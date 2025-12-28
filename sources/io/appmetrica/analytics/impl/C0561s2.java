package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0561s2 {

    /* renamed from: a  reason: collision with root package name */
    public final LocationManager f1208a;

    public C0561s2(Context context) {
        this((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION));
    }

    public C0561s2(LocationManager locationManager) {
        this.f1208a = locationManager;
    }
}
