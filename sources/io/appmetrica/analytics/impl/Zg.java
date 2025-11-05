package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes3.dex */
public final class Zg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f788a;
    public final InterfaceC0226el b;
    public final C0621ub c = new C0621ub();
    public final C0664w4 d = new C0664w4(new C0202dm(), new C0639v4(), null);
    public final Consumer e;

    public Zg(Context context, final InterfaceC0366k6 interfaceC0366k6, final EnumC0320ib enumC0320ib, InterfaceC0226el interfaceC0226el) {
        this.f788a = context;
        this.b = interfaceC0226el;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.Zg$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                Zg.a(EnumC0320ib.this, interfaceC0366k6, this, (C0522qb) obj);
            }
        };
    }

    public static final void a(EnumC0320ib enumC0320ib, InterfaceC0366k6 interfaceC0366k6, Zg zg, C0522qb c0522qb) {
        String str = c0522qb.h;
        X3 x3 = new X3(str, c0522qb.e, c0522qb.f, c0522qb.g, c0522qb.i);
        String str2 = c0522qb.b;
        byte[] bArr = c0522qb.f1071a;
        int i = c0522qb.c;
        HashMap hashMap = c0522qb.d;
        String str3 = c0522qb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = D9.f438a;
        U3 u3 = new U3(bArr, str2, enumC0320ib.f931a, orCreatePublicLogger);
        u3.q = hashMap;
        u3.g = i;
        u3.c = str3;
        ((Xg) interfaceC0366k6).a(x3, u3, zg.d);
    }
}
