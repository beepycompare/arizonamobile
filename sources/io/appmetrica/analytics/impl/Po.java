package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class Po implements InterfaceC0428mb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0428mb
    public final String a(Context context) {
        IdentifiersResult q = C0576s4.l().b(context).q();
        if (StringUtils.isNullOrEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
