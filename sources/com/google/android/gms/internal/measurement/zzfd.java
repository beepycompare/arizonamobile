package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzfd extends zzme implements zznm {
    private static final zzfd zzi;
    private int zzb;
    private int zzd;
    private zzmn zze = zzcv();
    private zzmn zzf = zzcv();
    private boolean zzg;
    private boolean zzh;

    static {
        zzfd zzfdVar = new zzfd();
        zzi = zzfdVar;
        zzme.zzcp(zzfd.class, zzfdVar);
    }

    private zzfd() {
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final zzfn zze(int i) {
        return (zzfn) this.zze.get(i);
    }

    public final List zzf() {
        return this.zzf;
    }

    public final int zzg() {
        return this.zzf.size();
    }

    public final zzff zzh(int i) {
        return (zzff) this.zzf.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(int i, zzfn zzfnVar) {
        zzfnVar.getClass();
        zzmn zzmnVar = this.zze;
        if (!zzmnVar.zza()) {
            this.zze = zzme.zzcw(zzmnVar);
        }
        this.zze.set(i, zzfnVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, zzff zzffVar) {
        zzffVar.getClass();
        zzmn zzmnVar = this.zzf;
        if (!zzmnVar.zza()) {
            this.zzf = zzme.zzcw(zzmnVar);
        }
        this.zzf.set(i, zzffVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", zzfn.class, "zzf", zzff.class, "zzg", "zzh"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzi;
                    }
                    throw null;
                }
                return new zzfc(null);
            } else {
                return new zzfd();
            }
        }
        return (byte) 1;
    }
}
