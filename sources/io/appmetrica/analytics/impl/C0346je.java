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
public final class C0346je implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1054a;
    public final IHandlerExecutor b = Na.k().w().f();
    public final C0424me c;

    public C0346je(Context context, C0323ih c0323ih, Function1<? super String, Unit> function1, InterfaceC0579se interfaceC0579se, Db db, String str, InterfaceC0502pe interfaceC0502pe) {
        this.f1054a = function1;
        this.c = new C0424me(context, c0323ih, interfaceC0579se, db, interfaceC0502pe);
    }

    public static final void a(C0346je c0346je, NativeCrash nativeCrash, File file) {
        c0346je.f1054a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        I0 i0;
        C0653va c0653va;
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
            LoggerStorage.getOrCreatePublicLogger(i0.f.f607a).info("Detected native crash with uuid = " + i0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            C0424me c0424me = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.je$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    C0346je.a(C0346je.this, nativeCrash, (File) obj);
                }
            };
            c0424me.getClass();
            C0243fe c0243fe = new C0243fe(new C0295he(i0.f590a, i0.b), c0424me.g);
            C0166ce c0166ce = new C0166ce(c0424me.b, i0.f, new C0398le(i0, c0424me.d, c0424me.e));
            C0679wa c0679wa = c0424me.f;
            String str = i0.d;
            c0679wa.getClass();
            File file = new File(str);
            Context context = c0424me.f1101a;
            if (C0653va.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0653va.class)) {
                    if (C0653va.c == null) {
                        C0653va.c = new C0653va(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0653va c0653va2 = C0653va.c;
            if (c0653va2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0653va = null;
            } else {
                c0653va = c0653va2;
            }
            iHandlerExecutor.execute(new RunnableC0633ug(file, c0243fe, consumer, c0166ce, c0653va, c0424me.c.a(i0)));
            return;
        }
        this.f1054a.invoke(nativeCrash.getUuid());
    }
}
