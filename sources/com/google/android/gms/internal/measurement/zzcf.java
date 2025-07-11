package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.base.Preconditions;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzcf {
    private static final ThreadLocal zza = new zzce();

    public static SharedPreferences zza(Context context, String str, int i, zzca zzcaVar) {
        zzbv.zza();
        zzcd zzcdVar = str.equals("") ? new zzcd() : null;
        if (zzcdVar != null) {
            return zzcdVar;
        }
        ThreadLocal threadLocal = zza;
        Preconditions.checkArgument(((Boolean) threadLocal.get()).booleanValue());
        threadLocal.set(Boolean.FALSE);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            threadLocal.set(Boolean.TRUE);
            return sharedPreferences;
        } catch (Throwable th) {
            zza.set(Boolean.TRUE);
            throw th;
        }
    }
}
