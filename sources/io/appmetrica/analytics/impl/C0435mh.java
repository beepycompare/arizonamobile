package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.mh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0435mh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f969a;
    public final InterfaceC0259fl b;
    public final Kb c = new Kb();
    public final K4 d = new K4(new C0234em(), new J4(), null);
    public final Consumer e;

    public C0435mh(Context context, final InterfaceC0748z6 interfaceC0748z6, final EnumC0728yb enumC0728yb, InterfaceC0259fl interfaceC0259fl) {
        this.f969a = context;
        this.b = interfaceC0259fl;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.mh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0435mh.a(EnumC0728yb.this, interfaceC0748z6, this, (Gb) obj);
            }
        };
    }

    public static final void a(EnumC0728yb enumC0728yb, InterfaceC0748z6 interfaceC0748z6, C0435mh c0435mh, Gb gb) {
        String str = gb.h;
        C0397l4 c0397l4 = new C0397l4(str, gb.e, gb.f, gb.g, gb.i);
        String str2 = gb.b;
        byte[] bArr = gb.f454a;
        int i = gb.c;
        HashMap hashMap = gb.d;
        String str3 = gb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = T9.f659a;
        C0320i4 c0320i4 = new C0320i4(bArr, str2, enumC0728yb.f1157a, orCreatePublicLogger);
        c0320i4.q = hashMap;
        c0320i4.g = i;
        c0320i4.c = str3;
        ((C0384kh) interfaceC0748z6).a(c0397l4, c0320i4, c0435mh.d);
    }
}
