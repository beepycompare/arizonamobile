package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes5.dex */
public final class Mo implements Mm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f673a;

    public Mo(UtilityServiceProvider utilityServiceProvider) {
        this.f673a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.Mm
    public final void a(Hm hm) {
        this.f673a.updateConfiguration(new UtilityServiceConfiguration(hm.v, hm.u));
    }
}
