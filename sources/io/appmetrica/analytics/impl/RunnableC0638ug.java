package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0638ug implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f1235a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0658va e;
    public final Fl f;

    public RunnableC0638ug(File file, Function function, Consumer consumer, Consumer consumer2, C0658va c0658va, Fl fl) {
        this.f1235a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0658va;
        this.f = fl;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1235a.exists()) {
            R9 b = this.e.b(this.f1235a.getName());
            Consumer consumer = this.c;
            try {
                b.f744a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f1235a.exists()) {
                consumer.consume(this.f1235a);
                b.c();
                C0658va c0658va = this.e;
                String name = this.f1235a.getName();
                synchronized (c0658va) {
                    c0658va.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f1235a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.ug$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            RunnableC0638ug.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f1235a);
            b.c();
            this.e.a(this.f1235a.getName());
        }
    }
}
