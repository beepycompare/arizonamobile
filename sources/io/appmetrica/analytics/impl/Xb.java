package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* loaded from: classes5.dex */
public final class Xb implements LocationReceiverProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final Yb f847a = new Yb();

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.f847a;
    }
}
