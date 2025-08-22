package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes4.dex */
public final class Wj implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f712a;

    public Wj(ModuleEvent moduleEvent) {
        this.f712a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportEvent(this.f712a);
    }
}
