package com.example.hackeru.advancedfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by hackeru on 1/26/2017.
 */

public class MainFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Monster[] monsters = {
            new Monster("1", 1, R.drawable.five),
            new Monster("2", 2, R.drawable.four),
            new Monster("3", 3, R.drawable.nine),
            new Monster("4", 4, R.drawable.ten),
            new Monster("5", 5, R.drawable.six),
            new Monster("6", 6, R.drawable.one),
            new Monster("7", 7, R.drawable.twelve),
            new Monster("8", 8, R.drawable.five),
            new Monster("9", 9, R.drawable.four)
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = (ListView) view.findViewById(R.id.list_view);
        MonsterAdapter adapter = new MonsterAdapter(getActivity(), monsters);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.MONSTER, monsters[position]);
        ((OnClickedImage) getActivity()).onClick(bundle);
    }
}
