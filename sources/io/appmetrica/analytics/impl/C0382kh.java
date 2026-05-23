package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.kh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0382kh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1065a;
    public final Fl b;
    public final D6 c;
    public final Pb d = new Pb();
    public final G4 e = new G4(new Bm(), new F4(), null);
    public final Consumer f;

    public C0382kh(Context context, final InterfaceC0604t6 interfaceC0604t6, final Db db, Fl fl, D6 d6) {
        this.f1065a = context;
        this.b = fl;
        this.c = d6;
        this.f = new Consumer() { // from class: io.appmetrica.analytics.impl.kh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0382kh.a(Db.this, this, interfaceC0604t6, (Lb) obj);
            }
        };
    }

    public static final void a(Db db, C0382kh c0382kh, InterfaceC0604t6 interfaceC0604t6, Lb lb) {
        String str = lb.h;
        C0266g4 c0266g4 = new C0266g4(str, lb.e, lb.f, lb.g, lb.i);
        String str2 = lb.b;
        byte[] bArr = lb.f643a;
        int i = lb.c;
        HashMap hashMap = lb.d;
        String str3 = lb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        long a2 = ((C0608ta) c0382kh.c).a(lb);
        Set set = Q9.f727a;
        C0189d4 c0189d4 = new C0189d4(bArr, str2, db.f510a, orCreatePublicLogger);
        c0189d4.b(a2);
        c0189d4.q = hashMap;
        c0189d4.g = i;
        c0189d4.c = str3;
        ((C0330ih) interfaceC0604t6).a(c0266g4, c0189d4, c0382kh.e);
    }
}
