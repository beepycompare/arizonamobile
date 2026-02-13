package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0183d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f946a = new AtomicBoolean(true);
    public final /* synthetic */ C0208e b;

    public C0183d(C0208e c0208e) {
        this.b = c0208e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && this.f946a.get()) {
            this.b.e.set(false);
            C0208e c0208e = this.b;
            c0208e.c.postAtFrontOfQueue(c0208e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C0208e.g);
                    if (this.b.e.get()) {
                        break;
                    }
                    i--;
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.f965a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0157c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                Thread.sleep(C0208e.g);
            }
        }
    }
}
