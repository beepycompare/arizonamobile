package com.google.android.gms.internal.measurement;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzol implements zzoh {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private final ConcurrentMap zzb;
    private final ConcurrentMap zzc;

    public zzol() {
        new ConcurrentHashMap();
        this.zzb = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.zzc = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.internal.measurement.zzoh
    public final void zza(zzacr zzacrVar, Set set, String str) {
        zzok[] zzokVarArr;
        if (!set.isEmpty() && !this.zza.getAndSet(true)) {
            zzbu.zza().zzb(new zzoj(this, null));
        }
        final byte[] zzm = zzacrVar.zzm();
        this.zzb.compute(str, new BiFunction() { // from class: com.google.android.gms.internal.measurement.zzoi
            @Override // java.util.function.BiFunction
            public final /* synthetic */ Object apply(Object obj, Object obj2) {
                byte[] bArr = (byte[]) obj2;
                byte[] bArr2 = zzm;
                return Arrays.equals(bArr, bArr2) ? bArr : bArr2;
            }
        });
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AtomicReference atomicReference = (AtomicReference) this.zzc.putIfAbsent((String) it.next(), new AtomicReference(new zzok(str, zzm, null)));
            if (atomicReference != null) {
                while (true) {
                    Object obj = atomicReference.get();
                    if (obj instanceof zzok) {
                        zzok zzokVar = (zzok) obj;
                        if (!str.equals(zzokVar.zza())) {
                            zzok zzokVar2 = new zzok(str, zzm, null);
                            zzokVarArr = str.compareTo(zzokVar.zza()) < 0 ? new zzok[]{zzokVar2, zzokVar} : new zzok[]{zzokVar, zzokVar2};
                            if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, obj, zzokVarArr)) {
                                break;
                            }
                        } else {
                            zzokVar.zzb(zzm, false);
                            break;
                        }
                    } else {
                        zzok[] zzokVarArr2 = (zzok[]) obj;
                        int binarySearch = Arrays.binarySearch(zzokVarArr2, str);
                        if (binarySearch < 0) {
                            int i = ~binarySearch;
                            int length = zzokVarArr2.length;
                            int i2 = length + 1;
                            int i3 = length - i;
                            if (i3 == 0) {
                                zzokVarArr = (zzok[]) Arrays.copyOf(zzokVarArr2, i2);
                            } else {
                                zzok[] zzokVarArr3 = new zzok[i2];
                                System.arraycopy(zzokVarArr2, 0, zzokVarArr3, 0, i);
                                System.arraycopy(zzokVarArr2, i, zzokVarArr3, i + 1, i3);
                                zzokVarArr = zzokVarArr3;
                            }
                            zzokVarArr[i] = new zzok(str, zzm, null);
                            if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, obj, zzokVarArr)) {
                                break;
                            }
                        } else {
                            zzokVarArr2[binarySearch].zzb(zzm, false);
                            break;
                        }
                    }
                }
            }
        }
    }
}
