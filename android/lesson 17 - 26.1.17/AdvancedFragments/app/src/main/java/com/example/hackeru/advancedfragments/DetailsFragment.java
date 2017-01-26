package com.example.hackeru.advancedfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hackeru on 1/26/2017.
 */

public class DetailsFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        Monster monster = (Monster) getArguments().getSerializable(MainActivity.MONSTER);

        ImageView iv = (ImageView) view.findViewById(R.id.fragment_detail_image_view);
        TextView nameTV = (TextView) view.findViewById(R.id.fragment_detail_name_text_view);
        TextView ageTV = (TextView) view.findViewById(R.id.fragment_detail_age_text_view);

        iv.setImageResource(monster.getImage());
        nameTV.setText(monster.getName());
        ageTV.setText(monster.getAge() + "");

        return view;
    }


}
