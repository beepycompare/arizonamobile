package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes5.dex */
public final class F1 implements InterfaceC0224ek {
    public static final E1 b = new E1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0559s0 f554a;

    public F1(InterfaceC0559s0 interfaceC0559s0) {
        this.f554a = interfaceC0559s0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0224ek
    public final void reportData(int i, Bundle bundle) {
        ((C1) this.f554a).a(bundle);
    }
}
