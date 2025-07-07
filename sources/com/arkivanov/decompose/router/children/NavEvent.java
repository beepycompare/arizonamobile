package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildrenFactory.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0003\u0003\u0004\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/arkivanov/decompose/router/children/NavEvent;", ExifInterface.LONGITUDE_EAST, "", "Init", "Event", "Back", "Lcom/arkivanov/decompose/router/children/NavEvent$Back;", "Lcom/arkivanov/decompose/router/children/NavEvent$Event;", "Lcom/arkivanov/decompose/router/children/NavEvent$Init;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
interface NavEvent<E> {

    /* compiled from: ChildrenFactory.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007R'\u0010\u0004\u001a\u0018\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/arkivanov/decompose/router/children/NavEvent$Init;", ExifInterface.LONGITUDE_EAST, "", "Lcom/arkivanov/decompose/router/children/NavEvent;", "holder", "Lcom/arkivanov/decompose/router/children/Holder;", "<init>", "(Lcom/arkivanov/decompose/router/children/Holder;)V", "getHolder", "()Lcom/arkivanov/decompose/router/children/Holder;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Init<E> implements NavEvent<E> {
        private final Holder<?, ?, E, ?, ?> holder;

        /* JADX WARN: Multi-variable type inference failed */
        public Init(Holder<?, ?, ? super E, ?, ?> holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            this.holder = holder;
        }

        public final Holder<?, ?, E, ?, ?> getHolder() {
            return this.holder;
        }
    }

    /* compiled from: ChildrenFactory.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\n\b\u0001\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/arkivanov/decompose/router/children/NavEvent$Event;", ExifInterface.LONGITUDE_EAST, "", "Lcom/arkivanov/decompose/router/children/NavEvent;", NotificationCompat.CATEGORY_EVENT, "<init>", "(Ljava/lang/Object;)V", "getEvent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Event<E> implements NavEvent<E> {
        private final E event;

        public Event(E event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public final E getEvent() {
            return this.event;
        }
    }

    /* compiled from: ChildrenFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/arkivanov/decompose/router/children/NavEvent$Back;", "Lcom/arkivanov/decompose/router/children/NavEvent;", "", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Back implements NavEvent {
        public static final Back INSTANCE = new Back();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Back) {
                Back back = (Back) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1922549033;
        }

        public String toString() {
            return "Back";
        }

        private Back() {
        }
    }
}
