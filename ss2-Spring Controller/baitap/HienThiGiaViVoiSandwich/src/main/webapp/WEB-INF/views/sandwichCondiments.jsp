<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/5/2023
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
      rel="stylesheet"/>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
      rel="stylesheet"/>
<!-- MDB -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
      rel="stylesheet"/>
<style>


  option {
    text-align: center;
  }

  input {
    width: 300px;
  }

  .text_left {
    text-align: left;
  }

  label {
    left: 10%;
  }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div style="width: 500px; height: auto; margin: 50px auto; text-align: center ; border: 1px solid gray; border-radius: 5px">
  <h1 style="margin-top: 5%">Sandwich Condiments</h1>
  <form action="/" method="post" style="text-align: left; margin-top: 5%;">
    <div class="row">
      <div class="col-sm-6" style="margin-left: 5%; width: 42.3%">
        <ul class="list-group">
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="Lettuce" name="spice" aria-label="...">
            Lettuce
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="Tomato" name="spice" aria-label="...">
            Tomato
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="Mustard" name="spice" aria-label="...">
            Mustard
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="Sprouts" name="spice" aria-label="...">
            Sprouts
          </li>
        </ul>
      </div>
      <div class="col-sm-6" style="margin-left: 5%; width: 43%">
        <ul class="list-group">
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="Mayo" name="spice" aria-label="...">
            Mayo
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="Butter" name="spice" aria-label="...">
            Butter
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="Pesto" name="spice" aria-label="...">
            Pesto
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="Jam" name="spice" aria-label="...">
            Jam
          </li>
        </ul>
      </div>
    </div>
    <hr>
    <div style="text-align: center">
      <button type="submit" class="btn btn-secondary btn-block mb-4" style="width: 100px">SAVE</button>
    </div>
  </form>
  <h3>Your Sandwich Has: </h3>
  <c:forEach var="spice" items="${spice}">
    <h4>${spice}</h4>
  </c:forEach>
</div>
</body>
</html>
