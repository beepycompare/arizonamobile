package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* loaded from: classes5.dex */
public final class Tf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f799a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final Z9 e;
    public final InterfaceC0126al f;

    public Tf(File file, Function function, Consumer consumer, Consumer consumer2, Z9 z9, InterfaceC0126al interfaceC0126al) {
        this.f799a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = z9;
        this.f = interfaceC0126al;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f799a.exists()) {
            C0696x9 b = this.e.b(this.f799a.getName());
            Consumer consumer = this.c;
            try {
                b.f1302a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f799a.exists()) {
                consumer.consume(this.f799a);
                b.c();
                Z9 z9 = this.e;
                String name = this.f799a.getName();
                synchronized (z9) {
                    z9.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f799a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Tf$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            Tf.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f799a);
            b.c();
            this.e.a(this.f799a.getName());
        }
    }
}
