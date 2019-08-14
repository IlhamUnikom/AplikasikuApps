package com.ilham.aplikasiku.Daily;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilham.aplikasiku.Adapter.DailyAdapter;
import com.ilham.aplikasiku.Item.DailyItem;
import com.ilham.aplikasiku.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyFragment extends Fragment {

    private View view;
    private List<DailyItem> DailyItem = null;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_daily, container, false);
        ButterKnife.bind(this, view);

        loadDataDaily();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DailyAdapter DailyDataAdapter = new DailyAdapter(getContext(), DailyItem);
        recyclerView.setAdapter(DailyDataAdapter);

        return view;
    }

    public void loadDataDaily() {
            DailyItem = new ArrayList<DailyItem>();
            DailyItem.add(new DailyItem("Ngaji Subuh", "04:30", R.drawable.solat));
            DailyItem.add(new DailyItem("Kuliah", "07:00", R.drawable.kuliah));
            DailyItem.add(new DailyItem("Ngajar Ngaji", "18:30", R.drawable.ngaji));
            DailyItem.add(new DailyItem("Belajar", "20:30", R.drawable.studi));
            DailyItem.add(new DailyItem("Tidur", "22:30", R.drawable.tidur));
    }
}
