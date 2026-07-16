package io.appmetrica.analytics.location.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* loaded from: classes5.dex */
public final class o implements LocationReceiverProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final q f1342a;

    public o(q qVar) {
        this.f1342a = qVar;
    }

    public final q a() {
        return this.f1342a;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.f1342a;
    }
}
