package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* loaded from: classes4.dex */
public final class Oc implements Gg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Pc f610a;

    public Oc(Pc pc) {
        this.f610a = pc;
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final void a(Jg jg) {
        if (jg == null) {
            return;
        }
        C0477o6 c0477o6 = new C0477o6("", "", 0);
        c0477o6.setValueBytes(jg.a());
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0477o6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f610a.a(c0477o6);
    }
}
