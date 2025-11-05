package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* loaded from: classes3.dex */
public final class Yf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f771a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0267ga e;
    public final InterfaceC0226el f;

    public Yf(File file, Function function, Consumer consumer, Consumer consumer2, C0267ga c0267ga, InterfaceC0226el interfaceC0226el) {
        this.f771a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0267ga;
        this.f = interfaceC0226el;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f771a.exists()) {
            E9 b = this.e.b(this.f771a.getName());
            Consumer consumer = this.c;
            try {
                b.f456a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f771a.exists()) {
                consumer.consume(this.f771a);
                b.c();
                C0267ga c0267ga = this.e;
                String name = this.f771a.getName();
                synchronized (c0267ga) {
                    c0267ga.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f771a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Yf$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            Yf.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f771a);
            b.c();
            this.e.a(this.f771a.getName());
        }
    }
}
