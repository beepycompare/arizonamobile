package io.appmetrica.analytics.locationapi.internal;

import android.location.Location;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lio/appmetrica/analytics/locationapi/internal/LocationProvider;", "", "systemLocation", "Landroid/location/Location;", "getSystemLocation", "()Landroid/location/Location;", "userLocation", "getUserLocation", "location-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LocationProvider {
    Location getSystemLocation();

    Location getUserLocation();
}
