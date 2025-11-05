package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.signatureverification.SignatureVerificationConfigurationProvider;
import com.google.android.gms.dynamite.DynamiteModule;
/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
/* loaded from: classes4.dex */
public class PackageSignatureVerifier {
    static volatile zzac zza;
    private static zzad zzb;

    private static synchronized zzad zza(Context context) {
        zzad zzadVar;
        synchronized (PackageSignatureVerifier.class) {
            if (zzb == null) {
                zzb = new zzad(context);
            }
            zzadVar = zzb;
        }
        return zzadVar;
    }

    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        int i = zzo.zzh;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzo.zzb();
                if (zzo.zzg.zzi()) {
                    SignatureVerificationConfigurationProvider.zza().zza();
                    String.valueOf(str);
                    String concat = String.valueOf(str).concat(true != honorsDebugCertificates ? "-0" : "-1");
                    if (zza == null || !zza.zza().equals(concat)) {
                        str.isEmpty();
                        zza(context);
                        zzv zzvVar = new zzv(null);
                        zzvVar.zza(str);
                        zzvVar.zzb(honorsDebugCertificates);
                        zzvVar.zzc(false);
                        zzy zzc = zzo.zzc(zzvVar.zzd());
                        if (zzc.zza) {
                            PackageVerificationResult zzd = PackageVerificationResult.zzd(str, zzc.zzd, null);
                            zza = new zzac(concat, zzd);
                            return zzd;
                        }
                        String str2 = zzc.zzb;
                        Preconditions.checkNotNull(str2);
                        return PackageVerificationResult.zza(str, str2, zzc.zzc, null);
                    }
                    return zza.zzb();
                }
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
        }
        throw new zzae();
    }

    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzc();
            return queryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (queryPackageSignatureVerified2.zzb()) {
                Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            }
            return queryPackageSignatureVerified2;
        }
    }
}
