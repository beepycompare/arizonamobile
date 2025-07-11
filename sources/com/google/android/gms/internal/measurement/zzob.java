package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zzob implements Iterator {
    final /* synthetic */ zzod zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzob(zzod zzodVar, byte[] bArr) {
        Objects.requireNonNull(zzodVar);
        this.zza = zzodVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzod zzodVar = this.zza;
        if (i >= zzodVar.zzj()) {
            return !zzodVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzod zzodVar = this.zza;
        return i < zzodVar.zzj() ? (zzoa) zzodVar.zzi()[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzod zzodVar = this.zza;
        zzodVar.zzh();
        int i = this.zzb;
        if (i < zzodVar.zzj()) {
            this.zzb = i - 1;
            zzodVar.zzg(i);
            return;
        }
        zza().remove();
    }
}
