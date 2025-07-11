package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public final class B implements Parcelable {
    public static final A CREATOR = new A();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1270a;
    public final D b;

    public B(boolean z, D d) {
        this.f1270a = z;
        this.b = d;
    }

    public final D a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1270a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableRemoteScreenshotConfig(enabled=" + this.f1270a + ", config=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1270a ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.b, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public B(g0 g0Var) {
        this(r0, r3 != null ? new D(r3) : null);
        boolean b = g0Var.b();
        h0 a2 = g0Var.a();
    }
}
