package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.g6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0267g6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1008a;
    public final Ug b;

    public C0267g6(Context context, InterfaceC0190d6 interfaceC0190d6, EnumC0143bb enumC0143bb, InterfaceC0127al interfaceC0127al, Executor executor, String str) {
        this.f1008a = executor;
        this.b = new Ug(context, interfaceC0190d6, enumC0143bb, interfaceC0127al);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1008a;
        Ug ug = this.b;
        C0450nb c0450nb = ug.c;
        Consumer consumer = ug.e;
        Context context = ug.f814a;
        if (Z9.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(Z9.class)) {
                if (Z9.c == null) {
                    Z9.c = new Z9(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Z9 z9 = Z9.c;
        if (z9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            z9 = null;
        }
        executor.execute(new Tf(file, c0450nb, c0450nb, consumer, z9, ug.b));
    }
}
