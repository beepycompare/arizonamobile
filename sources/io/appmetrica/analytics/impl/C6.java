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
    public final Executor f373a;
    public final C0313hh b;

    public C6(Context context, InterfaceC0750z6 interfaceC0750z6, EnumC0680wb enumC0680wb, InterfaceC0137al interfaceC0137al, Executor executor, String str) {
        this.f373a = executor;
        this.b = new C0313hh(context, interfaceC0750z6, enumC0680wb, interfaceC0137al);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f373a;
        C0313hh c0313hh = this.b;
        Ib ib = c0313hh.c;
        Consumer consumer = c0313hh.e;
        Context context = c0313hh.f887a;
        if (C0629ua.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0629ua.class)) {
                if (C0629ua.c == null) {
                    C0629ua.c = new C0629ua(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0629ua c0629ua = C0629ua.c;
        if (c0629ua == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0629ua = null;
        }
        executor.execute(new RunnableC0287gg(file, ib, ib, consumer, c0629ua, c0313hh.b));
    }
}
