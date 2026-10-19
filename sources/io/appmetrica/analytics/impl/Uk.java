package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Uk implements InterfaceC0345jd {
    public static final boolean a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public static void b(Context context) {
        C0495p7 c0495p7;
        Tk tk = new Tk();
        Sk sk = new Sk();
        Jn jn = new Jn(sk, sk, new Sa(false), new Kn() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Kn
            public final boolean a(SQLiteDatabase sQLiteDatabase) {
                return Uk.a(sQLiteDatabase);
            }
        });
        C0121al B = Na.I.B();
        synchronized (B) {
            C0546r7 c0546r7 = B.f896a;
            c0495p7 = new C0495p7(context, new C0521q7(c0546r7.f1184a, c0546r7.b, false).a(context, tk), jn, PublicLogger.getAnonymousInstance());
        }
        byte[] bArr = new C0232f3(new Vl(c0495p7), "binary_data").get("auto_inapp_collecting_info_data");
        if (bArr != null) {
            Na.I.B().c(context).insert("auto_inapp_collecting_info_data", bArr);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0345jd
    public final void a(Context context) {
        AbstractC0614tn abstractC0614tn = (AbstractC0614tn) C0562rn.a(Lm.class);
        ProtobufStateStorage<Object> a2 = abstractC0614tn.a(context, abstractC0614tn.b(context));
        Lm lm = (Lm) a2.read();
        Km a3 = lm.a(lm.m);
        a3.o = 0L;
        a2.save(new Lm(a3));
        b(context);
    }
}
