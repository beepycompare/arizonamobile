package com.arkivanov.essenty.backhandler;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BackEvent.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/arkivanov/essenty/backhandler/BackEvent;", "", "progress", "", "swipeEdge", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "touchX", "touchY", "<init>", "(FLcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;FF)V", "getProgress", "()F", "getSwipeEdge", "()Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "getTouchX", "getTouchY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SwipeEdge", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackEvent {
    private final float progress;
    private final SwipeEdge swipeEdge;
    private final float touchX;
    private final float touchY;

    public BackEvent() {
        this(0.0f, null, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ BackEvent copy$default(BackEvent backEvent, float f, SwipeEdge swipeEdge, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = backEvent.progress;
        }
        if ((i & 2) != 0) {
            swipeEdge = backEvent.swipeEdge;
        }
        if ((i & 4) != 0) {
            f2 = backEvent.touchX;
        }
        if ((i & 8) != 0) {
            f3 = backEvent.touchY;
        }
        return backEvent.copy(f, swipeEdge, f2, f3);
    }

    public final float component1() {
        return this.progress;
    }

    public final SwipeEdge component2() {
        return this.swipeEdge;
    }

    public final float component3() {
        return this.touchX;
    }

    public final float component4() {
        return this.touchY;
    }

    public final BackEvent copy(float f, SwipeEdge swipeEdge, float f2, float f3) {
        Intrinsics.checkNotNullParameter(swipeEdge, "swipeEdge");
        return new BackEvent(f, swipeEdge, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackEvent) {
            BackEvent backEvent = (BackEvent) obj;
            return Float.compare(this.progress, backEvent.progress) == 0 && this.swipeEdge == backEvent.swipeEdge && Float.compare(this.touchX, backEvent.touchX) == 0 && Float.compare(this.touchY, backEvent.touchY) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.progress) * 31) + this.swipeEdge.hashCode()) * 31) + Float.hashCode(this.touchX)) * 31) + Float.hashCode(this.touchY);
    }

    public String toString() {
        return "BackEvent(progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ", touchX=" + this.touchX + ", touchY=" + this.touchY + ')';
    }

    public BackEvent(float f, SwipeEdge swipeEdge, float f2, float f3) {
        Intrinsics.checkNotNullParameter(swipeEdge, "swipeEdge");
        this.progress = f;
        this.swipeEdge = swipeEdge;
        this.touchX = f2;
        this.touchY = f3;
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException("The 'progress' argument must be between 0 and 1 (both inclusive)".toString());
        }
    }

    public final float getProgress() {
        return this.progress;
    }

    public /* synthetic */ BackEvent(float f, SwipeEdge swipeEdge, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? SwipeEdge.UNKNOWN : swipeEdge, (i & 4) != 0 ? 0.0f : f2, (i & 8) != 0 ? 0.0f : f3);
    }

    public final SwipeEdge getSwipeEdge() {
        return this.swipeEdge;
    }

    public final float getTouchX() {
        return this.touchX;
    }

    public final float getTouchY() {
        return this.touchY;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BackEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "LEFT", "RIGHT", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SwipeEdge {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SwipeEdge[] $VALUES;
        public static final SwipeEdge UNKNOWN = new SwipeEdge("UNKNOWN", 0);
        public static final SwipeEdge LEFT = new SwipeEdge("LEFT", 1);
        public static final SwipeEdge RIGHT = new SwipeEdge("RIGHT", 2);

        private static final /* synthetic */ SwipeEdge[] $values() {
            return new SwipeEdge[]{UNKNOWN, LEFT, RIGHT};
        }

        public static EnumEntries<SwipeEdge> getEntries() {
            return $ENTRIES;
        }

        private SwipeEdge(String str, int i) {
        }

        static {
            SwipeEdge[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static SwipeEdge valueOf(String str) {
            return (SwipeEdge) Enum.valueOf(SwipeEdge.class, str);
        }

        public static SwipeEdge[] values() {
            return (SwipeEdge[]) $VALUES.clone();
        }
    }
}
