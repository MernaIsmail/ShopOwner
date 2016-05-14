package com.example.marwaadel.shopowner;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marwaadel.shopowner.mPicasso.PicassoClient;
import com.example.marwaadel.shopowner.model.OfferDataModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    OfferDataModel offerydetail;
    TextView tvTitle, tvDescription, tvBefore, tvAfter;


    public DetailActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.leftarrow);
        ((DetailActivity)getActivity()).setSupportActionBar(toolbar);
        ((DetailActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getContext(), showoffers.class);
                startActivity(in);
            }
        });
        // 1. get passed intent
        Intent intent = getActivity().getIntent();
        // 2. get offer object from intent
        OfferDataModel offer = (OfferDataModel) intent.getSerializableExtra("person");

        // 3. get reference to offer textView
        ImageView Img=(ImageView)rootView.findViewById(R.id.btndetail);
        tvTitle = (TextView) rootView.findViewById(R.id.titlte_detail);
        tvDescription = (TextView) rootView.findViewById(R.id.description_detail);
        tvBefore = (TextView) rootView.findViewById(R.id.before_detail);
        tvAfter = (TextView) rootView.findViewById(R.id.after_detail);
        // 4. display details on textView
        PicassoClient.downloadImg(getActivity(),offer.getOfferImage(),Img);
        tvTitle.setText(offer.getTitle());
        tvDescription.setText(offer.getDescription());
        // Double.parseDouble(tvBefore.getText().toString());
        tvBefore.setText(offer.getDiscountBefore());
        tvAfter.setText(offer.getDiscountAfter());

        return rootView;
    }
}
