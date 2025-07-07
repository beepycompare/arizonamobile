package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import com.arkivanov.essenty.backhandler.BackCallback;
import com.arkivanov.essenty.backhandler.BackCallbackKt;
import com.arkivanov.essenty.backhandler.BackEvent;
import com.arkivanov.essenty.backhandler.BackHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BackGestureHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"BackGestureHandler", "", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "onBackStarted", "Lkotlin/Function1;", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "onBackProgressed", "onBackCancelled", "Lkotlin/Function0;", "onBack", "(Lcom/arkivanov/essenty/backhandler/BackHandler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackGestureHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackGestureHandler$lambda$9(BackHandler backHandler, Function1 function1, Function1 function12, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        BackGestureHandler(backHandler, function1, function12, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackGestureHandler$lambda$1$lambda$0(BackEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackGestureHandler$lambda$3$lambda$2(BackEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BackGestureHandler(BackHandler backHandler, Function1<? super BackEvent, Unit> function1, Function1<? super BackEvent, Unit> function12, Function0<Unit> function0, final Function0<Unit> onBack, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        final Function1<? super BackEvent, Unit> function13;
        final Function0<Unit> function02;
        boolean changedInstance;
        Object rememberedValue;
        final Function0<Unit> function03;
        final Function1<? super BackEvent, Unit> function14;
        ScopeUpdateScope endRestartGroup;
        final BackHandler backHandler2 = backHandler;
        Intrinsics.checkNotNullParameter(backHandler2, "backHandler");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer startRestartGroup = composer.startRestartGroup(1795243716);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(backHandler2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = function1;
            i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = function12;
                i3 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj3 = function0;
                    i3 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changedInstance(onBack) ? 16384 : 8192;
                    }
                    i6 = i3;
                    if ((i6 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                        if (i7 != 0) {
                            startRestartGroup.startReplaceGroup(-1358038039);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj4) {
                                        Unit BackGestureHandler$lambda$1$lambda$0;
                                        BackGestureHandler$lambda$1$lambda$0 = BackGestureHandlerKt.BackGestureHandler$lambda$1$lambda$0((BackEvent) obj4);
                                        return BackGestureHandler$lambda$1$lambda$0;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceGroup();
                            obj = (Function1) rememberedValue2;
                        }
                        if (i4 == 0) {
                            startRestartGroup.startReplaceGroup(-1358036503);
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj4) {
                                        Unit BackGestureHandler$lambda$3$lambda$2;
                                        BackGestureHandler$lambda$3$lambda$2 = BackGestureHandlerKt.BackGestureHandler$lambda$3$lambda$2((BackEvent) obj4);
                                        return BackGestureHandler$lambda$3$lambda$2;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            function13 = (Function1) rememberedValue3;
                            startRestartGroup.endReplaceGroup();
                        } else {
                            function13 = obj2;
                        }
                        if (i5 == 0) {
                            startRestartGroup.startReplaceGroup(-1358035287);
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit unit;
                                        unit = Unit.INSTANCE;
                                        return unit;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            function02 = (Function0) rememberedValue4;
                            startRestartGroup.endReplaceGroup();
                        } else {
                            function02 = obj3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1795243716, i6, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandler (BackGestureHandler.kt:15)");
                        }
                        startRestartGroup.startReplaceGroup(-1358032828);
                        changedInstance = ((i6 & 112) != 32) | ((i6 & 896) != 256) | ((i6 & 7168) != 2048) | ((57344 & i6) == 16384) | startRestartGroup.changedInstance(backHandler2);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            final Function1<? super BackEvent, Unit> function15 = obj;
                            Function1 function16 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj4) {
                                    DisposableEffectResult BackGestureHandler$lambda$8$lambda$7;
                                    BackGestureHandler$lambda$8$lambda$7 = BackGestureHandlerKt.BackGestureHandler$lambda$8$lambda$7(Function1.this, function13, function02, onBack, backHandler2, (DisposableEffectScope) obj4);
                                    return BackGestureHandler$lambda$8$lambda$7;
                                }
                            };
                            backHandler2 = backHandler2;
                            startRestartGroup.updateRememberedValue(function16);
                            rememberedValue = function16;
                        }
                        startRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(backHandler2, (Function1) rememberedValue, startRestartGroup, i6 & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function03 = function02;
                        function14 = function13;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        function14 = obj2;
                        function03 = obj3;
                    }
                    final Function1<? super BackEvent, Unit> function17 = obj;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                Unit BackGestureHandler$lambda$9;
                                BackGestureHandler$lambda$9 = BackGestureHandlerKt.BackGestureHandler$lambda$9(BackHandler.this, function17, function14, function03, onBack, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                                return BackGestureHandler$lambda$9;
                            }
                        });
                        return;
                    }
                    return;
                }
                obj3 = function0;
                if ((i2 & 16) == 0) {
                }
                i6 = i3;
                if ((i6 & 9363) == 9362) {
                }
                if (i7 != 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-1358032828);
                changedInstance = ((i6 & 112) != 32) | ((i6 & 896) != 256) | ((i6 & 7168) != 2048) | ((57344 & i6) == 16384) | startRestartGroup.changedInstance(backHandler2);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                final Function1 function152 = obj;
                Function1 function162 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        DisposableEffectResult BackGestureHandler$lambda$8$lambda$7;
                        BackGestureHandler$lambda$8$lambda$7 = BackGestureHandlerKt.BackGestureHandler$lambda$8$lambda$7(Function1.this, function13, function02, onBack, backHandler2, (DisposableEffectScope) obj4);
                        return BackGestureHandler$lambda$8$lambda$7;
                    }
                };
                backHandler2 = backHandler2;
                startRestartGroup.updateRememberedValue(function162);
                rememberedValue = function162;
                startRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(backHandler2, (Function1) rememberedValue, startRestartGroup, i6 & 14);
                if (ComposerKt.isTraceInProgress()) {
                }
                function03 = function02;
                function14 = function13;
                final Function1 function172 = obj;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = function12;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj3 = function0;
            if ((i2 & 16) == 0) {
            }
            i6 = i3;
            if ((i6 & 9363) == 9362) {
            }
            if (i7 != 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-1358032828);
            changedInstance = ((i6 & 112) != 32) | ((i6 & 896) != 256) | ((i6 & 7168) != 2048) | ((57344 & i6) == 16384) | startRestartGroup.changedInstance(backHandler2);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            final Function1 function1522 = obj;
            Function1 function1622 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    DisposableEffectResult BackGestureHandler$lambda$8$lambda$7;
                    BackGestureHandler$lambda$8$lambda$7 = BackGestureHandlerKt.BackGestureHandler$lambda$8$lambda$7(Function1.this, function13, function02, onBack, backHandler2, (DisposableEffectScope) obj4);
                    return BackGestureHandler$lambda$8$lambda$7;
                }
            };
            backHandler2 = backHandler2;
            startRestartGroup.updateRememberedValue(function1622);
            rememberedValue = function1622;
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(backHandler2, (Function1) rememberedValue, startRestartGroup, i6 & 14);
            if (ComposerKt.isTraceInProgress()) {
            }
            function03 = function02;
            function14 = function13;
            final Function1 function1722 = obj;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = function1;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = function12;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj3 = function0;
        if ((i2 & 16) == 0) {
        }
        i6 = i3;
        if ((i6 & 9363) == 9362) {
        }
        if (i7 != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-1358032828);
        changedInstance = ((i6 & 112) != 32) | ((i6 & 896) != 256) | ((i6 & 7168) != 2048) | ((57344 & i6) == 16384) | startRestartGroup.changedInstance(backHandler2);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        final Function1 function15222 = obj;
        Function1 function16222 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj4) {
                DisposableEffectResult BackGestureHandler$lambda$8$lambda$7;
                BackGestureHandler$lambda$8$lambda$7 = BackGestureHandlerKt.BackGestureHandler$lambda$8$lambda$7(Function1.this, function13, function02, onBack, backHandler2, (DisposableEffectScope) obj4);
                return BackGestureHandler$lambda$8$lambda$7;
            }
        };
        backHandler2 = backHandler2;
        startRestartGroup.updateRememberedValue(function16222);
        rememberedValue = function16222;
        startRestartGroup.endReplaceGroup();
        EffectsKt.DisposableEffect(backHandler2, (Function1) rememberedValue, startRestartGroup, i6 & 14);
        if (ComposerKt.isTraceInProgress()) {
        }
        function03 = function02;
        function14 = function13;
        final Function1 function17222 = obj;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BackGestureHandler$lambda$8$lambda$7(Function1 function1, Function1 function12, Function0 function0, Function0 function02, final BackHandler backHandler, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final BackCallback BackCallback$default = BackCallbackKt.BackCallback$default(false, 0, function1, function12, function0, function02, 3, null);
        backHandler.register(BackCallback$default);
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.BackGestureHandlerKt$BackGestureHandler$lambda$8$lambda$7$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                BackHandler.this.unregister(BackCallback$default);
            }
        };
    }
}
