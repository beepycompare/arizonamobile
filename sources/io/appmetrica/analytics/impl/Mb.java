package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Mb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Nb f548a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mb(Nb nb, String str) {
        super(str);
        this.f548a = nb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f548a.f563a) {
            Nb.a(this.f548a);
            this.f548a.e = true;
            this.f548a.f563a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f548a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f548a.b);
                this.f548a.b.clear();
            }
            if (hashMap.size() > 0) {
                Nb.a(this.f548a, hashMap);
                hashMap.clear();
            }
        }
    }
}
