package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class go implements InterfaceC0205db {
    @Override // io.appmetrica.analytics.impl.InterfaceC0205db
    public final String a(Context context) {
        IdentifiersResult q = new C0309hf(C0549r7.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
