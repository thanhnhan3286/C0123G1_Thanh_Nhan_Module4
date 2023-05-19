<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/5/2023
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChuyenDoiTienTe</title>
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
    <h1 style="margin-top: 5%">Chuyen Doi Tien Te</h1>
    <form action="" method="" class="text_left" style="text-align: center">
        <div class="form-outline mb-4">
            <label for="customerName">Nhap So Tien</label>
            <p>
                <input style="text-align: center; border: 1px solid black; border-radius: 3px" name="usd"
                       id="customerName"
                       type="number" value="${usd}"/>
            </p>
        </div>
        <div class="form-outline mb-4" style="text-align: center">
            <label for="form6Example0">Tỷ Giá</label>
            <p style="width: 300px; margin: 0 auto">
                <select name="vnd" id="form6Example0" class="form-select" aria-label="Default select example"
                        required style="border: 1px solid rgba(34,34,34,0.85)">
                    <option value="23240">USD (US DOLLAR = 23.240 VND)</option>
                    <option value="24700">EUR (EURO = 24.700 VND)</option>
                    <option value="16970">CAD (CANADIAN DOLLAR = 16.970 VND)</option>
                    <option value="17029">SGD (SINGAPORE DOLLAR = 17.029 VND)</option>
                </select>
            </p>
        </div>
        <%--        <div class="form-outline mb-4">--%>
        <%--            <label for="quantity">Quantity</label>--%>
        <%--            <input style="text-align: center; border: 1px solid rgba(34,34,34,0.85)" name="quantity" type="number"--%>
        <%--                   min="1" max="100" id="quantity"--%>
        <%--                   class="form-control" required/>--%>
        <%--        </div>--%>
        <button type="submit" class="btn btn-dark btn-block mb-4" style="width: 100px">Result</button>
    </form>
    <h2>${result} VND</h2>
</div>

</body>
</html>
