package com.bingosoft.bingo.model;

import android.database.Cursor;

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
    }

    public Bingotbl(JSONObject jsonClass) throws Exception {


        this.Tblnro = jsonClass.get("Tblnro").toString();
        this.Tblb1 = jsonClass.get("Tblb1").toString();
        this.Tblb2 = jsonClass.get("Tblb2").toString();
        this.Tblb3 = jsonClass.get("Tblb3").toString();
        this.Tblb4 = jsonClass.get("Tblb4").toString();
        this.Tblb5 = jsonClass.get("Tblb5").toString();
        this.Tbli1 = jsonClass.get("Tbli1").toString();
        this.Tbli2 = jsonClass.get("Tbli2").toString();
        this.Tbli3 = jsonClass.get("Tbli3").toString();
        this.Tbli4 = jsonClass.get("Tbli4").toString();
        this.Tbli5 = jsonClass.get("Tbli5").toString();
        this.Tbln1 = jsonClass.get("Tbln1").toString();
        this.Tbln2 = jsonClass.get("Tbln2").toString();
        this.Tbln3 = jsonClass.get("Tbln3").toString();
        this.Tbln4 = jsonClass.get("Tbln4").toString();
        this.Tbln5 = jsonClass.get("Tbln5").toString();
        this.Tblg1 = jsonClass.get("Tblg1").toString();
        this.Tblg2 = jsonClass.get("Tblg2").toString();
        this.Tblg3 = jsonClass.get("Tblg3").toString();
        this.Tblg4 = jsonClass.get("Tblg4").toString();
        this.Tblg5 = jsonClass.get("Tblg5").toString();
        this.Tblo1 = jsonClass.get("Tblo1").toString();
        this.Tblo2 = jsonClass.get("Tblo2").toString();
        this.Tblo3 = jsonClass.get("Tblo3").toString();
        this.Tblo4 = jsonClass.get("Tblo4").toString();
        this.Tblo5 = jsonClass.get("Tblo5").toString();
        String tblAnd = jsonClass.get("Tblandroid").toString();
        if (NumberUtils.isNumber(tblAnd)) {
            this.Tblandroid = Integer.parseInt(tblAnd);
        } else {
            this.Tblandroid = 0;
        }
        this.Tblalias = jsonClass.get("Alias").toString();

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

}
