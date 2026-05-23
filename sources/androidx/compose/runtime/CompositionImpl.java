package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeList;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.compose.ComposeNavigator;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composition.kt */
@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010R\u001a\u00020OH\u0002J\b\u0010S\u001a\u000206H\u0002J \u0010e\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010_J \u0010g\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010_J \u0010h\u001a\u00020i2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010jJ \u0010k\u001a\u00020i2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010jJ\u001d\u0010l\u001a\u00020Z2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nH\u0000¢\u0006\u0002\bpJ \u0010q\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010_J(\u0010r\u001a\u00020i2\u0006\u0010s\u001a\u00020;2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010tJ \u0010u\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010_J\b\u0010v\u001a\u00020ZH\u0002J\b\u0010w\u001a\u00020;H\u0002J\u0010\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0016J\u000e\u0010|\u001a\u00020Z2\u0006\u0010}\u001a\u00020GJ\b\u0010~\u001a\u00020ZH\u0002J\b\u0010\u007f\u001a\u00020ZH\u0002J\t\u0010\u0080\u0001\u001a\u00020ZH\u0002J!\u0010\u0081\u0001\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0017¢\u0006\u0002\u0010_J\u000f\u0010\u0082\u0001\u001a\u00020ZH\u0000¢\u0006\u0003\b\u0083\u0001J\t\u0010\u0084\u0001\u001a\u00020ZH\u0016J\u0018\u0010\u0087\u0001\u001a\u00020Z2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0018\u0010\u0089\u0001\u001a\u00020;2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0018\u0010\u008a\u0001\u001a\u00020Z2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020Z0YH\u0016J,\u0010\u008c\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110\u008d\u0001022\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0000¢\u0006\u0003\b\u0090\u0001J:\u0010\u0091\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110\u008d\u0001022\u0015\u0010\u0092\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0004\u0012\u00020;0\u0093\u0001H\u0080\b¢\u0006\u0003\b\u0094\u0001J\u001b\u0010\u0095\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u00112\u0007\u0010\u0097\u0001\u001a\u00020;H\u0002J!\u0010\u0095\u0001\u001a\u00020Z2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'2\u0007\u0010\u0097\u0001\u001a\u00020;H\u0002J\t\u0010\u0098\u0001\u001a\u00020ZH\u0002J\u0012\u0010\u0099\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u009b\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009c\u0001\u001a\u00020;H\u0016J)\u0010\u009d\u0001\u001a\u00020Z2\u001e\u0010\u009e\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u009f\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009f\u00010\u008d\u000102H\u0016J\u0012\u0010 \u0001\u001a\u00020Z2\u0007\u0010U\u001a\u00030¡\u0001H\u0016J\u0011\u0010¢\u0001\u001a\u00020Z2\u0006\u00105\u001a\u000206H\u0002J\t\u0010£\u0001\u001a\u00020ZH\u0016J\t\u0010¤\u0001\u001a\u00020ZH\u0016J\t\u0010¥\u0001\u001a\u00020ZH\u0016JL\u0010¦\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u000122\u0010\u008b\u0001\u001a-\u0012!\u0012\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#¢\u0006\u000e\b¨\u0001\u0012\t\b©\u0001\u0012\u0004\b\b(5\u0012\u0005\u0012\u0003H§\u00010\u0093\u0001H\u0082\b¢\u0006\u0003\u0010ª\u0001J(\u0010«\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H§\u00010YH\u0082\b¢\u0006\u0003\u0010¬\u0001J\t\u0010\u00ad\u0001\u001a\u00020ZH\u0016J\t\u0010®\u0001\u001a\u00020ZH\u0016J\t\u0010¯\u0001\u001a\u00020ZH\u0016J;\u0010°\u0001\u001a\u0003H±\u0001\"\u0005\b\u0000\u0010±\u00012\t\u0010²\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010³\u0001\u001a\u00020G2\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H±\u00010YH\u0016¢\u0006\u0003\u0010´\u0001J\u0015\u0010µ\u0001\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001e\u0010¶\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020$2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010º\u0001\u001a\u00020Z2\u0007\u0010¸\u0001\u001a\u00020$H\u0016J)\u0010»\u0001\u001a\u0005\u0018\u0001H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010}\u001a\n\u0012\u0005\u0012\u0003H§\u00010¼\u0001H\u0016¢\u0006\u0003\u0010½\u0001J\u001d\u0010¾\u0001\u001a\u00020;2\u0007\u0010¸\u0001\u001a\u00020$2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010¿\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020$2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J!\u0010À\u0001\u001a\u00020Z2\u0007\u0010¹\u0001\u001a\u00020\u00112\u0007\u0010¸\u0001\u001a\u00020$H\u0000¢\u0006\u0003\bÁ\u0001J\u001b\u0010Â\u0001\u001a\u00020Z2\n\u0010U\u001a\u0006\u0012\u0002\b\u00030.H\u0000¢\u0006\u0003\bÃ\u0001J\u001e\u0010Ä\u0001\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J(\u0010Ç\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H§\u00010YH\u0082\b¢\u0006\u0003\u0010¬\u0001J\n\u0010z\u001a\u0004\u0018\u00010{H\u0002J\t\u0010È\u0001\u001a\u00020ZH\u0016J\u000f\u0010É\u0001\u001a\u00020GH\u0000¢\u0006\u0003\bÊ\u0001R\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00060\u0011j\u0002`\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110'8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110'8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010)R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020$028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001c\u00109\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R \u0010:\u001a\u00020;X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010T\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\bT\u0010>R\u000e\u0010U\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010>R'\u0010X\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[X\u0086\u000e¢\u0006\u0010\n\u0002\u0010`\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010>R\u0014\u0010b\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010>R\u0014\u0010c\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010>R\u0016\u0010\u0085\u0001\u001a\u00020;8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010>¨\u0006Ë\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "Landroidx/compose/runtime/PausableComposition;", "Landroidx/compose/runtime/tooling/ObservableComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "<init>", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;)V", "getParent", "()Landroidx/compose/runtime/CompositionContext;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "getSlotStorage$runtime$annotations", "getSlotStorage$runtime", "()Landroidx/compose/runtime/SlotStorage;", "createSlotStorage", "observations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/collection/MutableScatterMap;", "observedObjects", "", "getObservedObjects$runtime", "()Ljava/util/Set;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/DerivedState;", "derivedStateDependencies", "getDerivedStateDependencies$runtime", "conditionalScopes", "", "getConditionalScopes$runtime", "()Ljava/util/List;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "", "getPendingInvalidScopes$runtime$annotations", "getPendingInvalidScopes$runtime", "()Z", "setPendingInvalidScopes$runtime", "(Z)V", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "pendingPausedComposition", "Landroidx/compose/runtime/PausedCompositionImpl;", "invalidationDelegate", "invalidationDelegateGroup", "", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "composer", "Landroidx/compose/runtime/InternalComposer;", "getComposer$runtime", "()Landroidx/compose/runtime/InternalComposer;", "createComposer", "createChangeList", "isRoot", RemoteConfigConstants.ResponseFieldKey.STATE, "areChildrenComposing", "getAreChildrenComposing", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "isComposing", "isDisposed", "hasPendingChanges", "getHasPendingChanges", "setContent", FirebaseAnalytics.Param.CONTENT, "setContentWithReuse", "setPausableContent", "Landroidx/compose/runtime/PausedComposition;", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "pausedCompositionFinished", "ignoreSet", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RememberObserverHolder;", "pausedCompositionFinished$runtime", "composeInitial", "composeInitialPaused", "reusable", "(ZLkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "composeInitialWithReuse", "ensureRunning", "clearDeactivated", "setObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "invalidateGroupsWithKey", "key", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "drainPendingModificationsOutOfBandLocked", "composeContent", "updateMovingInvalidations", "updateMovingInvalidations$runtime", "dispose", "hasInvalidations", "getHasInvalidations", "recordModificationsOf", "values", "observesAnyOf", "prepareCompose", "block", "extractInvalidationsOf", "Lkotlin/Pair;", "anchor", "Landroidx/compose/runtime/Anchor;", "extractInvalidationsOf$runtime", "extractInvalidationsOfGroup", "inGroup", "Lkotlin/Function1;", "extractInvalidationsOfGroup$runtime", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "cleanUpDerivedStateObservations", "recordReadOf", "invalidateScopeOfLocked", "recordWriteOf", "recompose", "insertMovableContent", "references", "Landroidx/compose/runtime/MovableContentStateReference;", "disposeUnusedMovableContent", "Landroidx/compose/runtime/MovableContentState;", "applyChangesInLocked", "applyChanges", "applyLateChanges", "changesApplied", "guardInvalidationsLocked", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "abandonChanges", "invalidateAll", "verifyConsistent", "delegateInvalidations", "R", TypedValues.TransitionType.S_TO, "groupIndex", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAndSetShouldPauseCallback", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "recomposeScopeReleased", "getCompositionService", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "tryImminentInvalidation", "invalidateChecked", "removeObservation", "removeObservation$runtime", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime", "takeInvalidations", "takeInvalidations-afanTW4", "()Landroidx/collection/MutableScatterMap;", "trackAbandonedValues", "deactivate", "composerStacksSizes", "composerStacksSizes$runtime", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices, PausableComposition, ObservableComposition {
    public static final int $stable = 8;
    private final Applier<?> applier;
    private final Changes changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final InternalComposer composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final MutableScatterMap<Object, Object> derivedStates;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private MutableScatterMap<Object, Object> invalidations;
    private final boolean isRoot;
    private final Changes lateChanges;
    private final MutableScatterMap<Object, Object> observations;
    private final MutableScatterMap<Object, Object> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private PausedCompositionImpl pendingPausedComposition;
    private final RememberEventDispatcher rememberManager;
    private ShouldPauseCallback shouldPause;
    private final SlotStorage slotStorage;
    private int state;
    private final AtomicReference<Object> pendingModifications = new AtomicReference<>(null);
    private final Object lock = new Object();
    private final Set<RememberObserver> abandonSet = new MutableScatterSet(0, 1, null).asMutableSet();

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime$annotations() {
    }

    public static /* synthetic */ void getSlotStorage$runtime$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier) {
        this.parent = compositionContext;
        this.applier = applier;
        SlotStorage createSlotStorage = createSlotStorage();
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            createSlotStorage.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation$runtime()) {
            createSlotStorage.collectSourceInformation();
        }
        this.slotStorage = createSlotStorage;
        this.observations = ScopeMap.m4507constructorimpl$default(null, 1, null);
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.derivedStates = ScopeMap.m4507constructorimpl$default(null, 1, null);
        this.changes = createChangeList();
        this.lateChanges = createChangeList();
        this.observationsProcessed = ScopeMap.m4507constructorimpl$default(null, 1, null);
        this.invalidations = ScopeMap.m4507constructorimpl$default(null, 1, null);
        this.observerHolder = new CompositionObserverHolder(null, false, compositionContext, 3, null);
        this.rememberManager = new RememberEventDispatcher();
        InternalComposer createComposer = createComposer();
        compositionContext.registerComposer$runtime(createComposer);
        this.composer = createComposer;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$954879418$runtime();
    }

    public final CompositionContext getParent() {
        return this.parent;
    }

    public final SlotStorage getSlotStorage$runtime() {
        return this.slotStorage;
    }

    private final SlotStorage createSlotStorage() {
        if (ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new SlotTable(0, null, false, false, 15, null);
        }
        return new androidx.compose.runtime.composer.gapbuffer.SlotTable();
    }

    public final Set<Object> getObservedObjects$runtime() {
        return this.observations.asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime() {
        return this.derivedStates.asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    public final boolean getPendingInvalidScopes$runtime() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public final CompositionObserverHolder getObserverHolder$runtime() {
        return this.observerHolder;
    }

    public final InternalComposer getComposer$runtime() {
        return this.composer;
    }

    private final InternalComposer createComposer() {
        boolean z = ComposeRuntimeFlags.isLinkBufferComposerEnabled;
        Applier<?> applier = this.applier;
        if (z) {
            return new LinkComposer(applier, this.parent, this.abandonSet, SlotTableKt.asLinkBufferSlotTable(this.slotStorage), this.changes, this.lateChanges, this.observerHolder, this);
        }
        return new GapComposer(applier, this.parent, androidx.compose.runtime.composer.gapbuffer.SlotTableKt.asGapBufferSlotTable(this.slotStorage), this.abandonSet, this.changes, this.lateChanges, this.observerHolder, this);
    }

    private final Changes createChangeList() {
        if (ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new ChangeList();
        }
        return new androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList();
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.isComposing$runtime();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.state == 3;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime;
        synchronized (this.lock) {
            hasPendingChanges$runtime = this.composer.getHasPendingChanges$runtime();
        }
        return hasPendingChanges$runtime;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        boolean clearDeactivated = clearDeactivated();
        ensureRunning();
        if (clearDeactivated) {
            composeInitialWithReuse(function2);
        } else {
            composeInitial(function2);
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> function2) {
        clearDeactivated();
        ensureRunning();
        composeInitialWithReuse(function2);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        return composeInitialPaused(clearDeactivated(), function2);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContentWithReuse(Function2<? super Composer, ? super Integer, Unit> function2) {
        clearDeactivated();
        ensureRunning();
        return composeInitialPaused(true, function2);
    }

    public final void pausedCompositionFinished$runtime(ScatterSet<RememberObserverHolder> scatterSet) {
        this.pendingPausedComposition = null;
        if (scatterSet != null) {
            this.rememberManager.ignoreForgotten(scatterSet);
            this.state = 2;
        }
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
        this.parent.composeInitial$runtime(this, function2);
    }

    private final PausedComposition composeInitialPaused(boolean z, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, function2, z, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    private final void composeInitialWithReuse(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composer.startReuseFromRoot$runtime();
        composeInitial(function2);
        this.composer.endReuseFromRoot$runtime();
    }

    private final void ensureRunning() {
        String str;
        int i = this.state;
        if (!(i == 0)) {
            if (i == 1) {
                str = "The composition should be activated before setting content.";
            } else if (i == 2) {
                str = "A previous pausable composition for this composition was cancelled. This composition must be disposed.";
            } else if (i == 3) {
                str = "The composition is disposed";
            } else {
                str = "";
            }
            PreconditionsKt.throwIllegalStateException(str);
        }
        if (this.pendingPausedComposition == null) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
    }

    private final boolean clearDeactivated() {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (this.state != 1) {
                z = false;
            }
            if (z) {
                this.state = 0;
            }
        }
        return z;
    }

    @Override // androidx.compose.runtime.tooling.ObservableComposition
    public CompositionObserverHandle setObserver(final CompositionObserver compositionObserver) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(compositionObserver);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl$setObserver$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj;
                obj = CompositionImpl.this.lock;
                CompositionImpl compositionImpl = CompositionImpl.this;
                CompositionObserver compositionObserver2 = compositionObserver;
                synchronized (obj) {
                    if (Intrinsics.areEqual(compositionImpl.getObserverHolder$runtime().getObserver(), compositionObserver2)) {
                        compositionImpl.getObserverHolder$runtime().setObserver(null);
                        compositionImpl.getObserverHolder$runtime().setRoot(false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final void invalidateGroupsWithKey(int i) {
        List<RecomposeScopeImpl> invalidateGroupsWithKey;
        synchronized (this.lock) {
            invalidateGroupsWithKey = this.slotStorage.invalidateGroupsWithKey(i);
        }
        if (invalidateGroupsWithKey != null) {
            int size = invalidateGroupsWithKey.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (invalidateGroupsWithKey.get(i2).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime()) {
            this.parent.invalidate$runtime(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object obj;
        Object obj2;
        AtomicReference<Object> atomicReference = this.pendingModifications;
        obj = CompositionKt.PendingApplyNoModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            obj2 = CompositionKt.PendingApplyNoModifications;
            if (Intrinsics.areEqual(andSet, obj2)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            } else if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet, true);
            } else if (andSet instanceof Object[]) {
                for (Set<? extends Object> set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(set, true);
                }
            } else {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(null);
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
        } else if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
        } else if (andSet == null) {
            if (this.pendingPausedComposition == null) {
                ComposerKt.composeImmediateRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            }
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsOutOfBandLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(SetsKt.emptySet());
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
        } else if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                MutableScatterMap<Object, Object> m4423takeInvalidationsafanTW4 = m4423takeInvalidationsafanTW4();
                try {
                    this.composer.mo4428composeContentZbOJvo$runtime(m4423takeInvalidationsafanTW4, function2, this.shouldPause);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    this.invalidations = m4423takeInvalidationsafanTW4;
                    throw th;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        } catch (Throwable th2) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                    rememberEventDispatcher.clear();
                }
                throw th2;
            } catch (Throwable th3) {
                abandonChanges();
                throw th3;
            }
        }
    }

    public final void updateMovingInvalidations$runtime() {
        synchronized (this.lock) {
            drainPendingModificationsOutOfBandLocked();
            this.composer.mo4430updateComposerInvalidationsRY85e9Y$runtime(m4423takeInvalidationsafanTW4());
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (this.composer.isComposing$runtime()) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if (this.state != 3) {
                this.state = 3;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$1918065384$runtime();
                Changes deferredChanges$runtime = this.composer.getDeferredChanges$runtime();
                if (deferredChanges$runtime != null) {
                    applyChangesInLocked(deferredChanges$runtime);
                }
                boolean isEmpty = this.slotStorage.isEmpty();
                if (!isEmpty || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    if (!isEmpty) {
                        this.applier.onBeginChanges();
                        this.slotStorage.clear(this.rememberManager);
                        this.applier.clear();
                        this.applier.onEndChanges();
                        rememberEventDispatcher.dispatchRememberObservers();
                    }
                    rememberEventDispatcher.dispatchAbandons();
                    rememberEventDispatcher.clear();
                }
                this.composer.dispose$runtime();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = ScopeMap.m4515getSizeimpl(this.invalidations) > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> set) {
        Object obj;
        Set<? extends Object> set2;
        Object obj2;
        do {
            obj = this.pendingModifications.get();
            if (obj != null) {
                obj2 = CompositionKt.PendingApplyNoModifications;
                if (!Intrinsics.areEqual(obj, obj2)) {
                    if (obj instanceof Set) {
                        set2 = new Set[]{obj, set};
                    } else if (!(obj instanceof Object[])) {
                        throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                    } else {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                        set2 = ArraysKt.plus((Set<? extends Object>[]) obj, set);
                    }
                }
            }
            set2 = set;
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, set2));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> function0) {
        this.composer.prepareCompose$runtime(function0);
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOf$runtime(Anchor anchor) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        long j3;
        if (ScopeMap.m4515getSizeimpl(this.invalidations) > 0) {
            ArrayList arrayList = new ArrayList();
            SlotStorage slotStorage = this.slotStorage;
            MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j4 = jArr3[i5];
                    char c2 = 7;
                    long j5 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8;
                        int i7 = 8 - ((~(i5 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j4 & 255) < 128) {
                                int i9 = (i5 << 3) + i8;
                                c = c2;
                                Object obj = mutableScatterMap.keys[i9];
                                j2 = j5;
                                Object obj2 = mutableScatterMap.values[i9];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                if (obj2 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                    Object[] objArr = mutableScatterSet.elements;
                                    int i10 = i6;
                                    long[] jArr4 = mutableScatterSet.metadata;
                                    jArr2 = jArr3;
                                    int length2 = jArr4.length - 2;
                                    j = j4;
                                    if (length2 >= 0) {
                                        int i11 = i8;
                                        int i12 = 0;
                                        while (true) {
                                            long j6 = jArr4[i12];
                                            long[] jArr5 = jArr4;
                                            Object obj3 = obj;
                                            if ((((~j6) << c) & j6 & j2) != j2) {
                                                int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                                int i14 = 0;
                                                while (i14 < i13) {
                                                    if ((j6 & 255) < 128) {
                                                        i3 = i11;
                                                        int i15 = (i12 << 3) + i14;
                                                        i4 = i14;
                                                        Object obj4 = objArr[i15];
                                                        j3 = j6;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj3;
                                                        Anchor anchor2 = recomposeScopeImpl.getAnchor();
                                                        if (anchor2 != null && slotStorage.inGroup(anchor, anchor2)) {
                                                            arrayList.add(TuplesKt.to(recomposeScopeImpl, obj4));
                                                            mutableScatterSet.removeElementAt(i15);
                                                        }
                                                    } else {
                                                        i3 = i11;
                                                        i4 = i14;
                                                        j3 = j6;
                                                    }
                                                    j6 = j3 >> i10;
                                                    i14 = i4 + 1;
                                                    i11 = i3;
                                                }
                                                i = i11;
                                                if (i13 != i10) {
                                                    break;
                                                }
                                            } else {
                                                i = i11;
                                            }
                                            if (i12 == length2) {
                                                break;
                                            }
                                            i12++;
                                            obj = obj3;
                                            jArr4 = jArr5;
                                            i11 = i;
                                            i10 = 8;
                                        }
                                    } else {
                                        i = i8;
                                    }
                                    z = mutableScatterSet.isEmpty();
                                } else {
                                    jArr2 = jArr3;
                                    j = j4;
                                    i = i8;
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
                                    Anchor anchor3 = recomposeScopeImpl2.getAnchor();
                                    if (anchor3 == null || !slotStorage.inGroup(anchor, anchor3)) {
                                        z = false;
                                    } else {
                                        arrayList.add(TuplesKt.to(recomposeScopeImpl2, obj2));
                                        z = true;
                                    }
                                }
                                if (z) {
                                    mutableScatterMap.removeValueAt(i9);
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr3;
                                j = j4;
                                c = c2;
                                j2 = j5;
                                i = i8;
                                i2 = i6;
                            }
                            i8 = i + 1;
                            i6 = i2;
                            j4 = j >> i2;
                            c2 = c;
                            j5 = j2;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i7 != i6) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                    jArr3 = jArr;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOfGroup$runtime(Function1<? super Anchor, Boolean> function1) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        int i2;
        boolean z;
        Object obj;
        long j3;
        Object obj2;
        int i3;
        if (ScopeMap.m4515getSizeimpl(this.invalidations) > 0) {
            ArrayList arrayList = new ArrayList();
            MutableScatterMap mutableScatterMap = this.invalidations;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    long j4 = jArr3[i4];
                    char c2 = 7;
                    long j5 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8;
                        int i6 = 8 - ((~(i4 - length)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((j4 & 255) < 128) {
                                int i8 = (i4 << 3) + i7;
                                c = c2;
                                Object obj3 = mutableScatterMap.keys[i8];
                                j2 = j5;
                                Object obj4 = mutableScatterMap.values[i8];
                                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                if (obj4 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj4;
                                    Object[] objArr = mutableScatterSet.elements;
                                    long[] jArr4 = mutableScatterSet.metadata;
                                    int i9 = i5;
                                    int length2 = jArr4.length - 2;
                                    jArr2 = jArr3;
                                    j = j4;
                                    if (length2 >= 0) {
                                        int i10 = 0;
                                        while (true) {
                                            long j6 = jArr4[i10];
                                            Object[] objArr2 = objArr;
                                            i = i7;
                                            if ((((~j6) << c) & j6 & j2) != j2) {
                                                int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                int i12 = 0;
                                                while (i12 < i11) {
                                                    if ((j6 & 255) < 128) {
                                                        j3 = j6;
                                                        int i13 = (i10 << 3) + i12;
                                                        Object obj5 = objArr2[i13];
                                                        obj2 = obj3;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                                                        i3 = i12;
                                                        Anchor anchor = recomposeScopeImpl.getAnchor();
                                                        if (anchor != null && function1.invoke(anchor).booleanValue()) {
                                                            arrayList.add(TuplesKt.to(recomposeScopeImpl, obj5));
                                                            mutableScatterSet.removeElementAt(i13);
                                                        }
                                                    } else {
                                                        j3 = j6;
                                                        obj2 = obj3;
                                                        i3 = i12;
                                                    }
                                                    j6 = j3 >> i9;
                                                    i12 = i3 + 1;
                                                    obj3 = obj2;
                                                }
                                                obj = obj3;
                                                if (i11 != i9) {
                                                    break;
                                                }
                                            } else {
                                                obj = obj3;
                                            }
                                            if (i10 == length2) {
                                                break;
                                            }
                                            i10++;
                                            i7 = i;
                                            objArr = objArr2;
                                            obj3 = obj;
                                            i9 = 8;
                                        }
                                    } else {
                                        i = i7;
                                    }
                                    z = mutableScatterSet.isEmpty();
                                } else {
                                    jArr2 = jArr3;
                                    j = j4;
                                    i = i7;
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj3;
                                    Anchor anchor2 = recomposeScopeImpl2.getAnchor();
                                    if (anchor2 == null || !function1.invoke(anchor2).booleanValue()) {
                                        z = false;
                                    } else {
                                        arrayList.add(TuplesKt.to(recomposeScopeImpl2, obj4));
                                        z = true;
                                    }
                                }
                                if (z) {
                                    mutableScatterMap.removeValueAt(i8);
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr3;
                                j = j4;
                                c = c2;
                                j2 = j5;
                                i = i7;
                                i2 = i5;
                            }
                            i7 = i + 1;
                            i5 = i2;
                            j4 = j >> i2;
                            c2 = c;
                            jArr3 = jArr2;
                            j5 = j2;
                        }
                        jArr = jArr3;
                        if (i6 != i5) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    jArr3 = jArr;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private final void addPendingInvalidationsLocked(Object obj, boolean z) {
        Object obj2 = this.observations.get(obj);
        if (obj2 == null) {
            return;
        }
        if (obj2 instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!ScopeMap.m4520removeimpl(this.observationsProcessed, obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !z) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                }
                i++;
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj2;
            if (ScopeMap.m4520removeimpl(this.observationsProcessed, obj, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(obj) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !z) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long j;
        char c;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        long j4;
        char c2;
        long j5;
        int i2;
        boolean z;
        long[] jArr3;
        int i3;
        int i4;
        MutableScatterMap<Object, Object> mutableScatterMap = this.derivedStates;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        long j6 = 255;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i5 = 8;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j8 = jArr4[i6];
                j3 = 128;
                if ((((~j8) << c3) & j8 & j7) != j7) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j8 & j6) < 128) {
                            j4 = j6;
                            int i9 = (i6 << 3) + i8;
                            Object obj = mutableScatterMap.keys[i9];
                            Object obj2 = mutableScatterMap.values[i9];
                            c2 = c3;
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                j5 = j7;
                                long[] jArr5 = mutableScatterSet.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i10 = i5;
                                    int i11 = 0;
                                    while (true) {
                                        long j9 = jArr5[i11];
                                        Object[] objArr2 = objArr;
                                        long[] jArr6 = jArr5;
                                        if ((((~j9) << c2) & j9 & j5) != j5) {
                                            int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                            int i13 = 0;
                                            while (i13 < i12) {
                                                if ((j9 & j4) < 128) {
                                                    jArr3 = jArr4;
                                                    int i14 = (i11 << 3) + i13;
                                                    i3 = i8;
                                                    i4 = i13;
                                                    if (!ScopeMap.m4508containsimpl(this.observations, (DerivedState) objArr2[i14])) {
                                                        mutableScatterSet.removeElementAt(i14);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i3 = i8;
                                                    i4 = i13;
                                                }
                                                j9 >>= i10;
                                                i13 = i4 + 1;
                                                jArr4 = jArr3;
                                                i8 = i3;
                                            }
                                            jArr2 = jArr4;
                                            i = i8;
                                            if (i12 != i10) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            i = i8;
                                        }
                                        int i15 = i11;
                                        if (i15 == length2) {
                                            break;
                                        }
                                        i11 = i15 + 1;
                                        objArr = objArr2;
                                        jArr5 = jArr6;
                                        jArr4 = jArr2;
                                        i8 = i;
                                        i10 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    i = i8;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                i = i8;
                                j5 = j7;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                z = !ScopeMap.m4508containsimpl(this.observations, (DerivedState) obj2);
                            }
                            if (z) {
                                mutableScatterMap.removeValueAt(i9);
                            }
                            i2 = 8;
                        } else {
                            jArr2 = jArr4;
                            i = i8;
                            j4 = j6;
                            c2 = c3;
                            j5 = j7;
                            i2 = i5;
                        }
                        j8 >>= i2;
                        i8 = i + 1;
                        i5 = i2;
                        c3 = c2;
                        j6 = j4;
                        j7 = j5;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    j = j6;
                    c = c3;
                    j2 = j7;
                    if (i7 != i5) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                    j = j6;
                    c = c3;
                    j2 = j7;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                c3 = c;
                j6 = j;
                j7 = j2;
                jArr4 = jArr;
                i5 = 8;
            }
        } else {
            j = 255;
            c = 7;
            j2 = -9187201950435737472L;
            j3 = 128;
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr3 = mutableScatterSet2.elements;
        long[] jArr7 = mutableScatterSet2.metadata;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            long j10 = jArr7[i16];
            if ((((~j10) << c) & j10 & j2) != j2) {
                int i17 = 8 - ((~(i16 - length3)) >>> 31);
                for (int i18 = 0; i18 < i17; i18++) {
                    if ((j10 & j) < j3) {
                        int i19 = (i16 << 3) + i18;
                        if (!((RecomposeScopeImpl) objArr3[i19]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i19);
                        }
                    }
                    j10 >>= 8;
                }
                if (i17 != 8) {
                    return;
                }
            }
            if (i16 == length3) {
                return;
            }
            i16++;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        int i;
        int i2;
        int i3;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime = this.composer.getCurrentRecomposeScope$runtime()) == null) {
            return;
        }
        int i4 = 1;
        currentRecomposeScope$runtime.setUsed(true);
        boolean recordRead = currentRecomposeScope$runtime.recordRead(obj);
        CompositionObserver observer = observer();
        if (observer != null) {
            observer.onReadInScope(currentRecomposeScope$runtime, obj);
        }
        if (recordRead) {
            return;
        }
        if (obj instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.Companion;
            ((StateObjectImpl) obj).m4759recordReadInh_f27i8$runtime(ReaderKind.m4747constructorimpl(1));
        }
        ScopeMap.m4500addimpl(this.observations, obj, currentRecomposeScope$runtime);
        if (obj instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) obj;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            ScopeMap.m4522removeScopeimpl(this.derivedStates, obj);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr = dependencies.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j = jArr[i5];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8;
                        int i7 = 8 - ((~(i5 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j & 255) < 128) {
                                i2 = i4;
                                StateObject stateObject = (StateObject) objArr[(i5 << 3) + i8];
                                if (stateObject instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion2 = ReaderKind.Companion;
                                    i3 = i6;
                                    ((StateObjectImpl) stateObject).m4759recordReadInh_f27i8$runtime(ReaderKind.m4747constructorimpl(i2));
                                } else {
                                    i3 = i6;
                                }
                                ScopeMap.m4500addimpl(this.derivedStates, stateObject, obj);
                            } else {
                                i2 = i4;
                                i3 = i6;
                            }
                            j >>= i3;
                            i8++;
                            i4 = i2;
                            i6 = i3;
                        }
                        i = i4;
                        if (i7 != i6) {
                            break;
                        }
                    } else {
                        i = i4;
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                    i4 = i;
                }
            }
            currentRecomposeScope$runtime.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    private final void invalidateScopeOfLocked(Object obj) {
        Object obj2 = this.observations.get(obj);
        if (obj2 == null) {
            return;
        }
        if (obj2 instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                                ScopeMap.m4500addimpl(this.observationsProcessed, obj, recomposeScopeImpl);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                }
                i++;
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj2;
            if (recomposeScopeImpl2.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                ScopeMap.m4500addimpl(this.observationsProcessed, obj, recomposeScopeImpl2);
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object obj) {
        synchronized (this.lock) {
            invalidateScopeOfLocked(obj);
            Object obj2 = this.derivedStates.get(obj);
            if (obj2 != null) {
                if (!(obj2 instanceof MutableScatterSet)) {
                    invalidateScopeOfLocked((DerivedState) obj2);
                } else {
                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i3]);
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
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        synchronized (this.lock) {
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            if (pausedCompositionImpl != null && !pausedCompositionImpl.isRecomposing$runtime()) {
                pausedCompositionImpl.markIncomplete$runtime();
                pausedCompositionImpl.getPausableApplier$runtime().markRecomposePending();
                return false;
            }
            drainPendingModificationsForCompositionLocked();
            MutableScatterMap<Object, Object> m4423takeInvalidationsafanTW4 = m4423takeInvalidationsafanTW4();
            try {
                boolean mo4429recomposeaFTiNEg$runtime = this.composer.mo4429recomposeaFTiNEg$runtime(m4423takeInvalidationsafanTW4, this.shouldPause);
                if (!mo4429recomposeaFTiNEg$runtime) {
                    drainPendingModificationsLocked();
                }
                return mo4429recomposeaFTiNEg$runtime;
            } catch (Throwable th) {
                this.invalidations = m4423takeInvalidationsafanTW4;
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState movableContentState) {
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            movableContentState.getSlotStorage$runtime().disposeUnusedMovableContent(this.rememberManager, movableContentState);
            rememberEventDispatcher.dispatchRememberObservers();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    private final void applyChangesInLocked(Changes changes) {
        String str;
        RememberEventDispatcher rememberEventDispatcher;
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean z;
        long[] jArr3;
        RecordingApplier<Object> pausableApplier$runtime;
        this.rememberManager.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
        try {
            if (!changes.isEmpty()) {
                PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
                RecordingApplier<Object> recordingApplier = (pausedCompositionImpl == null || (pausableApplier$runtime = pausedCompositionImpl.getPausableApplier$runtime()) == null) ? this.applier : pausableApplier$runtime;
                PausedCompositionImpl pausedCompositionImpl2 = this.pendingPausedComposition;
                if (Intrinsics.areEqual(recordingApplier, pausedCompositionImpl2 != null ? pausedCompositionImpl2.getPausableApplier$runtime() : null)) {
                    str = "Compose:recordChanges";
                } else {
                    str = "Compose:applyChanges";
                }
                Object beginSection = Trace.INSTANCE.beginSection(str);
                PausedCompositionImpl pausedCompositionImpl3 = this.pendingPausedComposition;
                if (pausedCompositionImpl3 == null || (rememberEventDispatcher = pausedCompositionImpl3.getRememberManager$runtime()) == null) {
                    rememberEventDispatcher = this.rememberManager;
                }
                recordingApplier.onBeginChanges();
                changes.execute(this.slotStorage, recordingApplier, rememberEventDispatcher, this.composer.getErrorContext$runtime());
                recordingApplier.onEndChanges();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
                this.rememberManager.dispatchRememberObservers();
                this.rememberManager.dispatchSideEffects();
                if (this.pendingInvalidScopes) {
                    Object beginSection2 = Trace.INSTANCE.beginSection("Compose:unobserve");
                    int i2 = 0;
                    this.pendingInvalidScopes = false;
                    MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
                    long[] jArr4 = mutableScatterMap.metadata;
                    int length = jArr4.length - 2;
                    if (length >= 0) {
                        int i3 = 0;
                        while (true) {
                            long j3 = jArr4[i3];
                            char c2 = 7;
                            long j4 = -9187201950435737472L;
                            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i4 = 8;
                                int i5 = 8 - ((~(i3 - length)) >>> 31);
                                int i6 = i2;
                                while (i6 < i5) {
                                    if ((j3 & 255) < 128) {
                                        int i7 = (i3 << 3) + i6;
                                        c = c2;
                                        Object obj = mutableScatterMap.keys[i7];
                                        Object obj2 = mutableScatterMap.values[i7];
                                        j2 = j4;
                                        if (obj2 instanceof MutableScatterSet) {
                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                            Object[] objArr = mutableScatterSet.elements;
                                            long[] jArr5 = mutableScatterSet.metadata;
                                            int length2 = jArr5.length - 2;
                                            if (length2 >= 0) {
                                                j = j3;
                                                int i8 = i4;
                                                int i9 = 0;
                                                while (true) {
                                                    long j5 = jArr5[i9];
                                                    Object[] objArr2 = objArr;
                                                    long[] jArr6 = jArr5;
                                                    if ((((~j5) << c) & j5 & j2) != j2) {
                                                        int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                                        int i11 = 0;
                                                        while (i11 < i10) {
                                                            if ((j5 & 255) < 128) {
                                                                jArr3 = jArr4;
                                                                int i12 = (i9 << 3) + i11;
                                                                if (!((RecomposeScopeImpl) objArr2[i12]).getValid()) {
                                                                    mutableScatterSet.removeElementAt(i12);
                                                                }
                                                            } else {
                                                                jArr3 = jArr4;
                                                            }
                                                            j5 >>= i8;
                                                            i11++;
                                                            jArr4 = jArr3;
                                                        }
                                                        jArr2 = jArr4;
                                                        if (i10 != i8) {
                                                            break;
                                                        }
                                                    } else {
                                                        jArr2 = jArr4;
                                                    }
                                                    if (i9 == length2) {
                                                        break;
                                                    }
                                                    i9++;
                                                    objArr = objArr2;
                                                    jArr5 = jArr6;
                                                    jArr4 = jArr2;
                                                    i8 = 8;
                                                }
                                            } else {
                                                jArr2 = jArr4;
                                                j = j3;
                                            }
                                            z = mutableScatterSet.isEmpty();
                                        } else {
                                            jArr2 = jArr4;
                                            j = j3;
                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                            z = !((RecomposeScopeImpl) obj2).getValid();
                                        }
                                        if (z) {
                                            mutableScatterMap.removeValueAt(i7);
                                        }
                                        i = 8;
                                    } else {
                                        jArr2 = jArr4;
                                        j = j3;
                                        c = c2;
                                        j2 = j4;
                                        i = i4;
                                    }
                                    j3 = j >> i;
                                    i6++;
                                    i4 = i;
                                    c2 = c;
                                    j4 = j2;
                                    jArr4 = jArr2;
                                }
                                jArr = jArr4;
                                if (i5 != i4) {
                                    break;
                                }
                            } else {
                                jArr = jArr4;
                            }
                            if (i3 == length) {
                                break;
                            }
                            i3++;
                            jArr4 = jArr;
                            i2 = 0;
                        }
                    }
                    cleanUpDerivedStateObservations();
                    Unit unit2 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection2);
                }
                try {
                    if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                        this.rememberManager.dispatchAbandons();
                    }
                } finally {
                }
            } else {
                try {
                    if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                        this.rememberManager.dispatchAbandons();
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                    this.rememberManager.dispatchAbandons();
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            applyChangesInLocked(this.changes);
            drainPendingModificationsLocked();
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            if (this.lateChanges.isNotEmpty()) {
                applyChangesInLocked(this.lateChanges);
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            this.composer.changesApplied$runtime();
            if (!this.abandonSet.isEmpty()) {
                RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                rememberEventDispatcher.dispatchAbandons();
                rememberEventDispatcher.clear();
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> function1) {
        MutableScatterMap<Object, Object> m4423takeInvalidationsafanTW4 = m4423takeInvalidationsafanTW4();
        try {
            return function1.invoke(ScopeMap.m4504boximpl(m4423takeInvalidationsafanTW4));
        } catch (Throwable th) {
            this.invalidations = m4423takeInvalidationsafanTW4;
            throw th;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            rememberEventDispatcher.dispatchAbandons();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        this.slotStorage.invalidateAll();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime();
                this.slotStorage.verifyWellFormed();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition controlledComposition, int i, Function0<? extends R> function0) {
        if (controlledComposition != null && !Intrinsics.areEqual(controlledComposition, this) && i >= 0) {
            this.invalidationDelegate = (CompositionImpl) controlledComposition;
            this.invalidationDelegateGroup = i;
            try {
                return function0.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return function0.invoke();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback shouldPauseCallback) {
        ShouldPauseCallback shouldPauseCallback2 = this.shouldPause;
        this.shouldPause = shouldPauseCallback;
        return shouldPauseCallback2;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        CompositionObserver observer;
        CompositionImpl compositionImpl;
        if (recomposeScopeImpl.getDefaultsInScope()) {
            recomposeScopeImpl.setDefaultsInvalid(true);
        }
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotStorage.ownsRecomposeScope(recomposeScopeImpl)) {
            if (!recomposeScopeImpl.getCanRecompose()) {
                return InvalidationResult.IGNORED;
            }
            InvalidationResult invalidateChecked = invalidateChecked(recomposeScopeImpl, anchor, obj);
            if (invalidateChecked != InvalidationResult.IGNORED && (observer = observer()) != null) {
                observer.onScopeInvalidated(recomposeScopeImpl, obj);
            }
            return invalidateChecked;
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        if (compositionImpl != null && compositionImpl.tryImminentInvalidation(recomposeScopeImpl, obj)) {
            return InvalidationResult.IMMINENT;
        }
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl) {
        this.pendingInvalidScopes = true;
        CompositionObserver observer = observer();
        if (observer != null) {
            observer.onScopeDisposed(recomposeScopeImpl);
        }
    }

    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> compositionServiceKey) {
        if (Intrinsics.areEqual(compositionServiceKey, CompositionKt.getObservableCompositionServiceKey())) {
            return (T) this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime(recomposeScopeImpl, obj);
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl recomposeScopeImpl, Anchor anchor, Object obj) {
        int i;
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            CompositionImpl compositionImpl2 = null;
            if (compositionImpl != null) {
                if (!this.slotStorage.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                    compositionImpl = null;
                }
                compositionImpl2 = compositionImpl;
            }
            if (compositionImpl2 == null) {
                if (tryImminentInvalidation(recomposeScopeImpl, obj)) {
                    return InvalidationResult.IMMINENT;
                } else if (obj == null) {
                    ScopeMap.m4524setimpl(this.invalidations, recomposeScopeImpl, ScopeInvalidated.INSTANCE);
                } else {
                    boolean z = obj instanceof DerivedState;
                    MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
                    if (z) {
                        Object obj2 = mutableScatterMap.get(recomposeScopeImpl);
                        if (obj2 != null) {
                            if (obj2 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr = mutableScatterSet.metadata;
                                int length = jArr.length - 2;
                                if (length >= 0) {
                                    int i2 = 0;
                                    loop0: while (true) {
                                        long j = jArr[i2];
                                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i3 = 8;
                                            int i4 = 8 - ((~(i2 - length)) >>> 31);
                                            int i5 = 0;
                                            while (i5 < i4) {
                                                if ((j & 255) < 128) {
                                                    i = i3;
                                                    if (objArr[(i2 << 3) + i5] == ScopeInvalidated.INSTANCE) {
                                                        break loop0;
                                                    }
                                                } else {
                                                    i = i3;
                                                }
                                                j >>= i;
                                                i5++;
                                                i3 = i;
                                            }
                                            if (i4 != i3) {
                                                break;
                                            }
                                        }
                                        if (i2 == length) {
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                            } else if (obj2 == ScopeInvalidated.INSTANCE) {
                            }
                        }
                        ScopeMap.m4500addimpl(this.invalidations, recomposeScopeImpl, obj);
                    } else {
                        ScopeMap.m4524setimpl(mutableScatterMap, recomposeScopeImpl, ScopeInvalidated.INSTANCE);
                    }
                }
            }
            if (compositionImpl2 != null) {
                return compositionImpl2.invalidateChecked(recomposeScopeImpl, anchor, obj);
            }
            this.parent.invalidate$runtime(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }

    public final void removeObservation$runtime(Object obj, RecomposeScopeImpl recomposeScopeImpl) {
        ScopeMap.m4520removeimpl(this.observations, obj, recomposeScopeImpl);
    }

    public final void removeDerivedStateObservation$runtime(DerivedState<?> derivedState) {
        if (ScopeMap.m4508containsimpl(this.observations, derivedState)) {
            return;
        }
        ScopeMap.m4522removeScopeimpl(this.derivedStates, derivedState);
    }

    /* renamed from: takeInvalidations-afanTW4 */
    private final MutableScatterMap<Object, Object> m4423takeInvalidationsafanTW4() {
        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
        this.invalidations = ScopeMap.m4507constructorimpl$default(null, 1, null);
        return mutableScatterMap;
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                try {
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                } finally {
                    rememberEventDispatcher.clear();
                }
            }
            throw th;
        }
    }

    private final CompositionObserver observer() {
        return this.observerHolder.current();
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            if (!(this.pendingPausedComposition == null)) {
                PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
            }
            boolean isEmpty = this.slotStorage.isEmpty();
            if (!isEmpty || !this.abandonSet.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
                RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                try {
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    if (!isEmpty) {
                        this.applier.onBeginChanges();
                        this.slotStorage.deactivateAll(this.rememberManager);
                        this.applier.onEndChanges();
                        rememberEventDispatcher.dispatchRememberObservers();
                    }
                    rememberEventDispatcher.dispatchAbandons();
                    rememberEventDispatcher.clear();
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                } catch (Throwable th) {
                    rememberEventDispatcher.clear();
                    throw th;
                }
            }
            ScopeMap.m4505clearimpl(this.observations);
            ScopeMap.m4505clearimpl(this.derivedStates);
            ScopeMap.m4505clearimpl(this.invalidations);
            this.changes.clear();
            this.lateChanges.clear();
            this.composer.deactivate$runtime();
            this.state = 1;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final int composerStacksSizes$runtime() {
        return this.composer.stacksSize$runtime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0050, code lost:
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0068  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean observesAnyOf(Set<? extends Object> set) {
        if (set instanceof ScatterSetWrapper) {
            ScatterSet set$runtime = ((ScatterSetWrapper) set).getSet$runtime();
            Object[] objArr = set$runtime.elements;
            long[] jArr = set$runtime.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i3];
                                if (ScopeMap.m4508containsimpl(this.observations, obj) || ScopeMap.m4508containsimpl(this.derivedStates, obj)) {
                                    break loop0;
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
        } else {
            for (Object obj2 : set) {
                if (ScopeMap.m4508containsimpl(this.observations, obj2) || ScopeMap.m4508containsimpl(this.derivedStates, obj2)) {
                    return true;
                }
                while (r15.hasNext()) {
                }
            }
        }
        return false;
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> set, boolean z) {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        String str;
        long[] jArr2;
        String str2;
        int i;
        long j4;
        boolean contains;
        String str3;
        int i2;
        long[] jArr3;
        int i3;
        long[] jArr4;
        int i4;
        int i5;
        long j5;
        boolean z2;
        int i6;
        long j6;
        long j7;
        char c2;
        long j8;
        int i7;
        int i8;
        int i9;
        Object obj = null;
        char c3 = 7;
        long j9 = -9187201950435737472L;
        int i10 = 8;
        if (set instanceof ScatterSetWrapper) {
            ScatterSet set$runtime = ((ScatterSetWrapper) set).getSet$runtime();
            Object[] objArr = set$runtime.elements;
            long[] jArr5 = set$runtime.metadata;
            int length = jArr5.length - 2;
            if (length >= 0) {
                int i11 = 0;
                j2 = 128;
                while (true) {
                    long j10 = jArr5[i11];
                    j3 = 255;
                    if ((((~j10) << c3) & j10 & j9) != j9) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j10 & 255) < 128) {
                                c2 = c3;
                                Object obj2 = objArr[(i11 << 3) + i13];
                                j8 = j9;
                                if (obj2 instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj2).invalidateForResult(obj);
                                    j7 = j10;
                                    i7 = length;
                                } else {
                                    addPendingInvalidationsLocked(obj2, z);
                                    Object obj3 = this.derivedStates.get(obj2);
                                    if (obj3 != null) {
                                        if (obj3 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
                                            Object[] objArr2 = mutableScatterSet.elements;
                                            long[] jArr6 = mutableScatterSet.metadata;
                                            int length2 = jArr6.length - 2;
                                            if (length2 >= 0) {
                                                j7 = j10;
                                                int i14 = 0;
                                                while (true) {
                                                    long j11 = jArr6[i14];
                                                    int i15 = i10;
                                                    i7 = length;
                                                    if ((((~j11) << c2) & j11 & j8) != j8) {
                                                        int i16 = 8 - ((~(i14 - length2)) >>> 31);
                                                        int i17 = 0;
                                                        while (i17 < i16) {
                                                            if ((j11 & 255) < 128) {
                                                                i9 = i15;
                                                                addPendingInvalidationsLocked((DerivedState) objArr2[(i14 << 3) + i17], z);
                                                            } else {
                                                                i9 = i15;
                                                            }
                                                            j11 >>= i9;
                                                            i17++;
                                                            i15 = i9;
                                                        }
                                                        if (i16 != i15) {
                                                            break;
                                                        }
                                                    }
                                                    if (i14 == length2) {
                                                        break;
                                                    }
                                                    i14++;
                                                    length = i7;
                                                    i10 = 8;
                                                }
                                            }
                                        } else {
                                            j7 = j10;
                                            i7 = length;
                                            addPendingInvalidationsLocked((DerivedState) obj3, z);
                                        }
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    j7 = j10;
                                    i7 = length;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                i8 = 8;
                            } else {
                                j7 = j10;
                                c2 = c3;
                                j8 = j9;
                                i7 = length;
                                i8 = i10;
                            }
                            i13++;
                            length = i7;
                            i10 = i8;
                            c3 = c2;
                            j9 = j8;
                            j10 = j7 >> i8;
                            obj = null;
                        }
                        c = c3;
                        j = j9;
                        int i18 = length;
                        if (i12 != i10) {
                            break;
                        }
                        length = i18;
                    } else {
                        c = c3;
                        j = j9;
                    }
                    if (i11 == length) {
                        break;
                    }
                    i11++;
                    c3 = c;
                    j9 = j;
                    obj = null;
                    i10 = 8;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 128;
                j3 = 255;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 128;
            j3 = 255;
            for (Object obj4 : set) {
                if (obj4 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj4).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj4, z);
                    Object obj5 = this.derivedStates.get(obj4);
                    if (obj5 != null) {
                        if (obj5 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj5;
                            Object[] objArr3 = mutableScatterSet2.elements;
                            long[] jArr7 = mutableScatterSet2.metadata;
                            int length3 = jArr7.length - 2;
                            if (length3 >= 0) {
                                int i19 = 0;
                                while (true) {
                                    long j12 = jArr7[i19];
                                    if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i20 = 8 - ((~(i19 - length3)) >>> 31);
                                        for (int i21 = 0; i21 < i20; i21++) {
                                            if ((j12 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedState) objArr3[(i19 << 3) + i21], z);
                                            }
                                            j12 >>= 8;
                                        }
                                        if (i20 != 8) {
                                            break;
                                        }
                                    }
                                    if (i19 == length3) {
                                        break;
                                    }
                                    i19++;
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedState) obj5, z);
                        }
                    }
                    Unit unit3 = Unit.INSTANCE;
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet3 = this.conditionallyInvalidatedScopes;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet4 = this.invalidatedScopes;
        String str4 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>";
        if (z && mutableScatterSet3.isNotEmpty()) {
            MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
            long[] jArr8 = mutableScatterMap.metadata;
            int length4 = jArr8.length - 2;
            if (length4 >= 0) {
                int i22 = 0;
                while (true) {
                    long j13 = jArr8[i22];
                    if ((((~j13) << c) & j13 & j) != j) {
                        int i23 = 8 - ((~(i22 - length4)) >>> 31);
                        int i24 = 0;
                        while (i24 < i23) {
                            if ((j13 & j3) < j2) {
                                int i25 = (i22 << 3) + i24;
                                Object obj6 = mutableScatterMap.keys[i25];
                                Object obj7 = mutableScatterMap.values[i25];
                                if (obj7 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj7;
                                    Object[] objArr4 = mutableScatterSet5.elements;
                                    long[] jArr9 = mutableScatterSet5.metadata;
                                    jArr4 = jArr8;
                                    int length5 = jArr9.length - 2;
                                    if (length5 >= 0) {
                                        j5 = j13;
                                        int i26 = 0;
                                        while (true) {
                                            long j14 = jArr9[i26];
                                            i4 = length4;
                                            i5 = i22;
                                            if ((((~j14) << c) & j14 & j) != j) {
                                                int i27 = 8 - ((~(i26 - length5)) >>> 31);
                                                int i28 = 0;
                                                while (i28 < i27) {
                                                    if ((j14 & j3) < j2) {
                                                        i6 = i28;
                                                        int i29 = (i26 << 3) + i6;
                                                        j6 = j14;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr4[i29];
                                                        if (mutableScatterSet3.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                            mutableScatterSet5.removeElementAt(i29);
                                                        }
                                                    } else {
                                                        i6 = i28;
                                                        j6 = j14;
                                                    }
                                                    j14 = j6 >> 8;
                                                    i28 = i6 + 1;
                                                }
                                                if (i27 != 8) {
                                                    break;
                                                }
                                            }
                                            if (i26 == length5) {
                                                break;
                                            }
                                            i26++;
                                            length4 = i4;
                                            i22 = i5;
                                        }
                                    } else {
                                        i4 = length4;
                                        i5 = i22;
                                        j5 = j13;
                                    }
                                    z2 = mutableScatterSet5.isEmpty();
                                } else {
                                    jArr4 = jArr8;
                                    i4 = length4;
                                    i5 = i22;
                                    j5 = j13;
                                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj7;
                                    z2 = mutableScatterSet3.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2);
                                }
                                if (z2) {
                                    mutableScatterMap.removeValueAt(i25);
                                }
                            } else {
                                jArr4 = jArr8;
                                i4 = length4;
                                i5 = i22;
                                j5 = j13;
                            }
                            j13 = j5 >> 8;
                            i24++;
                            jArr8 = jArr4;
                            length4 = i4;
                            i22 = i5;
                        }
                        jArr3 = jArr8;
                        int i30 = length4;
                        int i31 = i22;
                        if (i23 != 8) {
                            break;
                        }
                        length4 = i30;
                        i3 = i31;
                    } else {
                        jArr3 = jArr8;
                        i3 = i22;
                    }
                    if (i3 == length4) {
                        break;
                    }
                    i22 = i3 + 1;
                    jArr8 = jArr3;
                }
            }
            mutableScatterSet3.clear();
            cleanUpDerivedStateObservations();
        } else if (mutableScatterSet4.isNotEmpty()) {
            MutableScatterMap<Object, Object> mutableScatterMap2 = this.observations;
            long[] jArr10 = mutableScatterMap2.metadata;
            int length6 = jArr10.length - 2;
            if (length6 >= 0) {
                int i32 = 0;
                while (true) {
                    long j15 = jArr10[i32];
                    if ((((~j15) << c) & j15 & j) != j) {
                        int i33 = 8 - ((~(i32 - length6)) >>> 31);
                        int i34 = 0;
                        while (i34 < i33) {
                            if ((j15 & j3) < j2) {
                                int i35 = (i32 << 3) + i34;
                                Object obj8 = mutableScatterMap2.keys[i35];
                                Object obj9 = mutableScatterMap2.values[i35];
                                if (obj9 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj9, str4);
                                    MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj9;
                                    Object[] objArr5 = mutableScatterSet6.elements;
                                    long[] jArr11 = mutableScatterSet6.metadata;
                                    int length7 = jArr11.length - 2;
                                    jArr2 = jArr10;
                                    if (length7 >= 0) {
                                        j4 = j15;
                                        int i36 = 0;
                                        while (true) {
                                            long j16 = jArr11[i36];
                                            long[] jArr12 = jArr11;
                                            i = length6;
                                            if ((((~j16) << c) & j16 & j) != j) {
                                                int i37 = 8 - ((~(i36 - length7)) >>> 31);
                                                int i38 = 0;
                                                while (i38 < i37) {
                                                    if ((j16 & j3) < j2) {
                                                        str3 = str4;
                                                        int i39 = (i36 << 3) + i38;
                                                        i2 = i38;
                                                        if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr5[i39])) {
                                                            mutableScatterSet6.removeElementAt(i39);
                                                        }
                                                    } else {
                                                        str3 = str4;
                                                        i2 = i38;
                                                    }
                                                    j16 >>= 8;
                                                    i38 = i2 + 1;
                                                    str4 = str3;
                                                }
                                                str2 = str4;
                                                if (i37 != 8) {
                                                    break;
                                                }
                                            } else {
                                                str2 = str4;
                                            }
                                            if (i36 == length7) {
                                                break;
                                            }
                                            i36++;
                                            length6 = i;
                                            jArr11 = jArr12;
                                            str4 = str2;
                                        }
                                    } else {
                                        str2 = str4;
                                        i = length6;
                                        j4 = j15;
                                    }
                                    contains = mutableScatterSet6.isEmpty();
                                } else {
                                    jArr2 = jArr10;
                                    str2 = str4;
                                    i = length6;
                                    j4 = j15;
                                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    contains = mutableScatterSet4.contains((RecomposeScopeImpl) obj9);
                                }
                                if (contains) {
                                    mutableScatterMap2.removeValueAt(i35);
                                }
                            } else {
                                jArr2 = jArr10;
                                str2 = str4;
                                i = length6;
                                j4 = j15;
                            }
                            j15 = j4 >> 8;
                            i34++;
                            jArr10 = jArr2;
                            length6 = i;
                            str4 = str2;
                        }
                        jArr = jArr10;
                        str = str4;
                        int i40 = length6;
                        if (i33 != 8) {
                            break;
                        }
                        length6 = i40;
                    } else {
                        jArr = jArr10;
                        str = str4;
                    }
                    if (i32 == length6) {
                        break;
                    }
                    i32++;
                    jArr10 = jArr;
                    str4 = str;
                }
            }
            cleanUpDerivedStateObservations();
            mutableScatterSet4.clear();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(list.get(i).getFirst().getComposition$runtime(), this)) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        try {
            this.composer.insertMovableContentReferences(list);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                    rememberEventDispatcher.clear();
                }
                throw th;
            } catch (Throwable th2) {
                this.abandonChanges();
                throw th2;
            }
        }
    }

    private final <T> T guardChanges(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                    rememberEventDispatcher.clear();
                }
                throw th;
            } catch (Throwable th2) {
                this.abandonChanges();
                throw th2;
            }
        }
    }
}
