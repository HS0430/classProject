<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member Register Page</title>
    <link href="/css/assets/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container">
        <div class="py-5 text-center">
            <h2>Register Form</h2>
        </div>

        <div class="row g-5">
            <div class="col-md-7 col-lg-12">
                <form method="post" action="/member/insert" class="needs-validation" novalidate>
                    <div class="row g-3">
                        <div class="col-sm-12">
                            <label for="userId" class="form-label">User Id</label>
                            <input type="text" class="form-control" id="userId" name="userId">
                        </div>
                        <div class="col-sm-12">
                            <label for="userPwd" class="form-label">User Password</label>
                            <input type="password" class="form-control" id="userPwd" name="userPwd">
                        </div>
                        <div class="col-sm-12">
                            <label for="userName" class="form-label">User Name</label>
                            <input type="text" class="form-control" id="userName" name="userName">
                        </div>
                        <div class="col-sm-12">
                            <label for="userPhone" class="form-label">User Phone</label>
                            <input type="text" class="form-control" id="userPhone" name="userPhone">
                        </div>
                        <div class="col-sm-12">
                            <label for="userAddress" class="form-label">User Address</label>
                            <input type="text" class="form-control" id="userAddress" name="userAddress">
                        </div>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Sign in</button>
                </form>
            </div>
        </div>
</div>

</body>
</html>
