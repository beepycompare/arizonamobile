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
public final class Wd implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f688a;
    public final IHandlerExecutor b = Ga.j().w().e();
    public final Zd c;

    public Wd(Context context, C0211dh c0211dh, Function1<? super String, Unit> function1, InterfaceC0233ee interfaceC0233ee, EnumC0628ub enumC0628ub, String str) {
        this.f688a = function1;
        this.c = new Zd(context, c0211dh, interfaceC0233ee, enumC0628ub);
    }

    public static final void a(Wd wd, NativeCrash nativeCrash, File file) {
        wd.f688a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        B0 b0;
        C0577sa c0577sa;
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
            LoggerStorage.getOrCreatePublicLogger(b0.f.f363a).info("Detected native crash with uuid = " + b0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            Zd zd = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Wd$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    Wd.a(Wd.this, nativeCrash, (File) obj);
                }
            };
            zd.getClass();
            Sd sd = new Sd(new Ud(b0.f346a, b0.b), zd.f);
            Pd pd = new Pd(zd.b, b0.f, new Yd(b0, zd.d));
            C0602ta c0602ta = zd.e;
            String str = b0.d;
            c0602ta.getClass();
            File file = new File(str);
            Context context = zd.f737a;
            if (C0577sa.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0577sa.class)) {
                    if (C0577sa.c == null) {
                        C0577sa.c = new C0577sa(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0577sa c0577sa2 = C0577sa.c;
            if (c0577sa2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0577sa = null;
            } else {
                c0577sa = c0577sa2;
            }
            iHandlerExecutor.execute(new RunnableC0235eg(file, sd, consumer, pd, c0577sa, zd.c.a(b0)));
            return;
        }
        this.f688a.invoke(nativeCrash.getUuid());
    }
}
