package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzcq extends zzbm implements zzcr {
    public zzcq() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzcr asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof zzcr ? (zzcr) queryLocalInterface : new zzcp(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcu zzcuVar = null;
        zzcx zzcxVar = null;
        zzcu zzcuVar2 = null;
        zzcu zzcuVar3 = null;
        zzcu zzcuVar4 = null;
        zzcu zzcuVar5 = null;
        zzda zzdaVar = null;
        zzda zzdaVar2 = null;
        zzda zzdaVar3 = null;
        zzcu zzcuVar6 = null;
        zzcu zzcuVar7 = null;
        zzcu zzcuVar8 = null;
        zzcu zzcuVar9 = null;
        zzcu zzcuVar10 = null;
        zzcu zzcuVar11 = null;
        zzdc zzdcVar = null;
        zzcu zzcuVar12 = null;
        zzcu zzcuVar13 = null;
        zzcu zzcuVar14 = null;
        zzcu zzcuVar15 = null;
        zzcu zzcuVar16 = null;
        switch (i) {
            case 1:
                long readLong = parcel.readLong();
                zzbn.zzf(parcel);
                initialize(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzdd) zzbn.zzb(parcel, zzdd.CREATOR), readLong);
                break;
            case 2:
                boolean zza = zzbn.zza(parcel);
                boolean zza2 = zzbn.zza(parcel);
                long readLong2 = parcel.readLong();
                zzbn.zzf(parcel);
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzbn.zzb(parcel, Bundle.CREATOR), zza, zza2, readLong2);
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar = queryLocalInterface instanceof zzcu ? (zzcu) queryLocalInterface : new zzcs(readStrongBinder);
                }
                long readLong3 = parcel.readLong();
                zzbn.zzf(parcel);
                logEventAndBundle(readString, readString2, bundle, zzcuVar, readLong3);
                break;
            case 4:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zza3 = zzbn.zza(parcel);
                long readLong4 = parcel.readLong();
                zzbn.zzf(parcel);
                setUserProperty(readString3, readString4, asInterface, zza3, readLong4);
                break;
            case 5:
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                boolean zza4 = zzbn.zza(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar16 = queryLocalInterface2 instanceof zzcu ? (zzcu) queryLocalInterface2 : new zzcs(readStrongBinder2);
                }
                zzbn.zzf(parcel);
                getUserProperties(readString5, readString6, zza4, zzcuVar16);
                break;
            case 6:
                String readString7 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar15 = queryLocalInterface3 instanceof zzcu ? (zzcu) queryLocalInterface3 : new zzcs(readStrongBinder3);
                }
                zzbn.zzf(parcel);
                getMaxUserProperties(readString7, zzcuVar15);
                break;
            case 7:
                String readString8 = parcel.readString();
                long readLong5 = parcel.readLong();
                zzbn.zzf(parcel);
                setUserId(readString8, readLong5);
                break;
            case 8:
                long readLong6 = parcel.readLong();
                zzbn.zzf(parcel);
                setConditionalUserProperty((Bundle) zzbn.zzb(parcel, Bundle.CREATOR), readLong6);
                break;
            case 9:
                zzbn.zzf(parcel);
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzbn.zzb(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar14 = queryLocalInterface4 instanceof zzcu ? (zzcu) queryLocalInterface4 : new zzcs(readStrongBinder4);
                }
                zzbn.zzf(parcel);
                getConditionalUserProperties(readString9, readString10, zzcuVar14);
                break;
            case 11:
                boolean zza5 = zzbn.zza(parcel);
                long readLong7 = parcel.readLong();
                zzbn.zzf(parcel);
                setMeasurementEnabled(zza5, readLong7);
                break;
            case 12:
                long readLong8 = parcel.readLong();
                zzbn.zzf(parcel);
                resetAnalyticsData(readLong8);
                break;
            case 13:
                long readLong9 = parcel.readLong();
                zzbn.zzf(parcel);
                setMinimumSessionDuration(readLong9);
                break;
            case 14:
                long readLong10 = parcel.readLong();
                zzbn.zzf(parcel);
                setSessionTimeoutDuration(readLong10);
                break;
            case 15:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                long readLong11 = parcel.readLong();
                zzbn.zzf(parcel);
                setCurrentScreen(asInterface2, readString11, readString12, readLong11);
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar13 = queryLocalInterface5 instanceof zzcu ? (zzcu) queryLocalInterface5 : new zzcs(readStrongBinder5);
                }
                zzbn.zzf(parcel);
                getCurrentScreenName(zzcuVar13);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar12 = queryLocalInterface6 instanceof zzcu ? (zzcu) queryLocalInterface6 : new zzcs(readStrongBinder6);
                }
                zzbn.zzf(parcel);
                getCurrentScreenClass(zzcuVar12);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzdcVar = queryLocalInterface7 instanceof zzdc ? (zzdc) queryLocalInterface7 : new zzdb(readStrongBinder7);
                }
                zzbn.zzf(parcel);
                setInstanceIdProvider(zzdcVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar11 = queryLocalInterface8 instanceof zzcu ? (zzcu) queryLocalInterface8 : new zzcs(readStrongBinder8);
                }
                zzbn.zzf(parcel);
                getCachedAppInstanceId(zzcuVar11);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar10 = queryLocalInterface9 instanceof zzcu ? (zzcu) queryLocalInterface9 : new zzcs(readStrongBinder9);
                }
                zzbn.zzf(parcel);
                getAppInstanceId(zzcuVar10);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar9 = queryLocalInterface10 instanceof zzcu ? (zzcu) queryLocalInterface10 : new zzcs(readStrongBinder10);
                }
                zzbn.zzf(parcel);
                getGmpAppId(zzcuVar9);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar8 = queryLocalInterface11 instanceof zzcu ? (zzcu) queryLocalInterface11 : new zzcs(readStrongBinder11);
                }
                zzbn.zzf(parcel);
                generateEventId(zzcuVar8);
                break;
            case 23:
                String readString13 = parcel.readString();
                long readLong12 = parcel.readLong();
                zzbn.zzf(parcel);
                beginAdUnitExposure(readString13, readLong12);
                break;
            case 24:
                String readString14 = parcel.readString();
                long readLong13 = parcel.readLong();
                zzbn.zzf(parcel);
                endAdUnitExposure(readString14, readLong13);
                break;
            case 25:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong14 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStarted(asInterface3, readLong14);
                break;
            case 26:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong15 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStopped(asInterface4, readLong15);
                break;
            case 27:
                long readLong16 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityCreated(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (Bundle) zzbn.zzb(parcel, Bundle.CREATOR), readLong16);
                break;
            case 28:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong17 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityDestroyed(asInterface5, readLong17);
                break;
            case 29:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong18 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityPaused(asInterface6, readLong18);
                break;
            case 30:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong19 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityResumed(asInterface7, readLong19);
                break;
            case 31:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar7 = queryLocalInterface12 instanceof zzcu ? (zzcu) queryLocalInterface12 : new zzcs(readStrongBinder12);
                }
                long readLong20 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivitySaveInstanceState(asInterface8, zzcuVar7, readLong20);
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar6 = queryLocalInterface13 instanceof zzcu ? (zzcu) queryLocalInterface13 : new zzcs(readStrongBinder13);
                }
                long readLong21 = parcel.readLong();
                zzbn.zzf(parcel);
                performAction(bundle2, zzcuVar6, readLong21);
                break;
            case 33:
                int readInt = parcel.readInt();
                String readString15 = parcel.readString();
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbn.zzf(parcel);
                logHealthData(readInt, readString15, asInterface9, asInterface10, asInterface11);
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdaVar3 = queryLocalInterface14 instanceof zzda ? (zzda) queryLocalInterface14 : new zzcy(readStrongBinder14);
                }
                zzbn.zzf(parcel);
                setEventInterceptor(zzdaVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdaVar2 = queryLocalInterface15 instanceof zzda ? (zzda) queryLocalInterface15 : new zzcy(readStrongBinder15);
                }
                zzbn.zzf(parcel);
                registerOnMeasurementEventListener(zzdaVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdaVar = queryLocalInterface16 instanceof zzda ? (zzda) queryLocalInterface16 : new zzcy(readStrongBinder16);
                }
                zzbn.zzf(parcel);
                unregisterOnMeasurementEventListener(zzdaVar);
                break;
            case 37:
                HashMap zze = zzbn.zze(parcel);
                zzbn.zzf(parcel);
                initForTests(zze);
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar5 = queryLocalInterface17 instanceof zzcu ? (zzcu) queryLocalInterface17 : new zzcs(readStrongBinder17);
                }
                int readInt2 = parcel.readInt();
                zzbn.zzf(parcel);
                getTestFlag(zzcuVar5, readInt2);
                break;
            case 39:
                boolean zza6 = zzbn.zza(parcel);
                zzbn.zzf(parcel);
                setDataCollectionEnabled(zza6);
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar4 = queryLocalInterface18 instanceof zzcu ? (zzcu) queryLocalInterface18 : new zzcs(readStrongBinder18);
                }
                zzbn.zzf(parcel);
                isDataCollectionEnabled(zzcuVar4);
                break;
            case 41:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            default:
                return false;
            case 42:
                zzbn.zzf(parcel);
                setDefaultEventParameters((Bundle) zzbn.zzb(parcel, Bundle.CREATOR));
                break;
            case 43:
                long readLong22 = parcel.readLong();
                zzbn.zzf(parcel);
                clearMeasurementEnabled(readLong22);
                break;
            case 44:
                long readLong23 = parcel.readLong();
                zzbn.zzf(parcel);
                setConsent((Bundle) zzbn.zzb(parcel, Bundle.CREATOR), readLong23);
                break;
            case 45:
                long readLong24 = parcel.readLong();
                zzbn.zzf(parcel);
                setConsentThirdParty((Bundle) zzbn.zzb(parcel, Bundle.CREATOR), readLong24);
                break;
            case 46:
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar3 = queryLocalInterface19 instanceof zzcu ? (zzcu) queryLocalInterface19 : new zzcs(readStrongBinder19);
                }
                zzbn.zzf(parcel);
                getSessionId(zzcuVar3);
                break;
            case 48:
                zzbn.zzf(parcel);
                setSgtmDebugInfo((Intent) zzbn.zzb(parcel, Intent.CREATOR));
                break;
            case 50:
                zzdf zzdfVar = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                String readString16 = parcel.readString();
                String readString17 = parcel.readString();
                long readLong25 = parcel.readLong();
                zzbn.zzf(parcel);
                setCurrentScreenByScionActivityInfo(zzdfVar, readString16, readString17, readLong25);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                long readLong26 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStartedByScionActivityInfo((zzdf) zzbn.zzb(parcel, zzdf.CREATOR), readLong26);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                long readLong27 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStoppedByScionActivityInfo((zzdf) zzbn.zzb(parcel, zzdf.CREATOR), readLong27);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                long readLong28 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityCreatedByScionActivityInfo((zzdf) zzbn.zzb(parcel, zzdf.CREATOR), (Bundle) zzbn.zzb(parcel, Bundle.CREATOR), readLong28);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                long readLong29 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityDestroyedByScionActivityInfo((zzdf) zzbn.zzb(parcel, zzdf.CREATOR), readLong29);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                long readLong30 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityPausedByScionActivityInfo((zzdf) zzbn.zzb(parcel, zzdf.CREATOR), readLong30);
                break;
            case 56:
                long readLong31 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityResumedByScionActivityInfo((zzdf) zzbn.zzb(parcel, zzdf.CREATOR), readLong31);
                break;
            case 57:
                zzdf zzdfVar2 = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcuVar2 = queryLocalInterface20 instanceof zzcu ? (zzcu) queryLocalInterface20 : new zzcs(readStrongBinder20);
                }
                long readLong32 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzdfVar2, zzcuVar2, readLong32);
                break;
            case 58:
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    zzcxVar = queryLocalInterface21 instanceof zzcx ? (zzcx) queryLocalInterface21 : new zzcv(readStrongBinder21);
                }
                zzbn.zzf(parcel);
                retrieveAndUploadBatches(zzcxVar);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
