<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="hpath" value="<%=request.getContextPath()%>" />
<header id="hd" class="clr-fix">
	<nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="#">
      <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
    </a>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item" href="#">
        Home
      </a>

      <a class="navbar-item" href="#">
        Documentation
      </a>

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link" href="#">
          More
        </a>

        <div class="navbar-dropdown">
          <a class="navbar-item" href="#">
            About
          </a>
          <a class="navbar-item" href="#">
            Jobs
          </a>
          <a class="navbar-item" href="#">
            Contact
          </a>
          <hr class="navbar-divider">
          <a class="navbar-item" href="#">
            Report an issue
          </a>
        </div>
      </div>
    </div>

    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a class="button is-primary" href="#">
            <strong>Sign up</strong>
          </a>
          <a class="button is-light" href="#">
            Log in
          </a>
        </div>
      </div>
    </div>
  </div>
</nav>
</header>