package com.google.android.gms.common.api.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zack implements Runnable {
    final /* synthetic */ com.google.android.gms.signin.internal.zak zaa;
    final /* synthetic */ zacm zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zack(zacm zacmVar, com.google.android.gms.signin.internal.zak zakVar) {
        this.zaa = zakVar;
        Objects.requireNonNull(zacmVar);
        this.zab = zacmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zae(this.zaa);
    }
}
