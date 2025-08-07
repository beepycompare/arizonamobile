package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class M1 implements InterfaceC0416lk {
    public static final L1 b = new L1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0496p0 f540a;

    public M1(InterfaceC0496p0 interfaceC0496p0) {
        this.f540a = interfaceC0496p0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0416lk
    public final void reportData(int i, Bundle bundle) {
        ((J1) this.f540a).a(bundle);
    }
}
