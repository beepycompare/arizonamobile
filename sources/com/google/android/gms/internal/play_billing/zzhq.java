package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzhq implements Iterator {
    final /* synthetic */ zzht zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhq(zzht zzhtVar, zzhs zzhsVar) {
        Objects.requireNonNull(zzhtVar);
        this.zza = zzhtVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        Map map;
        int i2 = this.zzb + 1;
        zzht zzhtVar = this.zza;
        i = zzhtVar.zzb;
        if (i2 >= i) {
            map = zzhtVar.zzc;
            return !map.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i;
        Object[] objArr;
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        zzht zzhtVar = this.zza;
        i = zzhtVar.zzb;
        if (i2 < i) {
            objArr = zzhtVar.zza;
            return (zzhp) objArr[i2];
        }
        return (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzht zzhtVar = this.zza;
        zzhtVar.zzo();
        int i2 = this.zzb;
        i = zzhtVar.zzb;
        if (i2 < i) {
            this.zzb = i2 - 1;
            zzhtVar.zzm(i2);
            return;
        }
        zza().remove();
    }
}
