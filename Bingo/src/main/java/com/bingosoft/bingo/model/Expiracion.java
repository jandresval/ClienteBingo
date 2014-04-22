package com.bingosoft.bingo.model;

import android.database.Cursor;

import com.bingosoft.bingo.ActividadPrincipal;

import java.util.Calendar;
import java.util.Date;

import static com.bingosoft.bingo.utils.AndroidUtils.loadDate;
import static java.lang.System.currentTimeMillis;

/**
 * Created by Jaime on 2014-04-20.
 */
public class Expiracion {

    private final int DIAS = 10;

    public Expiracion() {
        this.Iniciodate = new Date(currentTimeMillis());
        this.Findate = new Date(currentTimeMillis()+DIAS*24*60*60*1000l);
        this.Activo = 1;
    }

    public Expiracion(Cursor cursor) {
        this.Iniciodate = loadDate(cursor, 0);
        this.Findate = loadDate(cursor, 1);
        this.Activo = cursor.getInt(2);
    }

    public boolean InformacionActiva () {
        Calendar c = Calendar.getInstance();
        Date now = new Date(currentTimeMillis());
        if (this.Findate == null)
            return false;
        if (this.Findate.after(now))
            return false;
        else
            return true;
    }

    public Date Iniciodate;
    public Date Findate;
    public int Activo;

}
