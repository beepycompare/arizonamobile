package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public final class F implements Parcelable {
    public static final E CREATOR = new E();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1272a;
    public final long b;

    public F(boolean z, long j) {
        this.f1272a = z;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1272a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableServiceCaptorConfig(enabled=" + this.f1272a + ", delaySeconds=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1272a ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.b);
    }

    public F(i0 i0Var) {
        this(i0Var.b(), i0Var.a());
    }
}
