package androidx.compose.material3;

import android.content.res.Configuration;
import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002\u001aV\u0010\u001e\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u000e\u0010)\u001a\u00020\u001b*\u0004\u0018\u00010*H\u0002\u001a\f\u0010+\u001a\u00020\u001b*\u00020\u0012H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,²\u0006\f\u0010-\u001a\u0004\u0018\u00010*X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\u0019X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "Lkotlin/Function0;", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/geometry/Rect;", "anchorBounds", "verticalMargin", "expandable", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-Gq7TBQ4", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getWindowBounds", "material3_release", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenu_androidKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m6684constructorimpl(16);

    public static final /* synthetic */ float access$getExposedDropdownMenuItemHorizontalPadding$p() {
        return ExposedDropdownMenuItemHorizontalPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:279:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Modifier.Companion companion;
        View view;
        Density density;
        int mo383roundToPx0680j_4;
        Object rememberedValue;
        final MutableState mutableState;
        Object rememberedValue2;
        MutableIntState mutableIntState;
        Object rememberedValue3;
        final MutableIntState mutableIntState2;
        Object rememberedValue4;
        final FocusRequester focusRequester;
        Object rememberedValue5;
        int i4;
        int i5;
        boolean changed;
        Object obj2;
        Modifier modifier2;
        Density density2;
        int i6;
        int i7;
        final int i8;
        final MutableIntState mutableIntState3;
        int i9;
        final View view2;
        final FocusRequester focusRequester2;
        boolean changedInstance;
        Object rememberedValue6;
        final MutableState mutableState2;
        final MutableIntState mutableIntState4;
        int currentCompositeKeyHash;
        Composer m3520constructorimpl;
        boolean z2;
        Object rememberedValue7;
        boolean z3;
        Object rememberedValue8;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        final boolean z4 = z;
        final Function1<? super Boolean, Unit> function12 = function1;
        Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        Composer startRestartGroup = composer.startRestartGroup(2067579792);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenuBox)P(1,3,2)140@6498L7,141@6531L7,142@6570L7,146@6683L53,147@6760L33,148@6819L33,150@6879L29,151@6970L7,152@7008L31,153@7071L32,154@7132L37,155@7196L62,158@7284L2210,200@9543L361,199@9500L442,225@10317L47,225@10306L58,229@10529L27,229@10497L59:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z4) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                companion = i10 == 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2067579792, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:139)");
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Configuration configuration = (Configuration) consume;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                view = (View) consume2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                density = (Density) consume3;
                mo383roundToPx0680j_4 = density.mo383roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426259219, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                mutableState = (MutableState) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426261663, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                mutableIntState = (MutableIntState) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426263551, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                mutableIntState2 = (MutableIntState) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426265467, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new FocusRequester();
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                focusRequester = (FocusRequester) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) consume4;
                Strings.Companion companion2 = Strings.Companion;
                final String m2779getString2EP1pXo = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_dropdown_menu_expanded), startRestartGroup, 0);
                Strings.Companion companion3 = Strings.Companion;
                final String m2779getString2EP1pXo2 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_dropdown_menu_collapsed), startRestartGroup, 0);
                Strings.Companion companion4 = Strings.Companion;
                final String m2779getString2EP1pXo3 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_dropdown_menu_toggle), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426275644, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MenuAnchorType.m2021boximpl(MenuAnchorType.Companion.m2029getPrimaryNotEditableMg6Rgbw()), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                final MutableState mutableState3 = (MutableState) rememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426280608, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                i4 = i3 & 14;
                boolean z5 = i4 != 4;
                i5 = i3 & 112;
                changed = startRestartGroup.changed(configuration) | (i5 != 32) | z5 | startRestartGroup.changed(view) | startRestartGroup.changed(density);
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue9 == Composer.Companion.getEmpty()) {
                    modifier2 = companion;
                    density2 = density;
                    i6 = i5;
                    i7 = i4;
                    i8 = mo383roundToPx0680j_4;
                    mutableIntState3 = mutableIntState;
                    i9 = i3;
                    view2 = view;
                    obj2 = new ExposedDropdownMenuBoxScopeImpl() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        /* renamed from: menuAnchor-fsE2BvY */
                        public Modifier mo1887menuAnchorfsE2BvY(Modifier modifier4, final String str, boolean z6) {
                            Modifier.Companion m1896expandableGq7TBQ4;
                            Modifier focusRequester3 = FocusRequesterModifierKt.focusRequester(modifier4, FocusRequester.this);
                            if (!z6) {
                                m1896expandableGq7TBQ4 = Modifier.Companion;
                            } else {
                                boolean z7 = z;
                                final MutableState<MenuAnchorType> mutableState4 = mutableState3;
                                final Function1<Boolean, Unit> function13 = function1;
                                final boolean z8 = z;
                                m1896expandableGq7TBQ4 = ExposedDropdownMenu_androidKt.m1896expandableGq7TBQ4(Modifier.Companion, z7, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        mutableState4.setValue(MenuAnchorType.m2021boximpl(str));
                                        function13.invoke(Boolean.valueOf(!z8));
                                    }
                                }, str, m2779getString2EP1pXo, m2779getString2EP1pXo2, m2779getString2EP1pXo3, softwareKeyboardController);
                            }
                            return focusRequester3.then(m1896expandableGq7TBQ4);
                        }

                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        /* renamed from: getAnchorType-Mg6Rgbw$material3_release */
                        public String mo1886getAnchorTypeMg6Rgbw$material3_release() {
                            return mutableState3.getValue().m2027unboximpl();
                        }

                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        public Modifier exposedDropdownSize(Modifier modifier4, final boolean z6) {
                            final MutableIntState mutableIntState5 = mutableIntState3;
                            final MutableIntState mutableIntState6 = mutableIntState2;
                            return LayoutModifierKt.layout(modifier4, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                    return m1897invoke3p2s80s(measureScope, measurable, constraints.m6643unboximpl());
                                }

                                /* renamed from: invoke-3p2s80s  reason: not valid java name */
                                public final MeasureResult m1897invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                    int ExposedDropdownMenuBox$lambda$5;
                                    int ExposedDropdownMenuBox$lambda$8;
                                    ExposedDropdownMenuBox$lambda$5 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5(mutableIntState5);
                                    int m6654constrainWidthK40F9xA = ConstraintsKt.m6654constrainWidthK40F9xA(j, ExposedDropdownMenuBox$lambda$5);
                                    ExposedDropdownMenuBox$lambda$8 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8(mutableIntState6);
                                    int m6653constrainHeightK40F9xA = ConstraintsKt.m6653constrainHeightK40F9xA(j, ExposedDropdownMenuBox$lambda$8);
                                    int m6639getMinWidthimpl = z6 ? m6654constrainWidthK40F9xA : Constraints.m6639getMinWidthimpl(j);
                                    if (!z6) {
                                        m6654constrainWidthK40F9xA = Constraints.m6637getMaxWidthimpl(j);
                                    }
                                    final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j, m6639getMinWidthimpl, m6654constrainWidthK40F9xA, 0, m6653constrainHeightK40F9xA, 4, null));
                                    return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                            Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            });
                        }
                    };
                    focusRequester2 = focusRequester;
                    z4 = z;
                    function12 = function1;
                    startRestartGroup.updateRememberedValue(obj2);
                } else {
                    function12 = function1;
                    obj2 = rememberedValue9;
                    i9 = i3;
                    modifier2 = companion;
                    density2 = density;
                    i6 = i5;
                    focusRequester2 = focusRequester;
                    i7 = i4;
                    i8 = mo383roundToPx0680j_4;
                    mutableIntState3 = mutableIntState;
                    z4 = z;
                    view2 = view;
                }
                ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) obj2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426351047, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                changedInstance = startRestartGroup.changedInstance(view2) | startRestartGroup.changed(i8);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                    final MutableIntState mutableIntState5 = mutableIntState3;
                    final int i11 = i8;
                    final View view3 = view2;
                    Object obj3 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            Rect windowBounds;
                            LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                            Rect anchorBounds;
                            int calculateMaxHeight;
                            mutableState.setValue(layoutCoordinates);
                            mutableIntState5.setIntValue(IntSize.m6855getWidthimpl(layoutCoordinates.mo5446getSizeYbymL2g()));
                            MutableIntState mutableIntState6 = mutableIntState2;
                            windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view3.getRootView());
                            ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState);
                            anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                            calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i11);
                            mutableIntState6.setIntValue(calculateMaxHeight);
                        }
                    };
                    mutableState2 = mutableState;
                    mutableIntState4 = mutableIntState2;
                    rememberedValue6 = (Function1) obj3;
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                } else {
                    mutableIntState4 = mutableIntState2;
                    mutableState2 = mutableState;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) rememberedValue6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Modifier modifier4 = modifier2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -615130921, "C211@9927L9:ExposedDropdownMenu.android.kt#uh7d8r");
                function32 = function3;
                function32.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1, startRestartGroup, Integer.valueOf((i9 >> 6) & 112));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.startReplaceGroup(426363998);
                ComposerKt.sourceInformation(startRestartGroup, "215@10008L286,215@9972L322");
                if (z4) {
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426365852, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                    boolean changedInstance2 = startRestartGroup.changedInstance(view2) | startRestartGroup.changed(i8);
                    Object rememberedValue10 = startRestartGroup.rememberedValue();
                    if (changedInstance2 || rememberedValue10 == Composer.Companion.getEmpty()) {
                        rememberedValue10 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Rect windowBounds;
                                LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                                Rect anchorBounds;
                                int calculateMaxHeight;
                                MutableIntState mutableIntState6 = mutableIntState4;
                                windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view2.getRootView());
                                ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState2);
                                anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                                calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i8);
                                mutableIntState6.setIntValue(calculateMaxHeight);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue10);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    SoftKeyboardListener(view2, density2, (Function0) rememberedValue10, startRestartGroup, 0);
                }
                startRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426375501, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                int i12 = i7;
                z2 = i12 != 4;
                rememberedValue7 = startRestartGroup.rememberedValue();
                if (!z2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (z4) {
                                focusRequester2.requestFocus();
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.SideEffect((Function0) rememberedValue7, startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426382265, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                z3 = i6 != 32;
                rememberedValue8 = startRestartGroup.rememberedValue();
                if (!z3 || rememberedValue8 == Composer.Companion.getEmpty()) {
                    rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function12.invoke(false);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                BackHandlerKt.BackHandler(z4, (Function0) rememberedValue8, startRestartGroup, i12, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = obj;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(z4, function12, modifier3, function33, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        if (i10 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume5 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Configuration configuration2 = (Configuration) consume5;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        view = (View) consume22;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume32 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        density = (Density) consume32;
        mo383roundToPx0680j_4 = density.mo383roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426259219, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426261663, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
        }
        mutableIntState = (MutableIntState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426263551, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
        }
        mutableIntState2 = (MutableIntState) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426265467, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
        }
        focusRequester = (FocusRequester) rememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume42 = startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final SoftwareKeyboardController softwareKeyboardController2 = (SoftwareKeyboardController) consume42;
        Strings.Companion companion22 = Strings.Companion;
        final String m2779getString2EP1pXo4 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_dropdown_menu_expanded), startRestartGroup, 0);
        Strings.Companion companion32 = Strings.Companion;
        final String m2779getString2EP1pXo22 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_dropdown_menu_collapsed), startRestartGroup, 0);
        Strings.Companion companion42 = Strings.Companion;
        final String m2779getString2EP1pXo32 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_dropdown_menu_toggle), startRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426275644, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
        }
        final MutableState<MenuAnchorType> mutableState32 = (MutableState) rememberedValue5;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426280608, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        i4 = i3 & 14;
        if (i4 != 4) {
        }
        i5 = i3 & 112;
        if (i5 != 32) {
        }
        changed = startRestartGroup.changed(configuration2) | (i5 != 32) | z5 | startRestartGroup.changed(view) | startRestartGroup.changed(density);
        Object rememberedValue92 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        modifier2 = companion;
        density2 = density;
        i6 = i5;
        i7 = i4;
        i8 = mo383roundToPx0680j_4;
        mutableIntState3 = mutableIntState;
        i9 = i3;
        view2 = view;
        obj2 = new ExposedDropdownMenuBoxScopeImpl() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
            @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
            /* renamed from: menuAnchor-fsE2BvY */
            public Modifier mo1887menuAnchorfsE2BvY(Modifier modifier42, final String str, boolean z6) {
                Modifier.Companion m1896expandableGq7TBQ4;
                Modifier focusRequester3 = FocusRequesterModifierKt.focusRequester(modifier42, FocusRequester.this);
                if (!z6) {
                    m1896expandableGq7TBQ4 = Modifier.Companion;
                } else {
                    boolean z7 = z;
                    final MutableState<MenuAnchorType> mutableState4 = mutableState32;
                    final Function1<? super Boolean, Unit> function13 = function1;
                    final boolean z8 = z;
                    m1896expandableGq7TBQ4 = ExposedDropdownMenu_androidKt.m1896expandableGq7TBQ4(Modifier.Companion, z7, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState4.setValue(MenuAnchorType.m2021boximpl(str));
                            function13.invoke(Boolean.valueOf(!z8));
                        }
                    }, str, m2779getString2EP1pXo4, m2779getString2EP1pXo22, m2779getString2EP1pXo32, softwareKeyboardController2);
                }
                return focusRequester3.then(m1896expandableGq7TBQ4);
            }

            @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
            /* renamed from: getAnchorType-Mg6Rgbw$material3_release */
            public String mo1886getAnchorTypeMg6Rgbw$material3_release() {
                return mutableState32.getValue().m2027unboximpl();
            }

            @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
            public Modifier exposedDropdownSize(Modifier modifier42, final boolean z6) {
                final MutableIntState mutableIntState52 = mutableIntState3;
                final MutableIntState mutableIntState6 = mutableIntState2;
                return LayoutModifierKt.layout(modifier42, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m1897invoke3p2s80s(measureScope, measurable, constraints.m6643unboximpl());
                    }

                    /* renamed from: invoke-3p2s80s  reason: not valid java name */
                    public final MeasureResult m1897invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        int ExposedDropdownMenuBox$lambda$5;
                        int ExposedDropdownMenuBox$lambda$8;
                        ExposedDropdownMenuBox$lambda$5 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5(mutableIntState52);
                        int m6654constrainWidthK40F9xA = ConstraintsKt.m6654constrainWidthK40F9xA(j, ExposedDropdownMenuBox$lambda$5);
                        ExposedDropdownMenuBox$lambda$8 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8(mutableIntState6);
                        int m6653constrainHeightK40F9xA = ConstraintsKt.m6653constrainHeightK40F9xA(j, ExposedDropdownMenuBox$lambda$8);
                        int m6639getMinWidthimpl = z6 ? m6654constrainWidthK40F9xA : Constraints.m6639getMinWidthimpl(j);
                        if (!z6) {
                            m6654constrainWidthK40F9xA = Constraints.m6637getMaxWidthimpl(j);
                        }
                        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j, m6639getMinWidthimpl, m6654constrainWidthK40F9xA, 0, m6653constrainHeightK40F9xA, 4, null));
                        return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                });
            }
        };
        focusRequester2 = focusRequester;
        z4 = z;
        function12 = function1;
        startRestartGroup.updateRememberedValue(obj2);
        ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$12 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) obj2;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426351047, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        changedInstance = startRestartGroup.changedInstance(view2) | startRestartGroup.changed(i8);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (changedInstance) {
        }
        final MutableIntState mutableIntState52 = mutableIntState3;
        final int i112 = i8;
        final View view32 = view2;
        Object obj32 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                Rect windowBounds;
                LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                Rect anchorBounds;
                int calculateMaxHeight;
                mutableState.setValue(layoutCoordinates);
                mutableIntState52.setIntValue(IntSize.m6855getWidthimpl(layoutCoordinates.mo5446getSizeYbymL2g()));
                MutableIntState mutableIntState6 = mutableIntState2;
                windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view32.getRootView());
                ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState);
                anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i112);
                mutableIntState6.setIntValue(calculateMaxHeight);
            }
        };
        mutableState2 = mutableState;
        mutableIntState4 = mutableIntState2;
        rememberedValue6 = (Function1) obj32;
        startRestartGroup.updateRememberedValue(rememberedValue6);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) rememberedValue6);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned2);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
        Modifier modifier42 = modifier2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
        Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m3520constructorimpl.getInserting()) {
        }
        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m3527setimpl(m3520constructorimpl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -615130921, "C211@9927L9:ExposedDropdownMenu.android.kt#uh7d8r");
        function32 = function3;
        function32.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$12, startRestartGroup, Integer.valueOf((i9 >> 6) & 112));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.startReplaceGroup(426363998);
        ComposerKt.sourceInformation(startRestartGroup, "215@10008L286,215@9972L322");
        if (z4) {
        }
        startRestartGroup.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426375501, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        int i122 = i7;
        if (i122 != 4) {
        }
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (!z2) {
        }
        rememberedValue7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (z4) {
                    focusRequester2.requestFocus();
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue7);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        EffectsKt.SideEffect((Function0) rememberedValue7, startRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 426382265, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        if (i6 != 32) {
        }
        rememberedValue8 = startRestartGroup.rememberedValue();
        if (!z3) {
        }
        rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function12.invoke(false);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue8);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        BackHandlerKt.BackHandler(z4, (Function0) rememberedValue8, startRestartGroup, i122, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    public static final void SoftKeyboardListener(final View view, final Density density, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1319522472);
        ComposerKt.sourceInformation(startRestartGroup, "C(SoftKeyboardListener)P(2)240@10912L1420,240@10880L1452:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(view) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(density) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319522472, i2, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:237)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1935200244, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(view) | ((i2 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(view, function0);
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1.this.dispose();
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(view, density, (Function1) rememberedValue, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ExposedDropdownMenu_androidKt.SoftKeyboardListener(view, density, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* renamed from: expandable-Gq7TBQ4 */
    public static final Modifier m1896expandableGq7TBQ4(Modifier modifier, final boolean z, final Function0<Unit> function0, final String str, final String str2, final String str3, final String str4, final SoftwareKeyboardController softwareKeyboardController) {
        Modifier then;
        then = modifier.then(new SuspendPointerInputElement(function0, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new ExposedDropdownMenu_androidKt$expandable$1(str, function0, null)), 6, null));
        return SemanticsModifierKt.semantics$default(then, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (MenuAnchorType.m2024equalsimpl0(str, MenuAnchorType.Companion.m2030getSecondaryEditableMg6Rgbw())) {
                    SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5911getButtono7Vup1c());
                    SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, z ? str2 : str3);
                    SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str4);
                } else {
                    SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5914getDropdownListo7Vup1c());
                }
                final Function0<Unit> function02 = function0;
                final String str5 = str;
                final SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        SoftwareKeyboardController softwareKeyboardController3;
                        function02.invoke();
                        if (MenuAnchorType.m2024equalsimpl0(str5, MenuAnchorType.Companion.m2028getPrimaryEditableMg6Rgbw()) && (softwareKeyboardController3 = softwareKeyboardController2) != null) {
                            softwareKeyboardController3.show();
                        }
                        return true;
                    }
                }, 1, null);
            }
        }, 1, null);
    }

    public static final int calculateMaxHeight(Rect rect, Rect rect2, int i) {
        int roundToInt;
        if (rect2 == null) {
            return 0;
        }
        float f = i;
        float top = rect.getTop() + f;
        float bottom = rect.getBottom() - f;
        if (rect2.getTop() > rect.getBottom() || rect2.getBottom() < rect.getTop()) {
            roundToInt = MathKt.roundToInt(bottom - top);
        } else {
            roundToInt = MathKt.roundToInt(Math.max(rect2.getTop() - top, bottom - rect2.getBottom()));
        }
        return Math.max(roundToInt, 0);
    }

    public static final Rect getWindowBounds(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.toComposeRect(rect);
    }

    public static final Rect getAnchorBounds(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates == null ? Rect.Companion.getZero() : RectKt.m3877Recttz77jQw(LayoutCoordinatesKt.positionInWindow(layoutCoordinates), IntSizeKt.m6867toSizeozmzZPI(layoutCoordinates.mo5446getSizeYbymL2g()));
    }
}
