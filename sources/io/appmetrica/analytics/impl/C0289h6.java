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
public final class C0289h6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f918a;
    public final Vg b;

    public C0289h6(Context context, InterfaceC0211e6 interfaceC0211e6, EnumC0165cb enumC0165cb, InterfaceC0149bl interfaceC0149bl, Executor executor, String str) {
        this.f918a = executor;
        this.b = new Vg(context, interfaceC0211e6, enumC0165cb, interfaceC0149bl);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f918a;
        Vg vg = this.b;
        C0472ob c0472ob = vg.c;
        Consumer consumer = vg.e;
        Context context = vg.f725a;
        if (C0112aa.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0112aa.class)) {
                if (C0112aa.c == null) {
                    C0112aa.c = new C0112aa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0112aa c0112aa = C0112aa.c;
        if (c0112aa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0112aa = null;
        }
        executor.execute(new Uf(file, c0472ob, c0472ob, consumer, c0112aa, vg.b));
    }
}
