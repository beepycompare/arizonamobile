package com.google.android.gms.internal.measurement;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzok implements Comparable {
    private static final AtomicReferenceFieldUpdater zzc = AtomicReferenceFieldUpdater.newUpdater(zzok.class, Object.class, "zzb");
    private final String zza;
    private volatile Object zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzok(String str, byte[] bArr, byte[] bArr2) {
        this.zza = str;
        this.zzb = bArr;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza.compareTo((String) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(byte[] bArr, boolean z) {
        Object obj;
        byte[][] bArr2;
        int i = 0;
        do {
            obj = this.zzb;
            if (obj instanceof byte[]) {
                byte[] bArr3 = (byte[]) obj;
                if (Arrays.equals(bArr, bArr3)) {
                    return;
                }
                i = 1;
                bArr2 = new byte[][]{bArr3, bArr};
            } else {
                byte[][] bArr4 = (byte[][]) obj;
                while (true) {
                    int length = bArr4.length;
                    if (i < length) {
                        if (Arrays.equals(bArr, bArr4[i])) {
                            return;
                        }
                        i++;
                    } else {
                        bArr2 = (byte[][]) Arrays.copyOf(bArr4, length + 1);
                        bArr2[length] = bArr;
                        break;
                    }
                }
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zzc, this, obj, bArr2));
    }
}
