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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.miami.game.core.settings.game_test.GameTestScriptModelKt;
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
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzez {
    private static volatile zzez zzc;
    protected final ExecutorService zzb;
    private final AppMeasurementSdk zze;
    private final List zzf;
    private int zzg;
    private boolean zzh;
    private final String zzi;
    private volatile zzcp zzj;
    private volatile long zzk;
    private final String zzd = "FA";
    protected final Clock zza = DefaultClock.getInstance();

    protected zzez(Context context, Bundle bundle) {
        zzck.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzeb(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (com.google.android.gms.measurement.internal.zzlt.zza(context, "google_app_id", com.google.android.gms.measurement.internal.zzhu.zza(context)) != null) {
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
        zzM(new zzdp(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzey(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzV */
    public final void zzM(zzeo zzeoVar) {
        this.zzb.execute(zzeoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzW */
    public final void zzN(Exception exc, boolean z, boolean z2) {
        zzez zzezVar;
        Exception exc2;
        this.zzh |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzezVar = this;
            exc2 = exc;
            zzezVar.zzD(5, "Error with data collection. Data lost.", exc2, null, null);
        } else {
            zzezVar = this;
            exc2 = exc;
        }
        Log.w(zzezVar.zzd, "Error with data collection. Data lost.", exc2);
    }

    private final void zzX(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l, Long l2) {
        zzM(new zzen(this, l, l2, str, str2, bundle, z, z2));
    }

    public static zzez zza(Context context, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzez.class) {
                if (zzc == null) {
                    zzc = new zzez(context, bundle == null ? new Bundle() : new Bundle(bundle));
                }
            }
        }
        return zzc;
    }

    public final String zzA() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdx(this, zzcmVar));
        return zzcmVar.zzc(500L);
    }

    public final String zzB() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdy(this, zzcmVar));
        return zzcmVar.zzc(500L);
    }

    public final Map zzC(String str, String str2, boolean z) {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdz(this, str, str2, z, zzcmVar));
        Bundle zze = zzcmVar.zze(5000L);
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
        zzM(new zzea(this, false, 5, str, obj, null, null));
    }

    public final Bundle zzE(Bundle bundle, boolean z) {
        zzcm zzcmVar = new zzcm();
        zzM(new zzec(this, bundle, zzcmVar));
        if (z) {
            return zzcmVar.zze(5000L);
        }
        return null;
    }

    public final int zzF(String str) {
        zzcm zzcmVar = new zzcm();
        zzM(new zzed(this, str, zzcmVar));
        Integer num = (Integer) zzcm.zzf(zzcmVar.zze(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String zzG() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzee(this, zzcmVar));
        return zzcmVar.zzc(GameTestScriptModelKt.DEFAULT_LOGIN_AND_SPAWN_TIMEOUT_MS);
    }

    public final Long zzH() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzef(this, zzcmVar));
        return zzcmVar.zzd(GameTestScriptModelKt.DEFAULT_LOGIN_AND_SPAWN_TIMEOUT_MS);
    }

    public final String zzI() {
        return this.zzi;
    }

    public final Object zzJ(int i) {
        zzcm zzcmVar = new zzcm();
        zzM(new zzeg(this, zzcmVar, i));
        return zzcm.zzf(zzcmVar.zze(15000L), Object.class);
    }

    public final void zzK(boolean z) {
        zzM(new zzeh(this, z));
    }

    public final void zzL(Bundle bundle) {
        zzM(new zzei(this, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzO() {
        return this.zzk >= 169;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzP() {
        return this.zzk >= 170;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzQ() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzR() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcp zzS() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(zzcp zzcpVar) {
        this.zzj = zzcpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(long j) {
        this.zzk = j;
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzcp zzc(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        try {
            if (z) {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION;
            } else {
                versionPolicy = DynamiteModule.PREFER_LOCAL;
            }
            return zzco.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            this.zzN(e, true, false);
            return null;
        }
    }

    public final void zzd(com.google.android.gms.measurement.internal.zzjp zzjpVar) {
        zzep zzepVar = new zzep(zzjpVar);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzepVar);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zzM(new zzej(this, zzepVar));
    }

    public final void zze(Intent intent) {
        zzM(new zzek(this, intent));
    }

    public final void zzf(com.google.android.gms.measurement.internal.zzjq zzjqVar) {
        Preconditions.checkNotNull(zzjqVar);
        List list = this.zzf;
        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                if (zzjqVar.equals(((Pair) list.get(i)).first)) {
                    Log.w(this.zzd, "OnEventListener already registered.");
                    return;
                }
            }
            zzeq zzeqVar = new zzeq(zzjqVar);
            list.add(new Pair(zzjqVar, zzeqVar));
            if (this.zzj != null) {
                try {
                    this.zzj.registerOnMeasurementEventListener(zzeqVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zzM(new zzel(this, zzeqVar));
        }
    }

    public final void zzg(com.google.android.gms.measurement.internal.zzjq zzjqVar) {
        Pair pair;
        Preconditions.checkNotNull(zzjqVar);
        List list = this.zzf;
        synchronized (list) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    pair = null;
                    break;
                } else if (zzjqVar.equals(((Pair) list.get(i)).first)) {
                    pair = (Pair) list.get(i);
                    break;
                } else {
                    i++;
                }
            }
            if (pair != null) {
                list.remove(pair);
                zzeq zzeqVar = (zzeq) pair.second;
                if (this.zzj != null) {
                    try {
                        this.zzj.unregisterOnMeasurementEventListener(zzeqVar);
                        return;
                    } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                        Log.w(this.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                    }
                }
                zzM(new zzem(this, zzeqVar));
                return;
            }
            Log.w(this.zzd, "OnEventListener had not been registered.");
        }
    }

    public final void zzh(String str, Bundle bundle) {
        zzX(null, str, bundle, false, true, null, null);
    }

    public final void zzi(String str, String str2, Bundle bundle) {
        zzX(str, str2, bundle, true, true, null, null);
    }

    public final void zzj(String str, String str2, Bundle bundle, long j, long j2) {
        zzX(str, str2, bundle, true, false, Long.valueOf(j), 0L);
    }

    public final void zzk(String str, String str2, Object obj, boolean z) {
        zzM(new zzdf(this, str, str2, obj, z));
    }

    public final void zzl(Bundle bundle) {
        zzM(new zzdg(this, bundle));
    }

    public final void zzm(String str, String str2, Bundle bundle) {
        zzM(new zzdh(this, str, str2, bundle));
    }

    public final List zzn(String str, String str2) {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdi(this, str, str2, zzcmVar));
        List list = (List) zzcm.zzf(zzcmVar.zze(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zzo(String str) {
        zzM(new zzdj(this, str));
    }

    public final void zzp(zzdd zzddVar, String str, String str2) {
        zzM(new zzdk(this, zzddVar, str, str2));
    }

    public final void zzq(Boolean bool) {
        zzM(new zzdl(this, bool));
    }

    public final void zzr(Bundle bundle) {
        zzM(new zzdm(this, bundle));
    }

    public final void zzs() {
        zzM(new zzdn(this));
    }

    public final void zzt(long j) {
        zzM(new zzdo(this, j));
    }

    public final void zzu(String str) {
        zzM(new zzdq(this, str));
    }

    public final void zzv(String str) {
        zzM(new zzdr(this, str));
    }

    public final void zzw(Runnable runnable) {
        zzM(new zzdt(this, runnable));
    }

    public final String zzx() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdu(this, zzcmVar));
        return zzcmVar.zzc(500L);
    }

    public final String zzy() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdv(this, zzcmVar));
        return zzcmVar.zzc(50L);
    }

    public final long zzz() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdw(this, zzcmVar));
        Long zzd = zzcmVar.zzd(500L);
        if (zzd == null) {
            long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i = this.zzg + 1;
            this.zzg = i;
            return nextLong + i;
        }
        return zzd.longValue();
    }
}
