package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0193d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f792a = new AtomicBoolean(true);
    public final /* synthetic */ C0218e b;

    public C0193d(C0218e c0218e) {
        this.b = c0218e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && this.f792a.get()) {
            this.b.e.set(false);
            C0218e c0218e = this.b;
            c0218e.c.postAtFrontOfQueue(c0218e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C0218e.g);
                    if (this.b.e.get()) {
                        break;
                    }
                    i--;
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.f813a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0167c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                Thread.sleep(C0218e.g);
            }
        }
    }
}
