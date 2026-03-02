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
public final class C0266g6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1007a;
    public final Ug b;

    public C0266g6(Context context, InterfaceC0189d6 interfaceC0189d6, EnumC0142bb enumC0142bb, InterfaceC0126al interfaceC0126al, Executor executor, String str) {
        this.f1007a = executor;
        this.b = new Ug(context, interfaceC0189d6, enumC0142bb, interfaceC0126al);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1007a;
        Ug ug = this.b;
        C0449nb c0449nb = ug.c;
        Consumer consumer = ug.e;
        Context context = ug.f813a;
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
        executor.execute(new Tf(file, c0449nb, c0449nb, consumer, z9, ug.b));
    }
}
