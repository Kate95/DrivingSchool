<%-- 
    Document   : add_exam_result
    Created on : 05.05.2015, 22:16:29
    Author     : Kate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    <input class="button" type="submit" name="command" value="addExamResult" /><br>                   
                </form>
            </div>	
            <div id="center"><br>
                <a href="login.jsp" >Авторизоваться</a><br><hr>
                <form action="Controller">
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
                            <td><input type="radio" name="studentID" value="${student.studentID}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    Выберите тип зачета:<br>
                    <c:forEach items="${examTypeList}" var="examType">
                        <input type="radio" name="examType" value="${examType}">${examType}<br>
                    </c:forEach>
                    <p>Номер зачета:<input type="text" name="examNumber" value=""/></p>
                    <p>Оценка (от 1 до 10):<input type="text" name="value" value=""/></p>
                    <p><input type="submit" name="command" value="checkExamData"/></p>
                </form>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>
