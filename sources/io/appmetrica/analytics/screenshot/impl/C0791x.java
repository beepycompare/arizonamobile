package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.screenshot.impl.x  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0791x implements Parcelable {
    public static final C0790w CREATOR = new C0790w();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1317a;

    public C0791x(boolean z) {
        this.f1317a = z;
    }

    public final boolean a() {
        return this.f1317a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableApiCaptorConfig(enabled=" + this.f1317a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1317a ? (byte) 1 : (byte) 0);
    }

    public C0791x(e0 e0Var) {
        this(e0Var.a());
    }
}
