package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Kb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Lb f504a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kb(Lb lb, String str) {
        super(str);
        this.f504a = lb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f504a.f516a) {
            Lb.a(this.f504a);
            this.f504a.e = true;
            this.f504a.f516a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f504a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f504a.b);
                this.f504a.b.clear();
            }
            if (hashMap.size() > 0) {
                Lb.a(this.f504a, hashMap);
                hashMap.clear();
            }
        }
    }
}
