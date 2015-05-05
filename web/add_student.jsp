<%-- 
    Document   : add_student
    Created on : 05.05.2015, 17:57:52
    Author     : Kate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>       
        <link rel="stylesheet" href="style/style.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="maket">
            <div id="header">
                <br>Вас приветствует система учета слушателей автошколы "Виртуоз"<br>
            </div>
            <div id="left">
                <form action="Controller">
                    <input class="button" type="button" value="Main" onclick="javascript:window.location='index.jsp'" /><br>
                    <input class="button" type="submit" name="command" value="viewAllStudyForms" /><br>
                    <input class="button" type="submit" name="command" value="viewStudyGroups" /><br>
                    <input class="button" type="submit" name="command" value="viewInstructors" /><br>
                    <input class="button" type="submit" name="command" value="viewCars" /><br>
                    <input class="button" type="submit" name="command" value="viewStudents" /><br>
                    <input class="button" type="submit" name="command" value="addStudent" />
                </form>
            </div>	
            <div id="center"><br>
                <a href="login.jsp" >Авторизоваться</a><br><hr>
                <form action="Controller">                    
                <p>Выберите группу:</p>
                <table cellpadding="5" >
                    <tr>         
                        <td>Номер группы</td>
                        <td>Форма обучения</td>                       
                        <td>Начало обучения</td>
                        <td>Окончание обучения</td>
                        <td>выбор группы</td>
                    </tr>
                    <c:forEach items="${groupList}" var="group" varStatus="status">
                        <tr>                    
                            <td>${group.groupNumber}</td>
                            <td>${group.formOfStudy.formOfStudy}</td>                            
                            <td><fmt:formatDate dateStyle="medium" type="date" value="${group.startDate}" /></td> 
                            <td><fmt:formatDate dateStyle="medium" type="date" value="${group.endDate}" /></td>
                            <td><input type="radio" name="groupID" value="${group.groupID}"/></td>
                        </tr>
                    </c:forEach>
                </table>
                <p>ФИО:<input type="text" name="studentName" value=""/></p>
                <p>Дата рождения(yyyy-MM-dd):<input type="text" name="dateOfBirth" value=""/></p>
                <p>Телефон:<input type="text" name="phoneNumber" value=""/></p>
                <p>Адрес:<input type="text" name="address" value=""/></p>
                <p>Логин:<input type="text" name="login" value=""/></p>
                <p>Пароль:<input type="password" name="password" value=""/></p>
                <p><input type="submit" name="command" value="checkStudentData"/></p>
                </form>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>

