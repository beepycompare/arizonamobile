package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.kh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0375kh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1071a;
    public final Fl b;
    public final D6 c;
    public final Pb d = new Pb();
    public final G4 e = new G4(new Bm(), new F4(), null);
    public final Consumer f;

    public C0375kh(Context context, final InterfaceC0597t6 interfaceC0597t6, final Db db, Fl fl, D6 d6) {
        this.f1071a = context;
        this.b = fl;
        this.c = d6;
        this.f = new Consumer() { // from class: io.appmetrica.analytics.impl.kh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0375kh.a(Db.this, this, interfaceC0597t6, (Lb) obj);
            }
        };
    }

    public static final void a(Db db, C0375kh c0375kh, InterfaceC0597t6 interfaceC0597t6, Lb lb) {
        String str = lb.h;
        C0259g4 c0259g4 = new C0259g4(str, lb.e, lb.f, lb.g, lb.i);
        String str2 = lb.b;
        byte[] bArr = lb.f649a;
        int i = lb.c;
        HashMap hashMap = lb.d;
        String str3 = lb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        long a2 = ((C0601ta) c0375kh.c).a(lb);
        Set set = Q9.f733a;
        C0182d4 c0182d4 = new C0182d4(bArr, str2, db.f516a, orCreatePublicLogger);
        c0182d4.b(a2);
        c0182d4.q = hashMap;
        c0182d4.g = i;
        c0182d4.c = str3;
        ((C0323ih) interfaceC0597t6).a(c0259g4, c0182d4, c0375kh.e);
    }
}
