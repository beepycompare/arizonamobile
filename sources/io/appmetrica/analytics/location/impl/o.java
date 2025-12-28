package io.appmetrica.analytics.location.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* loaded from: classes5.dex */
public final class o implements LocationReceiverProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final q f1353a;

    public o(q qVar) {
        this.f1353a = qVar;
    }

    public final q a() {
        return this.f1353a;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.f1353a;
    }
}
