package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes5.dex */
public final class Gj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f494a;

    public Gj(ModuleEvent moduleEvent) {
        this.f494a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportEvent(this.f494a);
    }
}
