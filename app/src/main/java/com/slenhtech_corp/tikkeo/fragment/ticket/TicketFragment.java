package com.slenhtech_corp.tikkeo.fragment.ticket;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slenhtech_corp.tikkeo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicketFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static final int[] QR_CODES = new int[]{
            R.drawable.qr_code_1,
            R.drawable.qr_code_2,
            R.drawable.qr_code_3
    };

    public static final String[] DESCS = new String[]{

    };

    public TicketFragment() {
        // Required empty public constructor
    }

    public static TicketFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TicketFragment fragment = new TicketFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ticket, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.qrcode);
        TextView owner = (TextView) view.findViewById(R.id.owner);
        TextView desc = (TextView) view.findViewById(R.id.ticket_detail);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            imageView.setImageDrawable(getActivity().getDrawable(QR_CODES[mPage]));
        else
            imageView.setImageDrawable(getActivity().getResources().getDrawable(QR_CODES[mPage]));

        owner.setText("John Doe");

        desc.setText("Ticket #"+ String.valueOf(mPage + 1));

        return view;
    }

}
