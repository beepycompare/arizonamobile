package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import io.appmetrica.analytics.locationapi.internal.LocationFilter;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
/* renamed from: io.appmetrica.analytics.impl.oc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0481oc implements InterfaceC0429mc {

    /* renamed from: a  reason: collision with root package name */
    public final We f1129a = new We();
    public final Wb b = new Wb();
    public final C0740yc c = new C0740yc();

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mc, io.appmetrica.analytics.impl.InterfaceC0507pc
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mc, io.appmetrica.analytics.impl.InterfaceC0507pc
    public final void a(Object obj) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mc, io.appmetrica.analytics.impl.InterfaceC0507pc
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mc, io.appmetrica.analytics.impl.InterfaceC0507pc
    public final void b(Object obj) {
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final LastKnownLocationExtractorProviderFactory getLastKnownExtractorProviderFactory() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final LocationReceiverProviderFactory getLocationReceiverProviderFactory() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final PermissionExtractor getPermissionExtractor() {
        return this.f1129a;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationProvider
    public final Location getSystemLocation() {
        return null;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationProvider
    public final Location getUserLocation() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mc, io.appmetrica.analytics.impl.InterfaceC0507pc
    public final void init() {
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerControllerObserver(LocationControllerObserver locationControllerObserver) {
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerSource(LocationReceiverProvider locationReceiverProvider) {
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void unregisterSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void unregisterSource(LocationReceiverProvider locationReceiverProvider) {
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void updateLocationFilter(LocationFilter locationFilter) {
    }
}
