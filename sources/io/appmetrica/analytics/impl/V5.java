package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class V5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        EnumC0594t9 enumC0594t9;
        Bundle readBundle = parcel.readBundle(I6.class.getClassLoader());
        if (readBundle.containsKey("CounterReport.Source")) {
            int i = readBundle.getInt("CounterReport.Source");
            EnumC0594t9[] values = EnumC0594t9.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    enumC0594t9 = values[i2];
                    if (enumC0594t9.f1130a == i) {
                        break;
                    }
                    i2++;
                } else {
                    enumC0594t9 = EnumC0594t9.NATIVE;
                    break;
                }
            }
        } else {
            enumC0594t9 = null;
        }
        W5 w5 = new W5("", "", 0);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        w5.d = readBundle.getInt("CounterReport.Type", -1);
        w5.e = readBundle.getInt("CounterReport.CustomType");
        w5.b = StringUtils.ifIsNullToDef(readBundle.getString("CounterReport.Value"), "");
        w5.c = readBundle.getString("CounterReport.Environment");
        w5.f741a = readBundle.getString("CounterReport.Event");
        w5.f = W5.a(readBundle);
        w5.g = readBundle.getInt("CounterReport.TRUNCATED");
        w5.h = readBundle.getString("CounterReport.ProfileID");
        w5.i = readBundle.getLong("CounterReport.CreationElapsedRealtime");
        w5.j = readBundle.getLong("CounterReport.CreationTimestamp");
        w5.k = EnumC0370ka.a(Integer.valueOf(readBundle.getInt("CounterReport.UniquenessStatus")));
        w5.l = enumC0594t9;
        w5.m = readBundle.getBundle("CounterReport.Payload");
        w5.n = readBundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(readBundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        w5.o = readBundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(readBundle.getInt("CounterReport.OpenId")) : null;
        w5.p = CollectionUtils.bundleToMap(readBundle.getBundle("CounterReport.Extras"));
        return w5;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new W5[i];
    }
}
