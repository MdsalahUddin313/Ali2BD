package com.example.ali2bd.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ali2bd.R;


public class Cart extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.fragment_cart, container, false);


        WebView webView =viewGroup.findViewById(R.id.cart_web_id);
        webView.loadUrl("file:///android_asset/flipcart.html");

        // Enable Javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        webView.setWebViewClient(new WebViewClient());

        return viewGroup;
    }
}
