package com.google.android.gms.internal.measurement;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzrw {
    private final Context zza;
    private final zzsh zzb = new zzsh();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzrw(Context context, byte[] bArr) {
        zzsq.zza(context != null, "Context cannot be null", new Object[0]);
        this.zza = context.getApplicationContext();
    }

    public final zzrx zza() {
        return new zzrx(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Context zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzsh zzc() {
        return this.zzb;
    }
}
