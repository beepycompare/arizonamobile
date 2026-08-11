package com.wardrumstudios.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes4.dex */
public class WarServiceNotifyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("title");
        String string2 = extras.getString("subject");
        String string3 = extras.getString("message");
        int i = extras.getInt("icon");
        int i2 = extras.getInt("smallicon");
        int i3 = extras.getInt("notifyId");
        String string4 = extras.getString("class");
        Intent intent2 = new Intent(context, WarServiceNotifyAlarm.class);
        intent2.putExtra("title", string);
        intent2.putExtra("subject", string2);
        intent2.putExtra("message", string3);
        intent2.putExtra("icon", i);
        intent2.putExtra("smallicon", i2);
        intent2.putExtra("class", string4);
        intent2.putExtra("notifyId", i3);
        context.startService(intent2);
    }
}
