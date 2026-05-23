package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public final class Ti extends Q4 {
    public Ti(N4 n4) {
        super(n4);
    }

    @Override // io.appmetrica.analytics.impl.Q4
    public final boolean a(C0242f6 c0242f6, L4 l4) {
        Bundle bundle = c0242f6.m;
        this.f724a.a(bundle != null ? (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver") : null);
        return false;
    }
}
