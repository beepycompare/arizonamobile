package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zaw implements zabu {
    final /* synthetic */ zax zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zaw(zax zaxVar, byte[] bArr) {
        Objects.requireNonNull(zaxVar);
        this.zaa = zaxVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zaa(Bundle bundle) {
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            zaxVar.zav(ConnectionResult.RESULT_SUCCESS);
            zaxVar.zao();
        } finally {
            this.zaa.zay().unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zab(ConnectionResult connectionResult) {
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            zaxVar.zav(connectionResult);
            zaxVar.zao();
        } finally {
            this.zaa.zay().unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zac(int i, boolean z) {
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            if (!zaxVar.zaw()) {
                zaxVar.zax(true);
                zaxVar.zar().onConnectionSuspended(i);
            } else {
                zaxVar.zax(false);
                zaxVar.zap(i, z);
            }
            zaxVar.zay().unlock();
        } catch (Throwable th) {
            this.zaa.zay().unlock();
            throw th;
        }
    }
}
