package com.google.android.gms.common.api.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zar {
    final /* synthetic */ BasePendingResult zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zar(BasePendingResult basePendingResult, byte[] bArr) {
        Objects.requireNonNull(basePendingResult);
        this.zaa = basePendingResult;
    }

    protected final void finalize() throws Throwable {
        BasePendingResult.zal(this.zaa.zam());
        super.finalize();
    }
}
