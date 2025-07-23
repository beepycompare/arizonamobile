package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes4.dex */
public final class go implements InterfaceC0392km {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f872a;

    public go(UtilityServiceProvider utilityServiceProvider) {
        this.f872a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0392km
    public final void a(C0267fm c0267fm) {
        this.f872a.updateConfiguration(new UtilityServiceConfiguration(c0267fm.v, c0267fm.u));
    }
}
