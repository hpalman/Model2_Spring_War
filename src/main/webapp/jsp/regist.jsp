<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String strPath = request.getParameter("path");
	
%>
    
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> ■모델 2 Spring boot - <%=strPath %> </h1>

 <a href="/index.html">● Home </a>
 <p>
  
 <form name="regist" action="/<%=strPath %>/PeopleCreate" method="post"> 
	<table style="width: 200px;">
		<tr>
			<td> 구분 </td> <td align="center">입력</td> 
		</tr>
		<tr>	
			<td> ID </td>   <td><input type="text" name="id" value="" />   </td> 
		</tr>
		<tr>
			<td> Name </td> <td><input type="text" name="name" value="" /></td> 
		</tr>
		<tr>	
			<td> Age </td>  <td><input type="text" name="age" value="" />  </td> 
		</tr> 
	</table>
	<p>
	<input type="submit"  value="전송" style="width:200px;"> 

 </form>
</body>
</html>