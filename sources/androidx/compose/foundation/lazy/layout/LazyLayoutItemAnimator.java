package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
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
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003JKLB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000bJ1\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u000b2\u0012\b\u0002\u0010.\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u0010/J\u0082\u0001\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\r2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020,H\u0002J\u0010\u0010B\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0006\u0010C\u001a\u00020,J\u001f\u0010D\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\b\b\u0002\u0010E\u001a\u00020#H\u0002¢\u0006\u0002\u0010FJ\u0019\u0010G\u001a\u00020\u000b*\u00020H2\u0006\u0010-\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010IR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u00020\u00128Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020#*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "()V", "disappearingItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "crossAxisOffset", "getCrossAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "mainAxisOffset", "getMainAxisOffset", "getAnimation", "key", "placeableIndex", "initializeAnimation", "", "item", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "releaseAnimations", "removeInfoForKey", "reset", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "updateAndReturnOffsetFor", "", "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "ItemInfo", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0212, code lost:
        r6 = new int[r51];
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0214, code lost:
        if (r24 == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0216, code lost:
        if (r11 == null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0220, code lost:
        if (r42.movingInFromStartBound.isEmpty() != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0222, code lost:
        r1 = r42.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0229, code lost:
        if (r1.size() <= 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x022b, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0235, code lost:
        r7 = r42.movingInFromStartBound;
        r12 = r7.size();
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x023f, code lost:
        if (r13 >= r12) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0241, code lost:
        r1 = r7.get(r13);
        initializeAnimation$default(r42, r1, r53 - updateAndReturnOffsetFor(r6, r1), null, 4, null);
        startPlacementAnimationsIfNeeded$default(r42, r1, false, 2, null);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x025c, code lost:
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0273, code lost:
        if (r42.movingInFromEndBound.isEmpty() != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0275, code lost:
        r1 = r42.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x027c, code lost:
        if (r1.size() <= 1) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x027e, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0288, code lost:
        r7 = r42.movingInFromEndBound;
        r12 = r7.size();
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0292, code lost:
        if (r13 >= r12) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0294, code lost:
        r1 = r7.get(r13);
        initializeAnimation$default(r42, r1, (r54 + updateAndReturnOffsetFor(r6, r1)) - r1.getMainAxisSizeWithSpacings(), null, 4, null);
        startPlacementAnimationsIfNeeded$default(r42, r1, false, 2, null);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02b4, code lost:
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02c3, code lost:
        r1 = r42.movingAwayKeys;
        r2 = r1.elements;
        r1 = r1.metadata;
        r3 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02ce, code lost:
        if (r3 < 0) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02d0, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02d1, code lost:
        r12 = r1[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02db, code lost:
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02dd, code lost:
        r5 = 8 - ((~(r4 - r3)) >>> 31);
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02e7, code lost:
        if (r7 >= r5) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02ed, code lost:
        if ((r12 & 255) >= 128) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        r3 = r42.firstVisibleIndex;
        r4 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List<? extends java.lang.Object>) r46);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02ef, code lost:
        r14 = r2[(r4 << 3) + r7];
        r15 = r42.keyToItemInfoMap.get(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02fc, code lost:
        if (r15 != null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0300, code lost:
        r31 = r1;
        r1 = r47.getIndex(r14);
        r32 = r2;
        r15.setSpan(java.lang.Math.min(r51, r15.getSpan()));
        r33 = r7;
        r15.setLane(java.lang.Math.min(r51 - r15.getSpan(), r15.getLane()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0327, code lost:
        if (r1 != (-1)) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0329, code lost:
        r1 = r15.getAnimations();
        r7 = r1.length;
        r2 = 0;
        r25 = false;
        r26 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0333, code lost:
        if (r2 >= r7) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0335, code lost:
        r49 = r1;
        r1 = r49[r2];
        r27 = r26 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x033b, code lost:
        if (r1 == null) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r4 == null) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0341, code lost:
        if (r1.isDisappearanceAnimationInProgress() == false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0343, code lost:
        r28 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0345, code lost:
        r25 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x034e, code lost:
        if (r1.isDisappearanceAnimationFinished() == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0350, code lost:
        r1.release();
        r15.getAnimations()[r26] = null;
        r28 = r2;
        r42.disappearingItems.remove(r1);
        r1 = r42.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0364, code lost:
        if (r1 == null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0366, code lost:
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x036c, code lost:
        r28 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        r4 = r4.getIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0372, code lost:
        if (r1.getLayer() == null) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0374, code lost:
        r1.animateDisappearance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x037b, code lost:
        if (r1.isDisappearanceAnimationInProgress() == false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x037d, code lost:
        r42.disappearingItems.add(r1);
        r1 = r42.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0384, code lost:
        if (r1 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0386, code lost:
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x038c, code lost:
        r1.release();
        r15.getAnimations()[r26] = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0398, code lost:
        r28 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x039b, code lost:
        r2 = r28 + 1;
        r1 = r49;
        r26 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03a4, code lost:
        if (r25 != false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03a6, code lost:
        removeInfoForKey(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03ab, code lost:
        r2 = r15.m907getConstraintsDWUhwKw();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r1 = r48.mo854getAndMeasurehBUhpc(r1, r15.getLane(), r15.getSpan(), r2.m6643unboximpl());
        r1.setNonScrollableItem(true);
        r7 = r15.getAnimations();
        r1 = r7.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03d8, code lost:
        if (r7 >= r1) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03da, code lost:
        r25 = r7[r7];
        r26 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03de, code lost:
        if (r25 == null) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03e0, code lost:
        r1 = r25.isPlacementAnimationInProgress();
        r25 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03e7, code lost:
        if (r1 != true) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        r42.firstVisibleIndex = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03ea, code lost:
        r25 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x03ec, code lost:
        r7 = r25 + 1;
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03f1, code lost:
        if (r11 == null) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03f7, code lost:
        if (r1 != r11.getIndex(r14)) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03f9, code lost:
        removeInfoForKey(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03fd, code lost:
        r15.updateAnimation(r1, r55, r56, r53, r54, r15.getCrossAxisOffset());
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0412, code lost:
        if (r1 >= r42.firstVisibleIndex) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0414, code lost:
        r42.movingAwayToStartBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x041a, code lost:
        r42.movingAwayToEndBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r49 == false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0420, code lost:
        r31 = r1;
        r32 = r2;
        r33 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0428, code lost:
        r12 = r12 >> 8;
        r7 = r33 + 1;
        r1 = r31;
        r2 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0433, code lost:
        r31 = r1;
        r32 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x043b, code lost:
        if (r5 != 8) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x043e, code lost:
        r31 = r1;
        r32 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0446, code lost:
        if (r4 == r3) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0448, code lost:
        r4 = r4 + 1;
        r1 = r31;
        r2 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0458, code lost:
        if (r42.movingAwayToStartBound.isEmpty() != false) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        r4 = androidx.compose.ui.unit.IntOffset.m6806constructorimpl((r43 & 4294967295L) | (0 << 32));
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x045a, code lost:
        r1 = r42.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0461, code lost:
        if (r1.size() <= 1) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0463, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2(r47));
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x046d, code lost:
        r1 = r42.movingAwayToStartBound;
        r2 = r1.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0477, code lost:
        if (r3 >= r2) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0479, code lost:
        r4 = r1.get(r3);
        r5 = r42.keyToItemInfoMap.get(r4.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r5 = r5;
        r7 = updateAndReturnOffsetFor(r6, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0492, code lost:
        if (r50 == false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0494, code lost:
        r10 = getMainAxisOffset((androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.first((java.util.List<? extends java.lang.Object>) r46));
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x049f, code lost:
        r10 = r5.getLayoutMinOffset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04a3, code lost:
        r4.position(r10 - r7, r5.getCrossAxisOffset(), r44, r45);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
        r4 = androidx.compose.ui.unit.IntOffset.m6806constructorimpl((r43 << 32) | (0 & 4294967295L));
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04af, code lost:
        if (r24 == false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04b1, code lost:
        startPlacementAnimationsIfNeeded(r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04b5, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04b8, code lost:
        r7 = r44;
        r11 = r45;
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x04cc, code lost:
        r7 = r44;
        r11 = r45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x04d8, code lost:
        if (r42.movingAwayToEndBound.isEmpty() != false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04da, code lost:
        r1 = r42.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04e1, code lost:
        if (r1.size() <= 1) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04e3, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2(r47));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r50 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04ed, code lost:
        r1 = r42.movingAwayToEndBound;
        r2 = r1.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04f7, code lost:
        if (r3 >= r2) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04f9, code lost:
        r4 = r1.get(r3);
        r5 = r42.keyToItemInfoMap.get(r4.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r5 = r5;
        r9 = updateAndReturnOffsetFor(r6, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0512, code lost:
        if (r50 == false) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0514, code lost:
        r10 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.last((java.util.List<? extends java.lang.Object>) r46);
        r12 = getMainAxisOffset(r10) + r10.getMainAxisSizeWithSpacings();
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0524, code lost:
        r12 = r5.getLayoutMaxOffset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0528, code lost:
        r4.position((r12 - r4.getMainAxisSizeWithSpacings()) + r9, r5.getCrossAxisOffset(), r7, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0536, code lost:
        if (r24 == false) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0538, code lost:
        startPlacementAnimationsIfNeeded(r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x053b, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
        if (r52 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x053e, code lost:
        r1 = r42.movingAwayToStartBound;
        kotlin.collections.CollectionsKt.reverse(r1);
        r2 = kotlin.Unit.INSTANCE;
        r46.addAll(0, r1);
        r46.addAll(r42.movingAwayToEndBound);
        r42.movingInFromStartBound.clear();
        r42.movingInFromEndBound.clear();
        r42.movingAwayToStartBound.clear();
        r42.movingAwayToEndBound.clear();
        r42.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x056b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
        r1 = r42.keyToItemInfoMap;
        r15 = r1.keys;
        r1 = r1.metadata;
        r13 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        if (r13 < 0) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
        r24 = r14;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008e, code lost:
        r14 = r1[r12];
        r27 = r1;
        r26 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
        r1 = 8 - ((~(r12 - r13)) >>> 31);
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
        if (r2 >= r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ae, code lost:
        if ((r14 & 255) >= 128) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
        r29 = r2;
        r30 = r14;
        r42.movingAwayKeys.add(r15[(r12 << 3) + r2]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c0, code lost:
        r29 = r2;
        r30 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
        r14 = r30 >> 8;
        r2 = r29 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
        if (r1 != 8) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cd, code lost:
        if (r12 == r13) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cf, code lost:
        r12 = r12 + 1;
        r2 = r26;
        r1 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d6, code lost:
        r26 = r2;
        r24 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
        r1 = r26.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
        if (r2 >= r1) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e2, code lost:
        r14 = r46.get(r2);
        r42.movingAwayKeys.remove(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
        if (getHasAnimations(r14) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f7, code lost:
        r25 = r42.keyToItemInfoMap.get(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
        if (r11 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0107, code lost:
        r13 = r11.getIndex(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0110, code lost:
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0111, code lost:
        if (r13 != (-1)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0113, code lost:
        if (r11 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0115, code lost:
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0117, code lost:
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0118, code lost:
        if (r25 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011a, code lost:
        r12 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo(r42);
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r12, r14, r55, r56, r53, r54, 0, 32, null);
        r35 = r1;
        r36 = r2;
        r42.keyToItemInfoMap.set(r14.getKey(), r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0145, code lost:
        if (r14.getIndex() == r13) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0148, code lost:
        if (r13 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014a, code lost:
        if (r13 >= r3) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x014c, code lost:
        r42.movingInFromStartBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0153, code lost:
        r42.movingInFromEndBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015a, code lost:
        r25 = r14.mo852getOffsetBjo55l4(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0163, code lost:
        if (r14.isVertical() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0165, code lost:
        r1 = androidx.compose.ui.unit.IntOffset.m6813getYimpl(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x016a, code lost:
        r1 = androidx.compose.ui.unit.IntOffset.m6812getXimpl(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016e, code lost:
        initializeAnimation(r14, r1, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0171, code lost:
        if (r15 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0173, code lost:
        r1 = r12.getAnimations();
        r2 = r1.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0179, code lost:
        if (r12 >= r2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x017b, code lost:
        r13 = r1[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017d, code lost:
        if (r13 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017f, code lost:
        r13.animateAppearance();
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0184, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0187, code lost:
        r35 = r1;
        r36 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
        if (r24 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x018d, code lost:
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r25, r14, r55, r56, r53, r54, 0, 32, null);
        r1 = r25.getAnimations();
        r2 = r1.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a6, code lost:
        if (r12 >= r2) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a8, code lost:
        r13 = r1[r12];
        r26 = r1;
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ae, code lost:
        if (r13 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01be, code lost:
        if (androidx.compose.ui.unit.IntOffset.m6811equalsimpl0(r13.m901getRawOffsetnOccac(), androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.Companion.m905getNotInitializednOccac()) != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01c0, code lost:
        r13.m904setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffset.m6816plusqkQi6aY(r13.m901getRawOffsetnOccac(), r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01cb, code lost:
        r12 = r12 + 1;
        r1 = r26;
        r2 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01d2, code lost:
        if (r15 == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01d4, code lost:
        r1 = r25.getAnimations();
        r2 = r1.length;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01da, code lost:
        if (r6 >= r2) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01dc, code lost:
        r7 = r1[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01de, code lost:
        if (r7 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e4, code lost:
        if (r7.isDisappearanceAnimationInProgress() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e6, code lost:
        r42.disappearingItems.remove(r7);
        r12 = r42.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ed, code lost:
        if (r12 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ef, code lost:
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r12);
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f4, code lost:
        r7.animateAppearance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f7, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01fa, code lost:
        startPlacementAnimationsIfNeeded$default(r42, r14, false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0201, code lost:
        r35 = r1;
        r36 = r2;
        removeInfoForKey(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x020c, code lost:
        r2 = r36 + 1;
        r1 = r35;
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
        long m6808copyiSbpLlY$default;
        int i2 = 0;
        long mo852getOffsetBjo55l4 = t.mo852getOffsetBjo55l4(0);
        if (t.isVertical()) {
            m6808copyiSbpLlY$default = IntOffset.m6808copyiSbpLlY$default(mo852getOffsetBjo55l4, 0, i, 1, null);
        } else {
            m6808copyiSbpLlY$default = IntOffset.m6808copyiSbpLlY$default(mo852getOffsetBjo55l4, i, 0, 2, null);
        }
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i3 = 0;
        while (i2 < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i2];
            int i4 = i3 + 1;
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.m904setRawOffsetgyyYBs(IntOffset.m6816plusqkQi6aY(m6808copyiSbpLlY$default, IntOffset.m6815minusqkQi6aY(t.mo852getOffsetBjo55l4(i3), mo852getOffsetBjo55l4)));
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
                long mo852getOffsetBjo55l4 = t.mo852getOffsetBjo55l4(i2);
                long m901getRawOffsetnOccac = lazyLayoutItemAnimation.m901getRawOffsetnOccac();
                if (!IntOffset.m6811equalsimpl0(m901getRawOffsetnOccac, LazyLayoutItemAnimation.Companion.m905getNotInitializednOccac()) && !IntOffset.m6811equalsimpl0(m901getRawOffsetnOccac, mo852getOffsetBjo55l4)) {
                    lazyLayoutItemAnimation.m897animatePlacementDeltaar5cAso(IntOffset.m6815minusqkQi6aY(mo852getOffsetBjo55l4, m901getRawOffsetnOccac), z);
                }
                lazyLayoutItemAnimation.m904setRawOffsetgyyYBs(mo852getOffsetBjo55l4);
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
    public final long m906getMinSizeToFitDisappearingItemsYbymL2g() {
        long m6860getZeroYbymL2g = IntSize.Companion.m6860getZeroYbymL2g();
        List<LazyLayoutItemAnimation> list = this.disappearingItems;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = list.get(i);
            GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
            if (layer != null) {
                int max = Math.max((int) (m6860getZeroYbymL2g >> 32), IntOffset.m6812getXimpl(lazyLayoutItemAnimation.m901getRawOffsetnOccac()) + ((int) (layer.m4731getSizeYbymL2g() >> 32)));
                m6860getZeroYbymL2g = IntSize.m6850constructorimpl((Math.max((int) (m6860getZeroYbymL2g & 4294967295L), IntOffset.m6813getYimpl(lazyLayoutItemAnimation.m901getRawOffsetnOccac()) + ((int) (layer.m4731getSizeYbymL2g() & 4294967295L))) & 4294967295L) | (max << 32));
            }
        }
        return m6860getZeroYbymL2g;
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
        long mo852getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo852getOffsetBjo55l4(0);
        return lazyLayoutMeasuredItem.isVertical() ? IntOffset.m6813getYimpl(mo852getOffsetBjo55l4) : IntOffset.m6812getXimpl(mo852getOffsetBjo55l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo852getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo852getOffsetBjo55l4(0);
        return !lazyLayoutMeasuredItem.isVertical() ? IntOffset.m6813getYimpl(mo852getOffsetBjo55l4) : IntOffset.m6812getXimpl(mo852getOffsetBjo55l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyLayoutItemAnimator.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010*R0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "crossAxisOffset", "", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "isRunningPlacement", "", "()Z", "lane", "getLane", "setLane", "layoutMaxOffset", "getLayoutMaxOffset", "layoutMinOffset", "getLayoutMinOffset", TtmlNode.TAG_SPAN, "getSpan", "setSpan", "updateAnimation", "", "positionedItem", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        public final Constraints m907getConstraintsDWUhwKw() {
            return this.constraints;
        }

        /* renamed from: setConstraints-_Sx5XlM  reason: not valid java name */
        public final void m908setConstraints_Sx5XlM(Constraints constraints) {
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
            if (!isRunningPlacement()) {
                this.layoutMinOffset = i;
                this.layoutMaxOffset = i2;
            }
            int length = this.animations.length;
            for (int placeablesCount = t.getPlaceablesCount(); placeablesCount < length; placeablesCount++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = this.animations[placeablesCount];
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.release();
                }
            }
            if (this.animations.length != t.getPlaceablesCount()) {
                Object[] copyOf = Arrays.copyOf(this.animations, t.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.animations = (LazyLayoutItemAnimation[]) copyOf;
            }
            this.constraints = Constraints.m6624boximpl(t.mo851getConstraintsmsEJaDk());
            this.crossAxisOffset = i3;
            this.lane = t.getLane();
            this.span = t.getSpan();
            int placeablesCount2 = t.getPlaceablesCount();
            final LazyLayoutItemAnimator<T> lazyLayoutItemAnimator = LazyLayoutItemAnimator.this;
            for (int i4 = 0; i4 < placeablesCount2; i4++) {
                LazyLayoutAnimationSpecsNode access$getSpecs = LazyLayoutItemAnimatorKt.access$getSpecs(t.getParentData(i4));
                if (access$getSpecs == null) {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.animations[i4];
                    if (lazyLayoutItemAnimation2 != null) {
                        lazyLayoutItemAnimation2.release();
                    }
                    this.animations[i4] = null;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation3 = this.animations[i4];
                    if (lazyLayoutItemAnimation3 == null) {
                        lazyLayoutItemAnimation3 = new LazyLayoutItemAnimation(coroutineScope, graphicsContext, new Function0<Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo$updateAnimation$1$animation$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                DrawModifierNode drawModifierNode;
                                drawModifierNode = ((LazyLayoutItemAnimator) lazyLayoutItemAnimator).displayingNode;
                                if (drawModifierNode != null) {
                                    DrawModifierNodeKt.invalidateDraw(drawModifierNode);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
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
    }

    /* compiled from: LazyLayoutItemAnimator.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\f\u0010\u0014\u001a\u00020\u000f*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "onAttach", "", "onDetach", "setAnimator", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                    float m6812getXimpl = IntOffset.m6812getXimpl(lazyLayoutItemAnimation.m898getFinalOffsetnOccac()) - IntOffset.m6812getXimpl(layer.m4733getTopLeftnOccac());
                    float m6813getYimpl = IntOffset.m6813getYimpl(lazyLayoutItemAnimation.m898getFinalOffsetnOccac()) - IntOffset.m6813getYimpl(layer.m4733getTopLeftnOccac());
                    contentDrawScope2.getDrawContext().getTransform().translate(m6812getXimpl, m6813getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(contentDrawScope2, layer);
                    } finally {
                        contentDrawScope2.getDrawContext().getTransform().translate(-m6812getXimpl, -m6813getYimpl);
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
