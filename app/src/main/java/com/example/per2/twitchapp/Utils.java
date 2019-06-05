package com.example.per2.twitchapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

    public enum Keys {
        URL_LOGO,
        URL_BOX,
        TITLE,
        CHANNEL,
        VIEWER,
    }

    public static String getLogoUrl(String url, float density) {
        String width = String.valueOf((int) (64 * density));
        String height = String.valueOf((int) (38 * density));
        return url.replace("{width}", width).replace("{height}", height);
    }

    public static String getBoxUrl(String url, float density) {
        String width = String.valueOf((int) (152 * density));
        String height = String.valueOf((int) (218 * density));
        return url.replace("{width}", width).replace("{height}", height);
    }

    public static float getDensity(Context ctx) {
        return ctx.getResources().getDisplayMetrics().density;
    }


    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
