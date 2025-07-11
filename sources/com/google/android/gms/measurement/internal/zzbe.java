package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzbe extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbf();
    private final Bundle zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbe(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbd(this);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzf(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zza(String str) {
        return this.zza.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long zzb(String str) {
        return Long.valueOf(this.zza.getLong(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double zzc(String str) {
        return Double.valueOf(this.zza.getDouble("value"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd(String str) {
        return this.zza.getString(str);
    }

    public final int zze() {
        return this.zza.size();
    }

    public final Bundle zzf() {
        return new Bundle(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Bundle zzg() {
        return this.zza;
    }
}
