package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.tk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0604tk implements Jc {
    public static final boolean a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public static void b(Context context) {
        Z6 z6;
        C0579sk c0579sk = new C0579sk();
        C0554rk c0554rk = new C0554rk();
        C0356jn c0356jn = new C0356jn(c0554rk, c0554rk, new C0520qa(false), new InterfaceC0382kn() { // from class: io.appmetrica.analytics.impl.tk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0382kn
            public final boolean a(SQLiteDatabase sQLiteDatabase) {
                return C0604tk.a(sQLiteDatabase);
            }
        });
        C0754zk B = C0470oa.I.B();
        synchronized (B) {
            C0134b7 c0134b7 = B.f1333a;
            z6 = new Z6(context, new C0108a7(c0134b7.f911a, c0134b7.b, false).a(context, c0579sk), c0356jn, PublicLogger.getAnonymousInstance());
        }
        byte[] bArr = new T2(new C0555rl(z6), "binary_data").get("auto_inapp_collecting_info_data");
        if (bArr != null) {
            C0470oa.I.B().c(context).insert("auto_inapp_collecting_info_data", bArr);
        }
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final void a(Context context) {
        Sm sm = (Sm) Qm.a(C0381km.class);
        ProtobufStateStorage<Object> a2 = sm.a(context, sm.b(context));
        C0381km c0381km = (C0381km) a2.read();
        C0355jm a3 = c0381km.a(c0381km.m);
        a3.o = 0L;
        a2.save(new C0381km(a3));
        b(context);
    }
}
