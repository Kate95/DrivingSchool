<%-- 
    Document   : student_data
    Created on : 05.05.2015, 18:17:37
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
                <p>Группа:</p>
                <table cellpadding="5" >
                    <tr>         
                        <td>Номер группы</td>
                        <td>Форма обучения</td>                        
                        <td>Начало обучения</td>
                        <td>Окончание обучения</td>                        
                    </tr>                    
                        <tr>                    
                            <td>${student.studyGroup.groupNumber}</td>
                            <td>${student.studyGroup.formOfStudy.formOfStudy}</td>                            
                            <td><fmt:formatDate dateStyle="medium" type="date" value="${student.studyGroup.startDate}" /></td> 
                            <td><fmt:formatDate dateStyle="medium" type="date" value="${student.studyGroup.endDate}" /></td>                            
                        </tr>                  
                </table>
                <p><c:out value="ФИО: ${student.studentName}"/></p>
                <input type="hidden" name="studentName" value="${student.studentName}"/>              
                <p>Дата рождения: <fmt:formatDate dateStyle="medium" type="date" value="${student.dateOfBirth}" /></p>
                <input type="hidden" name="dateOfBirth" value="${student.dateOfBirth}"/>
                <p><c:out value="Телефон: ${student.phoneNumber}"/></p>
                <input type="hidden" name="phoneNumber" value="${student.phoneNumber}"/>
                <p><c:out value="Адрес: ${student.address}"/></p>
                <input type="hidden" name="address" value="${student.address}"/>
                <p><c:out value="Логин: ${student.login}"/></p>
                <input type="hidden" name="login" value="${student.address}"/>
                <p><c:out value="Пароль: ${student.password}"/></p>
                <input type="hidden" name="password" value="${student.password}"/>
                <input type="hidden" name="groupID" value="${student.studyGroup.groupID}"/>
                <p><input type="submit" name="command" value="addStudentIntoDB"/></p>
                </form>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>
