package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.k6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0376k6 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        H9 h9;
        Bundle readBundle = parcel.readBundle(W6.class.getClassLoader());
        if (readBundle.containsKey("CounterReport.Source")) {
            int i = readBundle.getInt("CounterReport.Source");
            H9[] values = H9.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    h9 = values[i2];
                    if (h9.f469a == i) {
                        break;
                    }
                    i2++;
                } else {
                    h9 = H9.NATIVE;
                    break;
                }
            }
        } else {
            h9 = null;
        }
        C0401l6 c0401l6 = new C0401l6("", "", 0);
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        c0401l6.d = readBundle.getInt("CounterReport.Type", -1);
        c0401l6.e = readBundle.getInt("CounterReport.CustomType");
        c0401l6.b = StringUtils.ifIsNullToDef(readBundle.getString("CounterReport.Value"), "");
        c0401l6.c = readBundle.getString("CounterReport.Environment");
        c0401l6.f935a = readBundle.getString("CounterReport.Event");
        c0401l6.f = C0401l6.a(readBundle);
        c0401l6.g = readBundle.getInt("CounterReport.TRUNCATED");
        c0401l6.h = readBundle.getString("CounterReport.ProfileID");
        c0401l6.i = readBundle.getLong("CounterReport.CreationElapsedRealtime");
        c0401l6.j = readBundle.getLong("CounterReport.CreationTimestamp");
        c0401l6.k = EnumC0729ya.a(Integer.valueOf(readBundle.getInt("CounterReport.UniquenessStatus")));
        c0401l6.l = h9;
        c0401l6.m = readBundle.getBundle("CounterReport.Payload");
        c0401l6.n = readBundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(readBundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        c0401l6.o = readBundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(readBundle.getInt("CounterReport.OpenId")) : null;
        c0401l6.p = CollectionUtils.bundleToMap(readBundle.getBundle("CounterReport.Extras"));
        return c0401l6;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C0401l6[i];
    }
}
