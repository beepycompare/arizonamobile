package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzwn {
    int zza;
    final int zzb;
    zzwn zzc;
    final Map zzd = new HashMap(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwn(int i, int i2, zzwn zzwnVar) {
        if (i <= i2) {
            this.zza = i;
            this.zzb = i2;
            this.zzc = null;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final String toString() {
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(identityHashCode).length() + 4);
        sb.append("Node");
        sb.append(identityHashCode);
        return sb.toString();
    }
}
