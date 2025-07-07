package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzgk extends com.google.android.gms.internal.measurement.zzbn implements zzgl {
    public zzgk() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzgr zzgrVar = null;
        zzgo zzgoVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzp((zzbh) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzbh.CREATOR), (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzB((zzqb) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzqb.CREATOR), (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
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
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzn((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzq((zzbh) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzbh.CREATOR), readString, readString2);
                parcel2.writeNoException();
                break;
            case 6:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzz((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                boolean zzf = com.google.android.gms.internal.measurement.zzbo.zzf(parcel);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzh = zzh((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR), zzf);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzh);
                break;
            case 9:
                String readString3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                byte[] zzD = zzD((zzbh) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzbh.CREATOR), readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zzD);
                break;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzw(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                break;
            case 11:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                String zzf2 = zzf((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzf2);
                break;
            case 12:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzt((zzai) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzai.CREATOR), (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzu((zzai) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzai.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzk = zzk(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzbo.zzf(parcel), (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzk);
                break;
            case 15:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                boolean zzf3 = com.google.android.gms.internal.measurement.zzbo.zzf(parcel);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzl = zzl(readString7, readString8, readString9, zzf3);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzl);
                break;
            case 16:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzi = zzi(parcel.readString(), parcel.readString(), (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzi);
                break;
            case 17:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzj = zzj(readString10, readString11, readString12);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzj);
                break;
            case 18:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzs((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 19:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzx((Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR), (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 20:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzv((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 21:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzap zze = zze((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                if (zze == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    zze.writeToParcel(parcel2, 1);
                }
                break;
            case 24:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzg = zzg((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR), (Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzg);
                break;
            case 25:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzA((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 26:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzy((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 27:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzm((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR));
                parcel2.writeNoException();
                break;
            case 29:
                zzr zzrVar = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                zzpc zzpcVar = (zzpc) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzpc.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    zzgrVar = queryLocalInterface instanceof zzgr ? (zzgr) queryLocalInterface : new zzgp(readStrongBinder);
                }
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzo(zzrVar, zzpcVar, zzgrVar);
                parcel2.writeNoException();
                break;
            case 30:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzC((zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR), (zzag) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzag.CREATOR));
                parcel2.writeNoException();
                break;
            case 31:
                zzr zzrVar2 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    zzgoVar = queryLocalInterface2 instanceof zzgo ? (zzgo) queryLocalInterface2 : new zzgm(readStrongBinder2);
                }
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzr(zzrVar2, bundle, zzgoVar);
                parcel2.writeNoException();
                break;
        }
        return true;
    }
}
