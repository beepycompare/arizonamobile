package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.media3.exoplayer.Renderer;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzfb {
    private static volatile zzfb zzc;
    protected final ExecutorService zzb;
    private final AppMeasurementSdk zze;
    private final List zzf;
    private int zzg;
    private boolean zzh;
    private final String zzi;
    private volatile zzcr zzj;
    private final String zzd = "FA";
    protected final Clock zza = DefaultClock.getInstance();

    protected zzfb(Context context, Bundle bundle) {
        zzcm.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzed(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (com.google.android.gms.measurement.internal.zzls.zza(context, "google_app_id", com.google.android.gms.measurement.internal.zzht.zza(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.zzi = null;
                    this.zzh = true;
                    Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        this.zzi = "fa";
        zzM(new zzdr(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzfa(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzS */
    public final void zzM(zzeq zzeqVar) {
        this.zzb.execute(zzeqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzT */
    public final void zzN(Exception exc, boolean z, boolean z2) {
        zzfb zzfbVar;
        Exception exc2;
        this.zzh |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzfbVar = this;
            exc2 = exc;
            zzfbVar.zzD(5, "Error with data collection. Data lost.", exc2, null, null);
        } else {
            zzfbVar = this;
            exc2 = exc;
        }
        Log.w(zzfbVar.zzd, "Error with data collection. Data lost.", exc2);
    }

    private final void zzU(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzM(new zzep(this, l, str, str2, bundle, z, z2));
    }

    public static zzfb zza(Context context, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzfb.class) {
                if (zzc == null) {
                    zzc = new zzfb(context, bundle);
                }
            }
        }
        return zzc;
    }

    public final String zzA() {
        zzco zzcoVar = new zzco();
        zzM(new zzdz(this, zzcoVar));
        return zzcoVar.zzc(500L);
    }

    public final String zzB() {
        zzco zzcoVar = new zzco();
        zzM(new zzea(this, zzcoVar));
        return zzcoVar.zzc(500L);
    }

    public final Map zzC(String str, String str2, boolean z) {
        zzco zzcoVar = new zzco();
        zzM(new zzeb(this, str, str2, z, zzcoVar));
        Bundle zze = zzcoVar.zze(5000L);
        if (zze == null || zze.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zze.size());
        for (String str3 : zze.keySet()) {
            Object obj = zze.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zzD(int i, String str, Object obj, Object obj2, Object obj3) {
        zzM(new zzec(this, false, 5, str, obj, null, null));
    }

    public final Bundle zzE(Bundle bundle, boolean z) {
        zzco zzcoVar = new zzco();
        zzM(new zzee(this, bundle, zzcoVar));
        if (z) {
            return zzcoVar.zze(5000L);
        }
        return null;
    }

    public final int zzF(String str) {
        zzco zzcoVar = new zzco();
        zzM(new zzef(this, str, zzcoVar));
        Integer num = (Integer) zzco.zzf(zzcoVar.zze(Renderer.DEFAULT_DURATION_TO_PROGRESS_US), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String zzG() {
        zzco zzcoVar = new zzco();
        zzM(new zzeg(this, zzcoVar));
        return zzcoVar.zzc(120000L);
    }

    public final Long zzH() {
        zzco zzcoVar = new zzco();
        zzM(new zzeh(this, zzcoVar));
        return zzcoVar.zzd(120000L);
    }

    public final String zzI() {
        return this.zzi;
    }

    public final Object zzJ(int i) {
        zzco zzcoVar = new zzco();
        zzM(new zzei(this, zzcoVar, i));
        return zzco.zzf(zzcoVar.zze(15000L), Object.class);
    }

    public final void zzK(boolean z) {
        zzM(new zzej(this, z));
    }

    public final void zzL(Bundle bundle) {
        zzM(new zzek(this, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzO() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzP() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcr zzQ() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzR(zzcr zzcrVar) {
        this.zzj = zzcrVar;
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzcr zzc(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        try {
            if (z) {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION;
            } else {
                versionPolicy = DynamiteModule.PREFER_LOCAL;
            }
            return zzcq.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zzN(e, true, false);
            return null;
        }
    }

    public final void zzd(com.google.android.gms.measurement.internal.zzjo zzjoVar) {
        zzer zzerVar = new zzer(zzjoVar);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzerVar);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zzM(new zzel(this, zzerVar));
    }

    public final void zze(Intent intent) {
        zzM(new zzem(this, intent));
    }

    public final void zzf(com.google.android.gms.measurement.internal.zzjp zzjpVar) {
        Preconditions.checkNotNull(zzjpVar);
        List list = this.zzf;
        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                if (zzjpVar.equals(((Pair) list.get(i)).first)) {
                    Log.w(this.zzd, "OnEventListener already registered.");
                    return;
                }
            }
            zzes zzesVar = new zzes(zzjpVar);
            list.add(new Pair(zzjpVar, zzesVar));
            if (this.zzj != null) {
                try {
                    this.zzj.registerOnMeasurementEventListener(zzesVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zzM(new zzen(this, zzesVar));
        }
    }

    public final void zzg(com.google.android.gms.measurement.internal.zzjp zzjpVar) {
        Pair pair;
        Preconditions.checkNotNull(zzjpVar);
        List list = this.zzf;
        synchronized (list) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    pair = null;
                    break;
                } else if (zzjpVar.equals(((Pair) list.get(i)).first)) {
                    pair = (Pair) list.get(i);
                    break;
                } else {
                    i++;
                }
            }
            if (pair != null) {
                list.remove(pair);
                zzes zzesVar = (zzes) pair.second;
                if (this.zzj != null) {
                    try {
                        this.zzj.unregisterOnMeasurementEventListener(zzesVar);
                        return;
                    } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                        Log.w(this.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                    }
                }
                zzM(new zzeo(this, zzesVar));
                return;
            }
            Log.w(this.zzd, "OnEventListener had not been registered.");
        }
    }

    public final void zzh(String str, Bundle bundle) {
        zzU(null, str, bundle, false, true, null);
    }

    public final void zzi(String str, String str2, Bundle bundle) {
        zzU(str, str2, bundle, true, true, null);
    }

    public final void zzj(String str, String str2, Bundle bundle, long j) {
        zzU(str, str2, bundle, true, false, Long.valueOf(j));
    }

    public final void zzk(String str, String str2, Object obj, boolean z) {
        zzM(new zzdh(this, str, str2, obj, z));
    }

    public final void zzl(Bundle bundle) {
        zzM(new zzdi(this, bundle));
    }

    public final void zzm(String str, String str2, Bundle bundle) {
        zzM(new zzdj(this, str, str2, bundle));
    }

    public final List zzn(String str, String str2) {
        zzco zzcoVar = new zzco();
        zzM(new zzdk(this, str, str2, zzcoVar));
        List list = (List) zzco.zzf(zzcoVar.zze(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zzo(String str) {
        zzM(new zzdl(this, str));
    }

    public final void zzp(zzdf zzdfVar, String str, String str2) {
        zzM(new zzdm(this, zzdfVar, str, str2));
    }

    public final void zzq(Boolean bool) {
        zzM(new zzdn(this, bool));
    }

    public final void zzr(Bundle bundle) {
        zzM(new zzdo(this, bundle));
    }

    public final void zzs() {
        zzM(new zzdp(this));
    }

    public final void zzt(long j) {
        zzM(new zzdq(this, j));
    }

    public final void zzu(String str) {
        zzM(new zzds(this, str));
    }

    public final void zzv(String str) {
        zzM(new zzdt(this, str));
    }

    public final void zzw(Runnable runnable) {
        zzM(new zzdv(this, runnable));
    }

    public final String zzx() {
        zzco zzcoVar = new zzco();
        zzM(new zzdw(this, zzcoVar));
        return zzcoVar.zzc(500L);
    }

    public final String zzy() {
        zzco zzcoVar = new zzco();
        zzM(new zzdx(this, zzcoVar));
        return zzcoVar.zzc(50L);
    }

    public final long zzz() {
        zzco zzcoVar = new zzco();
        zzM(new zzdy(this, zzcoVar));
        Long zzd = zzcoVar.zzd(500L);
        if (zzd == null) {
            long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i = this.zzg + 1;
            this.zzg = i;
            return nextLong + i;
        }
        return zzd.longValue();
    }
}
