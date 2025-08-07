package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes4.dex */
public final class go implements InterfaceC0393km {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f872a;

    public go(UtilityServiceProvider utilityServiceProvider) {
        this.f872a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0393km
    public final void a(C0268fm c0268fm) {
        this.f872a.updateConfiguration(new UtilityServiceConfiguration(c0268fm.v, c0268fm.u));
    }
}
