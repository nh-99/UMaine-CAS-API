<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>UMaine Central Auth Service RESTful API</title>
  </head>
  <body>
      <p>Welcome to the UMaine CAS API! To begin, try sending a GET request to the /auth endpoint with a username and password</p>
      <form action="auth" method="get">
        Username:<br>
        <input type="text" name="username"><br>
        Password:<br>
        <input type="password" name="password">
        <input type="submit" value="Submit">
      </form>
  </body>
</html>