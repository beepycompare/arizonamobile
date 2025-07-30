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
    public final Function1 f735a;
    public final IHandlerExecutor b = Ia.j().w().e();
    public final C0156be c;

    public Yd(Context context, C0262fh c0262fh, Function1<? super String, Unit> function1, InterfaceC0285ge interfaceC0285ge, EnumC0680wb enumC0680wb, String str) {
        this.f735a = function1;
        this.c = new C0156be(context, c0262fh, interfaceC0285ge, enumC0680wb);
    }

    public static final void a(Yd yd, NativeCrash nativeCrash, File file) {
        yd.f735a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        B0 b0;
        C0629ua c0629ua;
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
            LoggerStorage.getOrCreatePublicLogger(b0.f.f368a).info("Detected native crash with uuid = " + b0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            C0156be c0156be = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Yd$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    Yd.a(Yd.this, nativeCrash, (File) obj);
                }
            };
            c0156be.getClass();
            Ud ud = new Ud(new Wd(b0.f349a, b0.b), c0156be.f);
            Rd rd = new Rd(c0156be.b, b0.f, new C0130ae(b0, c0156be.d));
            C0654va c0654va = c0156be.e;
            String str = b0.d;
            c0654va.getClass();
            File file = new File(str);
            Context context = c0156be.f784a;
            if (C0629ua.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0629ua.class)) {
                    if (C0629ua.c == null) {
                        C0629ua.c = new C0629ua(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0629ua c0629ua2 = C0629ua.c;
            if (c0629ua2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0629ua = null;
            } else {
                c0629ua = c0629ua2;
            }
            iHandlerExecutor.execute(new RunnableC0287gg(file, ud, consumer, rd, c0629ua, c0156be.c.a(b0)));
            return;
        }
        this.f735a.invoke(nativeCrash.getUuid());
    }
}
