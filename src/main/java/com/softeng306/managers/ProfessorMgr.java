package com.softeng306.managers;

import com.softeng306.domain.professor.Professor;
import com.softeng306.io.HelpInfoMgr;
import com.softeng306.validation.ValidationMgr;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages all the professor related operations
 */
public class ProfessorMgr {
    private Scanner scanner = new Scanner(System.in);
    /**
     * An array list of all the professors in this school.
     */
    public static ArrayList<Professor> professors = new ArrayList<Professor>(0);

    /**
     * Adds a professor.
     *
     * @return a newly added professor
     */
    public Professor addProfessor() {
        String department, profID;
        while (true) {
            System.out.println("Give this professor an ID: ");
            profID = scanner.nextLine();
            if (ValidationMgr.checkValidProfIDInput(profID)) {
                if (ValidationMgr.checkProfExists(profID) == null) {
                    break;
                }
            }
        }

        String profName;
        while (true) {
            System.out.println("Enter the professor's name: ");
            profName = scanner.nextLine();
            if (ValidationMgr.checkValidPersonNameInput(profName)) {
                break;
            }
        }

        Professor professor = new Professor(profID, profName);
        while (true) {
            System.out.println("Enter professor's Department: ");
            System.out.println("Enter -h to print all the departments.");
            department = scanner.nextLine();
            while (department.equals("-h")) {
                HelpInfoMgr.getAllDepartment();
                department = scanner.nextLine();
            }

            if (ValidationMgr.checkDepartmentValidation(department)) {
                professor.setProfDepartment(department);
                break;
            }
        }


        return professor;
    }

}
