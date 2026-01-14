package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class O5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        EnumC0423m9 enumC0423m9;
        Bundle readBundle = parcel.readBundle(B6.class.getClassLoader());
        if (readBundle.containsKey("CounterReport.Source")) {
            int i = readBundle.getInt("CounterReport.Source");
            EnumC0423m9[] values = EnumC0423m9.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    enumC0423m9 = values[i2];
                    if (enumC0423m9.f1115a == i) {
                        break;
                    }
                    i2++;
                } else {
                    enumC0423m9 = EnumC0423m9.NATIVE;
                    break;
                }
            }
        } else {
            enumC0423m9 = null;
        }
        P5 p5 = new P5("", "", 0);
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        p5.d = readBundle.getInt("CounterReport.Type", -1);
        p5.e = readBundle.getInt("CounterReport.CustomType");
        p5.b = StringUtils.ifIsNullToDef(readBundle.getString("CounterReport.Value"), "");
        p5.c = readBundle.getString("CounterReport.Environment");
        p5.f737a = readBundle.getString("CounterReport.Event");
        p5.f = P5.a(readBundle);
        p5.g = readBundle.getInt("CounterReport.TRUNCATED");
        p5.h = readBundle.getString("CounterReport.ProfileID");
        p5.i = readBundle.getLong("CounterReport.CreationElapsedRealtime");
        p5.j = readBundle.getLong("CounterReport.CreationTimestamp");
        p5.k = EnumC0194da.a(Integer.valueOf(readBundle.getInt("CounterReport.UniquenessStatus")));
        p5.l = enumC0423m9;
        p5.m = readBundle.getBundle("CounterReport.Payload");
        p5.n = readBundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(readBundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        p5.o = readBundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(readBundle.getInt("CounterReport.OpenId")) : null;
        p5.p = CollectionUtils.bundleToMap(readBundle.getBundle("CounterReport.Extras"));
        return p5;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new P5[i];
    }
}
