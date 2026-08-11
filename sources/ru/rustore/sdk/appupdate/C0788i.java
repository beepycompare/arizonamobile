package ru.rustore.sdk.appupdate;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.analytics.event.AnalyticsEvent;
/* renamed from: ru.rustore.sdk.appupdate.i  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0788i extends AnalyticsEvent {

    /* renamed from: a  reason: collision with root package name */
    public final String f1485a;
    public final Map<String, String> b;

    public C0788i(String eventName, Map<String, String> eventData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1485a = eventName;
        this.b = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0788i) {
            C0788i c0788i = (C0788i) obj;
            return Intrinsics.areEqual(this.f1485a, c0788i.f1485a) && Intrinsics.areEqual(this.b, c0788i.b);
        }
        return false;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public final Map<String, String> getEventData() {
        return this.b;
    }

    @Override // ru.rustore.sdk.analytics.event.AnalyticsEvent
    public final String getEventName() {
        return this.f1485a;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f1485a.hashCode() * 31);
    }

    public final String toString() {
        return "AppUpdateAnalyticsEvent(eventName=" + this.f1485a + ", eventData=" + this.b + ')';
    }
}
