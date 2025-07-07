package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzia extends zzmd implements zzni {
    private static final zzia zzb;
    private int zzd;
    private int zze = 1;
    private zzmj zzf = zzcn();

    static {
        zzia zziaVar = new zzia();
        zzb = zziaVar;
        zzmd.zzct(zzia.class, zziaVar);
    }

    private zzia() {
    }

    public static zzhy zza() {
        return (zzhy) zzb.zzcg();
    }

    public static /* synthetic */ void zzc(zzia zziaVar, zzho zzhoVar) {
        zzhoVar.getClass();
        zzmj zzmjVar = zziaVar.zzf;
        if (!zzmjVar.zzc()) {
            zziaVar.zzf = zzmd.zzco(zzmjVar);
        }
        zziaVar.zzf.add(zzhoVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzd", "zze", zzhz.zza, "zzf", zzho.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzhy(null);
            } else {
                return new zzia();
            }
        }
        return (byte) 1;
    }
}
