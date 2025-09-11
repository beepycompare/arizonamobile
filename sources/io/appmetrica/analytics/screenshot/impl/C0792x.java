package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.screenshot.impl.x  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0792x implements Parcelable {
    public static final C0791w CREATOR = new C0791w();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1336a;

    public C0792x(boolean z) {
        this.f1336a = z;
    }

    public final boolean a() {
        return this.f1336a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableApiCaptorConfig(enabled=" + this.f1336a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1336a ? (byte) 1 : (byte) 0);
    }

    public C0792x(e0 e0Var) {
        this(e0Var.a());
    }
}
