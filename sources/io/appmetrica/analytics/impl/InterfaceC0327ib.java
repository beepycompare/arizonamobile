package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ib  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0327ib extends InterfaceC0198db, InterfaceC0303hd {
    void a(Activity activity);

    /* synthetic */ void a(Location location);

    void a(AnrListener anrListener);

    void a(ExternalAttribution externalAttribution);

    void a(Mo mo);

    void a(EnumC0418m enumC0418m);

    /* synthetic */ void a(String str);

    /* synthetic */ void a(String str, String str2);

    void a(String str, boolean z);

    /* synthetic */ void a(boolean z);

    void b(Activity activity);

    @Override // io.appmetrica.analytics.impl.InterfaceC0198db
    /* synthetic */ void b(String str);

    @Override // io.appmetrica.analytics.impl.InterfaceC0198db
    /* synthetic */ void b(String str, String str2);

    /* synthetic */ void b(boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0198db
    /* synthetic */ boolean b();

    void c();

    void c(String str);

    List<String> f();
}
