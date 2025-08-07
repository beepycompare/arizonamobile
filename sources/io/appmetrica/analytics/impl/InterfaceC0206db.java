package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.db  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0206db extends Ya, InterfaceC0182cd {
    void a(Activity activity);

    /* synthetic */ void a(Location location);

    void a(AnrListener anrListener);

    void a(ExternalAttribution externalAttribution);

    void a(Do r1);

    void a(EnumC0420m enumC0420m);

    @Override // io.appmetrica.analytics.impl.Ya
    /* synthetic */ void a(String str);

    /* synthetic */ void a(String str, String str2);

    void a(String str, boolean z);

    /* synthetic */ void a(boolean z);

    void b(Activity activity);

    void b(String str);

    @Override // io.appmetrica.analytics.impl.Ya
    /* synthetic */ void b(String str, String str2);

    /* synthetic */ void b(boolean z);

    @Override // io.appmetrica.analytics.impl.Ya
    /* synthetic */ boolean b();

    void c();

    List<String> f();
}
