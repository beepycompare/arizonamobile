package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public enum zzyv {
    SMALL(10),
    MEDIUM(20),
    LARGE(50),
    FULL(-1),
    NONE(0);
    
    private final int zzf;

    zzyv(int i) {
        this.zzf = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        return this.zzf;
    }
}
