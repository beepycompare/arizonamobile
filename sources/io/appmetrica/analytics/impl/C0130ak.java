package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0130ak implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f797a;

    public C0130ak(ModuleEvent moduleEvent) {
        this.f797a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportEvent(this.f797a);
    }
}
