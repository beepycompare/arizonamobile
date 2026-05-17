package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.PlaybackException;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzan extends zzas implements zzap {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final int zza(int i, String str, String str2) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(3);
        zzt.writeString(str);
        zzt.writeString(str2);
        Parcel zzu = zzu(5, zzt);
        int readInt = zzu.readInt();
        zzu.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final int zzb(int i, String str, String str2) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(i);
        zzt.writeString(str);
        zzt.writeString(str2);
        Parcel zzu = zzu(1, zzt);
        int readInt = zzu.readInt();
        zzu.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final int zzc(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(i);
        zzt.writeString(str);
        zzt.writeString(str2);
        zzau.zzb(zzt, bundle);
        Parcel zzu = zzu(10, zzt);
        int readInt = zzu.readInt();
        zzu.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzd(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(9);
        zzt.writeString(str);
        zzt.writeString(str2);
        zzau.zzb(zzt, bundle);
        Parcel zzu = zzu(TypedValues.Custom.TYPE_COLOR, zzt);
        Bundle bundle2 = (Bundle) zzau.zza(zzu, Bundle.CREATOR);
        zzu.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zze(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(9);
        zzt.writeString(str);
        zzt.writeString(str2);
        zzau.zzb(zzt, bundle);
        Parcel zzu = zzu(12, zzt);
        Bundle bundle2 = (Bundle) zzau.zza(zzu, Bundle.CREATOR);
        zzu.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzf(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(3);
        zzt.writeString(str);
        zzt.writeString(str2);
        zzt.writeString(str3);
        zzt.writeString(null);
        Parcel zzu = zzu(3, zzt);
        Bundle bundle = (Bundle) zzau.zza(zzu, Bundle.CREATOR);
        zzu.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(i);
        zzt.writeString(str);
        zzt.writeString(str2);
        zzt.writeString(str3);
        zzt.writeString(null);
        zzau.zzb(zzt, bundle);
        Parcel zzu = zzu(8, zzt);
        Bundle bundle2 = (Bundle) zzau.zza(zzu, Bundle.CREATOR);
        zzu.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzh(int i, String str, String str2, String str3) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(3);
        zzt.writeString(str);
        zzt.writeString(str2);
        zzt.writeString(str3);
        Parcel zzu = zzu(4, zzt);
        Bundle bundle = (Bundle) zzau.zza(zzu, Bundle.CREATOR);
        zzu.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzi(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(i);
        zzt.writeString(str);
        zzt.writeString(str2);
        zzt.writeString(str3);
        zzau.zzb(zzt, bundle);
        Parcel zzu = zzu(11, zzt);
        Bundle bundle2 = (Bundle) zzau.zza(zzu, Bundle.CREATOR);
        zzu.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzj(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(i);
        zzt.writeString(str);
        zzt.writeString(str2);
        zzau.zzb(zzt, bundle);
        zzau.zzb(zzt, bundle2);
        Parcel zzu = zzu(TypedValues.Custom.TYPE_FLOAT, zzt);
        Bundle bundle3 = (Bundle) zzau.zza(zzu, Bundle.CREATOR);
        zzu.recycle();
        return bundle3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzk(int i, String str, Bundle bundle, zzx zzxVar) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(21);
        zzt.writeString(str);
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzxVar);
        zzw(1501, zzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzl(int i, String str, Bundle bundle, zzz zzzVar) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(22);
        zzt.writeString(str);
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzzVar);
        zzw(1801, zzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzm(Bundle bundle, zzac zzacVar) throws RemoteException {
        Parcel zzt = zzt();
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzacVar);
        zzw(PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, zzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzn(int i, String str, Bundle bundle, zzae zzaeVar) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(21);
        zzt.writeString(str);
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzaeVar);
        zzw(1601, zzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzo(int i, String str, Bundle bundle, zzag zzagVar) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(18);
        zzt.writeString(str);
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzagVar);
        zzv(1301, zzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzp(int i, String str, Bundle bundle, zzai zzaiVar) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(i);
        zzt.writeString(str);
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzaiVar);
        zzw(1901, zzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzq(int i, String str, Bundle bundle, zzak zzakVar) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(21);
        zzt.writeString(str);
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzakVar);
        zzw(1401, zzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzr(int i, String str, Bundle bundle, zzam zzamVar) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(24);
        zzt.writeString(str);
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzamVar);
        zzw(1701, zzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzs(int i, String str, Bundle bundle, zzar zzarVar) throws RemoteException {
        Parcel zzt = zzt();
        zzt.writeInt(12);
        zzt.writeString(str);
        zzau.zzb(zzt, bundle);
        zzau.zzc(zzt, zzarVar);
        zzv(1201, zzt);
    }
}
