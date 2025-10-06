package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.z1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0748z1 {
    /* synthetic */ void a(Intent intent);

    /* synthetic */ void a(Intent intent, int i);

    /* synthetic */ void a(Intent intent, int i, int i2);

    void a(InterfaceC0723y1 interfaceC0723y1);

    /* synthetic */ void b(Intent intent);

    /* synthetic */ void c(Intent intent);

    /* synthetic */ void onConfigurationChanged(Configuration configuration);

    /* synthetic */ void onCreate();

    /* synthetic */ void onDestroy();

    void pauseUserSession(Bundle bundle);

    void reportData(int i, Bundle bundle);

    void resumeUserSession(Bundle bundle);
}
