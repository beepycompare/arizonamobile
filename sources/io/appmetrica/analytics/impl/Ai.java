package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public final class Ai extends B4 {
    public Ai(C0714y4 c0714y4) {
        super(c0714y4);
    }

    @Override // io.appmetrica.analytics.impl.B4
    public final boolean a(Q5 q5, C0639v4 c0639v4) {
        Bundle bundle = q5.m;
        this.f405a.k.a(new C0689x4(bundle != null ? (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver") : null));
        return false;
    }
}
