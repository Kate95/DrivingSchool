<%-- 
    Document   : index
    Created on : 03.05.2015, 14:07:04
    Author     : Kate
--%>

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
                
                <form action="Controller">
                    <input class="button" type="button" value="Main" onclick="javascript:window.location='index.jsp'" /><br>
                    <input class="button" type="submit" name="command" value="viewAllStudyForms" /><br>
                    <input class="button" type="submit" name="command" value="viewStudyGroups" /><br>
                    <input class="button" type="submit" name="command" value="viewInstructors" /><br>
                    <input class="button" type="submit" name="command" value="viewCars" /><br>
                    <input class="button" type="submit" name="command" value="viewStudents" /><br>
                    <input class="button" type="submit" name="command" value="addStudent" />
                </form>
            </div>	
            <div id="center"><br>
                <a href="login.jsp" >Авторизоваться</a><br><hr>
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
                    +375 44 5-524-524  (Velcom<br/>
                    +375 29 709-97-90  (МТС<br/>
                    E-mail: avtovirtuoz@mail.ru
                </p>
            </div>
            <div id="footer"><br>
                Автошкола "Виртуоз" E-mail:avtovirtuoz@mail.ru
            </div>
        </div>       
        </body>
</html>
