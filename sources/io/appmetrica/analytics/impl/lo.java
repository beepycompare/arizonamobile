package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes3.dex */
public final class lo implements InterfaceC0483om {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f997a;

    public lo(UtilityServiceProvider utilityServiceProvider) {
        this.f997a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0483om
    public final void a(C0356jm c0356jm) {
        this.f997a.updateConfiguration(new UtilityServiceConfiguration(c0356jm.v, c0356jm.u));
    }
}
