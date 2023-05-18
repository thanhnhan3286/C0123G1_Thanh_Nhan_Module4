<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/5/2023
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tu Dien</title>
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
<div style="width: 500px; height: 400px; margin: 50px auto; text-align: center ; border: 1px solid gray; border-radius: 5px">
    <h1 style="margin-top: 5%">Từ Điển Đơn Giản</h1>
    <form action="/" method="post" class="text_left" style="text-align: center; margin-top: 5%">
        <div class="form-outline mb-4">
            <label for="customerName">Nhập từ tếng Anh</label>
            <p>
                <input style="text-align: center; border: 1px solid black; border-radius: 3px" name="english"
                       id="customerName"
                       type="text" value="${english}"/>
            </p>
        </div>
        <button type="submit" class="btn btn-dark btn-block mb-4" style="width: 100px">Dịch</button>
    </form>
    <h3>Tiếng Việt: ${result}</h3>
</div>
</body>
</html>
