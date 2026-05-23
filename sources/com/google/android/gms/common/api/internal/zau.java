package com.google.android.gms.common.api.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zau implements Runnable {
    final /* synthetic */ zax zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zau(zax zaxVar) {
        Objects.requireNonNull(zaxVar);
        this.zaa = zaxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            zaxVar.zao();
        } finally {
            this.zaa.zay().unlock();
        }
    }
}
