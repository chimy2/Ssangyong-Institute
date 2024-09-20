<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String txt = request.getParameter("txt");
	String bgcolor = request.getParameter("bgcolor");
	String fontcolor = request.getParameter("fontcolor");
	String fontsize = request.getParameter("fontsize");
	int btncount = Integer.parseInt(request.getParameter("btncount"));
	String horizontalspacing = request.getParameter("horizontalspacing");
	String verticalspacing = request.getParameter("verticalspacing");
	String icon = request.getParameter("icon");
	String border = request.getParameter("border");
	String bordersize = request.getParameter("bordersize");
	String borderstyle = request.getParameter("borderstyle");
	String borderradius = request.getParameter("borderradius");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		
	</style>
</head>
<body>
	<!-- ex11_ok.jsp -->
	<h1>결과</h1>
	
	<table>
		<tr>
			<th>버튼</th>
		</tr>
		<tr>
			<td>
				<%
					for (int i=0; i<btncount; i++){
				
				%>
				
				
				<%
					}
				%>
			</td>
		</tr>
	</table>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>	
</body>
</html>