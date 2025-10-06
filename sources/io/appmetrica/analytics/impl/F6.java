package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes4.dex */
public final class F6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f440a;
    public final C0540qh b;

    public F6(Context context, C6 c6, Bb bb, InterfaceC0363jl interfaceC0363jl, Executor executor, String str) {
        this.f440a = executor;
        this.b = new C0540qh(context, c6, bb, interfaceC0363jl);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f440a;
        C0540qh c0540qh = this.b;
        Nb nb = c0540qh.c;
        Consumer consumer = c0540qh.e;
        Context context = c0540qh.f1052a;
        if (C0757za.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0757za.class)) {
                if (C0757za.c == null) {
                    C0757za.c = new C0757za(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0757za c0757za = C0757za.c;
        if (c0757za == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0757za = null;
        }
        executor.execute(new RunnableC0514pg(file, nb, nb, consumer, c0757za, c0540qh.b));
    }
}
