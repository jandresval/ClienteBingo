package com.bingosoft.bingo.interfases;

import android.content.Context;
import android.widget.Toast;

import com.bingosoft.bingo.ActividadPrincipal;
import com.bingosoft.bingo.listeners.MyHandlerDLTablas;
import com.bingosoft.bingo.model.Bingousuario;
import com.bingosoft.bingo.utils.StringUtils;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Created by jandresv on 12/03/14.
 */
public class JavaScriptInterface {

    Context _mContext;

    private boolean _conectado;

    public Bingousuario _bingousuario = null;

    public boolean _juego = false;


    public JavaScriptInterface(Context c) {
        _mContext = c;
        _conectado = false;
        _juego = false;
    }

    public void cargarBingoUsuario(String jsonBingoUsuario) {
        if (!jsonBingoUsuario.equals("")) try {
            _bingousuario = new Bingousuario(jsonBingoUsuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void iniciarJuego() {
        _juego = true;
    }



    public void showToast(String toast){
        Toast.makeText(_mContext, toast, Toast.LENGTH_SHORT).show();
    }

    public boolean Estado(){
        return _conectado;
    }

    public void Conectado() {
        _conectado = true;
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal) _mContext;
        actividadPrincipal.usuarioConecto();
    }

    public void DesConectado() {
        _conectado = false;
        _bingousuario = null;
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal) _mContext;
        actividadPrincipal.usuarioDesconecto();
    }

    public void Balota(String balota) {
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal) _mContext;
        actividadPrincipal.Balota(StringUtils.balotas(balota));
    }


}
