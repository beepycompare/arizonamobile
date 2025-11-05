package io.appmetrica.analytics.gpllibrary.internal;

import android.location.Location;
import android.location.LocationListener;
import com.google.android.gms.tasks.OnSuccessListener;
/* loaded from: classes3.dex */
class GplOnSuccessListener implements OnSuccessListener<Location> {

    /* renamed from: a  reason: collision with root package name */
    private final LocationListener f342a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GplOnSuccessListener(LocationListener locationListener) {
        this.f342a = locationListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Location location) {
        this.f342a.onLocationChanged(location);
    }
}
