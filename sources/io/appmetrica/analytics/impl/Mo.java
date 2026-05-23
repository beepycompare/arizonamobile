package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes5.dex */
public final class Mo implements Mm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f670a;

    public Mo(UtilityServiceProvider utilityServiceProvider) {
        this.f670a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.Mm
    public final void a(Hm hm) {
        this.f670a.updateConfiguration(new UtilityServiceConfiguration(hm.v, hm.u));
    }
}
