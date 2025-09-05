package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
/* loaded from: classes4.dex */
public final class Vi extends Y4 {
    public Vi(V4 v4) {
        super(v4);
    }

    @Override // io.appmetrica.analytics.impl.Y4
    public final boolean a(C0477o6 c0477o6, S4 s4) {
        Bundle bundle = c0477o6.m;
        this.f748a.k.a(new U4(bundle != null ? (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver") : null));
        return false;
    }
}
