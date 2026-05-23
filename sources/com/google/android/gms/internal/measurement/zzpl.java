package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpl extends zzadu implements zzafd {
    private static final zzpl zze;
    private static volatile zzafj zzf;
    private zzaef zzb = zzcy();

    static {
        zzpl zzplVar = new zzpl();
        zze = zzplVar;
        zzadu.zzcs(zzpl.class, zzplVar);
    }

    private zzpl() {
    }

    public static zzpl zzb(byte[] bArr, zzadf zzadfVar) throws zzaeh {
        return (zzpl) zzadu.zzcA(zze, bArr, zzadfVar);
    }

    public final List zza() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zze, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzf;
                            if (zzafjVar2 == null) {
                                synchronized (zzpl.class) {
                                    zzafjVar = zzf;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zze);
                                        zzf = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zze;
                }
                return new zzpk(null);
            } else {
                return new zzpl();
            }
        }
        return (byte) 1;
    }
}
