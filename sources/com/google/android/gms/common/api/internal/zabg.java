package com.google.android.gms.common.api.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zabg implements Runnable {
    final /* synthetic */ zabk zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabg(zabk zabkVar) {
        Objects.requireNonNull(zabkVar);
        this.zaa = zabkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zat();
    }
}
