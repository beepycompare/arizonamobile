package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Vg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f725a;
    public final InterfaceC0149bl b;
    public final C0472ob c = new C0472ob();
    public final C0515q4 d = new C0515q4(new C0124am(), new C0490p4(), null);
    public final Consumer e;

    public Vg(Context context, final InterfaceC0211e6 interfaceC0211e6, final EnumC0165cb enumC0165cb, InterfaceC0149bl interfaceC0149bl) {
        this.f725a = context;
        this.b = interfaceC0149bl;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.Vg$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                Vg.a(EnumC0165cb.this, interfaceC0211e6, this, (C0371kb) obj);
            }
        };
    }

    public static final void a(EnumC0165cb enumC0165cb, InterfaceC0211e6 interfaceC0211e6, Vg vg, C0371kb c0371kb) {
        String str = c0371kb.h;
        Q3 q3 = new Q3(str, c0371kb.e, c0371kb.f, c0371kb.g, c0371kb.i);
        String str2 = c0371kb.b;
        byte[] bArr = c0371kb.f974a;
        int i = c0371kb.c;
        HashMap hashMap = c0371kb.d;
        String str3 = c0371kb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = AbstractC0694x9.f1197a;
        N3 n3 = new N3(bArr, str2, enumC0165cb.f829a, orCreatePublicLogger);
        n3.q = hashMap;
        n3.g = i;
        n3.c = str3;
        ((Tg) interfaceC0211e6).a(q3, n3, vg.d);
    }
}
