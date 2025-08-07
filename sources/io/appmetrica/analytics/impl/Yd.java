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
/* loaded from: classes4.dex */
public final class Yd implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f734a;
    public final IHandlerExecutor b = Ia.j().w().e();
    public final C0157be c;

    public Yd(Context context, C0263fh c0263fh, Function1<? super String, Unit> function1, InterfaceC0286ge interfaceC0286ge, EnumC0681wb enumC0681wb, String str) {
        this.f734a = function1;
        this.c = new C0157be(context, c0263fh, interfaceC0286ge, enumC0681wb);
    }

    public static final void a(Yd yd, NativeCrash nativeCrash, File file) {
        yd.f734a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        B0 b0;
        C0630ua c0630ua;
        try {
            NativeCrashSource source = nativeCrash.getSource();
            String handlerVersion = nativeCrash.getHandlerVersion();
            String uuid = nativeCrash.getUuid();
            String dumpFile = nativeCrash.getDumpFile();
            long creationTime = nativeCrash.getCreationTime();
            C0 a2 = D0.a(nativeCrash.getMetadata());
            Intrinsics.checkNotNull(a2);
            b0 = new B0(source, handlerVersion, uuid, dumpFile, creationTime, a2);
        } catch (Throwable unused) {
            b0 = null;
        }
        if (b0 != null) {
            LoggerStorage.getOrCreatePublicLogger(b0.f.f367a).info("Detected native crash with uuid = " + b0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            C0157be c0157be = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Yd$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    Yd.a(Yd.this, nativeCrash, (File) obj);
                }
            };
            c0157be.getClass();
            Ud ud = new Ud(new Wd(b0.f348a, b0.b), c0157be.f);
            Rd rd = new Rd(c0157be.b, b0.f, new C0131ae(b0, c0157be.d));
            C0655va c0655va = c0157be.e;
            String str = b0.d;
            c0655va.getClass();
            File file = new File(str);
            Context context = c0157be.f783a;
            if (C0630ua.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0630ua.class)) {
                    if (C0630ua.c == null) {
                        C0630ua.c = new C0630ua(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0630ua c0630ua2 = C0630ua.c;
            if (c0630ua2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0630ua = null;
            } else {
                c0630ua = c0630ua2;
            }
            iHandlerExecutor.execute(new RunnableC0288gg(file, ud, consumer, rd, c0630ua, c0157be.c.a(b0)));
            return;
        }
        this.f734a.invoke(nativeCrash.getUuid());
    }
}
