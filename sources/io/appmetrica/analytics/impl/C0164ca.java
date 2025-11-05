package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0164ca implements Parcelable {
    public static final C0138ba CREATOR = new C0138ba();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f827a;
    public final IdentifierStatus b;
    public final String c;

    public C0164ca(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f827a = bool;
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
        if (obj instanceof C0164ca) {
            C0164ca c0164ca = (C0164ca) obj;
            return Intrinsics.areEqual(this.f827a, c0164ca.f827a) && this.b == c0164ca.b && Intrinsics.areEqual(this.c, c0164ca.c);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f827a;
        int hashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f827a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f827a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public C0164ca() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
