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
/* renamed from: io.appmetrica.analytics.impl.ec  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0231ec implements InterfaceC0206dc, InterfaceC0316hm, LocationProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f820a;
    public final InterfaceC0331ic b;
    public final LocationClient c;
    public final C0539ql d;
    public final C0662vk e;
    public final LastKnownLocationExtractorProviderFactory f;
    public final LocationReceiverProviderFactory g;

    public C0231ec(Context context, InterfaceC0331ic interfaceC0331ic, LocationClient locationClient) {
        this.f820a = context;
        this.b = interfaceC0331ic;
        this.c = locationClient;
        C0455nc c0455nc = new C0455nc();
        this.d = new C0539ql(new C5(c0455nc, Ga.j().o().getAskForPermissionStrategy()));
        this.e = Ga.j().o();
        ((C0405lc) interfaceC0331ic).a(c0455nc, true);
        ((C0405lc) interfaceC0331ic).a(locationClient, true);
        this.f = locationClient.getLastKnownExtractorProviderFactory();
        this.g = locationClient.getLocationReceiverProviderFactory();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0316hm
    public final void a(C0190cm c0190cm) {
        C0745z3 c0745z3 = c0190cm.y;
        if (c0745z3 != null) {
            long j = c0745z3.f1157a;
            this.c.updateCacheArguments(new CacheArguments(j, 2 * j));
        }
    }

    public final C0539ql b() {
        return this.d;
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0206dc, io.appmetrica.analytics.impl.InterfaceC0281gc
    public final void init() {
        this.c.init(this.f820a, this.d, Ga.F.d.c(), this.e.e());
        ModuleLocationSourcesServiceController f = this.e.f();
        if (f != null) {
            f.init();
        } else {
            LocationClient locationClient = this.c;
            locationClient.registerSystemLocationSource(locationClient.getLastKnownExtractorProviderFactory().getGplLastKnownLocationExtractorProvider());
            LocationClient locationClient2 = this.c;
            locationClient2.registerSystemLocationSource(locationClient2.getLastKnownExtractorProviderFactory().getNetworkLastKnownLocationExtractorProvider());
        }
        ((C0405lc) this.b).a(this.e.g());
        Ga.F.u.a(this);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerControllerObserver(LocationControllerObserver locationControllerObserver) {
        ((C0405lc) this.b).a(locationControllerObserver, true);
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0206dc, io.appmetrica.analytics.impl.InterfaceC0281gc
    public final void b(Object obj) {
        ((C0405lc) this.b).a(obj);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerSource(LocationReceiverProvider locationReceiverProvider) {
        this.c.registerSystemLocationSource(locationReceiverProvider);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void unregisterSource(LocationReceiverProvider locationReceiverProvider) {
        this.c.unregisterSystemLocationSource(locationReceiverProvider);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206dc, io.appmetrica.analytics.impl.InterfaceC0281gc
    public final void a(Object obj) {
        ((C0405lc) this.b).b(obj);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206dc, io.appmetrica.analytics.impl.InterfaceC0281gc
    public final void a(boolean z) {
        ((C0405lc) this.b).a(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0206dc, io.appmetrica.analytics.impl.InterfaceC0281gc
    public final void a(Location location) {
        this.c.updateUserLocation(location);
    }
}
