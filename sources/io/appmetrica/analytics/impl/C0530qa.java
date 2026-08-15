package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.qa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0530qa implements Parcelable {
    public static final C0504pa CREATOR = new C0504pa();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f1165a;
    public final IdentifierStatus b;
    public final String c;

    public C0530qa(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f1165a = bool;
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
        if (obj instanceof C0530qa) {
            C0530qa c0530qa = (C0530qa) obj;
            return Intrinsics.areEqual(this.f1165a, c0530qa.f1165a) && this.b == c0530qa.b && Intrinsics.areEqual(this.c, c0530qa.c);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f1165a;
        int hashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f1165a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f1165a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public C0530qa() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
