package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyLayoutItemAnimator.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003KLMB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0082\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0006\u0010-\u001a\u00020\u0019J\b\u0010.\u001a\u00020\u0019H\u0002J1\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\f2\u0012\b\u0002\u00102\u001a\f0\bR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u00103J\u001f\u00104\u001a\u00020\u00192\u0006\u00100\u001a\u00028\u00002\b\b\u0002\u00105\u001a\u00020!H\u0002¢\u0006\u0002\u00106J\u0018\u00107\u001a\u0004\u0018\u00010\u00152\u0006\u0010,\u001a\u00020\u00032\u0006\u00108\u001a\u00020\fJ\u0019\u00109\u001a\u00020\f*\u00020:2\u0006\u00100\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010;R$\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f0\bR\b\u0012\u0004\u0012\u00028\u00000\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0018\u0010D\u001a\u00020!*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0018\u00101\u001a\u00020\f*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0018\u0010I\u001a\u00020\f*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010H¨\u0006N"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "<init>", "()V", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "firstVisibleIndex", "", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingInFromStartBound", "", "movingInFromEndBound", "movingAwayToStartBound", "movingAwayToEndBound", "disappearingItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "removeInfoForKey", "key", "reset", "releaseAnimations", "initializeAnimation", "item", "mainAxisOffset", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "getAnimation", "placeableIndex", "updateAndReturnOffsetFor", "", "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "hasAnimations", "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "crossAxisOffset", "getCrossAxisOffset", "ItemInfo", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutItemAnimator<T extends LazyLayoutMeasuredItem> {
    public static final int $stable = 8;
    private DrawModifierNode displayingNode;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<T> movingInFromStartBound = new ArrayList();
    private final List<T> movingInFromEndBound = new ArrayList();
    private final List<T> movingAwayToStartBound = new ArrayList();
    private final List<T> movingAwayToEndBound = new ArrayList();
    private final List<LazyLayoutItemAnimation> disappearingItems = new ArrayList();
    private final Modifier modifier = new DisplayingDisappearingItemsElement(this);

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01fb, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01fe, code lost:
        r34 = r1;
        r35 = r2;
        removeInfoForKey(r14.getKey());
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x020b, code lost:
        r2 = r35 + 1;
        r1 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0211, code lost:
        r6 = new int[r50];
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0213, code lost:
        if (r23 == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0215, code lost:
        if (r11 == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x021f, code lost:
        if (r41.movingInFromStartBound.isEmpty() != false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0221, code lost:
        r1 = r41.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0228, code lost:
        if (r1.size() <= 1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x022a, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0234, code lost:
        r7 = r41.movingInFromStartBound;
        r12 = r7.size();
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x023e, code lost:
        if (r13 >= r12) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0240, code lost:
        r1 = r7.get(r13);
        initializeAnimation$default(r41, r1, r52 - updateAndReturnOffsetFor(r6, r1), null, 4, null);
        startPlacementAnimationsIfNeeded$default(r41, r1, false, 2, null);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x025b, code lost:
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0272, code lost:
        if (r41.movingInFromEndBound.isEmpty() != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0274, code lost:
        r1 = r41.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x027b, code lost:
        if (r1.size() <= 1) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x027d, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0287, code lost:
        r7 = r41.movingInFromEndBound;
        r12 = r7.size();
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0291, code lost:
        if (r13 >= r12) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0293, code lost:
        r1 = r7.get(r13);
        initializeAnimation$default(r41, r1, (r53 + updateAndReturnOffsetFor(r6, r1)) - r1.getMainAxisSizeWithSpacings(), null, 4, null);
        startPlacementAnimationsIfNeeded$default(r41, r1, false, 2, null);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02b3, code lost:
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02c2, code lost:
        r1 = r41.movingAwayKeys;
        r2 = r1.elements;
        r1 = r1.metadata;
        r3 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02cd, code lost:
        if (r3 < 0) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02cf, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02d0, code lost:
        r12 = r1[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02da, code lost:
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02dc, code lost:
        r5 = 8 - ((~(r4 - r3)) >>> 31);
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        r3 = r41.firstVisibleIndex;
        r4 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List<? extends java.lang.Object>) r45);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02e6, code lost:
        if (r7 >= r5) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02ec, code lost:
        if ((r12 & 255) >= 128) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02ee, code lost:
        r14 = r2[(r4 << 3) + r7];
        r15 = r41.keyToItemInfoMap.get(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02fb, code lost:
        if (r15 != null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02ff, code lost:
        r30 = r1;
        r1 = r46.getIndex(r14);
        r31 = r2;
        r15.setSpan(java.lang.Math.min(r50, r15.getSpan()));
        r32 = r7;
        r15.setLane(java.lang.Math.min(r50 - r15.getSpan(), r15.getLane()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0326, code lost:
        if (r1 != (-1)) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0328, code lost:
        r1 = r15.getAnimations();
        r7 = r1.length;
        r2 = 0;
        r24 = false;
        r25 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0332, code lost:
        if (r2 >= r7) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r4 == null) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0334, code lost:
        r48 = r1;
        r1 = r48[r2];
        r26 = r25 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x033a, code lost:
        if (r1 == null) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0340, code lost:
        if (r1.isDisappearanceAnimationInProgress() == false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0342, code lost:
        r1 = kotlin.Unit.INSTANCE;
        r27 = r2;
        r24 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x034d, code lost:
        if (r1.isDisappearanceAnimationFinished() == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x034f, code lost:
        r1.release();
        r15.getAnimations()[r25] = null;
        r27 = r2;
        r41.disappearingItems.remove(r1);
        r1 = r41.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0363, code lost:
        if (r1 == null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0365, code lost:
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        r4 = r4.getIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x036b, code lost:
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0371, code lost:
        if (r1.getLayer() == null) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0373, code lost:
        r1.animateDisappearance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x037a, code lost:
        if (r1.isDisappearanceAnimationInProgress() == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x037c, code lost:
        r41.disappearingItems.add(r1);
        r1 = r41.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0383, code lost:
        if (r1 == null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0385, code lost:
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x038a, code lost:
        r24 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x038f, code lost:
        r1.release();
        r15.getAnimations()[r25] = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x039a, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x039d, code lost:
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03a1, code lost:
        r2 = r27 + 1;
        r1 = r48;
        r25 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03aa, code lost:
        if (r24 != false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03ac, code lost:
        removeInfoForKey(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03af, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03b3, code lost:
        r2 = r15.m989getConstraintsDWUhwKw();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r1 = r47.mo933getAndMeasurehBUhpc(r1, r15.getLane(), r15.getSpan(), r2.m7514unboximpl());
        r1.setNonScrollableItem(true);
        r7 = r15.getAnimations();
        r1 = r7.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03e0, code lost:
        if (r7 >= r1) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        r41.firstVisibleIndex = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03e2, code lost:
        r24 = r7[r7];
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x03e6, code lost:
        if (r24 == null) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03e8, code lost:
        r1 = r24.isPlacementAnimationInProgress();
        r24 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03ef, code lost:
        if (r1 != true) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03f2, code lost:
        r24 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03f4, code lost:
        r7 = r24 + 1;
        r1 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03f9, code lost:
        if (r11 == null) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x03ff, code lost:
        if (r1 != r11.getIndex(r14)) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r48 == false) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0401, code lost:
        removeInfoForKey(r14);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0407, code lost:
        r15.updateAnimation(r1, r54, r55, r52, r53, r15.getCrossAxisOffset());
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x041c, code lost:
        if (r1 >= r41.firstVisibleIndex) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x041e, code lost:
        r1 = r41.movingAwayToStartBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0425, code lost:
        r1 = r41.movingAwayToEndBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x042b, code lost:
        java.lang.Boolean.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x042f, code lost:
        r30 = r1;
        r31 = r2;
        r32 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0437, code lost:
        r12 = r12 >> 8;
        r7 = r32 + 1;
        r1 = r30;
        r2 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0442, code lost:
        r30 = r1;
        r31 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x044a, code lost:
        if (r5 != 8) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        r4 = androidx.compose.ui.unit.IntOffset.m7677constructorimpl(r42 & 4294967295L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x044d, code lost:
        r30 = r1;
        r31 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0455, code lost:
        if (r4 == r3) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0457, code lost:
        r4 = r4 + 1;
        r1 = r30;
        r2 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0467, code lost:
        if (r41.movingAwayToStartBound.isEmpty() != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0469, code lost:
        r1 = r41.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0470, code lost:
        if (r1.size() <= 1) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0472, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2(r46));
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x047c, code lost:
        r1 = r41.movingAwayToStartBound;
        r2 = r1.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        r4 = androidx.compose.ui.unit.IntOffset.m7677constructorimpl(r42 << 32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0486, code lost:
        if (r3 >= r2) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0488, code lost:
        r4 = r1.get(r3);
        r5 = r41.keyToItemInfoMap.get(r4.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r5 = r5;
        r7 = updateAndReturnOffsetFor(r6, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04a1, code lost:
        if (r49 == false) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04a3, code lost:
        r10 = getMainAxisOffset((androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.first((java.util.List<? extends java.lang.Object>) r45));
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x04ae, code lost:
        r10 = r5.getLayoutMinOffset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x04b2, code lost:
        r4.position(r10 - r7, r5.getCrossAxisOffset(), r43, r44);
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x04be, code lost:
        if (r23 == false) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04c0, code lost:
        startPlacementAnimationsIfNeeded(r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04c4, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04c7, code lost:
        r7 = r43;
        r11 = r44;
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r49 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04db, code lost:
        r7 = r43;
        r11 = r44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04e7, code lost:
        if (r41.movingAwayToEndBound.isEmpty() != false) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04e9, code lost:
        r1 = r41.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x04f0, code lost:
        if (r1.size() <= 1) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x04f2, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2(r46));
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x04fc, code lost:
        r1 = r41.movingAwayToEndBound;
        r2 = r1.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0506, code lost:
        if (r3 >= r2) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0508, code lost:
        r4 = r1.get(r3);
        r5 = r41.keyToItemInfoMap.get(r4.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r5 = r5;
        r4.position((r5.getLayoutMaxOffset() - r4.getMainAxisSizeWithSpacings()) + updateAndReturnOffsetFor(r6, r4), r5.getCrossAxisOffset(), r7, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0533, code lost:
        if (r23 == false) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (r51 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0535, code lost:
        startPlacementAnimationsIfNeeded(r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0538, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x053b, code lost:
        r1 = r41.movingAwayToStartBound;
        kotlin.collections.CollectionsKt.reverse(r1);
        r2 = kotlin.Unit.INSTANCE;
        r45.addAll(0, r1);
        r45.addAll(r41.movingAwayToEndBound);
        r41.movingInFromStartBound.clear();
        r41.movingInFromEndBound.clear();
        r41.movingAwayToStartBound.clear();
        r41.movingAwayToEndBound.clear();
        r41.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0568, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        r1 = r41.keyToItemInfoMap;
        r15 = r1.keys;
        r1 = r1.metadata;
        r13 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r13 < 0) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
        r23 = r14;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
        r14 = r1[r12];
        r26 = r1;
        r25 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
        r1 = 8 - ((~(r12 - r13)) >>> 31);
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
        if (r2 >= r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
        if ((r14 & 255) >= 128) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
        r28 = r2;
        r29 = r14;
        r41.movingAwayKeys.add(r15[(r12 << 3) + r2]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
        r28 = r2;
        r29 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        r14 = r29 >> 8;
        r2 = r28 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00be, code lost:
        if (r1 != 8) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c0, code lost:
        if (r12 == r13) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c2, code lost:
        r12 = r12 + 1;
        r2 = r25;
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
        r25 = r2;
        r23 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:
        r1 = r25.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
        if (r2 >= r1) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d5, code lost:
        r14 = r45.get(r2);
        r41.movingAwayKeys.remove(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e8, code lost:
        if (getHasAnimations(r14) == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ea, code lost:
        r24 = r41.keyToItemInfoMap.get(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f8, code lost:
        if (r11 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fa, code lost:
        r13 = r11.getIndex(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0103, code lost:
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0104, code lost:
        if (r13 != (-1)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0106, code lost:
        if (r11 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0108, code lost:
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x010a, code lost:
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010b, code lost:
        if (r24 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010d, code lost:
        r12 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo(r41);
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r12, r14, r54, r55, r52, r53, 0, 32, null);
        r34 = r1;
        r35 = r2;
        r41.keyToItemInfoMap.set(r14.getKey(), r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0138, code lost:
        if (r14.getIndex() == r13) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013b, code lost:
        if (r13 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x013d, code lost:
        if (r13 >= r3) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013f, code lost:
        r1 = r41.movingInFromStartBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0146, code lost:
        r1 = r41.movingInFromEndBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014c, code lost:
        java.lang.Boolean.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0151, code lost:
        r24 = r14.mo931getOffsetBjo55l4(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x015a, code lost:
        if (r14.isVertical() == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x015c, code lost:
        r1 = androidx.compose.ui.unit.IntOffset.m7684getYimpl(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0161, code lost:
        r1 = androidx.compose.ui.unit.IntOffset.m7683getXimpl(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
        initializeAnimation(r14, r1, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0168, code lost:
        if (r15 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016a, code lost:
        r1 = r12.getAnimations();
        r2 = r1.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0170, code lost:
        if (r12 >= r2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0172, code lost:
        r13 = r1[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0174, code lost:
        if (r13 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0176, code lost:
        r13.animateAppearance();
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017b, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017e, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0182, code lost:
        r34 = r1;
        r35 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0186, code lost:
        if (r23 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0188, code lost:
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r24, r14, r54, r55, r52, r53, 0, 32, null);
        r1 = r24.getAnimations();
        r2 = r1.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a1, code lost:
        if (r12 >= r2) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a3, code lost:
        r13 = r1[r12];
        r25 = r1;
        r26 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a9, code lost:
        if (r13 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b9, code lost:
        if (androidx.compose.ui.unit.IntOffset.m7682equalsimpl0(r13.m982getRawOffsetnOccac(), androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.Companion.m986getNotInitializednOccac()) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bb, code lost:
        r13.m985setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffset.m7687plusqkQi6aY(r13.m982getRawOffsetnOccac(), r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c6, code lost:
        r12 = r12 + 1;
        r1 = r25;
        r2 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01cd, code lost:
        if (r15 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01cf, code lost:
        r1 = r24.getAnimations();
        r2 = r1.length;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01d5, code lost:
        if (r6 >= r2) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d7, code lost:
        r7 = r1[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d9, code lost:
        if (r7 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01df, code lost:
        if (r7.isDisappearanceAnimationInProgress() == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e1, code lost:
        r41.disappearingItems.remove(r7);
        r12 = r41.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e8, code lost:
        if (r12 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ea, code lost:
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r12);
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ef, code lost:
        r7.animateAppearance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f2, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f5, code lost:
        startPlacementAnimationsIfNeeded$default(r41, r14, false, 2, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasured(int i, int i2, int i3, List<T> list, final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap, LazyLayoutMeasuredItemProvider<T> lazyLayoutMeasuredItemProvider, boolean z, boolean z2, int i4, boolean z3, int i5, int i6, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap2 = this.keyIndexMap;
        this.keyIndexMap = lazyLayoutKeyIndexMap;
        List<T> list2 = list;
        int size = list2.size();
        int i7 = 0;
        while (true) {
            if (i7 < size) {
                if (getHasAnimations(list.get(i7))) {
                    break;
                }
                i7++;
            } else if (this.keyToItemInfoMap.isEmpty()) {
                releaseAnimations();
                return;
            }
        }
    }

    private final void removeInfoForKey(Object obj) {
        LazyLayoutItemAnimation[] animations;
        LazyLayoutItemAnimator<T>.ItemInfo remove = this.keyToItemInfoMap.remove(obj);
        if (remove == null || (animations = remove.getAnimations()) == null) {
            return;
        }
        for (LazyLayoutItemAnimation lazyLayoutItemAnimation : animations) {
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.release();
            }
        }
    }

    public final void reset() {
        releaseAnimations();
        this.keyIndexMap = null;
        this.firstVisibleIndex = -1;
    }

    private final void releaseAnimations() {
        LazyLayoutItemAnimation[] animations;
        if (this.keyToItemInfoMap.isNotEmpty()) {
            MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> mutableScatterMap = this.keyToItemInfoMap;
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                for (LazyLayoutItemAnimation lazyLayoutItemAnimation : ((ItemInfo) objArr[(i << 3) + i3]).getAnimations()) {
                                    if (lazyLayoutItemAnimation != null) {
                                        lazyLayoutItemAnimation.release();
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            this.keyToItemInfoMap.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void initializeAnimation$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo2 = itemInfo;
        if ((i2 & 4) != 0) {
            LazyLayoutItemAnimator<T>.ItemInfo itemInfo3 = lazyLayoutItemAnimator.keyToItemInfoMap.get(lazyLayoutMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo3);
            itemInfo2 = itemInfo3;
        }
        lazyLayoutItemAnimator.initializeAnimation(lazyLayoutMeasuredItem, i, itemInfo2);
    }

    private final void initializeAnimation(T t, int i, LazyLayoutItemAnimator<T>.ItemInfo itemInfo) {
        long m7679copyiSbpLlY$default;
        int i2 = 0;
        long mo931getOffsetBjo55l4 = t.mo931getOffsetBjo55l4(0);
        if (t.isVertical()) {
            m7679copyiSbpLlY$default = IntOffset.m7679copyiSbpLlY$default(mo931getOffsetBjo55l4, 0, i, 1, null);
        } else {
            m7679copyiSbpLlY$default = IntOffset.m7679copyiSbpLlY$default(mo931getOffsetBjo55l4, i, 0, 2, null);
        }
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i3 = 0;
        while (i2 < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i2];
            int i4 = i3 + 1;
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.m985setRawOffsetgyyYBs(IntOffset.m7687plusqkQi6aY(m7679copyiSbpLlY$default, IntOffset.m7686minusqkQi6aY(t.mo931getOffsetBjo55l4(i3), mo931getOffsetBjo55l4)));
            }
            i2++;
            i3 = i4;
        }
    }

    static /* synthetic */ void startPlacementAnimationsIfNeeded$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        lazyLayoutItemAnimator.startPlacementAnimationsIfNeeded(lazyLayoutMeasuredItem, z);
    }

    private final void startPlacementAnimationsIfNeeded(T t, boolean z) {
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(t.getKey());
        Intrinsics.checkNotNull(itemInfo);
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutItemAnimation != null) {
                long mo931getOffsetBjo55l4 = t.mo931getOffsetBjo55l4(i2);
                long m982getRawOffsetnOccac = lazyLayoutItemAnimation.m982getRawOffsetnOccac();
                if (!IntOffset.m7682equalsimpl0(m982getRawOffsetnOccac, LazyLayoutItemAnimation.Companion.m986getNotInitializednOccac()) && !IntOffset.m7682equalsimpl0(m982getRawOffsetnOccac, mo931getOffsetBjo55l4)) {
                    lazyLayoutItemAnimation.m978animatePlacementDeltaar5cAso(IntOffset.m7686minusqkQi6aY(mo931getOffsetBjo55l4, m982getRawOffsetnOccac), z);
                }
                lazyLayoutItemAnimation.m985setRawOffsetgyyYBs(mo931getOffsetBjo55l4);
            }
            i++;
            i2 = i3;
        }
    }

    public final LazyLayoutItemAnimation getAnimation(Object obj, int i) {
        LazyLayoutItemAnimation[] animations;
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[i];
    }

    private final int updateAndReturnOffsetFor(int[] iArr, T t) {
        int lane = t.getLane();
        int span = t.getSpan() + lane;
        int i = 0;
        while (lane < span) {
            int mainAxisSizeWithSpacings = iArr[lane] + t.getMainAxisSizeWithSpacings();
            iArr[lane] = mainAxisSizeWithSpacings;
            i = Math.max(i, mainAxisSizeWithSpacings);
            lane++;
        }
        return i;
    }

    /* renamed from: getMinSizeToFitDisappearingItems-YbymL2g  reason: not valid java name */
    public final long m987getMinSizeToFitDisappearingItemsYbymL2g() {
        long m7731getZeroYbymL2g = IntSize.Companion.m7731getZeroYbymL2g();
        List<LazyLayoutItemAnimation> list = this.disappearingItems;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = list.get(i);
            GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
            if (layer != null) {
                int max = Math.max((int) (m7731getZeroYbymL2g >> 32), IntOffset.m7683getXimpl(lazyLayoutItemAnimation.m982getRawOffsetnOccac()) + ((int) (layer.m5437getSizeYbymL2g() >> 32)));
                m7731getZeroYbymL2g = IntSize.m7721constructorimpl((Math.max((int) (m7731getZeroYbymL2g & 4294967295L), IntOffset.m7684getYimpl(lazyLayoutItemAnimation.m982getRawOffsetnOccac()) + ((int) (layer.m5437getSizeYbymL2g() & 4294967295L))) & 4294967295L) | (max << 32));
            }
        }
        return m7731getZeroYbymL2g;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    private final boolean getHasAnimations(T t) {
        int placeablesCount = t.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (LazyLayoutItemAnimatorKt.access$getSpecs(t.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    private final int getMainAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo931getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo931getOffsetBjo55l4(0);
        return lazyLayoutMeasuredItem.isVertical() ? IntOffset.m7684getYimpl(mo931getOffsetBjo55l4) : IntOffset.m7683getXimpl(mo931getOffsetBjo55l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo931getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo931getOffsetBjo55l4(0);
        return !lazyLayoutMeasuredItem.isVertical() ? IntOffset.m7684getYimpl(mo931getOffsetBjo55l4) : IntOffset.m7683getXimpl(mo931getOffsetBjo55l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyLayoutItemAnimator.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010+R0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u001e\u0010 \u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u001e\u0010\"\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "value", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "crossAxisOffset", "", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "lane", "getLane", "setLane", TtmlNode.TAG_SPAN, "getSpan", "setSpan", "isRunningPlacement", "", "()Z", "layoutMinOffset", "getLayoutMinOffset", "layoutMaxOffset", "getLayoutMaxOffset", "updateAnimation", "", "positionedItem", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class ItemInfo {
        private Constraints constraints;
        private int crossAxisOffset;
        private int lane;
        private int layoutMaxOffset;
        private int layoutMinOffset;
        private LazyLayoutItemAnimation[] animations = LazyLayoutItemAnimatorKt.access$getEmptyArray$p();
        private int span = 1;

        public ItemInfo() {
        }

        public final LazyLayoutItemAnimation[] getAnimations() {
            return this.animations;
        }

        /* renamed from: getConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m989getConstraintsDWUhwKw() {
            return this.constraints;
        }

        /* renamed from: setConstraints-_Sx5XlM  reason: not valid java name */
        public final void m990setConstraints_Sx5XlM(Constraints constraints) {
            this.constraints = constraints;
        }

        public final int getCrossAxisOffset() {
            return this.crossAxisOffset;
        }

        public final void setCrossAxisOffset(int i) {
            this.crossAxisOffset = i;
        }

        public final int getLane() {
            return this.lane;
        }

        public final void setLane(int i) {
            this.lane = i;
        }

        public final int getSpan() {
            return this.span;
        }

        public final void setSpan(int i) {
            this.span = i;
        }

        private final boolean isRunningPlacement() {
            LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr;
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : this.animations) {
                if (lazyLayoutItemAnimation != null && lazyLayoutItemAnimation.isRunningMovingAwayAnimation()) {
                    return true;
                }
            }
            return false;
        }

        public final int getLayoutMinOffset() {
            return this.layoutMinOffset;
        }

        public final int getLayoutMaxOffset() {
            return this.layoutMaxOffset;
        }

        public static /* synthetic */ void updateAnimation$default(ItemInfo itemInfo, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 32) != 0) {
                i3 = LazyLayoutItemAnimator.this.getCrossAxisOffset(lazyLayoutMeasuredItem);
            }
            itemInfo.updateAnimation(lazyLayoutMeasuredItem, coroutineScope, graphicsContext, i, i2, i3);
        }

        public final void updateAnimation(T t, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i, int i2, int i3) {
            LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr;
            if (!isRunningPlacement()) {
                this.layoutMinOffset = i;
                this.layoutMaxOffset = i2;
            }
            int placeablesCount = t.getPlaceablesCount();
            int length = this.animations.length;
            while (true) {
                lazyLayoutItemAnimationArr = this.animations;
                if (placeablesCount >= length) {
                    break;
                }
                LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArr[placeablesCount];
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.release();
                }
                placeablesCount++;
            }
            if (lazyLayoutItemAnimationArr.length != t.getPlaceablesCount()) {
                Object[] copyOf = Arrays.copyOf(this.animations, t.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.animations = (LazyLayoutItemAnimation[]) copyOf;
            }
            this.constraints = Constraints.m7495boximpl(t.mo930getConstraintsmsEJaDk());
            this.crossAxisOffset = i3;
            this.lane = t.getLane();
            this.span = t.getSpan();
            int placeablesCount2 = t.getPlaceablesCount();
            final LazyLayoutItemAnimator<T> lazyLayoutItemAnimator = LazyLayoutItemAnimator.this;
            for (int i4 = 0; i4 < placeablesCount2; i4++) {
                LazyLayoutAnimationSpecsNode access$getSpecs = LazyLayoutItemAnimatorKt.access$getSpecs(t.getParentData(i4));
                LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr2 = this.animations;
                if (access$getSpecs == null) {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation2 = lazyLayoutItemAnimationArr2[i4];
                    if (lazyLayoutItemAnimation2 != null) {
                        lazyLayoutItemAnimation2.release();
                    }
                    this.animations[i4] = null;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation3 = lazyLayoutItemAnimationArr2[i4];
                    if (lazyLayoutItemAnimation3 == null) {
                        lazyLayoutItemAnimation3 = new LazyLayoutItemAnimation(coroutineScope, graphicsContext, new Function0() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit updateAnimation$lambda$0$0;
                                updateAnimation$lambda$0$0 = LazyLayoutItemAnimator.ItemInfo.updateAnimation$lambda$0$0(LazyLayoutItemAnimator.this);
                                return updateAnimation$lambda$0$0;
                            }
                        });
                        this.animations[i4] = lazyLayoutItemAnimation3;
                    }
                    lazyLayoutItemAnimation3.setFadeInSpec(access$getSpecs.getFadeInSpec());
                    lazyLayoutItemAnimation3.setPlacementSpec(access$getSpecs.getPlacementSpec());
                    lazyLayoutItemAnimation3.setFadeOutSpec(access$getSpecs.getFadeOutSpec());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit updateAnimation$lambda$0$0(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            DrawModifierNode drawModifierNode = lazyLayoutItemAnimator.displayingNode;
            if (drawModifierNode != null) {
                DrawModifierNodeKt.invalidateDraw(drawModifierNode);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LazyLayoutItemAnimator.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\f\u0010\u000b\u001a\u00020\t*\u00020\fH\u0016J\r\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class DisplayingDisappearingItemsElement extends ModifierNodeElement<DisplayingDisappearingItemsNode> {
        private final LazyLayoutItemAnimator<?> animator;

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DisplayingDisappearingItemsElement copy$default(DisplayingDisappearingItemsElement displayingDisappearingItemsElement, LazyLayoutItemAnimator lazyLayoutItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyLayoutItemAnimator = displayingDisappearingItemsElement.animator;
            }
            return displayingDisappearingItemsElement.copy(lazyLayoutItemAnimator);
        }

        public final DisplayingDisappearingItemsElement copy(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            return new DisplayingDisappearingItemsElement(lazyLayoutItemAnimator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement) obj).animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public DisplayingDisappearingItemsNode create() {
            return new DisplayingDisappearingItemsNode(this.animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(DisplayingDisappearingItemsNode displayingDisappearingItemsNode) {
            displayingDisappearingItemsNode.setAnimator(this.animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("DisplayingDisappearingItemsElement");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyLayoutItemAnimator.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004J\r\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onAttach", "onDetach", "setAnimator", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {
        private LazyLayoutItemAnimator<?> animator;

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DisplayingDisappearingItemsNode copy$default(DisplayingDisappearingItemsNode displayingDisappearingItemsNode, LazyLayoutItemAnimator lazyLayoutItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyLayoutItemAnimator = displayingDisappearingItemsNode.animator;
            }
            return displayingDisappearingItemsNode.copy(lazyLayoutItemAnimator);
        }

        public final DisplayingDisappearingItemsNode copy(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            return new DisplayingDisappearingItemsNode(lazyLayoutItemAnimator);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode) obj).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsNode(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public void draw(ContentDrawScope contentDrawScope) {
            List list = ((LazyLayoutItemAnimator) this.animator).disappearingItems;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) list.get(i);
                GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
                if (layer != null) {
                    ContentDrawScope contentDrawScope2 = contentDrawScope;
                    float m7683getXimpl = IntOffset.m7683getXimpl(lazyLayoutItemAnimation.m979getFinalOffsetnOccac()) - IntOffset.m7683getXimpl(layer.m5439getTopLeftnOccac());
                    float m7684getYimpl = IntOffset.m7684getYimpl(lazyLayoutItemAnimation.m979getFinalOffsetnOccac()) - IntOffset.m7684getYimpl(layer.m5439getTopLeftnOccac());
                    contentDrawScope2.getDrawContext().getTransform().translate(m7683getXimpl, m7684getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(contentDrawScope2, layer);
                    } finally {
                        contentDrawScope2.getDrawContext().getTransform().translate(-m7683getXimpl, -m7684getYimpl);
                    }
                }
            }
            contentDrawScope.drawContent();
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            ((LazyLayoutItemAnimator) this.animator).displayingNode = this;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onDetach() {
            this.animator.reset();
        }

        public final void setAnimator(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            if (Intrinsics.areEqual(this.animator, lazyLayoutItemAnimator) || !getNode().isAttached()) {
                return;
            }
            this.animator.reset();
            ((LazyLayoutItemAnimator) lazyLayoutItemAnimator).displayingNode = this;
            this.animator = lazyLayoutItemAnimator;
        }
    }
}
