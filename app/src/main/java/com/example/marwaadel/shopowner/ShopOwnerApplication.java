package com.example.marwaadel.shopowner;

import android.content.SharedPreferences;

import com.cloudinary.Cloudinary;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Includes one-time initialization of Firebase related code
 */
public class ShopOwnerApplication extends android.app.Application {
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    public void onCreate() {
        super.onCreate();
   /* Initialize Firebase */
        Firebase.setAndroidContext(this);




    }

}