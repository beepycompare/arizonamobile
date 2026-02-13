package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Cd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Sg f533a;
    public final H0 b;
    public final Ld c;

    public Cd(Sg sg, H0 h0, Ld ld) {
        this.f533a = sg;
        this.b = h0;
        this.c = ld;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        Sg sg = this.f533a;
        H0 h0 = this.b;
        String str2 = h0.f605a;
        String str3 = h0.b;
        Integer valueOf = Integer.valueOf(h0.d);
        H0 h02 = this.b;
        P3 p3 = new P3(str2, str3, valueOf, h02.e, h02.c);
        Ld ld = this.c;
        EnumC0143bb enumC0143bb = ld.b;
        G0 g0 = ld.f677a;
        String str4 = g0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(g0.f.f605a);
        Set set = AbstractC0672w9.f1284a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        M3 m3 = new M3("", "", enumC0143bb.f917a, orCreatePublicLogger);
        if (str != null) {
            m3.f(str);
        }
        m3.m = bundle;
        m3.c = ld.f677a.f.f;
        sg.a(p3, m3, new C0493p4(new Zl(), new C0468o4(), null));
    }
}
