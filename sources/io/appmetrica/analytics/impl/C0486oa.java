package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.oa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0486oa implements Parcelable {
    public static final C0461na CREATOR = new C0461na();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f970a;
    public final IdentifierStatus b;
    public final String c;

    public C0486oa(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f970a = bool;
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
        if (obj instanceof C0486oa) {
            C0486oa c0486oa = (C0486oa) obj;
            return Intrinsics.areEqual(this.f970a, c0486oa.f970a) && this.b == c0486oa.b && Intrinsics.areEqual(this.c, c0486oa.c);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f970a;
        int hashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f970a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f970a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public C0486oa() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
