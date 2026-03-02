package androidx.navigationevent.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.NavigationEventInfo;
import androidx.navigationevent.NavigationEventTransitionState;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: NavigationEventHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001aq\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\r\u001aE\u0010\u000e\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\u000f\u001aE\u0010\u0010\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"NavigationEventHandler", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/navigationevent/compose/NavigationEventState;", "Landroidx/navigationevent/NavigationEventInfo;", "isForwardEnabled", "", "onForwardCancelled", "Lkotlin/Function0;", "onForwardCompleted", "isBackEnabled", "onBackCancelled", "onBackCompleted", "(Landroidx/navigationevent/compose/NavigationEventState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NavigationBackHandler", "(Landroidx/navigationevent/compose/NavigationEventState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NavigationForwardHandler", "navigationevent-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavigationEventHandlerKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavigationBackHandler$lambda$25(NavigationEventState navigationEventState, boolean z, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        NavigationBackHandler(navigationEventState, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavigationEventHandler$lambda$18(NavigationEventState navigationEventState, boolean z, Function0 function0, Function0 function02, boolean z2, Function0 function03, Function0 function04, int i, int i2, Composer composer, int i3) {
        NavigationEventHandler(navigationEventState, z, function0, function02, z2, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavigationEventHandler$lambda$8(NavigationEventState navigationEventState, boolean z, Function0 function0, Function0 function02, boolean z2, Function0 function03, Function0 function04, int i, int i2, Composer composer, int i3) {
        NavigationEventHandler(navigationEventState, z, function0, function02, z2, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavigationForwardHandler$lambda$32(NavigationEventState navigationEventState, boolean z, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        NavigationForwardHandler(navigationEventState, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationEventHandler(NavigationEventState<? extends NavigationEventInfo> navigationEventState, boolean z, Function0<Unit> function0, Function0<Unit> function02, boolean z2, Function0<Unit> function03, Function0<Unit> function04, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        int i4;
        int i5;
        Object obj;
        int i6;
        boolean z4;
        int i7;
        Object obj2;
        int i8;
        final Function0<Unit> function05;
        final boolean z5;
        final Function0<Unit> function06;
        final boolean z6;
        final Function0<Unit> function07;
        final Function0<Unit> function08;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final NavigationEventState<? extends NavigationEventInfo> navigationEventState2 = navigationEventState;
        Composer startRestartGroup = composer.startRestartGroup(898330592);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationEventHandler)N(state,isForwardEnabled,onForwardCancelled,onForwardCompleted,isBackEnabled,onBackCancelled,onBackCompleted)73@3839L2,74@3880L2,77@3982L2,78@4020L2,80@4036L18,87@4356L7,93@4553L276,102@4846L467,102@4835L478,114@5343L373,114@5319L397:NavigationEventHandler.kt#wc8b4r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(navigationEventState2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            z3 = z;
            i3 |= startRestartGroup.changed(z3) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj = function02;
                    i3 |= startRestartGroup.changedInstance(obj) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        z4 = z2;
                        i3 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            obj2 = function03;
                        } else {
                            obj2 = function03;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i3 |= startRestartGroup.changedInstance(obj2) ? 131072 : 65536;
                            }
                        }
                        i8 = i2 & 64;
                        if (i8 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changedInstance(function04) ? 1048576 : 524288;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            function05 = function0;
                            z5 = z3;
                            function06 = obj2;
                            z6 = z4;
                            function07 = obj;
                            function08 = function04;
                        } else {
                            if (i9 != 0) {
                                z3 = true;
                            }
                            if (i4 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 7279202, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit unit;
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                function05 = (Function0) rememberedValue;
                            } else {
                                function05 = function0;
                            }
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 7280514, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit unit;
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                function07 = (Function0) rememberedValue2;
                            } else {
                                function07 = obj;
                            }
                            final boolean z7 = z3;
                            z6 = i6 != 0 ? true : z4;
                            if (i7 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 7283778, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit unit;
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                function06 = (Function0) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            } else {
                                function06 = obj2;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 7284994, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                    rememberedValue4 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit unit;
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                function08 = (Function0) rememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            } else {
                                function08 = function04;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(898330592, i3, -1, "androidx.navigationevent.compose.NavigationEventHandler (NavigationEventHandler.kt:79)");
                            }
                            if (!NavigationEventHandler_androidKt.isInspectionMode(startRestartGroup, 0)) {
                                NavigationEventDispatcherOwner current = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, 6);
                                if (current == null) {
                                    throw new IllegalStateException("No NavigationEventDispatcher was provided via LocalNavigationEventDispatcherOwner".toString());
                                }
                                final NavigationEventDispatcher navigationEventDispatcher = current.getNavigationEventDispatcher();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 7302324, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                int i10 = i3 & 14;
                                boolean z8 = i10 == 4;
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (z8 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                    rememberedValue5 = new ComposeNavigationEventHandler(navigationEventState2.getCurrentInfo(), new Function1() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj3) {
                                            return NavigationEventHandlerKt.NavigationEventHandler$lambda$11$lambda$10(NavigationEventState.this, (NavigationEventTransitionState) obj3);
                                        }
                                    });
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                final ComposeNavigationEventHandler composeNavigationEventHandler = (ComposeNavigationEventHandler) rememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 7311891, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                boolean changedInstance = ((i3 & 3670016) == 1048576) | startRestartGroup.changedInstance(composeNavigationEventHandler) | ((i3 & 112) == 32) | ((i3 & 896) == 256) | ((i3 & 7168) == 2048) | ((57344 & i3) == 16384) | ((458752 & i3) == 131072) | (i10 == 4);
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                                    z5 = z7;
                                    Function0 function09 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return NavigationEventHandlerKt.NavigationEventHandler$lambda$13$lambda$12(ComposeNavigationEventHandler.this, z5, function05, function07, z6, function06, function08, navigationEventState2);
                                        }
                                    };
                                    navigationEventState2 = navigationEventState2;
                                    startRestartGroup.updateRememberedValue(function09);
                                    rememberedValue6 = function09;
                                } else {
                                    z5 = z7;
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                EffectsKt.SideEffect((Function0) rememberedValue6, startRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 7327701, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                boolean changedInstance2 = startRestartGroup.changedInstance(composeNavigationEventHandler) | (i10 == 4) | startRestartGroup.changedInstance(navigationEventDispatcher);
                                Object rememberedValue7 = startRestartGroup.rememberedValue();
                                if (changedInstance2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                    rememberedValue7 = new Function1() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj3) {
                                            return NavigationEventHandlerKt.NavigationEventHandler$lambda$17$lambda$16(NavigationEventState.this, composeNavigationEventHandler, navigationEventDispatcher, (DisposableEffectScope) obj3);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                EffectsKt.DisposableEffect(navigationEventState2, (Function1) rememberedValue7, startRestartGroup, i10);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    function2 = new Function2() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj3, Object obj4) {
                                            return NavigationEventHandlerKt.NavigationEventHandler$lambda$8(NavigationEventState.this, z7, function05, function07, z6, function06, function08, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                        }
                                    };
                                    endRestartGroup.updateScope(function2);
                                    return;
                                }
                                return;
                            }
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            function2 = new Function2() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return NavigationEventHandlerKt.NavigationEventHandler$lambda$18(NavigationEventState.this, z5, function05, function07, z6, function06, function08, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            };
                            endRestartGroup.updateScope(function2);
                            return;
                        }
                        return;
                    }
                    z4 = z2;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj = function02;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                z4 = z2;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj = function02;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            z4 = z2;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            i8 = i2 & 64;
            if (i8 != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z3 = z;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj = function02;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        z4 = z2;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        i8 = i2 & 64;
        if (i8 != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavigationEventHandler$lambda$11$lambda$10(NavigationEventState navigationEventState, NavigationEventTransitionState navigationEventTransitionState) {
        navigationEventState.setTransitionState$navigationevent_compose(navigationEventTransitionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavigationEventHandler$lambda$13$lambda$12(ComposeNavigationEventHandler composeNavigationEventHandler, boolean z, Function0 function0, Function0 function02, boolean z2, Function0 function03, Function0 function04, NavigationEventState navigationEventState) {
        composeNavigationEventHandler.setForwardEnabled(z);
        composeNavigationEventHandler.setCurrentOnForwardCancelled(function0);
        composeNavigationEventHandler.setCurrentOnForwardCompleted(function02);
        composeNavigationEventHandler.setBackEnabled(z2);
        composeNavigationEventHandler.setCurrentOnBackCancelled(function03);
        composeNavigationEventHandler.setCurrentOnBackCompleted(function04);
        composeNavigationEventHandler.setInfo(navigationEventState.getCurrentInfo(), navigationEventState.getBackInfo(), navigationEventState.getForwardInfo());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult NavigationEventHandler$lambda$17$lambda$16(final NavigationEventState navigationEventState, final ComposeNavigationEventHandler composeNavigationEventHandler, NavigationEventDispatcher navigationEventDispatcher, DisposableEffectScope disposableEffectScope) {
        if (navigationEventState.getSourceHandler$navigationevent_compose() != null) {
            throw new IllegalArgumentException(("NavigationEventState '" + navigationEventState + "' is already registered with a NavigationEventHandler '" + composeNavigationEventHandler + "'.").toString());
        }
        ComposeNavigationEventHandler composeNavigationEventHandler2 = composeNavigationEventHandler;
        navigationEventState.setSourceHandler$navigationevent_compose(composeNavigationEventHandler2);
        NavigationEventDispatcher.addHandler$default(navigationEventDispatcher, composeNavigationEventHandler2, 0, 2, null);
        return new DisposableEffectResult() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$NavigationEventHandler$lambda$17$lambda$16$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ComposeNavigationEventHandler.this.remove();
                navigationEventState.setSourceHandler$navigationevent_compose(null);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationBackHandler(final NavigationEventState<? extends NavigationEventInfo> navigationEventState, boolean z, Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        boolean z2;
        int i4;
        Object obj2;
        final boolean z3;
        final Function0<Unit> function03;
        ScopeUpdateScope endRestartGroup;
        Function0<Unit> function04;
        Composer startRestartGroup = composer.startRestartGroup(1220469155);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBackHandler)N(state,isBackEnabled,onBackCancelled,onBackCompleted)150@6741L2,155@6862L2,156@6895L2,153@6786L296:NavigationEventHandler.kt#wc8b4r");
        if ((i & 6) == 0) {
            obj = navigationEventState;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = navigationEventState;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            z2 = z;
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = function0;
                i3 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
                }
                if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    startRestartGroup.skipToGroupEnd();
                    z3 = z2;
                    function03 = obj2;
                } else {
                    boolean z4 = i5 == 0 ? z2 : true;
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 344791685, "CC(remember):NavigationEventHandler.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit unit;
                                    unit = Unit.INSTANCE;
                                    return unit;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        function04 = (Function0) rememberedValue;
                    } else {
                        function04 = obj2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1220469155, i3, -1, "androidx.navigationevent.compose.NavigationBackHandler (NavigationEventHandler.kt:152)");
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 344795557, "CC(remember):NavigationEventHandler.kt#9igjgp");
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    Function0 function05 = (Function0) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 344796613, "CC(remember):NavigationEventHandler.kt#9igjgp");
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    int i6 = i3 << 9;
                    NavigationEventHandler(obj, false, function05, (Function0) rememberedValue3, z4, function04, function02, startRestartGroup, (i3 & 14) | 3504 | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z4;
                    function03 = function04;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return NavigationEventHandlerKt.NavigationBackHandler$lambda$25(NavigationEventState.this, z3, function03, function02, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            obj2 = function0;
            if ((i & 3072) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z2 = z;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = function0;
        if ((i & 3072) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationForwardHandler(final NavigationEventState<? extends NavigationEventInfo> navigationEventState, boolean z, Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        boolean z2;
        int i4;
        final Function0<Unit> function03;
        final boolean z3;
        ScopeUpdateScope endRestartGroup;
        Function0<Unit> function04;
        Composer startRestartGroup = composer.startRestartGroup(-1737636087);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationForwardHandler)N(state,isForwardEnabled,onForwardCancelled,onForwardCompleted)185@8106L2,193@8370L2,194@8400L2,188@8154L302:NavigationEventHandler.kt#wc8b4r");
        if ((i & 6) == 0) {
            obj = navigationEventState;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = navigationEventState;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            z2 = z;
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
                if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
                }
                if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    startRestartGroup.skipToGroupEnd();
                    function03 = function0;
                    z3 = z2;
                } else {
                    boolean z4 = i5 != 0 ? true : z2;
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 874004363, "CC(remember):NavigationEventHandler.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit unit;
                                    unit = Unit.INSTANCE;
                                    return unit;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        function04 = (Function0) rememberedValue;
                    } else {
                        function04 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1737636087, i3, -1, "androidx.navigationevent.compose.NavigationForwardHandler (NavigationEventHandler.kt:187)");
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 874012811, "CC(remember):NavigationEventHandler.kt#9igjgp");
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    Function0 function05 = (Function0) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 874013771, "CC(remember):NavigationEventHandler.kt#9igjgp");
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    NavigationEventHandler(obj, z4, function04, function02, false, function05, (Function0) rememberedValue3, startRestartGroup, (i3 & 14) | 1794048 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z4;
                    function03 = function04;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return NavigationEventHandlerKt.NavigationForwardHandler$lambda$32(NavigationEventState.this, z3, function03, function02, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            if ((i & 3072) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z2 = z;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        if ((i & 3072) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
