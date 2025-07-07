package com.AdX.tag;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Set;
/* loaded from: classes3.dex */
public class AdXAppTracker extends BroadcastReceiver {
    final String AdX_PREFERENCE = "AdXPrefrences";
    final String REFERRAL_URL = "InstallReferral";

    private void pass_on_broadcast(Context context, Intent intent) {
        Set<String> keySet;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageManager packageManager2 = packageManager;
                ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, AdXAppTracker.class), 128);
                if (receiverInfo == null || receiverInfo.metaData == null || (keySet = receiverInfo.metaData.keySet()) == null) {
                    return;
                }
                Set<String> set = keySet;
                String str = "";
                for (String str2 : keySet) {
                    String str3 = str2;
                    if (str2.substring(0, 20).equalsIgnoreCase("ADX_FORWARD_REFERRAL")) {
                        Log.i("AdXAppTracker", "Found Forwarding : " + str2);
                        try {
                            String str4 = str2;
                            str = receiverInfo.metaData.getString(str2);
                            ((BroadcastReceiver) Class.forName(str).newInstance()).onReceive(context, intent);
                            Log.d("AdXAppTracker", "Successfully forwarded install notification to " + str);
                        } catch (Exception unused) {
                            Log.w("AdXAppTracker", "Could not forward Market's INSTALL_REFERRER intent to " + str);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.w("AdXAppTracker", "Unhandled exception while forwarding install intents.  Possibly lost some install information.", e);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        Log.i("AdXAppTracker", "Received Referrral Intent");
        String uri = intent.toUri(0);
        if (uri != null && uri.length() > 0) {
            int indexOf = uri.indexOf("referrer=");
            if (indexOf > -1) {
                String substring = uri.substring(indexOf, uri.length() - 4);
                Log.i("AdXAppTracker", "Referral URI: " + substring);
                SharedPreferences.Editor edit = context.getSharedPreferences("AdXPrefrences", 0).edit();
                edit.putString("InstallReferral", substring);
                edit.commit();
                str = "Cached Referral URI: " + substring;
            } else {
                str = "No Referral URL.";
            }
            Log.i("AdXAppTracker", str);
        }
        AdXConnect.doBroadcastConnectInstance(context);
        pass_on_broadcast(context, intent);
        Log.i("AdXAppTracker", "End");
    }
}
