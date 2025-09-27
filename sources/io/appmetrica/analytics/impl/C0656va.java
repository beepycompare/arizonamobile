package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.va  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0656va implements Parcelable {
    public static final C0631ua CREATOR = new C0631ua();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f1124a;
    public final IdentifierStatus b;
    public final String c;

    public C0656va(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f1124a = bool;
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
        if (obj instanceof C0656va) {
            C0656va c0656va = (C0656va) obj;
            return Intrinsics.areEqual(this.f1124a, c0656va.f1124a) && this.b == c0656va.b && Intrinsics.areEqual(this.c, c0656va.c);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f1124a;
        int hashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f1124a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f1124a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public C0656va() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
