package ru.rustore.sdk.appupdate;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
import ru.rustore.sdk.core.config.RuStoreInternalConfig;
import ru.rustore.sdk.reactive.core.Dispatchers;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleSubscribeKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeOnKt;
/* renamed from: ru.rustore.sdk.appupdate.e  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0799e {

    /* renamed from: a  reason: collision with root package name */
    public final C0808n f1361a;
    public final a0 b;
    public final L c;
    public final AnalyticsEventProvider d;
    public final Context e;
    public final Lazy f;

    /* renamed from: ru.rustore.sdk.appupdate.e$a */
    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ C0803i b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C0803i c0803i) {
            super(0);
            this.b = c0803i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            C0799e c0799e = C0799e.this;
            AnalyticsEventProvider analyticsEventProvider = c0799e.d;
            Context context = c0799e.e;
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.rustore.sdk.appupdate.e$b */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<Unit, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1363a = new b();

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

    /* renamed from: ru.rustore.sdk.appupdate.e$c */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function0<Map<String, ? extends String>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends String> invoke() {
            a0 a0Var = C0799e.this.b;
            a0Var.f1356a.getClass();
            c0 c0Var = a0Var.b;
            c0Var.getClass();
            String type = RuStoreInternalConfig.Companion.create(c0Var.f1359a).getSdkType().getValue();
            a0Var.c.getClass();
            Intrinsics.checkNotNullParameter("ru.rustore.sdk:appupdate", "value");
            Intrinsics.checkNotNullParameter(type, "value");
            Intrinsics.checkNotNullParameter("7.0.0", "value");
            Intrinsics.checkNotNullParameter("ru.rustore.sdk:appupdate", "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter("7.0.0", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN);
            return MapsKt.mapOf(TuplesKt.to("sdkName", "ru.rustore.sdk:appupdate"), TuplesKt.to("sdkType", type), TuplesKt.to(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "7.0.0"));
        }
    }

    public C0799e(C0808n analyticsRepository, a0 sdkInfoRepository, L appVersionNameRepository, AnalyticsEventProvider analyticsEventProvider, Context context) {
        Intrinsics.checkNotNullParameter(analyticsRepository, "analyticsRepository");
        Intrinsics.checkNotNullParameter(sdkInfoRepository, "sdkInfoRepository");
        Intrinsics.checkNotNullParameter(appVersionNameRepository, "appVersionNameRepository");
        Intrinsics.checkNotNullParameter(analyticsEventProvider, "analyticsEventProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1361a = analyticsRepository;
        this.b = sdkInfoRepository;
        this.c = appVersionNameRepository;
        this.d = analyticsEventProvider;
        this.e = context;
        this.f = LazyKt.lazy(new c());
    }

    public final LinkedHashMap a(int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String value = (String) this.c.f1342a.b.getValue();
        if (value != null) {
            Intrinsics.checkNotNullParameter(value, "value");
        } else {
            value = null;
        }
        if (value != null) {
            linkedHashMap.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, value);
        }
        String packageName = this.e.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        linkedHashMap.put("app_bundle", packageName);
        linkedHashMap.put("update_type", i != 0 ? i != 1 ? "SILENT" : "IMMEDIATE" : "FLEXIBLE");
        return linkedHashMap;
    }

    public final void a(int i, String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(a(i));
        linkedHashMap.put("errorCode", errorCode);
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new a(new C0803i("updateStart.error", linkedHashMap))), Dispatchers.INSTANCE.getIo()), null, b.f1363a, 1, null);
    }
}
