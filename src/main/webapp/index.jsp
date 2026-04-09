<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC Request Flow - Input</title>
</head>
<body>

<h1>MVC Request Flow Demo</h1>

<form action="process" method="post">

    <p>
        Name:
        <input type="text" name="name" required>
    </p>

    <p>
        Favorite Food:
        <input type="text" name="favoriteFood" required>
    </p>

    <p>
        Age:
        <input type="number" name="age" required>
    </p>

    <button type="submit">Submit</button>

</form>

<p style="color:red;">${errorMessage}</p>

</body>
</html>