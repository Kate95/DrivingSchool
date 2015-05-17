<%-- 
    Document   : index
    Created on : 03.05.2015, 14:07:04
    Author     : Kate
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <form action="Controller" method="post">                    
                    <c:if test="${empty client&&empty admin}">
                        <a href="login.jsp" >Авторизоваться</a><br><hr>
                    </c:if>
                    <c:if test="${not empty client}">                        
                        <c:out value="Здравствуйте, ${client.studentName}"/><br>
                        <%--<a href="Controller?command=logout" >Выйти</a><br><hr>--%>
                        <button class="a_button" type="submit" name="command" value="logout">Выйти</button><br><hr>
                    </c:if>
                    <c:if test="${not empty admin}">
                        <c:out value="Здравствуйте, ${admin}"/><br>
                        <button class="a_button" type="submit" name="command" value="logout">Выйти</button><br><hr>
                        <%--<a href="Controller?command=logout" >Выйти</a><br><hr>--%>
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
                <p>
                    Обучение в автошколе «ВиртуозАвто» - это не только основательная подготовка<br>
                    к сдаче теоретических и практических экзаменов в ГАИ с последующим получением<br>
                    водительских прав, но и приобретение чувства уверенности на любой дороге
                    в любых ситуациях.<br/>
                    Адрес: <br/>
                    Офис: г. Минск, ул.Стариновская,д. 31, подъезд 3, комн. № 11-H<br/>
                    Учебные классы:<br/>
                    ст.м "Уручье" (ул.Ложинская, 5)<br/>
                    ст.м"Я.Коласа" (пр.Независимости,49)<br/>
                    ст.м"Немига" (ул.Немига,3)<br/>
                    Контакты:<br/>
                    +375 44 5-524-524  (Velcom)<br/>
                    +375 29 709-97-90  (МТС)<br/>
                    E-mail: avtovirtuoz@mail.ru
                </p>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
        </body>
</html>
