package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
/* loaded from: classes4.dex */
public final class G2 {

    /* renamed from: a  reason: collision with root package name */
    public final LocationManager f454a;

    public G2(Context context) {
        this((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION));
    }

    public G2(LocationManager locationManager) {
        this.f454a = locationManager;
    }
}
