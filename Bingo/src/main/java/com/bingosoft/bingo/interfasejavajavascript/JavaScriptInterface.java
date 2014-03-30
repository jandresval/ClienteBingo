package com.bingosoft.bingo.interfasejavajavascript;

import android.content.Context;
import android.widget.Toast;

import com.bingosoft.bingo.ActividadPrincipal;
import com.bingosoft.bingo.model.Bingousuario;

/**
 * Created by jandresv on 12/03/14.
 */
public class JavaScriptInterface {

    Context mContext;

    private boolean _conectado;

    public Bingousuario bingousuario = null;

    public boolean _juego = false;


    public JavaScriptInterface(Context c) {
        mContext = c;
        _conectado = false;
        _juego = false;
    }

    public void cargarBingoUsuario(String jsonBingoUsuario) {
        if (!jsonBingoUsuario.equals("")) {
            try {
                bingousuario = new Bingousuario(jsonBingoUsuario);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void iniciarJuego() {
        _juego = true;
    }



    public void showToast(String toast){
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    public boolean Estado(){
        return _conectado;
    }

    public void Conectado(){
        _conectado = true;
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal)mContext;
        actividadPrincipal.usuarioConecto();
    }

    public void DesConectado(){
        _conectado = false;
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal)mContext;
        actividadPrincipal.usuarioDesconecto();
    }


}
