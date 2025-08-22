package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class M1 implements InterfaceC0538qk {
    public static final L1 b = new L1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0493p0 f552a;

    public M1(InterfaceC0493p0 interfaceC0493p0) {
        this.f552a = interfaceC0493p0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0538qk
    public final void reportData(int i, Bundle bundle) {
        ((J1) this.f552a).a(bundle);
    }
}
