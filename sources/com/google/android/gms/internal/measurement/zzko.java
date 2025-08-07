package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzko implements zzjv {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private SharedPreferences.OnSharedPreferenceChangeListener zzc;
    private volatile Map zze;
    private final Object zzd = new Object();
    private final List zzf = new ArrayList();

    private zzko(SharedPreferences sharedPreferences, Runnable runnable) {
        this.zzb = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzko zza(Context context, String str, Runnable runnable) {
        final zzko zzkoVar;
        SharedPreferences zza2;
        if (!zzjm.zza() || str.startsWith("direct_boot:") || zzjm.zzc(context)) {
            synchronized (zzko.class) {
                Map map = zza;
                zzkoVar = (zzko) map.get(str);
                if (zzkoVar == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    if (str.startsWith("direct_boot:")) {
                        if (zzjm.zza()) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                        zza2 = zzcf.zza(context, str.substring(12), 0, zzcb.zza);
                    } else {
                        zza2 = zzcf.zza(context, str, 0, zzcb.zza);
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    zzkoVar = new zzko(zza2, runnable);
                    SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.measurement.zzkn
                        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                        public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                            zzko.this.zzc(sharedPreferences, str2);
                        }
                    };
                    zzkoVar.zzc = onSharedPreferenceChangeListener;
                    zzkoVar.zzb.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                    map.put(str, zzkoVar);
                }
            }
            return zzkoVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzb() {
        synchronized (zzko.class) {
            Map map = zza;
            for (zzko zzkoVar : map.values()) {
                zzkoVar.zzb.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) Preconditions.checkNotNull(zzkoVar.zzc));
            }
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzkm.zzc();
        }
        synchronized (this) {
            for (zzjs zzjsVar : this.zzf) {
                zzjsVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjv
    public final Object zze(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    Map<String, ?> all = this.zzb.getAll();
                    this.zze = all;
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    map = all;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
