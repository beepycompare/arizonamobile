package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.n6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0451n6 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        M9 m9;
        Bundle readBundle = parcel.readBundle(ResultReceiverC0116a7.class.getClassLoader());
        if (readBundle.containsKey("CounterReport.Source")) {
            int i = readBundle.getInt("CounterReport.Source");
            M9[] values = M9.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    m9 = values[i2];
                    if (m9.f576a == i) {
                        break;
                    }
                    i2++;
                } else {
                    m9 = M9.NATIVE;
                    break;
                }
            }
        } else {
            m9 = null;
        }
        C0477o6 c0477o6 = new C0477o6("", "", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0477o6.d = readBundle.getInt("CounterReport.Type", -1);
        c0477o6.e = readBundle.getInt("CounterReport.CustomType");
        c0477o6.b = StringUtils.ifIsNullToDef(readBundle.getString("CounterReport.Value"), "");
        c0477o6.c = readBundle.getString("CounterReport.Environment");
        c0477o6.f1018a = readBundle.getString("CounterReport.Event");
        c0477o6.f = C0477o6.a(readBundle);
        c0477o6.g = readBundle.getInt("CounterReport.TRUNCATED");
        c0477o6.h = readBundle.getString("CounterReport.ProfileID");
        c0477o6.i = readBundle.getLong("CounterReport.CreationElapsedRealtime");
        c0477o6.j = readBundle.getLong("CounterReport.CreationTimestamp");
        c0477o6.k = Da.a(Integer.valueOf(readBundle.getInt("CounterReport.UniquenessStatus")));
        c0477o6.l = m9;
        c0477o6.m = readBundle.getBundle("CounterReport.Payload");
        c0477o6.n = readBundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(readBundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        c0477o6.o = readBundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(readBundle.getInt("CounterReport.OpenId")) : null;
        c0477o6.p = CollectionUtils.bundleToMap(readBundle.getBundle("CounterReport.Extras"));
        return c0477o6;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C0477o6[i];
    }
}
