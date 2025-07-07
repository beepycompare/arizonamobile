package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class M1 implements InterfaceC0346ik {
    public static final L1 b = new L1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0501p0 f526a;

    public M1(InterfaceC0501p0 interfaceC0501p0) {
        this.f526a = interfaceC0501p0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0346ik
    public final void reportData(int i, Bundle bundle) {
        ((J1) this.f526a).a(bundle);
    }
}
