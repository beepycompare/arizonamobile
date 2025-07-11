package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.screenshot.impl.x  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0788x implements Parcelable {
    public static final C0787w CREATOR = new C0787w();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1314a;

    public C0788x(boolean z) {
        this.f1314a = z;
    }

    public final boolean a() {
        return this.f1314a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableApiCaptorConfig(enabled=" + this.f1314a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1314a ? (byte) 1 : (byte) 0);
    }

    public C0788x(e0 e0Var) {
        this(e0Var.a());
    }
}
