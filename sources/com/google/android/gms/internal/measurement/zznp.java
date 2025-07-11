package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zznp implements zznw {
    private final zznl zza;
    private final zzoh zzb;
    private final boolean zzc;
    private final zzlr zzd;

    private zznp(zzoh zzohVar, zzlr zzlrVar, zznl zznlVar) {
        this.zzb = zzohVar;
        this.zzc = zznlVar instanceof zzmb;
        this.zzd = zzlrVar;
        this.zza = zznlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zznp zzg(zzoh zzohVar, zzlr zzlrVar, zznl zznlVar) {
        return new zznp(zzohVar, zzlrVar, zznlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final Object zza() {
        zznl zznlVar = this.zza;
        return zznlVar instanceof zzme ? ((zzme) zznlVar).zzch() : zznlVar.zzcC().zzbf();
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean zzb(Object obj, Object obj2) {
        if (((zzme) obj).zzc.equals(((zzme) obj2).zzc)) {
            if (this.zzc) {
                return ((zzmb) obj).zzb.equals(((zzmb) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final int zzc(Object obj) {
        int hashCode = ((zzme) obj).zzc.hashCode();
        return this.zzc ? (hashCode * 53) + ((zzmb) obj).zzb.zza.hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzd(Object obj, Object obj2) {
        zzny.zzD(this.zzb, obj, obj2);
        if (this.zzc) {
            zzny.zzC(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final int zze(Object obj) {
        int zzh = ((zzme) obj).zzc.zzh();
        return this.zzc ? zzh + ((zzmb) obj).zzb.zzg() : zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzf(Object obj, zzou zzouVar) throws IOException {
        Iterator zzc = ((zzmb) obj).zzb.zzc();
        while (zzc.hasNext()) {
            Map.Entry entry = (Map.Entry) zzc.next();
            zzlu zzluVar = (zzlu) entry.getKey();
            if (zzluVar.zzc() != zzot.MESSAGE || zzluVar.zzd() || zzluVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzms) {
                zzouVar.zzv(zzluVar.zza(), ((zzms) entry).zza().zzc());
            } else {
                zzouVar.zzv(zzluVar.zza(), entry.getValue());
            }
        }
        ((zzme) obj).zzc.zzf(zzouVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkv zzkvVar) throws IOException {
        zzme zzmeVar = (zzme) obj;
        if (zzmeVar.zzc == zzoi.zza()) {
            zzmeVar.zzc = zzoi.zzb();
        }
        zzmb zzmbVar = (zzmb) obj;
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzj(Object obj) {
        this.zzb.zzb(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean zzk(Object obj) {
        return ((zzmb) obj).zzb.zze();
    }
}
