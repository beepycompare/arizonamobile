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
public final class C0226ee implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f861a;
    public final IHandlerExecutor b = Na.j().w().e();
    public final C0304he c;

    public C0226ee(Context context, C0488oh c0488oh, Function1<? super String, Unit> function1, InterfaceC0433me interfaceC0433me, Bb bb, String str) {
        this.f861a = function1;
        this.c = new C0304he(context, c0488oh, interfaceC0433me, bb);
    }

    public static final void a(C0226ee c0226ee, NativeCrash nativeCrash, File file) {
        c0226ee.f861a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        D0 d0;
        C0756za c0756za;
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
            C0304he c0304he = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.ee$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    C0226ee.a(C0226ee.this, nativeCrash, (File) obj);
                }
            };
            c0304he.getClass();
            C0123ae c0123ae = new C0123ae(new C0175ce(d0.f400a, d0.b), c0304he.f);
            Xd xd = new Xd(c0304he.b, d0.f, new C0278ge(d0, c0304he.d));
            Aa aa = c0304he.e;
            String str = d0.d;
            aa.getClass();
            File file = new File(str);
            Context context = c0304he.f910a;
            if (C0756za.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0756za.class)) {
                    if (C0756za.c == null) {
                        C0756za.c = new C0756za(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0756za c0756za2 = C0756za.c;
            if (c0756za2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0756za = null;
            } else {
                c0756za = c0756za2;
            }
            iHandlerExecutor.execute(new RunnableC0513pg(file, c0123ae, consumer, xd, c0756za, c0304he.c.a(d0)));
            return;
        }
        this.f861a.invoke(nativeCrash.getUuid());
    }
}
