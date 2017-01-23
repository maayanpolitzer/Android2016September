package com.example.hackeru.fragmentsvolleymovies;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by hackeru on 1/23/2017.
 */

public class ResultsListFragment extends Fragment {

    private String link = "http://www.omdbapi.com/?r=json&s=";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String movieName = getActivity().getIntent().getStringExtra(MainActivity.SEARCH);
        createHttpRequest(movieName);
        View view = inflater.inflate(R.layout.fragment_list_results, container, false);



        return view;
    }

    private void createHttpRequest(String movieName){
            String searchLink = link + movieName;
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.GET,
                    searchLink,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("TAG", response.toString());
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("TAG", error.toString());
                        }
                    }
            );

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);
    }


}
