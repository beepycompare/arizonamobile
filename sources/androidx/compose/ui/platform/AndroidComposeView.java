package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.retain.ForgetfulRetainedValuesStore;
import androidx.compose.runtime.retain.RetainedValuesStore;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.AndroidComposeUiFlags;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.autofill.PlatformAutofillManagerImpl;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusOwnerImplKt;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.focus.PlatformFocusOwner;
import androidx.compose.ui.focus.TwoDimensionalFocusSearchKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeChangeRequester;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.InsetsListener;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RectRulers;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.WindowInsetsRulerProvider;
import androidx.compose.ui.layout.WindowInsetsRulers_androidKt;
import androidx.compose.ui.layout.WindowWindowInsetsAnimationValues;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.LifecycleRetainedValuesStoreOwner;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.spatial.ExecuteDelayed;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.arizona.launcher.UpdateServiceContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000¬\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!*\u0002ó\u0002\b\u0001\u0018\u0000 ¢\u00052\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f:\u0006¢\u0005£\u0005¤\u0005B\u0017\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010T\u001a\u00020UH\u0016J\u0017\u0010p\u001a\u00020\"2\u0006\u0010q\u001a\u00020rH\u0002¢\u0006\u0004\bs\u0010tJ\u0017\u0010u\u001a\u00020\"2\u0006\u0010q\u001a\u00020rH\u0002¢\u0006\u0004\bv\u0010tJ\u0017\u0010w\u001a\u00020\"2\u0006\u0010q\u001a\u00020rH\u0002¢\u0006\u0004\bx\u0010tJ\u0017\u0010y\u001a\u00020\"2\u0006\u0010q\u001a\u00020rH\u0016¢\u0006\u0004\bz\u0010tJ\u0019\u0010{\u001a\u0004\u0018\u0001002\u0006\u0010q\u001a\u00020rH\u0002¢\u0006\u0004\b|\u0010}J\n\u0010~\u001a\u0004\u0018\u00010\u007fH\u0016J\t\u0010\u0080\u0001\u001a\u00020BH\u0016J\u0014\u0010\u0081\u0001\u001a\u0004\u0018\u0001002\u0007\u0010\u0082\u0001\u001a\u00020UH\u0002JA\u0010¸\u0002\u001a\u00030¹\u00022.\u0010º\u0002\u001a)\b\u0001\u0012\u0005\u0012\u00030¼\u0002\u0012\f\u0012\n\u0012\u0005\u0012\u00030¹\u00020½\u0002\u0012\u0007\u0012\u0005\u0018\u00010¾\u00020»\u0002¢\u0006\u0003\b¿\u0002H\u0096@¢\u0006\u0003\u0010À\u0002J\u0007\u0010\u0080\u0003\u001a\u00020BJ\u0013\u0010\u0081\u0003\u001a\u00020B2\b\u0010\u0082\u0003\u001a\u00030\u0083\u0003H\u0016J>\u0010\u0084\u0003\u001a\u00020B2!\u0010\u0085\u0003\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010\u0086\u0003j\r\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u0001`\u0087\u00032\u0007\u0010\u0082\u0001\u001a\u00020U2\u0007\u0010\u0088\u0003\u001a\u00020UH\u0016J\u0013\u0010\u0089\u0003\u001a\u00020B2\b\u0010\u008a\u0003\u001a\u00030\u008b\u0003H\u0016J.\u0010\u0090\u0003\u001a\u00020B2\b\u0010\u0091\u0003\u001a\u00030\u0083\u00032\b\u0010\u0092\u0003\u001a\u00030\u0093\u00032\u000f\u0010\u0094\u0003\u001a\n\u0012\u0005\u0012\u00030\u0096\u00030\u0095\u0003H\u0016J\u0013\u0010\u0097\u0003\u001a\u00020B2\b\u0010\u0098\u0003\u001a\u00030\u0099\u0003H\u0016J\u0013\u0010\u009a\u0003\u001a\u00020B2\b\u0010\u0098\u0003\u001a\u00030\u0099\u0003H\u0016J\u001f\u0010\u009b\u0003\u001a\u0004\u0018\u0001002\t\u0010\u009c\u0003\u001a\u0004\u0018\u0001002\u0007\u0010\u0082\u0001\u001a\u00020UH\u0016J\u001c\u0010\u009d\u0003\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020U2\n\u0010\u009e\u0003\u001a\u0005\u0018\u00010\u0083\u0003J\u001c\u0010\u009f\u0003\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020U2\n\u0010\u009e\u0003\u001a\u0005\u0018\u00010\u0083\u0003J\u001c\u0010 \u0003\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020U2\n\u0010\u009e\u0003\u001a\u0005\u0018\u00010\u0083\u0003J\u001e\u0010¡\u0003\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020U2\n\u0010\u009e\u0003\u001a\u0005\u0018\u00010\u0083\u0003H\u0016J$\u0010¢\u0003\u001a\u00020\"2\b\u0010q\u001a\u0004\u0018\u00010r2\t\u0010\u009e\u0003\u001a\u0004\u0018\u00010\u007fH\u0016¢\u0006\u0003\b£\u0003J\t\u0010¤\u0003\u001a\u00020BH\u0016J'\u0010¥\u0003\u001a\u00020B2\u0007\u0010¦\u0003\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020U2\n\u0010\u009e\u0003\u001a\u0005\u0018\u00010\u0083\u0003H\u0014J!\u0010¥\u0003\u001a\u00020B2\n\u0010§\u0003\u001a\u0005\u0018\u00010¨\u00032\n\u0010©\u0003\u001a\u0005\u0018\u00010¨\u0003H\u0016J\u0012\u0010ª\u0003\u001a\u00020B2\u0007\u0010«\u0003\u001a\u00020\"H\u0016J\u001c\u0010¬\u0003\u001a\u00020\"2\b\u0010\u00ad\u0003\u001a\u00030®\u0003H\u0016¢\u0006\u0006\b¯\u0003\u0010°\u0003J\u0013\u0010±\u0003\u001a\u00020\"2\b\u0010²\u0003\u001a\u00030³\u0003H\u0017J\u0013\u0010´\u0003\u001a\u00020\"2\b\u0010µ\u0003\u001a\u00030¶\u0003H\u0016J\u0013\u0010·\u0003\u001a\u00020\"2\b\u0010µ\u0003\u001a\u00030¶\u0003H\u0016J\u0012\u0010¸\u0003\u001a\u00020B2\u0007\u0010¹\u0003\u001a\u00020\"H\u0016J\u0013\u0010º\u0003\u001a\u00020B2\b\u0010»\u0003\u001a\u00030þ\u0001H\u0016J\u0013\u0010¼\u0003\u001a\u00020B2\b\u0010½\u0003\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010¾\u0003\u001a\u00020B2\b\u0010½\u0003\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010¿\u0003\u001a\u00020B2\b\u0010½\u0003\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010À\u0003\u001a\u00020B2\b\u0010½\u0003\u001a\u00030\u008e\u0001H\u0016J\u0007\u0010Á\u0003\u001a\u00020BJ\t\u0010Â\u0003\u001a\u00020BH\u0016J\u0018\u0010Ã\u0003\u001a\u00020B2\r\u0010Ä\u0003\u001a\b\u0012\u0004\u0012\u00020B0AH\u0016JC\u0010Å\u0003\u001a\u00020\"2\b\u0010Æ\u0003\u001a\u00030Ç\u00032\b\u0010È\u0003\u001a\u00030É\u00032\u001b\u0010Ê\u0003\u001a\u0016\u0012\u0005\u0012\u00030Ë\u0003\u0012\u0004\u0012\u00020B0\u009f\u0002¢\u0006\u0003\b¿\u0002H\u0002¢\u0006\u0006\bÌ\u0003\u0010Í\u0003J\u0012\u0010Î\u0003\u001a\u00020B2\u0007\u0010Ï\u0003\u001a\u00020\u0001H\u0002J&\u0010Ð\u0003\u001a\u00020B2\u0007\u0010Ñ\u0003\u001a\u00020U2\b\u0010Ò\u0003\u001a\u00030Ó\u00032\b\u0010Ô\u0003\u001a\u00030Õ\u0003H\u0002J\u0014\u0010Ö\u0003\u001a\u00020B2\t\u0010×\u0003\u001a\u0004\u0018\u000100H\u0016J\u001d\u0010Ö\u0003\u001a\u00020B2\t\u0010×\u0003\u001a\u0004\u0018\u0001002\u0007\u0010Ø\u0003\u001a\u00020UH\u0016J&\u0010Ö\u0003\u001a\u00020B2\t\u0010×\u0003\u001a\u0004\u0018\u0001002\u0007\u0010Ù\u0003\u001a\u00020U2\u0007\u0010Ú\u0003\u001a\u00020UH\u0016J \u0010Ö\u0003\u001a\u00020B2\t\u0010×\u0003\u001a\u0004\u0018\u0001002\n\u0010Û\u0003\u001a\u0005\u0018\u00010Ü\u0003H\u0016J)\u0010Ö\u0003\u001a\u00020B2\t\u0010×\u0003\u001a\u0004\u0018\u0001002\u0007\u0010Ø\u0003\u001a\u00020U2\n\u0010Û\u0003\u001a\u0005\u0018\u00010Ü\u0003H\u0016J\u001a\u0010Ý\u0003\u001a\u00020B2\u0007\u0010/\u001a\u00030Þ\u00032\b\u0010ß\u0003\u001a\u00030\u008e\u0001J\u0010\u0010à\u0003\u001a\u00020B2\u0007\u0010/\u001a\u00030Þ\u0003J\u001a\u0010á\u0003\u001a\u00020B2\u0007\u0010/\u001a\u00030Þ\u00032\b\u0010â\u0003\u001a\u00030ã\u0003J\u0017\u0010ä\u0003\u001a\u00020B2\f\b\u0002\u0010å\u0003\u001a\u0005\u0018\u00010\u008e\u0001H\u0002J\u000e\u0010æ\u0003\u001a\u00020\"*\u00030\u008e\u0001H\u0002J\u0012\u0010ç\u0003\u001a\u00020B2\u0007\u0010è\u0003\u001a\u00020\"H\u0016J&\u0010ç\u0003\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u00012\b\u0010é\u0003\u001a\u00030ù\u0001H\u0016¢\u0006\u0006\bê\u0003\u0010ë\u0003J\t\u0010ì\u0003\u001a\u00020BH\u0002J\u001c\u0010í\u0003\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u00012\u0007\u0010î\u0003\u001a\u00020\"H\u0016J.\u0010ï\u0003\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u00012\u0007\u0010î\u0003\u001a\u00020\"2\u0007\u0010ð\u0003\u001a\u00020\"2\u0007\u0010ä\u0003\u001a\u00020\"H\u0016J%\u0010ñ\u0003\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u00012\u0007\u0010î\u0003\u001a\u00020\"2\u0007\u0010ð\u0003\u001a\u00020\"H\u0016J\u0013\u0010ò\u0003\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u0001H\u0016J\t\u0010ó\u0003\u001a\u00020BH\u0016J\u0015\u0010ô\u0003\u001a\u00020B2\n\u0010õ\u0003\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\u001b\u0010ö\u0003\u001a\u00020B2\u0007\u0010÷\u0003\u001a\u00020U2\u0007\u0010ø\u0003\u001a\u00020UH\u0014J\u0018\u0010ù\u0003\u001a\u00020U*\u00030ú\u0003H\u0082\n¢\u0006\u0006\bû\u0003\u0010ü\u0003J\u0018\u0010ý\u0003\u001a\u00020U*\u00030ú\u0003H\u0082\n¢\u0006\u0006\bþ\u0003\u0010ü\u0003J%\u0010ÿ\u0003\u001a\u00030ú\u00032\u0007\u0010\u0080\u0004\u001a\u00020U2\u0007\u0010\u0081\u0004\u001a\u00020UH\u0002¢\u0006\u0006\b\u0082\u0004\u0010\u0083\u0004J\u001c\u0010\u0084\u0004\u001a\u00030ú\u00032\u0007\u0010\u0085\u0004\u001a\u00020UH\u0002¢\u0006\u0006\b\u0086\u0004\u0010\u0087\u0004J6\u0010\u0088\u0004\u001a\u00020B2\u0007\u0010\u0089\u0004\u001a\u00020\"2\u0007\u0010\u008a\u0004\u001a\u00020U2\u0007\u0010\u008b\u0004\u001a\u00020U2\u0007\u0010\u008c\u0004\u001a\u00020U2\u0007\u0010\u0081\u0004\u001a\u00020UH\u0014J\t\u0010\u008e\u0004\u001a\u00020BH\u0002J\u0013\u0010\u008f\u0004\u001a\u00020B2\b\u0010â\u0003\u001a\u00030ã\u0003H\u0014Ji\u0010\u0090\u0004\u001a\u00030¾\u00012B\u0010\u0091\u0004\u001a=\u0012\u0017\u0012\u00150\u0092\u0004¢\u0006\u000f\b\u0093\u0004\u0012\n\b\u0094\u0004\u0012\u0005\b\b(â\u0003\u0012\u0019\u0012\u0017\u0018\u00010\u0095\u0004¢\u0006\u000f\b\u0093\u0004\u0012\n\b\u0094\u0004\u0012\u0005\b\b(\u0096\u0004\u0012\u0004\u0012\u00020B0»\u00022\r\u0010\u0097\u0004\u001a\b\u0012\u0004\u0012\u00020B0A2\n\u0010\u0098\u0004\u001a\u0005\u0018\u00010\u0095\u0004H\u0016J\u0019\u0010\u0099\u0004\u001a\u00020\"2\b\u0010\u009a\u0004\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\b\u009b\u0004J\t\u0010\u009c\u0004\u001a\u00020BH\u0016J\u0013\u0010\u009d\u0004\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010\u009e\u0004\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u0001H\u0016J\u001c\u0010\u009f\u0004\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u00012\u0007\u0010 \u0004\u001a\u00020UH\u0016J\u001c\u0010¡\u0004\u001a\u00020B2\b\u0010ß\u0003\u001a\u00030\u008e\u00012\u0007\u0010 \u0004\u001a\u00020UH\u0016J\u0016\u0010¢\u0004\u001a\u00020B2\u000b\u0010/\u001a\u000700j\u0003`£\u0004H\u0016J\u0013\u0010¤\u0004\u001a\u00020B2\b\u0010Ä\u0003\u001a\u00030¥\u0004H\u0016J\u0013\u0010¦\u0004\u001a\u00020B2\b\u0010â\u0003\u001a\u00030ã\u0003H\u0014J\"\u0010§\u0004\u001a\u00020B2\b\u0010\u009a\u0004\u001a\u00030¾\u00012\u0007\u0010¨\u0004\u001a\u00020\"H\u0000¢\u0006\u0003\b©\u0004J\u001d\u0010ª\u0004\u001a\u00020B2\u0014\u0010«\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020B0\u009f\u0002J\u0010\u0010¬\u0004\u001a\u00020BH\u0086@¢\u0006\u0003\u0010\u00ad\u0004J\u0010\u0010®\u0004\u001a\u00020BH\u0086@¢\u0006\u0003\u0010\u00ad\u0004J\u0013\u0010¯\u0004\u001a\u00020B2\b\u0010½\u0003\u001a\u00030\u008e\u0001H\u0002J\u0013\u0010°\u0004\u001a\u00020B2\b\u0010½\u0003\u001a\u00030\u008e\u0001H\u0002J\t\u0010±\u0004\u001a\u00020BH\u0016J\t\u0010²\u0004\u001a\u00020BH\u0016J\t\u0010³\u0004\u001a\u00020BH\u0014J#\u0010´\u0004\u001a\u0004\u0018\u00010;2\n\u0010µ\u0004\u001a\u0005\u0018\u00010\u0099\u00032\n\u0010¶\u0004\u001a\u0005\u0018\u00010·\u0004H\u0002J\t\u0010¸\u0004\u001a\u00020BH\u0014J\u001e\u0010¹\u0004\u001a\u00020B2\n\u0010\u008a\u0003\u001a\u0005\u0018\u00010\u008b\u00032\u0007\u0010º\u0004\u001a\u00020UH\u0016J\u001a\u0010Ø\u0001\u001a\u00020B2\u000f\u0010»\u0004\u001a\n\u0012\u0005\u0012\u00030½\u00040¼\u0004H\u0016J0\u0010¾\u0004\u001a\u00020B2\b\u0010¿\u0004\u001a\u00030À\u00042\b\u0010Á\u0004\u001a\u00030\u0086\u00022\u0011\u0010Â\u0004\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ã\u00040\u0095\u0003H\u0017J\u001c\u0010Ä\u0004\u001a\u00020B2\u0011\u0010Å\u0004\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ç\u00040Æ\u0004H\u0017J\u0013\u0010È\u0004\u001a\u00020\"2\b\u0010É\u0004\u001a\u00030ê\u0002H\u0016J\u0013\u0010Ê\u0004\u001a\u00020\"2\b\u0010²\u0003\u001a\u00030³\u0003H\u0002J\u0013\u0010Ë\u0004\u001a\u00020\"2\b\u0010É\u0004\u001a\u00030ê\u0002H\u0016J\u0013\u0010Ì\u0004\u001a\u00020\"2\b\u0010µ\u0003\u001a\u00030ê\u0002H\u0002J\u001d\u0010Í\u0004\u001a\u00030Î\u00042\b\u0010É\u0004\u001a\u00030ê\u0002H\u0002¢\u0006\u0006\bÏ\u0004\u0010Ð\u0004J\u001d\u0010Ñ\u0004\u001a\u00020\"2\b\u0010µ\u0003\u001a\u00030ê\u00022\b\u0010Ò\u0004\u001a\u00030ê\u0002H\u0002J\u0013\u0010Ó\u0004\u001a\u00020\"2\b\u0010µ\u0003\u001a\u00030ê\u0002H\u0002J\u001d\u0010Ô\u0004\u001a\u00030Î\u00042\b\u0010É\u0004\u001a\u00030ê\u0002H\u0002¢\u0006\u0006\bÕ\u0004\u0010Ð\u0004J1\u0010Ö\u0004\u001a\u00020B2\b\u0010É\u0004\u001a\u00030ê\u00022\u0007\u0010×\u0004\u001a\u00020U2\b\u0010Ø\u0004\u001a\u00030þ\u00012\t\b\u0002\u0010Ù\u0004\u001a\u00020\"H\u0002J\u0012\u0010Ú\u0004\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020UH\u0016J\u0012\u0010Û\u0004\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020UH\u0016J\u0013\u0010Ü\u0004\u001a\u00020\"2\b\u0010É\u0004\u001a\u00030ê\u0002H\u0002J\u001b\u0010Ý\u0004\u001a\u00020\u001f2\u0007\u0010Þ\u0004\u001a\u00020\u001fH\u0016¢\u0006\u0006\bß\u0004\u0010à\u0004J\u001c\u0010Ý\u0004\u001a\u00020B2\b\u0010á\u0004\u001a\u00030\u0088\u0002H\u0016¢\u0006\u0006\bâ\u0004\u0010ã\u0004J\u001b\u0010ä\u0004\u001a\u00020\u001f2\u0007\u0010å\u0004\u001a\u00020\u001fH\u0016¢\u0006\u0006\bæ\u0004\u0010à\u0004J\t\u0010ç\u0004\u001a\u00020BH\u0002J\u0013\u0010ç\u0004\u001a\u00020B2\b\u0010É\u0004\u001a\u00030ê\u0002H\u0002J\t\u0010è\u0004\u001a\u00020BH\u0002J\t\u0010é\u0004\u001a\u00020BH\u0002J\t\u0010ê\u0004\u001a\u00020\"H\u0016J\u0016\u0010ë\u0004\u001a\u0005\u0018\u00010ì\u00042\b\u0010í\u0004\u001a\u00030î\u0004H\u0016J\u001b\u0010ï\u0004\u001a\u00020\u001f2\u0007\u0010ð\u0004\u001a\u00020\u001fH\u0016¢\u0006\u0006\bñ\u0004\u0010à\u0004J\u001b\u0010ò\u0004\u001a\u00020\u001f2\u0007\u0010Þ\u0004\u001a\u00020\u001fH\u0016¢\u0006\u0006\bó\u0004\u0010à\u0004J\u0013\u0010ô\u0004\u001a\u00020B2\b\u0010õ\u0004\u001a\u00030Æ\u0001H\u0014J\t\u0010ö\u0004\u001a\u00020BH\u0002J\u0013\u0010÷\u0004\u001a\u00020B2\b\u0010õ\u0004\u001a\u00030Æ\u0001H\u0002J\u0012\u0010ø\u0004\u001a\u00020B2\u0007\u0010Ñ\u0002\u001a\u00020UH\u0016J\t\u0010ù\u0004\u001a\u00020\"H\u0002J\u0013\u0010ú\u0004\u001a\u00020\"2\b\u0010µ\u0003\u001a\u00030ê\u0002H\u0016J\u0013\u0010û\u0004\u001a\u00020\"2\b\u0010µ\u0003\u001a\u00030ê\u0002H\u0002J\u0013\u0010ü\u0004\u001a\u00020\"2\b\u0010µ\u0003\u001a\u00030ê\u0002H\u0002J\u001d\u0010ý\u0004\u001a\u0004\u0018\u0001002\u0007\u0010þ\u0004\u001a\u00020U2\u0007\u0010ÿ\u0004\u001a\u000200H\u0002J\u001d\u0010\u0080\u0005\u001a\u00030\u0081\u00052\b\u0010µ\u0003\u001a\u00030ê\u00022\u0007\u0010\u0082\u0005\u001a\u00020UH\u0017J\u0012\u0010\u0087\u0005\u001a\u0004\u0018\u0001002\u0007\u0010þ\u0004\u001a\u00020UJ\t\u0010\u0089\u0005\u001a\u00020\"H\u0016J\t\u0010\u008b\u0005\u001a\u00020BH\u0016J\t\u0010\u008c\u0005\u001a\u00020BH\u0016J\t\u0010\u008e\u0005\u001a\u00020BH\u0016J\t\u0010\u008f\u0005\u001a\u00020BH\u0016J\u0018\u0010\u0093\u0005\u001a\u00020B2\r\u0010\u0094\u0005\u001a\b\u0012\u0004\u0012\u00020B0AH\u0016J\u0013\u0010\u0095\u0005\u001a\u00020B2\b\u0010\u0096\u0005\u001a\u00030ð\u0002H\u0017J\u001b\u0010\u0097\u0005\u001a\u00020B2\u0007\u0010\u0098\u0005\u001a\u00020\u001fH\u0016¢\u0006\u0006\b\u0099\u0005\u0010\u0090\u0002J\t\u0010\u009a\u0005\u001a\u00020BH\u0016J\t\u0010\u009b\u0005\u001a\u00020BH\u0016J\u0012\u0010\u009c\u0005\u001a\u00020B2\u0007\u0010\u009d\u0005\u001a\u00020\"H\u0016J#\u0010\u009e\u0005\u001a\u00030¾\u00022\b\u0010\u009f\u0005\u001a\u00030þ\u00012\r\u0010\u0094\u0005\u001a\b\u0012\u0004\u0012\u00020B0AH\u0016J\u0013\u0010 \u0005\u001a\u00020B2\b\u0010¡\u0005\u001a\u00030¾\u0002H\u0016R+\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010#\u001a\u0004\u0018\u00010$8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u00020;2\u0006\u0010\u001b\u001a\u00020;@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010F\u001a\u00020E2\u0006\u0010\u0013\u001a\u00020E8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u001a\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0010\u0010L\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020QX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001a\u0010V\u001a\u00020WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020]X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u000e\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010b\u001a\u00020c8VX\u0096\u0004¢\u0006\f\u0012\u0004\bd\u0010&\u001a\u0004\be\u0010fR+\u0010g\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\"8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010\u001a\u001a\u0004\bg\u0010O\"\u0004\bh\u0010iR\u001b\u0010k\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bl\u0010OR\u000e\u0010o\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0015\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001f\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0096\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u008f\u0001\u0010&\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001f\u0010\u0092\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u0093\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u009b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\"\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00030¥\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001R\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010ª\u0001\u001a\u00030«\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R\u0018\u0010°\u0001\u001a\u00030±\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001R\u0018\u0010´\u0001\u001a\u00030µ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010¸\u0001\u001a\u00030¹\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bº\u0001\u0010»\u0001R\u0017\u0010¼\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010½\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010¿\u0001\u001a\f\u0012\u0005\u0012\u00030¾\u0001\u0018\u00010½\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010À\u0001\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Á\u0001\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Â\u0001\u001a\u00030Ã\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ä\u0001\u001a\u00030Å\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010Ç\u0001\u001a\u00030Æ\u00012\u0007\u0010\u0013\u001a\u00030Æ\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bÌ\u0001\u0010\u001a\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R \u0010Í\u0001\u001a\u00030Î\u00018VX\u0096\u0084\u0002¢\u0006\u000f\n\u0005\bÑ\u0001\u0010n\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u0012\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\bÖ\u0001\u0010×\u0001R\u001a\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u000f\u0010à\u0001\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010á\u0001\u001a\u00030â\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bã\u0001\u0010ä\u0001R\u0018\u0010å\u0001\u001a\u00030æ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bç\u0001\u0010è\u0001R\u0018\u0010é\u0001\u001a\u00030ê\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bë\u0001\u0010ì\u0001R&\u0010í\u0001\u001a\u00020\"8VX\u0096\u000e¢\u0006\u0017\n\u0000\u0012\u0005\bî\u0001\u0010&\u001a\u0005\bï\u0001\u0010O\"\u0005\bð\u0001\u0010iR\u0012\u0010ñ\u0001\u001a\u0005\u0018\u00010ò\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010ó\u0001\u001a\u00030ò\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bô\u0001\u0010õ\u0001R\u0012\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ø\u0001\u001a\u0005\u0018\u00010ù\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ú\u0001\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010û\u0001\u001a\u00030ü\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010ý\u0001\u001a\u00030þ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\u0016\u0010\u0081\u0002\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0002\u0010OR\u0012\u0010\u0083\u0002\u001a\u00030\u0084\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010\u0085\u0002\u001a\u00030\u0086\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0087\u0002\u001a\u00030\u0088\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0089\u0002R\u0013\u0010\u008a\u0002\u001a\u00030\u0088\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0089\u0002R\u0013\u0010\u008b\u0002\u001a\u00030\u0088\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0089\u0002R+\u0010\u008c\u0002\u001a\u00030þ\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u008d\u0002\u0010&\u001a\u0006\b\u008e\u0002\u0010\u0080\u0002\"\u0006\b\u008f\u0002\u0010\u0090\u0002R\u000f\u0010\u0091\u0002\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0092\u0002\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000f\u0010\u0093\u0002\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0094\u00022\t\u0010\u0013\u001a\u0005\u0018\u00010\u0094\u00028B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0005\b\u009a\u0002\u0010\u001a\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002\"\u0006\b\u0098\u0002\u0010\u0099\u0002R\"\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0094\u00028FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u009d\u0002\u0010n\u001a\u0006\b\u009c\u0002\u0010\u0097\u0002R\u001e\u0010\u009e\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020B\u0018\u00010\u009f\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u0002\u001a\u0005\u0018\u00010¡\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010¢\u0002\u001a\u00030¡\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b£\u0002\u0010¤\u0002R\u0012\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010§\u0002\u001a\u00030¦\u00028VX\u0097\u0004¢\u0006\u000f\u0012\u0005\b¨\u0002\u0010&\u001a\u0006\b©\u0002\u0010ª\u0002R\u001a\u0010«\u0002\u001a\n\u0012\u0005\u0012\u00030\u00ad\u00020¬\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010®\u0002R\u0012\u0010¯\u0002\u001a\u0005\u0018\u00010°\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010±\u0002\u001a\u00030°\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b²\u0002\u0010³\u0002R\u0018\u0010´\u0002\u001a\u00030µ\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b¶\u0002\u0010·\u0002R!\u0010Á\u0002\u001a\u00030Â\u00028\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bÃ\u0002\u0010&\u001a\u0006\bÄ\u0002\u0010Å\u0002R3\u0010Ç\u0002\u001a\u00030Æ\u00022\u0007\u0010\u0013\u001a\u00030Æ\u00028V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\bÌ\u0002\u0010\u001a\u001a\u0006\bÈ\u0002\u0010É\u0002\"\u0006\bÊ\u0002\u0010Ë\u0002R\u001c\u0010Í\u0002\u001a\u00020U*\u00030Æ\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÎ\u0002\u0010Ï\u0002R3\u0010Ñ\u0002\u001a\u00030Ð\u00022\u0007\u0010\u0013\u001a\u00030Ð\u00028V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\bÖ\u0002\u0010\u001a\u001a\u0006\bÒ\u0002\u0010Ó\u0002\"\u0006\bÔ\u0002\u0010Õ\u0002R\u0018\u0010×\u0002\u001a\u00030Ø\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0002\u0010Ú\u0002R\u0010\u0010Û\u0002\u001a\u00030Ü\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ý\u0002\u001a\u00030Þ\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bß\u0002\u0010à\u0002R\u0018\u0010á\u0002\u001a\u00030â\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bã\u0002\u0010ä\u0002R\u0018\u0010å\u0002\u001a\u00030æ\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bç\u0002\u0010è\u0002R\u0012\u0010é\u0002\u001a\u0005\u0018\u00010ê\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ë\u0002\u001a\u00030þ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010ì\u0002\u001a\n\u0012\u0005\u0012\u00030¾\u00010í\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010î\u0002\u001a\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00020B\u0018\u00010A0½\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ï\u0002\u001a\u00030ð\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ñ\u0002\u001a\u00030ð\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010ò\u0002\u001a\u00030ó\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ô\u0002R\u000f\u0010õ\u0002\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ö\u0002\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010÷\u0002\u001a\u00030ø\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010ù\u0002\u001a\b\u0012\u0004\u0012\u00020B0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ú\u0002\u001a\u00030û\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ü\u0002\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010ý\u0002\u001a\u00020\"X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bþ\u0002\u0010O\"\u0005\bÿ\u0002\u0010iR\u0012\u0010\u008c\u0003\u001a\u0005\u0018\u00010\u008d\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u008e\u0003\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0003\u0010OR\u0011\u0010\u008d\u0004\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0083\u0005\u001a\u00030\u0084\u0005X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0005\u0010\u0086\u0005R\u0016\u0010\u0088\u0005\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0005\u0010OR\u000f\u0010\u008a\u0005\u001a\u00020UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0005\u001a\u00020UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0090\u0005\u001a\u0004\u0018\u00010\u00008VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0091\u0005\u0010\u0092\u0005¨\u0006¥\u0005"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/compose/ui/node/OutOfFrameExecutor;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "Landroidx/compose/ui/focus/FocusListener;", "Landroidx/compose/ui/spatial/ExecuteDelayed;", "context", "Landroid/content/Context;", "composeViewContext", "Landroidx/compose/ui/platform/ComposeViewContext;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/platform/ComposeViewContext;)V", "<set-?>", "_composeViewContext", "get_composeViewContext", "()Landroidx/compose/ui/platform/ComposeViewContext;", "set_composeViewContext", "(Landroidx/compose/ui/platform/ComposeViewContext;)V", "_composeViewContext$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getComposeViewContext", "setComposeViewContext", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "superclassInitComplete", "", "primaryDirectionalMotionAxisOverride", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui$annotations", "()V", "getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui", "()Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "setPrimaryDirectionalMotionAxisOverride-r2epLt8$ui", "(Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;)V", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "frameEndScheduler", "Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$FrameEndScheduler;", "getFrameEndScheduler$ui", "()Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$FrameEndScheduler;", "setFrameEndScheduler$ui", "(Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$FrameEndScheduler;)V", "lifecycleRetainedValuesStoreOwnerEntry", "Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$RetainedValuesStoreEntry;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "retainedValuesStore", "getRetainedValuesStore", "()Landroidx/compose/runtime/retain/RetainedValuesStore;", "outOfFrameQueue", "Lkotlin/collections/ArrayDeque;", "Lkotlin/Function0;", "", "outOfFrameRunnable", "Ljava/lang/Runnable;", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "frameRateCategoryView", "isArrEnabled", "isArrEnabled$ui", "()Z", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "getImportantForAutofill", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "_windowInfo", "Landroidx/compose/ui/platform/LazyWindowInfo;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo$annotations", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "isAttached", "setAttached", "(Z)V", "isAttached$delegate", "derivedIsAttached", "getDerivedIsAttached", "derivedIsAttached$delegate", "Landroidx/compose/runtime/State;", "processingRequestFocusForNextNonChildView", "moveFocusInChildrenCurrent", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocusInChildrenCurrent-3ESFkO8", "(I)Z", "moveFocusInChildrenViewFocusFix", "moveFocusInChildrenViewFocusFix-3ESFkO8", "moveFocusInChildrenBypassUnfocusableComposeView", "moveFocusInChildrenBypassUnfocusableComposeView-3ESFkO8", "moveFocusInChildren", "moveFocusInChildren-3ESFkO8", "findNextViewInEmbeddedView", "findNextViewInEmbeddedView-3ESFkO8", "(I)Landroid/view/View;", "getEmbeddedViewFocusRect", "Landroidx/compose/ui/geometry/Rect;", "focusTargetAvailable", "findNextNonChildView", "direction", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "insetsListener", "Landroidx/compose/ui/layout/InsetsListener;", "getInsetsListener", "()Landroidx/compose/ui/layout/InsetsListener;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot$annotations", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNodes", "Landroidx/collection/MutableIntObjectMap;", "getLayoutNodes", "()Landroidx/collection/MutableIntObjectMap;", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "getRectManager", "()Landroidx/compose/ui/spatial/RectManager;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "uncaughtExceptionHandler", "Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "getUncaughtExceptionHandler$ui", "()Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "setUncaughtExceptionHandler$ui", "(Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;)V", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "dirtyLayers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/node/OwnedLayer;", "postponedDirtyLayers", "isDrawingContent", "isPendingInteropViewLayoutChangeDispatch", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "Landroid/content/res/Configuration;", "configuration", "getConfiguration", "()Landroid/content/res/Configuration;", "setConfiguration", "(Landroid/content/res/Configuration;)V", "configuration$delegate", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "localeList$delegate", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_autofillManager", "Landroidx/compose/ui/autofill/AndroidAutofillManager;", "get_autofillManager$ui", "()Landroidx/compose/ui/autofill/AndroidAutofillManager;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillManager", "Landroidx/compose/ui/autofill/AutofillManager;", "getAutofillManager", "()Landroidx/compose/ui/autofill/AutofillManager;", "observationClearRequested", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "clipboard", "Landroidx/compose/ui/platform/AndroidClipboard;", "getClipboard", "()Landroidx/compose/ui/platform/AndroidClipboard;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "androidViewsHandler", "getAndroidViewsHandler$ui", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "wasMeasuredWithMultipleConstraints", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "", "getMeasureIteration", "()J", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "tmpPositionArray", "", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "viewToWindowMatrix", "windowToViewMatrix", "lastMatrixRecalculationAnimationTime", "getLastMatrixRecalculationAnimationTime$ui$annotations", "getLastMatrixRecalculationAnimationTime$ui", "setLastMatrixRecalculationAnimationTime$ui", "(J)V", "forceUseMatrixCache", "windowPosition", "isRenderNodeCompatible", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "onReadyForComposition", "Lkotlin/Function1;", "_legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "legacyTextInputServiceAndroid", "getLegacyTextInputServiceAndroid", "()Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "_textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "textInputService", "getTextInputService$annotations", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "_softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "softwareKeyboardController", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textInputSession", "", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "endApplyChangesListeners", "currentFrameRate", "", "currentFrameRateCategory", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "sendHoverExitEvent", "hoverExitReceived", "indirectPointerNavigationGestureDetector", "Landroidx/compose/ui/platform/IndirectPointerNavigationGestureDetector;", "resendMotionEventOnLayout", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "keyboardModifiersRequireUpdate", "composeViewContextIncrementedDuringInit", "getComposeViewContextIncrementedDuringInit$ui", "setComposeViewContextIncrementedDuringInit$ui", "removeConnectionToComposeViewContext", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "addFocusables", "views", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "focusableMode", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCaptureInProgress", "getScrollCaptureInProgress$ui", "onScrollCaptureSearch", "localVisibleRect", "windowOffset", "Landroid/graphics/Point;", "targets", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "focusSearch", "focused", "requestFocusCurrent", "previouslyFocusedRect", "requestFocusViewFocusFix", "requestFocusBypassUnfocusableComposeView", "requestFocus", "requestOwnerFocus", "requestOwnerFocus-7o62pno", "clearOwnerFocus", "onFocusChanged", "gainFocus", "previous", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", UpdateServiceContract.BundleKey.CURRENT, "onWindowFocusChanged", "hasWindowFocus", "sendKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendIndirectPointerEvent", "indirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "forceAccessibilityForTesting", "enable", "setAccessibilityEventBatchIntervalMillis", "intervalMillis", "onPreAttach", "node", "onPostAttach", "onDetach", "requestAutofill", "requestClearInvalidObservations", "onEndApplyChanges", "registerOnEndApplyChangesListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "clearChildInvalidObservations", "viewGroup", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "addView", "child", FirebaseAnalytics.Param.INDEX, "width", "height", "params", "Landroid/view/ViewGroup$LayoutParams;", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "removeAndroidView", "drawAndroidView", "canvas", "Landroid/graphics/Canvas;", "scheduleMeasureAndLayout", "nodeToRemeasure", "childSizeCanAffectParentSize", "measureAndLayout", "sendPointerUpdate", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "dispatchPendingInteropLayoutCallbacks", "forceMeasureTheSubtree", "affectsLookahead", "onRequestMeasure", "forceRequest", "onRequestRelayout", "requestOnPositionedCallback", "measureAndLayoutForTest", "setUncaughtExceptionHandler", "handler", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "component1", "Lkotlin/ULong;", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "pack", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "pack-ZIaKswc", "(II)J", "convertMeasureSpec", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "onLayout", "changed", CmcdData.STREAM_TYPE_LIVE, "t", "r", "_rootView", "updatePositionCacheAndDispatch", "onDraw", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "invalidateParentLayer", "explicitLayer", "recycle", AdRevenueConstants.LAYER_KEY, "recycle$ui", "onSemanticsChange", "onLayoutChange", "onLayoutNodeDeactivated", "onPreLayoutNodeReused", "oldSemanticsId", "onPostLayoutNodeReused", "onInteropViewLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "dispatchDraw", "notifyLayerIsDirty", "isDirty", "notifyLayerIsDirty$ui", "setOnReadyForComposition", "callback", "boundsUpdatesContentCaptureEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesAccessibilityEventLoop", "invalidateLayoutNodeMeasurement", "invalidateLayers", "invalidateDescendants", "invalidateRootLayer", "onAttachedToWindow", "installLocalRetainedValuesStore", "lifecycleOwner", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "onDetachedFromWindow", "onProvideAutofillVirtualStructure", DownloaderServiceMarshaller.PARAMS_FLAGS, "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "dispatchGenericMotionEvent", "motionEvent", "handleIndirectPointerEvent", "dispatchTouchEvent", "handleRotaryEvent", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "hasChangedDevices", "lastEvent", "isDevicePressEvent", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "canScrollHorizontally", "canScrollVertically", "isInBounds", "localToScreen", "localPosition", "localToScreen-MK-Hz9U", "(J)J", "localTransform", "localToScreen-58bKbWc", "([F)V", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "recalculateWindowPosition", "recalculateWindowViewTransforms", "updateWindowMetrics", "onCheckIsTextEditor", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "calculatePositionInWindow", "calculatePositionInWindow-MK-Hz9U", "onConfigurationChanged", "newConfig", "dispatchConfigurationChangeIfNeeded", "updateConfiguration", "onRtlPropertiesChanged", "autofillSupported", "dispatchHoverEvent", "isBadMotionEvent", "isPositionChanged", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "onResolvePointerIcon", "Landroid/view/PointerIcon;", "pointerIndex", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "findViewByAccessibilityIdTraversal", "isLifecycleInResumedState", "shouldDelayChildPressedState", "sensitiveComponentCount", "incrementSensitiveComponentCount", "decrementSensitiveComponentCount", "keepScreenOnCount", "incrementKeepScreenOnCount", "decrementKeepScreenOnCount", "outOfFrameExecutor", "getOutOfFrameExecutor", "()Landroidx/compose/ui/platform/AndroidComposeView;", "schedule", "block", "voteFrameRate", "frameRate", "dispatchOnScrollChanged", "delta", "dispatchOnScrollChanged-k-4lQ0M", "onGlobalLayout", "onScrollChanged", "onTouchModeChanged", "isInTouchMode", "executeDelayed", "delayMillis", "removeDelayedExecution", "token", "Companion", "ViewTreeOwners", "RootModifierNode", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, PlatformFocusOwner, ViewRootForTest, MatrixPositionCalculator, DefaultLifecycleObserver, OutOfFrameExecutor, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnTouchModeChangeListener, FocusListener, ExecuteDelayed {
    private static Method addChangeCallbackMethod;
    private static Method dispatchOnScrollChangedMethod;
    private static Method getBooleanMethod;
    private static Runnable systemPropertiesChangedRunnable;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final AndroidAutofillManager _autofillManager;
    private final MutableState _composeViewContext$delegate;
    private final InputModeManagerImpl _inputModeManager;
    private TextInputServiceAndroid _legacyTextInputServiceAndroid;
    private View _rootView;
    private SoftwareKeyboardController _softwareKeyboardController;
    private TextInputService _textInputService;
    private final MutableState _viewTreeOwners$delegate;
    private final LazyWindowInfo _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboard clipboard;
    private final AndroidClipboardManager clipboardManager;
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private boolean composeViewContextIncrementedDuringInit;
    private final MutableState configuration$delegate;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private float currentFrameRate;
    private float currentFrameRateCategory;
    private final MutableState density$delegate;
    private final State derivedIsAttached$delegate;
    private final MutableObjectList<OwnedLayer> dirtyLayers;
    private final AndroidDragAndDropManager dragAndDropManager;
    private final MutableObjectList<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;
    private final MutableState fontFamilyResolver$delegate;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler;
    private View frameRateCategoryView;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private final IndirectPointerNavigationGestureDetector indirectPointerNavigationGestureDetector;
    private final InsetsListener insetsListener;
    private final MutableState isAttached$delegate;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible;
    private int keepScreenOnCount;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;
    private final MutableState layoutDirection$delegate;
    private final MutableIntObjectMap<LayoutNode> layoutNodes;
    private LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry lifecycleRetainedValuesStoreOwnerEntry;
    private final State localeList$delegate;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ComposeViewContext, Unit> onReadyForComposition;
    private final ArrayDeque<Function0<Unit>> outOfFrameQueue;
    private final Runnable outOfFrameRunnable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private MutableObjectList<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxisOverride;
    private boolean processingRequestFocusForNextNonChildView;
    private final RectManager rectManager;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private RetainedValuesStore retainedValuesStore;
    private final LayoutNode root;
    private final ScrollCapture scrollCapture;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private int sensitiveComponentCount;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private boolean superclassInitComplete;
    private final AtomicReference<SessionMutex.Session<AndroidPlatformTextInputSession>> textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;
    private final State viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final MutableObjectList<AndroidComposeView> composeViews = new MutableObjectList<>(0, 1, null);

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui$annotations() {
    }

    /* renamed from: getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui$annotations  reason: not valid java name */
    public static /* synthetic */ void m7246getPrimaryDirectionalMotionAxisOverridedqNNBbU$ui$annotations() {
    }

    public static /* synthetic */ void getRoot$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @Deprecated(message = "Use PlatformTextInputModifierNode instead.")
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    public static /* synthetic */ void getWindowInfo$annotations() {
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r15v10, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, ComposeViewContext composeViewContext) {
        super(context);
        LayoutNodeDrawScope layoutNodeDrawScope;
        CanvasHolder canvasHolder;
        AndroidViewConfiguration androidViewConfiguration;
        AndroidAccessibilityManager androidAccessibilityManager;
        AndroidAutofillManager androidAutofillManager;
        AndroidClipboardManager androidClipboardManager;
        AndroidClipboard androidClipboard;
        AndroidFontResourceLoader androidFontResourceLoader;
        MutableState<FontFamily.Resolver> mutableStateOf;
        PlatformHapticFeedback platformHapticFeedback;
        this._composeViewContext$delegate = SnapshotStateKt.mutableStateOf$default(composeViewContext, null, 2, null);
        this.lastDownPointerPosition = Offset.Companion.m5118getUnspecifiedF1C5BW0();
        this.superclassInitComplete = true;
        if (AndroidComposeUiFlags.isSharedDrawingEnabled) {
            layoutNodeDrawScope = composeViewContext.getSharedDrawScope$ui();
        } else {
            layoutNodeDrawScope = new LayoutNodeDrawScope(null, 1, null);
        }
        this.sharedDrawScope = layoutNodeDrawScope;
        this.retainedValuesStore = ForgetfulRetainedValuesStore.INSTANCE;
        this.outOfFrameQueue = new ArrayDeque<>();
        this.outOfFrameRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.outOfFrameRunnable$lambda$0(AndroidComposeView.this);
            }
        };
        this.density$delegate = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        AndroidComposeView androidComposeView = this;
        this.focusOwner = new FocusOwnerImpl(this, androidComposeView);
        this.coroutineContext = composeViewContext.getCompositionContext$ui().getEffectCoroutineContext();
        this.dragAndDropManager = new AndroidDragAndDropManager(new AndroidComposeView$dragAndDropManager$1(this));
        this._windowInfo = new LazyWindowInfo();
        this.isAttached$delegate = SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.derivedIsAttached$delegate = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$derivedIsAttached$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean isAttached;
                isAttached = AndroidComposeView.this.isAttached();
                return Boolean.valueOf(isAttached);
            }
        });
        if (AndroidComposeUiFlags.isSharedDrawingEnabled) {
            canvasHolder = composeViewContext.getCanvasHolder$ui();
        } else {
            canvasHolder = new CanvasHolder();
        }
        this.canvasHolder = canvasHolder;
        if (AndroidComposeUiFlags.isSharedViewConfigurationEnabled) {
            androidViewConfiguration = composeViewContext.getViewConfiguration$ui();
        } else {
            androidViewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(context));
        }
        this.viewConfiguration = androidViewConfiguration;
        this.insetsListener = new InsetsListener(this);
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setViewConfiguration(getViewConfiguration());
        layoutNode.setModifier(new ModifierNodeElement<RootModifierNode>() { // from class: androidx.compose.ui.platform.AndroidComposeView$root$1$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public boolean equals(Object obj) {
                return obj == this;
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void update(AndroidComposeView.RootModifierNode rootModifierNode) {
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public AndroidComposeView.RootModifierNode create() {
                return new AndroidComposeView.RootModifierNode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void inspectableProperties(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("rootModifier");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public int hashCode() {
                return AndroidComposeView.this.hashCode();
            }
        }.then(getFocusOwner().getModifier()).then(getDragAndDropManager().getModifier()));
        this.root = layoutNode;
        this.layoutNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.rectManager = new RectManager(getLayoutNodes(), this);
        this.semanticsOwner = new SemanticsOwner(getRoot(), new EmptySemanticsModifier(), getLayoutNodes());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        if (AndroidComposeUiFlags.isSharedAccessibilityManagerEnabled) {
            androidAccessibilityManager = composeViewContext.getAccessibilityManager$ui();
        } else {
            androidAccessibilityManager = new AndroidAccessibilityManager(context);
        }
        this.accessibilityManager = androidAccessibilityManager;
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new MutableObjectList<>(0, 1, null);
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configuration$delegate = SnapshotStateKt.mutableStateOf$default(new Configuration(context.getResources().getConfiguration()), null, 2, null);
        this.localeList$delegate = SnapshotStateKt.derivedStateOf(new Function0<LocaleList>() { // from class: androidx.compose.ui.platform.AndroidComposeView$localeList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LocaleList invoke() {
                LocaleListCompat locales = ConfigurationCompat.getLocales(AndroidComposeView.this.getConfiguration());
                if (locales.isEmpty()) {
                    locales = LocaleListCompat.getDefault();
                }
                int size = locales.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Locale locale = locales.get(i);
                    Intrinsics.checkNotNull(locale);
                    arrayList.add(new androidx.compose.ui.text.intl.Locale(locale));
                }
                return new LocaleList(arrayList);
            }
        });
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        if (autofillSupported()) {
            AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                androidAutofillManager = new AndroidAutofillManager(new PlatformAutofillManagerImpl(autofillManager), getSemanticsOwner(), this, getRectManager(), context.getPackageName());
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Autofill service could not be located.");
                throw new KotlinNothingValueException();
            }
        } else {
            androidAutofillManager = null;
        }
        this._autofillManager = androidAutofillManager;
        if (AndroidComposeUiFlags.isSharedClipboardManagerEnabled) {
            androidClipboardManager = composeViewContext.getClipboardManager$ui();
        } else {
            androidClipboardManager = new AndroidClipboardManager(context);
        }
        this.clipboardManager = androidClipboardManager;
        if (AndroidComposeUiFlags.isSharedClipboardManagerEnabled) {
            androidClipboard = composeViewContext.getClipboard$ui();
        } else {
            androidClipboard = new AndroidClipboard(getClipboardManager());
        }
        this.clipboard = androidClipboard;
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.globalPosition = IntOffset.m8282constructorimpl(9223372034707292159L);
        this.tmpPositionArray = new int[]{0, 0};
        float[] m5592constructorimpl$default = Matrix.m5592constructorimpl$default(null, 1, null);
        this.tmpMatrix = m5592constructorimpl$default;
        this.viewToWindowMatrix = Matrix.m5592constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m5592constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = Offset.Companion.m5117getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewTreeOwners$delegate = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                AndroidComposeView.ViewTreeOwners viewTreeOwners;
                viewTreeOwners = AndroidComposeView.this.get_viewTreeOwners();
                return viewTreeOwners;
            }
        });
        this.textInputSessionMutex = SessionMutex.m4785constructorimpl();
        if (AndroidComposeUiFlags.isSharedFontEnabled) {
            androidFontResourceLoader = composeViewContext.getFontLoader$ui();
        } else {
            androidFontResourceLoader = new AndroidFontResourceLoader(context);
        }
        this.fontLoader = androidFontResourceLoader;
        if (AndroidComposeUiFlags.isSharedFontEnabled) {
            mutableStateOf = composeViewContext.getFontFamilyResolver$ui();
        } else {
            mutableStateOf = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        }
        this.fontFamilyResolver$delegate = mutableStateOf;
        LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        this.layoutDirection$delegate = SnapshotStateKt.mutableStateOf$default(layoutDirection == null ? LayoutDirection.Ltr : layoutDirection, null, 2, null);
        if (AndroidComposeUiFlags.isSharedHapticsEnabled) {
            platformHapticFeedback = composeViewContext.getHapticFeedback$ui();
        } else {
            platformHapticFeedback = new PlatformHapticFeedback(this);
        }
        this.hapticFeedBack = platformHapticFeedback;
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.Companion.m6159getTouchaOaMEAU() : InputMode.Companion.m6158getKeyboardaOaMEAU(), new InputModeChangeRequester() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            @Override // androidx.compose.ui.input.InputModeChangeRequester
            /* renamed from: request-iuPiT84 */
            public final boolean mo6160requestiuPiT84(int i) {
                if (InputMode.m6154equalsimpl0(i, InputMode.Companion.m6159getTouchaOaMEAU())) {
                    return AndroidComposeView.this.isInTouchMode();
                }
                if (InputMode.m6154equalsimpl0(i, InputMode.Companion.m6158getKeyboardaOaMEAU())) {
                    if (AndroidComposeView.this.isInTouchMode()) {
                        return AndroidComposeView.this.requestFocusFromTouch();
                    }
                    return true;
                }
                return false;
            }
        }, null);
        this.modifierLocalManager = new ModifierLocalManager(androidComposeView);
        AndroidComposeView androidComposeView2 = this;
        this.textToolbar = new AndroidTextToolbar(androidComposeView2);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableObjectList<>(0, 1, null);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                MotionEvent motionEvent;
                int actionMasked;
                long j;
                AndroidComposeView.this.removeCallbacks(this);
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent == null || (actionMasked = motionEvent.getActionMasked()) == 10 || actionMasked == 1) {
                    return;
                }
                int i = 7;
                if (actionMasked != 7 && actionMasked != 9) {
                    i = 2;
                }
                int i2 = i;
                AndroidComposeView androidComposeView3 = AndroidComposeView.this;
                j = androidComposeView3.relayoutTime;
                androidComposeView3.sendSimulatedEvent(motionEvent, i2, j, false);
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.sendHoverExitEvent$lambda$0(AndroidComposeView.this);
            }
        };
        this.indirectPointerNavigationGestureDetector = new IndirectPointerNavigationGestureDetector(context, new Function1<FocusDirection, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$indirectPointerNavigationGestureDetector$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusDirection focusDirection) {
                m7258invoke3ESFkO8(focusDirection.m4981unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-3ESFkO8  reason: not valid java name */
            public final void m7258invoke3ESFkO8(int i) {
                AndroidComposeView.this.getFocusOwner().mo4998moveFocusaToIllA(i, false);
            }
        });
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MotionEvent motionEvent;
                AndroidComposeView$resendMotionEventRunnable$1 androidComposeView$resendMotionEventRunnable$1;
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        AndroidComposeView.this.relayoutTime = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView3 = AndroidComposeView.this;
                        androidComposeView$resendMotionEventRunnable$1 = androidComposeView3.resendMotionEventRunnable;
                        androidComposeView3.post(androidComposeView$resendMotionEventRunnable$1);
                    }
                }
            }
        };
        this.matrixToWindow = Build.VERSION.SDK_INT < 29 ? new CalculateMatrixToWindowApi21(m5592constructorimpl$default, null) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(androidComposeView2, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(androidComposeView2, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(getDragAndDropManager());
        getRoot().attach$ui(androidComposeView);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(androidComposeView2);
        }
        if (isArrEnabled$ui()) {
            View view = new View(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
            view.setTag(R.id.hide_in_inspector_tag, true);
            this.frameRateCategoryView = view;
            addView(view);
        }
        this.scrollCapture = Build.VERSION.SDK_INT >= 31 ? new ScrollCapture() : null;
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            private PointerIcon currentMouseCursorIcon = PointerIcon.Companion.getDefault();
            private PointerIcon currentStylusHoverIcon;

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public PointerIcon getIcon() {
                return this.currentMouseCursorIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setIcon(PointerIcon pointerIcon) {
                if (pointerIcon == null) {
                    pointerIcon = PointerIcon.Companion.getDefault();
                }
                this.currentMouseCursorIcon = pointerIcon;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(AndroidComposeView.this, this.currentMouseCursorIcon);
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public PointerIcon getStylusHoverIcon() {
                return this.currentStylusHoverIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setStylusHoverIcon(PointerIcon pointerIcon) {
                this.currentStylusHoverIcon = pointerIcon;
            }
        };
    }

    private final ComposeViewContext get_composeViewContext() {
        return (ComposeViewContext) this._composeViewContext$delegate.getValue();
    }

    private final void set_composeViewContext(ComposeViewContext composeViewContext) {
        this._composeViewContext$delegate.setValue(composeViewContext);
    }

    public final ComposeViewContext getComposeViewContext() {
        return get_composeViewContext();
    }

    public final void setComposeViewContext(ComposeViewContext composeViewContext) {
        if (!(getCoroutineContext() == composeViewContext.getCompositionContext$ui().getEffectCoroutineContext() || getRoot().getChildren$ui().isEmpty())) {
            InlineClassHelperKt.throwIllegalArgumentException("Changing ComposeViewContext cannot change the coroutine context without disposing of the composition first.");
        }
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            ComposeViewContext composeViewContext2 = get_composeViewContext();
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            if (Intrinsics.areEqual(composeViewContext, composeViewContext2)) {
                return;
            }
            if (isAttachedToWindow()) {
                composeViewContext2.decrementViewCount$ui();
                composeViewContext.incrementViewCount$ui();
            }
            set_composeViewContext(composeViewContext);
            setCoroutineContext(composeViewContext.getCompositionContext$ui().getEffectCoroutineContext());
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* renamed from: getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui  reason: not valid java name */
    public final IndirectPointerEventPrimaryDirectionalMotionAxis m7254getPrimaryDirectionalMotionAxisOverridedqNNBbU$ui() {
        return this.primaryDirectionalMotionAxisOverride;
    }

    /* renamed from: setPrimaryDirectionalMotionAxisOverride-r2epLt8$ui  reason: not valid java name */
    public final void m7255setPrimaryDirectionalMotionAxisOverrider2epLt8$ui(IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        this.primaryDirectionalMotionAxisOverride = indirectPointerEventPrimaryDirectionalMotionAxis;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public View getView() {
        return this;
    }

    public final LifecycleRetainedValuesStoreOwner.FrameEndScheduler getFrameEndScheduler$ui() {
        return this.frameEndScheduler;
    }

    public final void setFrameEndScheduler$ui(LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler) {
        this.frameEndScheduler = frameEndScheduler;
    }

    @Override // androidx.compose.ui.node.Owner
    public RetainedValuesStore getRetainedValuesStore() {
        return this.retainedValuesStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void outOfFrameRunnable$lambda$0(AndroidComposeView androidComposeView) {
        Trace.beginSection("AndroidOwner:outOfFrameExecutor");
        while (!androidComposeView.outOfFrameQueue.isEmpty()) {
            try {
                androidComposeView.outOfFrameQueue.removeLast().invoke();
            } finally {
                Trace.endSection();
            }
        }
        Unit unit = Unit.INSTANCE;
    }

    private void setDensity(Density density) {
        this.density$delegate.setValue(density);
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public Density getDensity() {
        return (Density) this.density$delegate.getValue();
    }

    public final boolean isArrEnabled$ui() {
        return Build.VERSION.SDK_INT >= 35;
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidDragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        if (AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
            return getComposeViewContext().getWindowInfo$ui();
        }
        return this._windowInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAttached() {
        return ((Boolean) this.isAttached$delegate.getValue()).booleanValue();
    }

    private final void setAttached(boolean z) {
        this.isAttached$delegate.setValue(Boolean.valueOf(z));
    }

    private final boolean getDerivedIsAttached() {
        return ((Boolean) this.derivedIsAttached$delegate.getValue()).booleanValue();
    }

    /* renamed from: moveFocusInChildrenCurrent-3ESFkO8  reason: not valid java name */
    private final boolean m7249moveFocusInChildrenCurrent3ESFkO8(int i) {
        View findNextFocusFromRect;
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4983getEnterdhqQ8s()) || FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4984getExitdhqQ8s())) {
            return false;
        }
        Integer m4990toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(i);
        if (m4990toAndroidFocusDirection3ESFkO8 != null) {
            int intValue = m4990toAndroidFocusDirection3ESFkO8.intValue();
            Rect embeddedViewFocusRect = getEmbeddedViewFocusRect();
            android.graphics.Rect androidRect = embeddedViewFocusRect != null ? RectHelper_androidKt.toAndroidRect(embeddedViewFocusRect) : null;
            FocusFinder focusFinder = FocusFinder.getInstance();
            if (androidRect == null) {
                findNextFocusFromRect = focusFinder.findNextFocus(this, findFocus(), intValue);
            } else {
                findNextFocusFromRect = focusFinder.findNextFocusFromRect(this, androidRect, intValue);
            }
            if (findNextFocusFromRect != null) {
                return FocusInteropUtils_androidKt.requestInteropFocus(findNextFocusFromRect, Integer.valueOf(intValue), androidRect);
            }
            return false;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid focus direction");
        throw new KotlinNothingValueException();
    }

    /* renamed from: moveFocusInChildrenViewFocusFix-3ESFkO8  reason: not valid java name */
    private final boolean m7250moveFocusInChildrenViewFocusFix3ESFkO8(int i) {
        AndroidViewsHandler androidViewsHandler;
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4983getEnterdhqQ8s()) || FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4984getExitdhqQ8s()) || !hasFocus() || (androidViewsHandler = this._androidViewsHandler) == null) {
            return false;
        }
        Integer m4990toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(i);
        if (m4990toAndroidFocusDirection3ESFkO8 != null) {
            int intValue = m4990toAndroidFocusDirection3ESFkO8.intValue();
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            View findFocus = viewGroup.findFocus();
            if (findFocus == null) {
                throw new IllegalStateException("view hasFocus but root can't find it".toString());
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, findFocus, intValue);
            if (!FocusOwnerImplKt.m5005is1dFocusSearch3ESFkO8(i) || !androidViewsHandler.hasFocus()) {
                Rect embeddedViewFocusRect = getEmbeddedViewFocusRect();
                r6 = embeddedViewFocusRect != null ? RectHelper_androidKt.toAndroidRect(embeddedViewFocusRect) : null;
                if (findNextFocus != null && r6 != null) {
                    viewGroup.offsetDescendantRectToMyCoords(this, r6);
                    viewGroup.offsetRectIntoDescendantCoords(findNextFocus, r6);
                }
            }
            if (findNextFocus == null || findNextFocus == findFocus) {
                return false;
            }
            View focusedChild = androidViewsHandler.getFocusedChild();
            ViewParent parent = findNextFocus.getParent();
            while (parent != null && parent != focusedChild) {
                parent = parent.getParent();
            }
            if (parent == null) {
                return false;
            }
            return FocusInteropUtils_androidKt.requestInteropFocus(findNextFocus, Integer.valueOf(intValue), r6);
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid focus direction");
        throw new KotlinNothingValueException();
    }

    /* renamed from: moveFocusInChildrenBypassUnfocusableComposeView-3ESFkO8  reason: not valid java name */
    private final boolean m7248moveFocusInChildrenBypassUnfocusableComposeView3ESFkO8(int i) {
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4983getEnterdhqQ8s()) || FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4984getExitdhqQ8s())) {
            return false;
        }
        Integer m4990toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(i);
        if (m4990toAndroidFocusDirection3ESFkO8 != null) {
            int intValue = m4990toAndroidFocusDirection3ESFkO8.intValue();
            View m7245findNextViewInEmbeddedView3ESFkO8 = m7245findNextViewInEmbeddedView3ESFkO8(i);
            if (m7245findNextViewInEmbeddedView3ESFkO8 != null) {
                return FocusInteropUtils_androidKt.requestInteropFocus(m7245findNextViewInEmbeddedView3ESFkO8, Integer.valueOf(intValue), null);
            }
            return false;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid focus direction");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    /* renamed from: moveFocusInChildren-3ESFkO8 */
    public boolean mo5044moveFocusInChildren3ESFkO8(int i) {
        if (ComposeUiFlags.isViewFocusFixEnabled) {
            return m7250moveFocusInChildrenViewFocusFix3ESFkO8(i);
        }
        if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            return m7248moveFocusInChildrenBypassUnfocusableComposeView3ESFkO8(i);
        }
        return m7249moveFocusInChildrenCurrent3ESFkO8(i);
    }

    /* renamed from: findNextViewInEmbeddedView-3ESFkO8  reason: not valid java name */
    private final View m7245findNextViewInEmbeddedView3ESFkO8(int i) {
        FocusTargetNode activeFocusTargetNode = getFocusOwner().getActiveFocusTargetNode();
        if (activeFocusTargetNode == null) {
            throw new IllegalStateException("findNextViewInEmbeddedView called when owner does not have anything focused.".toString());
        }
        Integer m4990toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(i);
        if (m4990toAndroidFocusDirection3ESFkO8 != null) {
            int intValue = m4990toAndroidFocusDirection3ESFkO8.intValue();
            View interopView = DelegatableNodeKt.requireLayoutNode(activeFocusTargetNode).getInteropView();
            View findFocus = findFocus();
            FocusFinder focusFinder = FocusFinder.getInstance();
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            View findNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, findFocus, intValue);
            if (findNextFocus == null || interopView == null || !AndroidComposeView_androidKt.access$containsDescendant(interopView, findNextFocus)) {
                return null;
            }
            return findNextFocus;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid focus direction");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    public Rect getEmbeddedViewFocusRect() {
        if (isFocused()) {
            return getFocusOwner().getFocusRect();
        }
        View findFocus = findFocus();
        if (findFocus != null) {
            return FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(findFocus, this);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    public void focusTargetAvailable() {
        if (getFocusOwner().getRootState().getHasFocus()) {
            return;
        }
        focusableViewAvailable(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findNextNonChildView(int i) {
        AndroidComposeView androidComposeView = this;
        FocusFinder focusFinder = FocusFinder.getInstance();
        View view = androidComposeView;
        while (view != null) {
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            view = focusFinder.findNextFocus((ViewGroup) rootView, view, i);
            if (view != null && !AndroidComposeView_androidKt.access$containsDescendant(androidComposeView, view)) {
                return view;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public final InsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.ui.node.Owner
    public MutableIntObjectMap<LayoutNode> getLayoutNodes() {
        return this.layoutNodes;
    }

    @Override // androidx.compose.ui.node.Owner
    public RectManager getRectManager() {
        return this.rectManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public RootForTest getRootForTest() {
        return this;
    }

    public final RootForTest.UncaughtExceptionHandler getUncaughtExceptionHandler$ui() {
        return this.uncaughtExceptionHandler;
    }

    public final void setUncaughtExceptionHandler$ui(RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    public final AndroidContentCaptureManager getContentCaptureManager$ui() {
        return this.contentCaptureManager;
    }

    public final void setContentCaptureManager$ui(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Configuration getConfiguration() {
        return (Configuration) this.configuration$delegate.getValue();
    }

    public final void setConfiguration(Configuration configuration) {
        this.configuration$delegate.setValue(configuration);
    }

    @Override // androidx.compose.ui.node.Owner
    public LocaleList getLocaleList() {
        return (LocaleList) this.localeList$delegate.getValue();
    }

    public final AndroidAutofillManager get_autofillManager$ui() {
        return this._autofillManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    public androidx.compose.ui.autofill.AutofillManager getAutofillManager() {
        return this._autofillManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboard getClipboard() {
        return this.clipboard;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.INSTANCE.isShowingLayoutBounds(this) : this.showLayoutBounds;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || !this.outOfFrameQueue.isEmpty();
    }

    public final long getLastMatrixRecalculationAnimationTime$ui() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners$delegate.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    private final TextInputServiceAndroid getLegacyTextInputServiceAndroid() {
        TextInputServiceAndroid textInputServiceAndroid = this._legacyTextInputServiceAndroid;
        if (textInputServiceAndroid == null) {
            TextInputServiceAndroid textInputServiceAndroid2 = new TextInputServiceAndroid(getView(), this);
            this._legacyTextInputServiceAndroid = textInputServiceAndroid2;
            return textInputServiceAndroid2;
        }
        return textInputServiceAndroid;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public TextInputService getTextInputService() {
        TextInputService textInputService = this._textInputService;
        if (textInputService == null) {
            TextInputService textInputService2 = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(getLegacyTextInputServiceAndroid()));
            this._textInputService = textInputService2;
            return textInputService2;
        }
        return textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        SoftwareKeyboardController softwareKeyboardController = this._softwareKeyboardController;
        if (softwareKeyboardController == null) {
            DelegatingSoftwareKeyboardController delegatingSoftwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
            this._softwareKeyboardController = delegatingSoftwareKeyboardController;
            return delegatingSoftwareKeyboardController;
        }
        return softwareKeyboardController;
    }

    @Override // androidx.compose.ui.node.Owner
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // androidx.compose.ui.node.Owner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object textInputSession(Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        AndroidComposeView$textInputSession$1 androidComposeView$textInputSession$1;
        int i;
        if (continuation instanceof AndroidComposeView$textInputSession$1) {
            androidComposeView$textInputSession$1 = (AndroidComposeView$textInputSession$1) continuation;
            if ((androidComposeView$textInputSession$1.label & Integer.MIN_VALUE) != 0) {
                androidComposeView$textInputSession$1.label -= Integer.MIN_VALUE;
                Object obj = androidComposeView$textInputSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidComposeView$textInputSession$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    androidComposeView$textInputSession$1.label = 1;
                    if (SessionMutex.m4792withSessionCancellingPreviousimpl(this.textInputSessionMutex, new Function1<CoroutineScope, AndroidPlatformTextInputSession>() { // from class: androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final AndroidPlatformTextInputSession invoke(CoroutineScope coroutineScope) {
                            AndroidComposeView androidComposeView = AndroidComposeView.this;
                            return new AndroidPlatformTextInputSession(androidComposeView, androidComposeView.getTextInputService(), coroutineScope);
                        }
                    }, function2, androidComposeView$textInputSession$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        androidComposeView$textInputSession$1 = new AndroidComposeView$textInputSession$1(this, continuation);
        Object obj2 = androidComposeView$textInputSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidComposeView$textInputSession$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver$delegate.setValue(resolver);
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void sendHoverExitEvent$lambda$0(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        androidComposeView.m7252sendMotionEvent8iAsVTc(motionEvent);
    }

    public final boolean getComposeViewContextIncrementedDuringInit$ui() {
        return this.composeViewContextIncrementedDuringInit;
    }

    public final void setComposeViewContextIncrementedDuringInit$ui(boolean z) {
        this.composeViewContextIncrementedDuringInit = z;
    }

    public final void removeConnectionToComposeViewContext() {
        if (this.composeViewContextIncrementedDuringInit) {
            getComposeViewContext().decrementViewCount$ui();
            this.composeViewContextIncrementedDuringInit = false;
        }
    }

    @Override // android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        Rect embeddedViewFocusRect = getEmbeddedViewFocusRect();
        if (embeddedViewFocusRect != null) {
            rect.left = Math.round(embeddedViewFocusRect.getLeft());
            rect.top = Math.round(embeddedViewFocusRect.getTop());
            rect.right = Math.round(embeddedViewFocusRect.getRight());
            rect.bottom = Math.round(embeddedViewFocusRect.getBottom());
        } else if (!Intrinsics.areEqual((Object) getFocusOwner().mo4997focusSearchULY8qGw(FocusDirection.Companion.m4982getDowndhqQ8s(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$getFocusedRect$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return true;
            }
        }), (Object) true)) {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            if (getFocusOwner().hasFocusableContent()) {
                super.addFocusables(arrayList, i, i2);
                if (getFocusOwner().hasNonInteropFocusableContent() || arrayList == null) {
                    return;
                }
                arrayList.remove(this);
                return;
            }
            return;
        }
        super.addFocusables(arrayList, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        if (Build.VERSION.SDK_INT < 28) {
            AndroidComposeViewAssistHelperMethodsO.INSTANCE.setClassName(viewStructure, getView());
        } else {
            super.dispatchProvideStructure(viewStructure);
        }
    }

    public final boolean getScrollCaptureInProgress$ui() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return false;
        }
        return scrollCapture.getScrollCaptureInProgress();
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(android.graphics.Rect rect, Point point, Consumer<ScrollCaptureTarget> consumer) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return;
        }
        scrollCapture.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), consumer);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner lifecycleOwner) {
        if (Build.VERSION.SDK_INT < 30) {
            setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
        }
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler = this.frameEndScheduler;
            Intrinsics.checkNotNull(frameEndScheduler);
            retainedValuesStoreEntry.stopRetainingExitedValues(frameEndScheduler);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            retainedValuesStoreEntry.startRetainingExitedValues();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        Rect calculateFocusRectRelativeTo;
        if (view == null || this.measureAndLayoutDelegate.getDuringMeasureLayout$ui()) {
            return super.focusSearch(view, i);
        }
        View rootView = getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) rootView, view, i);
        if (findNextFocus == null || !AndroidComposeView_androidKt.access$containsDescendant(this, findNextFocus)) {
            findNextFocus = null;
        }
        if (view == this) {
            calculateFocusRectRelativeTo = getFocusOwner().getFocusRect();
            if (calculateFocusRectRelativeTo == null) {
                calculateFocusRectRelativeTo = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(view, this);
            }
        } else {
            calculateFocusRectRelativeTo = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(view, this);
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
        int m4981unboximpl = focusDirection != null ? focusDirection.m4981unboximpl() : FocusDirection.Companion.m4982getDowndhqQ8s();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (getFocusOwner().mo4997focusSearchULY8qGw(m4981unboximpl, calculateFocusRectRelativeTo, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusSearch$searchResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = focusTargetNode;
                return true;
            }
        }) == null) {
            return view;
        }
        if (objectRef.element == 0) {
            if (findNextFocus == null) {
                return super.focusSearch(view, i);
            }
        } else if (findNextFocus == null) {
            return this;
        } else {
            if (FocusOwnerImplKt.m5005is1dFocusSearch3ESFkO8(m4981unboximpl)) {
                if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
                    return this;
                }
                return super.focusSearch(view, i);
            }
            AndroidComposeView androidComposeView = this;
            if (TwoDimensionalFocusSearchKt.m5051isBetterCandidateI7lrPNg(FocusTraversalKt.focusRect((FocusTargetNode) objectRef.element), FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(findNextFocus, androidComposeView), calculateFocusRectRelativeTo, m4981unboximpl)) {
                return androidComposeView;
            }
        }
        return findNextFocus;
    }

    public final boolean requestFocusCurrent(int i, android.graphics.Rect rect) {
        if (isFocused()) {
            return true;
        }
        if (getFocusOwner().getRootState().getHasFocus()) {
            return super.requestFocus(i, rect);
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
        final int m4981unboximpl = focusDirection != null ? focusDirection.m4981unboximpl() : FocusDirection.Companion.m4983getEnterdhqQ8s();
        return Intrinsics.areEqual((Object) getFocusOwner().mo4997focusSearchULY8qGw(m4981unboximpl, rect != null ? RectHelper_androidKt.toComposeRect(rect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocusCurrent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(m4981unboximpl));
            }
        }), (Object) true);
    }

    public final boolean requestFocusViewFocusFix(int i, android.graphics.Rect rect) {
        View findNextNonChildView;
        if (isFocused()) {
            return true;
        }
        if (this.processingRequestFocusForNextNonChildView) {
            return false;
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
        final int m4981unboximpl = focusDirection != null ? focusDirection.m4981unboximpl() : FocusDirection.Companion.m4983getEnterdhqQ8s();
        if (hasFocus() && mo5044moveFocusInChildren3ESFkO8(m4981unboximpl)) {
            return true;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Boolean mo4997focusSearchULY8qGw = getFocusOwner().mo4997focusSearchULY8qGw(m4981unboximpl, rect != null ? RectHelper_androidKt.toComposeRect(rect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocusViewFocusFix$focusSearchResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                Ref.BooleanRef.this.element = true;
                return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(m4981unboximpl));
            }
        });
        if (mo4997focusSearchULY8qGw == null) {
            return false;
        }
        if (mo4997focusSearchULY8qGw.booleanValue()) {
            return true;
        }
        if (booleanRef.element) {
            return false;
        }
        if ((rect != null && !hasFocus() && Intrinsics.areEqual((Object) getFocusOwner().mo4997focusSearchULY8qGw(m4981unboximpl, null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocusViewFocusFix$altFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(m4981unboximpl));
            }
        }), (Object) true)) || (findNextNonChildView = findNextNonChildView(i)) == null || findNextNonChildView == this) {
            return true;
        }
        this.processingRequestFocusForNextNonChildView = true;
        boolean requestFocus = findNextNonChildView.requestFocus(i);
        this.processingRequestFocusForNextNonChildView = false;
        return requestFocus;
    }

    public final boolean requestFocusBypassUnfocusableComposeView(int i, android.graphics.Rect rect) {
        if (isFocused()) {
            return true;
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
        final int m4981unboximpl = focusDirection != null ? focusDirection.m4981unboximpl() : FocusDirection.Companion.m4983getEnterdhqQ8s();
        if (Intrinsics.areEqual((Object) getFocusOwner().mo4997focusSearchULY8qGw(m4981unboximpl, rect != null ? RectHelper_androidKt.toComposeRect(rect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocusBypassUnfocusableComposeView$requestFocusWithPrevRect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(m4981unboximpl));
            }
        }), (Object) true) || Intrinsics.areEqual((Object) getFocusOwner().mo4997focusSearchULY8qGw(m4981unboximpl, null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocusBypassUnfocusableComposeView$requestFocusWithoutPrevRect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(m4981unboximpl));
            }
        }), (Object) true)) {
            return true;
        }
        if (hasFocus() && FocusOwnerImplKt.m5005is1dFocusSearch3ESFkO8(m4981unboximpl)) {
            return getFocusOwner().mo5000resetFocus3ESFkO8(m4981unboximpl);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, android.graphics.Rect rect) {
        if (ComposeUiFlags.isViewFocusFixEnabled) {
            return requestFocusViewFocusFix(i, rect);
        }
        if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            return requestFocusBypassUnfocusableComposeView(i, rect);
        }
        return requestFocusCurrent(i, rect);
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    /* renamed from: requestOwnerFocus-7o62pno */
    public boolean mo5045requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect rect) {
        Integer m4990toAndroidFocusDirection3ESFkO8;
        if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            if (isFocused()) {
                return true;
            }
        } else if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (m4990toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(focusDirection.m4981unboximpl())) == null) ? TsExtractor.TS_STREAM_TYPE_HDMV_DTS : m4990toAndroidFocusDirection3ESFkO8.intValue(), rect != null ? RectHelper_androidKt.toAndroidRect(rect) : null);
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    public void clearOwnerFocus() {
        if (isFocused() || (!ComposeUiFlags.isViewFocusFixEnabled && hasFocus())) {
            super.clearFocus();
        } else if (hasFocus()) {
            View findFocus = findFocus();
            if (findFocus != null) {
                findFocus.clearFocus();
            }
            super.clearFocus();
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, android.graphics.Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z || hasFocus()) {
            return;
        }
        getFocusOwner().releaseFocus();
    }

    @Override // androidx.compose.ui.focus.FocusListener
    public void onFocusChanged(FocusTargetModifierNode focusTargetModifierNode, FocusTargetModifierNode focusTargetModifierNode2) {
        NodeChain nodes$ui;
        boolean z;
        NodeChain nodes$ui2;
        boolean z2;
        if (!ComposeUiFlags.isOptimizedFocusEventDispatchEnabled || focusTargetModifierNode == null) {
            return;
        }
        FocusTargetModifierNode focusTargetModifierNode3 = focusTargetModifierNode;
        int m7135constructorimpl = NodeKind.m7135constructorimpl(2097152);
        if (!focusTargetModifierNode3.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = focusTargetModifierNode3.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetModifierNode3);
        MutableScatterSet mutableScatterSet = null;
        ArrayList arrayList = null;
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                while (node != null) {
                    if ((node.getKindSet$ui() & m7135constructorimpl) != 0) {
                        Modifier.Node node2 = node;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof IndirectPointerInputModifierNode) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node2);
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2 && (node2.getKindSet$ui() & m7135constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
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
                            node2 = DelegatableNodeKt.access$pop(mutableVector);
                        }
                    }
                    node = node.getParent$ui();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui();
            node = (requireLayoutNode == null || (nodes$ui2 = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui2.getTail$ui();
        }
        if (arrayList == null) {
            return;
        }
        if (focusTargetModifierNode2 != null) {
            FocusTargetModifierNode focusTargetModifierNode4 = focusTargetModifierNode2;
            int m7135constructorimpl2 = NodeKind.m7135constructorimpl(2097152);
            if (!focusTargetModifierNode4.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node3 = focusTargetModifierNode4.getNode();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetModifierNode4);
            MutableScatterSet mutableScatterSet2 = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl2) != 0) {
                    while (node3 != null) {
                        if ((node3.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            Modifier.Node node4 = node3;
                            MutableVector mutableVector2 = null;
                            while (node4 != null) {
                                if (node4 instanceof IndirectPointerInputModifierNode) {
                                    if (mutableScatterSet2 == null) {
                                        mutableScatterSet2 = ScatterSetKt.mutableScatterSetOf();
                                    }
                                    mutableScatterSet2.add(node4);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (node4.getKindSet$ui() & m7135constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui2 = ((DelegatingNode) node4).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                        if ((delegate$ui2.getKindSet$ui() & m7135constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node4 = delegate$ui2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node4 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node4);
                                                    }
                                                    node4 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node4 = DelegatableNodeKt.access$pop(mutableVector2);
                            }
                        }
                        node3 = node3.getParent$ui();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui();
                node3 = (requireLayoutNode2 == null || (nodes$ui = requireLayoutNode2.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
            }
            mutableScatterSet = mutableScatterSet2;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            IndirectPointerInputModifierNode indirectPointerInputModifierNode = (IndirectPointerInputModifierNode) arrayList.get(i3);
            if (!(mutableScatterSet != null ? mutableScatterSet.contains(indirectPointerInputModifierNode) : false)) {
                indirectPointerInputModifierNode.onCancelIndirectPointerInput();
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        boolean isShowingLayoutBounds;
        if (!AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
            this._windowInfo.setWindowFocused(z);
        }
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(z);
        if (!z || Build.VERSION.SDK_INT >= 30 || getShowLayoutBounds() == (isShowingLayoutBounds = Companion.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    @Override // androidx.compose.ui.node.RootForTest
    /* renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo7203sendKeyEventZmokQxo(KeyEvent keyEvent) {
        return getFocusOwner().mo4995dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || FocusOwner.m4993dispatchKeyEventYhN2O0w$default(getFocusOwner(), keyEvent, null, 2, null);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public boolean sendIndirectPointerEvent(IndirectPointerEvent indirectPointerEvent) {
        if (AndroidIndirectPointerEvent_androidKt.getNativeEvent(indirectPointerEvent).getActionMasked() == 3) {
            getFocusOwner().dispatchIndirectPointerCancel();
            return true;
        }
        return handleIndirectPointerEvent(indirectPointerEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        if (isFocused()) {
            if (AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
                getComposeViewContext().getWindowInfo$ui().m7327setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m6749constructorimpl(keyEvent.getMetaState()));
            } else {
                this._windowInfo.m7327setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m6749constructorimpl(keyEvent.getMetaState()));
            }
            return FocusOwner.m4993dispatchKeyEventYhN2O0w$default(getFocusOwner(), androidx.compose.ui.input.key.KeyEvent.m6501constructorimpl(keyEvent), null, 2, null) || super.dispatchKeyEvent(keyEvent);
        }
        return getFocusOwner().mo4996dispatchKeyEventYhN2O0w(androidx.compose.ui.input.key.KeyEvent.m6501constructorimpl(keyEvent), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$dispatchKeyEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean dispatchKeyEvent;
                dispatchKeyEvent = super/*android.view.ViewGroup*/.dispatchKeyEvent(keyEvent);
                return Boolean.valueOf(dispatchKeyEvent);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return (isFocused() && getFocusOwner().mo4995dispatchInterceptedSoftKeyboardEventZmokQxo(androidx.compose.ui.input.key.KeyEvent.m6501constructorimpl(keyEvent))) || super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void forceAccessibilityForTesting(boolean z) {
        this.composeAccessibilityDelegate.setAccessibilityForceEnabledForTesting$ui(z);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void setAccessibilityEventBatchIntervalMillis(long j) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui(j);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPreAttach(LayoutNode layoutNode) {
        getLayoutNodes().set(layoutNode.getSemanticsId(), layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPostAttach(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        if (!autofillSupported() || (androidAutofillManager = this._autofillManager) == null) {
            return;
        }
        androidAutofillManager.onPostAttach$ui(layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onDetach(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        getLayoutNodes().remove(layoutNode.getSemanticsId());
        this.measureAndLayoutDelegate.onNodeDetached(layoutNode);
        requestClearInvalidObservations();
        if (!autofillSupported() || (androidAutofillManager = this._autofillManager) == null) {
            return;
        }
        androidAutofillManager.onDetach$ui(layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestAutofill(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        if (!autofillSupported() || (androidAutofillManager = this._autofillManager) == null) {
            return;
        }
        androidAutofillManager.requestAutofill$ui(layoutNode);
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onEndApplyChanges() {
        MutableObjectList<Function0<Unit>> mutableObjectList;
        AndroidAutofillManager androidAutofillManager;
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        if (autofillSupported() && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onEndApplyChanges$ui();
        }
        while (this.endApplyChangesListeners.isNotEmpty() && this.endApplyChangesListeners.get(0) != null) {
            int size = this.endApplyChangesListeners.getSize();
            int i = 0;
            while (true) {
                mutableObjectList = this.endApplyChangesListeners;
                if (i < size) {
                    Function0<Unit> function0 = mutableObjectList.get(i);
                    this.endApplyChangesListeners.set(i, null);
                    if (function0 != null) {
                        function0.invoke();
                    }
                    i++;
                }
            }
            mutableObjectList.removeRange(0, size);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> function0) {
        if (this.endApplyChangesListeners.contains(function0)) {
            return;
        }
        this.endApplyChangesListeners.add(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startDrag-12SF9DM  reason: not valid java name */
    public final boolean m7253startDrag12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j, Function1<? super DrawScope, Unit> function1) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, dragAndDropTransferData, new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), j, function1, null));
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int orDefault;
        boolean areEqual = Intrinsics.areEqual(str, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal$ui());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
        if (areEqual) {
            int orDefault2 = androidComposeViewAccessibilityDelegateCompat.getIdToBeforeMap$ui().getOrDefault(i, -1);
            if (orDefault2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, orDefault2);
            }
        } else if (!Intrinsics.areEqual(str, androidComposeViewAccessibilityDelegateCompat.getExtraDataTestTraversalAfterVal$ui()) || (orDefault = this.composeAccessibilityDelegate.getIdToAfterMap$ui().getOrDefault(i, -1)) == -1) {
        } else {
            accessibilityNodeInfo.getExtras().putInt(str, orDefault);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        addView(view, -1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        Intrinsics.checkNotNull(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = i;
        generateDefaultLayoutParams.height = i2;
        Unit unit = Unit.INSTANCE;
        addView(view, -1, generateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addView(view, -1, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i, layoutParams, true);
    }

    public final void addAndroidView(AndroidViewHolder androidViewHolder, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui().getHolderToLayoutNode().put(androidViewHolder, layoutNode);
        AndroidViewHolder androidViewHolder2 = androidViewHolder;
        getAndroidViewsHandler$ui().addView(androidViewHolder2);
        getAndroidViewsHandler$ui().getLayoutNodeToHolder().put(layoutNode, androidViewHolder);
        androidViewHolder.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(androidViewHolder2, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
                if (r0.intValue() == r4.this$0.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) goto L34;
             */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat3;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat4;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat5;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                androidComposeViewAccessibilityDelegateCompat = AndroidComposeView.this.composeAccessibilityDelegate;
                if (androidComposeViewAccessibilityDelegateCompat.isEnabled$ui()) {
                    accessibilityNodeInfoCompat.setVisibleToUser(false);
                }
                LayoutNode parent$ui = layoutNode.getParent$ui();
                while (true) {
                    if (parent$ui == null) {
                        parent$ui = null;
                        break;
                    } else if (parent$ui.getNodes$ui().m7095hasH91voCI$ui(NodeKind.m7135constructorimpl(8))) {
                        break;
                    } else {
                        parent$ui = parent$ui.getParent$ui();
                    }
                }
                Integer valueOf = parent$ui != null ? Integer.valueOf(parent$ui.getSemanticsId()) : null;
                if (valueOf != null) {
                }
                valueOf = -1;
                accessibilityNodeInfoCompat.setParent(this, valueOf.intValue());
                int semanticsId = layoutNode.getSemanticsId();
                androidComposeViewAccessibilityDelegateCompat2 = AndroidComposeView.this.composeAccessibilityDelegate;
                int orDefault = androidComposeViewAccessibilityDelegateCompat2.getIdToBeforeMap$ui().getOrDefault(semanticsId, -1);
                if (orDefault != -1) {
                    View semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(AndroidComposeView.this.getAndroidViewsHandler$ui(), orDefault);
                    if (semanticsIdToView != null) {
                        accessibilityNodeInfoCompat.setTraversalBefore(semanticsIdToView);
                    } else {
                        accessibilityNodeInfoCompat.setTraversalBefore(this, orDefault);
                    }
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    AccessibilityNodeInfo unwrap = accessibilityNodeInfoCompat.unwrap();
                    androidComposeViewAccessibilityDelegateCompat5 = AndroidComposeView.this.composeAccessibilityDelegate;
                    androidComposeView.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, unwrap, androidComposeViewAccessibilityDelegateCompat5.getExtraDataTestTraversalBeforeVal$ui());
                }
                androidComposeViewAccessibilityDelegateCompat3 = AndroidComposeView.this.composeAccessibilityDelegate;
                int orDefault2 = androidComposeViewAccessibilityDelegateCompat3.getIdToAfterMap$ui().getOrDefault(semanticsId, -1);
                if (orDefault2 != -1) {
                    View semanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(AndroidComposeView.this.getAndroidViewsHandler$ui(), orDefault2);
                    if (semanticsIdToView2 != null) {
                        accessibilityNodeInfoCompat.setTraversalAfter(semanticsIdToView2);
                    } else {
                        accessibilityNodeInfoCompat.setTraversalAfter(this, orDefault2);
                    }
                    AndroidComposeView androidComposeView2 = AndroidComposeView.this;
                    AccessibilityNodeInfo unwrap2 = accessibilityNodeInfoCompat.unwrap();
                    androidComposeViewAccessibilityDelegateCompat4 = AndroidComposeView.this.composeAccessibilityDelegate;
                    androidComposeView2.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, unwrap2, androidComposeViewAccessibilityDelegateCompat4.getExtraDataTestTraversalAfterVal$ui());
                }
            }
        });
    }

    public final void removeAndroidView(AndroidViewHolder androidViewHolder) {
        getAndroidViewsHandler$ui().removeViewInLayout(androidViewHolder);
        TypeIntrinsics.asMutableMap(getAndroidViewsHandler$ui().getLayoutNodeToHolder()).remove(getAndroidViewsHandler$ui().getHolderToLayoutNode().remove(androidViewHolder));
        androidViewHolder.setImportantForAccessibility(0);
    }

    public final void drawAndroidView(AndroidViewHolder androidViewHolder, Canvas canvas) {
        getAndroidViewsHandler$ui().drawView(androidViewHolder, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (layoutNode != null) {
            while (layoutNode != null && layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(layoutNode)) {
                layoutNode = layoutNode.getParent$ui();
            }
            if (layoutNode == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode layoutNode) {
        if (this.wasMeasuredWithMultipleConstraints) {
            return true;
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        return (parent$ui == null || parent$ui.getHasFixedInnerContentConstraints$ui()) ? false : true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void measureAndLayout(boolean z) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } finally {
                    Trace.endSection();
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            getRectManager().dispatchCallbacks();
            dispatchPendingInteropLayoutCallbacks();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo7202measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m7082measureAndLayout0kLqBqw(layoutNode, j);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
                getRectManager().dispatchCallbacks();
                dispatchPendingInteropLayoutCallbacks();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, z);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean z, boolean z2, boolean z3) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (z) {
            if (measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z2) && z3) {
                scheduleMeasureAndLayout(layoutNode);
            }
        } else if (measureAndLayoutDelegate.requestRemeasure(layoutNode, z2) && z3) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean z, boolean z2) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (z) {
            if (measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z2)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (measureAndLayoutDelegate.requestRelayout(layoutNode, z2)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, null);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.outOfFrameRunnable);
        }
        this.outOfFrameRunnable.run();
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void setUncaughtExceptionHandler(RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        this.measureAndLayoutDelegate.setUncaughtExceptionHandler$ui(uncaughtExceptionHandler);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long m7244convertMeasureSpecI7RO_PI = m7244convertMeasureSpecI7RO_PI(i);
            long m7244convertMeasureSpecI7RO_PI2 = m7244convertMeasureSpecI7RO_PI(i2);
            long m8121fitPrioritizingHeightZbe2FdA = Constraints.Companion.m8121fitPrioritizingHeightZbe2FdA((int) ULong.m10096constructorimpl(m7244convertMeasureSpecI7RO_PI >>> 32), (int) ULong.m10096constructorimpl(m7244convertMeasureSpecI7RO_PI & 4294967295L), (int) ULong.m10096constructorimpl(m7244convertMeasureSpecI7RO_PI2 >>> 32), (int) ULong.m10096constructorimpl(4294967295L & m7244convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            boolean z = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m8100boximpl(m8121fitPrioritizingHeightZbe2FdA);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z = Constraints.m8106equalsimpl0(constraints.m8119unboximpl(), m8121fitPrioritizingHeightZbe2FdA);
                }
                if (!z) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m7083updateRootConstraintsBRTryo0(m8121fitPrioritizingHeightZbe2FdA);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                Trace.beginSection("AndroidOwner:androidViewMeasure");
                getAndroidViewsHandler$ui().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: component1-VKZWuLQ  reason: not valid java name */
    private final int m7242component1VKZWuLQ(long j) {
        return (int) ULong.m10096constructorimpl(j >>> 32);
    }

    /* renamed from: component2-VKZWuLQ  reason: not valid java name */
    private final int m7243component2VKZWuLQ(long j) {
        return (int) ULong.m10096constructorimpl(j & 4294967295L);
    }

    /* renamed from: pack-ZIaKswc  reason: not valid java name */
    private final long m7251packZIaKswc(int i, int i2) {
        return ULong.m10096constructorimpl(ULong.m10096constructorimpl(ULong.m10096constructorimpl(i) << 32) | ULong.m10096constructorimpl(i2));
    }

    /* renamed from: convertMeasureSpec-I7RO_PI  reason: not valid java name */
    private final long m7244convertMeasureSpecI7RO_PI(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return m7251packZIaKswc(size, size);
                }
                throw new IllegalStateException();
            }
            return m7251packZIaKswc(0, Integer.MAX_VALUE);
        }
        return m7251packZIaKswc(0, size);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Trace.beginSection("AndroidOwner:onLayout");
        try {
            this.lastMatrixRecalculationAnimationTime = 0L;
            this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
            this.onMeasureConstraints = null;
            updatePositionCacheAndDispatch();
            if (this._androidViewsHandler != null) {
                Trace.beginSection("AndroidOwner:viewLayout");
                getAndroidViewsHandler$ui().layout(0, 0, i3 - i, i4 - i2);
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int m8288getXimpl = IntOffset.m8288getXimpl(j);
        int m8289getYimpl = IntOffset.m8289getYimpl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        z = false;
        z = false;
        int i = iArr[0];
        if (m8288getXimpl != i || m8289getYimpl != iArr[1] || this.lastMatrixRecalculationAnimationTime < 0) {
            this.globalPosition = IntOffset.m8282constructorimpl((i << 32) | (iArr[1] & 4294967295L));
            if (m8288getXimpl != Integer.MAX_VALUE && m8289getYimpl != Integer.MAX_VALUE) {
                MutableVector<LayoutNode> mutableVector = getRoot().get_children$ui();
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    layoutNodeArr[i2].getMeasurePassDelegate$ui().requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
                }
                z = true;
            }
        }
        recalculateWindowPosition();
        View view = this._rootView;
        if (view == null) {
            view = getRootView();
            this._rootView = view;
        }
        getRectManager().m7402updateOffsetsgTq6Wqs(this.globalPosition, IntOffsetKt.m8305roundk4lQ0M(this.windowPosition), this.viewToWindowMatrix, view.getWidth(), view.getHeight());
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
        getRectManager().dispatchCallbacks();
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnedLayer createLayer(Function2<? super androidx.compose.ui.graphics.Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0, GraphicsLayer graphicsLayer) {
        if (graphicsLayer != null) {
            return new GraphicsLayerOwnerLayer(graphicsLayer, null, this, function2, function0);
        }
        OwnedLayer pop = this.layerCache.pop();
        if (pop != null) {
            pop.reuseLayer(function2, function0);
            return pop;
        }
        return new GraphicsLayerOwnerLayer(getGraphicsContext().createGraphicsLayer(), getGraphicsContext(), this, function2, function0);
    }

    public final boolean recycle$ui(OwnedLayer ownedLayer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.Companion.getShouldUseDispatchDraw();
        }
        this.layerCache.push(ownedLayer);
        this.dirtyLayers.remove(ownedLayer);
        return true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui();
        this.contentCaptureManager.onSemanticsChange$ui();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutNodeDeactivated(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        if (!autofillSupported() || (androidAutofillManager = this._autofillManager) == null) {
            return;
        }
        androidAutofillManager.onLayoutNodeDeactivated$ui(layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPreLayoutNodeReused(LayoutNode layoutNode, int i) {
        getLayoutNodes().remove(i);
        getLayoutNodes().set(layoutNode.getSemanticsId(), layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPostLayoutNodeReused(LayoutNode layoutNode, int i) {
        AndroidAutofillManager androidAutofillManager;
        if (!autofillSupported() || (androidAutofillManager = this._autofillManager) == null) {
            return;
        }
        androidAutofillManager.onPostLayoutNodeReused$ui(layoutNode, i);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onInteropViewLayoutChange(View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(onLayoutCompletedListener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, null);
        Snapshot.Companion.notifyObjectsInitialized();
        this.isDrawingContent = true;
        try {
            Trace.beginSection("AndroidOwner:draw");
            CanvasHolder canvasHolder = this.canvasHolder;
            Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
            getRoot().draw$ui(canvasHolder.getAndroidCanvas(), null);
            canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
            if (this.dirtyLayers.isNotEmpty()) {
                int size = this.dirtyLayers.getSize();
                for (int i = 0; i < size; i++) {
                    this.dirtyLayers.get(i).updateDisplayList();
                }
            }
            if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
                int save = canvas.save();
                canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
                super.dispatchDraw(canvas);
                canvas.restoreToCount(save);
            }
            this.dirtyLayers.clear();
            this.isDrawingContent = false;
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler = this.uncaughtExceptionHandler;
            if (uncaughtExceptionHandler == null) {
                throw th;
            }
            uncaughtExceptionHandler.onUncaughtException(th);
        }
        MutableObjectList<OwnedLayer> mutableObjectList = this.postponedDirtyLayers;
        if (mutableObjectList != null) {
            Intrinsics.checkNotNull(mutableObjectList);
            this.dirtyLayers.addAll(mutableObjectList);
            mutableObjectList.clear();
        }
        if (isArrEnabled$ui()) {
            Api35Impl.setRequestedFrameRate(this, this.currentFrameRate);
            View view = this.frameRateCategoryView;
            if (view != null) {
                Api35Impl.setRequestedFrameRate(view, this.currentFrameRateCategory);
                if (!Float.isNaN(this.currentFrameRateCategory)) {
                    view.invalidate();
                    drawChild(canvas, view, getDrawingTime());
                }
            }
            this.currentFrameRate = Float.NaN;
            this.currentFrameRateCategory = Float.NaN;
        }
    }

    public final void notifyLayerIsDirty$ui(OwnedLayer ownedLayer, boolean z) {
        boolean z2 = this.isDrawingContent;
        if (!z) {
            if (z2) {
                return;
            }
            this.dirtyLayers.remove(ownedLayer);
            MutableObjectList<OwnedLayer> mutableObjectList = this.postponedDirtyLayers;
            if (mutableObjectList != null) {
                mutableObjectList.remove(ownedLayer);
            }
        } else if (z2) {
            MutableObjectList<OwnedLayer> mutableObjectList2 = this.postponedDirtyLayers;
            if (mutableObjectList2 == null) {
                mutableObjectList2 = new MutableObjectList<>(0, 1, null);
                this.postponedDirtyLayers = mutableObjectList2;
            }
            mutableObjectList2.add(ownedLayer);
        } else {
            this.dirtyLayers.add(ownedLayer);
        }
    }

    public final void setOnReadyForComposition(Function1<? super ComposeViewContext, Unit> function1) {
        if (AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
            getDerivedIsAttached();
            if (isAttachedToWindow() || this.composeViewContextIncrementedDuringInit) {
                function1.invoke(getComposeViewContext());
                return;
            } else {
                this.onReadyForComposition = function1;
                return;
            }
        }
        if (getViewTreeOwners() != null) {
            function1.invoke(getComposeViewContext());
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onReadyForComposition = function1;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui = this.contentCaptureManager.boundsUpdatesEventLoop$ui(continuation);
        return boundsUpdatesEventLoop$ui == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui : Unit.INSTANCE;
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui(continuation);
        return boundsUpdatesEventLoop$ui == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, layoutNode, false, 2, null);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            invalidateLayoutNodeMeasurement(layoutNodeArr[i]);
        }
    }

    private final void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            invalidateLayers(layoutNodeArr[i]);
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // androidx.compose.ui.node.Owner
    public void invalidateRootLayer() {
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        Lifecycle lifecycle2;
        LifecycleOwner lifecycleOwner2;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        setAttached(true);
        if (Build.VERSION.SDK_INT < 30) {
            setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
        }
        if (ComposeView_androidKt.getAreWindowInsetsRulersEnabled()) {
            this.insetsListener.onViewAttachedToWindow(this);
        }
        Companion.addNotificationForSysPropsChange(this);
        if (!this.composeViewContextIncrementedDuringInit) {
            getComposeViewContext().incrementViewCount$ui();
        }
        this.composeViewContextIncrementedDuringInit = false;
        if (!AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
            this._windowInfo.setWindowFocused(hasWindowFocus());
            this._windowInfo.setOnInitializeContainerSize(new Function0<DerivedSize>() { // from class: androidx.compose.ui.platform.AndroidComposeView$onAttachedToWindow$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DerivedSize invoke() {
                    return AndroidWindowInfo_androidKt.calculateWindowSize(AndroidComposeView.this);
                }
            });
            updateWindowMetrics();
        }
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        Lifecycle lifecycle3 = null;
        if (AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
            ForgetfulRetainedValuesStore installLocalRetainedValuesStore = installLocalRetainedValuesStore(getComposeViewContext().getLifecycleOwner$ui(), getComposeViewContext().getViewModelStoreOwner$ui());
            if (installLocalRetainedValuesStore == null) {
                installLocalRetainedValuesStore = ForgetfulRetainedValuesStore.INSTANCE;
            }
            this.retainedValuesStore = installLocalRetainedValuesStore;
            Function1<? super ComposeViewContext, Unit> function1 = this.onReadyForComposition;
            if (function1 != null) {
                function1.invoke(getComposeViewContext());
                this.onReadyForComposition = null;
            }
            lifecycle2 = getComposeViewContext().getLifecycleOwner$ui().getLifecycle();
        } else {
            AndroidComposeView androidComposeView = this;
            LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(androidComposeView);
            SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(androidComposeView);
            ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(androidComposeView);
            ForgetfulRetainedValuesStore installLocalRetainedValuesStore2 = installLocalRetainedValuesStore(lifecycleOwner3, viewModelStoreOwner);
            if (installLocalRetainedValuesStore2 == null) {
                installLocalRetainedValuesStore2 = ForgetfulRetainedValuesStore.INSTANCE;
            }
            this.retainedValuesStore = installLocalRetainedValuesStore2;
            ViewTreeOwners viewTreeOwners = getViewTreeOwners();
            if (viewTreeOwners == null || (lifecycleOwner3 != null && savedStateRegistryOwner != null && (lifecycleOwner3 != viewTreeOwners.getLifecycleOwner() || savedStateRegistryOwner != viewTreeOwners.getSavedStateRegistryOwner() || viewModelStoreOwner != viewTreeOwners.getViewModelStoreOwner()))) {
                if (lifecycleOwner3 == null) {
                    throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
                }
                if (savedStateRegistryOwner == null) {
                    throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
                }
                if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                    lifecycle.removeObserver(this);
                }
                lifecycleOwner3.getLifecycle().addObserver(this);
                set_viewTreeOwners(new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner, viewModelStoreOwner));
                Function1<? super ComposeViewContext, Unit> function12 = this.onReadyForComposition;
                if (function12 != null) {
                    function12.invoke(getComposeViewContext());
                }
                this.onReadyForComposition = null;
            }
            ViewTreeOwners viewTreeOwners2 = getViewTreeOwners();
            if (viewTreeOwners2 != null && (lifecycleOwner2 = viewTreeOwners2.getLifecycleOwner()) != null) {
                lifecycle3 = lifecycleOwner2.getLifecycle();
            }
            if (lifecycle3 == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
                throw new KotlinNothingValueException();
            }
            lifecycle2 = lifecycle3;
        }
        lifecycle2.addObserver(this);
        lifecycle2.addObserver(this.contentCaptureManager);
        this._inputModeManager.m6163setInputModeiuPiT84(isInTouchMode() ? InputMode.Companion.m6159getTouchaOaMEAU() : InputMode.Companion.m6158getKeyboardaOaMEAU());
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        getViewTreeObserver().addOnScrollChangedListener(this);
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(this);
        }
        AndroidAutofillManager androidAutofillManager = this._autofillManager;
        if (androidAutofillManager != null) {
            getFocusOwner().getListeners().add(androidAutofillManager);
            getSemanticsOwner().getListeners$ui().add(androidAutofillManager);
        }
        getFocusOwner().getListeners().add(this);
    }

    private final RetainedValuesStore installLocalRetainedValuesStore(LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner) {
        LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler = this.frameEndScheduler;
        if (lifecycleOwner == null || viewModelStoreOwner == null || frameEndScheduler == null) {
            return null;
        }
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry orCreateRetainedValuesStoreEntry = ((LifecycleRetainedValuesStoreOwner) ViewModelProvider.Companion.create$default(ViewModelProvider.Companion, viewModelStoreOwner.getViewModelStore(), new ViewModelProvider.NewInstanceFactory(), (CreationExtras) null, 4, (Object) null).get(Reflection.getOrCreateKotlinClass(LifecycleRetainedValuesStoreOwner.class))).getOrCreateRetainedValuesStoreEntry(((View) parent).getId());
        this.lifecycleRetainedValuesStoreOwnerEntry = orCreateRetainedValuesStoreEntry;
        return orCreateRetainedValuesStoreEntry.getRetainedValuesStore();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner;
        AndroidAutofill androidAutofill;
        super.onDetachedFromWindow();
        setAttached(false);
        if (ComposeView_androidKt.getAreWindowInsetsRulersEnabled()) {
            this.insetsListener.onViewDetachedFromWindow(this);
        }
        View view = this.frameRateCategoryView;
        if (isArrEnabled$ui() && view != null) {
            removeView(view);
        }
        Companion.removeNotificationForSysPropsChange(this);
        getComposeViewContext().decrementViewCount$ui();
        getSnapshotObserver().stopObserving$ui();
        if (AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
            lifecycle = getComposeViewContext().getLifecycleOwner$ui().getLifecycle();
        } else {
            this._windowInfo.setOnInitializeContainerSize(null);
            ViewTreeOwners viewTreeOwners = getViewTreeOwners();
            lifecycle = (viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null) ? null : lifecycleOwner.getLifecycle();
            if (lifecycle == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
                throw new KotlinNothingValueException();
            }
        }
        lifecycle.removeObserver(this.contentCaptureManager);
        lifecycle.removeObserver(this);
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        getViewTreeObserver().removeOnScrollChangedListener(this);
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            retainedValuesStoreEntry.release();
        }
        this.lifecycleRetainedValuesStoreOwnerEntry = null;
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
        }
        AndroidAutofillManager androidAutofillManager = this._autofillManager;
        if (androidAutofillManager != null) {
            getSemanticsOwner().getListeners$ui().remove(androidAutofillManager);
            getFocusOwner().getListeners().remove(androidAutofillManager);
        }
        getRectManager().resetOffsets();
        getRectManager().dispatchCallbacks();
        getRectManager().removeScheduledCallback();
        getFocusOwner().getListeners().remove(this);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        if (!autofillSupported() || viewStructure == null) {
            return;
        }
        AndroidAutofillManager androidAutofillManager = this._autofillManager;
        if (androidAutofillManager != null) {
            androidAutofillManager.populateViewStructure(viewStructure);
        }
        AndroidAutofill androidAutofill = this._autofill;
        if (androidAutofill != null) {
            AndroidAutofill_androidKt.populateViewStructure(androidAutofill, viewStructure);
        }
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        if (autofillSupported()) {
            AndroidAutofillManager androidAutofillManager = this._autofillManager;
            if (androidAutofillManager != null) {
                androidAutofillManager.performAutofill(sparseArray);
            }
            AndroidAutofill androidAutofill = this._autofill;
            if (androidAutofill != null) {
                AndroidAutofill_androidKt.performAutofill(androidAutofill, sparseArray);
            }
        }
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui(jArr, iArr, consumer);
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> longSparseArray) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.onVirtualViewTranslationResponses$ui(androidContentCaptureManager, longSparseArray);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 8) {
            if (motionEvent.isFromSource(4194304)) {
                return handleRotaryEvent(motionEvent);
            }
            return (m7247handleMotionEvent8iAsVTc(motionEvent) & 4) != 0;
        }
        if (motionEvent.isFromSource(2097152)) {
            AndroidIndirectPointerEvent m6595convertToIndirectPointerEventk92h6UU$ui = this.motionEventAdapter.m6595convertToIndirectPointerEventk92h6UU$ui(motionEvent, this.primaryDirectionalMotionAxisOverride);
            if (m6595convertToIndirectPointerEventk92h6UU$ui != null) {
                if (handleIndirectPointerEvent(m6595convertToIndirectPointerEventk92h6UU$ui)) {
                    return true;
                }
            } else {
                getFocusOwner().dispatchIndirectPointerCancel();
                this.indirectPointerNavigationGestureDetector.cancelCurrentEventStream();
                return true;
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    private final boolean handleIndirectPointerEvent(IndirectPointerEvent indirectPointerEvent) {
        boolean dispatchIndirectPointerEvent = getFocusOwner().dispatchIndirectPointerEvent(indirectPointerEvent);
        if (ComposeUiFlags.isIndirectPointerNavigationGestureDetectorEnabled) {
            this.indirectPointerNavigationGestureDetector.onIndirectPointerEvent(indirectPointerEvent, dispatchIndirectPointerEvent);
            return true;
        }
        return dispatchIndirectPointerEvent;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Object m7269boximpl;
        FocusTargetNode activeFocusTargetNode;
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow() || (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent))) {
            return false;
        }
        int m7247handleMotionEvent8iAsVTc = m7247handleMotionEvent8iAsVTc(motionEvent);
        if ((m7247handleMotionEvent8iAsVTc & 2) != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        boolean z = motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5;
        boolean z2 = motionEvent.isFromSource(8194) || motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHPAD);
        if (z && z2) {
            ViewParent parent = getParent();
            View view = parent instanceof View ? (View) parent : null;
            if (view == null || (m7269boximpl = view.getTag(R.id.auto_clear_focus_behavior_tag)) == null) {
                m7269boximpl = AutoClearFocusBehavior.m7269boximpl(AutoClearFocusBehavior.Companion.m7277getDefault4UtRPd4());
            }
            if (Intrinsics.areEqual(m7269boximpl, AutoClearFocusBehavior.m7269boximpl(AutoClearFocusBehavior.Companion.m7276getCursorBased4UtRPd4())) && (activeFocusTargetNode = getFocusOwner().getActiveFocusTargetNode()) != null) {
                if (!LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.requireLayoutCoordinates(activeFocusTargetNode)).m5129containsk4lQ0M(Offset.m5095constructorimpl((Float.floatToRawIntBits(motionEvent.getX()) << 32) | (Float.floatToRawIntBits(motionEvent.getY()) & 4294967295L)))) {
                    FocusManager.clearFocus$default(getFocusOwner(), false, 1, null);
                }
            }
        }
        return (m7247handleMotionEvent8iAsVTc & 1) != 0;
    }

    private final boolean handleRotaryEvent(final MotionEvent motionEvent) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f = -motionEvent.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()) * f, f * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), motionEvent.getEventTime(), motionEvent.getDeviceId()), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$handleRotaryEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean dispatchGenericMotionEvent;
                dispatchGenericMotionEvent = super/*android.view.ViewGroup*/.dispatchGenericMotionEvent(motionEvent);
                return Boolean.valueOf(dispatchGenericMotionEvent);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:4:0x001a, B:6:0x0023, B:16:0x003c, B:36:0x0082, B:39:0x008b, B:40:0x008e, B:42:0x0092, B:44:0x0098, B:46:0x009c, B:48:0x00a2, B:50:0x00a8, B:53:0x00b0, B:54:0x00b6, B:56:0x00bc, B:58:0x00c2, B:60:0x00c8, B:62:0x00ce, B:64:0x00d2, B:65:0x00d6, B:71:0x00e9, B:73:0x00ed, B:75:0x00f4, B:82:0x0104, B:83:0x0109, B:84:0x010e), top: B:96:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:4:0x001a, B:6:0x0023, B:16:0x003c, B:36:0x0082, B:39:0x008b, B:40:0x008e, B:42:0x0092, B:44:0x0098, B:46:0x009c, B:48:0x00a2, B:50:0x00a8, B:53:0x00b0, B:54:0x00b6, B:56:0x00bc, B:58:0x00c2, B:60:0x00c8, B:62:0x00ce, B:64:0x00d2, B:65:0x00d6, B:71:0x00e9, B:73:0x00ed, B:75:0x00f4, B:82:0x0104, B:83:0x0109, B:84:0x010e), top: B:96:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c8 A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:4:0x001a, B:6:0x0023, B:16:0x003c, B:36:0x0082, B:39:0x008b, B:40:0x008e, B:42:0x0092, B:44:0x0098, B:46:0x009c, B:48:0x00a2, B:50:0x00a8, B:53:0x00b0, B:54:0x00b6, B:56:0x00bc, B:58:0x00c2, B:60:0x00c8, B:62:0x00ce, B:64:0x00d2, B:65:0x00d6, B:71:0x00e9, B:73:0x00ed, B:75:0x00f4, B:82:0x0104, B:83:0x0109, B:84:0x010e), top: B:96:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d2 A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:4:0x001a, B:6:0x0023, B:16:0x003c, B:36:0x0082, B:39:0x008b, B:40:0x008e, B:42:0x0092, B:44:0x0098, B:46:0x009c, B:48:0x00a2, B:50:0x00a8, B:53:0x00b0, B:54:0x00b6, B:56:0x00bc, B:58:0x00c2, B:60:0x00c8, B:62:0x00ce, B:64:0x00d2, B:65:0x00d6, B:71:0x00e9, B:73:0x00ed, B:75:0x00f4, B:82:0x0104, B:83:0x0109, B:84:0x010e), top: B:96:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ed A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:4:0x001a, B:6:0x0023, B:16:0x003c, B:36:0x0082, B:39:0x008b, B:40:0x008e, B:42:0x0092, B:44:0x0098, B:46:0x009c, B:48:0x00a2, B:50:0x00a8, B:53:0x00b0, B:54:0x00b6, B:56:0x00bc, B:58:0x00c2, B:60:0x00c8, B:62:0x00ce, B:64:0x00d2, B:65:0x00d6, B:71:0x00e9, B:73:0x00ed, B:75:0x00f4, B:82:0x0104, B:83:0x0109, B:84:0x010e), top: B:96:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0104 A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:4:0x001a, B:6:0x0023, B:16:0x003c, B:36:0x0082, B:39:0x008b, B:40:0x008e, B:42:0x0092, B:44:0x0098, B:46:0x009c, B:48:0x00a2, B:50:0x00a8, B:53:0x00b0, B:54:0x00b6, B:56:0x00bc, B:58:0x00c2, B:60:0x00c8, B:62:0x00ce, B:64:0x00d2, B:65:0x00d6, B:71:0x00e9, B:73:0x00ed, B:75:0x00f4, B:82:0x0104, B:83:0x0109, B:84:0x010e), top: B:96:0x001a }] */
    /* renamed from: handleMotionEvent-8iAsVTc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m7247handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        AndroidComposeView androidComposeView;
        int i;
        MotionEvent motionEvent3;
        int pointerId;
        boolean z;
        MotionEvent motionEvent4;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            boolean z2 = true;
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent5 = this.previousMotionEvent;
                boolean z3 = motionEvent5 != null && motionEvent5.getToolType(0) == 3;
                if (motionEvent5 != null) {
                    try {
                        if (hasChangedDevices(motionEvent, motionEvent5)) {
                            if (isDevicePressEvent(motionEvent5)) {
                                this.pointerInputEventProcessor.processCancel();
                            } else if (motionEvent5.getActionMasked() != 10 && z3) {
                                sendSimulatedEvent$default(this, motionEvent5, 10, motionEvent5.getEventTime(), false, 8, null);
                                motionEvent2 = motionEvent5;
                                boolean z4 = motionEvent.getToolType(0) != 3;
                                if (z3 && z4 && actionMasked != 3 && actionMasked != 9 && isInBounds(motionEvent)) {
                                    i = 9;
                                    androidComposeView = this;
                                    sendSimulatedEvent$default(androidComposeView, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                                } else {
                                    androidComposeView = this;
                                    i = 9;
                                }
                                if (motionEvent2 != null) {
                                    motionEvent2.recycle();
                                }
                                motionEvent3 = androidComposeView.previousMotionEvent;
                                if (motionEvent3 != null && motionEvent3.getAction() == 10) {
                                    MotionEvent motionEvent6 = androidComposeView.previousMotionEvent;
                                    pointerId = motionEvent6 == null ? motionEvent6.getPointerId(0) : -1;
                                    if (motionEvent.getAction() == i || motionEvent.getHistorySize() != 0) {
                                        if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                                            MotionEvent motionEvent7 = androidComposeView.previousMotionEvent;
                                            float x = motionEvent7 == null ? motionEvent7.getX() : Float.NaN;
                                            MotionEvent motionEvent8 = androidComposeView.previousMotionEvent;
                                            z = x == motionEvent.getX() || (motionEvent8 != null ? motionEvent8.getY() : Float.NaN) != motionEvent.getY();
                                            motionEvent4 = androidComposeView.previousMotionEvent;
                                            if ((motionEvent4 == null ? motionEvent4.getEventTime() : -1L) != motionEvent.getEventTime()) {
                                                z2 = false;
                                            }
                                            if (!z || z2) {
                                                if (pointerId >= 0) {
                                                    androidComposeView.motionEventAdapter.endStream(pointerId);
                                                }
                                                androidComposeView.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
                                            }
                                        }
                                    } else if (pointerId >= 0) {
                                        androidComposeView.motionEventAdapter.endStream(pointerId);
                                    }
                                }
                                androidComposeView.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                                int m7252sendMotionEvent8iAsVTc = m7252sendMotionEvent8iAsVTc(motionEvent);
                                Trace.endSection();
                                androidComposeView.forceUseMatrixCache = false;
                                return m7252sendMotionEvent8iAsVTc;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        Trace.endSection();
                        throw th;
                    }
                }
                motionEvent2 = motionEvent5;
                if (motionEvent.getToolType(0) != 3) {
                }
                if (z3) {
                }
                androidComposeView = this;
                i = 9;
                if (motionEvent2 != null) {
                }
                motionEvent3 = androidComposeView.previousMotionEvent;
                if (motionEvent3 != null) {
                    MotionEvent motionEvent62 = androidComposeView.previousMotionEvent;
                    if (motionEvent62 == null) {
                    }
                    if (motionEvent.getAction() == i) {
                    }
                    if (motionEvent.getAction() == 0) {
                        MotionEvent motionEvent72 = androidComposeView.previousMotionEvent;
                        if (motionEvent72 == null) {
                        }
                        MotionEvent motionEvent82 = androidComposeView.previousMotionEvent;
                        if (motionEvent82 != null) {
                        }
                        if (x == motionEvent.getX()) {
                        }
                        motionEvent4 = androidComposeView.previousMotionEvent;
                        if ((motionEvent4 == null ? motionEvent4.getEventTime() : -1L) != motionEvent.getEventTime()) {
                        }
                        if (!z) {
                        }
                        if (pointerId >= 0) {
                        }
                        androidComposeView.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
                    }
                }
                androidComposeView.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int m7252sendMotionEvent8iAsVTc2 = m7252sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                androidComposeView.forceUseMatrixCache = false;
                return m7252sendMotionEvent8iAsVTc2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            this.forceUseMatrixCache = false;
            throw th3;
        }
    }

    private final boolean hasChangedDevices(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent motionEvent) {
        int actionMasked;
        return motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* renamed from: sendMotionEvent-8iAsVTc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m7252sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        PointerInputEventData pointerInputEventData2;
        int m6708processBIzXfog;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            if (AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
                getComposeViewContext().getWindowInfo$ui().m7327setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m6749constructorimpl(motionEvent.getMetaState()));
            } else {
                this._windowInfo.m7327setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m6749constructorimpl(motionEvent.getMetaState()));
            }
        }
        AndroidComposeView androidComposeView = this;
        PointerInputEvent convertToPointerInputEvent$ui = this.motionEventAdapter.convertToPointerInputEvent$ui(motionEvent, androidComposeView);
        int actionMasked = motionEvent.getActionMasked();
        if (convertToPointerInputEvent$ui != null) {
            List<PointerInputEventData> pointers = convertToPointerInputEvent$ui.getPointers();
            int size = pointers.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    pointerInputEventData = pointers.get(size);
                    if (pointerInputEventData.getDown() && (actionMasked == 0 || actionMasked == 5)) {
                        break;
                    } else if (i < 0) {
                        break;
                    } else {
                        size = i;
                    }
                }
                pointerInputEventData2 = pointerInputEventData;
                if (pointerInputEventData2 != null) {
                    this.lastDownPointerPosition = pointerInputEventData2.m6703getPositionF1C5BW0();
                }
                m6708processBIzXfog = this.pointerInputEventProcessor.m6708processBIzXfog(convertToPointerInputEvent$ui, androidComposeView, isInBounds(motionEvent));
                convertToPointerInputEvent$ui.setMotionEvent(null);
                if ((actionMasked != 0 || actionMasked == 5) && (m6708processBIzXfog & 1) == 0) {
                    this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    return m6708processBIzXfog;
                }
                return m6708processBIzXfog;
            }
            pointerInputEventData = null;
            pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
            }
            m6708processBIzXfog = this.pointerInputEventProcessor.m6708processBIzXfog(convertToPointerInputEvent$ui, androidComposeView, isInBounds(motionEvent));
            convertToPointerInputEvent$ui.setMotionEvent(null);
            if (actionMasked != 0) {
            }
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            return m6708processBIzXfog;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int i, long j, boolean z) {
        int actionMasked = motionEvent.getActionMasked();
        int i2 = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i2 = motionEvent.getActionIndex();
            }
        } else if (i != 9 && i != 10) {
            i2 = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (i2 >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerPropertiesArr[i3] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i4 = 0; i4 < pointerCount; i4++) {
            pointerCoordsArr[i4] = new MotionEvent.PointerCoords();
        }
        int i5 = 0;
        while (i5 < pointerCount) {
            int i6 = ((i2 < 0 || i5 < i2) ? 0 : 1) + i5;
            motionEvent.getPointerProperties(i6, pointerPropertiesArr[i5]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i5];
            motionEvent.getPointerCoords(i6, pointerCoords);
            float f = pointerCoords.x;
            long mo6767localToScreenMKHz9U = mo6767localToScreenMKHz9U(Offset.m5095constructorimpl((Float.floatToRawIntBits(pointerCoords.y) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
            pointerCoords.x = Float.intBitsToFloat((int) (mo6767localToScreenMKHz9U >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (mo6767localToScreenMKHz9U & 4294967295L));
            i5++;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j : motionEvent.getDownTime(), j, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        AndroidComposeView androidComposeView = this;
        PointerInputEvent convertToPointerInputEvent$ui = this.motionEventAdapter.convertToPointerInputEvent$ui(obtain, androidComposeView);
        Intrinsics.checkNotNull(convertToPointerInputEvent$ui);
        this.pointerInputEventProcessor.m6708processBIzXfog(convertToPointerInputEvent$ui, androidComposeView, true);
        obtain.recycle();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.composeAccessibilityDelegate.m7263canScroll0AR0LA0$ui(false, i, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.composeAccessibilityDelegate.m7263canScroll0AR0LA0$ui(true, i, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo6767localToScreenMKHz9U(long j) {
        recalculateWindowPosition();
        long m5598mapMKHz9U = Matrix.m5598mapMKHz9U(this.viewToWindowMatrix, j);
        float intBitsToFloat = Float.intBitsToFloat((int) (m5598mapMKHz9U & 4294967295L)) + Float.intBitsToFloat((int) (this.windowPosition & 4294967295L));
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(intBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (m5598mapMKHz9U >> 32)) + Float.intBitsToFloat((int) (this.windowPosition >> 32))) << 32));
    }

    @Override // androidx.compose.ui.input.pointer.MatrixPositionCalculator
    /* renamed from: localToScreen-58bKbWc */
    public void mo6591localToScreen58bKbWc(float[] fArr) {
        recalculateWindowPosition();
        Matrix.m5611timesAssign58bKbWc(fArr, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m7265access$preTranslatecG2Xzmc(fArr, Float.intBitsToFloat((int) (this.windowPosition >> 32)), Float.intBitsToFloat((int) (this.windowPosition & 4294967295L)), this.tmpMatrix);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo6768screenToLocalMKHz9U(long j) {
        recalculateWindowPosition();
        float intBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (this.windowPosition & 4294967295L));
        return Matrix.m5598mapMKHz9U(this.windowToViewMatrix, Offset.m5095constructorimpl((Float.floatToRawIntBits(intBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (this.windowPosition >> 32))) << 32)));
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            AndroidComposeView androidComposeView = this;
            while (parent instanceof ViewGroup) {
                androidComposeView = (View) parent;
                parent = ((ViewGroup) androidComposeView).getParent();
            }
            androidComposeView.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            androidComposeView.getLocationInWindow(iArr);
            int[] iArr2 = this.tmpPositionArray;
            this.windowPosition = Offset.m5095constructorimpl((Float.floatToRawIntBits(iArr[0] - iArr2[0]) << 32) | (Float.floatToRawIntBits(iArr[1] - iArr2[1]) & 4294967295L));
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        float[] fArr = this.viewToWindowMatrix;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        long m5598mapMKHz9U = Matrix.m5598mapMKHz9U(fArr, Offset.m5095constructorimpl((Float.floatToRawIntBits(y) & 4294967295L) | (Float.floatToRawIntBits(x) << 32)));
        this.windowPosition = Offset.m5095constructorimpl((Float.floatToRawIntBits(motionEvent.getRawX() - Float.intBitsToFloat((int) (m5598mapMKHz9U >> 32))) << 32) | (Float.floatToRawIntBits(motionEvent.getRawY() - Float.intBitsToFloat((int) (m5598mapMKHz9U & 4294967295L))) & 4294967295L));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo7279calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m7318invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void updateWindowMetrics() {
        MutableState access$get_containerSize$p = LazyWindowInfo.access$get_containerSize$p(this._windowInfo);
        if (access$get_containerSize$p != null) {
            access$get_containerSize$p.setValue(AndroidWindowInfo_androidKt.calculateWindowSize(this));
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m4789getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return getLegacyTextInputServiceAndroid().isEditorFocused();
        }
        return androidPlatformTextInputSession.isReadyForConnection();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m4789getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return getLegacyTextInputServiceAndroid().createInputConnection(editorInfo);
        }
        return androidPlatformTextInputSession.createInputConnection(editorInfo);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo7199calculateLocalPositionMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m5598mapMKHz9U(this.windowToViewMatrix, j);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo7200calculatePositionInWindowMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m5598mapMKHz9U(this.viewToWindowMatrix, j);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateConfiguration(configuration);
    }

    private final void dispatchConfigurationChangeIfNeeded() {
        int i = Build.VERSION.SDK_INT;
        if (32 > i || i >= 34) {
            return;
        }
        updateConfiguration(getResources().getConfiguration());
    }

    private final void updateConfiguration(Configuration configuration) {
        Configuration configuration2 = getConfiguration();
        if (Intrinsics.areEqual(configuration2, configuration)) {
            return;
        }
        setConfiguration(new Configuration(configuration));
        if (configuration2.fontScale != configuration.fontScale || configuration2.densityDpi != configuration.densityDpi) {
            setDensity(AndroidDensity_androidKt.Density(getContext()));
        }
        if (AndroidComposeView_androidKt.access$diffForWindowMetricsChanged(configuration2, configuration)) {
            updateWindowMetrics();
        }
        if (AndroidComposeUiFlags.isSharedFontEnabled || getFontWeightAdjustmentCompat(configuration2) == getFontWeightAdjustmentCompat(configuration)) {
            return;
        }
        setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(i);
            if (layoutDirection == null) {
                layoutDirection = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection);
        }
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (!isBadMotionEvent(motionEvent) && isAttachedToWindow()) {
            this.composeAccessibilityDelegate.dispatchHoverEvent$ui(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 7) {
                if (actionMasked == 10 && isInBounds(motionEvent)) {
                    if (motionEvent.getToolType(0) != 3 || motionEvent.getButtonState() == 0) {
                        MotionEvent motionEvent2 = this.previousMotionEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                        this.hoverExitReceived = true;
                        postDelayed(this.sendHoverExitEvent, 8L);
                        return false;
                    }
                    return false;
                }
            } else if (!isPositionChanged(motionEvent)) {
                return false;
            }
            if ((m7247handleMotionEvent8iAsVTc(motionEvent) & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean isBadMotionEvent(MotionEvent motionEvent) {
        boolean z = (Float.floatToRawIntBits(motionEvent.getX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawY()) & Integer.MAX_VALUE) >= 2139095040;
        if (!z) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 1; i < pointerCount; i++) {
                z = (Float.floatToRawIntBits(motionEvent.getX(i)) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY(i)) & Integer.MAX_VALUE) >= 2139095040 || (Build.VERSION.SDK_INT >= 29 && !MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(motionEvent, i));
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    private final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        return (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.previousMotionEvent) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) ? false : true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int i, View view) {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("getAccessibilityViewId", new Class[0]);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(view, new Object[0]), Integer.valueOf(i))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i, viewGroup.getChildAt(i2));
                    if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                        return findViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public android.view.PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        PointerIcon stylusHoverIcon;
        int toolType = motionEvent.getToolType(i);
        if (!motionEvent.isFromSource(8194) && motionEvent.isFromSource(InputDeviceCompat.SOURCE_STYLUS) && ((toolType == 2 || toolType == 4) && (stylusHoverIcon = getPointerIconService().getStylusHoverIcon()) != null)) {
            return AndroidComposeViewVerificationHelperMethodsN.INSTANCE.toAndroidPointerIcon(getContext(), stylusHoverIcon);
        }
        return super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int i) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(this, Integer.valueOf(i));
                if (invoke instanceof View) {
                    return (View) invoke;
                }
                return null;
            }
            return findViewByAccessibilityIdRootedAtCurrentView(i, this);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        Lifecycle.State state = null;
        if (AndroidComposeUiFlags.isSharedWindowInfoEnabled) {
            lifecycleOwner = getComposeViewContext().getLifecycleOwner$ui();
        } else {
            ViewTreeOwners viewTreeOwners = getViewTreeOwners();
            lifecycleOwner = viewTreeOwners != null ? viewTreeOwners.getLifecycleOwner() : null;
        }
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            state = lifecycle.getCurrentState();
        }
        return state == Lifecycle.State.RESUMED;
    }

    @Override // androidx.compose.ui.node.Owner
    public void incrementSensitiveComponentCount() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (this.sensitiveComponentCount == 0) {
                AndroidComposeViewSensitiveContent35.INSTANCE.setContentSensitivity(getView(), true);
            }
            this.sensitiveComponentCount++;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void decrementSensitiveComponentCount() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (this.sensitiveComponentCount == 1) {
                AndroidComposeViewSensitiveContent35.INSTANCE.setContentSensitivity(getView(), false);
            }
            this.sensitiveComponentCount--;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void incrementKeepScreenOnCount() {
        this.keepScreenOnCount++;
        getView().setKeepScreenOn(this.keepScreenOnCount > 0);
    }

    @Override // androidx.compose.ui.node.Owner
    public void decrementKeepScreenOnCount() {
        this.keepScreenOnCount--;
        getView().setKeepScreenOn(this.keepScreenOnCount > 0);
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidComposeView getOutOfFrameExecutor() {
        if (isAttachedToWindow()) {
            return this;
        }
        return null;
    }

    @Override // androidx.compose.ui.node.OutOfFrameExecutor
    public void schedule(Function0<Unit> function0) {
        boolean isEmpty = this.outOfFrameQueue.isEmpty();
        this.outOfFrameQueue.addLast(function0);
        if (isEmpty) {
            Handler handler = getHandler();
            if (handler == null) {
                throw new IllegalArgumentException("schedule is called when outOfFrameExecutor is not available (view is detached)".toString());
            }
            handler.postAtFrontOfQueue(this.outOfFrameRunnable);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void voteFrameRate(float f) {
        if (isArrEnabled$ui()) {
            if (f > 0.0f) {
                if (Float.isNaN(this.currentFrameRate) || f > this.currentFrameRate) {
                    this.currentFrameRate = f;
                }
            } else if (f < 0.0f) {
                if (Float.isNaN(this.currentFrameRateCategory) || f < this.currentFrameRateCategory) {
                    this.currentFrameRateCategory = f;
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: dispatchOnScrollChanged-k-4lQ0M */
    public void mo7201dispatchOnScrollChangedk4lQ0M(long j) {
        Companion.dispatchOnScrollChanged(getViewTreeObserver());
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.lastMatrixRecalculationAnimationTime = 0L;
        updatePositionCacheAndDispatch();
        dispatchConfigurationChangeIfNeeded();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        updatePositionCacheAndDispatch();
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        this._inputModeManager.m6163setInputModeiuPiT84(z ? InputMode.Companion.m6159getTouchaOaMEAU() : InputMode.Companion.m6158getKeyboardaOaMEAU());
    }

    @Override // androidx.compose.ui.spatial.ExecuteDelayed
    public Object executeDelayed(long j, final Function0<Unit> function0) {
        Runnable runnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        postDelayed(runnable, j);
        return runnable;
    }

    @Override // androidx.compose.ui.spatial.ExecuteDelayed
    public void removeDelayedExecution(Object obj) {
        Runnable runnable = obj instanceof Runnable ? (Runnable) obj : null;
        if (runnable == null) {
            return;
        }
        removeCallbacks(runnable);
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "<init>", "()V", "systemPropertiesClass", "Ljava/lang/Class;", "getBooleanMethod", "Ljava/lang/reflect/Method;", "addChangeCallbackMethod", "composeViews", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/platform/AndroidComposeView;", "systemPropertiesChangedRunnable", "Ljava/lang/Runnable;", "dispatchOnScrollChangedMethod", "getIsShowingLayoutBounds", "", "addNotificationForSysPropsChange", "", "composeView", "removeNotificationForSysPropsChange", "dispatchOnScrollChanged", "viewTreeObserver", "Landroid/view/ViewTreeObserver;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                }
                if (AndroidComposeView.getBooleanMethod == null) {
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object invoke = method != null ? method.invoke(null, "debug.layout", false) : null;
                return Intrinsics.areEqual((Object) (invoke instanceof Boolean ? invoke : null), (Object) true);
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addNotificationForSysPropsChange(AndroidComposeView androidComposeView) {
            if (Build.VERSION.SDK_INT > 28) {
                if (AndroidComposeView.systemPropertiesChangedRunnable == null) {
                    Runnable runnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$Companion$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AndroidComposeView.Companion.addNotificationForSysPropsChange$lambda$0();
                        }
                    };
                    AndroidComposeView.systemPropertiesChangedRunnable = runnable;
                    StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
                    try {
                        if (AndroidComposeView.systemPropertiesClass == null) {
                            AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                        }
                        if (AndroidComposeView.addChangeCallbackMethod == null) {
                            StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
                            Class cls = AndroidComposeView.systemPropertiesClass;
                            AndroidComposeView.addChangeCallbackMethod = cls != null ? cls.getDeclaredMethod("addChangeCallback", Runnable.class) : null;
                        }
                        Method method = AndroidComposeView.addChangeCallbackMethod;
                        if (method != null) {
                            method.invoke(null, runnable);
                        }
                    } catch (Throwable unused) {
                    }
                    StrictMode.setVmPolicy(vmPolicy);
                }
                synchronized (AndroidComposeView.composeViews) {
                    AndroidComposeView.composeViews.add(androidComposeView);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void addNotificationForSysPropsChange$lambda$0() {
            synchronized (AndroidComposeView.composeViews) {
                int i = 0;
                if (Build.VERSION.SDK_INT < 30) {
                    MutableObjectList mutableObjectList = AndroidComposeView.composeViews;
                    Object[] objArr = mutableObjectList.content;
                    int i2 = mutableObjectList._size;
                    while (i < i2) {
                        final AndroidComposeView androidComposeView = (AndroidComposeView) objArr[i];
                        boolean showLayoutBounds = androidComposeView.getShowLayoutBounds();
                        androidComposeView.setShowLayoutBounds(AndroidComposeView.Companion.getIsShowingLayoutBounds());
                        if (showLayoutBounds != androidComposeView.getShowLayoutBounds()) {
                            androidComposeView.post(new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$Companion$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AndroidComposeView.this.invalidateDescendants();
                                }
                            });
                        }
                        i++;
                    }
                } else {
                    MutableObjectList mutableObjectList2 = AndroidComposeView.composeViews;
                    Object[] objArr2 = mutableObjectList2.content;
                    int i3 = mutableObjectList2._size;
                    while (i < i3) {
                        final AndroidComposeView androidComposeView2 = (AndroidComposeView) objArr2[i];
                        androidComposeView2.post(new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$Companion$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AndroidComposeView.this.invalidateDescendants();
                            }
                        });
                        i++;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeNotificationForSysPropsChange(AndroidComposeView androidComposeView) {
            if (Build.VERSION.SDK_INT > 28) {
                synchronized (AndroidComposeView.composeViews) {
                    AndroidComposeView.composeViews.remove(androidComposeView);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final void dispatchOnScrollChanged(ViewTreeObserver viewTreeObserver) {
            try {
                if (AndroidComposeView.dispatchOnScrollChangedMethod == null) {
                    Method declaredMethod = viewTreeObserver.getClass().getDeclaredMethod("dispatchOnScrollChanged", new Class[0]);
                    declaredMethod.setAccessible(true);
                    AndroidComposeView.dispatchOnScrollChangedMethod = declaredMethod;
                }
                Method method = AndroidComposeView.dispatchOnScrollChangedMethod;
                if (method != null) {
                    method.invoke(viewTreeObserver, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/lifecycle/ViewModelStoreOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "getViewModelStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;
        private final ViewModelStoreOwner viewModelStoreOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            this.viewModelStoreOwner = viewModelStoreOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }

        public final ViewModelStoreOwner getViewModelStoreOwner() {
            return this.viewModelStoreOwner;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0007¢\u0006\u0004\b\t\u0010\nJ#\u00103\u001a\u000204*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\f\u0010?\u001a\u00020-*\u00020@H\u0016J&\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020C2\u000e\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0EH\u0096@¢\u0006\u0002\u0010GJ\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0016J\u0017\u0010M\u001a\u00020I2\u0006\u0010J\u001a\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020NH\u0016¢\u0006\u0004\bR\u0010PR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R(\u0010*\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.¢\u0006\u000e\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u0010<\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006S"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$RootModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/relocation/BringIntoViewModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/layout/WindowInsetsRulerProvider;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "insetsValues", "Landroidx/collection/ScatterMap;", "", "Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "getInsetsValues", "()Landroidx/collection/ScatterMap;", "generation", "Landroidx/compose/runtime/MutableIntState;", "getGeneration", "()Landroidx/compose/runtime/MutableIntState;", "previousGeneration", "", "getPreviousGeneration", "()I", "setPreviousGeneration", "(I)V", "cutoutRects", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Rect;", "getCutoutRects", "()Landroidx/collection/MutableObjectList;", "cutoutRulers", "", "Landroidx/compose/ui/layout/RectRulers;", "getCutoutRulers", "()Ljava/util/List;", "insetsListener", "Landroidx/compose/ui/layout/InsetsListener;", "getInsetsListener", "()Landroidx/compose/ui/layout/InsetsListener;", "rulerLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulerLambda$annotations", "()V", "getRulerLambda", "()Lkotlin/jvm/functions/Function1;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "traverseKey", "getTraverseKey", "()Ljava/lang/Object;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "bringIntoView", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRotaryScrollEvent", "", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "onPreRotaryScrollEvent", "onPreKeyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onPreKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onKeyEvent", "onKeyEvent-ZmokQxo", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class RootModifierNode extends Modifier.Node implements BringIntoViewModifierNode, SemanticsModifierNode, RotaryInputModifierNode, KeyInputModifierNode, LayoutModifierNode, TraversableNode, WindowInsetsRulerProvider {
        private int previousGeneration = -1;
        private final Function1<RulerScope, Unit> rulerLambda = new Function1<RulerScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$RootModifierNode$rulerLambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RulerScope rulerScope) {
                invoke2(rulerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RulerScope rulerScope) {
                AndroidComposeView.RootModifierNode rootModifierNode = AndroidComposeView.RootModifierNode.this;
                rootModifierNode.setPreviousGeneration(rootModifierNode.getGeneration().getIntValue());
                if (AndroidComposeView.RootModifierNode.this.getPreviousGeneration() <= 0 || !ComposeView_androidKt.getAreWindowInsetsRulersEnabled()) {
                    return;
                }
                WindowInsetsRulers_androidKt.provideWindowInsetsRulers(rulerScope, AndroidComposeView.RootModifierNode.this);
            }
        };

        public static /* synthetic */ void getRulerLambda$annotations() {
        }

        @Override // androidx.compose.ui.node.SemanticsModifierNode
        public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        }

        @Override // androidx.compose.ui.input.key.KeyInputModifierNode
        /* renamed from: onPreKeyEvent-ZmokQxo */
        public boolean mo258onPreKeyEventZmokQxo(KeyEvent keyEvent) {
            return false;
        }

        @Override // androidx.compose.ui.input.rotary.RotaryInputModifierNode
        public boolean onPreRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent) {
            return false;
        }

        @Override // androidx.compose.ui.input.rotary.RotaryInputModifierNode
        public boolean onRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent) {
            return false;
        }

        public RootModifierNode() {
        }

        @Override // androidx.compose.ui.layout.WindowInsetsRulerProvider
        public ScatterMap<Object, WindowWindowInsetsAnimationValues> getInsetsValues() {
            return getInsetsListener().getInsetsValues();
        }

        public final MutableIntState getGeneration() {
            return getInsetsListener().getGeneration();
        }

        public final int getPreviousGeneration() {
            return this.previousGeneration;
        }

        public final void setPreviousGeneration(int i) {
            this.previousGeneration = i;
        }

        @Override // androidx.compose.ui.layout.WindowInsetsRulerProvider
        public MutableObjectList<MutableState<android.graphics.Rect>> getCutoutRects() {
            return getInsetsListener().getDisplayCutouts();
        }

        @Override // androidx.compose.ui.layout.WindowInsetsRulerProvider
        public List<RectRulers> getCutoutRulers() {
            return getInsetsListener().getDisplayCutoutRulers();
        }

        @Override // androidx.compose.ui.layout.WindowInsetsRulerProvider
        public InsetsListener getInsetsListener() {
            return AndroidComposeView.this.getInsetsListener();
        }

        public final Function1<RulerScope, Unit> getRulerLambda() {
            return this.rulerLambda;
        }

        @Override // androidx.compose.ui.node.LayoutModifierNode
        /* renamed from: measure-3p2s80s */
        public MeasureResult mo69measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
            final Placeable mo6818measureBRTryo0 = measurable.mo6818measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, mo6818measureBRTryo0.getWidth(), mo6818measureBRTryo0.getHeight(), null, this.rulerLambda, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$RootModifierNode$measure$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }

        @Override // androidx.compose.ui.node.TraversableNode
        public Object getTraverseKey() {
            return WindowInsetsRulers_androidKt.RulerKey;
        }

        @Override // androidx.compose.ui.relocation.BringIntoViewModifierNode
        public Object bringIntoView(LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Continuation<? super Unit> continuation) {
            long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
            Rect invoke = function0.invoke();
            Rect m5140translatek4lQ0M = invoke != null ? invoke.m5140translatek4lQ0M(positionInRoot) : null;
            if (m5140translatek4lQ0M != null) {
                AndroidComposeView.this.requestRectangleOnScreen(RectHelper_androidKt.toAndroidRect(m5140translatek4lQ0M), false);
            }
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.ui.input.key.KeyInputModifierNode
        /* renamed from: onKeyEvent-ZmokQxo */
        public boolean mo256onKeyEventZmokQxo(KeyEvent keyEvent) {
            Boolean mo4997focusSearchULY8qGw;
            final FocusDirection m4991toFocusDirectionZmokQxo = FocusInteropUtils_androidKt.m4991toFocusDirectionZmokQxo(keyEvent);
            if (m4991toFocusDirectionZmokQxo == null || !KeyEventType.m6510equalsimpl0(KeyEvent_androidKt.m6518getTypeZmokQxo(keyEvent), KeyEventType.Companion.m6514getKeyDownCS__XNY())) {
                return false;
            }
            if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
                FocusTargetNode activeFocusTargetNode = AndroidComposeView.this.getFocusOwner().getActiveFocusTargetNode();
                if (activeFocusTargetNode != null && activeFocusTargetNode.isInteropViewHost() && AndroidComposeView.this.mo5044moveFocusInChildren3ESFkO8(m4991toFocusDirectionZmokQxo.m4981unboximpl())) {
                    return true;
                }
                Boolean mo4997focusSearchULY8qGw2 = AndroidComposeView.this.getFocusOwner().mo4997focusSearchULY8qGw(m4991toFocusDirectionZmokQxo.m4981unboximpl(), AndroidComposeView.this.getEmbeddedViewFocusRect(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$RootModifierNode$onKeyEvent$focusWasMovedOrCancelled$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(FocusDirection.this.m4981unboximpl()));
                    }
                });
                if (mo4997focusSearchULY8qGw2 != null ? mo4997focusSearchULY8qGw2.booleanValue() : true) {
                    return true;
                }
                if (FocusOwnerImplKt.m5005is1dFocusSearch3ESFkO8(m4991toFocusDirectionZmokQxo.m4981unboximpl())) {
                    Integer m4990toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(m4991toFocusDirectionZmokQxo.m4981unboximpl());
                    int intValue = m4990toAndroidFocusDirection3ESFkO8 != null ? m4990toAndroidFocusDirection3ESFkO8.intValue() : 2;
                    FocusFinder focusFinder = FocusFinder.getInstance();
                    View rootView = AndroidComposeView.this.getRootView();
                    Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                    View findNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, AndroidComposeView.this.getView(), intValue);
                    if (findNextFocus == null || Intrinsics.areEqual(findNextFocus, AndroidComposeView.this)) {
                        return AndroidComposeView.this.getFocusOwner().mo5000resetFocus3ESFkO8(m4991toFocusDirectionZmokQxo.m4981unboximpl());
                    }
                }
                return false;
            }
            Integer m4990toAndroidFocusDirection3ESFkO82 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(m4991toFocusDirectionZmokQxo.m4981unboximpl());
            if (ComposeUiFlags.isViewFocusFixEnabled && AndroidComposeView.this.hasFocus() && m4990toAndroidFocusDirection3ESFkO82 != null && AndroidComposeView.this.mo5044moveFocusInChildren3ESFkO8(m4991toFocusDirectionZmokQxo.m4981unboximpl())) {
                return true;
            }
            Rect embeddedViewFocusRect = AndroidComposeView.this.getEmbeddedViewFocusRect();
            Boolean mo4997focusSearchULY8qGw3 = AndroidComposeView.this.getFocusOwner().mo4997focusSearchULY8qGw(m4991toFocusDirectionZmokQxo.m4981unboximpl(), embeddedViewFocusRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$RootModifierNode$onKeyEvent$focusWasMovedOrCancelled$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(FocusDirection.this.m4981unboximpl()));
                }
            });
            if (mo4997focusSearchULY8qGw3 != null ? mo4997focusSearchULY8qGw3.booleanValue() : true) {
                return true;
            }
            if (FocusOwnerImplKt.m5005is1dFocusSearch3ESFkO8(m4991toFocusDirectionZmokQxo.m4981unboximpl())) {
                if (m4990toAndroidFocusDirection3ESFkO82 != null) {
                    View findNextNonChildView = AndroidComposeView.this.findNextNonChildView(m4990toAndroidFocusDirection3ESFkO82.intValue());
                    if (Intrinsics.areEqual(findNextNonChildView, AndroidComposeView.this)) {
                        findNextNonChildView = null;
                    }
                    if (findNextNonChildView != null) {
                        android.graphics.Rect androidRect = embeddedViewFocusRect != null ? RectHelper_androidKt.toAndroidRect(embeddedViewFocusRect) : null;
                        if (androidRect != null) {
                            View rootView2 = AndroidComposeView.this.getRootView();
                            Intrinsics.checkNotNull(rootView2, "null cannot be cast to non-null type android.view.ViewGroup");
                            ViewGroup viewGroup = (ViewGroup) rootView2;
                            viewGroup.offsetDescendantRectToMyCoords(AndroidComposeView.this.getView(), androidRect);
                            viewGroup.offsetRectIntoDescendantCoords(findNextNonChildView, androidRect);
                            if (FocusInteropUtils_androidKt.requestInteropFocus(findNextNonChildView, m4990toAndroidFocusDirection3ESFkO82, androidRect)) {
                                return true;
                            }
                        } else {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid rect");
                            throw new KotlinNothingValueException();
                        }
                    }
                }
                if (AndroidComposeView.this.getFocusOwner().mo4994clearFocusI7lrPNg(false, true, false, m4991toFocusDirectionZmokQxo.m4981unboximpl()) && (mo4997focusSearchULY8qGw = AndroidComposeView.this.getFocusOwner().mo4997focusSearchULY8qGw(m4991toFocusDirectionZmokQxo.m4981unboximpl(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$RootModifierNode$onKeyEvent$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(FocusDirection.this.m4981unboximpl()));
                    }
                })) != null) {
                    return mo4997focusSearchULY8qGw.booleanValue();
                }
                return true;
            }
            return false;
        }
    }
}
