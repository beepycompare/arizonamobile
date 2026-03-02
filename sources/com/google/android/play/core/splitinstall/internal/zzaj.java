package com.google.android.play.core.splitinstall.internal;

import android.util.Log;
import java.util.List;
/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* loaded from: classes4.dex */
final class zzaj implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ com.google.android.play.core.splitinstall.zzf zzb;
    final /* synthetic */ zzak zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(zzak zzakVar, List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        this.zzc = zzakVar;
        this.zza = list;
        this.zzb = zzfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzam zzamVar;
        try {
            zzamVar = this.zzc.zzc;
            boolean zzb = zzamVar.zzb(this.zza);
            zzak zzakVar = this.zzc;
            if (zzb) {
                zzak.zzc(zzakVar, this.zzb);
            } else {
                zzak.zzb(zzakVar, this.zza, this.zzb);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.zzb.zzb(-11);
        }
    }
}
