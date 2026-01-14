package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.sk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0583sk implements Ic {
    public static final boolean a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public static void b(Context context) {
        Y6 y6;
        C0558rk c0558rk = new C0558rk();
        C0534qk c0534qk = new C0534qk();
        C0335in c0335in = new C0335in(c0534qk, c0534qk, new C0499pa(false), new InterfaceC0361jn() { // from class: io.appmetrica.analytics.impl.sk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0361jn
            public final boolean a(SQLiteDatabase sQLiteDatabase) {
                return C0583sk.a(sQLiteDatabase);
            }
        });
        C0733yk B = C0449na.I.B();
        synchronized (B) {
            C0113a7 c0113a7 = B.f1324a;
            y6 = new Y6(context, new Z6(c0113a7.f901a, c0113a7.b, false).a(context, c0558rk), c0335in, PublicLogger.getAnonymousInstance());
        }
        byte[] bArr = new S2(new C0535ql(y6), "binary_data").get("auto_inapp_collecting_info_data");
        if (bArr != null) {
            C0449na.I.B().c(context).insert("auto_inapp_collecting_info_data", bArr);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ic
    public final void a(Context context) {
        Rm rm = (Rm) Pm.a(C0360jm.class);
        ProtobufStateStorage<Object> a2 = rm.a(context, rm.b(context));
        C0360jm c0360jm = (C0360jm) a2.read();
        C0334im a3 = c0360jm.a(c0360jm.m);
        a3.o = 0L;
        a2.save(new C0360jm(a3));
        b(context);
    }
}
