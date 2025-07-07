package ru.rustore.sdk.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ru.rustore.sdk.analytics.event.AnalyticsEvent;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.core.util.CollectionExtKt;
import ru.rustore.sdk.core.util.ContextExtKt;
import ru.rustore.sdk.core.util.RuStoreUtils;
/* compiled from: AnalyticsEventProvider.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rJ\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/analytics/AnalyticsEventProvider;", "", "()V", "ACTION", "", "TAG", "postAnalyticsEvent", "", "context", "Landroid/content/Context;", "applicationId", "eventName", "eventData", "", "analyticsEvent", "Lru/rustore/sdk/analytics/event/AnalyticsEvent;", "sdk-public-analytics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnalyticsEventProvider {
    private static final String ACTION = "ru.vk.store.provider.analytics.RemoteAnalyticsProvider";
    public static final AnalyticsEventProvider INSTANCE = new AnalyticsEventProvider();
    private static final String TAG = "AnalyticsEventProvider";

    private AnalyticsEventProvider() {
    }

    public final void postAnalyticsEvent(Context context, String applicationId, AnalyticsEvent analyticsEvent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(analyticsEvent, "analyticsEvent");
        postAnalyticsEvent(context, applicationId, analyticsEvent.getEventName(), analyticsEvent.getEventData());
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, ru.rustore.sdk.analytics.AnalyticsProviderServiceConnection] */
    public final void postAnalyticsEvent(final Context context, String applicationId, String eventName, Map<String, String> eventData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        if (RuStoreUtils.INSTANCE.isRuStoreInstalled(context)) {
            Intent intent = new Intent(ACTION);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentServices, "context.packageManager.q…IntentServices(intent, 0)");
            ComponentName findRuStoreServiceComponentName = CollectionExtKt.findRuStoreServiceComponentName(queryIntentServices);
            if (findRuStoreServiceComponentName == null) {
                return;
            }
            intent.setComponent(findRuStoreServiceComponentName);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new AnalyticsProviderServiceConnection(applicationId, eventName, eventData, new Function0<Unit>() { // from class: ru.rustore.sdk.analytics.AnalyticsEventProvider$postAnalyticsEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ContextExtKt.unbindServiceSafely(context, objectRef.element);
                }
            }, new Function1<RuStoreException, Unit>() { // from class: ru.rustore.sdk.analytics.AnalyticsEventProvider$postAnalyticsEvent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RuStoreException ruStoreException) {
                    invoke2(ruStoreException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(RuStoreException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ContextExtKt.unbindServiceSafely(context, objectRef.element);
                }
            });
            try {
                context.bindService(intent, (ServiceConnection) objectRef.element, 1);
            } catch (SecurityException e) {
                Log.e(TAG, "postAnalyticsEvent", e);
            }
        }
    }
}
