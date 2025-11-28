package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* renamed from: io.appmetrica.analytics.impl.dc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0192dc implements LocationReceiverProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final C0217ec f844a = new C0217ec();

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.f844a;
    }
}
