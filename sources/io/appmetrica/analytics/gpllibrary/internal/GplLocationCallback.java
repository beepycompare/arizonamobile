package io.appmetrica.analytics.gpllibrary.internal;

import android.location.LocationListener;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
/* loaded from: classes3.dex */
class GplLocationCallback extends LocationCallback {

    /* renamed from: a  reason: collision with root package name */
    private final LocationListener f341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GplLocationCallback(LocationListener locationListener) {
        this.f341a = locationListener;
    }

    public void onLocationResult(LocationResult locationResult) {
        this.f341a.onLocationChanged(locationResult.getLastLocation());
    }
}
