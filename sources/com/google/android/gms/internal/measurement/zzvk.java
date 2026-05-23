package com.google.android.gms.internal.measurement;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzvk extends AbstractFuture {
    private zzvm zza;
    private final int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzvk(zzvm zzvmVar, int i, byte[] bArr) {
        this.zza = zzvmVar;
        this.zzb = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        zzvl zzvlVar;
        zzvm zzvmVar = this.zza;
        this.zza = null;
        if (zzvmVar != null && zzvmVar.zze()) {
            do {
                zzvlVar = (zzvl) zzvmVar.zzg().get();
                if (zzvlVar == null) {
                    return;
                }
                if (zzvlVar.zza() > this.zzb) {
                    return;
                }
                zzvlVar.cancel(true);
            } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(zzvmVar.zzg(), zzvlVar, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        AsyncCallable zza;
        zzvm zzvmVar = this.zza;
        if (zzvmVar == null || (zza = zzvmVar.zzf().zza()) == null) {
            return null;
        }
        String obj = zza.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 11);
        sb.append("callable=[");
        sb.append(obj);
        sb.append("]");
        String sb2 = sb.toString();
        zzvl zzvlVar = (zzvl) this.zza.zzg().get();
        if (zzvlVar != null) {
            int length = sb2.length();
            String obj2 = zzvlVar.toString();
            StringBuilder sb3 = new StringBuilder(length + 9 + obj2.length() + 1);
            sb3.append(sb2);
            sb3.append(", trial=[");
            sb3.append(obj2);
            sb3.append("]");
            return sb3.toString();
        }
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
