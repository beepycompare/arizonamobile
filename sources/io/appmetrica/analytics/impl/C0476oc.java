package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* renamed from: io.appmetrica.analytics.impl.oc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0476oc implements InterfaceC0380kg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0501pc f1154a;

    public C0476oc(C0501pc c0501pc) {
        this.f1154a = c0501pc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0380kg
    public final void a(C0455ng c0455ng) {
        if (c0455ng == null) {
            return;
        }
        P5 p5 = new P5("", "", 0);
        p5.setValueBytes(c0455ng.a());
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        p5.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f1154a.a(p5);
    }
}
