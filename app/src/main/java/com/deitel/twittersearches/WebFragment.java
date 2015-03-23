package com.deitel.twittersearches;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.deitel.twittersearches.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_URL = "url";
    // private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String url;
    // private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment WebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebFragment newInstance(String url) {
        WebFragment fragment = new WebFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        // args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public WebFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(ARG_URL);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View WebFragmentView = inflater.inflate(R.layout.fragment_web, container, false);
        TextView textView = (TextView)WebFragmentView.findViewById(R.id.webTextView);
        textView.setText(url);
        WebView webView = (WebView)WebFragmentView.findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl(url);
        return WebFragmentView;
    }


}
