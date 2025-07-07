package androidx.compose.foundation.pager;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: Pager.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aâ\u0001\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001aî\u0001\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u0017\u00102\u001a\u00020\u00012\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0082\b\u001aL\u00106\u001a\u00020\u000b*\u00020\u001e2\u0006\u00107\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000bH\u0000\u001a,\u0010?\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020B2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"HorizontalPager", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "HorizontalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerKt {
    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:268:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:483:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* renamed from: HorizontalPager--8jOkeI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m983HorizontalPager8jOkeI(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        int i7;
        int i8;
        final int i9;
        int i10;
        float f2;
        int i11;
        Alignment.Vertical vertical2;
        Object obj2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Composer composer2;
        final PaddingValues paddingValues2;
        final PageSize pageSize2;
        final boolean z3;
        final boolean z4;
        final Function1<? super Integer, ? extends Object> function12;
        final NestedScrollConnection nestedScrollConnection2;
        final SnapPosition snapPosition2;
        final float f3;
        final Modifier modifier2;
        final Alignment.Vertical vertical3;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        PagerState pagerState2;
        ?? r4;
        int i22;
        int i23;
        NestedScrollConnection nestedScrollConnection3;
        int i24;
        Function1<? super Integer, ? extends Object> function13;
        NestedScrollConnection nestedScrollConnection4;
        int i25;
        PaddingValues paddingValues3;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        boolean z5;
        int i26;
        float f4;
        int i27;
        boolean z6;
        SnapPosition snapPosition3;
        Modifier modifier3;
        OverscrollEffect overscrollEffect3;
        int i28;
        Object obj3;
        int i29;
        Object obj4;
        Composer startRestartGroup = composer.startRestartGroup(-1372972868);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPager)P(12,4,1,8!1,9:c#ui.unit.Dp,14!1,13,10!1,7,11)130@7467L706:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i30 = i4 & 2;
        if (i30 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = modifier;
            i5 |= startRestartGroup.changed(obj) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
                i7 = i4 & 8;
                int i31 = 1024;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                            vertical2 = vertical;
                        } else {
                            Object obj5 = vertical;
                            vertical2 = obj5;
                            if ((i2 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(obj5) ? 1048576 : 524288;
                                vertical2 = obj5;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & 128) == 0) {
                                obj3 = targetedFlingBehavior;
                                if (startRestartGroup.changed(obj3)) {
                                    i29 = 8388608;
                                    obj4 = obj3;
                                    i5 |= i29;
                                    obj2 = obj4;
                                }
                            } else {
                                obj3 = targetedFlingBehavior;
                            }
                            i29 = 4194304;
                            obj4 = obj3;
                            i5 |= i29;
                            obj2 = obj4;
                        } else {
                            obj2 = targetedFlingBehavior;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & 2048) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i28 = 32;
                                i17 |= i28;
                            }
                            i28 = 16;
                            i17 |= i28;
                        } else {
                            i18 = i16;
                        }
                        int i32 = i17;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                            i20 = i32 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            i20 = i32;
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i20 |= startRestartGroup.changed(snapPosition) ? 256 : 128;
                                if ((i3 & 3072) == 0) {
                                    if ((i4 & 8192) == 0 && startRestartGroup.changed(overscrollEffect)) {
                                        i31 = 2048;
                                    }
                                    i20 |= i31;
                                }
                                i21 = i20;
                                if ((i4 & 16384) == 0) {
                                    i21 |= 24576;
                                } else if ((i3 & 24576) == 0) {
                                    i21 |= startRestartGroup.changedInstance(function4) ? 16384 : 8192;
                                    if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                                        startRestartGroup.startDefaults();
                                        ComposerKt.sourceInformation(startRestartGroup, "120@6993L28,125@7217L57,127@7371L26");
                                        if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                            Modifier.Companion companion = i30 != 0 ? Modifier.Companion : obj;
                                            PaddingValues m731PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : paddingValues;
                                            PageSize.Fill fill = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                            int i33 = i8 != 0 ? 0 : i9;
                                            float m6684constructorimpl = i10 != 0 ? Dp.m6684constructorimpl(0) : f2;
                                            if (i11 != 0) {
                                                vertical2 = Alignment.Companion.getCenterVertically();
                                            }
                                            if ((i4 & 128) != 0) {
                                                i22 = i19;
                                                i23 = i21;
                                                pagerState2 = pagerState;
                                                i15 &= -29360129;
                                                r4 = 0;
                                                obj2 = PagerDefaults.INSTANCE.flingBehavior(pagerState2, null, null, null, 0.0f, startRestartGroup, (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                            } else {
                                                pagerState2 = pagerState;
                                                r4 = 0;
                                                i22 = i19;
                                                i23 = i21;
                                            }
                                            boolean z7 = i12 == 0 ? z : true;
                                            boolean z8 = i14 != 0 ? r4 : z2;
                                            Function1<? super Integer, ? extends Object> function14 = i18 != 0 ? null : function1;
                                            if ((i4 & 2048) != 0) {
                                                nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Horizontal, startRestartGroup, (i15 & 14) | 432);
                                                i24 = i23 & (-113);
                                            } else {
                                                nestedScrollConnection3 = nestedScrollConnection;
                                                i24 = i23;
                                            }
                                            SnapPosition.Start start = i22 != 0 ? SnapPosition.Start.INSTANCE : snapPosition;
                                            if ((i4 & 8192) != 0) {
                                                SnapPosition snapPosition4 = start;
                                                overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, r4);
                                                i25 = i24 & (-7169);
                                                targetedFlingBehavior3 = obj2;
                                                snapPosition3 = snapPosition4;
                                                function13 = function14;
                                                nestedScrollConnection4 = nestedScrollConnection3;
                                                composer2 = startRestartGroup;
                                                paddingValues3 = m731PaddingValues0680j_4;
                                                pageSize3 = fill;
                                                z5 = z7;
                                                i26 = i33;
                                                f4 = m6684constructorimpl;
                                                i27 = i15;
                                                z6 = z8;
                                                modifier3 = companion;
                                            } else {
                                                function13 = function14;
                                                nestedScrollConnection4 = nestedScrollConnection3;
                                                i25 = i24;
                                                composer2 = startRestartGroup;
                                                paddingValues3 = m731PaddingValues0680j_4;
                                                targetedFlingBehavior3 = obj2;
                                                pageSize3 = fill;
                                                z5 = z7;
                                                i26 = i33;
                                                f4 = m6684constructorimpl;
                                                i27 = i15;
                                                z6 = z8;
                                                snapPosition3 = start;
                                                modifier3 = companion;
                                                overscrollEffect3 = overscrollEffect;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i4 & 128) != 0) {
                                                i15 &= -29360129;
                                            }
                                            if ((i4 & 2048) != 0) {
                                                i21 &= -113;
                                            }
                                            if ((i4 & 8192) != 0) {
                                                i21 &= -7169;
                                            }
                                            paddingValues3 = paddingValues;
                                            pageSize3 = pageSize;
                                            z6 = z2;
                                            function13 = function1;
                                            nestedScrollConnection4 = nestedScrollConnection;
                                            i25 = i21;
                                            composer2 = startRestartGroup;
                                            f4 = f2;
                                            modifier3 = obj;
                                            i27 = i15;
                                            z5 = z;
                                            overscrollEffect3 = overscrollEffect;
                                            i26 = i9;
                                            targetedFlingBehavior3 = obj2;
                                            snapPosition3 = snapPosition;
                                        }
                                        composer2.endDefaults();
                                        Modifier modifier4 = modifier3;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1372972868, i27, i25, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:129)");
                                        }
                                        int i34 = i25;
                                        int i35 = i27 >> 6;
                                        int i36 = i27 << 12;
                                        int i37 = ((i27 >> 3) & 14) | 24576 | ((i27 << 3) & 112) | (i27 & 896) | ((i27 >> 18) & 7168) | (i35 & 458752) | (i35 & 3670016) | ((i34 << 12) & 29360128) | (i36 & 234881024) | (i36 & 1879048192);
                                        int i38 = ((i27 >> 9) & 14) | 3072 | (i34 & 112);
                                        int i39 = i34 << 6;
                                        LazyLayoutPagerKt.m979PagereLwUrMk(modifier4, pagerState, paddingValues3, z6, Orientation.Horizontal, targetedFlingBehavior3, z5, overscrollEffect3, i26, f4, pageSize3, nestedScrollConnection4, function13, Alignment.Companion.getCenterHorizontally(), vertical2, snapPosition3, function4, composer2, i37, i38 | (i39 & 896) | (i35 & 57344) | ((i34 << 9) & 458752) | (i39 & 3670016), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        int i40 = i26;
                                        targetedFlingBehavior2 = targetedFlingBehavior3;
                                        i9 = i40;
                                        float f5 = f4;
                                        z3 = z5;
                                        f3 = f5;
                                        Alignment.Vertical vertical4 = vertical2;
                                        overscrollEffect2 = overscrollEffect3;
                                        vertical3 = vertical4;
                                        Function1<? super Integer, ? extends Object> function15 = function13;
                                        nestedScrollConnection2 = nestedScrollConnection4;
                                        function12 = function15;
                                        pageSize2 = pageSize3;
                                        snapPosition2 = snapPosition3;
                                        z4 = z6;
                                        paddingValues2 = paddingValues3;
                                        modifier2 = modifier4;
                                    } else {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        paddingValues2 = paddingValues;
                                        pageSize2 = pageSize;
                                        z3 = z;
                                        z4 = z2;
                                        function12 = function1;
                                        nestedScrollConnection2 = nestedScrollConnection;
                                        snapPosition2 = snapPosition;
                                        f3 = f2;
                                        modifier2 = obj;
                                        vertical3 = vertical2;
                                        targetedFlingBehavior2 = obj2;
                                        overscrollEffect2 = overscrollEffect;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$1
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

                                            public final void invoke(Composer composer3, int i41) {
                                                PagerKt.m983HorizontalPager8jOkeI(PagerState.this, modifier2, paddingValues2, pageSize2, i9, f3, vertical3, targetedFlingBehavior2, z3, z4, function12, nestedScrollConnection2, snapPosition2, overscrollEffect2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        i21 = i20;
                        if ((i4 & 16384) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i322 = i17;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    i21 = i20;
                    if ((i4 & 16384) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i3222 = i17;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                i21 = i20;
                if ((i4 & 16384) == 0) {
                }
                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 8;
            int i312 = 1024;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i32222 = i17;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            i21 = i20;
            if ((i4 & 16384) == 0) {
            }
            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i3122 = 1024;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i322222 = i17;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        i21 = i20;
        if ((i4 & 16384) == 0) {
        }
        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:252:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:451:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* renamed from: HorizontalPager-oI3XNZo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m984HorizontalPageroI3XNZo(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, final Function4 function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        int i7;
        int i8;
        final int i9;
        int i10;
        final float f2;
        int i11;
        Object obj2;
        Object obj3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        final PaddingValues paddingValues2;
        final PageSize pageSize2;
        final boolean z3;
        final boolean z4;
        final Function1 function12;
        final NestedScrollConnection nestedScrollConnection2;
        final Modifier modifier2;
        final Alignment.Vertical vertical2;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final SnapPosition snapPosition2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        int i21;
        PagerState pagerState2;
        int i22;
        Composer composer2;
        int i23;
        NestedScrollConnection nestedScrollConnection3;
        SnapPosition.Start start;
        boolean z5;
        Function1 function13;
        NestedScrollConnection nestedScrollConnection4;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        boolean z6;
        float f3;
        PaddingValues paddingValues3;
        int i24;
        int i25;
        int i26;
        Composer startRestartGroup = composer.startRestartGroup(1870896258);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPager)P(11,4,1,7!1,8:c#ui.unit.Dp,13!1,12,9!1,6,10)184@9633L26,170@9080L620:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i27 = i4 & 2;
        if (i27 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = modifier;
            i5 |= startRestartGroup.changed(obj) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                            obj2 = vertical;
                        } else {
                            obj2 = vertical;
                            if ((i2 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(obj2) ? 1048576 : 524288;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & 128) == 0) {
                                obj3 = targetedFlingBehavior;
                                if (startRestartGroup.changed(obj3)) {
                                    i26 = 8388608;
                                    i5 |= i26;
                                }
                            } else {
                                obj3 = targetedFlingBehavior;
                            }
                            i26 = 4194304;
                            i5 |= i26;
                        } else {
                            obj3 = targetedFlingBehavior;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & 2048) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i25 = 32;
                                i17 |= i25;
                            }
                            i25 = 16;
                            i17 |= i25;
                        } else {
                            i18 = i16;
                        }
                        int i28 = i17;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                            i20 = i28 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            int i29 = i28;
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i29 |= startRestartGroup.changed(snapPosition) ? 256 : 128;
                            }
                            i20 = i29;
                        }
                        if ((i4 & 8192) != 0) {
                            i20 |= 3072;
                        } else if ((i3 & 3072) == 0) {
                            i20 |= startRestartGroup.changedInstance(function4) ? 2048 : 1024;
                            if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "161@8676L28,166@8900L57");
                                if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i27 != 0 ? Modifier.Companion : obj;
                                    PaddingValues m731PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : paddingValues;
                                    PageSize.Fill fill = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                    i21 = i8 != 0 ? 0 : i9;
                                    float m6684constructorimpl = i10 != 0 ? Dp.m6684constructorimpl(0) : f2;
                                    if (i11 != 0) {
                                        obj2 = Alignment.Companion.getCenterVertically();
                                    }
                                    if ((i4 & 128) != 0) {
                                        composer2 = startRestartGroup;
                                        i23 = i20;
                                        pagerState2 = pagerState;
                                        i15 &= -29360129;
                                        i22 = 0;
                                        obj3 = PagerDefaults.INSTANCE.flingBehavior(pagerState2, null, null, null, 0.0f, composer2, (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                    } else {
                                        pagerState2 = pagerState;
                                        i22 = 0;
                                        composer2 = startRestartGroup;
                                        i23 = i20;
                                    }
                                    boolean z7 = i12 == 0 ? z : true;
                                    boolean z8 = i14 != 0 ? i22 == 1 ? 1 : 0 : z2;
                                    Function1 function14 = i18 != 0 ? null : function1;
                                    if ((i4 & 2048) != 0) {
                                        nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Horizontal, composer2, (i15 & 14) | 432);
                                        i23 &= -113;
                                    } else {
                                        nestedScrollConnection3 = nestedScrollConnection;
                                    }
                                    if (i19 != 0) {
                                        z5 = z8;
                                        function13 = function14;
                                        nestedScrollConnection4 = nestedScrollConnection3;
                                        start = SnapPosition.Start.INSTANCE;
                                    } else {
                                        start = snapPosition;
                                        z5 = z8;
                                        function13 = function14;
                                        nestedScrollConnection4 = nestedScrollConnection3;
                                    }
                                    targetedFlingBehavior3 = obj3;
                                    i20 = i23;
                                    pageSize3 = fill;
                                    z6 = z7;
                                    f3 = m6684constructorimpl;
                                    paddingValues3 = m731PaddingValues0680j_4;
                                    i24 = i15;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & 128) != 0) {
                                        i15 &= -29360129;
                                    }
                                    if ((i4 & 2048) != 0) {
                                        i20 &= -113;
                                    }
                                    pagerState2 = pagerState;
                                    paddingValues3 = paddingValues;
                                    z6 = z;
                                    z5 = z2;
                                    function13 = function1;
                                    nestedScrollConnection4 = nestedScrollConnection;
                                    start = snapPosition;
                                    i22 = 0;
                                    i21 = i9;
                                    f3 = f2;
                                    companion = obj;
                                    targetedFlingBehavior3 = obj3;
                                    composer2 = startRestartGroup;
                                    i24 = i15;
                                    pageSize3 = pageSize;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1870896258, i24, i20, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:169)");
                                    i22 = 0;
                                }
                                int i30 = (i20 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i20 << 3) & 57344);
                                PagerState pagerState3 = pagerState2;
                                startRestartGroup = composer2;
                                Alignment.Vertical vertical3 = obj2;
                                Modifier modifier3 = companion;
                                int i31 = i21;
                                m983HorizontalPager8jOkeI(pagerState3, modifier3, paddingValues3, pageSize3, i31, f3, vertical3, targetedFlingBehavior3, z6, z5, function13, nestedScrollConnection4, start, OverscrollKt.rememberOverscrollEffect(composer2, i22), function4, startRestartGroup, i24 & 2147483646, i30, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                snapPosition2 = start;
                                nestedScrollConnection2 = nestedScrollConnection4;
                                function12 = function13;
                                z4 = z5;
                                z3 = z6;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                vertical2 = vertical3;
                                f2 = f3;
                                i9 = i31;
                                pageSize2 = pageSize3;
                                paddingValues2 = paddingValues3;
                                modifier2 = modifier3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                paddingValues2 = paddingValues;
                                pageSize2 = pageSize;
                                z3 = z;
                                z4 = z2;
                                function12 = function1;
                                nestedScrollConnection2 = nestedScrollConnection;
                                modifier2 = obj;
                                vertical2 = obj2;
                                targetedFlingBehavior2 = obj3;
                                snapPosition2 = snapPosition;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$2
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

                                    public final void invoke(Composer composer3, int i32) {
                                        PagerKt.m984HorizontalPageroI3XNZo(PagerState.this, modifier2, paddingValues2, pageSize2, i9, f2, vertical2, targetedFlingBehavior2, z3, z4, function12, nestedScrollConnection2, snapPosition2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i282 = i17;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    if ((i4 & 8192) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i2822 = i17;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                if ((i4 & 8192) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i28222 = i17;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            if ((i4 & 8192) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i282222 = i17;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        if ((i4 & 8192) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:268:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:483:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* renamed from: VerticalPager--8jOkeI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m985VerticalPager8jOkeI(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        int i7;
        int i8;
        final int i9;
        int i10;
        float f2;
        int i11;
        Object obj2;
        Object obj3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Composer composer2;
        final PaddingValues paddingValues2;
        final PageSize pageSize2;
        final boolean z3;
        final boolean z4;
        final Function1<? super Integer, ? extends Object> function12;
        final NestedScrollConnection nestedScrollConnection2;
        final SnapPosition snapPosition2;
        final float f3;
        final Modifier modifier2;
        final Alignment.Horizontal horizontal2;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        PagerState pagerState2;
        ?? r4;
        int i22;
        int i23;
        NestedScrollConnection nestedScrollConnection3;
        int i24;
        Function1<? super Integer, ? extends Object> function13;
        NestedScrollConnection nestedScrollConnection4;
        int i25;
        PaddingValues paddingValues3;
        Alignment.Horizontal horizontal3;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        boolean z5;
        int i26;
        float f4;
        int i27;
        boolean z6;
        SnapPosition snapPosition3;
        Modifier modifier3;
        OverscrollEffect overscrollEffect3;
        int i28;
        Object obj4;
        int i29;
        Object obj5;
        Composer startRestartGroup = composer.startRestartGroup(632853564);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalPager)P(13,5,1,9!1,10:c#ui.unit.Dp,3!1,14,11!1,8,12)260@14392L704:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i30 = i4 & 2;
        if (i30 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = modifier;
            i5 |= startRestartGroup.changed(obj) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
                i7 = i4 & 8;
                int i31 = 1024;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                            obj2 = horizontal;
                        } else {
                            Object obj6 = horizontal;
                            obj2 = obj6;
                            if ((i2 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(obj6) ? 1048576 : 524288;
                                obj2 = obj6;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & 128) == 0) {
                                obj4 = targetedFlingBehavior;
                                if (startRestartGroup.changed(obj4)) {
                                    i29 = 8388608;
                                    obj5 = obj4;
                                    i5 |= i29;
                                    obj3 = obj5;
                                }
                            } else {
                                obj4 = targetedFlingBehavior;
                            }
                            i29 = 4194304;
                            obj5 = obj4;
                            i5 |= i29;
                            obj3 = obj5;
                        } else {
                            obj3 = targetedFlingBehavior;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & 2048) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i28 = 32;
                                i17 |= i28;
                            }
                            i28 = 16;
                            i17 |= i28;
                        } else {
                            i18 = i16;
                        }
                        int i32 = i17;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                            i20 = i32 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            i20 = i32;
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i20 |= startRestartGroup.changed(snapPosition) ? 256 : 128;
                                if ((i3 & 3072) == 0) {
                                    if ((i4 & 8192) == 0 && startRestartGroup.changed(overscrollEffect)) {
                                        i31 = 2048;
                                    }
                                    i20 |= i31;
                                }
                                i21 = i20;
                                if ((i4 & 16384) == 0) {
                                    i21 |= 24576;
                                } else if ((i3 & 24576) == 0) {
                                    i21 |= startRestartGroup.changedInstance(function4) ? 16384 : 8192;
                                    if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                                        startRestartGroup.startDefaults();
                                        ComposerKt.sourceInformation(startRestartGroup, "250@13920L28,255@14144L55,257@14296L26");
                                        if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                            Modifier.Companion companion = i30 != 0 ? Modifier.Companion : obj;
                                            PaddingValues m731PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : paddingValues;
                                            PageSize.Fill fill = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                            int i33 = i8 != 0 ? 0 : i9;
                                            float m6684constructorimpl = i10 != 0 ? Dp.m6684constructorimpl(0) : f2;
                                            if (i11 != 0) {
                                                obj2 = Alignment.Companion.getCenterHorizontally();
                                            }
                                            if ((i4 & 128) != 0) {
                                                i22 = i19;
                                                i23 = i21;
                                                pagerState2 = pagerState;
                                                i15 &= -29360129;
                                                r4 = 0;
                                                obj3 = PagerDefaults.INSTANCE.flingBehavior(pagerState2, null, null, null, 0.0f, startRestartGroup, (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                            } else {
                                                pagerState2 = pagerState;
                                                r4 = 0;
                                                i22 = i19;
                                                i23 = i21;
                                            }
                                            boolean z7 = i12 == 0 ? z : true;
                                            boolean z8 = i14 != 0 ? r4 : z2;
                                            Function1<? super Integer, ? extends Object> function14 = i18 != 0 ? null : function1;
                                            if ((i4 & 2048) != 0) {
                                                nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Vertical, startRestartGroup, (i15 & 14) | 432);
                                                i24 = i23 & (-113);
                                            } else {
                                                nestedScrollConnection3 = nestedScrollConnection;
                                                i24 = i23;
                                            }
                                            SnapPosition.Start start = i22 != 0 ? SnapPosition.Start.INSTANCE : snapPosition;
                                            if ((i4 & 8192) != 0) {
                                                SnapPosition snapPosition4 = start;
                                                overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, r4);
                                                i25 = i24 & (-7169);
                                                targetedFlingBehavior3 = obj3;
                                                snapPosition3 = snapPosition4;
                                                function13 = function14;
                                                nestedScrollConnection4 = nestedScrollConnection3;
                                                composer2 = startRestartGroup;
                                                paddingValues3 = m731PaddingValues0680j_4;
                                                horizontal3 = obj2;
                                                pageSize3 = fill;
                                                z5 = z7;
                                                i26 = i33;
                                                f4 = m6684constructorimpl;
                                                i27 = i15;
                                                z6 = z8;
                                                modifier3 = companion;
                                            } else {
                                                function13 = function14;
                                                nestedScrollConnection4 = nestedScrollConnection3;
                                                i25 = i24;
                                                composer2 = startRestartGroup;
                                                paddingValues3 = m731PaddingValues0680j_4;
                                                horizontal3 = obj2;
                                                targetedFlingBehavior3 = obj3;
                                                pageSize3 = fill;
                                                z5 = z7;
                                                i26 = i33;
                                                f4 = m6684constructorimpl;
                                                i27 = i15;
                                                z6 = z8;
                                                snapPosition3 = start;
                                                modifier3 = companion;
                                                overscrollEffect3 = overscrollEffect;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i4 & 128) != 0) {
                                                i15 &= -29360129;
                                            }
                                            if ((i4 & 2048) != 0) {
                                                i21 &= -113;
                                            }
                                            if ((i4 & 8192) != 0) {
                                                i21 &= -7169;
                                            }
                                            paddingValues3 = paddingValues;
                                            pageSize3 = pageSize;
                                            z6 = z2;
                                            function13 = function1;
                                            nestedScrollConnection4 = nestedScrollConnection;
                                            i25 = i21;
                                            composer2 = startRestartGroup;
                                            f4 = f2;
                                            modifier3 = obj;
                                            horizontal3 = obj2;
                                            i27 = i15;
                                            z5 = z;
                                            overscrollEffect3 = overscrollEffect;
                                            i26 = i9;
                                            targetedFlingBehavior3 = obj3;
                                            snapPosition3 = snapPosition;
                                        }
                                        composer2.endDefaults();
                                        Modifier modifier4 = modifier3;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(632853564, i27, i25, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:259)");
                                        }
                                        int i34 = i25;
                                        int i35 = i27 >> 6;
                                        int i36 = ((i27 >> 3) & 14) | 24576 | ((i27 << 3) & 112) | (i27 & 896) | ((i27 >> 18) & 7168) | (i35 & 458752) | (i35 & 3670016) | ((i34 << 12) & 29360128);
                                        int i37 = i27 << 12;
                                        int i38 = i36 | (i37 & 234881024) | (i37 & 1879048192);
                                        int i39 = i27 >> 9;
                                        int i40 = i34 << 6;
                                        PaddingValues paddingValues4 = paddingValues3;
                                        LazyLayoutPagerKt.m979PagereLwUrMk(modifier4, pagerState, paddingValues4, z6, Orientation.Vertical, targetedFlingBehavior3, z5, overscrollEffect3, i26, f4, pageSize3, nestedScrollConnection4, function13, horizontal3, Alignment.Companion.getCenterVertically(), snapPosition3, function4, composer2, i38, (i39 & 7168) | (i40 & 896) | (i39 & 14) | 24576 | (i34 & 112) | ((i34 << 9) & 458752) | (i40 & 3670016), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        int i41 = i26;
                                        targetedFlingBehavior2 = targetedFlingBehavior3;
                                        i9 = i41;
                                        float f5 = f4;
                                        z3 = z5;
                                        f3 = f5;
                                        Function1<? super Integer, ? extends Object> function15 = function13;
                                        nestedScrollConnection2 = nestedScrollConnection4;
                                        function12 = function15;
                                        overscrollEffect2 = overscrollEffect3;
                                        pageSize2 = pageSize3;
                                        horizontal2 = horizontal3;
                                        snapPosition2 = snapPosition3;
                                        z4 = z6;
                                        paddingValues2 = paddingValues4;
                                        modifier2 = modifier4;
                                    } else {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        paddingValues2 = paddingValues;
                                        pageSize2 = pageSize;
                                        z3 = z;
                                        z4 = z2;
                                        function12 = function1;
                                        nestedScrollConnection2 = nestedScrollConnection;
                                        snapPosition2 = snapPosition;
                                        f3 = f2;
                                        modifier2 = obj;
                                        horizontal2 = obj2;
                                        targetedFlingBehavior2 = obj3;
                                        overscrollEffect2 = overscrollEffect;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$VerticalPager$1
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

                                            public final void invoke(Composer composer3, int i42) {
                                                PagerKt.m985VerticalPager8jOkeI(PagerState.this, modifier2, paddingValues2, pageSize2, i9, f3, horizontal2, targetedFlingBehavior2, z3, z4, function12, nestedScrollConnection2, snapPosition2, overscrollEffect2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        i21 = i20;
                        if ((i4 & 16384) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i322 = i17;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    i21 = i20;
                    if ((i4 & 16384) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i3222 = i17;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                i21 = i20;
                if ((i4 & 16384) == 0) {
                }
                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 8;
            int i312 = 1024;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i32222 = i17;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            i21 = i20;
            if ((i4 & 16384) == 0) {
            }
            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i3122 = 1024;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i322222 = i17;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        i21 = i20;
        if ((i4 & 16384) == 0) {
        }
        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:252:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:451:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* renamed from: VerticalPager-oI3XNZo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m986VerticalPageroI3XNZo(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, final Function4 function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        int i7;
        int i8;
        final int i9;
        int i10;
        final float f2;
        int i11;
        Object obj2;
        Object obj3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        final PaddingValues paddingValues2;
        final PageSize pageSize2;
        final boolean z3;
        final boolean z4;
        final Function1 function12;
        final NestedScrollConnection nestedScrollConnection2;
        final Modifier modifier2;
        final Alignment.Horizontal horizontal2;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final SnapPosition snapPosition2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        int i21;
        PagerState pagerState2;
        int i22;
        Composer composer2;
        int i23;
        NestedScrollConnection nestedScrollConnection3;
        SnapPosition.Start start;
        boolean z5;
        Function1 function13;
        NestedScrollConnection nestedScrollConnection4;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        boolean z6;
        float f3;
        PaddingValues paddingValues3;
        int i24;
        int i25;
        int i26;
        Composer startRestartGroup = composer.startRestartGroup(909160706);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalPager)P(12,5,1,8!1,9:c#ui.unit.Dp,3!1,13,10!1,7,11)314@16560L26,300@16005L622:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i27 = i4 & 2;
        if (i27 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = modifier;
            i5 |= startRestartGroup.changed(obj) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                            obj2 = horizontal;
                        } else {
                            obj2 = horizontal;
                            if ((i2 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(obj2) ? 1048576 : 524288;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & 128) == 0) {
                                obj3 = targetedFlingBehavior;
                                if (startRestartGroup.changed(obj3)) {
                                    i26 = 8388608;
                                    i5 |= i26;
                                }
                            } else {
                                obj3 = targetedFlingBehavior;
                            }
                            i26 = 4194304;
                            i5 |= i26;
                        } else {
                            obj3 = targetedFlingBehavior;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & 2048) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i25 = 32;
                                i17 |= i25;
                            }
                            i25 = 16;
                            i17 |= i25;
                        } else {
                            i18 = i16;
                        }
                        int i28 = i17;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                            i20 = i28 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            int i29 = i28;
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i29 |= startRestartGroup.changed(snapPosition) ? 256 : 128;
                            }
                            i20 = i29;
                        }
                        if ((i4 & 8192) != 0) {
                            i20 |= 3072;
                        } else if ((i3 & 3072) == 0) {
                            i20 |= startRestartGroup.changedInstance(function4) ? 2048 : 1024;
                            if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "291@15603L28,296@15827L55");
                                if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i27 != 0 ? Modifier.Companion : obj;
                                    PaddingValues m731PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : paddingValues;
                                    PageSize.Fill fill = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                    i21 = i8 != 0 ? 0 : i9;
                                    float m6684constructorimpl = i10 != 0 ? Dp.m6684constructorimpl(0) : f2;
                                    if (i11 != 0) {
                                        obj2 = Alignment.Companion.getCenterHorizontally();
                                    }
                                    if ((i4 & 128) != 0) {
                                        composer2 = startRestartGroup;
                                        i23 = i20;
                                        pagerState2 = pagerState;
                                        i15 &= -29360129;
                                        i22 = 0;
                                        obj3 = PagerDefaults.INSTANCE.flingBehavior(pagerState2, null, null, null, 0.0f, composer2, (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                    } else {
                                        pagerState2 = pagerState;
                                        i22 = 0;
                                        composer2 = startRestartGroup;
                                        i23 = i20;
                                    }
                                    boolean z7 = i12 == 0 ? z : true;
                                    boolean z8 = i14 != 0 ? i22 == 1 ? 1 : 0 : z2;
                                    Function1 function14 = i18 != 0 ? null : function1;
                                    if ((i4 & 2048) != 0) {
                                        nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Vertical, composer2, (i15 & 14) | 432);
                                        i23 &= -113;
                                    } else {
                                        nestedScrollConnection3 = nestedScrollConnection;
                                    }
                                    if (i19 != 0) {
                                        z5 = z8;
                                        function13 = function14;
                                        nestedScrollConnection4 = nestedScrollConnection3;
                                        start = SnapPosition.Start.INSTANCE;
                                    } else {
                                        start = snapPosition;
                                        z5 = z8;
                                        function13 = function14;
                                        nestedScrollConnection4 = nestedScrollConnection3;
                                    }
                                    targetedFlingBehavior3 = obj3;
                                    i20 = i23;
                                    pageSize3 = fill;
                                    z6 = z7;
                                    f3 = m6684constructorimpl;
                                    paddingValues3 = m731PaddingValues0680j_4;
                                    i24 = i15;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & 128) != 0) {
                                        i15 &= -29360129;
                                    }
                                    if ((i4 & 2048) != 0) {
                                        i20 &= -113;
                                    }
                                    pagerState2 = pagerState;
                                    paddingValues3 = paddingValues;
                                    z6 = z;
                                    z5 = z2;
                                    function13 = function1;
                                    nestedScrollConnection4 = nestedScrollConnection;
                                    start = snapPosition;
                                    i22 = 0;
                                    i21 = i9;
                                    f3 = f2;
                                    companion = obj;
                                    targetedFlingBehavior3 = obj3;
                                    composer2 = startRestartGroup;
                                    i24 = i15;
                                    pageSize3 = pageSize;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(909160706, i24, i20, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:299)");
                                    i22 = 0;
                                }
                                int i30 = (i20 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i20 << 3) & 57344);
                                PagerState pagerState3 = pagerState2;
                                startRestartGroup = composer2;
                                Alignment.Horizontal horizontal3 = obj2;
                                Modifier modifier3 = companion;
                                int i31 = i21;
                                m985VerticalPager8jOkeI(pagerState3, modifier3, paddingValues3, pageSize3, i31, f3, horizontal3, targetedFlingBehavior3, z6, z5, function13, nestedScrollConnection4, start, OverscrollKt.rememberOverscrollEffect(composer2, i22), function4, startRestartGroup, i24 & 2147483646, i30, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                snapPosition2 = start;
                                nestedScrollConnection2 = nestedScrollConnection4;
                                function12 = function13;
                                z4 = z5;
                                z3 = z6;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                horizontal2 = horizontal3;
                                f2 = f3;
                                i9 = i31;
                                pageSize2 = pageSize3;
                                paddingValues2 = paddingValues3;
                                modifier2 = modifier3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                paddingValues2 = paddingValues;
                                pageSize2 = pageSize;
                                z3 = z;
                                z4 = z2;
                                function12 = function1;
                                nestedScrollConnection2 = nestedScrollConnection;
                                modifier2 = obj;
                                horizontal2 = obj2;
                                targetedFlingBehavior2 = obj3;
                                snapPosition2 = snapPosition;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$VerticalPager$2
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

                                    public final void invoke(Composer composer3, int i32) {
                                        PagerKt.m986VerticalPageroI3XNZo(PagerState.this, modifier2, paddingValues2, pageSize2, i9, f2, horizontal2, targetedFlingBehavior2, z3, z4, function12, nestedScrollConnection2, snapPosition2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i282 = i17;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    if ((i4 & 8192) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i2822 = i17;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                if ((i4 & 8192) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i28222 = i17;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            if ((i4 & 8192) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i282222 = i17;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        if ((i4 & 8192) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i20 & 1171) != 1170, i15 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final int currentPageOffset(SnapPosition snapPosition, int i, int i2, int i3, int i4, int i5, int i6, float f, int i7) {
        return MathKt.roundToInt(snapPosition.position(i, i2, i4, i5, i6, i7) - (f * (i2 + i3)));
    }

    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (pagerState.getCanScrollForward()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, null);
            return true;
        }
        return false;
    }

    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (pagerState.getCanScrollBackward()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, null), 3, null);
            return true;
        }
        return false;
    }

    public static final Modifier pagerSemantics(Modifier modifier, final PagerState pagerState, final boolean z, final CoroutineScope coroutineScope, boolean z2) {
        if (z2) {
            return modifier.then(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1
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
                    if (z) {
                        final PagerState pagerState2 = pagerState;
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                boolean pagerSemantics$performBackwardPaging;
                                pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope2);
                                return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                            }
                        }, 1, null);
                        final PagerState pagerState3 = pagerState;
                        final CoroutineScope coroutineScope3 = coroutineScope;
                        SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                boolean pagerSemantics$performForwardPaging;
                                pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope3);
                                return Boolean.valueOf(pagerSemantics$performForwardPaging);
                            }
                        }, 1, null);
                        return;
                    }
                    final PagerState pagerState4 = pagerState;
                    final CoroutineScope coroutineScope4 = coroutineScope;
                    SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performBackwardPaging;
                            pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope4);
                            return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                        }
                    }, 1, null);
                    final PagerState pagerState5 = pagerState;
                    final CoroutineScope coroutineScope5 = coroutineScope;
                    SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performForwardPaging;
                            pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope5);
                            return Boolean.valueOf(pagerSemantics$performForwardPaging);
                        }
                    }, 1, null);
                }
            }, 1, null));
        }
        return modifier.then(Modifier.Companion);
    }
}
