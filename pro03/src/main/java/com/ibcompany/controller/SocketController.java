package com.ibcompany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ServerEndpoint("/socket")
public class SocketController {
	
	private static final List<Session> sessionList = new ArrayList<>();
	private static final Logger log = LoggerFactory.getLogger(SocketController.class);
	
	public SocketController() {
		log.info("Create Socket");
	}
	
	@GetMapping
	public String viewPage() {
		return "socketTesting";
	}
	
	@GetMapping("/chat")
	public String chatStart(Model model) {
		return "socket/chatTest";
	}
	
	//@OnOpen : 연결 애노테이션
	//여기서 session은 웹소켓의 session이다.
	@OnOpen
	public void onOpen(Session session) {
		log.info("Open Session : " + session.getId());
		try {
			//메시지를 보낸 사람 측에 보여짐
			final Basic basic = session.getBasicRemote();
			basic.sendText("채팅 서버 연결 완료");
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		
		sessionList.add(session);
	}
	
	//@OnMessage : 메시지 전송 애노테이션 
	@OnMessage
	public void onMessage(String message, Session session) {
		try {
			//메시지를 보낸 사람 측에 보여짐
			final Basic basic = session.getBasicRemote();
			basic.sendText("변경되었습니다.");
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		sendAllSessionToMessage(session, message);
	}
	
	@OnError
	public void onError(Throwable t, Session session) {
		log.info(t.getMessage() + " by session : " + session.getId());
	}
	
	@OnClose
	public void onClose(Session session) {
		log.info("Session : " + session.getId() + " closed");
		sessionList.remove(session);
	}
	
	private void sendAllSessionToMessage(Session self, String msg) {
		try {
			for(Session s : sessionList) {
				//세션을 갖고 있다면 메세지를 보냄
				if(self.getId().equals(s.getId())) {
					s.getBasicRemote().sendText(msg);
				}
			}
		} catch(Exception e) {
			log.error(e.getMessage());
		}
	}
}


















