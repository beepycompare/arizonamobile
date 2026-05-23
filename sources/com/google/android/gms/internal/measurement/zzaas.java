package com.google.android.gms.internal.measurement;

import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaas extends zzaag {
    public static final /* synthetic */ int zza = 0;
    private static final Set zzb;
    private static final zzzq zzc;
    private static final zzaaq zzd;
    private final String zze;
    private final Level zzf;
    private final Set zzg;
    private final zzzq zzh;
    private final int zzi;

    static {
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzxx.zza, zzyw.zza, zzyx.zza)));
        zzb = unmodifiableSet;
        zzc = zzzt.zza(unmodifiableSet).zzc();
        zzd = new zzaaq(null);
    }

    public /* synthetic */ zzaas(String str, String str2, boolean z, int i, Level level, Set set, zzzq zzzqVar, byte[] bArr) {
        super(str2);
        this.zze = zzaal.zza("", str2, true);
        this.zzi = 2;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzzqVar;
    }

    public static zzaaq zze() {
        return zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zzi(zzzd zzzdVar, String str, int i, Level level, Set set, zzzq zzzqVar) {
        String sb;
        int zzb2;
        Boolean bool = (Boolean) zzzdVar.zzl().zzd(zzyx.zza);
        if (bool != null && bool.booleanValue()) {
            return;
        }
        zzaaa zzh = zzaaa.zzh(zzaad.zzj(), zzzdVar.zzl());
        boolean z = zzzdVar.zze().intValue() < level.intValue();
        if (!z) {
            int i2 = zzaae.zza;
            if (zzzdVar.zzh() == null && zzh.zzb() <= set.size() && set.containsAll(zzh.zzc())) {
                sb = zzzh.zza(zzzdVar.zzj());
                Throwable th = (Throwable) zzzdVar.zzl().zzd(zzxx.zza);
                zzb2 = zzaal.zzb(zzzdVar.zze());
                if (zzb2 != 2) {
                    Log.v(str, sb, th);
                    return;
                } else if (zzb2 == 3) {
                    Log.d(str, sb, th);
                    return;
                } else if (zzb2 == 4) {
                    Log.i(str, sb, th);
                    return;
                } else if (zzb2 != 5) {
                    Log.e(str, sb, th);
                    return;
                } else {
                    Log.w(str, sb, th);
                    return;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (zzze.zza(2, zzzdVar.zzg(), sb2)) {
            sb2.append(" ");
        }
        if (z && zzzdVar.zzh() != null) {
            sb2.append("(REDACTED) ");
            sb2.append(zzzdVar.zzh().zzb());
        } else {
            zzyy.zza(zzzdVar, sb2);
            int i3 = zzaae.zza;
            zzzc zzzcVar = new zzzc("[CONTEXT ", " ]", sb2);
            zzh.zza(zzzqVar, zzzcVar);
            zzzcVar.zzb();
        }
        sb = sb2.toString();
        Throwable th2 = (Throwable) zzzdVar.zzl().zzd(zzxx.zza);
        zzb2 = zzaal.zzb(zzzdVar.zze());
        if (zzb2 != 2) {
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final boolean zzb(Level level) {
        String str = this.zze;
        int zzb2 = zzaal.zzb(level);
        return Log.isLoggable(str, zzb2) || Log.isLoggable(TtmlNode.COMBINE_ALL, zzb2);
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final void zzc(zzzd zzzdVar) {
        zzi(zzzdVar, this.zze, 2, this.zzf, this.zzg, this.zzh);
    }
}
