package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes5.dex */
public final class P1 implements InterfaceC0328ik {
    public static final O1 b = new O1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0560s0 f627a;

    public P1(InterfaceC0560s0 interfaceC0560s0) {
        this.f627a = interfaceC0560s0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0328ik
    public final void reportData(int i, Bundle bundle) {
        ((M1) this.f627a).a(bundle);
    }
}
