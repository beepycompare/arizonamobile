package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* loaded from: classes5.dex */
public final class Uf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f711a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0112aa e;
    public final InterfaceC0149bl f;

    public Uf(File file, Function function, Consumer consumer, Consumer consumer2, C0112aa c0112aa, InterfaceC0149bl interfaceC0149bl) {
        this.f711a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0112aa;
        this.f = interfaceC0149bl;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f711a.exists()) {
            C0719y9 b = this.e.b(this.f711a.getName());
            Consumer consumer = this.c;
            try {
                b.f1215a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f711a.exists()) {
                consumer.consume(this.f711a);
                b.c();
                C0112aa c0112aa = this.e;
                String name = this.f711a.getName();
                synchronized (c0112aa) {
                    c0112aa.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f711a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Uf$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            Uf.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f711a);
            b.c();
            this.e.a(this.f711a.getName());
        }
    }
}
