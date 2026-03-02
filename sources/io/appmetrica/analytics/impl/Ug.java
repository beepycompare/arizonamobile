package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Ug {

    /* renamed from: a  reason: collision with root package name */
    public final Context f813a;
    public final InterfaceC0126al b;
    public final C0449nb c = new C0449nb();
    public final C0492p4 d = new C0492p4(new Zl(), new C0467o4(), null);
    public final Consumer e;

    public Ug(Context context, final InterfaceC0189d6 interfaceC0189d6, final EnumC0142bb enumC0142bb, InterfaceC0126al interfaceC0126al) {
        this.f813a = context;
        this.b = interfaceC0126al;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.Ug$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                Ug.a(EnumC0142bb.this, interfaceC0189d6, this, (C0348jb) obj);
            }
        };
    }

    public static final void a(EnumC0142bb enumC0142bb, InterfaceC0189d6 interfaceC0189d6, Ug ug, C0348jb c0348jb) {
        String str = c0348jb.h;
        P3 p3 = new P3(str, c0348jb.e, c0348jb.f, c0348jb.g, c0348jb.i);
        String str2 = c0348jb.b;
        byte[] bArr = c0348jb.f1061a;
        int i = c0348jb.c;
        HashMap hashMap = c0348jb.d;
        String str3 = c0348jb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = AbstractC0671w9.f1284a;
        M3 m3 = new M3(bArr, str2, enumC0142bb.f917a, orCreatePublicLogger);
        m3.q = hashMap;
        m3.g = i;
        m3.c = str3;
        ((Sg) interfaceC0189d6).a(p3, m3, ug.d);
    }
}
