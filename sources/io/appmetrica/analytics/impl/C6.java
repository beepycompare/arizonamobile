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
    public final Executor f375a;
    public final C0435mh b;

    public C6(Context context, InterfaceC0748z6 interfaceC0748z6, EnumC0728yb enumC0728yb, InterfaceC0259fl interfaceC0259fl, Executor executor, String str) {
        this.f375a = executor;
        this.b = new C0435mh(context, interfaceC0748z6, enumC0728yb, interfaceC0259fl);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f375a;
        C0435mh c0435mh = this.b;
        Kb kb = c0435mh.c;
        Consumer consumer = c0435mh.e;
        Context context = c0435mh.f969a;
        if (C0677wa.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0677wa.class)) {
                if (C0677wa.c == null) {
                    C0677wa.c = new C0677wa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0677wa c0677wa = C0677wa.c;
        if (c0677wa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0677wa = null;
        }
        executor.execute(new RunnableC0409lg(file, kb, kb, consumer, c0677wa, c0435mh.b));
    }
}
