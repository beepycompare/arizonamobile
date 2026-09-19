package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0254fk implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f985a;

    public C0254fk(ModuleEvent moduleEvent) {
        this.f985a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.reportEvent(this.f985a);
    }
}
