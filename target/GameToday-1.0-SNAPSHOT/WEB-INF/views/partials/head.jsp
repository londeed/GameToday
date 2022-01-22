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
<link href="${context}/css_bootstrap/bootstrap-5.1.3-dist/css/bootstrap.css" rel="stylesheet">
<!--<link href="/css/crm.css" rel="stylesheet">
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/libraryCustomer.css" rel="stylesheet">-->
<c:if test="${not empty param.style}">
    <c:forTokens items="${param.styles}" delims="," var="style">
        <link rel="stylesheet" href="${context}/css_bootstrap/bootstrap-5.1.3-dist/css/${style}.css">
    </c:forTokens>
</c:if>

<script src="${context}/javascript/aggiungiCommento.js" defer></script>

<c:if test="${not empty param.script}">
    <c:forTokens items="${param.script}" delims="," var="script">
        <script src="${context}/javascript/${script}.js" defer></script>
    </c:forTokens>
</c:if>
<script src="https://kit.fontawesome.com/62da24ef45.js" crossorigin="anonymous"></script>