package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.w6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0680w6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1261a;
    public final C0380kh b;

    public C0680w6(Context context, InterfaceC0602t6 interfaceC0602t6, Db db, Fl fl, Executor executor, String str, D6 d6) {
        this.f1261a = executor;
        this.b = new C0380kh(context, interfaceC0602t6, db, fl, d6);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1261a;
        C0380kh c0380kh = this.b;
        Pb pb = c0380kh.d;
        Consumer consumer = c0380kh.f;
        Context context = c0380kh.f1068a;
        if (C0658va.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0658va.class)) {
                if (C0658va.c == null) {
                    C0658va.c = new C0658va(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0658va c0658va = C0658va.c;
        if (c0658va == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0658va = null;
        }
        executor.execute(new RunnableC0638ug(file, pb, pb, consumer, c0658va, c0380kh.b));
    }
}
