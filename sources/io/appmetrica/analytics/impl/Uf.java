package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* loaded from: classes5.dex */
public final class Uf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f808a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0111aa e;
    public final InterfaceC0148bl f;

    public Uf(File file, Function function, Consumer consumer, Consumer consumer2, C0111aa c0111aa, InterfaceC0148bl interfaceC0148bl) {
        this.f808a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0111aa;
        this.f = interfaceC0148bl;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f808a.exists()) {
            C0718y9 b = this.e.b(this.f808a.getName());
            Consumer consumer = this.c;
            try {
                b.f1312a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f808a.exists()) {
                consumer.consume(this.f808a);
                b.c();
                C0111aa c0111aa = this.e;
                String name = this.f808a.getName();
                synchronized (c0111aa) {
                    c0111aa.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f808a);
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
            consumer.consume(this.f808a);
            b.c();
            this.e.a(this.f808a.getName());
        }
    }
}
