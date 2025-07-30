package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.gg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0287gg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f867a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0629ua e;
    public final InterfaceC0137al f;

    public RunnableC0287gg(File file, Function function, Consumer consumer, Consumer consumer2, C0629ua c0629ua, InterfaceC0137al interfaceC0137al) {
        this.f867a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0629ua;
        this.f = interfaceC0137al;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f867a.exists()) {
            S9 b = this.e.b(this.f867a.getName());
            Consumer consumer = this.c;
            try {
                b.f638a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f867a.exists()) {
                consumer.consume(this.f867a);
                b.c();
                C0629ua c0629ua = this.e;
                String name = this.f867a.getName();
                synchronized (c0629ua) {
                    c0629ua.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f867a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.gg$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            RunnableC0287gg.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f867a);
            b.c();
            this.e.a(this.f867a.getName());
        }
    }
}
