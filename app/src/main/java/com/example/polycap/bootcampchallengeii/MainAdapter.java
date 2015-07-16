package com.example.polycap.bootcampchallengeii;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Polycap on 7/12/2015.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context context;
    private ArrayList<list> lists;

    public MainAdapter(Activity context, ArrayList<list> lists) {
        this.lists = lists;
        this.context = context;

    }


    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lillpoly, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.title.setText(lists.get(position).getTitle());
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetailsView(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public void goToDetailsView(int position) {
        if (((Activity)context).findViewById(R.id.fragment_container) != null) {

            Fragment detailsFragment = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(DetailsFragment.FRAG_TYPE,position);
            detailsFragment.setArguments(bundle);
            ((Activity)context).getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, detailsFragment)
                    .addToBackStack(null)
                    .commit();


        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView title;
        View row;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            row = v.findViewById(R.id.row_layout);
        }


        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.row_layout:
                    break;
            }
        }
    }

}
