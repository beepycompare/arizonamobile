package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* loaded from: classes4.dex */
public final class lo implements InterfaceC0515pm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f958a;

    public lo(UtilityServiceProvider utilityServiceProvider) {
        this.f958a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0515pm
    public final void a(C0389km c0389km) {
        this.f958a.updateConfiguration(new UtilityServiceConfiguration(c0389km.v, c0389km.u));
    }
}
