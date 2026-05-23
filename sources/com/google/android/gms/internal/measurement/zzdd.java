package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    public final int zza;
    public final String zzb;
    public final Intent zzc;

    public zzdd(int i, String str, Intent intent) {
        this.zza = i;
        this.zzb = str;
        this.zzc = intent;
    }

    public static zzdd zza(Activity activity) {
        return new zzdd(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdd) {
            zzdd zzddVar = (zzdd) obj;
            return this.zza == zzddVar.zza && Objects.equals(this.zzb, zzddVar.zzb) && Objects.equals(this.zzc, zzddVar.zzc);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
