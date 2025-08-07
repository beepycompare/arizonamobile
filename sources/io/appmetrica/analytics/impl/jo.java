package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class jo implements InterfaceC0257fb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0257fb
    public final String a(Context context) {
        IdentifiersResult q = new C0361jf(C0627u7.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
