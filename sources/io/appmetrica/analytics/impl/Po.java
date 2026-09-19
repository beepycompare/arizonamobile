package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class Po implements InterfaceC0426mb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0426mb
    public final String a(Context context) {
        IdentifiersResult q = C0574s4.l().b(context).q();
        if (StringUtils.isNullOrEmpty(q.id)) {
            return null;
        }
        return q.id;
    }
}
