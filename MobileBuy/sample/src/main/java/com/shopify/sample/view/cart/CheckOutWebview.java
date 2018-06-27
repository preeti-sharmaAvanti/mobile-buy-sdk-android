package com.shopify.sample.view.cart;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.shopify.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckOutWebview extends AppCompatActivity {

    @BindView(R.id.webview_payment)
    WebView webviewPayment;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.payment_screen);
        ButterKnife.bind(this);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager cookieManager = CookieManager.getInstance();

            cookieManager.setAcceptThirdPartyCookies(webviewPayment,true);
        }
        WebSettings webSettings = webviewPayment.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webviewPayment.setWebViewClient(new WebClient());
      String urlData="checkout[email]=preeti.sharma@avanti.in&checkout[shipping_address][zip]=110049&checkout[shipping_address][address1]=Avanti+Learning&checkout[shipping_address][city]=New+Delhi&checkout[shipping_address][province]=Delhi&checkout[shipping_address][country]=India&checkout[shipping_address][last_name]=Sharma&checkout[shipping_address][first_name]=Preeti";
        if(getIntent().getExtras()!=null)
        {
            String url=getIntent().getExtras().getString("URL");
            webviewPayment.loadUrl(url+"&"+urlData);
        }}

    private class WebClient extends WebViewClient
    {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            return false;
        }
    }



}
