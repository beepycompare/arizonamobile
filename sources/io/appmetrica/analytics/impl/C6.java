package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes4.dex */
public final class C6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f372a;
    public final C0314hh b;

    public C6(Context context, InterfaceC0751z6 interfaceC0751z6, EnumC0681wb enumC0681wb, InterfaceC0138al interfaceC0138al, Executor executor, String str) {
        this.f372a = executor;
        this.b = new C0314hh(context, interfaceC0751z6, enumC0681wb, interfaceC0138al);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f372a;
        C0314hh c0314hh = this.b;
        Ib ib = c0314hh.c;
        Consumer consumer = c0314hh.e;
        Context context = c0314hh.f886a;
        if (C0630ua.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0630ua.class)) {
                if (C0630ua.c == null) {
                    C0630ua.c = new C0630ua(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0630ua c0630ua = C0630ua.c;
        if (c0630ua == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0630ua = null;
        }
        executor.execute(new RunnableC0288gg(file, ib, ib, consumer, c0630ua, c0314hh.b));
    }
}
