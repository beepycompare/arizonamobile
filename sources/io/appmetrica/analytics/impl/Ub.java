package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.locationapi.internal.LocationProvider;
/* loaded from: classes3.dex */
public interface Ub extends LocationProvider {
    void a(Location location);

    void a(Object obj);

    void a(boolean z);

    void b(Object obj);

    void init();
}
