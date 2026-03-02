package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
/* compiled from: WideNavigationRail.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultModalWideNavigationRailOverride;", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "<init>", "()V", "ModalWideNavigationRail", "", "Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;", "(Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "isCollapsed", "", "modalExpanded"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultModalWideNavigationRailOverride implements ModalWideNavigationRailOverride {
    public static final int $stable = 0;
    public static final DefaultModalWideNavigationRailOverride INSTANCE = new DefaultModalWideNavigationRailOverride();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRail$lambda$23(DefaultModalWideNavigationRailOverride defaultModalWideNavigationRailOverride, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, int i, Composer composer, int i2) {
        defaultModalWideNavigationRailOverride.ModalWideNavigationRail(modalWideNavigationRailOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultModalWideNavigationRailOverride() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.coroutines.Continuation, kotlinx.coroutines.channels.BufferOverflow, java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v23 */
    @Override // androidx.compose.material3.ModalWideNavigationRailOverride
    public void ModalWideNavigationRail(final ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, Composer composer, final int i) {
        int i2;
        final ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope2;
        Function2<Composer, Integer, Unit> function2;
        int i3;
        ?? r4;
        boolean z;
        float f;
        Composer startRestartGroup = composer.startRestartGroup(1751235721);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalWideNavigationRail)509@25093L7,511@25254L14,513@25306L230,524@25833L7,521@25580L275,526@25892L60,527@25991L62,528@26105L132,535@26304L176,557@27012L48:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(modalWideNavigationRailOverrideScope) : startRestartGroup.changedInstance(modalWideNavigationRailOverrideScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            modalWideNavigationRailOverrideScope2 = modalWideNavigationRailOverrideScope;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1751235721, i2, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail (WideNavigationRail.kt:503)");
            }
            if (modalWideNavigationRailOverrideScope.getShouldHideOnCollapse()) {
                startRestartGroup.startReplaceGroup(95781714);
                startRestartGroup.endReplaceGroup();
                function2 = modalWideNavigationRailOverrideScope.getContent();
            } else {
                startRestartGroup.startReplaceGroup(95826602);
                ComposerKt.sourceInformation(startRestartGroup, "507@25009L47");
                Function2<Composer, Integer, Unit> content = modalWideNavigationRailOverrideScope.getContent();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689645480, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean changed = startRestartGroup.changed(content);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = MovableContentKt.movableContentOf(modalWideNavigationRailOverrideScope.getContent());
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                function2 = (Function2) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
            }
            final Function2<Composer, Integer, Unit> function22 = function2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            FiniteAnimationSpec value = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
            WideNavigationRailState state = modalWideNavigationRailOverrideScope.getState();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689635793, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(state);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new ModalWideNavigationRailState(modalWideNavigationRailOverrideScope.getState(), density, value);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final ModalWideNavigationRailState modalWideNavigationRailState = (ModalWideNavigationRailState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(!WideNavigationRailStateKt.isExpanded(modalWideNavigationRailOverrideScope.getState().getTargetValue()) ? 0.0f : 1.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, startRestartGroup, 6), 0.0f, null, null, startRestartGroup, 0, 28);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689617211, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$3$lambda$2(State.this));
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            State state2 = (State) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689614041, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$6$lambda$5(State.this));
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final State state3 = (State) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689610323, "CC(remember):WideNavigationRail.kt#9igjgp");
            int i4 = i2 & 14;
            boolean changedInstance = (i4 == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(modalWideNavigationRailOverrideScope))) | startRestartGroup.changedInstance(modalWideNavigationRailState);
            DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1(modalWideNavigationRailOverrideScope, modalWideNavigationRailState, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final Function1 function1 = rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689603911, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean changedInstance2 = (i4 == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(modalWideNavigationRailOverrideScope))) | startRestartGroup.changedInstance(modalWideNavigationRailState);
            DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1(modalWideNavigationRailOverrideScope, modalWideNavigationRailState, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final Function2 function23 = rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (!modalWideNavigationRailOverrideScope.getShouldHideOnCollapse() && ModalWideNavigationRail$lambda$4(state2)) {
                startRestartGroup.startReplaceGroup(97400069);
                ComposerKt.sourceInformation(startRestartGroup, "544@26598L380");
                i3 = i4;
                r4 = 0;
                WideNavigationRailKt.WideNavigationRailLayout(modalWideNavigationRailOverrideScope.getModifier(), false, false, modalWideNavigationRailOverrideScope.getColors(), modalWideNavigationRailOverrideScope.getCollapsedShape(), modalWideNavigationRailOverrideScope.getHeader(), modalWideNavigationRailOverrideScope.getWindowInsets(), modalWideNavigationRailOverrideScope.getArrangement(), function22, startRestartGroup, 432);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                i3 = i4;
                r4 = 0;
                startRestartGroup.startReplaceGroup(97788313);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689581383, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = ChannelKt.Channel$default(-1, r4, r4, 6, r4);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final Channel channel = (Channel) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (modalWideNavigationRailOverrideScope.getShouldHideOnCollapse()) {
                startRestartGroup.startReplaceGroup(97908438);
                ComposerKt.sourceInformation(startRestartGroup, "559@27133L403,559@27109L427");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689577156, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(channel) | startRestartGroup.changedInstance(modalWideNavigationRailState);
                DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 rememberedValue8 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue8 == Composer.Companion.getEmpty()) {
                    rememberedValue8 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1(channel, modalWideNavigationRailState, r4);
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.LaunchedEffect(channel, (Function2) rememberedValue8, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(98341849);
                startRestartGroup.endReplaceGroup();
            }
            if (!ModalWideNavigationRail$lambda$4(state2)) {
                startRestartGroup.startReplaceGroup(98512256);
                ComposerKt.sourceInformation(startRestartGroup, "583@28043L24,584@28109L42,585@28190L38,587@28253L49,587@28242L60,591@28431L37,592@28505L110,595@28661L93,599@28829L1724,589@28316L2237");
                if (!modalWideNavigationRailOverrideScope.getShouldHideOnCollapse()) {
                    startRestartGroup.startReplaceGroup(98472731);
                    ComposerKt.sourceInformation(startRestartGroup, "578@27806L197");
                    Modifier m263backgroundbw27NRU = BackgroundKt.m263backgroundbw27NRU(Modifier.Companion, modalWideNavigationRailOverrideScope.getColors().m2943getContainerColor0d7_KjU(), modalWideNavigationRailOverrideScope.getCollapsedShape());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m263backgroundbw27NRU);
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1258502535, "C579@27908L77:WideNavigationRail.kt#uh7d8r");
                    Modifier modifier = modalWideNavigationRailOverrideScope.getModifier();
                    f = WideNavigationRailKt.CollapsedRailWidth;
                    Modifier m871widthInVpY3zN4$default = SizeKt.m871widthInVpY3zN4$default(modifier, f, 0.0f, 2, r4);
                    z = true;
                    SpacerKt.Spacer(SizeKt.fillMaxHeight$default(m871widthInVpY3zN4$default, 0.0f, 1, r4), startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceGroup();
                } else {
                    z = true;
                    startRestartGroup.startReplaceGroup(98809081);
                    startRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    rememberedValue9 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689546285, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object rememberedValue10 = startRestartGroup.rememberedValue();
                if (rememberedValue10 == Composer.Companion.getEmpty()) {
                    rememberedValue10 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, r4);
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                }
                final Animatable animatable = (Animatable) rememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689543697, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object rememberedValue11 = startRestartGroup.rememberedValue();
                if (rememberedValue11 == Composer.Companion.getEmpty()) {
                    rememberedValue11 = new RailPredictiveBackState();
                    startRestartGroup.updateRememberedValue(rememberedValue11);
                }
                final RailPredictiveBackState railPredictiveBackState = (RailPredictiveBackState) rememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689541670, "CC(remember):WideNavigationRail.kt#9igjgp");
                int i5 = i3;
                boolean changedInstance4 = startRestartGroup.changedInstance(channel) | ((i5 == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(modalWideNavigationRailOverrideScope))) ? z : false);
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue12 == Composer.Companion.getEmpty()) {
                    rememberedValue12 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$16$lambda$15(Channel.this, modalWideNavigationRailOverrideScope);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                boolean z2 = false;
                EffectsKt.SideEffect((Function0) rememberedValue12, startRestartGroup, 0);
                ModalWideNavigationRailProperties expandedProperties = modalWideNavigationRailOverrideScope.getExpandedProperties();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689535986, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean changedInstance5 = startRestartGroup.changedInstance(coroutineScope);
                if (i5 == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(modalWideNavigationRailOverrideScope))) {
                    z2 = z;
                }
                boolean z3 = changedInstance5 | z2;
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue13 == Composer.Companion.getEmpty()) {
                    rememberedValue13 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$18$lambda$17(CoroutineScope.this, modalWideNavigationRailOverrideScope);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                }
                Function0 function0 = rememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689533545, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean changedInstance6 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(animatable);
                Object rememberedValue14 = startRestartGroup.rememberedValue();
                if (changedInstance6 || rememberedValue14 == Composer.Companion.getEmpty()) {
                    rememberedValue14 = new Function1() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$20$lambda$19(CoroutineScope.this, animatable, ((Float) obj).floatValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue14);
                }
                Function1 function12 = rememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -689528570, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean changedInstance7 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(animatable);
                Object rememberedValue15 = startRestartGroup.rememberedValue();
                if (changedInstance7 || rememberedValue15 == Composer.Companion.getEmpty()) {
                    rememberedValue15 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$22$lambda$21(CoroutineScope.this, animatable);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Function2<Composer, Integer, Unit> function24 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:39:0x0189  */
                    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(Composer composer2, int i6) {
                        boolean ModalWideNavigationRail$lambda$7;
                        boolean z4;
                        boolean z5;
                        float f2;
                        boolean ModalWideNavigationRail$lambda$72;
                        ComposerKt.sourceInformation(composer2, "C600@28847L1692:WideNavigationRail.kt#uh7d8r");
                        if (!composer2.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1345045690, i6, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.<anonymous> (WideNavigationRail.kt:600)");
                        }
                        Modifier imePadding = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null));
                        final ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope3 = ModalWideNavigationRailOverrideScope.this;
                        ModalWideNavigationRailState modalWideNavigationRailState2 = modalWideNavigationRailState;
                        Function1<Continuation<? super Unit>, Object> function13 = function1;
                        Animatable<Float, AnimationVector1D> animatable2 = animatable;
                        RailPredictiveBackState railPredictiveBackState2 = railPredictiveBackState;
                        Function2<Float, Continuation<? super Unit>, Object> function25 = function23;
                        Function2<Composer, Integer, Unit> function26 = function22;
                        State<Boolean> state4 = state3;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, imePadding);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4041constructorimpl2 = Updater.m4041constructorimpl(composer2);
                        Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 238599055, "C608@29206L195,625@30078L201,614@29423L1098:WideNavigationRail.kt#uh7d8r");
                        if (!modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse()) {
                            ModalWideNavigationRail$lambda$7 = DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$7(state4);
                            z4 = ModalWideNavigationRail$lambda$7;
                        } else {
                            z4 = modalWideNavigationRailState2.getTargetValue() != WideNavigationRailValue.Collapsed;
                        }
                        WideNavigationRailKt.m2953Scrim3JVO9M(modalWideNavigationRailOverrideScope3.getColors().m2947getModalScrimColor0d7_KjU(), function13, z4, composer2, 0);
                        if (!modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse()) {
                            ModalWideNavigationRail$lambda$72 = DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$7(state4);
                            if (!ModalWideNavigationRail$lambda$72) {
                                z5 = false;
                                boolean shouldHideOnCollapse = modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse();
                                Modifier modifier2 = modalWideNavigationRailOverrideScope3.getModifier();
                                WideNavigationRailColors colors = modalWideNavigationRailOverrideScope3.getColors();
                                Shape expandedShape = modalWideNavigationRailOverrideScope3.getExpandedShape();
                                f2 = WideNavigationRailKt.ExpandedRailMaxWidth;
                                WideNavigationRailKt.m2952ModalWideNavigationRailContentpU6N4AM(z5, shouldHideOnCollapse, animatable2, railPredictiveBackState2, function25, modifier2, modalWideNavigationRailState2, colors, expandedShape, f2, ComposableLambdaKt.rememberComposableLambda(208840989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7$1$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i7) {
                                        ComposerKt.sourceInformation(composer3, "C626@30108L145:WideNavigationRail.kt#uh7d8r");
                                        if (!composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(208840989, i7, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.<anonymous>.<anonymous>.<anonymous> (WideNavigationRail.kt:626)");
                                        }
                                        Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(Modifier.Companion, 0.0f, ModalWideNavigationRailOverrideScope.this.m2258getExpandedHeaderTopPaddingD9Ej5fM(), 0.0f, 0.0f, 13, null);
                                        ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope4 = ModalWideNavigationRailOverrideScope.this;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, m822paddingqDBjuR0$default);
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m4041constructorimpl3 = Updater.m4041constructorimpl(composer3);
                                        Updater.m4049setimpl(m4041constructorimpl3, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1627808976, "C:WideNavigationRail.kt#uh7d8r");
                                        Function2<Composer, Integer, Unit> header = modalWideNavigationRailOverrideScope4.getHeader();
                                        if (header == null) {
                                            composer3.startReplaceGroup(-1627801290);
                                        } else {
                                            composer3.startReplaceGroup(-2130719701);
                                            ComposerKt.sourceInformation(composer3, "627@30215L8");
                                            header.invoke(composer3, 0);
                                        }
                                        composer3.endReplaceGroup();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), modalWideNavigationRailOverrideScope3.getWindowInsets(), modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse(), modalWideNavigationRailOverrideScope3.getArrangement(), function26, composer2, (Animatable.$stable << 6) | 805309440, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    return;
                                }
                                ComposerKt.traceEventEnd();
                                return;
                            }
                        }
                        z5 = true;
                        boolean shouldHideOnCollapse2 = modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse();
                        Modifier modifier22 = modalWideNavigationRailOverrideScope3.getModifier();
                        WideNavigationRailColors colors2 = modalWideNavigationRailOverrideScope3.getColors();
                        Shape expandedShape2 = modalWideNavigationRailOverrideScope3.getExpandedShape();
                        f2 = WideNavigationRailKt.ExpandedRailMaxWidth;
                        WideNavigationRailKt.m2952ModalWideNavigationRailContentpU6N4AM(z5, shouldHideOnCollapse2, animatable2, railPredictiveBackState2, function25, modifier22, modalWideNavigationRailState2, colors2, expandedShape2, f2, ComposableLambdaKt.rememberComposableLambda(208840989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i7) {
                                ComposerKt.sourceInformation(composer3, "C626@30108L145:WideNavigationRail.kt#uh7d8r");
                                if (!composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(208840989, i7, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.<anonymous>.<anonymous>.<anonymous> (WideNavigationRail.kt:626)");
                                }
                                Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(Modifier.Companion, 0.0f, ModalWideNavigationRailOverrideScope.this.m2258getExpandedHeaderTopPaddingD9Ej5fM(), 0.0f, 0.0f, 13, null);
                                ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope4 = ModalWideNavigationRailOverrideScope.this;
                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, m822paddingqDBjuR0$default);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor3);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m4041constructorimpl3 = Updater.m4041constructorimpl(composer3);
                                Updater.m4049setimpl(m4041constructorimpl3, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -1627808976, "C:WideNavigationRail.kt#uh7d8r");
                                Function2<Composer, Integer, Unit> header = modalWideNavigationRailOverrideScope4.getHeader();
                                if (header == null) {
                                    composer3.startReplaceGroup(-1627801290);
                                } else {
                                    composer3.startReplaceGroup(-2130719701);
                                    ComposerKt.sourceInformation(composer3, "627@30215L8");
                                    header.invoke(composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), modalWideNavigationRailOverrideScope3.getWindowInsets(), modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse(), modalWideNavigationRailOverrideScope3.getArrangement(), function26, composer2, (Animatable.$stable << 6) | 805309440, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                };
                modalWideNavigationRailOverrideScope2 = modalWideNavigationRailOverrideScope;
                WideNavigationRail_androidKt.ModalWideNavigationRailDialog(function0, expandedProperties, function12, rememberedValue15, railPredictiveBackState, ComposableLambdaKt.rememberComposableLambda(1345045690, z, function24, startRestartGroup, 54), startRestartGroup, 221184);
                startRestartGroup.endReplaceGroup();
            } else {
                modalWideNavigationRailOverrideScope2 = modalWideNavigationRailOverrideScope;
                startRestartGroup.startReplaceGroup(101334713);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$23(DefaultModalWideNavigationRailOverride.this, modalWideNavigationRailOverrideScope2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean ModalWideNavigationRail$lambda$3$lambda$2(State state) {
        return ((Number) state.getValue()).floatValue() == 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean ModalWideNavigationRail$lambda$6$lambda$5(State state) {
        return ((Number) state.getValue()).floatValue() >= 0.3f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRail$lambda$16$lambda$15(Channel channel, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope) {
        channel.mo8396trySendJP2dKIU(Boolean.valueOf(WideNavigationRailStateKt.isExpanded(modalWideNavigationRailOverrideScope.getState().getTargetValue())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRail$lambda$18$lambda$17(CoroutineScope coroutineScope, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$4$1$1(modalWideNavigationRailOverrideScope, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRail$lambda$20$lambda$19(CoroutineScope coroutineScope, Animatable animatable, float f) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$5$1$1(animatable, f, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRail$lambda$22$lambda$21(CoroutineScope coroutineScope, Animatable animatable) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$6$1$1(animatable, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final boolean ModalWideNavigationRail$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalWideNavigationRail$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
