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
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzco extends zzbm implements zzcp {
    public zzco() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzcp asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof zzcp ? (zzcp) queryLocalInterface : new zzcn(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcs zzcsVar = null;
        zzcv zzcvVar = null;
        zzcs zzcsVar2 = null;
        zzcs zzcsVar3 = null;
        zzcs zzcsVar4 = null;
        zzcs zzcsVar5 = null;
        zzcy zzcyVar = null;
        zzcy zzcyVar2 = null;
        zzcy zzcyVar3 = null;
        zzcs zzcsVar6 = null;
        zzcs zzcsVar7 = null;
        zzcs zzcsVar8 = null;
        zzcs zzcsVar9 = null;
        zzcs zzcsVar10 = null;
        zzcs zzcsVar11 = null;
        zzda zzdaVar = null;
        zzcs zzcsVar12 = null;
        zzcs zzcsVar13 = null;
        zzcs zzcsVar14 = null;
        zzcs zzcsVar15 = null;
        zzcs zzcsVar16 = null;
        switch (i) {
            case 1:
                long readLong = parcel.readLong();
                zzbn.zzf(parcel);
                initialize(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzdb) zzbn.zzb(parcel, zzdb.CREATOR), readLong);
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
                    zzcsVar = queryLocalInterface instanceof zzcs ? (zzcs) queryLocalInterface : new zzcq(readStrongBinder);
                }
                long readLong3 = parcel.readLong();
                zzbn.zzf(parcel);
                logEventAndBundle(readString, readString2, bundle, zzcsVar, readLong3);
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
                    zzcsVar16 = queryLocalInterface2 instanceof zzcs ? (zzcs) queryLocalInterface2 : new zzcq(readStrongBinder2);
                }
                zzbn.zzf(parcel);
                getUserProperties(readString5, readString6, zza4, zzcsVar16);
                break;
            case 6:
                String readString7 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar15 = queryLocalInterface3 instanceof zzcs ? (zzcs) queryLocalInterface3 : new zzcq(readStrongBinder3);
                }
                zzbn.zzf(parcel);
                getMaxUserProperties(readString7, zzcsVar15);
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
                    zzcsVar14 = queryLocalInterface4 instanceof zzcs ? (zzcs) queryLocalInterface4 : new zzcq(readStrongBinder4);
                }
                zzbn.zzf(parcel);
                getConditionalUserProperties(readString9, readString10, zzcsVar14);
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
                    zzcsVar13 = queryLocalInterface5 instanceof zzcs ? (zzcs) queryLocalInterface5 : new zzcq(readStrongBinder5);
                }
                zzbn.zzf(parcel);
                getCurrentScreenName(zzcsVar13);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar12 = queryLocalInterface6 instanceof zzcs ? (zzcs) queryLocalInterface6 : new zzcq(readStrongBinder6);
                }
                zzbn.zzf(parcel);
                getCurrentScreenClass(zzcsVar12);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzdaVar = queryLocalInterface7 instanceof zzda ? (zzda) queryLocalInterface7 : new zzcz(readStrongBinder7);
                }
                zzbn.zzf(parcel);
                setInstanceIdProvider(zzdaVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar11 = queryLocalInterface8 instanceof zzcs ? (zzcs) queryLocalInterface8 : new zzcq(readStrongBinder8);
                }
                zzbn.zzf(parcel);
                getCachedAppInstanceId(zzcsVar11);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar10 = queryLocalInterface9 instanceof zzcs ? (zzcs) queryLocalInterface9 : new zzcq(readStrongBinder9);
                }
                zzbn.zzf(parcel);
                getAppInstanceId(zzcsVar10);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar9 = queryLocalInterface10 instanceof zzcs ? (zzcs) queryLocalInterface10 : new zzcq(readStrongBinder10);
                }
                zzbn.zzf(parcel);
                getGmpAppId(zzcsVar9);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar8 = queryLocalInterface11 instanceof zzcs ? (zzcs) queryLocalInterface11 : new zzcq(readStrongBinder11);
                }
                zzbn.zzf(parcel);
                generateEventId(zzcsVar8);
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
                    zzcsVar7 = queryLocalInterface12 instanceof zzcs ? (zzcs) queryLocalInterface12 : new zzcq(readStrongBinder12);
                }
                long readLong20 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivitySaveInstanceState(asInterface8, zzcsVar7, readLong20);
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar6 = queryLocalInterface13 instanceof zzcs ? (zzcs) queryLocalInterface13 : new zzcq(readStrongBinder13);
                }
                long readLong21 = parcel.readLong();
                zzbn.zzf(parcel);
                performAction(bundle2, zzcsVar6, readLong21);
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
                    zzcyVar3 = queryLocalInterface14 instanceof zzcy ? (zzcy) queryLocalInterface14 : new zzcw(readStrongBinder14);
                }
                zzbn.zzf(parcel);
                setEventInterceptor(zzcyVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzcyVar2 = queryLocalInterface15 instanceof zzcy ? (zzcy) queryLocalInterface15 : new zzcw(readStrongBinder15);
                }
                zzbn.zzf(parcel);
                registerOnMeasurementEventListener(zzcyVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzcyVar = queryLocalInterface16 instanceof zzcy ? (zzcy) queryLocalInterface16 : new zzcw(readStrongBinder16);
                }
                zzbn.zzf(parcel);
                unregisterOnMeasurementEventListener(zzcyVar);
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
                    zzcsVar5 = queryLocalInterface17 instanceof zzcs ? (zzcs) queryLocalInterface17 : new zzcq(readStrongBinder17);
                }
                int readInt2 = parcel.readInt();
                zzbn.zzf(parcel);
                getTestFlag(zzcsVar5, readInt2);
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
                    zzcsVar4 = queryLocalInterface18 instanceof zzcs ? (zzcs) queryLocalInterface18 : new zzcq(readStrongBinder18);
                }
                zzbn.zzf(parcel);
                isDataCollectionEnabled(zzcsVar4);
                break;
            case 41:
            case 47:
            case 49:
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
                    zzcsVar3 = queryLocalInterface19 instanceof zzcs ? (zzcs) queryLocalInterface19 : new zzcq(readStrongBinder19);
                }
                zzbn.zzf(parcel);
                getSessionId(zzcsVar3);
                break;
            case 48:
                zzbn.zzf(parcel);
                setSgtmDebugInfo((Intent) zzbn.zzb(parcel, Intent.CREATOR));
                break;
            case 50:
                zzdd zzddVar = (zzdd) zzbn.zzb(parcel, zzdd.CREATOR);
                String readString16 = parcel.readString();
                String readString17 = parcel.readString();
                long readLong25 = parcel.readLong();
                zzbn.zzf(parcel);
                setCurrentScreenByScionActivityInfo(zzddVar, readString16, readString17, readLong25);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                long readLong26 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStartedByScionActivityInfo((zzdd) zzbn.zzb(parcel, zzdd.CREATOR), readLong26);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                long readLong27 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStoppedByScionActivityInfo((zzdd) zzbn.zzb(parcel, zzdd.CREATOR), readLong27);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                long readLong28 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityCreatedByScionActivityInfo((zzdd) zzbn.zzb(parcel, zzdd.CREATOR), (Bundle) zzbn.zzb(parcel, Bundle.CREATOR), readLong28);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                long readLong29 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityDestroyedByScionActivityInfo((zzdd) zzbn.zzb(parcel, zzdd.CREATOR), readLong29);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                long readLong30 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityPausedByScionActivityInfo((zzdd) zzbn.zzb(parcel, zzdd.CREATOR), readLong30);
                break;
            case 56:
                long readLong31 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityResumedByScionActivityInfo((zzdd) zzbn.zzb(parcel, zzdd.CREATOR), readLong31);
                break;
            case 57:
                zzdd zzddVar2 = (zzdd) zzbn.zzb(parcel, zzdd.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar2 = queryLocalInterface20 instanceof zzcs ? (zzcs) queryLocalInterface20 : new zzcq(readStrongBinder20);
                }
                long readLong32 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzddVar2, zzcsVar2, readLong32);
                break;
            case 58:
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    zzcvVar = queryLocalInterface21 instanceof zzcv ? (zzcv) queryLocalInterface21 : new zzct(readStrongBinder21);
                }
                zzbn.zzf(parcel);
                retrieveAndUploadBatches(zzcvVar);
                break;
            case 59:
                boolean zza7 = zzbn.zza(parcel);
                boolean zza8 = zzbn.zza(parcel);
                long readLong33 = parcel.readLong();
                long readLong34 = parcel.readLong();
                zzbn.zzf(parcel);
                logEventWithElapsedTime(parcel.readString(), parcel.readString(), (Bundle) zzbn.zzb(parcel, Bundle.CREATOR), zza7, zza8, readLong33, readLong34);
                break;
            case 60:
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzdb zzdbVar = (zzdb) zzbn.zzb(parcel, zzdb.CREATOR);
                long readLong35 = parcel.readLong();
                long readLong36 = parcel.readLong();
                zzbn.zzf(parcel);
                initializeWithElapsedTime(asInterface12, zzdbVar, readLong35, readLong36);
                break;
            case 61:
                long readLong37 = parcel.readLong();
                long readLong38 = parcel.readLong();
                zzbn.zzf(parcel);
                resetAnalyticsDataWithElapsedTime(readLong37, readLong38);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
