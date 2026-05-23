package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzga extends com.google.android.gms.internal.measurement.zzbm implements zzgb {
    public zzga() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzgh zzghVar = null;
        zzge zzgeVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zze((zzbh) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbh.CREATOR), (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzf((zzpl) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzpl.CREATOR), (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzg((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzh((zzbh) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbh.CREATOR), readString, readString2);
                parcel2.writeNoException();
                break;
            case 6:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzi((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                boolean zza = com.google.android.gms.internal.measurement.zzbn.zza(parcel);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List zzj = zzj((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR), zza);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzj);
                break;
            case 9:
                String readString3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                byte[] zzk = zzk((zzbh) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbh.CREATOR), readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zzk);
                break;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzl(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                break;
            case 11:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                String zzm = zzm((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzm);
                break;
            case 12:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzn((zzah) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzah.CREATOR), (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzo((zzah) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzah.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List zzp = zzp(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzbn.zza(parcel), (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzp);
                break;
            case 15:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                boolean zza2 = com.google.android.gms.internal.measurement.zzbn.zza(parcel);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List zzq = zzq(readString7, readString8, readString9, zza2);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzq);
                break;
            case 16:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List zzr = zzr(parcel.readString(), parcel.readString(), (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzr);
                break;
            case 17:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List zzs = zzs(readString10, readString11, readString12);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzs);
                break;
            case 18:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzt((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 19:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzu((Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR), (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 20:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzv((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 21:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzao zzw = zzw((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                if (zzw == null) {
                    parcel2.writeInt(0);
                    break;
                } else {
                    parcel2.writeInt(1);
                    zzw.writeToParcel(parcel2, 1);
                    break;
                }
            case 24:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List zzx = zzx((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR), (Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzx);
                break;
            case 25:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzy((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 26:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzz((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 27:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzA((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 29:
                zzr zzrVar = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                zzoo zzooVar = (zzoo) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzoo.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    zzghVar = queryLocalInterface instanceof zzgh ? (zzgh) queryLocalInterface : new zzgf(readStrongBinder);
                }
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzB(zzrVar, zzooVar, zzghVar);
                parcel2.writeNoException();
                break;
            case 30:
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzC((zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR), (zzaf) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzaf.CREATOR));
                parcel2.writeNoException();
                break;
            case 31:
                zzr zzrVar2 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    zzgeVar = queryLocalInterface2 instanceof zzge ? (zzge) queryLocalInterface2 : new zzgc(readStrongBinder2);
                }
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzD(zzrVar2, bundle, zzgeVar);
                parcel2.writeNoException();
                break;
        }
        return true;
    }
}
