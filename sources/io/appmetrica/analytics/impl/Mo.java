package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes5.dex */
public final class Mo implements Mm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f671a;

    public Mo(UtilityServiceProvider utilityServiceProvider) {
        this.f671a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.Mm
    public final void a(Hm hm) {
        this.f671a.updateConfiguration(new UtilityServiceConfiguration(hm.v, hm.u));
    }
}
