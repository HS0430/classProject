<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Member Login Page</title>

    <link href="/css/assets/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap/signin.css" rel="stylesheet">

  </head>
  <body class="text-center">
    
<main class="form-signin w-100 m-auto">
  <form method="post">
    <h1 class="h3 mb-3 fw-normal">Member Login</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="userId" name="userId" placeholder="Id">
      <label for="userId">Member Id</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="userPwd" name="userPwd" placeholder="Password">
      <label for="userPwd">Member Password</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
  </form>
    <a class="btn btn-link" href="member/insert">회원가입</a>
</main>


    
  </body>
</html>
