package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.nc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0455nc implements PermissionStrategy, LocationControllerObserver {
    public static final C0430mc b = new C0430mc();
    public static final List c = CollectionsKt.listOf((Object[]) new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f955a;

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final boolean forbidUsePermission(String str) {
        if (c.contains(str)) {
            return !this.f955a;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public final void startLocationTracking() {
        this.f955a = true;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public final void stopLocationTracking() {
        this.f955a = false;
    }

    public final String toString() {
        return "LocationFlagStrategy(enabled=" + this.f955a + ", locationPermissions=" + c + ')';
    }
}
