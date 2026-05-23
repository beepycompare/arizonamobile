package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.logging.Level;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzxz implements zzyi, zzzd {
    private static final String zza = new String();
    private final Level zzb;
    private final long zzc;
    private zzxy zzd;
    private zzyc zze;
    private zzyq zzf;
    private zzaaf zzg;
    private Object[] zzh;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzxz(Level level, boolean z) {
        long zzk = zzaad.zzk();
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzh = null;
        zzabr.zza(level, FirebaseAnalytics.Param.LEVEL);
        this.zzb = level;
        this.zzc = zzk;
    }

    protected abstract zzabn zza();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zzb(zzyd zzydVar) {
        zzxy zzxyVar = this.zzd;
        if (zzxyVar != null) {
            if (zzydVar != null) {
                zzyq zzc = zzyq.zzc(zzyq.zzc(zzxn.zza(zzxyVar, zzydVar, this.zzc), zzxk.zza(this.zzd, zzydVar)), zzyt.zza(this.zzd, zzydVar));
                this.zzf = zzc;
                if (zzc == zzyq.zzc) {
                    return false;
                }
            }
            zzxy zzxyVar2 = this.zzd;
            zzyl zzylVar = zzxx.zzi;
            zzyv zzyvVar = (zzyv) zzxyVar2.zzd(zzylVar);
            if (zzyvVar != null) {
                zzxy zzxyVar3 = this.zzd;
                if (zzxyVar3 != null) {
                    zzxyVar3.zzf(zzylVar);
                }
                zzzj zzl = zzl();
                zzyl zzylVar2 = zzxx.zza;
                zzm(zzylVar2, new zzyg((Throwable) zzl.zzd(zzylVar2), zzyvVar, zzabq.zzb(zzxz.class, zzyvVar.zza(), 1)));
            }
        }
        return true;
    }

    protected abstract zzxi zzc();

    protected abstract zzyi zzd();

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final Level zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final long zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final zzyc zzg() {
        zzyc zzycVar = this.zze;
        if (zzycVar != null) {
            return zzycVar;
        }
        throw new IllegalStateException("cannot request log site information prior to postProcess()");
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final zzaaf zzh() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final Object[] zzi() {
        zzabr.zzc(this.zzg != null, "cannot get arguments unless a template context exists");
        Object[] objArr = this.zzh;
        if (objArr != null) {
            return objArr;
        }
        throw new IllegalStateException("cannot get arguments before calling log()");
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final Object zzj() {
        zzabr.zzc(this.zzg == null, "cannot get literal argument if a template context exists");
        Object[] objArr = this.zzh;
        if (objArr == null) {
            throw new IllegalStateException("cannot get literal argument before calling log()");
        }
        return objArr[0];
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final boolean zzk() {
        return this.zzd != null && Boolean.TRUE.equals(this.zzd.zzd(zzxx.zzg));
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final zzzj zzl() {
        zzxy zzxyVar = this.zzd;
        return zzxyVar != null ? zzxyVar : zzzj.zzg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzm(zzyl zzylVar, Object obj) {
        if (this.zzd == null) {
            this.zzd = new zzxy();
        }
        this.zzd.zze(zzylVar, obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final zzyi zzn(String str, String str2, int i, String str3) {
        zzyc zzycVar = zzyc.zza;
        zzyb zzybVar = new zzyb("com/google/android/libraries/phenotype/client/Phlogger", "logInternal", 44, "Phlogger.java", null);
        if (this.zze == null) {
            this.zze = zzybVar;
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final zzyi zzo(Throwable th) {
        zzyl zzylVar = zzxx.zza;
        zzabr.zza(zzylVar, "metadata key");
        if (th != null) {
            zzm(zzylVar, th);
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final void zzp(String str, Object[] objArr) {
        zzyd zzydVar;
        zzxy zzxyVar;
        if (this.zze == null) {
            this.zze = zzaad.zzb().zzb(zzxz.class, 1);
        }
        if (this.zze != zzyc.zza) {
            zzydVar = this.zze;
            zzxy zzxyVar2 = this.zzd;
            if (zzxyVar2 != null && zzxyVar2.zza() > 0) {
                zzabr.zza(zzydVar, "logSiteKey");
                int zza2 = zzxyVar2.zza();
                for (int i = 0; i < zza2; i++) {
                    if (zzxx.zzf.equals(zzxyVar2.zzb(i))) {
                        Object zzc = zzxyVar2.zzc(i);
                        if (zzc instanceof zzyj) {
                            zzydVar = ((zzyj) zzc).zzb();
                        } else {
                            zzydVar = zzyu.zza(zzydVar, zzc);
                        }
                    }
                }
            }
        } else {
            zzydVar = null;
        }
        boolean zzb = zzb(zzydVar);
        zzyq zzyqVar = this.zzf;
        if (zzyqVar != null) {
            int zza3 = zzyp.zza(zzyqVar, zzydVar, this.zzd);
            if (zzb && zza3 > 0 && (zzxyVar = this.zzd) != null) {
                zzxyVar.zze(zzxx.zze, Integer.valueOf(zza3));
            }
            zzb &= zza3 >= 0;
        }
        if (zzb) {
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            this.zzh = copyOf;
            for (int i2 = 0; i2 < copyOf.length; i2++) {
                Object obj = copyOf[i2];
                if (obj instanceof zzxu) {
                    copyOf[i2] = ((zzxu) obj).zza();
                }
            }
            if (str != zza) {
                this.zzg = new zzaaf(zza(), str);
            }
            zzabe zzi = zzaad.zzi();
            if (!zzi.zzc()) {
                zzzj zzl = zzl();
                zzyl zzylVar = zzxx.zzh;
                zzabe zzabeVar = (zzabe) zzl.zzd(zzylVar);
                if (zzabeVar != null) {
                    zzi = zzi.zzd(zzabeVar);
                }
                zzm(zzylVar, zzi);
            }
            zzc().zzc(this);
        }
    }
}
