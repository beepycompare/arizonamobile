package io.appmetrica.analytics.screenshot.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes5.dex */
public final class B implements Parcelable {
    public static final A CREATOR = new A();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1419a;
    public final List b;
    public final long c;

    public B(boolean z, List list, long j) {
        this.f1419a = z;
        this.b = list;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final boolean b() {
        return this.f1419a;
    }

    public final List c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ParcelableContentObserverCaptorConfig(enabled=" + this.f1419a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f1419a ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.b);
        parcel.writeLong(this.c);
    }

    public B(i0 i0Var) {
        this(i0Var.b(), i0Var.c(), i0Var.a());
    }
}
