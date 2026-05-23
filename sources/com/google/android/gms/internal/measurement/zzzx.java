package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzzx implements Iterator {
    final /* synthetic */ zzzy zza;
    private final zzyl zzb;
    private int zzc;
    private int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzzx(zzzy zzzyVar, zzyl zzylVar, int i, byte[] bArr) {
        Objects.requireNonNull(zzzyVar);
        this.zza = zzzyVar;
        this.zzb = zzylVar;
        int i2 = i & 31;
        this.zzc = i2;
        this.zzd = i >>> (i2 + 5);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object zze = this.zzb.zze(this.zza.zze(this.zzc));
        int i = this.zzd;
        if (i == 0) {
            this.zzc = -1;
            return zze;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i) + 1;
        this.zzd >>>= numberOfTrailingZeros;
        this.zzc += numberOfTrailingZeros;
        return zze;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
