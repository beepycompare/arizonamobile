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
    public final Executor f439a;
    public final C0539qh b;

    public F6(Context context, C6 c6, Bb bb, InterfaceC0362jl interfaceC0362jl, Executor executor, String str) {
        this.f439a = executor;
        this.b = new C0539qh(context, c6, bb, interfaceC0362jl);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f439a;
        C0539qh c0539qh = this.b;
        Nb nb = c0539qh.c;
        Consumer consumer = c0539qh.e;
        Context context = c0539qh.f1051a;
        if (C0756za.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0756za.class)) {
                if (C0756za.c == null) {
                    C0756za.c = new C0756za(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0756za c0756za = C0756za.c;
        if (c0756za == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0756za = null;
        }
        executor.execute(new RunnableC0513pg(file, nb, nb, consumer, c0756za, c0539qh.b));
    }
}
