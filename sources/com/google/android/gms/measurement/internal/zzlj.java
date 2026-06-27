package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzabw;
import com.google.android.gms.internal.measurement.zzabx;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzlj extends zzg {
    protected zzky zza;
    final zzx zzb;
    protected boolean zzc;
    private zzjp zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private boolean zzi;
    private int zzj;
    private zzaz zzk;
    private zzaz zzl;
    private PriorityQueue zzm;
    private zzjl zzn;
    private final AtomicLong zzo;
    private long zzp;
    private zzaz zzq;
    private SharedPreferences.OnSharedPreferenceChangeListener zzr;
    private zzaz zzs;
    private final zzpo zzt;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzlj(zzic zzicVar) {
        super(zzicVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzi = false;
        this.zzj = 1;
        this.zzc = true;
        this.zzt = new zzkn(this);
        this.zzg = new AtomicReference();
        this.zzn = zzjl.zza;
        this.zzp = -1L;
        this.zzo = new AtomicLong(0L);
        this.zzb = new zzx(zzicVar);
    }

    private final zzlr zzap(final zzom zzomVar) {
        try {
            URL url = new URI(zzomVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String zzl = this.zzu.zzv().zzl();
            zzic zzicVar = this.zzu;
            zzgs zzk = zzicVar.zzaW().zzk();
            Long valueOf = Long.valueOf(zzomVar.zza);
            zzk.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, zzomVar.zzc, Integer.valueOf(zzomVar.zzb.length));
            if (!TextUtils.isEmpty(zzomVar.zzg)) {
                zzicVar.zzaW().zzk().zzc("[sgtm] Uploading data from app. row_id", valueOf, zzomVar.zzg);
            }
            HashMap hashMap = new HashMap();
            Bundle bundle = zzomVar.zzd;
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str, string);
                }
            }
            zzlo zzn = zzicVar.zzn();
            byte[] bArr = zzomVar.zzb;
            zzll zzllVar = new zzll() { // from class: com.google.android.gms.measurement.internal.zzkz
                /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // com.google.android.gms.measurement.internal.zzll
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr2, Map map) {
                    zzlr zzlrVar;
                    AtomicReference atomicReference2;
                    zzlj zzljVar = zzlj.this;
                    zzljVar.zzg();
                    zzom zzomVar2 = zzomVar;
                    if (i != 200 && i != 204) {
                        if (i == 304) {
                            i = 304;
                        }
                        zzljVar.zzu.zzaW().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzomVar2.zza), Integer.valueOf(i), th);
                        zzlrVar = !Arrays.asList(((String) zzfy.zzt.zzb(null)).split(StringUtils.COMMA)).contains(String.valueOf(i)) ? zzlr.BACKOFF : zzlr.FAILURE;
                        atomicReference2 = atomicReference;
                        zznl zzt = zzljVar.zzu.zzt();
                        long j = zzomVar2.zza;
                        zzt.zzy(new zzaf(j, zzlrVar.zza(), zzomVar2.zzf));
                        zzljVar.zzu.zzaW().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j), zzlrVar);
                        synchronized (atomicReference2) {
                            atomicReference2.set(zzlrVar);
                            atomicReference2.notifyAll();
                        }
                        return;
                    }
                    if (th == null) {
                        zzljVar.zzu.zzaW().zzk().zzb("[sgtm] Upload succeeded for row_id", Long.valueOf(zzomVar2.zza));
                        zzlrVar = zzlr.SUCCESS;
                        atomicReference2 = atomicReference;
                        zznl zzt2 = zzljVar.zzu.zzt();
                        long j2 = zzomVar2.zza;
                        zzt2.zzy(new zzaf(j2, zzlrVar.zza(), zzomVar2.zzf));
                        zzljVar.zzu.zzaW().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j2), zzlrVar);
                        synchronized (atomicReference2) {
                        }
                    }
                    zzljVar.zzu.zzaW().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzomVar2.zza), Integer.valueOf(i), th);
                    if (!Arrays.asList(((String) zzfy.zzt.zzb(null)).split(StringUtils.COMMA)).contains(String.valueOf(i))) {
                    }
                    atomicReference2 = atomicReference;
                    zznl zzt22 = zzljVar.zzu.zzt();
                    long j22 = zzomVar2.zza;
                    zzt22.zzy(new zzaf(j22, zzlrVar.zza(), zzomVar2.zzf));
                    zzljVar.zzu.zzaW().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j22), zzlrVar);
                    synchronized (atomicReference2) {
                    }
                }
            };
            zzn.zzw();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzllVar);
            zzn.zzu.zzaX().zzm(new zzln(zzn, zzl, url, bArr, hashMap, zzllVar));
            try {
                zzic zzicVar2 = zzicVar.zzk().zzu;
                long currentTimeMillis = zzicVar2.zzba().currentTimeMillis() + 60000;
                synchronized (atomicReference) {
                    for (long j = 60000; atomicReference.get() == null && j > 0; j = currentTimeMillis - zzicVar2.zzba().currentTimeMillis()) {
                        atomicReference.wait(j);
                    }
                }
            } catch (InterruptedException unused) {
                this.zzu.zzaW().zze().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? zzlr.UNKNOWN : (zzlr) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e) {
            this.zzu.zzaW().zzb().zzd("[sgtm] Bad upload url for row_id", zzomVar.zzc, Long.valueOf(zzomVar.zza), e);
            return zzlr.FAILURE;
        }
    }

    private final void zzaq(Boolean bool, boolean z) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zzb("Setting app measurement enabled (FE)", bool);
        zzicVar.zzd().zzh(bool);
        if (z) {
            zzhh zzd = zzicVar.zzd();
            zzic zzicVar2 = zzd.zzu;
            zzd.zzg();
            SharedPreferences.Editor edit = zzd.zzd().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzu.zzE() || !(bool == null || bool.booleanValue())) {
            zzak();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzar */
    public final void zzak() {
        zzlj zzljVar;
        zzg();
        zzic zzicVar = this.zzu;
        String zza = zzicVar.zzd().zzh.zza();
        if (zza == null) {
            zzljVar = this;
        } else if ("unset".equals(zza)) {
            zzljVar = this;
            zzljVar.zzM("app", "_npa", null, zzicVar.zzba().currentTimeMillis());
        } else {
            zzljVar = this;
            zzljVar.zzM("app", "_npa", Long.valueOf(true != "true".equals(zza) ? 0L : 1L), zzicVar.zzba().currentTimeMillis());
        }
        if (!zzljVar.zzu.zzB() || !zzljVar.zzc) {
            zzicVar.zzaW().zzj().zza("Updating Scion state (FE)");
            zzljVar.zzu.zzt().zzi();
            return;
        }
        zzicVar.zzaW().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzljVar.zzT();
        zzljVar.zzu.zzh().zza.zza();
        zzicVar.zzaX().zzj(new zzjz(zzljVar));
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        zzic zzicVar = this.zzu;
        zzB(str, str2, bundle, true, true, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L);
    }

    public final void zzB(String str, String str2, Bundle bundle, boolean z, boolean z2, long j, long j2) {
        long j3;
        zzmb zzmbVar;
        long j4;
        Bundle bundle2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle3 = bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzic zzicVar = this.zzu;
            zzic zzicVar2 = this.zzu;
            zzmb zzs = zzicVar.zzs();
            if (true != zzicVar2.zzc().zzp(null, zzfy.zzbe)) {
                j3 = 0;
                j4 = j;
                bundle2 = bundle3;
                zzmbVar = zzs;
            } else {
                j3 = j2;
                zzmbVar = zzs;
                j4 = j;
                bundle2 = bundle3;
            }
            zzmbVar.zzj(bundle2, j4, j3);
            return;
        }
        boolean z3 = !z2 || this.zzd == null || zzpp.zzac(str2);
        if (str == null) {
            str = "app";
        }
        zzI(str, str2, j, true != this.zzu.zzc().zzp(null, zzfy.zzbe) ? 0L : j2, bundle3, z2, z3, z, null);
    }

    public final void zzC() {
        zzod zzodVar;
        zzabx zzabxVar;
        zzg();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zza("Handle tcf update.");
        SharedPreferences zze = zzicVar.zzd().zze();
        int i = zzof.zzb;
        zzabw zzabwVar = zzabw.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        zzoe zzoeVar = zzoe.CONSENT;
        zzabw zzabwVar2 = zzabw.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
        zzoe zzoeVar2 = zzoe.FLEXIBLE_LEGITIMATE_INTEREST;
        ImmutableMap of = ImmutableMap.of(zzabwVar, zzoeVar, zzabwVar2, zzoeVar2, zzabw.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, zzoeVar, zzabw.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, zzoeVar, zzabw.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, zzoeVar2, zzabw.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, zzoeVar2, zzabw.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, zzoeVar2);
        ImmutableSet of2 = ImmutableSet.of("CH");
        char[] cArr = new char[5];
        boolean contains = zze.contains("IABTCF_TCString");
        int zzb = zzof.zzb(zze, "IABTCF_CmpSdkID");
        int zzb2 = zzof.zzb(zze, "IABTCF_PolicyVersion");
        int zzb3 = zzof.zzb(zze, "IABTCF_gdprApplies");
        int zzb4 = zzof.zzb(zze, "IABTCF_PurposeOneTreatment");
        int zzb5 = zzof.zzb(zze, "IABTCF_EnableAdvertiserConsentMode");
        String zza = zzof.zza(zze, "IABTCF_PublisherCC");
        ImmutableMap.Builder builder = ImmutableMap.builder();
        UnmodifiableIterator it = of.keySet().iterator();
        while (it.hasNext()) {
            zzabw zzabwVar3 = (zzabw) it.next();
            int zza2 = zzabwVar3.zza();
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 28);
            sb.append("IABTCF_PublisherRestrictions");
            sb.append(zza2);
            String zza3 = zzof.zza(zze, sb.toString());
            if (TextUtils.isEmpty(zza3) || zza3.length() < 755) {
                zzabxVar = zzabx.PURPOSE_RESTRICTION_UNDEFINED;
            } else {
                int digit = Character.digit(zza3.charAt(754), 10);
                zzabxVar = (digit < 0 || digit > zzabx.values().length || digit == 0) ? zzabx.PURPOSE_RESTRICTION_NOT_ALLOWED : digit != 1 ? digit != 2 ? zzabx.PURPOSE_RESTRICTION_UNDEFINED : zzabx.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST : zzabx.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
            }
            builder.put(zzabwVar3, zzabxVar);
        }
        ImmutableMap buildOrThrow = builder.buildOrThrow();
        String zza4 = zzof.zza(zze, "IABTCF_PurposeConsents");
        String zza5 = zzof.zza(zze, "IABTCF_VendorConsents");
        boolean z = !TextUtils.isEmpty(zza5) && zza5.length() >= 755 && zza5.charAt(754) == '1';
        String zza6 = zzof.zza(zze, "IABTCF_PurposeLegitimateInterests");
        String zza7 = zzof.zza(zze, "IABTCF_VendorLegitimateInterests");
        boolean z2 = !TextUtils.isEmpty(zza7) && zza7.length() >= 755 && zza7.charAt(754) == '1';
        cArr[0] = '2';
        zzod zzodVar2 = new zzod(zzof.zzd(of, buildOrThrow, of2, cArr, zzb, zzb5, zzb3, zzb2, zzb4, zza, zza4, zza6, z, z2, contains));
        zzicVar.zzaW().zzk().zzb("Tcf preferences read", zzodVar2);
        zzhh zzd = zzicVar.zzd();
        zzd.zzg();
        String string = zzd.zzd().getString("stored_tcf_param", "");
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(string)) {
            zzodVar = new zzod(hashMap);
        } else {
            for (String str : string.split(";")) {
                String[] split = str.split("=");
                if (split.length >= 2 && zzof.zza.contains(split[0])) {
                    hashMap.put(split[0], split[1]);
                }
            }
            zzodVar = new zzod(hashMap);
        }
        zzhh zzd2 = zzicVar.zzd();
        zzd2.zzg();
        String string2 = zzd2.zzd().getString("stored_tcf_param", "");
        String zza8 = zzodVar2.zza();
        if (zza8.equals(string2)) {
            return;
        }
        SharedPreferences.Editor edit = zzd2.zzd().edit();
        edit.putString("stored_tcf_param", zza8);
        edit.apply();
        Bundle zzb6 = zzodVar2.zzb();
        zzicVar.zzaW().zzk().zzb("Consent generated from Tcf", zzb6);
        if (zzb6 != Bundle.EMPTY) {
            zzp(zzb6, -30, zzicVar.zzba().currentTimeMillis());
        }
        Bundle bundle = new Bundle();
        bundle.putString("_tcfm", zzodVar2.zzd(zzodVar));
        bundle.putString("_tcfd2", zzodVar2.zzc());
        bundle.putString("_tcfd", zzodVar2.zze());
        zzE("auto", "_tcf", bundle);
    }

    public final void zzD() {
        zzg();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zza("Register tcfPrefChangeListener.");
        if (this.zzr == null) {
            this.zzs = new zzkb(this, this.zzu);
            this.zzr = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzle
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzlj.this.zzaf(sharedPreferences, str);
                }
            };
        }
        zzicVar.zzd().zze().registerOnSharedPreferenceChangeListener(this.zzr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzE(String str, String str2, Bundle bundle) {
        zzg();
        zzic zzicVar = this.zzu;
        zzF(str, str2, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(String str, String str2, long j, long j2, Bundle bundle) {
        zzg();
        boolean z = true;
        if (this.zzd != null && !zzpp.zzac(str2)) {
            z = false;
        }
        zzG(str, str2, j, j2, bundle, true, z, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzG(String str, String str2, long j, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        char c;
        zzlu zzh;
        boolean equals;
        boolean z4;
        zzic zzicVar;
        int i;
        long j3;
        boolean zza;
        boolean z5;
        long j4;
        String str4;
        ArrayList arrayList;
        zzlj zzljVar;
        int size;
        int i2;
        int i3;
        Bundle[] bundleArr;
        int i4;
        Class<?> cls;
        String str5 = str;
        Preconditions.checkNotEmpty(str5);
        Preconditions.checkNotNull(bundle);
        zzg();
        zzb();
        zzic zzicVar2 = this.zzu;
        if (zzicVar2.zzB()) {
            List zzp = this.zzu.zzv().zzp();
            if (zzp != null && !zzp.contains(str2)) {
                this.zzu.zzaW().zzj().zzc("Dropping non-safelisted event. event name, origin", str2, str5);
                return;
            }
            if (!this.zzf) {
                this.zzf = true;
                try {
                    if (zzicVar2.zzp()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzu.zzaZ().getClassLoader());
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, this.zzu.zzaZ());
                    } catch (Exception e) {
                        this.zzu.zzaW().zze().zzb("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException unused) {
                    this.zzu.zzaW().zzi().zza("Tag Manager is not found and thus will not be used");
                }
            }
            zzic zzicVar3 = this.zzu;
            if (!zzicVar3.zzc().zzp(null, zzfy.zzaZ) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
                zzicVar3.zzaV();
                zzM("auto", "_lgclid", bundle.getString("gclid"), zzicVar3.zzba().currentTimeMillis());
            }
            zzicVar3.zzaV();
            if (z && zzpp.zzai(str2)) {
                zzicVar3.zzk().zzK(bundle, zzicVar3.zzd().zzt.zza());
            }
            if (!z3) {
                zzicVar3.zzaV();
                if (!"_iap".equals(str2)) {
                    zzic zzicVar4 = this.zzu;
                    zzpp zzk = zzicVar4.zzk();
                    if (zzk.zzk("event", str2)) {
                        zzic zzicVar5 = zzk.zzu;
                        c = 2;
                        if (zzk.zzm("event", zzjm.zza, zzicVar5.zzc().zzp(null, zzfy.zzbf) ? zzjm.zzc : zzjm.zzb, str2)) {
                            zzicVar5.zzc();
                            i4 = !zzk.zzn("event", 40, str2) ? 2 : 0;
                        } else {
                            i4 = 13;
                        }
                    } else {
                        i4 = 2;
                        c = 2;
                    }
                    if (i4 != 0) {
                        zzicVar3.zzaW().zzd().zzb("Invalid public event name. Event will not be logged (FE)", zzicVar3.zzl().zza(str2));
                        zzpp zzk2 = zzicVar4.zzk();
                        zzicVar4.zzc();
                        zzicVar4.zzk().zzP(this.zzt, null, i4, "_ev", zzk2.zzE(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                    zzicVar3.zzaV();
                    zzic zzicVar6 = this.zzu;
                    zzh = zzicVar6.zzs().zzh(false);
                    if (zzh != null && !bundle.containsKey("_sc")) {
                        zzh.zzd = true;
                    }
                    zzpp.zzay(zzh, bundle, (z || z3) ? false : true);
                    equals = "am".equals(str5);
                    boolean zzac = zzpp.zzac(str2);
                    if (z || this.zzd == null || zzac) {
                        z4 = equals;
                    } else if (!equals) {
                        zzicVar3.zzaW().zzj().zzc("Passing event to registered event handler (FE)", zzicVar3.zzl().zza(str2), zzicVar3.zzl().zze(bundle));
                        Preconditions.checkNotNull(this.zzd);
                        this.zzd.interceptEvent(str5, str2, bundle, j);
                        return;
                    } else {
                        z4 = true;
                    }
                    zzicVar = this.zzu;
                    if (zzicVar.zzH()) {
                        return;
                    }
                    int zzp2 = zzicVar3.zzk().zzp(str2);
                    if (zzp2 != 0) {
                        zzicVar3.zzaW().zzd().zzb("Invalid event name. Event will not be logged (FE)", zzicVar3.zzl().zza(str2));
                        zzpp zzk3 = zzicVar3.zzk();
                        zzicVar3.zzc();
                        zzicVar.zzk().zzP(this.zzt, str3, zzp2, "_ev", zzk3.zzE(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                    String[] strArr = new String[4];
                    strArr[0] = "_o";
                    strArr[1] = "_sn";
                    strArr[c] = "_sc";
                    strArr[3] = "_si";
                    Bundle zzH = zzicVar3.zzk().zzH(str3, str2, bundle, CollectionUtils.listOf((Object[]) strArr), z3);
                    Preconditions.checkNotNull(zzH);
                    zzicVar3.zzaV();
                    if (zzicVar6.zzs().zzh(false) == null || !"_ae".equals(str2)) {
                        i = 0;
                        j3 = 0;
                    } else {
                        zzoa zzoaVar = zzicVar6.zzh().zzb;
                        j3 = 0;
                        long elapsedRealtime = zzoaVar.zzc.zzu.zzba().elapsedRealtime();
                        i = 0;
                        long j5 = elapsedRealtime - zzoaVar.zzb;
                        zzoaVar.zzb = elapsedRealtime;
                        if (j5 > 0) {
                            zzicVar3.zzk().zzan(zzH, j5);
                        }
                    }
                    if (!"auto".equals(str5) && "_ssr".equals(str2)) {
                        zzpp zzk4 = zzicVar3.zzk();
                        String string = zzH.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            string = null;
                        } else if (string != null) {
                            string = string.trim();
                        }
                        zzic zzicVar7 = zzk4.zzu;
                        if (!Objects.equals(string, zzicVar7.zzd().zzq.zza())) {
                            zzicVar7.zzd().zzq.zzb(string);
                        } else {
                            zzicVar7.zzaW().zzj().zza("Not logging duplicate session_start_with_rollout event");
                            return;
                        }
                    } else if ("_ae".equals(str2)) {
                        String zza2 = zzicVar3.zzk().zzu.zzd().zzq.zza();
                        if (!TextUtils.isEmpty(zza2)) {
                            zzH.putString("_ffr", zza2);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(zzH);
                    if (!zzicVar3.zzc().zzp(null, zzfy.zzaS)) {
                        zza = zzicVar3.zzd().zzn.zza();
                    } else {
                        zza = zzicVar6.zzh().zzi();
                    }
                    if (zzicVar3.zzd().zzk.zza() > j3) {
                        arrayList = arrayList2;
                        if (zzicVar3.zzd().zzo(j) && zza) {
                            zzicVar3.zzaW().zzk().zza("Current session is expired, remove the session number, ID, and engagement time");
                            z5 = z4;
                            j4 = j3;
                            str4 = "_ae";
                            zzM("auto", "_sid", null, zzicVar3.zzba().currentTimeMillis());
                            zzM("auto", "_sno", null, zzicVar3.zzba().currentTimeMillis());
                            zzM("auto", "_se", null, zzicVar3.zzba().currentTimeMillis());
                            zzljVar = this;
                            zzicVar3.zzd().zzl.zzb(j4);
                            if (zzH.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j4) == 1) {
                                zzicVar3.zzaW().zzk().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                                zzicVar.zzh().zza.zzb(j, j2, true);
                            }
                            ArrayList arrayList3 = new ArrayList(zzH.keySet());
                            Collections.sort(arrayList3);
                            size = arrayList3.size();
                            for (i2 = i; i2 < size; i2++) {
                                String str6 = (String) arrayList3.get(i2);
                                if (str6 != null) {
                                    zzicVar3.zzk();
                                    Object obj = zzH.get(str6);
                                    if (obj instanceof Bundle) {
                                        bundleArr = new Bundle[1];
                                        bundleArr[i] = (Bundle) obj;
                                    } else if (obj instanceof Parcelable[]) {
                                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                                    } else if (obj instanceof ArrayList) {
                                        ArrayList arrayList4 = (ArrayList) obj;
                                        bundleArr = (Bundle[]) arrayList4.toArray(new Bundle[arrayList4.size()]);
                                    } else {
                                        bundleArr = null;
                                    }
                                    if (bundleArr != null) {
                                        zzH.putParcelableArray(str6, bundleArr);
                                    }
                                }
                            }
                            i3 = i;
                            while (i3 < arrayList.size()) {
                                ArrayList arrayList5 = arrayList;
                                Bundle bundle2 = (Bundle) arrayList5.get(i3);
                                String str7 = i3 != 0 ? "_ep" : str2;
                                bundle2.putString("_o", str5);
                                if (z2) {
                                    bundle2 = zzicVar3.zzk().zzae(bundle2, null);
                                }
                                Bundle bundle3 = bundle2;
                                zzicVar6.zzt().zzn(new zzbh(str7, new zzbf(bundle2), str5, j, j2), str3);
                                if (!z5) {
                                    for (zzjq zzjqVar : zzljVar.zze) {
                                        zzjqVar.onEvent(str, str2, new Bundle(bundle3), j);
                                    }
                                }
                                i3++;
                                str5 = str;
                                arrayList = arrayList5;
                            }
                            zzicVar3.zzaV();
                            if (zzicVar6.zzs().zzh(i) == null && str4.equals(str2)) {
                                zzicVar6.zzh().zzb.zzd(true, true, zzicVar3.zzba().elapsedRealtime());
                                return;
                            }
                            return;
                        }
                        z5 = z4;
                        j4 = j3;
                        str4 = "_ae";
                    } else {
                        z5 = z4;
                        j4 = j3;
                        str4 = "_ae";
                        arrayList = arrayList2;
                    }
                    zzljVar = this;
                    if (zzH.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j4) == 1) {
                    }
                    ArrayList arrayList32 = new ArrayList(zzH.keySet());
                    Collections.sort(arrayList32);
                    size = arrayList32.size();
                    while (i2 < size) {
                    }
                    i3 = i;
                    while (i3 < arrayList.size()) {
                    }
                    zzicVar3.zzaV();
                    if (zzicVar6.zzs().zzh(i) == null) {
                        return;
                    }
                    return;
                }
            }
            c = 2;
            zzicVar3.zzaV();
            zzic zzicVar62 = this.zzu;
            zzh = zzicVar62.zzs().zzh(false);
            if (zzh != null) {
                zzh.zzd = true;
            }
            zzpp.zzay(zzh, bundle, (z || z3) ? false : true);
            equals = "am".equals(str5);
            boolean zzac2 = zzpp.zzac(str2);
            if (z) {
            }
            z4 = equals;
            zzicVar = this.zzu;
            if (zzicVar.zzH()) {
            }
        } else {
            this.zzu.zzaW().zzj().zza("Event not sent since app measurement is disabled");
        }
    }

    public final void zzH(String str, String str2, Bundle bundle, String str3) {
        zzic.zzL();
        zzic zzicVar = this.zzu;
        zzI("auto", str2, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L, bundle, false, true, true, str3);
    }

    protected final void zzI(String str, String str2, long j, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int i = zzpp.zza;
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i2];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelable);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        this.zzu.zzaX().zzj(new zzkc(this, str, str2, j, j2, bundle2, z, z2, z3, str3));
    }

    public final void zzJ(String str, String str2, Object obj, boolean z) {
        zzK("auto", "_ldl", obj, true, this.zzu.zzba().currentTimeMillis());
    }

    final void zzL(String str, String str2, long j, Object obj) {
        this.zzu.zzaX().zzj(new zzkd(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzM(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzb();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    long j2 = true != "false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 0L : 1L;
                    zzic zzicVar = this.zzu;
                    Long valueOf = Long.valueOf(j2);
                    zzicVar.zzd().zzh.zzb(valueOf.longValue() == 1 ? "true" : "false");
                    obj = valueOf;
                    str2 = "_npa";
                    this.zzu.zzaW().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                this.zzu.zzd().zzh.zzb("unset");
                str2 = "_npa";
            }
            this.zzu.zzaW().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str4 = str2;
        Object obj2 = obj;
        zzic zzicVar2 = this.zzu;
        if (!zzicVar2.zzB()) {
            this.zzu.zzaW().zzk().zza("User property not set since app measurement is disabled");
        } else if (zzicVar2.zzH()) {
            this.zzu.zzt().zzA(new zzpl(str4, j, obj2, str));
        }
    }

    public final List zzN(boolean z) {
        zzb();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzk().zza("Getting user properties (FE)");
        if (!zzicVar.zzaX().zze()) {
            zzicVar.zzaV();
            if (zzae.zza()) {
                zzicVar.zzaW().zzb().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zzk(atomicReference, 5000L, "get user properties", new zzkf(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaW().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyList();
            }
            return list;
        }
        zzicVar.zzaW().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzO(String str, String str2, boolean z) {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaX().zze()) {
            zzicVar.zzaV();
            if (zzae.zza()) {
                zzicVar.zzaW().zzb().zza("Cannot get user properties from main thread");
                return Collections.emptyMap();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zzk(atomicReference, 5000L, "get user properties", new zzkl(this, atomicReference, null, str, str2, z));
            List<zzpl> list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaW().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzpl zzplVar : list) {
                Object zza = zzplVar.zza();
                if (zza != null) {
                    arrayMap.put(zzplVar.zzb, zza);
                }
            }
            return arrayMap;
        }
        zzicVar.zzaW().zzb().zza("Cannot get user properties from analytics worker thread");
        return Collections.emptyMap();
    }

    public final String zzP() {
        return (String) this.zzg.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzQ(String str) {
        this.zzg.set(str);
    }

    public final void zzR() {
        zzg();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzd().zzo.zza()) {
            long zza = zzicVar.zzd().zzp.zza();
            zzicVar.zzd().zzp.zzb(1 + zza);
            zzicVar.zzc();
            if (zza >= 5) {
                zzicVar.zzaW().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzicVar.zzd().zzo.zzb(true);
                return;
            }
            if (this.zzq == null) {
                this.zzq = new zzkg(this, this.zzu);
            }
            this.zzq.zzb(0L);
            return;
        }
        zzicVar.zzaW().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }

    public final void zzS(long j, long j2) {
        this.zzg.set(null);
        this.zzu.zzaX().zzj(new zzkh(this, j));
    }

    public final void zzT() {
        zzg();
        zzb();
        if (this.zzu.zzH()) {
            zzic zzicVar = this.zzu;
            zzal zzc = zzicVar.zzc();
            zzc.zzu.zzaV();
            Boolean zzr = zzc.zzr("google_analytics_deferred_deep_link_enabled");
            if (zzr != null && zzr.booleanValue()) {
                zzicVar.zzaW().zzj().zza("Deferred Deep Link feature enabled.");
                zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzlj.this.zzR();
                    }
                });
            }
            this.zzu.zzt().zzE();
            this.zzc = false;
            zzhh zzd = zzicVar.zzd();
            zzd.zzg();
            String string = zzd.zzd().getString("previous_os_version", null);
            zzd.zzu.zzu().zzw();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzd.zzd().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            zzicVar.zzu().zzw();
            if (string.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzE("auto", "_ou", bundle);
        }
    }

    public final void zzU(zzjp zzjpVar) {
        zzjp zzjpVar2;
        zzg();
        zzb();
        if (zzjpVar != null && zzjpVar != (zzjpVar2 = this.zzd)) {
            Preconditions.checkState(zzjpVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzjpVar;
    }

    public final void zzV(zzjq zzjqVar) {
        zzb();
        Preconditions.checkNotNull(zzjqVar);
        if (this.zze.add(zzjqVar)) {
            return;
        }
        this.zzu.zzaW().zze().zza("OnEventListener already registered");
    }

    public final void zzW(zzjq zzjqVar) {
        zzb();
        Preconditions.checkNotNull(zzjqVar);
        if (this.zze.remove(zzjqVar)) {
            return;
        }
        this.zzu.zzaW().zze().zza("OnEventListener had not been registered");
    }

    public final int zzX(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzu.zzc();
        return 25;
    }

    public final void zzY(Bundle bundle) {
        zzZ(bundle, this.zzu.zzba().currentTimeMillis());
    }

    public final void zzZ(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzu.zzaW().zze().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjh.zzb(bundle2, "app_id", String.class, null);
        zzjh.zzb(bundle2, "origin", String.class, null);
        zzjh.zzb(bundle2, "name", String.class, null);
        zzjh.zzb(bundle2, "value", Object.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzic zzicVar = this.zzu;
        if (zzicVar.zzk().zzs(string) == 0) {
            if (zzicVar.zzk().zzM(string, obj) == 0) {
                Object zzN = zzicVar.zzk().zzN(string, obj);
                if (zzN == null) {
                    zzicVar.zzaW().zzb().zzc("Unable to normalize conditional user property value", zzicVar.zzl().zzc(string), obj);
                    return;
                }
                zzjh.zza(bundle2, zzN);
                long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    zzicVar.zzc();
                    if (j2 > 15552000000L || j2 < 1) {
                        zzicVar.zzaW().zzb().zzc("Invalid conditional user property timeout", zzicVar.zzl().zzc(string), Long.valueOf(j2));
                        return;
                    }
                }
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                zzicVar.zzc();
                if (j3 > 15552000000L || j3 < 1) {
                    zzicVar.zzaW().zzb().zzc("Invalid conditional user property time to live", zzicVar.zzl().zzc(string), Long.valueOf(j3));
                    return;
                } else {
                    zzicVar.zzaX().zzj(new zzki(this, bundle2));
                    return;
                }
            }
            zzicVar.zzaW().zzb().zzc("Invalid conditional user property value", zzicVar.zzl().zzc(string), obj);
            return;
        }
        zzicVar.zzaW().zzb().zzb("Invalid conditional user property name", zzicVar.zzl().zzc(string));
    }

    public final void zzaa(String str, String str2, Bundle bundle) {
        zzic zzicVar = this.zzu;
        long currentTimeMillis = zzicVar.zzba().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzicVar.zzaX().zzj(new zzkj(this, bundle2));
    }

    public final ArrayList zzab(String str, String str2) {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaX().zze()) {
            zzicVar.zzaV();
            if (zzae.zza()) {
                zzicVar.zzaW().zzb().zza("Cannot get conditional user properties from main thread");
                return new ArrayList(0);
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zzk(atomicReference, 5000L, "get conditional user properties", new zzkk(this, atomicReference, null, str, str2));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaW().zzb().zzb("Timed out waiting for get conditional user properties", null);
                return new ArrayList();
            }
            return zzpp.zzav(list);
        }
        zzicVar.zzaW().zzb().zza("Cannot get conditional user properties from analytics worker thread");
        return new ArrayList(0);
    }

    public final String zzac() {
        zzlu zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zza;
        }
        return null;
    }

    public final String zzad() {
        zzlu zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zzb;
        }
        return null;
    }

    public final String zzae() {
        try {
            return zzlt.zza(this.zzu.zzaZ(), "google_app_id", this.zzu.zzq());
        } catch (IllegalStateException e) {
            this.zzu.zzaW().zzb().zzb("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaf(SharedPreferences sharedPreferences, String str) {
        if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            this.zzu.zzaW().zzk().zza("IABTCF_TCString change picked up in listener.");
            ((zzaz) Preconditions.checkNotNull(this.zzs)).zzb(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzag(Bundle bundle) {
        int i;
        if (!bundle.isEmpty()) {
            zzic zzicVar = this.zzu;
            Bundle bundle2 = new Bundle(zzicVar.zzd().zzt.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    if (zzicVar.zzk().zzz(obj)) {
                        zzicVar.zzk().zzP(this.zzt, null, 27, null, null, 0);
                    }
                    zzicVar.zzaW().zzh().zzc("Invalid default event parameter type. Name, value", next, obj);
                } else if (zzpp.zzac(next)) {
                    zzicVar.zzaW().zzh().zzb("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (zzicVar.zzk().zzA("param", next, zzicVar.zzc().zze(null, false), obj)) {
                    zzicVar.zzk().zzO(bundle2, next, obj);
                }
            }
            zzicVar.zzk();
            int zzc = zzicVar.zzc().zzc();
            if (bundle2.size() > zzc) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i++;
                    if (i > zzc) {
                        bundle2.remove(str);
                    }
                }
                zzicVar.zzk().zzP(this.zzt, null, 26, null, null, 0);
                zzicVar.zzaW().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            bundle = bundle2;
        }
        this.zzu.zzd().zzt.zzb(bundle);
        this.zzu.zzt().zzH(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzah(int i) {
        if (this.zzk == null) {
            this.zzk = new zzjx(this, this.zzu);
        }
        this.zzk.zzb(i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzai(Boolean bool, boolean z) {
        zzaq(bool, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaj(zzjl zzjlVar, long j, boolean z, boolean z2) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        zzjl zzl = zzicVar.zzd().zzl();
        if (j <= this.zzp && zzjl.zzu(zzl.zzb(), zzjlVar.zzb())) {
            zzicVar.zzaW().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjlVar);
            return;
        }
        zzhh zzd = zzicVar.zzd();
        zzic zzicVar2 = zzd.zzu;
        zzd.zzg();
        int zzb = zzjlVar.zzb();
        if (zzd.zzk(zzb)) {
            zzic zzicVar3 = this.zzu;
            SharedPreferences.Editor edit = zzd.zzd().edit();
            edit.putString("consent_settings", zzjlVar.zzl());
            edit.putInt("consent_source", zzb);
            edit.apply();
            zzicVar.zzaW().zzk().zzb("Setting storage consent(FE)", zzjlVar);
            this.zzp = j;
            if (!zzicVar3.zzt().zzP()) {
                zzicVar3.zzt().zzj(z);
            } else {
                zzicVar3.zzt().zzk(z);
            }
            if (z2) {
                zzicVar3.zzt().zzC(new AtomicReference());
                return;
            }
            return;
        }
        zzicVar.zzaW().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjlVar.zzb()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzal(boolean z) {
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzam() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzan(int i) {
        this.zzj = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzaz zzao() {
        return this.zzq;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        zzic zzicVar = this.zzu;
        if (!(zzicVar.zzaZ().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zzicVar.zzaZ().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaX().zzk(atomicReference, 15000L, "boolean test flag value", new zzke(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaX().zzk(atomicReference, 15000L, "String test flag value", new zzko(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaX().zzk(atomicReference, 15000L, "long test flag value", new zzkp(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaX().zzk(atomicReference, 15000L, "int test flag value", new zzkq(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaX().zzk(atomicReference, 15000L, "double test flag value", new zzkr(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzu.zzaX().zzj(new zzks(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzp(Bundle bundle, int i, long j) {
        Object obj;
        String string;
        zzb();
        zzjl zzjlVar = zzjl.zza;
        zzjk[] zzb = zzjj.STORAGE.zzb();
        int length = zzb.length;
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= length) {
                break;
            }
            String str = zzb[i2].zze;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if (string.equals("granted")) {
                    obj = true;
                } else if (string.equals("denied")) {
                    obj = false;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i2++;
        }
        if (obj != null) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzh().zzb("Ignoring invalid consent setting", obj);
            zzicVar.zzaW().zzh().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zze = this.zzu.zzaX().zze();
        zzjl zze2 = zzjl.zze(bundle, i);
        if (zze2.zzc()) {
            zzs(zze2, zze);
        }
        zzba zzh = zzba.zzh(bundle, i);
        if (zzh.zzd()) {
            zzq(zzh, zze);
        }
        Boolean zzi = zzba.zzi(bundle);
        if (zzi != null) {
            String str2 = i == -30 ? "tcf" : "app";
            if (zze) {
                zzM(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzi.toString(), j);
            } else {
                zzK(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzi.toString(), false, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzq(zzba zzbaVar, boolean z) {
        zzkt zzktVar = new zzkt(this, zzbaVar);
        if (!z) {
            this.zzu.zzaX().zzj(zzktVar);
            return;
        }
        zzg();
        zzktVar.run();
    }

    public final void zzs(zzjl zzjlVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        zzjl zzjlVar2;
        zzb();
        int zzb = zzjlVar.zzb();
        if (zzb != -10) {
            zzji zzp = zzjlVar.zzp();
            zzji zzjiVar = zzji.UNINITIALIZED;
            if (zzp == zzjiVar && zzjlVar.zzq() == zzjiVar) {
                this.zzu.zzaW().zzh().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzh) {
            z2 = false;
            if (zzjl.zzu(zzb, this.zzn.zzb())) {
                z3 = zzjlVar.zzr(this.zzn);
                zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                if (zzjlVar.zzo(zzjkVar) && !this.zzn.zzo(zzjkVar)) {
                    z2 = true;
                }
                zzjlVar = zzjlVar.zzt(this.zzn);
                this.zzn = zzjlVar;
                z4 = z2;
                z2 = true;
            } else {
                z3 = false;
                z4 = false;
            }
            zzjlVar2 = zzjlVar;
        }
        if (!z2) {
            this.zzu.zzaW().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjlVar2);
            return;
        }
        long andIncrement = this.zzo.getAndIncrement();
        if (z3) {
            this.zzg.set(null);
            zzku zzkuVar = new zzku(this, zzjlVar2, andIncrement, z4);
            if (!z) {
                this.zzu.zzaX().zzl(zzkuVar);
                return;
            }
            zzg();
            zzkuVar.run();
            return;
        }
        zzkv zzkvVar = new zzkv(this, zzjlVar2, andIncrement, z4);
        if (z) {
            zzg();
            zzkvVar.run();
        } else if (zzb == 30 || zzb == -10) {
            this.zzu.zzaX().zzl(zzkvVar);
        } else {
            this.zzu.zzaX().zzj(zzkvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt(Runnable runnable) {
        zzb();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaX().zze()) {
            if (!zzicVar.zzaX().zzf()) {
                zzicVar.zzaV();
                if (!zzae.zza()) {
                    zzicVar.zzaW().zzk().zza("[sgtm] Started client-side batch upload work.");
                    boolean z = false;
                    int i = 0;
                    int i2 = 0;
                    while (!z) {
                        zzicVar.zzaW().zzk().zza("[sgtm] Getting upload batches from service (FE)");
                        final AtomicReference atomicReference = new AtomicReference();
                        zzicVar.zzaX().zzk(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzli
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzlj.this.zzu.zzt().zzx(atomicReference, zzoo.zza(zzls.SGTM_CLIENT));
                            }
                        });
                        zzoq zzoqVar = (zzoq) atomicReference.get();
                        if (zzoqVar == null) {
                            break;
                        }
                        List list = zzoqVar.zza;
                        if (!list.isEmpty()) {
                            zzicVar.zzaW().zzk().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                            i += list.size();
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                zzlr zzap = zzap((zzom) it.next());
                                if (zzap == zzlr.SUCCESS) {
                                    i2++;
                                } else if (zzap == zzlr.BACKOFF) {
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    zzicVar.zzaW().zzk().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i), Integer.valueOf(i2));
                    runnable.run();
                    return;
                }
                zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from main thread");
                return;
            }
            zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from analytics worker thread");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(long j) {
        zzg();
        if (this.zzl == null) {
            this.zzl = new zzju(this, this.zzu);
        }
        this.zzl.zzb(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv() {
        zzg();
        zzaz zzazVar = this.zzl;
        if (zzazVar != null) {
            zzazVar.zzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw() {
        zzaif.zza();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzc().zzp(null, zzfy.zzaP)) {
            if (!zzicVar.zzaX().zze()) {
                zzicVar.zzaV();
                if (!zzae.zza()) {
                    zzb();
                    zzicVar.zzaW().zzk().zza("Getting trigger URIs (FE)");
                    final AtomicReference atomicReference = new AtomicReference();
                    zzicVar.zzaX().zzk(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzlj zzljVar = zzlj.this;
                            zzljVar.zzu.zzt().zzw(atomicReference, zzljVar.zzu.zzd().zzi.zza());
                        }
                    });
                    final List list = (List) atomicReference.get();
                    if (list == null) {
                        zzicVar.zzaW().zzd().zza("Timed out waiting for get trigger URIs");
                        return;
                    } else {
                        zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlb
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzlj zzljVar = zzlj.this;
                                zzljVar.zzg();
                                if (Build.VERSION.SDK_INT < 30) {
                                    return;
                                }
                                List<zzoh> list2 = list;
                                SparseArray zzf = zzljVar.zzu.zzd().zzf();
                                for (zzoh zzohVar : list2) {
                                    int i = zzohVar.zzc;
                                    if (!zzf.contains(i) || ((Long) zzf.get(i)).longValue() < zzohVar.zzb) {
                                        zzljVar.zzx().add(zzohVar);
                                    }
                                }
                                zzljVar.zzy();
                            }
                        });
                        return;
                    }
                }
                zzicVar.zzaW().zzb().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzicVar.zzaW().zzb().zza("Cannot get trigger URIs from analytics worker thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PriorityQueue zzx() {
        if (this.zzm == null) {
            this.zzm = new PriorityQueue(Comparator.comparing(zzlc.zza, zzld.zza));
        }
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzy() {
        zzoh zzohVar;
        zzg();
        if (zzx().isEmpty() || this.zzi || (zzohVar = (zzoh) zzx().poll()) == null) {
            return;
        }
        zzic zzicVar = this.zzu;
        MeasurementManagerFutures zzV = zzicVar.zzk().zzV();
        if (zzV != null) {
            this.zzi = true;
            zzgs zzk = zzicVar.zzaW().zzk();
            String str = zzohVar.zza;
            zzk.zzb("Registering trigger URI", str);
            ListenableFuture<Unit> registerTriggerAsync = zzV.registerTriggerAsync(Uri.parse(str));
            if (registerTriggerAsync == null) {
                this.zzi = false;
                zzx().add(zzohVar);
                return;
            }
            Futures.addCallback(registerTriggerAsync, new zzjw(this, zzohVar), new zzjv(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzz(zzjl zzjlVar) {
        zzg();
        boolean z = (zzjlVar.zzo(zzjk.ANALYTICS_STORAGE) && zzjlVar.zzo(zzjk.AD_STORAGE)) || this.zzu.zzt().zzO();
        zzic zzicVar = this.zzu;
        if (z != zzicVar.zzE()) {
            zzicVar.zzD(z);
            zzhh zzd = this.zzu.zzd();
            zzic zzicVar2 = zzd.zzu;
            zzd.zzg();
            Boolean valueOf = zzd.zzd().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzd.zzd().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzaq(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzK(String str, String str2, Object obj, boolean z, long j) {
        int i;
        if (!z) {
            zzpp zzk = this.zzu.zzk();
            if (zzk.zzk("user property", str2)) {
                if (zzk.zzm("user property", zzjo.zza, null, str2)) {
                    zzk.zzu.zzc();
                    if (zzk.zzn("user property", 24, str2)) {
                        i = 0;
                    }
                } else {
                    i = 15;
                }
            }
            i = 6;
        } else {
            i = this.zzu.zzk().zzs(str2);
        }
        if (i != 0) {
            zzic zzicVar = this.zzu;
            zzpp zzk2 = zzicVar.zzk();
            zzicVar.zzc();
            this.zzu.zzk().zzP(this.zzt, null, i, "_ev", zzk2.zzE(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        String str3 = str == null ? "app" : str;
        if (obj != null) {
            zzic zzicVar2 = this.zzu;
            int zzM = zzicVar2.zzk().zzM(str2, obj);
            if (zzM == 0) {
                Object zzN = zzicVar2.zzk().zzN(str2, obj);
                if (zzN != null) {
                    zzL(str3, str2, j, zzN);
                    return;
                }
                return;
            }
            zzpp zzk3 = zzicVar2.zzk();
            zzicVar2.zzc();
            String zzE = zzk3.zzE(str2, 24, true);
            if ((obj instanceof String) || (obj instanceof CharSequence)) {
                r3 = obj.toString().length();
            }
            this.zzu.zzk().zzP(this.zzt, null, zzM, "_ev", zzE, r3);
            return;
        }
        zzL(str3, str2, j, null);
    }
}
