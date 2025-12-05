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
    public final Context f808a;
    public final InterfaceC0148bl b;
    public final C0471ob c = new C0471ob();
    public final C0514q4 d = new C0514q4(new C0123am(), new C0489p4(), null);
    public final Consumer e;

    public Vg(Context context, final InterfaceC0210e6 interfaceC0210e6, final EnumC0164cb enumC0164cb, InterfaceC0148bl interfaceC0148bl) {
        this.f808a = context;
        this.b = interfaceC0148bl;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.Vg$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                Vg.a(EnumC0164cb.this, interfaceC0210e6, this, (C0370kb) obj);
            }
        };
    }

    public static final void a(EnumC0164cb enumC0164cb, InterfaceC0210e6 interfaceC0210e6, Vg vg, C0370kb c0370kb) {
        String str = c0370kb.h;
        Q3 q3 = new Q3(str, c0370kb.e, c0370kb.f, c0370kb.g, c0370kb.i);
        String str2 = c0370kb.b;
        byte[] bArr = c0370kb.f1057a;
        int i = c0370kb.c;
        HashMap hashMap = c0370kb.d;
        String str3 = c0370kb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = AbstractC0693x9.f1280a;
        N3 n3 = new N3(bArr, str2, enumC0164cb.f912a, orCreatePublicLogger);
        n3.q = hashMap;
        n3.g = i;
        n3.c = str3;
        ((Tg) interfaceC0210e6).a(q3, n3, vg.d);
    }
}
