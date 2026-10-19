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
public final class C0675w6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1264a;
    public final C0375kh b;

    public C0675w6(Context context, InterfaceC0597t6 interfaceC0597t6, Db db, Fl fl, Executor executor, String str, D6 d6) {
        this.f1264a = executor;
        this.b = new C0375kh(context, interfaceC0597t6, db, fl, d6);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1264a;
        C0375kh c0375kh = this.b;
        Pb pb = c0375kh.d;
        Consumer consumer = c0375kh.f;
        Context context = c0375kh.f1071a;
        if (C0653va.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0653va.class)) {
                if (C0653va.c == null) {
                    C0653va.c = new C0653va(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0653va c0653va = C0653va.c;
        if (c0653va == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0653va = null;
        }
        executor.execute(new RunnableC0633ug(file, pb, pb, consumer, c0653va, c0375kh.b));
    }
}
