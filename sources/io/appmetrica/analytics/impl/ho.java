package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class ho implements InterfaceC0205db {
    @Override // io.appmetrica.analytics.impl.InterfaceC0205db
    public final String a(Context context) {
        ProtobufStateStorage<Object> a2;
        C0291gm c0291gm;
        try {
            Om a3 = Nm.a(C0291gm.class);
            if (a3 == null || (a2 = a3.a(context, a3.c(context))) == null || (c0291gm = (C0291gm) a2.read()) == null) {
                return null;
            }
            return c0291gm.f858a;
        } catch (Throwable unused) {
            return null;
        }
    }
}
