package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public final class C implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new D((C0788x) parcel.readParcelable(C0788x.class.getClassLoader()), (F) parcel.readParcelable(F.class.getClassLoader()), (C0790z) parcel.readParcelable(C0790z.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new D[i];
    }
}
