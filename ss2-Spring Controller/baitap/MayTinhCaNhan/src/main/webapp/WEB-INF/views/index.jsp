<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
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
<div>
    <div style="width: 550px; height: auto; margin: 50px auto; text-align: center ; border: 1px solid gray; border-radius: 5px">
        <h1 style="margin-top: 5%">Calculator</h1>
        <form action="/" method="post" style="text-align: left; margin-top: 5%;">
            <div class="row">
                <div class="col-sm-6" style="margin-left: 5%; width: 44%">
                    <input type="number" value="${num1}" name="num1" id="num1" placeholder="Number 1">
                </div>
                <div class="col-sm-6" style="margin-left: 5%; width: 44%">
                    <input type="number" value="${num2}" name="num2" id="num2" placeholder="Number 2">
                </div>
            </div>
            <hr>
            <div class="row" style="text-align: center">
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-secondary btn-block mb-4" name="math" value="add"
                            style="width: 100px">ADD(+)
                    </button>
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-secondary btn-block mb-4" name="math" value="sub"
                            style="width: 100px">SUB(-)
                    </button>
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-secondary btn-block mb-4" name="math" value="mul"
                            style="width: 100px">MUL(x)
                    </button>
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-secondary btn-block mb-4" name="math" value="div"
                            style="width: 100px">DIV(/)
                    </button>
                </div>
            </div>
        </form>
        <h3>RESULT: <c:if test="${result1 == 'Not exist!!!'}">

            ${result1}
        </c:if>
            <c:if test="${result1 == null}">
                ${result}
            </c:if></h3>

    </div>
</body>
</html>