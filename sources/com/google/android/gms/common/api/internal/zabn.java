package com.google.android.gms.common.api.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public final class zabn implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabq zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabn(zabq zabqVar, int i) {
        this.zab = zabqVar;
        this.zaa = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zaI(this.zaa);
    }
}
