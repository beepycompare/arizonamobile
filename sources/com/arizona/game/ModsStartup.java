package com.arizona.game;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.settings.mods.ModsPreferences;
import com.miami.game.core.settings.mods.ModsStorage;
import com.miami.game.core.settings.mods.ModsSynchronizer;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import org.json.JSONObject;
/* compiled from: ModsStartup.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u001a\u0010\u0018\u001a\u00020\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0006\u0010\u001b\u001a\u00020\fJ\u0006\u0010\u001c\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u001a\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0006\u0010%\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/arizona/game/ModsStartup;", "", "<init>", "()V", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "Landroid/os/Handler;", "worker", "Ljava/util/concurrent/ThreadPoolExecutor;", "listeners", "", "Lkotlin/Function1;", "Lcom/arizona/game/ModsStartup$State;", "", "started", "", "running", RemoteConfigConstants.ResponseFieldKey.STATE, "source", "", "app", "Landroid/content/Context;", "attach", "context", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "detach", "publish", "next", "withoutMods", "previous", "configureReload", "Lorg/json/JSONObject;", "config", "finish", "hotReload", "validate", "validateAndFinish", "rawConfig", "retry", "State", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ModsStartup {
    public static final int $stable = 0;
    private static Context app;
    private static boolean running;
    private static String source;
    private static boolean started;
    public static final ModsStartup INSTANCE = new ModsStartup();
    private static final Handler main = new Handler(Looper.getMainLooper());
    private static final ThreadPoolExecutor worker = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda6
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return ModsStartup.worker$lambda$0(runnable);
        }
    });
    private static final Set<Function1<State, Unit>> listeners = new LinkedHashSet();
    private static State state = new State(null, null, null, null, 15, null);

    /* compiled from: ModsStartup.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013Ê\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001e"}, d2 = {"Lcom/arizona/game/ModsStartup$State;", "", "progress", "Lcom/miami/game/core/settings/mods/ModsSynchronizer$Progress;", "config", "", "error", "previous", "<init>", "(Lcom/miami/game/core/settings/mods/ModsSynchronizer$Progress;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProgress", "()Lcom/miami/game/core/settings/mods/ModsSynchronizer$Progress;", "getConfig", "()Ljava/lang/String;", "getError", "getPrevious", "hasPreparationUi", "", "getHasPreparationUi", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class State {
        public static final int $stable = 8;
        private final String config;
        private final String error;
        private final String previous;
        private final ModsSynchronizer.Progress progress;

        public State() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ State copy$default(State state, ModsSynchronizer.Progress progress, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                progress = state.progress;
            }
            if ((i & 2) != 0) {
                str = state.config;
            }
            if ((i & 4) != 0) {
                str2 = state.error;
            }
            if ((i & 8) != 0) {
                str3 = state.previous;
            }
            return state.copy(progress, str, str2, str3);
        }

        public final ModsSynchronizer.Progress component1() {
            return this.progress;
        }

        public final String component2() {
            return this.config;
        }

        public final String component3() {
            return this.error;
        }

        public final String component4() {
            return this.previous;
        }

        public final State copy(ModsSynchronizer.Progress progress, String str, String str2, String str3) {
            return new State(progress, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof State) {
                State state = (State) obj;
                return Intrinsics.areEqual(this.progress, state.progress) && Intrinsics.areEqual(this.config, state.config) && Intrinsics.areEqual(this.error, state.error) && Intrinsics.areEqual(this.previous, state.previous);
            }
            return false;
        }

        public int hashCode() {
            ModsSynchronizer.Progress progress = this.progress;
            int hashCode = (progress == null ? 0 : progress.hashCode()) * 31;
            String str = this.config;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.error;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.previous;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            ModsSynchronizer.Progress progress = this.progress;
            String str = this.config;
            String str2 = this.error;
            return "State(progress=" + progress + ", config=" + str + ", error=" + str2 + ", previous=" + this.previous + ")";
        }

        public State(ModsSynchronizer.Progress progress, String str, String str2, String str3) {
            this.progress = progress;
            this.config = str;
            this.error = str2;
            this.previous = str3;
        }

        public /* synthetic */ State(ModsSynchronizer.Progress progress, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : progress, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final String getConfig() {
            return this.config;
        }

        public final ModsSynchronizer.Progress getProgress() {
            return this.progress;
        }

        public final String getError() {
            return this.error;
        }

        public final String getPrevious() {
            return this.previous;
        }

        public final boolean getHasPreparationUi() {
            if (this.config == null) {
                return (this.progress == null && this.error == null) ? false : true;
            }
            return false;
        }
    }

    private ModsStartup() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Thread worker$lambda$0(Runnable runnable) {
        return new Thread(runnable, "Mods preparation");
    }

    public final void attach(Context context, Function1<? super State, Unit> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
        if (!started) {
            started = true;
            app = context.getApplicationContext();
            source = ModsPreferences.INSTANCE.prefs(context).getString(ModsPreferences.SOURCE, null);
            retry();
            return;
        }
        listener.invoke(state);
    }

    public final void detach(Function1<? super State, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    private final void publish(State state2) {
        state = state2;
        for (Function1 function1 : CollectionsKt.toList(listeners)) {
            function1.invoke(state2);
        }
    }

    public final void withoutMods() {
        if (running) {
            return;
        }
        validateAndFinish("{}");
    }

    public final void previous() {
        String previous;
        if (running || (previous = state.getPrevious()) == null) {
            return;
        }
        INSTANCE.validateAndFinish(previous);
    }

    private final JSONObject configureReload(JSONObject jSONObject) {
        Context context = app;
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        JSONObject put = jSONObject.put("hotReload", jSONObject.optBoolean("enabled", false) && ModsPreferences.INSTANCE.hotReloadCapable(context)).put("language", context.getResources().getConfiguration().getLocales().get(0).getLanguage());
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        return put;
    }

    static /* synthetic */ void finish$default(ModsStartup modsStartup, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        modsStartup.finish(str, z);
    }

    private final void finish(String str, boolean z) {
        if (z) {
            ModsRuntime modsRuntime = ModsRuntime.INSTANCE;
            Context context = app;
            if (context == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            modsRuntime.start(context, source);
        }
        worker.shutdown();
        publish(new State(null, str, null, null, 13, null));
    }

    private final void validate(String str) {
        Context context = app;
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            String prepareResourceOverlay = natives.prepareResourceOverlay(str, externalFilesDir.getAbsolutePath());
            Intrinsics.checkNotNull(prepareResourceOverlay);
            if (prepareResourceOverlay.length() != 0) {
                throw new IllegalStateException(prepareResourceOverlay.toString());
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void validateAndFinish(String str) {
        if (running || state.getConfig() != null) {
            return;
        }
        final Context context = app;
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        JSONObject configureReload = configureReload(new JSONObject(str));
        final boolean optBoolean = configureReload.optBoolean("enabled");
        final boolean z = configureReload.getBoolean("hotReload");
        final String jSONObject = configureReload.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        running = true;
        final String previous = state.getPrevious();
        worker.execute(new Runnable() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                ModsStartup.validateAndFinish$lambda$0(optBoolean, context, jSONObject, z, previous);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void validateAndFinish$lambda$0(final boolean z, Context context, final String str, final boolean z2, final String str2) {
        try {
            if (!z) {
                ModsStorage.INSTANCE.clearImportedCopies(context);
            } else {
                INSTANCE.validate(str);
            }
            main.post(new Runnable() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    ModsStartup.validateAndFinish$lambda$0$0(z, str, z2);
                }
            });
        } catch (Exception e) {
            main.post(new Runnable() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    ModsStartup.validateAndFinish$lambda$0$1(e, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateAndFinish$lambda$0$0(boolean z, String str, boolean z2) {
        running = false;
        ModsStartup modsStartup = INSTANCE;
        if (!z) {
            str = "{}";
        }
        modsStartup.finish(str, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateAndFinish$lambda$0$1(Exception exc, String str) {
        running = false;
        ModsStartup modsStartup = INSTANCE;
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        modsStartup.publish(new State(null, null, message, str, 3, null));
    }

    public final void retry() {
        final Context context;
        if (running || state.getConfig() != null || (context = app) == null) {
            return;
        }
        running = true;
        publish(new State(new ModsSynchronizer.Progress(true, null, 0, 0L, 0L, 30, null), null, null, null, 14, null));
        worker.execute(new Runnable() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ModsStartup.retry$lambda$0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void retry$lambda$0(Context context) {
        JSONObject lastGood;
        JSONObject synchronize$default;
        ModsSynchronizer modsSynchronizer = new ModsSynchronizer(context);
        final String str = null;
        try {
            String str2 = source;
            if (str2 == null) {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                synchronize$default = new JSONObject().put("enabled", true).put("source", "directory").put("root", new File(externalFilesDir, "mods").getAbsolutePath());
            } else {
                synchronize$default = ModsSynchronizer.synchronize$default(modsSynchronizer, str2, false, new Function1() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit retry$lambda$0$0;
                        retry$lambda$0$0 = ModsStartup.retry$lambda$0$0((ModsSynchronizer.Progress) obj);
                        return retry$lambda$0$0;
                    }
                }, 2, null);
            }
            ModsStartup modsStartup = INSTANCE;
            Intrinsics.checkNotNull(synchronize$default);
            modsStartup.configureReload(synchronize$default);
            final String jSONObject = synchronize$default.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            final boolean z = synchronize$default.getBoolean("hotReload");
            modsStartup.validate(jSONObject);
            main.post(new Runnable() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ModsStartup.retry$lambda$0$1(jSONObject, z);
                }
            });
        } catch (Exception e) {
            Log.e("Mods", "Preparation failed", e);
            String str3 = source;
            if (str3 != null && (lastGood = modsSynchronizer.lastGood(str3)) != null) {
                str = lastGood.toString();
            }
            main.post(new Runnable() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ModsStartup.retry$lambda$0$3(e, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retry$lambda$0$0(final ModsSynchronizer.Progress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        main.post(new Runnable() { // from class: com.arizona.game.ModsStartup$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                ModsStartup.retry$lambda$0$0$0(ModsSynchronizer.Progress.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retry$lambda$0$0$0(ModsSynchronizer.Progress progress) {
        INSTANCE.publish(new State(progress, null, null, null, 14, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retry$lambda$0$1(String str, boolean z) {
        running = false;
        INSTANCE.finish(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retry$lambda$0$3(Exception exc, String str) {
        running = false;
        ModsStartup modsStartup = INSTANCE;
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        modsStartup.publish(new State(null, null, message, str, 3, null));
    }
}
