package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0740yc implements LocationReceiverProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final C0766zc f1294a = new C0766zc();

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.f1294a;
    }
}
