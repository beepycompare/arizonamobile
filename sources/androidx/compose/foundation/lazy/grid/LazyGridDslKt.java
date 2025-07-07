package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
/* compiled from: LazyGridDsl.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001a\u001a\u008a\u0001\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001d\u001a~\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0002\u001a\u001d\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010)\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0,2%\b\n\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u000201\u0018\u00010\u001620\b\n\u00102\u001a*\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u000205\u0018\u000103¢\u0006\u0002\b\u00182%\b\n\u00106\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0006\u0012\u0004\u0018\u0001010\u001623\b\u0004\u00107\u001a-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010:\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0 2%\b\n\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u000201\u0018\u00010\u001620\b\n\u00102\u001a*\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u000205\u0018\u000103¢\u0006\u0002\b\u00182%\b\n\u00106\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0006\u0012\u0004\u0018\u0001010\u001623\b\u0004\u00107\u001a-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010;\u001a¯\u0002\u0010<\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0,2:\b\n\u0010-\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u000201\u0018\u0001032E\b\n\u00102\u001a?\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110!¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u000205\u0018\u00010>¢\u0006\u0002\b\u00182:\b\u0006\u00106\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0006\u0012\u0004\u0018\u000101032H\b\u0004\u00107\u001aB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110!¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001a¯\u0002\u0010<\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0 2:\b\n\u0010-\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u000201\u0018\u0001032E\b\n\u00102\u001a?\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110!¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u000205\u0018\u00010>¢\u0006\u0002\b\u00182:\b\u0006\u00106\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0006\u0012\u0004\u0018\u000101032H\b\u0004\u00107\u001aB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110!¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H+¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010@¨\u0006A"}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", FirebaseAnalytics.Param.ITEMS, ExifInterface.GPS_DIRECTION_TRUE, "", "key", "Lkotlin/ParameterName;", "name", "item", "", TtmlNode.TAG_SPAN, "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridDslKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        boolean z3;
        int i7;
        int i8;
        Object obj4;
        int i9;
        int i10;
        Composer composer2;
        final Arrangement.Vertical vertical2;
        final boolean z4;
        final Modifier modifier2;
        final LazyGridState lazyGridState2;
        final PaddingValues paddingValues2;
        final boolean z5;
        final Arrangement.Horizontal horizontal2;
        final FlingBehavior flingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        LazyGridState lazyGridState3;
        Arrangement.Vertical vertical3;
        Arrangement.Horizontal start;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffect3;
        Modifier modifier3;
        LazyGridState lazyGridState4;
        PaddingValues paddingValues3;
        Arrangement.Vertical vertical4;
        FlingBehavior flingBehavior4;
        boolean z6;
        boolean z7;
        int i11;
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-2072102870);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyVerticalGrid)P(!1,5,8,2,7,10,4,3,9,6)81@3848L55,80@3822L510:LazyGridDsl.kt#7791vq");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i15 = i3 & 2;
        if (i15 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    obj2 = lazyGridState;
                    if (startRestartGroup.changed(obj2)) {
                        i14 = 256;
                        i4 |= i14;
                    }
                } else {
                    obj2 = lazyGridState;
                }
                i14 = 128;
                i4 |= i14;
            } else {
                obj2 = lazyGridState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                obj3 = paddingValues;
                i4 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z;
                    i4 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(vertical)) ? 131072 : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i8 = 196608;
                        obj4 = horizontal;
                        i4 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                        if ((i & 12582912) == 0) {
                            if ((i3 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                                i13 = 8388608;
                                i4 |= i13;
                            }
                            i13 = 4194304;
                            i4 |= i13;
                        }
                        i9 = i3 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i & 805306368) == 0) {
                            if ((i3 & 512) == 0 && startRestartGroup.changed(overscrollEffect)) {
                                i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                                i4 |= i12;
                            }
                            i12 = 268435456;
                            i4 |= i12;
                        }
                        if ((i3 & 1024) != 0) {
                            i10 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i10 = i2 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i10 = i2;
                        }
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "69@3290L23,75@3650L15,77@3748L26");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i15 != 0 ? Modifier.Companion : obj;
                                if ((i3 & 4) != 0) {
                                    lazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    lazyGridState3 = obj2;
                                }
                                PaddingValues m731PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj3;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                if ((i3 & 32) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    vertical3 = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                    i4 &= -458753;
                                } else {
                                    vertical3 = vertical;
                                }
                                start = i7 != 0 ? Arrangement.INSTANCE.getStart() : obj4;
                                if ((i3 & 128) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i4 &= -29360129;
                                } else {
                                    flingBehavior3 = flingBehavior;
                                }
                                boolean z8 = i9 == 0 ? z2 : true;
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                    modifier3 = companion;
                                    overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                                } else {
                                    overscrollEffect3 = overscrollEffect;
                                    modifier3 = companion;
                                }
                                lazyGridState4 = lazyGridState3;
                                paddingValues3 = m731PaddingValues0680j_4;
                                vertical4 = vertical3;
                                flingBehavior4 = flingBehavior3;
                                z6 = z3;
                                z7 = z8;
                                i11 = -2072102870;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                }
                                vertical4 = vertical;
                                flingBehavior4 = flingBehavior;
                                z7 = z2;
                                overscrollEffect3 = overscrollEffect;
                                lazyGridState4 = obj2;
                                paddingValues3 = obj3;
                                z6 = z3;
                                start = obj4;
                                i11 = -2072102870;
                                modifier3 = obj;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i11, i4, i10, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:79)");
                            }
                            int i16 = i4 >> 3;
                            composer2 = startRestartGroup;
                            Arrangement.Horizontal horizontal3 = start;
                            LazyGridKt.LazyGrid(modifier3, lazyGridState4, rememberColumnWidthSums(gridCells, start, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112)), paddingValues3, z6, true, flingBehavior4, z7, overscrollEffect3, vertical4, horizontal3, function1, composer2, (i16 & 234881024) | (i16 & 14) | i8 | (i16 & 112) | (i4 & 7168) | (57344 & i4) | (3670016 & i16) | (29360128 & i16) | ((i4 << 12) & 1879048192), ((i4 >> 18) & 14) | ((i10 << 3) & 112), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            lazyGridState2 = lazyGridState4;
                            paddingValues2 = paddingValues3;
                            z5 = z6;
                            flingBehavior2 = flingBehavior4;
                            z4 = z7;
                            overscrollEffect2 = overscrollEffect3;
                            vertical2 = vertical4;
                            horizontal2 = horizontal3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            vertical2 = vertical;
                            z4 = z2;
                            modifier2 = obj;
                            lazyGridState2 = obj2;
                            paddingValues2 = obj3;
                            z5 = z3;
                            horizontal2 = obj4;
                            flingBehavior2 = flingBehavior;
                            overscrollEffect2 = overscrollEffect;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
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

                                public final void invoke(Composer composer3, int i17) {
                                    LazyGridDslKt.LazyVerticalGrid(GridCells.this, modifier2, lazyGridState2, paddingValues2, z5, vertical2, horizontal2, flingBehavior2, z4, overscrollEffect2, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = 196608;
                    obj4 = horizontal;
                    if ((i & 12582912) == 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                    }
                    if ((i & 805306368) == 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                i8 = 196608;
                obj4 = horizontal;
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj3 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            i8 = 196608;
            obj4 = horizontal;
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        obj3 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        i8 = 196608;
        obj4 = horizontal;
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fc  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        GridCells gridCells2;
        int i3;
        LazyGridState lazyGridState2;
        int i4;
        Object obj;
        int i5;
        boolean z3;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        int i8;
        Composer composer2;
        final Modifier modifier2;
        final FlingBehavior flingBehavior2;
        final LazyGridState lazyGridState3;
        final PaddingValues paddingValues2;
        final boolean z4;
        final Arrangement.Vertical vertical2;
        final Arrangement.Horizontal horizontal2;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        Arrangement.Vertical vertical3;
        FlingBehavior flingBehavior3;
        boolean z6;
        Modifier modifier3;
        LazyGridState lazyGridState4;
        PaddingValues paddingValues3;
        Arrangement.Vertical vertical4;
        Arrangement.Horizontal horizontal3;
        boolean z7;
        FlingBehavior flingBehavior4;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1485410512);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)121@5394L26,111@4998L455:LazyGridDsl.kt#7791vq");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            gridCells2 = gridCells;
        } else {
            gridCells2 = gridCells;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(gridCells2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    lazyGridState2 = lazyGridState;
                    if (startRestartGroup.changed(lazyGridState2)) {
                        i12 = 256;
                        i3 |= i12;
                    }
                } else {
                    lazyGridState2 = lazyGridState;
                }
                i12 = 128;
                i3 |= i12;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj = paddingValues;
                i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z;
                    i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj2 = vertical;
                            if (startRestartGroup.changed(obj2)) {
                                i11 = 131072;
                                i3 |= i11;
                            }
                        } else {
                            obj2 = vertical;
                        }
                        i11 = 65536;
                        i3 |= i11;
                    } else {
                        obj2 = vertical;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        obj3 = horizontal;
                        i3 |= startRestartGroup.changed(obj3) ? 1048576 : 524288;
                        if ((i & 12582912) == 0) {
                            if ((i2 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                                i10 = 8388608;
                                i3 |= i10;
                            }
                            i10 = 4194304;
                            i3 |= i10;
                        }
                        i7 = i2 & 256;
                        if (i7 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i8 = i7;
                            i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                            if ((i2 & 512) == 0) {
                                i3 |= 805306368;
                            } else if ((i & 805306368) == 0) {
                                i3 |= startRestartGroup.changedInstance(function1) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "101@4536L23,107@4896L15");
                                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i13 != 0 ? Modifier.Companion : modifier;
                                        if ((i2 & 4) != 0) {
                                            lazyGridState2 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                            i3 &= -897;
                                        }
                                        PaddingValues m731PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj;
                                        if (i5 != 0) {
                                            z3 = false;
                                        }
                                        if ((i2 & 32) != 0) {
                                            Arrangement arrangement = Arrangement.INSTANCE;
                                            vertical3 = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                            i3 &= -458753;
                                        } else {
                                            vertical3 = obj2;
                                        }
                                        Arrangement.Horizontal start = i6 != 0 ? Arrangement.INSTANCE.getStart() : obj3;
                                        if ((i2 & 128) != 0) {
                                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                            i3 &= -29360129;
                                        } else {
                                            flingBehavior3 = flingBehavior;
                                        }
                                        if (i8 != 0) {
                                            modifier3 = companion;
                                            lazyGridState4 = lazyGridState2;
                                            paddingValues3 = m731PaddingValues0680j_4;
                                            horizontal3 = start;
                                            z7 = z3;
                                            flingBehavior4 = flingBehavior3;
                                            z6 = true;
                                            i9 = 1485410512;
                                            vertical4 = vertical3;
                                        } else {
                                            z6 = z2;
                                            modifier3 = companion;
                                            lazyGridState4 = lazyGridState2;
                                            paddingValues3 = m731PaddingValues0680j_4;
                                            vertical4 = vertical3;
                                            horizontal3 = start;
                                            z7 = z3;
                                            flingBehavior4 = flingBehavior3;
                                            i9 = 1485410512;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i2 & 4) != 0) {
                                            i3 &= -897;
                                        }
                                        if ((i2 & 32) != 0) {
                                            i3 &= -458753;
                                        }
                                        if ((i2 & 128) != 0) {
                                            i3 &= -29360129;
                                        }
                                        modifier3 = modifier;
                                        flingBehavior4 = flingBehavior;
                                        z6 = z2;
                                        paddingValues3 = obj;
                                        z7 = z3;
                                        vertical4 = obj2;
                                        horizontal3 = obj3;
                                        i9 = 1485410512;
                                        lazyGridState4 = lazyGridState2;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:110)");
                                    }
                                    composer2 = startRestartGroup;
                                    LazyVerticalGrid(gridCells2, modifier3, lazyGridState4, paddingValues3, z7, vertical4, horizontal3, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, composer2, i3 & 268435454, (i3 >> 27) & 14, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    lazyGridState3 = lazyGridState4;
                                    paddingValues2 = paddingValues3;
                                    z4 = z7;
                                    vertical2 = vertical4;
                                    horizontal2 = horizontal3;
                                    flingBehavior2 = flingBehavior4;
                                    z5 = z6;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    flingBehavior2 = flingBehavior;
                                    lazyGridState3 = lazyGridState2;
                                    paddingValues2 = obj;
                                    z4 = z3;
                                    vertical2 = obj2;
                                    horizontal2 = obj3;
                                    z5 = z2;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$2
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

                                        public final void invoke(Composer composer3, int i14) {
                                            LazyGridDslKt.LazyVerticalGrid(GridCells.this, modifier2, lazyGridState3, paddingValues2, z4, vertical2, horizontal2, flingBehavior2, z5, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i8 = i7;
                        if ((i2 & 512) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    obj3 = horizontal;
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    if ((i2 & 512) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                obj3 = horizontal;
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                }
                i8 = i7;
                if ((i2 & 512) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            obj3 = horizontal;
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i2 & 512) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        obj = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        obj3 = horizontal;
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i2 & 512) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyHorizontalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        boolean z3;
        int i7;
        int i8;
        Object obj4;
        int i9;
        int i10;
        Composer composer2;
        final Arrangement.Horizontal horizontal2;
        final boolean z4;
        final Modifier modifier2;
        final LazyGridState lazyGridState2;
        final PaddingValues paddingValues2;
        final boolean z5;
        final Arrangement.Vertical vertical2;
        final FlingBehavior flingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        LazyGridState lazyGridState3;
        Arrangement.Horizontal horizontal3;
        Arrangement.Vertical top;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffect3;
        Modifier modifier3;
        LazyGridState lazyGridState4;
        PaddingValues paddingValues3;
        Arrangement.Horizontal horizontal4;
        FlingBehavior flingBehavior4;
        boolean z6;
        boolean z7;
        int i11;
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(635941664);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyHorizontalGrid)P(7,4,8,1,6,3,10,2,9,5)170@7819L48,169@7793L504:LazyGridDsl.kt#7791vq");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i15 = i3 & 2;
        if (i15 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    obj2 = lazyGridState;
                    if (startRestartGroup.changed(obj2)) {
                        i14 = 256;
                        i4 |= i14;
                    }
                } else {
                    obj2 = lazyGridState;
                }
                i14 = 128;
                i4 |= i14;
            } else {
                obj2 = lazyGridState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                obj3 = paddingValues;
                i4 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z;
                    i4 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(horizontal)) ? 131072 : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i8 = 196608;
                        obj4 = vertical;
                        i4 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                        if ((i & 12582912) == 0) {
                            if ((i3 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                                i13 = 8388608;
                                i4 |= i13;
                            }
                            i13 = 4194304;
                            i4 |= i13;
                        }
                        i9 = i3 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i & 805306368) == 0) {
                            if ((i3 & 512) == 0 && startRestartGroup.changed(overscrollEffect)) {
                                i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                                i4 |= i12;
                            }
                            i12 = 268435456;
                            i4 |= i12;
                        }
                        if ((i3 & 1024) != 0) {
                            i10 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i10 = i2 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i10 = i2;
                        }
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "158@7264L23,164@7621L15,166@7719L26");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i15 != 0 ? Modifier.Companion : obj;
                                if ((i3 & 4) != 0) {
                                    lazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    lazyGridState3 = obj2;
                                }
                                PaddingValues m731PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj3;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                if ((i3 & 32) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    horizontal3 = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                    i4 &= -458753;
                                } else {
                                    horizontal3 = horizontal;
                                }
                                top = i7 != 0 ? Arrangement.INSTANCE.getTop() : obj4;
                                if ((i3 & 128) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i4 &= -29360129;
                                } else {
                                    flingBehavior3 = flingBehavior;
                                }
                                boolean z8 = i9 == 0 ? z2 : true;
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                    modifier3 = companion;
                                    overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                                } else {
                                    overscrollEffect3 = overscrollEffect;
                                    modifier3 = companion;
                                }
                                lazyGridState4 = lazyGridState3;
                                paddingValues3 = m731PaddingValues0680j_4;
                                horizontal4 = horizontal3;
                                flingBehavior4 = flingBehavior3;
                                z6 = z3;
                                z7 = z8;
                                i11 = 635941664;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                }
                                horizontal4 = horizontal;
                                flingBehavior4 = flingBehavior;
                                z7 = z2;
                                overscrollEffect3 = overscrollEffect;
                                lazyGridState4 = obj2;
                                paddingValues3 = obj3;
                                z6 = z3;
                                top = obj4;
                                i11 = 635941664;
                                modifier3 = obj;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i11, i4, i10, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:168)");
                            }
                            int i16 = i4 >> 15;
                            int i17 = i4 >> 3;
                            composer2 = startRestartGroup;
                            Arrangement.Vertical vertical3 = top;
                            LazyGridKt.LazyGrid(modifier3, lazyGridState4, rememberRowHeightSums(gridCells, top, startRestartGroup, (i4 & 14) | (i16 & 112)), paddingValues3, z6, false, flingBehavior4, z7, overscrollEffect3, vertical3, horizontal4, function1, composer2, (i17 & 234881024) | (i17 & 14) | i8 | (i17 & 112) | (i4 & 7168) | (57344 & i4) | (3670016 & i17) | (29360128 & i17) | ((i4 << 9) & 1879048192), (i16 & 14) | ((i10 << 3) & 112), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            lazyGridState2 = lazyGridState4;
                            paddingValues2 = paddingValues3;
                            z5 = z6;
                            flingBehavior2 = flingBehavior4;
                            z4 = z7;
                            overscrollEffect2 = overscrollEffect3;
                            vertical2 = vertical3;
                            horizontal2 = horizontal4;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal2 = horizontal;
                            z4 = z2;
                            modifier2 = obj;
                            lazyGridState2 = obj2;
                            paddingValues2 = obj3;
                            z5 = z3;
                            vertical2 = obj4;
                            flingBehavior2 = flingBehavior;
                            overscrollEffect2 = overscrollEffect;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1
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

                                public final void invoke(Composer composer3, int i18) {
                                    LazyGridDslKt.LazyHorizontalGrid(GridCells.this, modifier2, lazyGridState2, paddingValues2, z5, horizontal2, vertical2, flingBehavior2, z4, overscrollEffect2, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = 196608;
                    obj4 = vertical;
                    if ((i & 12582912) == 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                    }
                    if ((i & 805306368) == 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                i8 = 196608;
                obj4 = vertical;
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj3 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            i8 = 196608;
            obj4 = vertical;
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        obj3 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        i8 = 196608;
        obj4 = vertical;
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fc  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyHorizontalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        GridCells gridCells2;
        int i3;
        LazyGridState lazyGridState2;
        int i4;
        Object obj;
        int i5;
        boolean z3;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        int i8;
        Composer composer2;
        final Modifier modifier2;
        final FlingBehavior flingBehavior2;
        final LazyGridState lazyGridState3;
        final PaddingValues paddingValues2;
        final boolean z4;
        final Arrangement.Horizontal horizontal2;
        final Arrangement.Vertical vertical2;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        Arrangement.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        boolean z6;
        Modifier modifier3;
        LazyGridState lazyGridState4;
        PaddingValues paddingValues3;
        Arrangement.Horizontal horizontal4;
        Arrangement.Vertical vertical3;
        boolean z7;
        FlingBehavior flingBehavior4;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(2123608858);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)210@9351L26,200@8959L451:LazyGridDsl.kt#7791vq");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            gridCells2 = gridCells;
        } else {
            gridCells2 = gridCells;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(gridCells2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    lazyGridState2 = lazyGridState;
                    if (startRestartGroup.changed(lazyGridState2)) {
                        i12 = 256;
                        i3 |= i12;
                    }
                } else {
                    lazyGridState2 = lazyGridState;
                }
                i12 = 128;
                i3 |= i12;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj = paddingValues;
                i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z;
                    i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj2 = horizontal;
                            if (startRestartGroup.changed(obj2)) {
                                i11 = 131072;
                                i3 |= i11;
                            }
                        } else {
                            obj2 = horizontal;
                        }
                        i11 = 65536;
                        i3 |= i11;
                    } else {
                        obj2 = horizontal;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        obj3 = vertical;
                        i3 |= startRestartGroup.changed(obj3) ? 1048576 : 524288;
                        if ((i & 12582912) == 0) {
                            if ((i2 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                                i10 = 8388608;
                                i3 |= i10;
                            }
                            i10 = 4194304;
                            i3 |= i10;
                        }
                        i7 = i2 & 256;
                        if (i7 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i8 = i7;
                            i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                            if ((i2 & 512) == 0) {
                                i3 |= 805306368;
                            } else if ((i & 805306368) == 0) {
                                i3 |= startRestartGroup.changedInstance(function1) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "190@8500L23,196@8857L15");
                                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i13 != 0 ? Modifier.Companion : modifier;
                                        if ((i2 & 4) != 0) {
                                            lazyGridState2 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                            i3 &= -897;
                                        }
                                        PaddingValues m731PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj;
                                        if (i5 != 0) {
                                            z3 = false;
                                        }
                                        if ((i2 & 32) != 0) {
                                            Arrangement arrangement = Arrangement.INSTANCE;
                                            horizontal3 = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                            i3 &= -458753;
                                        } else {
                                            horizontal3 = obj2;
                                        }
                                        Arrangement.Vertical top = i6 != 0 ? Arrangement.INSTANCE.getTop() : obj3;
                                        if ((i2 & 128) != 0) {
                                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                            i3 &= -29360129;
                                        } else {
                                            flingBehavior3 = flingBehavior;
                                        }
                                        if (i8 != 0) {
                                            modifier3 = companion;
                                            lazyGridState4 = lazyGridState2;
                                            paddingValues3 = m731PaddingValues0680j_4;
                                            vertical3 = top;
                                            z7 = z3;
                                            flingBehavior4 = flingBehavior3;
                                            z6 = true;
                                            i9 = 2123608858;
                                            horizontal4 = horizontal3;
                                        } else {
                                            z6 = z2;
                                            modifier3 = companion;
                                            lazyGridState4 = lazyGridState2;
                                            paddingValues3 = m731PaddingValues0680j_4;
                                            horizontal4 = horizontal3;
                                            vertical3 = top;
                                            z7 = z3;
                                            flingBehavior4 = flingBehavior3;
                                            i9 = 2123608858;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i2 & 4) != 0) {
                                            i3 &= -897;
                                        }
                                        if ((i2 & 32) != 0) {
                                            i3 &= -458753;
                                        }
                                        if ((i2 & 128) != 0) {
                                            i3 &= -29360129;
                                        }
                                        modifier3 = modifier;
                                        flingBehavior4 = flingBehavior;
                                        z6 = z2;
                                        paddingValues3 = obj;
                                        z7 = z3;
                                        horizontal4 = obj2;
                                        vertical3 = obj3;
                                        i9 = 2123608858;
                                        lazyGridState4 = lazyGridState2;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:199)");
                                    }
                                    composer2 = startRestartGroup;
                                    LazyHorizontalGrid(gridCells2, modifier3, lazyGridState4, paddingValues3, z7, horizontal4, vertical3, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, composer2, i3 & 268435454, (i3 >> 27) & 14, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    lazyGridState3 = lazyGridState4;
                                    paddingValues2 = paddingValues3;
                                    z4 = z7;
                                    horizontal2 = horizontal4;
                                    vertical2 = vertical3;
                                    flingBehavior2 = flingBehavior4;
                                    z5 = z6;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    flingBehavior2 = flingBehavior;
                                    lazyGridState3 = lazyGridState2;
                                    paddingValues2 = obj;
                                    z4 = z3;
                                    horizontal2 = obj2;
                                    vertical2 = obj3;
                                    z5 = z2;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$2
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

                                        public final void invoke(Composer composer3, int i14) {
                                            LazyGridDslKt.LazyHorizontalGrid(GridCells.this, modifier2, lazyGridState3, paddingValues2, z4, horizontal2, vertical2, flingBehavior2, z5, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i8 = i7;
                        if ((i2 & 512) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    obj3 = vertical;
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    if ((i2 & 512) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                obj3 = vertical;
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                }
                i8 = i7;
                if ((i2 & 512) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            obj3 = vertical;
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i2 & 512) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        obj = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        obj3 = vertical;
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i2 & 512) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells gridCells, final Arrangement.Horizontal horizontal, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -76500289, "C(rememberColumnWidthSums)221@9590L872:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-76500289, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:221)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2102949461, "CC(remember):LazyGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i & 48) == 32);
        GridSlotCache rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberColumnWidthSums$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m872invoke0kLqBqw(density, constraints.m6643unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final LazyGridSlots m872invoke0kLqBqw(Density density, long j) {
                    if (!(Constraints.m6637getMaxWidthimpl(j) != Integer.MAX_VALUE)) {
                        InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
                    }
                    int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j);
                    GridCells gridCells2 = GridCells.this;
                    Arrangement.Horizontal horizontal2 = horizontal;
                    int[] intArray = CollectionsKt.toIntArray(gridCells2.calculateCrossAxisCellSizes(density, m6637getMaxWidthimpl, density.mo383roundToPx0680j_4(horizontal2.mo625getSpacingD9Ej5fM())));
                    int[] iArr = new int[intArray.length];
                    horizontal2.arrange(density, m6637getMaxWidthimpl, intArray, LayoutDirection.Ltr, iArr);
                    return new LazyGridSlots(intArray, iArr);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridSlotsProvider;
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(final GridCells gridCells, final Arrangement.Vertical vertical, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -150818144, "C(rememberRowHeightSums)248@10619L772:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-150818144, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:248)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -380097672, "CC(remember):LazyGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(vertical)) || (i & 48) == 32);
        GridSlotCache rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberRowHeightSums$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m873invoke0kLqBqw(density, constraints.m6643unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final LazyGridSlots m873invoke0kLqBqw(Density density, long j) {
                    if (!(Constraints.m6636getMaxHeightimpl(j) != Integer.MAX_VALUE)) {
                        InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.");
                    }
                    int m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(j);
                    GridCells gridCells2 = GridCells.this;
                    Arrangement.Vertical vertical2 = vertical;
                    int[] intArray = CollectionsKt.toIntArray(gridCells2.calculateCrossAxisCellSizes(density, m6636getMaxHeightimpl, density.mo383roundToPx0680j_4(vertical2.mo625getSpacingD9Ej5fM())));
                    int[] iArr = new int[intArray.length];
                    vertical2.arrange(density, m6636getMaxHeightimpl, intArray, iArr);
                    return new LazyGridSlots(intArray, iArr);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke((LazyGridDslKt$items$1) obj2);
                }
            };
        }
        lazyGridScope.items(list.size(), function1 != null ? new LazyGridDslKt$items$2(function1, list) : null, function2 != null ? new LazyGridDslKt$items$3(function2, list) : null, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(list.size(), function1 != null ? new LazyGridDslKt$items$2(function1, list) : null, function2 != null ? new LazyGridDslKt$items$3(function2, list) : null, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyGridScope.items(list.size(), function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$3(function3, list) : null, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(list.size(), function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$3(function3, list) : null, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$6
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke((LazyGridDslKt$items$6) obj2);
                }
            };
        }
        lazyGridScope.items(objArr.length, function1 != null ? new LazyGridDslKt$items$7(function1, objArr) : null, function2 != null ? new LazyGridDslKt$items$8(function2, objArr) : null, new LazyGridDslKt$items$9(function12, objArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(tArr.length, function1 != null ? new LazyGridDslKt$items$7(function1, tArr) : null, function2 != null ? new LazyGridDslKt$items$8(function2, tArr) : null, new LazyGridDslKt$items$9(function12, tArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$6
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyGridScope.items(objArr.length, function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, objArr) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$8(function3, objArr) : null, new LazyGridDslKt$itemsIndexed$9(function22, objArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(tArr.length, function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, tArr) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$8(function3, tArr) : null, new LazyGridDslKt$itemsIndexed$9(function22, tArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, tArr)));
    }
}
