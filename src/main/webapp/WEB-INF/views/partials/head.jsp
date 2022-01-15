<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,viewport-fit=cover">
<title>${param.title}</title>
<meta name="description" content="Sito di recensioni videoludiche">
<link rel="Images" type="image/jpg" href="Images/LOGO.jpg">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone-no">
<meta name="apple-mobile-web-app-title" content="GameToday">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<link rel="apple-touch-icon" href="Images/LOGO.jpg">
<link rel="apple-touch-startup-image" href="Images/LOGO.jpg">
<meta name="theme-color" content="#808080">
<!--<link href="${context}/css/reset.css" rel="stylesheet">-->
<link href="${context}/css/bodyStyle.css" rel="stylesheet">
<link href="${context}/css/crm.css" rel="stylesheet">
<link href="${context}/css/dashboard.css" rel="stylesheet">
<link href="${context}/css/libraryCustomer.css" rel="stylesheet">
<c:if test="${not empty param.style}">
    <c:forTokens items="${param.styles}" delims="," var="style">
        <link rel="stylesheet" href="${context}/css/${style}.css">
    </c:forTokens>
</c:if>

<script src="${context}/javascript/library.js" defer></script>

<c:if test="${not empty param.script}">
    <c:forTokens items="${param.script}" delims="," var="script">
        <script src="${context}/javascript/${script}.js" defer></script>
    </c:forTokens>
</c:if>
