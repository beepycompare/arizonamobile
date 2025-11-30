package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes5.dex */
public final class F1 implements InterfaceC0225ek {
    public static final E1 b = new E1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0560s0 f471a;

    public F1(InterfaceC0560s0 interfaceC0560s0) {
        this.f471a = interfaceC0560s0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ek
    public final void reportData(int i, Bundle bundle) {
        ((C1) this.f471a).a(bundle);
    }
}
