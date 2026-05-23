package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzacq extends zzacp {
    private final byte[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacq(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzacr
    public final byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final zzacr zzc(int i, int i2) {
        byte[] bArr = this.zzb;
        int zzn = zzn(0, i2, bArr.length);
        return zzn == 0 ? zzacr.zza : new zzacm(bArr, 0, zzn);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final void zzd(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzacr
    public final void zze(zzacj zzacjVar) throws IOException {
        byte[] bArr = this.zzb;
        zzacjVar.zza(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzacr
    public final boolean zzf(zzacr zzacrVar) {
        boolean z = zzacrVar instanceof zzacq;
        if (z) {
            return Arrays.equals(this.zzb, ((zzacq) zzacrVar).zzb);
        }
        boolean z2 = zzacrVar instanceof zzacm;
        if (z2) {
            byte[] bArr = this.zzb;
            int zzb = zzacrVar.zzb();
            int length = bArr.length;
            if (length > zzb) {
                StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 18 + String.valueOf(length).length());
                sb.append("Length too large: ");
                sb.append(length);
                sb.append(length);
                throw new IllegalArgumentException(sb.toString());
            } else if (length <= zzacrVar.zzb()) {
                if (z) {
                    return zzacr.zzo(bArr, 0, ((zzacq) zzacrVar).zzb, 0, length);
                }
                if (z2) {
                    zzacm zzacmVar = (zzacm) zzacrVar;
                    return zzacr.zzo(bArr, 0, zzacmVar.zzh(), zzacmVar.zzi(), length);
                }
                return zzacrVar.zzc(0, length).equals(zzc(0, length));
            } else {
                int zzb2 = zzacrVar.zzb();
                StringBuilder sb2 = new StringBuilder(String.valueOf(length).length() + 27 + String.valueOf(zzb2).length());
                sb2.append("Ran off end of other: 0, ");
                sb2.append(length);
                sb2.append(", ");
                sb2.append(zzb2);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return zzacrVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final int zzg(int i, int i2, int i3) {
        return zzaed.zzb(i, this.zzb, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ byte[] zzh() {
        return this.zzb;
    }
}
