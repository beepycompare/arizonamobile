package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes4.dex */
public final class Oj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f568a;

    public Oj(ModuleEvent moduleEvent) {
        this.f568a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.reportEvent(this.f568a);
    }
}
