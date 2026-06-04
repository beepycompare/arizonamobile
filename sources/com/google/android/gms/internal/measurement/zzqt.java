package com.google.android.gms.internal.measurement;

import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import coil3.util.UtilsKt;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzqt {
    private static Boolean zza;
    private final zzlk zzb;
    private final Uri zzc;
    private final String zzd;
    private final String zze = "";

    public zzqt(zzlk zzlkVar, String str, String str2, boolean z) {
        this.zzb = zzlkVar;
        this.zzd = str;
        zzrz zza2 = zzsa.zza(zzlkVar.zzc());
        zza2.zzb("phenotype");
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4);
        sb.append("/");
        sb.append(str);
        sb.append(".pb");
        zza2.zzc(sb.toString());
        this.zzc = zza2.zzd();
    }

    private static boolean zzf() {
        if (zza == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                zza = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    zza = Boolean.valueOf(((Boolean) Preconditions.checkNotNull(Process.class.getMethod("isIsolated", new Class[0]).invoke(Process.class, new Object[0]))).booleanValue());
                } catch (ReflectiveOperationException unused) {
                    zza = false;
                }
            }
        }
        return zza.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzqs zza() {
        String substring;
        zznv zznvVar;
        zznv zznvVar2;
        String zzc;
        Uri build;
        StrictMode.ThreadPolicy threadPolicy;
        zzlk zzlkVar = this.zzb;
        if (zzky.zzb(zzlkVar.zzc())) {
            return zzqs.zza(zzqv.zzi(), new zzqr(3, 17));
        }
        if (!zzf()) {
            zzqn zzc2 = zzlkVar.zzd().zzc(false);
            String str = this.zzd;
            zzabz zzabzVar = zzabz.FILE;
            int i = zzlg.zza;
            int indexOf = str.indexOf("#");
            if (indexOf < 0) {
                if (str.contains("@")) {
                    String.valueOf(str);
                    throw new IllegalArgumentException("Invalid package name: ".concat(String.valueOf(str)));
                }
                substring = str;
            } else {
                substring = str.substring(0, indexOf);
            }
            int zzg = zzc2.zzg(zzabzVar, substring);
            if (zzg != 0) {
                zznvVar2 = new zznv(null, new zzqr(zzg));
            } else {
                try {
                    zzc = zzc2.zzc();
                } catch (Exception e) {
                    zzlz.zzb(Level.WARNING, this.zzb.zzg(), e, "Failed to read shared file for %s", this.zzd);
                    zznvVar = new zznv(zznd.zza(), new zzqr(3, 10));
                }
                try {
                    if (zzc.isEmpty()) {
                        Optional zze = zzlkVar.zze();
                        if (!zze.isPresent()) {
                            zzlz.zza(Level.WARNING, zzlkVar.zzg(), "Unable to get GMS application info, using defaults.", new Object[0]);
                            zznvVar = new zznv(zznd.zza(), new zzqr(3, 7));
                            zznvVar2 = zznvVar;
                        } else {
                            zzc = ((ApplicationInfo) zze.get()).dataDir;
                        }
                    }
                    zznvVar = new zznv((zznd) zzlkVar.zzi().zza(build, new zzna(zzc2.zzf().zza())), new zzqr(5, 2));
                    StrictMode.setThreadPolicy(threadPolicy);
                    zznvVar2 = zznvVar;
                } catch (zzaeh e2) {
                    zzlz.zzb(Level.SEVERE, this.zzb.zzg(), e2, "Failed to parse snapshot from shared storage for %s", this.zzd);
                    zznvVar2 = new zznv(null, new zzqr(9));
                    StrictMode.setThreadPolicy(threadPolicy);
                    if (zznvVar2.zza() != null) {
                    }
                } catch (FileNotFoundException unused) {
                    zzlz.zza(Level.INFO, this.zzb.zzg(), "Shared storage file not found for %s", this.zzd);
                    zznvVar2 = new zznv(null, new zzqr(8));
                    StrictMode.setThreadPolicy(threadPolicy);
                    if (zznvVar2.zza() != null) {
                    }
                }
                String str2 = File.separator;
                String zzb = zzc2.zzb();
                StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + String.valueOf(str2).length() + String.valueOf(zzb).length());
                sb.append(zzc);
                sb.append(str2);
                sb.append(zzb);
                String sb2 = sb.toString();
                zzmz zzmzVar = new zzmz(zzc2.zza(), str, this.zze);
                Uri.Builder scheme = new Uri.Builder().scheme(UtilsKt.SCHEME_FILE);
                String str3 = File.separator;
                String str4 = File.separator;
                String obj = zzmzVar.zza().toString();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str3).length() + sb2.length() + String.valueOf(str4).length() + obj.length());
                sb3.append(str3);
                sb3.append(sb2);
                sb3.append(str4);
                sb3.append(obj);
                build = scheme.appendEncodedPath(sb3.toString()).build();
                threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
            }
            if (zznvVar2.zza() != null) {
                return zzqs.zzc((zznd) Preconditions.checkNotNull(zznvVar2.zza()), zznvVar2.zzb());
            }
            try {
                return zzqs.zza((zzqv) this.zzb.zzi().zza(this.zzc, zzss.zzb(zzqv.zzi())), new zzqr(4, zznvVar2.zzb().zzb()));
            } catch (IOException | RuntimeException unused2) {
                zzlz.zza(Level.INFO, this.zzb.zzg(), "Unable to retrieve flag snapshot for %s, using defaults.", this.zzd);
                if (this.zzb()) {
                    return zzqs.zzc(zznd.zza(), new zzqr(3, 16));
                }
                return zzqs.zza(zzqv.zzi(), new zzqr(3, 11));
            }
        }
        return zzqs.zza(zzqv.zzi(), new zzqr(3, 18));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zzb.zzd().zzb(false, zzabz.FILE);
    }

    public final ListenableFuture zzc(final zzqv zzqvVar) {
        return Futures.submit(new Callable() { // from class: com.google.android.gms.internal.measurement.zzqq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzqt.this.zze(zzqvVar);
                return null;
            }
        }, this.zzb.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ListenableFuture zzd(String str) {
        zzlk zzlkVar = this.zzb;
        return Futures.transform(zzlkVar.zzh().zza(this.zzd, ""), zzqp.zza, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zze(zzqv zzqvVar) {
        zzse zzseVar = new zzse();
        try {
            zzru zzi = this.zzb.zzi();
            Uri uri = this.zzc;
            zzsv zzb = zzsv.zzb(zzqvVar);
            zzb.zzc(zzseVar);
            Void r6 = (Void) zzi.zza(uri, zzb);
            return null;
        } catch (IOException | RuntimeException e) {
            zzlz.zzb(Level.WARNING, this.zzb.zzg(), e, "Failed to update snapshot for %s flags may be stale.", this.zzd);
            return null;
        }
    }
}
