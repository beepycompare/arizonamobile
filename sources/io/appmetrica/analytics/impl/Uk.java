package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Uk implements InterfaceC0350jd {
    public static final boolean a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public static void b(Context context) {
        C0500p7 c0500p7;
        Tk tk = new Tk();
        Sk sk = new Sk();
        Jn jn = new Jn(sk, sk, new Sa(false), new Kn() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Kn
            public final boolean a(SQLiteDatabase sQLiteDatabase) {
                return Uk.a(sQLiteDatabase);
            }
        });
        C0126al B = Na.I.B();
        synchronized (B) {
            C0551r7 c0551r7 = B.f893a;
            c0500p7 = new C0500p7(context, new C0526q7(c0551r7.f1181a, c0551r7.b, false).a(context, tk), jn, PublicLogger.getAnonymousInstance());
        }
        byte[] bArr = new C0237f3(new Vl(c0500p7), "binary_data").get("auto_inapp_collecting_info_data");
        if (bArr != null) {
            Na.I.B().c(context).insert("auto_inapp_collecting_info_data", bArr);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jd
    public final void a(Context context) {
        AbstractC0619tn abstractC0619tn = (AbstractC0619tn) C0567rn.a(Lm.class);
        ProtobufStateStorage<Object> a2 = abstractC0619tn.a(context, abstractC0619tn.b(context));
        Lm lm = (Lm) a2.read();
        Km a3 = lm.a(lm.m);
        a3.o = 0L;
        a2.save(new Lm(a3));
        b(context);
    }
}
