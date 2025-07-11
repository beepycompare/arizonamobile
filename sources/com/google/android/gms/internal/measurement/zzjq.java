package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzjq implements zzju {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private volatile Map zzh;
    private static final Map zzb = new ArrayMap();
    public static final String[] zza = {"key", "value"};
    private final Object zzg = new Object();
    private final List zzi = new ArrayList();

    private zzjq(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        Preconditions.checkNotNull(contentResolver);
        Preconditions.checkNotNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        this.zzf = new zzjo(this, null);
    }

    public static zzjq zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzjq zzjqVar;
        synchronized (zzjq.class) {
            Map map = zzb;
            zzjqVar = (zzjq) map.get(uri);
            if (zzjqVar == null) {
                try {
                    zzjq zzjqVar2 = new zzjq(contentResolver, uri, runnable);
                    try {
                        contentResolver.registerContentObserver(uri, false, zzjqVar2.zzf);
                        map.put(uri, zzjqVar2);
                    } catch (SecurityException unused) {
                    }
                    zzjqVar = zzjqVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzjqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzd() {
        synchronized (zzjq.class) {
            Map map = zzb;
            for (zzjq zzjqVar : map.values()) {
                zzjqVar.zzc.unregisterContentObserver(zzjqVar.zzf);
            }
            map.clear();
        }
    }

    public final Map zzb() {
        Map emptyMap;
        Map map = this.zzh;
        if (map == null) {
            synchronized (this.zzg) {
                map = this.zzh;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        emptyMap = (Map) zzju.zzg(new zzjt() { // from class: com.google.android.gms.internal.measurement.zzjp
                            @Override // com.google.android.gms.internal.measurement.zzjt
                            public final /* synthetic */ Object zza() {
                                return zzjq.this.zzf();
                            }
                        });
                    } catch (SQLiteException | IllegalStateException | SecurityException e) {
                        Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                        emptyMap = Collections.emptyMap();
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    this.zzh = emptyMap;
                    map = emptyMap;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zzc() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            for (zzjr zzjrVar : this.zzi) {
                zzjrVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzju
    public final /* bridge */ /* synthetic */ Object zze(String str) {
        return (String) zzb().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map zzf() {
        ContentResolver contentResolver = this.zzc;
        Uri uri = this.zzd;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (acquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.emptyMap();
            }
            Cursor query = acquireUnstableContentProviderClient.query(uri, zza, null, null, null);
            try {
                if (query == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    return Collections.emptyMap();
                }
                int count = query.getCount();
                if (count == 0) {
                    Map emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
                while (query.moveToNext()) {
                    arrayMap.put(query.getString(0), query.getString(1));
                }
                if (query.isAfterLast()) {
                    query.close();
                    return arrayMap;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map emptyMap2 = Collections.emptyMap();
                query.close();
                return emptyMap2;
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (RemoteException e) {
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
            return Collections.emptyMap();
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }
}
