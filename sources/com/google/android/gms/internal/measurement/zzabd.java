package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
enum zzabd {
    BOOLEAN,
    STRING,
    LONG,
    DOUBLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzabd zza(Object obj) {
        if (obj instanceof String) {
            return STRING;
        }
        if (obj instanceof Boolean) {
            return BOOLEAN;
        }
        if (obj instanceof Long) {
            return LONG;
        }
        if (obj instanceof Double) {
            return DOUBLE;
        }
        String valueOf = String.valueOf(obj.getClass());
        String.valueOf(valueOf);
        throw new AssertionError("invalid tag type: ".concat(String.valueOf(valueOf)));
    }
}
