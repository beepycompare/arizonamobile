package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.screenshot.impl.z  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0785z implements Parcelable {
    public static final C0784y CREATOR = new C0784y();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1494a;

    public C0785z(boolean z) {
        this.f1494a = z;
    }

    public final boolean a() {
        return this.f1494a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableApiCaptorConfig(enabled=" + this.f1494a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1494a ? (byte) 1 : (byte) 0);
    }

    public C0785z(h0 h0Var) {
        this(h0Var.a());
    }
}
