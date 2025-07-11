package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzfw {
    private static final Object zze = new Object();
    private final String zza;
    private final zzbn zzb;
    private final Object zzc;
    private final Object zzd = new Object();
    private volatile Object zzf = null;
    private volatile Object zzg = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfw(String str, Object obj, Object obj2, zzbn zzbnVar, byte[] bArr) {
        this.zza = str;
        this.zzc = obj;
        this.zzb = zzbnVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final Object zzb(Object obj) {
        synchronized (this.zzd) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzfr.zza == null) {
            return this.zzc;
        }
        synchronized (zze) {
            if (zzae.zza()) {
                return this.zzg == null ? this.zzc : this.zzg;
            }
            try {
                for (zzfw zzfwVar : zzfx.zzb()) {
                    if (!zzae.zza()) {
                        Object obj2 = null;
                        try {
                            zzbn zzbnVar = zzfwVar.zzb;
                            if (zzbnVar != null) {
                                obj2 = zzbnVar.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (zze) {
                            zzfwVar.zzg = obj2;
                        }
                    } else {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzbn zzbnVar2 = this.zzb;
            if (zzbnVar2 != null) {
                try {
                    return zzbnVar2.zza();
                } catch (IllegalStateException | SecurityException unused3) {
                }
            }
            return this.zzc;
        }
    }
}
