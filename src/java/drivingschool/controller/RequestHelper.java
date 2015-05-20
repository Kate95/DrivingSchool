/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.controller;

import drivingschool.controller.commands.AddExamIntoDBCommand;
import drivingschool.controller.commands.AddExamResultCommand;
import drivingschool.controller.commands.AddInstructorCommand;
import drivingschool.controller.commands.AddPaymentCommand;
import drivingschool.controller.commands.AddPaymentIntoDBCommand;
import drivingschool.controller.commands.AddStudentCommand;
import drivingschool.controller.commands.AddStudentIntoDBCommand;
import drivingschool.controller.commands.CheckExamDataCommand;
import drivingschool.controller.commands.CheckInstructorDataCommand;
import drivingschool.controller.commands.CheckPaymentDataCommand;
import drivingschool.controller.commands.CheckStudentDataCommand;
import drivingschool.controller.commands.Command;
import drivingschool.controller.commands.DeleteInstructorCommand;
import drivingschool.controller.commands.DeleteInstructorFromDBCommand;
import drivingschool.controller.commands.EditInstructorCommand;
import drivingschool.controller.commands.LoginCommand;
import drivingschool.controller.commands.LogoutCommand;
import drivingschool.controller.commands.NoCommand;
import drivingschool.controller.commands.UpdateInstructorInDBCommand;
import drivingschool.controller.commands.ViewAllStudyFormsCommand;
import drivingschool.controller.commands.ViewCarsCommand;
import drivingschool.controller.commands.ViewExamsCommand;
import drivingschool.controller.commands.ViewInstructorsCommand;
import drivingschool.controller.commands.ViewStudentsCommand;
import drivingschool.controller.commands.ViewStudyGroupsCommand;
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
        commands.put("editInstructor", new EditInstructorCommand());
        commands.put("addInstructor", new AddInstructorCommand());
        commands.put("checkInstructorData", new CheckInstructorDataCommand());
        commands.put("updateInstructorInDB", new UpdateInstructorInDBCommand());
        commands.put("deleteInstructor", new DeleteInstructorCommand());
        commands.put("deleteInstructorFromDB", new DeleteInstructorFromDBCommand());
        commands.put("noCommand", new NoCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        if (action == null) {
            action = "noCommand";
        }
        Command command = commands.get(action);
        if(command == null){
            command = commands.get("noCommand");
        }
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }
}
