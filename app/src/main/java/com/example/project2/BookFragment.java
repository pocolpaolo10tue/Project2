package com.example.project2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.webkit.WebSettings;
import android.webkit.WebView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BookFragment extends Fragment {

    public BookFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_book, container, false);
        WebView webView = view.findViewById(R.id.webView);
        webView.loadUrl("https://fmis.tue.nl/case/tue/RES_001");

        // Enable Javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        return view;
    }

}