package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zaao extends com.google.android.gms.signin.internal.zac {
    private final WeakReference zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaao(zaar zaarVar) {
        this.zaa = new WeakReference(zaarVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        zaar zaarVar = (zaar) this.zaa.get();
        if (zaarVar == null) {
            return;
        }
        zaarVar.zar().zar(new zaan(this, zaarVar, zaarVar, zakVar));
    }
}
