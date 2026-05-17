package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes5.dex */
public final class Fj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f587a;

    public Fj(ModuleEvent moduleEvent) {
        this.f587a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportEvent(this.f587a);
    }
}
