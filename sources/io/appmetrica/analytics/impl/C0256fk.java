package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0256fk implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f982a;

    public C0256fk(ModuleEvent moduleEvent) {
        this.f982a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportEvent(this.f982a);
    }
}
