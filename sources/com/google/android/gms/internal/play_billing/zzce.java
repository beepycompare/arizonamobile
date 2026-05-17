package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzce extends zzbw {
    final /* synthetic */ zzcf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzce(zzcf zzcfVar) {
        Objects.requireNonNull(zzcfVar);
        this.zza = zzcfVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        zzcf zzcfVar = this.zza;
        i2 = zzcfVar.zzc;
        zzbj.zza(i, i2, FirebaseAnalytics.Param.INDEX);
        objArr = zzcfVar.zzb;
        int i3 = i + i;
        Object requireNonNull = Objects.requireNonNull(objArr[i3]);
        objArr2 = zzcfVar.zzb;
        return new AbstractMap.SimpleImmutableEntry(requireNonNull, Objects.requireNonNull(objArr2[i3 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzc;
        return i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    public final boolean zzf() {
        return true;
    }
}
