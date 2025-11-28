package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Jd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Xg f546a;
    public final F0 b;
    public final Sd c;

    public Jd(Xg xg, F0 f0, Sd sd) {
        this.f546a = xg;
        this.b = f0;
        this.c = sd;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        Xg xg = this.f546a;
        F0 f0 = this.b;
        String str2 = f0.f468a;
        String str3 = f0.b;
        Integer valueOf = Integer.valueOf(f0.d);
        F0 f02 = this.b;
        X3 x3 = new X3(str2, str3, valueOf, f02.e, f02.c);
        Sd sd = this.c;
        EnumC0320ib enumC0320ib = sd.b;
        E0 e0 = sd.f683a;
        String str4 = e0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(e0.f.f468a);
        Set set = D9.f438a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        U3 u3 = new U3("", "", enumC0320ib.f931a, orCreatePublicLogger);
        if (str != null) {
            u3.f(str);
        }
        u3.m = bundle;
        u3.c = sd.f683a.f.f;
        xg.a(x3, u3, new C0664w4(new C0202dm(), new C0639v4(), null));
    }
}
