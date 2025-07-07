package io.appmetrica.analytics.location.impl;

import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.cache.LocationDataCacheUpdateScheduler;
import io.appmetrica.analytics.locationapi.internal.ILastKnownUpdater;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractor;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import io.appmetrica.analytics.locationapi.internal.LocationReceiver;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class k implements ILastKnownUpdater, LocationControllerObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1187a;
    public final PermissionExtractor b;
    public final p c;
    public final IHandlerExecutor d;
    public final n e;
    public final LocationDataCacheUpdateScheduler f;
    public boolean g;
    public final HashMap h = new HashMap();
    public final HashMap i = new HashMap();
    public Location j;

    public k(Context context, PermissionExtractor permissionExtractor, IHandlerExecutor iHandlerExecutor, p pVar) {
        this.f1187a = context;
        this.c = pVar;
        this.b = permissionExtractor;
        this.d = iHandlerExecutor;
        this.e = new n(pVar);
        LocationDataCacheUpdateScheduler locationDataCacheUpdateScheduler = new LocationDataCacheUpdateScheduler(iHandlerExecutor, this, pVar.a(), "loc");
        this.f = locationDataCacheUpdateScheduler;
        pVar.a().setUpdateScheduler(locationDataCacheUpdateScheduler);
    }

    public final synchronized Location a() {
        return (Location) this.c.b.getData();
    }

    public final synchronized void b(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        this.h.remove(lastKnownLocationExtractorProvider.getIdentifier());
    }

    public final synchronized Location c() {
        Location location;
        location = this.j;
        if (location == null) {
            location = a();
        }
        return location;
    }

    public final synchronized void d() {
        this.f.startUpdates();
        for (LocationReceiver locationReceiver : this.i.values()) {
            locationReceiver.startLocationUpdates();
        }
        updateLastKnown();
    }

    public final synchronized void e() {
        this.f.stopUpdates();
        for (LocationReceiver locationReceiver : this.i.values()) {
            locationReceiver.stopLocationUpdates();
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public final synchronized void startLocationTracking() {
        if (!this.g) {
            this.g = true;
            d();
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public final synchronized void stopLocationTracking() {
        if (this.g) {
            this.g = false;
            e();
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.ILastKnownUpdater
    public final synchronized void updateLastKnown() {
        for (LastKnownLocationExtractor lastKnownLocationExtractor : this.h.values()) {
            lastKnownLocationExtractor.updateLastKnownLocation();
        }
    }

    public final synchronized void b(LocationReceiverProvider locationReceiverProvider) {
        LocationReceiver locationReceiver = (LocationReceiver) this.i.remove(locationReceiverProvider.getIdentifier());
        if (locationReceiver != null && this.g) {
            locationReceiver.stopLocationUpdates();
        }
    }

    public final void a(i iVar) {
        this.d.execute(new j(this, iVar));
    }

    public final synchronized void a(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        LastKnownLocationExtractor extractor = lastKnownLocationExtractorProvider.getExtractor(this.f1187a, this.b, this.d, this.e);
        this.h.put(lastKnownLocationExtractorProvider.getIdentifier(), extractor);
        if (this.g) {
            extractor.updateLastKnownLocation();
        }
    }

    public final synchronized Location b() {
        return this.j;
    }

    public final synchronized void a(LocationReceiverProvider locationReceiverProvider) {
        LocationReceiver locationReceiver = locationReceiverProvider.getLocationReceiver(this.f1187a, this.b, this.d, this.e);
        LocationReceiver locationReceiver2 = (LocationReceiver) this.i.put(locationReceiverProvider.getIdentifier(), locationReceiver);
        if (this.g) {
            if (locationReceiver2 != null) {
                locationReceiver2.stopLocationUpdates();
            }
            locationReceiver.startLocationUpdates();
        }
    }

    public final synchronized void a(Location location) {
        if (location != null) {
            this.j = location;
        }
    }
}
