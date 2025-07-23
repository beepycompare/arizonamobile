package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
/* loaded from: classes4.dex */
public final class Mi extends V4 {
    public Mi(S4 s4) {
        super(s4);
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0401l6 c0401l6, P4 p4) {
        Bundle bundle = c0401l6.m;
        this.f681a.k.a(new R4(bundle != null ? (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver") : null));
        return false;
    }
}
