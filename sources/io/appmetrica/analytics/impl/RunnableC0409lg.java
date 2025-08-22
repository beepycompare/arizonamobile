package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0409lg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f952a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0677wa e;
    public final InterfaceC0259fl f;

    public RunnableC0409lg(File file, Function function, Consumer consumer, Consumer consumer2, C0677wa c0677wa, InterfaceC0259fl interfaceC0259fl) {
        this.f952a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0677wa;
        this.f = interfaceC0259fl;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f952a.exists()) {
            U9 b = this.e.b(this.f952a.getName());
            Consumer consumer = this.c;
            try {
                b.f675a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f952a.exists()) {
                consumer.consume(this.f952a);
                b.c();
                C0677wa c0677wa = this.e;
                String name = this.f952a.getName();
                synchronized (c0677wa) {
                    c0677wa.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f952a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.lg$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            RunnableC0409lg.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f952a);
            b.c();
            this.e.a(this.f952a.getName());
        }
    }
}
