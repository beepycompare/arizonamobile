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
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzcu extends zzbn implements zzcv {
    public zzcu() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzcv asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof zzcv ? (zzcv) queryLocalInterface : new zzct(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcy zzcyVar = null;
        zzdb zzdbVar = null;
        zzcy zzcyVar2 = null;
        zzcy zzcyVar3 = null;
        zzcy zzcyVar4 = null;
        zzcy zzcyVar5 = null;
        zzde zzdeVar = null;
        zzde zzdeVar2 = null;
        zzde zzdeVar3 = null;
        zzcy zzcyVar6 = null;
        zzcy zzcyVar7 = null;
        zzcy zzcyVar8 = null;
        zzcy zzcyVar9 = null;
        zzcy zzcyVar10 = null;
        zzcy zzcyVar11 = null;
        zzdg zzdgVar = null;
        zzcy zzcyVar12 = null;
        zzcy zzcyVar13 = null;
        zzcy zzcyVar14 = null;
        zzcy zzcyVar15 = null;
        zzcy zzcyVar16 = null;
        switch (i) {
            case 1:
                long readLong = parcel.readLong();
                zzbo.zzc(parcel);
                initialize(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzdh) zzbo.zza(parcel, zzdh.CREATOR), readLong);
                break;
            case 2:
                boolean zzf = zzbo.zzf(parcel);
                boolean zzf2 = zzbo.zzf(parcel);
                long readLong2 = parcel.readLong();
                zzbo.zzc(parcel);
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzbo.zza(parcel, Bundle.CREATOR), zzf, zzf2, readLong2);
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar = queryLocalInterface instanceof zzcy ? (zzcy) queryLocalInterface : new zzcw(readStrongBinder);
                }
                long readLong3 = parcel.readLong();
                zzbo.zzc(parcel);
                logEventAndBundle(readString, readString2, bundle, zzcyVar, readLong3);
                break;
            case 4:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zzf3 = zzbo.zzf(parcel);
                long readLong4 = parcel.readLong();
                zzbo.zzc(parcel);
                setUserProperty(readString3, readString4, asInterface, zzf3, readLong4);
                break;
            case 5:
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                boolean zzf4 = zzbo.zzf(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar16 = queryLocalInterface2 instanceof zzcy ? (zzcy) queryLocalInterface2 : new zzcw(readStrongBinder2);
                }
                zzbo.zzc(parcel);
                getUserProperties(readString5, readString6, zzf4, zzcyVar16);
                break;
            case 6:
                String readString7 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar15 = queryLocalInterface3 instanceof zzcy ? (zzcy) queryLocalInterface3 : new zzcw(readStrongBinder3);
                }
                zzbo.zzc(parcel);
                getMaxUserProperties(readString7, zzcyVar15);
                break;
            case 7:
                String readString8 = parcel.readString();
                long readLong5 = parcel.readLong();
                zzbo.zzc(parcel);
                setUserId(readString8, readLong5);
                break;
            case 8:
                long readLong6 = parcel.readLong();
                zzbo.zzc(parcel);
                setConditionalUserProperty((Bundle) zzbo.zza(parcel, Bundle.CREATOR), readLong6);
                break;
            case 9:
                zzbo.zzc(parcel);
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzbo.zza(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar14 = queryLocalInterface4 instanceof zzcy ? (zzcy) queryLocalInterface4 : new zzcw(readStrongBinder4);
                }
                zzbo.zzc(parcel);
                getConditionalUserProperties(readString9, readString10, zzcyVar14);
                break;
            case 11:
                boolean zzf5 = zzbo.zzf(parcel);
                long readLong7 = parcel.readLong();
                zzbo.zzc(parcel);
                setMeasurementEnabled(zzf5, readLong7);
                break;
            case 12:
                long readLong8 = parcel.readLong();
                zzbo.zzc(parcel);
                resetAnalyticsData(readLong8);
                break;
            case 13:
                long readLong9 = parcel.readLong();
                zzbo.zzc(parcel);
                setMinimumSessionDuration(readLong9);
                break;
            case 14:
                long readLong10 = parcel.readLong();
                zzbo.zzc(parcel);
                setSessionTimeoutDuration(readLong10);
                break;
            case 15:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                long readLong11 = parcel.readLong();
                zzbo.zzc(parcel);
                setCurrentScreen(asInterface2, readString11, readString12, readLong11);
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar13 = queryLocalInterface5 instanceof zzcy ? (zzcy) queryLocalInterface5 : new zzcw(readStrongBinder5);
                }
                zzbo.zzc(parcel);
                getCurrentScreenName(zzcyVar13);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar12 = queryLocalInterface6 instanceof zzcy ? (zzcy) queryLocalInterface6 : new zzcw(readStrongBinder6);
                }
                zzbo.zzc(parcel);
                getCurrentScreenClass(zzcyVar12);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzdgVar = queryLocalInterface7 instanceof zzdg ? (zzdg) queryLocalInterface7 : new zzdf(readStrongBinder7);
                }
                zzbo.zzc(parcel);
                setInstanceIdProvider(zzdgVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar11 = queryLocalInterface8 instanceof zzcy ? (zzcy) queryLocalInterface8 : new zzcw(readStrongBinder8);
                }
                zzbo.zzc(parcel);
                getCachedAppInstanceId(zzcyVar11);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar10 = queryLocalInterface9 instanceof zzcy ? (zzcy) queryLocalInterface9 : new zzcw(readStrongBinder9);
                }
                zzbo.zzc(parcel);
                getAppInstanceId(zzcyVar10);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar9 = queryLocalInterface10 instanceof zzcy ? (zzcy) queryLocalInterface10 : new zzcw(readStrongBinder10);
                }
                zzbo.zzc(parcel);
                getGmpAppId(zzcyVar9);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar8 = queryLocalInterface11 instanceof zzcy ? (zzcy) queryLocalInterface11 : new zzcw(readStrongBinder11);
                }
                zzbo.zzc(parcel);
                generateEventId(zzcyVar8);
                break;
            case 23:
                String readString13 = parcel.readString();
                long readLong12 = parcel.readLong();
                zzbo.zzc(parcel);
                beginAdUnitExposure(readString13, readLong12);
                break;
            case 24:
                String readString14 = parcel.readString();
                long readLong13 = parcel.readLong();
                zzbo.zzc(parcel);
                endAdUnitExposure(readString14, readLong13);
                break;
            case 25:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong14 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityStarted(asInterface3, readLong14);
                break;
            case 26:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong15 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityStopped(asInterface4, readLong15);
                break;
            case 27:
                long readLong16 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityCreated(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (Bundle) zzbo.zza(parcel, Bundle.CREATOR), readLong16);
                break;
            case 28:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong17 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityDestroyed(asInterface5, readLong17);
                break;
            case 29:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong18 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityPaused(asInterface6, readLong18);
                break;
            case 30:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong19 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityResumed(asInterface7, readLong19);
                break;
            case 31:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar7 = queryLocalInterface12 instanceof zzcy ? (zzcy) queryLocalInterface12 : new zzcw(readStrongBinder12);
                }
                long readLong20 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivitySaveInstanceState(asInterface8, zzcyVar7, readLong20);
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar6 = queryLocalInterface13 instanceof zzcy ? (zzcy) queryLocalInterface13 : new zzcw(readStrongBinder13);
                }
                long readLong21 = parcel.readLong();
                zzbo.zzc(parcel);
                performAction(bundle2, zzcyVar6, readLong21);
                break;
            case 33:
                int readInt = parcel.readInt();
                String readString15 = parcel.readString();
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbo.zzc(parcel);
                logHealthData(readInt, readString15, asInterface9, asInterface10, asInterface11);
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdeVar3 = queryLocalInterface14 instanceof zzde ? (zzde) queryLocalInterface14 : new zzdc(readStrongBinder14);
                }
                zzbo.zzc(parcel);
                setEventInterceptor(zzdeVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdeVar2 = queryLocalInterface15 instanceof zzde ? (zzde) queryLocalInterface15 : new zzdc(readStrongBinder15);
                }
                zzbo.zzc(parcel);
                registerOnMeasurementEventListener(zzdeVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdeVar = queryLocalInterface16 instanceof zzde ? (zzde) queryLocalInterface16 : new zzdc(readStrongBinder16);
                }
                zzbo.zzc(parcel);
                unregisterOnMeasurementEventListener(zzdeVar);
                break;
            case 37:
                HashMap zzb = zzbo.zzb(parcel);
                zzbo.zzc(parcel);
                initForTests(zzb);
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar5 = queryLocalInterface17 instanceof zzcy ? (zzcy) queryLocalInterface17 : new zzcw(readStrongBinder17);
                }
                int readInt2 = parcel.readInt();
                zzbo.zzc(parcel);
                getTestFlag(zzcyVar5, readInt2);
                break;
            case 39:
                boolean zzf6 = zzbo.zzf(parcel);
                zzbo.zzc(parcel);
                setDataCollectionEnabled(zzf6);
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar4 = queryLocalInterface18 instanceof zzcy ? (zzcy) queryLocalInterface18 : new zzcw(readStrongBinder18);
                }
                zzbo.zzc(parcel);
                isDataCollectionEnabled(zzcyVar4);
                break;
            case 41:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            default:
                return false;
            case 42:
                zzbo.zzc(parcel);
                setDefaultEventParameters((Bundle) zzbo.zza(parcel, Bundle.CREATOR));
                break;
            case 43:
                long readLong22 = parcel.readLong();
                zzbo.zzc(parcel);
                clearMeasurementEnabled(readLong22);
                break;
            case 44:
                long readLong23 = parcel.readLong();
                zzbo.zzc(parcel);
                setConsent((Bundle) zzbo.zza(parcel, Bundle.CREATOR), readLong23);
                break;
            case 45:
                long readLong24 = parcel.readLong();
                zzbo.zzc(parcel);
                setConsentThirdParty((Bundle) zzbo.zza(parcel, Bundle.CREATOR), readLong24);
                break;
            case 46:
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar3 = queryLocalInterface19 instanceof zzcy ? (zzcy) queryLocalInterface19 : new zzcw(readStrongBinder19);
                }
                zzbo.zzc(parcel);
                getSessionId(zzcyVar3);
                break;
            case 48:
                zzbo.zzc(parcel);
                setSgtmDebugInfo((Intent) zzbo.zza(parcel, Intent.CREATOR));
                break;
            case 50:
                zzdj zzdjVar = (zzdj) zzbo.zza(parcel, zzdj.CREATOR);
                String readString16 = parcel.readString();
                String readString17 = parcel.readString();
                long readLong25 = parcel.readLong();
                zzbo.zzc(parcel);
                setCurrentScreenByScionActivityInfo(zzdjVar, readString16, readString17, readLong25);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                long readLong26 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityStartedByScionActivityInfo((zzdj) zzbo.zza(parcel, zzdj.CREATOR), readLong26);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                long readLong27 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityStoppedByScionActivityInfo((zzdj) zzbo.zza(parcel, zzdj.CREATOR), readLong27);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                long readLong28 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityCreatedByScionActivityInfo((zzdj) zzbo.zza(parcel, zzdj.CREATOR), (Bundle) zzbo.zza(parcel, Bundle.CREATOR), readLong28);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                long readLong29 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityDestroyedByScionActivityInfo((zzdj) zzbo.zza(parcel, zzdj.CREATOR), readLong29);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                long readLong30 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityPausedByScionActivityInfo((zzdj) zzbo.zza(parcel, zzdj.CREATOR), readLong30);
                break;
            case 56:
                long readLong31 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityResumedByScionActivityInfo((zzdj) zzbo.zza(parcel, zzdj.CREATOR), readLong31);
                break;
            case 57:
                zzdj zzdjVar2 = (zzdj) zzbo.zza(parcel, zzdj.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcyVar2 = queryLocalInterface20 instanceof zzcy ? (zzcy) queryLocalInterface20 : new zzcw(readStrongBinder20);
                }
                long readLong32 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzdjVar2, zzcyVar2, readLong32);
                break;
            case 58:
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    zzdbVar = queryLocalInterface21 instanceof zzdb ? (zzdb) queryLocalInterface21 : new zzcz(readStrongBinder21);
                }
                zzbo.zzc(parcel);
                retrieveAndUploadBatches(zzdbVar);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
