package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* loaded from: classes4.dex */
public final class Lc implements Cg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Mc f543a;

    public Lc(Mc mc) {
        this.f543a = mc;
    }

    @Override // io.appmetrica.analytics.impl.Cg
    public final void a(Fg fg) {
        if (fg == null) {
            return;
        }
        C0399l6 c0399l6 = new C0399l6("", "", 0);
        c0399l6.setValueBytes(fg.a());
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0399l6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f543a.a(c0399l6);
    }
}
