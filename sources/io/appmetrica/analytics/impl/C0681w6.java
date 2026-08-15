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
public final class C0681w6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1261a;
    public final C0381kh b;

    public C0681w6(Context context, InterfaceC0603t6 interfaceC0603t6, Db db, Fl fl, Executor executor, String str, D6 d6) {
        this.f1261a = executor;
        this.b = new C0381kh(context, interfaceC0603t6, db, fl, d6);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1261a;
        C0381kh c0381kh = this.b;
        Pb pb = c0381kh.d;
        Consumer consumer = c0381kh.f;
        Context context = c0381kh.f1068a;
        if (C0659va.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0659va.class)) {
                if (C0659va.c == null) {
                    C0659va.c = new C0659va(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0659va c0659va = C0659va.c;
        if (c0659va == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0659va = null;
        }
        executor.execute(new RunnableC0639ug(file, pb, pb, consumer, c0659va, c0381kh.b));
    }
}
