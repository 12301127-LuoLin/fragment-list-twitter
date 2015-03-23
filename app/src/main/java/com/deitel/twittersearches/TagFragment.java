package com.deitel.twittersearches;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.deitel.twittersearches.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TagFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class TagFragment extends ListFragment {

    private OnFragmentInteractionListener mListener;
    private SharedPreferences savedSearches;
    private static final String SEARCHES = "searches";
    private ArrayAdapter<String> adapter; // binds tags to ListView

    public TagFragment() {
        // Required empty public constructor
    }

    public void setAdapter(ArrayAdapter<String> adapter){
        this.adapter = adapter;
        setListAdapter(this.adapter);
    }

    public ArrayAdapter<String> getAdapter(){
        return this.adapter;
    }
    //
    public SharedPreferences getSavedSearches(){
        return savedSearches;
    }

    public void setSavedSearches(SharedPreferences savedSearches){
        this.savedSearches = savedSearches;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_tag, container, false);
        ListView listView = (ListView)myView.findViewById(android.R.id.list);
        listView.setOnItemLongClickListener(mListener.getOnItemLongClickListener());
        return myView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (mListener != null){
            // get query string and create a URL representing the search
            String tag = ((TextView) v).getText().toString();
            String urlString = getString(R.string.searchURL) +
                    Uri.encode(savedSearches.getString(tag, ""), "UTF-8");
            mListener.sendUrlToWebFragment(urlString);
            // create an Intent to launch a web browser

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public void sendUrlToWebFragment(String url);
        public AdapterView.OnItemLongClickListener getOnItemLongClickListener();
    }






}
