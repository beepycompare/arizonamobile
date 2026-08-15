package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0172ce implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0329ih f928a;
    public final J0 b;
    public final C0404le c;

    public C0172ce(C0329ih c0329ih, J0 j0, C0404le c0404le) {
        this.f928a = c0329ih;
        this.b = j0;
        this.c = c0404le;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0329ih c0329ih = this.f928a;
        J0 j0 = this.b;
        String str2 = j0.f604a;
        String str3 = j0.b;
        Integer valueOf = Integer.valueOf(j0.d);
        J0 j02 = this.b;
        C0265g4 c0265g4 = new C0265g4(str2, str3, valueOf, j02.e, j02.c);
        C0404le c0404le = this.c;
        Db db = c0404le.b;
        I0 i0 = c0404le.f1081a;
        String str4 = i0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(i0.f.f604a);
        long a2 = ((G6) c0404le.c).a(c0404le.f1081a);
        Set set = Q9.f730a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0188d4 c0188d4 = new C0188d4("", "", db.f513a, orCreatePublicLogger);
        c0188d4.b(a2);
        if (str != null) {
            c0188d4.f(str);
        }
        c0188d4.m = bundle;
        c0188d4.c = c0404le.f1081a.f.f;
        c0329ih.a(c0265g4, c0188d4, new G4(new Bm(), new F4(), null));
    }
}
