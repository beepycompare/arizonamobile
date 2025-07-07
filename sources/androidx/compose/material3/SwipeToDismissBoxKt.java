package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SwipeToDismissBox.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\b2#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00190\bH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001e"}, d2 = {"DismissVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismissBox", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/material3/SwipeToDismissBoxState;", "backgroundContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "gesturesEnabled", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSwipeToDismissBoxState", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeToDismissBoxKt {
    private static final float DismissVelocityThreshold = Dp.m6684constructorimpl(125);

    public static final /* synthetic */ float access$getDismissVelocityThreshold$p() {
        return DismissVelocityThreshold;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r13v0, types: [androidx.compose.runtime.Composer] */
    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(final SwipeToDismissBoxValue swipeToDismissBoxValue, final Function1<? super SwipeToDismissBoxValue, Boolean> function1, final Function1<? super Float, Float> function12, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -246335487, "C(rememberSwipeToDismissBoxState)P(1)185@7607L19,187@7687L7,195@7929L102,188@7706L325:SwipeToDismissBox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            swipeToDismissBoxValue = SwipeToDismissBoxValue.Settled;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<SwipeToDismissBoxValue, Boolean>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SwipeToDismissBoxValue swipeToDismissBoxValue2) {
                    return true;
                }
            };
        }
        if ((i2 & 4) != 0) {
            function12 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-246335487, i, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:186)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        Object[] objArr = new Object[0];
        Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver = SwipeToDismissBoxState.Companion.Saver(function1, function12, density);
        ComposerKt.sourceInformationMarkerStart(composer, -1333458863, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        boolean changed = (((6 ^ (i & 14)) > 4 && composer.changed(swipeToDismissBoxValue)) || (i & 6) == 4) | composer.changed(density) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(function12)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (Function0) new Function0<SwipeToDismissBoxState>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SwipeToDismissBoxState invoke() {
                    return new SwipeToDismissBoxState(SwipeToDismissBoxValue.this, density, function1, function12);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SwipeToDismissBoxState swipeToDismissBoxState = (SwipeToDismissBoxState) RememberSaveableKt.m3635rememberSaveable(objArr, Saver, (String) null, (Function0<? extends Object>) rememberedValue, (Composer) composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeToDismissBoxState;
    }

    /* JADX WARN: Removed duplicated region for block: B:204:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:335:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SwipeToDismissBox(final SwipeToDismissBoxState swipeToDismissBoxState, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z, boolean z2, boolean z3, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        final boolean z4;
        int i5;
        final boolean z5;
        int i6;
        boolean z6;
        final boolean z7;
        int currentCompositeKeyHash;
        Composer m3520constructorimpl;
        int currentCompositeKeyHash2;
        Composer m3520constructorimpl2;
        boolean changed;
        Object rememberedValue;
        int currentCompositeKeyHash3;
        Composer m3520constructorimpl3;
        final boolean z8;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-402577235);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwipeToDismissBox)P(6!1,5,3,2,4)225@9211L7,227@9247L1205:SwipeToDismissBox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(swipeToDismissBoxState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z4 = z;
                i3 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z5 = z2;
                    i3 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        z6 = z3;
                    } else {
                        z6 = z3;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= startRestartGroup.changed(z6) ? 131072 : 65536;
                        }
                    }
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                    }
                    if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        Modifier.Companion companion = i7 == 0 ? Modifier.Companion : obj;
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i5 != 0) {
                            z5 = true;
                        }
                        if (i6 != 0) {
                            z6 = true;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-402577235, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:224)");
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        z7 = consume != LayoutDirection.Rtl;
                        Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(companion, swipeToDismissBoxState.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, !z6 && swipeToDismissBoxState.getCurrentValue() == SwipeToDismissBoxValue.Settled, false, null, 24, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, anchoredDraggable$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        boolean z9 = z6;
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -586717200, "C235@9549L71,239@9784L652,236@9629L817:SwipeToDismissBox.kt#uh7d8r");
                        Modifier matchParentSize = BoxScopeInstance.INSTANCE.matchParentSize(Modifier.Companion);
                        int i8 = (i3 << 6) & 7168;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, matchParentSize);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor2);
                        } else {
                            startRestartGroup.useNode();
                        }
                        m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
                        Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        function3.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i8 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier.Companion companion2 = Modifier.Companion;
                        AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release = swipeToDismissBoxState.getAnchoredDraggableState$material3_release();
                        Orientation orientation = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396722910, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        changed = startRestartGroup.changed(z7) | ((i3 & 7168) != 2048) | ((57344 & i3) != 16384) | ((i3 & 14) != 4);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue>>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue> invoke(IntSize intSize, Constraints constraints) {
                                    return m2356invokeGpV2Q24(intSize.m6859unboximpl(), constraints.m6643unboximpl());
                                }

                                /* renamed from: invoke-GpV2Q24  reason: not valid java name */
                                public final Pair<DraggableAnchors<SwipeToDismissBoxValue>, SwipeToDismissBoxValue> m2356invokeGpV2Q24(long j, long j2) {
                                    final float m6855getWidthimpl = IntSize.m6855getWidthimpl(j);
                                    final boolean z10 = z4;
                                    final boolean z11 = z7;
                                    final boolean z12 = z5;
                                    return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                                            draggableAnchorsConfig.at(SwipeToDismissBoxValue.Settled, 0.0f);
                                            if (z10) {
                                                draggableAnchorsConfig.at(SwipeToDismissBoxValue.StartToEnd, z11 ? -m6855getWidthimpl : m6855getWidthimpl);
                                            }
                                            if (z12) {
                                                draggableAnchorsConfig.at(SwipeToDismissBoxValue.EndToStart, z11 ? m6855getWidthimpl : -m6855getWidthimpl);
                                            }
                                        }
                                    }), SwipeToDismissBoxState.this.getTargetValue());
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier draggableAnchors = AnchoredDraggableKt.draggableAnchors(companion2, anchoredDraggableState$material3_release, orientation, (Function2) rememberedValue);
                        int i9 = (i3 >> 9) & 7168;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, draggableAnchors);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor3);
                        } else {
                            startRestartGroup.useNode();
                        }
                        m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
                        Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        function32.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i9 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z9;
                        obj = companion;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        z8 = z6;
                    }
                    final boolean z10 = z4;
                    final boolean z11 = z5;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier2 = obj;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$2
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

                            public final void invoke(Composer composer2, int i10) {
                                SwipeToDismissBoxKt.SwipeToDismissBox(SwipeToDismissBoxState.this, function3, modifier2, z10, z11, z8, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                z5 = z2;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if ((i3 & 599187) == 599186) {
                }
                if (i7 == 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (consume2 != LayoutDirection.Rtl) {
                }
                Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(companion, swipeToDismissBoxState.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, !z6 && swipeToDismissBoxState.getCurrentValue() == SwipeToDismissBoxValue.Settled, false, null, 24, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, anchoredDraggable$default2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                boolean z92 = z6;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m3520constructorimpl.getInserting()) {
                }
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -586717200, "C235@9549L71,239@9784L652,236@9629L817:SwipeToDismissBox.kt#uh7d8r");
                Modifier matchParentSize2 = BoxScopeInstance.INSTANCE.matchParentSize(Modifier.Companion);
                int i82 = (i3 << 6) & 7168;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, matchParentSize2);
                Function0<ComposeUiNode> constructor22 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m3520constructorimpl2.getInserting()) {
                }
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier22, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                function3.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i82 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier.Companion companion22 = Modifier.Companion;
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release2 = swipeToDismissBoxState.getAnchoredDraggableState$material3_release();
                Orientation orientation2 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396722910, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                changed = startRestartGroup.changed(z7) | ((i3 & 7168) != 2048) | ((57344 & i3) != 16384) | ((i3 & 14) != 4);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue>>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue> invoke(IntSize intSize, Constraints constraints) {
                        return m2356invokeGpV2Q24(intSize.m6859unboximpl(), constraints.m6643unboximpl());
                    }

                    /* renamed from: invoke-GpV2Q24  reason: not valid java name */
                    public final Pair<DraggableAnchors<SwipeToDismissBoxValue>, SwipeToDismissBoxValue> m2356invokeGpV2Q24(long j, long j2) {
                        final float m6855getWidthimpl = IntSize.m6855getWidthimpl(j);
                        final boolean z102 = z4;
                        final boolean z112 = z7;
                        final boolean z12 = z5;
                        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                                invoke2(draggableAnchorsConfig);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                                draggableAnchorsConfig.at(SwipeToDismissBoxValue.Settled, 0.0f);
                                if (z102) {
                                    draggableAnchorsConfig.at(SwipeToDismissBoxValue.StartToEnd, z112 ? -m6855getWidthimpl : m6855getWidthimpl);
                                }
                                if (z12) {
                                    draggableAnchorsConfig.at(SwipeToDismissBoxValue.EndToStart, z112 ? m6855getWidthimpl : -m6855getWidthimpl);
                                }
                            }
                        }), SwipeToDismissBoxState.this.getTargetValue());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier draggableAnchors2 = AnchoredDraggableKt.draggableAnchors(companion22, anchoredDraggableState$material3_release2, orientation2, (Function2) rememberedValue);
                int i92 = (i3 >> 9) & 7168;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, draggableAnchors2);
                Function0<ComposeUiNode> constructor32 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m3520constructorimpl3.getInserting()) {
                }
                m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier32, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                function32.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i92 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                z8 = z92;
                obj = companion;
                final boolean z102 = z4;
                final boolean z112 = z5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z4 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z5 = z2;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            if (i7 == 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (consume22 != LayoutDirection.Rtl) {
            }
            Modifier anchoredDraggable$default22 = AnchoredDraggableKt.anchoredDraggable$default(companion, swipeToDismissBoxState.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, !z6 && swipeToDismissBoxState.getCurrentValue() == SwipeToDismissBoxValue.Settled, false, null, 24, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(startRestartGroup, anchoredDraggable$default22);
            Function0<ComposeUiNode> constructor42 = ComposeUiNode.Companion.getConstructor();
            boolean z922 = z6;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m3520constructorimpl.getInserting()) {
            }
            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash42);
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier42, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -586717200, "C235@9549L71,239@9784L652,236@9629L817:SwipeToDismissBox.kt#uh7d8r");
            Modifier matchParentSize22 = BoxScopeInstance.INSTANCE.matchParentSize(Modifier.Companion);
            int i822 = (i3 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy32 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, matchParentSize22);
            Function0<ComposeUiNode> constructor222 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy32, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m3520constructorimpl2.getInserting()) {
            }
            m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier222, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i822 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier.Companion companion222 = Modifier.Companion;
            AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release22 = swipeToDismissBoxState.getAnchoredDraggableState$material3_release();
            Orientation orientation22 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396722910, "CC(remember):SwipeToDismissBox.kt#9igjgp");
            changed = startRestartGroup.changed(z7) | ((i3 & 7168) != 2048) | ((57344 & i3) != 16384) | ((i3 & 14) != 4);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue>>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue> invoke(IntSize intSize, Constraints constraints) {
                    return m2356invokeGpV2Q24(intSize.m6859unboximpl(), constraints.m6643unboximpl());
                }

                /* renamed from: invoke-GpV2Q24  reason: not valid java name */
                public final Pair<DraggableAnchors<SwipeToDismissBoxValue>, SwipeToDismissBoxValue> m2356invokeGpV2Q24(long j, long j2) {
                    final float m6855getWidthimpl = IntSize.m6855getWidthimpl(j);
                    final boolean z1022 = z4;
                    final boolean z1122 = z7;
                    final boolean z12 = z5;
                    return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                            invoke2(draggableAnchorsConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                            draggableAnchorsConfig.at(SwipeToDismissBoxValue.Settled, 0.0f);
                            if (z1022) {
                                draggableAnchorsConfig.at(SwipeToDismissBoxValue.StartToEnd, z1122 ? -m6855getWidthimpl : m6855getWidthimpl);
                            }
                            if (z12) {
                                draggableAnchorsConfig.at(SwipeToDismissBoxValue.EndToStart, z1122 ? m6855getWidthimpl : -m6855getWidthimpl);
                            }
                        }
                    }), SwipeToDismissBoxState.this.getTargetValue());
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier draggableAnchors22 = AnchoredDraggableKt.draggableAnchors(companion222, anchoredDraggableState$material3_release22, orientation22, (Function2) rememberedValue);
            int i922 = (i3 >> 9) & 7168;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, draggableAnchors22);
            Function0<ComposeUiNode> constructor322 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap322, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m3520constructorimpl3.getInserting()) {
            }
            m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash322);
            Updater.m3527setimpl(m3520constructorimpl3, materializeModifier322, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            function32.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i922 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
            }
            z8 = z922;
            obj = companion;
            final boolean z1022 = z4;
            final boolean z1122 = z5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z4 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z5 = z2;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        if (i7 == 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (consume222 != LayoutDirection.Rtl) {
        }
        Modifier anchoredDraggable$default222 = AnchoredDraggableKt.anchoredDraggable$default(companion, swipeToDismissBoxState.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, !z6 && swipeToDismissBoxState.getCurrentValue() == SwipeToDismissBoxValue.Settled, false, null, 24, null);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier422 = ComposedModifierKt.materializeModifier(startRestartGroup, anchoredDraggable$default222);
        Function0<ComposeUiNode> constructor422 = ComposeUiNode.Companion.getConstructor();
        boolean z9222 = z6;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
        Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy222, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap422, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash422 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m3520constructorimpl.getInserting()) {
        }
        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash422);
        Updater.m3527setimpl(m3520constructorimpl, materializeModifier422, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -586717200, "C235@9549L71,239@9784L652,236@9629L817:SwipeToDismissBox.kt#uh7d8r");
        Modifier matchParentSize222 = BoxScopeInstance.INSTANCE.matchParentSize(Modifier.Companion);
        int i8222 = (i3 << 6) & 7168;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy322 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, matchParentSize222);
        Function0<ComposeUiNode> constructor2222 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
        Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy322, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m3520constructorimpl2.getInserting()) {
        }
        m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
        Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2222, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
        function3.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i8222 >> 6) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier.Companion companion2222 = Modifier.Companion;
        AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release222 = swipeToDismissBoxState.getAnchoredDraggableState$material3_release();
        Orientation orientation222 = Orientation.Horizontal;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396722910, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        changed = startRestartGroup.changed(z7) | ((i3 & 7168) != 2048) | ((57344 & i3) != 16384) | ((i3 & 14) != 4);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue>>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue> invoke(IntSize intSize, Constraints constraints) {
                return m2356invokeGpV2Q24(intSize.m6859unboximpl(), constraints.m6643unboximpl());
            }

            /* renamed from: invoke-GpV2Q24  reason: not valid java name */
            public final Pair<DraggableAnchors<SwipeToDismissBoxValue>, SwipeToDismissBoxValue> m2356invokeGpV2Q24(long j, long j2) {
                final float m6855getWidthimpl = IntSize.m6855getWidthimpl(j);
                final boolean z10222 = z4;
                final boolean z11222 = z7;
                final boolean z12 = z5;
                return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.at(SwipeToDismissBoxValue.Settled, 0.0f);
                        if (z10222) {
                            draggableAnchorsConfig.at(SwipeToDismissBoxValue.StartToEnd, z11222 ? -m6855getWidthimpl : m6855getWidthimpl);
                        }
                        if (z12) {
                            draggableAnchorsConfig.at(SwipeToDismissBoxValue.EndToStart, z11222 ? m6855getWidthimpl : -m6855getWidthimpl);
                        }
                    }
                }), SwipeToDismissBoxState.this.getTargetValue());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier draggableAnchors222 = AnchoredDraggableKt.draggableAnchors(companion2222, anchoredDraggableState$material3_release222, orientation222, (Function2) rememberedValue);
        int i9222 = (i3 >> 9) & 7168;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy2222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, draggableAnchors222);
        Function0<ComposeUiNode> constructor3222 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
        Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy2222, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m3520constructorimpl3.getInserting()) {
        }
        m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3222);
        Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3222, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
        function32.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i9222 >> 6) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
        }
        z8 = z9222;
        obj = companion;
        final boolean z10222 = z4;
        final boolean z11222 = z5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
