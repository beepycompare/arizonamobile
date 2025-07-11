package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.z6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0748z6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1160a;
    public final C0261fh b;

    public C0748z6(Context context, InterfaceC0673w6 interfaceC0673w6, EnumC0628ub enumC0628ub, Xk xk, Executor executor, String str) {
        this.f1160a = executor;
        this.b = new C0261fh(context, interfaceC0673w6, enumC0628ub, xk);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1160a;
        C0261fh c0261fh = this.b;
        Gb gb = c0261fh.c;
        Consumer consumer = c0261fh.e;
        Context context = c0261fh.f840a;
        if (C0577sa.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0577sa.class)) {
                if (C0577sa.c == null) {
                    C0577sa.c = new C0577sa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0577sa c0577sa = C0577sa.c;
        if (c0577sa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0577sa = null;
        }
        executor.execute(new RunnableC0235eg(file, gb, gb, consumer, c0577sa, c0261fh.b));
    }
}
