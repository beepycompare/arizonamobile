package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.sb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0570sb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0595tb f1200a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0570sb(C0595tb c0595tb, String str) {
        super(str);
        this.f1200a = c0595tb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f1200a.f1215a) {
            C0595tb.a(this.f1200a);
            this.f1200a.e = true;
            this.f1200a.f1215a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f1200a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f1200a.b);
                this.f1200a.b.clear();
            }
            if (hashMap.size() > 0) {
                C0595tb.a(this.f1200a, hashMap);
                hashMap.clear();
            }
        }
    }
}
