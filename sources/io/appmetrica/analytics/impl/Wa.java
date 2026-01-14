package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
public final class Wa implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new Xa(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Xa[i];
    }
}
