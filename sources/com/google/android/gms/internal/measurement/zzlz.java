package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzlz implements zznj {
    private static final zzlz zza = new zzlz();

    private zzlz() {
    }

    public static zzlz zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class cls) {
        return zzme.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class cls) {
        if (!zzme.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            String.valueOf(name);
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(name)));
        }
        try {
            return (zzni) zzme.zzco(cls.asSubclass(zzme.class)).zzl(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            String.valueOf(name2);
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(name2)), e);
        }
    }
}
