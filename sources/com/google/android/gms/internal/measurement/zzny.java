package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
class zzny extends zzof {
    private volatile boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzny(String str, String str2, zzph zzphVar) {
        super("com.google.android.gms.measurement", str2, zzphVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznp
    protected final /* synthetic */ Object zzc(String str) throws IOException {
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    @Override // com.google.android.gms.internal.measurement.zznp
    protected final /* synthetic */ Object zzd(Object obj) throws IOException {
        return (Boolean) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final /* synthetic */ Object zze() {
        return Boolean.valueOf(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final /* synthetic */ void zzh(Object obj) {
        this.zza = ((Boolean) obj).booleanValue();
    }
}
