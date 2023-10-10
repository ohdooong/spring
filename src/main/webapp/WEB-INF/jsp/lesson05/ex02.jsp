<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(2)</title>
</head>
<body>

	<h1>1. 조건문 (c:choose, c:when, c:otherwise)</h1>
	<c:set var="weight" value="80" />
	
	<c:choose>
		<c:when test="${weight < 60}">
			치킨 먹자
		</c:when>
		
		<c:when test="${weight < 70}">
			샐러드 먹자
		</c:when>
		
		<c:otherwise>
			굶자
		</c:otherwise>
	</c:choose>
	
	
	<h1>2. 반복문 (c:forEach)</h1>
	<c:forEach begin="0" end="5" step="1" var="i">
		맛있는 치킨 ${i}<br>
	</c:forEach>
	
	<%-- 16 ~ 20 : 5번 --%>
	<%-- count => 반복한 횟수 --%>
	<%-- index => 일반 for문에서는 begin부터 시작함. --%>
	<c:forEach begin="16" end="20" step="1" var="j" varStatus="status">
		var:${j} current:${status.current} 
		first:${status.first}
		last:${status.last} 
		count:${status.count}
		index:${status.index} 
		<br>
	</c:forEach>
	
	
	<%-- 서버에서 가져온 List<String> 출력 --%>
	<%-- Model에 담겨져 있는것 꺼내기 items이용 --%>
	<c:forEach items="${fruits}" var="fruit" varStatus="status">
		${fruit} ::::: 카운트 : ${status.count} ::::: 인덱스 : ${status.index}<br>	
	</c:forEach>
	
	
	<%-- 서버에서 가져온 List<Map<String,Object>>출력 --%>
	
	<%-- var와 items EL안의 이름 같지 않게 주의 --%>
	<c:forEach items="${users}" var="user" varStatus="status"> 
		<h3>${status.count}번째 사람 정보</h3>
		이름:${user.name}<br>
		나이:${user.age}<br>
		취미:${user.hobby}<br>
	</c:forEach>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>나이</td>
				<td>취미</td>
			</tr>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.hobby}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
	
	
</body>
</html>