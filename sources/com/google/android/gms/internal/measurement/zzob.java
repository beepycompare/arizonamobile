package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzob extends zzoc {
    private final long zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzob(String str, String str2, zzph zzphVar, long j) {
        super("com.google.android.gms.measurement", str2, zzphVar);
        this.zza = j;
    }

    @Override // com.google.android.gms.internal.measurement.zznp
    public final /* synthetic */ Object zza() {
        return Long.valueOf(this.zza);
    }
}
