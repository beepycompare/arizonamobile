package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public final class D implements Parcelable {
    public static final C CREATOR = new C();

    /* renamed from: a  reason: collision with root package name */
    public final C0796x f1270a;
    public final F b;
    public final C0798z c;

    public D(C0796x c0796x, F f, C0798z c0798z) {
        this.f1270a = c0796x;
        this.b = f;
        this.c = c0798z;
    }

    public final C0796x a() {
        return this.f1270a;
    }

    public final C0798z b() {
        return this.c;
    }

    public final F c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableScreenshotConfig(apiCaptorConfig=" + this.f1270a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1270a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public D(h0 h0Var) {
        this(r2, r3, r5 != null ? new C0798z(r5) : null);
        e0 a2 = h0Var.a();
        C0796x c0796x = a2 != null ? new C0796x(a2) : null;
        i0 c = h0Var.c();
        F f = c != null ? new F(c) : null;
        f0 b = h0Var.b();
    }
}
