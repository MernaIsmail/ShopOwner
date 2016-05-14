package com.example.marwaadel.shopowner.utils;

/**
 * Constants class store most important strings and paths of the app
 */
public final class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where active lists are stored (ie "activeLists")
     */
    public static final String FIREBASE_PROPERTY_LIST_NAME = "OfferList";

    /**
     * Constants for Firebase object properties
     */
    public static final String KEY_PROVIDER = "PROVIDER";
    public static final String KEY_ENCODED_EMAIL = "ENCODED_EMAIL";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    /**
     * Constants for Firebase URL
     */
    public static final String FIREBASE_URL = "https://forwork0.firebaseio.com/";
    public static final String FIREBASE_URL_ACTIVE_LIST = FIREBASE_URL + "/" + FIREBASE_PROPERTY_LIST_NAME;

    /**
     * Constants for bundles, extras and shared preferences keys
     */


    /**
     * Constants for Firebase login
     */
    public static final String PASSWORD_PROVIDER = "password";

}

