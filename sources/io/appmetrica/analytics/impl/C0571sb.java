package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.sb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0571sb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0596tb f1117a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0571sb(C0596tb c0596tb, String str) {
        super(str);
        this.f1117a = c0596tb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f1117a.f1132a) {
            C0596tb.a(this.f1117a);
            this.f1117a.e = true;
            this.f1117a.f1132a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f1117a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f1117a.b);
                this.f1117a.b.clear();
            }
            if (hashMap.size() > 0) {
                C0596tb.a(this.f1117a, hashMap);
                hashMap.clear();
            }
        }
    }
}
