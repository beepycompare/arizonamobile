package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* renamed from: io.appmetrica.analytics.impl.pc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0498pc implements InterfaceC0402lg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0523qc f1066a;

    public C0498pc(C0523qc c0523qc) {
        this.f1066a = c0523qc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0402lg
    public final void a(C0477og c0477og) {
        if (c0477og == null) {
            return;
        }
        Q5 q5 = new Q5("", "", 0);
        q5.setValueBytes(c0477og.a());
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        q5.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f1066a.a(q5);
    }
}
