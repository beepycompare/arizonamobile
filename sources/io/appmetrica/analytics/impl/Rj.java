package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes4.dex */
public final class Rj implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f625a;

    public Rj(ModuleEvent moduleEvent) {
        this.f625a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportEvent(this.f625a);
    }
}
