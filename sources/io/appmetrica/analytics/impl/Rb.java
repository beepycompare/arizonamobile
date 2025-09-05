package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Rb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sb f649a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rb(Sb sb, String str) {
        super(str);
        this.f649a = sb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f649a.f665a) {
            Sb.a(this.f649a);
            this.f649a.e = true;
            this.f649a.f665a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f649a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f649a.b);
                this.f649a.b.clear();
            }
            if (hashMap.size() > 0) {
                Sb.a(this.f649a, hashMap);
                hashMap.clear();
            }
        }
    }
}
