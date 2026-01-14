package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes5.dex */
public final class E1 implements InterfaceC0204dk {
    public static final D1 b = new D1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0563s0 f560a;

    public E1(InterfaceC0563s0 interfaceC0563s0) {
        this.f560a = interfaceC0563s0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0204dk
    public final void reportData(int i, Bundle bundle) {
        ((B1) this.f560a).a(bundle);
    }
}
