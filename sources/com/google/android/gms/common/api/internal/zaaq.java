package com.google.android.gms.common.api.internal;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public abstract class zaaq implements Runnable {
    final /* synthetic */ zaar zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zaaq(zaar zaarVar, byte[] bArr) {
        Objects.requireNonNull(zaarVar);
        this.zab = zaarVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock zas;
        zaar zaarVar = this.zab;
        zaarVar.zas().lock();
        try {
            try {
            } catch (RuntimeException e) {
                this.zab.zar().zas(e);
            }
            if (Thread.interrupted()) {
                zas = zaarVar.zas();
                zas.unlock();
            }
            zaa();
            zas = this.zab.zas();
            zas.unlock();
        } catch (Throwable th) {
            this.zab.zas().unlock();
            throw th;
        }
    }

    protected abstract void zaa();
}
