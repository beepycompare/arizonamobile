package com.google.android.gms.internal.measurement;

import android.os.Binder;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
interface zzju {
    static Object zzg(zzjt zzjtVar) {
        try {
            return zzjtVar.zza();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzjtVar.zza();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    Object zze(String str);
}
