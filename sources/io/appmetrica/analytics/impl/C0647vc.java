package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* renamed from: io.appmetrica.analytics.impl.vc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0647vc implements InterfaceC0502pg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0672wc f1169a;

    public C0647vc(C0672wc c0672wc) {
        this.f1169a = c0672wc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0502pg
    public final void a(C0576sg c0576sg) {
        if (c0576sg == null) {
            return;
        }
        W5 w5 = new W5("", "", 0);
        w5.setValueBytes(c0576sg.a());
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        w5.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f1169a.a(w5);
    }
}
