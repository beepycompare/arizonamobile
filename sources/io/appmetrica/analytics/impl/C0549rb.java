package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.rb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0549rb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0574sb f1206a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0549rb(C0574sb c0574sb, String str) {
        super(str);
        this.f1206a = c0574sb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f1206a.f1221a) {
            C0574sb.a(this.f1206a);
            this.f1206a.e = true;
            this.f1206a.f1221a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f1206a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f1206a.b);
                this.f1206a.b.clear();
            }
            if (hashMap.size() > 0) {
                C0574sb.a(this.f1206a, hashMap);
                hashMap.clear();
            }
        }
    }
}
