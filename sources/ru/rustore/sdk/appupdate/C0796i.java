package ru.rustore.sdk.appupdate;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.analytics.event.AnalyticsEvent;
/* renamed from: ru.rustore.sdk.appupdate.i  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0796i extends AnalyticsEvent {

    /* renamed from: a  reason: collision with root package name */
    public final String f1550a;
    public final Map<String, String> b;

    public C0796i(String eventName, Map<String, String> eventData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1550a = eventName;
        this.b = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0796i) {
            C0796i c0796i = (C0796i) obj;
            return Intrinsics.areEqual(this.f1550a, c0796i.f1550a) && Intrinsics.areEqual(this.b, c0796i.b);
        }
        return false;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public final Map<String, String> getEventData() {
        return this.b;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public final String getEventName() {
        return this.f1550a;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f1550a.hashCode() * 31);
    }

    public final String toString() {
        return "AppUpdateAnalyticsEvent(eventName=" + this.f1550a + ", eventData=" + this.b + ')';
    }
}
