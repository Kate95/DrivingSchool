<%-- 
    Document   : study_forms_info
    Created on : 03.05.2015, 14:41:07
    Author     : Kate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>       
        <link rel="stylesheet" href="style/style.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Формы обучения</title>
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
                <c:if test="${empty formList}">
                    <p>В базе нет требуемых данных или не был отправлен запрос к базе.</p>
                </c:if>
                <c:if test="${not empty formList}">
                    <table cellpadding="5" >
                        <tr>                
                            <td>Форма обучения</td>
                            <td>Стоимость обучения</td>
                            <td>Часы по теории</td>
                            <td>Часы по вождению</td>                
                        </tr>
                        <c:forEach items="${formList}" var="form">
                            <tr>                    
                                <td>${form.formOfStudy}</td>
                                <td>${form.costOfEducation}</td>
                                <td>${form.hoursForTheory}</td>
                                <td>${form.hoursForDriving}</td>                    
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>
