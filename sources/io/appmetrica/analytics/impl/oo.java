package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class oo implements InterfaceC0301hb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0301hb
    public final String a(Context context) {
        IdentifiersResult q = new C0408lf(C0649v7.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
