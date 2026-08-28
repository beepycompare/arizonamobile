package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.GroupKind;
import androidx.compose.runtime.composer.ThrowingRememberManagerStub;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.KeyInfo;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableBuilder;
import androidx.compose.runtime.composer.linkbuffer.SlotTableBuilderKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReader;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReaderKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeListKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.linkbuffer.changelist.ComposerChangeListWriterAddressMode;
import androidx.compose.runtime.composer.linkbuffer.changelist.FixupList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: LinkComposer.kt */
@ComposeCompilerApi
@Metadata(d1 = {"\u0000³\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\r\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001V\b\u0001\u0018\u00002\u00020\u0001:\u0004ó\u0002ô\u0002BQ\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010m\u001a\u00020nH\u0016J\b\u0010o\u001a\u00020nH\u0016J\b\u0010p\u001a\u00020nH\u0016J\r\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b|J\u001e\u0010\u007f\u001a\u00020n2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0010¢\u0006\u0003\b\u0082\u0001J\u0013\u0010\u008a\u0001\u001a\u00020n2\b\u0010\u008b\u0001\u001a\u00030\u0084\u0001H\u0016JJ\u0010\u008e\u0001\u001a\u00020n\"\u0005\b\u0000\u0010\u008f\u0001\"\u0005\b\u0001\u0010\u0090\u00012\u0007\u0010Y\u001a\u0003H\u008f\u00012\"\u0010\u0080\u0001\u001a\u001d\u0012\u0005\u0012\u0003H\u0090\u0001\u0012\u0005\u0012\u0003H\u008f\u0001\u0012\u0004\u0012\u00020n0\u0091\u0001¢\u0006\u0003\b\u0092\u0001H\u0016¢\u0006\u0003\u0010\u0093\u0001J\t\u0010\u0099\u0001\u001a\u00020\u0005H\u0017J\u0013\u0010\u009a\u0001\u001a\u00020,2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0016J\u0013\u0010\u009b\u0001\u001a\u00020,2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030\u009c\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030\u009d\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030\u009e\u0001H\u0016J\u0011\u0010\u009a\u0001\u001a\u00020,2\u0006\u0010Y\u001a\u00020,H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030\u009f\u0001H\u0016J\u0011\u0010\u009a\u0001\u001a\u00020,2\u0006\u0010Y\u001a\u00020cH\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030 \u0001H\u0016J\u0011\u0010\u009a\u0001\u001a\u00020,2\u0006\u0010Y\u001a\u00020#H\u0016J\t\u0010¡\u0001\u001a\u00020nH\u0016JH\u0010¢\u0001\u001a\u00020n2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0014\u0010¤\u0001\u001a\u000f\u0012\u0004\u0012\u00020n0\u0081\u0001¢\u0006\u0003\b¥\u00012\t\u0010¦\u0001\u001a\u0004\u0018\u00010wH\u0011¢\u0006\u0006\b§\u0001\u0010¨\u0001J(\u0010¬\u0001\u001a\u0003H\u0090\u0001\"\u0005\b\u0000\u0010\u0090\u00012\u000f\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0090\u00010®\u0001H\u0017¢\u0006\u0003\u0010¯\u0001J!\u0010°\u0001\u001a\u00020n\"\u0005\b\u0000\u0010\u0090\u00012\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0090\u00010\u0081\u0001H\u0016J\u000f\u0010º\u0001\u001a\u00020nH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010¼\u0001\u001a\u00020n2\u0007\u0010\u009a\u0001\u001a\u00020,H\u0016J\u000f\u0010½\u0001\u001a\u00020nH\u0010¢\u0006\u0003\b¾\u0001J\t\u0010¿\u0001\u001a\u00020nH\u0016J\t\u0010À\u0001\u001a\u00020nH\u0016J\t\u0010Á\u0001\u001a\u00020nH\u0017J\t\u0010Â\u0001\u001a\u00020nH\u0017J\t\u0010Ã\u0001\u001a\u00020nH\u0016J\f\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0016J\t\u0010Æ\u0001\u001a\u00020nH\u0017J\t\u0010Ç\u0001\u001a\u00020nH\u0016J\u000f\u0010È\u0001\u001a\u00020nH\u0010¢\u0006\u0003\bÉ\u0001J\t\u0010Ê\u0001\u001a\u00020nH\u0016J\u0017\u0010Ë\u0001\u001a\u00020n2\f\u0010Ì\u0001\u001a\u00070#j\u0003`·\u0001H\u0016J!\u0010Ï\u0001\u001a\u00020n2\u000b\u0010Y\u001a\u0007\u0012\u0002\b\u00030Ð\u00012\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u001bH\u0017J*\u0010Ò\u0001\u001a\u00020n2\u001f\u0010Ó\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Õ\u00010Ô\u0001H\u0017J\u001f\u0010×\u0001\u001a\u00020\u001b2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010Ù\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\u000f\u0010Ú\u0001\u001a\u00020#H\u0011¢\u0006\u0003\bÛ\u0001J\u0017\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030Ý\u00010Ô\u0001H\u0010¢\u0006\u0003\bÞ\u0001J2\u0010ß\u0001\u001a\u00020,2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\t\u0010¦\u0001\u001a\u0004\u0018\u00010wH\u0011¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0019\u0010â\u0001\u001a\u00020n2\u000e\u0010ã\u0001\u001a\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0017J\u000b\u0010ä\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\u001b\u0010å\u0001\u001a\u00020,2\u0007\u0010æ\u0001\u001a\u00020,2\u0007\u0010ç\u0001\u001a\u00020#H\u0017J\t\u0010è\u0001\u001a\u00020nH\u0017J\t\u0010é\u0001\u001a\u00020nH\u0017J\u001a\u0010ê\u0001\u001a\u00030ë\u00012\u000e\u0010ì\u0001\u001a\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0016J\u0013\u0010í\u0001\u001a\u00020n2\b\u0010í\u0001\u001a\u00030î\u0001H\u0016J\t\u0010ï\u0001\u001a\u00020nH\u0016J\u001c\u0010ð\u0001\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\b\u0010í\u0001\u001a\u00030î\u0001H\u0016J\u000f\u0010ñ\u0001\u001a\u00020#H\u0010¢\u0006\u0003\bò\u0001J\u001a\u0010ó\u0001\u001a\u00030ô\u00012\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0010¢\u0006\u0003\bõ\u0001J\t\u0010ö\u0001\u001a\u00020nH\u0016J\t\u0010÷\u0001\u001a\u00020nH\u0016J\u0016\u0010ø\u0001\u001a\u00020n2\u000b\u0010Y\u001a\u0007\u0012\u0002\b\u00030ù\u0001H\u0017J&\u0010ú\u0001\u001a\u00020n2\u0015\u0010û\u0001\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030ù\u00010ü\u0001H\u0017¢\u0006\u0003\u0010ý\u0001J\u0012\u0010þ\u0001\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#H\u0016J\u0012\u0010ÿ\u0001\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#H\u0016J\u0013\u0010\u0080\u0002\u001a\u00030\u0081\u00022\u0007\u0010\u00ad\u0001\u001a\u00020#H\u0016J\u001d\u0010\u0082\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u0084\u0002\u001a\u00020nH\u0016J\u000f\u0010\u0085\u0002\u001a\u00020nH\u0010¢\u0006\u0003\b\u0086\u0002J\u001d\u0010\u0087\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001bH\u0016J#\u0010\u0088\u0002\u001a\u00020,2\u0007\u0010\u008b\u0001\u001a\u00020\u001a2\t\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u001bH\u0010¢\u0006\u0003\b\u008a\u0002J'\u0010\u008b\u0002\u001a\u00020n2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0010¢\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002J\u0013\u0010\u008e\u0002\u001a\u00020n2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u008f\u0002\u001a\u00020nH\u0016J\u000f\u0010\u0090\u0002\u001a\u00020nH\u0010¢\u0006\u0003\b\u0091\u0002J\u0011\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0003\b\u0093\u0002J\u0011\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0003\b\u0095\u0002J\u0013\u0010\u0096\u0002\u001a\u00020n2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0001J\t\u0010\u0097\u0002\u001a\u00020nH\u0002J\t\u0010\u0098\u0002\u001a\u00020nH\u0002J\t\u0010\u0099\u0002\u001a\u00020nH\u0002J\t\u0010\u009a\u0002\u001a\u00020nH\u0002J\f\u0010\u009b\u0002\u001a\u0005\u0018\u00010ô\u0001H\u0002J?\u0010\u009c\u0002\u001a\u00020n2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0016\u0010¤\u0001\u001a\u0011\u0012\u0004\u0012\u00020n\u0018\u00010\u0081\u0001¢\u0006\u0003\b¥\u0001H\u0003¢\u0006\u0006\b\u009d\u0002\u0010\u009e\u0002J\u0012\u0010\u009f\u0002\u001a\u00020n2\u0007\u0010 \u0002\u001a\u00020,H\u0002J\t\u0010¡\u0002\u001a\u00020nH\u0002J\t\u0010¢\u0002\u001a\u00020nH\u0002J\u000f\u0010£\u0002\u001a\u00020nH\u0010¢\u0006\u0003\b¤\u0002J\u001d\u0010¥\u0002\u001a\u00020n2\u0007\u0010 \u0002\u001a\u00020,2\t\u0010¦\u0002\u001a\u0004\u0018\u00010\u001fH\u0002J\t\u0010§\u0002\u001a\u00020nH\u0002J\u001a\u0010¨\u0002\u001a\u00020n2\u0007\u0010©\u0002\u001a\u00020#2\u0006\u0010}\u001a\u00020,H\u0002J\t\u0010ª\u0002\u001a\u00020nH\u0002J\t\u0010«\u0002\u001a\u00020nH\u0002J\t\u0010¬\u0002\u001a\u000201H\u0002J\u0017\u0010¬\u0002\u001a\u0002012\f\u0010\u00ad\u0002\u001a\u00070#j\u0003`·\u0001H\u0002J*\u0010®\u0002\u001a\u00020n2\u001f\u0010Ó\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Õ\u00010Ô\u0001H\u0003Jt\u0010¯\u0002\u001a\u0003H°\u0002\"\u0005\b\u0000\u0010°\u00022\f\b\u0002\u0010±\u0002\u001a\u0005\u0018\u00010²\u00022\f\b\u0002\u0010³\u0002\u001a\u0005\u0018\u00010²\u00022\u000e\b\u0002\u0010´\u0002\u001a\u00070#j\u0003`·\u00012\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0Õ\u00010Ô\u00012\u000f\u0010\u0080\u0001\u001a\n\u0012\u0005\u0012\u0003H°\u00020\u0081\u0001H\u0002¢\u0006\u0003\u0010µ\u0002J8\u0010¶\u0002\u001a\u00020n2\u0010\u0010¤\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0Ð\u00012\u0007\u0010·\u0002\u001a\u0002012\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010¸\u0002\u001a\u00020,H\u0003J\u0017\u0010¹\u0002\u001a\u00020,2\f\u0010\u00ad\u0002\u001a\u00070cj\u0003`º\u0002H\u0002J\t\u0010»\u0002\u001a\u00020nH\u0003J\t\u0010¼\u0002\u001a\u00020nH\u0002J\u0017\u0010½\u0002\u001a\u00020n2\f\u0010¾\u0002\u001a\u00070cj\u0003`º\u0002H\u0002J\u0012\u0010¿\u0002\u001a\u00020n2\u0007\u0010À\u0002\u001a\u000201H\u0002J\t\u0010Á\u0002\u001a\u00020nH\u0002J\u0017\u0010Â\u0002\u001a\u00020n2\f\u0010Ã\u0002\u001a\u00070cj\u0003`º\u0002H\u0002J\u0012\u0010Ä\u0002\u001a\u00020n2\u0007\u0010½\u0001\u001a\u00020,H\u0002J\u0017\u0010Å\u0002\u001a\u00020\u001a2\f\u0010\u00ad\u0002\u001a\u00070#j\u0003`·\u0001H\u0002J\u0017\u0010Æ\u0002\u001a\u00020,2\f\u0010\u00ad\u0002\u001a\u00070#j\u0003`·\u0001H\u0002J\u0017\u0010Ç\u0002\u001a\u00020#2\f\u0010\u00ad\u0002\u001a\u00070#j\u0003`·\u0001H\u0002J\t\u0010È\u0002\u001a\u00020nH\u0002J\t\u0010É\u0002\u001a\u00020nH\u0002J;\u0010Ê\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\t\u0010Ë\u0002\u001a\u0004\u0018\u00010\u001b2\b\u0010Ì\u0002\u001a\u00030Í\u00022\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0006\bÏ\u0002\u0010Ð\u0002J\u0013\u0010Ñ\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#H\u0082\bJ\u001d\u0010Ñ\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001bH\u0002J\u001d\u0010Ò\u0002\u001a\u00020n2\u0007\u0010 \u0002\u001a\u00020,2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001bH\u0002J\t\u0010Ó\u0002\u001a\u00020nH\u0002J+\u0010Ô\u0002\u001a\n\u0012\u0005\u0012\u00030Ý\u00010Ô\u00012\u0007\u0010\u00ad\u0002\u001a\u00020#2\t\u0010Õ\u0002\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0003\u0010Ö\u0002J\u0019\u0010×\u0002\u001a\u00020n2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0003\bØ\u0002J \u0010Ù\u0002\u001a\u00020n2\f\u0010Ú\u0002\u001a\u00070cj\u0003`Û\u00022\u0007\u0010Ü\u0002\u001a\u00020#H\u0002J \u0010Ý\u0002\u001a\u00020n2\f\u0010Þ\u0002\u001a\u00070cj\u0003`Û\u00022\u0007\u0010ß\u0002\u001a\u00020#H\u0002J\u001b\u0010à\u0002\u001a\u0002012\u0007\u0010á\u0002\u001a\u0002012\u0007\u0010â\u0002\u001a\u000201H\u0002J\u0013\u0010ã\u0002\u001a\u00020n2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0002J\u0017\u0010ä\u0002\u001a\u00020#2\f\u0010Þ\u0002\u001a\u00070cj\u0003`Û\u0002H\u0002J\u0011\u0010å\u0002\u001a\u0004\u0018\u00010\u001b*\u0004\u0018\u00010\u001bH\u0002J1\u0010æ\u0002\u001a\u0003H°\u0002\"\u0005\b\u0000\u0010°\u00022\u0006\u00109\u001a\u00020:2\u000f\u0010\u0080\u0001\u001a\n\u0012\u0005\u0012\u0003H°\u00020\u0081\u0001H\u0082\b¢\u0006\u0003\u0010ç\u0002J\u0012\u0010è\u0002\u001a\u00020n2\u0007\u0010\u008b\u0001\u001a\u00020\u001aH\u0002J\"\u0010é\u0002\u001a\u0012\u0012\u0005\u0012\u00030ë\u0002\u0012\u0004\u0012\u00020n\u0018\u00010ê\u00022\u0007\u0010\u008b\u0001\u001a\u00020\u001aH\u0002J1\u0010ì\u0002\u001a\u00020n2\u0007\u0010í\u0002\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001b2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001bH\u0082\bJ\u001b\u0010î\u0002\u001a\u00020n2\u0007\u0010í\u0002\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0082\bJ1\u0010ï\u0002\u001a\u00020n2\u0007\u0010í\u0002\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001b2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001bH\u0082\bJ\u001b\u0010ð\u0002\u001a\u00020n2\u0007\u0010í\u0002\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0082\bJ\t\u0010ñ\u0002\u001a\u00020nH\u0002J\t\u0010ò\u0002\u001a\u00020nH\u0002R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010KR\u000e\u0010N\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020,X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u001e\u0010Z\u001a\u00020,2\u0006\u0010Y\u001a\u00020,@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010RR\u001e\u0010\\\u001a\u00020,2\u0006\u0010Y\u001a\u00020,@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010RR\u0014\u0010^\u001a\u00020,8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b_\u0010RR\u0016\u0010`\u001a\u0004\u0018\u00010\u001a8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR0\u0010e\u001a\u00060cj\u0002`d2\n\u0010Y\u001a\u00060cj\u0002`d8\u0016@RX\u0097\u000e¢\u0006\u0010\n\u0002\u0010j\u0012\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010RR\u001c\u0010q\u001a\u0004\u0018\u00010\fX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010x\u001a\u0004\u0018\u00010y8PX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u001e\u0010}\u001a\u00020,2\u0006\u0010Y\u001a\u00020,@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b~\u0010RR\u001a\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0016\u0010\u008c\u0001\u001a\u00020,8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010RR!\u0010\u0094\u0001\u001a\u00030\u0095\u00018\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0096\u0001\u0010g\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010©\u0001\u001a\u00020E8VX\u0096\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0018\u0010²\u0001\u001a\u00030³\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001R\u001c\u0010¶\u0001\u001a\u00070#j\u0003`·\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¸\u0001\u0010¹\u0001R\u0016\u0010Í\u0001\u001a\u00020,8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010R¨\u0006õ\u0002"}, d2 = {"Landroidx/compose/runtime/LinkComposer;", "Landroidx/compose/runtime/InternalComposer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "slotTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Ljava/util/Set;Landroidx/compose/runtime/composer/linkbuffer/SlotTable;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/CompositionObserverHolder;Landroidx/compose/runtime/CompositionImpl;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "invalidations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/collection/MutableScatterMap;", "pendingStack", "Landroidx/compose/runtime/Stack;", "Landroidx/compose/runtime/LinkPending;", "Ljava/util/ArrayList;", "pending", "nodeIndex", "", "groupNodeCount", "rGroupIndex", "parentStateStack", "Landroidx/compose/runtime/IntStack;", "nodeCountOverrides", "Landroidx/collection/MutableIntIntMap;", "nodeCountVirtualOverrides", "forceRecomposeScopes", "", "forciblyRecompose", "nodeExpected", "entersStack", "rootProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "providerUpdates", "Landroidx/collection/MutableIntObjectMap;", "providersInvalid", "providersInvalidStack", "reusing", "reusingGroup", "providerCache", "reader", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "getReader$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "setReader$runtime", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;)V", "builder", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "builderHasAProvider", "changeListWriter", "Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriter;", "_compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "lastPlacedChildGroup", "insertFixups", "Landroidx/compose/runtime/composer/linkbuffer/changelist/FixupList;", "insertTable", "getInsertTable$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "readerTable", "getReaderTable$runtime", "childrenComposing", "compositionToken", "sourceMarkersEnabled", "getSourceMarkersEnabled$runtime", "()Z", "setSourceMarkersEnabled$runtime", "(Z)V", "derivedStateObserver", "androidx/compose/runtime/LinkComposer$derivedStateObserver$1", "Landroidx/compose/runtime/LinkComposer$derivedStateObserver$1;", "invalidateStack", "value", "isComposing", "isComposing$runtime", "isDisposed", "isDisposed$runtime", "areChildrenComposing", "getAreChildrenComposing$runtime", "currentRecomposeScope", "getCurrentRecomposeScope$runtime", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "compositeKeyHashCode", "getCompositeKeyHashCode$annotations", "()V", "getCompositeKeyHashCode", "()J", "J", "defaultsInvalid", "getDefaultsInvalid", "disableReusing", "", "disableSourceInformation", "enableReusing", "deferredChanges", "getDeferredChanges$runtime", "()Landroidx/compose/runtime/Changes;", "setDeferredChanges$runtime", "(Landroidx/compose/runtime/Changes;)V", "shouldPauseCallback", "Landroidx/compose/runtime/ShouldPauseCallback;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "getErrorContext$runtime", "()Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "forceRecomposeScopes$runtime", "inserting", "getInserting", "prepareCompose", "block", "Lkotlin/Function0;", "prepareCompose$runtime", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "recordUsed", "scope", "skipping", "getSkipping", "apply", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "buildContext", "changed", "changedInstance", "", "", "", "", "", "collectParameterInformation", "composeContent", "invalidationsRequested", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "shouldPause", "composeContent--ZbOJvo$runtime", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ShouldPauseCallback;)V", "compositionData", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "getCurrentMarker", "()I", "deactivate", "deactivate$runtime", "deactivateToEndGroup", "dispose", "dispose$runtime", "endDefaults", "endNode", "endProvider", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReplaceGroup", "endReusableGroup", "endReuseFromRoot", "endReuseFromRoot$runtime", "endMovableGroup", "endToMarker", "marker", "hasPendingChanges", "getHasPendingChanges$runtime", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "joinKey", TtmlNode.LEFT, TtmlNode.RIGHT, "parentKey", "parentKey$runtime", "parentStackTrace", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "parentStackTrace$runtime", "recompose", "recompose-aFTiNEg$runtime", "(Landroidx/collection/MutableScatterMap;Landroidx/compose/runtime/ShouldPauseCallback;)Z", "recordSideEffect", "effect", "rememberedValue", "shouldExecute", "parametersChanged", DownloaderServiceMarshaller.PARAMS_FLAGS, "skipCurrentGroup", "skipToGroupEnd", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "stacksSize", "stacksSize$runtime", "stackTraceForValue", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "stackTraceForValue$runtime", "startDefaults", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReplaceableGroup", "startReplaceGroup", "startRestartGroup", "Landroidx/compose/runtime/Composer;", "startReusableGroup", "dataKey", "startReusableNode", "startReuseFromRoot", "startReuseFromRoot$runtime", "startMovableGroup", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime", "updateComposerInvalidations", "updateComposerInvalidations-RY85e9Y$runtime", "(Landroidx/collection/MutableScatterMap;)V", "updateRememberedValue", "useNode", "verifyConsistent", "verifyConsistent$runtime", "nextSlot", "nextSlot$runtime", "nextSlotForCache", "nextSlotForCache$runtime", "updateValue", "abortRoot", "addRecomposeScope", "cleanUpCompose", "clearUpdatedNodeCounts", "currentStackTrace", "doCompose", "doCompose-aFTiNEg", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", TtmlNode.END, "isNode", "endGroup", "endRoot", "changesApplied", "changesApplied$runtime", "enterGroup", "newPending", "executeChangesImmediatelyWithoutApplier", "exitGroup", "expectedNodeCount", "ensureBuilder", "finalizeCompose", "currentCompositionLocalScope", "group", "insertMovableContentGuarded", "recomposeMovableContent", "R", "from", "Landroidx/compose/runtime/ControlledComposition;", TypedValues.TransitionType.S_TO, "address", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;ILjava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "invokeMovableContentLambda", "locals", "force", "isGroupAfterCurrentReaderPosition", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "recomposeToGroupEnd", "recordDelete", "recordInsert", "source", "recordProviderUpdate", "providers", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "resetInsertBuilder", "requireRecomposeScope", "requiresRecomposition", "rGroupIndexOf", "skipGroup", "skipReaderToGroupEnd", TtmlNode.START, "objectKey", "kind", "Landroidx/compose/runtime/composer/GroupKind;", "data", "start-AzEfcrM", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startGroup", "startReaderGroup", "startRoot", "stackTraceForGroup", "dataOffset", "(ILjava/lang/Integer;)Ljava/util/List;", "updateCachedValue", "updateCachedValue$runtime", "updateChildNodeCount", "virtualGroup", "Landroidx/compose/runtime/VirtualGroupHandle;", "count", "updateNodeCountOverrides", "virtualHandle", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateSlot", "updatedNodeCount", "unwrapRememberObserverHolder", "withReader", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "enterRecomposeScope", "exitRecomposeScope", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "updateCompositeKeyWhenWeEnterGroup", "groupKey", "updateCompositeKeyWhenWeEnterGroupKeyHash", "updateCompositeKeyWhenWeExitGroup", "updateCompositeKeyWhenWeExitGroupKeyHash", "validateNodeExpected", "validateNodeNotExpected", "CompositionContextImpl", "CompositionContextHolder", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LinkComposer extends InternalComposer {
    public static final int $stable = 8;
    private CompositionData _compositionData;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final CoroutineContext applyCoroutineContext;
    private SlotTableBuilder builder;
    private boolean builderHasAProvider;
    private final ComposerChangeListWriter changeListWriter;
    private Changes changes;
    private int childrenComposing;
    private long compositeKeyHashCode;
    private final CompositionImpl composition;
    private int compositionToken;
    private Changes deferredChanges;
    private final LinkComposer$derivedStateObserver$1 derivedStateObserver;
    private final CompositionErrorContextImpl errorContext;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private FixupList insertFixups;
    private boolean inserting;
    private final ArrayList<RecomposeScopeImpl> invalidateStack;
    private boolean isComposing;
    private boolean isDisposed;
    private int lastPlacedChildGroup;
    private Changes lateChanges;
    private MutableIntIntMap nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parentContext;
    private LinkPending pending;
    private PersistentCompositionLocalMap providerCache;
    private MutableIntObjectMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private int rGroupIndex;
    private SlotTableReader reader;
    private boolean reusing;
    private ShouldPauseCallback shouldPauseCallback;
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;
    private final MutableScatterMap<Object, Object> invalidations = ScopeMap.m4507constructorimpl$default(null, 1, null);
    private final ArrayList<LinkPending> pendingStack = Stack.m4452constructorimpl$default(null, 1, null);
    private final IntStack parentStateStack = new IntStack();
    private final IntStack entersStack = new IntStack();
    private PersistentCompositionLocalMap rootProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    private final IntStack providersInvalidStack = new IntStack();
    private int reusingGroup = -1;

    public static /* synthetic */ void getApplyCoroutineContext$annotations() {
    }

    public static /* synthetic */ void getCompositeKeyHashCode$annotations() {
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.runtime.LinkComposer$derivedStateObserver$1] */
    public LinkComposer(Applier<?> applier, CompositionContext compositionContext, Set<RememberObserver> set, SlotTable slotTable, Changes changes, Changes changes2, CompositionObserverHolder compositionObserverHolder, CompositionImpl compositionImpl) {
        this.applier = applier;
        this.parentContext = compositionContext;
        this.abandonSet = set;
        this.slotTable = slotTable;
        this.changes = changes;
        this.lateChanges = changes2;
        this.observerHolder = compositionObserverHolder;
        this.composition = compositionImpl;
        SlotTableReader openReader = slotTable.openReader();
        openReader.close();
        this.reader = openReader;
        boolean z = false;
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(slotTable.getAddressSpace(), false, false);
        slotTableBuilder.close();
        this.builder = slotTableBuilder;
        this.changeListWriter = new ComposerChangeListWriter(this, ChangeListKt.asLinkBufferChangeList(this.changes));
        this.lastPlacedChildGroup = -1;
        this.insertFixups = new FixupList();
        this.sourceMarkersEnabled = (compositionContext.getCollectingSourceInformation$runtime() || compositionContext.getCollectingCallByInformation$runtime()) ? true : z;
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.LinkComposer$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                LinkComposer.this.childrenComposing++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                LinkComposer.this.childrenComposing--;
            }
        };
        this.invalidateStack = Stack.m4452constructorimpl$default(null, 1, null);
        this.errorContext = new CompositionErrorContextImpl(this);
        CoroutineContext effectCoroutineContext = compositionContext.getEffectCoroutineContext();
        CoroutineContext errorContext$runtime = getErrorContext$runtime();
        this.applyCoroutineContext = effectCoroutineContext.plus(errorContext$runtime == null ? EmptyCoroutineContext.INSTANCE : errorContext$runtime);
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionImpl getComposition() {
        return this.composition;
    }

    public final SlotTableReader getReader$runtime() {
        return this.reader;
    }

    public final void setReader$runtime(SlotTableReader slotTableReader) {
        this.reader = slotTableReader;
    }

    public final SlotTable getInsertTable$runtime() {
        return this.builder.getTable();
    }

    public final SlotTable getReaderTable$runtime() {
        return this.reader.getTable();
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
    public RecomposeScopeImpl getCurrentRecomposeScope$runtime() {
        ArrayList<RecomposeScopeImpl> arrayList = this.invalidateStack;
        if (this.childrenComposing == 0 && Stack.m4458isNotEmptyimpl(arrayList)) {
            return (RecomposeScopeImpl) Stack.m4459peekimpl(arrayList);
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public long getCompositeKeyHashCode() {
        return this.compositeKeyHashCode;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return !getSkipping() || this.providersInvalid || ((currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) != null && currentRecomposeScope$runtime.getDefaultsInvalid());
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        setSourceMarkersEnabled$runtime(false);
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public Changes getDeferredChanges$runtime() {
        return this.deferredChanges;
    }

    public void setDeferredChanges$runtime(Changes changes) {
        this.deferredChanges = changes;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public CompositionErrorContextImpl getErrorContext$runtime() {
        if (getSourceMarkersEnabled$runtime()) {
            return this.errorContext;
        }
        return null;
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

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
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
    public void recordUsed(RecomposeScope recomposeScope) {
        RecomposeScopeImpl recomposeScopeImpl = recomposeScope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) recomposeScope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return (getInserting() || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || currentRecomposeScope$runtime.getRequiresRecompose() || this.forciblyRecompose) ? false : true;
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
    public CoroutineContext getApplyCoroutineContext() {
        return this.applyCoroutineContext;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        LinkComposer linkComposer;
        startGroup(206, ComposerKt.getReference());
        if (getInserting()) {
            this.builder.addFlags(1073741824);
        }
        Object nextSlot$runtime = nextSlot$runtime();
        ReusableLinkRememberObserverHolder reusableLinkRememberObserverHolder = nextSlot$runtime instanceof ReusableRememberObserverHolder ? (ReusableRememberObserverHolder) nextSlot$runtime : null;
        if (reusableLinkRememberObserverHolder == null) {
            linkComposer = this;
            reusableLinkRememberObserverHolder = new ReusableLinkRememberObserverHolder(new CompositionContextHolder(new CompositionContextImpl(getCompositeKeyHashCode(), this.forceRecomposeScopes, getSourceMarkersEnabled$runtime(), getComposition().getObserverHolder$runtime())), LinkAnchorKt.getNullAnchor());
            linkComposer.updateValue(reusableLinkRememberObserverHolder);
        } else {
            linkComposer = this;
        }
        RememberObserver wrapped = reusableLinkRememberObserverHolder.getWrapped();
        Intrinsics.checkNotNull(wrapped, "null cannot be cast to non-null type androidx.compose.runtime.LinkComposer.CompositionContextHolder");
        CompositionContextHolder compositionContextHolder = (CompositionContextHolder) wrapped;
        compositionContextHolder.getRef().updateCompositionLocalScope(linkComposer.currentCompositionLocalScope());
        linkComposer.endGroup();
        return compositionContextHolder.getRef();
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(Object obj) {
        if (Intrinsics.areEqual(nextSlot$runtime(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changedInstance(Object obj) {
        if (nextSlot$runtime() != obj) {
            updateValue(obj);
            return true;
        }
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(char c) {
        Object nextSlot$runtime = nextSlot$runtime();
        if ((nextSlot$runtime instanceof Character) && c == ((Character) nextSlot$runtime).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(byte b) {
        Object nextSlot$runtime = nextSlot$runtime();
        if ((nextSlot$runtime instanceof Byte) && b == ((Number) nextSlot$runtime).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(short s) {
        Object nextSlot$runtime = nextSlot$runtime();
        if ((nextSlot$runtime instanceof Short) && s == ((Number) nextSlot$runtime).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(boolean z) {
        Object nextSlot$runtime = nextSlot$runtime();
        if ((nextSlot$runtime instanceof Boolean) && z == ((Boolean) nextSlot$runtime).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(float f) {
        Object nextSlot$runtime = nextSlot$runtime();
        if ((nextSlot$runtime instanceof Float) && Intrinsics.areEqual(f, (Float) nextSlot$runtime)) {
            return false;
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(long j) {
        Object nextSlot$runtime = nextSlot$runtime();
        boolean z = nextSlot$runtime instanceof Long;
        if (z && z && j == ((Number) nextSlot$runtime).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(double d) {
        Object nextSlot$runtime = nextSlot$runtime();
        if ((nextSlot$runtime instanceof Double) && Intrinsics.areEqual(d, (Double) nextSlot$runtime)) {
            return false;
        }
        updateValue(Double.valueOf(d));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(int i) {
        Object nextSlot$runtime = nextSlot$runtime();
        boolean z = nextSlot$runtime instanceof Integer;
        if (z && z && i == ((Number) nextSlot$runtime).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        setSourceMarkersEnabled$runtime(true);
        this.slotTable.collectSourceInformation();
        this.builder.collectSourceInformation();
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* renamed from: composeContent--ZbOJvo$runtime */
    public void mo4428composeContentZbOJvo$runtime(MutableScatterMap<Object, Object> mutableScatterMap, Function2<? super Composer, ? super Integer, Unit> function2, ShouldPauseCallback shouldPauseCallback) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        this.shouldPauseCallback = shouldPauseCallback;
        try {
            m4435doComposeaFTiNEg(mutableScatterMap, function2);
        } finally {
            this.shouldPauseCallback = null;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        CompositionData compositionData = this._compositionData;
        if (compositionData == null) {
            LinkCompositionDataImpl linkCompositionDataImpl = new LinkCompositionDataImpl(getComposition());
            this._compositionData = linkCompositionDataImpl;
            return linkCompositionDataImpl;
        }
        return compositionData;
    }

    @Override // androidx.compose.runtime.Composer
    public <T> T consume(CompositionLocal<T> compositionLocal) {
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), compositionLocal);
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(Function0<? extends T> function0) {
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        int peek = this.parentStateStack.peek();
        this.groupNodeCount++;
        long parentHandle = this.builder.getParentHandle();
        if (this.changeListWriter.isInAnchorMode()) {
            this.insertFixups.createAndInsertNodeByAnchor(function0, peek, this.builder.getTable().getAddressSpace().anchorOfAddress(GroupHandleKt.getGroup(parentHandle)));
            return;
        }
        this.insertFixups.createAndInsertNode(function0, peek, this.builder.getParentHandle());
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.builder.getParentGroup() : this.reader.getParentGroup();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void deactivate$runtime() {
        Stack.m4450clearimpl(this.invalidateStack);
        ScopeMap.m4505clearimpl(this.invalidations);
        this.changes.clear();
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
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
        this.changeListWriter.deactivateCurrentGroup();
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void dispose$runtime() {
        this.slotTable.dispose();
        this.parentContext.unregisterComposer$runtime(this);
        deactivate$runtime();
        getApplier().clear();
        this.isDisposed = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime == null || !currentRecomposeScope$runtime.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProvider() {
        endGroup();
        endGroup();
        this.providersInvalid = LinkComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = LinkComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public ScopeUpdateScope endRestartGroup() {
        LinkAnchor parentAnchor;
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
                if (recomposeScopeImpl2.getResetReusing() && this.reusingGroup == this.reader.getParentGroup()) {
                    recomposeScopeImpl2.setResetReusing(false);
                    this.reusingGroup = -1;
                    this.reusing = false;
                }
            }
        }
        if (recomposeScopeImpl2 != null && !recomposeScopeImpl2.getSkipped$runtime() && (recomposeScopeImpl2.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImpl2.getAnchor() == null) {
                if (getInserting()) {
                    parentAnchor = this.builder.getParentAnchor();
                } else {
                    parentAnchor = this.reader.getParentAnchor();
                }
                recomposeScopeImpl2.setAnchor(parentAnchor);
            }
            recomposeScopeImpl2.setDefaultsInvalid(false);
            recomposeScopeImpl = recomposeScopeImpl2;
        }
        end(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParentGroup() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void endReuseFromRoot$runtime() {
        int i = this.reusingGroup;
        if (!(!isComposing$runtime() && (i < 0 ? 100 : this.reader.groupKey(i)) == 100)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int i) {
        if (i < 0) {
            int i2 = -i;
            SlotTableBuilder slotTableBuilder = this.builder;
            MutableIntSet mutableIntSet = new MutableIntSet(0, 1, null);
            int[] groups = getReaderTable$runtime().getAddressSpace().getGroups();
            int i3 = i2;
            while (i3 > 0) {
                mutableIntSet.add(i3);
                i3 = groups[i3 + 2];
            }
            if (!(i3 != 0)) {
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i2);
            }
            while (!mutableIntSet.contains(slotTableBuilder.getParentGroup())) {
                end(slotTableBuilder.isNode());
            }
            return;
        }
        if (getInserting()) {
            SlotTableBuilder slotTableBuilder2 = this.builder;
            while (getInserting()) {
                end(slotTableBuilder2.isNode());
            }
        }
        MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
        int[] groups2 = getReaderTable$runtime().getAddressSpace().getGroups();
        int i4 = i;
        while (i4 > 0) {
            mutableIntSet2.add(i4);
            i4 = groups2[i4 + 2];
        }
        if (!(i4 != 0)) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
        }
        SlotTableReader slotTableReader = this.reader;
        for (int parentGroup = slotTableReader.getParentGroup(); !mutableIntSet2.contains(parentGroup); parentGroup = slotTableReader.getParentGroup()) {
            end((slotTableReader.flagsOf(parentGroup) & 8388608) == 8388608);
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean getHasPendingChanges$runtime() {
        return this.changes.isNotEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContent(MovableContent<?> movableContent, Object obj) {
        Intrinsics.checkNotNull(movableContent, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(movableContent, currentCompositionLocalScope(), obj, false);
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        try {
            insertMovableContentGuarded(list);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Object joinKey(Object obj, Object obj2) {
        Object access$getKey = LinkComposerKt.access$getKey(getInserting() ? null : this.reader.getGroupObjectKey(), obj, obj2);
        return access$getKey == null ? new JoinedKey(obj, obj2) : access$getKey;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public int parentKey$runtime() {
        if (getInserting()) {
            SlotTableBuilder slotTableBuilder = this.builder;
            return slotTableBuilder.groupKey(slotTableBuilder.getParentGroup());
        }
        SlotTableReader slotTableReader = this.reader;
        return slotTableReader.groupKey(slotTableReader.getParentGroup());
    }

    @Override // androidx.compose.runtime.InternalComposer
    public List<ComposeStackTraceFrame> parentStackTrace$runtime() {
        Composition composition$runtime = this.parentContext.getComposition$runtime();
        CompositionImpl compositionImpl = composition$runtime instanceof CompositionImpl ? (CompositionImpl) composition$runtime : null;
        if (compositionImpl == null) {
            return CollectionsKt.emptyList();
        }
        Integer findSubcompositionContextGroup = LinkComposerKt.findSubcompositionContextGroup(SlotTableKt.asLinkBufferSlotTable(compositionImpl.getSlotStorage$runtime()), this.parentContext);
        if (findSubcompositionContextGroup == null) {
            return CollectionsKt.emptyList();
        }
        SlotTableReader openReader = SlotTableKt.asLinkBufferSlotTable(compositionImpl.getSlotStorage$runtime()).openReader();
        try {
            List<ComposeStackTraceFrame> traceForGroup = SlotTableReaderKt.traceForGroup(openReader, findSubcompositionContextGroup.intValue(), 0);
            openReader.close();
            return CollectionsKt.plus((Collection) traceForGroup, (Iterable) compositionImpl.getComposer$runtime().parentStackTrace$runtime());
        } catch (Throwable th) {
            openReader.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* renamed from: recompose-aFTiNEg$runtime */
    public boolean mo4429recomposeaFTiNEg$runtime(MutableScatterMap<Object, Object> mutableScatterMap, ShouldPauseCallback shouldPauseCallback) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (ScopeMap.m4515getSizeimpl(mutableScatterMap) > 0 || ScopeMap.m4518isNotEmptyimpl(this.invalidations) || ((this.slotTable.getRoot() >= 0 && requiresRecomposition(this.slotTable.getRoot())) || this.forciblyRecompose)) {
            this.shouldPauseCallback = shouldPauseCallback;
            try {
                this.changeListWriter.startComposition();
                m4435doComposeaFTiNEg(mutableScatterMap, null);
                this.shouldPauseCallback = null;
                if (ChangeListKt.asLinkBufferChangeList(this.changes).hasChangesRequiringApplication()) {
                    return true;
                }
                if (this.changes.isNotEmpty()) {
                    executeChangesImmediatelyWithoutApplier();
                    return false;
                }
                return false;
            } catch (Throwable th) {
                this.shouldPauseCallback = null;
                throw th;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(Function0<Unit> function0) {
        this.changeListWriter.sideEffect(function0);
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return unwrapRememberObserverHolder(nextSlotForCache$runtime());
    }

    @Override // androidx.compose.runtime.Composer
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ca  */
    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void skipCurrentGroup() {
        long rotateLeft;
        if (!requiresRecomposition(this.reader.getCurrentGroup())) {
            skipGroup();
            return;
        }
        SlotTableReader slotTableReader = this.reader;
        int groupKey = slotTableReader.getGroupKey();
        Object groupObjectKey = slotTableReader.getGroupObjectKey();
        Object groupAux = slotTableReader.getGroupAux();
        int i = this.rGroupIndex;
        if (groupObjectKey != null) {
            rotateLeft = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ (groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode()), 3);
        } else if (groupAux != null && groupKey == 207 && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
            this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ groupAux.hashCode(), 3) ^ i;
            startReaderGroup(slotTableReader.isNode(), null);
            recomposeToGroupEnd();
            slotTableReader.endGroup();
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
        startReaderGroup(slotTableReader.isNode(), null);
        recomposeToGroupEnd();
        slotTableReader.endGroup();
        if (groupObjectKey == null) {
        }
    }

    @Override // androidx.compose.runtime.Composer
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
        if (this.reader.getCurrentGroup() < 0 || !requiresRecomposition(this.reader.getParentGroup())) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CancellationHandle scheduleFrameEndCallback(Function0<Unit> function0) {
        return this.parentContext.scheduleFrameEndCallback(function0);
    }

    @Override // androidx.compose.runtime.Composer
    public void sourceInformation(String str) {
        if (getInserting() && getSourceMarkersEnabled$runtime()) {
            this.builder.recordGroupSourceInformation(str);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void sourceInformationMarkerEnd() {
        if (getInserting() && getSourceMarkersEnabled$runtime()) {
            this.builder.recordGrouplessCallSourceInformationEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void sourceInformationMarkerStart(int i, String str) {
        if (getInserting() && getSourceMarkersEnabled$runtime()) {
            this.builder.recordGrouplessCallSourceInformationStart(i, str);
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public int stacksSize$runtime() {
        return this.entersStack.tos + Stack.m4455getSizeimpl(this.invalidateStack) + this.providersInvalidStack.tos + Stack.m4455getSizeimpl(this.pendingStack) + this.parentStateStack.tos;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public ComposeStackTrace stackTraceForValue$runtime(final Object obj) {
        List emptyList;
        if (getSourceMarkersEnabled$runtime()) {
            ObjectLocation findLocation = SlotTableKt.findLocation(this.slotTable, new Function1() { // from class: androidx.compose.runtime.LinkComposer$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(LinkComposer.stackTraceForValue$lambda$0(obj, obj2));
                }
            });
            if (findLocation == null || (emptyList = CollectionsKt.plus((Collection) stackTraceForGroup(findLocation.component1(), findLocation.component2()), (Iterable) parentStackTrace$runtime())) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            return new ComposeStackTrace(emptyList, getSourceMarkersEnabled$runtime());
        }
        return new ComposeStackTrace(CollectionsKt.emptyList(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean stackTraceForValue$lambda$0(Object obj, Object obj2) {
        if (obj2 != obj) {
            RememberObserverHolder rememberObserverHolder = obj2 instanceof RememberObserverHolder ? (RememberObserverHolder) obj2 : null;
            return (rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null) == obj;
        }
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startDefaults() {
        m4436startAzEfcrM(ComposerKt.defaultsKey, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m4436startAzEfcrM(GapComposerKt.nodeKey, null, GroupKind.Companion.m4537getNode9udXigM(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startProvider(ProvidedValue<?> providedValue) {
        ValueHolder<Object> valueHolder;
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
            this.builderHasAProvider = true;
        } else {
            SlotTableReader slotTableReader = this.reader;
            Object groupAux = slotTableReader.groupAux(slotTableReader.getCurrentGroup());
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
        this.providersInvalidStack.push(LinkComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = currentCompositionLocalScope;
        m4436startAzEfcrM(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m4536getGroup9udXigM(), currentCompositionLocalScope);
    }

    @Override // androidx.compose.runtime.Composer
    public void startProviders(ProvidedValue<?>[] providedValueArr) {
        PersistentCompositionLocalMap updateProviderMapGroup;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            updateProviderMapGroup = updateProviderMapGroup(currentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(providedValueArr, currentCompositionLocalScope, null, 4, null));
            this.builderHasAProvider = true;
        } else {
            Object obj = this.reader.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) obj;
            Object obj2 = this.reader.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) obj2;
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
        this.providersInvalidStack.push(LinkComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = updateProviderMapGroup;
        m4436startAzEfcrM(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m4536getGroup9udXigM(), updateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReplaceableGroup(int i) {
        m4436startAzEfcrM(i, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReplaceGroup(int i) {
        if (this.pending != null) {
            m4436startAzEfcrM(i, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
            return;
        }
        validateNodeNotExpected();
        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ i, 3) ^ this.rGroupIndex;
        this.rGroupIndex++;
        SlotTableReader slotTableReader = this.reader;
        if (getInserting()) {
            slotTableReader.beginEmpty();
            SlotTableBuilder slotTableBuilder = this.builder;
            Object empty = Composer.Companion.getEmpty();
            SlotTableBuilder.access$startNewGroup(slotTableBuilder, i, empty == Composer.Companion.getEmpty() ? 0 : 16777216, empty, null, null);
            enterGroup(false, null);
        } else if (slotTableReader.getGroupKey() == i && !slotTableReader.getHasObjectKey()) {
            slotTableReader.startGroup();
            enterGroup(false, null);
        } else {
            if (!slotTableReader.isGroupEnd()) {
                int i2 = this.nodeIndex;
                recordDelete();
                this.changeListWriter.removeNode(i2, slotTableReader.skipGroup());
            }
            slotTableReader.beginEmpty();
            this.inserting = true;
            this.providerCache = null;
            ensureBuilder();
            SlotTableBuilder slotTableBuilder2 = this.builder;
            Object empty2 = Composer.Companion.getEmpty();
            SlotTableBuilder.access$startNewGroup(slotTableBuilder2, i, empty2 == Composer.Companion.getEmpty() ? 0 : 16777216, empty2, null, null);
            enterGroup(false, null);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Composer startRestartGroup(int i) {
        startReplaceGroup(i);
        addRecomposeScope();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int i, Object obj) {
        if (!getInserting() && this.reader.getGroupKey() == i && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m4436startAzEfcrM(i, null, GroupKind.Companion.m4536getGroup9udXigM(), obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m4436startAzEfcrM(GapComposerKt.nodeKey, null, GroupKind.Companion.m4538getReusableNode9udXigM(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void startReuseFromRoot$runtime() {
        this.reusingGroup = this.slotTable.getRoot();
        this.reusing = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startMovableGroup(int i, Object obj) {
        m4436startAzEfcrM(i, obj, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean tryImminentInvalidation$runtime(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int address;
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor != null && (address = LinkAnchorKt.asLinkAnchor(anchor).getAddress()) >= 0 && isComposing$runtime() && isGroupAfterCurrentReaderPosition(UInt.m10021constructorimpl(address) & 4294967295L)) {
            this.reader.addFlag(address, 67108864);
            if (obj == null || Intrinsics.areEqual(obj, ScopeInvalidated.INSTANCE)) {
                ScopeMap.m4524setimpl(this.invalidations, recomposeScopeImpl, ScopeInvalidated.INSTANCE);
                return true;
            }
            boolean z = obj instanceof ScatterSet;
            MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
            if (z) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.collection.ScatterSet<kotlin.Any>");
                ScopeMap.m4501addAllimpl(mutableScatterMap, recomposeScopeImpl, (ScatterSet) obj);
                return true;
            } else if (Intrinsics.areEqual(ScopeMap.m4514getimpl(mutableScatterMap, recomposeScopeImpl), ScopeInvalidated.INSTANCE)) {
                return true;
            } else {
                ScopeMap.m4500addimpl(this.invalidations, recomposeScopeImpl, obj);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* renamed from: updateComposerInvalidations-RY85e9Y$runtime */
    public void mo4430updateComposerInvalidationsRY85e9Y$runtime(MutableScatterMap<Object, Object> mutableScatterMap) {
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
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
                        int i4 = (i << 3) + i3;
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                        Anchor anchor = ((RecomposeScopeImpl) obj).getAnchor();
                        LinkAnchor asLinkAnchor = anchor != null ? LinkAnchorKt.asLinkAnchor(anchor) : null;
                        if (asLinkAnchor != null && asLinkAnchor.getValid()) {
                            int address = asLinkAnchor.getAddress();
                            this.reader.addFlag(address, 67108864);
                            if (Intrinsics.areEqual(obj2, ScopeInvalidated.INSTANCE)) {
                                ScopeMap.m4524setimpl(this.invalidations, obj, ScopeInvalidated.INSTANCE);
                            } else if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<kotlin.Any>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                ScopeMap.m4501addAllimpl(this.invalidations, obj, (ScatterSet) obj2);
                            } else {
                                ScopeMap.m4500addimpl(this.invalidations, obj, obj2);
                            }
                            this.reader.addFlag(address, 67108864);
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
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object obj) {
        updateCachedValue$runtime(obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object parentNode = this.reader.getParentNode();
        this.changeListWriter.moveDown(parentNode);
        if (this.reusing && (parentNode instanceof ComposeNodeLifecycleCallback)) {
            this.changeListWriter.useNode(parentNode);
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void verifyConsistent$runtime() {
        if (isComposing$runtime()) {
            return;
        }
        getInsertTable$runtime().verifyWellFormed();
    }

    public final Object nextSlot$runtime() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserverHolder)) ? next : Composer.Companion.getEmpty();
    }

    public final Object nextSlotForCache$runtime() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        if (!this.reusing || (next instanceof ReusableRememberObserverHolder)) {
            if (next instanceof RememberObserverHolder) {
                this.changeListWriter.updateRememberOrdering(LinkComposerKt.asLinkRememberObserverHolder((RememberObserverHolder) next), getReaderTable$runtime().getAddressSpace().anchorOfAddress(this.lastPlacedChildGroup));
            }
            return next;
        }
        return Composer.Companion.getEmpty();
    }

    public final void updateValue(Object obj) {
        if (getInserting()) {
            this.builder.append(obj);
            return;
        }
        boolean hadNext = this.reader.getHadNext();
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        if (hadNext) {
            composerChangeListWriter.updateValue(this.reader.getParentCurrentSlotOffset() - 1, obj);
        } else {
            composerChangeListWriter.appendValue(obj);
        }
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
        if (!this.reader.isClosed()) {
            this.reader.close();
        }
        resetInsertBuilder(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addRecomposeScope() {
        RecomposeScopeImpl recomposeScopeImpl;
        boolean z;
        if (getInserting()) {
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl(getComposition());
            Stack.m4462pushimpl(this.invalidateStack, recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            enterRecomposeScope(recomposeScopeImpl2);
            return;
        }
        int parentGroup = this.reader.getParentGroup();
        RecomposeScopeImpl recomposeScopeOrNull = LinkComposerKt.getRecomposeScopeOrNull(this.reader, parentGroup);
        Object m4519removeimpl = recomposeScopeOrNull != null ? ScopeMap.m4519removeimpl(this.invalidations, recomposeScopeOrNull) : null;
        boolean recomposeRequired = this.reader.recomposeRequired(parentGroup);
        if (recomposeRequired) {
            this.reader.removeFlag(67108864);
        }
        Object next = this.reader.next();
        if (Intrinsics.areEqual(next, Composer.Companion.getEmpty())) {
            recomposeScopeImpl = new RecomposeScopeImpl(getComposition());
            updateValue(recomposeScopeImpl);
        } else {
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            recomposeScopeImpl = (RecomposeScopeImpl) next;
        }
        if (!recomposeRequired && m4519removeimpl == null) {
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
                this.reusingGroup = this.reader.getParentGroup();
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
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compositeKeyHashCode = 0L;
        this.nodeExpected = false;
        Stack.m4450clearimpl(this.invalidateStack);
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeStackTrace currentStackTrace() {
        if (getSourceMarkersEnabled$runtime()) {
            List createListBuilder = CollectionsKt.createListBuilder();
            createListBuilder.addAll(SlotTableBuilderKt.buildTrace(this.builder));
            createListBuilder.addAll(SlotTableReaderKt.buildTrace(this.reader));
            createListBuilder.addAll(parentStackTrace$runtime());
            return new ComposeStackTrace(CollectionsKt.build(createListBuilder), getSourceMarkersEnabled$runtime());
        }
        return null;
    }

    /* renamed from: doCompose-aFTiNEg  reason: not valid java name */
    private final void m4435doComposeaFTiNEg(MutableScatterMap<Object, Object> mutableScatterMap, Function2<? super Composer, ? super Integer, Unit> function2) {
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
            Object nextSlot$runtime = nextSlot$runtime();
            if (nextSlot$runtime != function2 && function2 != null) {
                updateValue(function2);
            }
            LinkComposer$derivedStateObserver$1 linkComposer$derivedStateObserver$1 = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            derivedStateObservers.add(linkComposer$derivedStateObserver$1);
            if (function2 != null) {
                startGroup(200, ComposerKt.getInvocation());
                Expect_jvmKt.invokeComposable(this, function2);
                endGroup();
            } else if ((this.forciblyRecompose || this.providersInvalid) && nextSlot$runtime != null && !Intrinsics.areEqual(nextSlot$runtime, Composer.Companion.getEmpty())) {
                startGroup(200, ComposerKt.getInvocation());
                Expect_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(nextSlot$runtime, 2));
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
            resetInsertBuilder(false);
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    private final void end(boolean z) {
        long rotateRight;
        long j;
        List<KeyInfo> list;
        List<KeyInfo> list2;
        long rotateRight2;
        long j2;
        int peek2 = this.parentStateStack.peek2() - 1;
        if (getInserting()) {
            int parentGroup = this.builder.getParentGroup();
            int groupKey = this.builder.groupKey(parentGroup);
            Object groupObjectKey = this.builder.groupObjectKey(parentGroup);
            Object groupAux = this.builder.groupAux(parentGroup);
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
            int parentGroup2 = this.reader.getParentGroup();
            int groupKey2 = this.reader.groupKey(parentGroup2);
            Object groupObjectKey2 = this.reader.groupObjectKey(parentGroup2);
            Object groupAux2 = this.reader.groupAux(parentGroup2);
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
        LinkPending linkPending = this.pending;
        if (linkPending != null && !linkPending.getKeyInfos().isEmpty()) {
            List<KeyInfo> keyInfos = linkPending.getKeyInfos();
            List<KeyInfo> used = linkPending.getUsed();
            Set fastToSet = ListUtilsKt.fastToSet(used);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < size2) {
                KeyInfo keyInfo = keyInfos.get(i2);
                if (!fastToSet.contains(keyInfo)) {
                    this.changeListWriter.removeNode(linkPending.nodePositionOf(keyInfo) + linkPending.getStartIndex(), keyInfo.getNodes());
                    linkPending.updateNodeCount(GroupHandleKt.getGroup(keyInfo.getHandle()), 0);
                    this.reader.reposition(keyInfo.getHandle());
                    recordDelete();
                    this.reader.skipGroup();
                } else if (!linkedHashSet.contains(keyInfo)) {
                    if (i3 < size) {
                        KeyInfo keyInfo2 = used.get(i3);
                        if (keyInfo2 != keyInfo) {
                            int nodePositionOf = linkPending.nodePositionOf(keyInfo2);
                            linkedHashSet.add(keyInfo2);
                            if (nodePositionOf != i4) {
                                int updatedNodeCountOf = linkPending.updatedNodeCountOf(keyInfo2);
                                list = keyInfos;
                                list2 = used;
                                this.changeListWriter.moveNode(nodePositionOf + linkPending.getStartIndex(), i4 + linkPending.getStartIndex(), updatedNodeCountOf);
                                linkPending.registerMoveNode(nodePositionOf, i4, updatedNodeCountOf);
                            } else {
                                list = keyInfos;
                                list2 = used;
                            }
                        } else {
                            list = keyInfos;
                            list2 = used;
                            i2++;
                        }
                        i3++;
                        i4 += linkPending.updatedNodeCountOf(keyInfo2);
                        keyInfos = list;
                        used = list2;
                    }
                }
                i2++;
            }
            this.changeListWriter.endNodeMovement();
            if (!keyInfos.isEmpty()) {
                this.reader.skipToGroupEnd();
            }
        }
        boolean inserting = getInserting();
        if (!inserting) {
            int i5 = this.nodeIndex;
            int previousSibling = this.reader.getPreviousSibling();
            SlotTable readerTable$runtime = getReaderTable$runtime();
            int currentGroup = this.reader.getCurrentGroup();
            int[] groups = readerTable$runtime.getAddressSpace().getGroups();
            while (true) {
                int i6 = currentGroup;
                int i7 = previousSibling;
                previousSibling = i6;
                if (previousSibling < 0) {
                    break;
                }
                reportFreeMovableContent(GroupHandleKt.makeGroupHandle(this.reader.getParentGroup(), i7, previousSibling));
                this.changeListWriter.removeNode(i5, this.reader.nodeCount(previousSibling));
                this.changeListWriter.endNodeMovement();
                currentGroup = groups[previousSibling + 1];
            }
            this.changeListWriter.removeTailGroupsAndValues(this.reader.getCurrentGroup(), this.reader.getRemainingSlots());
        }
        if (inserting) {
            if (z) {
                this.insertFixups.endNodeInsert();
                i = 1;
            }
            this.lastPlacedChildGroup = this.builder.getParentGroup();
            this.reader.endEmpty();
            this.builder.endGroup();
            if (!this.reader.getInEmpty()) {
                long lastRoot = this.builder.lastRoot();
                recordInsert(lastRoot);
                this.inserting = false;
                if (!getReaderTable$runtime().isEmpty()) {
                    long access$toInsertAddress = LinkComposerKt.access$toInsertAddress(lastRoot);
                    updateChildNodeCount(access$toInsertAddress, 0);
                    updateNodeCountOverrides(access$toInsertAddress, i);
                }
            }
        } else {
            if (z) {
                this.changeListWriter.moveUp();
            }
            long parentHandle = this.reader.getParentHandle();
            if (i != updatedNodeCount(parentHandle)) {
                updateNodeCountOverrides(parentHandle, i);
            }
            int i8 = z ? 1 : i;
            this.lastPlacedChildGroup = GroupHandleKt.getGroup(parentHandle);
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
            i = i8;
        }
        exitGroup(i, inserting);
    }

    private final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime();
        endGroup();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = LinkComposerKt.access$asBool(this.providersInvalidStack.pop());
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void changesApplied$runtime() {
        this.providerUpdates = null;
    }

    private final void enterGroup(boolean z, LinkPending linkPending) {
        Stack.m4462pushimpl(this.pendingStack, this.pending);
        this.pending = linkPending;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
        this.lastPlacedChildGroup = -1;
    }

    private final void executeChangesImmediatelyWithoutApplier() {
        SlotTableEditor openEditor = this.slotTable.openEditor();
        try {
            ChangeListKt.asLinkBufferChangeList(this.changes).executeAndFlushAllPendingChanges(ThrowingApplierStub.INSTANCE, openEditor, ThrowingRememberManagerStub.INSTANCE, getErrorContext$runtime());
            Unit unit = Unit.INSTANCE;
        } finally {
            openEditor.close();
        }
    }

    private final void exitGroup(int i, boolean z) {
        LinkPending linkPending = (LinkPending) Stack.m4461popimpl(this.pendingStack);
        if (linkPending != null && !z) {
            linkPending.setGroupIndex(linkPending.getGroupIndex() + 1);
        }
        this.pending = linkPending;
        this.nodeIndex = this.parentStateStack.pop() + i;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + i;
    }

    private final void ensureBuilder() {
        if (this.builder.isClosed()) {
            SlotTableBuilder slotTableBuilder = new SlotTableBuilder(this.slotTable.getAddressSpace(), this.slotTable.getRecordSourceInformation(), this.slotTable.getRecordCallByInformation());
            this.builder = slotTableBuilder;
            slotTableBuilder.buildStart();
            this.builderHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (!Stack.m4457isEmptyimpl(this.pendingStack)) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.getParentGroup());
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int i) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        if (getInserting() && this.builderHasAProvider) {
            int parentGroup = this.builder.getParentGroup();
            while (parentGroup >= 0) {
                if (this.builder.groupKey(parentGroup) == 202 && Intrinsics.areEqual(this.builder.groupObjectKey(parentGroup), ComposerKt.getCompositionLocalMap())) {
                    Object groupAux = this.builder.groupAux(parentGroup);
                    Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupAux;
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                parentGroup = this.builder.parent(parentGroup);
            }
        }
        if (!this.reader.isEmpty()) {
            while (i >= 0) {
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
                i = this.reader.parentOf(i);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.rootProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(32:(10:(2:51|(42:53|54|55|56|57|58|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|(1:86)(1:118)|87|88|89|90|91|93|94|95|96|97))|88|89|90|91|93|94|95|96|97)|55|56|57|58|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|(0)(0)|87) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x027a, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x027c, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x027d, code lost:
        r16 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x027f, code lost:
        r2 = r14;
        r10 = r3;
        r11 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0259  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        ComposerChangeListWriter composerChangeListWriter2;
        ChangeList changeList2;
        SlotTable asLinkBufferSlotTable;
        int i;
        SlotTableReader openReader;
        SlotTableReader slotTableReader;
        SlotTableReader slotTableReader2;
        MutableIntIntMap mutableIntIntMap;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap2;
        ComposerChangeListWriter composerChangeListWriter3;
        ChangeList changeList3;
        ComposerChangeListWriter composerChangeListWriter4;
        ChangeList changeList4;
        ComposerChangeListWriter composerChangeListWriter5;
        boolean implicitRootStart;
        ComposerChangeListWriter composerChangeListWriter6;
        ComposerChangeListWriter composerChangeListWriter7;
        int i2;
        ComposerChangeListWriterAddressMode addressMode$runtime;
        long access$getEditorCurrentPosition$p;
        ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode;
        SlotStorage slotStorage$runtime;
        SlotTable asLinkBufferSlotTable2;
        SlotStorage slotStorage$runtime2;
        SlotTableReader slotTableReader3;
        final LinkComposer linkComposer = this;
        List<Pair<MovableContentStateReference, MovableContentStateReference>> list2 = list;
        ComposerChangeListWriter composerChangeListWriter8 = linkComposer.changeListWriter;
        ChangeList asLinkBufferChangeList = ChangeListKt.asLinkBufferChangeList(linkComposer.lateChanges);
        ChangeList changeList5 = composerChangeListWriter8.getChangeList();
        try {
            composerChangeListWriter8.setChangeList(asLinkBufferChangeList);
            linkComposer.changeListWriter.resetSlots();
            int size = list2.size();
            ?? r13 = 0;
            int i3 = 0;
            while (i3 < size) {
                try {
                    Pair<MovableContentStateReference, MovableContentStateReference> pair = list2.get(i3);
                    final MovableContentStateReference component1 = pair.component1();
                    MovableContentStateReference component2 = pair.component2();
                    final long m10021constructorimpl = UInt.m10021constructorimpl(LinkAnchorKt.asLinkAnchor(component1.getAnchor$runtime()).getAddress()) & 4294967295L;
                    IntRef intRef = new IntRef(r13, 1, null);
                    linkComposer.changeListWriter.determineMovableContentNodeIndex(intRef, m10021constructorimpl);
                    if (component2 == null) {
                        SlotTable asLinkBufferSlotTable3 = SlotTableKt.asLinkBufferSlotTable(component1.getSlotStorage$runtime());
                        if (Intrinsics.areEqual(asLinkBufferSlotTable3, linkComposer.builder.getTable())) {
                            linkComposer.resetInsertBuilder(r13);
                        }
                        final SlotTableReader openReader2 = asLinkBufferSlotTable3.openReader();
                        try {
                            openReader2.reposition(m10021constructorimpl);
                            try {
                                final ChangeList changeList6 = new ChangeList();
                                Function0 function0 = new Function0() { // from class: androidx.compose.runtime.LinkComposer$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit insertMovableContentGuarded$lambda$0$0$0$0;
                                        insertMovableContentGuarded$lambda$0$0$0$0 = LinkComposer.insertMovableContentGuarded$lambda$0$0$0$0(LinkComposer.this, changeList6, openReader2, m10021constructorimpl, component1);
                                        return insertMovableContentGuarded$lambda$0$0$0$0;
                                    }
                                };
                                slotTableReader3 = openReader2;
                                linkComposer = this;
                                try {
                                    recomposeMovableContent$default(linkComposer, null, null, 0, null, function0, 15, null);
                                    linkComposer.changeListWriter.includeOperationsIn(changeList6, intRef);
                                    Unit unit = Unit.INSTANCE;
                                    slotTableReader3.close();
                                    composerChangeListWriter2 = composerChangeListWriter8;
                                    changeList2 = changeList5;
                                    i2 = size;
                                    i = i3;
                                } catch (Throwable th) {
                                    th = th;
                                    slotTableReader3.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                slotTableReader3 = openReader2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            slotTableReader3 = openReader2;
                        }
                    } else {
                        MovableContentState movableContentStateResolve$runtime = linkComposer.parentContext.movableContentStateResolve$runtime(component2);
                        if (movableContentStateResolve$runtime == null || (slotStorage$runtime2 = movableContentStateResolve$runtime.getSlotStorage$runtime()) == null || (asLinkBufferSlotTable = SlotTableKt.asLinkBufferSlotTable(slotStorage$runtime2)) == null) {
                            asLinkBufferSlotTable = SlotTableKt.asLinkBufferSlotTable(component2.getSlotStorage$runtime());
                        }
                        int address = (movableContentStateResolve$runtime == null || (slotStorage$runtime = movableContentStateResolve$runtime.getSlotStorage$runtime()) == null || (asLinkBufferSlotTable2 = SlotTableKt.asLinkBufferSlotTable(slotStorage$runtime)) == null) ? LinkAnchorKt.asLinkAnchor(component2.getAnchor$runtime()).getAddress() : asLinkBufferSlotTable2.getRoot();
                        List<? extends Object> access$collectNodesFrom = LinkComposerKt.access$collectNodesFrom(asLinkBufferSlotTable, address);
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            try {
                                                try {
                                                    try {
                                                        try {
                                                            try {
                                                                try {
                                                                    try {
                                                                        try {
                                                                            if (!access$collectNodesFrom.isEmpty()) {
                                                                                linkComposer.changeListWriter.copyNodesToNewAnchorLocation(access$collectNodesFrom, intRef);
                                                                                if (Intrinsics.areEqual(component1.getSlotStorage$runtime(), linkComposer.slotTable)) {
                                                                                    i = i3;
                                                                                    linkComposer.updateChildNodeCount(UInt.m10021constructorimpl(LinkAnchorKt.asLinkAnchor(component1.getAnchor$runtime()).getAddress()) & 4294967295L, linkComposer.updatedNodeCount(UInt.m10021constructorimpl(LinkAnchorKt.asLinkAnchor(component1.getAnchor$runtime()).getAddress()) & 4294967295L) + access$collectNodesFrom.size());
                                                                                    linkComposer.changeListWriter.copySlotTableToAnchorLocation(movableContentStateResolve$runtime, linkComposer.parentContext, component2, component1);
                                                                                    openReader = asLinkBufferSlotTable.openReader();
                                                                                    slotTableReader2 = linkComposer.reader;
                                                                                    mutableIntIntMap = linkComposer.nodeCountOverrides;
                                                                                    mutableIntObjectMap = linkComposer.providerUpdates;
                                                                                    linkComposer.nodeCountOverrides = null;
                                                                                    linkComposer.providerUpdates = null;
                                                                                    linkComposer.reader = openReader;
                                                                                    openReader.reposition(address);
                                                                                    ChangeList changeList7 = new ChangeList();
                                                                                    composerChangeListWriter3 = linkComposer.changeListWriter;
                                                                                    changeList3 = composerChangeListWriter3.getChangeList();
                                                                                    composerChangeListWriter3.setChangeList(changeList7);
                                                                                    composerChangeListWriter5 = linkComposer.changeListWriter;
                                                                                    slotTableReader = openReader;
                                                                                    implicitRootStart = composerChangeListWriter5.getImplicitRootStart();
                                                                                    composerChangeListWriter5.setImplicitRootStart(false);
                                                                                    int i4 = size;
                                                                                    composerChangeListWriter7 = linkComposer.changeListWriter;
                                                                                    i2 = i4;
                                                                                    ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter7, linkComposer.reader.handle());
                                                                                    ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode2 = ComposerChangeListWriterAddressMode.RelativeAddressing;
                                                                                    addressMode$runtime = composerChangeListWriter7.getAddressMode$runtime();
                                                                                    access$getEditorCurrentPosition$p = ComposerChangeListWriter.access$getEditorCurrentPosition$p(composerChangeListWriter7);
                                                                                    composerChangeListWriter7.setAddressMode$runtime(composerChangeListWriterAddressMode2);
                                                                                    component2.transferPendingInvalidations$runtime();
                                                                                    composerChangeListWriter6 = composerChangeListWriter5;
                                                                                    composerChangeListWriter2 = composerChangeListWriter8;
                                                                                    composerChangeListWriter4 = composerChangeListWriter3;
                                                                                    composerChangeListWriterAddressMode = addressMode$runtime;
                                                                                    changeList2 = changeList5;
                                                                                    changeList4 = changeList3;
                                                                                    linkComposer.recomposeMovableContent(component2.getComposition$runtime(), component1.getComposition$runtime(), linkComposer.reader.getCurrentGroup(), component2.getInvalidations$runtime(), new Function0() { // from class: androidx.compose.runtime.LinkComposer$$ExternalSyntheticLambda2
                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final Object invoke() {
                                                                                            Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0;
                                                                                            insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0 = LinkComposer.insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0(LinkComposer.this, component1);
                                                                                            return insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0;
                                                                                        }
                                                                                    });
                                                                                    composerChangeListWriter7.setAddressMode$runtime(composerChangeListWriterAddressMode);
                                                                                    ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter7, composerChangeListWriterAddressMode != ComposerChangeListWriterAddressMode.RelativeAddressing ? access$getEditorCurrentPosition$p : -1L);
                                                                                    composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                                                    composerChangeListWriter4.setChangeList(changeList4);
                                                                                    linkComposer.changeListWriter.includeOperationsIn(changeList7, intRef);
                                                                                    Unit unit2 = Unit.INSTANCE;
                                                                                    linkComposer.reader = slotTableReader2;
                                                                                    linkComposer.nodeCountOverrides = mutableIntIntMap;
                                                                                    linkComposer.providerUpdates = mutableIntObjectMap;
                                                                                    Unit unit3 = Unit.INSTANCE;
                                                                                    slotTableReader.close();
                                                                                    linkComposer.changeListWriter.disposeResolvedMovableState(movableContentStateResolve$runtime);
                                                                                }
                                                                            }
                                                                            slotTableReader.close();
                                                                            linkComposer.changeListWriter.disposeResolvedMovableState(movableContentStateResolve$runtime);
                                                                        } catch (Throwable th4) {
                                                                            th = th4;
                                                                            composerChangeListWriter = composerChangeListWriter2;
                                                                            changeList = changeList2;
                                                                            composerChangeListWriter.setChangeList(changeList);
                                                                            throw th;
                                                                        }
                                                                        linkComposer.reader = slotTableReader2;
                                                                        linkComposer.nodeCountOverrides = mutableIntIntMap;
                                                                        linkComposer.providerUpdates = mutableIntObjectMap;
                                                                        Unit unit32 = Unit.INSTANCE;
                                                                    } catch (Throwable th5) {
                                                                        th = th5;
                                                                        slotTableReader.close();
                                                                        throw th;
                                                                    }
                                                                    composerChangeListWriter4.setChangeList(changeList4);
                                                                    linkComposer.changeListWriter.includeOperationsIn(changeList7, intRef);
                                                                    Unit unit22 = Unit.INSTANCE;
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    mutableIntObjectMap2 = mutableIntObjectMap;
                                                                    linkComposer.reader = slotTableReader2;
                                                                    linkComposer.nodeCountOverrides = mutableIntIntMap;
                                                                    linkComposer.providerUpdates = mutableIntObjectMap2;
                                                                    throw th;
                                                                }
                                                                composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                mutableIntObjectMap2 = mutableIntObjectMap;
                                                                try {
                                                                    composerChangeListWriter4.setChangeList(changeList4);
                                                                    throw th;
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    linkComposer.reader = slotTableReader2;
                                                                    linkComposer.nodeCountOverrides = mutableIntIntMap;
                                                                    linkComposer.providerUpdates = mutableIntObjectMap2;
                                                                    throw th;
                                                                }
                                                            }
                                                            composerChangeListWriter7.setAddressMode$runtime(composerChangeListWriterAddressMode);
                                                            ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter7, composerChangeListWriterAddressMode != ComposerChangeListWriterAddressMode.RelativeAddressing ? access$getEditorCurrentPosition$p : -1L);
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            mutableIntObjectMap2 = mutableIntObjectMap;
                                                            try {
                                                                composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                                throw th;
                                                            } catch (Throwable th10) {
                                                                th = th10;
                                                                composerChangeListWriter4.setChangeList(changeList4);
                                                                throw th;
                                                            }
                                                        }
                                                        linkComposer.recomposeMovableContent(component2.getComposition$runtime(), component1.getComposition$runtime(), linkComposer.reader.getCurrentGroup(), component2.getInvalidations$runtime(), new Function0() { // from class: androidx.compose.runtime.LinkComposer$$ExternalSyntheticLambda2
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0;
                                                                insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0 = LinkComposer.insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0(LinkComposer.this, component1);
                                                                return insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0;
                                                            }
                                                        });
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        mutableIntObjectMap2 = mutableIntObjectMap;
                                                        try {
                                                            composerChangeListWriter7.setAddressMode$runtime(composerChangeListWriterAddressMode);
                                                            ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter7, composerChangeListWriterAddressMode != ComposerChangeListWriterAddressMode.RelativeAddressing ? access$getEditorCurrentPosition$p : -1L);
                                                            throw th;
                                                        } catch (Throwable th12) {
                                                            th = th12;
                                                            composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                            throw th;
                                                        }
                                                    }
                                                    composerChangeListWriter6 = composerChangeListWriter5;
                                                    composerChangeListWriter2 = composerChangeListWriter8;
                                                    composerChangeListWriter4 = composerChangeListWriter3;
                                                    composerChangeListWriterAddressMode = addressMode$runtime;
                                                    changeList2 = changeList5;
                                                    changeList4 = changeList3;
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    composerChangeListWriter6 = composerChangeListWriter5;
                                                    mutableIntObjectMap2 = mutableIntObjectMap;
                                                    composerChangeListWriter4 = composerChangeListWriter3;
                                                    composerChangeListWriterAddressMode = addressMode$runtime;
                                                    changeList4 = changeList3;
                                                    composerChangeListWriter7.setAddressMode$runtime(composerChangeListWriterAddressMode);
                                                    ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter7, composerChangeListWriterAddressMode != ComposerChangeListWriterAddressMode.RelativeAddressing ? access$getEditorCurrentPosition$p : -1L);
                                                    throw th;
                                                }
                                            } catch (Throwable th14) {
                                                th = th14;
                                                composerChangeListWriter6 = composerChangeListWriter5;
                                                mutableIntObjectMap2 = mutableIntObjectMap;
                                                composerChangeListWriter4 = composerChangeListWriter3;
                                                composerChangeListWriterAddressMode = addressMode$runtime;
                                            }
                                            component2.transferPendingInvalidations$runtime();
                                        } catch (Throwable th15) {
                                            th = th15;
                                            composerChangeListWriterAddressMode = addressMode$runtime;
                                            mutableIntObjectMap2 = mutableIntObjectMap;
                                            composerChangeListWriter6 = composerChangeListWriter5;
                                            composerChangeListWriter4 = composerChangeListWriter3;
                                        }
                                        ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter7, linkComposer.reader.handle());
                                        ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode22 = ComposerChangeListWriterAddressMode.RelativeAddressing;
                                        addressMode$runtime = composerChangeListWriter7.getAddressMode$runtime();
                                        access$getEditorCurrentPosition$p = ComposerChangeListWriter.access$getEditorCurrentPosition$p(composerChangeListWriter7);
                                        composerChangeListWriter7.setAddressMode$runtime(composerChangeListWriterAddressMode22);
                                    } catch (Throwable th16) {
                                        th = th16;
                                        composerChangeListWriter6 = composerChangeListWriter5;
                                        mutableIntObjectMap2 = mutableIntObjectMap;
                                        composerChangeListWriter4 = composerChangeListWriter3;
                                        changeList4 = changeList3;
                                        composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                        throw th;
                                    }
                                    composerChangeListWriter5.setImplicitRootStart(false);
                                    int i42 = size;
                                    composerChangeListWriter7 = linkComposer.changeListWriter;
                                    i2 = i42;
                                } catch (Throwable th17) {
                                    th = th17;
                                    composerChangeListWriter6 = composerChangeListWriter5;
                                    mutableIntObjectMap2 = mutableIntObjectMap;
                                    composerChangeListWriter4 = composerChangeListWriter3;
                                }
                                linkComposer.reader = openReader;
                                openReader.reposition(address);
                                ChangeList changeList72 = new ChangeList();
                                composerChangeListWriter3 = linkComposer.changeListWriter;
                                changeList3 = composerChangeListWriter3.getChangeList();
                                composerChangeListWriter3.setChangeList(changeList72);
                                composerChangeListWriter5 = linkComposer.changeListWriter;
                                slotTableReader = openReader;
                                implicitRootStart = composerChangeListWriter5.getImplicitRootStart();
                            } catch (Throwable th18) {
                                th = th18;
                                slotTableReader = openReader;
                                mutableIntObjectMap2 = mutableIntObjectMap;
                            }
                            slotTableReader2 = linkComposer.reader;
                            mutableIntIntMap = linkComposer.nodeCountOverrides;
                            mutableIntObjectMap = linkComposer.providerUpdates;
                            linkComposer.nodeCountOverrides = null;
                            linkComposer.providerUpdates = null;
                        } catch (Throwable th19) {
                            th = th19;
                            slotTableReader = openReader;
                        }
                        i = i3;
                        linkComposer.changeListWriter.copySlotTableToAnchorLocation(movableContentStateResolve$runtime, linkComposer.parentContext, component2, component1);
                        openReader = asLinkBufferSlotTable.openReader();
                    }
                    i3 = i + 1;
                    list2 = list;
                    composerChangeListWriter8 = composerChangeListWriter2;
                    size = i2;
                    changeList5 = changeList2;
                    r13 = 0;
                } catch (Throwable th20) {
                    th = th20;
                    composerChangeListWriter2 = composerChangeListWriter8;
                    changeList2 = changeList5;
                }
            }
            ComposerChangeListWriter composerChangeListWriter9 = composerChangeListWriter8;
            ChangeList changeList8 = changeList5;
            linkComposer.resetInsertBuilder(r13);
            linkComposer.changeListWriter.endMovableContentPlacement();
            composerChangeListWriter9.setChangeList(changeList8);
        } catch (Throwable th21) {
            th = th21;
            composerChangeListWriter = composerChangeListWriter8;
            changeList = changeList5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertMovableContentGuarded$lambda$0$0$0$0(LinkComposer linkComposer, ChangeList changeList, SlotTableReader slotTableReader, long j, MovableContentStateReference movableContentStateReference) {
        ComposerChangeListWriter composerChangeListWriter = linkComposer.changeListWriter;
        ChangeList changeList2 = composerChangeListWriter.getChangeList();
        try {
            composerChangeListWriter.setChangeList(changeList);
            SlotTableReader slotTableReader2 = linkComposer.reader;
            MutableIntIntMap mutableIntIntMap = linkComposer.nodeCountOverrides;
            MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = linkComposer.providerUpdates;
            linkComposer.nodeCountOverrides = null;
            linkComposer.providerUpdates = null;
            linkComposer.reader = slotTableReader;
            ComposerChangeListWriter composerChangeListWriter2 = linkComposer.changeListWriter;
            boolean implicitRootStart = composerChangeListWriter2.getImplicitRootStart();
            try {
                composerChangeListWriter2.setImplicitRootStart(false);
                ComposerChangeListWriter composerChangeListWriter3 = linkComposer.changeListWriter;
                ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter3, j);
                ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode = ComposerChangeListWriterAddressMode.RelativeAddressing;
                ComposerChangeListWriterAddressMode addressMode$runtime = composerChangeListWriter3.getAddressMode$runtime();
                long access$getEditorCurrentPosition$p = ComposerChangeListWriter.access$getEditorCurrentPosition$p(composerChangeListWriter3);
                composerChangeListWriter3.setAddressMode$runtime(composerChangeListWriterAddressMode);
                linkComposer.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals$runtime(), movableContentStateReference.getParameter$runtime(), true);
                composerChangeListWriter3.setAddressMode$runtime(addressMode$runtime);
                if (addressMode$runtime != ComposerChangeListWriterAddressMode.RelativeAddressing) {
                    access$getEditorCurrentPosition$p = -1;
                }
                ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter3, access$getEditorCurrentPosition$p);
                composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                Unit unit = Unit.INSTANCE;
                linkComposer.reader = slotTableReader2;
                linkComposer.nodeCountOverrides = mutableIntIntMap;
                linkComposer.providerUpdates = mutableIntObjectMap;
                composerChangeListWriter.setChangeList(changeList2);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                throw th;
            }
        } catch (Throwable th2) {
            composerChangeListWriter.setChangeList(changeList2);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0(LinkComposer linkComposer, MovableContentStateReference movableContentStateReference) {
        linkComposer.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals$runtime(), movableContentStateReference.getParameter$runtime(), true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object recomposeMovableContent$default(LinkComposer linkComposer, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, int i, List list, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            controlledComposition = null;
        }
        if ((i2 & 2) != 0) {
            controlledComposition2 = null;
        }
        if ((i2 & 4) != 0) {
            i = -1;
        }
        if ((i2 & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return linkComposer.recomposeMovableContent(controlledComposition, controlledComposition2, i, list, function0);
    }

    private final <R> R recomposeMovableContent(ControlledComposition controlledComposition, ControlledComposition controlledComposition2, int i, List<? extends Pair<RecomposeScopeImpl, ? extends Object>> list, Function0<? extends R> function0) {
        R invoke;
        boolean isComposing$runtime = isComposing$runtime();
        int i2 = this.nodeIndex;
        try {
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Pair<RecomposeScopeImpl, ? extends Object> pair = list.get(i3);
                RecomposeScopeImpl component1 = pair.component1();
                Object component2 = pair.component2();
                if (component2 != null) {
                    tryImminentInvalidation$runtime(component1, component2);
                } else {
                    tryImminentInvalidation$runtime(component1, null);
                }
            }
            if (controlledComposition == null || (invoke = (R) controlledComposition.delegateInvalidations(controlledComposition2, i, function0)) == null) {
                invoke = function0.invoke();
            }
            return invoke;
        } finally {
            this.isComposing = isComposing$runtime;
            this.nodeIndex = i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        recordProviderUpdate(r18);
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
            if (getInserting()) {
                this.builder.addFlags(268435456);
            }
            boolean z2 = false;
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), persistentCompositionLocalMap)) {
                z2 = true;
            }
            m4436startAzEfcrM(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m4536getGroup9udXigM(), persistentCompositionLocalMap);
            this.providerCache = null;
            if (getInserting() && !z) {
                this.builderHasAProvider = true;
                SlotTableBuilder slotTableBuilder = this.builder;
                this.parentContext.insertMovableContent$runtime(new MovableContentStateReference(movableContent, obj, getComposition(), this.builder.getTable(), this.builder.getTable().getAddressSpace().anchorOfAddress(slotTableBuilder.parent(slotTableBuilder.getParentGroup())), CollectionsKt.emptyList(), currentCompositionLocalScope(), null));
            } else {
                boolean z3 = this.providersInvalid;
                this.providersInvalid = z2;
                this.changeListWriter.seekTo(this.reader.handle(), true);
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter, -1L);
                ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode = ComposerChangeListWriterAddressMode.AnchorAddressing;
                ComposerChangeListWriterAddressMode addressMode$runtime = composerChangeListWriter.getAddressMode$runtime();
                long access$getEditorCurrentPosition$p = ComposerChangeListWriter.access$getEditorCurrentPosition$p(composerChangeListWriter);
                composerChangeListWriter.setAddressMode$runtime(composerChangeListWriterAddressMode);
                Expect_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(-1241221479, true, new Function2() { // from class: androidx.compose.runtime.LinkComposer$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit invokeMovableContentLambda$lambda$0$0;
                        invokeMovableContentLambda$lambda$0$0 = LinkComposer.invokeMovableContentLambda$lambda$0$0(MovableContent.this, obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return invokeMovableContentLambda$lambda$0$0;
                    }
                }));
                composerChangeListWriter.setAddressMode$runtime(addressMode$runtime);
                ComposerChangeListWriter.access$setEditorCurrentPosition$p(composerChangeListWriter, addressMode$runtime == ComposerChangeListWriterAddressMode.RelativeAddressing ? access$getEditorCurrentPosition$p : -1L);
                this.providersInvalid = z3;
            }
        } catch (Throwable th) {
            try {
                throw ComposeStackTraceKt.attachComposeStackTrace(th, new Function0() { // from class: androidx.compose.runtime.LinkComposer$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ComposeStackTrace currentStackTrace;
                        currentStackTrace = LinkComposer.this.currentStackTrace();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeMovableContentLambda$lambda$0$0(MovableContent movableContent, Object obj, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2031@81096L18:LinkComposer.kt#9igjgp");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1241221479, i, -1, "androidx.compose.runtime.LinkComposer.invokeMovableContentLambda.<anonymous>.<anonymous> (LinkComposer.kt:2031)");
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

    private final boolean isGroupAfterCurrentReaderPosition(long j) {
        long handle = this.reader.handle();
        return handle == -1 || LinkComposerKt.access$firstGroupInTopologicalOrder(getReaderTable$runtime(), j, handle) == handle;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void recomposeToGroupEnd() {
        long j;
        int i;
        int i2;
        int firstChildOf;
        int i3;
        int i4;
        int i5;
        long rotateLeft;
        int i6;
        boolean isComposing$runtime = isComposing$runtime();
        int i7 = 1;
        this.isComposing = true;
        SlotTableReader slotTableReader = this.reader;
        int parentGroup = slotTableReader.getParentGroup();
        int i8 = this.nodeIndex;
        long compositeKeyHashCode = getCompositeKeyHashCode();
        int i9 = this.groupNodeCount;
        int i10 = this.rGroupIndex;
        int firstChildOf2 = slotTableReader.firstChildOf(parentGroup);
        int i11 = 0;
        loop0: while (firstChildOf2 != -1) {
            if (slotTableReader.recomposeRequired(firstChildOf2)) {
                slotTableReader.reposition(firstChildOf2);
                i = i7;
                RecomposeScopeImpl requireRecomposeScope = requireRecomposeScope(firstChildOf2);
                j = 4294967295L;
                if (requireRecomposeScope.isInvalidFor(ScopeMap.m4514getimpl(this.invalidations, requireRecomposeScope))) {
                    this.providerCache = null;
                    rGroupIndexOf(firstChildOf2);
                    requireRecomposeScope.compose(this);
                    this.providerCache = null;
                    i2 = i;
                    i11 = i2;
                    firstChildOf = slotTableReader.firstChildOf(firstChildOf2);
                    if (i2 == 0 || firstChildOf == -1) {
                        i3 = i2;
                        i4 = i11;
                        i5 = -1;
                    } else {
                        boolean hasRecomposeRequired = slotTableReader.hasRecomposeRequired(firstChildOf2);
                        if (hasRecomposeRequired) {
                            if (slotTableReader.groupObjectKey(firstChildOf2) instanceof MovableContent) {
                                this.compositeKeyHashCode = 126665345L;
                                i3 = i2;
                                i4 = i11;
                            } else {
                                int i12 = i11;
                                int groupKey = slotTableReader.groupKey(firstChildOf2);
                                int i13 = this.rGroupIndex;
                                Object groupObjectKey = slotTableReader.groupObjectKey(firstChildOf2);
                                i3 = i2;
                                Object groupAux = slotTableReader.groupAux(firstChildOf2);
                                if (groupObjectKey == null) {
                                    if (groupAux != null && groupKey == 207 && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                                        i4 = i12;
                                        this.compositeKeyHashCode = i13 ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ groupAux.hashCode(), 3);
                                    } else {
                                        i4 = i12;
                                        rotateLeft = i13 ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ groupKey, 3);
                                    }
                                } else {
                                    i4 = i12;
                                    rotateLeft = Long.rotateLeft((groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode()) ^ Long.rotateLeft(getCompositeKeyHashCode(), 3), 3);
                                }
                                this.compositeKeyHashCode = rotateLeft;
                            }
                            this.parentStateStack.push(this.nodeIndex);
                            this.parentStateStack.push(this.rGroupIndex);
                            if (slotTableReader.isNode(firstChildOf2)) {
                                this.changeListWriter.moveDown(slotTableReader.node(firstChildOf2));
                                i6 = 0;
                                this.nodeIndex = 0;
                            } else {
                                i6 = 0;
                            }
                            this.rGroupIndex = i6;
                        } else {
                            i3 = i2;
                            i4 = i11;
                            this.nodeIndex += slotTableReader.isNode(firstChildOf2) ? i : updatedNodeCount(UInt.m10021constructorimpl(firstChildOf2) & j);
                            if (!slotTableReader.hasObjectKey(firstChildOf2)) {
                                this.rGroupIndex++;
                            }
                        }
                        if (hasRecomposeRequired) {
                            firstChildOf2 = firstChildOf;
                            i7 = i;
                            i11 = i4;
                        } else {
                            i5 = -1;
                        }
                    }
                    if (firstChildOf == i5 && i3 == 0) {
                        this.nodeIndex += !slotTableReader.isNode(firstChildOf2) ? i : updatedNodeCount(UInt.m10021constructorimpl(firstChildOf2) & j);
                        if (!slotTableReader.hasObjectKey(firstChildOf2)) {
                            this.rGroupIndex++;
                        }
                    }
                    int i14 = firstChildOf2;
                    firstChildOf2 = slotTableReader.nextSiblingOf(firstChildOf2);
                    while (firstChildOf2 == -1) {
                        i14 = slotTableReader.parentOf(i14);
                        if (i14 == -1 || i14 == parentGroup) {
                            i11 = i4;
                            break loop0;
                        }
                        if (slotTableReader.isNode(i14)) {
                            this.changeListWriter.moveUp();
                        }
                        this.rGroupIndex = this.parentStateStack.pop();
                        this.nodeIndex = this.parentStateStack.pop() + updatedNodeCount(UInt.m10021constructorimpl(i14) & j);
                        int groupKey2 = slotTableReader.groupKey(i14);
                        int i15 = this.rGroupIndex;
                        Object groupObjectKey2 = slotTableReader.groupObjectKey(i14);
                        Object groupAux2 = slotTableReader.groupAux(i14);
                        if (groupObjectKey2 == null) {
                            if (groupAux2 != null && groupKey2 == 207 && !Intrinsics.areEqual(groupAux2, Composer.Companion.getEmpty())) {
                                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ i15, 3) ^ groupAux2.hashCode(), 3);
                            } else {
                                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ i15, 3) ^ groupKey2, 3);
                            }
                        } else {
                            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode(), 3) ^ (groupObjectKey2 instanceof Enum ? ((Enum) groupObjectKey2).ordinal() : groupObjectKey2.hashCode()), 3);
                        }
                        if (!slotTableReader.hasObjectKey(i14)) {
                            this.rGroupIndex++;
                        }
                        firstChildOf2 = slotTableReader.nextSiblingOf(i14);
                    }
                    continue;
                    i7 = i;
                    i11 = i4;
                } else {
                    Stack.m4462pushimpl(this.invalidateStack, requireRecomposeScope);
                    CompositionObserver current = this.observerHolder.current();
                    if (current != null) {
                        try {
                            current.onScopeEnter(requireRecomposeScope);
                            requireRecomposeScope.rereadTrackedInstances();
                        } finally {
                            current.onScopeExit(requireRecomposeScope);
                        }
                    } else {
                        requireRecomposeScope.rereadTrackedInstances();
                    }
                    Stack.m4461popimpl(this.invalidateStack);
                }
            } else {
                i = i7;
                j = 4294967295L;
            }
            i2 = 0;
            firstChildOf = slotTableReader.firstChildOf(firstChildOf2);
            if (i2 == 0) {
            }
            i3 = i2;
            i4 = i11;
            i5 = -1;
            if (firstChildOf == i5) {
                this.nodeIndex += !slotTableReader.isNode(firstChildOf2) ? i : updatedNodeCount(UInt.m10021constructorimpl(firstChildOf2) & j);
                if (!slotTableReader.hasObjectKey(firstChildOf2)) {
                }
            }
            int i142 = firstChildOf2;
            firstChildOf2 = slotTableReader.nextSiblingOf(firstChildOf2);
            while (firstChildOf2 == -1) {
            }
            continue;
            i7 = i;
            i11 = i4;
        }
        j = 4294967295L;
        slotTableReader.restoreParent(parentGroup);
        if (i11 != 0) {
            slotTableReader.skipToGroupEnd();
            int updatedNodeCount = updatedNodeCount(UInt.m10021constructorimpl(parentGroup) & j);
            this.nodeIndex = i8 + updatedNodeCount;
            this.groupNodeCount = i9 + updatedNodeCount;
            this.rGroupIndex = i10;
        } else {
            skipReaderToGroupEnd();
        }
        this.compositeKeyHashCode = compositeKeyHashCode;
        this.isComposing = isComposing$runtime;
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.handle());
        this.changeListWriter.removeGroup();
    }

    private final void recordInsert(long j) {
        boolean isEmpty = this.insertFixups.isEmpty();
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        if (isEmpty) {
            composerChangeListWriter.insertSlots(this.builder.getTable(), j);
            return;
        }
        composerChangeListWriter.insertSlots(this.builder.getTable(), j, this.insertFixups);
        this.insertFixups = new FixupList();
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
            this.providerUpdates = mutableIntObjectMap;
        }
        mutableIntObjectMap.set(this.reader.getCurrentGroup(), persistentCompositionLocalMap);
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsFlags(536870912)) {
            getComposition().updateMovingInvalidations$runtime();
            ChangeList changeList = new ChangeList();
            setDeferredChanges$runtime(changeList);
            SlotTableReader openReader = this.slotTable.openReader();
            try {
                this.reader = openReader;
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.getChangeList();
                composerChangeListWriter.setChangeList(changeList);
                reportFreeMovableContent(openReader.rootHandle());
                composerChangeListWriter.setChangeList(changeList2);
                Unit unit = Unit.INSTANCE;
            } finally {
                openReader.close();
            }
        }
    }

    private static final MovableContentStateReference reportFreeMovableContent$createMovableContentReferenceForGroup(LinkComposer linkComposer, int i, List<MovableContentStateReference> list) {
        Object groupObjectKey = linkComposer.reader.groupObjectKey(i);
        Intrinsics.checkNotNull(groupObjectKey, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        MovableContent movableContent = (MovableContent) groupObjectKey;
        Object obj = linkComposer.reader.get(i, 0);
        List<Pair<RecomposeScopeImpl, Object>> m4437findInvalidationsVpaz1Sg = LinkComposerKt.m4437findInvalidationsVpaz1Sg(linkComposer.reader, i, linkComposer.invalidations);
        return new MovableContentStateReference(movableContent, obj, linkComposer.getComposition(), linkComposer.getReaderTable$runtime(), linkComposer.getReaderTable$runtime().getAddressSpace().anchorOfAddress(i), m4437findInvalidationsVpaz1Sg, linkComposer.currentCompositionLocalScope(i), list);
    }

    private static final MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor(LinkComposer linkComposer, int i) {
        boolean z;
        int flagsOf = linkComposer.reader.flagsOf(i);
        List list = null;
        if ((flagsOf & 268435456) == 268435456) {
            if ((flagsOf & 536870912) == 536870912) {
                List createListBuilder = CollectionsKt.createListBuilder();
                SlotTableReader slotTableReader = linkComposer.reader;
                int firstChildOf = slotTableReader.firstChildOf(i);
                loop0: while (firstChildOf != -1) {
                    if ((linkComposer.reader.flagsOf(firstChildOf) & 268435456) == 268435456) {
                        MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor = reportFreeMovableContent$movableContentReferenceFor(linkComposer, firstChildOf);
                        if (reportFreeMovableContent$movableContentReferenceFor != null) {
                            createListBuilder.add(reportFreeMovableContent$movableContentReferenceFor);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    int firstChildOf2 = slotTableReader.firstChildOf(firstChildOf);
                    if (z || firstChildOf2 == -1 || (linkComposer.reader.flagsOf(firstChildOf) & 536870912) != 536870912) {
                        int i2 = firstChildOf;
                        firstChildOf = slotTableReader.nextSiblingOf(firstChildOf);
                        while (firstChildOf == -1) {
                            i2 = slotTableReader.parentOf(i2);
                            if (i2 == -1 || i2 == i) {
                                break loop0;
                            }
                            firstChildOf = slotTableReader.nextSiblingOf(i2);
                        }
                        continue;
                    } else {
                        firstChildOf = firstChildOf2;
                    }
                }
                list = CollectionsKt.build(createListBuilder);
            }
            return reportFreeMovableContent$createMovableContentReferenceForGroup(linkComposer, i, list);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        if ((r0 & 8388608) == 8388608) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
        r3 = r0 & androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a7, code lost:
        if ((r0 & 8388608) == 8388608) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0139, code lost:
        if ((r0 & 8388608) == 8388608) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int reportFreeMovableContent$reportGroup(LinkComposer linkComposer, long j, boolean z, int i) {
        int flagsOf;
        int group = GroupHandleKt.getGroup(j);
        int i2 = 0;
        if (group < 0) {
            return 0;
        }
        int flagsOf2 = linkComposer.reader.flagsOf(group);
        if ((flagsOf2 & 268435456) == 268435456) {
            MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor = reportFreeMovableContent$movableContentReferenceFor(linkComposer, group);
            if (reportFreeMovableContent$movableContentReferenceFor != null) {
                linkComposer.parentContext.deletedMovableContent$runtime(reportFreeMovableContent$movableContentReferenceFor);
                linkComposer.changeListWriter.releaseMovableGroup(linkComposer.getComposition(), linkComposer.parentContext, reportFreeMovableContent$movableContentReferenceFor);
            }
            if (z) {
                linkComposer.changeListWriter.endNodeMovementAndDeleteNode(i, group);
            } else {
                flagsOf = linkComposer.reader.flagsOf(group);
            }
        } else if ((flagsOf2 & 1073741824) == 1073741824) {
            Object obj = linkComposer.reader.get(group, 0);
            RememberObserverHolder rememberObserverHolder = obj instanceof RememberObserverHolder ? (RememberObserverHolder) obj : null;
            RememberObserver wrapped = rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null;
            CompositionContextHolder compositionContextHolder = wrapped instanceof CompositionContextHolder ? wrapped : null;
            if (compositionContextHolder != null) {
                for (LinkComposer linkComposer2 : compositionContextHolder.getRef().getComposers()) {
                    linkComposer2.reportAllMovableContent();
                    linkComposer.parentContext.reportRemovedComposition$runtime(linkComposer2.getComposition());
                }
            }
            flagsOf = linkComposer.reader.flagsOf(group);
        } else if ((flagsOf2 & 536870912) == 536870912 || (flagsOf2 & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            SlotTableReader slotTableReader = linkComposer.reader;
            int i3 = 0;
            for (long m10021constructorimpl = (UInt.m10021constructorimpl(slotTableReader.firstChildOf(group)) & 4294967295L) | (-4294967296L); GroupHandleKt.getGroup(m10021constructorimpl) != -1; m10021constructorimpl = (UInt.m10021constructorimpl(slotTableReader.nextSiblingOf(GroupHandleKt.getGroup(m10021constructorimpl))) & 4294967295L) | (GroupHandleKt.getGroup(m10021constructorimpl) << 32)) {
                int group2 = GroupHandleKt.getGroup(m10021constructorimpl);
                boolean z2 = (linkComposer.reader.flagsOf(group2) & 8388608) == 8388608;
                if (z2) {
                    linkComposer.changeListWriter.endNodeMovement();
                    linkComposer.changeListWriter.moveDown(linkComposer.reader.node(group2));
                }
                i3 += reportFreeMovableContent$reportGroup(linkComposer, m10021constructorimpl, z2 || z, z2 ? 0 : i + i3);
                if (z2) {
                    linkComposer.changeListWriter.endNodeMovement();
                    linkComposer.changeListWriter.moveUp();
                }
            }
            i2 = i3;
        } else {
            flagsOf = linkComposer.reader.flagsOf(group);
        }
        if ((flagsOf2 & 8388608) == 8388608) {
            return 1;
        }
        return i2;
    }

    private final void reportFreeMovableContent(long j) {
        int group = GroupHandleKt.getGroup(j);
        boolean z = (this.reader.flagsOf(group) & 8388608) == 8388608;
        if (z) {
            this.changeListWriter.endNodeMovement();
            this.changeListWriter.moveDown(this.reader.node(group));
        }
        reportFreeMovableContent$reportGroup(this, j, z, 0);
        this.changeListWriter.endNodeMovement();
        if (z) {
            this.changeListWriter.moveUp();
        }
    }

    private final void resetInsertBuilder(boolean z) {
        if (!this.builder.isClosed()) {
            SlotTable build = this.builder.build();
            if (z) {
                build.dispose();
            }
        }
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(this.slotTable.getAddressSpace(), false, false);
        slotTableBuilder.close();
        this.builder = slotTableBuilder;
    }

    private final RecomposeScopeImpl requireRecomposeScope(int i) {
        Object obj = this.reader.get(i, 0);
        if (Intrinsics.areEqual(obj, Composer.Companion.getEmpty())) {
            ComposerKt.composeImmediateRuntimeError("Cannot obtain RecomposeScope. Group does not have a corresponding slot.");
        }
        if (!(obj instanceof RecomposeScopeImpl)) {
            ComposerKt.composeImmediateRuntimeError("Expected a RecomposeScope in the first non-utility slot, found " + obj + '.');
        }
        return (RecomposeScopeImpl) obj;
    }

    private final boolean requiresRecomposition(int i) {
        return this.reader.hasRecomposeRequired(i);
    }

    private final int rGroupIndexOf(int i) {
        int firstChildOf;
        int parentOf = this.reader.parentOf(i);
        if (parentOf < 0) {
            firstChildOf = getReaderTable$runtime().getRoot();
        } else {
            firstChildOf = this.reader.firstChildOf(parentOf);
        }
        int[] groups = getReaderTable$runtime().getAddressSpace().getGroups();
        int i2 = 0;
        while (firstChildOf >= 0 && firstChildOf != i) {
            if (!this.reader.hasObjectKey(firstChildOf)) {
                i2++;
            }
            firstChildOf = groups[firstChildOf + 1];
        }
        return i2;
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodeCount();
        this.reader.skipToGroupEnd();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0166  */
    /* renamed from: start-AzEfcrM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m4436startAzEfcrM(int i, Object obj, int i2, Object obj2) {
        long rotateLeft;
        int i3;
        LinkPending linkPending;
        validateNodeNotExpected();
        int i4 = this.rGroupIndex;
        if (obj == null) {
            if (obj2 != null && i == 207 && !Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ obj2.hashCode(), 3) ^ i4;
                if (obj == null) {
                    this.rGroupIndex++;
                }
                boolean z = i2 == GroupKind.Companion.m4536getGroup9udXigM();
                LinkPending linkPending2 = null;
                if (!getInserting()) {
                    this.reader.beginEmpty();
                    SlotTableBuilder slotTableBuilder = this.builder;
                    if (z) {
                        Object empty = Composer.Companion.getEmpty();
                        SlotTableBuilder.access$startNewGroup(slotTableBuilder, i, empty == Composer.Companion.getEmpty() ? 8388608 : 25165824, empty, null, Composer.Companion.getEmpty());
                    } else if (obj2 != null) {
                        Object empty2 = obj == null ? Composer.Companion.getEmpty() : obj;
                        SlotTableBuilder.access$startNewGroup(slotTableBuilder, i, empty2 == Composer.Companion.getEmpty() ? 33554432 : 50331648, empty2, obj2, null);
                    } else {
                        Object empty3 = obj == null ? Composer.Companion.getEmpty() : obj;
                        SlotTableBuilder.access$startNewGroup(slotTableBuilder, i, empty3 == Composer.Companion.getEmpty() ? 0 : 16777216, empty3, null, null);
                    }
                    LinkPending linkPending3 = this.pending;
                    if (linkPending3 != null) {
                        KeyInfo keyInfo = new KeyInfo(i, -1, LinkComposerKt.access$toInsertAddress(slotTableBuilder.getParentHandle()), -1, 0);
                        linkPending3.registerInsert(keyInfo, this.nodeIndex - linkPending3.getStartIndex());
                        linkPending3.recordUsed(keyInfo);
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
                        i3 = -1;
                        this.pending = new LinkPending(this.reader.extractKeys(), this.nodeIndex);
                        linkPending = this.pending;
                        if (linkPending != null) {
                            KeyInfo next = linkPending.getNext(i, obj);
                            if (!z2 && next != null) {
                                linkPending.recordUsed(next);
                                long handle = next.getHandle();
                                this.nodeIndex = linkPending.nodePositionOf(next) + linkPending.getStartIndex();
                                int slotPositionOf = linkPending.slotPositionOf(next);
                                int groupIndex = slotPositionOf - linkPending.getGroupIndex();
                                linkPending.registerMoveSlot(slotPositionOf, linkPending.getGroupIndex());
                                if (groupIndex > 0) {
                                    this.reader.reposition(linkPending.groupHandleOfNextUnmovedGroup());
                                    this.changeListWriter.moveGroup(groupIndex);
                                }
                                linkPending.markGroupLocationReconciled(next.getIndex());
                                this.reader.reposition(handle);
                                startReaderGroup(z, obj2);
                            } else {
                                this.reader.beginEmpty();
                                this.inserting = true;
                                this.providerCache = null;
                                ensureBuilder();
                                SlotTableBuilder slotTableBuilder2 = this.builder;
                                if (z) {
                                    Object empty4 = Composer.Companion.getEmpty();
                                    SlotTableBuilder.access$startNewGroup(slotTableBuilder2, i, empty4 == Composer.Companion.getEmpty() ? 8388608 : 25165824, empty4, null, Composer.Companion.getEmpty());
                                } else if (obj2 != null) {
                                    Object empty5 = obj == null ? Composer.Companion.getEmpty() : obj;
                                    SlotTableBuilder.access$startNewGroup(slotTableBuilder2, i, empty5 == Composer.Companion.getEmpty() ? 33554432 : 50331648, empty5, obj2, null);
                                } else {
                                    Object empty6 = obj == null ? Composer.Companion.getEmpty() : obj;
                                    SlotTableBuilder.access$startNewGroup(slotTableBuilder2, i, empty6 == Composer.Companion.getEmpty() ? 0 : 16777216, empty6, null, null);
                                }
                                KeyInfo keyInfo2 = new KeyInfo(i, Integer.valueOf(i3), LinkComposerKt.access$toInsertAddress(slotTableBuilder2.getParentHandle()), -1, 0);
                                linkPending.registerInsert(keyInfo2, this.nodeIndex - linkPending.getStartIndex());
                                linkPending.recordUsed(keyInfo2);
                                linkPending2 = new LinkPending(new ArrayList(), z ? 0 : this.nodeIndex);
                            }
                        }
                        enterGroup(z, linkPending2);
                        return;
                    }
                }
                i3 = -1;
                linkPending = this.pending;
                if (linkPending != null) {
                }
                enterGroup(z, linkPending2);
                return;
            }
            rotateLeft = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ i, 3) ^ i4;
        } else {
            rotateLeft = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ (obj instanceof Enum ? ((Enum) obj).ordinal() : obj.hashCode()), 3);
        }
        this.compositeKeyHashCode = rotateLeft;
        if (obj == null) {
        }
        if (i2 == GroupKind.Companion.m4536getGroup9udXigM()) {
        }
        LinkPending linkPending22 = null;
        if (!getInserting()) {
        }
    }

    private final void startGroup(int i) {
        m4436startAzEfcrM(i, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    private final void startGroup(int i, Object obj) {
        m4436startAzEfcrM(i, obj, GroupKind.Companion.m4536getGroup9udXigM(), null);
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

    private final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        m4436startAzEfcrM(100, null, GroupKind.Companion.m4536getGroup9udXigM(), null);
        this.parentContext.startComposing$runtime();
        PersistentCompositionLocalMap compositionLocalScope$runtime = this.parentContext.getCompositionLocalScope$runtime();
        this.providersInvalidStack.push(LinkComposerKt.access$asInt(this.providersInvalid));
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
        m4436startAzEfcrM(Long.hashCode(this.parentContext.getCompositeKeyHashCode$runtime()), null, GroupKind.Companion.m4536getGroup9udXigM(), null);
    }

    private final List<ComposeStackTraceFrame> stackTraceForGroup(int i, Integer num) {
        if (getSourceMarkersEnabled$runtime()) {
            SlotTableReader openReader = this.slotTable.openReader();
            try {
                return SlotTableReaderKt.traceForGroup(openReader, i, num);
            } finally {
                openReader.close();
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void updateCachedValue$runtime(Object obj) {
        if (obj instanceof RememberObserver) {
            LinkRememberObserverHolder linkRememberObserverHolder = new LinkRememberObserverHolder((RememberObserver) obj, getReaderTable$runtime().getAddressSpace().anchorOfAddress(this.lastPlacedChildGroup));
            if (getInserting()) {
                this.changeListWriter.remember(linkRememberObserverHolder);
            }
            this.abandonSet.add(obj);
            obj = linkRememberObserverHolder;
        }
        updateValue(obj);
    }

    private final void updateChildNodeCount(long j, int i) {
        if (updatedNodeCount(j) != i) {
            if (LinkComposerKt.access$isInsertHandle(j)) {
                MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap(0, 1, null);
                    this.nodeCountVirtualOverrides = mutableIntIntMap;
                }
                mutableIntIntMap.set(GroupHandleKt.getGroup(j), i);
                return;
            }
            MutableIntIntMap mutableIntIntMap2 = this.nodeCountOverrides;
            if (mutableIntIntMap2 == null) {
                mutableIntIntMap2 = new MutableIntIntMap(0, 1, null);
                this.nodeCountOverrides = mutableIntIntMap2;
            }
            LinkComposerKt.access$isInsertHandle(j);
            mutableIntIntMap2.set(GroupHandleKt.getGroup(j), i);
        }
    }

    private final void updateNodeCountOverrides(long j, int i) {
        int[] groups;
        int group;
        int updatedNodeCount = updatedNodeCount(j);
        if (updatedNodeCount != i) {
            int i2 = i - updatedNodeCount;
            int m4455getSizeimpl = Stack.m4455getSizeimpl(this.pendingStack) - 1;
            while (GroupHandleKt.getGroup(j) != -1) {
                int updatedNodeCount2 = updatedNodeCount(j) + i2;
                updateChildNodeCount(j, updatedNodeCount2);
                int i3 = m4455getSizeimpl;
                while (true) {
                    if (-1 < i3) {
                        LinkPending linkPending = (LinkPending) Stack.m4460peekimpl(this.pendingStack, i3);
                        if (linkPending != null && linkPending.updateNodeCount(GroupHandleKt.getGroup(j), updatedNodeCount2)) {
                            m4455getSizeimpl = i3 - 1;
                            break;
                        }
                        i3--;
                    } else {
                        break;
                    }
                }
                if (LinkComposerKt.access$isInsertHandle(j)) {
                    j = this.reader.getParentHandle();
                } else {
                    if ((getReaderTable$runtime().getAddressSpace().getGroups()[GroupHandleKt.getGroup(j) + 4] & 8388608) == 8388608) {
                        return;
                    }
                    j = UInt.m10021constructorimpl(groups[group + 2]) & 4294967295L;
                }
            }
        }
    }

    private final void updateSlot(Object obj) {
        nextSlot$runtime();
        updateValue(obj);
    }

    private final int updatedNodeCount(long j) {
        int orDefault;
        if (LinkComposerKt.access$isInsertHandle(j)) {
            MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
            if (mutableIntIntMap != null) {
                return mutableIntIntMap.getOrDefault(GroupHandleKt.getGroup(j), 0);
            }
            return 0;
        }
        LinkComposerKt.access$isInsertHandle(j);
        int group = GroupHandleKt.getGroup(j);
        MutableIntIntMap mutableIntIntMap2 = this.nodeCountOverrides;
        return (mutableIntIntMap2 == null || (orDefault = mutableIntIntMap2.getOrDefault(group, -1)) < 0) ? getReaderTable$runtime().getAddressSpace().getGroups()[group + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK : orDefault;
    }

    private final Object unwrapRememberObserverHolder(Object obj) {
        return obj instanceof RememberObserverHolder ? ((RememberObserverHolder) obj).getWrapped() : obj;
    }

    private final <R> R withReader(SlotTableReader slotTableReader, Function0<? extends R> function0) {
        SlotTableReader slotTableReader2 = this.reader;
        MutableIntIntMap mutableIntIntMap = this.nodeCountOverrides;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            this.reader = slotTableReader;
            return function0.invoke();
        } finally {
            this.reader = slotTableReader2;
            this.nodeCountOverrides = mutableIntIntMap;
            this.providerUpdates = mutableIntObjectMap;
        }
    }

    private final void enterRecomposeScope(RecomposeScopeImpl recomposeScopeImpl) {
        recomposeScopeImpl.start(this.compositionToken);
        CompositionObserver current = this.observerHolder.current();
        if (current != null) {
            current.onScopeEnter(recomposeScopeImpl);
        }
    }

    private final Function1<Composition, Unit> exitRecomposeScope(RecomposeScopeImpl recomposeScopeImpl) {
        CompositionObserver current = this.observerHolder.current();
        if (current != null) {
            current.onScopeExit(recomposeScopeImpl);
        }
        return recomposeScopeImpl.end(this.compositionToken);
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

    /* compiled from: LinkComposer.kt */
    @Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\"\u001a\u00020#J\u0015\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0010¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0010¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0010¢\u0006\u0002\b3J*\u00108\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020#0:¢\u0006\u0002\b;H\u0011¢\u0006\u0004\b<\u0010=J8\u0010>\u001a\b\u0012\u0004\u0012\u0002020?2\u0006\u0010+\u001a\u00020,2\u0006\u0010@\u001a\u00020A2\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020#0:¢\u0006\u0002\b;H\u0011¢\u0006\u0004\bB\u0010CJ1\u0010D\u001a\b\u0012\u0004\u0012\u0002020?2\u0006\u0010+\u001a\u00020,2\u0006\u0010@\u001a\u00020A2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002020?H\u0010¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0010¢\u0006\u0002\bJJ\r\u0010N\u001a\u00020LH\u0010¢\u0006\u0002\bTJ\u000e\u0010U\u001a\u00020#2\u0006\u00101\u001a\u00020LJ\u001b\u0010V\u001a\u00020#2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0010¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020#H\u0010¢\u0006\u0002\bZJ\r\u0010[\u001a\u00020#H\u0010¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020#2\u0006\u0010^\u001a\u00020_H\u0010¢\u0006\u0002\b`J\u0015\u0010a\u001a\u00020#2\u0006\u0010^\u001a\u00020_H\u0010¢\u0006\u0002\bbJ\u0017\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010^\u001a\u00020_H\u0010¢\u0006\u0002\beJ)\u0010f\u001a\u00020#2\u0006\u0010^\u001a\u00020_2\u0006\u0010g\u001a\u00020d2\n\u0010h\u001a\u0006\u0012\u0002\b\u00030iH\u0010¢\u0006\u0002\bjJ\u0015\u0010k\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\blJ\u0016\u0010p\u001a\u00020q2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020#0:H\u0016R\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0090\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010R\u0014\u0010 \u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0014\u00104\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R+\u0010M\u001a\u00020L2\u0006\u0010K\u001a\u00020L8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010+\u001a\u00020m8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bn\u0010o¨\u0006s"}, d2 = {"Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHashCode", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "<init>", "(Landroidx/compose/runtime/LinkComposer;JZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "getCompositeKeyHashCode$runtime", "()J", "J", "getCollectingParameterInformation$runtime", "()Z", "getCollectingSourceInformation$runtime", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "inspectionTables", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "()Ljava/util/Set;", "setInspectionTables", "(Ljava/util/Set;)V", "composers", "Landroidx/compose/runtime/LinkComposer;", "getComposers", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "dispose", "", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime", "unregisterComposer", "unregisterComposer$runtime", "registerComposition", "composition", "Landroidx/compose/runtime/ControlledComposition;", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "reportPausedScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "reportPausedScope$runtime", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composeInitial", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompositionLocalScope$runtime", "updateCompositionLocalScope", "recordInspectionTable", "table", "recordInspectionTable$runtime", "startComposing", "startComposing$runtime", "doneComposing", "doneComposing$runtime", "insertMovableContent", TypedValues.Custom.S_REFERENCE, "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateResolve", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final long compositeKeyHashCode;
        private Set<Set<CompositionData>> inspectionTables;
        private final CompositionObserverHolder observerHolder;
        private final Set<LinkComposer> composers = new LinkedHashSet();
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

        public final Set<LinkComposer> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingCallByInformation$runtime() {
            return LinkComposer.this.parentContext.getCollectingCallByInformation$runtime();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getStackTraceEnabled$runtime() {
            return LinkComposer.this.parentContext.getStackTraceEnabled$runtime();
        }

        public final void dispose() {
            if (this.composers.isEmpty()) {
                return;
            }
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (LinkComposer linkComposer : this.composers) {
                    for (Set<CompositionData> set2 : set) {
                        set2.remove(linkComposer.getCompositionData());
                    }
                }
            }
            this.composers.clear();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime(Composer composer) {
            super.registerComposer$runtime(composer);
            this.composers.add(LinkComposerKt.asLinkComposer(composer));
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime(Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(LinkComposerKt.asLinkComposer(composer).getCompositionData());
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime(ControlledComposition controlledComposition) {
            LinkComposer.this.parentContext.registerComposition$runtime(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime(ControlledComposition controlledComposition) {
            LinkComposer.this.parentContext.unregisterComposition$runtime(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportPausedScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
            LinkComposer.this.parentContext.reportPausedScope$runtime(recomposeScopeImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getEffectCoroutineContext() {
            return LinkComposer.this.parentContext.getEffectCoroutineContext();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void composeInitial$runtime(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
            LinkComposer.this.parentContext.composeInitial$runtime(controlledComposition, function2);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition controlledComposition, ShouldPauseCallback shouldPauseCallback, Function2<? super Composer, ? super Integer, Unit> function2) {
            return LinkComposer.this.parentContext.composeInitialPaused$runtime(controlledComposition, shouldPauseCallback, function2);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition controlledComposition, ShouldPauseCallback shouldPauseCallback, ScatterSet<RecomposeScopeImpl> scatterSet) {
            return LinkComposer.this.parentContext.recomposePaused$runtime(controlledComposition, shouldPauseCallback, scatterSet);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime(ControlledComposition controlledComposition) {
            LinkComposer.this.parentContext.invalidate$runtime(LinkComposer.this.getComposition());
            LinkComposer.this.parentContext.invalidate$runtime(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
            LinkComposer.this.parentContext.invalidateScope$runtime(recomposeScopeImpl);
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
            LinkComposer.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime() {
            LinkComposer.this.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime(MovableContentStateReference movableContentStateReference) {
            LinkComposer.this.parentContext.insertMovableContent$runtime(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime(MovableContentStateReference movableContentStateReference) {
            LinkComposer.this.parentContext.deletedMovableContent$runtime(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference movableContentStateReference) {
            return LinkComposer.this.parentContext.movableContentStateResolve$runtime(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState, Applier<?> applier) {
            LinkComposer.this.parentContext.movableContentStateReleased$runtime(movableContentStateReference, movableContentState, applier);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime(ControlledComposition controlledComposition) {
            LinkComposer.this.parentContext.reportRemovedComposition$runtime(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public Composition getComposition$runtime() {
            return LinkComposer.this.getComposition();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CancellationHandle scheduleFrameEndCallback(Function0<Unit> function0) {
            return LinkComposer.this.parentContext.scheduleFrameEndCallback(function0);
        }
    }

    /* compiled from: LinkComposer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/LinkComposer$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "Landroidx/compose/runtime/LinkComposer;", "<init>", "(Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "onRemembered", "", "onAbandoned", "onForgotten", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
}
