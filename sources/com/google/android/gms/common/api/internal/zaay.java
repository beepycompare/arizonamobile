package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zaay extends zabr {
    private final WeakReference zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaay(zaaz zaazVar) {
        this.zaa = new WeakReference(zaazVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zaa() {
        zaaz zaazVar = (zaaz) this.zaa.get();
        if (zaazVar == null) {
            return;
        }
        zaazVar.zai();
    }
}
