package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
/* renamed from: io.appmetrica.analytics.impl.r2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0540r2 {

    /* renamed from: a  reason: collision with root package name */
    public final LocationManager f1199a;

    public C0540r2(Context context) {
        this((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION));
    }

    public C0540r2(LocationManager locationManager) {
        this.f1199a = locationManager;
    }
}
