<%
	session.removeAttribute("uname");
	session.invalidate();
	response.sendRedirect("index.html");
%>