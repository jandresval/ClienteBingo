package com.bingosoft.bingo.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.bingosoft.bingo.ActividadPrincipal;
import com.bingosoft.bingo.R;
import com.bingosoft.bingo.data.DatabaseHandler;
import com.bingosoft.bingo.interfases.WebServiceCall;
import com.bingosoft.bingo.utils.StringUtils;

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
        assert _bingoUsuario != null;
        _cantidadTablas = _webServiceCall.IniciarProcesoDescargaTablas(_bingoUsuario.Alias);

    }

    public void procesoInicioDescargaTablasUsuario() {
        assert _bingoUsuario != null;
        _cantidadTablas = _webServiceCall.IniciarProcesoDescargaTablasUsuario(_bingoUsuario.Alias);

    }

    public boolean DescargaTablas(int pagina, boolean carga) {

        int fin;
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
                _databaseHandler.createBingotbl(bingotbl);
                if (carga)
                    _bingotbls.add(bingotbl);
            }
            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
        _webServiceCall = new WebServiceCall(_context.getString(R.string.mainRequestUrl),
                                             _context.getString(R.string.nameSpace));
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal)_context;
        _bingoUsuario = actividadPrincipal.retornarUsuario();

        Expiracion expiracion = _databaseHandler.getExpiracion();
        String alias = _databaseHandler.getUsuarioTablas();
        boolean soloUsuario = false;

        if (!(alias==null) && !alias.equals("") && !alias.equals(_bingoUsuario.Alias))
            soloUsuario = true;

        if (expiracion == null || expiracion.InformacionActiva())
            DescargarTablas();
        else {
            if (soloUsuario)
                DescargarUsuario(alias);
            CargaTablas();
        }

        return _bingotbls;
    }

    private void DescargarUsuario(String usuario) {

        procesoInicioDescargaTablasUsuario();

        String where = "Tblalias = ?";
        String[] whereArgs = new String[]{usuario};
        _databaseHandler.deleteBingotbl(where,whereArgs);

        if (!(_cantidadTablas == 0)) {

            _databaseHandler.deleteExpiracion();

            _paginas = (int) Math.ceil((float)_cantidadTablas / (float)NUMERO_TABLAS);
            int i = 1;
            boolean process = true;
            while (i <= _paginas) {
                if (!DescargaTablas(i,false)) {
                    process = false;
                    break;
                }
                i++;
            }

            if (process) {
                Expiracion expiracion = new Expiracion();
                _databaseHandler.createExpiracion(expiracion);
            }
        }
    }


    private void DescargarTablas() {
        procesoInicioDescargaTablas();

        _databaseHandler.deleteBingotbl(null,null);
        _databaseHandler.deleteExpiracion();

        if (!(_cantidadTablas == 0)) {
            _paginas = (int) Math.ceil((float)_cantidadTablas / (float)NUMERO_TABLAS);
            int i = 1;
            boolean process = true;
            while (i <= _paginas) {
                if (!DescargaTablas(i,true)) {
                    process = false;
                    break;
                }
                i++;
            }

            if (process) {
                Expiracion expiracion = new Expiracion();
                _databaseHandler.createExpiracion(expiracion);
            }
        }
    }

    private void CargaTablas() {
        _bingotbls = _databaseHandler.getListBingotbl();
    }

    @Override
    protected void onPostExecute(List<Bingotbl> bingotbls) {
        super.onPostExecute(bingotbls);
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal)_context;
        actividadPrincipal.tablas = bingotbls;
    }
}
