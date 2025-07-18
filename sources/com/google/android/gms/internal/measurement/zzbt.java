package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zzbt extends zzbz {
    private String zza;
    private byte zzb;
    private int zzc;
    private int zzd;

    public final zzbz zza(String str) {
        this.zza = "";
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzbz
    public final zzbz zzb(boolean z) {
        this.zzb = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzbz
    public final zzca zzc() {
        if (this.zzb != 1 || this.zza == null || this.zzc == 0 || this.zzd == 0) {
            StringBuilder sb = new StringBuilder();
            if (this.zza == null) {
                sb.append(" fileOwner");
            }
            if (this.zzb == 0) {
                sb.append(" hasDifferentDmaOwner");
            }
            if (this.zzc == 0) {
                sb.append(" fileChecks");
            }
            if (this.zzd == 0) {
                sb.append(" filePurpose");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new zzbu(this.zza, false, this.zzc, null, null, this.zzd, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzbz
    final zzbz zzd(int i) {
        this.zzc = i;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzbz
    public final zzbz zze(int i) {
        this.zzd = 1;
        return this;
    }
}
