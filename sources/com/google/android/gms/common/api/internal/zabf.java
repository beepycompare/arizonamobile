package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zabf implements BackgroundDetector.BackgroundStateChangeListener {
    final /* synthetic */ GoogleApiManager zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabf(GoogleApiManager googleApiManager) {
        Objects.requireNonNull(googleApiManager);
        this.zaa = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zaF().sendMessage(googleApiManager.zaF().obtainMessage(1, valueOf));
    }
}
