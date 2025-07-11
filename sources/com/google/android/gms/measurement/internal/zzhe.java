package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhe {
    final String zza;
    final /* synthetic */ zzhg zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhe(zzhg zzhgVar, String str, long j, byte[] bArr) {
        Objects.requireNonNull(zzhgVar);
        this.zzb = zzhgVar;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j > 0);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j;
    }

    private final void zzc() {
        zzhg zzhgVar = this.zzb;
        zzhgVar.zzg();
        long currentTimeMillis = zzhgVar.zzu.zzaZ().currentTimeMillis();
        SharedPreferences.Editor edit = zzhgVar.zzd().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    private final long zzd() {
        return this.zzb.zzd().getLong(this.zza, 0L);
    }

    public final void zza(String str, long j) {
        zzhg zzhgVar = this.zzb;
        zzhgVar.zzg();
        if (zzd() == 0) {
            zzc();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences zzd = zzhgVar.zzd();
        String str2 = this.zzc;
        long j2 = zzd.getLong(str2, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = zzhgVar.zzd().edit();
            edit.putString(this.zzd, str);
            edit.putLong(str2, 1L);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        SharedPreferences.Editor edit2 = zzhgVar.zzd().edit();
        if ((zzhgVar.zzu.zzk().zzf().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3) {
            edit2.putString(this.zzd, str);
        }
        edit2.putLong(str2, j3);
        edit2.apply();
    }

    public final Pair zzb() {
        long abs;
        zzhg zzhgVar = this.zzb;
        zzhgVar.zzg();
        zzhgVar.zzg();
        long zzd = zzd();
        if (zzd == 0) {
            zzc();
            abs = 0;
        } else {
            abs = Math.abs(zzd - zzhgVar.zzu.zzaZ().currentTimeMillis());
        }
        long j = this.zze;
        if (abs < j) {
            return null;
        }
        if (abs > j + j) {
            zzc();
            return null;
        }
        String string = zzhgVar.zzd().getString(this.zzd, null);
        long j2 = zzhgVar.zzd().getLong(this.zzc, 0L);
        zzc();
        if (string == null || j2 <= 0) {
            return zzhg.zza;
        }
        return new Pair(string, Long.valueOf(j2));
    }
}
