package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0173ce implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0330ih f928a;
    public final J0 b;
    public final C0405le c;

    public C0173ce(C0330ih c0330ih, J0 j0, C0405le c0405le) {
        this.f928a = c0330ih;
        this.b = j0;
        this.c = c0405le;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0330ih c0330ih = this.f928a;
        J0 j0 = this.b;
        String str2 = j0.f604a;
        String str3 = j0.b;
        Integer valueOf = Integer.valueOf(j0.d);
        J0 j02 = this.b;
        C0266g4 c0266g4 = new C0266g4(str2, str3, valueOf, j02.e, j02.c);
        C0405le c0405le = this.c;
        Db db = c0405le.b;
        I0 i0 = c0405le.f1081a;
        String str4 = i0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(i0.f.f604a);
        long a2 = ((G6) c0405le.c).a(c0405le.f1081a);
        Set set = Q9.f730a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0189d4 c0189d4 = new C0189d4("", "", db.f513a, orCreatePublicLogger);
        c0189d4.b(a2);
        if (str != null) {
            c0189d4.f(str);
        }
        c0189d4.m = bundle;
        c0189d4.c = c0405le.f1081a.f.f;
        c0330ih.a(c0266g4, c0189d4, new G4(new Bm(), new F4(), null));
    }
}
