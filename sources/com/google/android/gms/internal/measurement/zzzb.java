package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public enum zzzb {
    GENERAL(false, true),
    BOOLEAN(false, false),
    CHARACTER(false, false),
    INTEGRAL(true, false),
    FLOAT(true, true);
    
    private final boolean zzf;

    zzzb(boolean z, boolean z2) {
        this.zzf = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zzf;
    }
}
