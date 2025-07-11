package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* loaded from: classes4.dex */
public final class Hc implements InterfaceC0658vg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ic f461a;

    public Hc(Ic ic) {
        this.f461a = ic;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0658vg
    public final void a(C0733yg c0733yg) {
        if (c0733yg == null) {
            return;
        }
        C0325i6 c0325i6 = new C0325i6("", "", 0);
        c0325i6.setValueBytes(c0733yg.a());
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        c0325i6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f461a.a(c0325i6);
    }
}
