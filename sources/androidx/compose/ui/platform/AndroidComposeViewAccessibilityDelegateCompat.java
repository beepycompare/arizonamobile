package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntIntMapKt;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsNode_androidKt;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u008e\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\n\u008e\u0002\u008f\u0002\u0090\u0002\u0091\u0002\u0092\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010v\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020wH\u0016J\u0010\u0010y\u001a\u00020.2\u0006\u0010z\u001a\u00020\u0016H\u0016J\u0010\u0010{\u001a\u00020.2\u0006\u0010z\u001a\u00020\u0016H\u0016J*\u0010|\u001a\u00020\u00162\u0006\u0010}\u001a\u00020\u00162\u0006\u0010~\u001a\u00020\f2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0000¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J8\u0010|\u001a\u00020\u00162\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010}\u001a\u00020\u00162\u0006\u0010~\u001a\u00020\f2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020\u0016H\u0002J\u0014\u0010\u0086\u0001\u001a\u0004\u0018\u00010B2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J\u000b\u0010\u0088\u0001\u001a\u0004\u0018\u00010BH\u0002J\u0013\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u008b\u0001\u001a\u00020[H\u0002J2\u0010\u008c\u0001\u001a\u00030\u008a\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\b\u0010\u008f\u0001\u001a\u00030\u008e\u00012\b\u0010\u0090\u0001\u001a\u00030\u008e\u00012\b\u0010\u0091\u0001\u001a\u00030\u008e\u0001H\u0002J%\u0010\u0092\u0001\u001a\u00020.2\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u0093\u0001\u001a\u00020B2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002J\u001c\u0010\u0096\u0001\u001a\u00020.2\b\u0010\u008b\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0093\u0001\u001a\u00020BH\u0002J\u0011\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001*\u00030\u0099\u0001H\u0002J\u001c\u0010\u009a\u0001\u001a\u00020.2\b\u0010\u008b\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0093\u0001\u001a\u00020BH\u0002J\u0012\u0010\u009b\u0001\u001a\u00020\u00162\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J\u0012\u0010\u009c\u0001\u001a\u00020\u00162\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002JA\u0010\u009d\u0001\u001a\u00020\u00162\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u009e\u0001\u001a\u00020\f2\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\f2\u0011\b\u0002\u0010 \u0001\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010+H\u0002¢\u0006\u0003\u0010¡\u0001J\u0012\u0010¢\u0001\u001a\u00020\u00162\u0007\u0010£\u0001\u001a\u00020\u0015H\u0002J\u001b\u0010¤\u0001\u001a\u00020\u00152\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u009e\u0001\u001a\u00020\fH\u0003JD\u0010¥\u0001\u001a\u00020\u00152\u0007\u0010\u0087\u0001\u001a\u00020\f2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\f2\t\u0010§\u0001\u001a\u0004\u0018\u00010\f2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\f2\t\u0010©\u0001\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0003\u0010ª\u0001J\u0012\u0010«\u0001\u001a\u00020\u00162\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J'\u0010¬\u0001\u001a\u00020\u00162\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u00ad\u0001\u001a\u00020\f2\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0002J0\u0010°\u0001\u001a\u00020.2\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u0093\u0001\u001a\u00020B2\u0007\u0010±\u0001\u001a\u00020j2\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0002J(\u0010´\u0001\u001a\u00030µ\u00012\b\u0010\u008b\u0001\u001a\u00030\u0095\u00012\b\u0010¶\u0001\u001a\u00030\u008a\u00012\b\u0010·\u0001\u001a\u00030¸\u0001H\u0002J\u0019\u0010¹\u0001\u001a\u00030µ\u0001*\u00030\u008a\u00012\b\u0010¶\u0001\u001a\u00030\u008a\u0001H\u0002J\"\u0010º\u0001\u001a\u0005\u0018\u00010»\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u0095\u00012\b\u0010½\u0001\u001a\u00030µ\u0001H\u0002J,\u0010¾\u0001\u001a\u00030¿\u0001*\u00030¸\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0002¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J%\u0010Æ\u0001\u001a\u0005\u0018\u00010\u008a\u0001*\u00030¿\u00012\b\u0010Ç\u0001\u001a\u00030\u008e\u00012\b\u0010È\u0001\u001a\u00030\u008e\u0001H\u0002J\u0011\u0010É\u0001\u001a\u0005\u0018\u00010Ê\u0001*\u00030¿\u0001H\u0002J%\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001*\u00030¿\u00012\b\u0010Ç\u0001\u001a\u00030\u008e\u00012\b\u0010È\u0001\u001a\u00030\u008e\u0001H\u0002J'\u0010Æ\u0001\u001a\u00030\u008a\u0001*\u00030µ\u00012\n\b\u0002\u0010Ç\u0001\u001a\u00030\u008e\u00012\n\b\u0002\u0010È\u0001\u001a\u00030\u008e\u0001H\u0002J\u0019\u0010Í\u0001\u001a\u00020\u00162\b\u0010£\u0001\u001a\u00030Î\u0001H\u0000¢\u0006\u0003\bÏ\u0001J#\u0010Ð\u0001\u001a\u00020\f2\b\u0010Ñ\u0001\u001a\u00030\u008e\u00012\b\u0010Ò\u0001\u001a\u00030\u008e\u0001H\u0001¢\u0006\u0003\bÓ\u0001J\u0012\u0010Ô\u0001\u001a\u00020.2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J\u0013\u0010Õ\u0001\u001a\u00030Ö\u00012\u0007\u0010×\u0001\u001a\u00020wH\u0016J4\u0010Ø\u0001\u001a\u0005\u0018\u0001HÙ\u0001\"\t\b\u0000\u0010Ù\u0001*\u00020K2\n\u0010©\u0001\u001a\u0005\u0018\u0001HÙ\u00012\t\b\u0001\u0010À\u0001\u001a\u00020\fH\u0002¢\u0006\u0003\u0010Ú\u0001J\u000f\u0010Ý\u0001\u001a\u00020.H\u0000¢\u0006\u0003\bÞ\u0001J\u0013\u0010ß\u0001\u001a\u00020.H\u0080@¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0018\u0010â\u0001\u001a\u00020.2\u0007\u0010ã\u0001\u001a\u00020SH\u0000¢\u0006\u0003\bä\u0001J\u0012\u0010å\u0001\u001a\u00020.2\u0007\u0010ã\u0001\u001a\u00020SH\u0002J\u0012\u0010æ\u0001\u001a\u00020.2\u0007\u0010ã\u0001\u001a\u00020SH\u0002J\u001b\u0010ç\u0001\u001a\u00020.2\u0007\u0010ã\u0001\u001a\u00020S2\u0007\u0010è\u0001\u001a\u00020_H\u0002J\t\u0010é\u0001\u001a\u00020.H\u0002J\t\u0010ê\u0001\u001a\u00020.H\u0002J\u0018\u0010ë\u0001\u001a\u00020.2\r\u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020[0ZH\u0002J\"\u0010ñ\u0001\u001a\u00020\u00162\u0007\u0010ò\u0001\u001a\u00020\f2\u000e\u0010ó\u0001\u001a\t\u0012\u0005\u0012\u00030ï\u00010+H\u0002J\u0013\u0010ô\u0001\u001a\u00020.2\b\u0010õ\u0001\u001a\u00030ï\u0001H\u0002J&\u0010ö\u0001\u001a\u00020.2\u0007\u0010÷\u0001\u001a\u00020\f2\u0007\u0010\u009f\u0001\u001a\u00020\f2\t\u0010ø\u0001\u001a\u0004\u0018\u00010jH\u0002J\u001c\u0010ù\u0001\u001a\u00020.2\b\u0010ú\u0001\u001a\u00030\u0095\u00012\u0007\u0010û\u0001\u001a\u00020rH\u0002J\u0012\u0010ü\u0001\u001a\u00020\f2\u0007\u0010ò\u0001\u001a\u00020\fH\u0002J.\u0010ý\u0001\u001a\u00020\u00162\b\u0010\u008b\u0001\u001a\u00030\u0095\u00012\u0007\u0010þ\u0001\u001a\u00020\f2\u0007\u0010ÿ\u0001\u001a\u00020\u00162\u0007\u0010\u0080\u0002\u001a\u00020\u0016H\u0002J\u0012\u0010\u0081\u0002\u001a\u00020.2\u0007\u0010÷\u0001\u001a\u00020\fH\u0002J.\u0010\u0082\u0002\u001a\u00020\u00162\b\u0010\u008b\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0083\u0002\u001a\u00020\f2\u0007\u0010\u0084\u0002\u001a\u00020\f2\u0007\u0010\u0085\u0002\u001a\u00020\u0016H\u0002J\u0013\u0010\u0086\u0002\u001a\u00020\f2\b\u0010\u008b\u0001\u001a\u00030\u0095\u0001H\u0002J\u0013\u0010\u0087\u0002\u001a\u00020\f2\b\u0010\u008b\u0001\u001a\u00030\u0095\u0001H\u0002J\u0013\u0010\u0088\u0002\u001a\u00020\u00162\b\u0010\u008b\u0001\u001a\u00030\u0095\u0001H\u0002J!\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u008a\u00022\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0095\u00012\u0007\u0010þ\u0001\u001a\u00020\fH\u0002J\u0017\u0010\u008b\u0002\u001a\u0004\u0018\u00010j2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\u0011\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u0099\u0001*\u00030\u008d\u0002H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010!R\u0014\u00104\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010!R\u001e\u00105\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u00060>R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020G0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0J0JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0M0JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010PR\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020.0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u000e\u0010^\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\u00020aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010c\"\u0004\bh\u0010eR\u0014\u0010i\u001a\u00020jX\u0080D¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u0014\u0010m\u001a\u00020jX\u0080D¢\u0006\b\n\u0000\u001a\u0004\bn\u0010lR\u000e\u0010o\u001a\u00020pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010q\u001a\b\u0012\u0004\u0012\u00020r0FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0089\u0001\u001a\u00030\u008a\u0001*\u00020B8BX\u0082\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R\u0010\u0010Û\u0001\u001a\u00030Ü\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010í\u0001\u001a\n\u0012\u0005\u0012\u00030ï\u00010î\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010ð\u0001\u001a\u000f\u0012\u0005\u0012\u00030ï\u0001\u0012\u0004\u0012\u00020.0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0093\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "hoveredVirtualViewId", "", "getHoveredVirtualViewId$ui$annotations", "()V", "getHoveredVirtualViewId$ui", "()I", "setHoveredVirtualViewId$ui", "(I)V", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "", "getOnSendAccessibilityEvent$ui$annotations", "getOnSendAccessibilityEvent$ui", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui", "(Lkotlin/jvm/functions/Function1;)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "value", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui", "()Z", "setAccessibilityForceEnabledForTesting$ui", "(Z)V", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui", "(J)V", "_enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "resetEnabledAccessibilityServiceList", "", "enabledServices", "getEnabledServices", "()Ljava/util/List;", "isEnabled", "isEnabled$ui", "isTouchExplorationEnabled", "requestFromAccessibilityToolForTesting", "getRequestFromAccessibilityToolForTesting$ui", "()Ljava/lang/Boolean;", "setRequestFromAccessibilityToolForTesting$ui", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "handler", "Landroid/os/Handler;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "accessibilityFocusedVirtualViewId", "focusedVirtualViewId", "currentlyAccessibilityFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "currentlyFocusedANI", "sendingFocusAffectingEvent", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingVerticalScrollEvents", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "accessibilityCursorPosition", "previousTraversedNode", "Ljava/lang/Integer;", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "currentSemanticsNodesInvalidated", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "idToBeforeMap", "Landroidx/collection/MutableIntIntMap;", "getIdToBeforeMap$ui", "()Landroidx/collection/MutableIntIntMap;", "setIdToBeforeMap$ui", "(Landroidx/collection/MutableIntIntMap;)V", "idToAfterMap", "getIdToAfterMap$ui", "setIdToAfterMap$ui", "ExtraDataTestTraversalBeforeVal", "", "getExtraDataTestTraversalBeforeVal$ui", "()Ljava/lang/String;", "ExtraDataTestTraversalAfterVal", "getExtraDataTestTraversalAfterVal$ui", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "checkingForSemanticsChanges", "drawingOrder", "onViewAttachedToWindow", "Landroid/view/View;", "onViewDetachedFromWindow", "onAccessibilityStateChanged", "enabled", "onTouchExplorationStateChanged", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui", "(ZIJ)Z", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "isRequestFromAccessibilityTool", "createNodeInfo", "virtualViewId", "emptyNodeInfoOrNull", "boundsInScreen", "Landroid/graphics/Rect;", "node", "toBoundsInScreen", TtmlNode.LEFT, "", "top", TtmlNode.RIGHT, "bottom", "populateAccessibilityNodeInfoProperties", "info", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "setContentInvalid", "toSpannableString", "Landroid/text/SpannableString;", "Landroidx/compose/ui/text/AnnotatedString;", "setText", "isAccessibilityFocused", "requestAccessibilityFocus", "sendEventForVirtualView", "eventType", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendEvent", NotificationCompat.CATEGORY_EVENT, "createEvent", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "clearAccessibilityFocus", "performActionHelper", "action", "arguments", "Landroid/os/Bundle;", "addExtraDataToAccessibilityNodeInfoHelper", "extraDataKey", "getBoundsInScreen", "(Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)Landroid/graphics/Rect;", "getShapeBounds", "Landroidx/compose/ui/geometry/Rect;", "nodeBoundsInScreen", "shape", "Landroidx/compose/ui/graphics/Shape;", "toBoundsRelativeToNodeBounds", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-12SF9DM", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "toAndroidRect", "leftOffset", "topOffset", "toCornerArray", "", "toRegion", "Landroid/graphics/Region;", "dispatchHoverEvent", "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui", "hitTestSemanticsAt", "x", "y", "hitTestSemanticsAt$ui", "updateHoveredVirtualView", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "host", "trimToSize", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "onSemanticsChange", "onSemanticsChange$ui", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLayoutChange", "layoutNode", "onLayoutChange$ui", "notifySubtreeAccessibilityStateChangedIfNeeded", "sendTypeViewScrolledAccessibilityEvent", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "checkForSemanticsChanges", "updateSemanticsNodesCopyAndPanes", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "scrollObservationScopes", "", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scheduleScrollEventIfNeededLambda", "registerScrollingId", "id", "oldScrollObservationScopes", "scheduleScrollEventIfNeeded", "scrollObservationScope", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "semanticsNodeIdToAccessibilityVirtualNodeId", "traverseAtGranularity", "granularity", "forward", "extendSelection", "sendPendingTextTraversedAtGranularityEvent", "setAccessibilitySelection", TtmlNode.START, TtmlNode.END, "traversalMode", "getAccessibilitySelectionStart", "getAccessibilitySelectionEnd", "isAccessibilitySelectionExtendable", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "getIterableTextForAccessibility", "getTextForTextField", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Companion", "PendingTextTraversedEvent", "ComposeAccessibilityNodeProvider", "Api24Impl", "Api29Impl", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat implements View.OnAttachStateChangeListener, AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataShapeRectCornersKey = "androidx.compose.ui.semantics.shapeCorners";
    public static final String ExtraDataShapeRectKey = "androidx.compose.ui.semantics.shapeRect";
    public static final String ExtraDataShapeRegionKey = "androidx.compose.ui.semantics.shapeRegion";
    public static final int ExtraDataShapeTypeGeneric = 2;
    public static final String ExtraDataShapeTypeKey = "androidx.compose.ui.semantics.shapeType";
    public static final int ExtraDataShapeTypeRectangle = 0;
    public static final int ExtraDataShapeTypeRounded = 1;
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    private List<? extends AccessibilityServiceInfo> _enabledServices;
    private int accessibilityCursorPosition;
    private int accessibilityFocusedVirtualViewId;
    private boolean accessibilityForceEnabledForTesting;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private AccessibilityNodeInfoCompat currentlyAccessibilityFocusedANI;
    private AccessibilityNodeInfoCompat currentlyFocusedANI;
    private final MutableIntIntMap drawingOrder;
    private int focusedVirtualViewId;
    private final Handler handler;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<CharSequence>> labelToActionId;
    private ComposeAccessibilityNodeProvider nodeProvider;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private Boolean requestFromAccessibilityToolForTesting;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final IntList AccessibilityActionsResourceIds = IntListKt.intListOf(R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31);
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(AndroidComposeViewAccessibilityDelegateCompat.this.getView().getParent().requestSendAccessibilityEvent(AndroidComposeViewAccessibilityDelegateCompat.this.getView(), accessibilityEvent));
        }
    };

    public static /* synthetic */ void getHoveredVirtualViewId$ui$annotations() {
    }

    public static /* synthetic */ void getOnSendAccessibilityEvent$ui$annotations() {
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.SendRecurringAccessibilityEventsIntervalMillis = 100L;
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider();
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, null);
        this.idToBeforeMap = new MutableIntIntMap(0, 1, null);
        this.idToAfterMap = new MutableIntIntMap(0, 1, null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.drawingOrder = IntIntMapKt.mutableIntIntMapOf();
        androidComposeView.addOnAttachStateChangeListener(this);
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$0(AndroidComposeViewAccessibilityDelegateCompat.this);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope scrollObservationScope) {
                AndroidComposeViewAccessibilityDelegateCompat.this.scheduleScrollEventIfNeeded(scrollObservationScope);
            }
        };
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "<init>", "()V", "InvalidId", "", "ClassName", "", "TextFieldClassName", "TextClassName", "LogTag", "ExtraDataTestTagKey", "ExtraDataIdKey", "ExtraDataShapeTypeKey", "ExtraDataShapeTypeRectangle", "ExtraDataShapeTypeRounded", "ExtraDataShapeTypeGeneric", "ExtraDataShapeRectKey", "ExtraDataShapeRectCornersKey", "ExtraDataShapeRegionKey", "ParcelSafeTextLength", "AccessibilityCursorPositionUndefined", "AccessibilitySliderStepsCount", "TextTraversedEventTimeoutMillis", "", "AccessibilityActionsResourceIds", "Landroidx/collection/IntList;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getHoveredVirtualViewId$ui() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui() {
        return this.onSendAccessibilityEvent;
    }

    public final void setOnSendAccessibilityEvent$ui(Function1<? super AccessibilityEvent, Boolean> function1) {
        this.onSendAccessibilityEvent = function1;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
        this.currentSemanticsNodesInvalidated = true;
    }

    public final long getSendRecurringAccessibilityEventsIntervalMillis$ui() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui(long j) {
        this.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    private final void resetEnabledAccessibilityServiceList() {
        this._enabledServices = null;
    }

    private final List<AccessibilityServiceInfo> getEnabledServices() {
        List list = this._enabledServices;
        if (list == null) {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.accessibilityManager.getEnabledAccessibilityServiceList(-1);
            this._enabledServices = enabledAccessibilityServiceList;
            return enabledAccessibilityServiceList;
        }
        return list;
    }

    public final boolean isEnabled$ui() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        return this.accessibilityManager.isEnabled() && !getEnabledServices().isEmpty();
    }

    private final boolean isTouchExplorationEnabled() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        return this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled();
    }

    public final Boolean getRequestFromAccessibilityToolForTesting$ui() {
        return this.requestFromAccessibilityToolForTesting;
    }

    public final void setRequestFromAccessibilityToolForTesting$ui(Boolean bool) {
        this.requestFromAccessibilityToolForTesting = bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "<init>", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getAction", "()I", "getGranularity", "getFromIndex", "getToIndex", "getTraverseTime", "()J", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsOwnerKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner(), -1, new Function1<SemanticsNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$currentSemanticsNodes$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SemanticsNode semanticsNode) {
                    return Boolean.valueOf(SemanticsNode_androidKt.isAccessibilityIgnoredLink(semanticsNode));
                }
            });
            if (isEnabled$ui()) {
                AndroidComposeViewAccessibilityDelegateCompat_androidKt.setTraversalValues(this.currentSemanticsNodes, this.idToBeforeMap, this.idToAfterMap, this.view.getContext().getResources());
            }
        }
        return this.currentSemanticsNodes;
    }

    public final MutableIntIntMap getIdToBeforeMap$ui() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui(MutableIntIntMap mutableIntIntMap) {
        this.idToBeforeMap = mutableIntIntMap;
    }

    public final MutableIntIntMap getIdToAfterMap$ui() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui(MutableIntIntMap mutableIntIntMap) {
        this.idToAfterMap = mutableIntIntMap;
    }

    public final String getExtraDataTestTraversalBeforeVal$ui() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    public final String getExtraDataTestTraversalAfterVal$ui() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (this.accessibilityManager.isEnabled()) {
            resetEnabledAccessibilityServiceList();
        }
        this.accessibilityManager.addAccessibilityStateChangeListener(this);
        this.accessibilityManager.addTouchExplorationStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.handler.removeCallbacks(this.semanticsChangeChecker);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this);
        this.accessibilityManager.removeTouchExplorationStateChangeListener(this);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z) {
        resetEnabledAccessibilityServiceList();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean z) {
        resetEnabledAccessibilityServiceList();
    }

    /* renamed from: canScroll-0AR0LA0$ui  reason: not valid java name */
    public final boolean m7325canScroll0AR0LA0$ui(boolean z, int i, long j) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return m7323canScrollmoWRBKg(getCurrentSemanticsNodes(), z, i, j);
        }
        return false;
    }

    /* renamed from: canScroll-moWRBKg  reason: not valid java name */
    private final boolean m7323canScrollmoWRBKg(IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap, boolean z, int i, long j) {
        SemanticsPropertyKey<ScrollAxisRange> horizontalScrollAxisRange;
        ScrollAxisRange scrollAxisRange;
        if (Offset.m5176equalsimpl0(j, Offset.Companion.m5194getUnspecifiedF1C5BW0()) || (((9223372034707292159L & j) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) != 0) {
            return false;
        }
        if (z) {
            horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else if (z) {
            throw new NoWhenBranchMatchedException();
        } else {
            horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        }
        Object[] objArr = intObjectMap.values;
        long[] jArr = intObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((j2 & 255) < 128) {
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) objArr[(i2 << 3) + i4];
                        if (IntRectKt.toRect(semanticsNodeWithAdjustedBounds.getAdjustedBounds()).m5205containsk4lQ0M(j) && (scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig$ui(), horizontalScrollAxisRange)) != null) {
                            int i5 = scrollAxisRange.getReverseScrolling() ? -i : i;
                            if (i == 0 && scrollAxisRange.getReverseScrolling()) {
                                i5 = -1;
                            }
                            if (i5 < 0) {
                                if (scrollAxisRange.getValue().invoke().floatValue() <= 0.0f) {
                                    j2 >>= 8;
                                }
                                z2 = true;
                                j2 >>= 8;
                            } else {
                                if (scrollAxisRange.getValue().invoke().floatValue() >= scrollAxisRange.getMaxValue().invoke().floatValue()) {
                                    j2 >>= 8;
                                }
                                z2 = true;
                                j2 >>= 8;
                            }
                        }
                    }
                    j2 >>= 8;
                }
                if (i3 != 8) {
                    return z2;
                }
            }
            if (i2 == length) {
                return z2;
            }
            i2++;
        }
    }

    private final boolean isRequestFromAccessibilityTool() {
        Boolean bool = this.requestFromAccessibilityToolForTesting;
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) false)) {
            return false;
        }
        return AccessibilityManagerCompat.isRequestFromAccessibilityTool(this.accessibilityManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessibilityNodeInfoCompat createNodeInfo(int i) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.DESTROYED) {
            return emptyNodeInfoOrNull();
        }
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i);
        if (semanticsNodeWithAdjustedBounds == null) {
            return emptyNodeInfoOrNull();
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        boolean areEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true);
        if (!areEqual || isRequestFromAccessibilityTool()) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
            obtain.setAccessibilityDataSensitive(areEqual);
            if (i == -1) {
                ViewParent parentForAccessibility = this.view.getParentForAccessibility();
                obtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
            } else {
                SemanticsNode parent = semanticsNode.getParent();
                Integer valueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
                if (valueOf != null) {
                    int intValue = valueOf.intValue();
                    obtain.setParent(this.view, intValue != this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId() ? intValue : -1);
                } else {
                    androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + i + " has null parent");
                    throw new KotlinNothingValueException();
                }
            }
            obtain.setSource(this.view, i);
            obtain.setBoundsInScreen(boundsInScreen(semanticsNodeWithAdjustedBounds));
            populateAccessibilityNodeInfoProperties(i, obtain, semanticsNode);
            return obtain;
        }
        return null;
    }

    private final AccessibilityNodeInfoCompat emptyNodeInfoOrNull() {
        if (this.accessibilityManager.isEnabled()) {
            return null;
        }
        return AccessibilityNodeInfoCompat.obtain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds) {
        IntRect adjustedBounds = semanticsNodeWithAdjustedBounds.getAdjustedBounds();
        return toBoundsInScreen(adjustedBounds.getLeft(), adjustedBounds.getTop(), adjustedBounds.getRight(), adjustedBounds.getBottom());
    }

    private final Rect toBoundsInScreen(float f, float f2, float f3, float f4) {
        long mo6824localToScreenMKHz9U = this.view.mo6824localToScreenMKHz9U(Offset.m5171constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
        long mo6824localToScreenMKHz9U2 = this.view.mo6824localToScreenMKHz9U(Offset.m5171constructorimpl((Float.floatToRawIntBits(f4) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)));
        int i = (int) (mo6824localToScreenMKHz9U >> 32);
        int i2 = (int) (mo6824localToScreenMKHz9U2 >> 32);
        int i3 = (int) (mo6824localToScreenMKHz9U & 4294967295L);
        int i4 = (int) (mo6824localToScreenMKHz9U2 & 4294967295L);
        return new Rect((int) Math.floor(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.floor(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))));
    }

    private final void populateAccessibilityNodeInfoProperties(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
        String infoStateDescriptionOrNull;
        boolean infoIsCheckable;
        boolean enabled;
        boolean enabled2;
        boolean enabled3;
        boolean isScreenReaderFocusable;
        View semanticsIdToView;
        boolean enabled4;
        boolean enabled5;
        boolean isRtl;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        boolean isRtl2;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        boolean enabled6;
        String accessibilityExtraKey$ui;
        boolean excludeLineAndPageGranularities;
        boolean enabled7;
        boolean z;
        boolean enabled8;
        boolean z2;
        SemanticsNode semanticsNode2;
        SemanticsConfiguration config;
        Resources resources = this.view.getContext().getResources();
        accessibilityNodeInfoCompat.setClassName(ClassName);
        if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            accessibilityNodeInfoCompat.setClassName(TextFieldClassName);
        }
        if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getText())) {
            accessibilityNodeInfoCompat.setClassName(TextClassName);
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
            role.m7441unboximpl();
            if (semanticsNode.isFake$ui() || semanticsNode.getReplacedChildren$ui().isEmpty()) {
                if (Role.m7438equalsimpl0(role.m7441unboximpl(), Role.Companion.m7449getTabo7Vup1c())) {
                    accessibilityNodeInfoCompat.setRoleDescription(resources.getString(R.string.tab));
                } else if (Role.m7438equalsimpl0(role.m7441unboximpl(), Role.Companion.m7448getSwitcho7Vup1c())) {
                    accessibilityNodeInfoCompat.setRoleDescription(resources.getString(R.string.switch_role));
                } else {
                    String m7416toLegacyClassNameV4PA4sw = SemanticsUtils_androidKt.m7416toLegacyClassNameV4PA4sw(role.m7441unboximpl());
                    if (!Role.m7438equalsimpl0(role.m7441unboximpl(), Role.Companion.m7446getImageo7Vup1c()) || semanticsNode.isUnmergedLeafNode$ui() || semanticsNode.getUnmergedConfig$ui().isMergingSemanticsOfDescendants()) {
                        accessibilityNodeInfoCompat.setClassName(m7416toLegacyClassNameV4PA4sw);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setPackageName(this.view.getContext().getPackageName());
        accessibilityNodeInfoCompat.setImportantForAccessibility(SemanticsOwnerKt.isImportantForAccessibility(semanticsNode));
        boolean isRequestFromAccessibilityTool = isRequestFromAccessibilityTool();
        List<SemanticsNode> replacedChildren$ui = semanticsNode.getReplacedChildren$ui();
        int size = replacedChildren$ui.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui.get(i3);
            if (getCurrentSemanticsNodes().containsKey(semanticsNode3.getId())) {
                AndroidViewHolder androidViewHolder = this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(semanticsNode3.getLayoutNode$ui());
                if (semanticsNode3.getId() != -1) {
                    if (androidViewHolder != null) {
                        accessibilityNodeInfoCompat.addChild(androidViewHolder);
                    } else {
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(semanticsNode3.getId());
                        boolean areEqual = (semanticsNodeWithAdjustedBounds == null || (semanticsNode2 = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null || (config = semanticsNode2.getConfig()) == null) ? false : Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true);
                        if (isRequestFromAccessibilityTool || !areEqual) {
                            accessibilityNodeInfoCompat.addChild(this.view, semanticsNode3.getId());
                        }
                    }
                    this.drawingOrder.put(semanticsNode3.getId(), i2);
                    i2++;
                }
            }
        }
        if (i == this.accessibilityFocusedVirtualViewId) {
            accessibilityNodeInfoCompat.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode, accessibilityNodeInfoCompat);
        setContentInvalid(semanticsNode, accessibilityNodeInfoCompat);
        infoStateDescriptionOrNull = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoStateDescriptionOrNull(semanticsNode, resources);
        accessibilityNodeInfoCompat.setStateDescription(infoStateDescriptionOrNull);
        infoIsCheckable = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoIsCheckable(semanticsNode);
        accessibilityNodeInfoCompat.setCheckable(infoIsCheckable);
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleableState != null) {
            if (toggleableState == ToggleableState.On) {
                accessibilityNodeInfoCompat.setChecked(true);
            } else if (toggleableState == ToggleableState.Off) {
                accessibilityNodeInfoCompat.setChecked(false);
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (role == null ? false : Role.m7438equalsimpl0(role.m7441unboximpl(), Role.Companion.m7449getTabo7Vup1c())) {
                accessibilityNodeInfoCompat.setSelected(booleanValue);
            } else {
                accessibilityNodeInfoCompat.setChecked(booleanValue);
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig$ui().isMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getContentDescription());
            accessibilityNodeInfoCompat.setContentDescription(list != null ? (String) CollectionsKt.firstOrNull((List<? extends Object>) list) : null);
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getTestTag());
        if (str != null) {
            SemanticsNode semanticsNode4 = semanticsNode;
            while (true) {
                if (semanticsNode4 == null) {
                    z2 = false;
                    break;
                } else if (semanticsNode4.getUnmergedConfig$ui().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                    z2 = ((Boolean) semanticsNode4.getUnmergedConfig$ui().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                    break;
                } else {
                    semanticsNode4 = semanticsNode4.getParent();
                }
            }
            if (z2) {
                accessibilityNodeInfoCompat.setViewIdResourceName(str);
            }
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            accessibilityNodeInfoCompat.setHeading(true);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        if (i != -1) {
            int orDefault = this.drawingOrder.getOrDefault(semanticsNode.getId(), -1);
            if (orDefault != -1) {
                accessibilityNodeInfoCompat.setDrawingOrder(orDefault);
                Unit unit9 = Unit.INSTANCE;
            } else {
                Integer.valueOf(Log.w(LogTag, "Drawing order is not available, was AccessibilityNodeInfo requested for a child node before its parent?"));
            }
        }
        accessibilityNodeInfoCompat.setPassword(semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPassword()));
        accessibilityNodeInfoCompat.setEditable(semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getIsEditable()));
        Integer num = (Integer) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getMaxTextLength());
        accessibilityNodeInfoCompat.setMaxTextLength(num != null ? num.intValue() : -1);
        enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        accessibilityNodeInfoCompat.setEnabled(enabled);
        accessibilityNodeInfoCompat.setFocusable(semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getFocused()));
        if (accessibilityNodeInfoCompat.isFocusable()) {
            accessibilityNodeInfoCompat.setFocused(((Boolean) semanticsNode.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (accessibilityNodeInfoCompat.isFocused()) {
                accessibilityNodeInfoCompat.addAction(2);
                this.focusedVirtualViewId = i;
            } else {
                accessibilityNodeInfoCompat.addAction(1);
            }
        }
        accessibilityNodeInfoCompat.setVisibleToUser(!SemanticsOwnerKt.isHidden(semanticsNode));
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int m7432unboximpl = liveRegionMode.m7432unboximpl();
            accessibilityNodeInfoCompat.setLiveRegion((!LiveRegionMode.m7429equalsimpl0(m7432unboximpl, LiveRegionMode.Companion.m7434getPolite0phEisY()) && LiveRegionMode.m7429equalsimpl0(m7432unboximpl, LiveRegionMode.Companion.m7433getAssertive0phEisY())) ? 2 : 1);
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setClickable(false);
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnClick());
        if (accessibilityAction != null) {
            boolean areEqual2 = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            if (!(role == null ? false : Role.m7438equalsimpl0(role.m7441unboximpl(), Role.Companion.m7449getTabo7Vup1c()))) {
                if (!(role == null ? false : Role.m7438equalsimpl0(role.m7441unboximpl(), Role.Companion.m7447getRadioButtono7Vup1c()))) {
                    z = false;
                    accessibilityNodeInfoCompat.setClickable(z || (z && !areEqual2));
                    enabled8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                    if (enabled8 && accessibilityNodeInfoCompat.isClickable()) {
                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
                    }
                    Unit unit12 = Unit.INSTANCE;
                    Unit unit13 = Unit.INSTANCE;
                }
            }
            z = true;
            accessibilityNodeInfoCompat.setClickable(z || (z && !areEqual2));
            enabled8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled8) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
            }
            Unit unit122 = Unit.INSTANCE;
            Unit unit132 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setLongClickable(false);
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnLongClick());
        if (accessibilityAction2 != null) {
            accessibilityNodeInfoCompat.setLongClickable(true);
            enabled7 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled7) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.getLabel()));
            }
            Unit unit14 = Unit.INSTANCE;
            Unit unit15 = Unit.INSTANCE;
        }
        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCopyText());
        if (accessibilityAction3 != null) {
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.getLabel()));
            Unit unit16 = Unit.INSTANCE;
            Unit unit17 = Unit.INSTANCE;
        }
        enabled2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled2) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetText());
            if (accessibilityAction4 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction4.getLabel()));
                Unit unit18 = Unit.INSTANCE;
                Unit unit19 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnImeAction());
            if (accessibilityAction5 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908372, accessibilityAction5.getLabel()));
                Unit unit20 = Unit.INSTANCE;
                Unit unit21 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCutText());
            if (accessibilityAction6 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction6.getLabel()));
                Unit unit22 = Unit.INSTANCE;
                Unit unit23 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPasteText());
            if (accessibilityAction7 != null) {
                if (accessibilityNodeInfoCompat.isFocused() && this.view.getClipboardManager().hasText()) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction7.getLabel()));
                }
                Unit unit24 = Unit.INSTANCE;
                Unit unit25 = Unit.INSTANCE;
            }
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (!(iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0)) {
            accessibilityNodeInfoCompat.setTextSelection(getAccessibilitySelectionStart(semanticsNode), getAccessibilitySelectionEnd(semanticsNode));
            AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetSelection());
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, accessibilityAction8 != null ? accessibilityAction8.getLabel() : null));
            accessibilityNodeInfoCompat.addAction(256);
            accessibilityNodeInfoCompat.addAction(512);
            accessibilityNodeInfoCompat.setMovementGranularities(11);
            List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getContentDescription());
            if ((list2 == null || list2.isEmpty()) && semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                excludeLineAndPageGranularities = AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode);
                if (!excludeLineAndPageGranularities) {
                    accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat.getMovementGranularities() | 20);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ExtraDataIdKey);
            CharSequence text = accessibilityNodeInfoCompat.getText();
            if (!(text == null || text.length() == 0) && semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                arrayList.add(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY);
            }
            if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getTestTag())) {
                arrayList.add(ExtraDataTestTagKey);
            }
            if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getShape())) {
                arrayList.add(ExtraDataShapeTypeKey);
                arrayList.add(ExtraDataShapeRectKey);
                arrayList.add(ExtraDataShapeRectCornersKey);
                arrayList.add(ExtraDataShapeRegionKey);
            }
            ScatterSet<SemanticsPropertyKey<?>> accessibilityExtraKeys$ui = semanticsNode.getUnmergedConfig$ui().getAccessibilityExtraKeys$ui();
            if (accessibilityExtraKeys$ui != null) {
                Object[] objArr = accessibilityExtraKeys$ui.elements;
                long[] jArr = accessibilityExtraKeys$ui.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i4 = 0;
                    while (true) {
                        long j = jArr[i4];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i5 = 8 - ((~(i4 - length)) >>> 31);
                            long j2 = j;
                            for (int i6 = 0; i6 < i5; i6++) {
                                if (((j2 & 255) < 128) && (accessibilityExtraKey$ui = ((SemanticsPropertyKey) objArr[(i4 << 3) + i6]).getAccessibilityExtraKey$ui()) != null) {
                                    arrayList.add(accessibilityExtraKey$ui);
                                    Unit unit26 = Unit.INSTANCE;
                                    Unit unit27 = Unit.INSTANCE;
                                }
                                j2 >>= 8;
                            }
                            if (i5 != 8) {
                                break;
                            }
                        }
                        if (i4 == length) {
                            break;
                        }
                        i4++;
                    }
                }
                Unit unit28 = Unit.INSTANCE;
            }
            accessibilityNodeInfoCompat.setAvailableExtraData(arrayList);
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
            }
            if (progressBarRangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getCurrent()));
            }
            if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                enabled6 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                if (enabled6) {
                    if (progressBarRangeInfo.getCurrent() < RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue())) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    }
                    if (progressBarRangeInfo.getCurrent() > RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue())) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    }
                }
            }
        }
        Api24Impl.addSetProgressAction(accessibilityNodeInfoCompat, semanticsNode);
        CollectionInfo_androidKt.setCollectionInfo(semanticsNode, accessibilityNodeInfoCompat);
        CollectionInfo_androidKt.setCollectionItemInfo(semanticsNode, accessibilityNodeInfoCompat);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getScrollBy());
        if (scrollAxisRange != null && accessibilityAction9 != null) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
            }
            if (scrollAxisRange.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            enabled5 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled5) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    isRtl2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    if (!isRtl2) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    if (!isRtl) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (scrollAxisRange2 != null && accessibilityAction9 != null) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
            }
            if (scrollAxisRange2.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            enabled4 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled4) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.addPageActions(accessibilityNodeInfoCompat, semanticsNode);
        }
        accessibilityNodeInfoCompat.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getPaneTitle()));
        enabled3 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled3) {
            AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getExpand());
            if (accessibilityAction10 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction10.getLabel()));
                Unit unit29 = Unit.INSTANCE;
                Unit unit30 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCollapse());
            if (accessibilityAction11 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction11.getLabel()));
                Unit unit31 = Unit.INSTANCE;
                Unit unit32 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getDismiss());
            if (accessibilityAction12 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, accessibilityAction12.getLabel()));
                Unit unit33 = Unit.INSTANCE;
                Unit unit34 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List list3 = (List) semanticsNode.getUnmergedConfig$ui().get(SemanticsActions.INSTANCE.getCustomActions());
                int size2 = list3.size();
                IntList intList = AccessibilityActionsResourceIds;
                if (size2 >= intList._size) {
                    throw new IllegalStateException("Can't have more than " + intList._size + " custom actions for one widget");
                }
                SparseArrayCompat<CharSequence> sparseArrayCompat = new SparseArrayCompat<>(0, 1, null);
                MutableObjectIntMap<CharSequence> mutableObjectIntMapOf = ObjectIntMapKt.mutableObjectIntMapOf();
                if (this.labelToActionId.containsKey(i)) {
                    MutableObjectIntMap<CharSequence> mutableObjectIntMap = this.labelToActionId.get(i);
                    MutableIntList mutableIntList = new MutableIntList(0, 1, null);
                    int[] iArr = intList.content;
                    int i7 = intList._size;
                    for (int i8 = 0; i8 < i7; i8++) {
                        mutableIntList.add(iArr[i8]);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size3 = list3.size();
                    for (int i9 = 0; i9 < size3; i9++) {
                        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list3.get(i9);
                        Intrinsics.checkNotNull(mutableObjectIntMap);
                        if (mutableObjectIntMap.containsKey(customAccessibilityAction.getLabel())) {
                            int i10 = mutableObjectIntMap.get(customAccessibilityAction.getLabel());
                            sparseArrayCompat.put(i10, customAccessibilityAction.getLabel());
                            mutableObjectIntMapOf.set(customAccessibilityAction.getLabel(), i10);
                            mutableIntList.remove(i10);
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i10, customAccessibilityAction.getLabel()));
                            Unit unit35 = Unit.INSTANCE;
                        } else {
                            Boolean.valueOf(arrayList2.add(customAccessibilityAction));
                        }
                    }
                    int size4 = arrayList2.size();
                    for (int i11 = 0; i11 < size4; i11++) {
                        CustomAccessibilityAction customAccessibilityAction2 = (CustomAccessibilityAction) arrayList2.get(i11);
                        int i12 = mutableIntList.get(i11);
                        sparseArrayCompat.put(i12, customAccessibilityAction2.getLabel());
                        mutableObjectIntMapOf.set(customAccessibilityAction2.getLabel(), i12);
                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i12, customAccessibilityAction2.getLabel()));
                    }
                } else {
                    int size5 = list3.size();
                    for (int i13 = 0; i13 < size5; i13++) {
                        CustomAccessibilityAction customAccessibilityAction3 = (CustomAccessibilityAction) list3.get(i13);
                        int i14 = AccessibilityActionsResourceIds.get(i13);
                        sparseArrayCompat.put(i14, customAccessibilityAction3.getLabel());
                        mutableObjectIntMapOf.set(customAccessibilityAction3.getLabel(), i14);
                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i14, customAccessibilityAction3.getLabel()));
                    }
                }
                this.actionIdToLabel.put(i, sparseArrayCompat);
                this.labelToActionId.put(i, mutableObjectIntMapOf);
            }
        }
        isScreenReaderFocusable = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isScreenReaderFocusable(semanticsNode, resources);
        accessibilityNodeInfoCompat.setScreenReaderFocusable(isScreenReaderFocusable);
        int orDefault2 = this.idToBeforeMap.getOrDefault(i, -1);
        if (orDefault2 != -1) {
            View semanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui(), orDefault2);
            if (semanticsIdToView2 != null) {
                accessibilityNodeInfoCompat.setTraversalBefore(semanticsIdToView2);
            } else {
                accessibilityNodeInfoCompat.setTraversalBefore(this.view, orDefault2);
            }
            addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfoCompat, this.ExtraDataTestTraversalBeforeVal, null);
        }
        int orDefault3 = this.idToAfterMap.getOrDefault(i, -1);
        if (orDefault3 != -1 && (semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui(), orDefault3)) != null) {
            accessibilityNodeInfoCompat.setTraversalAfter(semanticsIdToView);
            addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfoCompat, this.ExtraDataTestTraversalAfterVal, null);
        }
        String str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName());
        if (str2 != null) {
            accessibilityNodeInfoCompat.setClassName(str2);
            Unit unit36 = Unit.INSTANCE;
            Unit unit37 = Unit.INSTANCE;
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        if (scrollAxisRange.getValue().invoke().floatValue() >= scrollAxisRange.getMaxValue().invoke().floatValue() || scrollAxisRange.getReverseScrolling()) {
            return scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling();
        }
        return true;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        if (scrollAxisRange.getValue().invoke().floatValue() <= 0.0f || scrollAxisRange.getReverseScrolling()) {
            return scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling();
        }
        return true;
    }

    private final void setContentInvalid(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getError())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final SpannableString toSpannableString(AnnotatedString annotatedString) {
        return (SpannableString) trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), this.view.getFontFamilyResolver(), this.urlSpanCache), 100000);
    }

    private final void setText(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AnnotatedString infoText;
        infoText = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoText(semanticsNode);
        accessibilityNodeInfoCompat.setText(infoText != null ? toSpannableString(infoText) : null);
    }

    private final boolean isAccessibilityFocused(int i) {
        return this.accessibilityFocusedVirtualViewId == i;
    }

    private final boolean requestAccessibilityFocus(int i) {
        if (isTouchExplorationEnabled() && !isAccessibilityFocused(i)) {
            int i2 = this.accessibilityFocusedVirtualViewId;
            if (i2 != Integer.MIN_VALUE) {
                sendEventForVirtualView$default(this, i2, 65536, null, null, 12, null);
            }
            this.accessibilityFocusedVirtualViewId = i;
            this.view.invalidate();
            sendEventForVirtualView$default(this, i, 32768, null, null, 12, null);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int i, int i2, Integer num, List<String> list) {
        if (i == Integer.MIN_VALUE || !isEnabled$ui()) {
            return false;
        }
        AccessibilityEvent createEvent = createEvent(i, i2);
        if (num != null) {
            createEvent.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            createEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(list, StringUtils.COMMA, null, null, 0, null, null, 62, null));
        }
        return sendEvent(createEvent);
    }

    private final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (isEnabled$ui()) {
            if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
                this.sendingFocusAffectingEvent = true;
            }
            try {
                return this.onSendAccessibilityEvent.invoke(accessibilityEvent).booleanValue();
            } finally {
                this.sendingFocusAffectingEvent = false;
            }
        }
        return false;
    }

    private final AccessibilityEvent createEvent(int i, int i2) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(ClassName);
        obtain.setPackageName(this.view.getContext().getPackageName());
        obtain.setSource(this.view, i);
        if (isEnabled$ui() && (semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i)) != null) {
            obtain.setPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPassword()));
            AccessibilityEventCompat.setAccessibilityDataSensitive(obtain, Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true));
        }
        return obtain;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int i, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent createEvent = createEvent(i, 8192);
        if (num != null) {
            createEvent.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            createEvent.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            createEvent.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            createEvent.getText().add(charSequence);
        }
        return createEvent;
    }

    private final boolean clearAccessibilityFocus(int i) {
        if (isAccessibilityFocused(i)) {
            this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.currentlyAccessibilityFocusedANI = null;
            this.view.invalidate();
            sendEventForVirtualView$default(this, i, 65536, null, null, 12, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0231  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x01ce -> B:102:0x01cf). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean performActionHelper(int i, int i2, Bundle bundle) {
        SemanticsNode semanticsNode;
        Function0 function0;
        boolean enabled;
        Function0 function02;
        Function0 function03;
        Function0 function04;
        float f;
        int i3;
        float f2;
        float intBitsToFloat;
        AccessibilityAction accessibilityAction;
        Function0 function05;
        float intBitsToFloat2;
        boolean isRtl;
        AccessibilityAction accessibilityAction2;
        Function0 function06;
        Function0 function07;
        Function0 function08;
        Function0 function09;
        Function0 function010;
        Function0 function011;
        Function1 function1;
        AccessibilityAction accessibilityAction3;
        boolean isRtl2;
        Function2 function2;
        SemanticsConfiguration unmergedConfig$ui;
        SemanticsConfiguration unmergedConfig$ui2;
        AccessibilityAction accessibilityAction4;
        Function1 function12;
        Function0 function012;
        Function0 function013;
        Function0 function014;
        Function0 function015;
        Function0 function016;
        CharSequence charSequence;
        List list;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return false;
        }
        if (!Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true) || isRequestFromAccessibilityTool()) {
            if (i2 != 64) {
                if (i2 != 128) {
                    if (i2 == 256 || i2 == 512) {
                        if (bundle != null) {
                            return traverseAtGranularity(semanticsNode, bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT), i2 == 256, bundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN));
                        }
                        return false;
                    } else if (i2 == 16384) {
                        AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCopyText());
                        if (accessibilityAction5 == null || (function0 = (Function0) accessibilityAction5.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function0.invoke()).booleanValue();
                    } else if (i2 != 131072) {
                        enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                        if (enabled) {
                            if (i2 == 1) {
                                if (this.view.isInTouchMode()) {
                                    this.view.requestFocusFromTouch();
                                }
                                AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getRequestFocus());
                                if (accessibilityAction6 == null || (function02 = (Function0) accessibilityAction6.getAction()) == null) {
                                    return false;
                                }
                                return ((Boolean) function02.invoke()).booleanValue();
                            } else if (i2 != 2) {
                                Boolean bool = null;
                                switch (i2) {
                                    case 16:
                                        AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnClick());
                                        if (accessibilityAction7 != null && (function03 = (Function0) accessibilityAction7.getAction()) != null) {
                                            bool = (Boolean) function03.invoke();
                                        }
                                        sendEventForVirtualView$default(this, i, 1, null, null, 12, null);
                                        if (bool != null) {
                                            return bool.booleanValue();
                                        }
                                        return false;
                                    case 32:
                                        AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnLongClick());
                                        if (accessibilityAction8 == null || (function04 = (Function0) accessibilityAction8.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function04.invoke()).booleanValue();
                                    case 4096:
                                    case 8192:
                                        break;
                                    case 32768:
                                        AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPasteText());
                                        if (accessibilityAction9 == null || (function07 = (Function0) accessibilityAction9.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function07.invoke()).booleanValue();
                                    case 65536:
                                        AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCutText());
                                        if (accessibilityAction10 == null || (function08 = (Function0) accessibilityAction10.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function08.invoke()).booleanValue();
                                    case 262144:
                                        AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getExpand());
                                        if (accessibilityAction11 == null || (function09 = (Function0) accessibilityAction11.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function09.invoke()).booleanValue();
                                    case 524288:
                                        AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCollapse());
                                        if (accessibilityAction12 == null || (function010 = (Function0) accessibilityAction12.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function010.invoke()).booleanValue();
                                    case 1048576:
                                        AccessibilityAction accessibilityAction13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getDismiss());
                                        if (accessibilityAction13 == null || (function011 = (Function0) accessibilityAction13.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function011.invoke()).booleanValue();
                                    case 2097152:
                                        String string = bundle != null ? bundle.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE) : null;
                                        AccessibilityAction accessibilityAction14 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetText());
                                        if (accessibilityAction14 == null || (function1 = (Function1) accessibilityAction14.getAction()) == null) {
                                            return false;
                                        }
                                        if (string == null) {
                                            string = "";
                                        }
                                        return ((Boolean) function1.invoke(new AnnotatedString(string, null, 2, null))).booleanValue();
                                    case 16908342:
                                        SemanticsNode parent = semanticsNode.getParent();
                                        if (parent != null && (unmergedConfig$ui2 = parent.getUnmergedConfig$ui()) != null) {
                                            accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui2, SemanticsActions.INSTANCE.getScrollBy());
                                            while (parent != null && accessibilityAction3 == null) {
                                                parent = parent.getParent();
                                                if (parent != null && (unmergedConfig$ui = parent.getUnmergedConfig$ui()) != null) {
                                                    accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui, SemanticsActions.INSTANCE.getScrollBy());
                                                }
                                            }
                                            if (parent != null) {
                                                androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                                                return this.view.requestRectangleOnScreen(new Rect((int) Math.floor(boundsInRoot.getLeft()), (int) Math.floor(boundsInRoot.getTop()), MathKt.roundToInt((float) Math.ceil(boundsInRoot.getRight())), MathKt.roundToInt((float) Math.ceil(boundsInRoot.getBottom()))));
                                            }
                                            androidx.compose.ui.geometry.Rect boundsInParent = LayoutCoordinatesKt.boundsInParent(parent.getLayoutInfo().getCoordinates());
                                            LayoutCoordinates parentLayoutCoordinates = parent.getLayoutInfo().getCoordinates().getParentLayoutCoordinates();
                                            androidx.compose.ui.geometry.Rect m5216translatek4lQ0M = boundsInParent.m5216translatek4lQ0M(parentLayoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(parentLayoutCoordinates) : Offset.Companion.m5195getZeroF1C5BW0());
                                            androidx.compose.ui.geometry.Rect m5219Recttz77jQw = RectKt.m5219Recttz77jQw(semanticsNode.m7452getPositionInRootF1C5BW0(), IntSizeKt.m8441toSizeozmzZPI(semanticsNode.m7455getSizeYbymL2g()));
                                            ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(parent.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                                            ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(parent.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                            float performActionHelper$scrollDelta = performActionHelper$scrollDelta(m5219Recttz77jQw.getLeft() - m5216translatek4lQ0M.getLeft(), m5219Recttz77jQw.getRight() - m5216translatek4lQ0M.getRight());
                                            if (scrollAxisRange != null && scrollAxisRange.getReverseScrolling()) {
                                                performActionHelper$scrollDelta = -performActionHelper$scrollDelta;
                                            }
                                            isRtl2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                                            if (isRtl2) {
                                                performActionHelper$scrollDelta = -performActionHelper$scrollDelta;
                                            }
                                            float performActionHelper$scrollDelta2 = performActionHelper$scrollDelta(m5219Recttz77jQw.getTop() - m5216translatek4lQ0M.getTop(), m5219Recttz77jQw.getBottom() - m5216translatek4lQ0M.getBottom());
                                            if (scrollAxisRange2 != null && scrollAxisRange2.getReverseScrolling()) {
                                                performActionHelper$scrollDelta2 = -performActionHelper$scrollDelta2;
                                            }
                                            return (accessibilityAction3 == null || (function2 = (Function2) accessibilityAction3.getAction()) == null || !((Boolean) function2.invoke(Float.valueOf(performActionHelper$scrollDelta), Float.valueOf(performActionHelper$scrollDelta2))).booleanValue()) ? false : true;
                                        }
                                        accessibilityAction3 = null;
                                        while (parent != null) {
                                            parent = parent.getParent();
                                            if (parent != null) {
                                                accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui, SemanticsActions.INSTANCE.getScrollBy());
                                            }
                                            accessibilityAction3 = null;
                                            while (parent != null) {
                                            }
                                        }
                                        if (parent != null) {
                                        }
                                        break;
                                    case 16908349:
                                        if (bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) || (accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetProgress())) == null || (function12 = (Function1) accessibilityAction4.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function12.invoke(Float.valueOf(bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)))).booleanValue();
                                    case 16908372:
                                        AccessibilityAction accessibilityAction15 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnImeAction());
                                        if (accessibilityAction15 == null || (function012 = (Function0) accessibilityAction15.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function012.invoke()).booleanValue();
                                    default:
                                        switch (i2) {
                                            case 16908344:
                                            case 16908345:
                                            case 16908346:
                                            case 16908347:
                                                break;
                                            default:
                                                switch (i2) {
                                                    case 16908358:
                                                        AccessibilityAction accessibilityAction16 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageUp());
                                                        if (accessibilityAction16 == null || (function013 = (Function0) accessibilityAction16.getAction()) == null) {
                                                            return false;
                                                        }
                                                        return ((Boolean) function013.invoke()).booleanValue();
                                                    case 16908359:
                                                        AccessibilityAction accessibilityAction17 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageDown());
                                                        if (accessibilityAction17 == null || (function014 = (Function0) accessibilityAction17.getAction()) == null) {
                                                            return false;
                                                        }
                                                        return ((Boolean) function014.invoke()).booleanValue();
                                                    case 16908360:
                                                        AccessibilityAction accessibilityAction18 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageLeft());
                                                        if (accessibilityAction18 == null || (function015 = (Function0) accessibilityAction18.getAction()) == null) {
                                                            return false;
                                                        }
                                                        return ((Boolean) function015.invoke()).booleanValue();
                                                    case 16908361:
                                                        AccessibilityAction accessibilityAction19 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageRight());
                                                        if (accessibilityAction19 == null || (function016 = (Function0) accessibilityAction19.getAction()) == null) {
                                                            return false;
                                                        }
                                                        return ((Boolean) function016.invoke()).booleanValue();
                                                    default:
                                                        SparseArrayCompat<CharSequence> sparseArrayCompat = this.actionIdToLabel.get(i);
                                                        if (sparseArrayCompat == null || (charSequence = sparseArrayCompat.get(i2)) == null || (list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCustomActions())) == null) {
                                                            return false;
                                                        }
                                                        int size = list.size();
                                                        for (int i4 = 0; i4 < size; i4++) {
                                                            CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list.get(i4);
                                                            if (Intrinsics.areEqual(customAccessibilityAction.getLabel(), charSequence)) {
                                                                return customAccessibilityAction.getAction().invoke().booleanValue();
                                                            }
                                                        }
                                                        return false;
                                                }
                                        }
                                }
                                boolean z = i2 == 4096;
                                boolean z2 = i2 == 8192;
                                boolean z3 = i2 == 16908345;
                                boolean z4 = i2 == 16908347;
                                boolean z5 = i2 == 16908344;
                                boolean z6 = i2 == 16908346;
                                boolean z7 = z3 || z4 || z || z2;
                                boolean z8 = z5 || z6 || z || z2;
                                if (z || z2) {
                                    ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
                                    AccessibilityAction accessibilityAction20 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetProgress());
                                    if (progressBarRangeInfo != null && accessibilityAction20 != null) {
                                        float coerceAtLeast = RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue());
                                        float coerceAtMost = RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue());
                                        if (progressBarRangeInfo.getSteps() > 0) {
                                            f = coerceAtLeast - coerceAtMost;
                                            i3 = progressBarRangeInfo.getSteps() + 1;
                                        } else {
                                            f = coerceAtLeast - coerceAtMost;
                                            i3 = 20;
                                        }
                                        float f3 = f / i3;
                                        if (z2) {
                                            f3 = -f3;
                                        }
                                        Function1 function13 = (Function1) accessibilityAction20.getAction();
                                        if (function13 != null) {
                                            return ((Boolean) function13.invoke(Float.valueOf(progressBarRangeInfo.getCurrent() + f3))).booleanValue();
                                        }
                                        return false;
                                    }
                                }
                                long m5212getSizeNHjbRc = LayoutCoordinatesKt.boundsInParent(semanticsNode.getLayoutInfo().getCoordinates()).m5212getSizeNHjbRc();
                                Float scrollViewportLength = SemanticsUtils_androidKt.getScrollViewportLength(semanticsNode.getUnmergedConfig$ui());
                                AccessibilityAction accessibilityAction21 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getScrollBy());
                                if (accessibilityAction21 == null) {
                                    return false;
                                }
                                ScrollAxisRange scrollAxisRange3 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                                if (scrollAxisRange3 == null || !z7) {
                                    f2 = 0.0f;
                                } else {
                                    if (scrollViewportLength != null) {
                                        intBitsToFloat2 = scrollViewportLength.floatValue();
                                        f2 = 0.0f;
                                    } else {
                                        f2 = 0.0f;
                                        intBitsToFloat2 = Float.intBitsToFloat((int) (m5212getSizeNHjbRc >> 32));
                                    }
                                    if (z3 || z2) {
                                        intBitsToFloat2 = -intBitsToFloat2;
                                    }
                                    if (scrollAxisRange3.getReverseScrolling()) {
                                        intBitsToFloat2 = -intBitsToFloat2;
                                    }
                                    isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                                    if (isRtl && (z3 || z4)) {
                                        intBitsToFloat2 = -intBitsToFloat2;
                                    }
                                    if (performActionHelper$canScroll(scrollAxisRange3, intBitsToFloat2)) {
                                        if (!semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getPageLeft()) && !semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getPageRight())) {
                                            Function2 function22 = (Function2) accessibilityAction21.getAction();
                                            if (function22 != null) {
                                                return ((Boolean) function22.invoke(Float.valueOf(intBitsToFloat2), Float.valueOf(f2))).booleanValue();
                                            }
                                            return false;
                                        }
                                        if (intBitsToFloat2 > f2) {
                                            accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageRight());
                                        } else {
                                            accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageLeft());
                                        }
                                        if (accessibilityAction2 == null || (function06 = (Function0) accessibilityAction2.getAction()) == null) {
                                            return false;
                                        }
                                        return ((Boolean) function06.invoke()).booleanValue();
                                    }
                                }
                                ScrollAxisRange scrollAxisRange4 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                if (scrollAxisRange4 != null && z8) {
                                    if (scrollViewportLength != null) {
                                        intBitsToFloat = scrollViewportLength.floatValue();
                                    } else {
                                        intBitsToFloat = Float.intBitsToFloat((int) (4294967295L & m5212getSizeNHjbRc));
                                    }
                                    if (z5 || z2) {
                                        intBitsToFloat = -intBitsToFloat;
                                    }
                                    if (scrollAxisRange4.getReverseScrolling()) {
                                        intBitsToFloat = -intBitsToFloat;
                                    }
                                    if (performActionHelper$canScroll(scrollAxisRange4, intBitsToFloat)) {
                                        if (!semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getPageUp()) && !semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getPageDown())) {
                                            Function2 function23 = (Function2) accessibilityAction21.getAction();
                                            if (function23 != null) {
                                                return ((Boolean) function23.invoke(Float.valueOf(f2), Float.valueOf(intBitsToFloat))).booleanValue();
                                            }
                                            return false;
                                        }
                                        if (intBitsToFloat > f2) {
                                            accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageDown());
                                        } else {
                                            accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageUp());
                                        }
                                        if (accessibilityAction != null && (function05 = (Function0) accessibilityAction.getAction()) != null) {
                                            return ((Boolean) function05.invoke()).booleanValue();
                                        }
                                    }
                                }
                                return false;
                            } else if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
                                this.view.getFocusOwner().mo5070clearFocusI7lrPNg(false, true, true, FocusDirection.Companion.m5060getExitdhqQ8s());
                                return true;
                            } else {
                                return false;
                            }
                        }
                        return false;
                    } else {
                        boolean accessibilitySelection = setAccessibilitySelection(semanticsNode, bundle != null ? bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT, -1) : -1, bundle != null ? bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT, -1) : -1, false);
                        if (accessibilitySelection) {
                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 0, null, null, 12, null);
                        }
                        return accessibilitySelection;
                    }
                }
                return clearAccessibilityFocus(i);
            }
            return requestAccessibilityFocus(i);
        }
        return false;
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        if (f >= 0.0f || scrollAxisRange.getValue().invoke().floatValue() <= 0.0f) {
            return f > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue();
        }
        return true;
    }

    private static final float performActionHelper$scrollDelta(float f, float f2) {
        if (Math.signum(f) == Math.signum(f2)) {
            return Math.abs(f) < Math.abs(f2) ? f : f2;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        SemanticsNode semanticsNode;
        float[] cornerArray;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (Intrinsics.areEqual(str, this.ExtraDataTestTraversalBeforeVal)) {
            int orDefault = this.idToBeforeMap.getOrDefault(i, -1);
            if (orDefault != -1) {
                accessibilityNodeInfoCompat.getExtras().putInt(str, orDefault);
            }
        } else if (Intrinsics.areEqual(str, this.ExtraDataTestTraversalAfterVal)) {
            int orDefault2 = this.idToAfterMap.getOrDefault(i, -1);
            if (orDefault2 != -1) {
                accessibilityNodeInfoCompat.getExtras().putInt(str, orDefault2);
            }
        } else {
            int i2 = 0;
            if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && bundle != null && Intrinsics.areEqual(str, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY)) {
                int i3 = bundle.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX, -1);
                int i4 = bundle.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH, -1);
                if (i4 > 0 && i3 >= 0) {
                    if (i3 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                        TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig$ui());
                        if (textLayoutResult == null) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i5 = 0; i5 < i4; i5++) {
                            int i6 = i3 + i5;
                            if (i6 >= textLayoutResult.getLayoutInput().getText().length()) {
                                arrayList.add(null);
                            } else {
                                arrayList.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i6)));
                            }
                        }
                        accessibilityNodeInfoCompat.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                        return;
                    }
                }
                Log.e(LogTag, "Invalid arguments for accessibility character locations");
            } else if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getTestTag()) && bundle != null && Intrinsics.areEqual(str, ExtraDataTestTagKey)) {
                String str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getTestTag());
                if (str2 != null) {
                    accessibilityNodeInfoCompat.getExtras().putCharSequence(str, str2);
                }
            } else if (Intrinsics.areEqual(str, ExtraDataIdKey)) {
                accessibilityNodeInfoCompat.getExtras().putInt(str, semanticsNode.getId());
            } else if (Intrinsics.areEqual(str, ExtraDataShapeTypeKey)) {
                Shape shape = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getShape());
                if (shape != null) {
                    androidx.compose.ui.geometry.Rect shapeBounds = getShapeBounds(semanticsNode, getBoundsInScreen(accessibilityNodeInfoCompat), shape);
                    Outline m7324createOutline12SF9DM = m7324createOutline12SF9DM(shape, shapeBounds.m5212getSizeNHjbRc(), semanticsNode.getLayoutInfo().getLayoutDirection());
                    if (m7324createOutline12SF9DM instanceof Outline.Rectangle) {
                        accessibilityNodeInfoCompat.getExtras().putInt(ExtraDataShapeTypeKey, 0);
                        accessibilityNodeInfoCompat.getExtras().putParcelable(ExtraDataShapeRectKey, toAndroidRect(m7324createOutline12SF9DM, shapeBounds.getLeft(), shapeBounds.getTop()));
                    } else if (m7324createOutline12SF9DM instanceof Outline.Rounded) {
                        accessibilityNodeInfoCompat.getExtras().putInt(ExtraDataShapeTypeKey, 1);
                        accessibilityNodeInfoCompat.getExtras().putParcelable(ExtraDataShapeRectKey, toAndroidRect(m7324createOutline12SF9DM, shapeBounds.getLeft(), shapeBounds.getTop()));
                        accessibilityNodeInfoCompat.getExtras().putFloatArray(ExtraDataShapeRectCornersKey, toCornerArray(m7324createOutline12SF9DM));
                    } else if (m7324createOutline12SF9DM instanceof Outline.Generic) {
                        accessibilityNodeInfoCompat.getExtras().putInt(ExtraDataShapeTypeKey, 2);
                        accessibilityNodeInfoCompat.getExtras().putParcelable(ExtraDataShapeRegionKey, toRegion(m7324createOutline12SF9DM, shapeBounds.getLeft(), shapeBounds.getTop()));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else if (Intrinsics.areEqual(str, ExtraDataShapeRectKey)) {
                Shape shape2 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getShape());
                if (shape2 != null) {
                    androidx.compose.ui.geometry.Rect shapeBounds2 = getShapeBounds(semanticsNode, getBoundsInScreen(accessibilityNodeInfoCompat), shape2);
                    Rect androidRect = toAndroidRect(m7324createOutline12SF9DM(shape2, shapeBounds2.m5212getSizeNHjbRc(), semanticsNode.getLayoutInfo().getLayoutDirection()), shapeBounds2.getLeft(), shapeBounds2.getTop());
                    if (androidRect != null) {
                        accessibilityNodeInfoCompat.getExtras().putParcelable(ExtraDataShapeRectKey, androidRect);
                    }
                }
            } else if (Intrinsics.areEqual(str, ExtraDataShapeRectCornersKey)) {
                Shape shape3 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getShape());
                if (shape3 == null || (cornerArray = toCornerArray(m7324createOutline12SF9DM(shape3, getShapeBounds(semanticsNode, getBoundsInScreen(accessibilityNodeInfoCompat), shape3).m5212getSizeNHjbRc(), semanticsNode.getLayoutInfo().getLayoutDirection()))) == null) {
                    return;
                }
                accessibilityNodeInfoCompat.getExtras().putFloatArray(ExtraDataShapeRectCornersKey, cornerArray);
            } else if (Intrinsics.areEqual(str, ExtraDataShapeRegionKey)) {
                Shape shape4 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getShape());
                if (shape4 != null) {
                    androidx.compose.ui.geometry.Rect shapeBounds3 = getShapeBounds(semanticsNode, getBoundsInScreen(accessibilityNodeInfoCompat), shape4);
                    Region region = toRegion(m7324createOutline12SF9DM(shape4, shapeBounds3.m5212getSizeNHjbRc(), semanticsNode.getLayoutInfo().getLayoutDirection()), shapeBounds3.getLeft(), shapeBounds3.getTop());
                    if (region != null) {
                        accessibilityNodeInfoCompat.getExtras().putParcelable(ExtraDataShapeRegionKey, region);
                    }
                }
            } else {
                ScatterSet<SemanticsPropertyKey<?>> accessibilityExtraKeys$ui = semanticsNode.getUnmergedConfig$ui().getAccessibilityExtraKeys$ui();
                if (accessibilityExtraKeys$ui == null) {
                    return;
                }
                Object[] objArr = accessibilityExtraKeys$ui.elements;
                long[] jArr = accessibilityExtraKeys$ui.metadata;
                int length = jArr.length - 2;
                if (length < 0) {
                    return;
                }
                int i7 = 0;
                while (true) {
                    long j = jArr[i7];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i8 = 8 - ((~(i7 - length)) >>> 31);
                        for (int i9 = i2; i9 < i8; i9++) {
                            if ((255 & j) < 128) {
                                SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) objArr[(i7 << 3) + i9];
                                String accessibilityExtraKey$ui = semanticsPropertyKey.getAccessibilityExtraKey$ui();
                                if (Intrinsics.areEqual(accessibilityExtraKey$ui, str)) {
                                    Object orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), semanticsPropertyKey);
                                    if (orNull instanceof Serializable) {
                                        accessibilityNodeInfoCompat.getExtras().putSerializable(accessibilityExtraKey$ui, (Serializable) orNull);
                                    } else if (!(orNull instanceof Parcelable)) {
                                        throw new IllegalStateException("Accessibility extra values must be either Serializable or Parcelable.");
                                    } else {
                                        accessibilityNodeInfoCompat.getExtras().putParcelable(accessibilityExtraKey$ui, (Parcelable) orNull);
                                    }
                                } else {
                                    continue;
                                }
                            }
                            j >>= 8;
                        }
                        if (i8 != 8) {
                            return;
                        }
                    }
                    if (i7 == length) {
                        return;
                    }
                    i7++;
                    i2 = 0;
                }
            }
        }
    }

    private final Rect getBoundsInScreen(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Rect rect = new Rect();
        accessibilityNodeInfoCompat.getBoundsInScreen(rect);
        return rect;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1] */
    private final androidx.compose.ui.geometry.Rect getShapeBounds(SemanticsNode semanticsNode, Rect rect, final Shape shape) {
        Modifier.Node node;
        ?? r0 = new SemanticsPropertyReceiver() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1
            private boolean hasMatchedShape;

            public final boolean getHasMatchedShape() {
                return this.hasMatchedShape;
            }

            public final void setHasMatchedShape(boolean z) {
                this.hasMatchedShape = z;
            }

            @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
            public <T> void set(SemanticsPropertyKey<T> semanticsPropertyKey, T t) {
                if (t == Shape.this) {
                    this.hasMatchedShape = true;
                }
            }
        };
        LayoutNode layoutNode$ui = semanticsNode.getLayoutNode$ui();
        NodeChain nodes$ui = layoutNode$ui.getNodes$ui();
        int m7195constructorimpl = NodeKind.m7195constructorimpl(8);
        SemanticsModifierNode semanticsModifierNode = null;
        if ((nodes$ui.getAggregateChildKindSet() & m7195constructorimpl) != 0) {
            Modifier.Node head$ui = nodes$ui.getHead$ui();
            loop0: while (true) {
                if (head$ui == null) {
                    break;
                }
                if ((head$ui.getKindSet$ui() & m7195constructorimpl) != 0) {
                    Modifier.Node node2 = head$ui;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        if (node2 instanceof SemanticsModifierNode) {
                            ((SemanticsModifierNode) node2).applySemantics((SemanticsPropertyReceiver) r0);
                            if (r0.getHasMatchedShape()) {
                                semanticsModifierNode = node2;
                                break loop0;
                            }
                        } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & m7195constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node2 = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node2 != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node2);
                                            }
                                            node2 = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node2 = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui.getAggregateChildKindSet$ui() & m7195constructorimpl) == 0) {
                    break;
                }
                head$ui = head$ui.getChild$ui();
            }
        }
        SemanticsModifierNode semanticsModifierNode2 = semanticsModifierNode;
        if (semanticsModifierNode2 == null || (node = semanticsModifierNode2.getNode()) == null || !node.isAttached()) {
            return LayoutCoordinatesKt.boundsInWindow(layoutNode$ui.getOuterCoordinator$ui(), false);
        }
        androidx.compose.ui.geometry.Rect boundsInRoot = LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.requireLayoutCoordinates(semanticsModifierNode2));
        return toBoundsRelativeToNodeBounds(toBoundsInScreen(boundsInRoot.getLeft(), boundsInRoot.getTop(), boundsInRoot.getRight(), boundsInRoot.getBottom()), rect);
    }

    private final androidx.compose.ui.geometry.Rect toBoundsRelativeToNodeBounds(Rect rect, Rect rect2) {
        float f = rect.left - rect2.left;
        float f2 = rect.top - rect2.top;
        return new androidx.compose.ui.geometry.Rect(f, f2, rect.width() + f, rect.height() + f2);
    }

    private final RectF toScreenCoords(SemanticsNode semanticsNode, androidx.compose.ui.geometry.Rect rect) {
        if (semanticsNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect m5216translatek4lQ0M = rect.m5216translatek4lQ0M(semanticsNode.m7452getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
        androidx.compose.ui.geometry.Rect intersect = m5216translatek4lQ0M.overlaps(boundsInRoot) ? m5216translatek4lQ0M.intersect(boundsInRoot) : null;
        if (intersect != null) {
            AndroidComposeView androidComposeView = this.view;
            float left = intersect.getLeft();
            long mo6824localToScreenMKHz9U = androidComposeView.mo6824localToScreenMKHz9U(Offset.m5171constructorimpl((Float.floatToRawIntBits(intersect.getTop()) & 4294967295L) | (Float.floatToRawIntBits(left) << 32)));
            long mo6824localToScreenMKHz9U2 = this.view.mo6824localToScreenMKHz9U(Offset.m5171constructorimpl((Float.floatToRawIntBits(intersect.getRight()) << 32) | (Float.floatToRawIntBits(intersect.getBottom()) & 4294967295L)));
            int i = (int) (mo6824localToScreenMKHz9U >> 32);
            int i2 = (int) (mo6824localToScreenMKHz9U2 >> 32);
            int i3 = (int) (mo6824localToScreenMKHz9U & 4294967295L);
            int i4 = (int) (mo6824localToScreenMKHz9U2 & 4294967295L);
            return new RectF(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)));
        }
        return null;
    }

    /* renamed from: createOutline-12SF9DM  reason: not valid java name */
    private final Outline m7324createOutline12SF9DM(Shape shape, long j, LayoutDirection layoutDirection) {
        return shape.mo365createOutlinePq9zytI(j, layoutDirection, this.view.getDensity());
    }

    private final Rect toAndroidRect(Outline outline, float f, float f2) {
        if ((outline instanceof Outline.Rectangle) || (outline instanceof Outline.Rounded)) {
            return toAndroidRect(outline.getBounds(), f, f2);
        }
        return null;
    }

    private final float[] toCornerArray(Outline outline) {
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            return new float[]{Float.intBitsToFloat((int) (rounded.getRoundRect().m5229getTopLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5229getTopLeftCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5230getTopRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5230getTopRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5228getBottomRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5228getBottomRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5227getBottomLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5227getBottomLeftCornerRadiuskKHJgLs() & 4294967295L))};
        }
        return null;
    }

    private final Region toRegion(Outline outline, float f, float f2) {
        if (outline instanceof Outline.Generic) {
            Outline.Generic generic = (Outline.Generic) outline;
            Region region = new Region(toAndroidRect$default(this, generic.getBounds().translate(f, f2), 0.0f, 0.0f, 3, null));
            Region region2 = new Region();
            Path path = generic.getPath();
            if (path instanceof AndroidPath) {
                android.graphics.Path internalPath = ((AndroidPath) path).getInternalPath();
                internalPath.offset(f, f2);
                region2.setPath(internalPath, region);
                return region2;
            }
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        return null;
    }

    static /* synthetic */ Rect toAndroidRect$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, androidx.compose.ui.geometry.Rect rect, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return androidComposeViewAccessibilityDelegateCompat.toAndroidRect(rect, f, f2);
    }

    private final Rect toAndroidRect(androidx.compose.ui.geometry.Rect rect, float f, float f2) {
        return new Rect((int) (rect.getLeft() + f), (int) (rect.getTop() + f2), (int) (rect.getRight() + f), (int) (rect.getBottom() + f2));
    }

    public final boolean dispatchHoverEvent$ui(MotionEvent motionEvent) {
        if (isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int hitTestSemanticsAt$ui = hitTestSemanticsAt$ui(motionEvent.getX(), motionEvent.getY());
                boolean dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(motionEvent);
                updateHoveredVirtualView(hitTestSemanticsAt$ui);
                if (hitTestSemanticsAt$ui == Integer.MIN_VALUE) {
                    return dispatchGenericMotionEvent;
                }
                return true;
            } else if (action != 10) {
                return false;
            } else {
                if (this.hoveredVirtualViewId != Integer.MIN_VALUE) {
                    updateHoveredVirtualView(Integer.MIN_VALUE);
                    return true;
                }
                return this.view.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(motionEvent);
            }
        }
        return false;
    }

    public final int hitTestSemanticsAt$ui(float f, float f2) {
        int i;
        Owner.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.m7098hitTestSemantics6fMxITs$ui$default(this.view.getRoot(), Offset.m5171constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)), hitTestResult, 0, false, 12, null);
        int lastIndex = CollectionsKt.getLastIndex(hitTestResult);
        while (true) {
            i = Integer.MIN_VALUE;
            if (-1 >= lastIndex) {
                break;
            }
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(hitTestResult.get(lastIndex));
            if (this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(requireLayoutNode) != null) {
                return Integer.MIN_VALUE;
            }
            if (requireLayoutNode.getNodes$ui().m7156hasH91voCI$ui(NodeKind.m7195constructorimpl(8))) {
                i = semanticsNodeIdToAccessibilityVirtualNodeId(requireLayoutNode.getSemanticsId());
                SemanticsNode SemanticsNode = SemanticsNodeKt.SemanticsNode(requireLayoutNode, false);
                if (SemanticsOwnerKt.isImportantForAccessibility(SemanticsNode) && !SemanticsNode_androidKt.isAccessibilityIgnoredLink(SemanticsNode)) {
                    break;
                }
            }
            lastIndex--;
        }
        return i;
    }

    private final void updateHoveredVirtualView(int i) {
        int i2 = this.hoveredVirtualViewId;
        if (i2 == i) {
            return;
        }
        this.hoveredVirtualViewId = i;
        sendEventForVirtualView$default(this, i, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, i2, 256, null, null, 12, null);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T t, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        }
        if (t == null || t.length() == 0 || t.length() <= i) {
            return t;
        }
        int i2 = i - 1;
        if (Character.isHighSurrogate(t.charAt(i2)) && Character.isLowSurrogate(t.charAt(i))) {
            i = i2;
        }
        T t2 = (T) t.subSequence(0, i);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.measureAndLayout$default(androidComposeViewAccessibilityDelegateCompat.view, false, 1, null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
            } finally {
            }
        } finally {
        }
    }

    public final void onSemanticsChange$ui() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.semanticsChangeChecker);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c2, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r7, r0) == r1) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:13:0x0032, B:22:0x005a, B:26:0x006a, B:28:0x0072, B:30:0x007b, B:32:0x0086, B:33:0x0097, B:35:0x009e, B:36:0x00a7, B:18:0x0047, B:21:0x004e), top: B:44:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c2 -> B:14:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object boundsUpdatesEventLoop$ui(Continuation<? super Unit> continuation) {
        AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1;
        int i;
        MutableIntSet mutableIntSet;
        ChannelIterator<Unit> it;
        MutableIntSet mutableIntSet2;
        Object hasNext;
        try {
            if (continuation instanceof AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) {
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 = (AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) continuation;
                if ((androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label & Integer.MIN_VALUE) != 0) {
                    androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label -= Integer.MIN_VALUE;
                    Object obj = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutableIntSet = new MutableIntSet(0, 1, null);
                        it = this.boundsUpdateChannel.iterator();
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = mutableIntSet;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = it;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 1;
                        hasNext = it.hasNext(androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } else if (i == 1) {
                        it = (ChannelIterator) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1;
                        mutableIntSet2 = (MutableIntSet) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        it = (ChannelIterator) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1;
                        mutableIntSet2 = (MutableIntSet) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableIntSet = mutableIntSet2;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = mutableIntSet;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = it;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 1;
                        hasNext = it.hasNext(androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutableIntSet2 = mutableIntSet;
                        obj = hasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            it.next();
                            if (isEnabled$ui()) {
                                int size = this.subtreeChangedLayoutNodes.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    LayoutNode valueAt = this.subtreeChangedLayoutNodes.valueAt(i2);
                                    sendSubtreeChangeAccessibilityEvents(valueAt, mutableIntSet2);
                                    sendTypeViewScrolledAccessibilityEvent(valueAt);
                                }
                                mutableIntSet2.clear();
                                if (!this.checkingForSemanticsChanges) {
                                    this.checkingForSemanticsChanges = true;
                                    this.handler.post(this.semanticsChangeChecker);
                                }
                            }
                            this.subtreeChangedLayoutNodes.clear();
                            this.pendingHorizontalScrollEvents.clear();
                            this.pendingVerticalScrollEvents.clear();
                            long j = this.SendRecurringAccessibilityEventsIntervalMillis;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = mutableIntSet2;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = it;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 2;
                        } else {
                            this.subtreeChangedLayoutNodes.clear();
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th) {
            this.subtreeChangedLayoutNodes.clear();
            throw th;
        }
        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 = new AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1(this, continuation);
        Object obj2 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label;
    }

    public final void onLayoutChange$ui(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo9174trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int semanticsId = layoutNode.getSemanticsId();
            ScrollAxisRange scrollAxisRange = this.pendingHorizontalScrollEvents.get(semanticsId);
            ScrollAxisRange scrollAxisRange2 = this.pendingVerticalScrollEvents.get(semanticsId);
            if (scrollAxisRange == null && scrollAxisRange2 == null) {
                return;
            }
            AccessibilityEvent createEvent = createEvent(semanticsId, 4096);
            if (scrollAxisRange != null) {
                createEvent.setScrollX((int) scrollAxisRange.getValue().invoke().floatValue());
                createEvent.setMaxScrollX((int) scrollAxisRange.getMaxValue().invoke().floatValue());
            }
            if (scrollAxisRange2 != null) {
                createEvent.setScrollY((int) scrollAxisRange2.getValue().invoke().floatValue());
                createEvent.setMaxScrollY((int) scrollAxisRange2.getMaxValue().invoke().floatValue());
            }
            sendEvent(createEvent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(r8, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet mutableIntSet) {
        SemanticsConfiguration semanticsConfiguration;
        LayoutNode findClosestParentNode;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(layoutNode)) {
            if (!layoutNode.getNodes$ui().m7156hasH91voCI$ui(NodeKind.m7195constructorimpl(8))) {
                layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.getNodes$ui().m7156hasH91voCI$ui(NodeKind.m7195constructorimpl(8)));
                    }
                });
            }
            if (layoutNode == null || (semanticsConfiguration = layoutNode.getSemanticsConfiguration()) == null) {
                return;
            }
            if (!semanticsConfiguration.isMergingSemanticsOfDescendants() && findClosestParentNode != null) {
                layoutNode = findClosestParentNode;
            }
            if (layoutNode != null) {
                int semanticsId = layoutNode.getSemanticsId();
                if (mutableIntSet.add(semanticsId)) {
                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, null, 8, null);
                }
            }
        }
    }

    private final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        long j;
        long j2;
        long j3;
        long j4;
        SemanticsConfiguration unmergedConfig;
        MutableIntSet mutableIntSet = new MutableIntSet(0, 1, null);
        MutableIntSet mutableIntSet2 = this.paneDisplayed;
        int[] iArr = mutableIntSet2.elements;
        long[] jArr = mutableIntSet2.metadata;
        int length = jArr.length - 2;
        long j5 = 128;
        long j6 = 255;
        char c = 7;
        long j7 = -9187201950435737472L;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j8 = jArr[i];
                int[] iArr2 = iArr;
                if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i3 = 0;
                    while (i3 < i2) {
                        if ((j8 & j6) < j5) {
                            j3 = j5;
                            int i4 = iArr2[(i << 3) + i3];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i4);
                            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (semanticsNode != null) {
                                j4 = j6;
                                if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                }
                            } else {
                                j4 = j6;
                            }
                            mutableIntSet.add(i4);
                            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(i4);
                            sendPaneChangeEvents(i4, 32, (semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null) ? null : (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle()));
                        } else {
                            j3 = j5;
                            j4 = j6;
                        }
                        j8 >>= 8;
                        i3++;
                        j5 = j3;
                        j6 = j4;
                    }
                    j = j5;
                    j2 = j6;
                    if (i2 != 8) {
                        break;
                    }
                } else {
                    j = j5;
                    j2 = j6;
                }
                if (i == length) {
                    break;
                }
                i++;
                iArr = iArr2;
                j5 = j;
                j6 = j2;
            }
        } else {
            j = 128;
            j2 = 255;
        }
        this.paneDisplayed.removeAll(mutableIntSet);
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes = getCurrentSemanticsNodes();
        int[] iArr3 = currentSemanticsNodes.keys;
        Object[] objArr = currentSemanticsNodes.values;
        long[] jArr2 = currentSemanticsNodes.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i5 = 0;
            while (true) {
                long j9 = jArr2[i5];
                if ((((~j9) << c) & j9 & j7) != j7) {
                    int i6 = 8 - ((~(i5 - length2)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((j9 & j2) < j) {
                            int i8 = (i5 << 3) + i7;
                            int i9 = iArr3[i8];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) objArr[i8];
                            if (semanticsNodeWithAdjustedBounds2.getSemanticsNode().getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPaneTitle()) && this.paneDisplayed.add(i9)) {
                                sendPaneChangeEvents(i9, 16, (String) semanticsNodeWithAdjustedBounds2.getSemanticsNode().getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getPaneTitle()));
                            }
                            this.previousSemanticsNodes.set(i9, new SemanticsNodeCopy(semanticsNodeWithAdjustedBounds2.getSemanticsNode(), getCurrentSemanticsNodes()));
                        }
                        j9 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length2) {
                    break;
                }
                i5++;
                c = 7;
                j7 = -9187201950435737472L;
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x059c, code lost:
        if (r1.isEmpty() == false) goto L171;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sendSemanticsPropertyChangeEvents(IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap) {
        ArrayList arrayList;
        int[] iArr;
        long[] jArr;
        int i;
        int i2;
        ArrayList arrayList2;
        int[] iArr2;
        long[] jArr2;
        int i3;
        char c;
        int i4;
        int i5;
        SemanticsNode semanticsNode;
        int i6;
        boolean z;
        Object[] objArr;
        int i7;
        int i8;
        int i9;
        ArrayList arrayList3;
        long[] jArr3;
        Object[] objArr2;
        int i10;
        int i11;
        SemanticsNode semanticsNode2;
        int[] iArr3;
        int i12;
        int i13;
        boolean accessibilityEquals;
        String text;
        int i14;
        int i15;
        int i16;
        boolean z2;
        AccessibilityEvent createTextSelectionChangedEvent;
        boolean sendEventForVirtualView$default;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2 = intObjectMap;
        ArrayList arrayList4 = new ArrayList(androidComposeViewAccessibilityDelegateCompat.scrollObservationScopes);
        androidComposeViewAccessibilityDelegateCompat.scrollObservationScopes.clear();
        int[] iArr4 = intObjectMap2.keys;
        long[] jArr4 = intObjectMap2.metadata;
        int i17 = 2;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i18 = 0;
        while (true) {
            long j = jArr4[i18];
            char c2 = 7;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i19 = 8;
                int i20 = 8 - ((~(i18 - length)) >>> 31);
                long j2 = j;
                int i21 = 0;
                while (i21 < i20) {
                    if ((j2 & 255) < 128) {
                        int i22 = iArr4[(i18 << 3) + i21];
                        SemanticsNodeCopy semanticsNodeCopy = androidComposeViewAccessibilityDelegateCompat.previousSemanticsNodes.get(i22);
                        if (semanticsNodeCopy == null) {
                            i2 = i21;
                            arrayList2 = arrayList4;
                            iArr2 = iArr4;
                            jArr2 = jArr4;
                            i3 = i17;
                            c = c2;
                            i4 = i20;
                        } else {
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = intObjectMap2.get(i22);
                            SemanticsNode semanticsNode3 = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (semanticsNode3 != null) {
                                MutableScatterMap<SemanticsPropertyKey<?>, Object> props$ui = semanticsNode3.getUnmergedConfig$ui().getProps$ui();
                                i3 = i17;
                                Object[] objArr3 = props$ui.keys;
                                Object[] objArr4 = props$ui.values;
                                long[] jArr5 = props$ui.metadata;
                                c = c2;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i23 = i19;
                                    SemanticsNode semanticsNode4 = semanticsNode3;
                                    z = false;
                                    int i24 = 0;
                                    while (true) {
                                        long j3 = jArr5[i24];
                                        long[] jArr6 = jArr5;
                                        if ((((~j3) << c) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i25 = 8 - ((~(i24 - length2)) >>> 31);
                                            long j4 = j3;
                                            int i26 = 0;
                                            while (i26 < i25) {
                                                if ((j4 & 255) < 128) {
                                                    int i27 = (i24 << 3) + i26;
                                                    Object obj = objArr3[i27];
                                                    Object obj2 = objArr4[i27];
                                                    boolean z3 = true;
                                                    SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                                                    i8 = i21;
                                                    if (((Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) ? androidComposeViewAccessibilityDelegateCompat.registerScrollingId(i22, arrayList4) : false) || !Intrinsics.areEqual(obj2, SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsPropertyKey))) {
                                                        if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getPaneTitle())) {
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                                                            String str = (String) obj2;
                                                            if (semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                                                androidComposeViewAccessibilityDelegateCompat.sendPaneChangeEvents(i22, i23, str);
                                                            }
                                                            Unit unit = Unit.INSTANCE;
                                                        } else {
                                                            if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getStateDescription()) || Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getToggleableState())) {
                                                                i9 = i26;
                                                                arrayList3 = arrayList4;
                                                                jArr3 = jArr4;
                                                                objArr2 = objArr3;
                                                                i10 = i24;
                                                                i11 = i20;
                                                                semanticsNode2 = semanticsNode4;
                                                                iArr3 = iArr4;
                                                                i12 = i22;
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 2048, 64, null, 8, null);
                                                                Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 2048, 0, null, 8, null));
                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getProgressBarRangeInfo())) {
                                                                i9 = i26;
                                                                arrayList3 = arrayList4;
                                                                jArr3 = jArr4;
                                                                objArr2 = objArr3;
                                                                i11 = i20;
                                                                i10 = i24;
                                                                semanticsNode2 = semanticsNode4;
                                                                iArr3 = iArr4;
                                                                i12 = i22;
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i22), 2048, 64, null, 8, null);
                                                                Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 2048, 0, null, 8, null));
                                                            } else {
                                                                i9 = i26;
                                                                arrayList3 = arrayList4;
                                                                jArr3 = jArr4;
                                                                objArr2 = objArr3;
                                                                i10 = i24;
                                                                i11 = i20;
                                                                semanticsNode2 = semanticsNode4;
                                                                iArr3 = iArr4;
                                                                i12 = i22;
                                                                if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getSelected())) {
                                                                    Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
                                                                    if (role == null ? false : Role.m7438equalsimpl0(role.m7441unboximpl(), Role.Companion.m7449getTabo7Vup1c())) {
                                                                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getSelected()), (Object) true)) {
                                                                            AccessibilityEvent createEvent = androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 4);
                                                                            SemanticsNode copyWithMergingEnabled$ui = semanticsNode2.copyWithMergingEnabled$ui();
                                                                            List list = (List) SemanticsConfigurationKt.getOrNull(copyWithMergingEnabled$ui.getConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                                                                            String fastJoinToString$default = list != null ? ListUtilsKt.fastJoinToString$default(list, StringUtils.COMMA, null, null, 0, null, null, 62, null) : null;
                                                                            List list2 = (List) SemanticsConfigurationKt.getOrNull(copyWithMergingEnabled$ui.getConfig(), SemanticsProperties.INSTANCE.getText());
                                                                            String fastJoinToString$default2 = list2 != null ? ListUtilsKt.fastJoinToString$default(list2, StringUtils.COMMA, null, null, 0, null, null, 62, null) : null;
                                                                            if (fastJoinToString$default != null) {
                                                                                createEvent.setContentDescription(fastJoinToString$default);
                                                                                Unit unit2 = Unit.INSTANCE;
                                                                                Unit unit3 = Unit.INSTANCE;
                                                                            }
                                                                            if (fastJoinToString$default2 != null) {
                                                                                Boolean.valueOf(createEvent.getText().add(fastJoinToString$default2));
                                                                            }
                                                                            sendEventForVirtualView$default = androidComposeViewAccessibilityDelegateCompat.sendEvent(createEvent);
                                                                        } else {
                                                                            sendEventForVirtualView$default = sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 2048, 0, null, 8, null);
                                                                        }
                                                                    } else {
                                                                        sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 2048, 64, null, 8, null);
                                                                        sendEventForVirtualView$default = sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 2048, 0, null, 8, null);
                                                                    }
                                                                    Boolean.valueOf(sendEventForVirtualView$default);
                                                                } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getContentDescription())) {
                                                                    int semanticsNodeIdToAccessibilityVirtualNodeId = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12);
                                                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                                                    Boolean.valueOf(androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) obj2));
                                                                } else {
                                                                    String str2 = "";
                                                                    if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getEditableText())) {
                                                                        if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getSetText())) {
                                                                            AnnotatedString textForTextField = androidComposeViewAccessibilityDelegateCompat.getTextForTextField(semanticsNodeCopy.getUnmergedConfig());
                                                                            String str3 = textForTextField != null ? textForTextField : "";
                                                                            AnnotatedString textForTextField2 = androidComposeViewAccessibilityDelegateCompat.getTextForTextField(semanticsNode2.getUnmergedConfig$ui());
                                                                            String str4 = textForTextField2 != null ? textForTextField2 : "";
                                                                            CharSequence trimToSize = androidComposeViewAccessibilityDelegateCompat.trimToSize(str4, 100000);
                                                                            int length3 = str3.length();
                                                                            int length4 = str4.length();
                                                                            int coerceAtMost = RangesKt.coerceAtMost(length3, length4);
                                                                            int i28 = 0;
                                                                            while (true) {
                                                                                i14 = length3;
                                                                                if (i28 >= coerceAtMost) {
                                                                                    i15 = length4;
                                                                                    break;
                                                                                }
                                                                                i15 = length4;
                                                                                if (str3.charAt(i28) != str4.charAt(i28)) {
                                                                                    break;
                                                                                }
                                                                                i28++;
                                                                                length3 = i14;
                                                                                length4 = i15;
                                                                            }
                                                                            int i29 = 0;
                                                                            while (true) {
                                                                                if (i29 >= coerceAtMost - i28) {
                                                                                    i16 = i29;
                                                                                    break;
                                                                                }
                                                                                i16 = i29;
                                                                                if (str3.charAt((i14 - 1) - i29) != str4.charAt((i15 - 1) - i16)) {
                                                                                    break;
                                                                                }
                                                                                i29 = i16 + 1;
                                                                            }
                                                                            int i30 = (i14 - i16) - i28;
                                                                            int i31 = (i15 - i16) - i28;
                                                                            boolean contains = semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword());
                                                                            boolean contains2 = semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPassword());
                                                                            boolean contains3 = semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
                                                                            boolean z4 = contains3 && !contains && contains2;
                                                                            z3 = (contains3 && contains && !contains2) ? false : false;
                                                                            if (z4 || z3) {
                                                                                z2 = z4;
                                                                                createTextSelectionChangedEvent = androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 0, 0, Integer.valueOf(i15), trimToSize);
                                                                            } else {
                                                                                z2 = z4;
                                                                                createTextSelectionChangedEvent = androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 16);
                                                                                createTextSelectionChangedEvent.setFromIndex(i28);
                                                                                createTextSelectionChangedEvent.setRemovedCount(i30);
                                                                                createTextSelectionChangedEvent.setAddedCount(i31);
                                                                                createTextSelectionChangedEvent.setBeforeText(str3);
                                                                                createTextSelectionChangedEvent.getText().add(trimToSize);
                                                                            }
                                                                            createTextSelectionChangedEvent.setClassName(TextFieldClassName);
                                                                            androidComposeViewAccessibilityDelegateCompat.sendEvent(createTextSelectionChangedEvent);
                                                                            if (z2 || z3) {
                                                                                long m7705unboximpl = ((TextRange) semanticsNode2.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7705unboximpl();
                                                                                createTextSelectionChangedEvent.setFromIndex(TextRange.m7701getStartimpl(m7705unboximpl));
                                                                                createTextSelectionChangedEvent.setToIndex(TextRange.m7696getEndimpl(m7705unboximpl));
                                                                                androidComposeViewAccessibilityDelegateCompat.sendEvent(createTextSelectionChangedEvent);
                                                                            }
                                                                            Unit unit4 = Unit.INSTANCE;
                                                                        } else {
                                                                            Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), 2048, Integer.valueOf(i3), null, 8, null));
                                                                        }
                                                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                                                                        AnnotatedString textForTextField3 = androidComposeViewAccessibilityDelegateCompat.getTextForTextField(semanticsNode2.getUnmergedConfig$ui());
                                                                        if (textForTextField3 != null && (text = textForTextField3.getText()) != null) {
                                                                            str2 = text;
                                                                        }
                                                                        long m7705unboximpl2 = ((TextRange) semanticsNode2.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7705unboximpl();
                                                                        androidComposeViewAccessibilityDelegateCompat.sendEvent(androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i12), Integer.valueOf(TextRange.m7701getStartimpl(m7705unboximpl2)), Integer.valueOf(TextRange.m7696getEndimpl(m7705unboximpl2)), Integer.valueOf(str2.length()), androidComposeViewAccessibilityDelegateCompat.trimToSize(str2, 100000)));
                                                                        androidComposeViewAccessibilityDelegateCompat.sendPendingTextTraversedAtGranularityEvent(semanticsNode2.getId());
                                                                        Unit unit5 = Unit.INSTANCE;
                                                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                                                                        androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode2.getLayoutNode$ui());
                                                                        ScrollObservationScope findById = SemanticsUtils_androidKt.findById(androidComposeViewAccessibilityDelegateCompat.scrollObservationScopes, i12);
                                                                        Intrinsics.checkNotNull(findById);
                                                                        findById.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()));
                                                                        findById.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()));
                                                                        androidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeeded(findById);
                                                                        Unit unit6 = Unit.INSTANCE;
                                                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getFocused())) {
                                                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                                                        if (((Boolean) obj2).booleanValue()) {
                                                                            androidComposeViewAccessibilityDelegateCompat.sendEvent(androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode2.getId()), 8));
                                                                        }
                                                                        Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode2.getId()), 2048, 0, null, 8, null));
                                                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsActions.INSTANCE.getCustomActions())) {
                                                                        List list3 = (List) semanticsNode2.getUnmergedConfig$ui().get(SemanticsActions.INSTANCE.getCustomActions());
                                                                        List list4 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions());
                                                                        if (list4 != null) {
                                                                            LinkedHashSet linkedHashSet = new LinkedHashSet();
                                                                            int size = list3.size();
                                                                            for (int i32 = 0; i32 < size; i32++) {
                                                                                linkedHashSet.add(((CustomAccessibilityAction) list3.get(i32)).getLabel());
                                                                            }
                                                                            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                                                            int size2 = list4.size();
                                                                            for (int i33 = 0; i33 < size2; i33++) {
                                                                                linkedHashSet2.add(((CustomAccessibilityAction) list4.get(i33)).getLabel());
                                                                            }
                                                                            if (linkedHashSet.containsAll(linkedHashSet2) && linkedHashSet2.containsAll(linkedHashSet)) {
                                                                                z = false;
                                                                                Unit unit7 = Unit.INSTANCE;
                                                                            }
                                                                            z = true;
                                                                            Unit unit72 = Unit.INSTANCE;
                                                                        }
                                                                    } else {
                                                                        if (obj2 instanceof AccessibilityAction) {
                                                                            accessibilityEquals = AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) obj2, SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsPropertyKey));
                                                                            if (accessibilityEquals) {
                                                                                z = false;
                                                                                Unit unit8 = Unit.INSTANCE;
                                                                            }
                                                                        }
                                                                        z = true;
                                                                        Unit unit82 = Unit.INSTANCE;
                                                                    }
                                                                }
                                                            }
                                                            i13 = 8;
                                                        }
                                                    }
                                                    i9 = i26;
                                                    arrayList3 = arrayList4;
                                                    jArr3 = jArr4;
                                                    objArr2 = objArr3;
                                                    i10 = i24;
                                                    i11 = i20;
                                                    semanticsNode2 = semanticsNode4;
                                                    iArr3 = iArr4;
                                                    i12 = i22;
                                                    i13 = 8;
                                                } else {
                                                    i8 = i21;
                                                    i9 = i26;
                                                    arrayList3 = arrayList4;
                                                    jArr3 = jArr4;
                                                    objArr2 = objArr3;
                                                    i10 = i24;
                                                    i11 = i20;
                                                    semanticsNode2 = semanticsNode4;
                                                    iArr3 = iArr4;
                                                    i12 = i22;
                                                    i13 = i23;
                                                }
                                                j4 >>= i13;
                                                i26 = i9 + 1;
                                                i20 = i11;
                                                i22 = i12;
                                                i23 = i13;
                                                iArr4 = iArr3;
                                                semanticsNode4 = semanticsNode2;
                                                i21 = i8;
                                                arrayList4 = arrayList3;
                                                objArr3 = objArr2;
                                                i24 = i10;
                                                jArr4 = jArr3;
                                            }
                                            i2 = i21;
                                            arrayList2 = arrayList4;
                                            jArr2 = jArr4;
                                            objArr = objArr3;
                                            i7 = i24;
                                            i4 = i20;
                                            semanticsNode = semanticsNode4;
                                            iArr2 = iArr4;
                                            i6 = i22;
                                            if (i25 != i23) {
                                                break;
                                            }
                                        } else {
                                            i2 = i21;
                                            arrayList2 = arrayList4;
                                            jArr2 = jArr4;
                                            objArr = objArr3;
                                            i7 = i24;
                                            i4 = i20;
                                            semanticsNode = semanticsNode4;
                                            iArr2 = iArr4;
                                            i6 = i22;
                                        }
                                        if (i7 == length2) {
                                            break;
                                        }
                                        int i34 = i7 + 1;
                                        i20 = i4;
                                        i22 = i6;
                                        iArr4 = iArr2;
                                        semanticsNode4 = semanticsNode;
                                        jArr5 = jArr6;
                                        jArr4 = jArr2;
                                        arrayList4 = arrayList2;
                                        objArr3 = objArr;
                                        i23 = 8;
                                        i24 = i34;
                                        i21 = i2;
                                    }
                                } else {
                                    i2 = i21;
                                    semanticsNode = semanticsNode3;
                                    arrayList2 = arrayList4;
                                    iArr2 = iArr4;
                                    jArr2 = jArr4;
                                    i6 = i22;
                                    i4 = i20;
                                    z = false;
                                }
                                if (!z) {
                                    z = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(semanticsNode, semanticsNodeCopy.getUnmergedConfig());
                                }
                                if (z) {
                                    sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i6), 2048, 0, null, 8, null);
                                }
                            } else {
                                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                                throw new KotlinNothingValueException();
                            }
                        }
                        i5 = 8;
                    } else {
                        i2 = i21;
                        arrayList2 = arrayList4;
                        iArr2 = iArr4;
                        jArr2 = jArr4;
                        i3 = i17;
                        c = c2;
                        i4 = i20;
                        i5 = i19;
                    }
                    j2 >>= i5;
                    i21 = i2 + 1;
                    androidComposeViewAccessibilityDelegateCompat = this;
                    intObjectMap2 = intObjectMap;
                    i20 = i4;
                    i19 = i5;
                    i17 = i3;
                    c2 = c;
                    iArr4 = iArr2;
                    jArr4 = jArr2;
                    arrayList4 = arrayList2;
                }
                arrayList = arrayList4;
                iArr = iArr4;
                jArr = jArr4;
                i = i17;
                if (i20 != i19) {
                    return;
                }
            } else {
                arrayList = arrayList4;
                iArr = iArr4;
                jArr = jArr4;
                i = i17;
            }
            if (i18 == length) {
                return;
            }
            i18++;
            androidComposeViewAccessibilityDelegateCompat = this;
            intObjectMap2 = intObjectMap;
            i17 = i;
            iArr4 = iArr;
            jArr4 = jArr;
            arrayList4 = arrayList;
        }
    }

    private final boolean registerScrollingId(int i, List<ScrollObservationScope> list) {
        boolean z;
        ScrollObservationScope findById = SemanticsUtils_androidKt.findById(list, i);
        if (findById != null) {
            z = false;
        } else {
            ScrollObservationScope scrollObservationScope = new ScrollObservationScope(i, this.scrollObservationScopes, null, null, null, null);
            z = true;
            findById = scrollObservationScope;
        }
        this.scrollObservationScopes.add(findById);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            this.view.getSnapshotObserver().observer.observeReads(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    int semanticsNodeIdToAccessibilityVirtualNodeId;
                    IntObjectMap currentSemanticsNodes;
                    IntObjectMap currentSemanticsNodes2;
                    IntObjectMap currentSemanticsNodes3;
                    SemanticsNode semanticsNode;
                    LayoutNode layoutNode$ui;
                    MutableIntObjectMap mutableIntObjectMap;
                    MutableIntObjectMap mutableIntObjectMap2;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
                    Rect boundsInScreen;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
                    Rect boundsInScreen2;
                    ScrollAxisRange horizontalScrollAxisRange = ScrollObservationScope.this.getHorizontalScrollAxisRange();
                    ScrollAxisRange verticalScrollAxisRange = ScrollObservationScope.this.getVerticalScrollAxisRange();
                    Float oldXValue = ScrollObservationScope.this.getOldXValue();
                    Float oldYValue = ScrollObservationScope.this.getOldYValue();
                    float floatValue = (horizontalScrollAxisRange == null || oldXValue == null) ? 0.0f : horizontalScrollAxisRange.getValue().invoke().floatValue() - oldXValue.floatValue();
                    float floatValue2 = (verticalScrollAxisRange == null || oldYValue == null) ? 0.0f : verticalScrollAxisRange.getValue().invoke().floatValue() - oldYValue.floatValue();
                    if (floatValue != 0.0f || floatValue2 != 0.0f) {
                        semanticsNodeIdToAccessibilityVirtualNodeId = this.semanticsNodeIdToAccessibilityVirtualNodeId(ScrollObservationScope.this.getSemanticsNodeId());
                        currentSemanticsNodes = this.getCurrentSemanticsNodes();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) currentSemanticsNodes.get(this.accessibilityFocusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
                            try {
                                accessibilityNodeInfoCompat2 = androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI;
                                if (accessibilityNodeInfoCompat2 != null) {
                                    boundsInScreen2 = androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds);
                                    accessibilityNodeInfoCompat2.setBoundsInScreen(boundsInScreen2);
                                    Unit unit = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused) {
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                        currentSemanticsNodes2 = this.getCurrentSemanticsNodes();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) currentSemanticsNodes2.get(this.focusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds2 != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this;
                            try {
                                accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat2.currentlyFocusedANI;
                                if (accessibilityNodeInfoCompat != null) {
                                    boundsInScreen = androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(semanticsNodeWithAdjustedBounds2);
                                    accessibilityNodeInfoCompat.setBoundsInScreen(boundsInScreen);
                                    Unit unit3 = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused2) {
                                Unit unit4 = Unit.INSTANCE;
                            }
                        }
                        this.getView().invalidate();
                        currentSemanticsNodes3 = this.getCurrentSemanticsNodes();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds3 = (SemanticsNodeWithAdjustedBounds) currentSemanticsNodes3.get(semanticsNodeIdToAccessibilityVirtualNodeId);
                        if (semanticsNodeWithAdjustedBounds3 != null && (semanticsNode = semanticsNodeWithAdjustedBounds3.getSemanticsNode()) != null && (layoutNode$ui = semanticsNode.getLayoutNode$ui()) != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat3 = this;
                            if (horizontalScrollAxisRange != null) {
                                mutableIntObjectMap2 = androidComposeViewAccessibilityDelegateCompat3.pendingHorizontalScrollEvents;
                                mutableIntObjectMap2.set(semanticsNodeIdToAccessibilityVirtualNodeId, horizontalScrollAxisRange);
                            }
                            if (verticalScrollAxisRange != null) {
                                mutableIntObjectMap = androidComposeViewAccessibilityDelegateCompat3.pendingVerticalScrollEvents;
                                mutableIntObjectMap.set(semanticsNodeIdToAccessibilityVirtualNodeId, verticalScrollAxisRange);
                            }
                            androidComposeViewAccessibilityDelegateCompat3.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode$ui);
                        }
                    }
                    if (horizontalScrollAxisRange != null) {
                        ScrollObservationScope.this.setOldXValue(horizontalScrollAxisRange.getValue().invoke());
                    }
                    if (verticalScrollAxisRange != null) {
                        ScrollObservationScope.this.setOldYValue(verticalScrollAxisRange.getValue().invoke());
                    }
                }
            });
        }
    }

    private final void sendPaneChangeEvents(int i, int i2, String str) {
        AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i), 32);
        createEvent.setContentChangeTypes(i2);
        if (str != null) {
            createEvent.getText().add(str);
        }
        sendEvent(createEvent);
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        MutableIntSet mutableIntSetOf = IntSetKt.mutableIntSetOf();
        List<SemanticsNode> replacedChildren$ui = semanticsNode.getReplacedChildren$ui();
        int size = replacedChildren$ui.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui.get(i);
            if (getCurrentSemanticsNodes().containsKey(semanticsNode2.getId())) {
                if (!semanticsNodeCopy.getChildren().contains(semanticsNode2.getId())) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui());
                    return;
                }
                mutableIntSetOf.add(semanticsNode2.getId());
            }
        }
        MutableIntSet children = semanticsNodeCopy.getChildren();
        int[] iArr = children.elements;
        long[] jArr = children.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128 && !mutableIntSetOf.contains(iArr[(i2 << 3) + i4])) {
                            notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui());
                            return;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        List<SemanticsNode> replacedChildren$ui2 = semanticsNode.getReplacedChildren$ui();
        int size2 = replacedChildren$ui2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui2.get(i5);
            SemanticsNodeCopy semanticsNodeCopy2 = this.previousSemanticsNodes.get(semanticsNode3.getId());
            if (semanticsNodeCopy2 != null && getCurrentSemanticsNodes().containsKey(semanticsNode3.getId())) {
                sendAccessibilitySemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i) {
        if (i == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return i;
    }

    private final boolean traverseAtGranularity(SemanticsNode semanticsNode, int i, boolean z, boolean z2) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int i2;
        int i3;
        int id = semanticsNode.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(semanticsNode.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        String str = iterableTextForAccessibility;
        if (str == null || str.length() == 0 || (iteratorForGranularity = getIteratorForGranularity(semanticsNode, i)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(semanticsNode);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = z ? 0 : iterableTextForAccessibility.length();
        }
        int[] following = z ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (following == null) {
            return false;
        }
        int i4 = following[0];
        int i5 = following[1];
        if (z2 && isAccessibilitySelectionExtendable(semanticsNode)) {
            i2 = getAccessibilitySelectionStart(semanticsNode);
            if (i2 == -1) {
                i2 = z ? i4 : i5;
            }
            i3 = z ? i5 : i4;
        } else {
            i2 = z ? i5 : i4;
            i3 = i2;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, z ? 256 : 512, i, i4, i5, SystemClock.uptimeMillis());
        setAccessibilitySelection(semanticsNode, i2, i3, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int i) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            if (i != pendingTextTraversedEvent.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.getTraverseTime() <= 1000) {
                AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent.getNode().getId()), 131072);
                createEvent.setFromIndex(pendingTextTraversedEvent.getFromIndex());
                createEvent.setToIndex(pendingTextTraversedEvent.getToIndex());
                createEvent.setAction(pendingTextTraversedEvent.getAction());
                createEvent.setMovementGranularity(pendingTextTraversedEvent.getGranularity());
                createEvent.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent.getNode()));
                sendEvent(createEvent);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i, int i2, boolean z) {
        String iterableTextForAccessibility;
        boolean enabled;
        if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getSetSelection())) {
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled) {
                Function3 function3 = (Function3) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
                if (function3 != null) {
                    return ((Boolean) function3.invoke(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
                }
                return false;
            }
        }
        if ((i == i2 && i2 == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) == null) {
            return false;
        }
        this.accessibilityCursorPosition = (i < 0 || i != i2 || i2 > iterableTextForAccessibility.length()) ? -1 : -1;
        String str = iterableTextForAccessibility;
        boolean z2 = str.length() > 0;
        sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z2 ? Integer.valueOf(iterableTextForAccessibility.length()) : null, str));
        sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
        return true;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        if (!semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getContentDescription()) && semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m7701getStartimpl(((TextRange) semanticsNode.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7705unboximpl());
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        if (!semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getContentDescription()) && semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m7696getEndimpl(((TextRange) semanticsNode.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7705unboximpl());
        }
        return this.accessibilityCursorPosition;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode semanticsNode) {
        return !semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getContentDescription()) && semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode semanticsNode, int i) {
        AccessibilityIterators.AbstractTextSegmentIterator companion;
        TextLayoutResult textLayoutResult;
        if (semanticsNode == null) {
            return null;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        String str = iterableTextForAccessibility;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (i == 1) {
            companion = AccessibilityIterators.CharacterTextSegmentIterator.Companion.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            ((AccessibilityIterators.CharacterTextSegmentIterator) companion).initialize(iterableTextForAccessibility);
        } else if (i == 2) {
            companion = AccessibilityIterators.WordTextSegmentIterator.Companion.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            ((AccessibilityIterators.WordTextSegmentIterator) companion).initialize(iterableTextForAccessibility);
        } else {
            if (i != 4) {
                if (i == 8) {
                    companion = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                    companion.initialize(iterableTextForAccessibility);
                } else if (i != 16) {
                    return null;
                }
            }
            if (!semanticsNode.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) || (textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig$ui())) == null) {
                return null;
            }
            if (i == 4) {
                companion = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
                ((AccessibilityIterators.LineTextSegmentIterator) companion).initialize(iterableTextForAccessibility, textLayoutResult);
            } else {
                AccessibilityIterators.AbstractTextSegmentIterator companion2 = AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance();
                ((AccessibilityIterators.PageTextSegmentIterator) companion2).initialize(iterableTextForAccessibility, textLayoutResult, semanticsNode);
                companion = companion2;
            }
        }
        return companion;
    }

    private final String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) semanticsNode.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getContentDescription()), StringUtils.COMMA, null, null, 0, null, null, 62, null);
        }
        if (semanticsNode.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull((List<? extends Object>) list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "createAccessibilityNodeInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "virtualViewId", "", "performAction", "", "action", "arguments", "Landroid/os/Bundle;", "addExtraDataToAccessibilityNodeInfo", "", "info", "extraDataKey", "", "findFocus", "focus", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfoCompat createNodeInfo = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(i);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent) {
                if (i == androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI = createNodeInfo;
                }
                if (i == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = createNodeInfo;
                }
            }
            return createNodeInfo;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i, int i2, Bundle bundle) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(i, i2, bundle);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfoCompat, str, bundle);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i) {
            if (i != 1) {
                if (i == 2) {
                    return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityFocusedVirtualViewId);
                }
                throw new IllegalArgumentException("Unknown focus type: " + i);
            } else if (AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId == Integer.MIN_VALUE) {
                return null;
            } else {
                return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "<init>", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            boolean enabled;
            AccessibilityAction accessibilityAction;
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (!enabled || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetProgress())) == null) {
                return;
            }
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908349, accessibilityAction.getLabel()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "<init>", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            boolean enabled;
            Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled) {
                if (role == null ? false : Role.m7438equalsimpl0(role.m7441unboximpl(), Role.Companion.m7443getCarouselo7Vup1c())) {
                    return;
                }
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageUp());
                if (accessibilityAction != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, accessibilityAction.getLabel()));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageDown());
                if (accessibilityAction2 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, accessibilityAction2.getLabel()));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageLeft());
                if (accessibilityAction3 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908360, accessibilityAction3.getLabel()));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageRight());
                if (accessibilityAction4 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908361, accessibilityAction4.getLabel()));
                }
            }
        }
    }
}
