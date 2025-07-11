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
import com.google.android.gms.internal.measurement.zzql;
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
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzli extends zzg {
    protected zzkx zza;
    final zzx zzb;
    protected boolean zzc;
    private zzjo zzd;
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
    private zzjk zzo;
    private final AtomicLong zzp;
    private long zzq;
    private zzay zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzay zzt;
    private final zzpn zzv;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzli(zzib zzibVar) {
        super(zzibVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzi = false;
        this.zzj = 1;
        this.zzc = true;
        this.zzv = new zzkm(this);
        this.zzg = new AtomicReference();
        this.zzo = zzjk.zza;
        this.zzq = -1L;
        this.zzp = new AtomicLong(0L);
        this.zzb = new zzx(zzibVar);
    }

    private final zzlq zzaq(final zzol zzolVar) {
        try {
            URL url = new URI(zzolVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String zzl = this.zzu.zzv().zzl();
            zzib zzibVar = this.zzu;
            zzgr zzk = zzibVar.zzaV().zzk();
            Long valueOf = Long.valueOf(zzolVar.zza);
            zzk.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, zzolVar.zzc, Integer.valueOf(zzolVar.zzb.length));
            if (!TextUtils.isEmpty(zzolVar.zzg)) {
                zzibVar.zzaV().zzk().zzc("[sgtm] Uploading data from app. row_id", valueOf, zzolVar.zzg);
            }
            HashMap hashMap = new HashMap();
            Bundle bundle = zzolVar.zzd;
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str, string);
                }
            }
            zzln zzn = zzibVar.zzn();
            byte[] bArr = zzolVar.zzb;
            zzlk zzlkVar = new zzlk() { // from class: com.google.android.gms.measurement.internal.zzky
                /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // com.google.android.gms.measurement.internal.zzlk
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr2, Map map) {
                    zzlq zzlqVar;
                    AtomicReference atomicReference2;
                    zzli zzliVar = zzli.this;
                    zzliVar.zzg();
                    zzol zzolVar2 = zzolVar;
                    if (i != 200 && i != 204) {
                        if (i == 304) {
                            i = 304;
                        }
                        zzliVar.zzu.zzaV().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzolVar2.zza), Integer.valueOf(i), th);
                        zzlqVar = !Arrays.asList(((String) zzfx.zzt.zzb(null)).split(StringUtils.COMMA)).contains(String.valueOf(i)) ? zzlq.BACKOFF : zzlq.FAILURE;
                        atomicReference2 = atomicReference;
                        zznk zzt = zzliVar.zzu.zzt();
                        long j = zzolVar2.zza;
                        zzt.zzy(new zzaf(j, zzlqVar.zza(), zzolVar2.zzf));
                        zzliVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j), zzlqVar);
                        synchronized (atomicReference2) {
                            atomicReference2.set(zzlqVar);
                            atomicReference2.notifyAll();
                        }
                        return;
                    }
                    if (th == null) {
                        zzliVar.zzu.zzaV().zzk().zzb("[sgtm] Upload succeeded for row_id", Long.valueOf(zzolVar2.zza));
                        zzlqVar = zzlq.SUCCESS;
                        atomicReference2 = atomicReference;
                        zznk zzt2 = zzliVar.zzu.zzt();
                        long j2 = zzolVar2.zza;
                        zzt2.zzy(new zzaf(j2, zzlqVar.zza(), zzolVar2.zzf));
                        zzliVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j2), zzlqVar);
                        synchronized (atomicReference2) {
                        }
                    }
                    zzliVar.zzu.zzaV().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzolVar2.zza), Integer.valueOf(i), th);
                    if (!Arrays.asList(((String) zzfx.zzt.zzb(null)).split(StringUtils.COMMA)).contains(String.valueOf(i))) {
                    }
                    atomicReference2 = atomicReference;
                    zznk zzt22 = zzliVar.zzu.zzt();
                    long j22 = zzolVar2.zza;
                    zzt22.zzy(new zzaf(j22, zzlqVar.zza(), zzolVar2.zzf));
                    zzliVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j22), zzlqVar);
                    synchronized (atomicReference2) {
                    }
                }
            };
            zzn.zzw();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzlkVar);
            zzn.zzu.zzaW().zzm(new zzlm(zzn, zzl, url, bArr, hashMap, zzlkVar));
            try {
                zzib zzibVar2 = zzibVar.zzk().zzu;
                long currentTimeMillis = zzibVar2.zzaZ().currentTimeMillis() + 60000;
                synchronized (atomicReference) {
                    for (long j = 60000; atomicReference.get() == null && j > 0; j = currentTimeMillis - zzibVar2.zzaZ().currentTimeMillis()) {
                        atomicReference.wait(j);
                    }
                }
            } catch (InterruptedException unused) {
                this.zzu.zzaV().zze().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? zzlq.UNKNOWN : (zzlq) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e) {
            this.zzu.zzaV().zzb().zzd("[sgtm] Bad upload url for row_id", zzolVar.zzc, Long.valueOf(zzolVar.zza), e);
            return zzlq.FAILURE;
        }
    }

    private final void zzar(Boolean bool, boolean z) {
        zzg();
        zzb();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzj().zzb("Setting app measurement enabled (FE)", bool);
        zzibVar.zzd().zzh(bool);
        if (z) {
            zzhg zzd = zzibVar.zzd();
            zzib zzibVar2 = zzd.zzu;
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
    /* renamed from: zzas */
    public final void zzak() {
        zzli zzliVar;
        zzg();
        zzib zzibVar = this.zzu;
        String zza = zzibVar.zzd().zzh.zza();
        if (zza == null) {
            zzliVar = this;
        } else if ("unset".equals(zza)) {
            zzliVar = this;
            zzliVar.zzN("app", "_npa", null, zzibVar.zzaZ().currentTimeMillis());
        } else {
            zzN("app", "_npa", Long.valueOf(true != "true".equals(zza) ? 0L : 1L), zzibVar.zzaZ().currentTimeMillis());
            zzliVar = this;
        }
        if (!zzliVar.zzu.zzB() || !zzliVar.zzc) {
            zzibVar.zzaV().zzj().zza("Updating Scion state (FE)");
            zzliVar.zzu.zzt().zzi();
            return;
        }
        zzibVar.zzaV().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzU();
        zzliVar.zzu.zzh().zza.zza();
        zzibVar.zzaW().zzj(new zzjy(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzA(zzjk zzjkVar) {
        zzg();
        boolean z = (zzjkVar.zzo(zzjj.ANALYTICS_STORAGE) && zzjkVar.zzo(zzjj.AD_STORAGE)) || this.zzu.zzt().zzO();
        zzib zzibVar = this.zzu;
        if (z != zzibVar.zzE()) {
            zzibVar.zzD(z);
            zzhg zzd = this.zzu.zzd();
            zzib zzibVar2 = zzd.zzu;
            zzd.zzg();
            Boolean valueOf = zzd.zzd().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzd.zzd().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzar(Boolean.valueOf(z), false);
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
        if (z2 && this.zzd != null && !zzpo.zzZ(str2)) {
            z3 = false;
        }
        boolean z4 = z3;
        if (str == null) {
            str = "app";
        }
        zzJ(str, str2, j, bundle2, z2, z4, z, null);
    }

    public final void zzD() {
        zzoc zzocVar;
        zzoc zzocVar2;
        com.google.android.gms.internal.measurement.zzkp zzkpVar;
        zzg();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzj().zza("Handle tcf update.");
        SharedPreferences zze = zzibVar.zzd().zze();
        HashMap hashMap = new HashMap();
        zzfw zzfwVar = zzfx.zzaZ;
        if (((Boolean) zzfwVar.zzb(null)).booleanValue()) {
            int i = zzoe.zzb;
            com.google.android.gms.internal.measurement.zzko zzkoVar = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            int i2 = 2;
            zzod zzodVar = zzod.CONSENT;
            com.google.android.gms.internal.measurement.zzko zzkoVar2 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            int i3 = 1;
            zzod zzodVar2 = zzod.FLEXIBLE_LEGITIMATE_INTEREST;
            ImmutableMap ofEntries = ImmutableMap.ofEntries(UByte$$ExternalSyntheticBackport0.m8542m((Object) zzkoVar, (Object) zzodVar), UByte$$ExternalSyntheticBackport0.m8542m((Object) zzkoVar2, (Object) zzodVar2), UByte$$ExternalSyntheticBackport0.m8542m((Object) com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, (Object) zzodVar), UByte$$ExternalSyntheticBackport0.m8542m((Object) com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, (Object) zzodVar), UByte$$ExternalSyntheticBackport0.m8542m((Object) com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, (Object) zzodVar2), UByte$$ExternalSyntheticBackport0.m8542m((Object) com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, (Object) zzodVar2), UByte$$ExternalSyntheticBackport0.m8542m((Object) com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, (Object) zzodVar2));
            ImmutableSet of = ImmutableSet.of("CH");
            char[] cArr = new char[5];
            boolean contains = zze.contains("IABTCF_TCString");
            int zzb = zzoe.zzb(zze, "IABTCF_CmpSdkID");
            int zzb2 = zzoe.zzb(zze, "IABTCF_PolicyVersion");
            int zzb3 = zzoe.zzb(zze, "IABTCF_gdprApplies");
            int zzb4 = zzoe.zzb(zze, "IABTCF_PurposeOneTreatment");
            int zzb5 = zzoe.zzb(zze, "IABTCF_EnableAdvertiserConsentMode");
            String zza = zzoe.zza(zze, "IABTCF_PublisherCC");
            ImmutableMap.Builder builder = ImmutableMap.builder();
            UnmodifiableIterator it = ofEntries.keySet().iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzko zzkoVar3 = (com.google.android.gms.internal.measurement.zzko) it.next();
                int zza2 = zzkoVar3.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(zza2);
                String zza3 = zzoe.zza(zze, sb.toString());
                if (TextUtils.isEmpty(zza3) || zza3.length() < 755) {
                    zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED;
                } else {
                    int digit = Character.digit(zza3.charAt(754), 10);
                    zzkpVar = (digit < 0 || digit > com.google.android.gms.internal.measurement.zzkp.values().length || digit == 0) ? com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED : digit != i3 ? digit != i2 ? com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED : com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST : com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                }
                builder.put(zzkoVar3, zzkpVar);
                i2 = 2;
                i3 = 1;
            }
            ImmutableMap buildOrThrow = builder.buildOrThrow();
            String zza4 = zzoe.zza(zze, "IABTCF_PurposeConsents");
            String zza5 = zzoe.zza(zze, "IABTCF_VendorConsents");
            boolean z = !TextUtils.isEmpty(zza5) && zza5.length() >= 755 && zza5.charAt(754) == '1';
            String zza6 = zzoe.zza(zze, "IABTCF_PurposeLegitimateInterests");
            String zza7 = zzoe.zza(zze, "IABTCF_VendorLegitimateInterests");
            boolean z2 = !TextUtils.isEmpty(zza7) && zza7.length() >= 755 && zza7.charAt(754) == '1';
            cArr[0] = '2';
            zzocVar = new zzoc(zzoe.zzd(ofEntries, buildOrThrow, of, cArr, zzb, zzb5, zzb3, zzb2, zzb4, zza, zza4, zza6, z, z2, contains));
        } else {
            String zza8 = zzoe.zza(zze, "IABTCF_VendorConsents");
            if (!"".equals(zza8) && zza8.length() > 754) {
                hashMap.put("GoogleConsent", String.valueOf(zza8.charAt(754)));
            }
            int zzb6 = zzoe.zzb(zze, "IABTCF_gdprApplies");
            if (zzb6 != -1) {
                hashMap.put("gdprApplies", String.valueOf(zzb6));
            }
            int zzb7 = zzoe.zzb(zze, "IABTCF_EnableAdvertiserConsentMode");
            if (zzb7 != -1) {
                hashMap.put("EnableAdvertiserConsentMode", String.valueOf(zzb7));
            }
            int zzb8 = zzoe.zzb(zze, "IABTCF_PolicyVersion");
            if (zzb8 != -1) {
                hashMap.put("PolicyVersion", String.valueOf(zzb8));
            }
            String zza9 = zzoe.zza(zze, "IABTCF_PurposeConsents");
            if (!"".equals(zza9)) {
                hashMap.put("PurposeConsents", zza9);
            }
            int zzb9 = zzoe.zzb(zze, "IABTCF_CmpSdkID");
            if (zzb9 != -1) {
                hashMap.put("CmpSdkID", String.valueOf(zzb9));
            }
            zzocVar = new zzoc(hashMap);
        }
        zzibVar.zzaV().zzk().zzb("Tcf preferences read", zzocVar);
        if (!zzibVar.zzc().zzp(null, zzfwVar)) {
            if (zzibVar.zzd().zzm(zzocVar)) {
                Bundle zzb10 = zzocVar.zzb();
                zzibVar.zzaV().zzk().zzb("Consent generated from Tcf", zzb10);
                if (zzb10 != Bundle.EMPTY) {
                    zzp(zzb10, -30, zzibVar.zzaZ().currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", zzocVar.zze());
                zzF("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        zzhg zzd = zzibVar.zzd();
        zzd.zzg();
        String string = zzd.zzd().getString("stored_tcf_param", "");
        HashMap hashMap2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            zzocVar2 = new zzoc(hashMap2);
        } else {
            for (String str : string.split(";")) {
                String[] split = str.split("=");
                if (split.length >= 2 && zzoe.zza.contains(split[0])) {
                    hashMap2.put(split[0], split[1]);
                }
            }
            zzocVar2 = new zzoc(hashMap2);
        }
        if (zzibVar.zzd().zzm(zzocVar)) {
            Bundle zzb11 = zzocVar.zzb();
            zzibVar.zzaV().zzk().zzb("Consent generated from Tcf", zzb11);
            if (zzb11 != Bundle.EMPTY) {
                zzp(zzb11, -30, zzibVar.zzaZ().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfm", zzocVar.zzd(zzocVar2));
            bundle2.putString("_tcfd2", zzocVar.zzc());
            bundle2.putString("_tcfd", zzocVar.zze());
            zzF("auto", "_tcf", bundle2);
        }
    }

    public final void zzE() {
        zzg();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzj().zza("Register tcfPrefChangeListener.");
        if (this.zzs == null) {
            this.zzt = new zzka(this, this.zzu);
            this.zzs = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzld
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzli.this.zzaf(sharedPreferences, str);
                }
            };
        }
        zzibVar.zzd().zze().registerOnSharedPreferenceChangeListener(this.zzs);
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
        if (this.zzd != null && !zzpo.zzZ(str2)) {
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
        zzib zzibVar = this.zzu;
        if (zzibVar.zzB()) {
            List zzp = this.zzu.zzv().zzp();
            if (zzp == null || zzp.contains(str2)) {
                if (!this.zzf) {
                    this.zzf = true;
                    try {
                        if (zzibVar.zzp()) {
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
                zzib zzibVar2 = this.zzu;
                if (!zzibVar2.zzc().zzp(null, zzfx.zzbg) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
                    zzibVar2.zzaU();
                    zzN("auto", "_lgclid", bundle.getString("gclid"), zzibVar2.zzaZ().currentTimeMillis());
                }
                zzli zzliVar = this;
                zzibVar2.zzaU();
                if (z && zzpo.zzaf(str2)) {
                    zzibVar2.zzk().zzI(bundle, zzibVar2.zzd().zzt.zza());
                }
                if (!z3) {
                    zzibVar2.zzaU();
                    if (!"_iap".equals(str2)) {
                        zzib zzibVar3 = zzliVar.zzu;
                        zzpo zzk = zzibVar3.zzk();
                        if (zzk.zzj(NotificationCompat.CATEGORY_EVENT, str2)) {
                            if (zzk.zzl(NotificationCompat.CATEGORY_EVENT, zzjl.zza, zzjl.zzb, str2)) {
                                zzk.zzu.zzc();
                                if (zzk.zzm(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                                    i4 = 0;
                                }
                            } else {
                                i4 = 13;
                            }
                            if (i4 != 0) {
                                zzibVar2.zzaV().zzd().zzb("Invalid public event name. Event will not be logged (FE)", zzibVar2.zzl().zza(str2));
                                zzpo zzk2 = zzibVar3.zzk();
                                zzibVar3.zzc();
                                zzibVar3.zzk().zzN(zzliVar.zzv, null, i4, "_ev", zzk2.zzC(str2, 40, true), str2 != null ? str2.length() : 0);
                                return;
                            }
                        }
                        i4 = 2;
                        if (i4 != 0) {
                        }
                    }
                }
                zzibVar2.zzaU();
                zzib zzibVar4 = zzliVar.zzu;
                zzlt zzh = zzibVar4.zzs().zzh(false);
                if (zzh != null && !bundle.containsKey("_sc")) {
                    zzh.zzd = true;
                }
                zzpo.zzav(zzh, bundle, z && !z3);
                boolean equals = "am".equals(str5);
                boolean zzZ = zzpo.zzZ(str2);
                if (!z || zzliVar.zzd == null || zzZ) {
                    z4 = equals;
                } else if (!equals) {
                    zzibVar2.zzaV().zzj().zzc("Passing event to registered event handler (FE)", zzibVar2.zzl().zza(str2), zzibVar2.zzl().zze(bundle));
                    Preconditions.checkNotNull(zzliVar.zzd);
                    zzliVar.zzd.interceptEvent(str5, str2, bundle, j);
                    return;
                } else {
                    z4 = true;
                }
                zzib zzibVar5 = zzliVar.zzu;
                if (zzibVar5.zzH()) {
                    int zzn = zzibVar2.zzk().zzn(str2);
                    if (zzn != 0) {
                        zzibVar2.zzaV().zzd().zzb("Invalid event name. Event will not be logged (FE)", zzibVar2.zzl().zza(str2));
                        zzpo zzk3 = zzibVar2.zzk();
                        zzibVar2.zzc();
                        zzibVar5.zzk().zzN(zzliVar.zzv, str3, zzn, "_ev", zzk3.zzC(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                    Bundle zzF = zzibVar2.zzk().zzF(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
                    Preconditions.checkNotNull(zzF);
                    zzibVar2.zzaU();
                    if (zzibVar4.zzs().zzh(false) == null || !"_ae".equals(str2)) {
                        i = 0;
                        j2 = 0;
                    } else {
                        zznz zznzVar = zzibVar4.zzh().zzb;
                        j2 = 0;
                        long elapsedRealtime = zznzVar.zzc.zzu.zzaZ().elapsedRealtime();
                        i = 0;
                        long j5 = elapsedRealtime - zznzVar.zzb;
                        zznzVar.zzb = elapsedRealtime;
                        if (j5 > 0) {
                            zzibVar2.zzk().zzak(zzF, j5);
                        }
                    }
                    if ("auto".equals(str5) || !"_ssr".equals(str2)) {
                        if ("_ae".equals(str2)) {
                            String zza2 = zzibVar2.zzk().zzu.zzd().zzq.zza();
                            if (!TextUtils.isEmpty(zza2)) {
                                zzF.putString("_ffr", zza2);
                            }
                        }
                    } else {
                        zzpo zzk4 = zzibVar2.zzk();
                        String string = zzF.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            string = null;
                        } else if (string != null) {
                            string = string.trim();
                        }
                        zzib zzibVar6 = zzk4.zzu;
                        if (!Objects.equals(string, zzibVar6.zzd().zzq.zza())) {
                            zzibVar6.zzd().zzq.zzb(string);
                        } else {
                            zzibVar6.zzaV().zzj().zza("Not logging duplicate session_start_with_rollout event");
                            return;
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(zzF);
                    if (!zzibVar2.zzc().zzp(null, zzfx.zzaU)) {
                        zza = zzibVar2.zzd().zzn.zza();
                    } else {
                        zza = zzibVar4.zzh().zzi();
                    }
                    if (zzibVar2.zzd().zzk.zza() > j2) {
                        j4 = j;
                        if (zzibVar2.zzd().zzp(j4) && zza) {
                            zzibVar2.zzaV().zzk().zza("Current session is expired, remove the session number, ID, and engagement time");
                            long j6 = j2;
                            arrayList = arrayList2;
                            j3 = j6;
                            str4 = "_ae";
                            zzN("auto", "_sid", null, zzibVar2.zzaZ().currentTimeMillis());
                            zzN("auto", "_sno", null, zzibVar2.zzaZ().currentTimeMillis());
                            zzN("auto", "_se", null, zzibVar2.zzaZ().currentTimeMillis());
                            zzliVar = this;
                            zzibVar2.zzd().zzl.zzb(j3);
                            if (zzF.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j3) == 1) {
                                zzibVar2.zzaV().zzk().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                                zzibVar5.zzh().zza.zzb(j4, true);
                            }
                            ArrayList arrayList3 = new ArrayList(zzF.keySet());
                            Collections.sort(arrayList3);
                            size = arrayList3.size();
                            for (i2 = i; i2 < size; i2++) {
                                String str6 = (String) arrayList3.get(i2);
                                if (str6 != null) {
                                    zzibVar2.zzk();
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
                                    bundle2 = zzibVar2.zzk().zzab(bundle2, null);
                                }
                                String str8 = str5;
                                Bundle bundle3 = bundle2;
                                zzibVar4.zzt().zzn(new zzbg(str7, new zzbe(bundle2), str8, j4), str3);
                                if (!z4) {
                                    for (zzjp zzjpVar : zzliVar.zze) {
                                        zzjpVar.onEvent(str, str2, new Bundle(bundle3), j);
                                    }
                                }
                                i3++;
                                str5 = str;
                                j4 = j;
                                arrayList = arrayList5;
                            }
                            zzibVar2.zzaU();
                            if (zzibVar4.zzs().zzh(i) == null && str4.equals(str2)) {
                                zzibVar4.zzh().zzb.zzd(true, true, zzibVar2.zzaZ().elapsedRealtime());
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
                    zzibVar2.zzaU();
                    if (zzibVar4.zzs().zzh(i) == null) {
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
        zzib.zzL();
        zzJ("auto", str2, this.zzu.zzaZ().currentTimeMillis(), bundle, false, true, true, str3);
    }

    protected final void zzJ(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int i = zzpo.zza;
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
        this.zzu.zzaW().zzj(new zzkb(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void zzK(String str, String str2, Object obj, boolean z) {
        zzL("auto", "_ldl", obj, true, this.zzu.zzaZ().currentTimeMillis());
    }

    final void zzM(String str, String str2, long j, Object obj) {
        this.zzu.zzaW().zzj(new zzkc(this, str, str2, obj, j));
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
                    zzib zzibVar = this.zzu;
                    Long valueOf = Long.valueOf(j2);
                    zzibVar.zzd().zzh.zzb(valueOf.longValue() == 1 ? "true" : "false");
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
        zzib zzibVar2 = this.zzu;
        if (!zzibVar2.zzB()) {
            this.zzu.zzaV().zzk().zza("User property not set since app measurement is disabled");
        } else if (zzibVar2.zzH()) {
            this.zzu.zzt().zzA(new zzpk(str4, j, obj2, str));
        }
    }

    public final List zzO(boolean z) {
        zzb();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzk().zza("Getting user properties (FE)");
        if (!zzibVar.zzaW().zze()) {
            zzibVar.zzaU();
            if (zzae.zza()) {
                zzibVar.zzaV().zzb().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference, 5000L, "get user properties", new zzke(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzibVar.zzaV().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyList();
            }
            return list;
        }
        zzibVar.zzaV().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzP(String str, String str2, boolean z) {
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzaW().zze()) {
            zzibVar.zzaU();
            if (zzae.zza()) {
                zzibVar.zzaV().zzb().zza("Cannot get user properties from main thread");
                return Collections.emptyMap();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference, 5000L, "get user properties", new zzkk(this, atomicReference, null, str, str2, z));
            List<zzpk> list = (List) atomicReference.get();
            if (list == null) {
                zzibVar.zzaV().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzpk zzpkVar : list) {
                Object zza = zzpkVar.zza();
                if (zza != null) {
                    arrayMap.put(zzpkVar.zzb, zza);
                }
            }
            return arrayMap;
        }
        zzibVar.zzaV().zzb().zza("Cannot get user properties from analytics worker thread");
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
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzd().zzo.zza()) {
            long zza = zzibVar.zzd().zzp.zza();
            zzibVar.zzd().zzp.zzb(1 + zza);
            zzibVar.zzc();
            if (zza >= 5) {
                zzibVar.zzaV().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzibVar.zzd().zzo.zzb(true);
                return;
            }
            if (this.zzr == null) {
                this.zzr = new zzkf(this, this.zzu);
            }
            this.zzr.zzb(0L);
            return;
        }
        zzibVar.zzaV().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }

    public final void zzT(long j) {
        this.zzg.set(null);
        this.zzu.zzaW().zzj(new zzkg(this, j));
    }

    public final void zzU() {
        zzg();
        zzb();
        if (this.zzu.zzH()) {
            zzib zzibVar = this.zzu;
            zzal zzc = zzibVar.zzc();
            zzc.zzu.zzaU();
            Boolean zzr = zzc.zzr("google_analytics_deferred_deep_link_enabled");
            if (zzr != null && zzr.booleanValue()) {
                zzibVar.zzaV().zzj().zza("Deferred Deep Link feature enabled.");
                zzibVar.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlg
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzli.this.zzS();
                    }
                });
            }
            this.zzu.zzt().zzE();
            this.zzc = false;
            zzhg zzd = zzibVar.zzd();
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
            zzibVar.zzu().zzw();
            if (string.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzF("auto", "_ou", bundle);
        }
    }

    public final void zzV(zzjo zzjoVar) {
        zzjo zzjoVar2;
        zzg();
        zzb();
        if (zzjoVar != null && zzjoVar != (zzjoVar2 = this.zzd)) {
            Preconditions.checkState(zzjoVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzjoVar;
    }

    public final void zzW(zzjp zzjpVar) {
        zzb();
        Preconditions.checkNotNull(zzjpVar);
        if (this.zze.add(zzjpVar)) {
            return;
        }
        this.zzu.zzaV().zze().zza("OnEventListener already registered");
    }

    public final void zzX(zzjp zzjpVar) {
        zzb();
        Preconditions.checkNotNull(zzjpVar);
        if (this.zze.remove(zzjpVar)) {
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
        zzjg.zzb(bundle2, "app_id", String.class, null);
        zzjg.zzb(bundle2, "origin", String.class, null);
        zzjg.zzb(bundle2, "name", String.class, null);
        zzjg.zzb(bundle2, "value", Object.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzib zzibVar = this.zzu;
        if (zzibVar.zzk().zzp(string) == 0) {
            if (zzibVar.zzk().zzK(string, obj) == 0) {
                Object zzL = zzibVar.zzk().zzL(string, obj);
                if (zzL == null) {
                    zzibVar.zzaV().zzb().zzc("Unable to normalize conditional user property value", zzibVar.zzl().zzc(string), obj);
                    return;
                }
                zzjg.zza(bundle2, zzL);
                long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    zzibVar.zzc();
                    if (j2 > 15552000000L || j2 < 1) {
                        zzibVar.zzaV().zzb().zzc("Invalid conditional user property timeout", zzibVar.zzl().zzc(string), Long.valueOf(j2));
                        return;
                    }
                }
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                zzibVar.zzc();
                if (j3 > 15552000000L || j3 < 1) {
                    zzibVar.zzaV().zzb().zzc("Invalid conditional user property time to live", zzibVar.zzl().zzc(string), Long.valueOf(j3));
                    return;
                } else {
                    zzibVar.zzaW().zzj(new zzkh(this, bundle2));
                    return;
                }
            }
            zzibVar.zzaV().zzb().zzc("Invalid conditional user property value", zzibVar.zzl().zzc(string), obj);
            return;
        }
        zzibVar.zzaV().zzb().zzb("Invalid conditional user property name", zzibVar.zzl().zzc(string));
    }

    public final void zzab(String str, String str2, Bundle bundle) {
        zzib zzibVar = this.zzu;
        long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzibVar.zzaW().zzj(new zzki(this, bundle2));
    }

    public final ArrayList zzac(String str, String str2) {
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzaW().zze()) {
            zzibVar.zzaU();
            if (zzae.zza()) {
                zzibVar.zzaV().zzb().zza("Cannot get conditional user properties from main thread");
                return new ArrayList(0);
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference, 5000L, "get conditional user properties", new zzkj(this, atomicReference, null, str, str2));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzibVar.zzaV().zzb().zzb("Timed out waiting for get conditional user properties", null);
                return new ArrayList();
            }
            return zzpo.zzas(list);
        }
        zzibVar.zzaV().zzb().zza("Cannot get conditional user properties from analytics worker thread");
        return new ArrayList(0);
    }

    public final String zzad() {
        zzlt zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zza;
        }
        return null;
    }

    public final String zzae() {
        zzlt zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zzb;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaf(SharedPreferences sharedPreferences, String str) {
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzc().zzp(null, zzfx.zzaZ)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                zzibVar.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
                ((zzay) Preconditions.checkNotNull(this.zzt)).zzb(500L);
            }
        } else if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            zzibVar.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
            ((zzay) Preconditions.checkNotNull(this.zzt)).zzb(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzag(Bundle bundle) {
        Bundle bundle2;
        int i;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            zzib zzibVar = this.zzu;
            bundle2 = new Bundle(zzibVar.zzd().zzt.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj == null || (obj instanceof String) || (obj instanceof Long) || (obj instanceof Double)) {
                    if (zzpo.zzZ(next)) {
                        zzibVar.zzaV().zzh().zzb("Invalid default event parameter name. Name", next);
                    } else if (obj == null) {
                        bundle2.remove(next);
                    } else if (zzibVar.zzk().zzu("param", next, zzibVar.zzc().zze(null, false), obj)) {
                        zzibVar.zzk().zzM(bundle2, next, obj);
                    }
                } else {
                    if (zzibVar.zzk().zzt(obj)) {
                        zzibVar.zzk().zzN(this.zzv, null, 27, null, null, 0);
                    }
                    zzibVar.zzaV().zzh().zzc("Invalid default event parameter type. Name, value", next, obj);
                }
            }
            zzibVar.zzk();
            int zzc = zzibVar.zzc().zzc();
            if (bundle2.size() > zzc) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i++;
                    if (i > zzc) {
                        bundle2.remove(str);
                    }
                }
                zzibVar.zzk().zzN(this.zzv, null, 26, null, null, 0);
                zzibVar.zzaV().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzib zzibVar2 = this.zzu;
        zzibVar2.zzd().zzt.zzb(bundle2);
        if (!bundle.isEmpty() || zzibVar2.zzc().zzp(null, zzfx.zzaW)) {
            this.zzu.zzt().zzH(bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzah(int i) {
        if (this.zzk == null) {
            this.zzk = new zzjw(this, this.zzu);
        }
        this.zzk.zzb(i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzai(Boolean bool, boolean z) {
        zzar(bool, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaj(zzjk zzjkVar, long j, boolean z, boolean z2) {
        zzg();
        zzb();
        zzib zzibVar = this.zzu;
        zzjk zzl = zzibVar.zzd().zzl();
        if (j > this.zzq || !zzjk.zzu(zzl.zzb(), zzjkVar.zzb())) {
            zzhg zzd = zzibVar.zzd();
            zzib zzibVar2 = zzd.zzu;
            zzd.zzg();
            int zzb = zzjkVar.zzb();
            if (zzd.zzk(zzb)) {
                zzib zzibVar3 = this.zzu;
                SharedPreferences.Editor edit = zzd.zzd().edit();
                edit.putString("consent_settings", zzjkVar.zzl());
                edit.putInt("consent_source", zzb);
                edit.apply();
                zzibVar.zzaV().zzk().zzb("Setting storage consent(FE)", zzjkVar);
                this.zzq = j;
                if (!zzibVar3.zzt().zzP()) {
                    zzibVar3.zzt().zzj(z);
                } else {
                    zzibVar3.zzt().zzk(z);
                }
                if (z2) {
                    zzibVar3.zzt().zzC(new AtomicReference());
                    return;
                }
                return;
            }
            zzibVar.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjkVar.zzb()));
            return;
        }
        zzibVar.zzaV().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjkVar);
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
    public final /* synthetic */ zzay zzao() {
        return this.zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzap(Throwable th) {
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
        zzib zzibVar = this.zzu;
        if (!(zzibVar.zzaY().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zzibVar.zzaY().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaW().zzk(atomicReference, 15000L, "boolean test flag value", new zzkd(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaW().zzk(atomicReference, 15000L, "String test flag value", new zzkn(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaW().zzk(atomicReference, 15000L, "long test flag value", new zzko(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaW().zzk(atomicReference, 15000L, "int test flag value", new zzkp(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaW().zzk(atomicReference, 15000L, "double test flag value", new zzkq(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzu.zzaW().zzj(new zzkr(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzp(Bundle bundle, int i, long j) {
        Object obj;
        String string;
        zzb();
        zzjk zzjkVar = zzjk.zza;
        zzjj[] zzb = zzji.STORAGE.zzb();
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
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzh().zzb("Ignoring invalid consent setting", obj);
            zzibVar.zzaV().zzh().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zze = this.zzu.zzaW().zze();
        zzjk zze2 = zzjk.zze(bundle, i);
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
        zzks zzksVar = new zzks(this, zzazVar);
        if (!z) {
            this.zzu.zzaW().zzj(zzksVar);
            return;
        }
        zzg();
        zzksVar.run();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00ce -> B:53:0x00cb). Please submit an issue!!! */
    public final void zzs(zzjk zzjkVar, boolean z) {
        Throwable th;
        boolean zzr;
        boolean z2;
        zzb();
        int zzb = zzjkVar.zzb();
        if (zzb != -10) {
            zzjh zzp = zzjkVar.zzp();
            zzjh zzjhVar = zzjh.UNINITIALIZED;
            if (zzp == zzjhVar && zzjkVar.zzq() == zzjhVar) {
                this.zzu.zzaV().zzh().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzh) {
            try {
                boolean z3 = false;
                if (zzjk.zzu(zzb, this.zzo.zzb())) {
                    try {
                        zzr = zzjkVar.zzr(this.zzo);
                        zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
                        if (zzjkVar.zzo(zzjjVar) && !this.zzo.zzo(zzjjVar)) {
                            z3 = true;
                        }
                        zzjkVar = zzjkVar.zzt(this.zzo);
                        this.zzo = zzjkVar;
                        z2 = z3;
                        z3 = true;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    zzr = false;
                    z2 = false;
                }
                zzjk zzjkVar2 = zzjkVar;
                if (!z3) {
                    this.zzu.zzaV().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjkVar2);
                    return;
                }
                long andIncrement = this.zzp.getAndIncrement();
                if (zzr) {
                    this.zzg.set(null);
                    zzkt zzktVar = new zzkt(this, zzjkVar2, andIncrement, z2);
                    if (!z) {
                        this.zzu.zzaW().zzl(zzktVar);
                        return;
                    }
                    zzg();
                    zzktVar.run();
                    return;
                }
                zzku zzkuVar = new zzku(this, zzjkVar2, andIncrement, z2);
                if (z) {
                    zzg();
                    zzkuVar.run();
                } else if (zzb == 30 || zzb == -10) {
                    this.zzu.zzaW().zzl(zzkuVar);
                } else {
                    this.zzu.zzaW().zzj(zzkuVar);
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt(Runnable runnable) {
        zzb();
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzaW().zze()) {
            if (!zzibVar.zzaW().zzf()) {
                zzibVar.zzaU();
                if (!zzae.zza()) {
                    zzibVar.zzaV().zzk().zza("[sgtm] Started client-side batch upload work.");
                    boolean z = false;
                    int i = 0;
                    int i2 = 0;
                    while (!z) {
                        zzibVar.zzaV().zzk().zza("[sgtm] Getting upload batches from service (FE)");
                        final AtomicReference atomicReference = new AtomicReference();
                        zzibVar.zzaW().zzk(atomicReference, Renderer.DEFAULT_DURATION_TO_PROGRESS_US, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzli.this.zzu.zzt().zzx(atomicReference, zzon.zza(zzlr.SGTM_CLIENT));
                            }
                        });
                        zzop zzopVar = (zzop) atomicReference.get();
                        if (zzopVar == null) {
                            break;
                        }
                        List list = zzopVar.zza;
                        if (!list.isEmpty()) {
                            zzibVar.zzaV().zzk().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                            i += list.size();
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                zzlq zzaq = zzaq((zzol) it.next());
                                if (zzaq == zzlq.SUCCESS) {
                                    i2++;
                                } else if (zzaq == zzlq.BACKOFF) {
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    zzibVar.zzaV().zzk().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i), Integer.valueOf(i2));
                    runnable.run();
                    return;
                }
                zzibVar.zzaV().zzb().zza("Cannot retrieve and upload batches from main thread");
                return;
            }
            zzibVar.zzaV().zzb().zza("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        zzibVar.zzaV().zzb().zza("Cannot retrieve and upload batches from analytics worker thread");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(long j) {
        zzg();
        if (this.zzl == null) {
            this.zzl = new zzjt(this, this.zzu);
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
        zzql.zza();
        zzib zzibVar = this.zzu;
        if (zzibVar.zzc().zzp(null, zzfx.zzaQ)) {
            if (!zzibVar.zzaW().zze()) {
                zzibVar.zzaU();
                if (!zzae.zza()) {
                    zzb();
                    zzibVar.zzaV().zzk().zza("Getting trigger URIs (FE)");
                    final AtomicReference atomicReference = new AtomicReference();
                    zzibVar.zzaW().zzk(atomicReference, Renderer.DEFAULT_DURATION_TO_PROGRESS_US, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkz
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzli zzliVar = zzli.this;
                            zzliVar.zzu.zzt().zzw(atomicReference, zzliVar.zzu.zzd().zzi.zza());
                        }
                    });
                    final List list = (List) atomicReference.get();
                    if (list == null) {
                        zzibVar.zzaV().zzd().zza("Timed out waiting for get trigger URIs");
                        return;
                    } else {
                        zzibVar.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzli zzliVar = zzli.this;
                                zzliVar.zzg();
                                if (Build.VERSION.SDK_INT < 30) {
                                    return;
                                }
                                List<zzog> list2 = list;
                                SparseArray zzf = zzliVar.zzu.zzd().zzf();
                                for (zzog zzogVar : list2) {
                                    int i = zzogVar.zzc;
                                    if (!zzf.contains(i) || ((Long) zzf.get(i)).longValue() < zzogVar.zzb) {
                                        zzliVar.zzy().add(zzogVar);
                                    }
                                }
                                zzliVar.zzz();
                            }
                        });
                        return;
                    }
                }
                zzibVar.zzaV().zzb().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzibVar.zzaV().zzb().zza("Cannot get trigger URIs from analytics worker thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PriorityQueue zzy() {
        if (this.zzm == null) {
            this.zzm = new PriorityQueue(Comparator.comparing(zzlb.zza, zzlc.zza));
        }
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzz() {
        zzog zzogVar;
        zzg();
        this.zzn = false;
        if (zzy().isEmpty() || this.zzi || (zzogVar = (zzog) zzy().poll()) == null) {
            return;
        }
        zzib zzibVar = this.zzu;
        MeasurementManagerFutures zzT = zzibVar.zzk().zzT();
        if (zzT != null) {
            this.zzi = true;
            zzgr zzk = zzibVar.zzaV().zzk();
            String str = zzogVar.zza;
            zzk.zzb("Registering trigger URI", str);
            ListenableFuture<Unit> registerTriggerAsync = zzT.registerTriggerAsync(Uri.parse(str));
            if (registerTriggerAsync == null) {
                this.zzi = false;
                zzy().add(zzogVar);
                return;
            }
            Futures.addCallback(registerTriggerAsync, new zzjv(this, zzogVar), new zzju(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzL(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int i2;
        if (!z) {
            zzpo zzk = this.zzu.zzk();
            if (zzk.zzj("user property", str2)) {
                if (zzk.zzl("user property", zzjn.zza, null, str2)) {
                    zzk.zzu.zzc();
                    if (zzk.zzm("user property", 24, str2)) {
                        i = 0;
                        if (i != 0) {
                            zzib zzibVar = this.zzu;
                            zzpo zzk2 = zzibVar.zzk();
                            zzibVar.zzc();
                            this.zzu.zzk().zzN(this.zzv, null, i, "_ev", zzk2.zzC(str2, 24, true), str2 != null ? str2.length() : 0);
                            return;
                        }
                        String str3 = str == null ? "app" : str;
                        if (obj != null) {
                            zzib zzibVar2 = this.zzu;
                            int zzK = zzibVar2.zzk().zzK(str2, obj);
                            if (zzK == 0) {
                                Object zzL = zzibVar2.zzk().zzL(str2, obj);
                                if (zzL != null) {
                                    zzM(str3, str2, j, zzL);
                                    return;
                                }
                                return;
                            }
                            zzpo zzk3 = zzibVar2.zzk();
                            zzibVar2.zzc();
                            String zzC = zzk3.zzC(str2, 24, true);
                            if ((obj instanceof String) || (obj instanceof CharSequence)) {
                                r3 = obj.toString().length();
                            }
                            this.zzu.zzk().zzN(this.zzv, null, zzK, "_ev", zzC, r3);
                            return;
                        }
                        zzM(str3, str2, j, null);
                        return;
                    }
                } else {
                    i2 = 15;
                }
            }
            i = 6;
            if (i != 0) {
            }
        } else {
            i2 = this.zzu.zzk().zzp(str2);
        }
        i = i2;
        if (i != 0) {
        }
    }
}
