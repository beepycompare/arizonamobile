package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Pd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0219dh f580a;
    public final C0 b;
    public final Yd c;

    public Pd(C0219dh c0219dh, C0 c0, Yd yd) {
        this.f580a = c0219dh;
        this.b = c0;
        this.c = yd;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0219dh c0219dh = this.f580a;
        C0 c0 = this.b;
        String str2 = c0.f362a;
        String str3 = c0.b;
        Integer valueOf = Integer.valueOf(c0.d);
        C0 c02 = this.b;
        C0405l4 c0405l4 = new C0405l4(str2, str3, valueOf, c02.e, c02.c);
        Yd yd = this.c;
        EnumC0636ub enumC0636ub = yd.b;
        B0 b0 = yd.f721a;
        String str4 = b0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(b0.f.f362a);
        Set set = O9.f564a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0331i4 c0331i4 = new C0331i4("", "", enumC0636ub.f1073a, orCreatePublicLogger);
        if (str != null) {
            c0331i4.f(str);
        }
        c0331i4.m = bundle;
        c0331i4.c = yd.f721a.f.f;
        c0219dh.a(c0405l4, c0331i4, new K4(new Wl(), new J4(), null));
    }
}
