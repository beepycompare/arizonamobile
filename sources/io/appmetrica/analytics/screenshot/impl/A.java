package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class A implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z = parcel.readByte() != 0;
        List createStringArrayList = parcel.createStringArrayList();
        if (createStringArrayList == null) {
            createStringArrayList = CollectionsKt.emptyList();
        }
        return new B(z, createStringArrayList, parcel.readLong());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new B[i];
    }
}
