package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
/* renamed from: io.appmetrica.analytics.impl.zi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0755zi extends A4 {
    public C0755zi(C0691x4 c0691x4) {
        super(c0691x4);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final boolean a(P5 p5, C0616u4 c0616u4) {
        Bundle bundle = p5.m;
        this.f493a.k.a(new C0666w4(bundle != null ? (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver") : null));
        return false;
    }
}
