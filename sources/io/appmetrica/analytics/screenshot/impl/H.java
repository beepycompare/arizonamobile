package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class H implements Parcelable {
    public static final G CREATOR = new G();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1337a;
    public final long b;

    public H(boolean z, long j) {
        this.f1337a = z;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1337a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableServiceCaptorConfig(enabled=" + this.f1337a + ", delaySeconds=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1337a ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.b);
    }

    public H(l0 l0Var) {
        this(l0Var.b(), l0Var.a());
    }
}
