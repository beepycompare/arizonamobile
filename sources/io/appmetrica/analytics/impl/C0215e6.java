package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.e6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0215e6 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        G9 g9;
        Bundle readBundle = parcel.readBundle(T6.class.getClassLoader());
        if (readBundle.containsKey("CounterReport.Source")) {
            int i = readBundle.getInt("CounterReport.Source");
            G9[] values = G9.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    g9 = values[i2];
                    if (g9.f564a == i) {
                        break;
                    }
                    i2++;
                } else {
                    g9 = G9.NATIVE;
                    break;
                }
            }
        } else {
            g9 = null;
        }
        C0241f6 c0241f6 = new C0241f6("", "", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0241f6.d = readBundle.getInt("CounterReport.Type", -1);
        c0241f6.e = readBundle.getInt("CounterReport.CustomType");
        c0241f6.b = StringUtils.ifIsNullToDef(readBundle.getString("CounterReport.Value"), "");
        c0241f6.c = readBundle.getString("CounterReport.Environment");
        c0241f6.f977a = readBundle.getString("CounterReport.Event");
        c0241f6.f = C0241f6.a(readBundle);
        c0241f6.g = readBundle.getInt("CounterReport.TRUNCATED");
        c0241f6.h = readBundle.getString("CounterReport.ProfileID");
        c0241f6.i = readBundle.getLong("CounterReport.CreationElapsedRealtime");
        c0241f6.j = readBundle.getLong("CounterReport.CreationTimestamp");
        c0241f6.k = Aa.a(Integer.valueOf(readBundle.getInt("CounterReport.UniquenessStatus")));
        c0241f6.l = g9;
        c0241f6.m = readBundle.getBundle("CounterReport.Payload");
        c0241f6.n = readBundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(readBundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        c0241f6.o = readBundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(readBundle.getInt("CounterReport.OpenId")) : null;
        c0241f6.p = CollectionUtils.bundleToMap(readBundle.getBundle("CounterReport.Extras"));
        return c0241f6;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C0241f6[i];
    }
}
