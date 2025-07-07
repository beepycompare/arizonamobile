package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.y  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0797y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z = parcel.readByte() != 0;
        List createStringArrayList = parcel.createStringArrayList();
        if (createStringArrayList == null) {
            createStringArrayList = CollectionsKt.emptyList();
        }
        return new C0798z(z, createStringArrayList, parcel.readLong());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C0798z[i];
    }
}
