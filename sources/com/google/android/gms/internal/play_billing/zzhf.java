package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzhf implements zzhl {
    private final zzhb zza;
    private final zzib zzb;
    private final boolean zzc;
    private final zzfi zzd;

    private zzhf(zzib zzibVar, zzfi zzfiVar, zzhb zzhbVar) {
        this.zzb = zzibVar;
        this.zzc = zzhbVar instanceof zzfr;
        this.zzd = zzfiVar;
        this.zza = zzhbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhf zzc(zzib zzibVar, zzfi zzfiVar, zzhb zzhbVar) {
        return new zzhf(zzibVar, zzfiVar, zzhbVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zza(Object obj) {
        int zzb = ((zzfu) obj).zzc.zzb();
        return this.zzc ? zzb + ((zzfr) obj).zzb.zzd() : zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zzb(Object obj) {
        int hashCode = ((zzfu) obj).zzc.hashCode();
        return this.zzc ? (hashCode * 53) + ((zzfr) obj).zzb.zza.hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final Object zze() {
        zzhb zzhbVar = this.zza;
        return zzhbVar instanceof zzfu ? ((zzfu) zzhbVar).zzs() : zzhbVar.zzw().zzk();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzf(Object obj) {
        this.zzb.zzb(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzg(Object obj, Object obj2) {
        zzhn.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhn.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzej zzejVar) throws IOException {
        zzfu zzfuVar = (zzfu) obj;
        if (zzfuVar.zzc == zzic.zzc()) {
            zzfuVar.zzc = zzic.zzf();
        }
        zzfr zzfrVar = (zzfr) obj;
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzi(Object obj, zzit zzitVar) throws IOException {
        Iterator zzf = ((zzfr) obj).zzb.zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzfl zzflVar = (zzfl) entry.getKey();
            if (zzflVar.zzc() != zzis.MESSAGE || zzflVar.zze() || zzflVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzge) {
                zzitVar.zzx(zzflVar.zza(), ((zzge) entry).zza().zzb());
            } else {
                zzitVar.zzx(zzflVar.zza(), entry.getValue());
            }
        }
        ((zzfu) obj).zzc.zzk(zzitVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final boolean zzj(Object obj, Object obj2) {
        if (((zzfu) obj).zzc.equals(((zzfu) obj2).zzc)) {
            if (this.zzc) {
                return ((zzfr) obj).zzb.equals(((zzfr) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final boolean zzk(Object obj) {
        return ((zzfr) obj).zzb.zzj();
    }
}
