package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: SharedTransitionScope.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0014H\u0003\u001a5\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001f0#¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0002\u0010'\u001a1\u0010(\u001a\u00020\u001f2\"\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0\u0005¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0002\u0010)\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\".\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00120\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0003\"\u0018\u0010\u0017\u001a\u00020\u0010*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0018\u0010\u0017\u001a\u00020\u0010*\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001a¨\u0006*"}, d2 = {"DefaultBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getDefaultBoundsTransform$annotations", "()V", "DefaultClipInOverlayDuringTransition", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "DefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "ParentClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "getParentClip$annotations", "VisualDebugging", "", "cachedScaleToBoundsImplMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/ContentScale;", "Landroidx/compose/ui/Alignment;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "getCachedScaleToBoundsImplMap$annotations", "shouldCache", "getShouldCache", "(Landroidx/compose/ui/Alignment;)Z", "(Landroidx/compose/ui/layout/ContentScale;)Z", "ScaleToBoundsCached", "contentScale", "alignment", "SharedTransitionLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SharedTransitionScope", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "animation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedTransitionScopeKt {
    public static final boolean VisualDebugging = false;
    private static final SpringSpec<Rect> DefaultSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 1, null);
    private static final SharedTransitionScope.OverlayClip ParentClip = new SharedTransitionScope.OverlayClip() { // from class: androidx.compose.animation.SharedTransitionScopeKt$ParentClip$1
        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path getClipPath(SharedTransitionScope.SharedContentState sharedContentState, Rect rect, LayoutDirection layoutDirection, Density density) {
            SharedTransitionScope.SharedContentState parentSharedContentState = sharedContentState.getParentSharedContentState();
            if (parentSharedContentState != null) {
                return parentSharedContentState.getClipPathInOverlay();
            }
            return null;
        }
    };
    private static final Function2<LayoutDirection, Density, Path> DefaultClipInOverlayDuringTransition = new Function2() { // from class: androidx.compose.animation.SharedTransitionScopeKt$DefaultClipInOverlayDuringTransition$1
        @Override // kotlin.jvm.functions.Function2
        public final Void invoke(LayoutDirection layoutDirection, Density density) {
            return null;
        }
    };
    private static final BoundsTransform DefaultBoundsTransform = new BoundsTransform() { // from class: androidx.compose.animation.SharedTransitionScopeKt$$ExternalSyntheticLambda0
        @Override // androidx.compose.animation.BoundsTransform
        public final FiniteAnimationSpec transform(Rect rect, Rect rect2) {
            FiniteAnimationSpec DefaultBoundsTransform$lambda$0;
            DefaultBoundsTransform$lambda$0 = SharedTransitionScopeKt.DefaultBoundsTransform$lambda$0(rect, rect2);
            return DefaultBoundsTransform$lambda$0;
        }
    };
    private static final MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> cachedScaleToBoundsImplMap = new MutableScatterMap<>(0, 1, null);

    private static /* synthetic */ void getCachedScaleToBoundsImplMap$annotations() {
    }

    private static /* synthetic */ void getDefaultBoundsTransform$annotations() {
    }

    private static /* synthetic */ void getParentClip$annotations() {
    }

    public static final void SharedTransitionLayout(final Modifier modifier, final Function3<? super SharedTransitionScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2043053727);
        ComposerKt.sourceInformation(startRestartGroup, "C(SharedTransitionLayout)P(1)99@4829L279,99@4807L301:SharedTransitionScope.kt#xbi5r1");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2043053727, i3, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:98)");
            }
            SharedTransitionScope(ComposableLambdaKt.rememberComposableLambda(-130587847, true, new Function4<SharedTransitionScope, Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionLayout$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(SharedTransitionScope sharedTransitionScope, Modifier modifier2, Composer composer2, Integer num) {
                    invoke(sharedTransitionScope, modifier2, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SharedTransitionScope sharedTransitionScope, Modifier modifier2, Composer composer2, int i5) {
                    int i6;
                    ComposerKt.sourceInformation(composer2, "C102@5044L58:SharedTransitionScope.kt#xbi5r1");
                    if ((i5 & 6) == 0) {
                        i6 = (composer2.changed(sharedTransitionScope) ? 4 : 2) | i5;
                    } else {
                        i6 = i5;
                    }
                    if ((i5 & 48) == 0) {
                        i6 |= composer2.changed(modifier2) ? 32 : 16;
                    }
                    if (!composer2.shouldExecute((i6 & 147) != 146, i6 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-130587847, i6, -1, "androidx.compose.animation.SharedTransitionLayout.<anonymous> (SharedTransitionScope.kt:102)");
                    }
                    Modifier then = Modifier.this.then(modifier2);
                    Function3<SharedTransitionScope, Composer, Integer, Unit> function32 = function3;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, then);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
                    Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1575068883, "C102@5091L9:SharedTransitionScope.kt#xbi5r1");
                    function32.invoke(sharedTransitionScope, composer2, Integer.valueOf(i6 & 14));
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
            }, startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionLayout$2
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

                public final void invoke(Composer composer2, int i5) {
                    SharedTransitionScopeKt.SharedTransitionLayout(Modifier.this, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void SharedTransitionScope(final Function4<? super SharedTransitionScope, ? super Modifier, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-2093217917);
        ComposerKt.sourceInformation(startRestartGroup, "C(SharedTransitionScope)122@6005L1014,122@5990L1029:SharedTransitionScope.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2093217917, i2, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:121)");
            }
            LookaheadScopeKt.LookaheadScope(ComposableLambdaKt.rememberComposableLambda(-863967934, true, new Function3<LookaheadScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LookaheadScope lookaheadScope, Composer composer2, Integer num) {
                    invoke(lookaheadScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LookaheadScope lookaheadScope, Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C123@6036L24,124@6087L60,126@6205L586,140@6825L105,125@6168L772,145@6972L41,145@6949L64:SharedTransitionScope.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-863967934, i3, -1, "androidx.compose.animation.SharedTransitionScope.<anonymous> (SharedTransitionScope.kt:123)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer2, -954203484, "CC(remember):Effects.kt#9igjgp");
                    Object rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -538792118, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new SharedTransitionScopeImpl(lookaheadScope, coroutineScope);
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    final SharedTransitionScopeImpl sharedTransitionScopeImpl = (SharedTransitionScopeImpl) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Function4<SharedTransitionScope, Modifier, Composer, Integer, Unit> function42 = function4;
                    Modifier.Companion companion = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(composer2, -538787816, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m121invoke3p2s80s(measureScope, measurable, constraints.m6643unboximpl());
                            }

                            /* renamed from: invoke-3p2s80s  reason: not valid java name */
                            public final MeasureResult m121invoke3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
                                final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(j);
                                int width = mo5438measureBRTryo0.getWidth();
                                int height = mo5438measureBRTryo0.getHeight();
                                final SharedTransitionScopeImpl sharedTransitionScopeImpl2 = SharedTransitionScopeImpl.this;
                                return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        LayoutCoordinates coordinates = placementScope.getCoordinates();
                                        if (coordinates != null) {
                                            if (!MeasureScope.this.isLookingAhead()) {
                                                sharedTransitionScopeImpl2.setRoot$animation_release(coordinates);
                                            } else {
                                                sharedTransitionScopeImpl2.setNullableLookaheadRoot$animation_release(coordinates);
                                            }
                                        }
                                        Placeable.PlacementScope.place$default(placementScope, mo5438measureBRTryo0, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier layout = LayoutModifierKt.layout(companion, (Function3) rememberedValue3);
                    ComposerKt.sourceInformationMarkerStart(composer2, -538768457, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                invoke2(contentDrawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(ContentDrawScope contentDrawScope) {
                                contentDrawScope.drawContent();
                                SharedTransitionScopeImpl.this.drawInOverlay$animation_release(contentDrawScope);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    function42.invoke(sharedTransitionScopeImpl, DrawModifierKt.drawWithContent(layout, (Function1) rememberedValue4), composer2, 6);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -538763817, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                final SharedTransitionScopeImpl sharedTransitionScopeImpl2 = SharedTransitionScopeImpl.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$3$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        SharedTransitionScopeImpl.this.onDispose$animation_release();
                                    }
                                };
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.DisposableEffect(unit, (Function1) rememberedValue5, composer2, 54);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$2
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

                public final void invoke(Composer composer2, int i3) {
                    SharedTransitionScopeKt.SharedTransitionScope(function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect rect, Rect rect2) {
        return DefaultSpring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScaleToBoundsImpl ScaleToBoundsCached(ContentScale contentScale, Alignment alignment) {
        if (getShouldCache(contentScale) && getShouldCache(alignment)) {
            MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> mutableScatterMap = cachedScaleToBoundsImplMap;
            MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap2 = mutableScatterMap.get(contentScale);
            if (mutableScatterMap2 == null) {
                mutableScatterMap2 = new MutableScatterMap<>(0, 1, null);
                mutableScatterMap.set(contentScale, mutableScatterMap2);
            }
            MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap3 = mutableScatterMap2;
            ScaleToBoundsImpl scaleToBoundsImpl = mutableScatterMap3.get(alignment);
            if (scaleToBoundsImpl == null) {
                scaleToBoundsImpl = new ScaleToBoundsImpl(contentScale, alignment);
                mutableScatterMap3.set(alignment, scaleToBoundsImpl);
            }
            return scaleToBoundsImpl;
        }
        return new ScaleToBoundsImpl(contentScale, alignment);
    }

    private static final boolean getShouldCache(Alignment alignment) {
        return alignment == Alignment.Companion.getTopStart() || alignment == Alignment.Companion.getTopCenter() || alignment == Alignment.Companion.getTopEnd() || alignment == Alignment.Companion.getCenterStart() || alignment == Alignment.Companion.getCenter() || alignment == Alignment.Companion.getCenterEnd() || alignment == Alignment.Companion.getBottomStart() || alignment == Alignment.Companion.getBottomCenter() || alignment == Alignment.Companion.getBottomEnd();
    }

    private static final boolean getShouldCache(ContentScale contentScale) {
        return contentScale == ContentScale.Companion.getFillWidth() || contentScale == ContentScale.Companion.getFillHeight() || contentScale == ContentScale.Companion.getFillBounds() || contentScale == ContentScale.Companion.getFit() || contentScale == ContentScale.Companion.getCrop() || contentScale == ContentScale.Companion.getNone() || contentScale == ContentScale.Companion.getInside();
    }
}
