package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.tk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0605tk implements Jc {
    public static final boolean a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public static void b(Context context) {
        Z6 z6;
        C0580sk c0580sk = new C0580sk();
        C0555rk c0555rk = new C0555rk();
        C0357jn c0357jn = new C0357jn(c0555rk, c0555rk, new C0521qa(false), new InterfaceC0383kn() { // from class: io.appmetrica.analytics.impl.tk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0383kn
            public final boolean a(SQLiteDatabase sQLiteDatabase) {
                return C0605tk.a(sQLiteDatabase);
            }
        });
        C0755zk B = C0471oa.I.B();
        synchronized (B) {
            C0135b7 c0135b7 = B.f1235a;
            z6 = new Z6(context, new C0109a7(c0135b7.f813a, c0135b7.b, false).a(context, c0580sk), c0357jn, PublicLogger.getAnonymousInstance());
        }
        byte[] bArr = new T2(new C0556rl(z6), "binary_data").get("auto_inapp_collecting_info_data");
        if (bArr != null) {
            C0471oa.I.B().c(context).insert("auto_inapp_collecting_info_data", bArr);
        }
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final void a(Context context) {
        Sm sm = (Sm) Qm.a(C0382km.class);
        ProtobufStateStorage<Object> a2 = sm.a(context, sm.b(context));
        C0382km c0382km = (C0382km) a2.read();
        C0356jm a3 = c0382km.a(c0382km.m);
        a3.o = 0L;
        a2.save(new C0382km(a3));
        b(context);
    }
}
