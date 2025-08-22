package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes4.dex */
public final class Zj implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f762a;

    public Zj(Map map) {
        this.f762a = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportAnr(this.f762a);
    }
}
