package ru.rustore.sdk.appupdate;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.analytics.event.AnalyticsEvent;
/* renamed from: ru.rustore.sdk.appupdate.i  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0803i extends AnalyticsEvent {

    /* renamed from: a  reason: collision with root package name */
    public final String f1379a;
    public final Map<String, String> b;

    public C0803i(String eventName, Map<String, String> eventData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1379a = eventName;
        this.b = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0803i) {
            C0803i c0803i = (C0803i) obj;
            return Intrinsics.areEqual(this.f1379a, c0803i.f1379a) && Intrinsics.areEqual(this.b, c0803i.b);
        }
        return false;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public final Map<String, String> getEventData() {
        return this.b;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public final String getEventName() {
        return this.f1379a;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f1379a.hashCode() * 31);
    }

    public final String toString() {
        return "AppUpdateAnalyticsEvent(eventName=" + this.f1379a + ", eventData=" + this.b + ')';
    }
}
