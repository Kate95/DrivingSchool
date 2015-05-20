<%-- 
    Document   : exam_info
    Created on : 05.05.2015, 22:29:12
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
                    <p>У вас нет прав выполнять данное действие.</p>
                </c:if>
                <c:if test="${not empty admin}">
                    <c:if test="${not empty comment}">
                        <c:out value="${comment}"/>
                    </c:if>
                    <c:if test="${empty comment}">
                        <c:if test="${empty exam}">
                            <p>Вы зашли на страницу, не введя предварительно необходимые данные о зачете.</p>
                        </c:if>
                        <c:if test="${not empty exam}">
                            <form action="Controller" method="post">
                                <input type="hidden" name="client" value="${client}"/>
                                <input type="hidden" name="admin" value="${admin}"/>
                                Слушатель:
                                <table cellpadding="5" >
                                    <tr>                
                                        <td>ФИО</td>
                                        <td>Номер группы</td>
                                        <td>Дата рождения</td>
                                        <td>Телефон</td>    
                                        <td>Адрес</td>                                                         
                                    </tr>                        
                                    <tr>                    
                                        <td>${exam.student.studentName}</td>
                                        <td>${exam.student.studyGroup.groupNumber}</td>
                                        <td><fmt:formatDate dateStyle="medium" type="date" value="${exam.student.dateOfBirth}" /></td>
                                        <td>${exam.student.phoneNumber}</td>                            
                                        <td>${exam.student.address}</td>                                                   
                                    </tr>                       
                                </table>
                                <p><c:out value="Тип зачета: ${exam.examType.examType}"/></p>
                                <input type="hidden" name="examType" value="${exam.examType.examType}"/>                    
                                <p><c:out value="Номер зачета: ${exam.examNumber}"/></p>
                                <input type="hidden" name="examNumber" value="${exam.examNumber}"/>
                                <p><c:out value="Оценка: ${exam.value}"/></p>
                                <input type="hidden" name="value" value="${exam.value}"/>
                                <input type="hidden" name="studentID" value="${exam.student.studentID}"/>
                                <p><button class="action_button" type="submit" name="command" value="addExamIntoDB">Добавить</button></p>
                            </form>
                        </c:if>
                    </c:if>
                </c:if>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>
