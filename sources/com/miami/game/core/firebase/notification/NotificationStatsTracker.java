package com.miami.game.core.firebase.notification;

import android.content.Context;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import timber.log.Timber;
/* compiled from: NotificationStatsTracker.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsTracker;", "", "context", "Landroid/content/Context;", "sender", "Lcom/miami/game/core/firebase/notification/NotificationStatsSender;", "<init>", "(Landroid/content/Context;Lcom/miami/game/core/firebase/notification/NotificationStatsSender;)V", "store", "Lcom/miami/game/core/firebase/notification/NotificationStatsStore;", "recordAndFlush", "", "event", "Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "flushPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "record", "Companion", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationStatsTracker {
    private static final Companion Companion = new Companion(null);
    private static final CoroutineScope SEND_SCOPE = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private final NotificationStatsSender sender;
    private final NotificationStatsStore store;

    public NotificationStatsTracker(Context context, NotificationStatsSender sender) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sender, "sender");
        this.sender = sender;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.store = new NotificationStatsStore(applicationContext);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NotificationStatsTracker(Context context, NotificationStatsSender notificationStatsSender, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, notificationStatsSender);
        if ((i & 2) != 0) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            notificationStatsSender = new HttpNotificationStatsSender(applicationContext, null, 2, null);
        }
    }

    public final void recordAndFlush(NotificationInteractionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        record(event);
        BuildersKt__Builders_commonKt.launch$default(SEND_SCOPE, null, null, new NotificationStatsTracker$recordAndFlush$1(this, null), 3, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|(1:(2:10|11)(2:23|24))(2:25|(2:27|28)(2:29|(1:31)))|12|13|(1:15)|16|(1:18)|19|20))|34|6|7|(0)(0)|12|13|(0)|16|(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        r0 = kotlin.Result.Companion;
        r6 = kotlin.Result.m9920constructorimpl(kotlin.ResultKt.createFailure(r6));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flushPending(Continuation<? super Unit> continuation) {
        NotificationStatsTracker$flushPending$1 notificationStatsTracker$flushPending$1;
        int i;
        Set m9920constructorimpl;
        Throwable m9923exceptionOrNullimpl;
        if (continuation instanceof NotificationStatsTracker$flushPending$1) {
            notificationStatsTracker$flushPending$1 = (NotificationStatsTracker$flushPending$1) continuation;
            if ((notificationStatsTracker$flushPending$1.label & Integer.MIN_VALUE) != 0) {
                notificationStatsTracker$flushPending$1.label -= Integer.MIN_VALUE;
                Object obj = notificationStatsTracker$flushPending$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = notificationStatsTracker$flushPending$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<NotificationInteractionEvent> pendingEvents = this.store.pendingEvents();
                    if (pendingEvents.isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    Result.Companion companion = Result.Companion;
                    NotificationStatsTracker notificationStatsTracker = this;
                    NotificationStatsSender notificationStatsSender = this.sender;
                    notificationStatsTracker$flushPending$1.L$0 = SpillingKt.nullOutSpilledVariable(pendingEvents);
                    notificationStatsTracker$flushPending$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                    notificationStatsTracker$flushPending$1.label = 1;
                    obj = notificationStatsSender.send(pendingEvents, notificationStatsTracker$flushPending$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    NotificationStatsTracker notificationStatsTracker2 = (NotificationStatsTracker) notificationStatsTracker$flushPending$1.L$1;
                    List list = (List) notificationStatsTracker$flushPending$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                m9920constructorimpl = Result.m9920constructorimpl((Set) obj);
                m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(m9920constructorimpl);
                if (m9923exceptionOrNullimpl != null) {
                    Timber.Forest.w(m9923exceptionOrNullimpl, "Failed to send notification stats", new Object[0]);
                }
                Set emptySet = SetsKt.emptySet();
                if (Result.m9926isFailureimpl(m9920constructorimpl)) {
                    m9920constructorimpl = emptySet;
                }
                this.store.remove((Set) m9920constructorimpl);
                return Unit.INSTANCE;
            }
        }
        notificationStatsTracker$flushPending$1 = new NotificationStatsTracker$flushPending$1(this, continuation);
        Object obj2 = notificationStatsTracker$flushPending$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = notificationStatsTracker$flushPending$1.label;
        if (i != 0) {
        }
        m9920constructorimpl = Result.m9920constructorimpl((Set) obj2);
        m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(m9920constructorimpl);
        if (m9923exceptionOrNullimpl != null) {
        }
        Set emptySet2 = SetsKt.emptySet();
        if (Result.m9926isFailureimpl(m9920constructorimpl)) {
        }
        this.store.remove((Set) m9920constructorimpl);
        return Unit.INSTANCE;
    }

    private final void record(NotificationInteractionEvent notificationInteractionEvent) {
        this.store.append(notificationInteractionEvent);
        Timber.Forest forest = Timber.Forest;
        NotificationInteractionType type = notificationInteractionEvent.getType();
        forest.d("Notification stats event recorded: type=" + type + ", notifRef=" + notificationInteractionEvent.getNotifRef(), new Object[0]);
    }

    /* compiled from: NotificationStatsTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsTracker$Companion;", "", "<init>", "()V", "SEND_SCOPE", "Lkotlinx/coroutines/CoroutineScope;", "getSEND_SCOPE", "()Lkotlinx/coroutines/CoroutineScope;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoroutineScope getSEND_SCOPE() {
            return NotificationStatsTracker.SEND_SCOPE;
        }
    }
}
