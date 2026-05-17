package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzbu extends zzbq {
    private final zzbw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbu(zzbw zzbwVar, int i) {
        super(zzbwVar.size(), i);
        this.zza = zzbwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
