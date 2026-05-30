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
public final class C0353je implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1049a;
    public final IHandlerExecutor b = Na.k().w().f();
    public final C0431me c;

    public C0353je(Context context, C0330ih c0330ih, Function1<? super String, Unit> function1, InterfaceC0586se interfaceC0586se, Db db, String str, InterfaceC0509pe interfaceC0509pe) {
        this.f1049a = function1;
        this.c = new C0431me(context, c0330ih, interfaceC0586se, db, interfaceC0509pe);
    }

    public static final void a(C0353je c0353je, NativeCrash nativeCrash, File file) {
        c0353je.f1049a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        I0 i0;
        C0660va c0660va;
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
            LoggerStorage.getOrCreatePublicLogger(i0.f.f602a).info("Detected native crash with uuid = " + i0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            C0431me c0431me = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.je$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    C0353je.a(C0353je.this, nativeCrash, (File) obj);
                }
            };
            c0431me.getClass();
            C0250fe c0250fe = new C0250fe(new C0302he(i0.f585a, i0.b), c0431me.g);
            C0173ce c0173ce = new C0173ce(c0431me.b, i0.f, new C0405le(i0, c0431me.d, c0431me.e));
            C0686wa c0686wa = c0431me.f;
            String str = i0.d;
            c0686wa.getClass();
            File file = new File(str);
            Context context = c0431me.f1096a;
            if (C0660va.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0660va.class)) {
                    if (C0660va.c == null) {
                        C0660va.c = new C0660va(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0660va c0660va2 = C0660va.c;
            if (c0660va2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0660va = null;
            } else {
                c0660va = c0660va2;
            }
            iHandlerExecutor.execute(new RunnableC0640ug(file, c0250fe, consumer, c0173ce, c0660va, c0431me.c.a(i0)));
            return;
        }
        this.f1049a.invoke(nativeCrash.getUuid());
    }
}
