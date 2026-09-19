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
public final class C0351je implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1051a;
    public final IHandlerExecutor b = Na.k().w().f();
    public final C0429me c;

    public C0351je(Context context, C0328ih c0328ih, Function1<? super String, Unit> function1, InterfaceC0584se interfaceC0584se, Db db, String str, InterfaceC0507pe interfaceC0507pe) {
        this.f1051a = function1;
        this.c = new C0429me(context, c0328ih, interfaceC0584se, db, interfaceC0507pe);
    }

    public static final void a(C0351je c0351je, NativeCrash nativeCrash, File file) {
        c0351je.f1051a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        I0 i0;
        C0658va c0658va;
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
            C0429me c0429me = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.je$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    C0351je.a(C0351je.this, nativeCrash, (File) obj);
                }
            };
            c0429me.getClass();
            C0248fe c0248fe = new C0248fe(new C0300he(i0.f587a, i0.b), c0429me.g);
            C0171ce c0171ce = new C0171ce(c0429me.b, i0.f, new C0403le(i0, c0429me.d, c0429me.e));
            C0684wa c0684wa = c0429me.f;
            String str = i0.d;
            c0684wa.getClass();
            File file = new File(str);
            Context context = c0429me.f1098a;
            if (C0658va.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0658va.class)) {
                    if (C0658va.c == null) {
                        C0658va.c = new C0658va(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0658va c0658va2 = C0658va.c;
            if (c0658va2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0658va = null;
            } else {
                c0658va = c0658va2;
            }
            iHandlerExecutor.execute(new RunnableC0638ug(file, c0248fe, consumer, c0171ce, c0658va, c0429me.c.a(i0)));
            return;
        }
        this.f1051a.invoke(nativeCrash.getUuid());
    }
}
