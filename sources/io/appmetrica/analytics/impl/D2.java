package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
/* loaded from: classes4.dex */
public final class D2 {

    /* renamed from: a  reason: collision with root package name */
    public final LocationManager f381a;

    public D2(Context context) {
        this((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION));
    }

    public D2(LocationManager locationManager) {
        this.f381a = locationManager;
    }
}
