package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.gg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0288gg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f866a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0630ua e;
    public final InterfaceC0138al f;

    public RunnableC0288gg(File file, Function function, Consumer consumer, Consumer consumer2, C0630ua c0630ua, InterfaceC0138al interfaceC0138al) {
        this.f866a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0630ua;
        this.f = interfaceC0138al;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f866a.exists()) {
            S9 b = this.e.b(this.f866a.getName());
            Consumer consumer = this.c;
            try {
                b.f637a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f866a.exists()) {
                consumer.consume(this.f866a);
                b.c();
                C0630ua c0630ua = this.e;
                String name = this.f866a.getName();
                synchronized (c0630ua) {
                    c0630ua.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f866a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.gg$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            RunnableC0288gg.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f866a);
            b.c();
            this.e.a(this.f866a.getName());
        }
    }
}
