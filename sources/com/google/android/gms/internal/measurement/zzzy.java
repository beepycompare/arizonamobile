package com.google.android.gms.internal.measurement;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzzy extends zzaaa {
    private final zzzj zza;
    private final zzzj zzb;
    private final int[] zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzzy(zzzj zzzjVar, zzzj zzzjVar2, byte[] bArr) {
        super(null);
        this.zza = zzzjVar;
        this.zzb = zzzjVar2;
        int zza = zzzjVar2.zza();
        zzabr.zzb(zza <= 28, "metadata size too large");
        int[] iArr = new int[zza];
        this.zzc = iArr;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            zzyl zzd = zzd(i);
            long zzi = zzd.zzi() | j;
            if (zzi == j) {
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        i3 = -1;
                        break;
                    } else if (zzd.equals(zzd(iArr[i3] & 31))) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    iArr[i3] = zzd.zzf() ? iArr[i3] | (1 << (i + 4)) : i;
                    i++;
                    j = zzi;
                }
            }
            iArr[i2] = i;
            i2++;
            i++;
            j = zzi;
        }
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzi */
    public final zzyl zzd(int i) {
        zzzj zzzjVar = this.zza;
        int zza = zzzjVar.zza();
        return i >= zza ? this.zzb.zzb(i - zza) : zzzjVar.zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzj */
    public final Object zze(int i) {
        zzzj zzzjVar = this.zza;
        int zza = zzzjVar.zza();
        return i >= zza ? this.zzb.zzc(i - zza) : zzzjVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final void zza(zzzq zzzqVar, Object obj) {
        for (int i = 0; i < this.zzd; i++) {
            int i2 = this.zzc[i];
            zzyl zzd = zzd(i2 & 31);
            if (!zzd.zzf()) {
                zzzqVar.zza(zzd, zzd.zze(zze(i2)), obj);
            } else {
                zzzqVar.zzb(zzd, new zzzx(this, zzd, i2, null), obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final Set zzc() {
        return new zzzw(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int[] zzf() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzg() {
        return this.zzd;
    }
}
