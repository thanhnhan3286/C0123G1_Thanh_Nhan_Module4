<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/5/2023
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>E-Mail</title>
    <style>
        tr {
            margin: 10px 20px;
        }

        button {
            border-radius: 10px;
            background-color: dodgerblue;
            margin: 10%;
        }
    </style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>

<%--<form:form action="/" method="get" modelAttribute=""--%>
<div style="margin: 30px auto; border-radius: 5px; border: 1px solid gray; width: 450px; height: auto">
    <div style="text-align: center">
        <h1 style="margin: 20px auto">Settings
        </h1>
    </div>
    <div style="margin-left: 10%; margin-bottom: 10%">
        <form:form action="update" method="post" modelAttribute="emailSettings">
            <table>
                <tr>
                    <th>Languages</th>
                    <td><form:select path="language" items="${languages}"/>
                        <select name="language" id="language">
                            <option value="English">English</option>
                            <option value="Vietnamese">Vietnamese</option>
                            <option value="Japanese">Japanese</option>
                            <option value="Chinese">Chinese</option>
                        </select>
                    </td>
                </tr>
                <tr></tr>
                <tr>
                    <th>
                        Page Size:
                    </th>
                    <td>
                        <span>Show</span>
                        <span>
    <select>
    <option value="5">5</option>
    <option value="5">10</option>
    <option value="5">15</option>
    <option value="5">20</option>
    </select>
    </span>
                        <span>
    email per page
    </span>
                    </td>
                </tr>
                <tr>
                    <td hidden>
                        <input class="form-check-input me-1" type="checkbox" value="" aria-label="...">
                        Enable spams filter
                    </td>
                </tr>
                <tr>
                    <th>Spams filter:</th>
                    <td>
                        <form:checkbox path="spamsFilter"/>
                        Enable spams filter
                    </td>
                </tr>
                <tr>

                </tr>
                <tr>
                    <th>Signature:</th>
                    <td>
                        <form:textarea path="signature" cols="30" rows="4"/>
                    </td>
                </tr>
                <tr>

                </tr>
                <tr>
                    <th>

                    </th>
                    <td>
                        <div style="display: flex">
                            <div>
                                <button>Update</button>
                            </div>
                            <div style="margin-left: 20%">
                                <button>Cancel</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
<%--    <div style="display: inline-block">--%>
<%--    <fieldset>--%>
<%--&lt;%&ndash;    <form:form action="update" method="post" modelAttribute="emailSettings">&ndash;%&gt;--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td><b>Languages</b></td>--%>
<%--                <td>--%>
<%--&lt;%&ndash;                    <form:select path="language" items="${languages}"/>&ndash;%&gt;--%>

<%--                </td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>--%>
<%--                    <b>Page size:</b>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    Show--%>
<%--                    <form:select path="pageSize" items="${pageSize}"/>--%>
<%--                    emails per page--%>
<%--                </td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>--%>
<%--                    <b>Spams filter:</b>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--&lt;%&ndash;                    <form:checkbox path="spamsFilter"/> Enable spam filter&ndash;%&gt;--%>
<%--                </td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td><b>Signature</b></td>--%>
<%--                <td>--%>
<%--&lt;%&ndash;                    <form:textarea path="signature"/>&ndash;%&gt;--%>
<%--                </td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td></td>--%>
<%--                <td>--%>
<%--                    <button type="submit">Update</button>--%>
<%--                    <button type="reset">Cancel</button>--%>
<%--                </td>--%>
<%--            </tr>--%>


<%--        </table>--%>


<%--&lt;%&ndash;    </form:form>&ndash;%&gt;--%>

<%--    </fieldset>--%>


<%--    </div>--%>
</body>
</html>
