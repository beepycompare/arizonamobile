package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import java.util.List;
/* loaded from: classes3.dex */
public interface Pa extends Ka, Oc {
    void a(Activity activity);

    /* synthetic */ void a(Location location);

    void a(AnrListener anrListener);

    void a(ExternalAttribution externalAttribution);

    void a(Io io2);

    void a(EnumC0435n enumC0435n);

    /* synthetic */ void a(String str);

    /* synthetic */ void a(String str, String str2);

    void a(String str, boolean z);

    /* synthetic */ void a(boolean z);

    /* synthetic */ void a(boolean z, boolean z2);

    void b(Activity activity);

    @Override // io.appmetrica.analytics.impl.Ka
    /* synthetic */ void b(String str);

    @Override // io.appmetrica.analytics.impl.Ka
    /* synthetic */ void b(String str, String str2);

    @Override // io.appmetrica.analytics.impl.Ka
    /* synthetic */ boolean b();

    void c();

    void c(String str);

    List<String> f();
}
