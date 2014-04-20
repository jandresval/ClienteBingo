package com.bingosoft.bingo.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.bingosoft.bingo.ActividadPrincipal;
import com.bingosoft.bingo.data.DatabaseHandler;
import com.bingosoft.bingo.interfases.WebServiceCall;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaime on 2014-04-08.
 */
public class TablasHandler extends AsyncTask<Context, Void, List<Bingotbl>> {

    private ArrayList<Bingotbl> _bingotbls;
    private Context _context;
    private boolean _proceso;
    private int _cantidadTablas;
    private int _paginas;
    private boolean _descarga;
    private DatabaseHandler _databaseHandler;
    private WebServiceCall _webServiceCall;
    private Bingousuario _bingoUsuario;

    private final int NUMERO_TABLAS = 100;

    private void mensaje(String mensaje) {
        Log.v("TablasHanler",mensaje);
    }


    public void addBingotbl(Bingotbl bingotbl) {
        _bingotbls.add(bingotbl);
    }

    public boolean removeBingotbl(Bingotbl bingotbl) {
        return _bingotbls.remove(bingotbl);
    }

    public void setBingotbls(ArrayList<Bingotbl> bingotbls) {
        _bingotbls = bingotbls;
    }

    public ArrayList<Bingotbl> getBingotbls() {
        return _bingotbls;
    }


    public void procesoInicioDescargaTablas() {
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal)_context;
        _bingoUsuario = actividadPrincipal.retornarUsuario();

        assert _bingoUsuario != null;
        _cantidadTablas = _webServiceCall.IniciarProcesoDescargaTablas(_bingoUsuario.Alias);

    }

    public void DescargaTablas(int pagina) {

        int fin = 0;
        if ((NUMERO_TABLAS*(pagina-1))+NUMERO_TABLAS > _cantidadTablas)
            fin = _cantidadTablas-(NUMERO_TABLAS*(pagina-1));
        else
            fin = NUMERO_TABLAS;

        String tablas = _webServiceCall.DescargaTablas(_bingoUsuario.Alias,NUMERO_TABLAS*(pagina-1),
                fin);

        try {
            JSONArray data = new JSONArray(tablas);

            for(int i=0;i<data.length();i++) {
                Bingotbl bingotbl = new Bingotbl(data.getJSONObject(i));
                _bingotbls.add(bingotbl);
                _databaseHandler.createBingotbl(bingotbl);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected List<Bingotbl> doInBackground(Context... params) {

        _bingotbls = new ArrayList<Bingotbl>();
        _context = params[0];
        _proceso = false;
        _cantidadTablas = 0;
        _paginas = 0;
        _descarga = false;
        _databaseHandler = new DatabaseHandler(params[0]);
        _webServiceCall = new WebServiceCall();

        procesoInicioDescargaTablas();

        _databaseHandler.deleteTable("Bingotbl");

        if (!(_cantidadTablas == 0)) {
            _paginas = (int) Math.ceil((float)_cantidadTablas / (float)NUMERO_TABLAS);
            int i = 1;
            while (i <= _paginas) {
                DescargaTablas(i);
                i++;
            }
        }

        return _bingotbls;
    }

    @Override
    protected void onPostExecute(List<Bingotbl> bingotbls) {
        super.onPostExecute(bingotbls);
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal)_context;
        actividadPrincipal.tablas = bingotbls;
    }
}
