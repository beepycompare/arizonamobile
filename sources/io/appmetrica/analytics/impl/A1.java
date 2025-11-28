package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
/* loaded from: classes5.dex */
public interface A1 {
    /* synthetic */ void a(Intent intent);

    /* synthetic */ void a(Intent intent, int i);

    /* synthetic */ void a(Intent intent, int i, int i2);

    void a(InterfaceC0736z1 interfaceC0736z1);

    /* synthetic */ void b(Intent intent);

    /* synthetic */ void c(Intent intent);

    /* synthetic */ void onConfigurationChanged(Configuration configuration);

    /* synthetic */ void onCreate();

    /* synthetic */ void onDestroy();

    void pauseUserSession(Bundle bundle);

    void reportData(int i, Bundle bundle);

    void resumeUserSession(Bundle bundle);
}
