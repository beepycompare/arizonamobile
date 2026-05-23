package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaab {
    private static final zzaad zza;

    static {
        String[] strArr;
        strArr = zzaad.zzd;
        zza = zzb(strArr);
    }

    public static /* synthetic */ zzaad zza() {
        return zza;
    }

    private static zzaad zzb(String[] strArr) {
        zzaaj zzaajVar;
        try {
            zzaajVar = zzaak.zza;
        } catch (NoClassDefFoundError unused) {
            zzaajVar = null;
        }
        if (zzaajVar != null) {
            return zzaajVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzaad) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th) {
                th = th;
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
