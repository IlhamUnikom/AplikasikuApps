package com.ilham.aplikasiku.Daily;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilham.aplikasiku.Adapter.FriendlistAdapter;
import com.ilham.aplikasiku.Item.FriendlistItem;
import com.ilham.aplikasiku.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendlistFragment extends Fragment {

    private View view;
    private List<FriendlistItem> friendlistItems = null;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_friendlist, container, false);
        ButterKnife.bind(this, view);

        loadDataFriendlist();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        FriendlistAdapter FriendlistDataAdapter = new FriendlistAdapter(getContext(), friendlistItems);
        recyclerView.setAdapter(FriendlistDataAdapter);

        return view;
    }

    public void loadDataFriendlist() {
        friendlistItems = new ArrayList<FriendlistItem>();
        friendlistItems.add(new FriendlistItem("Ryan Yusup", "Lembang People", R.drawable.ryan));
        friendlistItems.add(new FriendlistItem("Aa Suhendar", "Lembang People", R.drawable.aa));
        friendlistItems.add(new FriendlistItem("Erry Nurhadiyansyah", "Subang People", R.drawable.eri));
        friendlistItems.add(new FriendlistItem("Gilang Maulana", "Cimahi Boys", R.drawable.lang));
        friendlistItems.add(new FriendlistItem("Yusup Maulanadireja", "Fotografer Handal", R.drawable.ucup));
    }

}
