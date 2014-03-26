package com.bingosoft.bingo.utils;


import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;

import java.util.Date;
import java.util.Random;

/**
 * Created by jandresv on 26/03/14.
 */
public class StringUtils {

    public static String[] opcionesdeNombre(String nombre) {

        Random ran = new Random();

        String[] retornoArray = new String[] {
                nombre + DateTime.now().get(DateTimeFieldType.year()),
                nombre + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10),
                nombre + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10)
        };

        return retornoArray;
    }

}
