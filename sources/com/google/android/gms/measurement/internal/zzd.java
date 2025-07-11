package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzd extends zzf {
    private final Map zza;
    private final Map zzb;
    private long zzc;

    public zzd(zzib zzibVar) {
        super(zzibVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
    }

    private final void zzh(long j, zzlt zzltVar) {
        if (zzltVar == null) {
            this.zzu.zzaV().zzk().zza("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            this.zzu.zzaV().zzk().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzpo.zzav(zzltVar, bundle, true);
            this.zzu.zzj().zzF("am", "_xa", bundle);
        }
    }

    private final void zzi(String str, long j, zzlt zzltVar) {
        if (zzltVar == null) {
            this.zzu.zzaV().zzk().zza("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            this.zzu.zzaV().zzk().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzpo.zzav(zzltVar, bundle, true);
            this.zzu.zzj().zzF("am", "_xu", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzj */
    public final void zzf(long j) {
        Map map = this.zza;
        for (String str : map.keySet()) {
            map.put(str, Long.valueOf(j));
        }
        if (map.isEmpty()) {
            return;
        }
        this.zzc = j;
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            this.zzu.zzaV().zzb().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzu.zzaW().zzj(new zza(this, str, j));
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            this.zzu.zzaV().zzb().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzu.zzaW().zzj(new zzb(this, str, j));
        }
    }

    public final void zzc(long j) {
        zzlt zzh = this.zzu.zzs().zzh(false);
        Map map = this.zza;
        for (String str : map.keySet()) {
            zzi(str, j - ((Long) map.get(str)).longValue(), zzh);
        }
        if (!map.isEmpty()) {
            zzh(j - this.zzc, zzh);
        }
        zzf(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, long j) {
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzb;
        if (map.isEmpty()) {
            this.zzc = j;
        }
        Integer num = (Integer) map.get(str);
        if (num != null) {
            map.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (map.size() >= 100) {
            this.zzu.zzaV().zze().zza("Too many ads visible");
        } else {
            map.put(str, 1);
            this.zza.put(str, Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(String str, long j) {
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzb;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            this.zzu.zzaV().zzb().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzlt zzh = this.zzu.zzs().zzh(false);
        int intValue = num.intValue() - 1;
        if (intValue == 0) {
            map.remove(str);
            Map map2 = this.zza;
            Long l = (Long) map2.get(str);
            if (l == null) {
                this.zzu.zzaV().zzb().zza("First ad unit exposure time was never set");
            } else {
                map2.remove(str);
                zzi(str, j - l.longValue(), zzh);
            }
            if (map.isEmpty()) {
                long j2 = this.zzc;
                if (j2 == 0) {
                    this.zzu.zzaV().zzb().zza("First ad exposure time was never set");
                    return;
                }
                zzh(j - j2, zzh);
                this.zzc = 0L;
                return;
            }
            return;
        }
        map.put(str, Integer.valueOf(intValue));
    }
}
