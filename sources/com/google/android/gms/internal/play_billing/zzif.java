package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzif extends zzih {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzif(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final void zzc(Object obj, long j, boolean z) {
        if (zzii.zzb) {
            zzii.zzD(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzii.zzE(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final void zzd(Object obj, long j, byte b) {
        if (zzii.zzb) {
            zzii.zzD(obj, j, b);
        } else {
            zzii.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final boolean zzg(Object obj, long j) {
        if (zzii.zzb) {
            return zzii.zzt(obj, j);
        }
        return zzii.zzu(obj, j);
    }
}
