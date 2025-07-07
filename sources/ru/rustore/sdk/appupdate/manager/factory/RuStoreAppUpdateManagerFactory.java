package ru.rustore.sdk.appupdate.manager.factory;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
import ru.rustore.sdk.analytics.event.common.SdkInfoAnalyticsEvent;
import ru.rustore.sdk.appupdate.b0;
import ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager;
import ru.rustore.sdk.core.config.RuStoreInternalConfig;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0007¨\u0006\n"}, d2 = {"Lru/rustore/sdk/appupdate/manager/factory/RuStoreAppUpdateManagerFactory;", "", "()V", "create", "Lru/rustore/sdk/appupdate/manager/RuStoreAppUpdateManager;", "context", "Landroid/content/Context;", "internalConfig", "", "", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuStoreAppUpdateManagerFactory {
    public static final RuStoreAppUpdateManagerFactory INSTANCE = new RuStoreAppUpdateManagerFactory();

    private RuStoreAppUpdateManagerFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RuStoreAppUpdateManager create$default(RuStoreAppUpdateManagerFactory ruStoreAppUpdateManagerFactory, Context context, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return ruStoreAppUpdateManagerFactory.create(context, map);
    }

    public final RuStoreAppUpdateManager create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return create$default(this, context, null, 2, null);
    }

    public final RuStoreAppUpdateManager create(Context context, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        AnalyticsEventProvider analyticsEventProvider = AnalyticsEventProvider.INSTANCE;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, new SdkInfoAnalyticsEvent("ru.rustore.sdk:appupdate", "1.0.0", RuStoreInternalConfig.Companion.create(map).getSdkType().getValue()));
        return new b0(context);
    }
}
