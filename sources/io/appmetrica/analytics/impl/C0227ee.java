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
/* renamed from: io.appmetrica.analytics.impl.ee  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0227ee implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f861a;
    public final IHandlerExecutor b = Na.j().w().e();
    public final C0305he c;

    public C0227ee(Context context, C0489oh c0489oh, Function1<? super String, Unit> function1, InterfaceC0434me interfaceC0434me, Bb bb, String str) {
        this.f861a = function1;
        this.c = new C0305he(context, c0489oh, interfaceC0434me, bb);
    }

    public static final void a(C0227ee c0227ee, NativeCrash nativeCrash, File file) {
        c0227ee.f861a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        D0 d0;
        C0757za c0757za;
        try {
            NativeCrashSource source = nativeCrash.getSource();
            String handlerVersion = nativeCrash.getHandlerVersion();
            String uuid = nativeCrash.getUuid();
            String dumpFile = nativeCrash.getDumpFile();
            long creationTime = nativeCrash.getCreationTime();
            E0 a2 = F0.a(nativeCrash.getMetadata());
            Intrinsics.checkNotNull(a2);
            d0 = new D0(source, handlerVersion, uuid, dumpFile, creationTime, a2);
        } catch (Throwable unused) {
            d0 = null;
        }
        if (d0 != null) {
            LoggerStorage.getOrCreatePublicLogger(d0.f.f420a).info("Detected native crash with uuid = " + d0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            C0305he c0305he = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.ee$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    C0227ee.a(C0227ee.this, nativeCrash, (File) obj);
                }
            };
            c0305he.getClass();
            C0124ae c0124ae = new C0124ae(new C0176ce(d0.f400a, d0.b), c0305he.f);
            Xd xd = new Xd(c0305he.b, d0.f, new C0279ge(d0, c0305he.d));
            Aa aa = c0305he.e;
            String str = d0.d;
            aa.getClass();
            File file = new File(str);
            Context context = c0305he.f910a;
            if (C0757za.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0757za.class)) {
                    if (C0757za.c == null) {
                        C0757za.c = new C0757za(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0757za c0757za2 = C0757za.c;
            if (c0757za2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0757za = null;
            } else {
                c0757za = c0757za2;
            }
            iHandlerExecutor.execute(new RunnableC0514pg(file, c0124ae, consumer, xd, c0757za, c0305he.c.a(d0)));
            return;
        }
        this.f861a.invoke(nativeCrash.getUuid());
    }
}
