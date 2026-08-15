package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.kb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0375kb extends InterfaceC0246fb, InterfaceC0326id {
    void a(Activity activity);

    /* synthetic */ void a(Location location);

    void a(AnrListener anrListener);

    void a(ExternalAttribution externalAttribution);

    void a(lp lpVar);

    void a(EnumC0441n enumC0441n);

    /* synthetic */ void a(String str);

    /* synthetic */ void a(String str, String str2);

    void a(String str, boolean z);

    /* synthetic */ void a(boolean z);

    /* synthetic */ void a(boolean z, boolean z2);

    void b(Activity activity);

    @Override // io.appmetrica.analytics.impl.InterfaceC0246fb
    /* synthetic */ void b(String str);

    @Override // io.appmetrica.analytics.impl.InterfaceC0246fb
    /* synthetic */ void b(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC0246fb
    /* synthetic */ boolean b();

    void c();

    List<String> f();
}
