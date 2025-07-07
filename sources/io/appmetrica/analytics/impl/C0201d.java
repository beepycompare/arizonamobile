package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0201d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f791a = new AtomicBoolean(true);
    public final /* synthetic */ C0226e b;

    public C0201d(C0226e c0226e) {
        this.b = c0226e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && this.f791a.get()) {
            this.b.e.set(false);
            C0226e c0226e = this.b;
            c0226e.c.postAtFrontOfQueue(c0226e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C0226e.g);
                    if (this.b.e.get()) {
                        break;
                    }
                    i--;
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.f812a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0175c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                Thread.sleep(C0226e.g);
            }
        }
    }
}
