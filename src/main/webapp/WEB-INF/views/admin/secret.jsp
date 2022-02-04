<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="AdminPage"/>
        <jsp:param name="style" value="bootstrap"/>
        <jsp:param name="script" value="loginValidator"/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">
<br>
<!--
<form class="d-flex" action="${pageContext.request.contextPath}/admin/login" method="post" onsubmit="event.preventDefault(); validateForm(this)">
    <fieldset>
        <h2>Login Admin</h2>
        <span>Email</span>
        <label for="email">
            <input type="email" name="email" id="email" placeholder="Email">
        </label>
        <span>Password</span>
        <label for="password">
            <input type="password" name="password" id="password" placeholder="Password">
        </label>
        <button class="btn" style="background-color: turquoise" type="submit">Accedi</button>
    </fieldset>
</form>-->

<div class="container mt-3">
    <br>
    <h2>Inserisci le tue credenziali</h2>
    <br>
    <form action="${pageContext.request.contextPath}/admin/login" method="post">
        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="email" name="email" placeholder="Email">
            <label for="email">Email</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="password" name="password" placeholder="Password">
            <label for="password">Password</label>
        </div>

        <button class="btn" style="background-color: turquoise">Accedi</button>
    </form>
</div>


</body>
</html>

