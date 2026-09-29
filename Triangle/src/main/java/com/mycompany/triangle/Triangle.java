/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.triangle;

/**
 *
 * @author hooan
 */
public class Triangle {
    public static int getTriangleType(int a, int b, int c) {
    if (a + b <= c) {
        return -1; // Không phải tam giác
    } else if (a == b && b == c) {
        return 0; // Tam giác đều
    } else if ((c * c == a * a + b * b) && (a == b)) {
        return 2; // Tam giác vuông cân
    } else if (a == b) {
        return 3; // Tam giác cân
    } else if (c * c == a * a + b * b) {
        return 1; // Tam giác vuông
    } else {
        return 4; // Tam giác thường
    }
}
}
