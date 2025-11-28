package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.screenshot.impl.z  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0783z implements Parcelable {
    public static final C0782y CREATOR = new C0782y();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1381a;

    public C0783z(boolean z) {
        this.f1381a = z;
    }

    public final boolean a() {
        return this.f1381a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableApiCaptorConfig(enabled=" + this.f1381a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1381a ? (byte) 1 : (byte) 0);
    }

    public C0783z(h0 h0Var) {
        this(h0Var.a());
    }
}
