package com.arkivanov.decompose.extensions.compose.utils;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputConsumingOverlay.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"InputConsumingOverlay", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InputConsumingOverlayKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputConsumingOverlay$lambda$1(Modifier modifier, int i, Composer composer, int i2) {
        InputConsumingOverlay(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void InputConsumingOverlay(final Modifier modifier, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-502821345);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-502821345, i2, -1, "com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlay (InputConsumingOverlay.kt:8)");
            }
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1757309367);
            InputConsumingOverlayKt$InputConsumingOverlay$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new PointerInputEventHandler() { // from class: com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlayKt$InputConsumingOverlay$1$1

                    /* compiled from: InputConsumingOverlay.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlayKt$InputConsumingOverlay$1$1$1", f = "InputConsumingOverlay.kt", i = {0}, l = {14}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
                    /* renamed from: com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlayKt$InputConsumingOverlay$1$1$1  reason: invalid class name */
                    /* loaded from: classes.dex */
                    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                        private /* synthetic */ Object L$0;
                        int label;

                        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
                            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
                            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
                            */
                        /* JADX WARN: Removed duplicated region for block: B:11:0x0031 A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[LOOP:0: B:13:0x003e->B:15:0x0044, LOOP_END] */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002f -> B:12:0x0032). Please submit an issue!!! */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                            /*
                                r4 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r4.label
                                r2 = 1
                                if (r1 == 0) goto L1b
                                if (r1 != r2) goto L13
                                java.lang.Object r1 = r4.L$0
                                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                                kotlin.ResultKt.throwOnFailure(r5)
                                goto L32
                            L13:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L1b:
                                kotlin.ResultKt.throwOnFailure(r5)
                                java.lang.Object r5 = r4.L$0
                                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                                r1 = r5
                            L23:
                                r5 = r4
                                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                                r4.L$0 = r1
                                r4.label = r2
                                r3 = 0
                                java.lang.Object r5 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r1, r3, r5, r2, r3)
                                if (r5 != r0) goto L32
                                return r0
                            L32:
                                androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                                java.util.List r5 = r5.getChanges()
                                java.lang.Iterable r5 = (java.lang.Iterable) r5
                                java.util.Iterator r5 = r5.iterator()
                            L3e:
                                boolean r3 = r5.hasNext()
                                if (r3 == 0) goto L23
                                java.lang.Object r3 = r5.next()
                                androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
                                r3.consume()
                                goto L3e
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlayKt$InputConsumingOverlay$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass1(null), continuation);
                        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifier, unit, (PointerInputEventHandler) rememberedValue), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlayKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputConsumingOverlayKt.InputConsumingOverlay$lambda$1(Modifier.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
