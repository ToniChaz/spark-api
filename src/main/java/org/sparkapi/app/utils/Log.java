package org.sparkapi.app.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The Log class is an util to print System.out.print
 * The future implementation is the LOG4J
 *
 * @author Toni Chaz
 * @version 1.0
 * @since 2018-12-22
 */
public class Log {

    /**
     * Simply displays an a string to the standard output.
     *
     * @param msg [String] The message to print
     * @throws IllegalArgumentException If the message is null or contains only empty spaces
     */
    public static void sout(String msg) throws IllegalArgumentException {
        if (msg == null || msg.isEmpty()) {
            throw new IllegalArgumentException("The msg can´t be null or empty!");
        }
        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (day/month/year)
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        // Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();
        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        String reportDate = df.format(today);

        // Print the standard output with the current date!
        System.out.print("[" + reportDate + "]: " + msg + "\n");

    }
}
