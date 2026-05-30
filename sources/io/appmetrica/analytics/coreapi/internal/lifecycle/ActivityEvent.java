package io.appmetrica.analytics.coreapi.internal.lifecycle;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/lifecycle/ActivityEvent;", "", DebugCoroutineInfoImplKt.CREATED, "RESUMED", "PAUSED", "STARTED", "STOPPED", "DESTROYED", "core-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class ActivityEvent {
    public static final ActivityEvent CREATED;
    public static final ActivityEvent DESTROYED;
    public static final ActivityEvent PAUSED;
    public static final ActivityEvent RESUMED;
    public static final ActivityEvent STARTED;
    public static final ActivityEvent STOPPED;

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ ActivityEvent[] f325a;
    private static final /* synthetic */ EnumEntries b;

    static {
        ActivityEvent activityEvent = new ActivityEvent(DebugCoroutineInfoImplKt.CREATED, 0);
        CREATED = activityEvent;
        ActivityEvent activityEvent2 = new ActivityEvent("RESUMED", 1);
        RESUMED = activityEvent2;
        ActivityEvent activityEvent3 = new ActivityEvent("PAUSED", 2);
        PAUSED = activityEvent3;
        ActivityEvent activityEvent4 = new ActivityEvent("STARTED", 3);
        STARTED = activityEvent4;
        ActivityEvent activityEvent5 = new ActivityEvent("STOPPED", 4);
        STOPPED = activityEvent5;
        ActivityEvent activityEvent6 = new ActivityEvent("DESTROYED", 5);
        DESTROYED = activityEvent6;
        ActivityEvent[] activityEventArr = {activityEvent, activityEvent2, activityEvent3, activityEvent4, activityEvent5, activityEvent6};
        f325a = activityEventArr;
        b = EnumEntriesKt.enumEntries(activityEventArr);
    }

    private ActivityEvent(String str, int i) {
    }

    public static EnumEntries<ActivityEvent> getEntries() {
        return b;
    }

    public static ActivityEvent valueOf(String str) {
        return (ActivityEvent) Enum.valueOf(ActivityEvent.class, str);
    }

    public static ActivityEvent[] values() {
        return (ActivityEvent[]) f325a.clone();
    }
}
