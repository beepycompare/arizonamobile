package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0171ce implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0328ih f928a;
    public final J0 b;
    public final C0403le c;

    public C0171ce(C0328ih c0328ih, J0 j0, C0403le c0403le) {
        this.f928a = c0328ih;
        this.b = j0;
        this.c = c0403le;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0328ih c0328ih = this.f928a;
        J0 j0 = this.b;
        String str2 = j0.f604a;
        String str3 = j0.b;
        Integer valueOf = Integer.valueOf(j0.d);
        J0 j02 = this.b;
        C0264g4 c0264g4 = new C0264g4(str2, str3, valueOf, j02.e, j02.c);
        C0403le c0403le = this.c;
        Db db = c0403le.b;
        I0 i0 = c0403le.f1081a;
        String str4 = i0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(i0.f.f604a);
        long a2 = ((G6) c0403le.c).a(c0403le.f1081a);
        Set set = Q9.f730a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0187d4 c0187d4 = new C0187d4("", "", db.f513a, orCreatePublicLogger);
        c0187d4.b(a2);
        if (str != null) {
            c0187d4.f(str);
        }
        c0187d4.m = bundle;
        c0187d4.c = c0403le.f1081a.f.f;
        c0328ih.a(c0264g4, c0187d4, new G4(new Bm(), new F4(), null));
    }
}
