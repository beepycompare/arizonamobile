package com.arizona.game;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.settings.mods.ModsSynchronizer;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import org.json.JSONObject;
/* compiled from: ModsRuntime.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u001a\u0010\u0010\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/game/ModsRuntime;", "", "<init>", "()V", "started", "", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "Landroid/os/Handler;", "observers", "", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", RemoteConfigConstants.ResponseFieldKey.STATE, "attach", "observer", "detach", TtmlNode.START, "context", "Landroid/content/Context;", "selectedSource", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ModsRuntime {
    public static final int $stable = 0;
    public static final ModsRuntime INSTANCE = new ModsRuntime();
    private static final Handler main = new Handler(Looper.getMainLooper());
    private static final Set<Function1<JSONObject, Unit>> observers = new LinkedHashSet();
    private static boolean started;
    private static JSONObject state;

    private ModsRuntime() {
    }

    public final void attach(Function1<? super JSONObject, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        observers.add(observer);
        JSONObject jSONObject = state;
        if (jSONObject != null) {
            observer.invoke(jSONObject);
        }
    }

    public final void detach(Function1<? super JSONObject, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        observers.remove(observer);
    }

    public final synchronized void start(Context context, final String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (started) {
            return;
        }
        started = true;
        natives.setResourceOverlayUiHandler(new Consumer() { // from class: com.arizona.game.ModsRuntime$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ModsRuntime.main.post(new Runnable() { // from class: com.arizona.game.ModsRuntime$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ModsRuntime.start$lambda$0$0(r1);
                    }
                });
            }
        });
        if (str == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.arizona.game.ModsRuntime$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return ModsRuntime.start$lambda$1(runnable);
            }
        });
        natives.setResourceOverlaySyncHandler(new Runnable() { // from class: com.arizona.game.ModsRuntime$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ModsRuntime.start$lambda$2(atomicBoolean, threadPoolExecutor, applicationContext, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$0$0(String str) {
        JSONObject jSONObject = new JSONObject(str);
        state = jSONObject;
        for (Function1 function1 : CollectionsKt.toList(observers)) {
            function1.invoke(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Thread start$lambda$1(Runnable runnable) {
        return new Thread(runnable, "Mods runtime import");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void start$lambda$2(final AtomicBoolean atomicBoolean, ThreadPoolExecutor threadPoolExecutor, final Context context, final String str) {
        if (atomicBoolean.compareAndSet(false, true)) {
            threadPoolExecutor.execute(new Runnable() { // from class: com.arizona.game.ModsRuntime$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ModsRuntime.start$lambda$2$0(atomicBoolean, context, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$2$0(AtomicBoolean atomicBoolean, Context context, String str) {
        Object m9974constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(context);
            m9974constructorimpl = Result.m9974constructorimpl(ModsSynchronizer.synchronize$default(new ModsSynchronizer(context), str, true, null, 4, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9974constructorimpl = Result.m9974constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9977exceptionOrNullimpl = Result.m9977exceptionOrNullimpl(m9974constructorimpl);
        if (m9977exceptionOrNullimpl != null) {
            Log.e("Mods", "Runtime import failed", m9977exceptionOrNullimpl);
        }
        atomicBoolean.set(false);
        String message = m9977exceptionOrNullimpl != null ? m9977exceptionOrNullimpl.getMessage() : null;
        if (message == null) {
            message = "";
        }
        natives.completeResourceOverlaySync(message);
    }
}
