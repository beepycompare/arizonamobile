package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public final class C implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new D((C0793x) parcel.readParcelable(C0793x.class.getClassLoader()), (F) parcel.readParcelable(F.class.getClassLoader()), (C0795z) parcel.readParcelable(C0795z.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new D[i];
    }
}
