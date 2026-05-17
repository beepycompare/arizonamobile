package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* renamed from: io.appmetrica.analytics.impl.jo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0361jo implements InterfaceC0385km {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f1074a;

    public C0361jo(UtilityServiceProvider utilityServiceProvider) {
        this.f1074a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0385km
    public final void a(C0256fm c0256fm) {
        this.f1074a.updateConfiguration(new UtilityServiceConfiguration(c0256fm.v, c0256fm.u));
    }
}
