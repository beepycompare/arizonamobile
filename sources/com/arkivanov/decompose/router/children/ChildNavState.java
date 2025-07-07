package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
/* compiled from: ChildNavState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0001\nR\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildNavState;", "C", "", "configuration", "getConfiguration", "()Ljava/lang/Object;", NotificationCompat.CATEGORY_STATUS, "Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "getStatus", "()Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "Status", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ChildNavState<C> {
    C getConfiguration();

    Status getStatus();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ChildNavState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "", "<init>", "(Ljava/lang/String;I)V", "DESTROYED", DebugCoroutineInfoImplKt.CREATED, "STARTED", "RESUMED", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status DESTROYED = new Status("DESTROYED", 0);
        public static final Status CREATED = new Status(DebugCoroutineInfoImplKt.CREATED, 1);
        public static final Status STARTED = new Status("STARTED", 2);
        public static final Status RESUMED = new Status("RESUMED", 3);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{DESTROYED, CREATED, STARTED, RESUMED};
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String str, int i) {
        }

        static {
            Status[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }
}
