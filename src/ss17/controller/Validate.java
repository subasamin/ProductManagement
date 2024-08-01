package ss17.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String ID_REGEX = "^[0-9]{1,3}$";
    private static final String PRICE_REGEX = "^[0-9]{1,4}$";
    private static final String NAME_REGEX = "^[a-zA-Z0-9]+$";

    public static void ValidateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("Dia chi email hop le");
        } else {
            System.out.println("Dia chi email khong hop le");
        }
    }

    public static boolean ValidateID(String id) {
        Pattern pattern = Pattern.compile(ID_REGEX);
        Matcher matcher = pattern.matcher(String.valueOf(id));
        if (matcher.matches()) {
//            System.out.println("ID hop le");
            return true;
        } else {
//            System.out.println("ID khong hop le");
            return false;
        }
    }

    public static boolean ValidatePrice(String price) {
        Pattern pattern = Pattern.compile(PRICE_REGEX);
        Matcher matcher = pattern.matcher(String.valueOf(price));
        if (matcher.matches()) {
//            System.out.println("Price hop le");
            return true;
        } else {
//            System.out.println("Price khong hop le,");
            return false;
        }
    }
    public static boolean ValidateName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(String.valueOf(name));
        if (matcher.matches()) {
            return true;
        }
        else {
            return false;
        }
    }
}
