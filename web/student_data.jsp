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
                    <c:if test="${empty client&&empty admin}">
                        <a href="login.jsp" >Авторизоваться</a><br><hr>
                    </c:if>
                    <c:if test="${not empty client}">                        
                        <c:out value="Здравствуйте, ${client.studentName}"/><br>
                        <a href="Controller?command=logout" >Выйти</a><br><hr>
                    </c:if>
                    <c:if test="${not empty admin}">
                        <c:out value="Здравствуйте, ${admin}"/><br>
                        <a href="Controller?command=logout" >Выйти</a><br><hr>
                    </c:if>
                    <input type="hidden" name="client" value="${client}"/>
                    <input type="hidden" name="admin" value="${admin}"/>
                    <button class="button" type="button" value="Main" onclick="javascript:window.location='index.jsp'">Главная</button><br>
                    <button class="button" type="submit" name="command" value="viewAllStudyForms">Формы обучения</button><br>
                    <button class="button" type="submit" name="command" value="viewStudyGroups">Учебные группы</button><br>
                    <button class="button" type="submit" name="command" value="viewInstructors">Инструкторы</button><br>
                    <button class="button" type="submit" name="command" value="viewCars">Автомобили</button><br>
                    <button class="button" type="submit" name="command" value="viewStudents">Слушатели</button><br>
                    <c:if test="${empty client&&empty admin}">
                    <button class="button" type="submit" name="command" value="addStudent">Записаться в слушатели</button>
                    </c:if>
                    <c:if test="${not empty client}">
                        <button class="button" type="submit" name="command" value="viewExams">Информация о зачетах</button><br>
                        <button class="button" type="submit" name="command" value="addPayment">Оплатить обучение</button>
                    </c:if>
                    <c:if test="${not empty admin}">                        
                        <button class="button" type="submit" name="command" value="addExamResult">Добавить результаты зачета</button>
                    </c:if>
                </form>
            </div>	
            <div id="center"><br>                
                <form action="Controller">
                    <input type="hidden" name="client" value="${client}"/>
                    <input type="hidden" name="admin" value="${admin}"/>
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
                <p><button type="submit" name="command" value="addStudentIntoDB">Записаться</button></p>
                </form>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>
