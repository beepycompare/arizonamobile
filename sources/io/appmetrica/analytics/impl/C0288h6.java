package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.h6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0288h6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1016a;
    public final Vg b;

    public C0288h6(Context context, InterfaceC0210e6 interfaceC0210e6, EnumC0164cb enumC0164cb, InterfaceC0148bl interfaceC0148bl, Executor executor, String str) {
        this.f1016a = executor;
        this.b = new Vg(context, interfaceC0210e6, enumC0164cb, interfaceC0148bl);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1016a;
        Vg vg = this.b;
        C0471ob c0471ob = vg.c;
        Consumer consumer = vg.e;
        Context context = vg.f823a;
        if (C0111aa.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0111aa.class)) {
                if (C0111aa.c == null) {
                    C0111aa.c = new C0111aa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0111aa c0111aa = C0111aa.c;
        if (c0111aa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0111aa = null;
        }
        executor.execute(new Uf(file, c0471ob, c0471ob, consumer, c0111aa, vg.b));
    }
}
