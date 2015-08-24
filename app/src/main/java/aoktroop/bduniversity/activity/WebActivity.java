package aoktroop.bduniversity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import oaktroop.bduniversity.R;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    private Button back;
    private Button forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webn);

        back = (Button) findViewById(R.id.backButton);
        forward = (Button) findViewById(R.id.forwardButton);

        webView=(WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new MyBrowser());

        String url = "http://uva.onlinejudge.org/";

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);

    }

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {

            webView.goBack(); // go back in only the web view
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }

    public void backAction(View view){
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else{
            Toast.makeText(getApplicationContext(), "No page to go Back!", Toast.LENGTH_SHORT).show();
//            System.out.println("1. Else!!!");
        }

    }

    public void forwardAction(View view){
        if(webView.canGoForward())
        {
            webView.goForward();
        }
        else{
//            System.out.println("2. Else!!!");
            Toast.makeText(getApplicationContext(), "No page to go Forward!", Toast.LENGTH_SHORT).show();
        }

    }
}
