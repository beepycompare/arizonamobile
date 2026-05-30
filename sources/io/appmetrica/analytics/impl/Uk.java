package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Uk implements InterfaceC0352jd {
    public static final boolean a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public static void b(Context context) {
        C0502p7 c0502p7;
        Tk tk = new Tk();
        Sk sk = new Sk();
        Jn jn = new Jn(sk, sk, new Sa(false), new Kn() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Kn
            public final boolean a(SQLiteDatabase sQLiteDatabase) {
                return Uk.a(sQLiteDatabase);
            }
        });
        C0128al B = Na.I.B();
        synchronized (B) {
            C0553r7 c0553r7 = B.f891a;
            c0502p7 = new C0502p7(context, new C0528q7(c0553r7.f1179a, c0553r7.b, false).a(context, tk), jn, PublicLogger.getAnonymousInstance());
        }
        byte[] bArr = new C0239f3(new Vl(c0502p7), "binary_data").get("auto_inapp_collecting_info_data");
        if (bArr != null) {
            Na.I.B().c(context).insert("auto_inapp_collecting_info_data", bArr);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0352jd
    public final void a(Context context) {
        AbstractC0621tn abstractC0621tn = (AbstractC0621tn) C0569rn.a(Lm.class);
        ProtobufStateStorage<Object> a2 = abstractC0621tn.a(context, abstractC0621tn.b(context));
        Lm lm = (Lm) a2.read();
        Km a3 = lm.a(lm.m);
        a3.o = 0L;
        a2.save(new Lm(a3));
        b(context);
    }
}
