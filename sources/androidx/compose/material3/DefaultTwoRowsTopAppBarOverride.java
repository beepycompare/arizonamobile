package androidx.compose.material3;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultTwoRowsTopAppBarOverride;", "Landroidx/compose/material3/TwoRowsTopAppBarOverride;", "<init>", "()V", "TwoRowsTopAppBar", "", "Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;", "(Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "hideTopRowSemantics", ""}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultTwoRowsTopAppBarOverride implements TwoRowsTopAppBarOverride {
    public static final int $stable = 0;
    public static final DefaultTwoRowsTopAppBarOverride INSTANCE = new DefaultTwoRowsTopAppBarOverride();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final float TwoRowsTopAppBar$lambda$27$lambda$26$lambda$23$lambda$22() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TwoRowsTopAppBar$lambda$28(DefaultTwoRowsTopAppBarOverride defaultTwoRowsTopAppBarOverride, TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope, int i, Composer composer, int i2) {
        defaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar(twoRowsTopAppBarOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultTwoRowsTopAppBarOverride() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r13v25 */
    @Override // androidx.compose.material3.TwoRowsTopAppBarOverride
    public void TwoRowsTopAppBar(final TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Modifier.Companion companion;
        Modifier adjustHeightOffsetLimit;
        Composer startRestartGroup = composer.startRestartGroup(-1640665680);
        ComposerKt.sourceInformation(startRestartGroup, "C(TwoRowsTopAppBar)2742@128485L7,2749@128976L50,2750@129062L52,2754@129209L222,2761@129460L60,2762@129552L34,2766@129813L117,2797@131033L44,2798@131109L27,2799@131177L2,2793@130902L3154:AppBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(twoRowsTopAppBarOverrideScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1640665680, i2, -1, "androidx.compose.material3.DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar (AppBar.kt:2732)");
            }
            if (Float.isNaN(twoRowsTopAppBarOverrideScope.m2935getCollapsedHeightD9Ej5fM()) || (Float.floatToRawIntBits(twoRowsTopAppBarOverrideScope.m2935getCollapsedHeightD9Ej5fM()) & Integer.MAX_VALUE) >= 2139095040) {
                throw new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
            }
            if (Float.isNaN(twoRowsTopAppBarOverrideScope.m2936getExpandedHeightD9Ej5fM()) || (Float.floatToRawIntBits(twoRowsTopAppBarOverrideScope.m2936getExpandedHeightD9Ej5fM()) & Integer.MAX_VALUE) >= 2139095040) {
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
            }
            if (Dp.m7554compareTo0680j_4(twoRowsTopAppBarOverrideScope.m2936getExpandedHeightD9Ej5fM(), twoRowsTopAppBarOverrideScope.m2935getCollapsedHeightD9Ej5fM()) < 0) {
                throw new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int mo399roundToPx0680j_4 = ((Density) consume).mo399roundToPx0680j_4(twoRowsTopAppBarOverrideScope.m2937getTitleBottomPaddingD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426685886, "CC(remember):AppBar.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$5$lambda$4(TwoRowsTopAppBarOverrideScope.this));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final Function0 function0 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426683132, "CC(remember):AppBar.kt#9igjgp");
            boolean changed = (i3 == 4) | startRestartGroup.changed(function0);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function0) new Function0<Color>() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarContainerColor$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Color invoke() {
                        return Color.m4762boximpl(m2026invoke0d7_KjU());
                    }

                    /* renamed from: invoke-0d7_KjU  reason: not valid java name */
                    public final long m2026invoke0d7_KjU() {
                        return TwoRowsTopAppBarOverrideScope.this.getColors().m2907containerColorvNxB06k$material3(function0.invoke().floatValue());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final Function0 function02 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1333673671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$actionsRow$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C2755@129227L190:AppBar.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1333673671, i4, -1, "androidx.compose.material3.DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar.<anonymous> (AppBar.kt:2755)");
                    }
                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> actions = TwoRowsTopAppBarOverrideScope.this.getActions();
                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, Modifier.Companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m4041constructorimpl = Updater.m4041constructorimpl(composer3);
                    Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    actions.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426670388, "CC(remember):AppBar.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(function0);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float transform;
                        transform = AppBarKt.getTopTitleAlphaEasing().transform(((Number) Function0.this.invoke()).floatValue());
                        return Float.valueOf(transform);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function03 = rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426667470, "CC(remember):AppBar.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(function0);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$10$lambda$9(Function0.this));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function04 = rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426659035, "CC(remember):AppBar.kt#9igjgp");
            boolean changed4 = startRestartGroup.changed(function0);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed4 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$12$lambda$11(Function0.this));
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            State state = (State) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean z2 = !TwoRowsTopAppBar$lambda$13(state);
            if (twoRowsTopAppBarOverrideScope.getScrollBehavior() != null && !twoRowsTopAppBarOverrideScope.getScrollBehavior().isPinned()) {
                startRestartGroup.startReplaceGroup(-341140385);
                ComposerKt.sourceInformation(startRestartGroup, "2777@130356L107,2777@130333L130,2780@130501L312");
                Modifier.Companion companion2 = Modifier.Companion;
                Orientation orientation = Orientation.Vertical;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426641669, "CC(remember):AppBar.kt#9igjgp");
                boolean z3 = i3 == 4;
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$15$lambda$14(TwoRowsTopAppBarOverrideScope.this, ((Float) obj).floatValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue6, startRestartGroup, 0);
                Modifier.Companion companion3 = companion2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426636824, "CC(remember):AppBar.kt#9igjgp");
                boolean z4 = i3 == 4;
                DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1 rememberedValue7 = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1(twoRowsTopAppBarOverrideScope, null);
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                companion = DraggableKt.draggable$default(companion3, rememberDraggableState, orientation, false, null, false, null, rememberedValue7, false, TsExtractor.TS_PACKET_SIZE, null);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-340499894);
                startRestartGroup.endReplaceGroup();
                companion = Modifier.Companion;
            }
            Modifier then = twoRowsTopAppBarOverrideScope.getModifier().then(companion);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426620068, "CC(remember):AppBar.kt#9igjgp");
            boolean changed5 = startRestartGroup.changed(function02);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed5 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$18$lambda$17(Function0.this, (DrawScope) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier drawBehind = DrawModifierKt.drawBehind(then, (Function1) rememberedValue8);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426617653, "CC(remember):AppBar.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new Function1() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$20$lambda$19((SemanticsPropertyReceiver) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(drawBehind, false, (Function1) rememberedValue9, 1, null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426615502, "CC(remember):AppBar.kt#9igjgp");
            DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1 rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new PointerInputEventHandler() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(semantics$default, unit, (PointerInputEventHandler) rememberedValue10);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, pointerInput);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1325285569, "C2801@131204L2842:AppBar.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -200564612, "C2807@131523L6,2802@131229L1260,2833@133025L45,2825@132506L1526:AppBar.kt#uh7d8r");
            Modifier clipToBounds = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, twoRowsTopAppBarOverrideScope.getWindowInsets()));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1379010106, "CC(remember):AppBar.kt#9igjgp");
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new FloatProducer() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda7
                    @Override // androidx.compose.material3.internal.FloatProducer
                    public final float invoke() {
                        return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$27$lambda$26$lambda$23$lambda$22();
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AppBarKt.m1731TopAppBarLayoutlyUyIHI(clipToBounds, (FloatProducer) rememberedValue11, twoRowsTopAppBarOverrideScope.getColors().m2911getNavigationIconContentColor0d7_KjU(), twoRowsTopAppBarOverrideScope.getColors().m2914getTitleContentColor0d7_KjU(), twoRowsTopAppBarOverrideScope.getColors().m2913getSubtitleContentColor0d7_KjU(), twoRowsTopAppBarOverrideScope.getColors().m2909getActionIconContentColor0d7_KjU(), twoRowsTopAppBarOverrideScope.getSmallTitle(), twoRowsTopAppBarOverrideScope.getSmallTitleTextStyle(), twoRowsTopAppBarOverrideScope.getSmallSubtitle(), twoRowsTopAppBarOverrideScope.getSmallSubtitleTextStyle(), function03, Arrangement.INSTANCE.getCenter(), twoRowsTopAppBarOverrideScope.getTitleHorizontalAlignment(), 0, TwoRowsTopAppBar$lambda$13(state), twoRowsTopAppBarOverrideScope.getNavigationIcon(), rememberComposableLambda, twoRowsTopAppBarOverrideScope.m2935getCollapsedHeightD9Ej5fM(), startRestartGroup, 0, 1575984);
            adjustHeightOffsetLimit = AppBarKt.adjustHeightOffsetLimit(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, WindowInsetsKt.m891onlybOOhFvg(twoRowsTopAppBarOverrideScope.getWindowInsets(), WindowInsetsSides.Companion.m913getHorizontalJoeWqyM()))), twoRowsTopAppBarOverrideScope.getScrollBehavior());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1379058209, "CC(remember):AppBar.kt#9igjgp");
            boolean z5 = i3 == 4;
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new FloatProducer() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda8
                    @Override // androidx.compose.material3.internal.FloatProducer
                    public final float invoke() {
                        return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$27$lambda$26$lambda$25$lambda$24(TwoRowsTopAppBarOverrideScope.this);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            AppBarKt.m1731TopAppBarLayoutlyUyIHI(adjustHeightOffsetLimit, (FloatProducer) rememberedValue12, twoRowsTopAppBarOverrideScope.getColors().m2911getNavigationIconContentColor0d7_KjU(), twoRowsTopAppBarOverrideScope.getColors().m2914getTitleContentColor0d7_KjU(), twoRowsTopAppBarOverrideScope.getColors().m2913getSubtitleContentColor0d7_KjU(), twoRowsTopAppBarOverrideScope.getColors().m2909getActionIconContentColor0d7_KjU(), twoRowsTopAppBarOverrideScope.getTitle(), twoRowsTopAppBarOverrideScope.getTitleTextStyle(), twoRowsTopAppBarOverrideScope.getSubtitle(), twoRowsTopAppBarOverrideScope.getSubtitleTextStyle(), function04, Arrangement.INSTANCE.getBottom(), twoRowsTopAppBarOverrideScope.getTitleHorizontalAlignment(), mo399roundToPx0680j_4, z2, ComposableSingletons$AppBarKt.INSTANCE.m1926getLambda$2101264077$material3(), ComposableSingletons$AppBarKt.INSTANCE.getLambda$37575796$material3(), Dp.m7555constructorimpl(twoRowsTopAppBarOverrideScope.m2936getExpandedHeightD9Ej5fM() - twoRowsTopAppBarOverrideScope.m2935getCollapsedHeightD9Ej5fM()), composer2, 0, 1769520);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$28(DefaultTwoRowsTopAppBarOverride.this, twoRowsTopAppBarOverrideScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final float TwoRowsTopAppBar$lambda$5$lambda$4(TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope) {
        TopAppBarState state;
        TopAppBarScrollBehavior scrollBehavior = twoRowsTopAppBarOverrideScope.getScrollBehavior();
        if (scrollBehavior == null || (state = scrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.getCollapsedFraction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final float TwoRowsTopAppBar$lambda$10$lambda$9(Function0 function0) {
        return 1.0f - ((Number) function0.invoke()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean TwoRowsTopAppBar$lambda$12$lambda$11(Function0 function0) {
        return ((Number) function0.invoke()).floatValue() < 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TwoRowsTopAppBar$lambda$15$lambda$14(TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope, float f) {
        TopAppBarState state = twoRowsTopAppBarOverrideScope.getScrollBehavior().getState();
        state.setHeightOffset(state.getHeightOffset() + f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TwoRowsTopAppBar$lambda$18$lambda$17(Function0 function0, DrawScope drawScope) {
        DrawScope.m5340drawRectnJ9OG0$default(drawScope, ((Color) function0.invoke()).m4782unboximpl(), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TwoRowsTopAppBar$lambda$20$lambda$19(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final float TwoRowsTopAppBar$lambda$27$lambda$26$lambda$25$lambda$24(TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope) {
        TopAppBarState state;
        TopAppBarScrollBehavior scrollBehavior = twoRowsTopAppBarOverrideScope.getScrollBehavior();
        if (scrollBehavior == null || (state = scrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.getHeightOffset();
    }

    private static final boolean TwoRowsTopAppBar$lambda$13(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
