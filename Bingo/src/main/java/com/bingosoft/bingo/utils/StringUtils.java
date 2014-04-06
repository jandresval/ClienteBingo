package com.bingosoft.bingo.utils;


import com.bingosoft.bingo.R;

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

    public static int balotas(String balota) {
        int balotaNumero = Integer.parseInt(balota);
        int resourceId = 0;
        switch (balotaNumero) {
            case 1:
                resourceId = R.drawable.uno;
                break;
            case 2:
                resourceId = R.drawable.dos;
                break;
            case 3:
                resourceId = R.drawable.tres;
                break;
            case 4:
                resourceId = R.drawable.cuatro;
                break;
            case 5:
                resourceId = R.drawable.cinco;
                break;
            case 6:
                resourceId = R.drawable.seis;
                break;
            case 7:
                resourceId = R.drawable.siete;
                break;
            case 8:
                resourceId = R.drawable.ocho;
                break;
            case 9:
                resourceId = R.drawable.nueve;
                break;
            case 10:
                resourceId = R.drawable.diez;
                break;
            case 11:
                resourceId = R.drawable.once;
                break;
            case 12:
                resourceId = R.drawable.doce;
                break;
            case 13:
                resourceId = R.drawable.trece;
                break;
            case 14:
                resourceId = R.drawable.catorce;
                break;
            case 15:
                resourceId = R.drawable.quince;
                break;
            case 16:
                resourceId = R.drawable.dieciseis;
                break;
            case 17:
                resourceId = R.drawable.diecisiete;
                break;
            case 18:
                resourceId = R.drawable.dieciocho;
                break;
            case 19:
                resourceId = R.drawable.diecinueve;
                break;
            case 20:
                resourceId = R.drawable.veinte;
                break;
            case 21:
                resourceId = R.drawable.veintiuno;
                break;
            case 22:
                resourceId = R.drawable.veintidos;
                break;
            case 23:
                resourceId = R.drawable.veintitres;
                break;
            case 24:
                resourceId = R.drawable.veinticuatro;
                break;
            case 25:
                resourceId = R.drawable.veinticinco;
                break;
            case 26:
                resourceId = R.drawable.veintiseis;
                break;
            case 27:
                resourceId = R.drawable.veintisiete;
                break;
            case 28:
                resourceId = R.drawable.veintiocho;
                break;
            case 29:
                resourceId = R.drawable.veitinueve;
                break;
            case 30:
                resourceId = R.drawable.treinta;
                break;
            case 31:
                resourceId = R.drawable.treintauno;
                break;
            case 32:
                resourceId = R.drawable.treintados;
                break;
            case 33:
                resourceId = R.drawable.treintatres;
                break;
            case 34:
                resourceId = R.drawable.treintacuatro;
                break;
            case 35:
                resourceId = R.drawable.treintacinco;
                break;
            case 36:
                resourceId = R.drawable.treintaseis;
                break;
            case 37:
                resourceId = R.drawable.treintasiete;
                break;
            case 38:
                resourceId = R.drawable.treintaocho;
                break;
            case 39:
                resourceId = R.drawable.treintanueve;
                break;
            case 40:
                resourceId = R.drawable.cuarenta;
                break;
            case 41:
                resourceId = R.drawable.cuarentauno;
                break;
            case 42:
                resourceId = R.drawable.cuarentados;
                break;
            case 43:
                resourceId = R.drawable.cuarentatres;
                break;
            case 44:
                resourceId = R.drawable.cuarentacuatro;
                break;
            case 45:
                resourceId = R.drawable.cuarentacinco;
                break;
            case 46:
                resourceId = R.drawable.cuarentaseis;
                break;
            case 47:
                resourceId = R.drawable.cuarentasiete;
                break;
            case 48:
                resourceId = R.drawable.cuarentaocho;
                break;
            case 49:
                resourceId = R.drawable.cuarentanueve;
                break;
            case 50:
                resourceId = R.drawable.cincuenta;
                break;
            case 51:
                resourceId = R.drawable.cincuentauno;
                break;
            case 52:
                resourceId = R.drawable.cincuentados;
                break;
            case 53:
                resourceId = R.drawable.cincuentatres;
                break;
            case 54:
                resourceId = R.drawable.cincuentacuatro;
                break;
            case 55:
                resourceId = R.drawable.cincuentacinco;
                break;
            case 56:
                resourceId = R.drawable.cincuentaseis;
                break;
            case 57:
                resourceId = R.drawable.cincuentasiete;
                break;
            case 58:
                resourceId = R.drawable.cincuentaocho;
                break;
            case 59:
                resourceId = R.drawable.cincuentanueve;
                break;
            case 60:
                resourceId = R.drawable.sesenta;
                break;
            case 61:
                resourceId = R.drawable.sesentauno;
                break;
            case 62:
                resourceId = R.drawable.sesentados;
                break;
            case 63:
                resourceId = R.drawable.sesentatres;
                break;
            case 64:
                resourceId = R.drawable.sesentacuatro;
                break;
            case 65:
                resourceId = R.drawable.sesentacinco;
                break;
            case 66:
                resourceId = R.drawable.sesentaseis;
                break;
            case 67:
                resourceId = R.drawable.sesentasiete;
                break;
            case 68:
                resourceId = R.drawable.sesentaocho;
                break;
            case 69:
                resourceId = R.drawable.sesentanueve;
                break;
            case 70:
                resourceId = R.drawable.setenta;
                break;
            case 71:
                resourceId = R.drawable.setentauno;
                break;
            case 72:
                resourceId = R.drawable.setentados;
                break;
            case 73:
                resourceId = R.drawable.setentatres;
                break;
            case 74:
                resourceId = R.drawable.setentacuatro;
                break;
            case 75:
                resourceId = R.drawable.setentacinco;
                break;
        }
        return resourceId;
    }

}
