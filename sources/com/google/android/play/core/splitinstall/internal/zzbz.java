package com.google.android.play.core.splitinstall.internal;
/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* loaded from: classes4.dex */
public final class zzbz implements zzcb, zzby {
    private static final Object zza = new Object();
    private volatile zzcb zzb;
    private volatile Object zzc = zza;

    private zzbz(zzcb zzcbVar) {
        this.zzb = zzcbVar;
    }

    public static zzby zzb(zzcb zzcbVar) {
        return zzcbVar instanceof zzby ? (zzby) zzcbVar : new zzbz(zzcbVar);
    }

    public static zzcb zzc(zzcb zzcbVar) {
        zzcbVar.getClass();
        return zzcbVar instanceof zzbz ? zzcbVar : new zzbz(zzcbVar);
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzcb, com.google.android.play.core.splitinstall.internal.zzby
    public final Object zza() {
        Object obj;
        Object obj2 = this.zzc;
        Object obj3 = zza;
        if (obj2 == obj3) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == obj3) {
                    obj = this.zzb.zza();
                    Object obj4 = this.zzc;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
            return obj;
        }
        return obj2;
    }
}
