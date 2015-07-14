package com.example.polycap.bootcampchallengeii;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Polycap on 7/12/2015.
 */
public class DetailsFragment extends Fragment {

    public static final String FRAG_TYPE = "fragment_type";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detailsfragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        int type = getArguments().getInt(FRAG_TYPE);
        switch (type) {

            case 0:
                textView.setText("An automated system that can plant, irrigate and harvest would fulfill the basic food needs for majority of the worlds growing population");
                break;
            case 1:
                textView.setText("The growing size of the sahara Desert is approximately the size of america. Imagine if america was a baren land that noone could use or live on how would this change the world?");
                break;
            case 2:
                textView.setText("PolyOcracy is about looks to harness the knowledge gathered in psychology, neuroscience, sociology and other fields");
                break;
            case 3:
                textView.setText("Transforming how humans travel through space is a revolution that has been waiting to happen for the better half of the last century, I mean why not replace it with flying cars");
                break;
            case 4:
                textView.setText("Rather than always going to the doctor to get a diagnostic, why not have a chip in side your body that monitors your vitauls and sends the data to your doctor for examination. Your doctor could be Watson");
                break;
            case 5:
                textView.setText("To complement PolyOcracy by using the power of technology to revolutionizing how people vote and decide what happens in society");
                break;
            case 6:
                textView.setText("A company that unites people to create a better future for themselves.");
                break;
            case 7:
                textView.setText("Why not create a future that is the paradise that everyone is wishing for?");
                break;

        }
        return view;
    }


}
