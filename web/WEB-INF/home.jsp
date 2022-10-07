<%-- 
    Document   : home
    Created on : 29-Sep-2022, 10:24:09 PM
    Author     : SixtoDev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    </head>
    <body>
        <div class="mx-auto mt-3" style="width: 200px;">
            <h1>Hello ${username}</h1>
            <br>
            <a href="home?action=logout" class="badge-primary">Logout</a>
        </div>




    </body>
</html>
