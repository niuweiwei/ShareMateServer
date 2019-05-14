<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language=javascript> 
    setTimeout("document.form1.submit()",10) 
</script>
</head>
<body>
<form action="${ctx}/note/recommend/1?typeId=0" name="form1" method="post">
<input type="hidden" id="serverUrl" value="${pageContext.request.contextPath}"/>
</form>
</body>
</html>