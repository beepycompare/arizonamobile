package io.appmetrica.analytics.location.impl;

import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory;
/* loaded from: classes4.dex */
public final class g implements LastKnownLocationExtractorProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final LastKnownLocationExtractorProvider f1184a;
    public final c b = new c("location-module-gpl");
    public final v c = new v("network", new f(), "location-module-network");
    public final v d = new v("gps", new e(), "location-module-gps");

    public g(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        this.f1184a = lastKnownLocationExtractorProvider;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory
    public final LastKnownLocationExtractorProvider getGplLastKnownLocationExtractorProvider() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory
    public final LastKnownLocationExtractorProvider getGpsLastKnownLocationExtractorProvider() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory
    public final LastKnownLocationExtractorProvider getNetworkLastKnownLocationExtractorProvider() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory
    public final LastKnownLocationExtractorProvider getPassiveLastKnownLocationExtractorProvider() {
        return this.f1184a;
    }
}
