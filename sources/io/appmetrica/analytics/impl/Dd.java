package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Dd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Tg f444a;
    public final H0 b;
    public final Md c;

    public Dd(Tg tg, H0 h0, Md md) {
        this.f444a = tg;
        this.b = h0;
        this.c = md;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        Tg tg = this.f444a;
        H0 h0 = this.b;
        String str2 = h0.f499a;
        String str3 = h0.b;
        Integer valueOf = Integer.valueOf(h0.d);
        H0 h02 = this.b;
        Q3 q3 = new Q3(str2, str3, valueOf, h02.e, h02.c);
        Md md = this.c;
        EnumC0165cb enumC0165cb = md.b;
        G0 g0 = md.f589a;
        String str4 = g0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(g0.f.f499a);
        Set set = AbstractC0694x9.f1197a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        N3 n3 = new N3("", "", enumC0165cb.f829a, orCreatePublicLogger);
        if (str != null) {
            n3.f(str);
        }
        n3.m = bundle;
        n3.c = md.f589a.f.f;
        tg.a(q3, n3, new C0515q4(new C0124am(), new C0490p4(), null));
    }
}
