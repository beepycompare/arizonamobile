package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
/* loaded from: classes4.dex */
public final class Ji extends V4 {
    public Ji(S4 s4) {
        super(s4);
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0325i6 c0325i6, P4 p4) {
        Bundle bundle = c0325i6.m;
        this.f669a.k.a(new R4(bundle != null ? (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver") : null));
        return false;
    }
}
