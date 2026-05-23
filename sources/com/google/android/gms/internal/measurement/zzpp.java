package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpp {
    private static final Object zza = new Object();
    private static volatile Map zzb;
    private final String zzc;

    zzpp(Context context, zzpr zzprVar) {
        String zza2;
        if (zzprVar.zzb()) {
            zza2 = zzlg.zzb(context, zzprVar.zza(), false);
        } else {
            zza2 = zzprVar.zza();
        }
        this.zzc = zza2;
        zzprVar.zzc();
        zzprVar.zzf();
        zzprVar.zzd();
        zzprVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map zza(Context context) {
        Map map;
        Map map2 = zzb;
        if (map2 == null) {
            synchronized (zza) {
                map = zzb;
                if (map == null) {
                    ImmutableMap.Builder builder = ImmutableMap.builder();
                    try {
                        String[] list = context.getAssets().list("phenotype");
                        if (list != null) {
                            for (String str : list) {
                                if (str.endsWith("_package_metadata.binarypb")) {
                                    try {
                                        AssetManager assets = context.getAssets();
                                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 10);
                                        sb.append("phenotype/");
                                        sb.append(str);
                                        InputStream open = assets.open(sb.toString());
                                        try {
                                            zzpp zzppVar = new zzpp(context, zzpr.zzh(open, zzadf.zza()));
                                            builder.put(zzppVar.zzc, zzppVar);
                                            if (open != null) {
                                                open.close();
                                            }
                                        } catch (Throwable th) {
                                            if (open != null) {
                                                try {
                                                    open.close();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                            break;
                                        }
                                    } catch (zzaeh e) {
                                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 45);
                                        sb2.append("Unable to read Phenotype PackageMetadata for ");
                                        sb2.append(str);
                                        Log.e("PackageInfo", sb2.toString(), e);
                                    }
                                }
                            }
                        }
                    } catch (IOException e2) {
                        Log.e("PackageInfo", "Unable to read Phenotype PackageMetadata from assets.", e2);
                    }
                    map = builder.buildOrThrow();
                    zzb = map;
                }
            }
            return map;
        }
        return map2;
    }
}
