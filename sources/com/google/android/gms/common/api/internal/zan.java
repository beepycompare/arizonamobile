package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zan extends zabr {
    final /* synthetic */ Dialog zaa;
    final /* synthetic */ zao zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zan(zao zaoVar, Dialog dialog) {
        this.zaa = dialog;
        Objects.requireNonNull(zaoVar);
        this.zab = zaoVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zaa() {
        this.zab.zaa.zag();
        Dialog dialog = this.zaa;
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
