package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
enum zzam {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');
    
    private final char zzk;

    zzam(char c) {
        this.zzk = c;
    }

    public static zzam zza(char c) {
        zzam[] values;
        for (zzam zzamVar : values()) {
            if (zzamVar.zzk == c) {
                return zzamVar;
            }
        }
        return UNSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ char zzb() {
        return this.zzk;
    }
}
