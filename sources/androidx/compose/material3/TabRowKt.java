package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u0094\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0080\u0001\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u009a\u0001\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012.\b\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0086\u0001\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a \u0001\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0094\u0001\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001c\u001a\u0080\u0001\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u001f\u001a\u0090\u0001\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102.\b\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001f\u001an\u00104\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a~\u00107\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b8\u00106\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "TabRowIndicatorSpec", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m6684constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final AnimationSpec<Dp> TabRowIndicatorSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    public static final /* synthetic */ AnimationSpec access$getTabRowIndicatorSpec$p() {
        return TabRowIndicatorSpec;
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:241:? A[RETURN, SYNTHETIC] */
    /* renamed from: PrimaryTabRow-pAZo6Ak */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2396PrimaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier.Companion companion;
        long j3;
        long j4;
        int i5;
        ComposableLambda composableLambda;
        int i6;
        Object obj;
        Function2<Composer, Integer, Unit> m1786getLambda1$material3_release;
        Modifier modifier2;
        long j5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        long j6;
        Composer composer2;
        final Modifier modifier3;
        final long j7;
        final long j8;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1884787284);
        ComposerKt.sourceInformation(startRestartGroup, "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)155@7603L21,156@7667L19,157@7746L189,166@8053L76:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = 256;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = 128;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = 2048;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = 1024;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                composableLambda = function3;
                i4 |= startRestartGroup.changedInstance(composableLambda) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    obj = function2;
                    i4 |= startRestartGroup.changedInstance(obj) ? 131072 : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    composableLambda = ComposableLambdaKt.rememberComposableLambda(-2021049253, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, Integer num) {
                                            invoke(tabIndicatorScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, int i11) {
                                            int i12;
                                            ComposerKt.sourceInformation(composer3, "C158@7771L158:TabRow.kt#uh7d8r");
                                            if ((i11 & 6) == 0) {
                                                i12 = ((i11 & 8) == 0 ? composer3.changed(tabIndicatorScope) : composer3.changedInstance(tabIndicatorScope) ? 4 : 2) | i11;
                                            } else {
                                                i12 = i11;
                                            }
                                            if ((i12 & 19) != 18 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2021049253, i12, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:158)");
                                                }
                                                TabRowDefaults.INSTANCE.m2391PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.Companion, i, true), Dp.Companion.m6704getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer3, 196656, 28);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, startRestartGroup, 54);
                                }
                                if (i6 != 0) {
                                    m1786getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1786getLambda1$material3_release();
                                    modifier2 = companion;
                                    j5 = j4;
                                    function32 = composableLambda;
                                    i7 = -1884787284;
                                    j6 = j3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:165)");
                                    }
                                    composer2 = startRestartGroup;
                                    m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1786getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier2;
                                    j7 = j6;
                                    j8 = j5;
                                    function33 = function32;
                                    function23 = m1786getLambda1$material3_release;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                            }
                            modifier2 = companion;
                            function32 = composableLambda;
                            m1786getLambda1$material3_release = obj;
                            i7 = -1884787284;
                            j6 = j3;
                            j5 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1786getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier2;
                            j7 = j6;
                            j8 = j5;
                            function33 = function32;
                            function23 = m1786getLambda1$material3_release;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = companion;
                            j7 = j3;
                            j8 = j4;
                            function33 = composableLambda;
                            function23 = obj;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11) {
                                    TabRowKt.m2396PrimaryTabRowpAZo6Ak(i, modifier3, j7, j8, function33, function23, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier2 = companion;
                    function32 = composableLambda;
                    m1786getLambda1$material3_release = obj;
                    i7 = -1884787284;
                    j6 = j3;
                    j5 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1786getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    j7 = j6;
                    j8 = j5;
                    function33 = function32;
                    function23 = m1786getLambda1$material3_release;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                modifier2 = companion;
                function32 = composableLambda;
                m1786getLambda1$material3_release = obj;
                i7 = -1884787284;
                j6 = j3;
                j5 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1786getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                j7 = j6;
                j8 = j5;
                function33 = function32;
                function23 = m1786getLambda1$material3_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            composableLambda = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            obj = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            modifier2 = companion;
            function32 = composableLambda;
            m1786getLambda1$material3_release = obj;
            i7 = -1884787284;
            j6 = j3;
            j5 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1786getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            j7 = j6;
            j8 = j5;
            function33 = function32;
            function23 = m1786getLambda1$material3_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        composableLambda = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        obj = function2;
        if ((i3 & 64) == 0) {
        }
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        modifier2 = companion;
        function32 = composableLambda;
        m1786getLambda1$material3_release = obj;
        i7 = -1884787284;
        j6 = j3;
        j5 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1786getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        j7 = j6;
        j8 = j5;
        function33 = function32;
        function23 = m1786getLambda1$material3_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:241:? A[RETURN, SYNTHETIC] */
    /* renamed from: SecondaryTabRow-pAZo6Ak */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2401SecondaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier.Companion companion;
        long j3;
        long j4;
        int i5;
        ComposableLambda composableLambda;
        int i6;
        Object obj;
        Function2<Composer, Integer, Unit> m1787getLambda2$material3_release;
        Modifier modifier2;
        long j5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        long j6;
        Composer composer2;
        final Modifier modifier3;
        final long j7;
        final long j8;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1909540706);
        ComposerKt.sourceInformation(startRestartGroup, "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)209@10549L23,210@10615L21,212@10716L160,220@10994L76:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = 256;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = 128;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = 2048;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = 1024;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                composableLambda = function3;
                i4 |= startRestartGroup.changedInstance(composableLambda) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    obj = function2;
                    i4 |= startRestartGroup.changedInstance(obj) ? 131072 : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getSecondaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    composableLambda = ComposableLambdaKt.rememberComposableLambda(286693261, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, Integer num) {
                                            invoke(tabIndicatorScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, int i11) {
                                            ComposerKt.sourceInformation(composer3, "C213@10745L121:TabRow.kt#uh7d8r");
                                            if ((i11 & 6) == 0) {
                                                i11 |= (i11 & 8) == 0 ? composer3.changed(tabIndicatorScope) : composer3.changedInstance(tabIndicatorScope) ? 4 : 2;
                                            }
                                            if ((i11 & 19) != 18 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(286693261, i11, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:213)");
                                                }
                                                TabRowDefaults.INSTANCE.m2392SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.Companion, i, false), 0.0f, 0L, composer3, 3072, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, startRestartGroup, 54);
                                }
                                if (i6 != 0) {
                                    m1787getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1787getLambda2$material3_release();
                                    modifier2 = companion;
                                    j5 = j4;
                                    function32 = composableLambda;
                                    i7 = -1909540706;
                                    j6 = j3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:219)");
                                    }
                                    composer2 = startRestartGroup;
                                    m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1787getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier2;
                                    j7 = j6;
                                    j8 = j5;
                                    function33 = function32;
                                    function23 = m1787getLambda2$material3_release;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                            }
                            modifier2 = companion;
                            function32 = composableLambda;
                            m1787getLambda2$material3_release = obj;
                            i7 = -1909540706;
                            j6 = j3;
                            j5 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1787getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier2;
                            j7 = j6;
                            j8 = j5;
                            function33 = function32;
                            function23 = m1787getLambda2$material3_release;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = companion;
                            j7 = j3;
                            j8 = j4;
                            function33 = composableLambda;
                            function23 = obj;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11) {
                                    TabRowKt.m2401SecondaryTabRowpAZo6Ak(i, modifier3, j7, j8, function33, function23, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier2 = companion;
                    function32 = composableLambda;
                    m1787getLambda2$material3_release = obj;
                    i7 = -1909540706;
                    j6 = j3;
                    j5 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1787getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    j7 = j6;
                    j8 = j5;
                    function33 = function32;
                    function23 = m1787getLambda2$material3_release;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                modifier2 = companion;
                function32 = composableLambda;
                m1787getLambda2$material3_release = obj;
                i7 = -1909540706;
                j6 = j3;
                j5 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1787getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                j7 = j6;
                j8 = j5;
                function33 = function32;
                function23 = m1787getLambda2$material3_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            composableLambda = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            obj = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            modifier2 = companion;
            function32 = composableLambda;
            m1787getLambda2$material3_release = obj;
            i7 = -1909540706;
            j6 = j3;
            j5 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1787getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            j7 = j6;
            j8 = j5;
            function33 = function32;
            function23 = m1787getLambda2$material3_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        composableLambda = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        obj = function2;
        if ((i3 & 64) == 0) {
        }
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        modifier2 = companion;
        function32 = composableLambda;
        m1787getLambda2$material3_release = obj;
        i7 = -1909540706;
        j6 = j3;
        j5 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        m2403TabRowImplDTcfvLk(modifier2, j6, j5, function32, m1787getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        j7 = j6;
        j8 = j5;
        function33 = function32;
        function23 = m1787getLambda2$material3_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:241:? A[RETURN, SYNTHETIC] */
    /* renamed from: TabRow-pAZo6Ak */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2402TabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier.Companion companion;
        long j3;
        long j4;
        int i5;
        ComposableLambda composableLambda;
        int i6;
        Object obj;
        Function2<Composer, Integer, Unit> m1788getLambda3$material3_release;
        Modifier modifier2;
        long j5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        long j6;
        Composer composer2;
        final Modifier modifier3;
        final long j7;
        final long j8;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1199178586);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)303@15331L21,304@15395L19,306@15507L246,316@15871L90:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = 256;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = 128;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = 2048;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = 1024;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                composableLambda = function3;
                i4 |= startRestartGroup.changedInstance(composableLambda) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    obj = function2;
                    i4 |= startRestartGroup.changedInstance(obj) ? 131072 : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    composableLambda = ComposableLambdaKt.rememberComposableLambda(-2052073983, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer3, Integer num) {
                                            invoke((List<TabPosition>) list, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(List<TabPosition> list, Composer composer3, int i11) {
                                            ComposerKt.sourceInformation(composer3, "C308@15612L117:TabRow.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2052073983, i11, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:307)");
                                            }
                                            if (i < list.size()) {
                                                TabRowDefaults.INSTANCE.m2392SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.Companion, list.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, startRestartGroup, 54);
                                }
                                if (i6 != 0) {
                                    m1788getLambda3$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1788getLambda3$material3_release();
                                    modifier2 = companion;
                                    j5 = j4;
                                    function32 = composableLambda;
                                    i7 = -1199178586;
                                    j6 = j3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:315)");
                                    }
                                    composer2 = startRestartGroup;
                                    m2404TabRowWithSubcomposeImplDTcfvLk(modifier2, j6, j5, function32, m1788getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier2;
                                    j7 = j6;
                                    j8 = j5;
                                    function33 = function32;
                                    function23 = m1788getLambda3$material3_release;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                            }
                            modifier2 = companion;
                            function32 = composableLambda;
                            m1788getLambda3$material3_release = obj;
                            i7 = -1199178586;
                            j6 = j3;
                            j5 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            m2404TabRowWithSubcomposeImplDTcfvLk(modifier2, j6, j5, function32, m1788getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier2;
                            j7 = j6;
                            j8 = j5;
                            function33 = function32;
                            function23 = m1788getLambda3$material3_release;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = companion;
                            j7 = j3;
                            j8 = j4;
                            function33 = composableLambda;
                            function23 = obj;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11) {
                                    TabRowKt.m2402TabRowpAZo6Ak(i, modifier3, j7, j8, function33, function23, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier2 = companion;
                    function32 = composableLambda;
                    m1788getLambda3$material3_release = obj;
                    i7 = -1199178586;
                    j6 = j3;
                    j5 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    m2404TabRowWithSubcomposeImplDTcfvLk(modifier2, j6, j5, function32, m1788getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    j7 = j6;
                    j8 = j5;
                    function33 = function32;
                    function23 = m1788getLambda3$material3_release;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                modifier2 = companion;
                function32 = composableLambda;
                m1788getLambda3$material3_release = obj;
                i7 = -1199178586;
                j6 = j3;
                j5 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                m2404TabRowWithSubcomposeImplDTcfvLk(modifier2, j6, j5, function32, m1788getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                j7 = j6;
                j8 = j5;
                function33 = function32;
                function23 = m1788getLambda3$material3_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            composableLambda = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            obj = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            modifier2 = companion;
            function32 = composableLambda;
            m1788getLambda3$material3_release = obj;
            i7 = -1199178586;
            j6 = j3;
            j5 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            m2404TabRowWithSubcomposeImplDTcfvLk(modifier2, j6, j5, function32, m1788getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            j7 = j6;
            j8 = j5;
            function33 = function32;
            function23 = m1788getLambda3$material3_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        composableLambda = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        obj = function2;
        if ((i3 & 64) == 0) {
        }
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        modifier2 = companion;
        function32 = composableLambda;
        m1788getLambda3$material3_release = obj;
        i7 = -1199178586;
        j6 = j3;
        j5 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        m2404TabRowWithSubcomposeImplDTcfvLk(modifier2, j6, j5, function32, m1788getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        j7 = j6;
        j8 = j5;
        function33 = function32;
        function23 = m1788getLambda3$material3_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:305:? A[RETURN, SYNTHETIC] */
    /* renamed from: PrimaryScrollableTabRow-qhFBPw4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2395PrimaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier.Companion companion;
        Object obj;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        long j5;
        float f3;
        ScrollState scrollState2;
        long j6;
        Function2<Composer, Integer, Unit> function23;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        Modifier modifier2;
        long j7;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33;
        final float f4;
        final Modifier modifier3;
        final ScrollState scrollState3;
        final long j8;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1763241113);
        ComposerKt.sourceInformation(startRestartGroup, "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)358@18337L21,359@18403L21,360@18467L19,363@18637L198,372@18953L328:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    obj = scrollState;
                    if (startRestartGroup.changed(obj)) {
                        i12 = 256;
                        i4 |= i12;
                    }
                } else {
                    obj = scrollState;
                }
                i12 = 128;
                i4 |= i12;
            } else {
                obj = scrollState;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i11 = 2048;
                        i4 |= i11;
                    }
                } else {
                    j3 = j;
                }
                i11 = 1024;
                i4 |= i11;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i10 = 16384;
                        i4 |= i10;
                    }
                } else {
                    j4 = j2;
                }
                i10 = 8192;
                i4 |= i10;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i2) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i8 = i7;
                    i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if ((i3 & 256) == 0) {
                        i4 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                        if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    obj = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                }
                                if ((i3 & 8) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -57345;
                                }
                                if (i5 != 0) {
                                    f2 = TabRowDefaults.INSTANCE.m2393getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                ComposableLambda rememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(1601820568, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, Integer num) {
                                        invoke(tabIndicatorScope, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, int i14) {
                                        int i15;
                                        ComposerKt.sourceInformation(composer2, "C364@18666L159:TabRow.kt#uh7d8r");
                                        if ((i14 & 6) == 0) {
                                            i15 = ((i14 & 8) == 0 ? composer2.changed(tabIndicatorScope) : composer2.changedInstance(tabIndicatorScope) ? 4 : 2) | i14;
                                        } else {
                                            i15 = i14;
                                        }
                                        if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1601820568, i15, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:364)");
                                            }
                                            TabRowDefaults.INSTANCE.m2391PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.Companion, i, true), Dp.Companion.m6704getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer2, 196656, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }, startRestartGroup, 54) : function3;
                                if (i8 != 0) {
                                    i9 = i4;
                                    j6 = j4;
                                    function32 = rememberComposableLambda;
                                    function23 = ComposableSingletons$TabRowKt.INSTANCE.m1789getLambda4$material3_release();
                                    modifier2 = companion;
                                    j5 = j3;
                                    f3 = f2;
                                    scrollState2 = obj;
                                } else {
                                    i9 = i4;
                                    j5 = j3;
                                    f3 = f2;
                                    scrollState2 = obj;
                                    j6 = j4;
                                    function23 = function2;
                                    function32 = rememberComposableLambda;
                                    modifier2 = companion;
                                }
                                j7 = j6;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                i9 = i4;
                                modifier2 = companion;
                                j5 = j3;
                                f3 = f2;
                                scrollState2 = obj;
                                j7 = j4;
                                function32 = function3;
                                function23 = function2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1763241113, i9, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:371)");
                            }
                            int i14 = i9 >> 3;
                            m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i14 & 896) | (i14 & 7168) | (i14 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function24 = function23;
                            function33 = function32;
                            f4 = f3;
                            long j10 = j5;
                            modifier3 = modifier2;
                            scrollState3 = scrollState2;
                            j8 = j7;
                            j9 = j10;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function2;
                            modifier3 = companion;
                            scrollState3 = obj;
                            j9 = j3;
                            j8 = j4;
                            f4 = f2;
                            function33 = function3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2
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

                                public final void invoke(Composer composer2, int i15) {
                                    TabRowKt.m2395PrimaryScrollableTabRowqhFBPw4(i, modifier3, scrollState3, j9, j8, f4, function33, function24, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    j7 = j6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i142 = i9 >> 3;
                    m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i142 & 896) | (i142 & 7168) | (i142 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function24 = function23;
                    function33 = function32;
                    f4 = f3;
                    long j102 = j5;
                    modifier3 = modifier2;
                    scrollState3 = scrollState2;
                    j8 = j7;
                    j9 = j102;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i7;
                if ((i3 & 256) == 0) {
                }
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                j7 = j6;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1422 = i9 >> 3;
                m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i1422 & 896) | (i1422 & 7168) | (i1422 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                }
                function24 = function23;
                function33 = function32;
                f4 = f3;
                long j1022 = j5;
                modifier3 = modifier2;
                scrollState3 = scrollState2;
                j8 = j7;
                j9 = j1022;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f2 = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i3 & 256) == 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            j7 = j6;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i14222 = i9 >> 3;
            m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i14222 & 896) | (i14222 & 7168) | (i14222 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
            }
            function24 = function23;
            function33 = function32;
            f4 = f3;
            long j10222 = j5;
            modifier3 = modifier2;
            scrollState3 = scrollState2;
            j8 = j7;
            j9 = j10222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i3 & 256) == 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        j7 = j6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i142222 = i9 >> 3;
        m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i142222 & 896) | (i142222 & 7168) | (i142222 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
        if (ComposerKt.isTraceInProgress()) {
        }
        function24 = function23;
        function33 = function32;
        f4 = f3;
        long j102222 = j5;
        modifier3 = modifier2;
        scrollState3 = scrollState2;
        j8 = j7;
        j9 = j102222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:305:? A[RETURN, SYNTHETIC] */
    /* renamed from: SecondaryScrollableTabRow-qhFBPw4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2400SecondaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier.Companion companion;
        Object obj;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        long j5;
        float f3;
        ScrollState scrollState2;
        long j6;
        Function2<Composer, Integer, Unit> function23;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        Modifier modifier2;
        long j7;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33;
        final float f4;
        final Modifier modifier3;
        final ScrollState scrollState3;
        final long j8;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1821940917);
        ComposerKt.sourceInformation(startRestartGroup, "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)428@21932L21,429@21998L23,430@22064L21,433@22236L160,441@22514L327:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    obj = scrollState;
                    if (startRestartGroup.changed(obj)) {
                        i12 = 256;
                        i4 |= i12;
                    }
                } else {
                    obj = scrollState;
                }
                i12 = 128;
                i4 |= i12;
            } else {
                obj = scrollState;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i11 = 2048;
                        i4 |= i11;
                    }
                } else {
                    j3 = j;
                }
                i11 = 1024;
                i4 |= i11;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i10 = 16384;
                        i4 |= i10;
                    }
                } else {
                    j4 = j2;
                }
                i10 = 8192;
                i4 |= i10;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i2) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i8 = i7;
                    i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if ((i3 & 256) == 0) {
                        i4 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                        if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    obj = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                }
                                if ((i3 & 8) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getSecondaryContentColor(startRestartGroup, 6);
                                    i4 &= -57345;
                                }
                                if (i5 != 0) {
                                    f2 = TabRowDefaults.INSTANCE.m2393getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                ComposableLambda rememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(1535842470, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, Integer num) {
                                        invoke(tabIndicatorScope, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, int i14) {
                                        ComposerKt.sourceInformation(composer2, "C434@22265L121:TabRow.kt#uh7d8r");
                                        if ((i14 & 6) == 0) {
                                            i14 |= (i14 & 8) == 0 ? composer2.changed(tabIndicatorScope) : composer2.changedInstance(tabIndicatorScope) ? 4 : 2;
                                        }
                                        if ((i14 & 19) != 18 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1535842470, i14, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:434)");
                                            }
                                            TabRowDefaults.INSTANCE.m2392SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.Companion, i, false), 0.0f, 0L, composer2, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }, startRestartGroup, 54) : function3;
                                if (i8 != 0) {
                                    i9 = i4;
                                    j6 = j4;
                                    function32 = rememberComposableLambda;
                                    function23 = ComposableSingletons$TabRowKt.INSTANCE.m1790getLambda5$material3_release();
                                    modifier2 = companion;
                                    j5 = j3;
                                    f3 = f2;
                                    scrollState2 = obj;
                                } else {
                                    i9 = i4;
                                    j5 = j3;
                                    f3 = f2;
                                    scrollState2 = obj;
                                    j6 = j4;
                                    function23 = function2;
                                    function32 = rememberComposableLambda;
                                    modifier2 = companion;
                                }
                                j7 = j6;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                i9 = i4;
                                modifier2 = companion;
                                j5 = j3;
                                f3 = f2;
                                scrollState2 = obj;
                                j7 = j4;
                                function32 = function3;
                                function23 = function2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1821940917, i9, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:440)");
                            }
                            int i14 = i9 >> 3;
                            m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i14 & 896) | (i14 & 7168) | (i14 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function24 = function23;
                            function33 = function32;
                            f4 = f3;
                            long j10 = j5;
                            modifier3 = modifier2;
                            scrollState3 = scrollState2;
                            j8 = j7;
                            j9 = j10;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function2;
                            modifier3 = companion;
                            scrollState3 = obj;
                            j9 = j3;
                            j8 = j4;
                            f4 = f2;
                            function33 = function3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2
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

                                public final void invoke(Composer composer2, int i15) {
                                    TabRowKt.m2400SecondaryScrollableTabRowqhFBPw4(i, modifier3, scrollState3, j9, j8, f4, function33, function24, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    j7 = j6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i142 = i9 >> 3;
                    m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i142 & 896) | (i142 & 7168) | (i142 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function24 = function23;
                    function33 = function32;
                    f4 = f3;
                    long j102 = j5;
                    modifier3 = modifier2;
                    scrollState3 = scrollState2;
                    j8 = j7;
                    j9 = j102;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i7;
                if ((i3 & 256) == 0) {
                }
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                j7 = j6;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1422 = i9 >> 3;
                m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i1422 & 896) | (i1422 & 7168) | (i1422 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                }
                function24 = function23;
                function33 = function32;
                f4 = f3;
                long j1022 = j5;
                modifier3 = modifier2;
                scrollState3 = scrollState2;
                j8 = j7;
                j9 = j1022;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f2 = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i3 & 256) == 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            j7 = j6;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i14222 = i9 >> 3;
            m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i14222 & 896) | (i14222 & 7168) | (i14222 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
            }
            function24 = function23;
            function33 = function32;
            f4 = f3;
            long j10222 = j5;
            modifier3 = modifier2;
            scrollState3 = scrollState2;
            j8 = j7;
            j9 = j10222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i3 & 256) == 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        j7 = j6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i142222 = i9 >> 3;
        m2398ScrollableTabRowImplsKfQg0A(i, modifier2, j5, j7, f3, scrollState2, function32, function23, function22, startRestartGroup, (i9 & WebSocketProtocol.PAYLOAD_SHORT) | (i142222 & 896) | (i142222 & 7168) | (i142222 & 57344) | ((i9 << 9) & 458752) | (3670016 & i9) | (29360128 & i9) | (i9 & 234881024));
        if (ComposerKt.isTraceInProgress()) {
        }
        function24 = function23;
        function33 = function32;
        f4 = f3;
        long j102222 = j5;
        modifier3 = modifier2;
        scrollState3 = scrollState2;
        j8 = j7;
        j9 = j102222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:265:? A[RETURN, SYNTHETIC] */
    /* renamed from: ScrollableTabRow-sKfQg0A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2397ScrollableTabRowsKfQg0A(final int i, Modifier modifier, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier.Companion companion;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        ComposableLambda composableLambda;
        int i7;
        int i8;
        final Modifier modifier2;
        final long j5;
        final long j6;
        final float f3;
        Function2<Composer, Integer, Unit> m1791getLambda6$material3_release;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-497821003);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)496@25397L21,497@25461L19,500@25644L164,517@26250L21,508@25926L351:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i10 = 256;
                        i4 |= i10;
                    }
                } else {
                    j3 = j;
                }
                i10 = 128;
                i4 |= i10;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i9 = 2048;
                        i4 |= i9;
                    }
                } else {
                    j4 = j2;
                }
                i9 = 1024;
                i4 |= i9;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    composableLambda = function3;
                    i4 |= startRestartGroup.changedInstance(composableLambda) ? 131072 : 65536;
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i3 & 128) == 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        if ((i4 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    f2 = TabRowDefaults.INSTANCE.m2393getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    composableLambda = ComposableLambdaKt.rememberComposableLambda(-913748678, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer2, Integer num) {
                                            invoke((List<TabPosition>) list, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(List<TabPosition> list, Composer composer2, int i12) {
                                            ComposerKt.sourceInformation(composer2, "C501@25689L109:TabRow.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-913748678, i12, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:501)");
                                            }
                                            TabRowDefaults.INSTANCE.m2392SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.Companion, list.get(i)), 0.0f, 0L, composer2, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, startRestartGroup, 54);
                                }
                                if (i7 != 0) {
                                    i8 = i4;
                                    modifier2 = companion;
                                    j5 = j3;
                                    j6 = j4;
                                    f3 = f2;
                                    m1791getLambda6$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1791getLambda6$material3_release();
                                    function32 = composableLambda;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-497821003, i8, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:507)");
                                    }
                                    int i12 = i8 << 3;
                                    m2399ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function32, modifier2, j5, j6, f3, m1791getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i12 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i8) | (i8 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function23 = m1791getLambda6$material3_release;
                                    function33 = function32;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                            }
                            i8 = i4;
                            modifier2 = companion;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            function32 = composableLambda;
                            m1791getLambda6$material3_release = function2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i122 = i8 << 3;
                            m2399ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function32, modifier2, j5, j6, f3, m1791getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i122 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i122 & 7168) | (57344 & i122) | (458752 & i122) | (3670016 & i8) | (i8 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function23 = m1791getLambda6$material3_release;
                            function33 = function32;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function23 = function2;
                            modifier2 = companion;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            function33 = composableLambda;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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
                                    TabRowKt.m2397ScrollableTabRowsKfQg0A(i, modifier2, j5, j6, f3, function33, function23, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 4793491) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    i8 = i4;
                    modifier2 = companion;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    function32 = composableLambda;
                    m1791getLambda6$material3_release = function2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1222 = i8 << 3;
                    m2399ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function32, modifier2, j5, j6, f3, m1791getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i1222 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i1222 & 7168) | (57344 & i1222) | (458752 & i1222) | (3670016 & i8) | (i8 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function23 = m1791getLambda6$material3_release;
                    function33 = function32;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                composableLambda = function3;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i4 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                i8 = i4;
                modifier2 = companion;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                function32 = composableLambda;
                m1791getLambda6$material3_release = function2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i12222 = i8 << 3;
                m2399ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function32, modifier2, j5, j6, f3, m1791getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i12222 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i12222 & 7168) | (57344 & i12222) | (458752 & i12222) | (3670016 & i8) | (i8 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function23 = m1791getLambda6$material3_release;
                function33 = function32;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f2 = f;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            composableLambda = function3;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i4 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            i8 = i4;
            modifier2 = companion;
            j5 = j3;
            j6 = j4;
            f3 = f2;
            function32 = composableLambda;
            m1791getLambda6$material3_release = function2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i122222 = i8 << 3;
            m2399ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function32, modifier2, j5, j6, f3, m1791getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i122222 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i122222 & 7168) | (57344 & i122222) | (458752 & i122222) | (3670016 & i8) | (i8 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function23 = m1791getLambda6$material3_release;
            function33 = function32;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        composableLambda = function3;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i4 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        i8 = i4;
        modifier2 = companion;
        j5 = j3;
        j6 = j4;
        f3 = f2;
        function32 = composableLambda;
        m1791getLambda6$material3_release = function2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1222222 = i8 << 3;
        m2399ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function32, modifier2, j5, j6, f3, m1791getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i1222222 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i1222222 & 7168) | (57344 & i1222222) | (458752 & i1222222) | (3670016 & i8) | (i8 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function23 = m1791getLambda6$material3_release;
        function33 = function32;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: TabRowImpl-DTcfvLk */
    public static final void m2403TabRowImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)576@28021L4041,572@27891L4171:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, i2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:571)");
            }
            int i3 = i2 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2347SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-65106680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C577@28043L1274,618@29505L21,620@29556L2500,612@29327L2729:TabRow.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-65106680, i4, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:577)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 1811399233, "CC(remember):TabRow.kt#9igjgp");
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new TabRowKt$TabRowImpl$1$scope$1$1();
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function32 = function3;
                        List listOf = CollectionsKt.listOf((Object[]) new Function2[]{function22, function2, ComposableLambdaKt.rememberComposableLambda(1236693605, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i5) {
                                ComposerKt.sourceInformation(composer4, "C618@29513L11:TabRow.kt#uh7d8r");
                                if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1236693605, i5, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:618)");
                                }
                                function32.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer4, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54)});
                        ComposerKt.sourceInformationMarkerStart(composer3, 1811448875, "CC(remember):TabRow.kt#9igjgp");
                        MultiContentMeasurePolicy rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo685measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j3) {
                                    MeasureScope measureScope2 = measureScope;
                                    List<? extends Measurable> list2 = list.get(0);
                                    List<? extends Measurable> list3 = list.get(1);
                                    int i5 = 2;
                                    List<? extends Measurable> list4 = list.get(2);
                                    int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j3);
                                    int size = list2.size();
                                    final Ref.IntRef intRef = new Ref.IntRef();
                                    if (size > 0) {
                                        intRef.element = m6637getMaxWidthimpl / size;
                                    }
                                    int i6 = 0;
                                    int size2 = list2.size();
                                    for (int i7 = 0; i7 < size2; i7++) {
                                        i6 = Integer.valueOf(Math.max(list2.get(i7).maxIntrinsicHeight(intRef.element), i6.intValue()));
                                    }
                                    final int intValue = i6.intValue();
                                    TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$12 = TabRowKt$TabRowImpl$1$scope$1$1.this;
                                    ArrayList arrayList = new ArrayList(size);
                                    int i8 = 0;
                                    while (i8 < size) {
                                        arrayList.add(new TabPosition(Dp.m6684constructorimpl(measureScope2.mo386toDpu2uoSUM(intRef.element) * i8), measureScope2.mo386toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m6682boximpl(Dp.m6684constructorimpl(measureScope2.mo386toDpu2uoSUM(Math.min(list2.get(i8).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * i5))), Dp.m6682boximpl(Dp.m6684constructorimpl(24)))).m6698unboximpl(), null));
                                        i8++;
                                        measureScope2 = measureScope;
                                        i5 = 2;
                                    }
                                    tabRowKt$TabRowImpl$1$scope$1$12.setTabPositions(arrayList);
                                    ArrayList arrayList2 = new ArrayList(list2.size());
                                    int size3 = list2.size();
                                    for (int i9 = 0; i9 < size3; i9++) {
                                        int i10 = intValue;
                                        intValue = i10;
                                        arrayList2.add(list2.get(i9).mo5438measureBRTryo0(Constraints.m6626copyZbe2FdA(j3, intRef.element, intRef.element, i10, intValue)));
                                    }
                                    final ArrayList arrayList3 = arrayList2;
                                    ArrayList arrayList4 = new ArrayList(list3.size());
                                    int size4 = list3.size();
                                    for (int i11 = 0; i11 < size4; i11++) {
                                        arrayList4.add(list3.get(i11).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j3, 0, 0, 0, 0, 11, null)));
                                    }
                                    final ArrayList arrayList5 = arrayList4;
                                    ArrayList arrayList6 = new ArrayList(list4.size());
                                    int size5 = list4.size();
                                    int i12 = 0;
                                    while (i12 < size5) {
                                        int i13 = intValue;
                                        intValue = i13;
                                        arrayList6.add(list4.get(i12).mo5438measureBRTryo0(Constraints.m6626copyZbe2FdA(j3, intRef.element, intRef.element, 0, i13)));
                                        i12++;
                                        list4 = list4;
                                        arrayList6 = arrayList6;
                                    }
                                    final ArrayList arrayList7 = arrayList6;
                                    return MeasureScope.layout$default(measureScope, m6637getMaxWidthimpl, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            List<Placeable> list5 = arrayList3;
                                            Ref.IntRef intRef2 = intRef;
                                            int size6 = list5.size();
                                            for (int i14 = 0; i14 < size6; i14++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i14), i14 * intRef2.element, 0, 0.0f, 4, null);
                                            }
                                            List<Placeable> list6 = arrayList5;
                                            int i15 = intValue;
                                            int size7 = list6.size();
                                            for (int i16 = 0; i16 < size7; i16++) {
                                                Placeable placeable = list6.get(i16);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i15 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List<Placeable> list7 = arrayList7;
                                            int i17 = intValue;
                                            int size8 = list7.size();
                                            for (int i18 = 0; i18 < size8; i18++) {
                                                Placeable placeable2 = list7.get(i18);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, i17 - placeable2.getHeight(), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                        ComposerKt.sourceInformationMarkerStart(composer3, -290761997, "CC(remember):Layout.kt#9igjgp");
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                        Updater.m3527setimpl(m3520constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        combineAsVirtualLayouts.invoke(composer3, 0);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    TabRowKt.m2403TabRowImplDTcfvLk(Modifier.this, j, j2, function3, function2, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* renamed from: ScrollableTabRowImpl-sKfQg0A */
    public static final void m2398ScrollableTabRowImplsKfQg0A(final int i, final Modifier modifier, final long j, final long j2, final float f, final ScrollState scrollState, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2) {
        int i3;
        float f2;
        Object obj;
        Object obj2;
        Object obj3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1594140035);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRowImpl)P(7,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,6,4)710@32775L5081,700@32441L5415:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        if ((196608 & i2) == 0) {
            obj = scrollState;
            i3 |= startRestartGroup.changed(obj) ? 131072 : 65536;
        } else {
            obj = scrollState;
        }
        if ((1572864 & i2) == 0) {
            obj2 = function3;
            i3 |= startRestartGroup.changedInstance(obj2) ? 1048576 : 524288;
        } else {
            obj2 = function3;
        }
        if ((i2 & 12582912) == 0) {
            obj3 = function2;
            i3 |= startRestartGroup.changedInstance(obj3) ? 8388608 : 4194304;
        } else {
            obj3 = function2;
        }
        if ((100663296 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
        }
        if ((i3 & 38347923) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1594140035, i3, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:699)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function23 = obj3;
            final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32 = obj2;
            final float f3 = f2;
            composer2 = startRestartGroup;
            SurfaceKt.m2347SurfaceT9BRK9s(ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), obj, false, null, false, 14, null))), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1556158104, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C711@32806L24,713@32875L147,717@33044L1274,757@34458L21,759@34509L3341,752@34328L3522:TabRow.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1556158104, i4, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous> (TabRow.kt:711)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                            composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, 413419233, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                        ScrollState scrollState2 = ScrollState.this;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, 413425768, "CC(remember):TabRow.kt#9igjgp");
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new TabRowKt$ScrollableTabRowImpl$1$scope$1$1();
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        final TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1 = (TabRowKt$ScrollableTabRowImpl$1$scope$1$1) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function33 = function32;
                        List listOf = CollectionsKt.listOf((Object[]) new Function2[]{function22, function23, ComposableLambdaKt.rememberComposableLambda(-1530560661, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i5) {
                                ComposerKt.sourceInformation(composer4, "C757@34466L11:TabRow.kt#uh7d8r");
                                if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1530560661, i5, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous>.<anonymous> (TabRow.kt:757)");
                                }
                                function33.invoke(tabRowKt$ScrollableTabRowImpl$1$scope$1$1, composer4, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54)});
                        ComposerKt.sourceInformationMarkerStart(composer3, 413474715, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed2 = composer3.changed(f3) | composer3.changed(i) | composer3.changedInstance(scrollableTabData);
                        final float f4 = f3;
                        final int i5 = i;
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = (MultiContentMeasurePolicy) new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1
                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo685measure3p2s80s(final MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j3) {
                                    float f5;
                                    float f6;
                                    MeasureScope measureScope2 = measureScope;
                                    List<? extends Measurable> list2 = list.get(0);
                                    List<? extends Measurable> list3 = list.get(1);
                                    List<? extends Measurable> list4 = list.get(2);
                                    final int i6 = measureScope2.mo383roundToPx0680j_4(f4);
                                    int size = list2.size();
                                    f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                    int i7 = measureScope2.mo383roundToPx0680j_4(f5);
                                    int i8 = 0;
                                    int size2 = list2.size();
                                    for (int i9 = 0; i9 < size2; i9++) {
                                        i8 = Integer.valueOf(Math.max(i8.intValue(), list2.get(i9).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                    }
                                    int intValue = i8.intValue();
                                    int i10 = i6 * 2;
                                    long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j3, i7, 0, intValue, intValue, 2, null);
                                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                                    floatRef.element = f4;
                                    ArrayList arrayList = new ArrayList(list2.size());
                                    int size3 = list2.size();
                                    for (int i11 = 0; i11 < size3; i11++) {
                                        arrayList.add(list2.get(i11).mo5438measureBRTryo0(m6627copyZbe2FdA$default));
                                    }
                                    ArrayList arrayList2 = arrayList;
                                    ArrayList arrayList3 = new ArrayList(size);
                                    int i12 = 0;
                                    while (i12 < size) {
                                        f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                        float m6698unboximpl = ((Dp) ComparisonsKt.maxOf(Dp.m6682boximpl(f6), Dp.m6682boximpl(measureScope2.mo386toDpu2uoSUM(((Placeable) arrayList2.get(i12)).getWidth())))).m6698unboximpl();
                                        i10 += measureScope2.mo383roundToPx0680j_4(m6698unboximpl);
                                        TabPosition tabPosition = new TabPosition(floatRef.element, m6698unboximpl, ((Dp) ComparisonsKt.maxOf(Dp.m6682boximpl(Dp.m6684constructorimpl(m6698unboximpl - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2))), Dp.m6682boximpl(Dp.m6684constructorimpl(24)))).m6698unboximpl(), null);
                                        floatRef.element = Dp.m6684constructorimpl(floatRef.element + m6698unboximpl);
                                        arrayList3.add(tabPosition);
                                        i12++;
                                        arrayList2 = arrayList2;
                                    }
                                    final ArrayList arrayList4 = arrayList2;
                                    final ArrayList arrayList5 = arrayList3;
                                    tabRowKt$ScrollableTabRowImpl$1$scope$1$1.setTabPositions(arrayList5);
                                    ArrayList arrayList6 = new ArrayList(list3.size());
                                    int size4 = list3.size();
                                    int i13 = 0;
                                    while (i13 < size4) {
                                        int i14 = i10;
                                        arrayList6.add(list3.get(i13).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j3, i14, i10, 0, 0, 8, null)));
                                        i13++;
                                        list3 = list3;
                                        arrayList6 = arrayList6;
                                        i10 = i14;
                                    }
                                    int i15 = i10;
                                    final ArrayList arrayList7 = arrayList6;
                                    int i16 = i5;
                                    ArrayList arrayList8 = new ArrayList(list4.size());
                                    int size5 = list4.size();
                                    int i17 = 0;
                                    while (i17 < size5) {
                                        int i18 = intValue;
                                        intValue = i18;
                                        arrayList8.add(list4.get(i17).mo5438measureBRTryo0(Constraints.m6626copyZbe2FdA(j3, 0, measureScope2.mo383roundToPx0680j_4(((TabPosition) arrayList5.get(i16)).m2389getWidthD9Ej5fM()), 0, i18)));
                                        i17++;
                                        measureScope2 = measureScope;
                                        list4 = list4;
                                    }
                                    final ArrayList arrayList9 = arrayList8;
                                    final float f7 = f4;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i19 = i5;
                                    final int i20 = intValue;
                                    return MeasureScope.layout$default(measureScope, i15, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            Ref.FloatRef.this.element = f7;
                                            List<Placeable> list5 = arrayList4;
                                            MeasureScope measureScope3 = measureScope;
                                            Ref.FloatRef floatRef2 = Ref.FloatRef.this;
                                            List<TabPosition> list6 = arrayList5;
                                            int size6 = list5.size();
                                            for (int i21 = 0; i21 < size6; i21++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i21), measureScope3.mo383roundToPx0680j_4(floatRef2.element), 0, 0.0f, 4, null);
                                                floatRef2.element = Dp.m6684constructorimpl(floatRef2.element + list6.get(i21).m2389getWidthD9Ej5fM());
                                            }
                                            List<Placeable> list7 = arrayList7;
                                            int i22 = i20;
                                            int size7 = list7.size();
                                            for (int i23 = 0; i23 < size7; i23++) {
                                                Placeable placeable = list7.get(i23);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i22 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List<Placeable> list8 = arrayList9;
                                            MeasureScope measureScope4 = measureScope;
                                            List<TabPosition> list9 = arrayList5;
                                            int i24 = i19;
                                            int i25 = i20;
                                            int size8 = list8.size();
                                            for (int i26 = 0; i26 < size8; i26++) {
                                                Placeable placeable2 = list8.get(i26);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, Math.max(0, (measureScope4.mo383roundToPx0680j_4(list9.get(i24).m2389getWidthD9Ej5fM()) - placeable2.getWidth()) / 2), i25 - placeable2.getHeight(), 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut(measureScope, i6, arrayList5, i19);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue4);
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Modifier.Companion companion = Modifier.Companion;
                        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                        ComposerKt.sourceInformationMarkerStart(composer3, -290761997, "CC(remember):Layout.kt#9igjgp");
                        boolean changed3 = composer3.changed(multiContentMeasurePolicy);
                        Object rememberedValue5 = composer3.rememberedValue();
                        if (changed3 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                        Updater.m3527setimpl(m3520constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        combineAsVirtualLayouts.invoke(composer3, 0);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    TabRowKt.m2398ScrollableTabRowImplsKfQg0A(i, modifier, j, j2, f, scrollState, function3, function2, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk */
    public static final void m2404TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)953@41542L2218,949@41412L2348:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, i2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:948)");
            }
            int i3 = i2 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2347SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1617702432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C954@41594L2160,954@41552L2202:TabRow.kt#uh7d8r");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617702432, i4, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:954)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1807606673, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed = composer3.changed(function22) | composer3.changed(function2) | composer3.changed(function3);
                    final Function2<Composer, Integer, Unit> function23 = function22;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m2412invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                            }

                            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                            public final MeasureResult m2412invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j3) {
                                int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j3);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function23);
                                int size = subcompose.size();
                                final Ref.IntRef intRef = new Ref.IntRef();
                                if (size > 0) {
                                    intRef.element = m6637getMaxWidthimpl / size;
                                }
                                int i5 = 0;
                                int size2 = subcompose.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    i5 = Integer.valueOf(Math.max(subcompose.get(i6).maxIntrinsicHeight(intRef.element), i5.intValue()));
                                }
                                final int intValue = i5.intValue();
                                ArrayList arrayList = new ArrayList(subcompose.size());
                                int size3 = subcompose.size();
                                int i7 = 0;
                                while (i7 < size3) {
                                    arrayList.add(subcompose.get(i7).mo5438measureBRTryo0(Constraints.m6626copyZbe2FdA(j3, intRef.element, intRef.element, intValue, intValue)));
                                    i7++;
                                    m6637getMaxWidthimpl = m6637getMaxWidthimpl;
                                }
                                final int i8 = m6637getMaxWidthimpl;
                                final ArrayList arrayList2 = arrayList;
                                ArrayList arrayList3 = new ArrayList(size);
                                for (int i9 = 0; i9 < size; i9++) {
                                    arrayList3.add(new TabPosition(Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(intRef.element) * i9), subcomposeMeasureScope.mo386toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m6682boximpl(Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(Math.min(subcompose.get(i9).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2))), Dp.m6682boximpl(Dp.m6684constructorimpl(24)))).m6698unboximpl(), null));
                                }
                                final ArrayList arrayList4 = arrayList3;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                return MeasureScope.layout$default(subcomposeMeasureScope, i8, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        List<Placeable> list = arrayList2;
                                        Ref.IntRef intRef2 = intRef;
                                        int size4 = list.size();
                                        for (int i10 = 0; i10 < size4; i10++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i10), i10 * intRef2.element, 0, 0.0f, 4, null);
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function25);
                                        long j4 = j3;
                                        int i11 = intValue;
                                        int size5 = subcompose2.size();
                                        for (int i12 = 0; i12 < size5; i12++) {
                                            Placeable mo5438measureBRTryo0 = subcompose2.get(i12).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j4, 0, 0, 0, 0, 11, null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo0, 0, i11 - mo5438measureBRTryo0.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                        final List<TabPosition> list2 = arrayList4;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i13) {
                                                ComposerKt.sourceInformation(composer4, "C1000@43547L23:TabRow.kt#uh7d8r");
                                                if ((i13 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1621992604, i13, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1000)");
                                                }
                                                function34.invoke(list2, composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i13 = i8;
                                        int i14 = intValue;
                                        int size6 = subcompose3.size();
                                        for (int i15 = 0; i15 < size6; i15++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i15).mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(i13, i14)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer3, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    TabRowKt.m2404TabRowWithSubcomposeImplDTcfvLk(Modifier.this, j, j2, function3, function2, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:285:? A[RETURN, SYNTHETIC] */
    /* renamed from: ScrollableTabRowWithSubcomposeImpl-qhFBPw4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2399ScrollableTabRowWithSubcomposeImplqhFBPw4(final int i, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final ScrollState scrollState, Composer composer, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Modifier.Companion companion;
        long j3;
        long j4;
        int i6;
        float f2;
        int i7;
        Function2<Composer, Integer, Unit> m1792getLambda7$material3_release;
        Composer composer2;
        final float f3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier2;
        final long j5;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-955409947);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRowWithSubcomposeImpl)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)1014@43999L21,1015@44063L19,1021@44384L3880,1021@44302L3962:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = function3;
            i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i4 |= startRestartGroup.changed(companion) ? 256 : 128;
                if ((i2 & 3072) == 0) {
                    if ((i3 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i9 = 2048;
                            i4 |= i9;
                        }
                    } else {
                        j3 = j;
                    }
                    i9 = 1024;
                    i4 |= i9;
                } else {
                    j3 = j;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i8 = 16384;
                            i4 |= i8;
                        }
                    } else {
                        j4 = j2;
                    }
                    i8 = 8192;
                    i4 |= i8;
                } else {
                    j4 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    f2 = f;
                    i4 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i3 & 128) == 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        if ((i3 & 256) != 0) {
                            i4 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(scrollState) ? 67108864 : 33554432;
                            if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if ((i3 & 8) != 0) {
                                        j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                        i4 &= -57345;
                                    }
                                    if (i6 != 0) {
                                        f2 = TabRowDefaults.INSTANCE.m2393getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                    }
                                    if (i7 != 0) {
                                        m1792getLambda7$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1792getLambda7$material3_release();
                                        long j7 = j4;
                                        final float f4 = f2;
                                        Modifier modifier3 = companion;
                                        long j8 = j3;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-955409947, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:1020)");
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = m1792getLambda7$material3_release;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = obj;
                                        int i10 = i4 >> 3;
                                        composer2 = startRestartGroup;
                                        SurfaceKt.m2347SurfaceT9BRK9s(modifier3, null, j8, j7, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1572959552, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference failed for: r21v0, types: [androidx.compose.runtime.Composer] */
                                            /* JADX WARN: Type inference failed for: r7v2 */
                                            public final void invoke(Composer composer3, int i11) {
                                                ComposerKt.sourceInformation(composer3, "C1022@44415L24,1024@44484L147,1033@44882L3376,1027@44640L3618:TabRow.kt#uh7d8r");
                                                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1572959552, i11, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1022)");
                                                    }
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                                                    Object rememberedValue = composer3.rememberedValue();
                                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                                        composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -702885223, "CC(remember):TabRow.kt#9igjgp");
                                                    boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                                                    ScrollState scrollState2 = ScrollState.this;
                                                    Object rememberedValue2 = composer3.rememberedValue();
                                                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                                        composer3.updateRememberedValue(rememberedValue2);
                                                    }
                                                    final ScrollableTabData scrollableTabData = rememberedValue2;
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -702869258, "CC(remember):TabRow.kt#9igjgp");
                                                    boolean changed2 = composer3.changed(f4) | composer3.changed(function22) | composer3.changed(function24) | composer3.changed(function32) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                                                    final float f5 = f4;
                                                    final Function2<Composer, Integer, Unit> function25 = function22;
                                                    final Function2<Composer, Integer, Unit> function26 = function24;
                                                    final int i12 = i;
                                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                                    Object rememberedValue3 = composer3.rememberedValue();
                                                    if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                                return m2410invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                                                            }

                                                            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                                            public final MeasureResult m2410invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                                                float f6;
                                                                f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                                int i13 = subcomposeMeasureScope.mo383roundToPx0680j_4(f6);
                                                                final int i14 = subcomposeMeasureScope.mo383roundToPx0680j_4(f5);
                                                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                                int i15 = 0;
                                                                int size = subcompose.size();
                                                                for (int i16 = 0; i16 < size; i16++) {
                                                                    i15 = Integer.valueOf(Math.max(i15.intValue(), subcompose.get(i16).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                                }
                                                                final int intValue = i15.intValue();
                                                                long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j9, i13, 0, intValue, intValue, 2, null);
                                                                final ArrayList arrayList = new ArrayList();
                                                                final ArrayList arrayList2 = new ArrayList();
                                                                int size2 = subcompose.size();
                                                                for (int i17 = 0; i17 < size2; i17++) {
                                                                    Measurable measurable = subcompose.get(i17);
                                                                    Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m6627copyZbe2FdA$default);
                                                                    float m6684constructorimpl = Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5438measureBRTryo0.getHeight()), mo5438measureBRTryo0.getWidth())) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                                                    arrayList.add(mo5438measureBRTryo0);
                                                                    arrayList2.add(Dp.m6682boximpl(m6684constructorimpl));
                                                                }
                                                                Integer valueOf = Integer.valueOf(i14 * 2);
                                                                int size3 = arrayList.size();
                                                                for (int i18 = 0; i18 < size3; i18++) {
                                                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i18)).getWidth());
                                                                }
                                                                final int intValue2 = valueOf.intValue();
                                                                final Function2<Composer, Integer, Unit> function27 = function26;
                                                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                                final int i19 = i12;
                                                                final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
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
                                                                        final ArrayList arrayList3 = new ArrayList();
                                                                        int i20 = i14;
                                                                        List<Placeable> list = arrayList;
                                                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                                        List<Dp> list2 = arrayList2;
                                                                        int size4 = list.size();
                                                                        int i21 = i20;
                                                                        for (int i22 = 0; i22 < size4; i22++) {
                                                                            Placeable placeable = list.get(i22);
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo386toDpu2uoSUM(i21), subcomposeMeasureScope2.mo386toDpu2uoSUM(placeable.getWidth()), list2.get(i22).m6698unboximpl(), null));
                                                                            i21 += placeable.getWidth();
                                                                        }
                                                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                                        long j10 = j9;
                                                                        int i23 = intValue2;
                                                                        int i24 = intValue;
                                                                        int size5 = subcompose2.size();
                                                                        for (int i25 = 0; i25 < size5; i25++) {
                                                                            Placeable mo5438measureBRTryo02 = subcompose2.get(i25).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j10, i23, i23, 0, 0, 8, null));
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo02, 0, i24 - mo5438measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                                        }
                                                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1734082948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowWithSubcomposeImpl.1.1.1.2.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                                invoke(composer4, num.intValue());
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            public final void invoke(Composer composer4, int i26) {
                                                                                ComposerKt.sourceInformation(composer4, "C1100@47792L23:TabRow.kt#uh7d8r");
                                                                                if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                                                    composer4.skipToGroupEnd();
                                                                                    return;
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1734082948, i26, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1100)");
                                                                                }
                                                                                function35.invoke(arrayList3, composer4, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                        }));
                                                                        int i26 = intValue2;
                                                                        int i27 = intValue;
                                                                        int size6 = subcompose3.size();
                                                                        for (int i28 = 0; i28 < size6; i28++) {
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                                        }
                                                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i14, arrayList3, i19);
                                                                    }
                                                                }, 4, null);
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(rememberedValue3);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, startRestartGroup, 54), composer2, ((i4 >> 6) & 14) | 12582912 | (i10 & 896) | (i10 & 7168), 114);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        f3 = f4;
                                        function23 = function24;
                                        modifier2 = modifier3;
                                        j5 = j8;
                                        j6 = j7;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 8) != 0) {
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                }
                                m1792getLambda7$material3_release = function2;
                                long j72 = j4;
                                final float f42 = f2;
                                Modifier modifier32 = companion;
                                long j82 = j3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function242 = m1792getLambda7$material3_release;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function322 = obj;
                                int i102 = i4 >> 3;
                                composer2 = startRestartGroup;
                                SurfaceKt.m2347SurfaceT9BRK9s(modifier32, null, j82, j72, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1572959552, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r21v0, types: [androidx.compose.runtime.Composer] */
                                    /* JADX WARN: Type inference failed for: r7v2 */
                                    public final void invoke(Composer composer3, int i11) {
                                        ComposerKt.sourceInformation(composer3, "C1022@44415L24,1024@44484L147,1033@44882L3376,1027@44640L3618:TabRow.kt#uh7d8r");
                                        if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1572959552, i11, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1022)");
                                            }
                                            ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                            ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                                            Object rememberedValue = composer3.rememberedValue();
                                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                                composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                                rememberedValue = compositionScopedCoroutineScopeCanceller;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -702885223, "CC(remember):TabRow.kt#9igjgp");
                                            boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                                            ScrollState scrollState2 = ScrollState.this;
                                            Object rememberedValue2 = composer3.rememberedValue();
                                            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                                rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                                composer3.updateRememberedValue(rememberedValue2);
                                            }
                                            final ScrollableTabData scrollableTabData = rememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                            ComposerKt.sourceInformationMarkerStart(composer3, -702869258, "CC(remember):TabRow.kt#9igjgp");
                                            boolean changed2 = composer3.changed(f42) | composer3.changed(function22) | composer3.changed(function242) | composer3.changed(function322) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                                            final float f5 = f42;
                                            final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                            final Function2<? super Composer, ? super Integer, Unit> function26 = function242;
                                            final int i12 = i;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function322;
                                            Object rememberedValue3 = composer3.rememberedValue();
                                            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                                rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                        return m2410invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                                                    }

                                                    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                                    public final MeasureResult m2410invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                                        float f6;
                                                        f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                        int i13 = subcomposeMeasureScope.mo383roundToPx0680j_4(f6);
                                                        final int i14 = subcomposeMeasureScope.mo383roundToPx0680j_4(f5);
                                                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                        int i15 = 0;
                                                        int size = subcompose.size();
                                                        for (int i16 = 0; i16 < size; i16++) {
                                                            i15 = Integer.valueOf(Math.max(i15.intValue(), subcompose.get(i16).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                        }
                                                        final int intValue = i15.intValue();
                                                        long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j9, i13, 0, intValue, intValue, 2, null);
                                                        final List<Placeable> arrayList = new ArrayList();
                                                        final List<Dp> arrayList2 = new ArrayList();
                                                        int size2 = subcompose.size();
                                                        for (int i17 = 0; i17 < size2; i17++) {
                                                            Measurable measurable = subcompose.get(i17);
                                                            Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m6627copyZbe2FdA$default);
                                                            float m6684constructorimpl = Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5438measureBRTryo0.getHeight()), mo5438measureBRTryo0.getWidth())) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                                            arrayList.add(mo5438measureBRTryo0);
                                                            arrayList2.add(Dp.m6682boximpl(m6684constructorimpl));
                                                        }
                                                        Integer valueOf = Integer.valueOf(i14 * 2);
                                                        int size3 = arrayList.size();
                                                        for (int i18 = 0; i18 < size3; i18++) {
                                                            valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i18)).getWidth());
                                                        }
                                                        final int intValue2 = valueOf.intValue();
                                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                        final int i19 = i12;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                                        return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
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
                                                                final List<TabPosition> arrayList3 = new ArrayList();
                                                                int i20 = i14;
                                                                List<Placeable> list = arrayList;
                                                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                                List<Dp> list2 = arrayList2;
                                                                int size4 = list.size();
                                                                int i21 = i20;
                                                                for (int i22 = 0; i22 < size4; i22++) {
                                                                    Placeable placeable = list.get(i22);
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                                    arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo386toDpu2uoSUM(i21), subcomposeMeasureScope2.mo386toDpu2uoSUM(placeable.getWidth()), list2.get(i22).m6698unboximpl(), null));
                                                                    i21 += placeable.getWidth();
                                                                }
                                                                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                                long j10 = j9;
                                                                int i23 = intValue2;
                                                                int i24 = intValue;
                                                                int size5 = subcompose2.size();
                                                                for (int i25 = 0; i25 < size5; i25++) {
                                                                    Placeable mo5438measureBRTryo02 = subcompose2.get(i25).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j10, i23, i23, 0, 0, 8, null));
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo02, 0, i24 - mo5438measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                                }
                                                                SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                                TabSlots tabSlots = TabSlots.Indicator;
                                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                                                List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1734082948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowWithSubcomposeImpl.1.1.1.2.3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                        invoke(composer4, num.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Composer composer4, int i26) {
                                                                        ComposerKt.sourceInformation(composer4, "C1100@47792L23:TabRow.kt#uh7d8r");
                                                                        if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                                            composer4.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1734082948, i26, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1100)");
                                                                        }
                                                                        function35.invoke(arrayList3, composer4, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }));
                                                                int i26 = intValue2;
                                                                int i27 = intValue;
                                                                int size6 = subcompose3.size();
                                                                for (int i28 = 0; i28 < size6; i28++) {
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                                }
                                                                scrollableTabData2.onLaidOut(subcomposeMeasureScope, i14, arrayList3, i19);
                                                            }
                                                        }, 4, null);
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue3);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, startRestartGroup, 54), composer2, ((i4 >> 6) & 14) | 12582912 | (i102 & 896) | (i102 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f3 = f42;
                                function23 = function242;
                                modifier2 = modifier32;
                                j5 = j82;
                                j6 = j72;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                composer2 = startRestartGroup;
                                modifier2 = companion;
                                j5 = j3;
                                j6 = j4;
                                f3 = f2;
                                function23 = function2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i11) {
                                        TabRowKt.m2399ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function3, modifier2, j5, j6, f3, function23, function22, scrollState, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i4 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i3 & 8) != 0) {
                        }
                        if ((i3 & 16) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        m1792getLambda7$material3_release = function2;
                        long j722 = j4;
                        final float f422 = f2;
                        Modifier modifier322 = companion;
                        long j822 = j3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function2422 = m1792getLambda7$material3_release;
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3222 = obj;
                        int i1022 = i4 >> 3;
                        composer2 = startRestartGroup;
                        SurfaceKt.m2347SurfaceT9BRK9s(modifier322, null, j822, j722, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1572959552, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r21v0, types: [androidx.compose.runtime.Composer] */
                            /* JADX WARN: Type inference failed for: r7v2 */
                            public final void invoke(Composer composer3, int i11) {
                                ComposerKt.sourceInformation(composer3, "C1022@44415L24,1024@44484L147,1033@44882L3376,1027@44640L3618:TabRow.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1572959552, i11, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1022)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                                    Object rememberedValue = composer3.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                        composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -702885223, "CC(remember):TabRow.kt#9igjgp");
                                    boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                                    ScrollState scrollState2 = ScrollState.this;
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    final ScrollableTabData scrollableTabData = rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                    ComposerKt.sourceInformationMarkerStart(composer3, -702869258, "CC(remember):TabRow.kt#9igjgp");
                                    boolean changed2 = composer3.changed(f422) | composer3.changed(function22) | composer3.changed(function2422) | composer3.changed(function3222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                                    final float f5 = f422;
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function2422;
                                    final int i12 = i;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function3222;
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                return m2410invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                                            }

                                            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                            public final MeasureResult m2410invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                                float f6;
                                                f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                int i13 = subcomposeMeasureScope.mo383roundToPx0680j_4(f6);
                                                final int i14 = subcomposeMeasureScope.mo383roundToPx0680j_4(f5);
                                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                int i15 = 0;
                                                int size = subcompose.size();
                                                for (int i16 = 0; i16 < size; i16++) {
                                                    i15 = Integer.valueOf(Math.max(i15.intValue(), subcompose.get(i16).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                }
                                                final int intValue = i15.intValue();
                                                long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j9, i13, 0, intValue, intValue, 2, null);
                                                final List<Placeable> arrayList = new ArrayList();
                                                final List<Dp> arrayList2 = new ArrayList();
                                                int size2 = subcompose.size();
                                                for (int i17 = 0; i17 < size2; i17++) {
                                                    Measurable measurable = subcompose.get(i17);
                                                    Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m6627copyZbe2FdA$default);
                                                    float m6684constructorimpl = Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5438measureBRTryo0.getHeight()), mo5438measureBRTryo0.getWidth())) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                                    arrayList.add(mo5438measureBRTryo0);
                                                    arrayList2.add(Dp.m6682boximpl(m6684constructorimpl));
                                                }
                                                Integer valueOf = Integer.valueOf(i14 * 2);
                                                int size3 = arrayList.size();
                                                for (int i18 = 0; i18 < size3; i18++) {
                                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i18)).getWidth());
                                                }
                                                final int intValue2 = valueOf.intValue();
                                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                final int i19 = i12;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
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
                                                        final List<TabPosition> arrayList3 = new ArrayList();
                                                        int i20 = i14;
                                                        List<Placeable> list = arrayList;
                                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                        List<Dp> list2 = arrayList2;
                                                        int size4 = list.size();
                                                        int i21 = i20;
                                                        for (int i22 = 0; i22 < size4; i22++) {
                                                            Placeable placeable = list.get(i22);
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo386toDpu2uoSUM(i21), subcomposeMeasureScope2.mo386toDpu2uoSUM(placeable.getWidth()), list2.get(i22).m6698unboximpl(), null));
                                                            i21 += placeable.getWidth();
                                                        }
                                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                        long j10 = j9;
                                                        int i23 = intValue2;
                                                        int i24 = intValue;
                                                        int size5 = subcompose2.size();
                                                        for (int i25 = 0; i25 < size5; i25++) {
                                                            Placeable mo5438measureBRTryo02 = subcompose2.get(i25).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j10, i23, i23, 0, 0, 8, null));
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo02, 0, i24 - mo5438measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                        }
                                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1734082948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowWithSubcomposeImpl.1.1.1.2.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                invoke(composer4, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer4, int i26) {
                                                                ComposerKt.sourceInformation(composer4, "C1100@47792L23:TabRow.kt#uh7d8r");
                                                                if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                                    composer4.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1734082948, i26, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1100)");
                                                                }
                                                                function35.invoke(arrayList3, composer4, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                        int i26 = intValue2;
                                                        int i27 = intValue;
                                                        int size6 = subcompose3.size();
                                                        for (int i28 = 0; i28 < size6; i28++) {
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                        }
                                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i14, arrayList3, i19);
                                                    }
                                                }, 4, null);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, startRestartGroup, 54), composer2, ((i4 >> 6) & 14) | 12582912 | (i1022 & 896) | (i1022 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f3 = f422;
                        function23 = function2422;
                        modifier2 = modifier322;
                        j5 = j822;
                        j6 = j722;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if ((i4 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    m1792getLambda7$material3_release = function2;
                    long j7222 = j4;
                    final float f4222 = f2;
                    Modifier modifier3222 = companion;
                    long j8222 = j3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function24222 = m1792getLambda7$material3_release;
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32222 = obj;
                    int i10222 = i4 >> 3;
                    composer2 = startRestartGroup;
                    SurfaceKt.m2347SurfaceT9BRK9s(modifier3222, null, j8222, j7222, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1572959552, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r21v0, types: [androidx.compose.runtime.Composer] */
                        /* JADX WARN: Type inference failed for: r7v2 */
                        public final void invoke(Composer composer3, int i11) {
                            ComposerKt.sourceInformation(composer3, "C1022@44415L24,1024@44484L147,1033@44882L3376,1027@44640L3618:TabRow.kt#uh7d8r");
                            if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1572959552, i11, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1022)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                                Object rememberedValue = composer3.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                    composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerStart(composer3, -702885223, "CC(remember):TabRow.kt#9igjgp");
                                boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                                ScrollState scrollState2 = ScrollState.this;
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                final ScrollableTabData scrollableTabData = rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                ComposerKt.sourceInformationMarkerStart(composer3, -702869258, "CC(remember):TabRow.kt#9igjgp");
                                boolean changed2 = composer3.changed(f4222) | composer3.changed(function22) | composer3.changed(function24222) | composer3.changed(function32222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                                final float f5 = f4222;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function24222;
                                final int i12 = i;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32222;
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                            return m2410invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                                        }

                                        /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                        public final MeasureResult m2410invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                            float f6;
                                            f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                            int i13 = subcomposeMeasureScope.mo383roundToPx0680j_4(f6);
                                            final int i14 = subcomposeMeasureScope.mo383roundToPx0680j_4(f5);
                                            List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                            int i15 = 0;
                                            int size = subcompose.size();
                                            for (int i16 = 0; i16 < size; i16++) {
                                                i15 = Integer.valueOf(Math.max(i15.intValue(), subcompose.get(i16).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                            }
                                            final int intValue = i15.intValue();
                                            long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j9, i13, 0, intValue, intValue, 2, null);
                                            final List<Placeable> arrayList = new ArrayList();
                                            final List<Dp> arrayList2 = new ArrayList();
                                            int size2 = subcompose.size();
                                            for (int i17 = 0; i17 < size2; i17++) {
                                                Measurable measurable = subcompose.get(i17);
                                                Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m6627copyZbe2FdA$default);
                                                float m6684constructorimpl = Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5438measureBRTryo0.getHeight()), mo5438measureBRTryo0.getWidth())) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                                arrayList.add(mo5438measureBRTryo0);
                                                arrayList2.add(Dp.m6682boximpl(m6684constructorimpl));
                                            }
                                            Integer valueOf = Integer.valueOf(i14 * 2);
                                            int size3 = arrayList.size();
                                            for (int i18 = 0; i18 < size3; i18++) {
                                                valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i18)).getWidth());
                                            }
                                            final int intValue2 = valueOf.intValue();
                                            final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                            final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                            final int i19 = i12;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                            return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
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
                                                    final List<TabPosition> arrayList3 = new ArrayList();
                                                    int i20 = i14;
                                                    List<Placeable> list = arrayList;
                                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                    List<Dp> list2 = arrayList2;
                                                    int size4 = list.size();
                                                    int i21 = i20;
                                                    for (int i22 = 0; i22 < size4; i22++) {
                                                        Placeable placeable = list.get(i22);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                        arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo386toDpu2uoSUM(i21), subcomposeMeasureScope2.mo386toDpu2uoSUM(placeable.getWidth()), list2.get(i22).m6698unboximpl(), null));
                                                        i21 += placeable.getWidth();
                                                    }
                                                    List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                    long j10 = j9;
                                                    int i23 = intValue2;
                                                    int i24 = intValue;
                                                    int size5 = subcompose2.size();
                                                    for (int i25 = 0; i25 < size5; i25++) {
                                                        Placeable mo5438measureBRTryo02 = subcompose2.get(i25).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j10, i23, i23, 0, 0, 8, null));
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo02, 0, i24 - mo5438measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                    }
                                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                    TabSlots tabSlots = TabSlots.Indicator;
                                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                                    List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1734082948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowWithSubcomposeImpl.1.1.1.2.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                            invoke(composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i26) {
                                                            ComposerKt.sourceInformation(composer4, "C1100@47792L23:TabRow.kt#uh7d8r");
                                                            if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1734082948, i26, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1100)");
                                                            }
                                                            function35.invoke(arrayList3, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }));
                                                    int i26 = intValue2;
                                                    int i27 = intValue;
                                                    int size6 = subcompose3.size();
                                                    for (int i28 = 0; i28 < size6; i28++) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                    }
                                                    scrollableTabData2.onLaidOut(subcomposeMeasureScope, i14, arrayList3, i19);
                                                }
                                            }, 4, null);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54), composer2, ((i4 >> 6) & 14) | 12582912 | (i10222 & 896) | (i10222 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f3 = f4222;
                    function23 = function24222;
                    modifier2 = modifier3222;
                    j5 = j8222;
                    j6 = j7222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                f2 = f;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                m1792getLambda7$material3_release = function2;
                long j72222 = j4;
                final float f42222 = f2;
                Modifier modifier32222 = companion;
                long j82222 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function242222 = m1792getLambda7$material3_release;
                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function322222 = obj;
                int i102222 = i4 >> 3;
                composer2 = startRestartGroup;
                SurfaceKt.m2347SurfaceT9BRK9s(modifier32222, null, j82222, j72222, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1572959552, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r21v0, types: [androidx.compose.runtime.Composer] */
                    /* JADX WARN: Type inference failed for: r7v2 */
                    public final void invoke(Composer composer3, int i11) {
                        ComposerKt.sourceInformation(composer3, "C1022@44415L24,1024@44484L147,1033@44882L3376,1027@44640L3618:TabRow.kt#uh7d8r");
                        if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1572959552, i11, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1022)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                            Object rememberedValue = composer3.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                rememberedValue = compositionScopedCoroutineScopeCanceller;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerStart(composer3, -702885223, "CC(remember):TabRow.kt#9igjgp");
                            boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                            ScrollState scrollState2 = ScrollState.this;
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            final ScrollableTabData scrollableTabData = rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                            ComposerKt.sourceInformationMarkerStart(composer3, -702869258, "CC(remember):TabRow.kt#9igjgp");
                            boolean changed2 = composer3.changed(f42222) | composer3.changed(function22) | composer3.changed(function242222) | composer3.changed(function322222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                            final float f5 = f42222;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function242222;
                            final int i12 = i;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function322222;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                        return m2410invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                                    }

                                    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                    public final MeasureResult m2410invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                        float f6;
                                        f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                        int i13 = subcomposeMeasureScope.mo383roundToPx0680j_4(f6);
                                        final int i14 = subcomposeMeasureScope.mo383roundToPx0680j_4(f5);
                                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                        int i15 = 0;
                                        int size = subcompose.size();
                                        for (int i16 = 0; i16 < size; i16++) {
                                            i15 = Integer.valueOf(Math.max(i15.intValue(), subcompose.get(i16).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                        }
                                        final int intValue = i15.intValue();
                                        long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j9, i13, 0, intValue, intValue, 2, null);
                                        final List<Placeable> arrayList = new ArrayList();
                                        final List<Dp> arrayList2 = new ArrayList();
                                        int size2 = subcompose.size();
                                        for (int i17 = 0; i17 < size2; i17++) {
                                            Measurable measurable = subcompose.get(i17);
                                            Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m6627copyZbe2FdA$default);
                                            float m6684constructorimpl = Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5438measureBRTryo0.getHeight()), mo5438measureBRTryo0.getWidth())) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                            arrayList.add(mo5438measureBRTryo0);
                                            arrayList2.add(Dp.m6682boximpl(m6684constructorimpl));
                                        }
                                        Integer valueOf = Integer.valueOf(i14 * 2);
                                        int size3 = arrayList.size();
                                        for (int i18 = 0; i18 < size3; i18++) {
                                            valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i18)).getWidth());
                                        }
                                        final int intValue2 = valueOf.intValue();
                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                        final int i19 = i12;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                        return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
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
                                                final List<TabPosition> arrayList3 = new ArrayList();
                                                int i20 = i14;
                                                List<Placeable> list = arrayList;
                                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                List<Dp> list2 = arrayList2;
                                                int size4 = list.size();
                                                int i21 = i20;
                                                for (int i22 = 0; i22 < size4; i22++) {
                                                    Placeable placeable = list.get(i22);
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                    arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo386toDpu2uoSUM(i21), subcomposeMeasureScope2.mo386toDpu2uoSUM(placeable.getWidth()), list2.get(i22).m6698unboximpl(), null));
                                                    i21 += placeable.getWidth();
                                                }
                                                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                long j10 = j9;
                                                int i23 = intValue2;
                                                int i24 = intValue;
                                                int size5 = subcompose2.size();
                                                for (int i25 = 0; i25 < size5; i25++) {
                                                    Placeable mo5438measureBRTryo02 = subcompose2.get(i25).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j10, i23, i23, 0, 0, 8, null));
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo02, 0, i24 - mo5438measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                }
                                                SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                TabSlots tabSlots = TabSlots.Indicator;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                                List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1734082948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowWithSubcomposeImpl.1.1.1.2.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                        invoke(composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i26) {
                                                        ComposerKt.sourceInformation(composer4, "C1100@47792L23:TabRow.kt#uh7d8r");
                                                        if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1734082948, i26, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1100)");
                                                        }
                                                        function35.invoke(arrayList3, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }));
                                                int i26 = intValue2;
                                                int i27 = intValue;
                                                int size6 = subcompose3.size();
                                                for (int i28 = 0; i28 < size6; i28++) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                }
                                                scrollableTabData2.onLaidOut(subcomposeMeasureScope, i14, arrayList3, i19);
                                            }
                                        }, 4, null);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), composer2, ((i4 >> 6) & 14) | 12582912 | (i102222 & 896) | (i102222 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                }
                f3 = f42222;
                function23 = function242222;
                modifier2 = modifier32222;
                j5 = j82222;
                j6 = j72222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            companion = modifier;
            if ((i2 & 3072) == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            f2 = f;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            m1792getLambda7$material3_release = function2;
            long j722222 = j4;
            final float f422222 = f2;
            Modifier modifier322222 = companion;
            long j822222 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function2422222 = m1792getLambda7$material3_release;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3222222 = obj;
            int i1022222 = i4 >> 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2347SurfaceT9BRK9s(modifier322222, null, j822222, j722222, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1572959552, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r21v0, types: [androidx.compose.runtime.Composer] */
                /* JADX WARN: Type inference failed for: r7v2 */
                public final void invoke(Composer composer3, int i11) {
                    ComposerKt.sourceInformation(composer3, "C1022@44415L24,1024@44484L147,1033@44882L3376,1027@44640L3618:TabRow.kt#uh7d8r");
                    if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1572959552, i11, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1022)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                            composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -702885223, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                        ScrollState scrollState2 = ScrollState.this;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        final ScrollableTabData scrollableTabData = rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                        ComposerKt.sourceInformationMarkerStart(composer3, -702869258, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed2 = composer3.changed(f422222) | composer3.changed(function22) | composer3.changed(function2422222) | composer3.changed(function3222222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                        final float f5 = f422222;
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function2422222;
                        final int i12 = i;
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function3222222;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m2410invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                                }

                                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                public final MeasureResult m2410invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                    float f6;
                                    f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                    int i13 = subcomposeMeasureScope.mo383roundToPx0680j_4(f6);
                                    final int i14 = subcomposeMeasureScope.mo383roundToPx0680j_4(f5);
                                    List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                    int i15 = 0;
                                    int size = subcompose.size();
                                    for (int i16 = 0; i16 < size; i16++) {
                                        i15 = Integer.valueOf(Math.max(i15.intValue(), subcompose.get(i16).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                    }
                                    final int intValue = i15.intValue();
                                    long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j9, i13, 0, intValue, intValue, 2, null);
                                    final List<Placeable> arrayList = new ArrayList();
                                    final List<Dp> arrayList2 = new ArrayList();
                                    int size2 = subcompose.size();
                                    for (int i17 = 0; i17 < size2; i17++) {
                                        Measurable measurable = subcompose.get(i17);
                                        Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m6627copyZbe2FdA$default);
                                        float m6684constructorimpl = Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5438measureBRTryo0.getHeight()), mo5438measureBRTryo0.getWidth())) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                        arrayList.add(mo5438measureBRTryo0);
                                        arrayList2.add(Dp.m6682boximpl(m6684constructorimpl));
                                    }
                                    Integer valueOf = Integer.valueOf(i14 * 2);
                                    int size3 = arrayList.size();
                                    for (int i18 = 0; i18 < size3; i18++) {
                                        valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i18)).getWidth());
                                    }
                                    final int intValue2 = valueOf.intValue();
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i19 = i12;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                    return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            final List<TabPosition> arrayList3 = new ArrayList();
                                            int i20 = i14;
                                            List<Placeable> list = arrayList;
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                            List<Dp> list2 = arrayList2;
                                            int size4 = list.size();
                                            int i21 = i20;
                                            for (int i22 = 0; i22 < size4; i22++) {
                                                Placeable placeable = list.get(i22);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo386toDpu2uoSUM(i21), subcomposeMeasureScope2.mo386toDpu2uoSUM(placeable.getWidth()), list2.get(i22).m6698unboximpl(), null));
                                                i21 += placeable.getWidth();
                                            }
                                            List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                            long j10 = j9;
                                            int i23 = intValue2;
                                            int i24 = intValue;
                                            int size5 = subcompose2.size();
                                            for (int i25 = 0; i25 < size5; i25++) {
                                                Placeable mo5438measureBRTryo02 = subcompose2.get(i25).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j10, i23, i23, 0, 0, 8, null));
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo02, 0, i24 - mo5438measureBRTryo02.getHeight(), 0.0f, 4, null);
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                            List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1734082948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowWithSubcomposeImpl.1.1.1.2.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i26) {
                                                    ComposerKt.sourceInformation(composer4, "C1100@47792L23:TabRow.kt#uh7d8r");
                                                    if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1734082948, i26, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1100)");
                                                    }
                                                    function35.invoke(arrayList3, composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i26 = intValue2;
                                            int i27 = intValue;
                                            int size6 = subcompose3.size();
                                            for (int i28 = 0; i28 < size6; i28++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut(subcomposeMeasureScope, i14, arrayList3, i19);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), composer2, ((i4 >> 6) & 14) | 12582912 | (i1022222 & 896) | (i1022222 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
            }
            f3 = f422222;
            function23 = function2422222;
            modifier2 = modifier322222;
            j5 = j822222;
            j6 = j722222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = function3;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        companion = modifier;
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        f2 = f;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        m1792getLambda7$material3_release = function2;
        long j7222222 = j4;
        final float f4222222 = f2;
        Modifier modifier3222222 = companion;
        long j8222222 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function24222222 = m1792getLambda7$material3_release;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32222222 = obj;
        int i10222222 = i4 >> 3;
        composer2 = startRestartGroup;
        SurfaceKt.m2347SurfaceT9BRK9s(modifier3222222, null, j8222222, j7222222, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1572959552, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r21v0, types: [androidx.compose.runtime.Composer] */
            /* JADX WARN: Type inference failed for: r7v2 */
            public final void invoke(Composer composer3, int i11) {
                ComposerKt.sourceInformation(composer3, "C1022@44415L24,1024@44484L147,1033@44882L3376,1027@44640L3618:TabRow.kt#uh7d8r");
                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1572959552, i11, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1022)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                    Object rememberedValue = composer3.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                        composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -702885223, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                    ScrollState scrollState2 = ScrollState.this;
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    final ScrollableTabData scrollableTabData = rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                    ComposerKt.sourceInformationMarkerStart(composer3, -702869258, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed2 = composer3.changed(f4222222) | composer3.changed(function22) | composer3.changed(function24222222) | composer3.changed(function32222222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                    final float f5 = f4222222;
                    final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function24222222;
                    final int i12 = i;
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32222222;
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m2410invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                            }

                            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                            public final MeasureResult m2410invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                float f6;
                                f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                int i13 = subcomposeMeasureScope.mo383roundToPx0680j_4(f6);
                                final int i14 = subcomposeMeasureScope.mo383roundToPx0680j_4(f5);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                int i15 = 0;
                                int size = subcompose.size();
                                for (int i16 = 0; i16 < size; i16++) {
                                    i15 = Integer.valueOf(Math.max(i15.intValue(), subcompose.get(i16).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                }
                                final int intValue = i15.intValue();
                                long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j9, i13, 0, intValue, intValue, 2, null);
                                final List<Placeable> arrayList = new ArrayList();
                                final List<Dp> arrayList2 = new ArrayList();
                                int size2 = subcompose.size();
                                for (int i17 = 0; i17 < size2; i17++) {
                                    Measurable measurable = subcompose.get(i17);
                                    Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m6627copyZbe2FdA$default);
                                    float m6684constructorimpl = Dp.m6684constructorimpl(subcomposeMeasureScope.mo386toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5438measureBRTryo0.getHeight()), mo5438measureBRTryo0.getWidth())) - Dp.m6684constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                    arrayList.add(mo5438measureBRTryo0);
                                    arrayList2.add(Dp.m6682boximpl(m6684constructorimpl));
                                }
                                Integer valueOf = Integer.valueOf(i14 * 2);
                                int size3 = arrayList.size();
                                for (int i18 = 0; i18 < size3; i18++) {
                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i18)).getWidth());
                                }
                                final int intValue2 = valueOf.intValue();
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                final int i19 = i12;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        final List<TabPosition> arrayList3 = new ArrayList();
                                        int i20 = i14;
                                        List<Placeable> list = arrayList;
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        List<Dp> list2 = arrayList2;
                                        int size4 = list.size();
                                        int i21 = i20;
                                        for (int i22 = 0; i22 < size4; i22++) {
                                            Placeable placeable = list.get(i22);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo386toDpu2uoSUM(i21), subcomposeMeasureScope2.mo386toDpu2uoSUM(placeable.getWidth()), list2.get(i22).m6698unboximpl(), null));
                                            i21 += placeable.getWidth();
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                        long j10 = j9;
                                        int i23 = intValue2;
                                        int i24 = intValue;
                                        int size5 = subcompose2.size();
                                        for (int i25 = 0; i25 < size5; i25++) {
                                            Placeable mo5438measureBRTryo02 = subcompose2.get(i25).mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j10, i23, i23, 0, 0, 8, null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo02, 0, i24 - mo5438measureBRTryo02.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1734082948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowWithSubcomposeImpl.1.1.1.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C1100@47792L23:TabRow.kt#uh7d8r");
                                                if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1734082948, i26, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1100)");
                                                }
                                                function35.invoke(arrayList3, composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i26 = intValue2;
                                        int i27 = intValue;
                                        int size6 = subcompose3.size();
                                        for (int i28 = 0; i28 < size6; i28++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                        }
                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i14, arrayList3, i19);
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, startRestartGroup, 54), composer2, ((i4 >> 6) & 14) | 12582912 | (i10222222 & 896) | (i10222222 & 7168), 114);
        if (ComposerKt.isTraceInProgress()) {
        }
        f3 = f4222222;
        function23 = function24222222;
        modifier2 = modifier3222222;
        j5 = j8222222;
        j6 = j7222222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
