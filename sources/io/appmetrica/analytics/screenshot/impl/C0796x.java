package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.screenshot.impl.x  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0796x implements Parcelable {
    public static final C0795w CREATOR = new C0795w();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1313a;

    public C0796x(boolean z) {
        this.f1313a = z;
    }

    public final boolean a() {
        return this.f1313a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableApiCaptorConfig(enabled=" + this.f1313a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1313a ? (byte) 1 : (byte) 0);
    }

    public C0796x(e0 e0Var) {
        this(e0Var.a());
    }
}
