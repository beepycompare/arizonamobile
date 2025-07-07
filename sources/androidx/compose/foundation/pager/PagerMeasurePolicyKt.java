package androidx.compose.foundation.pager;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: PagerMeasurePolicy.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¡\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"rememberPagerMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasurePolicyKt {
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0135, code lost:
        if (r34.changed(r3) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        if (r34.changed(r4) == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
        if (r34.changed(r9) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
        if (r34.changed(r12) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cd, code lost:
        if (r34.changed(r13) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e9, code lost:
        if (r34.changed(r14) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0102, code lost:
        if (r34.changed(r5) == false) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012f  */
    /* renamed from: rememberPagerMeasurePolicy-8u0NR3k  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> m991rememberPagerMeasurePolicy8u0NR3k(final Function0<PagerLazyLayoutItemProvider> function0, final PagerState pagerState, final PaddingValues paddingValues, final boolean z, Orientation orientation, int i, float f, PageSize pageSize, Alignment.Horizontal horizontal, Alignment.Vertical vertical, SnapPosition snapPosition, final CoroutineScope coroutineScope, final Function0<Integer> function02, Composer composer, int i2, int i3) {
        Object obj;
        boolean z2;
        Object obj2;
        boolean z3;
        Object obj3;
        boolean z4;
        float f2;
        boolean z5;
        Object obj4;
        boolean z6;
        Object obj5;
        boolean z7;
        int i4;
        boolean z8;
        boolean changed;
        Object rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, 1391419623, "C(rememberPagerMeasurePolicy)P(4,11,1,9,5!1,8:c#ui.unit.Dp,7,3,12,10)57@2305L7411:PagerMeasurePolicy.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1391419623, i2, i3, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:57)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 35233522, "CC(remember):PagerMeasurePolicy.kt#9igjgp");
        boolean z9 = ((((i2 & 112) ^ 48) > 32 && composer.changed(pagerState)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(paddingValues)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i2 & 3072) == 2048);
        if (((57344 & i2) ^ 24576) > 16384) {
            obj = orientation;
        } else {
            obj = orientation;
        }
        if ((i2 & 24576) != 16384) {
            z2 = false;
            boolean z10 = z9 | z2;
            if (((234881024 & i2) ^ 100663296) <= 67108864) {
                obj2 = horizontal;
            } else {
                obj2 = horizontal;
            }
            if ((100663296 & i2) != 67108864) {
                z3 = false;
                boolean z11 = z10 | z3;
                if (((1879048192 & i2) ^ 805306368) > 536870912) {
                    obj3 = vertical;
                } else {
                    obj3 = vertical;
                }
                if ((805306368 & i2) != 536870912) {
                    z4 = false;
                    boolean z12 = z11 | z4;
                    if (((3670016 & i2) ^ 1572864) <= 1048576) {
                        f2 = f;
                    } else {
                        f2 = f;
                    }
                    if ((1572864 & i2) != 1048576) {
                        z5 = false;
                        boolean z13 = z12 | z5;
                        if (((29360128 & i2) ^ 12582912) > 8388608) {
                            obj4 = pageSize;
                        } else {
                            obj4 = pageSize;
                        }
                        if ((12582912 & i2) != 8388608) {
                            z6 = false;
                            boolean z14 = z13 | z6;
                            if (((i3 & 14) ^ 6) <= 4) {
                                obj5 = snapPosition;
                            } else {
                                obj5 = snapPosition;
                            }
                            if ((i3 & 6) != 4) {
                                z7 = false;
                                boolean z15 = ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 && composer.changed(function02)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | z14 | z7;
                                if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
                                    i4 = i;
                                } else {
                                    i4 = i;
                                }
                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
                                    z8 = false;
                                    changed = z15 | z8 | composer.changed(coroutineScope);
                                    rememberedValue = composer.rememberedValue();
                                    if (!changed || rememberedValue == Composer.Companion.getEmpty()) {
                                        final int i5 = i4;
                                        final SnapPosition snapPosition2 = obj5;
                                        final Alignment.Horizontal horizontal2 = obj2;
                                        final Alignment.Vertical vertical2 = obj3;
                                        final float f3 = f2;
                                        final PageSize pageSize2 = obj4;
                                        final Orientation orientation2 = obj;
                                        rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                                return m992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                                            }

                                            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                            public final PagerMeasureResult m992invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                                int i6;
                                                int i7;
                                                int i8;
                                                int m6637getMaxWidthimpl;
                                                int i9;
                                                long m6806constructorimpl;
                                                ObservableScopeInvalidator.m918attachToScopeimpl(PagerState.this.m993getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                                boolean z16 = orientation2 == Orientation.Vertical;
                                                CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                                                if (z16) {
                                                    i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                                } else {
                                                    i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                                }
                                                if (z16) {
                                                    i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                                } else {
                                                    i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                                }
                                                int i10 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                                                int i11 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                                                int i12 = i7;
                                                int i13 = i10 + i11;
                                                final int i14 = i6 + i12;
                                                int i15 = z16 ? i13 : i14;
                                                if (z16 && !z) {
                                                    i8 = i10;
                                                } else if (z16 && z) {
                                                    i8 = i11;
                                                } else {
                                                    i8 = (z16 || z) ? i12 : i6;
                                                }
                                                int i16 = i15 - i8;
                                                long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i14, -i13);
                                                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                                                PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                                                int i17 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(f3);
                                                if (z16) {
                                                    m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i13;
                                                } else {
                                                    m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i14;
                                                }
                                                if (!z || m6637getMaxWidthimpl > 0) {
                                                    i9 = i13;
                                                    m6806constructorimpl = IntOffset.m6806constructorimpl((i6 << 32) | (i10 & 4294967295L));
                                                } else {
                                                    if (!z16) {
                                                        i6 += m6637getMaxWidthimpl;
                                                    }
                                                    if (z16) {
                                                        i10 += m6637getMaxWidthimpl;
                                                    }
                                                    i9 = i13;
                                                    m6806constructorimpl = IntOffset.m6806constructorimpl((i10 & 4294967295L) | (i6 << 32));
                                                }
                                                int coerceAtLeast = RangesKt.coerceAtLeast(pageSize2.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m6637getMaxWidthimpl, i17), 0);
                                                PagerState.this.m997setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation2 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU) : coerceAtLeast, 0, orientation2 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU) : coerceAtLeast, 5, null));
                                                PagerLazyLayoutItemProvider invoke = function0.invoke();
                                                int i18 = m6637getMaxWidthimpl + i8 + i16;
                                                Snapshot.Companion companion = Snapshot.Companion;
                                                PagerState pagerState2 = PagerState.this;
                                                long j2 = m6806constructorimpl;
                                                SnapPosition snapPosition3 = snapPosition2;
                                                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                                try {
                                                    int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                                    int i19 = m6637getMaxWidthimpl;
                                                    int currentPageOffset = PagerKt.currentPageOffset(snapPosition3, i18, coerceAtLeast, i17, i8, i16, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                                    Unit unit = Unit.INSTANCE;
                                                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                    final int i20 = i9;
                                                    PagerMeasureResult m990measurePagerbmk8ZPk = PagerMeasureKt.m990measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, i19, i8, i16, i17, matchScrollPositionWithKey$foundation_release, currentPageOffset, m6656offsetNN6EwU, orientation2, vertical2, horizontal2, z, j2, coerceAtLeast, i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages$foundation_release(), PagerState.this.getBeyondBoundsInfo$foundation_release()), snapPosition2, PagerState.this.m994getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                                        }

                                                        public final MeasureResult invoke(int i21, int i22, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i21 + i14), ConstraintsKt.m6653constrainHeightK40F9xA(j, i22 + i20), MapsKt.emptyMap(), function1);
                                                        }
                                                    });
                                                    PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m990measurePagerbmk8ZPk, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                                    return m990measurePagerbmk8ZPk;
                                                } catch (Throwable th) {
                                                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                    throw th;
                                                }
                                            }
                                        };
                                        composer.updateRememberedValue(rememberedValue);
                                    }
                                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    return function2;
                                }
                                z8 = true;
                                changed = z15 | z8 | composer.changed(coroutineScope);
                                rememberedValue = composer.rememberedValue();
                                if (!changed) {
                                }
                                final int i52 = i4;
                                final SnapPosition snapPosition22 = obj5;
                                final Alignment.Horizontal horizontal22 = obj2;
                                final Alignment.Vertical vertical22 = obj3;
                                final float f32 = f2;
                                final PageSize pageSize22 = obj4;
                                final Orientation orientation22 = obj;
                                rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                        return m992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                                    }

                                    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                    public final PagerMeasureResult m992invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                        int i6;
                                        int i7;
                                        int i8;
                                        int m6637getMaxWidthimpl;
                                        int i9;
                                        long m6806constructorimpl;
                                        ObservableScopeInvalidator.m918attachToScopeimpl(PagerState.this.m993getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                        boolean z16 = orientation22 == Orientation.Vertical;
                                        CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                                        if (z16) {
                                            i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                        } else {
                                            i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                        }
                                        if (z16) {
                                            i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                        } else {
                                            i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                        }
                                        int i10 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                                        int i11 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                                        int i12 = i7;
                                        int i13 = i10 + i11;
                                        final int i14 = i6 + i12;
                                        int i15 = z16 ? i13 : i14;
                                        if (z16 && !z) {
                                            i8 = i10;
                                        } else if (z16 && z) {
                                            i8 = i11;
                                        } else {
                                            i8 = (z16 || z) ? i12 : i6;
                                        }
                                        int i16 = i15 - i8;
                                        long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i14, -i13);
                                        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                                        PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                                        int i17 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(f32);
                                        if (z16) {
                                            m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i13;
                                        } else {
                                            m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i14;
                                        }
                                        if (!z || m6637getMaxWidthimpl > 0) {
                                            i9 = i13;
                                            m6806constructorimpl = IntOffset.m6806constructorimpl((i6 << 32) | (i10 & 4294967295L));
                                        } else {
                                            if (!z16) {
                                                i6 += m6637getMaxWidthimpl;
                                            }
                                            if (z16) {
                                                i10 += m6637getMaxWidthimpl;
                                            }
                                            i9 = i13;
                                            m6806constructorimpl = IntOffset.m6806constructorimpl((i10 & 4294967295L) | (i6 << 32));
                                        }
                                        int coerceAtLeast = RangesKt.coerceAtLeast(pageSize22.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m6637getMaxWidthimpl, i17), 0);
                                        PagerState.this.m997setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation22 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU) : coerceAtLeast, 0, orientation22 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU) : coerceAtLeast, 5, null));
                                        PagerLazyLayoutItemProvider invoke = function0.invoke();
                                        int i18 = m6637getMaxWidthimpl + i8 + i16;
                                        Snapshot.Companion companion = Snapshot.Companion;
                                        PagerState pagerState2 = PagerState.this;
                                        long j2 = m6806constructorimpl;
                                        SnapPosition snapPosition3 = snapPosition22;
                                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                        try {
                                            int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                            int i19 = m6637getMaxWidthimpl;
                                            int currentPageOffset = PagerKt.currentPageOffset(snapPosition3, i18, coerceAtLeast, i17, i8, i16, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                            Unit unit = Unit.INSTANCE;
                                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                            final int i20 = i9;
                                            PagerMeasureResult m990measurePagerbmk8ZPk = PagerMeasureKt.m990measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, i19, i8, i16, i17, matchScrollPositionWithKey$foundation_release, currentPageOffset, m6656offsetNN6EwU, orientation22, vertical22, horizontal22, z, j2, coerceAtLeast, i52, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages$foundation_release(), PagerState.this.getBeyondBoundsInfo$foundation_release()), snapPosition22, PagerState.this.m994getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                                }

                                                public final MeasureResult invoke(int i21, int i22, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i21 + i14), ConstraintsKt.m6653constrainHeightK40F9xA(j, i22 + i20), MapsKt.emptyMap(), function1);
                                                }
                                            });
                                            PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m990measurePagerbmk8ZPk, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                            return m990measurePagerbmk8ZPk;
                                        } catch (Throwable th) {
                                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                            throw th;
                                        }
                                    }
                                };
                                composer.updateRememberedValue(rememberedValue);
                                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                return function22;
                            }
                            z7 = true;
                            boolean z152 = ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 && composer.changed(function02)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | z14 | z7;
                            if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
                            }
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
                            }
                            z8 = true;
                            changed = z152 | z8 | composer.changed(coroutineScope);
                            rememberedValue = composer.rememberedValue();
                            if (!changed) {
                            }
                            final int i522 = i4;
                            final SnapPosition snapPosition222 = obj5;
                            final Alignment.Horizontal horizontal222 = obj2;
                            final Alignment.Vertical vertical222 = obj3;
                            final float f322 = f2;
                            final PageSize pageSize222 = obj4;
                            final Orientation orientation222 = obj;
                            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                    return m992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                                }

                                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                public final PagerMeasureResult m992invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                    int i6;
                                    int i7;
                                    int i8;
                                    int m6637getMaxWidthimpl;
                                    int i9;
                                    long m6806constructorimpl;
                                    ObservableScopeInvalidator.m918attachToScopeimpl(PagerState.this.m993getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                    boolean z16 = orientation222 == Orientation.Vertical;
                                    CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                                    if (z16) {
                                        i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                    } else {
                                        i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    }
                                    if (z16) {
                                        i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                    } else {
                                        i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    }
                                    int i10 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                                    int i11 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                                    int i12 = i7;
                                    int i13 = i10 + i11;
                                    final int i14 = i6 + i12;
                                    int i15 = z16 ? i13 : i14;
                                    if (z16 && !z) {
                                        i8 = i10;
                                    } else if (z16 && z) {
                                        i8 = i11;
                                    } else {
                                        i8 = (z16 || z) ? i12 : i6;
                                    }
                                    int i16 = i15 - i8;
                                    long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i14, -i13);
                                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                                    PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                                    int i17 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(f322);
                                    if (z16) {
                                        m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i13;
                                    } else {
                                        m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i14;
                                    }
                                    if (!z || m6637getMaxWidthimpl > 0) {
                                        i9 = i13;
                                        m6806constructorimpl = IntOffset.m6806constructorimpl((i6 << 32) | (i10 & 4294967295L));
                                    } else {
                                        if (!z16) {
                                            i6 += m6637getMaxWidthimpl;
                                        }
                                        if (z16) {
                                            i10 += m6637getMaxWidthimpl;
                                        }
                                        i9 = i13;
                                        m6806constructorimpl = IntOffset.m6806constructorimpl((i10 & 4294967295L) | (i6 << 32));
                                    }
                                    int coerceAtLeast = RangesKt.coerceAtLeast(pageSize222.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m6637getMaxWidthimpl, i17), 0);
                                    PagerState.this.m997setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation222 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU) : coerceAtLeast, 0, orientation222 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU) : coerceAtLeast, 5, null));
                                    PagerLazyLayoutItemProvider invoke = function0.invoke();
                                    int i18 = m6637getMaxWidthimpl + i8 + i16;
                                    Snapshot.Companion companion = Snapshot.Companion;
                                    PagerState pagerState2 = PagerState.this;
                                    long j2 = m6806constructorimpl;
                                    SnapPosition snapPosition3 = snapPosition222;
                                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                    try {
                                        int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                        int i19 = m6637getMaxWidthimpl;
                                        int currentPageOffset = PagerKt.currentPageOffset(snapPosition3, i18, coerceAtLeast, i17, i8, i16, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                        Unit unit = Unit.INSTANCE;
                                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                        final int i20 = i9;
                                        PagerMeasureResult m990measurePagerbmk8ZPk = PagerMeasureKt.m990measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, i19, i8, i16, i17, matchScrollPositionWithKey$foundation_release, currentPageOffset, m6656offsetNN6EwU, orientation222, vertical222, horizontal222, z, j2, coerceAtLeast, i522, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages$foundation_release(), PagerState.this.getBeyondBoundsInfo$foundation_release()), snapPosition222, PagerState.this.m994getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                            }

                                            public final MeasureResult invoke(int i21, int i22, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i21 + i14), ConstraintsKt.m6653constrainHeightK40F9xA(j, i22 + i20), MapsKt.emptyMap(), function1);
                                            }
                                        });
                                        PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m990measurePagerbmk8ZPk, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                        return m990measurePagerbmk8ZPk;
                                    } catch (Throwable th) {
                                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                        throw th;
                                    }
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222 = (Function2) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            return function222;
                        }
                        z6 = true;
                        boolean z142 = z13 | z6;
                        if (((i3 & 14) ^ 6) <= 4) {
                        }
                        if ((i3 & 6) != 4) {
                        }
                        z7 = true;
                        boolean z1522 = ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 && composer.changed(function02)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | z142 | z7;
                        if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
                        }
                        z8 = true;
                        changed = z1522 | z8 | composer.changed(coroutineScope);
                        rememberedValue = composer.rememberedValue();
                        if (!changed) {
                        }
                        final int i5222 = i4;
                        final SnapPosition snapPosition2222 = obj5;
                        final Alignment.Horizontal horizontal2222 = obj2;
                        final Alignment.Vertical vertical2222 = obj3;
                        final float f3222 = f2;
                        final PageSize pageSize2222 = obj4;
                        final Orientation orientation2222 = obj;
                        rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                return m992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                            }

                            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                            public final PagerMeasureResult m992invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                int i6;
                                int i7;
                                int i8;
                                int m6637getMaxWidthimpl;
                                int i9;
                                long m6806constructorimpl;
                                ObservableScopeInvalidator.m918attachToScopeimpl(PagerState.this.m993getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                boolean z16 = orientation2222 == Orientation.Vertical;
                                CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                                if (z16) {
                                    i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                } else {
                                    i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                }
                                if (z16) {
                                    i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                } else {
                                    i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                }
                                int i10 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                                int i11 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                                int i12 = i7;
                                int i13 = i10 + i11;
                                final int i14 = i6 + i12;
                                int i15 = z16 ? i13 : i14;
                                if (z16 && !z) {
                                    i8 = i10;
                                } else if (z16 && z) {
                                    i8 = i11;
                                } else {
                                    i8 = (z16 || z) ? i12 : i6;
                                }
                                int i16 = i15 - i8;
                                long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i14, -i13);
                                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                                PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                                int i17 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(f3222);
                                if (z16) {
                                    m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i13;
                                } else {
                                    m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i14;
                                }
                                if (!z || m6637getMaxWidthimpl > 0) {
                                    i9 = i13;
                                    m6806constructorimpl = IntOffset.m6806constructorimpl((i6 << 32) | (i10 & 4294967295L));
                                } else {
                                    if (!z16) {
                                        i6 += m6637getMaxWidthimpl;
                                    }
                                    if (z16) {
                                        i10 += m6637getMaxWidthimpl;
                                    }
                                    i9 = i13;
                                    m6806constructorimpl = IntOffset.m6806constructorimpl((i10 & 4294967295L) | (i6 << 32));
                                }
                                int coerceAtLeast = RangesKt.coerceAtLeast(pageSize2222.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m6637getMaxWidthimpl, i17), 0);
                                PagerState.this.m997setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation2222 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU) : coerceAtLeast, 0, orientation2222 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU) : coerceAtLeast, 5, null));
                                PagerLazyLayoutItemProvider invoke = function0.invoke();
                                int i18 = m6637getMaxWidthimpl + i8 + i16;
                                Snapshot.Companion companion = Snapshot.Companion;
                                PagerState pagerState2 = PagerState.this;
                                long j2 = m6806constructorimpl;
                                SnapPosition snapPosition3 = snapPosition2222;
                                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                try {
                                    int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                    int i19 = m6637getMaxWidthimpl;
                                    int currentPageOffset = PagerKt.currentPageOffset(snapPosition3, i18, coerceAtLeast, i17, i8, i16, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                    Unit unit = Unit.INSTANCE;
                                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                    final int i20 = i9;
                                    PagerMeasureResult m990measurePagerbmk8ZPk = PagerMeasureKt.m990measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, i19, i8, i16, i17, matchScrollPositionWithKey$foundation_release, currentPageOffset, m6656offsetNN6EwU, orientation2222, vertical2222, horizontal2222, z, j2, coerceAtLeast, i5222, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages$foundation_release(), PagerState.this.getBeyondBoundsInfo$foundation_release()), snapPosition2222, PagerState.this.m994getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                        }

                                        public final MeasureResult invoke(int i21, int i22, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i21 + i14), ConstraintsKt.m6653constrainHeightK40F9xA(j, i22 + i20), MapsKt.emptyMap(), function1);
                                        }
                                    });
                                    PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m990measurePagerbmk8ZPk, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                    return m990measurePagerbmk8ZPk;
                                } catch (Throwable th) {
                                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                    throw th;
                                }
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222 = (Function2) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return function2222;
                    }
                    z5 = true;
                    boolean z132 = z12 | z5;
                    if (((29360128 & i2) ^ 12582912) > 8388608) {
                    }
                    if ((12582912 & i2) != 8388608) {
                    }
                    z6 = true;
                    boolean z1422 = z132 | z6;
                    if (((i3 & 14) ^ 6) <= 4) {
                    }
                    if ((i3 & 6) != 4) {
                    }
                    z7 = true;
                    boolean z15222 = ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 && composer.changed(function02)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | z1422 | z7;
                    if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
                    }
                    z8 = true;
                    changed = z15222 | z8 | composer.changed(coroutineScope);
                    rememberedValue = composer.rememberedValue();
                    if (!changed) {
                    }
                    final int i52222 = i4;
                    final SnapPosition snapPosition22222 = obj5;
                    final Alignment.Horizontal horizontal22222 = obj2;
                    final Alignment.Vertical vertical22222 = obj3;
                    final float f32222 = f2;
                    final PageSize pageSize22222 = obj4;
                    final Orientation orientation22222 = obj;
                    rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                            return m992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                        }

                        /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                        public final PagerMeasureResult m992invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                            int i6;
                            int i7;
                            int i8;
                            int m6637getMaxWidthimpl;
                            int i9;
                            long m6806constructorimpl;
                            ObservableScopeInvalidator.m918attachToScopeimpl(PagerState.this.m993getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                            boolean z16 = orientation22222 == Orientation.Vertical;
                            CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                            if (z16) {
                                i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                            } else {
                                i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                            }
                            if (z16) {
                                i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                            } else {
                                i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                            }
                            int i10 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                            int i11 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                            int i12 = i7;
                            int i13 = i10 + i11;
                            final int i14 = i6 + i12;
                            int i15 = z16 ? i13 : i14;
                            if (z16 && !z) {
                                i8 = i10;
                            } else if (z16 && z) {
                                i8 = i11;
                            } else {
                                i8 = (z16 || z) ? i12 : i6;
                            }
                            int i16 = i15 - i8;
                            long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i14, -i13);
                            LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                            PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                            int i17 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(f32222);
                            if (z16) {
                                m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i13;
                            } else {
                                m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i14;
                            }
                            if (!z || m6637getMaxWidthimpl > 0) {
                                i9 = i13;
                                m6806constructorimpl = IntOffset.m6806constructorimpl((i6 << 32) | (i10 & 4294967295L));
                            } else {
                                if (!z16) {
                                    i6 += m6637getMaxWidthimpl;
                                }
                                if (z16) {
                                    i10 += m6637getMaxWidthimpl;
                                }
                                i9 = i13;
                                m6806constructorimpl = IntOffset.m6806constructorimpl((i10 & 4294967295L) | (i6 << 32));
                            }
                            int coerceAtLeast = RangesKt.coerceAtLeast(pageSize22222.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m6637getMaxWidthimpl, i17), 0);
                            PagerState.this.m997setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation22222 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU) : coerceAtLeast, 0, orientation22222 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU) : coerceAtLeast, 5, null));
                            PagerLazyLayoutItemProvider invoke = function0.invoke();
                            int i18 = m6637getMaxWidthimpl + i8 + i16;
                            Snapshot.Companion companion = Snapshot.Companion;
                            PagerState pagerState2 = PagerState.this;
                            long j2 = m6806constructorimpl;
                            SnapPosition snapPosition3 = snapPosition22222;
                            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                int i19 = m6637getMaxWidthimpl;
                                int currentPageOffset = PagerKt.currentPageOffset(snapPosition3, i18, coerceAtLeast, i17, i8, i16, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                Unit unit = Unit.INSTANCE;
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                final int i20 = i9;
                                PagerMeasureResult m990measurePagerbmk8ZPk = PagerMeasureKt.m990measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, i19, i8, i16, i17, matchScrollPositionWithKey$foundation_release, currentPageOffset, m6656offsetNN6EwU, orientation22222, vertical22222, horizontal22222, z, j2, coerceAtLeast, i52222, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages$foundation_release(), PagerState.this.getBeyondBoundsInfo$foundation_release()), snapPosition22222, PagerState.this.m994getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                    }

                                    public final MeasureResult invoke(int i21, int i22, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i21 + i14), ConstraintsKt.m6653constrainHeightK40F9xA(j, i22 + i20), MapsKt.emptyMap(), function1);
                                    }
                                });
                                PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m990measurePagerbmk8ZPk, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                return m990measurePagerbmk8ZPk;
                            } catch (Throwable th) {
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22222 = (Function2) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return function22222;
                }
                z4 = true;
                boolean z122 = z11 | z4;
                if (((3670016 & i2) ^ 1572864) <= 1048576) {
                }
                if ((1572864 & i2) != 1048576) {
                }
                z5 = true;
                boolean z1322 = z122 | z5;
                if (((29360128 & i2) ^ 12582912) > 8388608) {
                }
                if ((12582912 & i2) != 8388608) {
                }
                z6 = true;
                boolean z14222 = z1322 | z6;
                if (((i3 & 14) ^ 6) <= 4) {
                }
                if ((i3 & 6) != 4) {
                }
                z7 = true;
                boolean z152222 = ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 && composer.changed(function02)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | z14222 | z7;
                if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
                }
                z8 = true;
                changed = z152222 | z8 | composer.changed(coroutineScope);
                rememberedValue = composer.rememberedValue();
                if (!changed) {
                }
                final int i522222 = i4;
                final SnapPosition snapPosition222222 = obj5;
                final Alignment.Horizontal horizontal222222 = obj2;
                final Alignment.Vertical vertical222222 = obj3;
                final float f322222 = f2;
                final PageSize pageSize222222 = obj4;
                final Orientation orientation222222 = obj;
                rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                        return m992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                    }

                    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                    public final PagerMeasureResult m992invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                        int i6;
                        int i7;
                        int i8;
                        int m6637getMaxWidthimpl;
                        int i9;
                        long m6806constructorimpl;
                        ObservableScopeInvalidator.m918attachToScopeimpl(PagerState.this.m993getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                        boolean z16 = orientation222222 == Orientation.Vertical;
                        CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                        if (z16) {
                            i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                        } else {
                            i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        }
                        if (z16) {
                            i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                        } else {
                            i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        }
                        int i10 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                        int i11 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                        int i12 = i7;
                        int i13 = i10 + i11;
                        final int i14 = i6 + i12;
                        int i15 = z16 ? i13 : i14;
                        if (z16 && !z) {
                            i8 = i10;
                        } else if (z16 && z) {
                            i8 = i11;
                        } else {
                            i8 = (z16 || z) ? i12 : i6;
                        }
                        int i16 = i15 - i8;
                        long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i14, -i13);
                        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                        PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                        int i17 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(f322222);
                        if (z16) {
                            m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i13;
                        } else {
                            m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i14;
                        }
                        if (!z || m6637getMaxWidthimpl > 0) {
                            i9 = i13;
                            m6806constructorimpl = IntOffset.m6806constructorimpl((i6 << 32) | (i10 & 4294967295L));
                        } else {
                            if (!z16) {
                                i6 += m6637getMaxWidthimpl;
                            }
                            if (z16) {
                                i10 += m6637getMaxWidthimpl;
                            }
                            i9 = i13;
                            m6806constructorimpl = IntOffset.m6806constructorimpl((i10 & 4294967295L) | (i6 << 32));
                        }
                        int coerceAtLeast = RangesKt.coerceAtLeast(pageSize222222.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m6637getMaxWidthimpl, i17), 0);
                        PagerState.this.m997setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation222222 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU) : coerceAtLeast, 0, orientation222222 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU) : coerceAtLeast, 5, null));
                        PagerLazyLayoutItemProvider invoke = function0.invoke();
                        int i18 = m6637getMaxWidthimpl + i8 + i16;
                        Snapshot.Companion companion = Snapshot.Companion;
                        PagerState pagerState2 = PagerState.this;
                        long j2 = m6806constructorimpl;
                        SnapPosition snapPosition3 = snapPosition222222;
                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                            int i19 = m6637getMaxWidthimpl;
                            int currentPageOffset = PagerKt.currentPageOffset(snapPosition3, i18, coerceAtLeast, i17, i8, i16, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                            Unit unit = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            final int i20 = i9;
                            PagerMeasureResult m990measurePagerbmk8ZPk = PagerMeasureKt.m990measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, i19, i8, i16, i17, matchScrollPositionWithKey$foundation_release, currentPageOffset, m6656offsetNN6EwU, orientation222222, vertical222222, horizontal222222, z, j2, coerceAtLeast, i522222, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages$foundation_release(), PagerState.this.getBeyondBoundsInfo$foundation_release()), snapPosition222222, PagerState.this.m994getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i21, int i22, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i21 + i14), ConstraintsKt.m6653constrainHeightK40F9xA(j, i22 + i20), MapsKt.emptyMap(), function1);
                                }
                            });
                            PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m990measurePagerbmk8ZPk, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                            return m990measurePagerbmk8ZPk;
                        } catch (Throwable th) {
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                composer.updateRememberedValue(rememberedValue);
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222222 = (Function2) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return function222222;
            }
            z3 = true;
            boolean z112 = z10 | z3;
            if (((1879048192 & i2) ^ 805306368) > 536870912) {
            }
            if ((805306368 & i2) != 536870912) {
            }
            z4 = true;
            boolean z1222 = z112 | z4;
            if (((3670016 & i2) ^ 1572864) <= 1048576) {
            }
            if ((1572864 & i2) != 1048576) {
            }
            z5 = true;
            boolean z13222 = z1222 | z5;
            if (((29360128 & i2) ^ 12582912) > 8388608) {
            }
            if ((12582912 & i2) != 8388608) {
            }
            z6 = true;
            boolean z142222 = z13222 | z6;
            if (((i3 & 14) ^ 6) <= 4) {
            }
            if ((i3 & 6) != 4) {
            }
            z7 = true;
            boolean z1522222 = ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 && composer.changed(function02)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | z142222 | z7;
            if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
            }
            z8 = true;
            changed = z1522222 | z8 | composer.changed(coroutineScope);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            final int i5222222 = i4;
            final SnapPosition snapPosition2222222 = obj5;
            final Alignment.Horizontal horizontal2222222 = obj2;
            final Alignment.Vertical vertical2222222 = obj3;
            final float f3222222 = f2;
            final PageSize pageSize2222222 = obj4;
            final Orientation orientation2222222 = obj;
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final PagerMeasureResult m992invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i6;
                    int i7;
                    int i8;
                    int m6637getMaxWidthimpl;
                    int i9;
                    long m6806constructorimpl;
                    ObservableScopeInvalidator.m918attachToScopeimpl(PagerState.this.m993getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    boolean z16 = orientation2222222 == Orientation.Vertical;
                    CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z16) {
                        i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z16) {
                        i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i10 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                    int i11 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                    int i12 = i7;
                    int i13 = i10 + i11;
                    final int i14 = i6 + i12;
                    int i15 = z16 ? i13 : i14;
                    if (z16 && !z) {
                        i8 = i10;
                    } else if (z16 && z) {
                        i8 = i11;
                    } else {
                        i8 = (z16 || z) ? i12 : i6;
                    }
                    int i16 = i15 - i8;
                    long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i14, -i13);
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    int i17 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(f3222222);
                    if (z16) {
                        m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i13;
                    } else {
                        m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i14;
                    }
                    if (!z || m6637getMaxWidthimpl > 0) {
                        i9 = i13;
                        m6806constructorimpl = IntOffset.m6806constructorimpl((i6 << 32) | (i10 & 4294967295L));
                    } else {
                        if (!z16) {
                            i6 += m6637getMaxWidthimpl;
                        }
                        if (z16) {
                            i10 += m6637getMaxWidthimpl;
                        }
                        i9 = i13;
                        m6806constructorimpl = IntOffset.m6806constructorimpl((i10 & 4294967295L) | (i6 << 32));
                    }
                    int coerceAtLeast = RangesKt.coerceAtLeast(pageSize2222222.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m6637getMaxWidthimpl, i17), 0);
                    PagerState.this.m997setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation2222222 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU) : coerceAtLeast, 0, orientation2222222 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU) : coerceAtLeast, 5, null));
                    PagerLazyLayoutItemProvider invoke = function0.invoke();
                    int i18 = m6637getMaxWidthimpl + i8 + i16;
                    Snapshot.Companion companion = Snapshot.Companion;
                    PagerState pagerState2 = PagerState.this;
                    long j2 = m6806constructorimpl;
                    SnapPosition snapPosition3 = snapPosition2222222;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                        int i19 = m6637getMaxWidthimpl;
                        int currentPageOffset = PagerKt.currentPageOffset(snapPosition3, i18, coerceAtLeast, i17, i8, i16, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                        Unit unit = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        final int i20 = i9;
                        PagerMeasureResult m990measurePagerbmk8ZPk = PagerMeasureKt.m990measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, i19, i8, i16, i17, matchScrollPositionWithKey$foundation_release, currentPageOffset, m6656offsetNN6EwU, orientation2222222, vertical2222222, horizontal2222222, z, j2, coerceAtLeast, i5222222, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages$foundation_release(), PagerState.this.getBeyondBoundsInfo$foundation_release()), snapPosition2222222, PagerState.this.m994getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                            }

                            public final MeasureResult invoke(int i21, int i22, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i21 + i14), ConstraintsKt.m6653constrainHeightK40F9xA(j, i22 + i20), MapsKt.emptyMap(), function1);
                            }
                        });
                        PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m990measurePagerbmk8ZPk, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                        return m990measurePagerbmk8ZPk;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222222 = (Function2) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function2222222;
        }
        z2 = true;
        boolean z102 = z9 | z2;
        if (((234881024 & i2) ^ 100663296) <= 67108864) {
        }
        if ((100663296 & i2) != 67108864) {
        }
        z3 = true;
        boolean z1122 = z102 | z3;
        if (((1879048192 & i2) ^ 805306368) > 536870912) {
        }
        if ((805306368 & i2) != 536870912) {
        }
        z4 = true;
        boolean z12222 = z1122 | z4;
        if (((3670016 & i2) ^ 1572864) <= 1048576) {
        }
        if ((1572864 & i2) != 1048576) {
        }
        z5 = true;
        boolean z132222 = z12222 | z5;
        if (((29360128 & i2) ^ 12582912) > 8388608) {
        }
        if ((12582912 & i2) != 8388608) {
        }
        z6 = true;
        boolean z1422222 = z132222 | z6;
        if (((i3 & 14) ^ 6) <= 4) {
        }
        if ((i3 & 6) != 4) {
        }
        z7 = true;
        boolean z15222222 = ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 && composer.changed(function02)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | z1422222 | z7;
        if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
        }
        z8 = true;
        changed = z15222222 | z8 | composer.changed(coroutineScope);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        final int i52222222 = i4;
        final SnapPosition snapPosition22222222 = obj5;
        final Alignment.Horizontal horizontal22222222 = obj2;
        final Alignment.Vertical vertical22222222 = obj3;
        final float f32222222 = f2;
        final PageSize pageSize22222222 = obj4;
        final Orientation orientation22222222 = obj;
        rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                return m992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
            }

            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
            public final PagerMeasureResult m992invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                int i6;
                int i7;
                int i8;
                int m6637getMaxWidthimpl;
                int i9;
                long m6806constructorimpl;
                ObservableScopeInvalidator.m918attachToScopeimpl(PagerState.this.m993getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                boolean z16 = orientation22222222 == Orientation.Vertical;
                CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                if (z16) {
                    i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                } else {
                    i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                }
                if (z16) {
                    i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                } else {
                    i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                }
                int i10 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                int i11 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                int i12 = i7;
                int i13 = i10 + i11;
                final int i14 = i6 + i12;
                int i15 = z16 ? i13 : i14;
                if (z16 && !z) {
                    i8 = i10;
                } else if (z16 && z) {
                    i8 = i11;
                } else {
                    i8 = (z16 || z) ? i12 : i6;
                }
                int i16 = i15 - i8;
                long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i14, -i13);
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                int i17 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(f32222222);
                if (z16) {
                    m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i13;
                } else {
                    m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i14;
                }
                if (!z || m6637getMaxWidthimpl > 0) {
                    i9 = i13;
                    m6806constructorimpl = IntOffset.m6806constructorimpl((i6 << 32) | (i10 & 4294967295L));
                } else {
                    if (!z16) {
                        i6 += m6637getMaxWidthimpl;
                    }
                    if (z16) {
                        i10 += m6637getMaxWidthimpl;
                    }
                    i9 = i13;
                    m6806constructorimpl = IntOffset.m6806constructorimpl((i10 & 4294967295L) | (i6 << 32));
                }
                int coerceAtLeast = RangesKt.coerceAtLeast(pageSize22222222.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m6637getMaxWidthimpl, i17), 0);
                PagerState.this.m997setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation22222222 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU) : coerceAtLeast, 0, orientation22222222 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU) : coerceAtLeast, 5, null));
                PagerLazyLayoutItemProvider invoke = function0.invoke();
                int i18 = m6637getMaxWidthimpl + i8 + i16;
                Snapshot.Companion companion = Snapshot.Companion;
                PagerState pagerState2 = PagerState.this;
                long j2 = m6806constructorimpl;
                SnapPosition snapPosition3 = snapPosition22222222;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                    int i19 = m6637getMaxWidthimpl;
                    int currentPageOffset = PagerKt.currentPageOffset(snapPosition3, i18, coerceAtLeast, i17, i8, i16, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                    Unit unit = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    final int i20 = i9;
                    PagerMeasureResult m990measurePagerbmk8ZPk = PagerMeasureKt.m990measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, i19, i8, i16, i17, matchScrollPositionWithKey$foundation_release, currentPageOffset, m6656offsetNN6EwU, orientation22222222, vertical22222222, horizontal22222222, z, j2, coerceAtLeast, i52222222, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages$foundation_release(), PagerState.this.getBeyondBoundsInfo$foundation_release()), snapPosition22222222, PagerState.this.m994getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                        }

                        public final MeasureResult invoke(int i21, int i22, Function1<? super Placeable.PlacementScope, Unit> function1) {
                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i21 + i14), ConstraintsKt.m6653constrainHeightK40F9xA(j, i22 + i20), MapsKt.emptyMap(), function1);
                        }
                    });
                    PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m990measurePagerbmk8ZPk, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                    return m990measurePagerbmk8ZPk;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
        };
        composer.updateRememberedValue(rememberedValue);
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22222222 = (Function2) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function22222222;
    }
}
