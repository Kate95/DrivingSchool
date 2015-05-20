<%-- 
    Document   : instructor_data
    Created on : 19.05.2015, 22:05:47
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
        <title>Потверждение данных</title>
    </head>
    <body>
        <div id="maket">
            <div id="header">
                <img src="style/virtuoz.jpg" class="head_img"/>
                <br>Вас приветствует система учета слушателей автошколы "Виртуоз"<br>
            </div>
            <div id="left">
                <form action="Controller" method="post">
                    <c:if test="${empty client&&empty admin}">
                        <a href="login.jsp" >Авторизоваться</a><br><hr>
                    </c:if>
                    <c:if test="${not empty client}">                        
                        <c:out value="Здравствуйте, ${client.studentName}"/><br>
                        <button class="a_button" type="submit" name="command" value="logout">Выйти</button><br><hr>
                    </c:if>
                    <c:if test="${not empty admin}">
                        <c:out value="Здравствуйте, ${admin}"/><br>
                        <button class="a_button" type="submit" name="command" value="logout">Выйти</button><br><hr>
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
                <c:if test="${empty admin}">
                    <p>Вы не имеете прав выполнять данное действие.</p>
                </c:if>
                <c:if test="${not empty admin}">
                    <c:if test="${empty instructor}">
                        <p>Вы зашли на страницу, не введя предварительно необходимые данные об инструкторе.</p>
                    </c:if>
                    <c:if test="${not empty instructor}">
                        <form action="Controller" method="post">
                            <input type="hidden" name="client" value="${client}"/>
                            <input type="hidden" name="admin" value="${admin}"/>
                            <input type="hidden" name="instructorID" value="${instructor.instructorID}"/>
                            <p><c:out value="ФИО: ${instructor.instructorName}"/></p>
                            <input type="hidden" name="instructorName" value="${instructor.instructorName}"/>              
                            <p>Дата рождения: <fmt:formatDate dateStyle="medium" type="date" value="${instructor.dateOfBirth}" /></p>
                            <input type="hidden" name="dateOfBirth" value="${instructor.dateOfBirth}"/>
                            <p><c:out value="Телефон: ${instructor.phoneNumber}"/></p>
                            <input type="hidden" name="phoneNumber" value="${instructor.phoneNumber}"/>
                            <c:if test="${not empty creation}">
                                <p><button class="action_button" type="submit" name="command" value="updateInstructorInDB">Добавить</button></p>
                            </c:if>
                            <c:if test="${empty creation}">
                                <p><button class="action_button" type="submit" name="command" value="updateInstructorInDB">Сохранить</button></p>
                            </c:if>
                        </form>
                    </c:if>
                </c:if>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>
