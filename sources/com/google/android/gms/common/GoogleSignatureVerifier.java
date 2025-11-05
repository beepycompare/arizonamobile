package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.common.zzah;
import com.google.android.gms.internal.common.zzal;
import java.util.Arrays;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
/* loaded from: classes4.dex */
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    @Nullable
    private static volatile Set zzd;
    @Nullable
    private static volatile Set zze;
    private final Context zzb;
    private volatile String zzc;

    public GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzo.zza(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c4, code lost:
        r5 = r9;
     */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean zza(PackageInfo packageInfo, boolean z) {
        zzah zzahVar;
        zzah zzj;
        if (packageInfo == null) {
            return false;
        }
        if (z && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) ? false : true;
        }
        try {
            if (z) {
                zzahVar = zzn.zzc;
            } else {
                zzahVar = zzn.zzb;
            }
            int i = AndroidUtilsLight.zza;
            if (Build.VERSION.SDK_INT >= 28) {
                com.google.android.gms.internal.common.zzr.zza(Build.VERSION.SDK_INT >= 28);
                SigningInfo signingInfo = packageInfo.signingInfo;
                if (signingInfo != null && !signingInfo.hasMultipleSigners() && signingInfo.getSigningCertificateHistory() != null) {
                    int i2 = zzah.zzd;
                    com.google.android.gms.internal.common.zzad zzadVar = new com.google.android.gms.internal.common.zzad();
                    for (Signature signature : signingInfo.getSigningCertificateHistory()) {
                        zzadVar.zzb(signature.toByteArray());
                    }
                    zzj = zzadVar.zzd();
                }
                zzj = zzah.zzj();
            } else {
                byte[] bArr = null;
                if (packageInfo.signatures != null && packageInfo.signatures.length == 1) {
                    bArr = packageInfo.signatures[0].toByteArray();
                }
                zzj = bArr != null ? zzah.zzk(bArr) : zzah.zzj();
            }
            if (!zzj.isEmpty()) {
                zzah zzh = zzj.zzh();
                int size = zzh.size();
                int i3 = 0;
                while (i3 < size) {
                    byte[] bArr2 = (byte[]) zzh.get(i3);
                    zzal listIterator = zzahVar.listIterator(0);
                    while (true) {
                        int i4 = i3 + 1;
                        if (listIterator.hasNext()) {
                            if (Arrays.equals(bArr2, (byte[]) listIterator.next())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            throw new IllegalArgumentException("Unable to obtain package certificate history.");
        } catch (IllegalArgumentException unused) {
            Log.i("GoogleSignatureVerifier", "package info is not set correctly");
            return (z ? zzc(packageInfo, zzn.zza) : zzc(packageInfo, zzn.zza[0])) != null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c1  */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.os.StrictMode$ThreadPolicy] */
    /* JADX WARN: Type inference failed for: r8v6, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzy zzb(@Nullable String str, boolean z, boolean z2) {
        zzy zzc;
        if (str == null) {
            return zzy.zzc("null pkg");
        }
        if (!str.equals(this.zzc)) {
            int i = zzo.zzh;
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                try {
                    zzo.zzb();
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            } catch (RemoteException | DynamiteModule.LoadingException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
            try {
                if (zzo.zzg.zzg()) {
                    zzv zzvVar = new zzv(null);
                    zzvVar.zza(str);
                    zzvVar.zzb(GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb));
                    zzvVar.zzc(true);
                    zzc = zzo.zzc(zzvVar.zzd());
                    if (zzc.zza) {
                        this.zzc = str;
                    }
                    return zzc;
                }
                PackageInfo packageInfo = this.zzb.getPackageManager().getPackageInfo(str, allowThreadDiskReads >= 28 ? 134217792 : 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
                if (packageInfo == null) {
                    zzc = zzy.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzc = zzy.zzc("single cert required");
                } else {
                    zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzy zzd2 = zzo.zzd(str2, zzkVar, honorsDebugCertificates, false);
                    zzc = (!zzd2.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzo.zzd(str2, zzkVar, false, true).zza) ? zzd2 : zzy.zzc("debuggable release cert app rejected");
                }
                if (zzc.zza) {
                }
                return zzc;
            } catch (PackageManager.NameNotFoundException e2) {
                return zzy.zzd("no pkg ".concat(str), e2);
            }
            allowThreadDiskReads = Build.VERSION.SDK_INT;
        } else {
            return zzy.zzb();
        }
    }

    @Nullable
    private static zzj zzc(PackageInfo packageInfo, zzj... zzjVarArr) {
        if (packageInfo.signatures != null) {
            if (packageInfo.signatures.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjVarArr.length; i++) {
                if (zzjVarArr[i].equals(zzkVar)) {
                    return zzjVarArr[i];
                }
            }
        }
        return null;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(@Nullable String str) {
        zzy zzb = zzb(str, false, false);
        zzb.zze();
        return zzb.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzy zzc;
        int length;
        String[] packagesForUid = this.zzb.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzc = null;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    zzc = zzb(packagesForUid[i2], false, false);
                    if (zzc.zza) {
                        break;
                    }
                    i2++;
                } else {
                    Preconditions.checkNotNull(zzc);
                    break;
                }
            }
        } else {
            zzc = zzy.zzc("no pkgs");
        }
        zzc.zze();
        return zzc.zza;
    }
}
