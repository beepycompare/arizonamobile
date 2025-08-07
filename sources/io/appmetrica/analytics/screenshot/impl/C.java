package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public final class C implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new D((C0791x) parcel.readParcelable(C0791x.class.getClassLoader()), (F) parcel.readParcelable(F.class.getClassLoader()), (C0793z) parcel.readParcelable(C0793z.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new D[i];
    }
}
