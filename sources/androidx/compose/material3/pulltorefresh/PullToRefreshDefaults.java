package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\n\u001a\u00020\u000b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u000b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "PositionalThreshold", "getPositionalThreshold-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "indicatorColor", "getIndicatorColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "Indicator", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "threshold", "Indicator-2poqoh4", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;JJFLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullToRefreshDefaults {
    public static final int $stable = 0;
    public static final PullToRefreshDefaults INSTANCE = new PullToRefreshDefaults();
    private static final Shape shape = RoundedCornerShapeKt.getCircleShape();
    private static final float PositionalThreshold = Dp.m6684constructorimpl(80);
    private static final float Elevation = ElevationTokens.INSTANCE.m2979getLevel2D9Ej5fM();

    private PullToRefreshDefaults() {
    }

    public final Shape getShape() {
        return shape;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1066257972, "C419@15907L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066257972, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:419)");
        }
        long m1722getSurfaceContainerHigh0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1722getSurfaceContainerHigh0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1722getSurfaceContainerHigh0d7_KjU;
    }

    public final long getIndicatorColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1441334156, "C423@16068L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1441334156, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorColor> (PullToRefresh.kt:423)");
        }
        long m1709getOnSurfaceVariant0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1709getOnSurfaceVariant0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1709getOnSurfaceVariant0d7_KjU;
    }

    /* renamed from: getPositionalThreshold-D9Ej5fM  reason: not valid java name */
    public final float m2790getPositionalThresholdD9Ej5fM() {
        return PositionalThreshold;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m2789getElevationD9Ej5fM() {
        return Elevation;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* renamed from: Indicator-2poqoh4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2788Indicator2poqoh4(final PullToRefreshState pullToRefreshState, final boolean z, Modifier modifier, long j, long j2, float f, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Object obj;
        long j3;
        long j4;
        float f2;
        Modifier.Companion companion;
        long j5;
        long j6;
        int i5;
        float f3;
        int currentCompositeKeyHash;
        Composer m3520constructorimpl;
        Composer composer2;
        final Modifier modifier2;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1076870256);
        ComposerKt.sourceInformation(startRestartGroup, "C(Indicator)P(4,2,3,1:c#ui.graphics.Color,0:c#ui.graphics.Color,5:c#ui.unit.Dp)437@16566L14,438@16627L14,441@16704L1007:PullToRefresh.kt#djiw08");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(pullToRefreshState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = modifier;
                i3 |= startRestartGroup.changed(obj) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        j3 = j;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        j4 = j2;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    j4 = j2;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        f2 = f;
                        if (startRestartGroup.changed(f2)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        f2 = f;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    f2 = f;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 1048576 : 524288;
                    if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i4 == 0 ? Modifier.Companion : obj;
                            if ((i2 & 8) == 0) {
                                j5 = INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                j5 = j3;
                            }
                            if ((i2 & 16) == 0) {
                                j6 = INSTANCE.getIndicatorColor(startRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                j6 = j4;
                            }
                            if ((i2 & 32) != 0) {
                                i5 = i3 & (-458753);
                                f3 = PositionalThreshold;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1076870256, i5, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:440)");
                                }
                                final long j9 = j6;
                                Modifier modifier3 = companion;
                                int i9 = i5;
                                Modifier m2804pullToRefreshIndicatorwUdLESc$default = PullToRefreshKt.m2804pullToRefreshIndicatorwUdLESc$default(modifier3, pullToRefreshState, z, f3, null, j5, 0.0f, 40, null);
                                float f5 = f3;
                                long j10 = j5;
                                Alignment center = Alignment.Companion.getCenter();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m2804pullToRefreshIndicatorwUdLESc$default);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
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
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396611011, "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08");
                                CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(167807595, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer3, Integer num) {
                                        invoke(bool.booleanValue(), composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean z2, Composer composer3, int i10) {
                                        float f6;
                                        ComposerKt.sourceInformation(composer3, "C:PullToRefresh.kt#djiw08");
                                        if ((i10 & 6) == 0) {
                                            i10 |= composer3.changed(z2) ? 4 : 2;
                                        }
                                        if ((i10 & 19) != 18 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(167807595, i10, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:455)");
                                            }
                                            if (z2) {
                                                composer3.startReplaceGroup(576835739);
                                                ComposerKt.sourceInformation(composer3, "456@17267L201");
                                                f6 = PullToRefreshKt.StrokeWidth;
                                                ProgressIndicatorKt.m2171CircularProgressIndicatorLxG7B9w(SizeKt.m785size3ABfNKs(Modifier.Companion, PullToRefreshKt.getSpinnerSize()), j9, f6, 0L, 0, composer3, 390, 24);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(577079337);
                                                ComposerKt.sourceInformation(composer3, "463@17581L26,462@17514L155");
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1505402512, "CC(remember):PullToRefresh.kt#9igjgp");
                                                boolean changed = composer3.changed(pullToRefreshState);
                                                final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                                                Object rememberedValue = composer3.rememberedValue();
                                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Float invoke() {
                                                            return Float.valueOf(PullToRefreshState.this.getDistanceFraction());
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                PullToRefreshKt.m2795CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j9, composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, startRestartGroup, 54), startRestartGroup, ((i9 >> 3) & 14) | 24960, 10);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                modifier2 = modifier3;
                                j7 = j9;
                                j8 = j10;
                                f4 = f5;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = obj;
                            j5 = j3;
                            j6 = j4;
                        }
                        f3 = f2;
                        i5 = i3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final long j92 = j6;
                        Modifier modifier32 = companion;
                        int i92 = i5;
                        Modifier m2804pullToRefreshIndicatorwUdLESc$default2 = PullToRefreshKt.m2804pullToRefreshIndicatorwUdLESc$default(modifier32, pullToRefreshState, z, f3, null, j5, 0.0f, 40, null);
                        float f52 = f3;
                        long j102 = j5;
                        Alignment center2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m2804pullToRefreshIndicatorwUdLESc$default2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396611011, "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08");
                        CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(167807595, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer3, Integer num) {
                                invoke(bool.booleanValue(), composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z2, Composer composer3, int i10) {
                                float f6;
                                ComposerKt.sourceInformation(composer3, "C:PullToRefresh.kt#djiw08");
                                if ((i10 & 6) == 0) {
                                    i10 |= composer3.changed(z2) ? 4 : 2;
                                }
                                if ((i10 & 19) != 18 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(167807595, i10, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:455)");
                                    }
                                    if (z2) {
                                        composer3.startReplaceGroup(576835739);
                                        ComposerKt.sourceInformation(composer3, "456@17267L201");
                                        f6 = PullToRefreshKt.StrokeWidth;
                                        ProgressIndicatorKt.m2171CircularProgressIndicatorLxG7B9w(SizeKt.m785size3ABfNKs(Modifier.Companion, PullToRefreshKt.getSpinnerSize()), j92, f6, 0L, 0, composer3, 390, 24);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(577079337);
                                        ComposerKt.sourceInformation(composer3, "463@17581L26,462@17514L155");
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1505402512, "CC(remember):PullToRefresh.kt#9igjgp");
                                        boolean changed = composer3.changed(pullToRefreshState);
                                        final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                                        Object rememberedValue = composer3.rememberedValue();
                                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Float invoke() {
                                                    return Float.valueOf(PullToRefreshState.this.getDistanceFraction());
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        PullToRefreshKt.m2795CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j92, composer3, 0);
                                        composer3.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, startRestartGroup, 54), startRestartGroup, ((i92 >> 3) & 14) | 24960, 10);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        modifier2 = modifier32;
                        j7 = j92;
                        j8 = j102;
                        f4 = f52;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = obj;
                        j8 = j3;
                        j7 = j4;
                        composer2 = startRestartGroup;
                        f4 = f2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i10) {
                                PullToRefreshDefaults.this.m2788Indicator2poqoh4(pullToRefreshState, z, modifier2, j8, j7, f4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                f3 = f2;
                i5 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final long j922 = j6;
                Modifier modifier322 = companion;
                int i922 = i5;
                Modifier m2804pullToRefreshIndicatorwUdLESc$default22 = PullToRefreshKt.m2804pullToRefreshIndicatorwUdLESc$default(modifier322, pullToRefreshState, z, f3, null, j5, 0.0f, 40, null);
                float f522 = f3;
                long j1022 = j5;
                Alignment center22 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(center22, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m2804pullToRefreshIndicatorwUdLESc$default22);
                Function0<ComposeUiNode> constructor22 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m3520constructorimpl.getInserting()) {
                }
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier22, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396611011, "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08");
                CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(167807595, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer3, Integer num) {
                        invoke(bool.booleanValue(), composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2, Composer composer3, int i10) {
                        float f6;
                        ComposerKt.sourceInformation(composer3, "C:PullToRefresh.kt#djiw08");
                        if ((i10 & 6) == 0) {
                            i10 |= composer3.changed(z2) ? 4 : 2;
                        }
                        if ((i10 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(167807595, i10, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:455)");
                            }
                            if (z2) {
                                composer3.startReplaceGroup(576835739);
                                ComposerKt.sourceInformation(composer3, "456@17267L201");
                                f6 = PullToRefreshKt.StrokeWidth;
                                ProgressIndicatorKt.m2171CircularProgressIndicatorLxG7B9w(SizeKt.m785size3ABfNKs(Modifier.Companion, PullToRefreshKt.getSpinnerSize()), j922, f6, 0L, 0, composer3, 390, 24);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(577079337);
                                ComposerKt.sourceInformation(composer3, "463@17581L26,462@17514L155");
                                ComposerKt.sourceInformationMarkerStart(composer3, -1505402512, "CC(remember):PullToRefresh.kt#9igjgp");
                                boolean changed = composer3.changed(pullToRefreshState);
                                final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                                Object rememberedValue = composer3.rememberedValue();
                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            return Float.valueOf(PullToRefreshState.this.getDistanceFraction());
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                PullToRefreshKt.m2795CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j922, composer3, 0);
                                composer3.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), startRestartGroup, ((i922 >> 3) & 14) | 24960, 10);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier2 = modifier322;
                j7 = j922;
                j8 = j1022;
                f4 = f522;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj = modifier;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            f3 = f2;
            i5 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final long j9222 = j6;
            Modifier modifier3222 = companion;
            int i9222 = i5;
            Modifier m2804pullToRefreshIndicatorwUdLESc$default222 = PullToRefreshKt.m2804pullToRefreshIndicatorwUdLESc$default(modifier3222, pullToRefreshState, z, f3, null, j5, 0.0f, 40, null);
            float f5222 = f3;
            long j10222 = j5;
            Alignment center222 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(center222, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m2804pullToRefreshIndicatorwUdLESc$default222);
            Function0<ComposeUiNode> constructor222 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m3520constructorimpl.getInserting()) {
            }
            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier222, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396611011, "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08");
            CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(167807595, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer3, Integer num) {
                    invoke(bool.booleanValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z2, Composer composer3, int i10) {
                    float f6;
                    ComposerKt.sourceInformation(composer3, "C:PullToRefresh.kt#djiw08");
                    if ((i10 & 6) == 0) {
                        i10 |= composer3.changed(z2) ? 4 : 2;
                    }
                    if ((i10 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(167807595, i10, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:455)");
                        }
                        if (z2) {
                            composer3.startReplaceGroup(576835739);
                            ComposerKt.sourceInformation(composer3, "456@17267L201");
                            f6 = PullToRefreshKt.StrokeWidth;
                            ProgressIndicatorKt.m2171CircularProgressIndicatorLxG7B9w(SizeKt.m785size3ABfNKs(Modifier.Companion, PullToRefreshKt.getSpinnerSize()), j9222, f6, 0L, 0, composer3, 390, 24);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(577079337);
                            ComposerKt.sourceInformation(composer3, "463@17581L26,462@17514L155");
                            ComposerKt.sourceInformationMarkerStart(composer3, -1505402512, "CC(remember):PullToRefresh.kt#9igjgp");
                            boolean changed = composer3.changed(pullToRefreshState);
                            final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                            Object rememberedValue = composer3.rememberedValue();
                            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(PullToRefreshState.this.getDistanceFraction());
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            PullToRefreshKt.m2795CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j9222, composer3, 0);
                            composer3.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), startRestartGroup, ((i9222 >> 3) & 14) | 24960, 10);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier2 = modifier3222;
            j7 = j9222;
            j8 = j10222;
            f4 = f5222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj = modifier;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        f3 = f2;
        i5 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final long j92222 = j6;
        Modifier modifier32222 = companion;
        int i92222 = i5;
        Modifier m2804pullToRefreshIndicatorwUdLESc$default2222 = PullToRefreshKt.m2804pullToRefreshIndicatorwUdLESc$default(modifier32222, pullToRefreshState, z, f3, null, j5, 0.0f, 40, null);
        float f52222 = f3;
        long j102222 = j5;
        Alignment center2222 = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(center2222, false);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m2804pullToRefreshIndicatorwUdLESc$default2222);
        Function0<ComposeUiNode> constructor2222 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
        Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy2222, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m3520constructorimpl.getInserting()) {
        }
        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        Updater.m3527setimpl(m3520constructorimpl, materializeModifier2222, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 396611011, "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08");
        CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(167807595, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer3, Integer num) {
                invoke(bool.booleanValue(), composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2, Composer composer3, int i10) {
                float f6;
                ComposerKt.sourceInformation(composer3, "C:PullToRefresh.kt#djiw08");
                if ((i10 & 6) == 0) {
                    i10 |= composer3.changed(z2) ? 4 : 2;
                }
                if ((i10 & 19) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(167807595, i10, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:455)");
                    }
                    if (z2) {
                        composer3.startReplaceGroup(576835739);
                        ComposerKt.sourceInformation(composer3, "456@17267L201");
                        f6 = PullToRefreshKt.StrokeWidth;
                        ProgressIndicatorKt.m2171CircularProgressIndicatorLxG7B9w(SizeKt.m785size3ABfNKs(Modifier.Companion, PullToRefreshKt.getSpinnerSize()), j92222, f6, 0L, 0, composer3, 390, 24);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(577079337);
                        ComposerKt.sourceInformation(composer3, "463@17581L26,462@17514L155");
                        ComposerKt.sourceInformationMarkerStart(composer3, -1505402512, "CC(remember):PullToRefresh.kt#9igjgp");
                        boolean changed = composer3.changed(pullToRefreshState);
                        final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(PullToRefreshState.this.getDistanceFraction());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        PullToRefreshKt.m2795CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j92222, composer3, 0);
                        composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, startRestartGroup, 54), startRestartGroup, ((i92222 >> 3) & 14) | 24960, 10);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier2 = modifier32222;
        j7 = j92222;
        j8 = j102222;
        f4 = f52222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
