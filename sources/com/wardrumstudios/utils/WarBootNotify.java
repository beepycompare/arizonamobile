package com.wardrumstudios.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.preference.PreferenceManager;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.Renderer;
/* loaded from: classes4.dex */
public class WarBootNotify extends Service {
    private void CreateAlarmIntent(int i, String str) {
        String[] split = str.split("\\|");
        if (split.length == 6) {
            long parseLong = Long.parseLong(split[0]);
            int parseInt = Integer.parseInt(split[1]);
            int parseInt2 = Integer.parseInt(split[2]);
            String str2 = split[3];
            String str3 = split[4];
            String str4 = split[5];
            System.currentTimeMillis();
            long currentTimeMillis = parseLong - System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                currentTimeMillis = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
            }
            Intent intent = new Intent(this, WarServiceNotifyReceiver.class);
            intent.putExtra("class", str4);
            intent.putExtra("icon", parseInt2);
            intent.putExtra("smallicon", parseInt);
            intent.putExtra("title", str2);
            intent.putExtra("message", str3);
            intent.putExtra("notifyId", i);
            ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, System.currentTimeMillis() + currentTimeMillis, PendingIntent.getBroadcast(this, i, intent, 0));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        for (int i3 = 0; i3 < 3; i3++) {
            String string = PreferenceManager.getDefaultSharedPreferences(this).getString("Alarm" + i3, "");
            if (string.length() > 10) {
                CreateAlarmIntent(i3, string);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
