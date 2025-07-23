package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* loaded from: classes4.dex */
public final class Jc implements InterfaceC0710xg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Kc f505a;

    public Jc(Kc kc) {
        this.f505a = kc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0710xg
    public final void a(Ag ag) {
        if (ag == null) {
            return;
        }
        C0401l6 c0401l6 = new C0401l6("", "", 0);
        c0401l6.setValueBytes(ag.a());
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        c0401l6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f505a.a(c0401l6);
    }
}
