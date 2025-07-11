package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzjl implements zzjh {
    private final AtomicBoolean zza = new AtomicBoolean();
    private HashMap zzb = null;
    private final HashMap zzc = new HashMap(16, 1.0f);
    private final HashMap zzd = new HashMap(16, 1.0f);
    private final HashMap zze = new HashMap(16, 1.0f);
    private final HashMap zzf = new HashMap(16, 1.0f);
    private Object zzg = null;
    private boolean zzh = false;
    private final String[] zzi = new String[0];

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final String zza(ContentResolver contentResolver, String str, String str2) {
        String str3;
        if (contentResolver != null) {
            synchronized (this) {
                String str4 = null;
                if (this.zzb == null) {
                    this.zza.set(false);
                    this.zzb = new HashMap(16, 1.0f);
                    this.zzg = new Object();
                    contentResolver.registerContentObserver(zzjg.zza, true, new zzjj(this, null));
                } else if (this.zza.getAndSet(false)) {
                    this.zzb.clear();
                    this.zzc.clear();
                    this.zzd.clear();
                    this.zze.clear();
                    this.zzf.clear();
                    this.zzg = new Object();
                    this.zzh = false;
                }
                Object obj = this.zzg;
                if (this.zzb.containsKey(str)) {
                    String str5 = (String) this.zzb.get(str);
                    if (str5 != null) {
                        str4 = str5;
                    }
                    return str4;
                }
                try {
                    Uri uri = zzjg.zza;
                    ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (acquireUnstableContentProviderClient != null) {
                        try {
                            Cursor query = acquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                            try {
                                if (query != null) {
                                    if (query.moveToFirst()) {
                                        str3 = query.getString(1);
                                        query.close();
                                        acquireUnstableContentProviderClient.release();
                                    } else {
                                        query.close();
                                        acquireUnstableContentProviderClient.release();
                                        str3 = null;
                                    }
                                    if (str3 != null && str3.equals(null)) {
                                        str3 = null;
                                    }
                                    synchronized (this) {
                                        if (obj == this.zzg) {
                                            this.zzb.put(str, str3);
                                        }
                                    }
                                    if (str3 != null) {
                                        return str3;
                                    }
                                    return null;
                                }
                                throw new zzjk("ContentProvider query returned null cursor");
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
                            throw new zzjk("ContentProvider query failed", e);
                        }
                    }
                    throw new zzjk("Unable to acquire ContentProviderClient");
                } catch (zzjk unused) {
                    return null;
                }
            }
        }
        throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ AtomicBoolean zzb() {
        return this.zza;
    }
}
