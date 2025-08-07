package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.d  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0194d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f806a = new AtomicBoolean(true);
    public final /* synthetic */ C0219e b;

    public C0194d(C0219e c0219e) {
        this.b = c0219e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && this.f806a.get()) {
            this.b.e.set(false);
            C0219e c0219e = this.b;
            c0219e.c.postAtFrontOfQueue(c0219e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C0219e.g);
                    if (this.b.e.get()) {
                        break;
                    }
                    i--;
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.f822a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0168c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                Thread.sleep(C0219e.g);
            }
        }
    }
}
