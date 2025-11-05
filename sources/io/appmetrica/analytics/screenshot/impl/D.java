package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class D implements Parcelable {
    public static final C CREATOR = new C();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1335a;
    public final F b;

    public D(boolean z, F f) {
        this.f1335a = z;
        this.b = f;
    }

    public final F a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1335a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableRemoteScreenshotConfig(enabled=" + this.f1335a + ", config=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1335a ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.b, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public D(j0 j0Var) {
        this(r0, r3 != null ? new F(r3) : null);
        boolean b = j0Var.b();
        k0 a2 = j0Var.a();
    }
}
