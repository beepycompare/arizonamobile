package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes5.dex */
public final class R1 implements Fk {
    public static final Q1 b = new Q1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0624u0 f738a;

    public R1(InterfaceC0624u0 interfaceC0624u0) {
        this.f738a = interfaceC0624u0;
    }

    @Override // io.appmetrica.analytics.impl.Fk
    public final void reportData(int i, Bundle bundle) {
        ((O1) this.f738a).a(bundle);
    }
}
