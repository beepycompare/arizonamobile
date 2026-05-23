package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
/* loaded from: classes5.dex */
public final class E2 {

    /* renamed from: a  reason: collision with root package name */
    public final LocationManager f519a;

    public E2(Context context) {
        this((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION));
    }

    public E2(LocationManager locationManager) {
        this.f519a = locationManager;
    }
}
