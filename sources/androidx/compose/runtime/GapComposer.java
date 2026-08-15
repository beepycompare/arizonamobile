package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.GroupKind;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapAnchorKt;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeListKt;
import androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.FixupList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilderKt;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.runtime.tooling.ObjectLocation;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: GapComposer.kt */
@Metadata(d1 = {"\u0000·\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001?\b\u0001\u0018\u00002\u00020\u0001:\u0004\u0087\u0003\u0088\u0003BQ\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001eH\u0017J\b\u0010u\u001a\u00020sH\u0017J\u0010\u0010v\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001eH\u0017J\b\u0010w\u001a\u00020sH\u0017J\b\u0010x\u001a\u00020sH\u0017J\b\u0010y\u001a\u00020sH\u0017J\u001b\u0010~\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J\t\u0010\u0081\u0001\u001a\u00020sH\u0017J\t\u0010\u0082\u0001\u001a\u00020sH\u0002J\t\u0010\u0083\u0001\u001a\u00020sH\u0002J\t\u0010\u0084\u0001\u001a\u00020sH\u0002J\u000f\u0010\u0085\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b\u0086\u0001J\t\u0010\u0094\u0001\u001a\u00020sH\u0016J\u001a\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0016J\u000f\u0010\u0099\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b\u009a\u0001J\u000f\u0010\u009b\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b\u009c\u0001J\u000e\u0010'\u001a\u00020(H\u0010¢\u0006\u0003\b\u009d\u0001J\u0011\u0010\u009e\u0001\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001eH\u0002J\u001c\u0010\u009e\u0001\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020sH\u0002J\t\u0010 \u0001\u001a\u00020sH\u0002J\t\u0010¡\u0001\u001a\u00020sH\u0016J\t\u0010¢\u0001\u001a\u00020sH\u0016J!\u0010£\u0001\u001a\u00020s\"\u0005\b\u0000\u0010¤\u00012\u000f\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u0003H¤\u00010\u0098\u0001H\u0016J\t\u0010¦\u0001\u001a\u00020sH\u0016J\t\u0010§\u0001\u001a\u00020sH\u0016J\u001c\u0010¨\u0001\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\t\u0010©\u0001\u001a\u00020sH\u0016J\t\u0010ª\u0001\u001a\u00020sH\u0016J\t\u0010«\u0001\u001a\u00020sH\u0016J\u000f\u0010¬\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b\u00ad\u0001J\u000f\u0010®\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b¯\u0001J\u0012\u0010³\u0001\u001a\u00020s2\u0007\u0010´\u0001\u001a\u00020\u001eH\u0016JJ\u0010µ\u0001\u001a\u00020s\"\u0005\b\u0000\u0010¶\u0001\"\u0005\b\u0001\u0010¤\u00012\u0007\u0010C\u001a\u0003H¶\u00012\"\u0010·\u0001\u001a\u001d\u0012\u0005\u0012\u0003H¤\u0001\u0012\u0005\u0012\u0003H¶\u0001\u0012\u0004\u0012\u00020s0¸\u0001¢\u0006\u0003\b¹\u0001H\u0016¢\u0006\u0003\u0010º\u0001J\"\u0010»\u0001\u001a\u00030\u0080\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u0080\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J\f\u0010¾\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0001J\f\u0010¿\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0001J\u0014\u0010À\u0001\u001a\u00020(2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J\u0014\u0010Á\u0001\u001a\u00020(2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Â\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Ã\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Ä\u0001H\u0017J\u0011\u0010À\u0001\u001a\u00020(2\u0006\u0010C\u001a\u00020(H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Å\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030\u008d\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Æ\u0001H\u0017J\u0011\u0010À\u0001\u001a\u00020(2\u0006\u0010C\u001a\u00020\u001eH\u0017J2\u0010Ç\u0001\u001a\u0003H¤\u0001\"\u0005\b\u0000\u0010¤\u00012\u0007\u0010È\u0001\u001a\u00020(2\u000f\u0010·\u0001\u001a\n\u0012\u0005\u0012\u0003H¤\u00010\u0098\u0001H\u0087\b¢\u0006\u0003\u0010É\u0001J\u0014\u0010Ê\u0001\u001a\u00020s2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\u0014\u0010Ë\u0001\u001a\u00020s2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0001J\u0014\u0010Ì\u0001\u001a\u00020s2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0001J\t\u0010Í\u0001\u001a\u00020\u001eH\u0002J\u0019\u0010Ó\u0001\u001a\u00020s2\u000e\u0010Ô\u0001\u001a\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0016J\t\u0010Õ\u0001\u001a\u000200H\u0002J\u0012\u0010Õ\u0001\u001a\u0002002\u0007\u0010Ú\u0001\u001a\u00020\u001eH\u0002J\u001b\u0010Û\u0001\u001a\u0002002\u0007\u0010Ü\u0001\u001a\u0002002\u0007\u0010Ý\u0001\u001a\u000200H\u0002J\u0016\u0010Þ\u0001\u001a\u00020s2\u000b\u0010C\u001a\u0007\u0012\u0002\b\u00030ß\u0001H\u0017J\u0012\u0010à\u0001\u001a\u00020s2\u0007\u0010á\u0001\u001a\u000200H\u0002J\t\u0010â\u0001\u001a\u00020sH\u0017J&\u0010ã\u0001\u001a\u00020s2\u0015\u0010ä\u0001\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030ß\u00010å\u0001H\u0017¢\u0006\u0003\u0010æ\u0001J\t\u0010ç\u0001\u001a\u00020sH\u0017J'\u0010è\u0001\u001a\u0003H¤\u0001\"\u0005\b\u0000\u0010¤\u00012\u000e\u0010t\u001a\n\u0012\u0005\u0012\u0003H¤\u00010é\u0001H\u0017¢\u0006\u0003\u0010ê\u0001J\t\u0010ë\u0001\u001a\u00020\u0005H\u0016J\t\u0010ï\u0001\u001a\u00020sH\u0002J\t\u0010ð\u0001\u001a\u00020sH\u0002J\t\u0010ñ\u0001\u001a\u00020sH\u0002J\u001e\u0010ò\u0001\u001a\u00020s2\u0007\u0010ó\u0001\u001a\u00020(2\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J<\u0010õ\u0001\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\n\u0010ö\u0001\u001a\u0005\u0018\u00010\u0080\u00012\b\u0010÷\u0001\u001a\u00030ø\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0002¢\u0006\u0006\bù\u0001\u0010ú\u0001J\u001d\u0010û\u0001\u001a\u00020s2\u0007\u0010ó\u0001\u001a\u00020(2\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u001aH\u0002J\u001b\u0010ý\u0001\u001a\u00020s2\u0007\u0010þ\u0001\u001a\u00020\u001e2\u0007\u0010\u0087\u0001\u001a\u00020(H\u0002J\u0012\u0010ÿ\u0001\u001a\u00020s2\u0007\u0010ó\u0001\u001a\u00020(H\u0002J\t\u0010\u0080\u0002\u001a\u00020sH\u0002J\u0012\u0010\u0081\u0002\u001a\u00020\u001e2\u0007\u0010\u0082\u0002\u001a\u00020\u001eH\u0002J\u001b\u0010\u0083\u0002\u001a\u00020s2\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u0084\u0002\u001a\u00020\u001eH\u0002J-\u0010\u0085\u0002\u001a\u00020\u001e2\u0007\u0010\u0086\u0002\u001a\u00020\u001e2\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u0087\u0002\u001a\u00020\u001e2\u0007\u0010\u0088\u0002\u001a\u00020\u001eH\u0002J\u0012\u0010\u0089\u0002\u001a\u00020\u001e2\u0007\u0010Ú\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010\u008a\u0002\u001a\u00020\u001e2\u0007\u0010Ú\u0001\u001a\u00020\u001eH\u0002J\u001b\u0010\u008b\u0002\u001a\u00020s2\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u008c\u0002\u001a\u00020\u001eH\u0002J\t\u0010\u008d\u0002\u001a\u00020sH\u0002J$\u0010\u008e\u0002\u001a\u00020s2\u0007\u0010\u008f\u0002\u001a\u00020\u001e2\u0007\u0010\u0090\u0002\u001a\u00020\u001e2\u0007\u0010\u0091\u0002\u001a\u00020\u001eH\u0002J\u001b\u0010\u0092\u0002\u001a\u00020s2\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u0093\u0002\u001a\u00020\u001eH\u0002J6\u0010\u0094\u0002\u001a\b0\u008d\u0001j\u0003`\u008e\u00012\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u0087\u0002\u001a\u00020\u001e2\r\u0010\u0095\u0002\u001a\b0\u008d\u0001j\u0003`\u008e\u0001H\u0002¢\u0006\u0003\u0010\u0096\u0002J\u0016\u0010\u0097\u0002\u001a\u00020\u001e*\u00020M2\u0007\u0010Ú\u0001\u001a\u00020\u001eH\u0002J$\u0010\u0098\u0002\u001a\u00020(2\u0007\u0010\u0099\u0002\u001a\u00020B2\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0080\u0001H\u0010¢\u0006\u0003\b\u009b\u0002J\u000f\u0010\u009c\u0002\u001a\u00020\u001eH\u0011¢\u0006\u0003\b\u009d\u0002J\t\u0010\u009e\u0002\u001a\u00020sH\u0017J\t\u0010\u009f\u0002\u001a\u00020sH\u0002J\u001b\u0010 \u0002\u001a\u00020(2\u0007\u0010¡\u0002\u001a\u00020(2\u0007\u0010¢\u0002\u001a\u00020\u001eH\u0017J\t\u0010£\u0002\u001a\u00020sH\u0017J\u0012\u0010¤\u0002\u001a\u00020s2\u0007\u0010À\u0001\u001a\u00020(H\u0017J\u0012\u0010¥\u0002\u001a\u00030¦\u00022\u0006\u0010t\u001a\u00020\u001eH\u0017J\t\u0010§\u0002\u001a\u00020sH\u0002J\u0012\u0010¨\u0002\u001a\u00020s2\u0007\u0010\u0099\u0002\u001a\u00020BH\u0002J\f\u0010©\u0002\u001a\u0005\u0018\u00010ª\u0002H\u0017J\"\u0010«\u0002\u001a\u0012\u0012\u0005\u0012\u00030\u00ad\u0002\u0012\u0004\u0012\u00020s\u0018\u00010¬\u00022\u0007\u0010\u0099\u0002\u001a\u00020BH\u0002J\"\u0010®\u0002\u001a\u00020s2\u000b\u0010C\u001a\u0007\u0012\u0002\b\u00030¯\u00022\n\u0010°\u0002\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J:\u0010±\u0002\u001a\u00020s2\u0011\u0010²\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010¯\u00022\u0007\u0010³\u0002\u001a\u0002002\n\u0010°\u0002\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010´\u0002\u001a\u00020(H\u0002J*\u0010µ\u0002\u001a\u00020s2\u001f\u0010¶\u0002\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030¹\u0002\u0012\u0007\u0012\u0005\u0018\u00010¹\u00020¸\u00020·\u0002H\u0017J*\u0010º\u0002\u001a\u00020s2\u001f\u0010¶\u0002\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030¹\u0002\u0012\u0007\u0012\u0005\u0018\u00010¹\u00020¸\u00020·\u0002H\u0002J1\u0010»\u0002\u001a\u0003H¼\u0002\"\u0005\b\u0000\u0010¼\u00022\u0006\u0010L\u001a\u00020M2\u000f\u0010·\u0001\u001a\n\u0012\u0005\u0012\u0003H¼\u00020\u0098\u0001H\u0082\b¢\u0006\u0003\u0010½\u0002Jr\u0010¾\u0002\u001a\u0003H¼\u0002\"\u0005\b\u0000\u0010¼\u00022\f\b\u0002\u0010¿\u0002\u001a\u0005\u0018\u00010À\u00022\f\b\u0002\u0010Á\u0002\u001a\u0005\u0018\u00010À\u00022\u000b\b\u0002\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u001e2\u001f\b\u0002\u0010+\u001a\u0019\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020B\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010¸\u00020·\u00022\u000f\u0010·\u0001\u001a\n\u0012\u0005\u0012\u0003H¼\u00020\u0098\u0001H\u0002¢\u0006\u0003\u0010Â\u0002J\u0013\u0010Ã\u0002\u001a\u00020s2\b\u0010Ã\u0002\u001a\u00030Ä\u0002H\u0017J\u001b\u0010Å\u0002\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\b\u0010Ã\u0002\u001a\u00030Ä\u0002H\u0017J\t\u0010Æ\u0002\u001a\u00020sH\u0017J\t\u0010Ç\u0002\u001a\u00020sH\u0016J\u001b\u0010È\u0002\u001a\u00030É\u00022\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0010¢\u0006\u0003\bÊ\u0002J\f\u0010Ë\u0002\u001a\u0005\u0018\u00010É\u0002H\u0002J+\u0010Ì\u0002\u001a\n\u0012\u0005\u0012\u00030Í\u00020·\u00022\u0007\u0010Ú\u0001\u001a\u00020\u001e2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0003\u0010Ï\u0002J\u0017\u0010Ð\u0002\u001a\n\u0012\u0005\u0012\u00030Í\u00020·\u0002H\u0010¢\u0006\u0003\bÑ\u0002JJ\u0010Ò\u0002\u001a\u00020s2\u0015\u0010Ó\u0002\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\u0014\u0010²\u0002\u001a\u000f\u0012\u0004\u0012\u00020s0\u0098\u0001¢\u0006\u0003\bÕ\u00022\t\u0010Ö\u0002\u001a\u0004\u0018\u00010iH\u0010¢\u0006\u0006\b×\u0002\u0010Ø\u0002J\u001f\u0010Ù\u0002\u001a\u00020s2\u000e\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0010¢\u0006\u0003\bÚ\u0002J4\u0010Û\u0002\u001a\u00020(2\u0015\u0010Ó\u0002\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\t\u0010Ö\u0002\u001a\u0004\u0018\u00010iH\u0010¢\u0006\u0006\bÜ\u0002\u0010Ý\u0002J)\u0010Þ\u0002\u001a\u00020s2\u0015\u0010Ó\u0002\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u0002H\u0010¢\u0006\u0006\bß\u0002\u0010à\u0002JA\u0010á\u0002\u001a\u00020s2\u0015\u0010Ó\u0002\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\u0016\u0010²\u0002\u001a\u0011\u0012\u0004\u0012\u00020s\u0018\u00010\u0098\u0001¢\u0006\u0003\bÕ\u0002H\u0002¢\u0006\u0006\bâ\u0002\u0010ã\u0002J\u0019\u0010é\u0002\u001a\u0005\u0018\u00010\u0080\u0001*\u00020M2\u0007\u0010\u0082\u0002\u001a\u00020\u001eH\u0002J\t\u0010ê\u0002\u001a\u00020sH\u0002J\t\u0010ë\u0002\u001a\u00020sH\u0002J\u0012\u0010ì\u0002\u001a\u00020s2\u0007\u0010í\u0002\u001a\u00020dH\u0002J\t\u0010î\u0002\u001a\u00020sH\u0002J\u0012\u0010ï\u0002\u001a\u00020s2\u0007\u0010ð\u0002\u001a\u00020\u001eH\u0002J\t\u0010ñ\u0002\u001a\u00020sH\u0002J\t\u0010ò\u0002\u001a\u00020sH\u0002J\t\u0010ó\u0002\u001a\u00020sH\u0002J\u000f\u0010ô\u0002\u001a\u00020sH\u0010¢\u0006\u0003\bõ\u0002J2\u0010ö\u0002\u001a\u00020s2\u0007\u0010÷\u0002\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0082\bJ\u001b\u0010ø\u0002\u001a\u00020s2\u0007\u0010÷\u0002\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0082\bJ2\u0010ù\u0002\u001a\u00020s2\u0007\u0010÷\u0002\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0082\bJ\u001b\u0010ú\u0002\u001a\u00020s2\u0007\u0010÷\u0002\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0082\bJ\u000f\u0010û\u0002\u001a\u00020\u001eH\u0010¢\u0006\u0003\bü\u0002J\f\u0010\u0084\u0003\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0014\u0010\u0085\u0003\u001a\u00020s2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0013\u0010\u0086\u0003\u001a\u00020s2\b\u0010\u0099\u0002\u001a\u00030þ\u0002H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020(X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0010\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@R\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u001e\u0010D\u001a\u00020(2\u0006\u0010C\u001a\u00020(@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R\u001e\u0010F\u001a\u00020(2\u0006\u0010C\u001a\u00020(@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0014\u0010H\u001a\u00020(8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bI\u0010;R\u0014\u0010J\u001a\u00020(8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bK\u0010;R\u001a\u0010L\u001a\u00020MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020XX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010j\u001a\u0004\u0018\u00010k8PX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020oX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u001a\u0010z\u001a\u00020(8VX\u0097\u0004¢\u0006\f\u0012\u0004\b{\u0010|\u001a\u0004\b}\u0010;R)\u0010\u0087\u0001\u001a\u00020(2\u0006\u0010C\u001a\u00020(8\u0016@RX\u0097\u000e¢\u0006\u0010\n\u0000\u0012\u0005\b\u0088\u0001\u0010|\u001a\u0005\b\u0089\u0001\u0010;R\u001d\u0010\u008a\u0001\u001a\u00020(8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\b\u008b\u0001\u0010|\u001a\u0005\b\u008c\u0001\u0010;R9\u0010\u008f\u0001\u001a\b0\u008d\u0001j\u0003`\u008e\u00012\f\u0010C\u001a\b0\u008d\u0001j\u0003`\u008e\u00018\u0016@RX\u0097\u000e¢\u0006\u0014\n\u0003\u0010\u0093\u0001\u0012\u0005\b\u0090\u0001\u0010|\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0017\u0010°\u0001\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u0012\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Ð\u0001\u001a\u00030Ï\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ö\u0001\u001a\u00030×\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bØ\u0001\u0010Ù\u0001R\u0019\u0010ì\u0001\u001a\u0004\u0018\u00010B8PX\u0090\u0004¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u0013\u0010ä\u0002\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\bå\u0002\u0010;R\u001e\u0010æ\u0002\u001a\u0005\u0018\u00010\u0080\u0001*\u00020M8BX\u0082\u0004¢\u0006\b\u001a\u0006\bç\u0002\u0010è\u0002R\u001a\u0010ý\u0002\u001a\u0005\u0018\u00010þ\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÿ\u0002\u0010\u0080\u0003R\u001a\u0010\u0081\u0003\u001a\u0005\u0018\u00010\u0080\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0003\u0010\u0083\u0003¨\u0006\u0089\u0003"}, d2 = {"Landroidx/compose/runtime/GapComposer;", "Landroidx/compose/runtime/InternalComposer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/composer/gapbuffer/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/CompositionObserverHolder;Landroidx/compose/runtime/CompositionImpl;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "pendingStack", "Landroidx/compose/runtime/Stack;", "Landroidx/compose/runtime/GapPending;", "Ljava/util/ArrayList;", "pending", "nodeIndex", "", "groupNodeCount", "rGroupIndex", "parentStateStack", "Landroidx/compose/runtime/IntStack;", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "forceRecomposeScopes", "", "forciblyRecompose", "nodeExpected", "invalidations", "", "Landroidx/compose/runtime/Invalidation;", "entersStack", "rootProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "providerUpdates", "Landroidx/collection/MutableIntObjectMap;", "providersInvalid", "providersInvalidStack", "reusing", "reusingGroup", "childrenComposing", "compositionToken", "sourceMarkersEnabled", "getSourceMarkersEnabled$runtime", "()Z", "setSourceMarkersEnabled$runtime", "(Z)V", "derivedStateObserver", "androidx/compose/runtime/GapComposer$derivedStateObserver$1", "Landroidx/compose/runtime/GapComposer$derivedStateObserver$1;", "invalidateStack", "Landroidx/compose/runtime/RecomposeScopeImpl;", "value", "isComposing", "isComposing$runtime", "isDisposed", "isDisposed$runtime", "areChildrenComposing", "getAreChildrenComposing$runtime", "hasPendingChanges", "getHasPendingChanges$runtime", "reader", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "getReader$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "setReader$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;)V", "insertTable", "getInsertTable$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "setInsertTable$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;)V", "writer", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "writerHasAProvider", "providerCache", "deferredChanges", "Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "getDeferredChanges$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "setDeferredChanges$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;)V", "changeListWriter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/ComposerChangeListWriter;", "insertAnchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "insertFixups", "Landroidx/compose/runtime/composer/gapbuffer/changelist/FixupList;", "pausable", "shouldPauseCallback", "Landroidx/compose/runtime/ShouldPauseCallback;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "getErrorContext$runtime", "()Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "startReplaceableGroup", "", "key", "endReplaceableGroup", "startReplaceGroup", "endReplaceGroup", "startDefaults", "endDefaults", "defaultsInvalid", "getDefaultsInvalid$annotations", "()V", "getDefaultsInvalid", "startMovableGroup", "dataKey", "", "endMovableGroup", "startRoot", "endRoot", "abortRoot", "changesApplied", "changesApplied$runtime", "inserting", "getInserting$annotations", "getInserting", "skipping", "getSkipping$annotations", "getSkipping", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "compositeKeyHashCode", "getCompositeKeyHashCode$annotations", "getCompositeKeyHashCode", "()J", "J", "collectParameterInformation", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "Lkotlin/Function0;", "dispose", "dispose$runtime", "deactivate", "deactivate$runtime", "forceRecomposeScopes$runtime", "startGroup", "endGroup", "skipGroup", "startNode", "startReusableNode", "createNode", ExifInterface.GPS_DIRECTION_TRUE, "factory", "useNode", "endNode", "startReusableGroup", "endReusableGroup", "disableReusing", "enableReusing", "startReuseFromRoot", "startReuseFromRoot$runtime", "endReuseFromRoot", "endReuseFromRoot$runtime", "currentMarker", "getCurrentMarker", "()I", "endToMarker", "marker", "apply", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "joinKey", TtmlNode.LEFT, TtmlNode.RIGHT, "nextSlot", "nextSlotForCache", "changed", "changedInstance", "", "", "", "", "", "cache", "invalid", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateSlot", "updateValue", "updateCachedValue", "rememberObserverGroupIndex", "_compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "compositionData", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "recordSideEffect", "effect", "currentCompositionLocalScope", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "group", "updateProviderMapGroup", "parentScope", "currentProviders", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "recordProviderUpdate", "providers", "endProvider", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "endProviders", "consume", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "buildContext", "currentRecomposeScope", "getCurrentRecomposeScope$runtime", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "ensureWriter", "createFreshInsertTable", "forceFreshInsertTable", "startReaderGroup", "isNode", "data", TtmlNode.START, "objectKey", "kind", "Landroidx/compose/runtime/composer/GroupKind;", "start-AzEfcrM", "(ILjava/lang/Object;ILjava/lang/Object;)V", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", TtmlNode.END, "recomposeToGroupEnd", "insertedGroupVirtualIndex", FirebaseAnalytics.Param.INDEX, "updateNodeCountOverrides", "newCount", "nodeIndexOf", "groupLocation", "recomposeGroup", "recomposeIndex", "rGroupIndexOf", "updatedNodeCount", "updateNodeCount", "count", "clearUpdatedNodeCounts", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "doRecordDownsFor", "nearestCommonRoot", "compositeKeyOf", "recomposeKey", "(IIJ)J", "groupCompositeKeyPart", "tryImminentInvalidation", "scope", "instance", "tryImminentInvalidation$runtime", "parentKey", "parentKey$runtime", "skipCurrentGroup", "skipReaderToGroupEnd", "shouldExecute", "parametersChanged", DownloaderServiceMarshaller.PARAMS_FLAGS, "skipToGroupEnd", "deactivateToEndGroup", "startRestartGroup", "Landroidx/compose/runtime/Composer;", "addRecomposeScope", "enterRecomposeScope", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "exitRecomposeScope", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "invokeMovableContentLambda", FirebaseAnalytics.Param.CONTENT, "locals", "force", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentGuarded", "withReader", "R", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeMovableContent", "from", "Landroidx/compose/runtime/ControlledComposition;", TypedValues.TransitionType.S_TO, "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sourceInformation", "", "sourceInformationMarkerStart", "sourceInformationMarkerEnd", "disableSourceInformation", "stackTraceForValue", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "stackTraceForValue$runtime", "currentStackTrace", "stackTraceForGroup", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "dataOffset", "(ILjava/lang/Integer;)Ljava/util/List;", "parentStackTrace", "parentStackTrace$runtime", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/Composable;", "shouldPause", "composeContent--ZbOJvo$runtime", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ShouldPauseCallback;)V", "prepareCompose", "prepareCompose$runtime", "recompose", "recompose-aFTiNEg$runtime", "(Landroidx/collection/MutableScatterMap;Landroidx/compose/runtime/ShouldPauseCallback;)Z", "updateComposerInvalidations", "updateComposerInvalidations-RY85e9Y$runtime", "(Landroidx/collection/MutableScatterMap;)V", "doCompose", "doCompose-aFTiNEg", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", "hasInvalidations", "getHasInvalidations", "node", "getNode", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;)Ljava/lang/Object;", "nodeAt", "validateNodeExpected", "validateNodeNotExpected", "recordInsert", "anchor", "recordDelete", "reportFreeMovableContent", "groupBeingRemoved", "reportAllMovableContent", "finalizeCompose", "cleanUpCompose", "verifyConsistent", "verifyConsistent$runtime", "updateCompositeKeyWhenWeEnterGroup", "groupKey", "updateCompositeKeyWhenWeEnterGroupKeyHash", "updateCompositeKeyWhenWeExitGroup", "updateCompositeKeyWhenWeExitGroupKeyHash", "stacksSize", "stacksSize$runtime", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "rememberedValue", "updateRememberedValue", "recordUsed", "CompositionContextHolder", "CompositionContextImpl", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GapComposer extends InternalComposer {
    public static final int $stable = 8;
    private CompositionData _compositionData;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final CoroutineContext applyCoroutineContext;
    private final ComposerChangeListWriter changeListWriter;
    private Changes changes;
    private int childrenComposing;
    private long compositeKeyHashCode;
    private final CompositionImpl composition;
    private int compositionToken;
    private ChangeList deferredChanges;
    private final GapComposer$derivedStateObserver$1 derivedStateObserver;
    private final CompositionErrorContextImpl errorContext;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private GapAnchor insertAnchor;
    private FixupList insertFixups;
    private SlotTable insertTable;
    private boolean inserting;
    private final ArrayList<RecomposeScopeImpl> invalidateStack;
    private boolean isComposing;
    private boolean isDisposed;
    private Changes lateChanges;
    private int[] nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parentContext;
    private boolean pausable;
    private GapPending pending;
    private PersistentCompositionLocalMap providerCache;
    private MutableIntObjectMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private int rGroupIndex;
    private SlotReader reader;
    private boolean reusing;
    private ShouldPauseCallback shouldPauseCallback;
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private final ArrayList<GapPending> pendingStack = Stack.m4452constructorimpl$default(null, 1, null);
    private final IntStack parentStateStack = new IntStack();
    private final List<Invalidation> invalidations = new ArrayList();
    private final IntStack entersStack = new IntStack();
    private PersistentCompositionLocalMap rootProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    private final IntStack providersInvalidStack = new IntStack();
    private int reusingGroup = -1;

    public static /* synthetic */ void getCompositeKeyHashCode$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int insertedGroupVirtualIndex(int i) {
        return (-2) - i;
    }

    /* JADX WARN: Type inference failed for: r5v13, types: [androidx.compose.runtime.GapComposer$derivedStateObserver$1] */
    public GapComposer(Applier<?> applier, CompositionContext compositionContext, SlotTable slotTable, Set<RememberObserver> set, Changes changes, Changes changes2, CompositionObserverHolder compositionObserverHolder, CompositionImpl compositionImpl) {
        this.applier = applier;
        this.parentContext = compositionContext;
        this.slotTable = slotTable;
        this.abandonSet = set;
        this.changes = changes;
        this.lateChanges = changes2;
        this.observerHolder = compositionObserverHolder;
        this.composition = compositionImpl;
        this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation$runtime() || compositionContext.getCollectingCallByInformation$runtime();
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.GapComposer$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                GapComposer.this.childrenComposing++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                GapComposer.this.childrenComposing--;
            }
        };
        this.invalidateStack = Stack.m4452constructorimpl$default(null, 1, null);
        SlotReader openReader = slotTable.openReader();
        openReader.close();
        this.reader = openReader;
        SlotTable slotTable2 = new SlotTable();
        if (compositionContext.getCollectingSourceInformation$runtime()) {
            slotTable2.collectSourceInformation();
        }
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable2.collectCalledByInformation();
        }
        this.insertTable = slotTable2;
        SlotWriter openWriter = slotTable2.openWriter();
        openWriter.close(true);
        this.writer = openWriter;
        this.changeListWriter = new ComposerChangeListWriter(this, ChangeListKt.asGapBufferChangeList(this.changes));
        SlotReader openReader2 = this.insertTable.openReader();
        try {
            GapAnchor anchor = openReader2.anchor(0);
            openReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new FixupList();
            this.errorContext = new CompositionErrorContextImpl(this);
            CoroutineContext effectCoroutineContext = compositionContext.getEffectCoroutineContext();
            CoroutineContext errorContext$runtime = getErrorContext$runtime();
            this.applyCoroutineContext = effectCoroutineContext.plus(errorContext$runtime == null ? EmptyCoroutineContext.INSTANCE : errorContext$runtime);
        } catch (Throwable th) {
            openReader2.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionImpl getComposition() {
        return this.composition;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean getSourceMarkersEnabled$runtime() {
        return this.sourceMarkersEnabled;
    }

    public void setSourceMarkersEnabled$runtime(boolean z) {
        this.sourceMarkersEnabled = z;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean isComposing$runtime() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime() {
        return this.isDisposed;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean getAreChildrenComposing$runtime() {
        return this.childrenComposing > 0;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean getHasPendingChanges$runtime() {
        return this.changes.isNotEmpty();
    }

    public final SlotReader getReader$runtime() {
        return this.reader;
    }

    public final void setReader$runtime(SlotReader slotReader) {
        this.reader = slotReader;
    }

    public final SlotTable getInsertTable$runtime() {
        return this.insertTable;
    }

    public final void setInsertTable$runtime(SlotTable slotTable) {
        this.insertTable = slotTable;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public ChangeList getDeferredChanges$runtime() {
        return this.deferredChanges;
    }

    public void setDeferredChanges$runtime(ChangeList changeList) {
        this.deferredChanges = changeList;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public CompositionErrorContextImpl getErrorContext$runtime() {
        if (this.parentContext.getStackTraceEnabled$runtime()) {
            return this.errorContext;
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public CoroutineContext getApplyCoroutineContext() {
        return this.applyCoroutineContext;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceableGroup(int i) {
        m4427startAzEfcrM(i, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceGroup(int i) {
        if (this.pending != null) {
            m4427startAzEfcrM(i, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
            return;
        }
        validateNodeNotExpected();
        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ i, 3) ^ this.rGroupIndex;
        this.rGroupIndex++;
        SlotReader slotReader = this.reader;
        if (getInserting()) {
            slotReader.beginEmpty();
            this.writer.startGroup(i, Composer.Companion.getEmpty());
            enterGroup(false, null);
        } else if (slotReader.getGroupKey() == i && !slotReader.getHasObjectKey()) {
            slotReader.startGroup();
            enterGroup(false, null);
        } else {
            if (!slotReader.isGroupEnd()) {
                int i2 = this.nodeIndex;
                int currentGroup = slotReader.getCurrentGroup();
                recordDelete();
                this.changeListWriter.removeNode(i2, slotReader.skipGroup());
                GapComposerKt.removeRange(this.invalidations, currentGroup, slotReader.getCurrentGroup());
            }
            slotReader.beginEmpty();
            this.inserting = true;
            this.providerCache = null;
            ensureWriter();
            SlotWriter slotWriter = this.writer;
            slotWriter.beginInsert();
            int currentGroup2 = slotWriter.getCurrentGroup();
            slotWriter.startGroup(i, Composer.Companion.getEmpty());
            this.insertAnchor = slotWriter.anchor(currentGroup2);
            enterGroup(false, null);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startDefaults() {
        m4427startAzEfcrM(ComposerKt.defaultsKey, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime == null || !currentRecomposeScope$runtime.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return !getSkipping() || this.providersInvalid || ((currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) != null && currentRecomposeScope$runtime.getDefaultsInvalid());
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startMovableGroup(int i, Object obj) {
        m4427startAzEfcrM(i, obj, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    private final void startRoot() {
        int asInt;
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime();
        PersistentCompositionLocalMap compositionLocalScope$runtime = this.parentContext.getCompositionLocalScope$runtime();
        IntStack intStack = this.providersInvalidStack;
        asInt = GapComposerKt.asInt(this.providersInvalid);
        intStack.push(asInt);
        this.providersInvalid = changed(compositionLocalScope$runtime);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime();
        }
        if (!getSourceMarkersEnabled$runtime()) {
            setSourceMarkersEnabled$runtime(this.parentContext.getCollectingSourceInformation$runtime());
        }
        if (getSourceMarkersEnabled$runtime()) {
            CompositionLocal<CompositionErrorContext> localCompositionErrorContext = CompositionErrorContextKt.getLocalCompositionErrorContext();
            Intrinsics.checkNotNull(localCompositionErrorContext, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
            compositionLocalScope$runtime = compositionLocalScope$runtime.putValue(localCompositionErrorContext, new StaticValueHolder(getErrorContext$runtime()));
        }
        this.rootProvider = compositionLocalScope$runtime;
        Set<CompositionData> set = (Set) CompositionLocalMapKt.read(compositionLocalScope$runtime, InspectionTablesKt.getLocalInspectionTables());
        if (set != null) {
            set.add(getCompositionData());
            this.parentContext.recordInspectionTable$runtime(set);
        }
        startGroup(Long.hashCode(this.parentContext.getCompositeKeyHashCode$runtime()));
    }

    private final void endRoot() {
        boolean asBool;
        endGroup();
        this.parentContext.doneComposing$runtime();
        endGroup();
        this.changeListWriter.endRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        asBool = GapComposerKt.asBool(this.providersInvalidStack.pop());
        this.providersInvalid = asBool;
    }

    private final void abortRoot() {
        cleanUpCompose();
        Stack.m4450clearimpl(this.pendingStack);
        this.parentStateStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = null;
        this.insertFixups.clear();
        this.compositeKeyHashCode = 0L;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (this.writer.getClosed()) {
            return;
        }
        forceFreshInsertTable();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void changesApplied$runtime() {
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return (getInserting() || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || currentRecomposeScope$runtime.getRequiresRecompose() || this.forciblyRecompose) ? false : true;
    }

    @Override // androidx.compose.runtime.Composer
    public long getCompositeKeyHashCode() {
        return this.compositeKeyHashCode;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        setSourceMarkersEnabled$runtime(true);
        this.slotTable.collectSourceInformation();
        this.insertTable.collectSourceInformation();
        this.writer.updateToTableMaps();
    }

    @Override // androidx.compose.runtime.Composer
    public CancellationHandle scheduleFrameEndCallback(Function0<Unit> function0) {
        return this.parentContext.scheduleFrameEndCallback(function0);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void dispose$runtime() {
        Object beginSection = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime(this);
            deactivate$runtime();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void deactivate$runtime() {
        Stack.m4450clearimpl(this.invalidateStack);
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean forceRecomposeScopes$runtime() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    private final void startGroup(int i) {
        m4427startAzEfcrM(i, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    private final void startGroup(int i, Object obj) {
        m4427startAzEfcrM(i, obj, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    private final void endGroup() {
        end(false);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m4427startAzEfcrM(GapComposerKt.nodeKey, null, GroupKind.Companion.m4537getNode9udXigM(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m4427startAzEfcrM(GapComposerKt.nodeKey, null, GroupKind.Companion.m4538getReusableNode9udXigM(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(Function0<? extends T> function0) {
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        int peek = this.parentStateStack.peek();
        SlotWriter slotWriter = this.writer;
        GapAnchor anchor = slotWriter.anchor(slotWriter.getParent());
        this.groupNodeCount++;
        this.insertFixups.createAndInsertNode(function0, peek, anchor);
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object node = getNode(this.reader);
        this.changeListWriter.moveDown(node);
        if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
            this.changeListWriter.useNode(node);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int i, Object obj) {
        if (!getInserting() && this.reader.getGroupKey() == i && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m4427startAzEfcrM(i, null, GroupKind.Companion.m4536getGroup9udXigM(), obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void startReuseFromRoot$runtime() {
        this.reusingGroup = 0;
        this.reusing = true;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void endReuseFromRoot$runtime() {
        if (!(!isComposing$runtime() && this.reusingGroup == 0)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int i) {
        if (i < 0) {
            int i2 = -i;
            SlotWriter slotWriter = this.writer;
            while (true) {
                int parent = slotWriter.getParent();
                if (parent <= i2) {
                    return;
                }
                end(slotWriter.isNode(parent));
            }
        } else {
            if (getInserting()) {
                SlotWriter slotWriter2 = this.writer;
                while (getInserting()) {
                    end(slotWriter2.isNode(slotWriter2.getParent()));
                }
            }
            SlotReader slotReader = this.reader;
            while (true) {
                int parent2 = slotReader.getParent();
                if (parent2 <= i) {
                    return;
                }
                end(slotReader.isNode(parent2));
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(V v, Function2<? super T, ? super V, Unit> function2) {
        if (getInserting()) {
            this.insertFixups.updateNode(v, function2);
        } else {
            this.changeListWriter.updateNode(v, function2);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Object joinKey(Object obj, Object obj2) {
        Object key;
        key = GapComposerKt.getKey(this.reader.getGroupObjectKey(), obj, obj2);
        return key == null ? new JoinedKey(obj, obj2) : key;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserverHolder)) ? next : Composer.Companion.getEmpty();
    }

    public final Object nextSlotForCache() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserverHolder)) ? next instanceof RememberObserverHolder ? ((RememberObserverHolder) next).getWrapped() : next : Composer.Companion.getEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(Object obj) {
        if (Intrinsics.areEqual(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changedInstance(Object obj) {
        if (nextSlot() != obj) {
            updateValue(obj);
            return true;
        }
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(char c) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Character) && c == ((Character) nextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(byte b) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Byte) && b == ((Number) nextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(short s) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Short) && s == ((Number) nextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(boolean z) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Boolean) && z == ((Boolean) nextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(float f) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Float) && f == ((Number) nextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(long j) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Long) && j == ((Number) nextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(double d) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Double) && d == ((Number) nextSlot).doubleValue()) {
            return false;
        }
        updateValue(Double.valueOf(d));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(int i) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Integer) && i == ((Number) nextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i));
        return true;
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean z, Function0<? extends T> function0) {
        T t = (T) nextSlotForCache();
        if (t == Composer.Companion.getEmpty() || z) {
            T invoke = function0.invoke();
            updateCachedValue(invoke);
            return invoke;
        }
        return t;
    }

    private final void updateSlot(Object obj) {
        nextSlot();
        updateValue(obj);
    }

    public final void updateValue(Object obj) {
        if (getInserting()) {
            this.writer.update(obj);
        } else if (this.reader.getHadNext()) {
            int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
            boolean pastParent = this.changeListWriter.getPastParent();
            ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
            if (pastParent) {
                SlotReader slotReader = this.reader;
                composerChangeListWriter.updateAnchoredValue(obj, slotReader.anchor(slotReader.getParent()), groupSlotIndex);
                return;
            }
            composerChangeListWriter.updateValue(obj, groupSlotIndex);
        } else {
            ComposerChangeListWriter composerChangeListWriter2 = this.changeListWriter;
            SlotReader slotReader2 = this.reader;
            composerChangeListWriter2.appendValue(slotReader2.anchor(slotReader2.getParent()), obj);
        }
    }

    public final void updateCachedValue(Object obj) {
        if (obj instanceof RememberObserver) {
            GapRememberObserverHolder gapRememberObserverHolder = new GapRememberObserverHolder((RememberObserver) obj, rememberObserverGroupIndex());
            if (getInserting()) {
                this.changeListWriter.remember(gapRememberObserverHolder);
            }
            this.abandonSet.add(obj);
            obj = gapRememberObserverHolder;
        }
        updateValue(obj);
    }

    private final int rememberObserverGroupIndex() {
        return this.rGroupIndex - 1;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        CompositionData compositionData = this._compositionData;
        if (compositionData == null) {
            GapCompositionDataImpl gapCompositionDataImpl = new GapCompositionDataImpl(getComposition());
            this._compositionData = gapCompositionDataImpl;
            return gapCompositionDataImpl;
        }
        return compositionData;
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(Function0<Unit> function0) {
        this.changeListWriter.sideEffect(function0);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.getParent());
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int i) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        if (getInserting() && this.writerHasAProvider) {
            int parent = this.writer.getParent();
            while (parent > 0) {
                if (this.writer.groupKey(parent) == 202 && Intrinsics.areEqual(this.writer.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    Object groupAux = this.writer.groupAux(parent);
                    Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupAux;
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                parent = this.writer.parent(parent);
            }
        }
        if (this.reader.getSize() > 0) {
            while (i > 0) {
                if (this.reader.groupKey(i) == 202 && Intrinsics.areEqual(this.reader.groupObjectKey(i), ComposerKt.getCompositionLocalMap())) {
                    MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
                    if (mutableIntObjectMap == null || (persistentCompositionLocalMap = mutableIntObjectMap.get(i)) == null) {
                        Object groupAux2 = this.reader.groupAux(i);
                        Intrinsics.checkNotNull(groupAux2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap = (PersistentCompositionLocalMap) groupAux2;
                    }
                    this.providerCache = persistentCompositionLocalMap;
                    return persistentCompositionLocalMap;
                }
                i = this.reader.parent(i);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.rootProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    @Override // androidx.compose.runtime.Composer
    public void startProvider(ProvidedValue<?> providedValue) {
        ValueHolder<Object> valueHolder;
        int asInt;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        Object rememberedValue = rememberedValue();
        if (Intrinsics.areEqual(rememberedValue, Composer.Companion.getEmpty())) {
            valueHolder = null;
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            valueHolder = (ValueHolder) rememberedValue;
        }
        CompositionLocal<Object> compositionLocal = providedValue.getCompositionLocal();
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(providedValue, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        ValueHolder<Object> updatedStateOf$runtime = compositionLocal.updatedStateOf$runtime(providedValue, valueHolder);
        boolean areEqual = Intrinsics.areEqual(updatedStateOf$runtime, valueHolder);
        if (!areEqual) {
            updateRememberedValue(updatedStateOf$runtime);
        }
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            if (providedValue.getCanOverride() || !CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal)) {
                currentCompositionLocalScope = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime);
            }
            this.writerHasAProvider = true;
        } else {
            SlotReader slotReader = this.reader;
            Object groupAux = slotReader.groupAux(slotReader.getCurrentGroup());
            Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) groupAux;
            if ((!getSkipping() || !areEqual) && (providedValue.getCanOverride() || !CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal))) {
                currentCompositionLocalScope = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime);
            } else if ((areEqual && !this.providersInvalid) || !this.providersInvalid) {
                currentCompositionLocalScope = persistentCompositionLocalMap;
            }
            if (!this.reusing && persistentCompositionLocalMap == currentCompositionLocalScope) {
                z = false;
            }
            z2 = z;
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(currentCompositionLocalScope);
        }
        IntStack intStack = this.providersInvalidStack;
        asInt = GapComposerKt.asInt(this.providersInvalid);
        intStack.push(asInt);
        this.providersInvalid = z2;
        this.providerCache = currentCompositionLocalScope;
        m4427startAzEfcrM(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m4536getGroup9udXigM(), currentCompositionLocalScope);
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
            this.providerUpdates = mutableIntObjectMap;
        }
        mutableIntObjectMap.set(this.reader.getCurrentGroup(), persistentCompositionLocalMap);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProvider() {
        boolean asBool;
        endGroup();
        endGroup();
        asBool = GapComposerKt.asBool(this.providersInvalidStack.pop());
        this.providersInvalid = asBool;
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void startProviders(ProvidedValue<?>[] providedValueArr) {
        PersistentCompositionLocalMap updateProviderMapGroup;
        int asInt;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            updateProviderMapGroup = updateProviderMapGroup(currentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(providedValueArr, currentCompositionLocalScope, null, 4, null));
            this.writerHasAProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupGet2;
            PersistentCompositionLocalMap updateCompositionMap = CompositionLocalMapKt.updateCompositionMap(providedValueArr, currentCompositionLocalScope, persistentCompositionLocalMap2);
            if (!getSkipping() || this.reusing || !Intrinsics.areEqual(persistentCompositionLocalMap2, updateCompositionMap)) {
                updateProviderMapGroup = updateProviderMapGroup(currentCompositionLocalScope, updateCompositionMap);
                if (!this.reusing && Intrinsics.areEqual(updateProviderMapGroup, persistentCompositionLocalMap)) {
                    z = false;
                }
                z2 = z;
            } else {
                skipGroup();
                updateProviderMapGroup = persistentCompositionLocalMap;
            }
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(updateProviderMapGroup);
        }
        IntStack intStack = this.providersInvalidStack;
        asInt = GapComposerKt.asInt(this.providersInvalid);
        intStack.push(asInt);
        this.providersInvalid = z2;
        this.providerCache = updateProviderMapGroup;
        m4427startAzEfcrM(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m4536getGroup9udXigM(), updateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProviders() {
        boolean asBool;
        endGroup();
        endGroup();
        asBool = GapComposerKt.asBool(this.providersInvalidStack.pop());
        this.providersInvalid = asBool;
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public <T> T consume(CompositionLocal<T> compositionLocal) {
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), compositionLocal);
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        GapComposer gapComposer;
        startGroup(206, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, null);
        }
        Object nextSlot = nextSlot();
        ReusableGapRememberObserverHolder reusableGapRememberObserverHolder = nextSlot instanceof RememberObserverHolder ? (RememberObserverHolder) nextSlot : null;
        if (reusableGapRememberObserverHolder == null) {
            gapComposer = this;
            reusableGapRememberObserverHolder = new ReusableGapRememberObserverHolder(new CompositionContextHolder(new CompositionContextImpl(getCompositeKeyHashCode(), this.forceRecomposeScopes, getSourceMarkersEnabled$runtime(), getComposition().getObserverHolder$runtime())), -1);
            gapComposer.updateValue(reusableGapRememberObserverHolder);
        } else {
            gapComposer = this;
        }
        RememberObserver wrapped = reusableGapRememberObserverHolder.getWrapped();
        Intrinsics.checkNotNull(wrapped, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer.CompositionContextHolder");
        CompositionContextHolder compositionContextHolder = (CompositionContextHolder) wrapped;
        compositionContextHolder.getRef().updateCompositionLocalScope(gapComposer.currentCompositionLocalScope());
        gapComposer.endGroup();
        return compositionContextHolder.getRef();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public RecomposeScopeImpl getCurrentRecomposeScope$runtime() {
        ArrayList<RecomposeScopeImpl> arrayList = this.invalidateStack;
        if (this.childrenComposing == 0 && Stack.m4458isNotEmptyimpl(arrayList)) {
            return (RecomposeScopeImpl) Stack.m4459peekimpl(arrayList);
        }
        return null;
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter openWriter = this.insertTable.openWriter();
            this.writer = openWriter;
            openWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void createFreshInsertTable() {
        if (!this.writer.getClosed()) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        forceFreshInsertTable();
    }

    private final void forceFreshInsertTable() {
        SlotTable slotTable = new SlotTable();
        if (getSourceMarkersEnabled$runtime()) {
            slotTable.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime()) {
            slotTable.collectCalledByInformation();
        }
        this.insertTable = slotTable;
        SlotWriter openWriter = slotTable.openWriter();
        openWriter.close(true);
        this.writer = openWriter;
    }

    private final void startReaderGroup(boolean z, Object obj) {
        if (z) {
            this.reader.startNode();
            return;
        }
        if (obj != null && this.reader.getGroupAux() != obj) {
            this.changeListWriter.updateAuxData(obj);
        }
        this.reader.startGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* renamed from: start-AzEfcrM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m4427startAzEfcrM(int i, Object obj, int i2, Object obj2) {
        long rotateLeft;
        Object obj3 = obj;
        validateNodeNotExpected();
        int i3 = this.rGroupIndex;
        if (obj3 == null) {
            if (obj2 != null && i == 207 && !Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ obj2.hashCode(), 3) ^ i3;
                if (obj3 == null) {
                    this.rGroupIndex++;
                }
                boolean z = i2 == GroupKind.Companion.m4536getGroup9udXigM();
                GapPending gapPending = null;
                if (!getInserting()) {
                    this.reader.beginEmpty();
                    int currentGroup = this.writer.getCurrentGroup();
                    if (z) {
                        this.writer.startNode(i, Composer.Companion.getEmpty());
                    } else {
                        SlotWriter slotWriter = this.writer;
                        if (obj2 != null) {
                            if (obj3 == null) {
                                obj3 = Composer.Companion.getEmpty();
                            }
                            slotWriter.startData(i, obj3, obj2);
                        } else {
                            if (obj3 == null) {
                                obj3 = Composer.Companion.getEmpty();
                            }
                            slotWriter.startGroup(i, obj3);
                        }
                    }
                    GapPending gapPending2 = this.pending;
                    if (gapPending2 != null) {
                        KeyInfo keyInfo = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                        gapPending2.registerInsert(keyInfo, this.nodeIndex - gapPending2.getStartIndex());
                        gapPending2.recordUsed(keyInfo);
                    }
                    enterGroup(z, null);
                    return;
                }
                boolean z2 = i2 == GroupKind.Companion.m4537getNode9udXigM() && this.reusing;
                if (this.pending == null) {
                    int groupKey = this.reader.getGroupKey();
                    if (!z2 && groupKey == i && Intrinsics.areEqual(obj, this.reader.getGroupObjectKey())) {
                        startReaderGroup(z, obj2);
                    } else {
                        this.pending = new GapPending(this.reader.extractKeys(), this.nodeIndex);
                    }
                }
                GapPending gapPending3 = this.pending;
                if (gapPending3 != null) {
                    KeyInfo next = gapPending3.getNext(i, obj);
                    if (!z2 && next != null) {
                        gapPending3.recordUsed(next);
                        int location = next.getLocation();
                        this.nodeIndex = gapPending3.nodePositionOf(next) + gapPending3.getStartIndex();
                        int slotPositionOf = gapPending3.slotPositionOf(next);
                        int groupIndex = slotPositionOf - gapPending3.getGroupIndex();
                        gapPending3.registerMoveSlot(slotPositionOf, gapPending3.getGroupIndex());
                        this.changeListWriter.moveReaderRelativeTo(location);
                        this.reader.reposition(location);
                        if (groupIndex > 0) {
                            this.changeListWriter.moveCurrentGroup(groupIndex);
                        }
                        startReaderGroup(z, obj2);
                    } else {
                        this.reader.beginEmpty();
                        this.inserting = true;
                        this.providerCache = null;
                        ensureWriter();
                        this.writer.beginInsert();
                        int currentGroup2 = this.writer.getCurrentGroup();
                        if (z) {
                            this.writer.startNode(i, Composer.Companion.getEmpty());
                        } else {
                            SlotWriter slotWriter2 = this.writer;
                            if (obj2 != null) {
                                if (obj3 == null) {
                                    obj3 = Composer.Companion.getEmpty();
                                }
                                slotWriter2.startData(i, obj3, obj2);
                            } else {
                                if (obj3 == null) {
                                    obj3 = Composer.Companion.getEmpty();
                                }
                                slotWriter2.startGroup(i, obj3);
                            }
                        }
                        this.insertAnchor = this.writer.anchor(currentGroup2);
                        KeyInfo keyInfo2 = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                        gapPending3.registerInsert(keyInfo2, this.nodeIndex - gapPending3.getStartIndex());
                        gapPending3.recordUsed(keyInfo2);
                        gapPending = new GapPending(new ArrayList(), z ? 0 : this.nodeIndex);
                    }
                }
                enterGroup(z, gapPending);
                return;
            }
            rotateLeft = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ i, 3) ^ i3;
        } else {
            rotateLeft = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ (obj3 instanceof Enum ? ((Enum) obj3).ordinal() : obj.hashCode()), 3);
        }
        this.compositeKeyHashCode = rotateLeft;
        if (obj3 == null) {
        }
        if (i2 == GroupKind.Companion.m4536getGroup9udXigM()) {
        }
        GapPending gapPending4 = null;
        if (!getInserting()) {
        }
    }

    private final void enterGroup(boolean z, GapPending gapPending) {
        Stack.m4462pushimpl(this.pendingStack, this.pending);
        this.pending = gapPending;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
    }

    private final void exitGroup(int i, boolean z) {
        GapPending gapPending = (GapPending) Stack.m4461popimpl(this.pendingStack);
        if (gapPending != null && !z) {
            gapPending.setGroupIndex(gapPending.getGroupIndex() + 1);
        }
        this.pending = gapPending;
        this.nodeIndex = this.parentStateStack.pop() + i;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + i;
    }

    private final void end(boolean z) {
        long rotateRight;
        long j;
        int remainingSlots;
        List<KeyInfo> list;
        List<KeyInfo> list2;
        long rotateRight2;
        long j2;
        int peek2 = this.parentStateStack.peek2() - 1;
        if (getInserting()) {
            int parent = this.writer.getParent();
            int groupKey = this.writer.groupKey(parent);
            Object groupObjectKey = this.writer.groupObjectKey(parent);
            Object groupAux = this.writer.groupAux(parent);
            if (groupObjectKey == null) {
                if (groupAux != null && groupKey == 207 && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                    this.compositeKeyHashCode = Long.rotateRight(groupAux.hashCode() ^ Long.rotateRight(getCompositeKeyHashCode() ^ peek2, 3), 3);
                } else {
                    rotateRight2 = Long.rotateRight(getCompositeKeyHashCode() ^ peek2, 3);
                    j2 = groupKey;
                }
            } else {
                int ordinal = groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode();
                rotateRight2 = Long.rotateRight(getCompositeKeyHashCode(), 3);
                j2 = ordinal;
            }
            this.compositeKeyHashCode = Long.rotateRight(rotateRight2 ^ j2, 3);
        } else {
            int parent2 = this.reader.getParent();
            int groupKey2 = this.reader.groupKey(parent2);
            Object groupObjectKey2 = this.reader.groupObjectKey(parent2);
            Object groupAux2 = this.reader.groupAux(parent2);
            if (groupObjectKey2 == null) {
                if (groupAux2 != null && groupKey2 == 207 && !Intrinsics.areEqual(groupAux2, Composer.Companion.getEmpty())) {
                    this.compositeKeyHashCode = Long.rotateRight(groupAux2.hashCode() ^ Long.rotateRight(getCompositeKeyHashCode() ^ peek2, 3), 3);
                } else {
                    rotateRight = Long.rotateRight(getCompositeKeyHashCode() ^ peek2, 3);
                    j = groupKey2;
                }
            } else {
                int ordinal2 = groupObjectKey2 instanceof Enum ? ((Enum) groupObjectKey2).ordinal() : groupObjectKey2.hashCode();
                rotateRight = Long.rotateRight(getCompositeKeyHashCode(), 3);
                j = ordinal2;
            }
            this.compositeKeyHashCode = Long.rotateRight(rotateRight ^ j, 3);
        }
        int i = this.groupNodeCount;
        GapPending gapPending = this.pending;
        if (gapPending != null && gapPending.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = gapPending.getKeyInfos();
            List<KeyInfo> used = gapPending.getUsed();
            Set fastToSet = ListUtilsKt.fastToSet(used);
            MutableScatterSet mutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            int size = used.size();
            int size2 = keyInfos.size();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < size2) {
                KeyInfo keyInfo = keyInfos.get(i2);
                if (!fastToSet.contains(keyInfo)) {
                    this.changeListWriter.removeNode(gapPending.nodePositionOf(keyInfo) + gapPending.getStartIndex(), keyInfo.getNodes());
                    gapPending.updateNodeCount(keyInfo.getLocation(), 0);
                    this.changeListWriter.moveReaderRelativeTo(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    list = keyInfos;
                    GapComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                } else {
                    list = keyInfos;
                    if (!mutableScatterSetOf.contains(keyInfo)) {
                        if (i3 < size) {
                            KeyInfo keyInfo2 = used.get(i3);
                            if (keyInfo2 != keyInfo) {
                                int nodePositionOf = gapPending.nodePositionOf(keyInfo2);
                                mutableScatterSetOf.add(keyInfo2);
                                if (nodePositionOf != i4) {
                                    int updatedNodeCountOf = gapPending.updatedNodeCountOf(keyInfo2);
                                    list2 = used;
                                    this.changeListWriter.moveNode(gapPending.getStartIndex() + nodePositionOf, i4 + gapPending.getStartIndex(), updatedNodeCountOf);
                                    gapPending.registerMoveNode(nodePositionOf, i4, updatedNodeCountOf);
                                } else {
                                    list2 = used;
                                }
                            } else {
                                list2 = used;
                                i2++;
                            }
                            i3++;
                            i4 += gapPending.updatedNodeCountOf(keyInfo2);
                            keyInfos = list;
                            used = list2;
                        }
                        keyInfos = list;
                    }
                }
                i2++;
                keyInfos = list;
            }
            this.changeListWriter.endNodeMovement();
            if (keyInfos.size() > 0) {
                this.changeListWriter.moveReaderRelativeTo(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        boolean inserting = getInserting();
        if (!inserting && (remainingSlots = this.reader.getRemainingSlots()) > 0) {
            this.changeListWriter.trimValues(remainingSlots);
        }
        int i5 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i5, this.reader.skipGroup());
            GapComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        if (inserting) {
            if (z) {
                this.insertFixups.endNodeInsert();
                i = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int insertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close(true);
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(insertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(insertedGroupVirtualIndex, i);
                }
            }
        } else {
            if (z) {
                this.changeListWriter.moveUp();
            }
            this.changeListWriter.endCurrentGroup();
            int parent4 = this.reader.getParent();
            if (i != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i);
            }
            if (z) {
                i = 1;
            }
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
        }
        exitGroup(i, inserting);
    }

    private final void recomposeToGroupEnd() {
        Invalidation firstInRange;
        boolean isComposing$runtime = isComposing$runtime();
        this.isComposing = true;
        int parent = this.reader.getParent();
        int groupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        long compositeKeyHashCode = getCompositeKeyHashCode();
        int i2 = this.groupNodeCount;
        int i3 = this.rGroupIndex;
        firstInRange = GapComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        boolean z = false;
        int i4 = parent;
        while (firstInRange != null) {
            int location = firstInRange.getLocation();
            RecomposeScopeImpl scope = firstInRange.getScope();
            GapComposerKt.removeLocation(this.invalidations, location);
            if (firstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i4, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.rGroupIndex = rGroupIndexOf(currentGroup);
                this.compositeKeyHashCode = compositeKeyOf(this.reader.parent(currentGroup), parent, compositeKeyHashCode);
                this.providerCache = null;
                scope.compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                z = true;
                i4 = currentGroup;
            } else {
                Stack.m4462pushimpl(this.invalidateStack, scope);
                CompositionObserver current = this.observerHolder.current();
                if (current != null) {
                    try {
                        current.onScopeEnter(scope);
                        scope.rereadTrackedInstances();
                    } finally {
                        current.onScopeExit(scope);
                    }
                } else {
                    scope.rereadTrackedInstances();
                }
                Stack.m4461popimpl(this.invalidateStack);
            }
            firstInRange = GapComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        }
        if (z) {
            recordUpsAndDowns(i4, parent, parent);
            this.reader.skipToGroupEnd();
            int updatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + updatedNodeCount;
            this.groupNodeCount = i2 + updatedNodeCount;
            this.rGroupIndex = i3;
        } else {
            skipReaderToGroupEnd();
        }
        this.compositeKeyHashCode = compositeKeyHashCode;
        this.isComposing = isComposing$runtime;
    }

    private final void updateNodeCountOverrides(int i, int i2) {
        int updatedNodeCount = updatedNodeCount(i);
        if (updatedNodeCount != i2) {
            int i3 = i2 - updatedNodeCount;
            int m4455getSizeimpl = Stack.m4455getSizeimpl(this.pendingStack) - 1;
            while (i != -1) {
                int updatedNodeCount2 = updatedNodeCount(i) + i3;
                updateNodeCount(i, updatedNodeCount2);
                int i4 = m4455getSizeimpl;
                while (true) {
                    if (-1 < i4) {
                        GapPending gapPending = (GapPending) Stack.m4460peekimpl(this.pendingStack, i4);
                        if (gapPending != null && gapPending.updateNodeCount(i, updatedNodeCount2)) {
                            m4455getSizeimpl = i4 - 1;
                            break;
                        }
                        i4--;
                    } else {
                        break;
                    }
                }
                SlotReader slotReader = this.reader;
                if (i < 0) {
                    i = slotReader.getParent();
                } else if (slotReader.isNode(i)) {
                    return;
                } else {
                    i = this.reader.parent(i);
                }
            }
        }
    }

    private final int nodeIndexOf(int i, int i2, int i3, int i4) {
        int parent = this.reader.parent(i2);
        while (parent != i3 && !this.reader.isNode(parent)) {
            parent = this.reader.parent(parent);
        }
        if (this.reader.isNode(parent)) {
            i4 = 0;
        }
        if (parent == i2) {
            return i4;
        }
        int updatedNodeCount = (updatedNodeCount(parent) - this.reader.nodeCount(i2)) + i4;
        loop1: while (i4 < updatedNodeCount && parent != i) {
            parent++;
            while (parent < i) {
                int groupSize = this.reader.groupSize(parent) + parent;
                if (i >= groupSize) {
                    i4 += this.reader.isNode(parent) ? 1 : updatedNodeCount(parent);
                    parent = groupSize;
                }
            }
            break loop1;
        }
        return i4;
    }

    private final int rGroupIndexOf(int i) {
        int parent = this.reader.parent(i) + 1;
        int i2 = 0;
        while (parent < i) {
            if (!this.reader.hasObjectKey(parent)) {
                i2++;
            }
            parent += this.reader.groupSize(parent);
        }
        return i2;
    }

    private final int updatedNodeCount(int i) {
        int i2;
        if (i < 0) {
            MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
            if (mutableIntIntMap == null || !mutableIntIntMap.containsKey(i)) {
                return 0;
            }
            return mutableIntIntMap.get(i);
        }
        int[] iArr = this.nodeCountOverrides;
        return (iArr == null || (i2 = iArr[i]) < 0) ? this.reader.nodeCount(i) : i2;
    }

    private final void updateNodeCount(int i, int i2) {
        if (updatedNodeCount(i) != i2) {
            if (i < 0) {
                MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap(0, 1, null);
                    this.nodeCountVirtualOverrides = mutableIntIntMap;
                }
                mutableIntIntMap.set(i, i2);
                return;
            }
            int[] iArr = this.nodeCountOverrides;
            if (iArr == null) {
                int[] iArr2 = new int[this.reader.getSize()];
                ArraysKt.fill$default(iArr2, -1, 0, 0, 6, (Object) null);
                this.nodeCountOverrides = iArr2;
                iArr = iArr2;
            }
            iArr[i] = i2;
        }
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final void recordUpsAndDowns(int i, int i2, int i3) {
        int nearestCommonRootOf;
        SlotReader slotReader = this.reader;
        nearestCommonRootOf = GapComposerKt.nearestCommonRootOf(slotReader, i, i2, i3);
        while (i > 0 && i != nearestCommonRootOf) {
            if (slotReader.isNode(i)) {
                this.changeListWriter.moveUp();
            }
            i = slotReader.parent(i);
        }
        doRecordDownsFor(i2, nearestCommonRootOf);
    }

    private final void doRecordDownsFor(int i, int i2) {
        if (i <= 0 || i == i2) {
            return;
        }
        doRecordDownsFor(this.reader.parent(i), i2);
        if (this.reader.isNode(i)) {
            this.changeListWriter.moveDown(nodeAt(this.reader, i));
        }
    }

    private final int groupCompositeKeyPart(SlotReader slotReader, int i) {
        Object groupAux;
        if (slotReader.hasObjectKey(i)) {
            Object groupObjectKey = slotReader.groupObjectKey(i);
            if (groupObjectKey != null) {
                return groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey instanceof MovableContent ? MovableContentKt.movableContentKey : groupObjectKey.hashCode();
            }
            return 0;
        }
        int groupKey = slotReader.groupKey(i);
        return (groupKey != 207 || (groupAux = slotReader.groupAux(i)) == null || Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) ? groupKey : groupAux.hashCode();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean tryImminentInvalidation$runtime(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = GapAnchorKt.asGapAnchor(anchor).toIndexFor(this.reader.getTable$runtime());
        if (!isComposing$runtime() || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        GapComposerKt.insertIfMissing(this.invalidations, indexFor, recomposeScopeImpl, obj);
        return true;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public int parentKey$runtime() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void skipCurrentGroup() {
        long rotateLeft;
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        int i = this.rGroupIndex;
        if (groupObjectKey != null) {
            rotateLeft = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ (groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode()), 3);
        } else if (groupAux != null && groupKey == 207 && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
            this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ groupAux.hashCode(), 3) ^ i;
            startReaderGroup(slotReader.isNode(), null);
            recomposeToGroupEnd();
            slotReader.endGroup();
            if (groupObjectKey == null) {
                if (groupObjectKey instanceof Enum) {
                    this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode(), 3) ^ ((Enum) groupObjectKey).ordinal(), 3);
                    return;
                } else {
                    this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode(), 3) ^ groupObjectKey.hashCode(), 3);
                    return;
                }
            } else if (groupAux == null || groupKey != 207 || Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateRight(groupKey ^ Long.rotateRight(getCompositeKeyHashCode() ^ i, 3), 3);
                return;
            } else {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ i, 3) ^ groupAux.hashCode(), 3);
                return;
            }
        } else {
            rotateLeft = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ groupKey, 3) ^ i;
        }
        this.compositeKeyHashCode = rotateLeft;
        startReaderGroup(slotReader.isNode(), null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        if (groupObjectKey == null) {
        }
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean shouldExecute(boolean z, int i) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        if ((i & 1) != 0 || (!getInserting() && !this.reusing)) {
            return z || !getSkipping();
        }
        ShouldPauseCallback shouldPauseCallback = this.shouldPauseCallback;
        if (shouldPauseCallback == null || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || !shouldPauseCallback.shouldPause() || currentRecomposeScope$runtime.getResuming()) {
            return true;
        }
        currentRecomposeScope$runtime.setUsed(true);
        currentRecomposeScope$runtime.setReusing(this.reusing);
        currentRecomposeScope$runtime.setPaused(true);
        this.changeListWriter.rememberPausingScope(currentRecomposeScope$runtime);
        this.parentContext.reportPausedScope$runtime(currentRecomposeScope$runtime);
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (getInserting()) {
            return;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime != null) {
            currentRecomposeScope$runtime.scopeSkipped();
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean z) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling deactivateToEndGroup");
        }
        if (getInserting()) {
            return;
        }
        if (!z) {
            skipReaderToGroupEnd();
            return;
        }
        int currentGroup = this.reader.getCurrentGroup();
        int currentEnd = this.reader.getCurrentEnd();
        this.changeListWriter.deactivateCurrentGroup();
        GapComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Composer startRestartGroup(int i) {
        startReplaceGroup(i);
        addRecomposeScope();
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addRecomposeScope() {
        Invalidation removeLocation;
        RecomposeScopeImpl recomposeScopeImpl;
        boolean z;
        if (!getInserting()) {
            removeLocation = GapComposerKt.removeLocation(this.invalidations, this.reader.getParent());
            Object next = this.reader.next();
            if (Intrinsics.areEqual(next, Composer.Companion.getEmpty())) {
                CompositionImpl composition = getComposition();
                Intrinsics.checkNotNull(composition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
                recomposeScopeImpl = new RecomposeScopeImpl(composition);
                updateValue(recomposeScopeImpl);
            } else {
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                recomposeScopeImpl = (RecomposeScopeImpl) next;
            }
            if (removeLocation == null) {
                boolean forcedRecompose = recomposeScopeImpl.getForcedRecompose();
                if (forcedRecompose) {
                    recomposeScopeImpl.setForcedRecompose(false);
                }
                if (!forcedRecompose) {
                    z = false;
                    recomposeScopeImpl.setRequiresRecompose(z);
                    Stack.m4462pushimpl(this.invalidateStack, recomposeScopeImpl);
                    enterRecomposeScope(recomposeScopeImpl);
                    if (recomposeScopeImpl.getPaused()) {
                        return;
                    }
                    recomposeScopeImpl.setPaused(false);
                    recomposeScopeImpl.setResuming(true);
                    this.changeListWriter.startResumingScope(recomposeScopeImpl);
                    if (this.reusing || !recomposeScopeImpl.getReusing()) {
                        return;
                    }
                    this.reusing = true;
                    this.reusingGroup = this.reader.getParent();
                    recomposeScopeImpl.setResetReusing(true);
                    return;
                }
            }
            z = true;
            recomposeScopeImpl.setRequiresRecompose(z);
            Stack.m4462pushimpl(this.invalidateStack, recomposeScopeImpl);
            enterRecomposeScope(recomposeScopeImpl);
            if (recomposeScopeImpl.getPaused()) {
            }
        } else {
            CompositionImpl composition2 = getComposition();
            Intrinsics.checkNotNull(composition2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl(composition2);
            Stack.m4462pushimpl(this.invalidateStack, recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            enterRecomposeScope(recomposeScopeImpl2);
        }
    }

    private final void enterRecomposeScope(RecomposeScopeImpl recomposeScopeImpl) {
        recomposeScopeImpl.start(this.compositionToken);
        CompositionObserver current = this.observerHolder.current();
        if (current != null) {
            current.onScopeEnter(recomposeScopeImpl);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        GapAnchor anchor;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImpl2 = Stack.m4458isNotEmptyimpl(this.invalidateStack) ? (RecomposeScopeImpl) Stack.m4461popimpl(this.invalidateStack) : null;
        if (recomposeScopeImpl2 != null) {
            recomposeScopeImpl2.setRequiresRecompose(false);
            Function1<Composition, Unit> exitRecomposeScope = exitRecomposeScope(recomposeScopeImpl2);
            if (exitRecomposeScope != null) {
                this.changeListWriter.endCompositionScope(exitRecomposeScope, getComposition());
            }
            if (recomposeScopeImpl2.getResuming()) {
                recomposeScopeImpl2.setResuming(false);
                this.changeListWriter.endResumingScope(recomposeScopeImpl2);
                recomposeScopeImpl2.setReusing(false);
                if (recomposeScopeImpl2.getResetReusing()) {
                    recomposeScopeImpl2.setResetReusing(false);
                    if (this.reusingGroup == this.reader.getParent()) {
                        this.reusing = false;
                        this.reusingGroup = -1;
                    }
                }
            }
        }
        if (recomposeScopeImpl2 != null && !recomposeScopeImpl2.getSkipped$runtime() && (recomposeScopeImpl2.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImpl2.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                recomposeScopeImpl2.setAnchor(anchor);
            }
            recomposeScopeImpl2.setDefaultsInvalid(false);
            recomposeScopeImpl = recomposeScopeImpl2;
        }
        end(false);
        return recomposeScopeImpl;
    }

    private final Function1<Composition, Unit> exitRecomposeScope(RecomposeScopeImpl recomposeScopeImpl) {
        CompositionObserver current = this.observerHolder.current();
        if (current != null) {
            current.onScopeExit(recomposeScopeImpl);
        }
        return recomposeScopeImpl.end(this.compositionToken);
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContent(MovableContent<?> movableContent, Object obj) {
        Intrinsics.checkNotNull(movableContent, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(movableContent, currentCompositionLocalScope(), obj, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        recordProviderUpdate(r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void invokeMovableContentLambda(final MovableContent<Object> movableContent, PersistentCompositionLocalMap persistentCompositionLocalMap, final Object obj, boolean z) {
        startMovableGroup(MovableContentKt.movableContentKey, movableContent);
        updateSlot(obj);
        long compositeKeyHashCode = getCompositeKeyHashCode();
        try {
            this.compositeKeyHashCode = 126665345L;
            boolean z2 = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, null);
            }
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), persistentCompositionLocalMap)) {
                z2 = true;
            }
            m4427startAzEfcrM(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m4536getGroup9udXigM(), persistentCompositionLocalMap);
            this.providerCache = null;
            if (getInserting() && !z) {
                this.writerHasAProvider = true;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime(new MovableContentStateReference(movableContent, obj, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope(), null));
            } else {
                boolean z3 = this.providersInvalid;
                this.providersInvalid = z2;
                Expect_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(-59194059, true, new Function2() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return GapComposer.invokeMovableContentLambda$lambda$0(MovableContent.this, obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                this.providersInvalid = z3;
            }
        } catch (Throwable th) {
            try {
                throw ComposeStackTraceKt.attachComposeStackTrace(th, new Function0() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ComposeStackTrace currentStackTrace;
                        currentStackTrace = GapComposer.this.currentStackTrace();
                        return currentStackTrace;
                    }
                });
            } finally {
                endGroup();
                this.providerCache = null;
                this.compositeKeyHashCode = compositeKeyHashCode;
                endMovableGroup();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeMovableContentLambda$lambda$0(MovableContent movableContent, Object obj, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2265@91036L18:GapComposer.kt#9igjgp");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-59194059, i, -1, "androidx.compose.runtime.GapComposer.invokeMovableContentLambda.<anonymous> (GapComposer.kt:2265)");
            }
            movableContent.getContent().invoke(obj, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        Object beginSection = Trace.INSTANCE.beginSection("Compose:insertMovableContent");
        try {
            insertMovableContentGuarded(list);
            cleanUpCompose();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        ComposerChangeListWriter composerChangeListWriter2;
        ChangeList changeList2;
        List<? extends Object> collectNodesFrom;
        SlotReader slotReader;
        int[] iArr;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap;
        ChangeList changeList3;
        int i;
        int i2;
        GapAnchor anchor;
        SlotStorage slotStorage$runtime;
        List<Pair<MovableContentStateReference, MovableContentStateReference>> list2 = list;
        ComposerChangeListWriter composerChangeListWriter3 = this.changeListWriter;
        ChangeList asGapBufferChangeList = ChangeListKt.asGapBufferChangeList(this.lateChanges);
        ChangeList changeList4 = composerChangeListWriter3.getChangeList();
        try {
            composerChangeListWriter3.setChangeList(asGapBufferChangeList);
            this.changeListWriter.resetSlots();
            int size = list2.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                try {
                    Pair<MovableContentStateReference, MovableContentStateReference> pair = list2.get(i4);
                    final MovableContentStateReference component1 = pair.component1();
                    MovableContentStateReference component2 = pair.component2();
                    GapAnchor asGapAnchor = GapAnchorKt.asGapAnchor(component1.getAnchor$runtime());
                    SlotTable asGapBufferSlotTable = SlotTableKt.asGapBufferSlotTable(component1.getSlotStorage$runtime());
                    int anchorIndex = asGapBufferSlotTable.anchorIndex(asGapAnchor);
                    IntRef intRef = new IntRef(i3, 1, null);
                    this.changeListWriter.determineMovableContentNodeIndex(intRef, asGapAnchor);
                    if (component2 == null) {
                        if (Intrinsics.areEqual(asGapBufferSlotTable, this.insertTable)) {
                            createFreshInsertTable();
                        }
                        final SlotReader openReader = asGapBufferSlotTable.openReader();
                        openReader.reposition(anchorIndex);
                        this.changeListWriter.moveReaderToAbsolute(anchorIndex);
                        final ChangeList changeList5 = new ChangeList();
                        recomposeMovableContent$default(this, null, null, null, null, new Function0() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit insertMovableContentGuarded$lambda$0$0$0$0;
                                insertMovableContentGuarded$lambda$0$0$0$0 = GapComposer.insertMovableContentGuarded$lambda$0$0$0$0(GapComposer.this, changeList5, openReader, component1);
                                return insertMovableContentGuarded$lambda$0$0$0$0;
                            }
                        }, 15, null);
                        this.changeListWriter.includeOperationsIn(changeList5, intRef);
                        Unit unit = Unit.INSTANCE;
                        openReader.close();
                        composerChangeListWriter2 = composerChangeListWriter3;
                        changeList2 = changeList4;
                        i = size;
                        i2 = i4;
                    } else {
                        MovableContentState movableContentStateResolve$runtime = this.parentContext.movableContentStateResolve$runtime(component2);
                        SlotTable asGapBufferSlotTable2 = (movableContentStateResolve$runtime == null || (slotStorage$runtime = movableContentStateResolve$runtime.getSlotStorage$runtime()) == null) ? null : SlotTableKt.asGapBufferSlotTable(slotStorage$runtime);
                        SlotTable asGapBufferSlotTable3 = asGapBufferSlotTable2 == null ? SlotTableKt.asGapBufferSlotTable(component2.getSlotStorage$runtime()) : asGapBufferSlotTable2;
                        GapAnchor asGapAnchor2 = GapAnchorKt.asGapAnchor((asGapBufferSlotTable2 == null || (anchor = asGapBufferSlotTable2.anchor(0)) == null) ? component2.getAnchor$runtime() : anchor);
                        collectNodesFrom = GapComposerKt.collectNodesFrom(asGapBufferSlotTable3, asGapAnchor2);
                        if (!collectNodesFrom.isEmpty()) {
                            this.changeListWriter.copyNodesToNewAnchorLocation(collectNodesFrom, intRef);
                            if (Intrinsics.areEqual(asGapBufferSlotTable, this.slotTable)) {
                                int anchorIndex2 = this.slotTable.anchorIndex(asGapAnchor);
                                updateNodeCount(anchorIndex2, updatedNodeCount(anchorIndex2) + collectNodesFrom.size());
                            }
                        }
                        this.changeListWriter.copySlotTableToAnchorLocation(movableContentStateResolve$runtime, this.parentContext, component2, component1);
                        SlotReader openReader2 = asGapBufferSlotTable3.openReader();
                        try {
                            SlotReader slotReader2 = this.reader;
                            int[] iArr2 = this.nodeCountOverrides;
                            MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap2 = this.providerUpdates;
                            this.nodeCountOverrides = null;
                            this.providerUpdates = null;
                            try {
                                this.reader = openReader2;
                                int anchorIndex3 = asGapBufferSlotTable3.anchorIndex(GapAnchorKt.asGapAnchor(asGapAnchor2));
                                openReader2.reposition(anchorIndex3);
                                this.changeListWriter.moveReaderToAbsolute(anchorIndex3);
                                ChangeList changeList6 = new ChangeList();
                                ComposerChangeListWriter composerChangeListWriter4 = this.changeListWriter;
                                ChangeList changeList7 = composerChangeListWriter4.getChangeList();
                                try {
                                    composerChangeListWriter4.setChangeList(changeList6);
                                    slotReader = openReader2;
                                    try {
                                        ComposerChangeListWriter composerChangeListWriter5 = this.changeListWriter;
                                        i = size;
                                        boolean implicitRootStart = composerChangeListWriter5.getImplicitRootStart();
                                        try {
                                            composerChangeListWriter5.setImplicitRootStart(false);
                                            try {
                                                i2 = i4;
                                                iArr = iArr2;
                                                composerChangeListWriter2 = composerChangeListWriter3;
                                                mutableIntObjectMap = mutableIntObjectMap2;
                                                changeList2 = changeList4;
                                                changeList3 = changeList7;
                                                try {
                                                    recomposeMovableContent(component2.getComposition$runtime(), component1.getComposition$runtime(), Integer.valueOf(slotReader.getCurrentGroup()), component2.getInvalidations$runtime(), new Function0() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda2
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0;
                                                            insertMovableContentGuarded$lambda$0$0$1$0$0$0$0 = GapComposer.insertMovableContentGuarded$lambda$0$0$1$0$0$0$0(GapComposer.this, component1);
                                                            return insertMovableContentGuarded$lambda$0$0$1$0$0$0$0;
                                                        }
                                                    });
                                                    try {
                                                        composerChangeListWriter5.setImplicitRootStart(implicitRootStart);
                                                        try {
                                                            composerChangeListWriter4.setChangeList(changeList3);
                                                            this.changeListWriter.includeOperationsIn(changeList6, intRef);
                                                            Unit unit2 = Unit.INSTANCE;
                                                            try {
                                                                this.reader = slotReader2;
                                                                this.nodeCountOverrides = iArr;
                                                                this.providerUpdates = mutableIntObjectMap;
                                                                Unit unit3 = Unit.INSTANCE;
                                                                try {
                                                                    slotReader.close();
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    composerChangeListWriter = composerChangeListWriter2;
                                                                    changeList = changeList2;
                                                                    composerChangeListWriter.setChangeList(changeList);
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                slotReader.close();
                                                                throw th;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            this.reader = slotReader2;
                                                            this.nodeCountOverrides = iArr;
                                                            this.providerUpdates = mutableIntObjectMap;
                                                            throw th;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        composerChangeListWriter4.setChangeList(changeList3);
                                                        throw th;
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    composerChangeListWriter5.setImplicitRootStart(implicitRootStart);
                                                    throw th;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                iArr = iArr2;
                                                changeList3 = changeList7;
                                                mutableIntObjectMap = mutableIntObjectMap2;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            iArr = iArr2;
                                            mutableIntObjectMap = mutableIntObjectMap2;
                                            changeList3 = changeList7;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        iArr = iArr2;
                                        mutableIntObjectMap = mutableIntObjectMap2;
                                        changeList3 = changeList7;
                                        composerChangeListWriter4.setChangeList(changeList3);
                                        throw th;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    iArr = iArr2;
                                    slotReader = openReader2;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                iArr = iArr2;
                                slotReader = openReader2;
                                mutableIntObjectMap = mutableIntObjectMap2;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            slotReader = openReader2;
                        }
                    }
                    this.changeListWriter.skipToEndOfCurrentGroup();
                    i4 = i2 + 1;
                    list2 = list;
                    size = i;
                    composerChangeListWriter3 = composerChangeListWriter2;
                    changeList4 = changeList2;
                    i3 = 0;
                } catch (Throwable th12) {
                    th = th12;
                    composerChangeListWriter2 = composerChangeListWriter3;
                    changeList2 = changeList4;
                }
            }
            ComposerChangeListWriter composerChangeListWriter6 = composerChangeListWriter3;
            ChangeList changeList8 = changeList4;
            this.changeListWriter.endMovableContentPlacement();
            this.changeListWriter.moveReaderToAbsolute(0);
            composerChangeListWriter6.setChangeList(changeList8);
        } catch (Throwable th13) {
            th = th13;
            composerChangeListWriter = composerChangeListWriter3;
            changeList = changeList4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertMovableContentGuarded$lambda$0$0$0$0(GapComposer gapComposer, ChangeList changeList, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        ComposerChangeListWriter composerChangeListWriter = gapComposer.changeListWriter;
        ChangeList changeList2 = composerChangeListWriter.getChangeList();
        try {
            composerChangeListWriter.setChangeList(changeList);
            SlotReader slotReader2 = gapComposer.reader;
            int[] iArr = gapComposer.nodeCountOverrides;
            MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = gapComposer.providerUpdates;
            gapComposer.nodeCountOverrides = null;
            gapComposer.providerUpdates = null;
            gapComposer.reader = slotReader;
            ComposerChangeListWriter composerChangeListWriter2 = gapComposer.changeListWriter;
            boolean implicitRootStart = composerChangeListWriter2.getImplicitRootStart();
            composerChangeListWriter2.setImplicitRootStart(false);
            gapComposer.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals$runtime(), movableContentStateReference.getParameter$runtime(), true);
            composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
            Unit unit = Unit.INSTANCE;
            gapComposer.reader = slotReader2;
            gapComposer.nodeCountOverrides = iArr;
            gapComposer.providerUpdates = mutableIntObjectMap;
            composerChangeListWriter.setChangeList(changeList2);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            composerChangeListWriter.setChangeList(changeList2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0(GapComposer gapComposer, MovableContentStateReference movableContentStateReference) {
        gapComposer.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals$runtime(), movableContentStateReference.getParameter$runtime(), true);
        return Unit.INSTANCE;
    }

    private final <R> R withReader(SlotReader slotReader, Function0<? extends R> function0) {
        SlotReader slotReader2 = this.reader;
        int[] iArr = this.nodeCountOverrides;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            this.reader = slotReader;
            return function0.invoke();
        } finally {
            this.reader = slotReader2;
            this.nodeCountOverrides = iArr;
            this.providerUpdates = mutableIntObjectMap;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object recomposeMovableContent$default(GapComposer gapComposer, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            controlledComposition = null;
        }
        if ((i & 2) != 0) {
            controlledComposition2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return gapComposer.recomposeMovableContent(controlledComposition, controlledComposition2, num, list, function0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r7 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <R> R recomposeMovableContent(ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List<? extends Pair<RecomposeScopeImpl, ? extends Object>> list, Function0<? extends R> function0) {
        R invoke;
        boolean isComposing$runtime = isComposing$runtime();
        int i = this.nodeIndex;
        try {
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Pair<RecomposeScopeImpl, ? extends Object> pair = list.get(i2);
                RecomposeScopeImpl component1 = pair.component1();
                Object component2 = pair.component2();
                if (component2 != null) {
                    tryImminentInvalidation$runtime(component1, component2);
                } else {
                    tryImminentInvalidation$runtime(component1, null);
                }
            }
            if (controlledComposition != null) {
                invoke = (R) controlledComposition.delegateInvalidations(controlledComposition2, num != null ? num.intValue() : -1, function0);
            }
            invoke = function0.invoke();
            return invoke;
        } finally {
            this.isComposing = isComposing$runtime;
            this.nodeIndex = i;
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformation(String str) {
        if (getInserting() && getSourceMarkersEnabled$runtime()) {
            this.writer.recordGroupSourceInformation(str);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int i, String str) {
        if (getInserting() && getSourceMarkersEnabled$runtime()) {
            this.writer.recordGrouplessCallSourceInformationStart(i, str);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (getInserting() && getSourceMarkersEnabled$runtime()) {
            this.writer.recordGrouplessCallSourceInformationEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        setSourceMarkersEnabled$runtime(false);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public ComposeStackTrace stackTraceForValue$runtime(final Object obj) {
        List emptyList;
        ObjectLocation findLocation = ComposeStackTraceBuilderKt.findLocation(this.slotTable, new Function1() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(GapComposer.stackTraceForValue$lambda$0(obj, obj2));
            }
        });
        if (findLocation == null || (emptyList = CollectionsKt.plus((Collection) stackTraceForGroup(findLocation.component1(), findLocation.component2()), (Iterable) parentStackTrace$runtime())) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return new ComposeStackTrace(emptyList, getSourceMarkersEnabled$runtime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean stackTraceForValue$lambda$0(Object obj, Object obj2) {
        if (obj2 != obj) {
            RememberObserverHolder rememberObserverHolder = obj2 instanceof RememberObserverHolder ? (RememberObserverHolder) obj2 : null;
            return (rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null) == obj;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeStackTrace currentStackTrace() {
        if (this.parentContext.getStackTraceEnabled$runtime()) {
            List createListBuilder = CollectionsKt.createListBuilder();
            createListBuilder.addAll(ComposeStackTraceBuilderKt.buildTrace$default(this.writer, null, 0, null, 7, null));
            createListBuilder.addAll(ComposeStackTraceBuilderKt.buildTrace(this.reader));
            createListBuilder.addAll(parentStackTrace$runtime());
            return new ComposeStackTrace(CollectionsKt.build(createListBuilder), getSourceMarkersEnabled$runtime());
        }
        return null;
    }

    private final List<ComposeStackTraceFrame> stackTraceForGroup(int i, Integer num) {
        SlotReader openReader = this.slotTable.openReader();
        try {
            return ComposeStackTraceBuilderKt.traceForGroup(openReader, i, num);
        } finally {
            openReader.close();
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public List<ComposeStackTraceFrame> parentStackTrace$runtime() {
        Composition composition$runtime = this.parentContext.getComposition$runtime();
        CompositionImpl compositionImpl = composition$runtime instanceof CompositionImpl ? (CompositionImpl) composition$runtime : null;
        if (compositionImpl == null) {
            return CollectionsKt.emptyList();
        }
        Integer findSubcompositionContextGroup = ComposeStackTraceBuilderKt.findSubcompositionContextGroup(SlotTableKt.asGapBufferSlotTable(compositionImpl.getSlotStorage$runtime()), this.parentContext);
        if (findSubcompositionContextGroup == null) {
            return CollectionsKt.emptyList();
        }
        SlotReader openReader = SlotTableKt.asGapBufferSlotTable(compositionImpl.getSlotStorage$runtime()).openReader();
        try {
            List<ComposeStackTraceFrame> traceForGroup = ComposeStackTraceBuilderKt.traceForGroup(openReader, findSubcompositionContextGroup.intValue(), 0);
            openReader.close();
            return CollectionsKt.plus((Collection) traceForGroup, (Iterable) compositionImpl.getComposer$runtime().parentStackTrace$runtime());
        } catch (Throwable th) {
            openReader.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* renamed from: composeContent--ZbOJvo$runtime  reason: not valid java name */
    public void mo4428composeContentZbOJvo$runtime(MutableScatterMap<Object, Object> mutableScatterMap, Function2<? super Composer, ? super Integer, Unit> function2, ShouldPauseCallback shouldPauseCallback) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        this.shouldPauseCallback = shouldPauseCallback;
        try {
            m4426doComposeaFTiNEg(mutableScatterMap, function2);
        } finally {
            this.shouldPauseCallback = null;
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void prepareCompose$runtime(Function0<Unit> function0) {
        if (isComposing$runtime()) {
            ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
        }
        this.isComposing = true;
        try {
            function0.invoke();
        } finally {
            this.isComposing = false;
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* renamed from: recompose-aFTiNEg$runtime  reason: not valid java name */
    public boolean mo4429recomposeaFTiNEg$runtime(MutableScatterMap<Object, Object> mutableScatterMap, ShouldPauseCallback shouldPauseCallback) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (ScopeMap.m4515getSizeimpl(mutableScatterMap) > 0 || !this.invalidations.isEmpty() || this.forciblyRecompose) {
            this.shouldPauseCallback = shouldPauseCallback;
            try {
                m4426doComposeaFTiNEg(mutableScatterMap, null);
                this.shouldPauseCallback = null;
                return this.changes.isNotEmpty();
            } catch (Throwable th) {
                this.shouldPauseCallback = null;
                throw th;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* renamed from: updateComposerInvalidations-RY85e9Y$runtime  reason: not valid java name */
    public void mo4430updateComposerInvalidationsRY85e9Y$runtime(MutableScatterMap<Object, Object> mutableScatterMap) {
        Comparator comparator;
        GapAnchor asGapAnchor;
        for (int lastIndex = CollectionsKt.getLastIndex(this.invalidations); -1 < lastIndex; lastIndex--) {
            Invalidation invalidation = this.invalidations.get(lastIndex);
            Anchor anchor = invalidation.getScope().getAnchor();
            GapAnchor asGapAnchor2 = anchor != null ? GapAnchorKt.asGapAnchor(anchor) : null;
            if (asGapAnchor2 != null && asGapAnchor2.getValid()) {
                if (invalidation.getLocation() != asGapAnchor2.getLocation$runtime()) {
                    invalidation.setLocation(asGapAnchor2.getLocation$runtime());
                }
            } else {
                this.invalidations.remove(lastIndex);
            }
        }
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
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
                            Object obj = objArr[i4];
                            Object obj2 = objArr2[i4];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                            Anchor anchor2 = recomposeScopeImpl.getAnchor();
                            if (anchor2 != null && (asGapAnchor = GapAnchorKt.asGapAnchor(anchor2)) != null) {
                                int location$runtime = asGapAnchor.getLocation$runtime();
                                List<Invalidation> list = this.invalidations;
                                if (obj2 == ScopeInvalidated.INSTANCE) {
                                    obj2 = null;
                                }
                                list.add(new Invalidation(recomposeScopeImpl, location$runtime, obj2));
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
        List<Invalidation> list2 = this.invalidations;
        comparator = GapComposerKt.InvalidationLocationAscending;
        CollectionsKt.sortWith(list2, comparator);
    }

    /* renamed from: doCompose-aFTiNEg  reason: not valid java name */
    private final void m4426doComposeaFTiNEg(MutableScatterMap<Object, Object> mutableScatterMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (isComposing$runtime()) {
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }
        CompositionObserver current = this.observerHolder.current();
        Object beginSection = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            this.compositionToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            this.providerUpdates = null;
            mo4430updateComposerInvalidationsRY85e9Y$runtime(mutableScatterMap);
            this.nodeIndex = 0;
            this.isComposing = true;
            if (current != null) {
                current.onBeginComposition(getComposition());
            }
            startRoot();
            Object nextSlot = nextSlot();
            if (nextSlot != function2 && function2 != null) {
                updateValue(function2);
            }
            GapComposer$derivedStateObserver$1 gapComposer$derivedStateObserver$1 = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            derivedStateObservers.add(gapComposer$derivedStateObserver$1);
            if (function2 != null) {
                startGroup(200, ComposerKt.getInvocation());
                Expect_jvmKt.invokeComposable(this, function2);
                endGroup();
            } else if ((this.forciblyRecompose || this.providersInvalid) && nextSlot != null && !Intrinsics.areEqual(nextSlot, Composer.Companion.getEmpty())) {
                startGroup(200, ComposerKt.getInvocation());
                Expect_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(nextSlot, 2));
                endGroup();
            } else {
                skipCurrentGroup();
            }
            derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
            endRoot();
            if (current != null) {
                current.onEndComposition(getComposition());
            }
            this.isComposing = false;
            this.invalidations.clear();
            createFreshInsertTable();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
    }

    private final void validateNodeExpected() {
        if (!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
    }

    private final void validateNodeNotExpected() {
        if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    private final void recordInsert(GapAnchor gapAnchor) {
        boolean isEmpty = this.insertFixups.isEmpty();
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        if (isEmpty) {
            composerChangeListWriter.insertSlots(gapAnchor, this.insertTable);
            return;
        }
        composerChangeListWriter.insertSlots(gapAnchor, this.insertTable, this.insertFixups);
        this.insertFixups = new FixupList();
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        this.changeListWriter.removeCurrentGroup();
    }

    private static final MovableContentStateReference reportFreeMovableContent$createMovableContentReferenceForGroup(GapComposer gapComposer, int i, List<MovableContentStateReference> list) {
        Object groupObjectKey = gapComposer.reader.groupObjectKey(i);
        Intrinsics.checkNotNull(groupObjectKey, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        MovableContent movableContent = (MovableContent) groupObjectKey;
        Object groupGet = gapComposer.reader.groupGet(i, 0);
        GapAnchor anchor = gapComposer.reader.anchor(i);
        int groupSize = gapComposer.reader.groupSize(i) + i;
        ArrayList arrayList = new ArrayList();
        List<Invalidation> list2 = gapComposer.invalidations;
        for (int findInsertLocation = GapComposerKt.findInsertLocation(list2, i); findInsertLocation < list2.size(); findInsertLocation++) {
            Invalidation invalidation = list2.get(findInsertLocation);
            if (invalidation.getLocation() >= groupSize) {
                break;
            }
            arrayList.add(TuplesKt.to(invalidation.getScope(), invalidation.getInstances()));
        }
        return new MovableContentStateReference(movableContent, groupGet, gapComposer.getComposition(), gapComposer.slotTable, anchor, arrayList, gapComposer.currentCompositionLocalScope(i), list);
    }

    private static final MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor(GapComposer gapComposer, int i) {
        int groupKey = gapComposer.reader.groupKey(i);
        Object groupObjectKey = gapComposer.reader.groupObjectKey(i);
        ArrayList arrayList = null;
        if (groupKey == 126665345 && (groupObjectKey instanceof MovableContent)) {
            if (gapComposer.reader.containsMark(i)) {
                ArrayList arrayList2 = new ArrayList();
                reportFreeMovableContent$movableContentReferenceFor$traverseGroups(gapComposer, arrayList2, i);
                if (!arrayList2.isEmpty()) {
                    arrayList = arrayList2;
                }
            }
            return reportFreeMovableContent$createMovableContentReferenceForGroup(gapComposer, i, arrayList);
        }
        return null;
    }

    private static final void reportFreeMovableContent$movableContentReferenceFor$traverseGroups(GapComposer gapComposer, List<MovableContentStateReference> list, int i) {
        int groupSize = gapComposer.reader.groupSize(i) + i;
        int i2 = i + 1;
        while (i2 < groupSize) {
            if (gapComposer.reader.hasMark(i2)) {
                MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor = reportFreeMovableContent$movableContentReferenceFor(gapComposer, i2);
                if (reportFreeMovableContent$movableContentReferenceFor != null) {
                    list.add(reportFreeMovableContent$movableContentReferenceFor);
                }
            } else if (gapComposer.reader.containsMark(i2)) {
                reportFreeMovableContent$movableContentReferenceFor$traverseGroups(gapComposer, list, i2);
            }
            i2 += gapComposer.reader.groupSize(i2);
        }
    }

    private static final int reportFreeMovableContent$reportGroup(GapComposer gapComposer, int i, int i2, boolean z, int i3) {
        SlotReader slotReader = gapComposer.reader;
        if (slotReader.hasMark(i2)) {
            int groupKey = slotReader.groupKey(i2);
            Object groupObjectKey = slotReader.groupObjectKey(i2);
            if (groupKey == 126665345 && (groupObjectKey instanceof MovableContent)) {
                MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor = reportFreeMovableContent$movableContentReferenceFor(gapComposer, i2);
                if (reportFreeMovableContent$movableContentReferenceFor != null) {
                    gapComposer.parentContext.deletedMovableContent$runtime(reportFreeMovableContent$movableContentReferenceFor);
                    gapComposer.changeListWriter.recordSlotEditing();
                    gapComposer.changeListWriter.releaseMovableGroupAtCurrent(gapComposer.getComposition(), gapComposer.parentContext, reportFreeMovableContent$movableContentReferenceFor);
                }
                if (z && i2 != i) {
                    gapComposer.changeListWriter.endNodeMovementAndDeleteNode(i3, i2);
                    return 0;
                }
                return slotReader.nodeCount(i2);
            } else if (groupKey == 206 && Intrinsics.areEqual(groupObjectKey, ComposerKt.getReference())) {
                Object groupGet = slotReader.groupGet(i2, 0);
                RememberObserverHolder rememberObserverHolder = groupGet instanceof RememberObserverHolder ? (RememberObserverHolder) groupGet : null;
                RememberObserver wrapped = rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null;
                CompositionContextHolder compositionContextHolder = wrapped instanceof CompositionContextHolder ? wrapped : null;
                if (compositionContextHolder != null) {
                    MutableScatterSet<GapComposer> composers = compositionContextHolder.getRef().getComposers();
                    Object[] objArr = composers.elements;
                    long[] jArr = composers.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i4 = 0;
                        while (true) {
                            long j = jArr[i4];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i5 = 8 - ((~(i4 - length)) >>> 31);
                                for (int i6 = 0; i6 < i5; i6++) {
                                    if ((255 & j) < 128) {
                                        GapComposer gapComposer2 = (GapComposer) objArr[(i4 << 3) + i6];
                                        gapComposer2.reportAllMovableContent();
                                        gapComposer.parentContext.reportRemovedComposition$runtime(gapComposer2.getComposition());
                                    }
                                    j >>= 8;
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
                }
                return slotReader.nodeCount(i2);
            } else if (slotReader.isNode(i2)) {
                return 1;
            } else {
                return slotReader.nodeCount(i2);
            }
        } else if (slotReader.containsMark(i2)) {
            int groupSize = slotReader.groupSize(i2) + i2;
            int i7 = 0;
            for (int i8 = i2 + 1; i8 < groupSize; i8 += slotReader.groupSize(i8)) {
                boolean isNode = slotReader.isNode(i8);
                if (isNode) {
                    gapComposer.changeListWriter.endNodeMovement();
                    gapComposer.changeListWriter.moveDown(slotReader.node(i8));
                }
                i7 += reportFreeMovableContent$reportGroup(gapComposer, i, i8, isNode || z, isNode ? 0 : i3 + i7);
                if (isNode) {
                    gapComposer.changeListWriter.endNodeMovement();
                    gapComposer.changeListWriter.moveUp();
                }
            }
            if (slotReader.isNode(i2)) {
                return 1;
            }
            return i7;
        } else if (slotReader.isNode(i2)) {
            return 1;
        } else {
            return slotReader.nodeCount(i2);
        }
    }

    private final void reportFreeMovableContent(int i) {
        boolean isNode = this.reader.isNode(i);
        if (isNode) {
            this.changeListWriter.endNodeMovement();
            this.changeListWriter.moveDown(this.reader.node(i));
        }
        reportFreeMovableContent$reportGroup(this, i, i, isNode, 0);
        this.changeListWriter.endNodeMovement();
        if (isNode) {
            this.changeListWriter.moveUp();
        }
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsMark()) {
            getComposition().updateMovingInvalidations$runtime();
            ChangeList changeList = new ChangeList();
            setDeferredChanges$runtime(changeList);
            SlotReader openReader = this.slotTable.openReader();
            try {
                this.reader = openReader;
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.getChangeList();
                composerChangeListWriter.setChangeList(changeList);
                reportFreeMovableContent(0);
                this.changeListWriter.releaseMovableContent();
                composerChangeListWriter.setChangeList(changeList2);
                Unit unit = Unit.INSTANCE;
            } finally {
                openReader.close();
            }
        }
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (!Stack.m4457isEmptyimpl(this.pendingStack)) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compositeKeyHashCode = 0L;
        this.nodeExpected = false;
        this.changeListWriter.resetTransientState();
        Stack.m4450clearimpl(this.invalidateStack);
        clearUpdatedNodeCounts();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void verifyConsistent$runtime() {
        this.insertTable.verifyWellFormed();
    }

    /* compiled from: GapComposer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/GapComposer$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "Landroidx/compose/runtime/GapComposer;", "<init>", "(Landroidx/compose/runtime/GapComposer$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "onRemembered", "", "onAbandoned", "onForgotten", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class CompositionContextHolder implements RememberObserver {
        public static final int $stable = 8;
        private final CompositionContextImpl ref;

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }
    }

    /* compiled from: GapComposer.kt */
    @Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010$\u001a\u00020%J\u0015\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0010¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0010¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0010¢\u0006\u0002\b5J*\u0010:\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020%0<¢\u0006\u0002\b=H\u0011¢\u0006\u0004\b>\u0010?J8\u0010@\u001a\b\u0012\u0004\u0012\u0002040A2\u0006\u0010-\u001a\u00020.2\u0006\u0010B\u001a\u00020C2\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020%0<¢\u0006\u0002\b=H\u0011¢\u0006\u0004\bD\u0010EJ1\u0010F\u001a\b\u0012\u0004\u0012\u0002040A2\u0006\u0010-\u001a\u00020.2\u0006\u0010B\u001a\u00020C2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002040AH\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\bJJ\u0015\u0010K\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0010¢\u0006\u0002\bLJ\r\u0010P\u001a\u00020NH\u0010¢\u0006\u0002\bVJ\u000e\u0010W\u001a\u00020%2\u0006\u00103\u001a\u00020NJ\u001b\u0010X\u001a\u00020%2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0010¢\u0006\u0002\bZJ\r\u0010[\u001a\u00020%H\u0010¢\u0006\u0002\b\\J\r\u0010]\u001a\u00020%H\u0010¢\u0006\u0002\b^J\u0015\u0010_\u001a\u00020%2\u0006\u0010`\u001a\u00020aH\u0010¢\u0006\u0002\bbJ\u0015\u0010c\u001a\u00020%2\u0006\u0010`\u001a\u00020aH\u0010¢\u0006\u0002\bdJ\u0017\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010`\u001a\u00020aH\u0010¢\u0006\u0002\bgJ)\u0010h\u001a\u00020%2\u0006\u0010`\u001a\u00020a2\u0006\u0010i\u001a\u00020f2\n\u0010j\u001a\u0006\u0012\u0002\b\u00030kH\u0010¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\bnJ\u0016\u0010r\u001a\u00020s2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020%0<H\u0016R\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0090\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0010R\u0014\u00106\u001a\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R+\u0010O\u001a\u00020N2\u0006\u0010M\u001a\u00020N8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0014\u0010-\u001a\u00020o8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bp\u0010q¨\u0006u"}, d2 = {"Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHashCode", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "<init>", "(Landroidx/compose/runtime/GapComposer;JZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "getCompositeKeyHashCode$runtime", "()J", "J", "getCollectingParameterInformation$runtime", "()Z", "getCollectingSourceInformation$runtime", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "inspectionTables", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "()Ljava/util/Set;", "setInspectionTables", "(Ljava/util/Set;)V", "composers", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/GapComposer;", "getComposers", "()Landroidx/collection/MutableScatterSet;", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "dispose", "", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime", "unregisterComposer", "unregisterComposer$runtime", "registerComposition", "composition", "Landroidx/compose/runtime/ControlledComposition;", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "reportPausedScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "reportPausedScope$runtime", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composeInitial", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompositionLocalScope$runtime", "updateCompositionLocalScope", "recordInspectionTable", "table", "recordInspectionTable$runtime", "startComposing", "startComposing$runtime", "doneComposing", "doneComposing$runtime", "insertMovableContent", TypedValues.Custom.S_REFERENCE, "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateResolve", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final long compositeKeyHashCode;
        private Set<Set<CompositionData>> inspectionTables;
        private final CompositionObserverHolder observerHolder;
        private final MutableScatterSet<GapComposer> composers = ScatterSetKt.mutableScatterSetOf();
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());

        public CompositionContextImpl(long j, boolean z, boolean z2, CompositionObserverHolder compositionObserverHolder) {
            this.compositeKeyHashCode = j;
            this.collectingParameterInformation = z;
            this.collectingSourceInformation = z2;
            this.observerHolder = compositionObserverHolder;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public long getCompositeKeyHashCode$runtime() {
            return this.compositeKeyHashCode;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingParameterInformation$runtime() {
            return this.collectingParameterInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingSourceInformation$runtime() {
            return this.collectingSourceInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CompositionObserverHolder getObserverHolder$runtime() {
            return this.observerHolder;
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public final MutableScatterSet<GapComposer> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingCallByInformation$runtime() {
            return GapComposer.this.parentContext.getCollectingCallByInformation$runtime();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getStackTraceEnabled$runtime() {
            return GapComposer.this.parentContext.getStackTraceEnabled$runtime();
        }

        public final void dispose() {
            if (this.composers.isNotEmpty()) {
                Set<Set<CompositionData>> set = this.inspectionTables;
                if (set != null) {
                    MutableScatterSet<GapComposer> mutableScatterSet = this.composers;
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
                                        GapComposer gapComposer = (GapComposer) objArr[(i << 3) + i3];
                                        for (Set<CompositionData> set2 : set) {
                                            set2.remove(gapComposer.getCompositionData());
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
                }
                this.composers.clear();
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime(Composer composer) {
            Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer");
            super.registerComposer$runtime((GapComposer) composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime(Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer");
                    ((Set) it.next()).remove(((GapComposer) composer).getCompositionData());
                }
            }
            if (composer instanceof GapComposer) {
                this.composers.remove(composer);
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime(ControlledComposition controlledComposition) {
            GapComposer.this.parentContext.registerComposition$runtime(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime(ControlledComposition controlledComposition) {
            GapComposer.this.parentContext.unregisterComposition$runtime(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportPausedScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
            GapComposer.this.parentContext.reportPausedScope$runtime(recomposeScopeImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getEffectCoroutineContext() {
            return GapComposer.this.parentContext.getEffectCoroutineContext();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void composeInitial$runtime(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
            GapComposer.this.parentContext.composeInitial$runtime(controlledComposition, function2);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition controlledComposition, ShouldPauseCallback shouldPauseCallback, Function2<? super Composer, ? super Integer, Unit> function2) {
            return GapComposer.this.parentContext.composeInitialPaused$runtime(controlledComposition, shouldPauseCallback, function2);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition controlledComposition, ShouldPauseCallback shouldPauseCallback, ScatterSet<RecomposeScopeImpl> scatterSet) {
            return GapComposer.this.parentContext.recomposePaused$runtime(controlledComposition, shouldPauseCallback, scatterSet);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime(ControlledComposition controlledComposition) {
            GapComposer.this.parentContext.invalidate$runtime(GapComposer.this.getComposition());
            GapComposer.this.parentContext.invalidate$runtime(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
            GapComposer.this.parentContext.invalidateScope$runtime(recomposeScopeImpl);
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope$delegate.getValue();
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.compositionLocalScope$delegate.setValue(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public PersistentCompositionLocalMap getCompositionLocalScope$runtime() {
            return getCompositionLocalScope();
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            setCompositionLocalScope(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime(Set<CompositionData> set) {
            HashSet hashSet = this.inspectionTables;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.inspectionTables = hashSet;
            }
            hashSet.add(set);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime() {
            GapComposer.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime() {
            GapComposer.this.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime(MovableContentStateReference movableContentStateReference) {
            GapComposer.this.parentContext.insertMovableContent$runtime(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime(MovableContentStateReference movableContentStateReference) {
            GapComposer.this.parentContext.deletedMovableContent$runtime(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference movableContentStateReference) {
            return GapComposer.this.parentContext.movableContentStateResolve$runtime(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState, Applier<?> applier) {
            GapComposer.this.parentContext.movableContentStateReleased$runtime(movableContentStateReference, movableContentState, applier);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime(ControlledComposition controlledComposition) {
            GapComposer.this.parentContext.reportRemovedComposition$runtime(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public Composition getComposition$runtime() {
            return GapComposer.this.getComposition();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CancellationHandle scheduleFrameEndCallback(Function0<Unit> function0) {
            return GapComposer.this.parentContext.scheduleFrameEndCallback(function0);
        }
    }

    private final void updateCompositeKeyWhenWeEnterGroup(int i, int i2, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 != null && i == 207 && !Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = i2 ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ obj2.hashCode(), 3);
                return;
            }
            this.compositeKeyHashCode = i2 ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ i, 3);
        } else if (!(obj instanceof Enum)) {
            this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ obj.hashCode(), 3);
        } else {
            this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((Enum) obj).ordinal(), 3);
        }
    }

    private final void updateCompositeKeyWhenWeEnterGroupKeyHash(int i, int i2) {
        this.compositeKeyHashCode = i2 ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ i, 3);
    }

    private final void updateCompositeKeyWhenWeExitGroup(int i, int i2, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 != null && i == 207 && !Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ i2, 3) ^ obj2.hashCode(), 3);
                return;
            }
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ i2, 3) ^ i, 3);
        } else if (!(obj instanceof Enum)) {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode(), 3) ^ obj.hashCode(), 3);
        } else {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode(), 3) ^ ((Enum) obj).ordinal(), 3);
        }
    }

    private final void updateCompositeKeyWhenWeExitGroupKeyHash(int i, int i2) {
        this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ i2, 3) ^ i, 3);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public int stacksSize$runtime() {
        return this.entersStack.tos + Stack.m4455getSizeimpl(this.invalidateStack) + this.providersInvalidStack.tos + Stack.m4455getSizeimpl(this.pendingStack) + this.parentStateStack.tos;
    }

    @Override // androidx.compose.runtime.Composer
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime();
    }

    @Override // androidx.compose.runtime.Composer
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime != null) {
            return currentRecomposeScope$runtime.getAnchor();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return nextSlotForCache();
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object obj) {
        updateCachedValue(obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(RecomposeScope recomposeScope) {
        RecomposeScopeImpl recomposeScopeImpl = recomposeScope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) recomposeScope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object] */
    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder = persistentCompositionLocalMap.builder();
        builder.putAll(persistentCompositionLocalMap2);
        ?? build = builder.build();
        startGroup(ComposerKt.providerMapsKey, ComposerKt.getProviderMaps());
        updateSlot(build);
        updateSlot(persistentCompositionLocalMap2);
        endGroup();
        return build;
    }

    private final long compositeKeyOf(int i, int i2, long j) {
        long rotateLeft;
        int i3 = 3;
        long j2 = 0;
        int i4 = 0;
        while (i >= 0) {
            if (i != i2) {
                int groupCompositeKeyPart = groupCompositeKeyPart(this.reader, i);
                if (groupCompositeKeyPart == 126665345) {
                    rotateLeft = Long.rotateLeft(groupCompositeKeyPart, i4);
                } else {
                    j2 = (j2 ^ Long.rotateLeft(groupCompositeKeyPart, i3)) ^ Long.rotateLeft(this.reader.hasObjectKey(i) ? 0 : rGroupIndexOf(i), i4);
                    i3 = (i3 + 6) % 64;
                    i4 = (i4 + 6) % 64;
                    i = this.reader.parent(i);
                }
            } else {
                rotateLeft = Long.rotateLeft(j, i4);
            }
            return rotateLeft ^ j2;
        }
        return j2;
    }
}
