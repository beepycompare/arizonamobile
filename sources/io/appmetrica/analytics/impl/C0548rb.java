package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.rb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0548rb extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0573sb f1210a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0548rb(C0573sb c0573sb, String str) {
        super(str);
        this.f1210a = c0573sb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        synchronized (this.f1210a.f1225a) {
            C0573sb.a(this.f1210a);
            this.f1210a.e = true;
            this.f1210a.f1225a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f1210a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                hashMap = new HashMap(this.f1210a.b);
                this.f1210a.b.clear();
            }
            if (hashMap.size() > 0) {
                C0573sb.a(this.f1210a, hashMap);
                hashMap.clear();
            }
        }
    }
}
