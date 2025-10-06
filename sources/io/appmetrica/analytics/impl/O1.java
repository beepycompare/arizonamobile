package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class O1 implements InterfaceC0642uk {
    public static final N1 b = new N1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0547r0 f603a;

    public O1(InterfaceC0547r0 interfaceC0547r0) {
        this.f603a = interfaceC0547r0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0642uk
    public final void reportData(int i, Bundle bundle) {
        ((L1) this.f603a).a(bundle);
    }
}
