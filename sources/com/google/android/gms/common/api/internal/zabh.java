package com.google.android.gms.common.api.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zabh implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabk zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabh(zabk zabkVar, int i) {
        this.zaa = i;
        Objects.requireNonNull(zabkVar);
        this.zab = zabkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zau(this.zaa);
    }
}
