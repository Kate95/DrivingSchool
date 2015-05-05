<%-- 
    Document   : exam_info
    Created on : 05.05.2015, 22:29:12
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
                    <p><c:out value="Тип зачета: ${exam.examType}"/></p>
                    <input type="hidden" name="examType" value="${exam.examType}"/>                    
                    <p><c:out value="Номер зачета: ${exam.examNumber}"/></p>
                    <input type="hidden" name="examNumber" value="${exam.examNumber}"/>
                    <p><c:out value="Оценка: ${exam.value}"/></p>
                    <input type="hidden" name="value" value="${exam.value}"/>
                    <input type="hidden" name="studentID" value="${exam.student.studentID}"/>
                    <p><input type="submit" name="command" value="addExamIntoDB"/></p>
                </form>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
    </body>
</html>
