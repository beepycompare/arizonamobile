package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Xd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0488oh f742a;
    public final E0 b;
    public final C0278ge c;

    public Xd(C0488oh c0488oh, E0 e0, C0278ge c0278ge) {
        this.f742a = c0488oh;
        this.b = e0;
        this.c = c0278ge;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0488oh c0488oh = this.f742a;
        E0 e0 = this.b;
        String str2 = e0.f419a;
        String str3 = e0.b;
        Integer valueOf = Integer.valueOf(e0.d);
        E0 e02 = this.b;
        C0475o4 c0475o4 = new C0475o4(str2, str3, valueOf, e02.e, e02.c);
        C0278ge c0278ge = this.c;
        Bb bb = c0278ge.b;
        D0 d0 = c0278ge.f895a;
        String str4 = d0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(d0.f.f419a);
        Set set = W9.f725a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0397l4 c0397l4 = new C0397l4("", "", bb.f368a, orCreatePublicLogger);
        if (str != null) {
            c0397l4.f(str);
        }
        c0397l4.m = bundle;
        c0397l4.c = c0278ge.f895a.f.f;
        c0488oh.a(c0475o4, c0397l4, new N4(new C0337im(), new M4(), null));
    }
}
