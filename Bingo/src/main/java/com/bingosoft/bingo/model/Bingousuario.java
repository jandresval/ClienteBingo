package com.bingosoft.bingo.model;


import android.graphics.Bitmap;

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;

import org.apache.commons.lang.math.NumberUtils;

import org.joda.time.DateTime;

import java.util.Map;


/**
 * Created by jandresv on 22/03/14.
 */
public class Bingousuario {

    public Bingousuario() {

    }

    public Bingousuario(String jsonClass) throws Exception{

        JsonParserFactory factory = JsonParserFactory.getInstance();
        JSONParser parser = factory.newJsonParser();
        Map jsonData = parser.parseJson(jsonClass);

        String idUsuario = jsonData.get("Idusuario").toString();
        if (NumberUtils.isNumber(idUsuario))
            this.Idusuario = Integer.parseInt(idUsuario);
        else
            this.Idusuario = 0;
        this.Alias = jsonData.get("Alias").toString();
        this.Macadress = jsonData.get("Macadress").toString();
        this.Ip = jsonData.get("Ip").toString();
        this.Ultimafechaconexion = new DateTime();
        this.Ultimafechaconexion = DateTime.parse(jsonData.get("Ultimafechaconexion").toString());
        this.Ultimafechadejuego = new DateTime();
        this.Ultimafechadejuego = DateTime.parse(jsonData.get("Ultimafechadejuego").toString());

        String saldoActual = jsonData.get("Saldoactual").toString();
        if (NumberUtils.isNumber(saldoActual))
            this.Saldoactual = Double.parseDouble(saldoActual);
        else
            this.Saldoactual = 0;
        this.Socsucursal = jsonData.get("Socsucursal").toString();

        String gpsLatitud = jsonData.get("Gpslatitud").toString();
        if (NumberUtils.isNumber(gpsLatitud))
            this.Gpslatitud = Double.parseDouble(gpsLatitud);
        else
            this.Gpslatitud = 0;

        String gpsLongitud = jsonData.get("Gpslongitud").toString();
        if (NumberUtils.isNumber(gpsLongitud))
            this.Gpslongitud = Double.parseDouble(gpsLongitud);
        else
            this.Gpslongitud = 0;
        this.Activo = Boolean.parseBoolean(jsonData.get("Activo").toString());


    }

    public int Idusuario;

    public  String Alias;

    public String Macadress;

    public String Ip;

    public DateTime Ultimafechaconexion;

    public DateTime Ultimafechadejuego;

    public double Saldoactual;

    public String Socsucursal;

    public double Gpslatitud;

    public double Gpslongitud;

    public Bitmap Imagenuser;

    public boolean Activo;

}
