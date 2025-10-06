package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class so implements InterfaceC0379kb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0379kb
    public final String a(Context context) {
        IdentifiersResult q = new C0513pf(C0729y7.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
