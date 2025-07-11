package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zznm extends zzor {
    public final zzhd zza;
    public final zzhd zzb;
    public final zzhd zzc;
    public final zzhd zzd;
    public final zzhd zze;
    public final zzhd zzf;
    private final Map zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznm(zzpf zzpfVar) {
        super(zzpfVar);
        this.zzh = new HashMap();
        zzhg zzd = this.zzu.zzd();
        Objects.requireNonNull(zzd);
        this.zza = new zzhd(zzd, "last_delete_stale", 0L);
        zzhg zzd2 = this.zzu.zzd();
        Objects.requireNonNull(zzd2);
        this.zzb = new zzhd(zzd2, "last_delete_stale_batch", 0L);
        zzhg zzd3 = this.zzu.zzd();
        Objects.requireNonNull(zzd3);
        this.zzc = new zzhd(zzd3, "backoff", 0L);
        zzhg zzd4 = this.zzu.zzd();
        Objects.requireNonNull(zzd4);
        this.zzd = new zzhd(zzd4, "last_upload", 0L);
        zzhg zzd5 = this.zzu.zzd();
        Objects.requireNonNull(zzd5);
        this.zze = new zzhd(zzd5, "last_upload_attempt", 0L);
        zzhg zzd6 = this.zzu.zzd();
        Objects.requireNonNull(zzd6);
        this.zzf = new zzhd(zzd6, "midnight_offset", 0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair zzc(String str, zzjk zzjkVar) {
        if (zzjkVar.zzo(zzjj.AD_STORAGE)) {
            return zzd(str);
        }
        return new Pair("", false);
    }

    @Deprecated
    final Pair zzd(String str) {
        zznl zznlVar;
        AdvertisingIdClient.Info info;
        zzg();
        zzib zzibVar = this.zzu;
        long elapsedRealtime = zzibVar.zzaZ().elapsedRealtime();
        zznl zznlVar2 = (zznl) this.zzh.get(str);
        if (zznlVar2 == null || elapsedRealtime >= zznlVar2.zzc) {
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            long zzl = zzibVar.zzc().zzl(str, zzfx.zza) + elapsedRealtime;
            try {
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(zzibVar.zzaY());
                } catch (PackageManager.NameNotFoundException unused) {
                    info = null;
                    if (zznlVar2 != null && elapsedRealtime < zznlVar2.zzc + this.zzu.zzc().zzl(str, zzfx.zzb)) {
                        return new Pair(zznlVar2.zza, Boolean.valueOf(zznlVar2.zzb));
                    }
                }
            } catch (Exception e) {
                this.zzu.zzaV().zzj().zzb("Unable to get advertising id", e);
                zznlVar = new zznl("", false, zzl);
            }
            if (info == null) {
                return new Pair("00000000-0000-0000-0000-000000000000", false);
            }
            String id = info.getId();
            if (id != null) {
                zznlVar = new zznl(id, info.isLimitAdTrackingEnabled(), zzl);
            } else {
                zznlVar = new zznl("", info.isLimitAdTrackingEnabled(), zzl);
            }
            this.zzh.put(str, zznlVar);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair(zznlVar.zza, Boolean.valueOf(zznlVar.zzb));
        }
        return new Pair(zznlVar2.zza, Boolean.valueOf(zznlVar2.zzb));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final String zzf(String str, boolean z) {
        String str2;
        zzg();
        if (z) {
            str2 = (String) zzd(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest zzO = zzpo.zzO();
        if (zzO == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzO.digest(str2.getBytes())));
    }
}
