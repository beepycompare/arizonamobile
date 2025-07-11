package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* renamed from: io.appmetrica.analytics.screenshot.impl.z  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0790z implements Parcelable {
    public static final C0789y CREATOR = new C0789y();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1315a;
    public final List b;
    public final long c;

    public C0790z(boolean z, List list, long j) {
        this.f1315a = z;
        this.b = list;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final boolean b() {
        return this.f1315a;
    }

    public final List c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableContentObserverCaptorConfig(enabled=" + this.f1315a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1315a ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.b);
        parcel.writeLong(this.c);
    }

    public C0790z(f0 f0Var) {
        this(f0Var.b(), f0Var.c(), f0Var.a());
    }
}
