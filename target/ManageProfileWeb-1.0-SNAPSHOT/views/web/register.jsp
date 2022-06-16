<%-- 
    Document   : register
    Created on : Jun 9, 2022, 11:29:16 AM
    Author     : phu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='views/css/register-css.css' />" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <title>Register</title>
    </head>
    <body>
        <form action="<c:url value='/register-page'/>" method="post">
            <div class="container">
                <h1>Register</h1>
                <p>Please fill in this form to create an account.</p>
                <hr>

                <div class="row">
                    <div class="col-md-6">
                        <label for="fullname"><b>Full Name</b></label>
                        <input type="text" placeholder="Enter Full name" name="fullname" id="fullname" required>
                    </div>
                    <div class="col-md-6">
                        <label for="phone"><b>Phone Number</b></label>
                        <input type="text" placeholder="Enter Phone number" name="phone" id="phone" required>
                    </div>
                </div>

                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="email" id="email" required>



                <div class="row">
                    <div class="col-md-6">
                        <label for="dob"><b>Date of birth</b></label>
                        <input type="date" name="dob" id="dob" required>
                    </div>
                    <div class="col-md-6">
                        <label><b>Gender</b></label>
                        <div class="d-flex">
                            <div class="form-check me-3">
                                <input class="form-check-input" type="radio" name="dob" id="dob" checked>
                                <label class="form-check-label" for="flexRadioDefault1">
                                    Male
                                </label>
                            </div>
                            <div class="form-check me-3">
                                <input class="form-check-input" type="radio" name="dob" id="dob">
                                <label class="form-check-label" for="flexRadioDefault2">
                                    Female
                                </label>
                            </div>
                            <div class="form-check me-3">
                                <input class="form-check-input" type="radio" name="dob" id="dob">
                                <label class="form-check-label" for="flexRadioDefault2">
                                    Other
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <label for="address"><b>Address</b></label>
                <input type="text" placeholder="Enter Address" name="address" id="address" required>

                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" id="username" required>
                <div class="row">
                    <div class="col-md-6">
                        <label for="psw"><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" name="pwd" id="pwd" onkeyup='check();' required>
                    </div>

                    <div class="col-md-6">
                        <label for="psw-repeat"><b>Repeat Password</b></label>
                        <input type="password" placeholder="Repeat Password" name="pwd-repeat" id="pwd-repeat" onkeyup='check();' required>
                        <span id='message'></span>
                    </div>
                </div>

                <hr>

                <button type="submit" class="registerbtn" id="submit">Register</button>
            </div>

            <div class="container signin">
                <p>Already have an account? <a href="login-page">Sign in</a>.</p>
            </div>
        </form>
        <script>
            var check = function () {
                if (document.getElementById('pwd').value ==
                        document.getElementById('pwd-repeat').value) {
                    document.getElementById('message').style.color = 'green';
                    document.getElementById('message').innerHTML = 'Matching';
                    document.getElementById('submit').disabled = false;
                } else {
                    document.getElementById('message').style.color = 'red';
                    document.getElementById('message').innerHTML = 'Not matching';
                    document.getElementById('submit').disabled = true;
                }
            }
        </script>
    </body>
</html>
