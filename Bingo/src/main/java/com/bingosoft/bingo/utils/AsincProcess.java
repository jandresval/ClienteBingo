package com.bingosoft.bingo.utils;

import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by jandresv on 20/03/14.
 */
public class AsincProcess {

    public String ProcessString (String texto) {
        try {
            return new AsyncTask<String,Void,String>(){
                @Override
                protected String doInBackground(String... params) {
                    return HtmlUtils.readHtml(params[0].toString());
                }
            }.execute(texto).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "";
        }
    }

}
