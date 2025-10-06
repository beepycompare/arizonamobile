package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Xd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0489oh f743a;
    public final E0 b;
    public final C0279ge c;

    public Xd(C0489oh c0489oh, E0 e0, C0279ge c0279ge) {
        this.f743a = c0489oh;
        this.b = e0;
        this.c = c0279ge;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0489oh c0489oh = this.f743a;
        E0 e0 = this.b;
        String str2 = e0.f420a;
        String str3 = e0.b;
        Integer valueOf = Integer.valueOf(e0.d);
        E0 e02 = this.b;
        C0476o4 c0476o4 = new C0476o4(str2, str3, valueOf, e02.e, e02.c);
        C0279ge c0279ge = this.c;
        Bb bb = c0279ge.b;
        D0 d0 = c0279ge.f896a;
        String str4 = d0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(d0.f.f420a);
        Set set = W9.f726a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0398l4 c0398l4 = new C0398l4("", "", bb.f369a, orCreatePublicLogger);
        if (str != null) {
            c0398l4.f(str);
        }
        c0398l4.m = bundle;
        c0398l4.c = c0279ge.f896a.f.f;
        c0489oh.a(c0476o4, c0398l4, new N4(new C0338im(), new M4(), null));
    }
}
