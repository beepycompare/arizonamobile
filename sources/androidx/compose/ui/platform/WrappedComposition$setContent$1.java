package androidx.compose.ui.platform;

import android.os.Looper;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Wrapper.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "composeViewContext", "Landroidx/compose/ui/platform/ComposeViewContext;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WrappedComposition$setContent$1 extends Lambda implements Function1<ComposeViewContext, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ WrappedComposition this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WrappedComposition$setContent$1(WrappedComposition wrappedComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(1);
        this.this$0 = wrappedComposition;
        this.$content = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ComposeViewContext composeViewContext) {
        invoke2(composeViewContext);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final ComposeViewContext composeViewContext) {
        boolean z;
        Lifecycle lifecycle;
        z = this.this$0.disposed;
        if (z) {
            return;
        }
        final Lifecycle lifecycle2 = composeViewContext.getLifecycleOwner$ui().getLifecycle();
        this.this$0.lastContent = this.$content;
        lifecycle = this.this$0.addedToLifecycle;
        if (lifecycle == null) {
            if (Intrinsics.areEqual(Looper.myLooper(), composeViewContext.getView$ui().getHandler().getLooper())) {
                this.this$0.addedToLifecycle = lifecycle2;
                lifecycle2.addObserver(this.this$0);
                return;
            }
            View view$ui = composeViewContext.getView$ui();
            final WrappedComposition wrappedComposition = this.this$0;
            view$ui.post(new Runnable() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WrappedComposition$setContent$1.invoke$lambda$0(WrappedComposition.this, lifecycle2);
                }
            });
        } else if (lifecycle2.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            Composition original = this.this$0.getOriginal();
            final WrappedComposition wrappedComposition2 = this.this$0;
            final Function2<Composer, Integer, Unit> function2 = this.$content;
            original.setContent(ComposableLambdaKt.composableLambdaInstance(-1723985096, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C126@5432L47,126@5410L69,127@5526L48,127@5504L70,129@5619L40:Wrapper.android.kt#itgzvw");
                    if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1723985096, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:126)");
                    }
                    AndroidComposeView owner = WrappedComposition.this.getOwner();
                    ComposerKt.sourceInformationMarkerStart(composer, 1107703815, "CC(remember):Wrapper.android.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(WrappedComposition.this);
                    WrappedComposition wrappedComposition3 = WrappedComposition.this;
                    WrappedComposition$setContent$1$2$1$1 rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new WrappedComposition$setContent$1$2$1$1(wrappedComposition3, null);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    EffectsKt.LaunchedEffect(owner, (Function2) rememberedValue, composer, 0);
                    AndroidComposeView owner2 = WrappedComposition.this.getOwner();
                    ComposerKt.sourceInformationMarkerStart(composer, 1107706824, "CC(remember):Wrapper.android.kt#9igjgp");
                    boolean changedInstance2 = composer.changedInstance(WrappedComposition.this);
                    WrappedComposition wrappedComposition4 = WrappedComposition.this;
                    WrappedComposition$setContent$1$2$2$1 rememberedValue2 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new WrappedComposition$setContent$1$2$2$1(wrappedComposition4, null);
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    EffectsKt.LaunchedEffect(owner2, (Function2) rememberedValue2, composer, 0);
                    composeViewContext.ProvideCompositionLocals$ui(WrappedComposition.this.getOwner(), function2, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void invoke$lambda$0(WrappedComposition wrappedComposition, Lifecycle lifecycle) {
        boolean z;
        z = wrappedComposition.disposed;
        if (z) {
            return;
        }
        wrappedComposition.addedToLifecycle = lifecycle;
        lifecycle.addObserver(wrappedComposition);
    }
}
