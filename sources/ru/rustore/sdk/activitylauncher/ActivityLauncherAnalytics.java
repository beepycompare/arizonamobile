package ru.rustore.sdk.activitylauncher;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.IntentSender;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ru.rustore.sdk.metrics.MetricsClient;
import ru.rustore.sdk.metrics.MetricsEvent;
import ru.rustore.sdk.reactive.core.Dispatchers;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleOnErrorReturnKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeOnKt;
/* compiled from: ActivityLauncherAnalytics.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0012\u0010\u000f\u001a\u00020\r2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lru/rustore/sdk/activitylauncher/ActivityLauncherAnalytics;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "metricsClient", "Lru/rustore/sdk/metrics/MetricsClient;", "getMetricsClient", "()Lru/rustore/sdk/metrics/MetricsClient;", "metricsClient$delegate", "Lkotlin/Lazy;", "send", "Lru/rustore/sdk/reactive/single/Single;", "", "sendEvent", "sendExceptionActivityStart", "reason", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "sdk-public-activitylauncher_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityLauncherAnalytics {
    @Deprecated
    public static final String ACTIVITY_NOT_FOUND_EXCEPTION = "ActivityLauncher.ActivityNotFoundException";
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String ERROR_DESCRIPTION = "errorDescription";
    @Deprecated
    public static final String ERROR_LAUNCH_ACTIVITY = "launchActivity.error";
    @Deprecated
    public static final String SEND_INTENT_EXCEPTION = "ActivityLauncher.SendIntentException";
    private final Lazy metricsClient$delegate;

    public ActivityLauncherAnalytics(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.metricsClient$delegate = LazyKt.lazy(new Function0<MetricsClient>() { // from class: ru.rustore.sdk.activitylauncher.ActivityLauncherAnalytics$metricsClient$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MetricsClient invoke() {
                return MetricsClient.Companion.getInstance(context);
            }
        });
    }

    private final MetricsClient getMetricsClient() {
        return (MetricsClient) this.metricsClient$delegate.getValue();
    }

    public final void sendExceptionActivityStart(Exception reason) {
        String str;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (reason instanceof ActivityNotFoundException) {
            str = ACTIVITY_NOT_FOUND_EXCEPTION;
        } else {
            str = reason instanceof IntentSender.SendIntentException ? SEND_INTENT_EXCEPTION : Reflection.getOrCreateKotlinClass(reason.getClass()).getQualifiedName() + " || " + reason.getMessage() + " ||| " + reason.getCause();
        }
        SingleSubscribeKt.subscribe$default(send(getMetricsClient().send(new MetricsEvent(ERROR_LAUNCH_ACTIVITY, MapsKt.mapOf(TuplesKt.to(ERROR_DESCRIPTION, str))))), null, new Function1<Unit, Unit>() { // from class: ru.rustore.sdk.activitylauncher.ActivityLauncherAnalytics$sendExceptionActivityStart$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    private final Single<Unit> send(Single<Unit> single) {
        return SingleOnErrorReturnKt.onErrorReturn(SingleSubscribeOnKt.subscribeOn(single, Dispatchers.INSTANCE.getIo()), new Function1<Throwable, Unit>() { // from class: ru.rustore.sdk.activitylauncher.ActivityLauncherAnalytics$send$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    /* compiled from: ActivityLauncherAnalytics.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/rustore/sdk/activitylauncher/ActivityLauncherAnalytics$Companion;", "", "()V", "ACTIVITY_NOT_FOUND_EXCEPTION", "", "ERROR_DESCRIPTION", "ERROR_LAUNCH_ACTIVITY", "SEND_INTENT_EXCEPTION", "sdk-public-activitylauncher_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
