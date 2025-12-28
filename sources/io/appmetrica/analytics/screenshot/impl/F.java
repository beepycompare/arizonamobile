package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
public final class F implements Parcelable {
    public static final E CREATOR = new E();

    /* renamed from: a  reason: collision with root package name */
    public final C0782z f1436a;
    public final H b;
    public final B c;

    public F(C0782z c0782z, H h, B b) {
        this.f1436a = c0782z;
        this.b = h;
        this.c = b;
    }

    public final C0782z a() {
        return this.f1436a;
    }

    public final B b() {
        return this.c;
    }

    public final H c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableScreenshotConfig(apiCaptorConfig=" + this.f1436a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1436a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public F(k0 k0Var) {
        this(r2, r3, r5 != null ? new B(r5) : null);
        h0 a2 = k0Var.a();
        C0782z c0782z = a2 != null ? new C0782z(a2) : null;
        l0 c = k0Var.c();
        H h = c != null ? new H(c) : null;
        i0 b = k0Var.b();
    }
}
