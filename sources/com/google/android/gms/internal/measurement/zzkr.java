package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzkr extends zzbm implements zzks {
    public zzkr() {
        super("com.google.android.gms.phenotype.internal.IPhenotypeCallbacks");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzbn.zzf(parcel);
                zzb((Status) zzbn.zzb(parcel, Status.CREATOR));
                return true;
            case 2:
                zzbn.zzf(parcel);
                zzc((Status) zzbn.zzb(parcel, Status.CREATOR));
                return true;
            case 3:
                zzbn.zzf(parcel);
                zze((Status) zzbn.zzb(parcel, Status.CREATOR));
                return true;
            case 4:
                zzbn.zzf(parcel);
                zzf((Status) zzbn.zzb(parcel, Status.CREATOR), (zzjh) zzbn.zzb(parcel, zzjh.CREATOR));
                return true;
            case 5:
                zzbn.zzf(parcel);
                zzg((Status) zzbn.zzb(parcel, Status.CREATOR));
                return true;
            case 6:
                zzbn.zzf(parcel);
                zzh((Status) zzbn.zzb(parcel, Status.CREATOR), (zzjl) zzbn.zzb(parcel, zzjl.CREATOR));
                return true;
            case 7:
                zzbn.zzf(parcel);
                zzi((Status) zzbn.zzb(parcel, Status.CREATOR), (zzjj) zzbn.zzb(parcel, zzjj.CREATOR));
                return true;
            case 8:
                zzbn.zzf(parcel);
                zzj((Status) zzbn.zzb(parcel, Status.CREATOR));
                return true;
            case 9:
                zzbn.zzf(parcel);
                zzk((Status) zzbn.zzb(parcel, Status.CREATOR), (zzjo) zzbn.zzb(parcel, zzjo.CREATOR));
                return true;
            case 10:
                zzbn.zzf(parcel);
                zzl((Status) zzbn.zzb(parcel, Status.CREATOR), (zzjh) zzbn.zzb(parcel, zzjh.CREATOR));
                return true;
            case 11:
                long readLong = parcel.readLong();
                zzbn.zzf(parcel);
                zzm((Status) zzbn.zzb(parcel, Status.CREATOR), readLong);
                return true;
            case 12:
                zzbn.zzf(parcel);
                zzn((Status) zzbn.zzb(parcel, Status.CREATOR));
                return true;
            case 13:
                zzbn.zzf(parcel);
                zzo((Status) zzbn.zzb(parcel, Status.CREATOR), (zzjs) zzbn.zzb(parcel, zzjs.CREATOR));
                return true;
            case 14:
                zzbn.zzf(parcel);
                zzd((Status) zzbn.zzb(parcel, Status.CREATOR));
                return true;
            case 15:
                zzbn.zzf(parcel);
                zzp((Status) zzbn.zzb(parcel, Status.CREATOR));
                return true;
            case 16:
                long readLong2 = parcel.readLong();
                zzbn.zzf(parcel);
                zzq((Status) zzbn.zzb(parcel, Status.CREATOR), readLong2);
                return true;
            default:
                return false;
        }
    }
}
