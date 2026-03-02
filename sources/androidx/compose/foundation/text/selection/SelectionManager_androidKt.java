package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.view.KeyEvent;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifier_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* compiled from: SelectionManager.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0000¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002"}, d2 = {"isCopyKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "isCopyKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "selectionMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "addSelectionContainerTextContextMenuComponents", "selectionManager", "foundation", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionManager_androidKt {
    /* renamed from: isCopyKeyEvent-ZmokQxo  reason: not valid java name */
    public static final boolean m1639isCopyKeyEventZmokQxo(KeyEvent keyEvent) {
        return KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1200mapZmokQxo(keyEvent) == KeyCommand.COPY;
    }

    public static final Modifier selectionMagnifier(Modifier modifier, final SelectionManager selectionManager) {
        return !Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null) ? modifier : ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SelectionManager_androidKt.selectionMagnifier$lambda$0(SelectionManager.this, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Modifier selectionMagnifier$lambda$0(final SelectionManager selectionManager, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-1914520728);
        ComposerKt.sourceInformation(composer, "C51@2356L7,52@2393L41,54@2501L68,55@2603L540:SelectionManager.android.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1914520728, i, -1, "androidx.compose.foundation.text.selection.selectionMagnifier.<anonymous> (SelectionManager.android.kt:51)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, -1608414511, "CC(remember):SelectionManager.android.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m7718boximpl(IntSize.Companion.m7731getZeroYbymL2g()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1608411028, "CC(remember):SelectionManager.android.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(selectionManager);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Offset selectionMagnifier$lambda$0$3$0;
                    selectionMagnifier$lambda$0$3$0 = SelectionManager_androidKt.selectionMagnifier$lambda$0$3$0(SelectionManager.this, mutableState);
                    return selectionMagnifier$lambda$0$3$0;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function0 function0 = (Function0) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1608407292, "CC(remember):SelectionManager.android.kt#9igjgp");
        boolean changed = composer.changed(density);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier selectionMagnifier$lambda$0$4$0;
                    selectionMagnifier$lambda$0$4$0 = SelectionManager_androidKt.selectionMagnifier$lambda$0$4$0(Density.this, mutableState, (Function0) obj);
                    return selectionMagnifier$lambda$0$4$0;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier animatedSelectionMagnifier = SelectionMagnifierKt.animatedSelectionMagnifier(modifier, function0, (Function1) rememberedValue3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return animatedSelectionMagnifier;
    }

    private static final long selectionMagnifier$lambda$0$1(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m7730unboximpl();
    }

    private static final void selectionMagnifier$lambda$0$2(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.m7718boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset selectionMagnifier$lambda$0$3$0(SelectionManager selectionManager, MutableState mutableState) {
        return Offset.m4516boximpl(SelectionManagerKt.m1634calculateSelectionMagnifierCenterAndroidO0kMr_c(selectionManager, selectionMagnifier$lambda$0$1(mutableState)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier selectionMagnifier$lambda$0$4$0(final Density density, final MutableState mutableState, final Function0 function0) {
        return Magnifier_androidKt.m333magnifierjPUL71Q$default(Modifier.Companion, new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Offset selectionMagnifier$lambda$0$4$0$0;
                selectionMagnifier$lambda$0$4$0$0 = SelectionManager_androidKt.selectionMagnifier$lambda$0$4$0$0(Function0.this, (Density) obj);
                return selectionMagnifier$lambda$0$4$0$0;
            }
        }, null, new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit selectionMagnifier$lambda$0$4$0$1;
                selectionMagnifier$lambda$0$4$0$1 = SelectionManager_androidKt.selectionMagnifier$lambda$0$4$0$1(Density.this, mutableState, (DpSize) obj);
                return selectionMagnifier$lambda$0$4$0$1;
            }
        }, 0.0f, true, 0L, 0.0f, 0.0f, false, PlatformMagnifierFactory.Companion.getForCurrentPlatform(), 490, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset selectionMagnifier$lambda$0$4$0$0(Function0 function0, Density density) {
        return (Offset) function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectionMagnifier$lambda$0$4$0$1(Density density, MutableState mutableState, DpSize dpSize) {
        selectionMagnifier$lambda$0$2(mutableState, IntSize.m7721constructorimpl((density.mo399roundToPx0680j_4(DpSize.m7653getWidthD9Ej5fM(dpSize.m7661unboximpl())) << 32) | (density.mo399roundToPx0680j_4(DpSize.m7651getHeightD9Ej5fM(dpSize.m7661unboximpl())) & 4294967295L)));
        return Unit.INSTANCE;
    }

    public static final Modifier addSelectionContainerTextContextMenuComponents(Modifier modifier, final SelectionManager selectionManager) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(modifier, new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0(SelectionManager.this, (TextContextMenuBuilderScope) obj, (Context) obj2);
            }
        });
    }

    static /* synthetic */ void addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$default(TextContextMenuBuilderScope textContextMenuBuilderScope, Context context, TextContextMenuItems textContextMenuItems, boolean z, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 8) != 0) {
            function0 = null;
        }
        addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem(textContextMenuBuilderScope, context, textContextMenuItems, z, function0, function02);
    }

    private static final void addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem(TextContextMenuBuilderScope textContextMenuBuilderScope, Context context, TextContextMenuItems textContextMenuItems, boolean z, final Function0<Boolean> function0, final Function0<Unit> function02) {
        ContextMenu_androidKt.textItem(textContextMenuBuilderScope, context.getResources(), textContextMenuItems, z, new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$0;
                addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$0 = SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$0(Function0.this, function0, (TextContextMenuSession) obj);
                return addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$0(Function0 function0, Function0 function02, TextContextMenuSession textContextMenuSession) {
        function0.invoke();
        if (function02 != null ? ((Boolean) function02.invoke()).booleanValue() : true) {
            textContextMenuSession.close();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit addSelectionContainerTextContextMenuComponents$lambda$0(final SelectionManager selectionManager, TextContextMenuBuilderScope textContextMenuBuilderScope, final Context context) {
        Pair<AnnotatedString, TextRange> contextTextAndSelection$foundation = selectionManager.getContextTextAndSelection$foundation();
        PlatformSelectionBehaviors_androidKt.m1600addPlatformTextContextMenuItems71BSaZU(textContextMenuBuilderScope, context, false, contextTextAndSelection$foundation != null ? contextTextAndSelection$foundation.getFirst() : null, contextTextAndSelection$foundation != null ? contextTextAndSelection$foundation.getSecond() : null, selectionManager.getPlatformSelectionBehaviors$foundation(), new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit addSelectionContainerTextContextMenuComponents$lambda$0$1;
                addSelectionContainerTextContextMenuComponents$lambda$0$1 = SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$1(SelectionManager.this, context, (TextContextMenuBuilderScope) obj);
                return addSelectionContainerTextContextMenuComponents$lambda$0$1;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSelectionContainerTextContextMenuComponents$lambda$0$1(final SelectionManager selectionManager, Context context, TextContextMenuBuilderScope textContextMenuBuilderScope) {
        textContextMenuBuilderScope.separator();
        addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$default(textContextMenuBuilderScope, context, TextContextMenuItems.Copy, selectionManager.isNonEmptySelection$foundation(), null, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit addSelectionContainerTextContextMenuComponents$lambda$0$1$0$0;
                addSelectionContainerTextContextMenuComponents$lambda$0$1$0$0 = SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$1$0$0(SelectionManager.this);
                return addSelectionContainerTextContextMenuComponents$lambda$0$1$0$0;
            }
        }, 8, null);
        addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem(textContextMenuBuilderScope, context, TextContextMenuItems.SelectAll, !selectionManager.isEntireContainerSelected$foundation(), new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean addSelectionContainerTextContextMenuComponents$lambda$0$1$0$1;
                addSelectionContainerTextContextMenuComponents$lambda$0$1$0$1 = SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$1$0$1(SelectionManager.this);
                return Boolean.valueOf(addSelectionContainerTextContextMenuComponents$lambda$0$1$0$1);
            }
        }, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit addSelectionContainerTextContextMenuComponents$lambda$0$1$0$2;
                addSelectionContainerTextContextMenuComponents$lambda$0$1$0$2 = SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$1$0$2(SelectionManager.this);
                return addSelectionContainerTextContextMenuComponents$lambda$0$1$0$2;
            }
        });
        textContextMenuBuilderScope.separator();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSelectionContainerTextContextMenuComponents$lambda$0$1$0$0(SelectionManager selectionManager) {
        selectionManager.copy$foundation();
        if (selectionManager.isInTouchMode()) {
            selectionManager.onRelease();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addSelectionContainerTextContextMenuComponents$lambda$0$1$0$1(SelectionManager selectionManager) {
        return (selectionManager.getShowToolbar$foundation() && selectionManager.isInTouchMode()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSelectionContainerTextContextMenuComponents$lambda$0$1$0$2(SelectionManager selectionManager) {
        selectionManager.selectAll$foundation();
        return Unit.INSTANCE;
    }
}
