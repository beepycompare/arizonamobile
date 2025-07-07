package ru.rustore.sdk.analytics.event.common;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.analytics.event.AnalyticsEvent;
/* compiled from: SdkInfoAnalyticsEvent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lru/rustore/sdk/analytics/event/common/SdkInfoAnalyticsEvent;", "Lru/rustore/sdk/analytics/event/AnalyticsEvent;", "name", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "eventData", "", "getEventData", "()Ljava/util/Map;", "eventName", "getEventName", "()Ljava/lang/String;", "sdk-public-analytics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SdkInfoAnalyticsEvent extends AnalyticsEvent {
    private final Map<String, String> eventData;
    private final String eventName;

    public SdkInfoAnalyticsEvent(String name, String version, String type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(type, "type");
        this.eventName = "sdkInfo";
        this.eventData = MapsKt.mapOf(TuplesKt.to("sdkName", name), TuplesKt.to(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, version), TuplesKt.to("sdkType", type));
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public String getEventName() {
        return this.eventName;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public Map<String, String> getEventData() {
        return this.eventData;
    }
}
