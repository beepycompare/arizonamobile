package com.google.android.vending.expansion.downloader;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.collection.SieveCacheKt;
/* loaded from: classes4.dex */
class SystemFacade {
    private Context mContext;
    private NotificationManager mNotificationManager;

    public SystemFacade(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }

    public void cancelAllNotifications() {
        this.mNotificationManager.cancelAll();
    }

    public void cancelNotification(long j) {
        this.mNotificationManager.cancel((int) j);
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public Integer getActiveNetworkType() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        if (connectivityManager == null) {
            Log.w(Constants.TAG, "couldn't get connectivity manager");
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return Integer.valueOf(activeNetworkInfo.getType());
        }
        return null;
    }

    public Long getMaxBytesOverMobile() {
        return Long.valueOf((long) SieveCacheKt.NodeLinkMask);
    }

    public Long getRecommendedMaxBytesOverMobile() {
        return Long.valueOf((long) PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
    }

    public boolean isNetworkRoaming() {
        String str;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        if (connectivityManager == null) {
            str = "couldn't get connectivity manager";
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager != null) {
                return z && telephonyManager.isNetworkRoaming();
            }
            str = "couldn't get telephony manager";
        }
        Log.w(Constants.TAG, str);
        return false;
    }

    public void postNotification(long j, Notification notification) {
        this.mNotificationManager.notify((int) j, notification);
    }

    public void sendBroadcast(Intent intent) {
        this.mContext.sendBroadcast(intent);
    }

    public void startThread(Thread thread) {
        thread.start();
    }

    public boolean userOwnsPackage(int i, String str) throws PackageManager.NameNotFoundException {
        return this.mContext.getPackageManager().getApplicationInfo(str, 0).uid == i;
    }
}
