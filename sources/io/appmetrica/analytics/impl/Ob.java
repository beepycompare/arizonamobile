package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ob extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Pb f589a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ob(Pb pb, String str) {
        super(str);
        this.f589a = pb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f589a.f603a) {
            Pb.a(this.f589a);
            this.f589a.e = true;
            this.f589a.f603a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f589a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f589a.b);
                this.f589a.b.clear();
            }
            if (hashMap.size() > 0) {
                Pb.a(this.f589a, hashMap);
                hashMap.clear();
            }
        }
    }
}
