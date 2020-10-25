package com.softeng306.validation;

import com.softeng306.Enum.Gender;
import com.softeng306.io.*;

public class GenderValidator {
    /**
     * Checks whether the inputted gender is valid.
     *
     * @param gender The inputted gender.
     * @return boolean indicates whether the inputted gender is valid.
     */
    public static boolean checkGenderValidation(String gender) {
        if (Gender.contains(gender)) {
            return true;
        }
        System.out.println("The gender is invalid. Please re-enter.");
        return false;
    }
}
