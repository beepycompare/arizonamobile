package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.sk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0582sk implements Ic {
    public static final boolean a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public static void b(Context context) {
        Y6 y6;
        C0557rk c0557rk = new C0557rk();
        C0533qk c0533qk = new C0533qk();
        C0334in c0334in = new C0334in(c0533qk, c0533qk, new C0498pa(false), new InterfaceC0360jn() { // from class: io.appmetrica.analytics.impl.sk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0360jn
            public final boolean a(SQLiteDatabase sQLiteDatabase) {
                return C0582sk.a(sQLiteDatabase);
            }
        });
        C0732yk B = C0448na.I.B();
        synchronized (B) {
            C0112a7 c0112a7 = B.f1328a;
            y6 = new Y6(context, new Z6(c0112a7.f905a, c0112a7.b, false).a(context, c0557rk), c0334in, PublicLogger.getAnonymousInstance());
        }
        byte[] bArr = new S2(new C0534ql(y6), "binary_data").get("auto_inapp_collecting_info_data");
        if (bArr != null) {
            C0448na.I.B().c(context).insert("auto_inapp_collecting_info_data", bArr);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ic
    public final void a(Context context) {
        Rm rm = (Rm) Pm.a(C0359jm.class);
        ProtobufStateStorage<Object> a2 = rm.a(context, rm.b(context));
        C0359jm c0359jm = (C0359jm) a2.read();
        C0333im a3 = c0359jm.a(c0359jm.m);
        a3.o = 0L;
        a2.save(new C0359jm(a3));
        b(context);
    }
}
