package com.google.android.gms.internal.play_billing;

import java.io.IOException;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzep extends zzes {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    public zzep(byte[] bArr, int i, int i2) {
        super(null);
        zzj(i, i + i2, bArr.length);
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    protected final int zzd(int i, int i2, int i3) {
        return zzga.zzb(i, this.zzb, this.zzc, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final int zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final zzev zzf(int i, int i2) {
        int zzj = zzj(i, i2, this.zzd);
        return zzj == 0 ? zzev.zza : new zzep(this.zzb, this.zzc + i, zzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final void zzg(zzem zzemVar) throws IOException {
        ((zzez) zzemVar).zzc(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final boolean zzh(zzev zzevVar) {
        byte[] bArr;
        boolean z = zzevVar instanceof zzet;
        if (z || (zzevVar instanceof zzep)) {
            int i = this.zzd;
            if (i > zzevVar.zze()) {
                throw new IllegalArgumentException("Length too large: " + i + i);
            } else if (i > zzevVar.zze()) {
                int zze = zzevVar.zze();
                throw new IllegalArgumentException("Ran off end of other: 0, " + i + ", " + zze);
            } else if (z) {
                byte[] bArr2 = this.zzb;
                int i2 = this.zzc;
                bArr = ((zzet) zzevVar).zzb;
                return zzev.zzl(bArr2, i2, bArr, 0, i);
            } else if (zzevVar instanceof zzep) {
                zzep zzepVar = (zzep) zzevVar;
                return zzev.zzl(this.zzb, this.zzc, zzepVar.zzb, zzepVar.zzc, i);
            } else {
                zzev zzf = zzevVar.zzf(0, i);
                int i3 = this.zzc;
                return zzf.equals(zzf(i3, i + i3));
            }
        }
        return zzevVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final byte zza(int i) {
        int i2 = this.zzd;
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
        return this.zzb[this.zzc + i];
    }
}
