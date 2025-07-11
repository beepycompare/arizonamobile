package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.oa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0478oa implements Parcelable {
    public static final C0453na CREATOR = new C0453na();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f971a;
    public final IdentifierStatus b;
    public final String c;

    public C0478oa(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f971a = bool;
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
        if (obj instanceof C0478oa) {
            C0478oa c0478oa = (C0478oa) obj;
            return Intrinsics.areEqual(this.f971a, c0478oa.f971a) && this.b == c0478oa.b && Intrinsics.areEqual(this.c, c0478oa.c);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f971a;
        int hashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f971a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f971a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public C0478oa() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
