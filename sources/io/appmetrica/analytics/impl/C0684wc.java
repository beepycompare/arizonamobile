package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* renamed from: io.appmetrica.analytics.impl.wc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0684wc implements LocationReceiverProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final C0709xc f1137a = new C0709xc();

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.f1137a;
    }
}
