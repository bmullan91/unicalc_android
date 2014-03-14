package unicalc_android.main;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.io.*;

public class WebAppInterface implements LocalStorage {

    private Context mContext;
    private FileIO fileIO;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
        fileIO = new FileIO(c);
    }

    @JavascriptInterface
    public void setItem(String key, String results) {

        try {
            fileIO.write(key, results);
        } catch (IOException e) {
            Log.e("FileIO Exception", "file write failed: "+e.toString());
        }

    }

    @JavascriptInterface
    public String getItem(String key) {

        String rc = "";
        try {
            rc = fileIO.read(key);
        } catch (IOException e) {
            Log.e("FileIO Exception", "file read error: "+e.toString());
        }

        return rc;
    }
}
