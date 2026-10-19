package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0177d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f939a = new AtomicBoolean(true);
    public final /* synthetic */ C0202e b;

    public C0177d(C0202e c0202e) {
        this.b = c0202e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && this.f939a.get()) {
            this.b.e.set(false);
            C0202e c0202e = this.b;
            c0202e.c.postAtFrontOfQueue(c0202e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C0202e.g);
                    if (this.b.e.get()) {
                        break;
                    }
                    i--;
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.f957a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0151c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                Thread.sleep(C0202e.g);
            }
        }
    }
}
