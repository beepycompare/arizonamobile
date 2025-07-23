package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class jo implements InterfaceC0256fb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0256fb
    public final String a(Context context) {
        IdentifiersResult q = new C0360jf(C0626u7.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
