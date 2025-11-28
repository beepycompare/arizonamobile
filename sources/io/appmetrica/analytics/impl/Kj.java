package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes5.dex */
public final class Kj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f561a;

    public Kj(ModuleEvent moduleEvent) {
        this.f561a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportEvent(this.f561a);
    }
}
