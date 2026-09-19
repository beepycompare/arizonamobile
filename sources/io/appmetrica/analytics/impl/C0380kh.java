package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.kh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0380kh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1068a;
    public final Fl b;
    public final D6 c;
    public final Pb d = new Pb();
    public final G4 e = new G4(new Bm(), new F4(), null);
    public final Consumer f;

    public C0380kh(Context context, final InterfaceC0602t6 interfaceC0602t6, final Db db, Fl fl, D6 d6) {
        this.f1068a = context;
        this.b = fl;
        this.c = d6;
        this.f = new Consumer() { // from class: io.appmetrica.analytics.impl.kh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0380kh.a(Db.this, this, interfaceC0602t6, (Lb) obj);
            }
        };
    }

    public static final void a(Db db, C0380kh c0380kh, InterfaceC0602t6 interfaceC0602t6, Lb lb) {
        String str = lb.h;
        C0264g4 c0264g4 = new C0264g4(str, lb.e, lb.f, lb.g, lb.i);
        String str2 = lb.b;
        byte[] bArr = lb.f646a;
        int i = lb.c;
        HashMap hashMap = lb.d;
        String str3 = lb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        long a2 = ((C0606ta) c0380kh.c).a(lb);
        Set set = Q9.f730a;
        C0187d4 c0187d4 = new C0187d4(bArr, str2, db.f513a, orCreatePublicLogger);
        c0187d4.b(a2);
        c0187d4.q = hashMap;
        c0187d4.g = i;
        c0187d4.c = str3;
        ((C0328ih) interfaceC0602t6).a(c0264g4, c0187d4, c0380kh.e);
    }
}
