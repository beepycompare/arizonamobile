package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zznb implements zznj {
    private final zznj[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznb(zznj... zznjVarArr) {
        this.zza = zznjVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            zznj zznjVar = this.zza[i];
            if (zznjVar.zzb(cls)) {
                return zznjVar.zzc(cls);
            }
        }
        String name = cls.getName();
        String.valueOf(name);
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(name)));
    }
}
