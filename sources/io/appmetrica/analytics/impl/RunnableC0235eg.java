package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.eg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0235eg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f822a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0577sa e;
    public final Xk f;

    public RunnableC0235eg(File file, Function function, Consumer consumer, Consumer consumer2, C0577sa c0577sa, Xk xk) {
        this.f822a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0577sa;
        this.f = xk;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f822a.exists()) {
            P9 b = this.e.b(this.f822a.getName());
            Consumer consumer = this.c;
            try {
                b.f579a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f822a.exists()) {
                consumer.consume(this.f822a);
                b.c();
                C0577sa c0577sa = this.e;
                String name = this.f822a.getName();
                synchronized (c0577sa) {
                    c0577sa.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f822a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.eg$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            RunnableC0235eg.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f822a);
            b.c();
            this.e.a(this.f822a.getName());
        }
    }
}
