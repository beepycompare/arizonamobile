package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
@Deprecated
/* loaded from: classes3.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
    /* loaded from: classes3.dex */
    public interface Types {
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    public final String toString() {
        long zzb = zzb();
        int zza = zza();
        String zzc = zzc();
        return zzb + "\t" + zza + "\t-1" + zzc;
    }

    public abstract int zza();

    public abstract long zzb();

    public abstract String zzc();
}
