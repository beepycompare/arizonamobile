package ru.rustore.sdk.appupdate;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.analytics.event.AnalyticsEvent;
/* renamed from: ru.rustore.sdk.appupdate.i  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0800i extends AnalyticsEvent {

    /* renamed from: a  reason: collision with root package name */
    public final String f1389a;
    public final Map<String, String> b;

    public C0800i(String eventName, Map<String, String> eventData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1389a = eventName;
        this.b = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0800i) {
            C0800i c0800i = (C0800i) obj;
            return Intrinsics.areEqual(this.f1389a, c0800i.f1389a) && Intrinsics.areEqual(this.b, c0800i.b);
        }
        return false;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public final Map<String, String> getEventData() {
        return this.b;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public final String getEventName() {
        return this.f1389a;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f1389a.hashCode() * 31);
    }

    public final String toString() {
        return "AppUpdateAnalyticsEvent(eventName=" + this.f1389a + ", eventData=" + this.b + ')';
    }
}
