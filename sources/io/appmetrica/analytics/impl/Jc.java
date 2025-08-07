package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* loaded from: classes4.dex */
public final class Jc implements InterfaceC0711xg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Kc f505a;

    public Jc(Kc kc) {
        this.f505a = kc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0711xg
    public final void a(Ag ag) {
        if (ag == null) {
            return;
        }
        C0402l6 c0402l6 = new C0402l6("", "", 0);
        c0402l6.setValueBytes(ag.a());
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        c0402l6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f505a.a(c0402l6);
    }
}
