package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes4.dex */
public final class Rj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f626a;

    public Rj(ModuleEvent moduleEvent) {
        this.f626a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportEvent(this.f626a);
    }
}
