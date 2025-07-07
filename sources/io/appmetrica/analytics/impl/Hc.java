package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* loaded from: classes4.dex */
public final class Hc implements InterfaceC0666vg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ic f460a;

    public Hc(Ic ic) {
        this.f460a = ic;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0666vg
    public final void a(C0741yg c0741yg) {
        if (c0741yg == null) {
            return;
        }
        C0333i6 c0333i6 = new C0333i6("", "", 0);
        c0333i6.setValueBytes(c0741yg.a());
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        c0333i6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f460a.a(c0333i6);
    }
}
