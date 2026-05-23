package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzkt extends zzbl implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.phenotype.internal.IPhenotypeService");
    }

    public final void zze(zzks zzksVar, String str, int i, String[] strArr, byte[] bArr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzksVar);
        zza.writeString(str);
        zza.writeInt(0);
        zza.writeStringArray(strArr);
        zza.writeByteArray(null);
        zzc(1, zza);
    }

    public final void zzf(zzks zzksVar, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzksVar);
        zza.writeString(str);
        zza.writeString("");
        zza.writeString(null);
        zzc(11, zza);
    }

    public final void zzg(zzks zzksVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzksVar);
        zza.writeString(str);
        zzc(5, zza);
    }

    public final void zzh(zzks zzksVar, byte[] bArr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzksVar);
        zza.writeByteArray(bArr);
        zzc(31, zza);
    }

    public final void zzi(zzkq zzkqVar) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzkqVar);
        zzc(27, zza);
    }

    public final void zzj(String str, zzko zzkoVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbn.zzd(zza, zzkoVar);
        zzc(28, zza);
    }
}
