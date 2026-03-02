package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* renamed from: io.appmetrica.analytics.impl.oc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0475oc implements InterfaceC0379kg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0500pc f1153a;

    public C0475oc(C0500pc c0500pc) {
        this.f1153a = c0500pc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0379kg
    public final void a(C0454ng c0454ng) {
        if (c0454ng == null) {
            return;
        }
        P5 p5 = new P5("", "", 0);
        p5.setValueBytes(c0454ng.a());
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        p5.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f1153a.a(p5);
    }
}
