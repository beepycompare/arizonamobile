package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrash;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.je  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0352je implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1051a;
    public final IHandlerExecutor b = Na.k().w().f();
    public final C0430me c;

    public C0352je(Context context, C0329ih c0329ih, Function1<? super String, Unit> function1, InterfaceC0585se interfaceC0585se, Db db, String str, InterfaceC0508pe interfaceC0508pe) {
        this.f1051a = function1;
        this.c = new C0430me(context, c0329ih, interfaceC0585se, db, interfaceC0508pe);
    }

    public static final void a(C0352je c0352je, NativeCrash nativeCrash, File file) {
        c0352je.f1051a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        I0 i0;
        C0659va c0659va;
        try {
            NativeCrashSource source = nativeCrash.getSource();
            String handlerVersion = nativeCrash.getHandlerVersion();
            String uuid = nativeCrash.getUuid();
            String dumpFile = nativeCrash.getDumpFile();
            long creationTime = nativeCrash.getCreationTime();
            J0 a2 = K0.a(nativeCrash.getMetadata());
            Intrinsics.checkNotNull(a2);
            i0 = new I0(source, handlerVersion, uuid, dumpFile, creationTime, a2);
        } catch (Throwable unused) {
            i0 = null;
        }
        if (i0 != null) {
            LoggerStorage.getOrCreatePublicLogger(i0.f.f604a).info("Detected native crash with uuid = " + i0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            C0430me c0430me = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.je$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    C0352je.a(C0352je.this, nativeCrash, (File) obj);
                }
            };
            c0430me.getClass();
            C0249fe c0249fe = new C0249fe(new C0301he(i0.f587a, i0.b), c0430me.g);
            C0172ce c0172ce = new C0172ce(c0430me.b, i0.f, new C0404le(i0, c0430me.d, c0430me.e));
            C0685wa c0685wa = c0430me.f;
            String str = i0.d;
            c0685wa.getClass();
            File file = new File(str);
            Context context = c0430me.f1098a;
            if (C0659va.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0659va.class)) {
                    if (C0659va.c == null) {
                        C0659va.c = new C0659va(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0659va c0659va2 = C0659va.c;
            if (c0659va2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0659va = null;
            } else {
                c0659va = c0659va2;
            }
            iHandlerExecutor.execute(new RunnableC0639ug(file, c0249fe, consumer, c0172ce, c0659va, c0430me.c.a(i0)));
            return;
        }
        this.f1051a.invoke(nativeCrash.getUuid());
    }
}
