package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Mb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Nb f547a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mb(Nb nb, String str) {
        super(str);
        this.f547a = nb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f547a.f562a) {
            Nb.a(this.f547a);
            this.f547a.e = true;
            this.f547a.f562a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f547a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f547a.b);
                this.f547a.b.clear();
            }
            if (hashMap.size() > 0) {
                Nb.a(this.f547a, hashMap);
                hashMap.clear();
            }
        }
    }
}
