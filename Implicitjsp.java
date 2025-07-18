//request
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
    Enter name: <input type="text" name="username">
    <input type="submit">
	</form>
	<%
        String name = request.getParameter("username");
        if(name != null){
            out.println("Hello, " + name);
        }
    %>
</body>
</html>

          //response
          <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setContentType("text/html");
    out.println("<h2>Hello, this response is coming from JSP response object!</h2>");
    out.println("<p>Header 'Custom-Header' is set in the response.</p>");
	%>
</body>
</html>

    //session
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	session.setAttribute("username", "Chandana");
	String user = (String) session.getAttribute("username");
	 out.println("<h2>Welcome, " + user + "!</h2>");
	 out.println("<p>Your session ID: " + session.getId() + "</p>");
	 if (session.isNew()) {
	        out.println("<p>This is a new session.</p>");
	    } else {
	        out.println("<p>Session already exists.</p>");
	    }
	%>
</body>
</html>

    //application
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    // Set an attribute in application scope
    application.setAttribute("globalMessage", "Welcome to the JSP Application!");

    // Get the attribute from application scope
    String message = (String) application.getAttribute("globalMessage");

    // Display the message
    out.println("<h2>Application Message: " + message + "</h2>");

    // Get real path of a file/folder in the application
    String path = application.getRealPath("/");
    out.println("<p>Application Path: " + path + "</p>");

    // Log a message to server logs
    application.log("Accessed application object at: " + new java.util.Date());
%>
</body>
</html>

  //config
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String companyname = config.getInitParameter("company");
	%>
	<p>Company name: <b><%= companyname %></b></p>
	<p>Servlet Name: <b><%= config.getServletName() %></b></p>
</body>
</html>
  web.xml
  <?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="https://jakarta.ee/xml/ns/jakartaee" xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd" id="WebApp_ID" version="5.0">
  <servlet>
        <servlet-name>configDemo</servlet-name>
        <jsp-file>/NewFile.jsp</jsp-file>
        <init-param>
            <param-name>company</param-name>
            <param-value>OpenAI</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>configDemo</servlet-name>
        <url-pattern>/NewFile.jsp</url-pattern>
    </servlet-mapping>
</web-app>

  //pageContext
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	pageContext.setAttribute("course", "Java Full Stack");
	String courseName = (String) pageContext.getAttribute("course");
	String uri = ((HttpServletRequest)pageContext.getRequest()).getRequestURI();
	%>
	<p>Course: <b><%= courseName %></b></p>
    <p>Request URI: <b><%= uri %></b></p>
</body>
</html>
