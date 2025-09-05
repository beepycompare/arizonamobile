package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes4.dex */
public final class po implements InterfaceC0618tm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f1036a;

    public po(UtilityServiceProvider utilityServiceProvider) {
        this.f1036a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0618tm
    public final void a(C0493om c0493om) {
        this.f1036a.updateConfiguration(new UtilityServiceConfiguration(c0493om.v, c0493om.u));
    }
}
