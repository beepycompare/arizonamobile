package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zaaa implements ListenerHolder.Notifier {
    final /* synthetic */ ModuleInstallStatusUpdate zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaaa(zaab zaabVar, ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.zaa = moduleInstallStatusUpdate;
        Objects.requireNonNull(zaabVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((InstallStatusListener) obj).onInstallStatusUpdated(this.zaa);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
