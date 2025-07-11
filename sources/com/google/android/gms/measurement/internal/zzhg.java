package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhg extends zzje {
    static final Pair zza = new Pair("", 0L);
    public zzhe zzb;
    public final zzhd zzc;
    public final zzhd zzd;
    public final zzhf zze;
    public final zzhd zzf;
    public final zzhb zzg;
    public final zzhf zzh;
    public final zzhc zzi;
    public final zzhb zzj;
    public final zzhd zzk;
    public final zzhd zzl;
    public boolean zzm;
    public final zzhb zzn;
    public final zzhb zzo;
    public final zzhd zzp;
    public final zzhf zzq;
    public final zzhf zzr;
    public final zzhd zzs;
    public final zzhc zzt;
    private SharedPreferences zzv;
    private SharedPreferences zzw;
    private String zzx;
    private boolean zzy;
    private long zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhg(zzib zzibVar) {
        super(zzibVar);
        this.zzf = new zzhd(this, "session_timeout", 1800000L);
        this.zzg = new zzhb(this, "start_new_session", true);
        this.zzk = new zzhd(this, "last_pause_time", 0L);
        this.zzl = new zzhd(this, "session_id", 0L);
        this.zzh = new zzhf(this, "non_personalized_ads", null);
        this.zzi = new zzhc(this, "last_received_uri_timestamps_by_source", null);
        this.zzj = new zzhb(this, "allow_remote_dynamite", false);
        this.zzc = new zzhd(this, "first_open_time", 0L);
        this.zzd = new zzhd(this, "app_install_time", 0L);
        this.zze = new zzhf(this, "app_instance_id", null);
        this.zzn = new zzhb(this, "app_backgrounded", false);
        this.zzo = new zzhb(this, "deep_link_retrieval_complete", false);
        this.zzp = new zzhd(this, "deep_link_retrieval_attempts", 0L);
        this.zzq = new zzhf(this, "firebase_feature_rollouts", null);
        this.zzr = new zzhf(this, "deferred_attribution_cache", null);
        this.zzs = new zzhd(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzt = new zzhc(this, "default_event_parameters", null);
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    protected final boolean zza() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair zzb(String str) {
        zzg();
        if (zzl().zzo(zzjj.AD_STORAGE)) {
            zzib zzibVar = this.zzu;
            long elapsedRealtime = zzibVar.zzaZ().elapsedRealtime();
            String str2 = this.zzx;
            if (str2 == null || elapsedRealtime >= this.zzz) {
                this.zzz = elapsedRealtime + zzibVar.zzc().zzl(str, zzfx.zza);
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzibVar.zzaY());
                    this.zzx = "";
                    String id = advertisingIdInfo.getId();
                    if (id != null) {
                        this.zzx = id;
                    }
                    this.zzy = advertisingIdInfo.isLimitAdTrackingEnabled();
                } catch (Exception e) {
                    this.zzu.zzaV().zzj().zzb("Unable to get advertising id", e);
                    this.zzx = "";
                }
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                return new Pair(this.zzx, Boolean.valueOf(this.zzy));
            }
            return new Pair(str2, Boolean.valueOf(this.zzy));
        }
        return new Pair("", false);
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    protected final void zzba() {
        zzib zzibVar = this.zzu;
        SharedPreferences sharedPreferences = zzibVar.zzaY().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzm = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzv.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        zzibVar.zzc();
        this.zzb = new zzhe(this, "health_monitor", Math.max(0L, ((Long) zzfx.zzc.zzb(null)).longValue()), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences zzd() {
        zzg();
        zzw();
        Preconditions.checkNotNull(this.zzv);
        return this.zzv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences zze() {
        zzg();
        zzw();
        if (this.zzw == null) {
            zzib zzibVar = this.zzu;
            String packageName = zzibVar.zzaY().getPackageName();
            String.valueOf(packageName);
            String valueOf = String.valueOf(packageName);
            zzgr zzk = zzibVar.zzaV().zzk();
            String concat = valueOf.concat("_preferences");
            zzk.zzb("Default prefs file", concat);
            this.zzw = zzibVar.zzaY().getSharedPreferences(concat, 0);
        }
        return this.zzw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SparseArray zzf() {
        Bundle zza2 = this.zzi.zza();
        int[] intArray = zza2.getIntArray("uriSources");
        long[] longArray = zza2.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            this.zzu.zzaV().zzb().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = zzd().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzi() {
        zzg();
        if (zzd().contains("measurement_enabled")) {
            return Boolean.valueOf(zzd().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaz zzj() {
        zzg();
        return zzaz.zzg(zzd().getString("dma_consent_settings", null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(int i) {
        return zzjk.zzu(i, zzd().getInt("consent_source", 100));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjk zzl() {
        zzg();
        return zzjk.zzf(zzd().getString("consent_settings", "G1"), zzd().getInt("consent_source", 100));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzm(zzoc zzocVar) {
        zzg();
        String string = zzd().getString("stored_tcf_param", "");
        String zza2 = zzocVar.zza();
        if (zza2.equals(string)) {
            return false;
        }
        SharedPreferences.Editor edit = zzd().edit();
        edit.putString("stored_tcf_param", zza2);
        edit.apply();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzn(boolean z) {
        zzg();
        this.zzu.zzaV().zzk().zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzd().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzo() {
        SharedPreferences sharedPreferences = this.zzv;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(long j) {
        return j - this.zzf.zza() > this.zzk.zza();
    }
}
