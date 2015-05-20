<%-- 
    Document   : edit_instructor
    Created on : 19.05.2015, 21:43:59
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
        <title>Инструктор</title>
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
                    <p>Вы не имеете права выполнять данное действие.</p>
                </c:if>
                <c:if test="${not empty admin}">
                    <c:if test="${empty instructor}">
                        <p>Вы не выбрали предварительно инструктора, информацию о котором необходимо изменить.</p>
                    </c:if>
                    <c:if test="${not empty instructor}">
                        <form action="Controller" method="post">  
                            <input type="hidden" name="client" value="${client}"/>
                            <input type="hidden" name="admin" value="${admin}"/>
                            <input type="hidden" name="instructorID" value="${instructor.instructorID}"/>
                            ФИО (или Фамилия И.О.)::<br><input type="text" name="instructorName" value="${instructor.instructorName}" required="" pattern="^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?(( [А-ЯЁ][а-яё]+)|( [А-ЯЁ][.]))(( [А-ЯЁ][а-яё]+)|([\s]?[А-ЯЁ][.]))$"/><br>
                            Дата рождения(yyyy-MM-dd):<br><input type="text" name="dateOfBirth" value="${birthDate}" pattern="^(19)\d\d-((0[1-9]|1[012])-(0[1-9]|[12]\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)$"/><br>
                            Телефон((+xxxxx-)xxx-xx-xx):<br><input type="text" name="phoneNumber" value="${instructor.phoneNumber}" pattern="^[+]?([0-9]{5})?[-]?[0-9]{3}[-]?[0-9]{2}[-]?[0-9]{2}$"/><br>                            
                            <p>
                                <button class="action_button" type="submit" name="command" value="checkInstructorData">Подтвердить</button>
                                <br><br><a class="a_button" href="instructors_info.jsp">Вернуться назад</a><br>
                            </p>
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
