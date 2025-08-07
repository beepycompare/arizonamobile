package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.hh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0314hh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f886a;
    public final InterfaceC0138al b;
    public final Ib c = new Ib();
    public final K4 d = new K4(new Zl(), new J4(), null);
    public final Consumer e;

    public C0314hh(Context context, final InterfaceC0751z6 interfaceC0751z6, final EnumC0681wb enumC0681wb, InterfaceC0138al interfaceC0138al) {
        this.f886a = context;
        this.b = interfaceC0138al;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.hh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0314hh.a(EnumC0681wb.this, interfaceC0751z6, this, (Eb) obj);
            }
        };
    }

    public static final void a(EnumC0681wb enumC0681wb, InterfaceC0751z6 interfaceC0751z6, C0314hh c0314hh, Eb eb) {
        String str = eb.h;
        C0400l4 c0400l4 = new C0400l4(str, eb.e, eb.f, eb.g, eb.i);
        String str2 = eb.b;
        byte[] bArr = eb.f415a;
        int i = eb.c;
        HashMap hashMap = eb.d;
        String str3 = eb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = R9.f620a;
        C0326i4 c0326i4 = new C0326i4(bArr, str2, enumC0681wb.f1119a, orCreatePublicLogger);
        c0326i4.q = hashMap;
        c0326i4.g = i;
        c0326i4.c = str3;
        ((C0263fh) interfaceC0751z6).a(c0400l4, c0326i4, c0314hh.d);
    }
}
