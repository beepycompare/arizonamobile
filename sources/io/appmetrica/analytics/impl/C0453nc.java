package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.locationapi.internal.CacheArguments;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory;
import io.appmetrica.analytics.locationapi.internal.LocationClient;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import io.appmetrica.analytics.locationapi.internal.LocationFilter;
import io.appmetrica.analytics.locationapi.internal.LocationProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleLocationSourcesServiceController;
/* renamed from: io.appmetrica.analytics.impl.nc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0453nc implements InterfaceC0427mc, Mm, LocationProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1115a;
    public final InterfaceC0556rc b;
    public final LocationClient c;
    public final Yl d;
    public final Zk e;
    public final LastKnownLocationExtractorProviderFactory f;
    public final LocationReceiverProviderFactory g;

    public C0453nc(Context context, InterfaceC0556rc interfaceC0556rc, LocationClient locationClient) {
        this.f1115a = context;
        this.b = interfaceC0556rc;
        this.c = locationClient;
        C0686wc c0686wc = new C0686wc();
        this.d = new Yl(new C0757z5(c0686wc, Na.k().p().getAskForPermissionStrategy()));
        this.e = Na.k().p();
        ((C0634uc) interfaceC0556rc).a(c0686wc, true);
        ((C0634uc) interfaceC0556rc).a(locationClient, true);
        this.f = locationClient.getLastKnownExtractorProviderFactory();
        this.g = locationClient.getLocationReceiverProviderFactory();
    }

    public final Yl a() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0427mc, io.appmetrica.analytics.impl.InterfaceC0505pc
    public final void b(Object obj) {
        ((C0634uc) this.b).a(obj);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final LastKnownLocationExtractorProviderFactory getLastKnownExtractorProviderFactory() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final LocationReceiverProviderFactory getLocationReceiverProviderFactory() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final PermissionExtractor getPermissionExtractor() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationProvider
    public final Location getSystemLocation() {
        return this.c.getSystemLocation();
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationProvider
    public final Location getUserLocation() {
        return this.c.getUserLocation();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0427mc, io.appmetrica.analytics.impl.InterfaceC0505pc
    public final void init() {
        this.c.init(this.f1115a, this.d, Na.I.d.c(), this.e.d());
        ModuleLocationSourcesServiceController e = this.e.e();
        if (e != null) {
            e.init();
        } else {
            LocationClient locationClient = this.c;
            locationClient.registerSystemLocationSource(locationClient.getLastKnownExtractorProviderFactory().getGplLastKnownLocationExtractorProvider());
            LocationClient locationClient2 = this.c;
            locationClient2.registerSystemLocationSource(locationClient2.getLastKnownExtractorProviderFactory().getNetworkLastKnownLocationExtractorProvider());
        }
        ((C0634uc) this.b).a(this.e.f());
        Na.I.u.a(this);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerControllerObserver(LocationControllerObserver locationControllerObserver) {
        ((C0634uc) this.b).a(locationControllerObserver, true);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        this.c.registerSystemLocationSource(lastKnownLocationExtractorProvider);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void unregisterSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        this.c.unregisterSystemLocationSource(lastKnownLocationExtractorProvider);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void updateLocationFilter(LocationFilter locationFilter) {
        this.c.updateLocationFilter(locationFilter);
    }

    @Override // io.appmetrica.analytics.impl.Mm
    public final void a(Hm hm) {
        C0599t3 c0599t3 = hm.x;
        if (c0599t3 != null) {
            long j = c0599t3.f1210a;
            this.c.updateCacheArguments(new CacheArguments(j, 2 * j));
        }
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerSource(LocationReceiverProvider locationReceiverProvider) {
        this.c.registerSystemLocationSource(locationReceiverProvider);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void unregisterSource(LocationReceiverProvider locationReceiverProvider) {
        this.c.unregisterSystemLocationSource(locationReceiverProvider);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0427mc, io.appmetrica.analytics.impl.InterfaceC0505pc
    public final void a(Object obj) {
        ((C0634uc) this.b).b(obj);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0427mc, io.appmetrica.analytics.impl.InterfaceC0505pc
    public final void a(boolean z) {
        ((C0634uc) this.b).a(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0427mc, io.appmetrica.analytics.impl.InterfaceC0505pc
    public final void a(Location location) {
        this.c.updateUserLocation(location);
    }
}
