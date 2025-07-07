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
public final class C0756z6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1159a;
    public final C0269fh b;

    public C0756z6(Context context, InterfaceC0681w6 interfaceC0681w6, EnumC0636ub enumC0636ub, Xk xk, Executor executor, String str) {
        this.f1159a = executor;
        this.b = new C0269fh(context, interfaceC0681w6, enumC0636ub, xk);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1159a;
        C0269fh c0269fh = this.b;
        Gb gb = c0269fh.c;
        Consumer consumer = c0269fh.e;
        Context context = c0269fh.f839a;
        if (C0585sa.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0585sa.class)) {
                if (C0585sa.c == null) {
                    C0585sa.c = new C0585sa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0585sa c0585sa = C0585sa.c;
        if (c0585sa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0585sa = null;
        }
        executor.execute(new RunnableC0243eg(file, gb, gb, consumer, c0585sa, c0269fh.b));
    }
}
