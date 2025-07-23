package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.hh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0313hh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f886a;
    public final InterfaceC0137al b;
    public final Ib c = new Ib();
    public final K4 d = new K4(new Zl(), new J4(), null);
    public final Consumer e;

    public C0313hh(Context context, final InterfaceC0750z6 interfaceC0750z6, final EnumC0680wb enumC0680wb, InterfaceC0137al interfaceC0137al) {
        this.f886a = context;
        this.b = interfaceC0137al;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.hh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0313hh.a(EnumC0680wb.this, interfaceC0750z6, this, (Eb) obj);
            }
        };
    }

    public static final void a(EnumC0680wb enumC0680wb, InterfaceC0750z6 interfaceC0750z6, C0313hh c0313hh, Eb eb) {
        String str = eb.h;
        C0399l4 c0399l4 = new C0399l4(str, eb.e, eb.f, eb.g, eb.i);
        String str2 = eb.b;
        byte[] bArr = eb.f415a;
        int i = eb.c;
        HashMap hashMap = eb.d;
        String str3 = eb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = R9.f620a;
        C0325i4 c0325i4 = new C0325i4(bArr, str2, enumC0680wb.f1119a, orCreatePublicLogger);
        c0325i4.q = hashMap;
        c0325i4.g = i;
        c0325i4.c = str3;
        ((C0262fh) interfaceC0750z6).a(c0399l4, c0325i4, c0313hh.d);
    }
}
