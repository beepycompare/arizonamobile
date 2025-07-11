package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public enum zzlr {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);
    
    private final int zzg;

    zzlr(int i) {
        this.zzg = i;
    }

    public static zzlr zzb(int i) {
        zzlr[] values;
        for (zzlr zzlrVar : values()) {
            if (zzlrVar.zzg == i) {
                return zzlrVar;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.zzg;
    }
}
