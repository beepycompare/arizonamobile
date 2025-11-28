package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class oo implements Ra {
    @Override // io.appmetrica.analytics.impl.Ra
    public final String a(Context context) {
        IdentifiersResult q = new C0117af(C0264g7.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
