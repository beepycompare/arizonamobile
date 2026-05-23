package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zznd {
    private static final zznd zza = new zznd(zzmw.zzb(), zzmq.zzi());
    private final zzmw zzb;
    private final zzmq zzc;

    private zznd(zzmw zzmwVar, zzmq zzmqVar) {
        this.zzb = (zzmw) Preconditions.checkNotNull(zzmwVar);
        this.zzc = zzmqVar;
    }

    public static zznd zza() {
        return zza;
    }

    public static zznd zzb(zzacv zzacvVar, boolean z) throws IOException {
        zzmw zzmwVar;
        int zzr = zzacvVar.zzr();
        if (zzr > 1) {
            StringBuilder sb = new StringBuilder(String.valueOf(zzr).length() + 44);
            sb.append("Unsupported version: ");
            sb.append(zzr);
            sb.append(". Current version is: 1");
            throw new zzaeh(sb.toString());
        }
        zzacvVar.zzr();
        int zzD = zzacvVar.zzD(zzacvVar.zzp());
        zzmq zzh = zzmq.zzh(zzacvVar, zzadf.zza());
        zzacvVar.zzE(zzD);
        zzmu zza2 = zzmu.zza();
        try {
            if (z) {
                int zzD2 = zzacvVar.zzD(zzacvVar.zzp());
                zzmwVar = (zzmw) zza2.zzc(zzacvVar, zznb.zza);
                if (zzacvVar.zzF() != 0) {
                    throw new zzaeh("Unexpected bytes remaining after FlagsBlob parsing.");
                }
                zzacvVar.zzE(zzD2);
            } else {
                zzmwVar = (zzmw) zza2.zzb(zzacvVar.zzo(), zznc.zza);
            }
            zza2.close();
            return new zznd(zzmwVar, zzh);
        } catch (Throwable th) {
            try {
                zza2.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final zzmw zzc() {
        ImmutableMap buildKeepingLast;
        zzmq zzmqVar = this.zzc;
        int zze = zzmqVar.zze();
        zzmw zzmwVar = this.zzb;
        if (zze > 0) {
            Collection<zzmi> values = zzmqVar.zzf().values();
            if (values == null) {
                buildKeepingLast = ImmutableMap.of();
            } else {
                ImmutableMap.Builder builder = ImmutableMap.builder();
                for (zzmi zzmiVar : values) {
                    int zzq = zzmiVar.zzq();
                    int i = zzq - 1;
                    if (zzq == 0) {
                        throw null;
                    }
                    if (i == 0) {
                        builder.put(zzmiVar.zza(), Long.valueOf(zzmiVar.zzb()));
                    } else if (i == 1) {
                        builder.put(zzmiVar.zza(), Boolean.valueOf(zzmiVar.zzc()));
                    } else if (i == 2) {
                        builder.put(zzmiVar.zza(), Double.valueOf(zzmiVar.zzd()));
                    } else if (i == 3) {
                        builder.put(zzmiVar.zza(), zzmiVar.zze());
                    } else if (i == 4) {
                        builder.put(zzmiVar.zza(), zzmiVar.zzf().zzm());
                    } else {
                        String zza2 = zzmiVar.zza();
                        String.valueOf(zza2);
                        throw new IllegalStateException("Could not serialize Flag for override: ".concat(String.valueOf(zza2)));
                    }
                }
                buildKeepingLast = builder.buildKeepingLast();
            }
            return zzmw.zza(zzmwVar, buildKeepingLast);
        }
        return zzmwVar;
    }

    public final String zzd() {
        return this.zzc.zza();
    }

    public final String zze() {
        return this.zzc.zzc();
    }

    public final long zzf() {
        return this.zzc.zzd();
    }

    public final zzacr zzg() {
        return this.zzc.zzb();
    }

    public final Map zzh() {
        zzmq zzmqVar = this.zzc;
        if (zzmqVar.zze() == 0) {
            return null;
        }
        return zzmqVar.zzf();
    }

    public final boolean zzi() {
        if (this.zzb.zze().isEmpty()) {
            return zzmq.zzi().equals(this.zzc);
        }
        return false;
    }
}
