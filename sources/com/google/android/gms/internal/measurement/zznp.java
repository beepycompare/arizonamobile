package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.util.Log;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zznp implements zzom {
    private final String zza;
    private final zzph zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznp(String str, String str2, zzph zzphVar) {
        this.zza = str2;
        this.zzb = zzphVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzom, com.google.common.base.Supplier
    public final Object get() {
        return Preconditions.checkNotNull(zzb(zzlk.zzb()));
    }

    protected Object zza() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:7:0x0014, B:9:0x001b, B:11:0x0030, B:13:0x003a, B:15:0x0050, B:19:0x0067, B:27:0x007d, B:28:0x0083, B:30:0x008d, B:32:0x009d, B:34:0x00a5, B:35:0x00b5, B:38:0x00c1, B:43:0x00c9, B:44:0x00d4, B:49:0x00df, B:51:0x00e5, B:52:0x00eb, B:24:0x006f, B:54:0x00ed), top: B:60:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:7:0x0014, B:9:0x001b, B:11:0x0030, B:13:0x003a, B:15:0x0050, B:19:0x0067, B:27:0x007d, B:28:0x0083, B:30:0x008d, B:32:0x009d, B:34:0x00a5, B:35:0x00b5, B:38:0x00c1, B:43:0x00c9, B:44:0x00d4, B:49:0x00df, B:51:0x00e5, B:52:0x00eb, B:24:0x006f, B:54:0x00ed), top: B:60:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e5 A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:7:0x0014, B:9:0x001b, B:11:0x0030, B:13:0x003a, B:15:0x0050, B:19:0x0067, B:27:0x007d, B:28:0x0083, B:30:0x008d, B:32:0x009d, B:34:0x00a5, B:35:0x00b5, B:38:0x00c1, B:43:0x00c9, B:44:0x00d4, B:49:0x00df, B:51:0x00e5, B:52:0x00eb, B:24:0x006f, B:54:0x00ed), top: B:60:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzaA(zznw zznwVar, final zzlk zzlkVar, String str) {
        zzpg zzpgVar;
        Object obj;
        final String zzb;
        Object zza;
        String zza2;
        int zzf = zznwVar.zzf();
        if (zzf == -1 || zzf < zznwVar.zzg().zza()) {
            synchronized (zznwVar) {
                int zzf2 = zznwVar.zzf();
                Object obj2 = null;
                if (zzf2 == -1) {
                    zzlk.zzl();
                    Preconditions.checkNotNull(zzlkVar);
                    zzpgVar = this.zzb.zza(zzlkVar, "");
                    zznwVar.zzj(zzpgVar.zzc());
                } else {
                    zzpgVar = null;
                }
                int zza3 = zznwVar.zzg().zza();
                if (zzf2 < zza3) {
                    zzlk.zzl();
                    Preconditions.checkNotNull(zzlkVar);
                    Optional zza4 = zzlf.zza(zzlkVar.zzc());
                    if (zza4.isPresent() && (zza2 = ((zzle) zza4.get()).zza(zzlg.zza("com.google.android.gms.measurement"), null, null, this.zza)) != null) {
                        try {
                            obj = zzc(zza2);
                        } catch (IOException | IllegalArgumentException e) {
                            Log.e("FilePhenotypeFlags", "Invalid Phenotype flag value for flag ".concat(this.zza), e);
                        }
                        if (zzpgVar == null) {
                            zzpgVar = this.zzb.zza(zzlkVar, "");
                        }
                        zzb = zzpgVar.zzb();
                        if (Build.VERSION.SDK_INT >= 26 && !zzlkVar.zzc().getPackageName().equals("com.android.vending") && !zzb.startsWith("com.google.android.gms.measurement#")) {
                            zzpx.zza(zzlkVar.zzg().submit(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzpn
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    Map zza5 = zzpp.zza(zzlk.this.zzc());
                                    String str2 = zzb;
                                    if (zza5.containsKey(str2)) {
                                        return;
                                    }
                                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 173);
                                    sb.append("Config package ");
                                    sb.append(str2);
                                    sb.append(" cannot use FILE backing without declarative registration. See go/phenotype-android-integration#phenotype for more information. This will lead to stale flags.");
                                    Log.e("FilePhenotypeFlags", sb.toString());
                                }
                            }));
                        }
                        zza = zzpgVar.zza(this.zza, false);
                        if (zza != null) {
                            try {
                                obj2 = zzd(zza);
                            } catch (IOException | ClassCastException e2) {
                                Log.e("FilePhenotypeFlags", "Invalid Phenotype flag value for flag ".concat(this.zza), e2);
                            }
                        }
                        if (true == zza4.isPresent()) {
                            obj = obj2;
                        }
                        if (obj == null) {
                            obj = zza();
                        }
                        if (obj != null) {
                            zznwVar.zzh(obj);
                            zznwVar.zzi(zza3);
                        }
                        return obj;
                    }
                    obj = null;
                    if (zzpgVar == null) {
                    }
                    zzb = zzpgVar.zzb();
                    if (Build.VERSION.SDK_INT >= 26) {
                        zzpx.zza(zzlkVar.zzg().submit(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzpn
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                Map zza5 = zzpp.zza(zzlk.this.zzc());
                                String str2 = zzb;
                                if (zza5.containsKey(str2)) {
                                    return;
                                }
                                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 173);
                                sb.append("Config package ");
                                sb.append(str2);
                                sb.append(" cannot use FILE backing without declarative registration. See go/phenotype-android-integration#phenotype for more information. This will lead to stale flags.");
                                Log.e("FilePhenotypeFlags", sb.toString());
                            }
                        }));
                    }
                    zza = zzpgVar.zza(this.zza, false);
                    if (zza != null) {
                    }
                    if (true == zza4.isPresent()) {
                    }
                    if (obj == null) {
                    }
                    if (obj != null) {
                    }
                    return obj;
                }
            }
        }
        return zznwVar.zze();
    }

    protected abstract Object zzb(zzlk zzlkVar);

    protected abstract Object zzc(String str) throws IOException;

    protected abstract Object zzd(Object obj) throws IOException;
}
