package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasicMarquee.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2", f = "BasicMarquee.kt", i = {}, l = {413}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class MarqueeModifierNode$runAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MarqueeModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeModifierNode$runAnimation$2(MarqueeModifierNode marqueeModifierNode, Continuation<? super MarqueeModifierNode$runAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = marqueeModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarqueeModifierNode$runAnimation$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MarqueeModifierNode$runAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final MarqueeModifierNode marqueeModifierNode = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MarqueeModifierNode$runAnimation$2.invokeSuspend$lambda$0(MarqueeModifierNode.this);
                }
            }), new AnonymousClass2(this.this$0, null), this) == coroutine_suspended) {
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
    public static final Float invokeSuspend$lambda$0(MarqueeModifierNode marqueeModifierNode) {
        int contentWidth;
        int containerWidth;
        int contentWidth2;
        int spacingPx;
        boolean hasFocus;
        contentWidth = marqueeModifierNode.getContentWidth();
        containerWidth = marqueeModifierNode.getContainerWidth();
        if (contentWidth <= containerWidth) {
            return null;
        }
        if (MarqueeAnimationMode.m337equalsimpl0(marqueeModifierNode.m348getAnimationModeZbEOnfQ(), MarqueeAnimationMode.Companion.m342getWhileFocusedZbEOnfQ())) {
            hasFocus = marqueeModifierNode.getHasFocus();
            if (!hasFocus) {
                return null;
            }
        }
        contentWidth2 = marqueeModifierNode.getContentWidth();
        spacingPx = marqueeModifierNode.getSpacingPx();
        return Float.valueOf(contentWidth2 + spacingPx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasicMarquee.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "contentWithSpacingWidth", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2", f = "BasicMarquee.kt", i = {0, 0}, l = {427, 429, 433, 433}, m = "invokeSuspend", n = {"contentWithSpacingWidth", "spec"}, s = {"L$0", "L$1"}, v = 1)
    /* renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MarqueeModifierNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MarqueeModifierNode marqueeModifierNode, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = marqueeModifierNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Float f, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(f, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00c7, code lost:
            if (r0.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r18) != r2) goto L14;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Animatable animatable;
            int i;
            int i2;
            int i3;
            float f;
            AnimationSpec m271createMarqueeAnimationSpecZ4HSEVQ;
            Animatable animatable2;
            Float f2;
            AnimationSpec animationSpec;
            Animatable animatable3;
            Object animateTo$default;
            Animatable animatable4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
            } catch (Throwable th) {
                animatable = this.this$0.offset;
                this.L$0 = th;
                this.L$1 = null;
                this.label = 4;
                if (animatable.snapTo(Boxing.boxFloat(0.0f), this) != coroutine_suspended) {
                    throw th;
                }
            }
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                Float f3 = (Float) this.L$0;
                if (f3 != null) {
                    i = this.this$0.iterations;
                    float floatValue = f3.floatValue();
                    i2 = this.this$0.initialDelayMillis;
                    i3 = this.this$0.delayMillis;
                    f = this.this$0.velocity;
                    m271createMarqueeAnimationSpecZ4HSEVQ = BasicMarqueeKt.m271createMarqueeAnimationSpecZ4HSEVQ(i, floatValue, i2, i3, f, DelegatableNodeKt.requireDensity(this.this$0));
                    animatable2 = this.this$0.offset;
                    this.L$0 = f3;
                    this.L$1 = m271createMarqueeAnimationSpecZ4HSEVQ;
                    this.label = 1;
                    if (animatable2.snapTo(Boxing.boxFloat(0.0f), this) != coroutine_suspended) {
                        f2 = f3;
                        animationSpec = m271createMarqueeAnimationSpecZ4HSEVQ;
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else if (i4 == 1) {
                ResultKt.throwOnFailure(obj);
                animationSpec = (AnimationSpec) this.L$1;
                f2 = (Float) this.L$0;
            } else if (i4 != 2) {
                if (i4 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else if (i4 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Throwable th2 = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th2;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                animateTo$default = obj;
                AnimationResult animationResult = (AnimationResult) animateTo$default;
                animatable4 = this.this$0.offset;
                this.label = 3;
            }
            animatable3 = this.this$0.offset;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            animateTo$default = Animatable.animateTo$default(animatable3, f2, animationSpec, null, null, this, 12, null);
            if (animateTo$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            AnimationResult animationResult2 = (AnimationResult) animateTo$default;
            animatable4 = this.this$0.offset;
            this.label = 3;
        }
    }
}
