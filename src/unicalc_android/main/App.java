package unicalc_android.main;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class App extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //load the url
        WebView myWebView = (WebView) findViewById(R.id.webview);


        myWebView.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage cm) {
                Log.d("WebView", cm.message() + " -- From line "
                        + cm.lineNumber() + " of "
                        + cm.sourceId());
                return true;
            }
        });

        //chrome debugger - visit chrome://inspect/#devices
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        //important!
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        //Prevent users from zooming - also prevents the webview auto zooming on input fields
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);

        //inject the interface
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        myWebView.loadUrl("file:///android_asset/webapp/index.html");


    }
}
