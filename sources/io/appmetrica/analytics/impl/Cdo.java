package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* renamed from: io.appmetrica.analytics.impl.do  reason: invalid class name */
/* loaded from: classes4.dex */
public final class Cdo implements InterfaceC0324hm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f811a;

    public Cdo(UtilityServiceProvider utilityServiceProvider) {
        this.f811a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0324hm
    public final void a(C0198cm c0198cm) {
        this.f811a.updateConfiguration(new UtilityServiceConfiguration(c0198cm.v, c0198cm.u));
    }
}
