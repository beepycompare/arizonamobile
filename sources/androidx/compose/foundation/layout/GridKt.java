package androidx.compose.foundation.layout;

import androidx.collection.LongList;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.foundation.layout.GridFlow;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* compiled from: Grid.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0019\b\b\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\n¢\u0006\u0002\b\u0005H\u0087\b¢\u0006\u0002\u0010\u000b\u001a%\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a5\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002\u001a]\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101\u001ak\u00102\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0014\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020(\u0018\u00010'0\u000e2\u0006\u0010+\u001a\u00020,2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010-\u001a\u00020\u001fH\u0002¢\u0006\u0004\b9\u0010:\u001as\u0010;\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0014\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020(\u0018\u00010'0\u000e2\u0006\u0010+\u001a\u00020,2\u0006\u0010=\u001a\u0002072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010/\u001a\u00020\u001fH\u0002¢\u0006\u0004\b>\u0010?\u001a0\u0010@\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0006\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020C2\u0006\u00104\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0018H\u0002\u001a\u0018\u0010D\u001a\u00020\u001f2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002\u001a\u0018\u0010F\u001a\u00020\u001f2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002\u001a(\u0010G\u001a\u00020\u001f2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010=\u001a\u0002072\u0006\u0010H\u001a\u00020\u001fH\u0002\u001a(\u0010I\u001a\u00020\u001f2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010=\u001a\u0002072\u0006\u0010H\u001a\u00020\u001fH\u0002\u001a\u0018\u0010J\u001a\u00020K2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002\u001a(\u0010L\u001a\u00020K2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010=\u001a\u0002072\u0006\u0010H\u001a\u00020\u001fH\u0002\u001aO\u0010M\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00182\u0006\u0010N\u001a\u0002072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010O\u001a\u00020P2\u0006\u0010+\u001a\u00020,2\b\u0010Q\u001a\u0004\u0018\u0001072\u0006\u0010R\u001a\u00020\u001fH\u0002¢\u0006\u0004\bS\u0010T\u001a(\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020W2\u0006\u00106\u001a\u0002072\u0006\u0010X\u001a\u0002072\u0006\u00105\u001a\u00020\u001fH\u0002\u001a&\u0010Y\u001a\u00020\u00012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010Z\u001a\u00020#2\u0006\u0010[\u001a\u00020\\H\u0002\u001a\u0018\u0010]\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010^\u001a\u00020\u001fH\u0002\u001a\"\u0010_\u001a\u0002H`\"\u0004\b\u0000\u0010`2\f\u0010a\u001a\b\u0012\u0004\u0012\u0002H`0bH\u0082\b¢\u0006\u0002\u0010c\"\u0016\u0010d\u001a\u00020e8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bf\u0010g¨\u0006h"}, d2 = {"Grid", "", "config", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/GridConfigurationScope;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/foundation/layout/GridScope;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columns", "specs", "", "Landroidx/compose/foundation/layout/GridTrackSpec;", "(Landroidx/compose/foundation/layout/GridConfigurationScope;[Landroidx/compose/foundation/layout/GridTrackSpec;)V", "rows", "resolveGridItemIndices", "Landroidx/compose/foundation/layout/ResolvedGridItemIndicesResult;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "columnSpecs", "Landroidx/collection/LongList;", "rowSpecs", "flow", "Landroidx/compose/foundation/layout/GridFlow;", "resolveGridItemIndices-pclAfdo", "(Ljava/util/List;Landroidx/collection/LongList;Landroidx/collection/LongList;I)Landroidx/compose/foundation/layout/ResolvedGridItemIndicesResult;", "resolveToZeroBasedIndex", "", FirebaseAnalytics.Param.INDEX, "maxCount", "calculateGridTrackSizes", "Landroidx/compose/foundation/layout/GridTrackSizes;", "density", "Landroidx/compose/ui/unit/Density;", "gridItems", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/foundation/layout/GridItem;", "totalColCount", "totalRowCount", "constraints", "Landroidx/compose/ui/unit/Constraints;", "columnGap", "Landroidx/compose/ui/unit/Dp;", "rowGap", "calculateGridTrackSizes-cMe430U", "(Landroidx/compose/ui/unit/Density;Landroidx/collection/MutableObjectList;Landroidx/collection/LongList;Landroidx/collection/LongList;IIJFF)Landroidx/compose/foundation/layout/GridTrackSizes;", "calculateColumnWidths", "explicitSpecs", "totalCount", "availableSpace", "outSizes", "", "itemsByColumn", "calculateColumnWidths-O3s9Psw", "(Landroidx/compose/ui/unit/Density;Landroidx/collection/LongList;II[I[Landroidx/collection/MutableObjectList;JLandroidx/collection/MutableObjectList;I)I", "calculateRowHeights", "itemsByRow", "columnWidths", "calculateRowHeights-ESwBiLc", "(Landroidx/compose/ui/unit/Density;Landroidx/collection/LongList;II[I[Landroidx/collection/MutableObjectList;J[ILandroidx/collection/MutableObjectList;I)I", "distributeFlexSpaceAndGetTotal", "availableTrackSpace", "totalFlex", "", "calculateMaxIntrinsicWidth", "items", "calculateMinIntrinsicWidth", "calculateMaxIntrinsicHeight", "fallbackWidth", "calculateMinIntrinsicHeight", "calculateMinMaxIntrinsicWidth", "", "calculateMinMaxIntrinsicHeight", "distributeSpanningSpace", "sizes", "isRowAxis", "", "crossAxisSizes", "gap", "distributeSpanningSpace-WeOhcdQ", "(Landroidx/collection/LongList;[ILandroidx/collection/MutableObjectList;ZJ[II)V", "expandAutoTracks", "autoTrackIndices", "Landroidx/collection/MutableIntList;", "maxSizes", "measureItems", "trackSizes", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateTrackOffsets", "gapPx", "wrapIntrinsicException", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "SubcomposeLayoutIntrinsicErrorMessage", "", "getSubcomposeLayoutIntrinsicErrorMessage$annotations", "()V", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GridKt {
    public static final String SubcomposeLayoutIntrinsicErrorMessage = "Grid intrinsic measurement failed because a SubcomposeLayout (e.g., LazyColumn or LazyRow) was placed inside a track that queries its intrinsic measurements (like `Auto` or `Flex`).\n\nTo fix this, change the track definition to `GridTrackSize.MinMax(min = 0.dp, max = 1.fr)` (or your desired flex weight for max) to explicitly set a minimum base size and bypass the intrinsic measurement pass.";

    public static /* synthetic */ void getSubcomposeLayoutIntrinsicErrorMessage$annotations() {
    }

    private static final int resolveGridItemIndices_pclAfdo$packCoordinate(int i, int i2) {
        return (i << 16) | (i2 & 65535);
    }

    private static final int resolveToZeroBasedIndex(int i, int i2) {
        if (i == 0) {
            return -1;
        }
        if (i > 0) {
            return i - 1;
        }
        int i3 = i2 + i;
        if (i3 >= 0) {
            return i3;
        }
        return -1;
    }

    public static final void Grid(Function1<? super GridConfigurationScope, Unit> function1, Modifier modifier, Function3<? super GridScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1588403050, "CC(Grid)N(config,modifier,content)98@4389L28,104@4693L45,106@4744L132:Grid.kt#2w3rfo");
        if ((i2 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1741961271, "CC(remember):Grid.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GridMeasurePolicy(rememberUpdatedState);
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        GridMeasurePolicy gridMeasurePolicy = (GridMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
        Updater.m4475setimpl(m4467constructorimpl, gridMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 83312277, "C107@4790L9:Grid.kt#2w3rfo");
        function3.invoke(GridScopeInstance.INSTANCE, composer, Integer.valueOf(((i >> 3) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void columns(GridConfigurationScope gridConfigurationScope, GridTrackSpec... gridTrackSpecArr) {
        for (GridTrackSpec gridTrackSpec : gridTrackSpecArr) {
            if (gridTrackSpec instanceof GridTrackSize) {
                gridConfigurationScope.mo940column118E5d0(((GridTrackSize) gridTrackSpec).m988unboximpl());
            }
        }
    }

    public static final void rows(GridConfigurationScope gridConfigurationScope, GridTrackSpec... gridTrackSpecArr) {
        for (GridTrackSpec gridTrackSpec : gridTrackSpecArr) {
            if (gridTrackSpec instanceof GridTrackSize) {
                gridConfigurationScope.mo952row118E5d0(((GridTrackSize) gridTrackSpec).m988unboximpl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019f  */
    /* renamed from: resolveGridItemIndices-pclAfdo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ResolvedGridItemIndicesResult m977resolveGridItemIndicespclAfdo(List<? extends Measurable> list, LongList longList, LongList longList2, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        List<? extends Measurable> list2 = list;
        MutableObjectList mutableObjectList = new MutableObjectList(list2.size());
        int i9 = 0;
        int i10 = 1;
        GridItemNode gridItemNode = null;
        MutableIntSet mutableIntSet = new MutableIntSet(0, 1, null);
        int i11 = longList._size;
        int i12 = longList2._size;
        int size = list2.size();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = i11;
        int i17 = i12;
        while (i13 < size) {
            Measurable measurable = list2.get(i13);
            Object parentData = measurable.getParentData();
            int i18 = i10;
            GridItemNode gridItemNode2 = parentData instanceof GridItemNode ? (GridItemNode) parentData : gridItemNode;
            int rowSpan = gridItemNode2 != null ? gridItemNode2.getRowSpan() : i18;
            int columnSpan = gridItemNode2 != null ? gridItemNode2.getColumnSpan() : i18;
            if (gridItemNode2 != null) {
                i2 = i9;
                i9 = gridItemNode2.getRow();
            } else {
                i2 = i9;
            }
            int resolveToZeroBasedIndex = resolveToZeroBasedIndex(i9, i12);
            int resolveToZeroBasedIndex2 = resolveToZeroBasedIndex(gridItemNode2 != null ? gridItemNode2.getColumn() : i2, i11);
            int i19 = size;
            if (resolveToZeroBasedIndex == -1 || resolveToZeroBasedIndex2 == -1) {
                i3 = i13;
                int i20 = 1000;
                if (resolveToZeroBasedIndex != -1) {
                    GridFlow.Companion companion = GridFlow.Companion;
                    for (int i21 = (GridFlow.m963equalsimpl0(i, GridFlow.m961constructorimpl(i2)) && resolveToZeroBasedIndex == i14) ? i15 : i2; i21 < 1000; i21++) {
                        if (!resolveGridItemIndices_pclAfdo$isAreaOccupied(mutableIntSet, resolveToZeroBasedIndex, i21, rowSpan, columnSpan)) {
                            i5 = i14;
                            i7 = i2;
                            i6 = i21;
                            i4 = resolveToZeroBasedIndex;
                            break;
                        }
                    }
                    i4 = resolveToZeroBasedIndex;
                    i5 = i14;
                    i7 = i2;
                    i6 = -1;
                } else if (resolveToZeroBasedIndex2 != -1) {
                    GridFlow.Companion companion2 = GridFlow.Companion;
                    i4 = (GridFlow.m963equalsimpl0(i, GridFlow.m961constructorimpl(i18)) && resolveToZeroBasedIndex2 == i15) ? i14 : i2;
                    while (i4 < 1000) {
                        if (resolveGridItemIndices_pclAfdo$isAreaOccupied(mutableIntSet, i4, resolveToZeroBasedIndex2, rowSpan, columnSpan)) {
                            i4++;
                        }
                    }
                    i5 = i14;
                    i7 = i2;
                    i4 = -1;
                    i6 = resolveToZeroBasedIndex2;
                } else {
                    i4 = i14;
                    i5 = i4;
                    i6 = i15;
                    while (i4 < i20 && i6 < i20) {
                        GridFlow.Companion companion3 = GridFlow.Companion;
                        if (GridFlow.m963equalsimpl0(i, GridFlow.m961constructorimpl(i2))) {
                            if (i11 > 0 && i6 + columnSpan > i11 && i6 > 0) {
                                i4++;
                                i6 = i2;
                                i20 = 1000;
                            }
                            if (resolveGridItemIndices_pclAfdo$isAreaOccupied(mutableIntSet, i4, i6, rowSpan, columnSpan)) {
                                i7 = i2;
                                break;
                            }
                            GridFlow.Companion companion4 = GridFlow.Companion;
                            if (GridFlow.m963equalsimpl0(i, GridFlow.m961constructorimpl(i2))) {
                                i6++;
                                i20 = 1000;
                                if (i6 > 1000) {
                                    i4++;
                                    i6 = i2;
                                }
                            } else {
                                i20 = 1000;
                                i4++;
                                if (i4 > 1000) {
                                    i6++;
                                    i4 = i2;
                                }
                            }
                        } else {
                            if (i12 > 0 && i4 + rowSpan > i12 && i4 > 0) {
                                i6++;
                                i4 = i2;
                                i20 = 1000;
                            }
                            if (resolveGridItemIndices_pclAfdo$isAreaOccupied(mutableIntSet, i4, i6, rowSpan, columnSpan)) {
                            }
                        }
                    }
                    i7 = i2;
                    i4 = -1;
                    i6 = -1;
                }
                int max = Math.max(i7, i4);
                int max2 = Math.max(i7, i6);
                resolveGridItemIndices_pclAfdo$markAreaOccupied(mutableIntSet, max, max2, rowSpan, columnSpan);
                if (gridItemNode2 != null || (r10 = gridItemNode2.getAlignment()) == null) {
                    Alignment topStart = Alignment.Companion.getTopStart();
                }
                int i22 = rowSpan;
                int i23 = columnSpan;
                mutableObjectList.add(new GridItem(measurable, max, max2, i22, i23, topStart, null, 0, 0, 448, null));
                int i24 = max + i22;
                i17 = Math.max(i17, i24);
                int i25 = max2 + i23;
                i16 = Math.max(i16, i25);
                if (resolveToZeroBasedIndex != -1 || resolveToZeroBasedIndex2 == -1) {
                    GridFlow.Companion companion5 = GridFlow.Companion;
                    i8 = 0;
                    if (GridFlow.m963equalsimpl0(i, GridFlow.m961constructorimpl(0))) {
                        i14 = i24;
                        i15 = max2;
                    } else {
                        i15 = i25;
                        i14 = max;
                    }
                } else {
                    i14 = i5;
                    i8 = 0;
                }
                i13 = i3 + 1;
                list2 = list;
                size = i19;
                i10 = i18;
                i9 = i8;
                gridItemNode = null;
            } else {
                i4 = resolveToZeroBasedIndex;
                i3 = i13;
            }
            i5 = i14;
            i7 = i2;
            i6 = resolveToZeroBasedIndex2;
            int max3 = Math.max(i7, i4);
            int max22 = Math.max(i7, i6);
            resolveGridItemIndices_pclAfdo$markAreaOccupied(mutableIntSet, max3, max22, rowSpan, columnSpan);
            if (gridItemNode2 != null) {
            }
            Alignment topStart2 = Alignment.Companion.getTopStart();
            int i222 = rowSpan;
            int i232 = columnSpan;
            mutableObjectList.add(new GridItem(measurable, max3, max22, i222, i232, topStart2, null, 0, 0, 448, null));
            int i242 = max3 + i222;
            i17 = Math.max(i17, i242);
            int i252 = max22 + i232;
            i16 = Math.max(i16, i252);
            if (resolveToZeroBasedIndex != -1) {
            }
            GridFlow.Companion companion52 = GridFlow.Companion;
            i8 = 0;
            if (GridFlow.m963equalsimpl0(i, GridFlow.m961constructorimpl(0))) {
            }
            i13 = i3 + 1;
            list2 = list;
            size = i19;
            i10 = i18;
            i9 = i8;
            gridItemNode = null;
        }
        return new ResolvedGridItemIndicesResult(mutableObjectList, IntSize.m8326constructorimpl((i16 << 32) | (i17 & 4294967295L)), null);
    }

    private static final boolean resolveGridItemIndices_pclAfdo$isAreaOccupied(MutableIntSet mutableIntSet, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i3 + i;
        if (i6 > 1000 || (i5 = i4 + i2) > 1000) {
            return true;
        }
        while (i < i6) {
            for (int i7 = i2; i7 < i5; i7++) {
                if (mutableIntSet.contains(resolveGridItemIndices_pclAfdo$packCoordinate(i, i7))) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    private static final void resolveGridItemIndices_pclAfdo$markAreaOccupied(MutableIntSet mutableIntSet, int i, int i2, int i3, int i4) {
        int i5 = i3 + i;
        while (i < i5) {
            int i6 = i2 + i4;
            for (int i7 = i2; i7 < i6; i7++) {
                mutableIntSet.add(resolveGridItemIndices_pclAfdo$packCoordinate(i, i7));
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateGridTrackSizes-cMe430U  reason: not valid java name */
    public static final GridTrackSizes m974calculateGridTrackSizescMe430U(Density density, MutableObjectList<GridItem> mutableObjectList, LongList longList, LongList longList2, int i, int i2, long j, float f, float f2) {
        int mo428roundToPx0680j_4 = density.mo428roundToPx0680j_4(f);
        int mo428roundToPx0680j_42 = density.mo428roundToPx0680j_4(f2);
        MutableObjectList[] mutableObjectListArr = new MutableObjectList[i];
        MutableObjectList[] mutableObjectListArr2 = new MutableObjectList[i2];
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i3 = mutableObjectList2._size;
        for (int i4 = 0; i4 < i3; i4++) {
            GridItem gridItem = (GridItem) objArr[i4];
            if (gridItem.getColumn() < i) {
                MutableObjectList mutableObjectList3 = mutableObjectListArr[gridItem.getColumn()];
                if (mutableObjectList3 == null) {
                    mutableObjectList3 = new MutableObjectList(0, 1, null);
                    mutableObjectListArr[gridItem.getColumn()] = mutableObjectList3;
                }
                mutableObjectList3.add(gridItem);
            }
            if (gridItem.getRow() < i2) {
                MutableObjectList mutableObjectList4 = mutableObjectListArr2[gridItem.getRow()];
                if (mutableObjectList4 == null) {
                    mutableObjectList4 = new MutableObjectList(0, 1, null);
                    mutableObjectListArr2[gridItem.getRow()] = mutableObjectList4;
                }
                mutableObjectList4.add(gridItem);
            }
        }
        int[] iArr = new int[i];
        int[] iArr2 = new int[i2];
        return new GridTrackSizes(iArr, iArr2, m973calculateColumnWidthsO3s9Psw(density, longList, i, Constraints.m8113getMaxWidthimpl(j), iArr, mutableObjectListArr, j, mutableObjectList, mo428roundToPx0680j_4) + (Math.max(0, i - 1) * mo428roundToPx0680j_4), m975calculateRowHeightsESwBiLc(density, longList2, i2, Constraints.m8112getMaxHeightimpl(j), iArr2, mutableObjectListArr2, j, iArr, mutableObjectList, mo428roundToPx0680j_42) + (Math.max(0, i2 - 1) * mo428roundToPx0680j_42), mo428roundToPx0680j_4, mo428roundToPx0680j_42);
    }

    /* renamed from: calculateColumnWidths-O3s9Psw  reason: not valid java name */
    private static final int m973calculateColumnWidthsO3s9Psw(Density density, LongList longList, int i, int i2, int[] iArr, MutableObjectList<GridItem>[] mutableObjectListArr, long j, MutableObjectList<GridItem> mutableObjectList, int i3) {
        long m996getAutoeyNpfc4;
        int mo428roundToPx0680j_4;
        if (i == 0) {
            return 0;
        }
        int coerceAtLeast = i2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : RangesKt.coerceAtLeast(i2 - RangesKt.coerceAtLeast((i - 1) * i3, 0), 0);
        MutableIntList mutableIntList = new MutableIntList(0, 1, null);
        int[] iArr2 = new int[i];
        float f = 0.0f;
        for (int i4 = 0; i4 < i; i4++) {
            if (i4 < longList._size) {
                m996getAutoeyNpfc4 = longList.get(i4);
            } else {
                m996getAutoeyNpfc4 = GridTrackSize.Companion.m996getAutoeyNpfc4();
            }
            long m979constructorimpl = GridTrackSize.m979constructorimpl(m996getAutoeyNpfc4);
            switch (GridTrackSize.m984getTypeimpl$foundation_layout(m979constructorimpl)) {
                case 1:
                    mo428roundToPx0680j_4 = density.mo428roundToPx0680j_4(Dp.m8160constructorimpl(GridTrackSize.m985getValueimpl$foundation_layout(m979constructorimpl)));
                    break;
                case 2:
                    if (coerceAtLeast != Integer.MAX_VALUE) {
                        mo428roundToPx0680j_4 = MathKt.roundToInt(GridTrackSize.m985getValueimpl$foundation_layout(m979constructorimpl) * coerceAtLeast);
                        break;
                    } else {
                        mo428roundToPx0680j_4 = calculateMaxIntrinsicWidth(mutableObjectListArr[i4]);
                        break;
                    }
                case 3:
                    f += GridTrackSize.m985getValueimpl$foundation_layout(m979constructorimpl);
                    mo428roundToPx0680j_4 = calculateMinIntrinsicWidth(mutableObjectListArr[i4]);
                    break;
                case 4:
                    mo428roundToPx0680j_4 = calculateMinIntrinsicWidth(mutableObjectListArr[i4]);
                    break;
                case 5:
                    mo428roundToPx0680j_4 = calculateMaxIntrinsicWidth(mutableObjectListArr[i4]);
                    break;
                case 6:
                    if (coerceAtLeast == Integer.MAX_VALUE) {
                        mo428roundToPx0680j_4 = calculateMaxIntrinsicWidth(mutableObjectListArr[i4]);
                        break;
                    } else {
                        long calculateMinMaxIntrinsicWidth = calculateMinMaxIntrinsicWidth(mutableObjectListArr[i4]);
                        mutableIntList.add(i4);
                        iArr2[i4] = (int) (calculateMinMaxIntrinsicWidth >>> 32);
                        mo428roundToPx0680j_4 = (int) (calculateMinMaxIntrinsicWidth & 4294967295L);
                        break;
                    }
                case 7:
                    f += GridTrackSize.m982getMaxValueimpl$foundation_layout(m979constructorimpl);
                    mo428roundToPx0680j_4 = density.mo428roundToPx0680j_4(Dp.m8160constructorimpl(GridTrackSize.m983getMinValueimpl$foundation_layout(m979constructorimpl)));
                    break;
                default:
                    mo428roundToPx0680j_4 = calculateMaxIntrinsicWidth(mutableObjectListArr[i4]);
                    break;
            }
            iArr[i4] = mo428roundToPx0680j_4;
        }
        m976distributeSpanningSpaceWeOhcdQ(longList, iArr, mutableObjectList, false, j, null, i3);
        if (coerceAtLeast != Integer.MAX_VALUE && mutableIntList._size != 0) {
            expandAutoTracks(mutableIntList, iArr, iArr2, coerceAtLeast);
        }
        return distributeFlexSpaceAndGetTotal(iArr, coerceAtLeast, f, i, longList);
    }

    /* renamed from: calculateRowHeights-ESwBiLc  reason: not valid java name */
    private static final int m975calculateRowHeightsESwBiLc(Density density, LongList longList, int i, int i2, int[] iArr, MutableObjectList<GridItem>[] mutableObjectListArr, long j, int[] iArr2, MutableObjectList<GridItem> mutableObjectList, int i3) {
        long m996getAutoeyNpfc4;
        int mo428roundToPx0680j_4;
        if (i == 0) {
            return 0;
        }
        int coerceAtLeast = i2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : RangesKt.coerceAtLeast(i2 - RangesKt.coerceAtLeast((i - 1) * i3, 0), 0);
        MutableIntList mutableIntList = new MutableIntList(0, 1, null);
        int[] iArr3 = new int[i];
        float f = 0.0f;
        for (int i4 = 0; i4 < i; i4++) {
            if (i4 < longList._size) {
                m996getAutoeyNpfc4 = longList.get(i4);
            } else {
                m996getAutoeyNpfc4 = GridTrackSize.Companion.m996getAutoeyNpfc4();
            }
            long m979constructorimpl = GridTrackSize.m979constructorimpl(m996getAutoeyNpfc4);
            switch (GridTrackSize.m984getTypeimpl$foundation_layout(m979constructorimpl)) {
                case 1:
                    mo428roundToPx0680j_4 = density.mo428roundToPx0680j_4(Dp.m8160constructorimpl(GridTrackSize.m985getValueimpl$foundation_layout(m979constructorimpl)));
                    break;
                case 2:
                    if (coerceAtLeast != Integer.MAX_VALUE) {
                        mo428roundToPx0680j_4 = MathKt.roundToInt(GridTrackSize.m985getValueimpl$foundation_layout(m979constructorimpl) * coerceAtLeast);
                        break;
                    } else {
                        mo428roundToPx0680j_4 = calculateMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8113getMaxWidthimpl(j));
                        break;
                    }
                case 3:
                    f += GridTrackSize.m985getValueimpl$foundation_layout(m979constructorimpl);
                    mo428roundToPx0680j_4 = calculateMinIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8113getMaxWidthimpl(j));
                    break;
                case 4:
                    mo428roundToPx0680j_4 = calculateMinIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8113getMaxWidthimpl(j));
                    break;
                case 5:
                    mo428roundToPx0680j_4 = calculateMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8113getMaxWidthimpl(j));
                    break;
                case 6:
                    if (coerceAtLeast == Integer.MAX_VALUE) {
                        mo428roundToPx0680j_4 = calculateMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8113getMaxWidthimpl(j));
                        break;
                    } else {
                        long calculateMinMaxIntrinsicHeight = calculateMinMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8113getMaxWidthimpl(j));
                        mutableIntList.add(i4);
                        iArr3[i4] = (int) (calculateMinMaxIntrinsicHeight >>> 32);
                        mo428roundToPx0680j_4 = (int) (calculateMinMaxIntrinsicHeight & 4294967295L);
                        break;
                    }
                case 7:
                    f += GridTrackSize.m982getMaxValueimpl$foundation_layout(m979constructorimpl);
                    mo428roundToPx0680j_4 = density.mo428roundToPx0680j_4(Dp.m8160constructorimpl(GridTrackSize.m983getMinValueimpl$foundation_layout(m979constructorimpl)));
                    break;
                default:
                    mo428roundToPx0680j_4 = calculateMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8113getMaxWidthimpl(j));
                    break;
            }
            iArr[i4] = mo428roundToPx0680j_4;
        }
        m976distributeSpanningSpaceWeOhcdQ(longList, iArr, mutableObjectList, true, j, iArr2, i3);
        if (coerceAtLeast != Integer.MAX_VALUE && mutableIntList._size != 0) {
            expandAutoTracks(mutableIntList, iArr, iArr3, coerceAtLeast);
        }
        return distributeFlexSpaceAndGetTotal(iArr, coerceAtLeast, f, i, longList);
    }

    private static final int distributeFlexSpaceAndGetTotal(int[] iArr, int i, float f, int i2, LongList longList) {
        long m996getAutoeyNpfc4;
        float m985getValueimpl$foundation_layout;
        int i3 = 0;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        int max = i == Integer.MAX_VALUE ? 0 : Math.max(0, i - i4);
        if (f > 0.0f && max > 0) {
            float f2 = 0.0f;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                if (i8 < longList._size) {
                    m996getAutoeyNpfc4 = longList.get(i8);
                } else {
                    m996getAutoeyNpfc4 = GridTrackSize.Companion.m996getAutoeyNpfc4();
                }
                long m979constructorimpl = GridTrackSize.m979constructorimpl(m996getAutoeyNpfc4);
                int m984getTypeimpl$foundation_layout = GridTrackSize.m984getTypeimpl$foundation_layout(m979constructorimpl);
                if (m984getTypeimpl$foundation_layout == 3) {
                    m985getValueimpl$foundation_layout = GridTrackSize.m985getValueimpl$foundation_layout(m979constructorimpl);
                } else {
                    m985getValueimpl$foundation_layout = m984getTypeimpl$foundation_layout != 7 ? 0.0f : GridTrackSize.m982getMaxValueimpl$foundation_layout(m979constructorimpl);
                }
                if (m985getValueimpl$foundation_layout > 0.0f) {
                    f2 += m985getValueimpl$foundation_layout;
                    int max2 = Math.max(0, MathKt.roundToInt((f2 / f) * max) - i7);
                    iArr[i8] = iArr[i8] + max2;
                    i6 = max2 + i7;
                    i7 = i6;
                }
            }
            i3 = i6;
        }
        return i4 + i3;
    }

    private static final int calculateMaxIntrinsicWidth(MutableObjectList<GridItem> mutableObjectList) {
        if (mutableObjectList == null) {
            return 0;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            GridItem gridItem = (GridItem) objArr[i3];
            if (gridItem.getColumnSpan() == 1) {
                try {
                    int maxIntrinsicWidth = gridItem.getMeasurable().maxIntrinsicWidth(Integer.MAX_VALUE);
                    if (maxIntrinsicWidth > i2) {
                        i2 = maxIntrinsicWidth;
                    }
                } catch (IllegalStateException e) {
                    String message = e.getMessage();
                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e);
                    }
                    throw e;
                }
            }
        }
        return i2;
    }

    private static final int calculateMinIntrinsicWidth(MutableObjectList<GridItem> mutableObjectList) {
        if (mutableObjectList == null) {
            return 0;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            GridItem gridItem = (GridItem) objArr[i3];
            if (gridItem.getColumnSpan() == 1) {
                try {
                    int minIntrinsicWidth = gridItem.getMeasurable().minIntrinsicWidth(Integer.MAX_VALUE);
                    if (minIntrinsicWidth > i2) {
                        i2 = minIntrinsicWidth;
                    }
                } catch (IllegalStateException e) {
                    String message = e.getMessage();
                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e);
                    }
                    throw e;
                }
            }
        }
        return i2;
    }

    private static final int calculateMaxIntrinsicHeight(MutableObjectList<GridItem> mutableObjectList, int[] iArr, int i) {
        if (mutableObjectList == null) {
            return 0;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i2 = mutableObjectList2._size;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            GridItem gridItem = (GridItem) objArr[i4];
            if (gridItem.getRowSpan() == 1) {
                int column = gridItem.getColumn();
                try {
                    int maxIntrinsicHeight = gridItem.getMeasurable().maxIntrinsicHeight(column < iArr.length ? iArr[column] : i);
                    if (maxIntrinsicHeight > i3) {
                        i3 = maxIntrinsicHeight;
                    }
                } catch (IllegalStateException e) {
                    String message = e.getMessage();
                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e);
                    }
                    throw e;
                }
            }
        }
        return i3;
    }

    private static final int calculateMinIntrinsicHeight(MutableObjectList<GridItem> mutableObjectList, int[] iArr, int i) {
        if (mutableObjectList == null) {
            return 0;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i2 = mutableObjectList2._size;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            GridItem gridItem = (GridItem) objArr[i4];
            if (gridItem.getRowSpan() == 1) {
                int column = gridItem.getColumn();
                try {
                    int minIntrinsicHeight = gridItem.getMeasurable().minIntrinsicHeight(column < iArr.length ? iArr[column] : i);
                    if (minIntrinsicHeight > i3) {
                        i3 = minIntrinsicHeight;
                    }
                } catch (IllegalStateException e) {
                    String message = e.getMessage();
                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e);
                    }
                    throw e;
                }
            }
        }
        return i3;
    }

    private static final long calculateMinMaxIntrinsicWidth(MutableObjectList<GridItem> mutableObjectList) {
        if (mutableObjectList == null) {
            return 0L;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            GridItem gridItem = (GridItem) objArr[i4];
            if (gridItem.getColumnSpan() == 1) {
                try {
                    int minIntrinsicWidth = gridItem.getMeasurable().minIntrinsicWidth(Integer.MAX_VALUE);
                    try {
                        int maxIntrinsicWidth = gridItem.getMeasurable().maxIntrinsicWidth(Integer.MAX_VALUE);
                        if (minIntrinsicWidth > i3) {
                            i3 = minIntrinsicWidth;
                        }
                        if (maxIntrinsicWidth > i2) {
                            i2 = maxIntrinsicWidth;
                        }
                    } catch (IllegalStateException e) {
                        String message = e.getMessage();
                        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                            throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e);
                        }
                        throw e;
                    }
                } catch (IllegalStateException e2) {
                    String message2 = e2.getMessage();
                    if (message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                    }
                    throw e2;
                }
            }
        }
        return (i2 << 32) | (i3 & 4294967295L);
    }

    private static final long calculateMinMaxIntrinsicHeight(MutableObjectList<GridItem> mutableObjectList, int[] iArr, int i) {
        if (mutableObjectList == null) {
            return 0L;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i2 = mutableObjectList2._size;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            GridItem gridItem = (GridItem) objArr[i5];
            if (gridItem.getRowSpan() == 1) {
                int column = gridItem.getColumn();
                int i6 = column < iArr.length ? iArr[column] : i;
                try {
                    int minIntrinsicHeight = gridItem.getMeasurable().minIntrinsicHeight(i6);
                    try {
                        int maxIntrinsicHeight = gridItem.getMeasurable().maxIntrinsicHeight(i6);
                        if (minIntrinsicHeight > i4) {
                            i4 = minIntrinsicHeight;
                        }
                        if (maxIntrinsicHeight > i3) {
                            i3 = maxIntrinsicHeight;
                        }
                    } catch (IllegalStateException e) {
                        String message = e.getMessage();
                        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                            throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e);
                        }
                        throw e;
                    }
                } catch (IllegalStateException e2) {
                    String message2 = e2.getMessage();
                    if (message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                    }
                    throw e2;
                }
            }
        }
        return (i3 << 32) | (i4 & 4294967295L);
    }

    /* renamed from: distributeSpanningSpace-WeOhcdQ  reason: not valid java name */
    private static final void m976distributeSpanningSpaceWeOhcdQ(LongList longList, int[] iArr, MutableObjectList<GridItem> mutableObjectList, boolean z, long j, int[] iArr2, int i) {
        int maxIntrinsicWidth;
        long m996getAutoeyNpfc4;
        boolean z2;
        int m8113getMaxWidthimpl;
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i2 = mutableObjectList2._size;
        for (int i3 = 0; i3 < i2; i3++) {
            GridItem gridItem = (GridItem) objArr[i3];
            int row = z ? gridItem.getRow() : gridItem.getColumn();
            int rowSpan = z ? gridItem.getRowSpan() : gridItem.getColumnSpan();
            if (rowSpan > 1) {
                int coerceAtMost = RangesKt.coerceAtMost(rowSpan + row, iArr.length);
                int i4 = row;
                int i5 = 0;
                int i6 = 0;
                while (i4 < coerceAtMost) {
                    i5 += iArr[i4];
                    long m979constructorimpl = GridTrackSize.m979constructorimpl(i4 < longList._size ? longList.get(i4) : GridTrackSize.Companion.m996getAutoeyNpfc4());
                    if (GridTrackSize.m984getTypeimpl$foundation_layout(m979constructorimpl) != 1 && GridTrackSize.m984getTypeimpl$foundation_layout(m979constructorimpl) != 2) {
                        i6++;
                    }
                    i4++;
                }
                if (z) {
                    if (iArr2 != null) {
                        int column = gridItem.getColumn();
                        z2 = true;
                        int coerceAtMost2 = RangesKt.coerceAtMost(column + gridItem.getColumnSpan(), iArr2.length);
                        int i7 = 0;
                        for (int i8 = column; i8 < coerceAtMost2; i8++) {
                            i7 += iArr2[i8];
                        }
                        m8113getMaxWidthimpl = i7 + (Math.max(0, gridItem.getColumnSpan() - 1) * i);
                    } else {
                        z2 = true;
                        m8113getMaxWidthimpl = Constraints.m8113getMaxWidthimpl(j);
                    }
                    try {
                        maxIntrinsicWidth = gridItem.getMeasurable().maxIntrinsicHeight(m8113getMaxWidthimpl);
                    } catch (IllegalStateException e) {
                        String message = e.getMessage();
                        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null) == z2) {
                            throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e);
                        }
                        throw e;
                    }
                } else {
                    try {
                        maxIntrinsicWidth = gridItem.getMeasurable().maxIntrinsicWidth(Integer.MAX_VALUE);
                    } catch (IllegalStateException e2) {
                        String message2 = e2.getMessage();
                        if (message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                            throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                        }
                        throw e2;
                    }
                }
                int i9 = maxIntrinsicWidth - i5;
                if (i9 > 0 && i6 > 0) {
                    int i10 = i9 / i6;
                    int i11 = i9 % i6;
                    while (row < coerceAtMost) {
                        if (row < longList._size) {
                            m996getAutoeyNpfc4 = longList.get(row);
                        } else {
                            m996getAutoeyNpfc4 = GridTrackSize.Companion.m996getAutoeyNpfc4();
                        }
                        long m979constructorimpl2 = GridTrackSize.m979constructorimpl(m996getAutoeyNpfc4);
                        if (GridTrackSize.m984getTypeimpl$foundation_layout(m979constructorimpl2) != 1 && GridTrackSize.m984getTypeimpl$foundation_layout(m979constructorimpl2) != 2) {
                            iArr[row] = iArr[row] + (i11 > 0 ? 1 : 0) + i10;
                            if (i11 > 0) {
                                i11--;
                            }
                        }
                        row++;
                    }
                }
            }
        }
    }

    private static final void expandAutoTracks(MutableIntList mutableIntList, int[] iArr, int[] iArr2, int i) {
        MutableIntList mutableIntList2 = mutableIntList;
        if (mutableIntList2._size == 0) {
            return;
        }
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int i4 = i - i2;
        if (i4 <= 0) {
            return;
        }
        int[] iArr3 = new int[mutableIntList2._size];
        int[] iArr4 = mutableIntList2.content;
        int i5 = mutableIntList2._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = iArr4[i7];
            int max = Math.max(0, iArr2[i8] - iArr[i8]);
            iArr3[i7] = max;
            i6 += max;
        }
        if (i6 == 0) {
            return;
        }
        if (i4 >= i6) {
            IntRange until = RangesKt.until(0, mutableIntList2._size);
            int first = until.getFirst();
            int last = until.getLast();
            if (first > last) {
                return;
            }
            while (true) {
                int i9 = mutableIntList.get(first);
                iArr[i9] = iArr[i9] + iArr3[first];
                if (first == last) {
                    return;
                }
                first++;
            }
        } else {
            IntRange until2 = RangesKt.until(0, mutableIntList2._size);
            int first2 = until2.getFirst();
            int last2 = until2.getLast();
            if (first2 > last2) {
                return;
            }
            while (true) {
                int i10 = mutableIntList.get(first2);
                iArr[i10] = iArr[i10] + MathKt.roundToInt((iArr3[first2] / i6) * i4);
                if (first2 == last2) {
                    return;
                }
                first2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void measureItems(MutableObjectList<GridItem> mutableObjectList, GridTrackSizes gridTrackSizes, LayoutDirection layoutDirection) {
        int length = gridTrackSizes.getRowHeights().length;
        int length2 = gridTrackSizes.getColumnWidths().length;
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        for (int i2 = 0; i2 < i; i2++) {
            GridItem gridItem = (GridItem) objArr[i2];
            int row = gridItem.getRow();
            int column = gridItem.getColumn();
            if (row < length && column < length2) {
                int coerceAtMost = RangesKt.coerceAtMost(gridItem.getColumnSpan() + column, length2);
                int i3 = 0;
                for (int i4 = column; i4 < coerceAtMost; i4++) {
                    i3 += gridTrackSizes.getColumnWidths()[i4];
                }
                int i5 = coerceAtMost - column;
                if (i5 > 1) {
                    i3 += (i5 - 1) * gridTrackSizes.getColumnGapPx();
                }
                int i6 = i3;
                int coerceAtMost2 = RangesKt.coerceAtMost(gridItem.getRowSpan() + row, length);
                int i7 = 0;
                for (int i8 = row; i8 < coerceAtMost2; i8++) {
                    i7 += gridTrackSizes.getRowHeights()[i8];
                }
                int i9 = coerceAtMost2 - row;
                if (i9 > 1) {
                    i7 += (i9 - 1) * gridTrackSizes.getRowGapPx();
                }
                int i10 = i7;
                Placeable mo6818measureBRTryo0 = gridItem.getMeasurable().mo6818measureBRTryo0(ConstraintsKt.Constraints$default(0, i6, 0, i10, 5, null));
                long mo4771alignKFBX0sM = gridItem.getAlignment().mo4771alignKFBX0sM(IntSize.m8326constructorimpl((mo6818measureBRTryo0.getHeight() & 4294967295L) | (mo6818measureBRTryo0.getWidth() << 32)), IntSize.m8326constructorimpl((i6 << 32) | (i10 & 4294967295L)), layoutDirection);
                gridItem.setPlaceable(mo6818measureBRTryo0);
                gridItem.setOffsetX(IntOffset.m8288getXimpl(mo4771alignKFBX0sM));
                gridItem.setOffsetY(IntOffset.m8289getYimpl(mo4771alignKFBX0sM));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] calculateTrackOffsets(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length];
        int length = iArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            iArr2[i3] = i2;
            i2 += iArr[i3] + i;
        }
        return iArr2;
    }

    private static final <T> T wrapIntrinsicException(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (IllegalStateException e) {
            String message = e.getMessage();
            if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e);
            }
            throw e;
        }
    }
}
