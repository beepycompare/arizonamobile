package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* renamed from: io.appmetrica.analytics.impl.rc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0557rc implements LocationReceiverProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final C0582sc f1034a = new C0582sc();

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.f1034a;
    }
}
