package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class ho implements InterfaceC0213db {
    @Override // io.appmetrica.analytics.impl.InterfaceC0213db
    public final String a(Context context) {
        ProtobufStateStorage<Object> a2;
        C0299gm c0299gm;
        try {
            Om a3 = Nm.a(C0299gm.class);
            if (a3 == null || (a2 = a3.a(context, a3.c(context))) == null || (c0299gm = (C0299gm) a2.read()) == null) {
                return null;
            }
            return c0299gm.f857a;
        } catch (Throwable unused) {
            return null;
        }
    }
}
