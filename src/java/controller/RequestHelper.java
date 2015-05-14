/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.commands.AddExamIntoDBCommand;
import controller.commands.AddExamResultCommand;
import controller.commands.AddPaymentCommand;
import controller.commands.AddPaymentIntoDBCommand;
import controller.commands.AddStudentCommand;
import controller.commands.AddStudentIntoDBCommand;
import controller.commands.CheckExamDataCommand;
import controller.commands.CheckPaymentDataCommand;
import controller.commands.CheckStudentDataCommand;
import controller.commands.Command;
import controller.commands.LoginCommand;
import controller.commands.LogoutCommand;
import controller.commands.NoCommand;
import controller.commands.ViewAllStudyFormsCommand;
import controller.commands.ViewCarsCommand;
import controller.commands.ViewExamsCommand;
import controller.commands.ViewInstructorsCommand;
import controller.commands.ViewStudentsCommand;
import controller.commands.ViewStudyGroupsCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kate
 */
public class RequestHelper {

    private static RequestHelper instance = null;

    HashMap<String, Command> commands = new HashMap();

    private RequestHelper() {
        commands.put("viewAllStudyForms", new ViewAllStudyFormsCommand());
        commands.put("viewInstructors", new ViewInstructorsCommand());
        commands.put("viewStudyGroups", new ViewStudyGroupsCommand());
        commands.put("viewStudents", new ViewStudentsCommand());
        commands.put("viewCars", new ViewCarsCommand());
        commands.put("viewExams", new ViewExamsCommand());
        commands.put("addStudent", new AddStudentCommand());
        commands.put("checkStudentData", new CheckStudentDataCommand());
        commands.put("addStudentIntoDB", new AddStudentIntoDBCommand());
        commands.put("addExamResult", new AddExamResultCommand());
        commands.put("checkExamData", new CheckExamDataCommand());
        commands.put("addExamIntoDB", new AddExamIntoDBCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("addPayment", new AddPaymentCommand());
        commands.put("checkPaymentData", new CheckPaymentDataCommand());
        commands.put("addPaymentIntoDB", new AddPaymentIntoDBCommand());
        commands.put("noCommand", new NoCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        if (action == null) {
            action = "noCommand";
        }
        Command command = commands.get(action);
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }
}
