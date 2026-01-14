package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
public final class E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new F((C0786z) parcel.readParcelable(C0786z.class.getClassLoader()), (H) parcel.readParcelable(H.class.getClassLoader()), (B) parcel.readParcelable(B.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new F[i];
    }
}
