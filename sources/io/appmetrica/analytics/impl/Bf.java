package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public final class Bf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Bundle readBundle = parcel.readBundle(C6.class.getClassLoader());
        return new Cf((ContentValues) readBundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT"), (ResultReceiver) readBundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT_RECEIVER"));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Cf[i];
    }
}
