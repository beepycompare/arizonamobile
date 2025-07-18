package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.h6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0300h6 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        E9 e9;
        Bundle readBundle = parcel.readBundle(T6.class.getClassLoader());
        if (readBundle.containsKey("CounterReport.Source")) {
            int i = readBundle.getInt("CounterReport.Source");
            E9[] values = E9.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    e9 = values[i2];
                    if (e9.f406a == i) {
                        break;
                    }
                    i2++;
                } else {
                    e9 = E9.NATIVE;
                    break;
                }
            }
        } else {
            e9 = null;
        }
        C0325i6 c0325i6 = new C0325i6("", "", 0);
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        c0325i6.d = readBundle.getInt("CounterReport.Type", -1);
        c0325i6.e = readBundle.getInt("CounterReport.CustomType");
        c0325i6.b = StringUtils.ifIsNullToDef(readBundle.getString("CounterReport.Value"), "");
        c0325i6.c = readBundle.getString("CounterReport.Environment");
        c0325i6.f875a = readBundle.getString("CounterReport.Event");
        c0325i6.f = C0325i6.a(readBundle);
        c0325i6.g = readBundle.getInt("CounterReport.TRUNCATED");
        c0325i6.h = readBundle.getString("CounterReport.ProfileID");
        c0325i6.i = readBundle.getLong("CounterReport.CreationElapsedRealtime");
        c0325i6.j = readBundle.getLong("CounterReport.CreationTimestamp");
        c0325i6.k = EnumC0677wa.a(Integer.valueOf(readBundle.getInt("CounterReport.UniquenessStatus")));
        c0325i6.l = e9;
        c0325i6.m = readBundle.getBundle("CounterReport.Payload");
        c0325i6.n = readBundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(readBundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        c0325i6.o = readBundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(readBundle.getInt("CounterReport.OpenId")) : null;
        c0325i6.p = CollectionUtils.bundleToMap(readBundle.getBundle("CounterReport.Extras"));
        return c0325i6;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C0325i6[i];
    }
}
