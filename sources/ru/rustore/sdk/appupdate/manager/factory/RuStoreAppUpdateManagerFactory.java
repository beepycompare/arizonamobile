package ru.rustore.sdk.appupdate.manager.factory;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
import ru.rustore.sdk.analytics.event.common.SdkInfoAnalyticsEvent;
import ru.rustore.sdk.appupdate.Z;
import ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager;
import ru.rustore.sdk.core.config.RuStoreInternalConfig;
import ru.rustore.sdk.reactive.core.Dispatchers;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleSubscribeKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeOnKt;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0007¨\u0006\n"}, d2 = {"Lru/rustore/sdk/appupdate/manager/factory/RuStoreAppUpdateManagerFactory;", "", "()V", "create", "Lru/rustore/sdk/appupdate/manager/RuStoreAppUpdateManager;", "context", "Landroid/content/Context;", "internalConfig", "", "", "sdk-public-appupdate_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RuStoreAppUpdateManagerFactory {
    public static final RuStoreAppUpdateManagerFactory INSTANCE = new RuStoreAppUpdateManagerFactory();

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        public final /* synthetic */ Context f1533a;
        public final /* synthetic */ Map<String, Object> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, Map<String, ? extends Object> map) {
            super(0);
            this.f1533a = context;
            this.b = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AnalyticsEventProvider analyticsEventProvider = AnalyticsEventProvider.INSTANCE;
            Context context = this.f1533a;
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            analyticsEventProvider.postAnalyticsEvent(context, packageName, new SdkInfoAnalyticsEvent("ru.rustore.sdk:appupdate", "7.0.0", RuStoreInternalConfig.Companion.create(this.b).getSdkType().getValue()));
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function1<Unit, Unit> {

        /* renamed from: a */
        public static final b f1534a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Unit unit) {
            Unit it = unit;
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }
    }

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
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new a(context, map)), Dispatchers.INSTANCE.getIo()), null, b.f1534a, 1, null);
        return new Z(context);
    }
}
