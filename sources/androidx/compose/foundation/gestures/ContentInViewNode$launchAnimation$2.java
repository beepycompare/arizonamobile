package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.IntOffset;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentInViewNode.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: $$v$c$androidx-compose-ui-unit-IntOffset$-viewportAdjustmentForReverseScroll$0  reason: not valid java name */
    final /* synthetic */ long f8x677d03b0;
    final /* synthetic */ UpdatableAnimationState $animationState;
    final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec, long j, Continuation<? super ContentInViewNode$launchAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewNode;
        this.$animationState = updatableAnimationState;
        this.$bringIntoViewSpec = bringIntoViewSpec;
        this.f8x677d03b0 = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.this$0, this.$animationState, this.$bringIntoViewSpec, this.f8x677d03b0, continuation);
        contentInViewNode$launchAnimation$2.L$0 = obj;
        return contentInViewNode$launchAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewNode$launchAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ScrollingLogic scrollingLogic;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                    this.this$0.isAnimationRunning = true;
                    scrollingLogic = this.this$0.scrollingLogic;
                    this.label = 1;
                    if (scrollingLogic.scroll(MutatePriority.Default, new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.f8x677d03b0, job, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.bringIntoViewRequests.resumeAndRemoveAll();
                this.this$0.isAnimationRunning = false;
                this.this$0.bringIntoViewRequests.cancelAndRemoveAll(null);
                this.this$0.trackingFocusedChild = false;
                return Unit.INSTANCE;
            } catch (CancellationException e) {
                throw e;
            }
        } catch (Throwable th) {
            this.this$0.isAnimationRunning = false;
            this.this$0.bringIntoViewRequests.cancelAndRemoveAll(null);
            this.this$0.trackingFocusedChild = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContentInViewNode.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {

        /* renamed from: $$v$c$androidx-compose-ui-unit-IntOffset$-viewportAdjustmentForReverseScroll$0  reason: not valid java name */
        final /* synthetic */ long f9x677d03b0;
        final /* synthetic */ Job $animationJob;
        final /* synthetic */ UpdatableAnimationState $animationState;
        final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, long j, Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$animationState = updatableAnimationState;
            this.this$0 = contentInViewNode;
            this.$bringIntoViewSpec = bringIntoViewSpec;
            this.f9x677d03b0 = j;
            this.$animationJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.f9x677d03b0, this.$animationJob, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float m432calculateScrollDeltaI_oMVgE;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
                UpdatableAnimationState updatableAnimationState = this.$animationState;
                m432calculateScrollDeltaI_oMVgE = this.this$0.m432calculateScrollDeltaI_oMVgE(this.$bringIntoViewSpec, this.f9x677d03b0);
                updatableAnimationState.setValue(m432calculateScrollDeltaI_oMVgE);
                final UpdatableAnimationState updatableAnimationState2 = this.$animationState;
                final ContentInViewNode contentInViewNode = this.this$0;
                final Job job = this.$animationJob;
                Function1<? super Float, Unit> function1 = new Function1() { // from class: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ContentInViewNode$launchAnimation$2.AnonymousClass1.invokeSuspend$lambda$0(ContentInViewNode.this, updatableAnimationState2, job, nestedScrollScope, ((Float) obj2).floatValue());
                    }
                };
                final ContentInViewNode contentInViewNode2 = this.this$0;
                final UpdatableAnimationState updatableAnimationState3 = this.$animationState;
                final BringIntoViewSpec bringIntoViewSpec = this.$bringIntoViewSpec;
                this.label = 1;
                if (updatableAnimationState2.animateToZero(function1, new Function0() { // from class: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ContentInViewNode$launchAnimation$2.AnonymousClass1.invokeSuspend$lambda$1(ContentInViewNode.this, updatableAnimationState3, bringIntoViewSpec);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit invokeSuspend$lambda$0(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, Job job, NestedScrollScope nestedScrollScope, float f) {
            boolean z;
            ScrollingLogic scrollingLogic;
            z = contentInViewNode.reverseDirection;
            float f2 = z ? 1.0f : -1.0f;
            scrollingLogic = contentInViewNode.scrollingLogic;
            float m589toFloatk4lQ0M = f2 * scrollingLogic.m589toFloatk4lQ0M(scrollingLogic.m587reverseIfNeededMKHz9U(nestedScrollScope.mo530scrollByOzD1aCk(scrollingLogic.m587reverseIfNeededMKHz9U(scrollingLogic.m590toOffsettuRUvjQ(f2 * f)), NestedScrollSource.Companion.m5965getUserInputWNlRxjI())));
            if (Math.abs(m589toFloatk4lQ0M) < Math.abs(f)) {
                JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + m589toFloatk4lQ0M + " < " + f + ')', null, 2, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit invokeSuspend$lambda$1(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec) {
            boolean z;
            ContentInViewNode contentInViewNode2;
            boolean z2;
            float m432calculateScrollDeltaI_oMVgE;
            Rect focusedChildBounds;
            boolean m436isMaxVisibleEQwtKw$default;
            BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = contentInViewNode.bringIntoViewRequests;
            while (true) {
                z = true;
                if (bringIntoViewRequestPriorityQueue.requests.getSize() == 0) {
                    contentInViewNode2 = contentInViewNode;
                    break;
                }
                Rect invoke = ((ContentInViewNode.Request) bringIntoViewRequestPriorityQueue.requests.last()).getCurrentBounds().invoke();
                if (invoke == null) {
                    contentInViewNode2 = contentInViewNode;
                    m436isMaxVisibleEQwtKw$default = true;
                } else {
                    contentInViewNode2 = contentInViewNode;
                    m436isMaxVisibleEQwtKw$default = ContentInViewNode.m436isMaxVisibleEQwtKw$default(contentInViewNode2, invoke, 0L, 0L, 3, null);
                }
                if (!m436isMaxVisibleEQwtKw$default) {
                    break;
                }
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                ((ContentInViewNode.Request) bringIntoViewRequestPriorityQueue.requests.removeAt(bringIntoViewRequestPriorityQueue.requests.getSize() - 1)).getContinuation().resumeWith(Result.m9183constructorimpl(unit));
                contentInViewNode = contentInViewNode2;
            }
            z2 = contentInViewNode2.trackingFocusedChild;
            if (z2) {
                focusedChildBounds = contentInViewNode2.getFocusedChildBounds();
                if (focusedChildBounds == null || !ContentInViewNode.m436isMaxVisibleEQwtKw$default(contentInViewNode2, focusedChildBounds, 0L, 0L, 3, null)) {
                    z = false;
                }
                if (z) {
                    contentInViewNode2.trackingFocusedChild = false;
                }
            }
            m432calculateScrollDeltaI_oMVgE = contentInViewNode2.m432calculateScrollDeltaI_oMVgE(bringIntoViewSpec, IntOffset.Companion.m7694getZeronOccac());
            updatableAnimationState.setValue(m432calculateScrollDeltaI_oMVgE);
            return Unit.INSTANCE;
        }
    }
}
