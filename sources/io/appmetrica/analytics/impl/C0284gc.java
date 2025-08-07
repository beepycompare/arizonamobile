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
/* renamed from: io.appmetrica.analytics.impl.gc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0284gc implements InterfaceC0258fc, InterfaceC0393km, LocationProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f864a;
    public final InterfaceC0383kc b;
    public final LocationClient c;
    public final C0616tl d;
    public final C0740yk e;
    public final LastKnownLocationExtractorProviderFactory f;
    public final LocationReceiverProviderFactory g;

    public C0284gc(Context context, InterfaceC0383kc interfaceC0383kc, LocationClient locationClient) {
        this.f864a = context;
        this.b = interfaceC0383kc;
        this.c = locationClient;
        C0508pc c0508pc = new C0508pc();
        this.d = new C0616tl(new E5(c0508pc, Ia.j().o().getAskForPermissionStrategy()));
        this.e = Ia.j().o();
        ((C0458nc) interfaceC0383kc).a(c0508pc, true);
        ((C0458nc) interfaceC0383kc).a(locationClient, true);
        this.f = locationClient.getLastKnownExtractorProviderFactory();
        this.g = locationClient.getLocationReceiverProviderFactory();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0393km
    public final void a(C0268fm c0268fm) {
        C0748z3 c0748z3 = c0268fm.y;
        if (c0748z3 != null) {
            long j = c0748z3.f1162a;
            this.c.updateCacheArguments(new CacheArguments(j, 2 * j));
        }
    }

    public final C0616tl b() {
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0258fc, io.appmetrica.analytics.impl.InterfaceC0334ic
    public final void init() {
        this.c.init(this.f864a, this.d, Ia.F.d.c(), this.e.e());
        ModuleLocationSourcesServiceController f = this.e.f();
        if (f != null) {
            f.init();
        } else {
            LocationClient locationClient = this.c;
            locationClient.registerSystemLocationSource(locationClient.getLastKnownExtractorProviderFactory().getGplLastKnownLocationExtractorProvider());
            LocationClient locationClient2 = this.c;
            locationClient2.registerSystemLocationSource(locationClient2.getLastKnownExtractorProviderFactory().getNetworkLastKnownLocationExtractorProvider());
        }
        ((C0458nc) this.b).a(this.e.g());
        Ia.F.u.a(this);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerControllerObserver(LocationControllerObserver locationControllerObserver) {
        ((C0458nc) this.b).a(locationControllerObserver, true);
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0258fc, io.appmetrica.analytics.impl.InterfaceC0334ic
    public final void b(Object obj) {
        ((C0458nc) this.b).a(obj);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerSource(LocationReceiverProvider locationReceiverProvider) {
        this.c.registerSystemLocationSource(locationReceiverProvider);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void unregisterSource(LocationReceiverProvider locationReceiverProvider) {
        this.c.unregisterSystemLocationSource(locationReceiverProvider);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0258fc, io.appmetrica.analytics.impl.InterfaceC0334ic
    public final void a(Object obj) {
        ((C0458nc) this.b).b(obj);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0258fc, io.appmetrica.analytics.impl.InterfaceC0334ic
    public final void a(boolean z) {
        ((C0458nc) this.b).a(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0258fc, io.appmetrica.analytics.impl.InterfaceC0334ic
    public final void a(Location location) {
        this.c.updateUserLocation(location);
    }
}
