package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzma {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private SharedPreferences.OnSharedPreferenceChangeListener zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zza() {
        synchronized (zzma.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (it.hasNext()) {
                zzma zzmaVar = (zzma) it.next();
                SharedPreferences sharedPreferences = zzmaVar.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = zzmaVar.zzc;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener2 = (SharedPreferences.OnSharedPreferenceChangeListener) Preconditions.checkNotNull(null);
                throw null;
            }
            map.clear();
        }
    }
}
