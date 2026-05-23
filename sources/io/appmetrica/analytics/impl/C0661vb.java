package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.impl.vb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0661vb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new C0687wb(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C0687wb[i];
    }
}
