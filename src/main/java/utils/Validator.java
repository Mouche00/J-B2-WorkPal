package utils;

import utils.enums.InputType;

import java.util.List;
import java.util.Scanner;

public class Validator {



    public static boolean isEmpty(String str) {
        boolean isEmpty = str.isEmpty();
        if(isEmpty) System.out.println("\nERROR: Input string cannot be empty\n");
        return isEmpty;
    }

    public static boolean isInteger(String str) {
        boolean isInteger = str.matches("^[-+]?\\d+$");
        if(!isInteger) System.out.println("\nERROR: Input integer is not valid\n");
        return isInteger;
    }

    public static boolean isDouble(String str) {
        boolean isDouble = str.matches("^[+-]?([0-9]*[.])?[0-9]+$");
        if(!isDouble) System.out.println("\nERROR: Input double is not valid\n");
        return isDouble;
    }

    public static boolean isDate(String str) {
        boolean isDate = str.matches("^\\d{4}-\\d{2}-\\d{2}$");
        if(!isDate) System.out.println("\nERROR: Input date is not valid\n");
        return isDate;
    }

    public static boolean isValidEmail(String str) {
        boolean isValidEmail = str.matches("^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$");
        if(!isValidEmail) System.out.println("\nERROR: Input email is not valid\n");
        return isValidEmail;
    }

    public static boolean isValidPassword(String str) {
        boolean isValidPassword = str.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$");
        if(!isValidPassword) System.out.println("\nERROR: Input password is not valid (must include at least 8 characters, one uppercase letter, one lowercase letter, one digit and one special character)\n");
        return isValidPassword;
    }

    public static boolean isWhithinRange(String option, int min, int max) {
        if(max <= min) return false;

        boolean isWhithinRange = validateInteger(option) >= min && validateInteger(option) <= max;
        if(!isWhithinRange) System.out.println("\nERROR: Input option is not valid\n");
        return isWhithinRange;
    }

//    public static int ValidateOption(String str){
//        if(isInteger(str)) {
//            return Parser.parseInt(str);
//        }
//
//        return -1;
//    }


    public static int validateInteger(String str) {
        if(isInteger(str)) {
            return Parser.parseInt(str);
        }

        return -1;
    }

    public static boolean isValidInput(String input, InputType type, int... range) {
        boolean isValidInput = true;

        switch (type) {
            case InputType.DATE:
                isValidInput = isDate(input);
                break;
            case InputType.EMAIL:
                isValidInput = isValidEmail(input);
                break;
            case InputType.PASSWORD:
                isValidInput = isValidPassword(input);
                break;
            case InputType.INTEGER:
                isValidInput = isInteger(input);
                break;
            case InputType.DOUBLE:
                isValidInput = isDouble(input);
                break;
            case InputType.OPTION:
                isValidInput = isWhithinRange(input, range[0], range[1]) || !isInteger(input);
                break;
            default:
                isValidInput = !isEmpty(input);;
        }

        return isValidInput;
    }

    public static String validateInput(String prompt, InputType type, int... range){

        String input;
        do {
            System.out.print(prompt);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();

        } while(!isValidInput(input, type, range));

        return input;
    }

    public static boolean listIsEmpty(List<?> list) {
        if(list.isEmpty()){
            System.out.println("\nERROR: No data available!\n");
            return true;
        }

        return false;
    }
}
