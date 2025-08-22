package io.appmetrica.analytics.gpllibrary.internal;

import android.location.LocationListener;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
/* loaded from: classes4.dex */
class GplLocationCallback extends LocationCallback {

    /* renamed from: a  reason: collision with root package name */
    private final LocationListener f319a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GplLocationCallback(LocationListener locationListener) {
        this.f319a = locationListener;
    }

    public void onLocationResult(LocationResult locationResult) {
        this.f319a.onLocationChanged(locationResult.getLastLocation());
    }
}
