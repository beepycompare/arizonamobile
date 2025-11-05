package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.n6  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0442n6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1020a;
    public final Zg b;

    public C0442n6(Context context, InterfaceC0366k6 interfaceC0366k6, EnumC0320ib enumC0320ib, InterfaceC0226el interfaceC0226el, Executor executor, String str) {
        this.f1020a = executor;
        this.b = new Zg(context, interfaceC0366k6, enumC0320ib, interfaceC0226el);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1020a;
        Zg zg = this.b;
        C0621ub c0621ub = zg.c;
        Consumer consumer = zg.e;
        Context context = zg.f788a;
        if (C0267ga.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0267ga.class)) {
                if (C0267ga.c == null) {
                    C0267ga.c = new C0267ga(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0267ga c0267ga = C0267ga.c;
        if (c0267ga == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0267ga = null;
        }
        executor.execute(new Yf(file, c0621ub, c0621ub, consumer, c0267ga, zg.b));
    }
}
