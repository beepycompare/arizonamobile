package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.xk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0705xk implements Pc {
    public static final boolean a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public static void b(Context context) {
        IBinaryDataHelper f;
        C0680wk c0680wk = new C0680wk();
        C0655vk c0655vk = new C0655vk();
        C0409ln c0409ln = new C0409ln(c0655vk, c0655vk, new C0670wa(false), new InterfaceC0434mn() { // from class: io.appmetrica.analytics.impl.xk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0434mn
            public final boolean a(SQLiteDatabase sQLiteDatabase) {
                return C0705xk.a(sQLiteDatabase);
            }
        });
        C0264g7 a2 = C0264g7.a(context);
        a2.getClass();
        Context context2 = a2.e;
        C0316i7 c0316i7 = a2.p;
        byte[] bArr = new C0105a3(new C0631ul(new C0238f7(context2, new C0290h7(c0316i7.f927a, c0316i7.b, false).a(context2, c0680wk), c0409ln, PublicLogger.getAnonymousInstance())), "binary_data").get("auto_inapp_collecting_info_data");
        if (bArr != null) {
            C0264g7 a3 = C0264g7.a(context);
            synchronized (a3) {
                f = a3.f();
            }
            ((C0105a3) f).insert("auto_inapp_collecting_info_data", bArr);
            return;
        }
        int i = C0630uk.f1155a;
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final void a(Context context) {
        Vm vm = (Vm) Tm.a(C0458nm.class);
        ProtobufStateStorage<Object> a2 = vm.a(context, vm.b(context));
        C0458nm c0458nm = (C0458nm) a2.read();
        C0433mm a3 = c0458nm.a(c0458nm.m);
        a3.o = 0L;
        a2.save(new C0458nm(a3));
        b(context);
    }
}
