package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zzol extends zzon {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzol(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zza(Object obj, long j, byte b) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j, b);
        } else {
            zzoo.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zzb(Object obj, long j) {
        if (zzoo.zzb) {
            return zzoo.zzu(obj, j);
        }
        return zzoo.zzv(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zzc(Object obj, long j, boolean z) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzoo.zzE(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }
}
