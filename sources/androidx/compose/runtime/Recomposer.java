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
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.internal.Utils_androidKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
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
import java.util.LinkedHashSet;
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
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
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
@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ã\u00012\u00020\u0001:\nß\u0001à\u0001á\u0001â\u0001ã\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010N\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/H\u0002J\u0006\u0010\\\u001a\u00020]J\b\u0010^\u001a\u000204H\u0002J\u001d\u0010^\u001a\u0002002\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002000`H\u0082\bJ\u0010\u0010a\u001a\u0002002\u0006\u0010b\u001a\u00020\u0012H\u0002J\u000e\u0010c\u001a\u000200H\u0086@¢\u0006\u0002\u0010dJ&\u0010e\u001a\u0002002\u0006\u0010f\u001a\u00020\u00142\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010h\u001a\u000204H\u0002J\u0017\u0010i\u001a\u0002002\f\u0010j\u001a\b\u0012\u0004\u0012\u0002000kH\u0082\bJ\u000e\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0002J\u000e\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0002J\b\u0010n\u001a\u000200H\u0002J\u0010\u0010o\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0002J\u0010\u0010q\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0002J\u0010\u0010r\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0002J\u0010\u0010s\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0002J\u0015\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020KH\u0000¢\u0006\u0002\bwJ\n\u0010x\u001a\u0004\u0018\u000106H\u0002J\b\u0010y\u001a\u000200H\u0002J\u0010\u0010z\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0002J\u0016\u0010{\u001a\u0002002\u0006\u0010B\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010|J!\u0010}\u001a\u0002002\u0006\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0082@¢\u0006\u0003\u0010\u0082\u0001J\u000f\u0010\u0085\u0001\u001a\u000200H\u0082@¢\u0006\u0002\u0010dJT\u0010\u0086\u0001\u001a\u0002002B\u0010j\u001a>\b\u0001\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0015\u0012\u00130\u007f¢\u0006\u000e\b\u0089\u0001\u0012\t\b\u008a\u0001\u0012\u0004\b\b(~\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002000\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0087\u0001¢\u0006\u0003\b\u008c\u0001H\u0082@¢\u0006\u0003\u0010\u008d\u0001J\u0007\u0010\u008e\u0001\u001a\u000200J\u0007\u0010\u008f\u0001\u001a\u000200J\u000f\u0010\u0090\u0001\u001a\u000200H\u0086@¢\u0006\u0002\u0010dJ/\u0010\u0091\u0001\u001a\u0002002\u0006\u0010p\u001a\u00020\u00172\u0013\u0010\u0092\u0001\u001a\u000e\u0012\u0004\u0012\u0002000k¢\u0006\u0003\b\u0093\u0001H\u0010¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J@\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020=0\u0097\u00012\u0006\u0010p\u001a\u00020\u00172\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0013\u0010\u0092\u0001\u001a\u000e\u0012\u0004\u0012\u0002000k¢\u0006\u0003\b\u0093\u0001H\u0010¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J8\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020=0\u0097\u00012\u0006\u0010p\u001a\u00020\u00172\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u000e\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020=0\u0097\u0001H\u0010¢\u0006\u0003\b\u009e\u0001J\u0018\u0010\u009f\u0001\u001a\u0002002\u0007\u0010 \u0001\u001a\u00020=H\u0010¢\u0006\u0003\b¡\u0001J\u0011\u0010¢\u0001\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0002J$\u0010£\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010p\u001a\u00020\u00172\u000f\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bH\u0002J/\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020 0\u00192\u000f\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bH\u0002J\t\u0010§\u0001\u001a\u000200H\u0002J\u001d\u0010¨\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002000`2\u0006\u0010p\u001a\u00020\u0017H\u0002J.\u0010©\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002000`2\u0006\u0010p\u001a\u00020\u00172\u000f\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bH\u0002J@\u0010ª\u0001\u001a\u0003H«\u0001\"\u0005\b\u0000\u0010«\u00012\u0006\u0010p\u001a\u00020\u00172\u000f\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001b2\r\u0010j\u001a\t\u0012\u0005\u0012\u0003H«\u00010kH\u0082\b¢\u0006\u0003\u0010¬\u0001J\u0013\u0010\u00ad\u0001\u001a\u0002002\b\u0010®\u0001\u001a\u00030¯\u0001H\u0002J\u000f\u0010¶\u0001\u001a\u000200H\u0086@¢\u0006\u0002\u0010dJ\u0007\u0010·\u0001\u001a\u000200J\u0007\u0010¸\u0001\u001a\u000200J\u001f\u0010Â\u0001\u001a\u0002002\u000e\u0010Ã\u0001\u001a\t\u0012\u0005\u0012\u00030Ä\u00010-H\u0010¢\u0006\u0003\bÅ\u0001J\u0017\u0010Æ\u0001\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0010¢\u0006\u0003\bÇ\u0001J\u0017\u0010È\u0001\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0010¢\u0006\u0003\bÉ\u0001J\u0017\u0010Ê\u0001\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0010¢\u0006\u0003\bË\u0001J\u0018\u0010Ì\u0001\u001a\u0002002\u0007\u0010 \u0001\u001a\u00020=H\u0010¢\u0006\u0003\bÍ\u0001J\u0018\u0010Î\u0001\u001a\u0002002\u0007\u0010Ï\u0001\u001a\u00020 H\u0010¢\u0006\u0003\bÐ\u0001J\u0018\u0010Ñ\u0001\u001a\u0002002\u0007\u0010Ï\u0001\u001a\u00020 H\u0010¢\u0006\u0003\bÒ\u0001J/\u0010Ó\u0001\u001a\u0002002\u0007\u0010Ï\u0001\u001a\u00020 2\u0007\u0010Ô\u0001\u001a\u00020)2\f\u0010Õ\u0001\u001a\u0007\u0012\u0002\b\u00030Ö\u0001H\u0010¢\u0006\u0003\b×\u0001J\u0017\u0010Ø\u0001\u001a\u0002002\u0006\u0010p\u001a\u00020\u0017H\u0010¢\u0006\u0003\bÙ\u0001J\u001a\u0010Ú\u0001\u001a\u0004\u0018\u00010)2\u0007\u0010Ï\u0001\u001a\u00020 H\u0010¢\u0006\u0003\bÛ\u0001R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010!\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0#\u0012\u0004\u0012\u00020 0\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020=\u0018\u00010\u001b0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bC\u0010AR\u0014\u0010D\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010FR\u001c\u0010I\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bL\u0010MR\u0014\u0010O\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010FR \u0010Q\u001a\b\u0012\u0004\u0012\u00020:0R8FX\u0087\u0004¢\u0006\f\u0012\u0004\bS\u0010M\u001a\u0004\bT\u0010UR\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020:0W8F¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0012\u0010Z\u001a\u00060[R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0083\u0001\u001a\u0002048BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010FR\u0013\u0010°\u0001\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b±\u0001\u0010FR\u0016\u0010²\u0001\u001a\u0002048BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b³\u0001\u0010FR\u0016\u0010´\u0001\u001a\u0002048BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bµ\u0001\u0010FR\u001b\u0010¹\u0001\u001a\u00070\u0007j\u0003`º\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010\nR\u0016\u0010¼\u0001\u001a\u0002048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b½\u0001\u0010FR\u0016\u0010¾\u0001\u001a\u0002048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¿\u0001\u0010FR\u0016\u0010À\u0001\u001a\u0002048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010FR\u0019\u0010p\u001a\u0005\u0018\u00010Ü\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Þ\u0001¨\u0006ä\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "value", "", "changeCount", "getChangeCount", "()J", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "stateLock", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "runnerJob", "Lkotlinx/coroutines/Job;", "closeCause", "", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionsAwaitingApply", "movableContentAwaitingInsert", "Landroidx/compose/runtime/MovableContentStateReference;", "movableContentRemoved", "Landroidx/compose/runtime/collection/MultiValueMap;", "Landroidx/compose/runtime/MovableContent;", "Landroidx/collection/MutableScatterMap;", "movableContentNestedStatesAvailable", "Landroidx/compose/runtime/NestedContentMap;", "movableContentStatesAvailable", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/MovableContentState;", "movableContentNestedExtractionsPending", "failedCompositions", "compositionsRemoved", "", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "concurrentCompositionsOutstanding", "", "isClosed", "", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "frameClockPaused", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "pausedScopes", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "()Z", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "registrationObservers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "getRegistrationObservers$annotations", "()V", "deriveStateLocked", "shouldKeepRecomposing", "getShouldKeepRecomposing", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "recordComposerModifications", "onEachInvalidComposition", "Lkotlin/Function1;", "registerRunnerJob", "callingJob", "runRecomposeAndApplyChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCompositionError", "e", "failedInitialComposition", "recoverable", "withTransparentSnapshot", "block", "Lkotlin/Function0;", "knownCompositions", "knownCompositionsLocked", "clearKnownCompositionsLocked", "removeKnownCompositionLocked", "composition", "addKnownCompositionLocked", "registerCompositionLocked", "unregisterCompositionLocked", "addCompositionRegistrationObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "addCompositionRegistrationObserver$runtime", "resetErrorState", "retryFailedCompositions", "recordFailedCompositionLocked", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runFrameLoop", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasSchedulingWork", "getHasSchedulingWork", "awaitWorkAvailable", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "close", "join", "composeInitial", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "reportPausedScope", "scope", "reportPausedScope$runtime", "performInitialMovableContentInserts", "performRecompose", "modifiedValues", "performInsertValues", "references", "discardUnusedMovableContentState", "readObserverOf", "writeObserverOf", "composing", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "hasPendingWork", "getHasPendingWork", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "awaitIdle", "pauseCompositionFrameClock", "resumeCompositionFrameClock", "compositeKeyHashCode", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getCompositeKeyHashCode$runtime", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "collectingParameterInformation", "getCollectingParameterInformation$runtime", "collectingSourceInformation", "getCollectingSourceInformation$runtime", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime", "registerComposition", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "insertMovableContent", TypedValues.Custom.S_REFERENCE, "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "movableContentStateResolve", "movableContentStateResolve$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "State", "RecomposerInfoImpl", "HotReloadable", "RecomposerErrorState", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List<MovableContentStateReference> movableContentAwaitingInsert;
    private final MutableScatterMap<Object, Object> movableContentNestedExtractionsPending;
    private final NestedContentMap movableContentNestedStatesAvailable;
    private final MutableScatterMap<Object, Object> movableContentRemoved;
    private final MutableScatterMap<MovableContentStateReference, MovableContentState> movableContentStatesAvailable;
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
        return 1000;
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
                Unit broadcastFrameClock$lambda$2;
                broadcastFrameClock$lambda$2 = Recomposer.broadcastFrameClock$lambda$2(Recomposer.this);
                return broadcastFrameClock$lambda$2;
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.movableContentAwaitingInsert = new ArrayList();
        this.movableContentRemoved = MultiValueMap.m4678constructorimpl$default(null, 1, null);
        this.movableContentNestedStatesAvailable = new NestedContentMap();
        this.movableContentStatesAvailable = ScatterMapKt.mutableScatterMapOf();
        this.movableContentNestedExtractionsPending = MultiValueMap.m4678constructorimpl$default(null, 1, null);
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        this.pausedScopes = new SnapshotThreadLocal<>();
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.Key));
        Job.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit effectJob$lambda$10$lambda$9;
                effectJob$lambda$10$lambda$9 = Recomposer.effectJob$lambda$10$lambda$9(Recomposer.this, (Throwable) obj);
                return effectJob$lambda$10$lambda$9;
            }
        });
        this.effectJob = Job;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(Job);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit broadcastFrameClock$lambda$2(Recomposer recomposer) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (recomposer.stateLock) {
            deriveStateLocked = recomposer.deriveStateLocked();
            if (recomposer._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
            }
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m9902constructorimpl(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "<init>", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

        private State(String str, int i) {
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit effectJob$lambda$10$lambda$9(final Recomposer recomposer, final Throwable th) {
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
                                Unit effectJob$lambda$10$lambda$9$lambda$8$lambda$7;
                                effectJob$lambda$10$lambda$9$lambda$8$lambda$7 = Recomposer.effectJob$lambda$10$lambda$9$lambda$8$lambda$7(Recomposer.this, th, (Throwable) obj);
                                return effectJob$lambda$10$lambda$9$lambda$8$lambda$7;
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
                        Unit effectJob$lambda$10$lambda$9$lambda$8$lambda$7;
                        effectJob$lambda$10$lambda$9$lambda$8$lambda$7 = Recomposer.effectJob$lambda$10$lambda$9$lambda$8$lambda$7(Recomposer.this, th, (Throwable) obj);
                        return effectJob$lambda$10$lambda$9$lambda$8$lambda$7;
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
            cancellableContinuation.resumeWith(Result.m9902constructorimpl(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit effectJob$lambda$10$lambda$9$lambda$8$lambda$7(Recomposer recomposer, Throwable th, Throwable th2) {
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

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
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
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else if (this.compositionInvalidations.getSize() != 0 || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.movableContentAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked() || MultiValueMap.m4686isNotEmptyimpl(this.movableContentRemoved)) {
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
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\u001aR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "<init>", "(Landroidx/compose/runtime/Recomposer;)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "hasPendingWork", "", "getHasPendingWork", "()Z", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "invalidateGroupsWithKey", "", "key", "", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class RecomposerInfoImpl implements RecomposerInfo {
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

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                recomposerErrorState = recomposer.errorState;
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
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/CompositionImpl;)V", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "resetContent", "recompose", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m4522getLambda$1091980426$runtime());
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "", "<init>", "(ZLjava/lang/Throwable;)V", "getRecoverable", "()Z", "getCause", "()Ljava/lang/Throwable;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Throwable cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Throwable th) {
            this.recoverable = z;
            this.cause = th;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Throwable getCause() {
            return this.cause;
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

    /* JADX WARN: Multi-variable type inference failed */
    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> function1) {
        MutableScatterSet mutableScatterSet;
        int i;
        synchronized (this.stateLock) {
            mutableScatterSet = this.snapshotInvalidations;
            if (mutableScatterSet.isNotEmpty()) {
                this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
            }
        }
        Set<? extends Object> wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
        if (!wrapIntoSet.isEmpty()) {
            List knownCompositionsLocked = knownCompositionsLocked();
            int size = knownCompositionsLocked.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ControlledComposition) knownCompositionsLocked.get(i2)).recordModificationsOf(wrapIntoSet);
            }
        }
        MutableVector mutableVector = this.compositionInvalidations;
        T[] tArr = mutableVector.content;
        int size2 = mutableVector.getSize();
        for (i = 0; i < size2; i++) {
            function1.invoke(tArr[i]);
        }
        this.compositionInvalidations.clear();
        synchronized (this.stateLock) {
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
            Unit unit = Unit.INSTANCE;
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
            deriveStateLocked();
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
                MultiValueMap.m4676clearimpl(this.movableContentRemoved);
                this.movableContentStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(z, th);
                if (controlledComposition != null) {
                    recordFailedCompositionLocked(controlledComposition);
                }
                deriveStateLocked();
            }
            return;
        }
        synchronized (this.stateLock) {
            RecomposerErrorState recomposerErrorState = this.errorState;
            if (recomposerErrorState == null) {
                this.errorState = new RecomposerErrorState(false, th);
                Unit unit = Unit.INSTANCE;
            } else {
                throw recomposerErrorState.getCause();
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
        for (ControlledComposition controlledComposition : knownCompositionsLocked()) {
            unregisterCompositionLocked(controlledComposition);
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
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
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
                    if (this.errorState != null) {
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

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(coroutineContext, this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
        if (r5.withFrameNanos(r9, r0) != r1) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0098 -> B:13:0x003c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runFrameLoop(MonotonicFrameClock monotonicFrameClock, ProduceFrameSignal produceFrameSignal, Continuation<? super Unit> continuation) {
        Recomposer$runFrameLoop$1 recomposer$runFrameLoop$1;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        final ArrayList arrayList3;
        final ArrayList arrayList4;
        MonotonicFrameClock monotonicFrameClock2;
        final ProduceFrameSignal produceFrameSignal2;
        Object obj;
        ArrayList arrayList5;
        ArrayList arrayList6;
        if (continuation instanceof Recomposer$runFrameLoop$1) {
            recomposer$runFrameLoop$1 = (Recomposer$runFrameLoop$1) continuation;
            if ((recomposer$runFrameLoop$1.label & Integer.MIN_VALUE) != 0) {
                recomposer$runFrameLoop$1.label -= Integer.MIN_VALUE;
                Object obj2 = recomposer$runFrameLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = recomposer$runFrameLoop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    obj = this.stateLock;
                    recomposer$runFrameLoop$1.L$0 = monotonicFrameClock;
                    recomposer$runFrameLoop$1.L$1 = produceFrameSignal;
                    recomposer$runFrameLoop$1.L$2 = arrayList;
                    recomposer$runFrameLoop$1.L$3 = arrayList2;
                    recomposer$runFrameLoop$1.label = 1;
                    if (produceFrameSignal.awaitFrameRequest(obj, recomposer$runFrameLoop$1) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        produceFrameSignal2 = (ProduceFrameSignal) recomposer$runFrameLoop$1.L$1;
                        monotonicFrameClock2 = (MonotonicFrameClock) recomposer$runFrameLoop$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        arrayList6 = (List) recomposer$runFrameLoop$1.L$3;
                        arrayList5 = (List) recomposer$runFrameLoop$1.L$2;
                        arrayList = arrayList5;
                        produceFrameSignal = produceFrameSignal2;
                        arrayList2 = arrayList6;
                        monotonicFrameClock = monotonicFrameClock2;
                        obj = this.stateLock;
                        recomposer$runFrameLoop$1.L$0 = monotonicFrameClock;
                        recomposer$runFrameLoop$1.L$1 = produceFrameSignal;
                        recomposer$runFrameLoop$1.L$2 = arrayList;
                        recomposer$runFrameLoop$1.L$3 = arrayList2;
                        recomposer$runFrameLoop$1.label = 1;
                        if (produceFrameSignal.awaitFrameRequest(obj, recomposer$runFrameLoop$1) != coroutine_suspended) {
                            monotonicFrameClock2 = monotonicFrameClock;
                            arrayList4 = arrayList2;
                            produceFrameSignal2 = produceFrameSignal;
                            arrayList3 = arrayList;
                            Function1 function1 = new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    CancellableContinuation runFrameLoop$lambda$51;
                                    runFrameLoop$lambda$51 = Recomposer.runFrameLoop$lambda$51(Recomposer.this, arrayList3, arrayList4, produceFrameSignal2, ((Long) obj3).longValue());
                                    return runFrameLoop$lambda$51;
                                }
                            };
                            recomposer$runFrameLoop$1.L$0 = monotonicFrameClock2;
                            recomposer$runFrameLoop$1.L$1 = produceFrameSignal2;
                            recomposer$runFrameLoop$1.L$2 = arrayList3;
                            recomposer$runFrameLoop$1.L$3 = arrayList4;
                            recomposer$runFrameLoop$1.label = 2;
                            arrayList6 = arrayList4;
                            arrayList5 = arrayList3;
                        }
                        return coroutine_suspended;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    produceFrameSignal2 = (ProduceFrameSignal) recomposer$runFrameLoop$1.L$1;
                    monotonicFrameClock2 = (MonotonicFrameClock) recomposer$runFrameLoop$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    arrayList4 = (List) recomposer$runFrameLoop$1.L$3;
                    arrayList3 = (List) recomposer$runFrameLoop$1.L$2;
                    Function1 function12 = new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            CancellableContinuation runFrameLoop$lambda$51;
                            runFrameLoop$lambda$51 = Recomposer.runFrameLoop$lambda$51(Recomposer.this, arrayList3, arrayList4, produceFrameSignal2, ((Long) obj3).longValue());
                            return runFrameLoop$lambda$51;
                        }
                    };
                    recomposer$runFrameLoop$1.L$0 = monotonicFrameClock2;
                    recomposer$runFrameLoop$1.L$1 = produceFrameSignal2;
                    recomposer$runFrameLoop$1.L$2 = arrayList3;
                    recomposer$runFrameLoop$1.L$3 = arrayList4;
                    recomposer$runFrameLoop$1.label = 2;
                    arrayList6 = arrayList4;
                    arrayList5 = arrayList3;
                }
            }
        }
        recomposer$runFrameLoop$1 = new Recomposer$runFrameLoop$1(this, continuation);
        Object obj22 = recomposer$runFrameLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = recomposer$runFrameLoop$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CancellableContinuation runFrameLoop$lambda$51(Recomposer recomposer, List list, List list2, ProduceFrameSignal produceFrameSignal, long j) {
        Object beginSection;
        int i;
        CancellableContinuation<Unit> deriveStateLocked;
        if (recomposer.getHasBroadcastFrameClockAwaiters()) {
            beginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
            try {
                recomposer.broadcastFrameClock.sendFrame(j);
                Snapshot.Companion.sendApplyNotifications();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
            } finally {
            }
        }
        beginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
        try {
            recomposer.recordComposerModifications();
            synchronized (recomposer.stateLock) {
                List<ControlledComposition> list3 = recomposer.compositionsAwaitingApply;
                int size = list3.size();
                for (int i2 = 0; i2 < size; i2++) {
                    list2.add(list3.get(i2));
                }
                recomposer.compositionsAwaitingApply.clear();
                MutableVector<ControlledComposition> mutableVector = recomposer.compositionInvalidations;
                ControlledComposition[] controlledCompositionArr = mutableVector.content;
                int size2 = mutableVector.getSize();
                for (int i3 = 0; i3 < size2; i3++) {
                    list.add(controlledCompositionArr[i3]);
                }
                recomposer.compositionInvalidations.clear();
                produceFrameSignal.takeFrameRequestLocked();
                Unit unit2 = Unit.INSTANCE;
            }
            MutableScatterSet<Object> mutableScatterSet = new MutableScatterSet<>(0, 1, null);
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ControlledComposition performRecompose = recomposer.performRecompose((ControlledComposition) list.get(i4), mutableScatterSet);
                if (performRecompose != null) {
                    list2.add(performRecompose);
                }
            }
            list.clear();
            if (!list2.isEmpty()) {
                recomposer.changeCount++;
            }
            int size4 = list2.size();
            for (i = 0; i < size4; i++) {
                ((ControlledComposition) list2.get(i)).applyChanges();
            }
            list2.clear();
            synchronized (recomposer.stateLock) {
                deriveStateLocked = recomposer.deriveStateLocked();
            }
            return deriveStateLocked;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (!this.snapshotInvalidations.isNotEmpty() && this.compositionInvalidations.getSize() == 0) {
                z = getHasBroadcastFrameClockAwaitersLocked();
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
            cancellableContinuationImpl2.resumeWith(Result.m9902constructorimpl(Unit.INSTANCE));
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
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
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
    public void composeInitial$runtime(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
        Throwable th;
        boolean z;
        Recomposer recomposer;
        Throwable th2;
        boolean isComposing = controlledComposition.isComposing();
        synchronized (this.stateLock) {
            try {
                if (this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                    try {
                        boolean contains = knownCompositionsLocked().contains(controlledComposition);
                        z = !contains;
                        if (!contains) {
                            registerCompositionLocked(controlledComposition);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } else {
                    z = true;
                }
                try {
                    MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, null));
                    try {
                        MutableSnapshot mutableSnapshot = takeMutableSnapshot;
                        Snapshot makeCurrent = mutableSnapshot.makeCurrent();
                        try {
                            controlledComposition.composeContent(function2);
                            Unit unit = Unit.INSTANCE;
                            mutableSnapshot.restoreCurrent(makeCurrent);
                            applyAndCheck(takeMutableSnapshot);
                            synchronized (this.stateLock) {
                                try {
                                    if (this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                                        try {
                                            if (!knownCompositionsLocked().contains(controlledComposition)) {
                                                addKnownCompositionLocked(controlledComposition);
                                            }
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            throw th2;
                                        }
                                    } else {
                                        unregisterCompositionLocked(controlledComposition);
                                    }
                                    Unit unit2 = Unit.INSTANCE;
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
                                        } catch (Throwable th5) {
                                            processCompositionError$default(this, th5, null, false, 6, null);
                                        }
                                    } catch (Throwable th6) {
                                        processCompositionError(th6, controlledComposition, true);
                                    }
                                } catch (Throwable th7) {
                                    th2 = th7;
                                }
                            }
                        } catch (Throwable th8) {
                            recomposer = this;
                            try {
                                mutableSnapshot.restoreCurrent(makeCurrent);
                                throw th8;
                            } catch (Throwable th9) {
                                th = th9;
                                Throwable th10 = th;
                                try {
                                    applyAndCheck(takeMutableSnapshot);
                                    throw th10;
                                } catch (Throwable th11) {
                                    th = th11;
                                    Throwable th12 = th;
                                    if (z) {
                                        synchronized (recomposer.stateLock) {
                                            unregisterCompositionLocked(controlledComposition);
                                            Unit unit3 = Unit.INSTANCE;
                                        }
                                    }
                                    processCompositionError(th12, controlledComposition, true);
                                }
                            }
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        recomposer = this;
                    }
                } catch (Throwable th14) {
                    th = th14;
                    recomposer = this;
                }
            } catch (Throwable th15) {
                th = th15;
            }
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
        Set<ControlledComposition> set;
        if (controlledComposition.isComposing() || controlledComposition.isDisposed() || ((set = this.compositionsRemoved) != null && set.contains(controlledComposition))) {
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
                        Unit performRecompose$lambda$69$lambda$68;
                        performRecompose$lambda$69$lambda$68 = Recomposer.performRecompose$lambda$69$lambda$68(MutableScatterSet.this, controlledComposition);
                        return performRecompose$lambda$69$lambda$68;
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
    public static final Unit performRecompose$lambda$69$lambda$68(MutableScatterSet mutableScatterSet, ControlledComposition controlledComposition) {
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
            if (MultiValueMap.m4686isNotEmptyimpl(this.movableContentRemoved)) {
                ObjectList m4691valuesimpl = MultiValueMap.m4691valuesimpl(this.movableContentRemoved);
                MultiValueMap.m4676clearimpl(this.movableContentRemoved);
                this.movableContentNestedStatesAvailable.clear();
                MultiValueMap.m4676clearimpl(this.movableContentNestedExtractionsPending);
                MutableObjectList mutableObjectList = new MutableObjectList(m4691valuesimpl.getSize());
                Object[] objArr = m4691valuesimpl.content;
                int i2 = m4691valuesimpl._size;
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
                Unit readObserverOf$lambda$86;
                readObserverOf$lambda$86 = Recomposer.readObserverOf$lambda$86(ControlledComposition.this, obj);
                return readObserverOf$lambda$86;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readObserverOf$lambda$86(ControlledComposition controlledComposition, Object obj) {
        controlledComposition.recordReadOf(obj);
        return Unit.INSTANCE;
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition controlledComposition, final MutableScatterSet<Object> mutableScatterSet) {
        return new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit writeObserverOf$lambda$87;
                writeObserverOf$lambda$87 = Recomposer.writeObserverOf$lambda$87(ControlledComposition.this, mutableScatterSet, obj);
                return writeObserverOf$lambda$87;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeObserverOf$lambda$87(ControlledComposition controlledComposition, MutableScatterSet mutableScatterSet, Object obj) {
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
            if (!this.snapshotInvalidations.isNotEmpty() && this.compositionInvalidations.getSize() == 0 && this.concurrentCompositionsOutstanding <= 0 && this.compositionsAwaitingApply.isEmpty() && !getHasBroadcastFrameClockAwaitersLocked()) {
                z = MultiValueMap.m4686isNotEmptyimpl(this.movableContentRemoved);
            }
        }
        return z;
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.getSize() != 0 || getHasBroadcastFrameClockAwaitersLocked() || MultiValueMap.m4686isNotEmptyimpl(this.movableContentRemoved);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
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
            cancellableContinuation.resumeWith(Result.m9902constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingSourceInformation$runtime() {
        return ComposerKt.getComposeStackTraceEnabled();
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
            cancellableContinuation.resumeWith(Result.m9902constructorimpl(Unit.INSTANCE));
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
            deriveStateLocked.resumeWith(Result.m9902constructorimpl(Unit.INSTANCE));
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
            deriveStateLocked.resumeWith(Result.m9902constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime(MovableContentStateReference movableContentStateReference) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            MultiValueMap.m4674addimpl(this.movableContentRemoved, movableContentStateReference.getContent$runtime(), movableContentStateReference);
            if (movableContentStateReference.getNestedReferences$runtime() != null) {
                deletedMovableContent$lambda$96$recordNestedStatesOf(this, movableContentStateReference, movableContentStateReference);
            }
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m9902constructorimpl(Unit.INSTANCE));
        }
    }

    private static final void deletedMovableContent$lambda$96$recordNestedStatesOf(Recomposer recomposer, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        List<MovableContentStateReference> nestedReferences$runtime = movableContentStateReference2.getNestedReferences$runtime();
        if (nestedReferences$runtime != null) {
            int size = nestedReferences$runtime.size();
            for (int i = 0; i < size; i++) {
                MovableContentStateReference movableContentStateReference3 = nestedReferences$runtime.get(i);
                recomposer.movableContentNestedStatesAvailable.add(movableContentStateReference3.getContent$runtime(), new NestedMovableContent(movableContentStateReference3, movableContentStateReference));
                deletedMovableContent$lambda$96$recordNestedStatesOf(recomposer, movableContentStateReference, movableContentStateReference3);
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState, Applier<?> applier) {
        synchronized (this.stateLock) {
            this.movableContentStatesAvailable.set(movableContentStateReference, movableContentState);
            ObjectList<MovableContentStateReference> m4683getimpl = MultiValueMap.m4683getimpl(this.movableContentNestedExtractionsPending, movableContentStateReference);
            if (m4683getimpl.isNotEmpty()) {
                ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates$runtime = movableContentState.extractNestedStates$runtime(applier, m4683getimpl);
                Object[] objArr = extractNestedStates$runtime.keys;
                Object[] objArr2 = extractNestedStates$runtime.values;
                long[] jArr = extractNestedStates$runtime.metadata;
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
            LinkedHashSet linkedHashSet = this.compositionsRemoved;
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                this.compositionsRemoved = linkedHashSet;
            }
            linkedHashSet.add(controlledComposition);
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
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0019J\u0014\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0007R\u00020\bH\u0002J\u0014\u0010\u001c\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0007R\u00020\bH\u0002J\r\u0010\u001d\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0001H\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0000¢\u0006\u0002\b)J\r\u0010*\u001a\u00020\u0017H\u0000¢\u0006\u0002\b+R\u001e\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007R\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006,"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "<init>", "()V", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "currentRunningRecomposers", "currentRunningRecomposers$runtime", "setHotReloadEnabled", "", "value", "setHotReloadEnabled$runtime", "addRunning", "info", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime", "clearErrors", "clearErrors$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

        public final Set<RecomposerInfo> currentRunningRecomposers$runtime() {
            return (Set) Recomposer._runningRecomposers.getValue();
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
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(i);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime() {
            ArrayList arrayList = new ArrayList();
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
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
    /* JADX WARN: Code restructure failed: missing block: B:52:0x016b, code lost:
        r0 = r11.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0173, code lost:
        if (r2 >= r0) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017f, code lost:
        if (r11.get(r2).getSecond() == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0181, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0184, code lost:
        r0 = new java.util.ArrayList(r11.size());
        r2 = r11.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0195, code lost:
        if (r3 >= r2) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0197, code lost:
        r4 = r11.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01a1, code lost:
        if (r4.getSecond() != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a3, code lost:
        r4 = r4.getFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01aa, code lost:
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01ab, code lost:
        if (r4 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ad, code lost:
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b3, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b6, code lost:
        r0 = r0;
        r2 = r17.stateLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ba, code lost:
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01bb, code lost:
        kotlin.collections.CollectionsKt.addAll(r17.movableContentAwaitingInsert, r0);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c6, code lost:
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c7, code lost:
        r0 = new java.util.ArrayList(r11.size());
        r2 = r11.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01d8, code lost:
        if (r3 >= r2) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01da, code lost:
        r4 = r11.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01e5, code lost:
        if (r4.getSecond() == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01e7, code lost:
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ed, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f0, code lost:
        r11 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                        Object m4688removeLastimpl = MultiValueMap.m4688removeLastimpl(this.movableContentRemoved, movableContentStateReference2.getContent$runtime());
                        MovableContentStateReference movableContentStateReference3 = (MovableContentStateReference) m4688removeLastimpl;
                        if (movableContentStateReference3 != null) {
                            hashMap2 = hashMap5;
                            this.movableContentNestedStatesAvailable.usedContainer(movableContentStateReference3);
                        } else {
                            hashMap2 = hashMap5;
                        }
                        arrayList3.add(TuplesKt.to(movableContentStateReference2, m4688removeLastimpl));
                        i2++;
                        it2 = it3;
                        hashMap5 = hashMap2;
                    }
                    it = it2;
                    hashMap = hashMap5;
                    arrayList = arrayList2;
                    if (ComposeRuntimeFlags.isMovingNestedMovableContentEnabled) {
                        int size3 = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                break;
                            }
                            Pair<MovableContentStateReference, MovableContentStateReference> pair = arrayList.get(i3);
                            if (pair.getSecond() == null && this.movableContentNestedStatesAvailable.contains(pair.getFirst().getContent$runtime())) {
                                ArrayList<Pair> arrayList4 = arrayList;
                                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                                for (Pair pair2 : arrayList4) {
                                    if (pair2.getSecond() == null && (removeLast = this.movableContentNestedStatesAvailable.removeLast(((MovableContentStateReference) pair2.getFirst()).getContent$runtime())) != null) {
                                        MovableContentStateReference content = removeLast.getContent();
                                        MultiValueMap.m4674addimpl(this.movableContentNestedExtractionsPending, removeLast.getContainer(), content);
                                        pair2 = TuplesKt.to(pair2.getFirst(), content);
                                    }
                                    arrayList5.add(pair2);
                                }
                                arrayList = arrayList5;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                int size4 = arrayList.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size4) {
                        break;
                    }
                    if (arrayList.get(i4).getSecond() != null) {
                        break;
                    }
                    i4++;
                }
                controlledComposition.insertMovableContent(arrayList);
                Unit unit = Unit.INSTANCE;
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
