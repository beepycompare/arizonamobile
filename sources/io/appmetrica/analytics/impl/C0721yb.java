package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.yb  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0721yb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0746zb f1213a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0721yb(C0746zb c0746zb, String str) {
        super(str);
        this.f1213a = c0746zb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f1213a.f1228a) {
            C0746zb.a(this.f1213a);
            this.f1213a.e = true;
            this.f1213a.f1228a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f1213a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f1213a.b);
                this.f1213a.b.clear();
            }
            if (hashMap.size() > 0) {
                C0746zb.a(this.f1213a, hashMap);
                hashMap.clear();
            }
        }
    }
}
