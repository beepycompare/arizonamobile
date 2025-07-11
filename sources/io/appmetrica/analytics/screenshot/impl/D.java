package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public final class D implements Parcelable {
    public static final C CREATOR = new C();

    /* renamed from: a  reason: collision with root package name */
    public final C0788x f1271a;
    public final F b;
    public final C0790z c;

    public D(C0788x c0788x, F f, C0790z c0790z) {
        this.f1271a = c0788x;
        this.b = f;
        this.c = c0790z;
    }

    public final C0788x a() {
        return this.f1271a;
    }

    public final C0790z b() {
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
        return "ParcelableScreenshotConfig(apiCaptorConfig=" + this.f1271a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1271a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public D(h0 h0Var) {
        this(r2, r3, r5 != null ? new C0790z(r5) : null);
        e0 a2 = h0Var.a();
        C0788x c0788x = a2 != null ? new C0788x(a2) : null;
        i0 c = h0Var.c();
        F f = c != null ? new F(c) : null;
        f0 b = h0Var.b();
    }
}
