package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpr extends zzadu implements zzafd {
    private static final zzpr zzl;
    private static volatile zzafj zzm;
    private int zzb;
    private boolean zzf;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private String zze = "";
    private zzaef zzg = zzcy();

    static {
        zzpr zzprVar = new zzpr();
        zzl = zzprVar;
        zzadu.zzcs(zzpr.class, zzprVar);
    }

    private zzpr() {
    }

    public static zzpr zzh(InputStream inputStream, zzadf zzadfVar) throws IOException {
        return (zzpr) zzadu.zzcB(zzl, inputStream, zzadfVar);
    }

    public final String zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final zzabz zzc() {
        zzabz zzb = zzabz.zzb(this.zzh);
        return zzb == null ? zzabz.UNKNOWN : zzb;
    }

    public final boolean zzd() {
        return this.zzi;
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzl, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003\u001a\u0004᠌\u0002\u0005ဇ\u0003\u0006ဇ\u0005\u0007ဇ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", zzabz.zzc(), "zzi", "zzk", "zzj"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzm;
                            if (zzafjVar2 == null) {
                                synchronized (zzpr.class) {
                                    zzafjVar = zzm;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzl);
                                        zzm = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzl;
                }
                return new zzpq(null);
            } else {
                return new zzpr();
            }
        }
        return (byte) 1;
    }
}
