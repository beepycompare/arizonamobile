package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: io.appmetrica.analytics.screenshot.impl.x  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0793x implements Parcelable {
    public static final C0792w CREATOR = new C0792w();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1337a;

    public C0793x(boolean z) {
        this.f1337a = z;
    }

    public final boolean a() {
        return this.f1337a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableApiCaptorConfig(enabled=" + this.f1337a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1337a ? (byte) 1 : (byte) 0);
    }

    public C0793x(e0 e0Var) {
        this(e0Var.a());
    }
}
