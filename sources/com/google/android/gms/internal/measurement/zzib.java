package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzib extends zzadu implements zzafd {
    private static final zzib zzi;
    private static volatile zzafj zzj;
    private int zzb;
    private zzaef zze = zzcy();
    private String zzf = "";
    private String zzg = "";
    private int zzh;

    static {
        zzib zzibVar = new zzib();
        zzi = zzibVar;
        zzadu.zzcs(zzib.class, zzibVar);
    }

    private zzib() {
    }

    public static zzhz zzi() {
        return (zzhz) zzi.zzcn();
    }

    public static zzhz zzj(zzib zzibVar) {
        zzadp zzcn = zzi.zzcn();
        zzcn.zzbe(zzibVar);
        return (zzhz) zzcn;
    }

    private final void zzr() {
        zzaef zzaefVar = this.zze;
        if (zzaefVar.zza()) {
            return;
        }
        this.zze = zzadu.zzcz(zzaefVar);
    }

    public final List zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final zzid zzc(int i) {
        return (zzid) this.zze.get(i);
    }

    public final boolean zzd() {
        return (this.zzb & 1) != 0;
    }

    public final String zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return (this.zzb & 2) != 0;
    }

    public final String zzh() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(int i, zzid zzidVar) {
        zzidVar.getClass();
        zzr();
        this.zze.set(i, zzidVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzid zzidVar) {
        zzidVar.getClass();
        zzr();
        this.zze.add(zzidVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Iterable iterable) {
        zzr();
        zzacb.zzcg(iterable, this.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn() {
        this.zze = zzcy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzi, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zze", zzid.class, "zzf", "zzg", "zzh", zzia.zza});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzj;
                            if (zzafjVar2 == null) {
                                synchronized (zzib.class) {
                                    zzafjVar = zzj;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzi);
                                        zzj = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzi;
                }
                return new zzhz(null);
            } else {
                return new zzib();
            }
        }
        return (byte) 1;
    }
}
