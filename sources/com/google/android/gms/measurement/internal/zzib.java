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
import com.google.android.gms.internal.measurement.zzql;
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
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzib implements zzjf {
    private static volatile zzib zzb;
    private volatile Boolean zzA;
    private volatile boolean zzB;
    private int zzC;
    private int zzD;
    final long zza;
    private final Context zzc;
    private final boolean zzd;
    private final zzae zze;
    private final zzal zzf;
    private final zzhg zzg;
    private final zzgt zzh;
    private final zzhy zzi;
    private final zzob zzj;
    private final zzpo zzk;
    private final zzgm zzl;
    private final Clock zzm;
    private final zzma zzn;
    private final zzli zzo;
    private final zzd zzp;
    private final zzln zzq;
    private final String zzr;
    private zzgk zzs;
    private zznk zzt;
    private zzba zzu;
    private zzgh zzv;
    private zzlp zzw;
    private Boolean zzy;
    private long zzz;
    private boolean zzx = false;
    private final AtomicInteger zzE = new AtomicInteger(0);

    zzib(zzjr zzjrVar) {
        long currentTimeMillis;
        boolean z = false;
        Preconditions.checkNotNull(zzjrVar);
        Context context = zzjrVar.zza;
        zzae zzaeVar = new zzae(context);
        this.zze = zzaeVar;
        zzfr.zza = zzaeVar;
        this.zzc = context;
        this.zzd = zzjrVar.zze;
        this.zzA = zzjrVar.zzb;
        this.zzr = zzjrVar.zzg;
        this.zzB = true;
        com.google.android.gms.internal.measurement.zzkl.zzb(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzm = defaultClock;
        Long l = zzjrVar.zzf;
        if (l != null) {
            currentTimeMillis = l.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zza = currentTimeMillis;
        this.zzf = new zzal(this);
        zzhg zzhgVar = new zzhg(this);
        zzhgVar.zzx();
        this.zzg = zzhgVar;
        zzgt zzgtVar = new zzgt(this);
        zzgtVar.zzx();
        this.zzh = zzgtVar;
        zzpo zzpoVar = new zzpo(this);
        zzpoVar.zzx();
        this.zzk = zzpoVar;
        this.zzl = new zzgm(new zzjq(zzjrVar, this));
        this.zzp = new zzd(this);
        zzma zzmaVar = new zzma(this);
        zzmaVar.zzc();
        this.zzn = zzmaVar;
        zzli zzliVar = new zzli(this);
        zzliVar.zzc();
        this.zzo = zzliVar;
        zzob zzobVar = new zzob(this);
        zzobVar.zzc();
        this.zzj = zzobVar;
        zzln zzlnVar = new zzln(this);
        zzlnVar.zzx();
        this.zzq = zzlnVar;
        zzhy zzhyVar = new zzhy(this);
        zzhyVar.zzx();
        this.zzi = zzhyVar;
        com.google.android.gms.internal.measurement.zzdd zzddVar = zzjrVar.zzd;
        z = (zzddVar == null || zzddVar.zzb == 0) ? true : z;
        if (!(context.getApplicationContext() instanceof Application)) {
            zzP(zzgtVar);
            zzgtVar.zze().zza("Application context is not an Application");
        } else {
            zzO(zzliVar);
            if (zzliVar.zzu.zzc.getApplicationContext() instanceof Application) {
                Application application = (Application) zzliVar.zzu.zzc.getApplicationContext();
                if (zzliVar.zza == null) {
                    zzliVar.zza = new zzkx(zzliVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzliVar.zza);
                    application.registerActivityLifecycleCallbacks(zzliVar.zza);
                    zzgt zzgtVar2 = zzliVar.zzu.zzh;
                    zzP(zzgtVar2);
                    zzgtVar2.zzk().zza("Registered activity lifecycle callback");
                }
            }
        }
        zzhyVar.zzj(new zzhz(this, zzjrVar));
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

    private static final void zzN(zzjd zzjdVar) {
        if (zzjdVar == null) {
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

    private static final void zzP(zzje zzjeVar) {
        if (zzjeVar != null) {
            if (zzjeVar.zzv()) {
                return;
            }
            String valueOf = String.valueOf(zzjeVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzib zzy(Context context, com.google.android.gms.internal.measurement.zzdd zzddVar, Long l) {
        Bundle bundle;
        if (zzddVar != null) {
            Bundle bundle2 = zzddVar.zzd;
            zzddVar = new com.google.android.gms.internal.measurement.zzdd(zzddVar.zza, zzddVar.zzb, zzddVar.zzc, bundle2, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzib.class) {
                if (zzb == null) {
                    zzb = new zzib(new zzjr(context, zzddVar, l));
                }
            }
        } else if (zzddVar != null && (bundle = zzddVar.zzd) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zzA = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    public final boolean zzA() {
        return this.zzA != null && this.zzA.booleanValue();
    }

    public final boolean zzB() {
        return zzC() == 0;
    }

    public final int zzC() {
        zzhy zzhyVar = this.zzi;
        zzP(zzhyVar);
        zzhyVar.zzg();
        zzal zzalVar = this.zzf;
        if (zzalVar.zzt()) {
            return 1;
        }
        zzP(zzhyVar);
        zzhyVar.zzg();
        if (this.zzB) {
            zzhg zzhgVar = this.zzg;
            zzN(zzhgVar);
            Boolean zzi = zzhgVar.zzi();
            if (zzi != null) {
                return zzi.booleanValue() ? 0 : 3;
            }
            zzae zzaeVar = zzalVar.zzu.zze;
            Boolean zzr = zzalVar.zzr("firebase_analytics_collection_enabled");
            return zzr != null ? zzr.booleanValue() ? 0 : 4 : (this.zzA == null || this.zzA.booleanValue()) ? 0 : 7;
        }
        return 8;
    }

    public final void zzD(boolean z) {
        zzhy zzhyVar = this.zzi;
        zzP(zzhyVar);
        zzhyVar.zzg();
        this.zzB = z;
    }

    public final boolean zzE() {
        zzhy zzhyVar = this.zzi;
        zzP(zzhyVar);
        zzhyVar.zzg();
        return this.zzB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF() {
        this.zzC++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG() {
        this.zzE.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzH() {
        if (this.zzx) {
            zzhy zzhyVar = this.zzi;
            zzP(zzhyVar);
            zzhyVar.zzg();
            Boolean bool = this.zzy;
            if (bool == null || this.zzz == 0 || (!bool.booleanValue() && Math.abs(this.zzm.elapsedRealtime() - this.zzz) > 1000)) {
                this.zzz = this.zzm.elapsedRealtime();
                zzpo zzpoVar = this.zzk;
                zzN(zzpoVar);
                boolean z = false;
                if (zzpoVar.zzY("android.permission.INTERNET")) {
                    zzN(zzpoVar);
                    if (zzpoVar.zzY("android.permission.ACCESS_NETWORK_STATE")) {
                        Context context = this.zzc;
                        if (Wrappers.packageManager(context).isCallerInstantApp() || this.zzf.zzE() || (zzpo.zzau(context) && zzpo.zzQ(context, false))) {
                            z = true;
                        }
                    }
                }
                Boolean valueOf = Boolean.valueOf(z);
                this.zzy = valueOf;
                if (valueOf.booleanValue()) {
                    zzN(zzpoVar);
                    this.zzy = Boolean.valueOf(zzpoVar.zzA(zzv().zzk()));
                }
            }
            return this.zzy.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
        if (r3.zzah() >= 234200) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzI() {
        NetworkInfo activeNetworkInfo;
        zzhg zzhgVar;
        zzhy zzhyVar = this.zzi;
        zzP(zzhyVar);
        zzhyVar.zzg();
        zzln zzlnVar = this.zzq;
        zzP(zzlnVar);
        zzP(zzlnVar);
        String zzj = zzv().zzj();
        if (this.zzf.zzu()) {
            zzhg zzhgVar2 = this.zzg;
            zzN(zzhgVar2);
            Pair zzb2 = zzhgVar2.zzb(zzj);
            if (((Boolean) zzb2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb2.first)) {
                zzgt zzgtVar = this.zzh;
                zzP(zzgtVar);
                zzgtVar.zzk().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
                return false;
            }
            zzP(zzlnVar);
            zzlnVar.zzw();
            ConnectivityManager connectivityManager = (ConnectivityManager) zzlnVar.zzu.zzc.getSystemService("connectivity");
            if (connectivityManager != null) {
                try {
                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (SecurityException unused) {
                }
                if (activeNetworkInfo == null && activeNetworkInfo.isConnected()) {
                    StringBuilder sb = new StringBuilder();
                    zznk zzt = zzt();
                    zzt.zzg();
                    zzt.zzb();
                    if (zzt.zzK()) {
                        zzpo zzpoVar = zzt.zzu.zzk;
                        zzN(zzpoVar);
                    }
                    zzli zzliVar = this.zzo;
                    zzO(zzliVar);
                    zzib zzibVar = zzliVar.zzu;
                    zzliVar.zzg();
                    zzao zzz = zzibVar.zzt().zzz();
                    Bundle bundle = zzz != null ? zzz.zza : null;
                    if (bundle == null) {
                        int i = this.zzD;
                        this.zzD = i + 1;
                        boolean z = i < 10;
                        zzgt zzgtVar2 = this.zzh;
                        zzP(zzgtVar2);
                        String str = i < 10 ? "Retrying." : "Skipping.";
                        zzgr zzj2 = zzgtVar2.zzj();
                        StringBuilder sb2 = new StringBuilder(str.length() + 60);
                        sb2.append("Failed to retrieve DMA consent from the service, ");
                        sb2.append(str);
                        sb2.append(" retryCount");
                        zzj2.zzb(sb2.toString(), Integer.valueOf(this.zzD));
                        return z;
                    }
                    zzjk zze = zzjk.zze(bundle, 100);
                    sb.append("&gcs=");
                    sb.append(zze.zzk());
                    zzaz zzh = zzaz.zzh(bundle, 100);
                    sb.append("&dma=");
                    sb.append(!Objects.equals(zzh.zzj(), false) ? 1 : 0);
                    if (!TextUtils.isEmpty(zzh.zzk())) {
                        sb.append("&dma_cps=");
                        sb.append(zzh.zzk());
                    }
                    int i2 = !Objects.equals(zzaz.zzi(bundle), true) ? 1 : 0;
                    sb.append("&npa=");
                    sb.append(i2);
                    zzgt zzgtVar3 = this.zzh;
                    zzP(zzgtVar3);
                    zzgtVar3.zzk().zzb("Consent query parameters to Bow", sb);
                    zzpo zzpoVar2 = this.zzk;
                    zzN(zzpoVar2);
                    zzv().zzu.zzf.zzi();
                    String str2 = (String) zzb2.first;
                    zzN(this.zzg);
                    URL zzat = zzpoVar2.zzat(130000L, zzj, str2, zzhgVar.zzp.zza() - 1, sb.toString());
                    if (zzat != null) {
                        zzln zzlnVar2 = this.zzq;
                        zzP(zzlnVar2);
                        zzlk zzlkVar = new zzlk() { // from class: com.google.android.gms.measurement.internal.zzia
                            @Override // com.google.android.gms.measurement.internal.zzlk
                            public final /* synthetic */ void zza(String str3, int i3, Throwable th, byte[] bArr, Map map) {
                                zzib.this.zzJ(str3, i3, th, bArr, map);
                            }
                        };
                        zzlnVar2.zzw();
                        Preconditions.checkNotNull(zzat);
                        Preconditions.checkNotNull(zzlkVar);
                        zzhy zzhyVar2 = zzlnVar2.zzu.zzi;
                        zzP(zzhyVar2);
                        zzhyVar2.zzm(new zzlm(zzlnVar2, zzj, zzat, null, null, zzlkVar));
                    }
                    return false;
                }
                zzgt zzgtVar4 = this.zzh;
                zzP(zzgtVar4);
                zzgtVar4.zze().zza("Network is not available for Deferred Deep Link request. Skipping");
                return false;
            }
            activeNetworkInfo = null;
            if (activeNetworkInfo == null) {
            }
            zzgt zzgtVar42 = this.zzh;
            zzP(zzgtVar42);
            zzgtVar42.zze().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        zzgt zzgtVar5 = this.zzh;
        zzP(zzgtVar5);
        zzgtVar5.zzk().zza("ADID collection is disabled from Manifest. Skipping");
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
                zzgt zzgtVar = this.zzh;
                zzP(zzgtVar);
                zzgtVar.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            }
        }
        if (th == null) {
            zzhg zzhgVar = this.zzg;
            zzN(zzhgVar);
            zzhgVar.zzo.zzb(true);
            if (bArr == null || bArr.length == 0) {
                zzgt zzgtVar2 = this.zzh;
                zzP(zzgtVar2);
                zzgtVar2.zzj().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString(Constants.DEEPLINK, "");
                if (TextUtils.isEmpty(optString)) {
                    zzgt zzgtVar3 = this.zzh;
                    zzP(zzgtVar3);
                    zzgtVar3.zzj().zza("Deferred Deep Link is empty.");
                    return;
                }
                String optString2 = jSONObject.optString("gclid", "");
                String optString3 = jSONObject.optString("gbraid", "");
                String optString4 = jSONObject.optString("gad_source", "");
                double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                Bundle bundle = new Bundle();
                zzpo zzpoVar = this.zzk;
                zzN(zzpoVar);
                zzib zzibVar = zzpoVar.zzu;
                if (!TextUtils.isEmpty(optString)) {
                    Context context = zzibVar.zzc;
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
                        this.zzo.zzF("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        zzN(zzpoVar);
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        try {
                            SharedPreferences.Editor edit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            edit.putString(com.adjust.sdk.Constants.DEEPLINK, optString);
                            edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                            if (edit.commit()) {
                                Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                Context context2 = zzpoVar.zzu.zzc;
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
                            zzgt zzgtVar4 = zzpoVar.zzu.zzh;
                            zzP(zzgtVar4);
                            zzgtVar4.zzb().zzb("Failed to persist Deferred Deep Link. exception", e);
                            return;
                        }
                    }
                }
                zzgt zzgtVar5 = this.zzh;
                zzP(zzgtVar5);
                zzgtVar5.zze().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                return;
            } catch (JSONException e2) {
                zzgt zzgtVar6 = this.zzh;
                zzP(zzgtVar6);
                zzgtVar6.zzb().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzgt zzgtVar7 = this.zzh;
        zzP(zzgtVar7);
        zzgtVar7.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(zzjr zzjrVar) {
        zzhy zzhyVar = this.zzi;
        zzP(zzhyVar);
        zzhyVar.zzg();
        zzal zzalVar = this.zzf;
        zzalVar.zzb();
        zzba zzbaVar = new zzba(this);
        zzbaVar.zzx();
        this.zzu = zzbaVar;
        com.google.android.gms.internal.measurement.zzdd zzddVar = zzjrVar.zzd;
        zzgh zzghVar = new zzgh(this, zzjrVar.zzc, zzddVar == null ? 0L : zzddVar.zza);
        zzghVar.zzc();
        this.zzv = zzghVar;
        zzgk zzgkVar = new zzgk(this);
        zzgkVar.zzc();
        this.zzs = zzgkVar;
        zznk zznkVar = new zznk(this);
        zznkVar.zzc();
        this.zzt = zznkVar;
        zzpo zzpoVar = this.zzk;
        zzpoVar.zzy();
        this.zzg.zzy();
        this.zzv.zzd();
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzc();
        this.zzw = zzlpVar;
        zzlpVar.zzd();
        zzgt zzgtVar = this.zzh;
        zzP(zzgtVar);
        zzgr zzi = zzgtVar.zzi();
        zzalVar.zzi();
        zzi.zzb("App measurement initialized, version", 130000L);
        zzP(zzgtVar);
        zzgtVar.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzj = zzghVar.zzj();
        zzN(zzpoVar);
        if (!zzpoVar.zzaa(zzj, zzalVar.zzz())) {
            zzP(zzgtVar);
            zzgr zzi2 = zzgtVar.zzi();
            String.valueOf(zzj);
            zzi2.zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzj)));
        } else {
            zzP(zzgtVar);
            zzgtVar.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        }
        zzP(zzgtVar);
        zzgtVar.zzj().zza("Debug-level message logging enabled");
        int i = this.zzC;
        AtomicInteger atomicInteger = this.zzE;
        if (i != atomicInteger.get()) {
            zzP(zzgtVar);
            zzgtVar.zzb().zzc("Not all components initialized", Integer.valueOf(this.zzC), Integer.valueOf(atomicInteger.get()));
        }
        this.zzx = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r1.zzS() == false) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0253  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        zzjk zza;
        zzli zzliVar;
        zzjh zzw;
        zzjh zzw2;
        Bundle bundle;
        zzaz zzh;
        Boolean zzr;
        zzhd zzhdVar;
        zzhy zzhyVar = this.zzi;
        zzP(zzhyVar);
        zzhyVar.zzg();
        com.google.android.gms.internal.measurement.zzin zzj = zzx().zzj();
        com.google.android.gms.internal.measurement.zzin zzinVar = com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE;
        zzql.zza();
        zzfw zzfwVar = zzfx.zzaQ;
        zzal zzalVar = this.zzf;
        boolean zzp = zzalVar.zzp(null, zzfwVar);
        boolean z = zzj == zzinVar;
        if (zzp) {
            zzpo zzpoVar = this.zzk;
            zzN(zzpoVar);
        }
        if (z) {
            z = true;
            zzpo zzpoVar2 = this.zzk;
            zzN(zzpoVar2);
            zzpoVar2.zzg();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            zzw zzwVar = new zzw(zzpoVar2.zzu);
            zzib zzibVar = zzpoVar2.zzu;
            ContextCompat.registerReceiver(zzibVar.zzc, zzwVar, intentFilter, 2);
            zzgt zzgtVar = zzibVar.zzh;
            zzP(zzgtVar);
            zzgtVar.zzj().zza("Registered app receiver");
            if (z) {
                zzx().zzh(((Long) zzfx.zzB.zzb(null)).longValue());
            }
        }
        zzhg zzhgVar = this.zzg;
        zzN(zzhgVar);
        zzjk zzl = zzhgVar.zzl();
        int zzb2 = zzl.zzb();
        zzjh zzw3 = zzalVar.zzw("google_analytics_default_allow_ad_storage", false);
        zzjh zzw4 = zzalVar.zzw("google_analytics_default_allow_analytics_storage", false);
        zzjh zzjhVar = zzjh.UNINITIALIZED;
        if (zzw3 != zzjhVar || zzw4 != zzjhVar) {
            zzN(zzhgVar);
            if (zzhgVar.zzk(-10)) {
                zza = zzjk.zza(zzw3, zzw4, -10);
                if (zza != null) {
                    zzli zzliVar2 = this.zzo;
                    zzO(zzliVar2);
                    zzliVar2.zzs(zza, true);
                    zzl = zza;
                }
                zzliVar = this.zzo;
                zzO(zzliVar);
                zzliVar.zzA(zzl);
                zzN(zzhgVar);
                int zzb3 = zzhgVar.zzj().zzb();
                zzw = zzalVar.zzw("google_analytics_default_allow_ad_personalization_signals", true);
                if (zzw != zzjhVar) {
                    zzgt zzgtVar2 = this.zzh;
                    zzP(zzgtVar2);
                    zzgtVar2.zzk().zzb("Default ad personalization consent from Manifest", zzw);
                }
                zzw2 = zzalVar.zzw("google_analytics_default_allow_ad_user_data", true);
                if (zzw2 != zzjhVar || !zzjk.zzu(-10, zzb3)) {
                    if (!TextUtils.isEmpty(zzv().zzk()) || (zzb3 != 0 && zzb3 != 30)) {
                        if (TextUtils.isEmpty(zzv().zzk()) && zzddVar != null && (bundle = zzddVar.zzd) != null && zzjk.zzu(30, zzb3)) {
                            zzh = zzaz.zzh(bundle, 30);
                            if (zzh.zzd()) {
                                zzO(zzliVar);
                                zzliVar.zzq(zzh, true);
                            }
                        }
                    } else {
                        zzO(zzliVar);
                        zzliVar.zzq(new zzaz((Boolean) null, -10, (Boolean) null, (String) null), true);
                    }
                } else {
                    zzO(zzliVar);
                    zzliVar.zzq(zzaz.zza(zzw2, -10), true);
                }
                zzib zzibVar2 = zzalVar.zzu;
                zzr = zzalVar.zzr("google_analytics_tcf_data_enabled");
                if (zzr != null || zzr.booleanValue()) {
                    zzgt zzgtVar3 = this.zzh;
                    zzP(zzgtVar3);
                    zzgtVar3.zzj().zza("TCF client enabled.");
                    zzO(zzliVar);
                    zzliVar.zzE();
                    zzO(zzliVar);
                    zzliVar.zzD();
                }
                zzN(zzhgVar);
                zzhdVar = zzhgVar.zzc;
                if (zzhdVar.zza() == 0) {
                    zzgt zzgtVar4 = this.zzh;
                    zzP(zzgtVar4);
                    long j = this.zza;
                    zzgtVar4.zzk().zzb("Persisting first open", Long.valueOf(j));
                    zzN(zzhgVar);
                    zzhdVar.zzb(j);
                }
                zzO(zzliVar);
                zzliVar.zzb.zzc();
                if (!zzH()) {
                    if (!TextUtils.isEmpty(zzv().zzk())) {
                        zzpo zzpoVar3 = this.zzk;
                        zzN(zzpoVar3);
                        String zzk = zzv().zzk();
                        zzN(zzhgVar);
                        zzhgVar.zzg();
                        if (zzpoVar3.zzB(zzk, zzhgVar.zzd().getString("gmp_app_id", null))) {
                            zzgt zzgtVar5 = this.zzh;
                            zzP(zzgtVar5);
                            zzgtVar5.zzi().zza("Rechecking which service to use due to a GMP App Id change");
                            zzN(zzhgVar);
                            zzhgVar.zzg();
                            Boolean zzi = zzhgVar.zzi();
                            SharedPreferences.Editor edit = zzhgVar.zzd().edit();
                            edit.clear();
                            edit.apply();
                            if (zzi != null) {
                                zzhgVar.zzh(zzi);
                            }
                            zzm().zzh();
                            this.zzt.zzM();
                            this.zzt.zzI();
                            zzN(zzhgVar);
                            zzhdVar.zzb(this.zza);
                            zzN(zzhgVar);
                            zzhgVar.zze.zzb(null);
                        }
                        zzN(zzhgVar);
                        String zzk2 = zzv().zzk();
                        zzhgVar.zzg();
                        SharedPreferences.Editor edit2 = zzhgVar.zzd().edit();
                        edit2.putString("gmp_app_id", zzk2);
                        edit2.apply();
                    }
                    zzN(zzhgVar);
                    if (!zzhgVar.zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
                        zzN(zzhgVar);
                        zzhgVar.zze.zzb(null);
                    }
                    zzO(zzliVar);
                    zzN(zzhgVar);
                    zzliVar.zzR(zzhgVar.zze.zza());
                    zzpo zzpoVar4 = this.zzk;
                    zzN(zzpoVar4);
                    try {
                        zzpoVar4.zzu.zzc.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                    } catch (ClassNotFoundException unused) {
                        zzhg zzhgVar2 = this.zzg;
                        zzN(zzhgVar2);
                        zzhf zzhfVar = zzhgVar2.zzq;
                        if (!TextUtils.isEmpty(zzhfVar.zza())) {
                            zzgt zzgtVar6 = this.zzh;
                            zzP(zzgtVar6);
                            zzgtVar6.zze().zza("Remote config removed with active feature rollouts");
                            zzN(zzhgVar2);
                            zzhfVar.zzb(null);
                        }
                    }
                    if (!TextUtils.isEmpty(zzv().zzk())) {
                        boolean zzB = zzB();
                        zzhg zzhgVar3 = this.zzg;
                        zzN(zzhgVar3);
                        if (!zzhgVar3.zzo() && !this.zzf.zzt()) {
                            zzN(zzhgVar3);
                            zzhgVar3.zzn(!zzB);
                        }
                        if (zzB) {
                            zzli zzliVar3 = this.zzo;
                            zzO(zzliVar3);
                            zzliVar3.zzU();
                        }
                        zzob zzobVar = this.zzj;
                        zzO(zzobVar);
                        zzobVar.zza.zza();
                        zzt().zzC(new AtomicReference());
                        zznk zzt = zzt();
                        zzN(zzhgVar3);
                        zzt.zzH(zzhgVar3.zzt.zza());
                    }
                } else if (zzB()) {
                    zzpo zzpoVar5 = this.zzk;
                    zzN(zzpoVar5);
                    if (!zzpoVar5.zzY("android.permission.INTERNET")) {
                        zzgt zzgtVar7 = this.zzh;
                        zzP(zzgtVar7);
                        zzgtVar7.zzb().zza("App is missing INTERNET permission");
                    }
                    zzN(zzpoVar5);
                    if (!zzpoVar5.zzY("android.permission.ACCESS_NETWORK_STATE")) {
                        zzgt zzgtVar8 = this.zzh;
                        zzP(zzgtVar8);
                        zzgtVar8.zzb().zza("App is missing ACCESS_NETWORK_STATE permission");
                    }
                    Context context = this.zzc;
                    if (!Wrappers.packageManager(context).isCallerInstantApp() && !this.zzf.zzE()) {
                        if (!zzpo.zzau(context)) {
                            zzgt zzgtVar9 = this.zzh;
                            zzP(zzgtVar9);
                            zzgtVar9.zzb().zza("AppMeasurementReceiver not registered/enabled");
                        }
                        if (!zzpo.zzQ(context, false)) {
                            zzgt zzgtVar10 = this.zzh;
                            zzP(zzgtVar10);
                            zzgtVar10.zzb().zza("AppMeasurementService not registered/enabled");
                        }
                    }
                    zzgt zzgtVar11 = this.zzh;
                    zzP(zzgtVar11);
                    zzgtVar11.zzb().zza("Uploading is not possible. App measurement disabled");
                }
                zzql.zza();
                if (this.zzf.zzp(null, zzfx.zzaQ)) {
                    zzpo zzpoVar6 = this.zzk;
                    zzN(zzpoVar6);
                    if (zzpoVar6.zzS()) {
                        long max = Math.max(500L, ((((Integer) zzfx.zzax.zzb(null)).intValue() * 1000) + new Random().nextInt(5000)) - this.zzm.elapsedRealtime());
                        if (max > 500) {
                            zzgt zzgtVar12 = this.zzh;
                            zzP(zzgtVar12);
                            zzgtVar12.zzk().zzb("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(max));
                        }
                        zzli zzliVar4 = this.zzo;
                        zzO(zzliVar4);
                        zzliVar4.zzu(max);
                    }
                }
                zzhg zzhgVar4 = this.zzg;
                zzN(zzhgVar4);
                zzhgVar4.zzj.zzb(true);
            }
        }
        if (!TextUtils.isEmpty(zzv().zzk()) && (zzb2 == 0 || zzb2 == 30 || zzb2 == 10 || zzb2 == 40)) {
            zzli zzliVar5 = this.zzo;
            zzO(zzliVar5);
            zzliVar5.zzs(new zzjk(null, null, -10), false);
        }
        zza = null;
        if (zza != null) {
        }
        zzliVar = this.zzo;
        zzO(zzliVar);
        zzliVar.zzA(zzl);
        zzN(zzhgVar);
        int zzb32 = zzhgVar.zzj().zzb();
        zzw = zzalVar.zzw("google_analytics_default_allow_ad_personalization_signals", true);
        if (zzw != zzjhVar) {
        }
        zzw2 = zzalVar.zzw("google_analytics_default_allow_ad_user_data", true);
        if (zzw2 != zzjhVar) {
        }
        if (!TextUtils.isEmpty(zzv().zzk())) {
        }
        if (TextUtils.isEmpty(zzv().zzk())) {
            zzh = zzaz.zzh(bundle, 30);
            if (zzh.zzd()) {
            }
        }
        zzib zzibVar22 = zzalVar.zzu;
        zzr = zzalVar.zzr("google_analytics_tcf_data_enabled");
        if (zzr != null) {
        }
        zzgt zzgtVar32 = this.zzh;
        zzP(zzgtVar32);
        zzgtVar32.zzj().zza("TCF client enabled.");
        zzO(zzliVar);
        zzliVar.zzE();
        zzO(zzliVar);
        zzliVar.zzD();
        zzN(zzhgVar);
        zzhdVar = zzhgVar.zzc;
        if (zzhdVar.zza() == 0) {
        }
        zzO(zzliVar);
        zzliVar.zzb.zzc();
        if (!zzH()) {
        }
        zzql.zza();
        if (this.zzf.zzp(null, zzfx.zzaQ)) {
        }
        zzhg zzhgVar42 = this.zzg;
        zzN(zzhgVar42);
        zzhgVar42.zzj.zzb(true);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzae zzaU() {
        return this.zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzgt zzaV() {
        zzgt zzgtVar = this.zzh;
        zzP(zzgtVar);
        return zzgtVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzhy zzaW() {
        zzhy zzhyVar = this.zzi;
        zzP(zzhyVar);
        return zzhyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final Context zzaY() {
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final Clock zzaZ() {
        return this.zzm;
    }

    @Pure
    public final zzal zzc() {
        return this.zzf;
    }

    @Pure
    public final zzhg zzd() {
        zzhg zzhgVar = this.zzg;
        zzN(zzhgVar);
        return zzhgVar;
    }

    public final zzgt zzf() {
        zzgt zzgtVar = this.zzh;
        if (zzgtVar == null || !zzgtVar.zzv()) {
            return null;
        }
        return zzgtVar;
    }

    @Pure
    public final zzob zzh() {
        zzob zzobVar = this.zzj;
        zzO(zzobVar);
        return zzobVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final zzhy zzi() {
        return this.zzi;
    }

    @Pure
    public final zzli zzj() {
        zzli zzliVar = this.zzo;
        zzO(zzliVar);
        return zzliVar;
    }

    @Pure
    public final zzpo zzk() {
        zzpo zzpoVar = this.zzk;
        zzN(zzpoVar);
        return zzpoVar;
    }

    @Pure
    public final zzgm zzl() {
        return this.zzl;
    }

    @Pure
    public final zzgk zzm() {
        zzO(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzln zzn() {
        zzln zzlnVar = this.zzq;
        zzP(zzlnVar);
        return zzlnVar;
    }

    @Pure
    public final boolean zzp() {
        return this.zzd;
    }

    @Pure
    public final String zzq() {
        return this.zzr;
    }

    @Pure
    public final zzma zzs() {
        zzma zzmaVar = this.zzn;
        zzO(zzmaVar);
        return zzmaVar;
    }

    @Pure
    public final zznk zzt() {
        zzO(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzba zzu() {
        zzP(this.zzu);
        return this.zzu;
    }

    @Pure
    public final zzgh zzv() {
        zzO(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzd zzw() {
        zzd zzdVar = this.zzp;
        zzM(zzdVar);
        return zzdVar;
    }

    @Pure
    public final zzlp zzx() {
        zzM(this.zzw);
        return this.zzw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzz(boolean z) {
        this.zzA = Boolean.valueOf(z);
    }
}
