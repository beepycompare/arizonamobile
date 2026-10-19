package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0633ug implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f1238a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;
    public final C0653va e;
    public final Fl f;

    public RunnableC0633ug(File file, Function function, Consumer consumer, Consumer consumer2, C0653va c0653va, Fl fl) {
        this.f1238a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
        this.e = c0653va;
        this.f = fl;
    }

    public static final void a(File file) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1238a.exists()) {
            R9 b = this.e.b(this.f1238a.getName());
            Consumer consumer = this.c;
            try {
                b.f747a.lock();
                b.b.a();
            } catch (Throwable unused) {
            }
            if (!this.f1238a.exists()) {
                consumer.consume(this.f1238a);
                b.c();
                C0653va c0653va = this.e;
                String name = this.f1238a.getName();
                synchronized (c0653va) {
                    c0653va.b.remove(name);
                }
                return;
            }
            Object apply = this.b.apply(this.f1238a);
            if (apply != null) {
                if (this.f.a(apply)) {
                    this.d.consume(apply);
                } else {
                    consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.ug$$ExternalSyntheticLambda0
                        @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                        public final void consume(Object obj) {
                            RunnableC0633ug.a((File) obj);
                        }
                    };
                }
            }
            consumer.consume(this.f1238a);
            b.c();
            this.e.a(this.f1238a.getName());
        }
    }
}
