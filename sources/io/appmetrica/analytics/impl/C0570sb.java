package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.sb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0570sb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0595tb f1214a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0570sb(C0595tb c0595tb, String str) {
        super(str);
        this.f1214a = c0595tb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f1214a.f1229a) {
            C0595tb.a(this.f1214a);
            this.f1214a.e = true;
            this.f1214a.f1229a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f1214a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f1214a.b);
                this.f1214a.b.clear();
            }
            if (hashMap.size() > 0) {
                C0595tb.a(this.f1214a, hashMap);
                hashMap.clear();
            }
        }
    }
}
