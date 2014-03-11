package unicalc_android.main;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class App extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //load the url
        WebView myWebView = (WebView) findViewById(R.id.webview);

        //chrome debugger - visit chrome://inspect/#devices
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        myWebView.loadUrl("file:///android_asset/webapp/index.html");

        //important!
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        //Prevent users from zooming - also prevents the webview auto zooming on input fields
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);

        //Testing localStorage first..
        //myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");




    }
}
