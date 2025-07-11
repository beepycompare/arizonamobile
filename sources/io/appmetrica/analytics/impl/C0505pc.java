package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* renamed from: io.appmetrica.analytics.impl.pc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0505pc implements LocationReceiverProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final C0530qc f989a = new C0530qc();

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.f989a;
    }
}
