package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.x1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0693x1 {
    /* synthetic */ void a(Intent intent);

    /* synthetic */ void a(Intent intent, int i);

    /* synthetic */ void a(Intent intent, int i, int i2);

    void a(InterfaceC0668w1 interfaceC0668w1);

    /* synthetic */ void b(Intent intent);

    /* synthetic */ void c(Intent intent);

    /* synthetic */ void onConfigurationChanged(Configuration configuration);

    /* synthetic */ void onCreate();

    /* synthetic */ void onDestroy();

    void pauseUserSession(Bundle bundle);

    void reportData(int i, Bundle bundle);

    void resumeUserSession(Bundle bundle);
}
