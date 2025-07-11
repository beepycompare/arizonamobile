package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* renamed from: io.appmetrica.analytics.impl.do  reason: invalid class name */
/* loaded from: classes4.dex */
public final class Cdo implements InterfaceC0316hm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f812a;

    public Cdo(UtilityServiceProvider utilityServiceProvider) {
        this.f812a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0316hm
    public final void a(C0190cm c0190cm) {
        this.f812a.updateConfiguration(new UtilityServiceConfiguration(c0190cm.v, c0190cm.u));
    }
}
