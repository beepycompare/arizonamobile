package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.qa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0524qa implements Parcelable {
    public static final C0498pa CREATOR = new C0498pa();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f1168a;
    public final IdentifierStatus b;
    public final String c;

    public C0524qa(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f1168a = bool;
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
        if (obj instanceof C0524qa) {
            C0524qa c0524qa = (C0524qa) obj;
            return Intrinsics.areEqual(this.f1168a, c0524qa.f1168a) && this.b == c0524qa.b && Intrinsics.areEqual(this.c, c0524qa.c);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f1168a;
        int hashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f1168a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f1168a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public C0524qa() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
