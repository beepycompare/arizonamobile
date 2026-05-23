package com.google.android.gms.internal.measurement;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzagr {
    private static final zzph zza;
    private static final zzom zzb;
    private static volatile String zzc;
    private static final zzog zzd;

    static {
        zzpj zzpjVar = new zzpj(zzagq.zza);
        zzpjVar.zza();
        zzph zzb2 = zzpjVar.zzb();
        zza = zzb2;
        zzog zzogVar = new zzog("com.google.android.gms.measurement", zzb2);
        zzd = zzogVar;
        zzb = zzogVar.zzd("__phenotype_server_token", "");
        zzc = null;
    }

    private zzagr() {
    }

    public static String zza() {
        return (String) zzb.get();
    }

    public static String zzb(Context context) {
        String str;
        String str2 = zzc;
        if (str2 == null) {
            synchronized (zzagr.class) {
                str = zzc;
                if (str == null) {
                    str = zzlg.zzb(context, "com.google.android.gms.measurement", false);
                    zzc = str;
                }
            }
            return str;
        }
        return str2;
    }

    public static zzog zzc() {
        return zzd;
    }
}
