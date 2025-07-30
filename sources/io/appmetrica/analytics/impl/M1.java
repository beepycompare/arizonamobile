package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class M1 implements InterfaceC0415lk {
    public static final L1 b = new L1();
    public static final int c = 1;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0495p0 f541a;

    public M1(InterfaceC0495p0 interfaceC0495p0) {
        this.f541a = interfaceC0495p0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0415lk
    public final void reportData(int i, Bundle bundle) {
        ((J1) this.f541a).a(bundle);
    }
}
