package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzon {
    private final Function zza;
    private final boolean zzb;
    private final ImmutableSet zzc;
    private volatile String zzd = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzon(Function function, boolean z, boolean z2, boolean z3, boolean z4, ImmutableSet immutableSet) {
        this.zza = function;
        this.zzb = z3;
        this.zzc = immutableSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(Context context) {
        String str = this.zzd;
        if (str == null) {
            String str2 = (String) this.zza.apply(context);
            this.zzd = str2;
            return str2;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImmutableSet zzc() {
        return this.zzc;
    }
}
