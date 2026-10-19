package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0166ce implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0323ih f931a;
    public final J0 b;
    public final C0398le c;

    public C0166ce(C0323ih c0323ih, J0 j0, C0398le c0398le) {
        this.f931a = c0323ih;
        this.b = j0;
        this.c = c0398le;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0323ih c0323ih = this.f931a;
        J0 j0 = this.b;
        String str2 = j0.f607a;
        String str3 = j0.b;
        Integer valueOf = Integer.valueOf(j0.d);
        J0 j02 = this.b;
        C0259g4 c0259g4 = new C0259g4(str2, str3, valueOf, j02.e, j02.c);
        C0398le c0398le = this.c;
        Db db = c0398le.b;
        I0 i0 = c0398le.f1084a;
        String str4 = i0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(i0.f.f607a);
        long a2 = ((G6) c0398le.c).a(c0398le.f1084a);
        Set set = Q9.f733a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0182d4 c0182d4 = new C0182d4("", "", db.f516a, orCreatePublicLogger);
        c0182d4.b(a2);
        if (str != null) {
            c0182d4.f(str);
        }
        c0182d4.m = bundle;
        c0182d4.c = c0398le.f1084a.f.f;
        c0323ih.a(c0259g4, c0182d4, new G4(new Bm(), new F4(), null));
    }
}
