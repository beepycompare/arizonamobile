package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.networktasks.impl.d;
import io.appmetrica.analytics.networktasks.impl.f;
import io.appmetrica.analytics.networktasks.impl.g;
import io.appmetrica.analytics.networktasks.impl.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes4.dex */
public class NetworkCore extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingQueue f1238a;
    private final Object b;
    private final Object c;
    private volatile d d;
    private final g e;

    public NetworkCore() {
        this(new g());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        NetworkTask networkTask = null;
        while (isRunning()) {
            try {
                synchronized (this.c) {
                }
                this.d = (d) this.f1238a.take();
                networkTask = this.d.f1227a;
                Executor executor = networkTask.getExecutor();
                this.e.getClass();
                executor.execute(new h(networkTask, this, new f()));
                networkTask.onTaskFinished();
                synchronized (this.c) {
                    this.d = null;
                }
            } catch (InterruptedException unused) {
                if (networkTask != null) {
                    networkTask.onTaskFinished();
                    synchronized (this.c) {
                        this.d = null;
                    }
                } else {
                    continue;
                }
            } catch (Throwable th) {
                if (networkTask != null) {
                    networkTask.onTaskFinished();
                    synchronized (this.c) {
                        this.d = null;
                        networkTask.onTaskRemoved();
                    }
                }
                throw th;
            }
            networkTask.onTaskRemoved();
        }
    }

    public void startTask(NetworkTask networkTask) {
        synchronized (this.b) {
            d dVar = new d(networkTask);
            if (isRunning() && !this.f1238a.contains(dVar) && !dVar.equals(this.d) && networkTask.onTaskAdded()) {
                this.f1238a.offer(dVar);
            }
        }
    }

    public void stopTasks() {
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList(this.f1238a.size());
            this.f1238a.drainTo(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f1227a.onTaskRemoved();
            }
        }
    }

    NetworkCore(g gVar) {
        this.f1238a = new LinkedBlockingQueue();
        this.b = new Object();
        this.c = new Object();
        this.e = gVar;
    }
}
