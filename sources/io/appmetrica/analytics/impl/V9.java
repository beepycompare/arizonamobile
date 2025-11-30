package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* loaded from: classes5.dex */
public final class V9 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Object readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        return new W9(readValue instanceof Boolean ? (Boolean) readValue : null, IdentifierStatus.Companion.from(parcel.readString()), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new W9[i];
    }
}
