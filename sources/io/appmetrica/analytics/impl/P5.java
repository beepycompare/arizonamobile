package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class P5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        EnumC0445n9 enumC0445n9;
        Bundle readBundle = parcel.readBundle(C6.class.getClassLoader());
        if (readBundle.containsKey("CounterReport.Source")) {
            int i = readBundle.getInt("CounterReport.Source");
            EnumC0445n9[] values = EnumC0445n9.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    enumC0445n9 = values[i2];
                    if (enumC0445n9.f1027a == i) {
                        break;
                    }
                    i2++;
                } else {
                    enumC0445n9 = EnumC0445n9.NATIVE;
                    break;
                }
            }
        } else {
            enumC0445n9 = null;
        }
        Q5 q5 = new Q5("", "", 0);
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        q5.d = readBundle.getInt("CounterReport.Type", -1);
        q5.e = readBundle.getInt("CounterReport.CustomType");
        q5.b = StringUtils.ifIsNullToDef(readBundle.getString("CounterReport.Value"), "");
        q5.c = readBundle.getString("CounterReport.Environment");
        q5.f648a = readBundle.getString("CounterReport.Event");
        q5.f = Q5.a(readBundle);
        q5.g = readBundle.getInt("CounterReport.TRUNCATED");
        q5.h = readBundle.getString("CounterReport.ProfileID");
        q5.i = readBundle.getLong("CounterReport.CreationElapsedRealtime");
        q5.j = readBundle.getLong("CounterReport.CreationTimestamp");
        q5.k = EnumC0215ea.a(Integer.valueOf(readBundle.getInt("CounterReport.UniquenessStatus")));
        q5.l = enumC0445n9;
        q5.m = readBundle.getBundle("CounterReport.Payload");
        q5.n = readBundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(readBundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        q5.o = readBundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(readBundle.getInt("CounterReport.OpenId")) : null;
        q5.p = CollectionUtils.bundleToMap(readBundle.getBundle("CounterReport.Extras"));
        return q5;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Q5[i];
    }
}
