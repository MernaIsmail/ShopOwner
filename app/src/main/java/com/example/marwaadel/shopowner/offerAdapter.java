package com.example.marwaadel.shopowner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.marwaadel.shopowner.mPicasso.PicassoClient;
import com.example.marwaadel.shopowner.model.OfferDataModel;
import com.example.marwaadel.shopowner.utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.Query;
import com.firebase.client.core.Context;
import com.firebase.ui.FirebaseListAdapter;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by Marwa Adel on 5/2/2016.
 */
public class offerAdapter extends FirebaseListAdapter<OfferDataModel> {
    Activity activity;

    public offerAdapter(Activity activity, Class<OfferDataModel> modelClass, int modelLayout, Query ref) {

        super(activity, modelClass, modelLayout, ref);
        this.activity=activity;
        Log.d("ddd", ref.toString());
    }

    @Override
    protected void populateView(View v, final OfferDataModel model,final int position) {
        //Double num1,num2,result;
        LinearLayout deleteBtn = (LinearLayout) v.findViewById(R.id.deleteLayout);
        LinearLayout editBtn = (LinearLayout) v.findViewById(R.id.editLayout);
        ImageView imgOffer=(ImageView) v.findViewById(R.id.offerImg);

        TextView title = (TextView) v.findViewById(R.id.titlteoffer);
        TextView description = (TextView) v.findViewById(R.id.descriptionoffer);
        TextView before = (TextView) v.findViewById(R.id.beforeoffer);
        before.setPaintFlags(before.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        TextView after = (TextView) v.findViewById(R.id.afteroffer);
        TextView Discountdifference = (TextView) v.findViewById(R.id.Discountdifferencez);
        Log.d("data", "populateView " + model.getDescription());

//        num1 = Double.parseDouble(after.getText().toString());
//        num2 = Double.parseDouble(before.getText().toString());
//        result=(1- (num1/num2));
//        Discountdifference.setText(Double.toString(result));

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(activity, addoffers.class);
                in.putExtra("editobj", model);
                in.putExtra("uuid", getRef(position).getKey());
                activity.startActivity(in);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "deleted", Toast.LENGTH_SHORT).show();
                Firebase shopRef = new Firebase(Constants.FIREBASE_URL).child("OfferList")
                        .child(getRef(position).getKey()).child("status");
                shopRef.setValue("true");
            }
        });

        title.setText(model.getTitle());
        description.setText(model.getDescription());
        before.setText(model.getDiscountBefore());
        after.setText(model.getDiscountAfter());


//        Log.e("picaso test",model.getOfferImage());
    }
}
