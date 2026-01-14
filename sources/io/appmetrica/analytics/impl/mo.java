package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class mo implements Ka {
    @Override // io.appmetrica.analytics.impl.Ka
    public final String a(Context context) {
        IdentifiersResult q = new Ve(C0136b4.l().c(context).a(context)).q();
        if (TextUtils.isEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
