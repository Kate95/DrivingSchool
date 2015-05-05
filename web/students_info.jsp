<%-- 
    Document   : students_info
    Created on : 04.05.2015, 22:18:26
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
                <table cellpadding="5" >
                    <tr>                
                        <td>ФИО</td>
                        <td>Номер группы</td>
                        <td>Дата рождения</td>
                        <td>Телефон</td>    
                        <td>Адрес</td>
                        <td>Оплата обучения</td>  
                    </tr>
                    <c:forEach items="${studentList}" var="student" varStatus="status">
                        <tr>                    
                            <td>${student.studentName}</td>
                            <td>${student.studyGroup.groupNumber}</td>
                            <td><fmt:formatDate dateStyle="medium" type="date" value="${student.dateOfBirth}" /></td>
                            <td>${student.phoneNumber}</td>                            
                            <td>${student.address}</td> 
                            <td>${paymentList[status.index]}</td>                             
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>
