package com.google.android.gms.dynamic;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zaf implements zah {
    final /* synthetic */ DeferredLifecycleHelper zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaf(DeferredLifecycleHelper deferredLifecycleHelper) {
        Objects.requireNonNull(deferredLifecycleHelper);
        this.zaa = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 4;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab(LifecycleDelegate lifecycleDelegate) {
        this.zaa.zaa().onStart();
    }
}
