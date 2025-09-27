package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.pg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0513pg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f1035a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0756za e;
    public final InterfaceC0362jl f;

    public RunnableC0513pg(File file, Function function, Consumer consumer, Consumer consumer2, C0756za c0756za, InterfaceC0362jl interfaceC0362jl) {
        this.f1035a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0756za;
        this.f = interfaceC0362jl;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1035a.exists()) {
            X9 b = this.e.b(this.f1035a.getName());
            Consumer consumer = this.c;
            try {
                b.f740a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f1035a.exists()) {
                consumer.consume(this.f1035a);
                b.c();
                C0756za c0756za = this.e;
                String name = this.f1035a.getName();
                synchronized (c0756za) {
                    c0756za.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f1035a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.pg$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            RunnableC0513pg.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f1035a);
            b.c();
            this.e.a(this.f1035a.getName());
        }
    }
}
