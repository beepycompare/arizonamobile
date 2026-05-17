package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class V9 implements Parcelable {
    public static final U9 CREATOR = new U9();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f830a;
    public final IdentifierStatus b;
    public final String c;

    public V9(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f830a = bool;
        this.b = identifierStatus;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof V9) {
            V9 v9 = (V9) obj;
            return Intrinsics.areEqual(this.f830a, v9.f830a) && this.b == v9.b && Intrinsics.areEqual(this.c, v9.c);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f830a;
        int hashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f830a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f830a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public V9() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
