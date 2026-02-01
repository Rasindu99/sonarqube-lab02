package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    // FIXED: Standard logger for java:S106 compliance
    private static final Logger LOGGER =
            Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        try {
            Calculator calc = new Calculator();

            // Log the result instead of using System.out
            int result = calc.calculate(10, 5, "add-again");
            LOGGER.log(Level.INFO, "Calculation Result: {0}", result);

            UserService service = new UserService();
            service.findUser("admin");
            service.deleteUser("admin");

        } catch (Exception e) {
            // Good practice: catch the exception thrown by UserService
            LOGGER.log(Level.SEVERE, "An error occurred in the application", e);
        }
    }
}
