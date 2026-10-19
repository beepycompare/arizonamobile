package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0249fk implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f988a;

    public C0249fk(ModuleEvent moduleEvent) {
        this.f988a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        interfaceC0499pb.reportEvent(this.f988a);
    }
}
