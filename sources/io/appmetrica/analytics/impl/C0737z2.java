package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
/* renamed from: io.appmetrica.analytics.impl.z2  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0737z2 {

    /* renamed from: a  reason: collision with root package name */
    public final LocationManager f1223a;

    public C0737z2(Context context) {
        this((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION));
    }

    public C0737z2(LocationManager locationManager) {
        this.f1223a = locationManager;
    }
}
