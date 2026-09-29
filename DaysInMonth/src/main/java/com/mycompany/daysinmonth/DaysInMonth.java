/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daysinmonth;

/**
 *
 * @author hooan
 */
public class DaysInMonth {
    public static int getDaysInMonth(int year, int month) {
    if (month == 1 || month == 3 || month == 5 || month == 7 || 
        month == 8 || month == 10 || month == 12) {
        return 31;
    } 
    else if (month == 4 || month == 6 || month == 9 || month == 11) {
        return 30;
    } 
    else if (month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
        return 29;
    } 
    else {
        return 28;
    }
}
}
