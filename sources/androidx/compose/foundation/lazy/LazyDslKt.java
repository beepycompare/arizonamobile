package androidx.compose.foundation.lazy;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
/* compiled from: LazyDsl.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0018\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0019\u001al\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001f\u001a\u0082\u0001\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010 \u001av\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010!\u001a©\u0001\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0$2%\b\n\u0010%\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010\u00112%\b\n\u0010*\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010)0\u001123\b\u0004\u0010+\u001a-\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u0010/\u001a\u0082\u0001\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0$2%\b\n\u0010%\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010\u001123\b\u0004\u0010+\u001a-\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00100\u001a©\u0001\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#012%\b\n\u0010%\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010\u00112%\b\n\u0010*\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010)0\u001123\b\u0004\u0010+\u001a-\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u00102\u001a\u0082\u0001\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#012%\b\n\u0010%\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010\u001123\b\u0004\u0010+\u001a-\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00103\u001aè\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0$2:\b\n\u0010%\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010,2:\b\u0006\u0010*\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010)0,2H\b\u0004\u0010+\u001aB\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u00108\u001a¬\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0$2:\b\n\u0010%\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010,2H\b\u0004\u0010+\u001aB\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00109\u001aè\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#012:\b\n\u0010%\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010,2:\b\u0006\u0010*\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010)0,2H\b\u0004\u0010+\u001aB\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u0010:\u001a¬\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#012:\b\n\u0010%\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010,2H\b\u0004\u0010+\u001aB\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u0010;¨\u0006<"}, d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", FirebaseAnalytics.Param.ITEMS, ExifInterface.GPS_DIRECTION_TRUE, "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyDslKt {
    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyDslKt$items$1.INSTANCE;
        }
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static final <T> void items(LazyListScope lazyListScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyDslKt$items$5.INSTANCE;
        }
        lazyListScope.items(objArr.length, function1 != null ? new LazyDslKt$items$6(function1, objArr) : null, new LazyDslKt$items$7(function12, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, objArr)));
    }

    public static final <T> void items(LazyListScope lazyListScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(tArr.length, function1 != null ? new LazyDslKt$items$6(function1, tArr) : null, new LazyDslKt$items$7(function12, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$5
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyListScope.items(objArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, objArr) : null, new LazyDslKt$itemsIndexed$7(function22, objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(tArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, tArr) : null, new LazyDslKt$itemsIndexed$7(function22, tArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, tArr)));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyListState lazyListState2;
        Object obj;
        int i4;
        boolean z3;
        Object obj2;
        int i5;
        Object obj3;
        Object obj4;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues2;
        final boolean z5;
        final Arrangement.Horizontal horizontal2;
        final Alignment.Vertical vertical2;
        final FlingBehavior flingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        Arrangement.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffect3;
        Modifier modifier3;
        LazyListState lazyListState4;
        PaddingValues paddingValues3;
        Arrangement.Horizontal horizontal4;
        Alignment.Vertical vertical3;
        boolean z6;
        boolean z7;
        int i8;
        FlingBehavior flingBehavior4;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1884325601);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyRow)P(4,7,1,6,3,9,2,8,5)340@17470L434:LazyDsl.kt#428nma");
        int i13 = i2 & 1;
        if (i13 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                if (startRestartGroup.changed(lazyListState2)) {
                    i12 = 32;
                    i3 |= i12;
                }
            } else {
                lazyListState2 = lazyListState;
            }
            i12 = 16;
            i3 |= i12;
        } else {
            lazyListState2 = lazyListState;
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = paddingValues;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = horizontal;
                        if (startRestartGroup.changed(obj2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        obj2 = horizontal;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    obj2 = horizontal;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = vertical;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj4 = flingBehavior;
                            if (startRestartGroup.changed(obj4)) {
                                i10 = 1048576;
                                i3 |= i10;
                            }
                        } else {
                            obj4 = flingBehavior;
                        }
                        i10 = 524288;
                        i3 |= i10;
                    } else {
                        obj4 = flingBehavior;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i7 = i6;
                        i3 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                        if ((i & 100663296) == 0) {
                            if ((i2 & 256) == 0 && startRestartGroup.changed(overscrollEffect)) {
                                i9 = 67108864;
                                i3 |= i9;
                            }
                            i9 = 33554432;
                            i3 |= i9;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "329@16947L23,335@17298L15,337@17396L26");
                                if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i13 != 0 ? Modifier.Companion : modifier;
                                    if ((i2 & 2) != 0) {
                                        lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                        i3 &= -113;
                                    }
                                    PaddingValues m731PaddingValues0680j_4 = i14 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj;
                                    if (i4 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 16) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        horizontal3 = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                        i3 &= -57345;
                                    } else {
                                        horizontal3 = obj2;
                                    }
                                    Alignment.Vertical top = i5 != 0 ? Alignment.Companion.getTop() : obj3;
                                    if ((i2 & 64) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -3670017;
                                    } else {
                                        flingBehavior3 = obj4;
                                    }
                                    boolean z8 = i7 == 0 ? z2 : true;
                                    if ((i2 & 256) != 0) {
                                        i3 &= -234881025;
                                        modifier3 = companion;
                                        overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                                    } else {
                                        overscrollEffect3 = overscrollEffect;
                                        modifier3 = companion;
                                    }
                                    lazyListState4 = lazyListState2;
                                    paddingValues3 = m731PaddingValues0680j_4;
                                    horizontal4 = horizontal3;
                                    vertical3 = top;
                                    z6 = z3;
                                    z7 = z8;
                                    i8 = -1884325601;
                                    flingBehavior4 = flingBehavior3;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 2) != 0) {
                                        i3 &= -113;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    if ((i2 & 256) != 0) {
                                        i3 &= -234881025;
                                    }
                                    modifier3 = modifier;
                                    z7 = z2;
                                    overscrollEffect3 = overscrollEffect;
                                    z6 = z3;
                                    horizontal4 = obj2;
                                    vertical3 = obj3;
                                    flingBehavior4 = obj4;
                                    i8 = -1884325601;
                                    lazyListState4 = lazyListState2;
                                    paddingValues3 = obj;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:339)");
                                }
                                int i15 = i3 >> 3;
                                composer2 = startRestartGroup;
                                LazyListKt.LazyList(modifier3, lazyListState4, paddingValues3, z6, false, flingBehavior4, z7, overscrollEffect3, 0, null, null, vertical3, horizontal4, function1, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i15) | (3670016 & i15) | (i15 & 29360128), ((i3 >> 12) & 112) | ((i3 >> 6) & 896) | ((i3 >> 18) & 7168), 1792);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                lazyListState3 = lazyListState4;
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
                                modifier2 = modifier;
                                z4 = z2;
                                lazyListState3 = lazyListState2;
                                paddingValues2 = obj;
                                z5 = z3;
                                horizontal2 = obj2;
                                vertical2 = obj3;
                                flingBehavior2 = obj4;
                                overscrollEffect2 = overscrollEffect;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1
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

                                    public final void invoke(Composer composer3, int i16) {
                                        LazyDslKt.LazyRow(Modifier.this, lazyListState3, paddingValues2, z5, horizontal2, vertical2, flingBehavior2, z4, overscrollEffect2, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i7 = i6;
                    if ((i & 100663296) == 0) {
                    }
                    if ((i2 & 512) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = vertical;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i6;
                if ((i & 100663296) == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = vertical;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i6;
            if ((i & 100663296) == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = paddingValues;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = vertical;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i6;
        if ((i & 100663296) == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyListState lazyListState2;
        Object obj;
        int i4;
        boolean z3;
        Object obj2;
        int i5;
        Object obj3;
        Object obj4;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues2;
        final boolean z5;
        final Arrangement.Vertical vertical2;
        final Alignment.Horizontal horizontal2;
        final FlingBehavior flingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        Arrangement.Vertical vertical3;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffect3;
        Modifier modifier3;
        LazyListState lazyListState4;
        PaddingValues paddingValues3;
        Arrangement.Vertical vertical4;
        Alignment.Horizontal horizontal3;
        boolean z6;
        boolean z7;
        int i8;
        FlingBehavior flingBehavior4;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(53695811);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyColumn)P(4,7,1,6,9,3,2,8,5)400@20785L433:LazyDsl.kt#428nma");
        int i13 = i2 & 1;
        if (i13 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                if (startRestartGroup.changed(lazyListState2)) {
                    i12 = 32;
                    i3 |= i12;
                }
            } else {
                lazyListState2 = lazyListState;
            }
            i12 = 16;
            i3 |= i12;
        } else {
            lazyListState2 = lazyListState;
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = paddingValues;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = vertical;
                        if (startRestartGroup.changed(obj2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        obj2 = vertical;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    obj2 = vertical;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = horizontal;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj4 = flingBehavior;
                            if (startRestartGroup.changed(obj4)) {
                                i10 = 1048576;
                                i3 |= i10;
                            }
                        } else {
                            obj4 = flingBehavior;
                        }
                        i10 = 524288;
                        i3 |= i10;
                    } else {
                        obj4 = flingBehavior;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i7 = i6;
                        i3 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                        if ((i & 100663296) == 0) {
                            if ((i2 & 256) == 0 && startRestartGroup.changed(overscrollEffect)) {
                                i9 = 67108864;
                                i3 |= i9;
                            }
                            i9 = 33554432;
                            i3 |= i9;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "389@20259L23,395@20613L15,397@20711L26");
                                if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i13 != 0 ? Modifier.Companion : modifier;
                                    if ((i2 & 2) != 0) {
                                        lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                        i3 &= -113;
                                    }
                                    PaddingValues m731PaddingValues0680j_4 = i14 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj;
                                    if (i4 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 16) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        vertical3 = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                        i3 &= -57345;
                                    } else {
                                        vertical3 = obj2;
                                    }
                                    Alignment.Horizontal start = i5 != 0 ? Alignment.Companion.getStart() : obj3;
                                    if ((i2 & 64) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -3670017;
                                    } else {
                                        flingBehavior3 = obj4;
                                    }
                                    boolean z8 = i7 == 0 ? z2 : true;
                                    if ((i2 & 256) != 0) {
                                        i3 &= -234881025;
                                        modifier3 = companion;
                                        overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                                    } else {
                                        overscrollEffect3 = overscrollEffect;
                                        modifier3 = companion;
                                    }
                                    lazyListState4 = lazyListState2;
                                    paddingValues3 = m731PaddingValues0680j_4;
                                    vertical4 = vertical3;
                                    horizontal3 = start;
                                    z6 = z3;
                                    z7 = z8;
                                    i8 = 53695811;
                                    flingBehavior4 = flingBehavior3;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 2) != 0) {
                                        i3 &= -113;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    if ((i2 & 256) != 0) {
                                        i3 &= -234881025;
                                    }
                                    modifier3 = modifier;
                                    z7 = z2;
                                    overscrollEffect3 = overscrollEffect;
                                    z6 = z3;
                                    vertical4 = obj2;
                                    horizontal3 = obj3;
                                    flingBehavior4 = obj4;
                                    i8 = 53695811;
                                    lazyListState4 = lazyListState2;
                                    paddingValues3 = obj;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:399)");
                                }
                                int i15 = i3 >> 3;
                                composer2 = startRestartGroup;
                                LazyListKt.LazyList(modifier3, lazyListState4, paddingValues3, z6, true, flingBehavior4, z7, overscrollEffect3, 0, horizontal3, vertical4, null, null, function1, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i15) | (3670016 & i15) | (i15 & 29360128) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 18) & 7168), 6400);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                lazyListState3 = lazyListState4;
                                paddingValues2 = paddingValues3;
                                z5 = z6;
                                flingBehavior2 = flingBehavior4;
                                z4 = z7;
                                overscrollEffect2 = overscrollEffect3;
                                horizontal2 = horizontal3;
                                vertical2 = vertical4;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                z4 = z2;
                                lazyListState3 = lazyListState2;
                                paddingValues2 = obj;
                                z5 = z3;
                                vertical2 = obj2;
                                horizontal2 = obj3;
                                flingBehavior2 = obj4;
                                overscrollEffect2 = overscrollEffect;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
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

                                    public final void invoke(Composer composer3, int i16) {
                                        LazyDslKt.LazyColumn(Modifier.this, lazyListState3, paddingValues2, z5, vertical2, horizontal2, flingBehavior2, z4, overscrollEffect2, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i7 = i6;
                    if ((i & 100663296) == 0) {
                    }
                    if ((i2 & 512) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = horizontal;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i6;
                if ((i & 100663296) == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = horizontal;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i6;
            if ((i & 100663296) == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = paddingValues;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = horizontal;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i6;
        if ((i & 100663296) == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0103  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyListState lazyListState2;
        Object obj;
        int i4;
        boolean z3;
        Object obj2;
        int i5;
        Object obj3;
        Object obj4;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues2;
        final boolean z5;
        final Arrangement.Vertical vertical2;
        final Alignment.Horizontal horizontal2;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        Arrangement.Vertical vertical3;
        FlingBehavior flingBehavior3;
        boolean z6;
        LazyListState lazyListState4;
        PaddingValues paddingValues3;
        Arrangement.Vertical vertical4;
        Alignment.Horizontal horizontal3;
        boolean z7;
        FlingBehavior flingBehavior4;
        Modifier modifier3;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-740714857);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyColumn)P(4,6,1,5,8,3,2,7)438@22207L26,429@21848L418:LazyDsl.kt#428nma");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                if (startRestartGroup.changed(lazyListState2)) {
                    i11 = 32;
                    i3 |= i11;
                }
            } else {
                lazyListState2 = lazyListState;
            }
            i11 = 16;
            i3 |= i11;
        } else {
            lazyListState2 = lazyListState;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = paddingValues;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = vertical;
                        if (startRestartGroup.changed(obj2)) {
                            i10 = 16384;
                            i3 |= i10;
                        }
                    } else {
                        obj2 = vertical;
                    }
                    i10 = 8192;
                    i3 |= i10;
                } else {
                    obj2 = vertical;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = horizontal;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj4 = flingBehavior;
                            if (startRestartGroup.changed(obj4)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            obj4 = flingBehavior;
                        }
                        i9 = 524288;
                        i3 |= i9;
                    } else {
                        obj4 = flingBehavior;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i7 = i6;
                        i3 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                        if ((i2 & 256) != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                            if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "419@21392L23,425@21746L15");
                                if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i12 != 0 ? Modifier.Companion : modifier;
                                    if ((i2 & 2) != 0) {
                                        lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                        i3 &= -113;
                                    }
                                    PaddingValues m731PaddingValues0680j_4 = i13 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj;
                                    if (i4 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 16) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        vertical3 = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                        i3 &= -57345;
                                    } else {
                                        vertical3 = obj2;
                                    }
                                    Alignment.Horizontal start = i5 != 0 ? Alignment.Companion.getStart() : obj3;
                                    if ((i2 & 64) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -3670017;
                                    } else {
                                        flingBehavior3 = obj4;
                                    }
                                    if (i7 != 0) {
                                        lazyListState4 = lazyListState2;
                                        paddingValues3 = m731PaddingValues0680j_4;
                                        vertical4 = vertical3;
                                        horizontal3 = start;
                                        z7 = z3;
                                        z6 = true;
                                    } else {
                                        z6 = z2;
                                        lazyListState4 = lazyListState2;
                                        paddingValues3 = m731PaddingValues0680j_4;
                                        vertical4 = vertical3;
                                        horizontal3 = start;
                                        z7 = z3;
                                    }
                                    flingBehavior4 = flingBehavior3;
                                    modifier3 = companion;
                                    i8 = -740714857;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 2) != 0) {
                                        i3 &= -113;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    z6 = z2;
                                    lazyListState4 = lazyListState2;
                                    vertical4 = obj2;
                                    horizontal3 = obj3;
                                    flingBehavior4 = obj4;
                                    i8 = -740714857;
                                    modifier3 = modifier;
                                    paddingValues3 = obj;
                                    z7 = z3;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:428)");
                                }
                                composer2 = startRestartGroup;
                                LazyColumn(modifier3, lazyListState4, paddingValues3, z7, vertical4, horizontal3, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, composer2, (33554430 & i3) | ((i3 << 3) & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                lazyListState3 = lazyListState4;
                                paddingValues2 = paddingValues3;
                                z5 = z7;
                                vertical2 = vertical4;
                                horizontal2 = horizontal3;
                                flingBehavior2 = flingBehavior4;
                                z4 = z6;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                z4 = z2;
                                lazyListState3 = lazyListState2;
                                paddingValues2 = obj;
                                z5 = z3;
                                vertical2 = obj2;
                                horizontal2 = obj3;
                                flingBehavior2 = obj4;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$2
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
                                        LazyDslKt.LazyColumn(Modifier.this, lazyListState3, paddingValues2, z5, vertical2, horizontal2, flingBehavior2, z4, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i7 = i6;
                    if ((i2 & 256) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = horizontal;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i6;
                if ((i2 & 256) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = horizontal;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i6;
            if ((i2 & 256) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = paddingValues;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = horizontal;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i6;
        if ((i2 & 256) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010e  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyListState lazyListState2;
        Object obj;
        int i4;
        boolean z2;
        Object obj2;
        int i5;
        Object obj3;
        Object obj4;
        Composer composer2;
        final Modifier modifier2;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues2;
        final boolean z3;
        final Arrangement.Vertical vertical2;
        final Alignment.Horizontal horizontal2;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        PaddingValues paddingValues3;
        Alignment.Horizontal horizontal3;
        int i6;
        boolean z4;
        Modifier modifier3;
        int i7;
        FlingBehavior flingBehavior3;
        Arrangement.Vertical vertical3;
        LazyListState lazyListState4;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-563353797);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyColumn)P(4,6,1,5,7,3,2)456@22857L350:LazyDsl.kt#428nma");
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                if (startRestartGroup.changed(lazyListState2)) {
                    i10 = 32;
                    i3 |= i10;
                }
            } else {
                lazyListState2 = lazyListState;
            }
            i10 = 16;
            i3 |= i10;
        } else {
            lazyListState2 = lazyListState;
        }
        int i12 = i2 & 4;
        if (i12 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = paddingValues;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = vertical;
                        if (startRestartGroup.changed(obj2)) {
                            i9 = 16384;
                            i3 |= i9;
                        }
                    } else {
                        obj2 = vertical;
                    }
                    i9 = 8192;
                    i3 |= i9;
                } else {
                    obj2 = vertical;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = horizontal;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj4 = flingBehavior;
                            if (startRestartGroup.changed(obj4)) {
                                i8 = 1048576;
                                i3 |= i8;
                            }
                        } else {
                            obj4 = flingBehavior;
                        }
                        i8 = 524288;
                        i3 |= i8;
                    } else {
                        obj4 = flingBehavior;
                    }
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "447@22440L23,453@22794L15");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i11 != 0 ? Modifier.Companion : modifier;
                                if ((i2 & 2) != 0) {
                                    lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -113;
                                }
                                PaddingValues m731PaddingValues0680j_4 = i12 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj;
                                if (i4 != 0) {
                                    z2 = false;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    i3 &= -57345;
                                    obj2 = !z2 ? arrangement.getTop() : arrangement.getBottom();
                                }
                                if (i5 != 0) {
                                    obj3 = Alignment.Companion.getStart();
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    paddingValues3 = m731PaddingValues0680j_4;
                                    vertical3 = obj2;
                                    horizontal3 = obj3;
                                    lazyListState4 = lazyListState2;
                                    z4 = z2;
                                    modifier3 = companion;
                                    i7 = 12582912;
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i6 = -563353797;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:455)");
                                    }
                                    composer2 = startRestartGroup;
                                    LazyColumn(modifier3, lazyListState4, paddingValues3, z4, vertical3, horizontal3, flingBehavior3, true, null, function1, composer2, i7 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 6) & 1879048192), 256);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    lazyListState3 = lazyListState4;
                                    paddingValues2 = paddingValues3;
                                    z3 = z4;
                                    vertical2 = vertical3;
                                    horizontal2 = horizontal3;
                                    flingBehavior2 = flingBehavior3;
                                } else {
                                    paddingValues3 = m731PaddingValues0680j_4;
                                    horizontal3 = obj3;
                                    i6 = -563353797;
                                    z4 = z2;
                                    modifier3 = companion;
                                    i7 = 12582912;
                                    flingBehavior3 = obj4;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                paddingValues3 = obj;
                                horizontal3 = obj3;
                                i7 = 12582912;
                                i6 = -563353797;
                                z4 = z2;
                                flingBehavior3 = obj4;
                                modifier3 = modifier;
                            }
                            vertical3 = obj2;
                            lazyListState4 = lazyListState2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            LazyColumn(modifier3, lazyListState4, paddingValues3, z4, vertical3, horizontal3, flingBehavior3, true, null, function1, composer2, i7 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 6) & 1879048192), 256);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = modifier3;
                            lazyListState3 = lazyListState4;
                            paddingValues2 = paddingValues3;
                            z3 = z4;
                            vertical2 = vertical3;
                            horizontal2 = horizontal3;
                            flingBehavior2 = flingBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyListState3 = lazyListState2;
                            paddingValues2 = obj;
                            z3 = z2;
                            vertical2 = obj2;
                            horizontal2 = obj3;
                            flingBehavior2 = obj4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$3
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

                                public final void invoke(Composer composer3, int i13) {
                                    LazyDslKt.LazyColumn(Modifier.this, lazyListState3, paddingValues2, z3, vertical2, horizontal2, flingBehavior2, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = horizontal;
                if ((1572864 & i) != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = horizontal;
            if ((1572864 & i) != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = paddingValues;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = horizontal;
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0103  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyListState lazyListState2;
        Object obj;
        int i4;
        boolean z3;
        Object obj2;
        int i5;
        Object obj3;
        Object obj4;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues2;
        final boolean z5;
        final Arrangement.Horizontal horizontal2;
        final Alignment.Vertical vertical2;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        Arrangement.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        boolean z6;
        LazyListState lazyListState4;
        PaddingValues paddingValues3;
        Arrangement.Horizontal horizontal4;
        Alignment.Vertical vertical3;
        boolean z7;
        FlingBehavior flingBehavior4;
        Modifier modifier3;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1724297413);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyRow)P(4,6,1,5,3,8,2,7)492@24187L26,483@23831L415:LazyDsl.kt#428nma");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                if (startRestartGroup.changed(lazyListState2)) {
                    i11 = 32;
                    i3 |= i11;
                }
            } else {
                lazyListState2 = lazyListState;
            }
            i11 = 16;
            i3 |= i11;
        } else {
            lazyListState2 = lazyListState;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = paddingValues;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = horizontal;
                        if (startRestartGroup.changed(obj2)) {
                            i10 = 16384;
                            i3 |= i10;
                        }
                    } else {
                        obj2 = horizontal;
                    }
                    i10 = 8192;
                    i3 |= i10;
                } else {
                    obj2 = horizontal;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = vertical;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj4 = flingBehavior;
                            if (startRestartGroup.changed(obj4)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            obj4 = flingBehavior;
                        }
                        i9 = 524288;
                        i3 |= i9;
                    } else {
                        obj4 = flingBehavior;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i7 = i6;
                        i3 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                        if ((i2 & 256) != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                            if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "473@23378L23,479@23729L15");
                                if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i12 != 0 ? Modifier.Companion : modifier;
                                    if ((i2 & 2) != 0) {
                                        lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                        i3 &= -113;
                                    }
                                    PaddingValues m731PaddingValues0680j_4 = i13 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj;
                                    if (i4 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 16) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        horizontal3 = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                        i3 &= -57345;
                                    } else {
                                        horizontal3 = obj2;
                                    }
                                    Alignment.Vertical top = i5 != 0 ? Alignment.Companion.getTop() : obj3;
                                    if ((i2 & 64) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -3670017;
                                    } else {
                                        flingBehavior3 = obj4;
                                    }
                                    if (i7 != 0) {
                                        lazyListState4 = lazyListState2;
                                        paddingValues3 = m731PaddingValues0680j_4;
                                        horizontal4 = horizontal3;
                                        vertical3 = top;
                                        z7 = z3;
                                        z6 = true;
                                    } else {
                                        z6 = z2;
                                        lazyListState4 = lazyListState2;
                                        paddingValues3 = m731PaddingValues0680j_4;
                                        horizontal4 = horizontal3;
                                        vertical3 = top;
                                        z7 = z3;
                                    }
                                    flingBehavior4 = flingBehavior3;
                                    modifier3 = companion;
                                    i8 = -1724297413;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 2) != 0) {
                                        i3 &= -113;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    z6 = z2;
                                    lazyListState4 = lazyListState2;
                                    horizontal4 = obj2;
                                    vertical3 = obj3;
                                    flingBehavior4 = obj4;
                                    i8 = -1724297413;
                                    modifier3 = modifier;
                                    paddingValues3 = obj;
                                    z7 = z3;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:482)");
                                }
                                composer2 = startRestartGroup;
                                LazyRow(modifier3, lazyListState4, paddingValues3, z7, horizontal4, vertical3, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, composer2, (33554430 & i3) | ((i3 << 3) & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                lazyListState3 = lazyListState4;
                                paddingValues2 = paddingValues3;
                                z5 = z7;
                                horizontal2 = horizontal4;
                                vertical2 = vertical3;
                                flingBehavior2 = flingBehavior4;
                                z4 = z6;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                z4 = z2;
                                lazyListState3 = lazyListState2;
                                paddingValues2 = obj;
                                z5 = z3;
                                horizontal2 = obj2;
                                vertical2 = obj3;
                                flingBehavior2 = obj4;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$2
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
                                        LazyDslKt.LazyRow(Modifier.this, lazyListState3, paddingValues2, z5, horizontal2, vertical2, flingBehavior2, z4, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i7 = i6;
                    if ((i2 & 256) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = vertical;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i6;
                if ((i2 & 256) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = vertical;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i6;
            if ((i2 & 256) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = paddingValues;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = vertical;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i6;
        if ((i2 & 256) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010e  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyListState lazyListState2;
        Object obj;
        int i4;
        boolean z2;
        Object obj2;
        int i5;
        Object obj3;
        Object obj4;
        Composer composer2;
        final Modifier modifier2;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues2;
        final boolean z3;
        final Arrangement.Horizontal horizontal2;
        final Alignment.Vertical vertical2;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        PaddingValues paddingValues3;
        Alignment.Vertical vertical3;
        int i6;
        boolean z4;
        Modifier modifier3;
        int i7;
        FlingBehavior flingBehavior3;
        Arrangement.Horizontal horizontal3;
        LazyListState lazyListState4;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(407929823);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyRow)P(4,6,1,5,3,7,2)510@24831L347:LazyDsl.kt#428nma");
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                if (startRestartGroup.changed(lazyListState2)) {
                    i10 = 32;
                    i3 |= i10;
                }
            } else {
                lazyListState2 = lazyListState;
            }
            i10 = 16;
            i3 |= i10;
        } else {
            lazyListState2 = lazyListState;
        }
        int i12 = i2 & 4;
        if (i12 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = paddingValues;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = horizontal;
                        if (startRestartGroup.changed(obj2)) {
                            i9 = 16384;
                            i3 |= i9;
                        }
                    } else {
                        obj2 = horizontal;
                    }
                    i9 = 8192;
                    i3 |= i9;
                } else {
                    obj2 = horizontal;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = vertical;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj4 = flingBehavior;
                            if (startRestartGroup.changed(obj4)) {
                                i8 = 1048576;
                                i3 |= i8;
                            }
                        } else {
                            obj4 = flingBehavior;
                        }
                        i8 = 524288;
                        i3 |= i8;
                    } else {
                        obj4 = flingBehavior;
                    }
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "501@24417L23,507@24768L15");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i11 != 0 ? Modifier.Companion : modifier;
                                if ((i2 & 2) != 0) {
                                    lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -113;
                                }
                                PaddingValues m731PaddingValues0680j_4 = i12 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj;
                                if (i4 != 0) {
                                    z2 = false;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    i3 &= -57345;
                                    obj2 = !z2 ? arrangement.getStart() : arrangement.getEnd();
                                }
                                if (i5 != 0) {
                                    obj3 = Alignment.Companion.getTop();
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    paddingValues3 = m731PaddingValues0680j_4;
                                    horizontal3 = obj2;
                                    vertical3 = obj3;
                                    lazyListState4 = lazyListState2;
                                    z4 = z2;
                                    modifier3 = companion;
                                    i7 = 12582912;
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i6 = 407929823;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:509)");
                                    }
                                    composer2 = startRestartGroup;
                                    LazyRow(modifier3, lazyListState4, paddingValues3, z4, horizontal3, vertical3, flingBehavior3, true, null, function1, composer2, i7 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 6) & 1879048192), 256);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    lazyListState3 = lazyListState4;
                                    paddingValues2 = paddingValues3;
                                    z3 = z4;
                                    horizontal2 = horizontal3;
                                    vertical2 = vertical3;
                                    flingBehavior2 = flingBehavior3;
                                } else {
                                    paddingValues3 = m731PaddingValues0680j_4;
                                    vertical3 = obj3;
                                    i6 = 407929823;
                                    z4 = z2;
                                    modifier3 = companion;
                                    i7 = 12582912;
                                    flingBehavior3 = obj4;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                paddingValues3 = obj;
                                vertical3 = obj3;
                                i7 = 12582912;
                                i6 = 407929823;
                                z4 = z2;
                                flingBehavior3 = obj4;
                                modifier3 = modifier;
                            }
                            horizontal3 = obj2;
                            lazyListState4 = lazyListState2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            LazyRow(modifier3, lazyListState4, paddingValues3, z4, horizontal3, vertical3, flingBehavior3, true, null, function1, composer2, i7 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 6) & 1879048192), 256);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = modifier3;
                            lazyListState3 = lazyListState4;
                            paddingValues2 = paddingValues3;
                            z3 = z4;
                            horizontal2 = horizontal3;
                            vertical2 = vertical3;
                            flingBehavior2 = flingBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyListState3 = lazyListState2;
                            paddingValues2 = obj;
                            z3 = z2;
                            horizontal2 = obj2;
                            vertical2 = obj3;
                            flingBehavior2 = obj4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$3
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

                                public final void invoke(Composer composer3, int i13) {
                                    LazyDslKt.LazyRow(Modifier.this, lazyListState3, paddingValues2, z3, horizontal2, vertical2, flingBehavior2, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = vertical;
                if ((1572864 & i) != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = vertical;
            if ((1572864 & i) != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = paddingValues;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = vertical;
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(LazyDslKt$items$1.INSTANCE, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(objArr.length, function1 != null ? new LazyDslKt$items$6(function1, objArr) : null, new LazyDslKt$items$7(LazyDslKt$items$5.INSTANCE, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, objArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        lazyListScope.items(objArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, objArr) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, objArr)));
    }
}
