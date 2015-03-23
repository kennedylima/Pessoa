<%@page import="org.omg.CORBA.Request"%>
<%@page import="java.util.List"%>
<%@page import= "kennedy.Pessoa" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	List<Pessoa> Pessoas = (List<Pessoa>)request.getAttribute("pessoa");
	
for(Pessoa P : Pessoas){
	out.print(P.getNome());
	out.print ("<br>");
	out.print(P.getCpf());
	out.print ("<br>");
	out.print(P.getRg());
	out.print ("<br>");
	out.print(P.getEndereco());
	out.print ("<br>");
	out.print(P.getTelefone());
	
	out.print ("<br> __________________________ <br>");
}



%>

</body>
</html>