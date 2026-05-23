package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.wc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0688wc implements PermissionStrategy, LocationControllerObserver {
    public static final C0662vc b = new C0662vc();
    public static final List c = CollectionsKt.listOf((Object[]) new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f1263a;

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final boolean forbidUsePermission(String str) {
        if (c.contains(str)) {
            return !this.f1263a;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public final void startLocationTracking() {
        this.f1263a = true;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public final void stopLocationTracking() {
        this.f1263a = false;
    }

    public final String toString() {
        return "LocationFlagStrategy(enabled=" + this.f1263a + ", locationPermissions=" + c + ')';
    }
}
