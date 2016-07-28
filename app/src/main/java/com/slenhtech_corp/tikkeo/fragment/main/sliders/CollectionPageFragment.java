package com.slenhtech_corp.tikkeo.fragment.main.sliders;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slenhtech_corp.tikkeo.R;

/**
 * Created by bface007 on 15/06/2016.
 */
public class CollectionPageFragment extends BaseSliderFragment {

    private ImageView image;
    private TextView text;

    public static final int[] COLLECTION_IMAGE_RES_ID = new int[]{
            R.drawable.event_3,
            R.drawable.event_5,
            R.drawable.event_6,
            R.drawable.event_4
    };

    private static final int[] COLLECTION_TITLE_RES_ID = new int[]{
            R.string.event_1,
            R.string.event_2,
            R.string.event_3,
            R.string.event_4
    };

    public static CollectionPageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CollectionPageFragment fragment = new CollectionPageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_curated_collection_pager_slide, container, false);

        image = (ImageView) view.findViewById(R.id.slide_img);
        text = (TextView) view.findViewById(R.id.slide_text);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            image.setImageDrawable(getActivity().getResources().getDrawable(COLLECTION_IMAGE_RES_ID[mPage], getActivity().getApplicationContext().getTheme()));
        }else {
            image.setImageDrawable(getActivity().getResources().getDrawable(COLLECTION_IMAGE_RES_ID[mPage]));
        }

        image.setImageResource(COLLECTION_IMAGE_RES_ID[mPage]);
        text.setText(COLLECTION_TITLE_RES_ID[mPage]);

        return view;
    }


}
