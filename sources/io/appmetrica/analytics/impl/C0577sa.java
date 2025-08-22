package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.sa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0577sa implements Parcelable {
    public static final C0552ra CREATOR = new C0552ra();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f1058a;
    public final IdentifierStatus b;
    public final String c;

    public C0577sa(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f1058a = bool;
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
        if (obj instanceof C0577sa) {
            C0577sa c0577sa = (C0577sa) obj;
            return Intrinsics.areEqual(this.f1058a, c0577sa.f1058a) && this.b == c0577sa.b && Intrinsics.areEqual(this.c, c0577sa.c);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f1058a;
        int hashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f1058a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f1058a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public C0577sa() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
