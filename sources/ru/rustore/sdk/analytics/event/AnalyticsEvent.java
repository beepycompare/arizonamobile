package ru.rustore.sdk.analytics.event;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
/* compiled from: AnalyticsEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/rustore/sdk/analytics/event/AnalyticsEvent;", "", "()V", "eventData", "", "", "getEventData", "()Ljava/util/Map;", "eventName", "getEventName", "()Ljava/lang/String;", "sdk-public-analytics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AnalyticsEvent {
    private final Map<String, String> eventData = MapsKt.emptyMap();

    public abstract String getEventName();

    public Map<String, String> getEventData() {
        return this.eventData;
    }
}
