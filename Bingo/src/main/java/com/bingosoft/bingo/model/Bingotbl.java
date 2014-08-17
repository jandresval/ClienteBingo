package com.bingosoft.bingo.model;

import android.database.Cursor;

import com.bingosoft.bingo.utils.StringUtils;
import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;

import org.apache.commons.lang.math.NumberUtils;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Jaime on 2014-04-06.
 */
public class Bingotbl {


    public Bingotbl(Cursor cursor) {
        this.Tblnro = cursor.getString(0);
        this.Tblb1 = cursor.getString(1);
        this.Tblb2 = cursor.getString(2);
        this.Tblb3 = cursor.getString(3);
        this.Tblb4 = cursor.getString(4);
        this.Tblb5 = cursor.getString(5);
        this.Tbli1 = cursor.getString(6);
        this.Tbli2 = cursor.getString(7);
        this.Tbli3 = cursor.getString(8);
        this.Tbli4 = cursor.getString(9);
        this.Tbli5 = cursor.getString(10);
        this.Tbln1 = cursor.getString(11);
        this.Tbln2 = cursor.getString(12);
        this.Tbln3 = cursor.getString(13);
        this.Tbln4 = cursor.getString(14);
        this.Tbln5 = cursor.getString(15);
        this.Tblg1 = cursor.getString(16);
        this.Tblg2 = cursor.getString(17);
        this.Tblg3 = cursor.getString(18);
        this.Tblg4 = cursor.getString(19);
        this.Tblg5 = cursor.getString(20);
        this.Tblo1 = cursor.getString(21);
        this.Tblo2 = cursor.getString(22);
        this.Tblo3 = cursor.getString(23);
        this.Tblo4 = cursor.getString(24);
        this.Tblo5 = cursor.getString(25);
        this.Tblandroid = cursor.getInt(26);
        this.Tblalias = cursor.getString(27);
        this.Tblpiram = cursor.getString(28);
    }

    public Bingotbl(JSONObject jsonClass) throws Exception {


        this.Tblnro = jsonClass.getString("Tblnro");
        this.Tblb1 = jsonClass.getString("Tblb1");
        this.Tblb2 = jsonClass.getString("Tblb2");
        this.Tblb3 = jsonClass.getString("Tblb3");
        this.Tblb4 = jsonClass.getString("Tblb4");
        this.Tblb5 = jsonClass.getString("Tblb5");
        this.Tbli1 = jsonClass.getString("Tbli1");
        this.Tbli2 = jsonClass.getString("Tbli2");
        this.Tbli3 = jsonClass.getString("Tbli3");
        this.Tbli4 = jsonClass.getString("Tbli4");
        this.Tbli5 = jsonClass.getString("Tbli5");
        this.Tbln1 = jsonClass.getString("Tbln1");
        this.Tbln2 = jsonClass.getString("Tbln2");
        this.Tbln3 = jsonClass.getString("Tbln3");
        this.Tbln4 = jsonClass.getString("Tbln4");
        this.Tbln5 = jsonClass.getString("Tbln5");
        this.Tblg1 = jsonClass.getString("Tblg1");
        this.Tblg2 = jsonClass.getString("Tblg2");
        this.Tblg3 = jsonClass.getString("Tblg3");
        this.Tblg4 = jsonClass.getString("Tblg4");
        this.Tblg5 = jsonClass.getString("Tblg5");
        this.Tblo1 = jsonClass.getString("Tblo1");
        this.Tblo2 = jsonClass.getString("Tblo2");
        this.Tblo3 = jsonClass.getString("Tblo3");
        this.Tblo4 = jsonClass.getString("Tblo4");
        this.Tblo5 = jsonClass.getString("Tblo5");
        boolean tblAndroid = jsonClass.getBoolean("Tblandroid");
        if (tblAndroid)
            this.Tblandroid = 1;
        else
            this.Tblandroid = 0;
        this.Tblalias = jsonClass.getString("Alias");
        this.Tblpiram = jsonClass.getString("Tblpiram");

    }

    public String Tblnro;
    public String Tblb1;
    public String Tblb2;
    public String Tblb3;
    public String Tblb4;
    public String Tblb5;
    public String Tbli1;
    public String Tbli2;
    public String Tbli3;
    public String Tbli4;
    public String Tbli5;
    public String Tbln1;
    public String Tbln2;
    public String Tbln3;
    public String Tbln4;
    public String Tbln5;
    public String Tblg1;
    public String Tblg2;
    public String Tblg3;
    public String Tblg4;
    public String Tblg5;
    public String Tblo1;
    public String Tblo2;
    public String Tblo3;
    public String Tblo4;
    public String Tblo5;
    public int Tblandroid;
    public String Tblalias;
    public String Tblpiram;

}
