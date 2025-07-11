package com.google.android.gms.internal.measurement;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zzms implements Map.Entry {
    private final Map.Entry zza;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzmu) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zznl)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((zzmu) this.zza.getValue()).zza((zznl) obj);
    }

    public final zzmu zza() {
        return (zzmu) this.zza.getValue();
    }
}
