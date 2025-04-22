//Creating a first servlet
//index.html
<!DOCTYPE html>
<html>
<body>
	<form action = "add">
		Enter 1st number: <input type="text" name="num1"><br>
		Enter 2nd number: <input type="text" name="num2"><br>
		<input type="submit">
	</form>
</body>
</html>

//addservlet.java
  package chandu.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addservlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i+j;
		PrintWriter out = res.getWriter();
		out.println("Result is: " +k);
	}
}

//web.xml (Deployment descriptor)
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <servlet>
  	<servlet-name>abc</servlet-name>
  	<servlet-class>chandu.first.addservlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>abc</servlet-name>
  	<url-pattern>/add</url-pattern>
  </servlet-mapping>
</web-app>
