package com.coursework.csa_cw.utils;

import java.util.Random;

public class ISBNGenerator {

    public static String generateISBN(){
        String firstSegment = Integer.toString((int)(Math.random() * 1000));
        String secondSegment = Integer.toString((int)(Math.random() * 10));
        String thirdSegment = Integer.toString((int)(Math.random() * 1000));
        String fourthSegment = Integer.toString((int)(Math.random() * 100000));
        String lastSegment = Integer.toString((int)(Math.random() * 10));

        String isbn = firstSegment.concat("-" + secondSegment + "-" + thirdSegment + "-" + fourthSegment + "-" + lastSegment);
        return isbn;
    }

    public static void main(String[] args) {
        System.out.println(generateISBN());
    }
}
