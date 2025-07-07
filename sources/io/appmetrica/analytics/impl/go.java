package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class go implements InterfaceC0213db {
    @Override // io.appmetrica.analytics.impl.InterfaceC0213db
    public final String a(Context context) {
        IdentifiersResult q = new C0317hf(C0557r7.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
