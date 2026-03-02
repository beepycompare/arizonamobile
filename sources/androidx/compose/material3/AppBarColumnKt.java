package androidx.compose.material3;

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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AppBarColumn.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"AppBarColumn", "", "overflowIndicator", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "maxItemCount", "", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/material3/AppBarColumnScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "material3", "scope", "Landroidx/compose/material3/AppBarColumnScopeImpl;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarColumnKt {
    public static final Unit AppBarColumn$lambda$5(Function3 function3, Modifier modifier, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        AppBarColumn(function3, modifier, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ AppBarColumnScopeImpl access$AppBarColumn$lambda$2(State state) {
        return AppBarColumn$lambda$2(state);
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AppBarColumn(final Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, int i, final Function1<? super AppBarColumnScope, Unit> function1, Composer composer, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        int i6;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1484836710);
        ComposerKt.sourceInformation(startRestartGroup, "C(AppBarColumn)N(overflowIndicator,modifier,maxItemCount,content)55@2698L29,56@2745L111,59@2877L30,60@2932L29,62@2994L131,69@3194L50,70@3262L680,66@3131L901:AppBarColumn.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i7 = i3 & 2;
        if (i7 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? 256 : 128;
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i4 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
                }
                if (!startRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
                    startRestartGroup.skipToGroupEnd();
                    companion = obj;
                } else {
                    companion = i7 != 0 ? Modifier.Companion : obj;
                    if (i5 != 0) {
                        i6 = Integer.MAX_VALUE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1484836710, i4, -1, "androidx.compose.material3.AppBarColumn (AppBarColumn.kt:54)");
                    }
                    final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, startRestartGroup, (i4 >> 9) & 14);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 998947733, "CC(remember):AppBarColumn.kt#9igjgp");
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AppBarColumnKt.AppBarColumn$lambda$1$lambda$0(State.this);
                            }
                        });
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    final State state = (State) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 998951876, "CC(remember):AppBarColumn.kt#9igjgp");
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new AppBarMenuState();
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    AppBarMenuState appBarMenuState = (AppBarMenuState) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    AppBarOverflowState rememberAppBarOverflowState = AppBarDslKt.rememberAppBarOverflowState(startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 998955721, "CC(remember):AppBarColumn.kt#9igjgp");
                    boolean changed = ((i4 & 896) == 256) | startRestartGroup.changed(rememberAppBarOverflowState);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new OverflowMeasurePolicy(rememberAppBarOverflowState, i6, true);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    OverflowMeasurePolicy overflowMeasurePolicy = (OverflowMeasurePolicy) rememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    List listOf = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(979489399, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarColumnKt$AppBarColumn$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i8) {
                            AppBarColumnScopeImpl AppBarColumn$lambda$2;
                            ComposerKt.sourceInformation(composer2, "C*69@3225L15:AppBarColumn.kt#uh7d8r");
                            if (composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(979489399, i8, -1, "androidx.compose.material3.AppBarColumn.<anonymous> (AppBarColumn.kt:69)");
                                }
                                AppBarColumn$lambda$2 = AppBarColumnKt.AppBarColumn$lambda$2(state);
                                List<AppBarItem> items = AppBarColumn$lambda$2.getItems();
                                int size = items.size();
                                for (int i9 = 0; i9 < size; i9++) {
                                    items.get(i9).AppbarContent(composer2, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1681423992, true, new AppBarColumnKt$AppBarColumn$2(function3, appBarMenuState, rememberAppBarOverflowState, state), startRestartGroup, 54)});
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    boolean changed2 = startRestartGroup.changed(overflowMeasurePolicy);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
                    Updater.m4049setimpl(m4041constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    combineAsVirtualLayouts.invoke(startRestartGroup, 0);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                final int i8 = i6;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier2 = companion;
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return AppBarColumnKt.AppBarColumn$lambda$5(Function3.this, modifier2, i8, function1, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i;
            if ((i3 & 8) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            }
            final int i82 = i6;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        i6 = i;
        if ((i3 & 8) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
        }
        final int i822 = i6;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final AppBarColumnScopeImpl AppBarColumn$lambda$1$lambda$0(State state) {
        AppBarColumnScopeImpl appBarColumnScopeImpl = new AppBarColumnScopeImpl(new AppBarScopeImpl());
        ((Function1) state.getValue()).invoke(appBarColumnScopeImpl);
        return appBarColumnScopeImpl;
    }

    public static final AppBarColumnScopeImpl AppBarColumn$lambda$2(State<AppBarColumnScopeImpl> state) {
        return state.getValue();
    }
}
