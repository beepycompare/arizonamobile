package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* renamed from: io.appmetrica.analytics.impl.pc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0497pc implements InterfaceC0401lg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0522qc f1163a;

    public C0497pc(C0522qc c0522qc) {
        this.f1163a = c0522qc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0401lg
    public final void a(C0476og c0476og) {
        if (c0476og == null) {
            return;
        }
        Q5 q5 = new Q5("", "", 0);
        q5.setValueBytes(c0476og.a());
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        q5.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f1163a.a(q5);
    }
}
