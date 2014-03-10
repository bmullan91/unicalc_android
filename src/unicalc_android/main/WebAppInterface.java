package unicalc_android.main;

import android.content.Context;
import android.webkit.JavascriptInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WebAppInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
//    @JavascriptInterface
//    public void showToast(String toast) {
//        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
//    }

    @JavascriptInterface
    public boolean setItem(String key, String results) {

        try {

            FileOutputStream fos = mContext.openFileOutput(key, Context.MODE_PRIVATE);

            try {
                fos.write(results.getBytes());
                fos.close();
            } catch (IOException e) {
                return false;
            }


        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    @JavascriptInterface
    public String getItem(String key) {
        String failed = "";
        StringBuffer fileContent;

        try {

            FileInputStream fis = mContext.openFileInput(key);

            fileContent = new StringBuffer("");
            byte[] buffer = new byte[1024];

            try {
                while (fis.read(buffer) != -1) {
                    fileContent.append(new String(buffer));
                }

            } catch (IOException e) {
                return failed;
            }
        } catch (FileNotFoundException e) {
            return failed;
        }

        return fileContent.toString();
    }
}
