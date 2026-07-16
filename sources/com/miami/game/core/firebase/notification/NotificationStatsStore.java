package com.miami.game.core.firebase.notification;

import android.content.Context;
import android.content.SharedPreferences;
import com.miami.game.core.firebase.notification.NotificationInteractionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import timber.log.Timber;
/* compiled from: NotificationStatsStore.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u0014\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "append", "", "event", "Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "pendingEvents", "", "remove", "eventIds", "", "", "pendingEventsLocked", "writeEventsLocked", NotificationStatsStore.KEY_EVENTS, "Companion", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationStatsStore {
    @Deprecated
    public static final String KEY_EVENTS = "events";
    @Deprecated
    public static final int MAX_PENDING_EVENTS = 500;
    @Deprecated
    public static final String PREFS_NAME = "notification_stats";
    private final SharedPreferences prefs;
    private static final Companion Companion = new Companion(null);
    private static final Object LOCK = new Object();

    public NotificationStatsStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
    }

    public final void append(NotificationInteractionEvent event) {
        Object m9898constructorimpl;
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            Result.Companion companion = Result.Companion;
            NotificationStatsStore notificationStatsStore = this;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        synchronized (LOCK) {
            List mutableList = CollectionsKt.toMutableList((Collection) pendingEventsLocked());
            List<NotificationInteractionEvent> list = mutableList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (NotificationInteractionEvent notificationInteractionEvent : list) {
                    if (Intrinsics.areEqual(notificationInteractionEvent.getEventId(), event.getEventId())) {
                        return;
                    }
                }
            }
            mutableList.add(event);
            writeEventsLocked(CollectionsKt.takeLast(mutableList, 500));
            Unit unit = Unit.INSTANCE;
            m9898constructorimpl = Result.m9898constructorimpl(Unit.INSTANCE);
            Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
            if (m9901exceptionOrNullimpl != null) {
                Timber.Forest.w(m9901exceptionOrNullimpl, "Failed to append pending notification stats", new Object[0]);
            }
        }
    }

    public final List<NotificationInteractionEvent> pendingEvents() {
        List m9898constructorimpl;
        List<NotificationInteractionEvent> pendingEventsLocked;
        try {
            Result.Companion companion = Result.Companion;
            NotificationStatsStore notificationStatsStore = this;
            synchronized (LOCK) {
                pendingEventsLocked = pendingEventsLocked();
            }
            m9898constructorimpl = Result.m9898constructorimpl(pendingEventsLocked);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
        if (m9901exceptionOrNullimpl != null) {
            Timber.Forest.w(m9901exceptionOrNullimpl, "Failed to read pending notification stats", new Object[0]);
        }
        List emptyList = CollectionsKt.emptyList();
        if (Result.m9904isFailureimpl(m9898constructorimpl)) {
            m9898constructorimpl = emptyList;
        }
        return (List) m9898constructorimpl;
    }

    public final void remove(Set<String> eventIds) {
        Object m9898constructorimpl;
        Intrinsics.checkNotNullParameter(eventIds, "eventIds");
        if (eventIds.isEmpty()) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            NotificationStatsStore notificationStatsStore = this;
            synchronized (LOCK) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : pendingEventsLocked()) {
                    if (!eventIds.contains(((NotificationInteractionEvent) obj).getEventId())) {
                        arrayList.add(obj);
                    }
                }
                writeEventsLocked(arrayList);
                Unit unit = Unit.INSTANCE;
            }
            m9898constructorimpl = Result.m9898constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
        if (m9901exceptionOrNullimpl != null) {
            Timber.Forest.w(m9901exceptionOrNullimpl, "Failed to remove sent notification stats", new Object[0]);
        }
    }

    private final List<NotificationInteractionEvent> pendingEventsLocked() {
        List m9898constructorimpl;
        NotificationInteractionEvent fromJson;
        Object obj = this.prefs.getAll().get(KEY_EVENTS);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return CollectionsKt.emptyList();
        }
        try {
            Result.Companion companion = Result.Companion;
            NotificationStatsStore notificationStatsStore = this;
            JSONArray jSONArray = new JSONArray(str);
            List createListBuilder = CollectionsKt.createListBuilder();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                NotificationInteractionEvent.Companion companion2 = NotificationInteractionEvent.Companion;
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (fromJson = companion2.fromJson(optJSONObject)) != null) {
                    createListBuilder.add(fromJson);
                }
            }
            m9898constructorimpl = Result.m9898constructorimpl(CollectionsKt.build(createListBuilder));
        } catch (Throwable th) {
            Result.Companion companion3 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
        if (m9901exceptionOrNullimpl != null) {
            Timber.Forest.w(m9901exceptionOrNullimpl, "Failed to parse pending notification stats", new Object[0]);
            this.prefs.edit().remove(KEY_EVENTS).apply();
        }
        List emptyList = CollectionsKt.emptyList();
        if (Result.m9904isFailureimpl(m9898constructorimpl)) {
            m9898constructorimpl = emptyList;
        }
        return (List) m9898constructorimpl;
    }

    private final void writeEventsLocked(List<NotificationInteractionEvent> list) {
        JSONArray jSONArray = new JSONArray();
        for (NotificationInteractionEvent notificationInteractionEvent : list) {
            jSONArray.put(notificationInteractionEvent.toJson());
        }
        this.prefs.edit().putString(KEY_EVENTS, jSONArray.toString()).apply();
    }

    /* compiled from: NotificationStatsStore.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsStore$Companion;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_EVENTS", "MAX_PENDING_EVENTS", "", "LOCK", "getLOCK", "()Ljava/lang/Object;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object getLOCK() {
            return NotificationStatsStore.LOCK;
        }
    }
}
