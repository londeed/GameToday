<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
    <jsp:param name="title" value="Login"/>
    <jsp:param name="style" value=""/>
    <jsp:param name="script" value="login"/>
</jsp:include>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
    body {
    font-family: "Lato", sans-serif;
    }





    .main-head{
    height: 150px;
    background: #FFF;

    }



    .sidenav {
    height: 100%;
    background-color: #000;
    overflow-x: hidden;
    padding-top: 20px;
    }




    .main {
    padding: 0px 10px;
    }



    @media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
    }



    @media screen and (max-width: 450px) {
    .login-form{
    margin-top: 10%;
    }



    .register-form{
    margin-top: 10%;
    }
    }



    @media screen and (min-width: 768px){
    .main{
    margin-left: 40%;
    }



    .sidenav{
    width: 40%;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    }



    .login-form{
    margin-top: 80%;
    }



    .register-form{
    margin-top: 20%;
    }
    }




    .login-main-text{
    margin-top: 20%;
    padding: 60px;
    color: #fff;
    }



    .login-main-text h2{
    font-weight: 300;
    }



    .btn-black{
    background-color: #000 !important;
    color: #fff;
    }
</style>
</head>
<body Style="background-color: #141414;color: white;" >
        <div class="sidenav" style="background-color: turquoise" >
            <div class="login-main-text">
                <h1 style="color: #141414">Pagina login</h1>
            </div>
        </div>
        <div class="main" id="sezioneLogin" Style="background-color: #141414;color: white;">
            <div class="col-md-6 col-sm-12">
                <div class="login-form">
                    <form action="${pageContext.request.contextPath}/UserServlet/login" onsubmit="event.preventDefault();validateForm(this)" method="post">
                        <div class="form-group">
                            <label>Email</label>
                            <input id="email" type="email" name="email" class="form-control" placeholder="nome@esempio.it">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input id="password" type="password" name="password" class="form-control" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-secondary">Login</button>
                    </form>
                    <br>
                    <form action="${pageContext.request.contextPath}/utenteProfile" method="get">
                        <button id="registrazione" name="gestioneUtente" value="registrazione" type="submit" class="btn btn-secondary">Registrazione</button>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>
