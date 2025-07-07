package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.eg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0243eg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f821a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0585sa e;
    public final Xk f;

    public RunnableC0243eg(File file, Function function, Consumer consumer, Consumer consumer2, C0585sa c0585sa, Xk xk) {
        this.f821a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0585sa;
        this.f = xk;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f821a.exists()) {
            P9 b = this.e.b(this.f821a.getName());
            Consumer consumer = this.c;
            try {
                b.f578a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f821a.exists()) {
                consumer.consume(this.f821a);
                b.c();
                C0585sa c0585sa = this.e;
                String name = this.f821a.getName();
                synchronized (c0585sa) {
                    c0585sa.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f821a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.eg$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            RunnableC0243eg.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f821a);
            b.c();
            this.e.a(this.f821a.getName());
        }
    }
}
