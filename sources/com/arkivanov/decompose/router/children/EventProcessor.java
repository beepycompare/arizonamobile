package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.mainthread.CheckMainThreadKt;
import com.arkivanov.decompose.router.children.NavEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildrenFactory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/decompose/router/children/EventProcessor;", ExifInterface.LONGITUDE_EAST, "", "<init>", "()V", "pendingEvents", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "holder", "Lcom/arkivanov/decompose/router/children/Holder;", "process", "", NotificationCompat.CATEGORY_EVENT, "Lcom/arkivanov/decompose/router/children/NavEvent;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class EventProcessor<E> {
    private Holder<?, ?, ? super E, ?, ?> holder;
    private final ArrayList<E> pendingEvents = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    public final void process(NavEvent<? extends E> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        CheckMainThreadKt.checkMainThread();
        if (event instanceof NavEvent.Event) {
            Holder<?, ?, ? super E, ?, ?> holder = this.holder;
            if (holder == null) {
                this.pendingEvents.add(((NavEvent.Event) event).getEvent());
            } else if (holder != null) {
                holder.navigate((Object) ((NavEvent.Event) event).getEvent());
            }
        } else if (event instanceof NavEvent.Back) {
            Holder<?, ?, ? super E, ?, ?> holder2 = this.holder;
            if (holder2 != null) {
                holder2.back();
            }
        } else if (!(event instanceof NavEvent.Init)) {
            throw new NoWhenBranchMatchedException();
        } else {
            NavEvent.Init init = (NavEvent.Init) event;
            this.holder = init.getHolder();
            Holder<?, ?, E, ?, ?> holder3 = init.getHolder();
            for (E e : this.pendingEvents) {
                holder3.navigate(e);
            }
            this.pendingEvents.clear();
        }
    }
}
