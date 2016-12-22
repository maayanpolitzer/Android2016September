package example.com.webview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;




public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Website[] websites = {
            new Website("walla", "http://www.walla.co.il"),
            new Website("ynet", "http://www.ynet.co.il"),
            new Website("facebook", "http://www.facebook.com"),
            new Website("twitter", "http://www.twitter.com")
    };
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        webView = (WebView) findViewById(R.id.webView);

        ArrayAdapter<Website> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, websites);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        webView.loadUrl(websites[position].getUrl());   // display webpages via URL
        /*
        String first = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<style>";
        String second = "</style>\n" +
                "\t</head>\n" +
                "\t<body>";
        String third = "</body>\n" +
                "</html>";
        String css = "p {width:100px;height:100px;background-color:pink;}";
        String html = "<p>hi</p>";
        webView.loadData(first + css + second + html + third, "text/html", "UTF-8");    // display html file as String.
        */

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d("Maayan", "onNothingSelected");
    }
}
