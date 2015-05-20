<%-- 
    Document   : add_exam_result
    Created on : 05.05.2015, 22:16:29
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
        <title>Добавление зачета</title>
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
                    <c:if test="${empty studentList || empty examTypeList}">
                        <p>Не удалось взять из базы данные о слушателях или типах зачетов, или нужных данных нет в базе.</p>
                    </c:if>
                    <c:if test="${not empty studentList && not empty examTypeList}">
                        <form action="Controller" method="post">
                            <input type="hidden" name="client" value="${client}"/>
                            <input type="hidden" name="admin" value="${admin}"/>
                            Выберите слушателя:
                            <table cellpadding="5" >
                                <tr>                
                                    <td>ФИО</td>
                                    <td>Номер группы</td>
                                    <td>Дата рождения</td>
                                    <td>Телефон</td>    
                                    <td>Адрес</td>
                                    <td>Оплата обучения</td>  
                                    <td>Выбор</td>
                                </tr>
                                <c:forEach items="${studentList}" var="student" varStatus="status">
                                    <tr>                    
                                        <td>${student.studentName}</td>
                                        <td>${student.studyGroup.groupNumber}</td>
                                        <td><fmt:formatDate dateStyle="medium" type="date" value="${student.dateOfBirth}" /></td>
                                        <td>${student.phoneNumber}</td>                            
                                        <td>${student.address}</td> 
                                        <td>${paymentList[status.index]}</td>
                                        <td>
                                            <c:if test="${status.index == 0}">
                                                <input type="radio" name="studentID" value="${student.studentID}" checked=""/>
                                            </c:if>
                                            <c:if test="${status.index != 0}">
                                                <input type="radio" name="studentID" value="${student.studentID}"/>
                                            </c:if>                                
                                    </tr>
                                </c:forEach>
                            </table><br>
                            Выберите тип зачета:
                            <select name="examType">
                                <c:forEach items="${examTypeList}" var="examType" varStatus="status">
                                    <c:if test="${status.index == 0}">
                                        <option value="${examType.examType}" selected="">${examType.examType}</option>
                                    </c:if>
                                    <c:if test="${status.index != 0}">
                                        <option value="${examType.examType}">${examType.examType}</option>
                                    </c:if>
                                </c:forEach>
                            </select>                       
                            <p>Номер зачета (от 1 до 59):<input type="text" name="examNumber" value="" required="" pattern="[1-9]|([1-5][0-9])"/></p>
                            <p>Оценка (от 1 до 10):<input type="text" name="value" value="" required="" pattern="[1-9]|(10)"/></p>
                            <p><button class="action_button" type="submit" name="command" value="checkExamData">Подтвердить</button></p>
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
