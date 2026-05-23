package com.google.android.gms.internal.measurement;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
final class zzaej implements Map.Entry {
    private final Map.Entry zza;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zzael zzaelVar = (zzael) this.zza.getValue();
        if (zzaelVar == null) {
            return null;
        }
        zzaelVar.zzd(null);
        return zzaelVar.zza;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzafc)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((zzael) this.zza.getValue()).zza((zzafc) obj);
    }

    public final zzael zza() {
        return (zzael) this.zza.getValue();
    }
}
