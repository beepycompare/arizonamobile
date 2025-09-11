package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class O1 implements InterfaceC0641uk {
    public static final N1 b = new N1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0546r0 f602a;

    public O1(InterfaceC0546r0 interfaceC0546r0) {
        this.f602a = interfaceC0546r0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0641uk
    public final void reportData(int i, Bundle bundle) {
        ((L1) this.f602a).a(bundle);
    }
}
