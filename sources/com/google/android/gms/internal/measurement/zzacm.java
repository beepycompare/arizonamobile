package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
final class zzacm extends zzacp {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacm(byte[] bArr, int i, int i2) {
        super(null);
        zzn(i, i + i2, bArr.length);
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzacr
    public final byte zza(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final zzacr zzc(int i, int i2) {
        int zzn = zzn(i, i2, this.zzd);
        return zzn == 0 ? zzacr.zza : new zzacm(this.zzb, this.zzc + i, zzn);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final void zzd(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, this.zzc, bArr, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzacr
    public final void zze(zzacj zzacjVar) throws IOException {
        zzacjVar.zza(this.zzb, this.zzc, this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzacr
    public final boolean zzf(zzacr zzacrVar) {
        boolean z = zzacrVar instanceof zzacq;
        if (z || (zzacrVar instanceof zzacm)) {
            int i = this.zzd;
            if (i > zzacrVar.zzb()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i).length());
                sb.append("Length too large: ");
                sb.append(i);
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            } else if (i <= zzacrVar.zzb()) {
                if (z) {
                    return zzacr.zzo(this.zzb, this.zzc, ((zzacq) zzacrVar).zzh(), 0, i);
                }
                if (zzacrVar instanceof zzacm) {
                    zzacm zzacmVar = (zzacm) zzacrVar;
                    return zzacr.zzo(this.zzb, this.zzc, zzacmVar.zzb, zzacmVar.zzc, i);
                }
                zzacr zzc = zzacrVar.zzc(0, i);
                int i2 = this.zzc;
                return zzc.equals(zzc(i2, i + i2));
            } else {
                int zzb = zzacrVar.zzb();
                StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 27 + String.valueOf(zzb).length());
                sb2.append("Ran off end of other: 0, ");
                sb2.append(i);
                sb2.append(", ");
                sb2.append(zzb);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return zzacrVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final int zzg(int i, int i2, int i3) {
        return zzaed.zzb(i, this.zzb, this.zzc, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ byte[] zzh() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzi() {
        return this.zzc;
    }
}
