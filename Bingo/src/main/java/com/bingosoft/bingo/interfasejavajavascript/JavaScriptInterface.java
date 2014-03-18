package com.bingosoft.bingo.interfasejavajavascript;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jandresv on 12/03/14.
 */
public class JavaScriptInterface {

    Context mContext;

    public JavaScriptInterface(Context c) {
        mContext = c;
    }

    public void showToast(String toast){
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }


}
