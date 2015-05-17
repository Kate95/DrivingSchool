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
                <form action="Controller" method="post">
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
                <c:if test="${not empty admin || not empty client}">
                    <p>У вас нет прав выполнять данное действие.</p>
                </c:if>
                <c:if test="${empty admin && empty client}">
                    <c:if test="${empty groupList}">
                        <p>Не удалось взять из базы данные об учебных группах или нужных данных нет в базе.</p>
                    </c:if>
                    <c:if test="${not empty groupList}">
                        <c:if test="${not empty comment}">
                            <c:out value="${comment}"/><br>
                        </c:if>
                        <form action="Controller" method="post">  
                            <input type="hidden" name="client" value="${client}"/>
                            <input type="hidden" name="admin" value="${admin}"/>
                            Выберите группу:<br>
                            <table cellpadding="5" >
                                <tr>         
                                    <td>Номер группы</td>
                                    <td>Форма обучения</td>                       
                                    <td>Начало обучения</td>
                                    <td>Окончание обучения</td>
                                    <td>Выбор группы</td>
                                </tr>
                                <c:forEach items="${groupList}" var="group" varStatus="status">
                                    <tr>                    
                                        <td>${group.groupNumber}</td>
                                        <td>${group.formOfStudy.formOfStudy}</td>                            
                                        <td><fmt:formatDate dateStyle="medium" type="date" value="${group.startDate}" /></td> 
                                        <td><fmt:formatDate dateStyle="medium" type="date" value="${group.endDate}" /></td>
                                        <td><c:if test="${status.index == 0}">
                                                <input type="radio" name="groupID" value="${group.groupID}" checked=""/>
                                            </c:if>
                                            <c:if test="${status.index != 0}">
                                                <input type="radio" name="groupID" value="${group.groupID}"/>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <c:if test="${not empty comment}">
                                ФИО:<br><input type="text" name="studentName" value="${student.studentName}" required="" pattern="^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?(( [А-ЯЁ][а-яё]+)|( [А-ЯЁ][.]))(( [А-ЯЁ][а-яё]+)|( [А-ЯЁ][.]))$"/><br>
                                Дата рождения(yyyy-MM-dd):<br><input type="text" name="dateOfBirth" value="${birthDate}" pattern="^(19)\d\d-((0[1-9]|1[012])-(0[1-9]|[12]\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)$"/><br>
                                Телефон((+xxxxx-)xxx-xx-xx):<br><input type="text" name="phoneNumber" value="${student.phoneNumber}" pattern="^[+]?([0-9]{5})?[-]?[0-9]{3}[-]?[0-9]{2}[-]?[0-9]{2}$"/><br>
                                Адрес:<br><input type="text" name="address" value="${student.address}" pattern=""/><br>
                            </c:if>
                            <c:if test="${empty comment}">
                                ФИО (или Фамилия И.О.):<br><input type="text" name="studentName" value="" required="" pattern="^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?(( [А-ЯЁ][а-яё]+)|( [А-ЯЁ][.]))(( [А-ЯЁ][а-яё]+)|( [А-ЯЁ][.]))$"/><br>
                                Дата рождения(yyyy-MM-dd):<br><input type="text" name="dateOfBirth" value="" pattern="^(19)\d\d-((0[1-9]|1[012])-(0[1-9]|[12]\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)$"/><br>
                                Телефон((+xxxxx-)xxx-xx-xx):<br><input type="text" name="phoneNumber" value="" pattern="^[+]?([0-9]{5})?[-]?[0-9]{3}[-]?[0-9]{2}[-]?[0-9]{2}$"/><br>
                                Адрес:<br><input type="text" name="address" value="" pattern="^[a-zA-Zа-яёА-яЁ0-9.,/]+$"/><br>
                            </c:if>                
                            Логин:<br><input type="text" name="login" value="" pattern="^[a-zA-Z][a-zA-Z0-9]{1,20}$" required=""/><br>
                            Пароль (не менее 4 символов):<br><input type="password" name="password" value="" pattern="^[a-zA-Z0-9]{4,45}$" required=""/><br>
                            <p><button type="submit" name="command" value="checkStudentData">Подтвердить</button></p>
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

