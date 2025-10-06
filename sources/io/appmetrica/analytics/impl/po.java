package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes4.dex */
public final class po implements InterfaceC0619tm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f1041a;

    public po(UtilityServiceProvider utilityServiceProvider) {
        this.f1041a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0619tm
    public final void a(C0494om c0494om) {
        this.f1041a.updateConfiguration(new UtilityServiceConfiguration(c0494om.v, c0494om.u));
    }
}
