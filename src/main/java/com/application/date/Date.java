package com.application.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {

    /**
     * Метод создает оъект класса Date из строки даты
     *
     * @param textDate - строка даты
     * @return объект класса Date
     */

    public static java.util.Date createObjectDate(String textDate) {
        String[] arrDateNumbers = textDate.split("-");

        Calendar calendar = new GregorianCalendar(Integer.parseInt(arrDateNumbers[0]), Integer.parseInt(arrDateNumbers[1]), Integer.parseInt(arrDateNumbers[2]));

        java.util.Date newDate = new java.util.Date();
        newDate.setTime(calendar.getTimeInMillis());

        return newDate;
    }
}
