package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes5.dex */
public final class E1 implements InterfaceC0203dk {
    public static final D1 b = new D1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0562s0 f559a;

    public E1(InterfaceC0562s0 interfaceC0562s0) {
        this.f559a = interfaceC0562s0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0203dk
    public final void reportData(int i, Bundle bundle) {
        ((B1) this.f559a).a(bundle);
    }
}
