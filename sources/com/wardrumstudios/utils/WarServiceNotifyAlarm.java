package com.wardrumstudios.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import androidx.media3.common.C;
/* loaded from: classes4.dex */
public class WarServiceNotifyAlarm extends Service {
    public int icon;
    private NotificationManager mManager;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Intent intent2;
        super.onStart(intent, i);
        Bundle extras = intent.getExtras();
        String string = extras.getString("title");
        extras.getString("subject");
        String string2 = extras.getString("message");
        int i2 = extras.getInt("icon");
        int i3 = extras.getInt("smallicon");
        int i4 = extras.getInt("notifyId");
        String string3 = extras.getString("class");
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
        edit.remove("Alarm" + i4);
        edit.commit();
        Resources resources = getApplicationContext().getResources();
        Context applicationContext = getApplicationContext();
        getApplicationContext();
        this.mManager = (NotificationManager) applicationContext.getSystemService("notification");
        try {
            intent2 = new Intent(getApplicationContext(), Class.forName(string3));
        } catch (ClassNotFoundException unused) {
            intent2 = new Intent();
        }
        intent2.addFlags(603979776);
        this.mManager.notify(i4, new Notification.Builder(this).setContentTitle(string).setContentText(string2).setSmallIcon(i3).setLargeIcon(BitmapFactory.decodeResource(resources, i2)).setAutoCancel(true).setDefaults(4).setTicker(string2).setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, intent2, C.BUFFER_FLAG_FIRST_SAMPLE)).build());
        if (WarService.myWarService != null) {
            WarService.myWarService.UpdateBadgeReceiver(true, string3);
        }
    }
}
