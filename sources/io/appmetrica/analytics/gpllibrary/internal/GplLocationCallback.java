package io.appmetrica.analytics.gpllibrary.internal;

import android.location.LocationListener;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
/* loaded from: classes4.dex */
class GplLocationCallback extends LocationCallback {

    /* renamed from: a  reason: collision with root package name */
    private final LocationListener f312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GplLocationCallback(LocationListener locationListener) {
        this.f312a = locationListener;
    }

    public void onLocationResult(LocationResult locationResult) {
        this.f312a.onLocationChanged(locationResult.getLastLocation());
    }
}
