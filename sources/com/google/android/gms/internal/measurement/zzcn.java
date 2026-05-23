package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzcn extends zzbl implements zzcp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(23, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzc(zza, bundle);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(24, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void generateEventId(zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcsVar);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getAppInstanceId(zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcsVar);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getCachedAppInstanceId(zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcsVar);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getConditionalUserProperties(String str, String str2, zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzd(zza, zzcsVar);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getCurrentScreenClass(zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcsVar);
        zzc(17, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getCurrentScreenName(zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcsVar);
        zzc(16, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getGmpAppId(zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcsVar);
        zzc(21, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getMaxUserProperties(String str, zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbn.zzd(zza, zzcsVar);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getSessionId(zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcsVar);
        zzc(46, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getTestFlag(zzcs zzcsVar, int i) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcsVar);
        zza.writeInt(i);
        zzc(38, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getUserProperties(String str, String str2, boolean z, zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        int i = zzbn.zza;
        zza.writeInt(z ? 1 : 0);
        zzbn.zzd(zza, zzcsVar);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void initialize(IObjectWrapper iObjectWrapper, zzdb zzdbVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, iObjectWrapper);
        zzbn.zzc(zza, zzdbVar);
        zza.writeLong(j);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void initializeWithElapsedTime(IObjectWrapper iObjectWrapper, zzdb zzdbVar, long j, long j2) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, iObjectWrapper);
        zzbn.zzc(zza, zzdbVar);
        zza.writeLong(j);
        zza.writeLong(j2);
        zzc(60, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void isDataCollectionEnabled(zzcs zzcsVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcs zzcsVar, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void logEventWithElapsedTime(String str, String str2, Bundle bundle, boolean z, boolean z2, long j, long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzc(zza, bundle);
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(z2 ? 1 : 0);
        zza.writeLong(j);
        zza.writeLong(j2);
        zzc(59, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzbn.zzd(zza, iObjectWrapper);
        zzbn.zzd(zza, iObjectWrapper2);
        zzbn.zzd(zza, iObjectWrapper3);
        zzc(33, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityCreatedByScionActivityInfo(zzdd zzddVar, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzddVar);
        zzbn.zzc(zza, bundle);
        zza.writeLong(j);
        zzc(53, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityDestroyedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzddVar);
        zza.writeLong(j);
        zzc(54, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityPausedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzddVar);
        zza.writeLong(j);
        zzc(55, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityResumedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzddVar);
        zza.writeLong(j);
        zzc(56, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcs zzcsVar, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdd zzddVar, zzcs zzcsVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzddVar);
        zzbn.zzd(zza, zzcsVar);
        zza.writeLong(j);
        zzc(57, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityStartedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzddVar);
        zza.writeLong(j);
        zzc(51, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityStoppedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzddVar);
        zza.writeLong(j);
        zzc(52, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void performAction(Bundle bundle, zzcs zzcsVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zzbn.zzd(zza, zzcsVar);
        zza.writeLong(j);
        zzc(32, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void registerOnMeasurementEventListener(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcyVar);
        zzc(35, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void resetAnalyticsDataWithElapsedTime(long j, long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zza.writeLong(j2);
        zzc(61, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void retrieveAndUploadBatches(zzcv zzcvVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcvVar);
        zzc(58, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zza.writeLong(j);
        zzc(8, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zza.writeLong(j);
        zzc(45, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setCurrentScreenByScionActivityInfo(zzdd zzddVar, String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzddVar);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzc(50, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzbn.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(39, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zzc(42, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setEventInterceptor(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcyVar);
        zzc(34, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setInstanceIdProvider(zzda zzdaVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        int i = zzbn.zza;
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(14, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setSgtmDebugInfo(Intent intent) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, intent);
        zzc(48, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzd(zza, iObjectWrapper);
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void unregisterOnMeasurementEventListener(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcyVar);
        zzc(36, zza);
    }
}
