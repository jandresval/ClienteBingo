package com.bingosoft.bingo;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import com.bingosoft.bingo.interfasejavajavascript.JavaScriptInterface;
import com.bingosoft.bingo.utils.AndroidUtils;
import com.bingosoft.bingo.utils.AsincProcess;

public class ActividadPrincipal extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    /**
     * Este es el buton con el que nos vamos a conectar al servicio
     */
    Button bConectar;

    /**
     * Este es conector al servicio web
     */
    WebView conecionServer;

    /**
     * Este es el text para introducir el usuario
     */
    EditText textUsuario;

    /**
     * Variable para determinar si la pagina cargo correctamente
     */
    boolean paginaCargo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);



        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        iniciarTextUsuario();

    }

    public void iniciarTextUsuario() {

        InputFilter espaciosFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for(int k = start; k < end; k++) {
                    if (Character.isSpaceChar(source.charAt(k))) {
                        return "";
                    }
                }
                return null;
            }
        };

        textUsuario = (EditText) findViewById(R.id.TUsuario);

        textUsuario.setFilters(new InputFilter[]{ espaciosFilter });

        textUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 3)
                    enableConectar();
                else
                    disableConectar();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void onConectarClick(View v) {

        conecionServer = (WebView)findViewById(R.id.conexionSignalR);

        textUsuario = (EditText)findViewById(R.id.TUsuario);

        String usuario = textUsuario.getText().toString();

        String ip = AndroidUtils.getLocalIpAddress();

        String macAddress = AndroidUtils.getMacAddress(this);

        conecionServer.loadUrl("javascript:Conectar('" +
                usuario + "','" +
                ip + "','" +
                macAddress + "');");
    }

    public void enableConectar() {
        textUsuario = (EditText) findViewById(R.id.TUsuario);
        if (textUsuario.getText().length() > 3 && paginaCargo == true) {
            bConectar = (Button) findViewById(R.id.Conectar);
            bConectar.setEnabled(true);
        }
    }

    public void disableConectar() {
        bConectar = (Button) findViewById(R.id.Conectar);
        bConectar.setEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        try{

            WebView webView = (WebView)findViewById(R.id.conexionSignalR);

            if (!(webView == null)) {

                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                webView.getSettings().setDomStorageEnabled(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.getSettings().setUseWideViewPort(true);

                webView.setWebChromeClient(new WebChromeClient());

                final JavaScriptInterface javaScriptInterface = new JavaScriptInterface(this);

                webView.addJavascriptInterface(javaScriptInterface, getString(R.string.JavaFunciones));

                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        paginaCargo = false;
                        disableConectar();
                    }
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        paginaCargo = true;
                        enableConectar();
                    }
                });

                webView.loadUrl(getString(R.string.RutaConexionSignalR));

            }

        }
        catch (NullPointerException ex) {
            Log.w("BingoSoft",ex.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actividad_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_actividad_principal, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        @Override
        public void onResume(){
            super.onResume();



        }

    }

}
