package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0129ak implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f792a;

    public C0129ak(ModuleEvent moduleEvent) {
        this.f792a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.reportEvent(this.f792a);
    }
}
