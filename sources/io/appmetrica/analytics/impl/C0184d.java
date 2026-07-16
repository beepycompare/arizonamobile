package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0184d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f936a = new AtomicBoolean(true);
    public final /* synthetic */ C0209e b;

    public C0184d(C0209e c0209e) {
        this.b = c0209e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && this.f936a.get()) {
            this.b.e.set(false);
            C0209e c0209e = this.b;
            c0209e.c.postAtFrontOfQueue(c0209e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C0209e.g);
                    if (this.b.e.get()) {
                        break;
                    }
                    i--;
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.f954a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0158c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                Thread.sleep(C0209e.g);
            }
        }
    }
}
