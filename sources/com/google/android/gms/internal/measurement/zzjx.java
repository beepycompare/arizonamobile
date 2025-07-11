package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.common.base.Preconditions;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzjx implements zzju {
    private static zzjx zza;
    private final Context zzb;
    private final ContentObserver zzc;
    private boolean zzd;

    private zzjx() {
        this.zzd = false;
        this.zzb = null;
        this.zzc = null;
    }

    private zzjx(Context context) {
        this.zzd = false;
        this.zzb = context;
        this.zzc = new zzjv(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjx zza(Context context) {
        zzjx zzjxVar;
        synchronized (zzjx.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzjx(context) : new zzjx();
            }
            zzjx zzjxVar2 = zza;
            if (zzjxVar2 != null && zzjxVar2.zzc != null && !zzjxVar2.zzd) {
                try {
                    context.getContentResolver().registerContentObserver(zzjg.zza, true, zza.zzc);
                    ((zzjx) Preconditions.checkNotNull(zza)).zzd = true;
                } catch (SecurityException e) {
                    Log.e("GservicesLoader", "Unable to register Gservices content observer", e);
                }
            }
            zzjxVar = (zzjx) Preconditions.checkNotNull(zza);
        }
        return zzjxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzc() {
        Context context;
        synchronized (zzjx.class) {
            zzjx zzjxVar = zza;
            if (zzjxVar != null && (context = zzjxVar.zzb) != null && zzjxVar.zzc != null && zzjxVar.zzd) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzju
    /* renamed from: zzb */
    public final String zze(final String str) {
        Context context = this.zzb;
        if (context != null && !zzjm.zzb(context)) {
            try {
                return (String) zzju.zzg(new zzjt() { // from class: com.google.android.gms.internal.measurement.zzjw
                    @Override // com.google.android.gms.internal.measurement.zzjt
                    public final /* synthetic */ Object zza() {
                        return zzjx.this.zzd(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzjf.zza(((Context) Preconditions.checkNotNull(this.zzb)).getContentResolver(), str, null);
    }
}
