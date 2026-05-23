package com.google.android.gms.internal.measurement;

import androidx.collection.SimpleArrayMap;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public class zzwl {
    private static final zzwj zza = zzwj.zza(Boolean.class);
    @Nullable
    private final zzwl zzb;
    private final SimpleArrayMap zzc;
    private boolean zzd = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzwl(zzwl zzwlVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        if (zzwlVar != null) {
            Preconditions.checkArgument(zzwlVar.zzd);
        }
        this.zzb = zzwlVar;
        this.zzc = simpleArrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzwl zza(zzwl zzwlVar, zzwl zzwlVar2) {
        if (zzwlVar.zzc()) {
            return zzwlVar2;
        }
        if (zzwlVar2.zzc()) {
            return zzwlVar;
        }
        ImmutableSet<zzwl> of = ImmutableSet.of(zzwlVar, zzwlVar2);
        if (of.isEmpty()) {
            return zzwk.zza;
        }
        if (of.size() == 1) {
            return (zzwl) of.iterator().next();
        }
        int i = 0;
        for (zzwl zzwlVar3 : of) {
            do {
                i += zzwlVar3.zzc.size();
                zzwlVar3 = zzwlVar3.zzb;
            } while (zzwlVar3 != null);
        }
        if (i == 0) {
            return zzwk.zza;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(i);
        for (zzwl zzwlVar4 : of) {
            do {
                int i2 = 0;
                while (true) {
                    SimpleArrayMap simpleArrayMap2 = zzwlVar4.zzc;
                    if (i2 >= simpleArrayMap2.size()) {
                        break;
                    }
                    Preconditions.checkArgument(simpleArrayMap.put((zzwj) simpleArrayMap2.keyAt(i2), simpleArrayMap2.valueAt(i2)) == null, "Duplicate bindings: %s", simpleArrayMap2.keyAt(i2));
                    i2++;
                }
                zzwlVar4 = zzwlVar4.zzb;
            } while (zzwlVar4 != null);
        }
        return new zzwk(null, simpleArrayMap, null).zzb();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SpanExtras<");
        for (zzwl zzwlVar = this; zzwlVar != null; zzwlVar = zzwlVar.zzb) {
            for (int i = 0; i < zzwlVar.zzc.size(); i++) {
                sb.append("[");
                sb.append(this.zzc.valueAt(i));
                sb.append("], ");
            }
        }
        sb.append(">");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzwl zzb() {
        if (this.zzd) {
            throw new IllegalStateException("Already frozen");
        }
        this.zzd = true;
        zzwl zzwlVar = this.zzb;
        return (zzwlVar == null || !this.zzc.isEmpty()) ? this : zzwlVar;
    }

    public final boolean zzc() {
        return this == zzwk.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(zzwj zzwjVar) {
        if (this.zzc.containsKey(zzwjVar)) {
            return true;
        }
        zzwl zzwlVar = this.zzb;
        return zzwlVar != null && zzwlVar.zzd(zzwjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zze() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ SimpleArrayMap zzg() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzh() {
        return this.zzd;
    }
}
