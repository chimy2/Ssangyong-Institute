<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
    </head>
    <body>
        <h1>tblAddress</h1>

        <table>
            <tr>
                <th>번호</th>
                <th>이름</th>
                <th>나이</th>
                <th>주소</th>
                <th>성별</th>
            </tr>
            <c:forEach items="${list}" var="dto">
                <tr>
                    <td>${dto.seq}</td>
                    <td>${dto.name}</td>
                    <td>${dto.age}</td>
                    <td>${dto.address}</td>
                    <td>${dto.gender}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
