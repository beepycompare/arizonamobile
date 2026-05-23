package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.Utils_androidKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
import androidx.compose.runtime.tooling.ComposeStackTraceMode;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.CompositionObserverKt;
import androidx.compose.runtime.tooling.CompositionRegistrationObserver;
import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.compose.ComposeNavigator;
import com.facebook.widget.FacebookDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 â\u00012\u00020\u0001:\nÞ\u0001ß\u0001à\u0001á\u0001â\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010O\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J\b\u0010P\u001a\u000201H\u0002J\u0006\u0010^\u001a\u00020_J\b\u0010`\u001a\u000205H\u0002J\u0010\u0010a\u001a\u0002012\u0006\u0010b\u001a\u00020\u0014H\u0002J\u000e\u0010c\u001a\u000201H\u0086@¢\u0006\u0002\u0010dJ&\u0010e\u001a\u0002012\u0006\u0010f\u001a\u00020\u00162\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010h\u001a\u000205H\u0002J\u0017\u0010i\u001a\u0002012\f\u0010j\u001a\b\u0012\u0004\u0012\u0002010kH\u0082\bJ\u000e\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002J\u000e\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002J\b\u0010n\u001a\u000201H\u0002J\u0010\u0010o\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0002J\u0010\u0010q\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0002J\u0010\u0010r\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0002J\u0010\u0010s\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0002J\u0015\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020LH\u0000¢\u0006\u0002\bwJ\n\u0010x\u001a\u0004\u0018\u000108H\u0002J\b\u0010y\u001a\u000201H\u0002J\u0010\u0010z\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0002J\u000e\u0010}\u001a\u000201H\u0082@¢\u0006\u0002\u0010dJT\u0010~\u001a\u0002012C\u0010j\u001a?\b\u0001\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0017\u0012\u00150\u0081\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002010\u0085\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u007f¢\u0006\u0003\b\u0086\u0001H\u0082@¢\u0006\u0003\u0010\u0087\u0001J\u0007\u0010\u0088\u0001\u001a\u000201J\u0007\u0010\u0089\u0001\u001a\u000201J\u000f\u0010\u008a\u0001\u001a\u000201H\u0086@¢\u0006\u0002\u0010dJ\u0019\u0010\u008b\u0001\u001a\u00030\u008c\u00012\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u0002010kH\u0016J/\u0010\u008e\u0001\u001a\u0002012\u0006\u0010p\u001a\u00020\u00192\u0013\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u0002010k¢\u0006\u0003\b\u0090\u0001H\u0011¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J@\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0006\u0010p\u001a\u00020\u00192\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0013\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u0002010k¢\u0006\u0003\b\u0090\u0001H\u0011¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J8\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0006\u0010p\u001a\u00020\u00192\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u000e\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0094\u0001H\u0010¢\u0006\u0003\b\u009b\u0001J\u0018\u0010\u009c\u0001\u001a\u0002012\u0007\u0010\u009d\u0001\u001a\u00020>H\u0010¢\u0006\u0003\b\u009e\u0001J\u0011\u0010\u009f\u0001\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0002J$\u0010 \u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010p\u001a\u00020\u00192\u000f\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dH\u0002J/\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u001b2\u000f\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dH\u0002J\t\u0010¤\u0001\u001a\u000201H\u0002J\u001e\u0010¥\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002010¦\u00012\u0006\u0010p\u001a\u00020\u0019H\u0002J/\u0010§\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002010¦\u00012\u0006\u0010p\u001a\u00020\u00192\u000f\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dH\u0002J@\u0010¨\u0001\u001a\u0003H©\u0001\"\u0005\b\u0000\u0010©\u00012\u0006\u0010p\u001a\u00020\u00192\u000f\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\r\u0010j\u001a\t\u0012\u0005\u0012\u0003H©\u00010kH\u0082\b¢\u0006\u0003\u0010ª\u0001J\u0013\u0010«\u0001\u001a\u0002012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0002J\u000f\u0010²\u0001\u001a\u000201H\u0086@¢\u0006\u0002\u0010dJ\u0007\u0010³\u0001\u001a\u000201J\u0007\u0010´\u0001\u001a\u000201J \u0010À\u0001\u001a\u0002012\u000f\u0010Á\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Â\u0001H\u0010¢\u0006\u0003\bÄ\u0001J\u0017\u0010Å\u0001\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0010¢\u0006\u0003\bÆ\u0001J\u0017\u0010Ç\u0001\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0010¢\u0006\u0003\bÈ\u0001J\u0017\u0010É\u0001\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0010¢\u0006\u0003\bÊ\u0001J\u0018\u0010Ë\u0001\u001a\u0002012\u0007\u0010\u009d\u0001\u001a\u00020>H\u0010¢\u0006\u0003\bÌ\u0001J\u0018\u0010Í\u0001\u001a\u0002012\u0007\u0010Î\u0001\u001a\u00020\"H\u0010¢\u0006\u0003\bÏ\u0001J\u0018\u0010Ð\u0001\u001a\u0002012\u0007\u0010Î\u0001\u001a\u00020\"H\u0010¢\u0006\u0003\bÑ\u0001J/\u0010Ò\u0001\u001a\u0002012\u0007\u0010Î\u0001\u001a\u00020\"2\u0007\u0010Ó\u0001\u001a\u00020+2\f\u0010Ô\u0001\u001a\u0007\u0012\u0002\b\u00030Õ\u0001H\u0010¢\u0006\u0003\bÖ\u0001J\u0017\u0010×\u0001\u001a\u0002012\u0006\u0010p\u001a\u00020\u0019H\u0010¢\u0006\u0003\bØ\u0001J\u001a\u0010Ù\u0001\u001a\u0004\u0018\u00010+2\u0007\u0010Î\u0001\u001a\u00020\"H\u0010¢\u0006\u0003\bÚ\u0001R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100%\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010807X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;07X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020>\u0018\u00010\u001d0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010ER\u0014\u0010H\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010ER\u001c\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bM\u0010NR\u0014\u0010Q\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010ER \u0010S\u001a\b\u0012\u0004\u0012\u00020;0T8FX\u0087\u0004¢\u0006\f\u0012\u0004\bU\u0010N\u001a\u0004\bV\u0010WR\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020;0Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0012\u0010\\\u001a\u00060]R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010{\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010ER\u0013\u0010®\u0001\u001a\u0002058F¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010ER\u0016\u0010°\u0001\u001a\u0002058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010ER\u001b\u0010µ\u0001\u001a\u00070\u0007j\u0003`¶\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b·\u0001\u0010\nR\u0016\u0010¸\u0001\u001a\u0002058PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010ER\u0016\u0010º\u0001\u001a\u0002058PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010ER\u0016\u0010¼\u0001\u001a\u0002058PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b½\u0001\u0010ER\u0016\u0010¾\u0001\u001a\u0002058PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¿\u0001\u0010ER\u0019\u0010p\u001a\u0005\u0018\u00010Û\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\bÜ\u0001\u0010Ý\u0001¨\u0006ã\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "value", "", "changeCount", "getChangeCount", "()J", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "nextFrameEndCallbackQueue", "Landroidx/compose/runtime/NextFrameEndCallbackQueue;", "stateLock", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "runnerJob", "Lkotlinx/coroutines/Job;", "closeCause", "", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionsAwaitingApply", "movableContentAwaitingInsert", "Landroidx/compose/runtime/MovableContentStateReference;", "movableContentRemoved", "Landroidx/compose/runtime/collection/MultiValueMap;", "Landroidx/compose/runtime/MovableContent;", "Landroidx/collection/MutableScatterMap;", "movableContentNestedStatesAvailable", "Landroidx/compose/runtime/NestedContentMap;", "movableContentStatesAvailable", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/MovableContentState;", "movableContentNestedExtractionsPending", "failedCompositions", "compositionsRemoved", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "concurrentCompositionsOutstanding", "", "isClosed", "", "errorState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "frameClockPaused", "_state", "Landroidx/compose/runtime/Recomposer$State;", "pausedScopes", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "()Z", "hasNextFrameEndAwaitersLocked", "getHasNextFrameEndAwaitersLocked", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "registrationObservers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "getRegistrationObservers$annotations", "()V", "deriveStateLocked", "onNewFrameAwaiter", "shouldKeepRecomposing", "getShouldKeepRecomposing", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "recordComposerModifications", "registerRunnerJob", "callingJob", "runRecomposeAndApplyChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCompositionError", "e", "failedInitialComposition", "recoverable", "withTransparentSnapshot", "block", "Lkotlin/Function0;", "knownCompositions", "knownCompositionsLocked", "clearKnownCompositionsLocked", "removeKnownCompositionLocked", "composition", "addKnownCompositionLocked", "registerCompositionLocked", "unregisterCompositionLocked", "addCompositionRegistrationObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "addCompositionRegistrationObserver$runtime", "resetErrorState", "retryFailedCompositions", "recordFailedCompositionLocked", "hasSchedulingWork", "getHasSchedulingWork", "awaitWorkAvailable", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "close", "join", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "composeInitial", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "reportPausedScope", "scope", "reportPausedScope$runtime", "performInitialMovableContentInserts", "performRecompose", "modifiedValues", "performInsertValues", "references", "discardUnusedMovableContentState", "readObserverOf", "Lkotlin/Function1;", "writeObserverOf", "composing", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "hasPendingWork", "getHasPendingWork", "hasFrameWorkLocked", "getHasFrameWorkLocked", "awaitIdle", "pauseCompositionFrameClock", "resumeCompositionFrameClock", "compositeKeyHashCode", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getCompositeKeyHashCode$runtime", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "collectingParameterInformation", "getCollectingParameterInformation$runtime", "collectingSourceInformation", "getCollectingSourceInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime", "registerComposition", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "insertMovableContent", TypedValues.Custom.S_REFERENCE, "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "movableContentStateResolve", "movableContentStateResolve$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "State", "RecomposerInfoImpl", "HotReloadable", "RecomposerErrorState", "Companion", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    private final List<ControlledComposition> _knownCompositions;
    private List<? extends ControlledComposition> _knownCompositionsCache;
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector<ControlledComposition> compositionInvalidations;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private MutableScatterSet<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private MutableStateFlow<RecomposerErrorState> errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List<MovableContentStateReference> movableContentAwaitingInsert;
    private final MutableScatterMap<Object, Object> movableContentNestedExtractionsPending;
    private final NestedContentMap movableContentNestedStatesAvailable;
    private final MutableScatterMap<Object, Object> movableContentRemoved;
    private final MutableScatterMap<MovableContentStateReference, MovableContentState> movableContentStatesAvailable;
    private final NextFrameEndCallbackQueue nextFrameEndCallbackQueue;
    private final SnapshotThreadLocal<MutableScatterSet<RecomposeScopeImpl>> pausedScopes;
    private final RecomposerInfoImpl recomposerInfo;
    private MutableObjectList<CompositionRegistrationObserver> registrationObservers;
    private Job runnerJob;
    private MutableScatterSet<Object> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);

    private static /* synthetic */ void getRegistrationObservers$annotations() {
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public long getCompositeKeyHashCode$runtime() {
        return 1000L;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public Composition getComposition$runtime() {
        return null;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime(Set<CompositionData> set) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime(ControlledComposition controlledComposition) {
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Recomposer.broadcastFrameClock$lambda$0(Recomposer.this);
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.nextFrameEndCallbackQueue = new NextFrameEndCallbackQueue(new Function0() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Recomposer.nextFrameEndCallbackQueue$lambda$0(Recomposer.this);
            }
        });
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.movableContentAwaitingInsert = new ArrayList();
        this.movableContentRemoved = MultiValueMap.m4484constructorimpl$default(null, 1, null);
        this.movableContentNestedStatesAvailable = new NestedContentMap();
        this.movableContentStatesAvailable = ScatterMapKt.mutableScatterMapOf();
        this.movableContentNestedExtractionsPending = MultiValueMap.m4484constructorimpl$default(null, 1, null);
        this.errorState = StateFlowKt.MutableStateFlow(null);
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        this.pausedScopes = new SnapshotThreadLocal<>();
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.Key));
        Job.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit effectJob$lambda$0$0;
                effectJob$lambda$0$0 = Recomposer.effectJob$lambda$0$0(Recomposer.this, (Throwable) obj);
                return effectJob$lambda$0$0;
            }
        });
        this.effectJob = Job;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(Job);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit broadcastFrameClock$lambda$0(Recomposer recomposer) {
        recomposer.onNewFrameAwaiter();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit nextFrameEndCallbackQueue$lambda$0(Recomposer recomposer) {
        recomposer.onNewFrameAwaiter();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "<init>", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State ShutDown = new State("ShutDown", 0);
        public static final State ShuttingDown = new State("ShuttingDown", 1);
        public static final State Inactive = new State("Inactive", 2);
        public static final State InactivePendingWork = new State("InactivePendingWork", 3);
        public static final State Idle = new State("Idle", 4);
        public static final State PendingWork = new State("PendingWork", 5);

        private static final /* synthetic */ State[] $values() {
            return new State[]{ShutDown, ShuttingDown, Inactive, InactivePendingWork, Idle, PendingWork};
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        private State(String str, int i) {
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit effectJob$lambda$0$0(final Recomposer recomposer, final Throwable th) {
        CancellableContinuation<? super Unit> cancellableContinuation;
        CancellableContinuation<? super Unit> cancellableContinuation2;
        CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th);
        synchronized (recomposer.stateLock) {
            Job job = recomposer.runnerJob;
            cancellableContinuation = null;
            if (job != null) {
                recomposer._state.setValue(State.ShuttingDown);
                if (!recomposer.isClosed) {
                    job.cancel(CancellationException);
                } else {
                    cancellableContinuation2 = recomposer.workContinuation;
                    if (cancellableContinuation2 != null) {
                        recomposer.workContinuation = null;
                        job.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit effectJob$lambda$0$0$0$0;
                                effectJob$lambda$0$0$0$0 = Recomposer.effectJob$lambda$0$0$0$0(Recomposer.this, th, (Throwable) obj);
                                return effectJob$lambda$0$0$0$0;
                            }
                        });
                        cancellableContinuation = cancellableContinuation2;
                    }
                }
                cancellableContinuation2 = null;
                recomposer.workContinuation = null;
                job.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit effectJob$lambda$0$0$0$0;
                        effectJob$lambda$0$0$0$0 = Recomposer.effectJob$lambda$0$0$0$0(Recomposer.this, th, (Throwable) obj);
                        return effectJob$lambda$0$0$0$0;
                    }
                });
                cancellableContinuation = cancellableContinuation2;
            } else {
                recomposer.closeCause = CancellationException;
                recomposer._state.setValue(State.ShutDown);
                Unit unit = Unit.INSTANCE;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit effectJob$lambda$0$0$0$0(Recomposer recomposer, Throwable th, Throwable th2) {
        synchronized (recomposer.stateLock) {
            if (th == null) {
                th = null;
            } else if (th2 != null) {
                if (th2 instanceof CancellationException) {
                    th2 = null;
                }
                if (th2 != null) {
                    kotlin.ExceptionsKt.addSuppressed(th, th2);
                }
            }
            recomposer.closeCause = th;
            recomposer._state.setValue(State.ShutDown);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    private final boolean getHasNextFrameEndAwaitersLocked() {
        return !this.frameClockPaused && this.nextFrameEndCallbackQueue.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.movableContentAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState.setValue(null);
            return null;
        }
        if (this.errorState.getValue() != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            this.compositionInvalidations.clear();
            if (getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked()) {
                state = State.InactivePendingWork;
            } else {
                state = State.Inactive;
            }
        } else if (this.compositionInvalidations.getSize() != 0 || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.movableContentAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked() || MultiValueMap.m4493isNotEmptyimpl(this.movableContentRemoved)) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state == State.PendingWork) {
            CancellableContinuation cancellableContinuation2 = this.workContinuation;
            this.workContinuation = null;
            return cancellableContinuation2;
        }
        return null;
    }

    private final void onNewFrameAwaiter() {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            deriveStateLocked = deriveStateLocked();
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", this.closeCause);
            }
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (z) {
            for (Job job : this.effectJob.getChildren()) {
                if (job.isActive()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%J\b\u0010'\u001a\u0004\u0018\u00010(J\u0006\u0010)\u001a\u00020!R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "<init>", "(Landroidx/compose/runtime/Recomposer;)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "hasPendingWork", "", "getHasPendingWork", "()Z", "changeCount", "", "getChangeCount", "()J", "errorState", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/compose/runtime/RecomposerErrorInformation;", "getErrorState$annotations", "()V", "getErrorState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentError", "getCurrentError$annotations", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInformation;", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "invalidateGroupsWithKey", "", "key", "", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class RecomposerInfoImpl implements RecomposerInfo {
        public static /* synthetic */ void getCurrentError$annotations() {
        }

        public static /* synthetic */ void getErrorState$annotations() {
        }

        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public StateFlow<RecomposerErrorInformation> getErrorState() {
            return Recomposer.this.errorState;
        }

        public final RecomposerErrorInformation getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                recomposerErrorState = (RecomposerErrorState) recomposer.errorState.getValue();
            }
            return recomposerErrorState;
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public CompositionObserverHandle observe(CompositionRegistrationObserver compositionRegistrationObserver) {
            return CompositionObserverKt.observe(Recomposer.this, compositionRegistrationObserver);
        }

        public final void invalidateGroupsWithKey(int i) {
            List knownCompositions = Recomposer.this.knownCompositions();
            ArrayList arrayList = new ArrayList(knownCompositions.size());
            int size = knownCompositions.size();
            for (int i2 = 0; i2 < size; i2++) {
                ControlledComposition controlledComposition = (ControlledComposition) knownCompositions.get(i2);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((CompositionImpl) arrayList2.get(i3)).invalidateGroupsWithKey(i);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List knownCompositions = Recomposer.this.knownCompositions();
            ArrayList arrayList = new ArrayList(knownCompositions.size());
            int size = knownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) knownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList2.get(i2));
                hotReloadable.clearContent();
                arrayList3.add(hotReloadable);
            }
            return arrayList3;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/CompositionImpl;)V", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "resetContent", "recompose", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m4420getLambda$1091980426$runtime());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "Landroidx/compose/runtime/RecomposerErrorInformation;", "cause", "", "isRecoverable", "", "<init>", "(Ljava/lang/Throwable;Z)V", "getCause", "()Ljava/lang/Throwable;", "()Z", "recoverable", "getRecoverable", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RecomposerErrorState implements RecomposerErrorInfo, RecomposerErrorInformation {
        private final Throwable cause;
        private final boolean isRecoverable;

        public RecomposerErrorState(Throwable th, boolean z) {
            this.cause = th;
            this.isRecoverable = z;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo, androidx.compose.runtime.RecomposerErrorInformation
        public Throwable getCause() {
            return this.cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInformation
        public boolean isRecoverable() {
            return this.isRecoverable;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return isRecoverable();
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        boolean hasFrameWorkLocked;
        CollectionsKt.emptyList();
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            List<ControlledComposition> knownCompositionsLocked = knownCompositionsLocked();
            Set<? extends Object> wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            try {
                Recomposer recomposer = this;
                int size = knownCompositionsLocked.size();
                for (int i = 0; i < size; i++) {
                    knownCompositionsLocked.get(i).recordModificationsOf(wrapIntoSet);
                    if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(wrapIntoSet);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job job) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.runnerJob = job;
            if (deriveStateLocked() != null) {
                ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Throwable th, ControlledComposition controlledComposition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(th, controlledComposition, z);
    }

    private final void processCompositionError(Throwable th, ControlledComposition controlledComposition, boolean z) {
        if (_hotReloadEnabled.get().booleanValue() && !(th instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                Utils_androidKt.logError("Error was captured in composition while live edit was enabled.", th);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
                this.movableContentAwaitingInsert.clear();
                MultiValueMap.m4482clearimpl(this.movableContentRemoved);
                this.movableContentStatesAvailable.clear();
                this.errorState.setValue(new RecomposerErrorState(th, z));
                if (controlledComposition != null) {
                    recordFailedCompositionLocked(controlledComposition);
                }
                if (deriveStateLocked() != null) {
                    ComposerKt.composeImmediateRuntimeError("expected to go to inactive state due to composition error");
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        synchronized (this.stateLock) {
            Utils_androidKt.logError("Error was captured in composition.", th);
            RecomposerErrorState value = this.errorState.getValue();
            if (value == null) {
                this.errorState.setValue(new RecomposerErrorState(th, false));
                Unit unit2 = Unit.INSTANCE;
            } else {
                throw value.getCause();
            }
        }
        throw th;
    }

    private final void withTransparentSnapshot(Function0<Unit> function0) {
        TransparentObserverSnapshot transparentObserverSnapshot;
        Snapshot current = Snapshot.Companion.getCurrent();
        if (current instanceof MutableSnapshot) {
            transparentObserverSnapshot = new TransparentObserverMutableSnapshot((MutableSnapshot) current, null, null, true, false);
        } else {
            transparentObserverSnapshot = new TransparentObserverSnapshot(current, null, true, false);
        }
        try {
            Snapshot makeCurrent = transparentObserverSnapshot.makeCurrent();
            function0.invoke();
            transparentObserverSnapshot.restoreCurrent(makeCurrent);
        } finally {
            transparentObserverSnapshot.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> knownCompositions() {
        List<ControlledComposition> knownCompositionsLocked;
        synchronized (this.stateLock) {
            knownCompositionsLocked = knownCompositionsLocked();
        }
        return knownCompositionsLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> knownCompositionsLocked() {
        List list = this._knownCompositionsCache;
        if (list != null) {
            return list;
        }
        List<ControlledComposition> list2 = this._knownCompositions;
        ArrayList emptyList = list2.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list2);
        this._knownCompositionsCache = emptyList;
        return emptyList;
    }

    private final void clearKnownCompositionsLocked() {
        List<ControlledComposition> knownCompositionsLocked = knownCompositionsLocked();
        int size = knownCompositionsLocked.size();
        for (int i = 0; i < size; i++) {
            unregisterCompositionLocked(knownCompositionsLocked.get(i));
        }
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final void removeKnownCompositionLocked(ControlledComposition controlledComposition) {
        if (this._knownCompositions.remove(controlledComposition)) {
            this._knownCompositionsCache = null;
            unregisterCompositionLocked(controlledComposition);
        }
    }

    private final void addKnownCompositionLocked(ControlledComposition controlledComposition) {
        this._knownCompositions.add(controlledComposition);
        this._knownCompositionsCache = null;
    }

    private final void registerCompositionLocked(ControlledComposition controlledComposition) {
        MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
        if (mutableObjectList != null) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList2 = mutableObjectList;
            Object[] objArr = mutableObjectList2.content;
            int i = mutableObjectList2._size;
            for (int i2 = 0; i2 < i; i2++) {
                CompositionRegistrationObserver compositionRegistrationObserver = (CompositionRegistrationObserver) objArr[i2];
                if (controlledComposition instanceof ObservableComposition) {
                    compositionRegistrationObserver.onCompositionRegistered((ObservableComposition) controlledComposition);
                }
            }
        }
    }

    private final void unregisterCompositionLocked(ControlledComposition controlledComposition) {
        MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
        if (mutableObjectList != null) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList2 = mutableObjectList;
            Object[] objArr = mutableObjectList2.content;
            int i = mutableObjectList2._size;
            for (int i2 = 0; i2 < i; i2++) {
                CompositionRegistrationObserver compositionRegistrationObserver = (CompositionRegistrationObserver) objArr[i2];
                if (controlledComposition instanceof ObservableComposition) {
                    compositionRegistrationObserver.onCompositionUnregistered((ObservableComposition) controlledComposition);
                }
            }
        }
    }

    public final CompositionObserverHandle addCompositionRegistrationObserver$runtime(final CompositionRegistrationObserver compositionRegistrationObserver) {
        synchronized (this.stateLock) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(0, 1, null);
                this.registrationObservers = mutableObjectList;
            }
            mutableObjectList.add(compositionRegistrationObserver);
            List<ControlledComposition> list = this._knownCompositions;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = list.get(i);
                if (controlledComposition instanceof ObservableComposition) {
                    compositionRegistrationObserver.onCompositionRegistered((ObservableComposition) controlledComposition);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.Recomposer$addCompositionRegistrationObserver$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                MutableObjectList mutableObjectList2;
                Object obj = Recomposer.this.stateLock;
                Recomposer recomposer = Recomposer.this;
                CompositionRegistrationObserver compositionRegistrationObserver2 = compositionRegistrationObserver;
                synchronized (obj) {
                    mutableObjectList2 = recomposer.registrationObservers;
                    if (mutableObjectList2 != null) {
                        Boolean.valueOf(mutableObjectList2.remove(compositionRegistrationObserver2));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState value;
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            value = this.errorState.getValue();
            cancellableContinuation = null;
            if (value != null) {
                this.errorState.setValue(null);
                cancellableContinuation = deriveStateLocked();
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        int i;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list == null) {
            return;
        }
        while (true) {
            i = 0;
            try {
                if (list.isEmpty()) {
                    break;
                }
                ControlledComposition controlledComposition = (ControlledComposition) CollectionsKt.removeLast(list);
                if (controlledComposition instanceof CompositionImpl) {
                    ((CompositionImpl) controlledComposition).invalidateAll();
                    ((CompositionImpl) controlledComposition).setContent(((CompositionImpl) controlledComposition).getComposable());
                    if (this.errorState.getValue() != null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!list.isEmpty()) {
                    synchronized (this.stateLock) {
                        int size = list.size();
                        while (i < size) {
                            recordFailedCompositionLocked(list.get(i));
                            i++;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                throw th;
            }
        }
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.stateLock) {
            int size2 = list.size();
            while (i < size2) {
                recordFailedCompositionLocked(list.get(i));
                i++;
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition controlledComposition) {
        ArrayList arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(controlledComposition)) {
            arrayList.add(controlledComposition);
        }
        removeKnownCompositionLocked(controlledComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (!this.snapshotInvalidations.isNotEmpty() && this.compositionInvalidations.getSize() == 0 && !getHasBroadcastFrameClockAwaitersLocked()) {
                z = getHasNextFrameEndAwaitersLocked();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        synchronized (this.stateLock) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = cancellableContinuationImpl2;
                cancellableContinuationImpl2 = null;
            }
        }
        if (cancellableContinuationImpl2 != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl2.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2(null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CancellationHandle scheduleFrameEndCallback(Function0<Unit> function0) {
        return this.nextFrameEndCallbackQueue.scheduleFrameEndCallback(function0);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
        boolean z;
        boolean isComposing = controlledComposition.isComposing();
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                boolean contains = knownCompositionsLocked().contains(controlledComposition);
                z = !contains;
                if (!contains) {
                    registerCompositionLocked(controlledComposition);
                }
            } else {
                z = true;
            }
        }
        try {
            MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, null));
            MutableSnapshot mutableSnapshot = takeMutableSnapshot;
            Snapshot makeCurrent = mutableSnapshot.makeCurrent();
            try {
                controlledComposition.composeContent(function2);
                Unit unit = Unit.INSTANCE;
                mutableSnapshot.restoreCurrent(makeCurrent);
                applyAndCheck(takeMutableSnapshot);
                synchronized (this.stateLock) {
                    if (this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                        if (!knownCompositionsLocked().contains(controlledComposition)) {
                            addKnownCompositionLocked(controlledComposition);
                        }
                    } else {
                        unregisterCompositionLocked(controlledComposition);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
                if (!isComposing) {
                    Snapshot.Companion.notifyObjectsInitialized();
                }
                try {
                    performInitialMovableContentInserts(controlledComposition);
                    try {
                        controlledComposition.applyChanges();
                        controlledComposition.applyLateChanges();
                        if (isComposing) {
                            return;
                        }
                        Snapshot.Companion.notifyObjectsInitialized();
                    } catch (Throwable th) {
                        processCompositionError$default(this, th, null, false, 6, null);
                    }
                } catch (Throwable th2) {
                    processCompositionError(th2, controlledComposition, true);
                }
            } catch (Throwable th3) {
                mutableSnapshot.restoreCurrent(makeCurrent);
                throw th3;
            }
        } catch (Throwable th4) {
            if (z) {
                synchronized (this.stateLock) {
                    unregisterCompositionLocked(controlledComposition);
                    Unit unit3 = Unit.INSTANCE;
                }
            }
            processCompositionError(th4, controlledComposition, true);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition controlledComposition, ShouldPauseCallback shouldPauseCallback, ScatterSet<RecomposeScopeImpl> scatterSet) {
        try {
            recordComposerModifications();
            controlledComposition.recordModificationsOf(ScatterSetWrapperKt.wrapIntoSet(scatterSet));
            ShouldPauseCallback andSetShouldPauseCallback = controlledComposition.getAndSetShouldPauseCallback(shouldPauseCallback);
            ControlledComposition performRecompose = performRecompose(controlledComposition, null);
            if (performRecompose != null) {
                performInitialMovableContentInserts(controlledComposition);
                performRecompose.applyChanges();
                performRecompose.applyLateChanges();
            }
            MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.pausedScopes.get();
            MutableScatterSet<RecomposeScopeImpl> emptyScatterSet = mutableScatterSet != null ? mutableScatterSet : ScatterSetKt.emptyScatterSet();
            controlledComposition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
            return emptyScatterSet;
        } finally {
            this.pausedScopes.set(null);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportPausedScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.pausedScopes.get();
        if (mutableScatterSet == null) {
            mutableScatterSet = ScatterSetKt.mutableScatterSetOf();
            this.pausedScopes.set(mutableScatterSet);
        }
        mutableScatterSet.add(recomposeScopeImpl);
    }

    private final void performInitialMovableContentInserts(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.movableContentAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(list.get(i).getComposition$runtime(), controlledComposition)) {
                    Unit unit = Unit.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, controlledComposition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, controlledComposition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.movableContentAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (Intrinsics.areEqual(next.getComposition$runtime(), controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition controlledComposition, final MutableScatterSet<Object> mutableScatterSet) {
        MutableScatterSet<ControlledComposition> mutableScatterSet2;
        if (controlledComposition.isComposing() || controlledComposition.isDisposed() || ((mutableScatterSet2 = this.compositionsRemoved) != null && mutableScatterSet2.contains(controlledComposition))) {
            return null;
        }
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, mutableScatterSet));
        try {
            MutableSnapshot mutableSnapshot = takeMutableSnapshot;
            Snapshot makeCurrent = mutableSnapshot.makeCurrent();
            if (mutableScatterSet != null && mutableScatterSet.isNotEmpty()) {
                controlledComposition.prepareCompose(new Function0() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit performRecompose$lambda$0$0;
                        performRecompose$lambda$0$0 = Recomposer.performRecompose$lambda$0$0(MutableScatterSet.this, controlledComposition);
                        return performRecompose$lambda$0$0;
                    }
                });
            }
            boolean recompose = controlledComposition.recompose();
            mutableSnapshot.restoreCurrent(makeCurrent);
            if (recompose) {
                return controlledComposition;
            }
            return null;
        } finally {
            applyAndCheck(takeMutableSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit performRecompose$lambda$0$0(MutableScatterSet mutableScatterSet, ControlledComposition controlledComposition) {
        MutableScatterSet mutableScatterSet2 = mutableScatterSet;
        Object[] objArr = mutableScatterSet2.elements;
        long[] jArr = mutableScatterSet2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            controlledComposition.recordWriteOf(objArr[(i << 3) + i3]);
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedMovableContentState() {
        int i;
        MutableObjectList emptyObjectList;
        synchronized (this.stateLock) {
            if (MultiValueMap.m4493isNotEmptyimpl(this.movableContentRemoved)) {
                ObjectList m4498valuesimpl = MultiValueMap.m4498valuesimpl(this.movableContentRemoved);
                MultiValueMap.m4482clearimpl(this.movableContentRemoved);
                this.movableContentNestedStatesAvailable.clear();
                MultiValueMap.m4482clearimpl(this.movableContentNestedExtractionsPending);
                MutableObjectList mutableObjectList = new MutableObjectList(m4498valuesimpl.getSize());
                Object[] objArr = m4498valuesimpl.content;
                int i2 = m4498valuesimpl._size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr[i3];
                    mutableObjectList.add(TuplesKt.to(movableContentStateReference, this.movableContentStatesAvailable.get(movableContentStateReference)));
                }
                emptyObjectList = mutableObjectList;
                this.movableContentStatesAvailable.clear();
            } else {
                emptyObjectList = ObjectListKt.emptyObjectList();
            }
        }
        Object[] objArr2 = emptyObjectList.content;
        int i4 = emptyObjectList._size;
        for (i = 0; i < i4; i++) {
            Pair pair = (Pair) objArr2[i];
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition$runtime().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition controlledComposition) {
        return new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Recomposer.readObserverOf$lambda$0(ControlledComposition.this, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit readObserverOf$lambda$0(ControlledComposition controlledComposition, Object obj) {
        controlledComposition.recordReadOf(obj);
        return Unit.INSTANCE;
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition controlledComposition, final MutableScatterSet<Object> mutableScatterSet) {
        return new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Recomposer.writeObserverOf$lambda$0(ControlledComposition.this, mutableScatterSet, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit writeObserverOf$lambda$0(ControlledComposition controlledComposition, MutableScatterSet mutableScatterSet, Object obj) {
        controlledComposition.recordWriteOf(obj);
        if (mutableScatterSet != null) {
            mutableScatterSet.add(obj);
        }
        return Unit.INSTANCE;
    }

    private final <T> T composing(ControlledComposition controlledComposition, MutableScatterSet<Object> mutableScatterSet, Function0<? extends T> function0) {
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, mutableScatterSet));
        try {
            MutableSnapshot mutableSnapshot = takeMutableSnapshot;
            Snapshot makeCurrent = mutableSnapshot.makeCurrent();
            T invoke = function0.invoke();
            mutableSnapshot.restoreCurrent(makeCurrent);
            return invoke;
        } finally {
            applyAndCheck(takeMutableSnapshot);
        }
    }

    private final void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            mutableSnapshot.dispose();
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (!this.snapshotInvalidations.isNotEmpty() && this.compositionInvalidations.getSize() == 0 && this.concurrentCompositionsOutstanding <= 0 && this.compositionsAwaitingApply.isEmpty() && !getHasBroadcastFrameClockAwaitersLocked() && !getHasNextFrameEndAwaitersLocked()) {
                z = MultiValueMap.m4493isNotEmptyimpl(this.movableContentRemoved);
            }
        }
        return z;
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.getSize() != 0 || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked() || MultiValueMap.m4493isNotEmptyimpl(this.movableContentRemoved);
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2(null)), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingSourceInformation$runtime() {
        return ComposeStackTraceMode.m4763equalsimpl0(ComposerKt.getComposeStackTraceMode(), ComposeStackTraceMode.Companion.m4770getSourceInformationMD5MrJc());
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getStackTraceEnabled$runtime() {
        return !ComposeStackTraceMode.m4763equalsimpl0(ComposerKt.getComposeStackTraceMode(), ComposeStackTraceMode.Companion.m4769getNoneMD5MrJc());
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(controlledComposition);
            this.compositionInvalidations.remove(controlledComposition);
            this.compositionsAwaitingApply.remove(controlledComposition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime(ControlledComposition controlledComposition) {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(controlledComposition)) {
                cancellableContinuation = null;
            } else {
                this.compositionInvalidations.add(controlledComposition);
                cancellableContinuation = deriveStateLocked();
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(recomposeScopeImpl);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime(MovableContentStateReference movableContentStateReference) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.movableContentAwaitingInsert.add(movableContentStateReference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime(MovableContentStateReference movableContentStateReference) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            MultiValueMap.m4480addimpl(this.movableContentRemoved, movableContentStateReference.getContent$runtime(), movableContentStateReference);
            if (movableContentStateReference.getNestedReferences$runtime() != null) {
                deletedMovableContent$lambda$0$recordNestedStatesOf(this, movableContentStateReference, movableContentStateReference);
            }
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m9842constructorimpl(Unit.INSTANCE));
        }
    }

    private static final void deletedMovableContent$lambda$0$recordNestedStatesOf(Recomposer recomposer, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        List<MovableContentStateReference> nestedReferences$runtime = movableContentStateReference2.getNestedReferences$runtime();
        if (nestedReferences$runtime != null) {
            int size = nestedReferences$runtime.size();
            for (int i = 0; i < size; i++) {
                MovableContentStateReference movableContentStateReference3 = nestedReferences$runtime.get(i);
                recomposer.movableContentNestedStatesAvailable.add(movableContentStateReference3.getContent$runtime(), new NestedMovableContent(movableContentStateReference3, movableContentStateReference));
                deletedMovableContent$lambda$0$recordNestedStatesOf(recomposer, movableContentStateReference, movableContentStateReference3);
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState, Applier<?> applier) {
        synchronized (this.stateLock) {
            this.movableContentStatesAvailable.set(movableContentStateReference, movableContentState);
            ObjectList<MovableContentStateReference> m4490getimpl = MultiValueMap.m4490getimpl(this.movableContentNestedExtractionsPending, movableContentStateReference);
            if (m4490getimpl.isNotEmpty()) {
                ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates = movableContentState.getSlotStorage$runtime().extractNestedStates(applier, m4490getimpl);
                Object[] objArr = extractNestedStates.keys;
                Object[] objArr2 = extractNestedStates.values;
                long[] jArr = extractNestedStates.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    int i4 = (i << 3) + i3;
                                    this.movableContentStatesAvailable.set((MovableContentStateReference) objArr[i4], (MovableContentState) objArr2[i4]);
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
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            MutableScatterSet<ControlledComposition> mutableScatterSet = this.compositionsRemoved;
            if (mutableScatterSet == null) {
                mutableScatterSet = ScatterSetKt.mutableScatterSetOf();
                this.compositionsRemoved = mutableScatterSet;
            }
            mutableScatterSet.add(controlledComposition);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference movableContentStateReference) {
        MovableContentState remove;
        synchronized (this.stateLock) {
            remove = this.movableContentStatesAvailable.remove(movableContentStateReference);
        }
        return remove;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0017J\u0014\u0010\u0018\u001a\u00020\u00152\n\u0010\u0019\u001a\u00060\u0007R\u00020\bH\u0002J\u0014\u0010\u001a\u001a\u00020\u00152\n\u0010\u0019\u001a\u00060\u0007R\u00020\bH\u0002J\r\u0010\u001b\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u001cJ\u0015\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0000¢\u0006\u0002\b'J\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020)0%H\u0000¢\u0006\u0002\b*J\r\u0010+\u001a\u00020\u0015H\u0000¢\u0006\u0002\b,R\u001e\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007R\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "<init>", "()V", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "setHotReloadEnabled", "", "value", "setHotReloadEnabled$runtime", "addRunning", "info", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime", "getRecomposerErrors", "Landroidx/compose/runtime/RecomposerErrorInformation;", "getRecomposerErrors$runtime", "clearErrors", "clearErrors$runtime", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void setHotReloadEnabled$runtime(boolean z) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet add;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                add = persistentSet.add((PersistentSet) recomposerInfoImpl);
                if (persistentSet == add) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, add));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet remove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                remove = persistentSet.remove((PersistentSet) recomposerInfoImpl);
                if (persistentSet == remove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, remove));
        }

        public final Object saveStateAndDisposeForHotReload$runtime() {
            Recomposer._hotReloadEnabled.set(true);
            ArrayList arrayList = new ArrayList();
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                CollectionsKt.addAll(arrayList, recomposerInfoImpl.saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }

        public final void loadStateAndComposeForHotReload$runtime(Object obj) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                recomposerInfoImpl.resetErrorState();
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List list = (List) obj;
            List list2 = list;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
            for (RecomposerInfoImpl recomposerInfoImpl2 : (Iterable) Recomposer._runningRecomposers.getValue()) {
                recomposerInfoImpl2.retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime(int i) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInformation currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.isRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(i);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime() {
            ArrayList arrayList = new ArrayList();
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInformation currentError = recomposerInfoImpl.getCurrentError();
                RecomposerErrorInfo recomposerErrorInfo = currentError instanceof RecomposerErrorInfo ? (RecomposerErrorInfo) currentError : null;
                if (recomposerErrorInfo != null) {
                    arrayList.add(recomposerErrorInfo);
                }
            }
            return arrayList;
        }

        public final List<RecomposerErrorInformation> getRecomposerErrors$runtime() {
            ArrayList arrayList = new ArrayList();
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInformation currentError = recomposerInfoImpl.getCurrentError();
                if (currentError != null) {
                    arrayList.add(currentError);
                }
            }
            return arrayList;
        }

        public final void clearErrors$runtime() {
            ArrayList arrayList = new ArrayList();
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorState resetErrorState = recomposerInfoImpl.resetErrorState();
                if (resetErrorState != null) {
                    arrayList.add(resetErrorState);
                }
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition controlledComposition, ShouldPauseCallback shouldPauseCallback, Function2<? super Composer, ? super Integer, Unit> function2) {
        try {
            ShouldPauseCallback andSetShouldPauseCallback = controlledComposition.getAndSetShouldPauseCallback(shouldPauseCallback);
            composeInitial$runtime(controlledComposition, function2);
            MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.pausedScopes.get();
            MutableScatterSet<RecomposeScopeImpl> emptyScatterSet = mutableScatterSet != null ? mutableScatterSet : ScatterSetKt.emptyScatterSet();
            controlledComposition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
            return emptyScatterSet;
        } finally {
            this.pausedScopes.set(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> list, MutableScatterSet<Object> mutableScatterSet) {
        Iterator it;
        HashMap hashMap;
        ArrayList arrayList;
        NestedMovableContent removeLast;
        HashMap hashMap2;
        HashMap hashMap3 = new HashMap(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MovableContentStateReference movableContentStateReference = list.get(i);
            ControlledComposition composition$runtime = movableContentStateReference.getComposition$runtime();
            HashMap hashMap4 = hashMap3;
            Object obj = hashMap4.get(composition$runtime);
            if (obj == null) {
                obj = new ArrayList();
                hashMap4.put(composition$runtime, obj);
            }
            ((ArrayList) obj).add(movableContentStateReference);
        }
        HashMap hashMap5 = hashMap3;
        Iterator it2 = hashMap5.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list2 = (List) entry.getValue();
            if (controlledComposition.isComposing()) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, mutableScatterSet));
            try {
                MutableSnapshot mutableSnapshot = takeMutableSnapshot;
                Snapshot makeCurrent = mutableSnapshot.makeCurrent();
                synchronized (this.stateLock) {
                    ArrayList arrayList2 = new ArrayList(list2.size());
                    int size2 = list2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        ArrayList arrayList3 = arrayList2;
                        MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list2.get(i2);
                        Iterator it3 = it2;
                        Object m4495removeLastimpl = MultiValueMap.m4495removeLastimpl(this.movableContentRemoved, movableContentStateReference2.getContent$runtime());
                        MovableContentStateReference movableContentStateReference3 = (MovableContentStateReference) m4495removeLastimpl;
                        if (movableContentStateReference3 != null) {
                            hashMap2 = hashMap5;
                            this.movableContentNestedStatesAvailable.usedContainer(movableContentStateReference3);
                        } else {
                            hashMap2 = hashMap5;
                        }
                        arrayList3.add(TuplesKt.to(movableContentStateReference2, m4495removeLastimpl));
                        i2++;
                        it2 = it3;
                        hashMap5 = hashMap2;
                    }
                    it = it2;
                    hashMap = hashMap5;
                    arrayList = arrayList2;
                    int size3 = arrayList.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size3) {
                            break;
                        }
                        Pair<MovableContentStateReference, MovableContentStateReference> pair = arrayList.get(i3);
                        if (pair.getSecond() == null && this.movableContentNestedStatesAvailable.contains(pair.getFirst().getContent$runtime())) {
                            ArrayList arrayList4 = new ArrayList(arrayList.size());
                            int size4 = arrayList.size();
                            for (int i4 = 0; i4 < size4; i4++) {
                                ArrayList arrayList5 = arrayList4;
                                Pair<MovableContentStateReference, MovableContentStateReference> pair2 = arrayList.get(i4);
                                if (pair2.getSecond() == null && (removeLast = this.movableContentNestedStatesAvailable.removeLast(pair2.getFirst().getContent$runtime())) != null) {
                                    MovableContentStateReference content = removeLast.getContent();
                                    MultiValueMap.m4480addimpl(this.movableContentNestedExtractionsPending, removeLast.getContainer(), content);
                                    pair2 = TuplesKt.to(pair2.getFirst(), content);
                                }
                                arrayList5.add(pair2);
                            }
                            arrayList = arrayList4;
                        } else {
                            i3++;
                        }
                    }
                }
                int size5 = arrayList.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size5) {
                        break;
                    } else if (arrayList.get(i5).getSecond() == null) {
                        i5++;
                    } else {
                        int size6 = arrayList.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size6) {
                                break;
                            } else if (arrayList.get(i6).getSecond() != null) {
                                i6++;
                            } else {
                                ArrayList arrayList6 = new ArrayList(arrayList.size());
                                int size7 = arrayList.size();
                                for (int i7 = 0; i7 < size7; i7++) {
                                    Pair<MovableContentStateReference, MovableContentStateReference> pair3 = arrayList.get(i7);
                                    MovableContentStateReference first = pair3.getSecond() == null ? pair3.getFirst() : null;
                                    if (first != null) {
                                        arrayList6.add(first);
                                    }
                                }
                                ArrayList arrayList7 = arrayList6;
                                synchronized (this.stateLock) {
                                    CollectionsKt.addAll(this.movableContentAwaitingInsert, arrayList7);
                                    Unit unit = Unit.INSTANCE;
                                }
                                ArrayList arrayList8 = new ArrayList(arrayList.size());
                                int size8 = arrayList.size();
                                for (int i8 = 0; i8 < size8; i8++) {
                                    Pair<MovableContentStateReference, MovableContentStateReference> pair4 = arrayList.get(i8);
                                    if (pair4.getSecond() != null) {
                                        arrayList8.add(pair4);
                                    }
                                }
                                arrayList = arrayList8;
                            }
                        }
                    }
                }
                controlledComposition.insertMovableContent(arrayList);
                Unit unit2 = Unit.INSTANCE;
                mutableSnapshot.restoreCurrent(makeCurrent);
                applyAndCheck(takeMutableSnapshot);
                it2 = it;
                hashMap5 = hashMap;
            } catch (Throwable th) {
                applyAndCheck(takeMutableSnapshot);
                throw th;
            }
        }
        return CollectionsKt.toList(hashMap5.keySet());
    }
}
