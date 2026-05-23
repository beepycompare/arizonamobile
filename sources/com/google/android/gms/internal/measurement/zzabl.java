package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzabl extends zzabp {
    private static final zzabp zza = new zzabl();

    private zzabl() {
    }

    public static zzabp zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzabp
    public final int zzb(zzabm zzabmVar, int i, String str, int i2, int i3, int i4) throws zzabo {
        zzabh zza2;
        char charAt = str.charAt(i4);
        zzza zzb = zzza.zzb(str, i3, i4, (charAt & ' ') == 0);
        zzyz zza3 = zzyz.zza(charAt);
        int i5 = i4 + 1;
        if (zza3 != null) {
            if (!zzb.zzi(zza3)) {
                throw zzabo.zza("invalid format specifier", str, i2, i5);
            }
            zza2 = zzabj.zza(i, zza3, zzb);
        } else if (charAt == 't' || charAt == 'T') {
            if (zzb.zzh(160, false)) {
                int i6 = i4 + 2;
                if (i6 > str.length()) {
                    throw zzabo.zzb("truncated format specifier", str, i2);
                }
                zzabf zza4 = zzabf.zza(str.charAt(i5));
                if (zza4 == null) {
                    throw zzabo.zzb("illegal date/time conversion", str, i5);
                }
                zza2 = zzabg.zza(zza4, zzb, i);
                i5 = i6;
            } else {
                throw zzabo.zza("invalid format specification", str, i2, i5);
            }
        } else if (charAt == 'h' || charAt == 'H') {
            if (zzb.zzh(160, false)) {
                zza2 = new zzabk(zzb, i, zzb);
            } else {
                throw zzabo.zza("invalid format specification", str, i2, i5);
            }
        } else {
            throw zzabo.zza("invalid format specification", str, i2, i5);
        }
        zzabmVar.zzk(i2, i5, zza2);
        return i5;
    }
}
