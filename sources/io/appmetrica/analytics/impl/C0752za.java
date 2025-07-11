package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.za  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0752za extends V4 {
    public C0752za(S4 s4) {
        super(s4);
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0325i6 c0325i6, P4 p4) {
        Bundle bundle = c0325i6.m;
        this.f669a.a(bundle != null ? (C0529qb) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null);
        return false;
    }
}
