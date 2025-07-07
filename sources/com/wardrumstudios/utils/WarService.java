package com.wardrumstudios.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class WarService {
    private static final String TAG = "WarService";
    public static WarService myWarService;
    public boolean done;
    public int icon;
    private String intentClass;
    NotificationCompat.Builder mBuilder;
    NotificationManager mNotifyManager;
    private ArrayList<WarNotification> notifications;
    private boolean runOnce = true;
    public int smallicon;
    public Activity warActivity;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class WarNotification {
        public long epochTime;
        public int icon;
        public String message;
        public int smallicon;
        public String title;

        public WarNotification(int i, String str, String str2, int i2, int i3) {
            this.epochTime = System.currentTimeMillis() + (i * 1000);
            this.title = str;
            this.message = str2;
            this.icon = i2;
            this.smallicon = i3;
        }
    }

    public WarService(Activity activity) {
        this.warActivity = null;
        this.warActivity = activity;
        jniWarService();
        this.intentClass = activity.getClass().getCanonicalName();
        this.notifications = new ArrayList<>();
        this.done = true;
        myWarService = this;
    }

    private Intent CreateIntent(String str, String str2) {
        Intent intent = new Intent(this.warActivity, WarServiceNotifyReceiver.class);
        intent.putExtra("class", this.intentClass);
        intent.putExtra("icon", this.icon);
        intent.putExtra("smallicon", this.smallicon);
        intent.putExtra("title", str);
        intent.putExtra("message", str2);
        intent.putExtra("notifyId", this.notifications.size());
        return intent;
    }

    private WarNotification CreateNotification(int i, String str, String str2, int i2, int i3) {
        WarNotification warNotification = new WarNotification(i, str, str2, i2, i3);
        this.notifications.size();
        this.notifications.add(warNotification);
        return warNotification;
    }

    public void LocalPushNotification(final int i, String str, String str2) {
        final int size = this.notifications.size();
        final Intent CreateIntent = CreateIntent(str, str2);
        WarNotification CreateNotification = CreateNotification(i, str, str2, this.icon, this.smallicon);
        String str3 = ((((String.valueOf(CreateNotification.epochTime) + "|" + String.valueOf(this.smallicon)) + "|" + String.valueOf(this.icon)) + "|" + str) + "|" + str2) + "|" + this.intentClass;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.warActivity).edit();
        edit.putString("Alarm" + size, str3);
        edit.commit();
        this.done = false;
        this.warActivity.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarService.1
            @Override // java.lang.Runnable
            public void run() {
                ((AlarmManager) WarService.this.warActivity.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(2, SystemClock.elapsedRealtime() + (i * 1000), PendingIntent.getBroadcast(WarService.this.warActivity, size, CreateIntent, 0));
                WarService.this.done = true;
            }
        });
        while (!this.done) {
            Thread.yield();
        }
    }

    public void LocalPushNotificationCancel() {
        ((NotificationManager) this.warActivity.getSystemService("notification")).cancelAll();
        Intent CreateIntent = CreateIntent("", "");
        for (int i = 0; i < 10; i++) {
            PendingIntent broadcast = PendingIntent.getBroadcast(this.warActivity, i, CreateIntent, 0);
            broadcast.cancel();
            ((AlarmManager) this.warActivity.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(broadcast);
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.warActivity).edit();
            edit.remove("Alarm" + i);
            edit.commit();
        }
        this.notifications.clear();
        UpdateBadgeReceiver(false, this.intentClass);
    }

    public void UpdateBadgeReceiver(boolean z, String str) {
        if (Build.MANUFACTURER.equals("Sony")) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
                intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", str);
                intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", "1");
                intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", this.warActivity.getPackageName());
                intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", z);
                this.warActivity.sendBroadcast(intent);
            } catch (Exception unused) {
            }
        }
        if (Build.MANUFACTURER.equals("HTC")) {
            try {
                Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
                intent2.putExtra("packagename", this.warActivity.getPackageName());
                intent2.putExtra("count", 1);
                this.warActivity.sendBroadcast(intent2);
                Intent intent3 = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
                intent3.putExtra("com.htc.launcher.extra.COMPONENT", new ComponentName(this.warActivity, str).flattenToShortString());
                intent3.putExtra("com.htc.launcher.extra.COUNT", 1);
                this.warActivity.sendBroadcast(intent3);
            } catch (Exception unused2) {
            }
        }
        try {
            Cursor query = this.warActivity.getContentResolver().query(Uri.parse("content://com.sec.badge/apps"), null, null, null, null);
            if (query != null) {
                query.close();
                if (!z) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("badgecount", (Integer) 0);
                    this.warActivity.getContentResolver().update(Uri.parse("content://com.sec.badge/apps"), contentValues, "package=?", new String[]{this.warActivity.getPackageName()});
                    return;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("package", this.warActivity.getPackageName());
                contentValues2.put("class", str);
                contentValues2.put("badgecount", (Integer) 1);
                this.warActivity.getContentResolver().insert(Uri.parse("content://com.sec.badge/apps"), contentValues2);
            }
        } catch (Exception unused3) {
        }
    }

    public native void jniWarService();
}
