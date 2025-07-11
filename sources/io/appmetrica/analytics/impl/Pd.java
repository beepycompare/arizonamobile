package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Pd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0211dh f581a;
    public final C0 b;
    public final Yd c;

    public Pd(C0211dh c0211dh, C0 c0, Yd yd) {
        this.f581a = c0211dh;
        this.b = c0;
        this.c = yd;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0211dh c0211dh = this.f581a;
        C0 c0 = this.b;
        String str2 = c0.f363a;
        String str3 = c0.b;
        Integer valueOf = Integer.valueOf(c0.d);
        C0 c02 = this.b;
        C0397l4 c0397l4 = new C0397l4(str2, str3, valueOf, c02.e, c02.c);
        Yd yd = this.c;
        EnumC0628ub enumC0628ub = yd.b;
        B0 b0 = yd.f722a;
        String str4 = b0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(b0.f.f363a);
        Set set = O9.f565a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0323i4 c0323i4 = new C0323i4("", "", enumC0628ub.f1074a, orCreatePublicLogger);
        if (str != null) {
            c0323i4.f(str);
        }
        c0323i4.m = bundle;
        c0323i4.c = yd.f722a.f.f;
        c0211dh.a(c0397l4, c0323i4, new K4(new Wl(), new J4(), null));
    }
}
