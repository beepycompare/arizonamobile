package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.android.vending.expansion.zipfile.APEZProvider;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.5.0 */
/* loaded from: classes3.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzcq {
    zzib zza = null;
    private final Map zzb = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str) {
        zzb();
        this.zza.zzk().zzal(zzcuVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzw().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzj().zzab(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearMeasurementEnabled(long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzn(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzw().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void generateEventId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        long zzd = this.zza.zzk().zzd();
        zzb();
        this.zza.zzk().zzam(zzcuVar, zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.zza.zzaW().zzj(new zzi(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzc(zzcuVar, this.zza.zzj().zzQ());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.zza.zzaW().zzj(new zzm(this, zzcuVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzc(zzcuVar, this.zza.zzj().zzae());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzc(zzcuVar, this.zza.zzj().zzad());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        String str;
        zzb();
        zzli zzj = this.zza.zzj();
        try {
            str = zzls.zza(zzj.zzu.zzaY(), "google_app_id", zzj.zzu.zzq());
        } catch (IllegalStateException e) {
            zzj.zzu.zzaV().zzb().zzb("getGoogleAppId failed with exception", e);
            str = null;
        }
        zzc(zzcuVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.zza.zzj().zzY(str);
        zzb();
        this.zza.zzk().zzan(zzcuVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getSessionId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        zzj.zzu.zzaW().zzj(new zzkl(zzj, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcu zzcuVar, int i) throws RemoteException {
        zzb();
        if (i == 0) {
            this.zza.zzk().zzal(zzcuVar, this.zza.zzj().zzj());
        } else if (i == 1) {
            this.zza.zzk().zzam(zzcuVar, this.zza.zzj().zzk().longValue());
        } else if (i != 2) {
            if (i == 3) {
                this.zza.zzk().zzan(zzcuVar, this.zza.zzj().zzl().intValue());
            } else if (i != 4) {
            } else {
                this.zza.zzk().zzap(zzcuVar, this.zza.zzj().zzi().booleanValue());
            }
        } else {
            zzpo zzk = this.zza.zzk();
            double doubleValue = this.zza.zzj().zzm().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzcuVar.zzb(bundle);
            } catch (RemoteException e) {
                zzk.zzu.zzaV().zze().zzb("Error returning double value to wrapper", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.zza.zzaW().zzj(new zzk(this, zzcuVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initForTests(Map map) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdd zzddVar, long j) throws RemoteException {
        zzib zzibVar = this.zza;
        if (zzibVar == null) {
            this.zza = zzib.zzy((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzddVar, Long.valueOf(j));
        } else {
            zzibVar.zzaV().zze().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.zza.zzaW().zzj(new zzn(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzC(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j) throws RemoteException {
        zzb();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzaW().zzj(new zzj(this, zzcuVar, new zzbg(str2, new zzbe(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zzb();
        this.zza.zzaV().zzm(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zzb();
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle, long j) {
        zzb();
        zzkx zzkxVar = this.zza.zzj().zza;
        if (zzkxVar != null) {
            this.zza.zzj().zzh();
            zzkxVar.zza(zzdfVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j) throws RemoteException {
        zzb();
        zzkx zzkxVar = this.zza.zzj().zza;
        if (zzkxVar != null) {
            this.zza.zzj().zzh();
            zzkxVar.zzb(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j) throws RemoteException {
        zzb();
        zzkx zzkxVar = this.zza.zzj().zza;
        if (zzkxVar != null) {
            this.zza.zzj().zzh();
            zzkxVar.zzc(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j) throws RemoteException {
        zzb();
        zzkx zzkxVar = this.zza.zzj().zza;
        if (zzkxVar != null) {
            this.zza.zzj().zzh();
            zzkxVar.zzd(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j) throws RemoteException {
        zzb();
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), zzcuVar, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j) throws RemoteException {
        zzb();
        zzkx zzkxVar = this.zza.zzj().zza;
        Bundle bundle = new Bundle();
        if (zzkxVar != null) {
            this.zza.zzj().zzh();
            zzkxVar.zze(zzdfVar, bundle);
        }
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zza.zzaV().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j) throws RemoteException {
        zzb();
        if (this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j) throws RemoteException {
        zzb();
        if (this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j) throws RemoteException {
        zzb();
        zzcuVar.zzb(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzjp zzjpVar;
        zzb();
        Map map = this.zzb;
        synchronized (map) {
            zzjpVar = (zzjp) map.get(Integer.valueOf(zzdaVar.zzf()));
            if (zzjpVar == null) {
                zzjpVar = new zzq(this, zzdaVar);
                map.put(Integer.valueOf(zzdaVar.zzf()), zzjpVar);
            }
        }
        this.zza.zzj().zzW(zzjpVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void resetAnalyticsData(long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzT(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.zzcx zzcxVar) {
        zzb();
        this.zza.zzj().zzt(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzo
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzcxVar.zze();
                } catch (RemoteException e) {
                    ((zzib) Preconditions.checkNotNull(AppMeasurementDynamiteService.this.zza)).zzaV().zze().zzb("Failed to call IDynamiteUploadBatchesCallback", e);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzaV().zzb().zza("Conditional user property must not be null");
        } else {
            this.zza.zzj().zzaa(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsent(Bundle bundle, long j) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzp(bundle, -20, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zzb();
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), str, str2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, String str, String str2, long j) throws RemoteException {
        zzb();
        this.zza.zzs().zzk(zzdfVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        zzj.zzb();
        zzib zzibVar = zzj.zzu;
        zzj.zzu.zzaW().zzj(new zzjx(zzj, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDefaultEventParameters(Bundle bundle) {
        zzb();
        final zzli zzj = this.zza.zzj();
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzj.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzle
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzli.this.zzag(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzb();
        zzp zzpVar = new zzp(this, zzdaVar);
        if (this.zza.zzaW().zze()) {
            this.zza.zzj().zzV(zzpVar);
        } else {
            this.zza.zzaW().zzj(new zzl(this, zzpVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdc zzdcVar) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzn(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        zzib zzibVar = zzj.zzu;
        zzj.zzu.zzaW().zzj(new zzjz(zzj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSgtmDebugInfo(Intent intent) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        Uri data = intent.getData();
        if (data == null) {
            zzj.zzu.zzaV().zzi().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            zzib zzibVar = zzj.zzu;
            zzibVar.zzaV().zzi().zza("[sgtm] Preview Mode was not enabled.");
            zzibVar.zzc().zzy(null);
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        zzib zzibVar2 = zzj.zzu;
        zzibVar2.zzaV().zzi().zzb("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
        zzibVar2.zzc().zzy(queryParameter2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserId(final String str, long j) throws RemoteException {
        zzb();
        final zzli zzj = this.zza.zzj();
        if (str == null || !TextUtils.isEmpty(str)) {
            zzj.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlf
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzib zzibVar = zzli.this.zzu;
                    if (zzibVar.zzv().zzq(str)) {
                        zzibVar.zzv().zzi();
                    }
                }
            });
            zzj.zzL(null, APEZProvider.FILEID, str, true, j);
            return;
        }
        zzj.zzu.zzaV().zze().zza("User ID must be non-empty or null");
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzL(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzjp zzjpVar;
        zzb();
        Map map = this.zzb;
        synchronized (map) {
            zzjpVar = (zzjp) map.remove(Integer.valueOf(zzdaVar.zzf()));
        }
        if (zzjpVar == null) {
            zzjpVar = new zzq(this, zzdaVar);
        }
        this.zza.zzj().zzX(zzjpVar);
    }
}
