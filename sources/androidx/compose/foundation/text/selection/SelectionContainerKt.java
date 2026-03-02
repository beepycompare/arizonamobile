package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.ClipboardEventsHandler_jvmKt$rememberClipboardEventsHandler$1;
import androidx.compose.foundation.text.ClipboardEventsHandler_jvmKt$rememberClipboardEventsHandler$3;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* compiled from: SelectionContainer.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002"}, d2 = {"SelectionContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DisableSelection", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionContainerKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DisableSelection$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        DisableSelection(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelectionContainer$lambda$11(Modifier modifier, Selection selection, Function1 function1, Function2 function2, int i, int i2, Composer composer, int i3) {
        SelectionContainer(modifier, selection, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelectionContainer$lambda$4(Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        SelectionContainer(modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SelectionContainer(final Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(1949207773);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionContainer)N(modifier,content)57@2606L45,61@2764L18,58@2656L161:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1949207773, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:56)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 582932362, "CC(remember):SelectionContainer.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i5 = i3;
            Selection SelectionContainer$lambda$1 = SelectionContainer$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 582937391, "CC(remember):SelectionContainer.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SelectionContainer$lambda$3$0;
                        SelectionContainer$lambda$3$0 = SelectionContainerKt.SelectionContainer$lambda$3$0(MutableState.this, (Selection) obj);
                        return SelectionContainer$lambda$3$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier modifier2 = modifier;
            function22 = function2;
            SelectionContainer(modifier2, SelectionContainer$lambda$1, (Function1) rememberedValue2, function22, startRestartGroup, (i5 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i5 << 6) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectionContainerKt.SelectionContainer$lambda$4(Modifier.this, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$3$0(MutableState mutableState, Selection selection) {
        mutableState.setValue(selection);
        return Unit.INSTANCE;
    }

    public static final void DisableSelection(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1162635549);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableSelection)N(content)74@3108L82:SelectionContainer.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162635549, i2, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:73)");
            }
            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null), function2, startRestartGroup, ((i2 << 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectionContainerKt.DisableSelection$lambda$0(Function2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SelectionContainer(Modifier modifier, final Selection selection, final Function1<? super Selection, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-917932944);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionContainer)N(modifier,selection,onSelectionChange,children)95@3856L28,95@3801L83,97@3904L44,99@3985L7,100@4018L24,101@4092L7,103@4136L345,112@4525L7,122@4906L136,134@5420L2468,134@5363L2525,190@7920L106,190@7894L132:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            companion = obj;
        } else {
            companion = i4 != 0 ? Modifier.Companion : obj;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-917932944, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:93)");
            }
            Object[] objArr = new Object[0];
            Saver<SelectionRegistrarImpl, Long> saver = SelectionRegistrarImpl.Companion.getSaver();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1665249940, "CC(remember):SelectionContainer.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        SelectionRegistrarImpl SelectionContainer$lambda$5$0;
                        SelectionContainer$lambda$5$0 = SelectionContainerKt.SelectionContainer$lambda$5$0();
                        return SelectionContainer$lambda$5$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) RememberSaveableKt.m4213rememberSaveable(objArr, saver, (Function0<? extends Object>) rememberedValue, startRestartGroup, (int) RendererCapabilities.DECODER_SUPPORT_MASK);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1665248388, "CC(remember):SelectionContainer.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final SelectionManager selectionManager = (SelectionManager) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalClipboard());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Clipboard clipboard = (Clipboard) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setHapticFeedBack((HapticFeedback) consume2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1665240663, "CC(remember):SelectionContainer.kt#9igjgp");
            boolean changed = startRestartGroup.changed(coroutineScope) | startRestartGroup.changed(clipboard);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = ClipboardUtils_androidKt.isWriteSupported(clipboard) ? new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit SelectionContainer$lambda$7$0;
                        SelectionContainer$lambda$7$0 = SelectionContainerKt.SelectionContainer$lambda$7$0(CoroutineScope.this, clipboard, (AnnotatedString) obj2);
                        return SelectionContainer$lambda$7$0;
                    }
                } : null;
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setOnCopyHandler((Function1) rememberedValue4);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setTextToolbar((TextToolbar) consume3);
            selectionManager.setOnSelectionChange(function1);
            selectionManager.setSelection(selection);
            if (!ComposeFoundationFlags.isSmartSelectionEnabled) {
                startRestartGroup.startReplaceGroup(-86967598);
            } else {
                startRestartGroup.startReplaceGroup(-82280708);
                ComposerKt.sourceInformation(startRestartGroup, "118@4777L69");
                selectionManager.setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.StaticText, null, startRestartGroup, 54));
                selectionManager.setCoroutineScope$foundation(coroutineScope);
            }
            startRestartGroup.endReplaceGroup();
            new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    AnnotatedString selectedText$foundation;
                    selectedText$foundation = SelectionManager.this.getSelectedText$foundation();
                    return selectedText$foundation;
                }
            };
            selectionManager.isNonEmptySelection$foundation();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1197772674, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvm.kt#423gt5");
            ClipboardEventsHandler_jvmKt$rememberClipboardEventsHandler$1 clipboardEventsHandler_jvmKt$rememberClipboardEventsHandler$1 = ClipboardEventsHandler_jvmKt$rememberClipboardEventsHandler$1.INSTANCE;
            ClipboardEventsHandler_jvmKt$rememberClipboardEventsHandler$3 clipboardEventsHandler_jvmKt$rememberClipboardEventsHandler$3 = ClipboardEventsHandler_jvmKt$rememberClipboardEventsHandler$3.INSTANCE;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SimpleLayoutKt.SimpleLayout(companion.then(selectionManager.getModifier()), ComposableLambdaKt.rememberComposableLambda(-1799563674, true, new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SelectionContainerKt.SelectionContainer$lambda$9(SelectionManager.this, selectionRegistrarImpl, function2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1665119814, "CC(remember):SelectionContainer.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(selectionManager);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        DisposableEffectResult SelectionContainer$lambda$10$0;
                        SelectionContainer$lambda$10$0 = SelectionContainerKt.SelectionContainer$lambda$10$0(SelectionManager.this, (DisposableEffectScope) obj2);
                        return SelectionContainer$lambda$10$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(selectionManager, (Function1) rememberedValue5, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = companion;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SelectionContainerKt.SelectionContainer$lambda$11(Modifier.this, selection, function1, function2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SelectionRegistrarImpl SelectionContainer$lambda$5$0() {
        return new SelectionRegistrarImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$7$0(CoroutineScope coroutineScope, Clipboard clipboard, AnnotatedString annotatedString) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new SelectionContainerKt$SelectionContainer$3$1$1(clipboard, annotatedString, null), 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelectionContainer$lambda$9(final SelectionManager selectionManager, final SelectionRegistrarImpl selectionRegistrarImpl, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C135@5455L2427,135@5430L2452:SelectionContainer.kt#eksfi3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1799563674, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:135)");
            }
            ContextMenu_androidKt.ContextMenuArea(selectionManager, ComposableLambdaKt.rememberComposableLambda(-284825865, true, new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectionContainer$lambda$9$0;
                    SelectionContainer$lambda$9$0 = SelectionContainerKt.SelectionContainer$lambda$9$0(SelectionRegistrarImpl.this, function2, selectionManager, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectionContainer$lambda$9$0;
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$9$0(SelectionRegistrarImpl selectionRegistrarImpl, final Function2 function2, final SelectionManager selectionManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C136@5542L2330,136@5469L2403:SelectionContainer.kt#eksfi3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-284825865, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:136)");
            }
            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(selectionRegistrarImpl), ComposableLambdaKt.rememberComposableLambda(610483127, true, new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectionContainer$lambda$9$0$0;
                    SelectionContainer$lambda$9$0$0 = SelectionContainerKt.SelectionContainer$lambda$9$0$0(Function2.this, selectionManager, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectionContainer$lambda$9$0$0;
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$9$0$0(Function2 function2, final SelectionManager selectionManager, Composer composer, int i) {
        Object obj;
        ResolvedTextDirection direction;
        float endHandleLineHeight;
        ComposerKt.sourceInformation(composer, "C137@5560L10:SelectionContainer.kt#eksfi3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(610483127, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:137)");
            }
            function2.invoke(composer, 0);
            if (!selectionManager.isInTouchMode() || !selectionManager.getHasFocus() || selectionManager.isTriviallyCollapsedSelection$foundation()) {
                composer.startReplaceGroup(2005806539);
            } else {
                composer.startReplaceGroup(-1736224054);
                ComposerKt.sourceInformation(composer, "");
                Selection selection = selectionManager.getSelection();
                if (selection == null) {
                    composer.startReplaceGroup(2011629175);
                } else {
                    composer.startReplaceGroup(2011629176);
                    ComposerKt.sourceInformation(composer, "");
                    composer.startReplaceGroup(-1736222526);
                    ComposerKt.sourceInformation(composer, "*146@5961L137,151@6197L385,179@7634L127,172@7196L596");
                    List listOf = CollectionsKt.listOf((Object[]) new Boolean[]{true, false});
                    int size = listOf.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        boolean booleanValue = ((Boolean) listOf.get(i2)).booleanValue();
                        ComposerKt.sourceInformationMarkerStart(composer, -465225385, "CC(remember):SelectionContainer.kt#9igjgp");
                        boolean changed = composer.changed(booleanValue);
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = selectionManager.handleDragObserver(booleanValue);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        final TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerStart(composer, -465217585, "CC(remember):SelectionContainer.kt#9igjgp");
                        boolean changed2 = composer.changed(booleanValue);
                        Object rememberedValue2 = composer.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            if (booleanValue) {
                                obj = new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Offset SelectionContainer$lambda$9$0$0$0$0$1$0;
                                        SelectionContainer$lambda$9$0$0$0$0$1$0 = SelectionContainerKt.SelectionContainer$lambda$9$0$0$0$0$1$0(SelectionManager.this);
                                        return SelectionContainer$lambda$9$0$0$0$0$1$0;
                                    }
                                };
                            } else {
                                obj = new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Offset SelectionContainer$lambda$9$0$0$0$0$1$1;
                                        SelectionContainer$lambda$9$0$0$0$0$1$1 = SelectionContainerKt.SelectionContainer$lambda$9$0$0$0$0$1$1(SelectionManager.this);
                                        return SelectionContainer$lambda$9$0$0$0$0$1$1;
                                    }
                                };
                            }
                            rememberedValue2 = obj;
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        Function0 function0 = (Function0) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (booleanValue) {
                            direction = selection.getStart().getDirection();
                        } else {
                            direction = selection.getEnd().getDirection();
                        }
                        if (booleanValue) {
                            endHandleLineHeight = selectionManager.getStartHandleLineHeight();
                        } else {
                            endHandleLineHeight = selectionManager.getEndHandleLineHeight();
                        }
                        float f = endHandleLineHeight;
                        SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 = new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(function0);
                        boolean handlesCrossed = selection.getHandlesCrossed();
                        Modifier.Companion companion = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart(composer, -465171859, "CC(remember):SelectionContainer.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(textDragObserver);
                        Object rememberedValue3 = composer.rememberedValue();
                        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = (PointerInputEventHandler) new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1
                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object detectDownAndDragGesturesWithObserver = LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(pointerInputScope, TextDragObserver.this, continuation);
                                    return detectDownAndDragGesturesWithObserver == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDownAndDragGesturesWithObserver : Unit.INSTANCE;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        AndroidSelectionHandles_androidKt.m1579SelectionHandlewLIcFTc(selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0, booleanValue, direction, handlesCrossed, 0L, f, SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) rememberedValue3), composer, 0, 16);
                    }
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset SelectionContainer$lambda$9$0$0$0$0$1$0(SelectionManager selectionManager) {
        Offset m1628getStartHandlePosition_m7T9E = selectionManager.m1628getStartHandlePosition_m7T9E();
        return Offset.m4516boximpl(m1628getStartHandlePosition_m7T9E != null ? m1628getStartHandlePosition_m7T9E.m4537unboximpl() : Offset.Companion.m4542getUnspecifiedF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset SelectionContainer$lambda$9$0$0$0$0$1$1(SelectionManager selectionManager) {
        Offset m1627getEndHandlePosition_m7T9E = selectionManager.m1627getEndHandlePosition_m7T9E();
        return Offset.m4516boximpl(m1627getEndHandlePosition_m7T9E != null ? m1627getEndHandlePosition_m7T9E.m4537unboximpl() : Offset.Companion.m4542getUnspecifiedF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SelectionContainer$lambda$10$0(final SelectionManager selectionManager, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$lambda$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                SelectionManager.this.onRelease();
                SelectionManager.this.setHasFocus(false);
            }
        };
    }
}
