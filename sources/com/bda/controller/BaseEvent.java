package com.bda.controller;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class BaseEvent implements Parcelable {
    public static final Parcelable.Creator<BaseEvent> CREATOR = new ParcelableCreator();
    final int mControllerId;
    final long mEventTime;

    /* loaded from: classes3.dex */
    static class ParcelableCreator implements Parcelable.Creator<BaseEvent> {
        ParcelableCreator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseEvent createFromParcel(Parcel parcel) {
            return new BaseEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseEvent[] newArray(int i) {
            return new BaseEvent[i];
        }
    }

    public BaseEvent(long j, int i) {
        this.mEventTime = j;
        this.mControllerId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseEvent(Parcel parcel) {
        this.mEventTime = parcel.readLong();
        this.mControllerId = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getControllerId() {
        return this.mControllerId;
    }

    public final long getEventTime() {
        return this.mEventTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mEventTime);
        parcel.writeInt(this.mControllerId);
    }
}
