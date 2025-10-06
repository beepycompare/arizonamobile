package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0187d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f832a = new AtomicBoolean(true);
    public final /* synthetic */ C0212e b;

    public C0187d(C0212e c0212e) {
        this.b = c0212e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && this.f832a.get()) {
            this.b.e.set(false);
            C0212e c0212e = this.b;
            c0212e.c.postAtFrontOfQueue(c0212e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C0212e.g);
                    if (this.b.e.get()) {
                        break;
                    }
                    i--;
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.f852a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0161c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                Thread.sleep(C0212e.g);
            }
        }
    }
}
