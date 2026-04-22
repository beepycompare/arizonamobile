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
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.Renderer;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzqp;
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
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
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
    private zzay zzk;
    private zzay zzl;
    private PriorityQueue zzm;
    private boolean zzn;
    private zzjl zzo;
    private final AtomicLong zzp;
    private long zzq;
    private zzay zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzay zzt;
    private final zzpo zzv;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzlj(zzic zzicVar) {
        super(zzicVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzi = false;
        this.zzj = 1;
        this.zzc = true;
        this.zzv = new zzkn(this);
        this.zzg = new AtomicReference();
        this.zzo = zzjl.zza;
        this.zzq = -1L;
        this.zzp = new AtomicLong(0L);
        this.zzb = new zzx(zzicVar);
    }

    private final zzlr zzar(final zzom zzomVar) {
        try {
            URL url = new URI(zzomVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String zzl = this.zzu.zzv().zzl();
            zzic zzicVar = this.zzu;
            zzgs zzk = zzicVar.zzaV().zzk();
            Long valueOf = Long.valueOf(zzomVar.zza);
            zzk.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, zzomVar.zzc, Integer.valueOf(zzomVar.zzb.length));
            if (!TextUtils.isEmpty(zzomVar.zzg)) {
                zzicVar.zzaV().zzk().zzc("[sgtm] Uploading data from app. row_id", valueOf, zzomVar.zzg);
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
                        zzljVar.zzu.zzaV().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzomVar2.zza), Integer.valueOf(i), th);
                        zzlrVar = !Arrays.asList(((String) zzfy.zzt.zzb(null)).split(StringUtils.COMMA)).contains(String.valueOf(i)) ? zzlr.BACKOFF : zzlr.FAILURE;
                        atomicReference2 = atomicReference;
                        zznl zzt = zzljVar.zzu.zzt();
                        long j = zzomVar2.zza;
                        zzt.zzy(new zzaf(j, zzlrVar.zza(), zzomVar2.zzf));
                        zzljVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j), zzlrVar);
                        synchronized (atomicReference2) {
                            atomicReference2.set(zzlrVar);
                            atomicReference2.notifyAll();
                        }
                        return;
                    }
                    if (th == null) {
                        zzljVar.zzu.zzaV().zzk().zzb("[sgtm] Upload succeeded for row_id", Long.valueOf(zzomVar2.zza));
                        zzlrVar = zzlr.SUCCESS;
                        atomicReference2 = atomicReference;
                        zznl zzt2 = zzljVar.zzu.zzt();
                        long j2 = zzomVar2.zza;
                        zzt2.zzy(new zzaf(j2, zzlrVar.zza(), zzomVar2.zzf));
                        zzljVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j2), zzlrVar);
                        synchronized (atomicReference2) {
                        }
                    }
                    zzljVar.zzu.zzaV().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzomVar2.zza), Integer.valueOf(i), th);
                    if (!Arrays.asList(((String) zzfy.zzt.zzb(null)).split(StringUtils.COMMA)).contains(String.valueOf(i))) {
                    }
                    atomicReference2 = atomicReference;
                    zznl zzt22 = zzljVar.zzu.zzt();
                    long j22 = zzomVar2.zza;
                    zzt22.zzy(new zzaf(j22, zzlrVar.zza(), zzomVar2.zzf));
                    zzljVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j22), zzlrVar);
                    synchronized (atomicReference2) {
                    }
                }
            };
            zzn.zzw();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzllVar);
            zzn.zzu.zzaW().zzm(new zzln(zzn, zzl, url, bArr, hashMap, zzllVar));
            try {
                zzic zzicVar2 = zzicVar.zzk().zzu;
                long currentTimeMillis = zzicVar2.zzaZ().currentTimeMillis() + 60000;
                synchronized (atomicReference) {
                    for (long j = 60000; atomicReference.get() == null && j > 0; j = currentTimeMillis - zzicVar2.zzaZ().currentTimeMillis()) {
                        atomicReference.wait(j);
                    }
                }
            } catch (InterruptedException unused) {
                this.zzu.zzaV().zze().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? zzlr.UNKNOWN : (zzlr) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e) {
            this.zzu.zzaV().zzb().zzd("[sgtm] Bad upload url for row_id", zzomVar.zzc, Long.valueOf(zzomVar.zza), e);
            return zzlr.FAILURE;
        }
    }

    private final void zzas(Boolean bool, boolean z) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        zzicVar.zzaV().zzj().zzb("Setting app measurement enabled (FE)", bool);
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
            zzal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzat */
    public final void zzal() {
        zzlj zzljVar;
        zzg();
        zzic zzicVar = this.zzu;
        String zza = zzicVar.zzd().zzh.zza();
        if (zza == null) {
            zzljVar = this;
        } else if ("unset".equals(zza)) {
            zzljVar = this;
            zzljVar.zzN("app", "_npa", null, zzicVar.zzaZ().currentTimeMillis());
        } else {
            zzljVar = this;
            zzljVar.zzN("app", "_npa", Long.valueOf(true != "true".equals(zza) ? 0L : 1L), zzicVar.zzaZ().currentTimeMillis());
        }
        if (!zzljVar.zzu.zzB() || !zzljVar.zzc) {
            zzicVar.zzaV().zzj().zza("Updating Scion state (FE)");
            zzljVar.zzu.zzt().zzi();
            return;
        }
        zzicVar.zzaV().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzljVar.zzU();
        zzljVar.zzu.zzh().zza.zza();
        zzicVar.zzaW().zzj(new zzjz(zzljVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzA(zzjl zzjlVar) {
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
                zzas(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzB(String str, String str2, Bundle bundle) {
        zzC(str, str2, bundle, true, true, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzC(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.zzu.zzs().zzj(bundle2, j);
            return;
        }
        boolean z3 = true;
        if (z2 && this.zzd != null && !zzpp.zzZ(str2)) {
            z3 = false;
        }
        boolean z4 = z3;
        if (str == null) {
            str = "app";
        }
        zzJ(str, str2, j, bundle2, z2, z4, z, null);
    }

    public final void zzD() {
        zzod zzodVar;
        zzod zzodVar2;
        com.google.android.gms.internal.measurement.zzkq zzkqVar;
        zzg();
        zzic zzicVar = this.zzu;
        zzicVar.zzaV().zzj().zza("Handle tcf update.");
        SharedPreferences zze = zzicVar.zzd().zze();
        HashMap hashMap = new HashMap();
        zzfx zzfxVar = zzfy.zzaZ;
        if (((Boolean) zzfxVar.zzb(null)).booleanValue()) {
            int i = zzof.zzb;
            com.google.android.gms.internal.measurement.zzkp zzkpVar = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            int i2 = 2;
            zzoe zzoeVar = zzoe.CONSENT;
            com.google.android.gms.internal.measurement.zzkp zzkpVar2 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            int i3 = 1;
            zzoe zzoeVar2 = zzoe.FLEXIBLE_LEGITIMATE_INTEREST;
            ImmutableMap ofEntries = ImmutableMap.ofEntries(UByte$$ExternalSyntheticBackport0.m(zzkpVar, zzoeVar), UByte$$ExternalSyntheticBackport0.m(zzkpVar2, zzoeVar2), UByte$$ExternalSyntheticBackport0.m(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, zzoeVar), UByte$$ExternalSyntheticBackport0.m(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, zzoeVar), UByte$$ExternalSyntheticBackport0.m(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, zzoeVar2), UByte$$ExternalSyntheticBackport0.m(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, zzoeVar2), UByte$$ExternalSyntheticBackport0.m(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, zzoeVar2));
            ImmutableSet of = ImmutableSet.of("CH");
            char[] cArr = new char[5];
            boolean contains = zze.contains("IABTCF_TCString");
            int zzb = zzof.zzb(zze, "IABTCF_CmpSdkID");
            int zzb2 = zzof.zzb(zze, "IABTCF_PolicyVersion");
            int zzb3 = zzof.zzb(zze, "IABTCF_gdprApplies");
            int zzb4 = zzof.zzb(zze, "IABTCF_PurposeOneTreatment");
            int zzb5 = zzof.zzb(zze, "IABTCF_EnableAdvertiserConsentMode");
            String zza = zzof.zza(zze, "IABTCF_PublisherCC");
            ImmutableMap.Builder builder = ImmutableMap.builder();
            UnmodifiableIterator it = ofEntries.keySet().iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzkp zzkpVar3 = (com.google.android.gms.internal.measurement.zzkp) it.next();
                int zza2 = zzkpVar3.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(zza2);
                String zza3 = zzof.zza(zze, sb.toString());
                if (TextUtils.isEmpty(zza3) || zza3.length() < 755) {
                    zzkqVar = com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED;
                } else {
                    int digit = Character.digit(zza3.charAt(754), 10);
                    zzkqVar = (digit < 0 || digit > com.google.android.gms.internal.measurement.zzkq.values().length || digit == 0) ? com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_NOT_ALLOWED : digit != i3 ? digit != i2 ? com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                }
                builder.put(zzkpVar3, zzkqVar);
                i2 = 2;
                i3 = 1;
            }
            ImmutableMap buildOrThrow = builder.buildOrThrow();
            String zza4 = zzof.zza(zze, "IABTCF_PurposeConsents");
            String zza5 = zzof.zza(zze, "IABTCF_VendorConsents");
            boolean z = !TextUtils.isEmpty(zza5) && zza5.length() >= 755 && zza5.charAt(754) == '1';
            String zza6 = zzof.zza(zze, "IABTCF_PurposeLegitimateInterests");
            String zza7 = zzof.zza(zze, "IABTCF_VendorLegitimateInterests");
            boolean z2 = !TextUtils.isEmpty(zza7) && zza7.length() >= 755 && zza7.charAt(754) == '1';
            cArr[0] = '2';
            zzodVar = new zzod(zzof.zzd(ofEntries, buildOrThrow, of, cArr, zzb, zzb5, zzb3, zzb2, zzb4, zza, zza4, zza6, z, z2, contains));
        } else {
            String zza8 = zzof.zza(zze, "IABTCF_VendorConsents");
            if (!"".equals(zza8) && zza8.length() > 754) {
                hashMap.put("GoogleConsent", String.valueOf(zza8.charAt(754)));
            }
            int zzb6 = zzof.zzb(zze, "IABTCF_gdprApplies");
            if (zzb6 != -1) {
                hashMap.put("gdprApplies", String.valueOf(zzb6));
            }
            int zzb7 = zzof.zzb(zze, "IABTCF_EnableAdvertiserConsentMode");
            if (zzb7 != -1) {
                hashMap.put("EnableAdvertiserConsentMode", String.valueOf(zzb7));
            }
            int zzb8 = zzof.zzb(zze, "IABTCF_PolicyVersion");
            if (zzb8 != -1) {
                hashMap.put("PolicyVersion", String.valueOf(zzb8));
            }
            String zza9 = zzof.zza(zze, "IABTCF_PurposeConsents");
            if (!"".equals(zza9)) {
                hashMap.put("PurposeConsents", zza9);
            }
            int zzb9 = zzof.zzb(zze, "IABTCF_CmpSdkID");
            if (zzb9 != -1) {
                hashMap.put("CmpSdkID", String.valueOf(zzb9));
            }
            zzodVar = new zzod(hashMap);
        }
        zzicVar.zzaV().zzk().zzb("Tcf preferences read", zzodVar);
        if (!zzicVar.zzc().zzp(null, zzfxVar)) {
            if (zzicVar.zzd().zzm(zzodVar)) {
                Bundle zzb10 = zzodVar.zzb();
                zzicVar.zzaV().zzk().zzb("Consent generated from Tcf", zzb10);
                if (zzb10 != Bundle.EMPTY) {
                    zzp(zzb10, -30, zzicVar.zzaZ().currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", zzodVar.zze());
                zzF("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        zzhh zzd = zzicVar.zzd();
        zzd.zzg();
        String string = zzd.zzd().getString("stored_tcf_param", "");
        HashMap hashMap2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            zzodVar2 = new zzod(hashMap2);
        } else {
            for (String str : string.split(";")) {
                String[] split = str.split("=");
                if (split.length >= 2 && zzof.zza.contains(split[0])) {
                    hashMap2.put(split[0], split[1]);
                }
            }
            zzodVar2 = new zzod(hashMap2);
        }
        if (zzicVar.zzd().zzm(zzodVar)) {
            Bundle zzb11 = zzodVar.zzb();
            zzicVar.zzaV().zzk().zzb("Consent generated from Tcf", zzb11);
            if (zzb11 != Bundle.EMPTY) {
                zzp(zzb11, -30, zzicVar.zzaZ().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfm", zzodVar.zzd(zzodVar2));
            bundle2.putString("_tcfd2", zzodVar.zzc());
            bundle2.putString("_tcfd", zzodVar.zze());
            zzF("auto", "_tcf", bundle2);
        }
    }

    public final void zzE() {
        zzg();
        zzic zzicVar = this.zzu;
        zzicVar.zzaV().zzj().zza("Register tcfPrefChangeListener.");
        if (this.zzs == null) {
            this.zzt = new zzkb(this, this.zzu);
            this.zzs = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzle
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzlj.this.zzag(sharedPreferences, str);
                }
            };
        }
        zzicVar.zzd().zze().registerOnSharedPreferenceChangeListener(this.zzs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(String str, String str2, Bundle bundle) {
        zzg();
        zzG(str, str2, this.zzu.zzaZ().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG(String str, String str2, long j, Bundle bundle) {
        zzg();
        boolean z = true;
        if (this.zzd != null && !zzpp.zzZ(str2)) {
            z = false;
        }
        zzH(str, str2, j, bundle, true, z, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzH(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean z4;
        int i;
        long j2;
        boolean zza;
        ArrayList arrayList;
        long j3;
        long j4;
        String str4;
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
        zzic zzicVar = this.zzu;
        if (zzicVar.zzB()) {
            List zzp = this.zzu.zzv().zzp();
            if (zzp == null || zzp.contains(str2)) {
                if (!this.zzf) {
                    this.zzf = true;
                    try {
                        if (zzicVar.zzp()) {
                            cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                        } else {
                            cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzu.zzaY().getClassLoader());
                        }
                        try {
                            cls.getDeclaredMethod("initialize", Context.class).invoke(null, this.zzu.zzaY());
                        } catch (Exception e) {
                            this.zzu.zzaV().zze().zzb("Failed to invoke Tag Manager's initialize() method", e);
                        }
                    } catch (ClassNotFoundException unused) {
                        this.zzu.zzaV().zzi().zza("Tag Manager is not found and thus will not be used");
                    }
                }
                zzic zzicVar2 = this.zzu;
                if (!zzicVar2.zzc().zzp(null, zzfy.zzbf) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
                    zzicVar2.zzaU();
                    zzN("auto", "_lgclid", bundle.getString("gclid"), zzicVar2.zzaZ().currentTimeMillis());
                }
                zzlj zzljVar = this;
                zzicVar2.zzaU();
                if (z && zzpp.zzaf(str2)) {
                    zzicVar2.zzk().zzI(bundle, zzicVar2.zzd().zzt.zza());
                }
                if (!z3) {
                    zzicVar2.zzaU();
                    if (!"_iap".equals(str2)) {
                        zzic zzicVar3 = zzljVar.zzu;
                        zzpp zzk = zzicVar3.zzk();
                        if (zzk.zzj(NotificationCompat.CATEGORY_EVENT, str2)) {
                            if (zzk.zzl(NotificationCompat.CATEGORY_EVENT, zzjm.zza, zzjm.zzb, str2)) {
                                zzk.zzu.zzc();
                                if (zzk.zzm(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                                    i4 = 0;
                                }
                            } else {
                                i4 = 13;
                            }
                            if (i4 != 0) {
                                zzicVar2.zzaV().zzd().zzb("Invalid public event name. Event will not be logged (FE)", zzicVar2.zzl().zza(str2));
                                zzpp zzk2 = zzicVar3.zzk();
                                zzicVar3.zzc();
                                zzicVar3.zzk().zzN(zzljVar.zzv, null, i4, "_ev", zzk2.zzC(str2, 40, true), str2 != null ? str2.length() : 0);
                                return;
                            }
                        }
                        i4 = 2;
                        if (i4 != 0) {
                        }
                    }
                }
                zzicVar2.zzaU();
                zzic zzicVar4 = zzljVar.zzu;
                zzlu zzh = zzicVar4.zzs().zzh(false);
                if (zzh != null && !bundle.containsKey("_sc")) {
                    zzh.zzd = true;
                }
                zzpp.zzav(zzh, bundle, z && !z3);
                boolean equals = "am".equals(str5);
                boolean zzZ = zzpp.zzZ(str2);
                if (!z || zzljVar.zzd == null || zzZ) {
                    z4 = equals;
                } else if (!equals) {
                    zzicVar2.zzaV().zzj().zzc("Passing event to registered event handler (FE)", zzicVar2.zzl().zza(str2), zzicVar2.zzl().zze(bundle));
                    Preconditions.checkNotNull(zzljVar.zzd);
                    zzljVar.zzd.interceptEvent(str5, str2, bundle, j);
                    return;
                } else {
                    z4 = true;
                }
                zzic zzicVar5 = zzljVar.zzu;
                if (zzicVar5.zzH()) {
                    int zzn = zzicVar2.zzk().zzn(str2);
                    if (zzn != 0) {
                        zzicVar2.zzaV().zzd().zzb("Invalid event name. Event will not be logged (FE)", zzicVar2.zzl().zza(str2));
                        zzpp zzk3 = zzicVar2.zzk();
                        zzicVar2.zzc();
                        zzicVar5.zzk().zzN(zzljVar.zzv, str3, zzn, "_ev", zzk3.zzC(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                    Bundle zzF = zzicVar2.zzk().zzF(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
                    Preconditions.checkNotNull(zzF);
                    zzicVar2.zzaU();
                    if (zzicVar4.zzs().zzh(false) == null || !"_ae".equals(str2)) {
                        i = 0;
                        j2 = 0;
                    } else {
                        zzoa zzoaVar = zzicVar4.zzh().zzb;
                        j2 = 0;
                        long elapsedRealtime = zzoaVar.zzc.zzu.zzaZ().elapsedRealtime();
                        i = 0;
                        long j5 = elapsedRealtime - zzoaVar.zzb;
                        zzoaVar.zzb = elapsedRealtime;
                        if (j5 > 0) {
                            zzicVar2.zzk().zzak(zzF, j5);
                        }
                    }
                    if ("auto".equals(str5) || !"_ssr".equals(str2)) {
                        if ("_ae".equals(str2)) {
                            String zza2 = zzicVar2.zzk().zzu.zzd().zzq.zza();
                            if (!TextUtils.isEmpty(zza2)) {
                                zzF.putString("_ffr", zza2);
                            }
                        }
                    } else {
                        zzpp zzk4 = zzicVar2.zzk();
                        String string = zzF.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            string = null;
                        } else if (string != null) {
                            string = string.trim();
                        }
                        zzic zzicVar6 = zzk4.zzu;
                        if (!Objects.equals(string, zzicVar6.zzd().zzq.zza())) {
                            zzicVar6.zzd().zzq.zzb(string);
                        } else {
                            zzicVar6.zzaV().zzj().zza("Not logging duplicate session_start_with_rollout event");
                            return;
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(zzF);
                    if (!zzicVar2.zzc().zzp(null, zzfy.zzaU)) {
                        zza = zzicVar2.zzd().zzn.zza();
                    } else {
                        zza = zzicVar4.zzh().zzi();
                    }
                    if (zzicVar2.zzd().zzk.zza() > j2) {
                        j4 = j;
                        if (zzicVar2.zzd().zzp(j4) && zza) {
                            zzicVar2.zzaV().zzk().zza("Current session is expired, remove the session number, ID, and engagement time");
                            long j6 = j2;
                            arrayList = arrayList2;
                            j3 = j6;
                            str4 = "_ae";
                            zzN("auto", "_sid", null, zzicVar2.zzaZ().currentTimeMillis());
                            zzN("auto", "_sno", null, zzicVar2.zzaZ().currentTimeMillis());
                            zzN("auto", "_se", null, zzicVar2.zzaZ().currentTimeMillis());
                            zzljVar = this;
                            zzicVar2.zzd().zzl.zzb(j3);
                            if (zzF.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j3) == 1) {
                                zzicVar2.zzaV().zzk().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                                zzicVar5.zzh().zza.zzb(j4, true);
                            }
                            ArrayList arrayList3 = new ArrayList(zzF.keySet());
                            Collections.sort(arrayList3);
                            size = arrayList3.size();
                            for (i2 = i; i2 < size; i2++) {
                                String str6 = (String) arrayList3.get(i2);
                                if (str6 != null) {
                                    zzicVar2.zzk();
                                    Object obj = zzF.get(str6);
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
                                        zzF.putParcelableArray(str6, bundleArr);
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
                                    bundle2 = zzicVar2.zzk().zzab(bundle2, null);
                                }
                                String str8 = str5;
                                Bundle bundle3 = bundle2;
                                zzicVar4.zzt().zzn(new zzbg(str7, new zzbe(bundle2), str8, j4), str3);
                                if (!z4) {
                                    for (zzjq zzjqVar : zzljVar.zze) {
                                        zzjqVar.onEvent(str, str2, new Bundle(bundle3), j);
                                    }
                                }
                                i3++;
                                str5 = str;
                                j4 = j;
                                arrayList = arrayList5;
                            }
                            zzicVar2.zzaU();
                            if (zzicVar4.zzs().zzh(i) == null && str4.equals(str2)) {
                                zzicVar4.zzh().zzb.zzd(true, true, zzicVar2.zzaZ().elapsedRealtime());
                                return;
                            }
                            return;
                        }
                        long j7 = j2;
                        arrayList = arrayList2;
                        j3 = j7;
                    } else {
                        long j8 = j2;
                        arrayList = arrayList2;
                        j3 = j8;
                        j4 = j;
                    }
                    str4 = "_ae";
                    if (zzF.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j3) == 1) {
                    }
                    ArrayList arrayList32 = new ArrayList(zzF.keySet());
                    Collections.sort(arrayList32);
                    size = arrayList32.size();
                    while (i2 < size) {
                    }
                    i3 = i;
                    while (i3 < arrayList.size()) {
                    }
                    zzicVar2.zzaU();
                    if (zzicVar4.zzs().zzh(i) == null) {
                        return;
                    }
                    return;
                }
                return;
            }
            this.zzu.zzaV().zzj().zzc("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        this.zzu.zzaV().zzj().zza("Event not sent since app measurement is disabled");
    }

    public final void zzI(String str, String str2, Bundle bundle, String str3) {
        zzic.zzL();
        zzJ("auto", str2, this.zzu.zzaZ().currentTimeMillis(), bundle, false, true, true, str3);
    }

    protected final void zzJ(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
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
        this.zzu.zzaW().zzj(new zzkc(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void zzK(String str, String str2, Object obj, boolean z) {
        zzL("auto", "_ldl", obj, true, this.zzu.zzaZ().currentTimeMillis());
    }

    final void zzM(String str, String str2, long j, Object obj) {
        this.zzu.zzaW().zzj(new zzkd(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzN(String str, String str2, Object obj, long j) {
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
                    this.zzu.zzaV().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                this.zzu.zzd().zzh.zzb("unset");
                str2 = "_npa";
            }
            this.zzu.zzaV().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str4 = str2;
        Object obj2 = obj;
        zzic zzicVar2 = this.zzu;
        if (!zzicVar2.zzB()) {
            this.zzu.zzaV().zzk().zza("User property not set since app measurement is disabled");
        } else if (zzicVar2.zzH()) {
            this.zzu.zzt().zzA(new zzpl(str4, j, obj2, str));
        }
    }

    public final List zzO(boolean z) {
        zzb();
        zzic zzicVar = this.zzu;
        zzicVar.zzaV().zzk().zza("Getting user properties (FE)");
        if (!zzicVar.zzaW().zze()) {
            zzicVar.zzaU();
            if (zzae.zza()) {
                zzicVar.zzaV().zzb().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference, 5000L, "get user properties", new zzkf(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaV().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyList();
            }
            return list;
        }
        zzicVar.zzaV().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzP(String str, String str2, boolean z) {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaW().zze()) {
            zzicVar.zzaU();
            if (zzae.zza()) {
                zzicVar.zzaV().zzb().zza("Cannot get user properties from main thread");
                return Collections.emptyMap();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference, 5000L, "get user properties", new zzkl(this, atomicReference, null, str, str2, z));
            List<zzpl> list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaV().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
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
        zzicVar.zzaV().zzb().zza("Cannot get user properties from analytics worker thread");
        return Collections.emptyMap();
    }

    public final String zzQ() {
        return (String) this.zzg.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzR(String str) {
        this.zzg.set(str);
    }

    public final void zzS() {
        zzg();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzd().zzo.zza()) {
            long zza = zzicVar.zzd().zzp.zza();
            zzicVar.zzd().zzp.zzb(1 + zza);
            zzicVar.zzc();
            if (zza >= 5) {
                zzicVar.zzaV().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzicVar.zzd().zzo.zzb(true);
                return;
            }
            if (this.zzr == null) {
                this.zzr = new zzkg(this, this.zzu);
            }
            this.zzr.zzb(0L);
            return;
        }
        zzicVar.zzaV().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }

    public final void zzT(long j) {
        this.zzg.set(null);
        this.zzu.zzaW().zzj(new zzkh(this, j));
    }

    public final void zzU() {
        zzg();
        zzb();
        if (this.zzu.zzH()) {
            zzic zzicVar = this.zzu;
            zzal zzc = zzicVar.zzc();
            zzc.zzu.zzaU();
            Boolean zzr = zzc.zzr("google_analytics_deferred_deep_link_enabled");
            if (zzr != null && zzr.booleanValue()) {
                zzicVar.zzaV().zzj().zza("Deferred Deep Link feature enabled.");
                zzicVar.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzlj.this.zzS();
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
            zzF("auto", "_ou", bundle);
        }
    }

    public final void zzV(zzjp zzjpVar) {
        zzjp zzjpVar2;
        zzg();
        zzb();
        if (zzjpVar != null && zzjpVar != (zzjpVar2 = this.zzd)) {
            Preconditions.checkState(zzjpVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzjpVar;
    }

    public final void zzW(zzjq zzjqVar) {
        zzb();
        Preconditions.checkNotNull(zzjqVar);
        if (this.zze.add(zzjqVar)) {
            return;
        }
        this.zzu.zzaV().zze().zza("OnEventListener already registered");
    }

    public final void zzX(zzjq zzjqVar) {
        zzb();
        Preconditions.checkNotNull(zzjqVar);
        if (this.zze.remove(zzjqVar)) {
            return;
        }
        this.zzu.zzaV().zze().zza("OnEventListener had not been registered");
    }

    public final int zzY(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzu.zzc();
        return 25;
    }

    public final void zzZ(Bundle bundle) {
        zzaa(bundle, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzaa(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzu.zzaV().zze().zza("Package name should be null when calling setConditionalUserProperty");
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
        if (zzicVar.zzk().zzp(string) == 0) {
            if (zzicVar.zzk().zzK(string, obj) == 0) {
                Object zzL = zzicVar.zzk().zzL(string, obj);
                if (zzL == null) {
                    zzicVar.zzaV().zzb().zzc("Unable to normalize conditional user property value", zzicVar.zzl().zzc(string), obj);
                    return;
                }
                zzjh.zza(bundle2, zzL);
                long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    zzicVar.zzc();
                    if (j2 > 15552000000L || j2 < 1) {
                        zzicVar.zzaV().zzb().zzc("Invalid conditional user property timeout", zzicVar.zzl().zzc(string), Long.valueOf(j2));
                        return;
                    }
                }
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                zzicVar.zzc();
                if (j3 > 15552000000L || j3 < 1) {
                    zzicVar.zzaV().zzb().zzc("Invalid conditional user property time to live", zzicVar.zzl().zzc(string), Long.valueOf(j3));
                    return;
                } else {
                    zzicVar.zzaW().zzj(new zzki(this, bundle2));
                    return;
                }
            }
            zzicVar.zzaV().zzb().zzc("Invalid conditional user property value", zzicVar.zzl().zzc(string), obj);
            return;
        }
        zzicVar.zzaV().zzb().zzb("Invalid conditional user property name", zzicVar.zzl().zzc(string));
    }

    public final void zzab(String str, String str2, Bundle bundle) {
        zzic zzicVar = this.zzu;
        long currentTimeMillis = zzicVar.zzaZ().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzicVar.zzaW().zzj(new zzkj(this, bundle2));
    }

    public final ArrayList zzac(String str, String str2) {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaW().zze()) {
            zzicVar.zzaU();
            if (zzae.zza()) {
                zzicVar.zzaV().zzb().zza("Cannot get conditional user properties from main thread");
                return new ArrayList(0);
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference, 5000L, "get conditional user properties", new zzkk(this, atomicReference, null, str, str2));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaV().zzb().zzb("Timed out waiting for get conditional user properties", null);
                return new ArrayList();
            }
            return zzpp.zzas(list);
        }
        zzicVar.zzaV().zzb().zza("Cannot get conditional user properties from analytics worker thread");
        return new ArrayList(0);
    }

    public final String zzad() {
        zzlu zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zza;
        }
        return null;
    }

    public final String zzae() {
        zzlu zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zzb;
        }
        return null;
    }

    public final String zzaf() {
        try {
            return zzlt.zza(this.zzu.zzaY(), "google_app_id", this.zzu.zzq());
        } catch (IllegalStateException e) {
            this.zzu.zzaV().zzb().zzb("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzag(SharedPreferences sharedPreferences, String str) {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzc().zzp(null, zzfy.zzaZ)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                zzicVar.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
                ((zzay) Preconditions.checkNotNull(this.zzt)).zzb(500L);
            }
        } else if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            zzicVar.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
            ((zzay) Preconditions.checkNotNull(this.zzt)).zzb(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzah(Bundle bundle) {
        Bundle bundle2;
        int i;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            zzic zzicVar = this.zzu;
            bundle2 = new Bundle(zzicVar.zzd().zzt.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj == null || (obj instanceof String) || (obj instanceof Long) || (obj instanceof Double)) {
                    if (zzpp.zzZ(next)) {
                        zzicVar.zzaV().zzh().zzb("Invalid default event parameter name. Name", next);
                    } else if (obj == null) {
                        bundle2.remove(next);
                    } else if (zzicVar.zzk().zzu("param", next, zzicVar.zzc().zze(null, false), obj)) {
                        zzicVar.zzk().zzM(bundle2, next, obj);
                    }
                } else {
                    if (zzicVar.zzk().zzt(obj)) {
                        zzicVar.zzk().zzN(this.zzv, null, 27, null, null, 0);
                    }
                    zzicVar.zzaV().zzh().zzc("Invalid default event parameter type. Name, value", next, obj);
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
                zzicVar.zzk().zzN(this.zzv, null, 26, null, null, 0);
                zzicVar.zzaV().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzic zzicVar2 = this.zzu;
        zzicVar2.zzd().zzt.zzb(bundle2);
        if (!bundle.isEmpty() || zzicVar2.zzc().zzp(null, zzfy.zzaW)) {
            this.zzu.zzt().zzH(bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzai(int i) {
        if (this.zzk == null) {
            this.zzk = new zzjx(this, this.zzu);
        }
        this.zzk.zzb(i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaj(Boolean bool, boolean z) {
        zzas(bool, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzak(zzjl zzjlVar, long j, boolean z, boolean z2) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        zzjl zzl = zzicVar.zzd().zzl();
        if (j > this.zzq || !zzjl.zzu(zzl.zzb(), zzjlVar.zzb())) {
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
                zzicVar.zzaV().zzk().zzb("Setting storage consent(FE)", zzjlVar);
                this.zzq = j;
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
            zzicVar.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjlVar.zzb()));
            return;
        }
        zzicVar.zzaV().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzam(boolean z) {
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzan() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzao(int i) {
        this.zzj = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzay zzap() {
        return this.zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzaq(Throwable th) {
        String message = th.getMessage();
        this.zzn = false;
        if (message == null) {
            return 2;
        }
        if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        } else if (message.contains("Background")) {
            this.zzn = true;
            return 1;
        } else {
            return 1;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        zzic zzicVar = this.zzu;
        if (!(zzicVar.zzaY().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zzicVar.zzaY().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaW().zzk(atomicReference, 15000L, "boolean test flag value", new zzke(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaW().zzk(atomicReference, 15000L, "String test flag value", new zzko(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaW().zzk(atomicReference, 15000L, "long test flag value", new zzkp(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaW().zzk(atomicReference, 15000L, "int test flag value", new zzkq(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaW().zzk(atomicReference, 15000L, "double test flag value", new zzkr(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzu.zzaW().zzj(new zzks(this, bool));
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
            zzicVar.zzaV().zzh().zzb("Ignoring invalid consent setting", obj);
            zzicVar.zzaV().zzh().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zze = this.zzu.zzaW().zze();
        zzjl zze2 = zzjl.zze(bundle, i);
        if (zze2.zzc()) {
            zzs(zze2, zze);
        }
        zzaz zzh = zzaz.zzh(bundle, i);
        if (zzh.zzd()) {
            zzq(zzh, zze);
        }
        Boolean zzi = zzaz.zzi(bundle);
        if (zzi != null) {
            String str2 = i == -30 ? "tcf" : "app";
            if (zze) {
                zzN(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzi.toString(), j);
            } else {
                zzL(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzi.toString(), false, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzq(zzaz zzazVar, boolean z) {
        zzkt zzktVar = new zzkt(this, zzazVar);
        if (!z) {
            this.zzu.zzaW().zzj(zzktVar);
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
                this.zzu.zzaV().zzh().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzh) {
            z2 = false;
            if (zzjl.zzu(zzb, this.zzo.zzb())) {
                z3 = zzjlVar.zzr(this.zzo);
                zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                if (zzjlVar.zzo(zzjkVar) && !this.zzo.zzo(zzjkVar)) {
                    z2 = true;
                }
                zzjlVar = zzjlVar.zzt(this.zzo);
                this.zzo = zzjlVar;
                z4 = z2;
                z2 = true;
            } else {
                z3 = false;
                z4 = false;
            }
            zzjlVar2 = zzjlVar;
        }
        if (!z2) {
            this.zzu.zzaV().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjlVar2);
            return;
        }
        long andIncrement = this.zzp.getAndIncrement();
        if (z3) {
            this.zzg.set(null);
            zzku zzkuVar = new zzku(this, zzjlVar2, andIncrement, z4);
            if (!z) {
                this.zzu.zzaW().zzl(zzkuVar);
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
            this.zzu.zzaW().zzl(zzkvVar);
        } else {
            this.zzu.zzaW().zzj(zzkvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt(Runnable runnable) {
        zzb();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaW().zze()) {
            if (!zzicVar.zzaW().zzf()) {
                zzicVar.zzaU();
                if (!zzae.zza()) {
                    zzicVar.zzaV().zzk().zza("[sgtm] Started client-side batch upload work.");
                    boolean z = false;
                    int i = 0;
                    int i2 = 0;
                    while (!z) {
                        zzicVar.zzaV().zzk().zza("[sgtm] Getting upload batches from service (FE)");
                        final AtomicReference atomicReference = new AtomicReference();
                        zzicVar.zzaW().zzk(atomicReference, Renderer.DEFAULT_DURATION_TO_PROGRESS_US, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzli
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
                            zzicVar.zzaV().zzk().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                            i += list.size();
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                zzlr zzar = zzar((zzom) it.next());
                                if (zzar == zzlr.SUCCESS) {
                                    i2++;
                                } else if (zzar == zzlr.BACKOFF) {
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    zzicVar.zzaV().zzk().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i), Integer.valueOf(i2));
                    runnable.run();
                    return;
                }
                zzicVar.zzaV().zzb().zza("Cannot retrieve and upload batches from main thread");
                return;
            }
            zzicVar.zzaV().zzb().zza("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        zzicVar.zzaV().zzb().zza("Cannot retrieve and upload batches from analytics worker thread");
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
        zzay zzayVar = this.zzl;
        if (zzayVar != null) {
            zzayVar.zzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw() {
        zzqp.zza();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzc().zzp(null, zzfy.zzaQ)) {
            if (!zzicVar.zzaW().zze()) {
                zzicVar.zzaU();
                if (!zzae.zza()) {
                    zzb();
                    zzicVar.zzaV().zzk().zza("Getting trigger URIs (FE)");
                    final AtomicReference atomicReference = new AtomicReference();
                    zzicVar.zzaW().zzk(atomicReference, Renderer.DEFAULT_DURATION_TO_PROGRESS_US, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzlj zzljVar = zzlj.this;
                            zzljVar.zzu.zzt().zzw(atomicReference, zzljVar.zzu.zzd().zzi.zza());
                        }
                    });
                    final List list = (List) atomicReference.get();
                    if (list == null) {
                        zzicVar.zzaV().zzd().zza("Timed out waiting for get trigger URIs");
                        return;
                    } else {
                        zzicVar.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlb
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
                                        zzljVar.zzy().add(zzohVar);
                                    }
                                }
                                zzljVar.zzz();
                            }
                        });
                        return;
                    }
                }
                zzicVar.zzaV().zzb().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzicVar.zzaV().zzb().zza("Cannot get trigger URIs from analytics worker thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PriorityQueue zzy() {
        if (this.zzm == null) {
            this.zzm = new PriorityQueue(Comparator.comparing(zzlc.zza, zzld.zza));
        }
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzz() {
        zzoh zzohVar;
        zzg();
        this.zzn = false;
        if (zzy().isEmpty() || this.zzi || (zzohVar = (zzoh) zzy().poll()) == null) {
            return;
        }
        zzic zzicVar = this.zzu;
        MeasurementManagerFutures zzT = zzicVar.zzk().zzT();
        if (zzT != null) {
            this.zzi = true;
            zzgs zzk = zzicVar.zzaV().zzk();
            String str = zzohVar.zza;
            zzk.zzb("Registering trigger URI", str);
            ListenableFuture<Unit> registerTriggerAsync = zzT.registerTriggerAsync(Uri.parse(str));
            if (registerTriggerAsync == null) {
                this.zzi = false;
                zzy().add(zzohVar);
                return;
            }
            Futures.addCallback(registerTriggerAsync, new zzjw(this, zzohVar), new zzjv(this));
        }
    }

    public final void zzL(String str, String str2, Object obj, boolean z, long j) {
        int i;
        if (!z) {
            zzpp zzk = this.zzu.zzk();
            if (zzk.zzj("user property", str2)) {
                if (zzk.zzl("user property", zzjo.zza, null, str2)) {
                    zzk.zzu.zzc();
                    if (zzk.zzm("user property", 24, str2)) {
                        i = 0;
                    }
                } else {
                    i = 15;
                }
            }
            i = 6;
        } else {
            i = this.zzu.zzk().zzp(str2);
        }
        if (i != 0) {
            zzic zzicVar = this.zzu;
            zzpp zzk2 = zzicVar.zzk();
            zzicVar.zzc();
            this.zzu.zzk().zzN(this.zzv, null, i, "_ev", zzk2.zzC(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        String str3 = str == null ? "app" : str;
        if (obj != null) {
            zzic zzicVar2 = this.zzu;
            int zzK = zzicVar2.zzk().zzK(str2, obj);
            if (zzK == 0) {
                Object zzL = zzicVar2.zzk().zzL(str2, obj);
                if (zzL != null) {
                    zzM(str3, str2, j, zzL);
                    return;
                }
                return;
            }
            zzpp zzk3 = zzicVar2.zzk();
            zzicVar2.zzc();
            String zzC = zzk3.zzC(str2, 24, true);
            if ((obj instanceof String) || (obj instanceof CharSequence)) {
                r3 = obj.toString().length();
            }
            this.zzu.zzk().zzN(this.zzv, null, zzK, "_ev", zzC, r3);
            return;
        }
        zzM(str3, str2, j, null);
    }
}
