package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Td implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0384kh f661a;
    public final C0 b;
    public final C0175ce c;

    public Td(C0384kh c0384kh, C0 c0, C0175ce c0175ce) {
        this.f661a = c0384kh;
        this.b = c0;
        this.c = c0175ce;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0384kh c0384kh = this.f661a;
        C0 c0 = this.b;
        String str2 = c0.f370a;
        String str3 = c0.b;
        Integer valueOf = Integer.valueOf(c0.d);
        C0 c02 = this.b;
        C0397l4 c0397l4 = new C0397l4(str2, str3, valueOf, c02.e, c02.c);
        C0175ce c0175ce = this.c;
        EnumC0728yb enumC0728yb = c0175ce.b;
        B0 b0 = c0175ce.f811a;
        String str4 = b0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(b0.f.f370a);
        Set set = T9.f659a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0320i4 c0320i4 = new C0320i4("", "", enumC0728yb.f1157a, orCreatePublicLogger);
        if (str != null) {
            c0320i4.f(str);
        }
        c0320i4.m = bundle;
        c0320i4.c = c0175ce.f811a.f.f;
        c0384kh.a(c0397l4, c0320i4, new K4(new C0234em(), new J4(), null));
    }
}
