package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzic implements zzjg {
    private static volatile zzic zzc;
    private long zzA;
    private volatile Boolean zzB;
    private volatile boolean zzC;
    private int zzD;
    private int zzE;
    final long zza;
    final long zzb;
    private final Context zzd;
    private final boolean zze;
    private final zzae zzf;
    private final zzal zzg;
    private final zzhh zzh;
    private final zzgu zzi;
    private final zzhz zzj;
    private final zzoc zzk;
    private final zzpp zzl;
    private final zzgn zzm;
    private final Clock zzn;
    private final zzmb zzo;
    private final zzlj zzp;
    private final zzd zzq;
    private final zzlo zzr;
    private final String zzs;
    private zzgl zzt;
    private zznl zzu;
    private zzbb zzv;
    private zzgi zzw;
    private zzlq zzx;
    private Boolean zzz;
    private boolean zzy = false;
    private final AtomicInteger zzF = new AtomicInteger(0);

    zzic(zzjs zzjsVar) {
        long currentTimeMillis;
        long elapsedRealtime;
        boolean z = false;
        Preconditions.checkNotNull(zzjsVar);
        Context context = zzjsVar.zza;
        zzae zzaeVar = new zzae(context);
        this.zzf = zzaeVar;
        zzfr.zza = zzaeVar;
        this.zzd = context;
        this.zze = zzjsVar.zze;
        this.zzB = zzjsVar.zzb;
        this.zzs = zzjsVar.zzh;
        this.zzC = true;
        com.google.android.gms.internal.measurement.zzlw.zza(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzn = defaultClock;
        com.google.android.gms.internal.measurement.zzkk zza = com.google.android.gms.internal.measurement.zzjx.zza(context);
        String packageName = context.getPackageName();
        String.valueOf(packageName);
        zza.zza("com.google.android.gms.measurement#".concat(String.valueOf(packageName)), 0, new String[0], null);
        com.google.android.gms.internal.measurement.zzlk.zza(context);
        Long l = zzjsVar.zzf;
        if (l != null) {
            currentTimeMillis = l.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zza = currentTimeMillis;
        Long l2 = zzjsVar.zzg;
        if (l2 != null) {
            elapsedRealtime = l2.longValue();
        } else {
            elapsedRealtime = defaultClock.elapsedRealtime();
        }
        this.zzb = elapsedRealtime;
        this.zzg = new zzal(this);
        zzhh zzhhVar = new zzhh(this);
        zzhhVar.zzx();
        this.zzh = zzhhVar;
        zzgu zzguVar = new zzgu(this);
        zzguVar.zzx();
        this.zzi = zzguVar;
        zzpp zzppVar = new zzpp(this);
        zzppVar.zzx();
        this.zzl = zzppVar;
        this.zzm = new zzgn(new zzjr(zzjsVar, this));
        this.zzq = new zzd(this);
        zzmb zzmbVar = new zzmb(this);
        zzmbVar.zzc();
        this.zzo = zzmbVar;
        zzlj zzljVar = new zzlj(this);
        zzljVar.zzc();
        this.zzp = zzljVar;
        zzoc zzocVar = new zzoc(this);
        zzocVar.zzc();
        this.zzk = zzocVar;
        zzlo zzloVar = new zzlo(this);
        zzloVar.zzx();
        this.zzr = zzloVar;
        zzhz zzhzVar = new zzhz(this);
        zzhzVar.zzx();
        this.zzj = zzhzVar;
        com.google.android.gms.internal.measurement.zzdb zzdbVar = zzjsVar.zzd;
        z = (zzdbVar == null || zzdbVar.zzb == 0) ? true : z;
        if (!(context.getApplicationContext() instanceof Application)) {
            zzP(zzguVar);
            zzguVar.zze().zza("Application context is not an Application");
        } else {
            zzO(zzljVar);
            if (zzljVar.zzu.zzd.getApplicationContext() instanceof Application) {
                Application application = (Application) zzljVar.zzu.zzd.getApplicationContext();
                if (zzljVar.zza == null) {
                    zzljVar.zza = new zzky(zzljVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzljVar.zza);
                    application.registerActivityLifecycleCallbacks(zzljVar.zza);
                    zzgu zzguVar2 = zzljVar.zzu.zzi;
                    zzP(zzguVar2);
                    zzguVar2.zzk().zza("Registered activity lifecycle callback");
                }
            }
        }
        zzhzVar.zzj(new zzia(this, zzjsVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzL() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzM(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzN(zzje zzjeVar) {
        if (zzjeVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzO(zzg zzgVar) {
        if (zzgVar != null) {
            if (zzgVar.zza()) {
                return;
            }
            String valueOf = String.valueOf(zzgVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void zzP(zzjf zzjfVar) {
        if (zzjfVar != null) {
            if (zzjfVar.zzv()) {
                return;
            }
            String valueOf = String.valueOf(zzjfVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzic zzy(Context context, com.google.android.gms.internal.measurement.zzdb zzdbVar, Long l, Long l2) {
        Bundle bundle;
        if (zzdbVar != null) {
            Bundle bundle2 = zzdbVar.zzd;
            zzdbVar = new com.google.android.gms.internal.measurement.zzdb(zzdbVar.zza, zzdbVar.zzb, zzdbVar.zzc, bundle2, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (zzic.class) {
                if (zzc == null) {
                    zzc = new zzic(new zzjs(context, zzdbVar, l, l2));
                }
            }
        } else if (zzdbVar != null && (bundle = zzdbVar.zzd) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzc);
            zzc.zzB = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzc);
        return zzc;
    }

    public final boolean zzA() {
        return this.zzB != null && this.zzB.booleanValue();
    }

    public final boolean zzB() {
        return zzC() == 0;
    }

    public final int zzC() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        zzal zzalVar = this.zzg;
        if (zzalVar.zzt()) {
            return 1;
        }
        zzP(zzhzVar);
        zzhzVar.zzg();
        if (this.zzC) {
            zzhh zzhhVar = this.zzh;
            zzN(zzhhVar);
            Boolean zzi = zzhhVar.zzi();
            if (zzi != null) {
                return zzi.booleanValue() ? 0 : 3;
            }
            zzae zzaeVar = zzalVar.zzu.zzf;
            Boolean zzr = zzalVar.zzr("firebase_analytics_collection_enabled");
            return zzr != null ? zzr.booleanValue() ? 0 : 4 : (this.zzB == null || this.zzB.booleanValue()) ? 0 : 7;
        }
        return 8;
    }

    public final void zzD(boolean z) {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        this.zzC = z;
    }

    public final boolean zzE() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        return this.zzC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF() {
        this.zzD++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG() {
        this.zzF.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzH() {
        if (this.zzy) {
            zzhz zzhzVar = this.zzj;
            zzP(zzhzVar);
            zzhzVar.zzg();
            Boolean bool = this.zzz;
            if (bool == null || this.zzA == 0 || (!bool.booleanValue() && Math.abs(this.zzn.elapsedRealtime() - this.zzA) > 1000)) {
                this.zzA = this.zzn.elapsedRealtime();
                zzpp zzppVar = this.zzl;
                zzN(zzppVar);
                boolean z = false;
                if (zzppVar.zzab("android.permission.INTERNET")) {
                    zzN(zzppVar);
                    if (zzppVar.zzab("android.permission.ACCESS_NETWORK_STATE")) {
                        Context context = this.zzd;
                        if (Wrappers.packageManager(context).isCallerInstantApp() || this.zzg.zzE() || (zzpp.zzax(context) && zzpp.zzS(context, false))) {
                            z = true;
                        }
                    }
                }
                Boolean valueOf = Boolean.valueOf(z);
                this.zzz = valueOf;
                if (valueOf.booleanValue()) {
                    zzN(zzppVar);
                    this.zzz = Boolean.valueOf(zzppVar.zzC(zzv().zzk()));
                }
            }
            return this.zzz.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
        if (r3.zzak() >= 234200) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzI() {
        NetworkInfo activeNetworkInfo;
        zzhh zzhhVar;
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        zzlo zzloVar = this.zzr;
        zzP(zzloVar);
        zzP(zzloVar);
        String zzj = zzv().zzj();
        if (this.zzg.zzu()) {
            zzhh zzhhVar2 = this.zzh;
            zzN(zzhhVar2);
            Pair zzb = zzhhVar2.zzb(zzj);
            if (((Boolean) zzb.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb.first)) {
                zzgu zzguVar = this.zzi;
                zzP(zzguVar);
                zzguVar.zzk().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
                return false;
            }
            zzP(zzloVar);
            zzloVar.zzw();
            ConnectivityManager connectivityManager = (ConnectivityManager) zzloVar.zzu.zzd.getSystemService("connectivity");
            if (connectivityManager != null) {
                try {
                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (SecurityException unused) {
                }
                if (activeNetworkInfo == null && activeNetworkInfo.isConnected()) {
                    StringBuilder sb = new StringBuilder();
                    zznl zzt = zzt();
                    zzt.zzg();
                    zzt.zzb();
                    if (zzt.zzK()) {
                        zzpp zzppVar = zzt.zzu.zzl;
                        zzN(zzppVar);
                    }
                    zzlj zzljVar = this.zzp;
                    zzO(zzljVar);
                    zzic zzicVar = zzljVar.zzu;
                    zzljVar.zzg();
                    zzao zzz = zzicVar.zzt().zzz();
                    Bundle bundle = zzz != null ? zzz.zza : null;
                    if (bundle == null) {
                        int i = this.zzE;
                        this.zzE = i + 1;
                        boolean z = i < 10;
                        zzgu zzguVar2 = this.zzi;
                        zzP(zzguVar2);
                        zzgs zzj2 = zzguVar2.zzj();
                        StringBuilder sb2 = new StringBuilder(69);
                        sb2.append("Failed to retrieve DMA consent from the service, ");
                        sb2.append(i < 10 ? "Retrying." : "Skipping.");
                        sb2.append(" retryCount");
                        zzj2.zzb(sb2.toString(), Integer.valueOf(this.zzE));
                        return z;
                    }
                    zzjl zze = zzjl.zze(bundle, 100);
                    sb.append("&gcs=");
                    sb.append(zze.zzk());
                    zzba zzh = zzba.zzh(bundle, 100);
                    sb.append("&dma=");
                    sb.append(!Objects.equals(zzh.zzj(), false) ? 1 : 0);
                    if (!TextUtils.isEmpty(zzh.zzk())) {
                        sb.append("&dma_cps=");
                        sb.append(zzh.zzk());
                    }
                    int i2 = !Objects.equals(zzba.zzi(bundle), true) ? 1 : 0;
                    sb.append("&npa=");
                    sb.append(i2);
                    zzgu zzguVar3 = this.zzi;
                    zzP(zzguVar3);
                    zzguVar3.zzk().zzb("Consent query parameters to Bow", sb);
                    zzpp zzppVar2 = this.zzl;
                    zzN(zzppVar2);
                    zzv().zzu.zzg.zzi();
                    String str = (String) zzb.first;
                    zzN(this.zzh);
                    URL zzaw = zzppVar2.zzaw(161000L, zzj, str, zzhhVar.zzp.zza() - 1, sb.toString());
                    if (zzaw != null) {
                        zzlo zzloVar2 = this.zzr;
                        zzP(zzloVar2);
                        zzll zzllVar = new zzll() { // from class: com.google.android.gms.measurement.internal.zzib
                            @Override // com.google.android.gms.measurement.internal.zzll
                            public final /* synthetic */ void zza(String str2, int i3, Throwable th, byte[] bArr, Map map) {
                                zzic.this.zzJ(str2, i3, th, bArr, map);
                            }
                        };
                        zzloVar2.zzw();
                        Preconditions.checkNotNull(zzaw);
                        Preconditions.checkNotNull(zzllVar);
                        zzhz zzhzVar2 = zzloVar2.zzu.zzj;
                        zzP(zzhzVar2);
                        zzhzVar2.zzm(new zzln(zzloVar2, zzj, zzaw, null, null, zzllVar));
                    }
                    return false;
                }
                zzgu zzguVar4 = this.zzi;
                zzP(zzguVar4);
                zzguVar4.zze().zza("Network is not available for Deferred Deep Link request. Skipping");
                return false;
            }
            activeNetworkInfo = null;
            if (activeNetworkInfo == null) {
            }
            zzgu zzguVar42 = this.zzi;
            zzP(zzguVar42);
            zzguVar42.zze().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        zzgu zzguVar5 = this.zzi;
        zzP(zzguVar5);
        zzguVar5.zzk().zza("ADID collection is disabled from Manifest. Skipping");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(String str, int i, Throwable th, byte[] bArr, Map map) {
        int i2;
        if (i == 200 || i == 204) {
            i2 = i;
        } else {
            i2 = 304;
            if (i != 304) {
                i2 = i;
                zzgu zzguVar = this.zzi;
                zzP(zzguVar);
                zzguVar.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            }
        }
        if (th == null) {
            zzhh zzhhVar = this.zzh;
            zzN(zzhhVar);
            zzhhVar.zzo.zzb(true);
            if (bArr == null || bArr.length == 0) {
                zzgu zzguVar2 = this.zzi;
                zzP(zzguVar2);
                zzguVar2.zzj().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString(Constants.DEEPLINK, "");
                if (TextUtils.isEmpty(optString)) {
                    zzgu zzguVar3 = this.zzi;
                    zzP(zzguVar3);
                    zzguVar3.zzj().zza("Deferred Deep Link is empty.");
                    return;
                }
                String optString2 = jSONObject.optString("gclid", "");
                String optString3 = jSONObject.optString("gbraid", "");
                String optString4 = jSONObject.optString("gad_source", "");
                double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                Bundle bundle = new Bundle();
                zzpp zzppVar = this.zzl;
                zzN(zzppVar);
                zzic zzicVar = zzppVar.zzu;
                if (!TextUtils.isEmpty(optString)) {
                    Context context = zzicVar.zzd;
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(optString3)) {
                            bundle.putString("gbraid", optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            bundle.putString("gad_source", optString4);
                        }
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.zzp.zzE("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        zzN(zzppVar);
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        try {
                            SharedPreferences.Editor edit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            edit.putString(com.adjust.sdk.Constants.DEEPLINK, optString);
                            edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                            if (edit.commit()) {
                                Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                Context context2 = zzppVar.zzu.zzd;
                                if (Build.VERSION.SDK_INT < 34) {
                                    context2.sendBroadcast(intent);
                                    return;
                                } else {
                                    context2.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                    return;
                                }
                            }
                            return;
                        } catch (RuntimeException e) {
                            zzgu zzguVar4 = zzppVar.zzu.zzi;
                            zzP(zzguVar4);
                            zzguVar4.zzb().zzb("Failed to persist Deferred Deep Link. exception", e);
                            return;
                        }
                    }
                }
                zzgu zzguVar5 = this.zzi;
                zzP(zzguVar5);
                zzguVar5.zze().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                return;
            } catch (JSONException e2) {
                zzgu zzguVar6 = this.zzi;
                zzP(zzguVar6);
                zzguVar6.zzb().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzgu zzguVar7 = this.zzi;
        zzP(zzguVar7);
        zzguVar7.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(zzjs zzjsVar) {
        Bundle bundle;
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        zzal zzalVar = this.zzg;
        zzalVar.zzb();
        zzbb zzbbVar = new zzbb(this);
        zzbbVar.zzx();
        this.zzv = zzbbVar;
        com.google.android.gms.internal.measurement.zzdb zzdbVar = zzjsVar.zzd;
        long j = zzdbVar == null ? 0L : zzdbVar.zza;
        String str = "";
        if (zzdbVar != null && (bundle = zzdbVar.zzd) != null) {
            str = bundle.getString("runtime_google_app_id", "");
        }
        zzgi zzgiVar = new zzgi(this, zzjsVar.zzc, j, str);
        zzgiVar.zzc();
        this.zzw = zzgiVar;
        zzgl zzglVar = new zzgl(this);
        zzglVar.zzc();
        this.zzt = zzglVar;
        zznl zznlVar = new zznl(this);
        zznlVar.zzc();
        this.zzu = zznlVar;
        zzpp zzppVar = this.zzl;
        zzppVar.zzy();
        this.zzh.zzy();
        this.zzw.zzd();
        zzlq zzlqVar = new zzlq(this);
        zzlqVar.zzc();
        this.zzx = zzlqVar;
        zzlqVar.zzd();
        zzgu zzguVar = this.zzi;
        zzP(zzguVar);
        zzgs zzi = zzguVar.zzi();
        zzalVar.zzi();
        zzi.zzb("App measurement initialized, version", 161000L);
        zzP(zzguVar);
        zzguVar.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzj = zzgiVar.zzj();
        zzN(zzppVar);
        if (!zzppVar.zzad(zzj, zzalVar.zzz())) {
            zzP(zzguVar);
            zzgs zzi2 = zzguVar.zzi();
            String.valueOf(zzj);
            zzi2.zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzj)));
        } else {
            zzP(zzguVar);
            zzguVar.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        }
        zzP(zzguVar);
        zzguVar.zzj().zza("Debug-level message logging enabled");
        int i = this.zzD;
        AtomicInteger atomicInteger = this.zzF;
        if (i != atomicInteger.get()) {
            zzP(zzguVar);
            zzguVar.zzb().zzc("Not all components initialized", Integer.valueOf(this.zzD), Integer.valueOf(atomicInteger.get()));
        }
        this.zzy = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r0.zzU() == false) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdb zzdbVar) {
        zzjl zza;
        zzlj zzljVar;
        zzji zzw;
        zzji zzw2;
        Boolean zzr;
        zzhe zzheVar;
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        com.google.android.gms.internal.measurement.zzin zzj = zzx().zzj();
        com.google.android.gms.internal.measurement.zzin zzinVar = com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE;
        zzaif.zza();
        zzfx zzfxVar = zzfy.zzaP;
        zzal zzalVar = this.zzg;
        boolean zzp = zzalVar.zzp(null, zzfxVar);
        boolean z = zzj == zzinVar;
        if (zzp) {
            zzpp zzppVar = this.zzl;
            zzN(zzppVar);
        }
        if (z) {
            z = true;
            zzpp zzppVar2 = this.zzl;
            zzN(zzppVar2);
            zzppVar2.zzg();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            zzw zzwVar = new zzw(zzppVar2.zzu);
            zzic zzicVar = zzppVar2.zzu;
            ContextCompat.registerReceiver(zzicVar.zzd, zzwVar, intentFilter, 2);
            zzgu zzguVar = zzicVar.zzi;
            zzP(zzguVar);
            zzguVar.zzj().zza("Registered app receiver");
            if (z) {
                zzx().zzh(((Long) zzfy.zzB.zzb(null)).longValue());
            }
        }
        zzhh zzhhVar = this.zzh;
        zzN(zzhhVar);
        zzjl zzl = zzhhVar.zzl();
        int zzb = zzl.zzb();
        zzji zzw3 = zzalVar.zzw("google_analytics_default_allow_ad_storage", false);
        zzji zzw4 = zzalVar.zzw("google_analytics_default_allow_analytics_storage", false);
        zzji zzjiVar = zzji.UNINITIALIZED;
        if (zzw3 != zzjiVar || zzw4 != zzjiVar) {
            zzN(zzhhVar);
            if (zzhhVar.zzk(-10)) {
                zza = zzjl.zza(zzw3, zzw4, -10);
                if (zza != null) {
                    zzlj zzljVar2 = this.zzp;
                    zzO(zzljVar2);
                    zzljVar2.zzs(zza, true);
                    zzl = zza;
                }
                zzljVar = this.zzp;
                zzO(zzljVar);
                zzljVar.zzz(zzl);
                zzN(zzhhVar);
                int zzb2 = zzhhVar.zzj().zzb();
                zzw = zzalVar.zzw("google_analytics_default_allow_ad_personalization_signals", true);
                if (zzw != zzjiVar) {
                    zzgu zzguVar2 = this.zzi;
                    zzP(zzguVar2);
                    zzguVar2.zzk().zzb("Default ad personalization consent from Manifest", zzw);
                }
                zzw2 = zzalVar.zzw("google_analytics_default_allow_ad_user_data", true);
                if (zzw2 == zzjiVar && zzjl.zzu(-10, zzb2)) {
                    zzO(zzljVar);
                    zzljVar.zzq(zzba.zza(zzw2, -10), true);
                } else if (!TextUtils.isEmpty(zzv().zzk()) && (zzb2 == 0 || zzb2 == 30)) {
                    zzO(zzljVar);
                    zzljVar.zzq(new zzba((Boolean) null, -10, (Boolean) null, (String) null), true);
                }
                zzic zzicVar2 = zzalVar.zzu;
                zzr = zzalVar.zzr("google_analytics_tcf_data_enabled");
                if (zzr != null || zzr.booleanValue()) {
                    zzgu zzguVar3 = this.zzi;
                    zzP(zzguVar3);
                    zzguVar3.zzj().zza("TCF client enabled.");
                    zzO(zzljVar);
                    zzljVar.zzD();
                    zzO(zzljVar);
                    zzljVar.zzC();
                }
                zzN(zzhhVar);
                zzheVar = zzhhVar.zzc;
                if (zzheVar.zza() == 0) {
                    zzgu zzguVar4 = this.zzi;
                    zzP(zzguVar4);
                    long j = this.zza;
                    zzguVar4.zzk().zzb("Persisting first open", Long.valueOf(j));
                    zzN(zzhhVar);
                    zzheVar.zzb(j);
                }
                zzO(zzljVar);
                zzljVar.zzb.zzc();
                if (!zzH()) {
                    if (!TextUtils.isEmpty(zzv().zzk())) {
                        zzpp zzppVar3 = this.zzl;
                        zzN(zzppVar3);
                        String zzk = zzv().zzk();
                        zzN(zzhhVar);
                        zzhhVar.zzg();
                        if (zzppVar3.zzD(zzk, zzhhVar.zzd().getString("gmp_app_id", null))) {
                            zzgu zzguVar5 = this.zzi;
                            zzP(zzguVar5);
                            zzguVar5.zzi().zza("Rechecking which service to use due to a GMP App Id change");
                            zzN(zzhhVar);
                            zzhhVar.zzg();
                            Boolean zzi = zzhhVar.zzi();
                            SharedPreferences.Editor edit = zzhhVar.zzd().edit();
                            edit.clear();
                            edit.apply();
                            if (zzi != null) {
                                zzhhVar.zzh(zzi);
                            }
                            zzm().zzh();
                            this.zzu.zzM();
                            this.zzu.zzI();
                            zzN(zzhhVar);
                            zzheVar.zzb(this.zza);
                            zzN(zzhhVar);
                            zzhhVar.zze.zzb(null);
                        }
                        zzN(zzhhVar);
                        String zzk2 = zzv().zzk();
                        zzhhVar.zzg();
                        SharedPreferences.Editor edit2 = zzhhVar.zzd().edit();
                        edit2.putString("gmp_app_id", zzk2);
                        edit2.apply();
                    }
                    zzN(zzhhVar);
                    if (!zzhhVar.zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
                        zzN(zzhhVar);
                        zzhhVar.zze.zzb(null);
                    }
                    zzO(zzljVar);
                    zzN(zzhhVar);
                    zzljVar.zzQ(zzhhVar.zze.zza());
                    zzpp zzppVar4 = this.zzl;
                    zzN(zzppVar4);
                    try {
                        zzppVar4.zzu.zzd.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                    } catch (ClassNotFoundException unused) {
                        zzhh zzhhVar2 = this.zzh;
                        zzN(zzhhVar2);
                        zzhg zzhgVar = zzhhVar2.zzq;
                        if (!TextUtils.isEmpty(zzhgVar.zza())) {
                            zzgu zzguVar6 = this.zzi;
                            zzP(zzguVar6);
                            zzguVar6.zze().zza("Remote config removed with active feature rollouts");
                            zzN(zzhhVar2);
                            zzhgVar.zzb(null);
                        }
                    }
                    if (!TextUtils.isEmpty(zzv().zzk())) {
                        boolean zzB = zzB();
                        zzhh zzhhVar3 = this.zzh;
                        zzN(zzhhVar3);
                        if (!zzhhVar3.zzn() && !this.zzg.zzt()) {
                            zzN(zzhhVar3);
                            zzhhVar3.zzm(!zzB);
                        }
                        if (zzB) {
                            zzlj zzljVar3 = this.zzp;
                            zzO(zzljVar3);
                            zzljVar3.zzT();
                        }
                        zzoc zzocVar = this.zzk;
                        zzO(zzocVar);
                        zzocVar.zza.zza();
                        zzt().zzC(new AtomicReference());
                        zznl zzt = zzt();
                        zzN(zzhhVar3);
                        zzt.zzH(zzhhVar3.zzt.zza());
                    }
                } else if (zzB()) {
                    zzpp zzppVar5 = this.zzl;
                    zzN(zzppVar5);
                    if (!zzppVar5.zzab("android.permission.INTERNET")) {
                        zzgu zzguVar7 = this.zzi;
                        zzP(zzguVar7);
                        zzguVar7.zzb().zza("App is missing INTERNET permission");
                    }
                    zzN(zzppVar5);
                    if (!zzppVar5.zzab("android.permission.ACCESS_NETWORK_STATE")) {
                        zzgu zzguVar8 = this.zzi;
                        zzP(zzguVar8);
                        zzguVar8.zzb().zza("App is missing ACCESS_NETWORK_STATE permission");
                    }
                    Context context = this.zzd;
                    if (!Wrappers.packageManager(context).isCallerInstantApp() && !this.zzg.zzE()) {
                        if (!zzpp.zzax(context)) {
                            zzgu zzguVar9 = this.zzi;
                            zzP(zzguVar9);
                            zzguVar9.zzb().zza("AppMeasurementReceiver not registered/enabled");
                        }
                        if (!zzpp.zzS(context, false)) {
                            zzgu zzguVar10 = this.zzi;
                            zzP(zzguVar10);
                            zzguVar10.zzb().zza("AppMeasurementService not registered/enabled");
                        }
                    }
                    zzgu zzguVar11 = this.zzi;
                    zzP(zzguVar11);
                    zzguVar11.zzb().zza("Uploading is not possible. App measurement disabled");
                }
                zzaif.zza();
                if (this.zzg.zzp(null, zzfy.zzaP)) {
                    zzpp zzppVar6 = this.zzl;
                    zzN(zzppVar6);
                    if (zzppVar6.zzU()) {
                        long max = Math.max(500L, ((((Integer) zzfy.zzaw.zzb(null)).intValue() * 1000) + new Random().nextInt(5000)) - this.zzn.elapsedRealtime());
                        if (max > 500) {
                            zzgu zzguVar12 = this.zzi;
                            zzP(zzguVar12);
                            zzguVar12.zzk().zzb("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(max));
                        }
                        zzlj zzljVar4 = this.zzp;
                        zzO(zzljVar4);
                        zzljVar4.zzu(max);
                    }
                }
                zzhh zzhhVar4 = this.zzh;
                zzN(zzhhVar4);
                zzhhVar4.zzj.zzb(true);
            }
        }
        if (!TextUtils.isEmpty(zzv().zzk()) && (zzb == 0 || zzb == 30 || zzb == 10 || zzb == 40)) {
            zzlj zzljVar5 = this.zzp;
            zzO(zzljVar5);
            zzljVar5.zzs(new zzjl(null, null, -10), false);
        }
        zza = null;
        if (zza != null) {
        }
        zzljVar = this.zzp;
        zzO(zzljVar);
        zzljVar.zzz(zzl);
        zzN(zzhhVar);
        int zzb22 = zzhhVar.zzj().zzb();
        zzw = zzalVar.zzw("google_analytics_default_allow_ad_personalization_signals", true);
        if (zzw != zzjiVar) {
        }
        zzw2 = zzalVar.zzw("google_analytics_default_allow_ad_user_data", true);
        if (zzw2 == zzjiVar) {
        }
        if (!TextUtils.isEmpty(zzv().zzk())) {
            zzO(zzljVar);
            zzljVar.zzq(new zzba((Boolean) null, -10, (Boolean) null, (String) null), true);
        }
        zzic zzicVar22 = zzalVar.zzu;
        zzr = zzalVar.zzr("google_analytics_tcf_data_enabled");
        if (zzr != null) {
        }
        zzgu zzguVar32 = this.zzi;
        zzP(zzguVar32);
        zzguVar32.zzj().zza("TCF client enabled.");
        zzO(zzljVar);
        zzljVar.zzD();
        zzO(zzljVar);
        zzljVar.zzC();
        zzN(zzhhVar);
        zzheVar = zzhhVar.zzc;
        if (zzheVar.zza() == 0) {
        }
        zzO(zzljVar);
        zzljVar.zzb.zzc();
        if (!zzH()) {
        }
        zzaif.zza();
        if (this.zzg.zzp(null, zzfy.zzaP)) {
        }
        zzhh zzhhVar42 = this.zzh;
        zzN(zzhhVar42);
        zzhhVar42.zzj.zzb(true);
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzae zzaV() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzgu zzaW() {
        zzgu zzguVar = this.zzi;
        zzP(zzguVar);
        return zzguVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzhz zzaX() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        return zzhzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final Context zzaZ() {
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final Clock zzba() {
        return this.zzn;
    }

    @Pure
    public final zzal zzc() {
        return this.zzg;
    }

    @Pure
    public final zzhh zzd() {
        zzhh zzhhVar = this.zzh;
        zzN(zzhhVar);
        return zzhhVar;
    }

    public final zzgu zzf() {
        zzgu zzguVar = this.zzi;
        if (zzguVar == null || !zzguVar.zzv()) {
            return null;
        }
        return zzguVar;
    }

    @Pure
    public final zzoc zzh() {
        zzoc zzocVar = this.zzk;
        zzO(zzocVar);
        return zzocVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final zzhz zzi() {
        return this.zzj;
    }

    @Pure
    public final zzlj zzj() {
        zzlj zzljVar = this.zzp;
        zzO(zzljVar);
        return zzljVar;
    }

    @Pure
    public final zzpp zzk() {
        zzpp zzppVar = this.zzl;
        zzN(zzppVar);
        return zzppVar;
    }

    @Pure
    public final zzgn zzl() {
        return this.zzm;
    }

    @Pure
    public final zzgl zzm() {
        zzO(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzlo zzn() {
        zzlo zzloVar = this.zzr;
        zzP(zzloVar);
        return zzloVar;
    }

    @Pure
    public final boolean zzp() {
        return this.zze;
    }

    @Pure
    public final String zzq() {
        return this.zzs;
    }

    @Pure
    public final zzmb zzs() {
        zzmb zzmbVar = this.zzo;
        zzO(zzmbVar);
        return zzmbVar;
    }

    @Pure
    public final zznl zzt() {
        zzO(this.zzu);
        return this.zzu;
    }

    @Pure
    public final zzbb zzu() {
        zzP(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzgi zzv() {
        zzO(this.zzw);
        return this.zzw;
    }

    @Pure
    public final zzd zzw() {
        zzd zzdVar = this.zzq;
        zzM(zzdVar);
        return zzdVar;
    }

    @Pure
    public final zzlq zzx() {
        zzM(this.zzx);
        return this.zzx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzz(boolean z) {
        this.zzB = Boolean.valueOf(z);
    }
}
