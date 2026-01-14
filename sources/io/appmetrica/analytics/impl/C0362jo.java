package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* renamed from: io.appmetrica.analytics.impl.jo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0362jo implements InterfaceC0386km {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f1070a;

    public C0362jo(UtilityServiceProvider utilityServiceProvider) {
        this.f1070a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0386km
    public final void a(C0257fm c0257fm) {
        this.f1070a.updateConfiguration(new UtilityServiceConfiguration(c0257fm.v, c0257fm.u));
    }
}
