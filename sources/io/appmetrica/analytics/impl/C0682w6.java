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
public final class C0682w6 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1259a;
    public final C0382kh b;

    public C0682w6(Context context, InterfaceC0604t6 interfaceC0604t6, Db db, Fl fl, Executor executor, String str, D6 d6) {
        this.f1259a = executor;
        this.b = new C0382kh(context, interfaceC0604t6, db, fl, d6);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(File file) {
        if (file == null) {
            return;
        }
        Executor executor = this.f1259a;
        C0382kh c0382kh = this.b;
        Pb pb = c0382kh.d;
        Consumer consumer = c0382kh.f;
        Context context = c0382kh.f1066a;
        if (C0660va.c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0660va.class)) {
                if (C0660va.c == null) {
                    C0660va.c = new C0660va(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0660va c0660va = C0660va.c;
        if (c0660va == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            c0660va = null;
        }
        executor.execute(new RunnableC0640ug(file, pb, pb, consumer, c0660va, c0382kh.b));
    }
}
