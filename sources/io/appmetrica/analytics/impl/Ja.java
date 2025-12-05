package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import java.util.List;
/* loaded from: classes5.dex */
public interface Ja extends Ea, Ic {
    void a(Activity activity);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(Location location);

    void a(AnrListener anrListener);

    void a(ExternalAttribution externalAttribution);

    void a(Io io2);

    void a(EnumC0434n enumC0434n);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(String str);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(String str, String str2);

    void a(String str, boolean z);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(boolean z);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(boolean z, boolean z2);

    void b(Activity activity);

    @Override // io.appmetrica.analytics.impl.Ea
    /* synthetic */ void b(String str);

    @Override // io.appmetrica.analytics.impl.Ea
    /* synthetic */ void b(String str, String str2);

    @Override // io.appmetrica.analytics.impl.Ea
    /* synthetic */ boolean b();

    void c();

    void c(String str);

    List<String> f();
}
