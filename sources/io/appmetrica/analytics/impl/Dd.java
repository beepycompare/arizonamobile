package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Dd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Tg f527a;
    public final H0 b;
    public final Md c;

    public Dd(Tg tg, H0 h0, Md md) {
        this.f527a = tg;
        this.b = h0;
        this.c = md;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        Tg tg = this.f527a;
        H0 h0 = this.b;
        String str2 = h0.f582a;
        String str3 = h0.b;
        Integer valueOf = Integer.valueOf(h0.d);
        H0 h02 = this.b;
        Q3 q3 = new Q3(str2, str3, valueOf, h02.e, h02.c);
        Md md = this.c;
        EnumC0164cb enumC0164cb = md.b;
        G0 g0 = md.f672a;
        String str4 = g0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(g0.f.f582a);
        Set set = AbstractC0693x9.f1280a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        N3 n3 = new N3("", "", enumC0164cb.f912a, orCreatePublicLogger);
        if (str != null) {
            n3.f(str);
        }
        n3.m = bundle;
        n3.c = md.f672a.f.f;
        tg.a(q3, n3, new C0514q4(new C0123am(), new C0489p4(), null));
    }
}
