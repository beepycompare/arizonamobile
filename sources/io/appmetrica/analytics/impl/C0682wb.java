package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.impl.wb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0682wb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new C0707xb(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C0707xb[i];
    }
}
