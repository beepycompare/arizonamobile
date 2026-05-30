package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0015\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0001\u0018\u0000 §\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0006¥\u0001¦\u0001§\u0001B/\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fJ\b\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\u00002\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020&0)¢\u0006\u0002\b+H\u0086\bJ-\u0010,\u001a\u0002H-\"\u0004\b\u0000\u0010-2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u0002H-0)¢\u0006\u0002\b+H\u0086\b¢\u0006\u0002\u0010.J-\u0010/\u001a\u0002H-\"\u0004\b\u0000\u0010-2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002H-0)¢\u0006\u0002\b+H\u0086\b¢\u0006\u0002\u0010.J\u0006\u00101\u001a\u000200J\u000e\u00102\u001a\u00020&2\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u00020\u001bJ\u000e\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u001bJ\u0015\u00107\u001a\u00020\n2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0086\u0002J\u0011\u00107\u001a\u00020\n2\u0006\u0010:\u001a\u00020;H\u0086\u0002J\u0012\u0010<\u001a\u00020\n2\n\u0010=\u001a\u00060\u0006j\u0002`>J\u0012\u0010?\u001a\u00020\n2\n\u00108\u001a\u00060\u0006j\u0002`9J\u0016\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020;J\u0010\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0016J.\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J0H2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020I0NH\u0016J\u0012\u0010O\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020\n2\u0006\u00108\u001a\u00020\u00062\u0006\u0010:\u001a\u00020SH\u0016J\u0018\u0010@\u001a\u00020\n2\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020SH\u0016J\u0018\u0010V\u001a\u00020&2\u0006\u0010D\u001a\u00020E2\u0006\u0010W\u001a\u00020JH\u0016J\b\u0010X\u001a\u00020&H\u0016J\u0018\u0010Y\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010Z2\u0006\u0010\\\u001a\u00020\u0006H\u0016J\u0010\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020[H\u0016J\u0016\u0010_\u001a\u0004\u0018\u00010[2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0002J\u001b\u0010`\u001a\u0004\u0018\u00010[2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0002\baJA\u0010b\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`92%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bfJA\u0010g\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`92%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bhJA\u0010i\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`92%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bjJK\u0010k\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`92\b\b\u0002\u0010l\u001a\u00020\n2%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bmJ5\u0010n\u001a\u00020&2%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\boJ%\u0010p\u001a\u00020\n2\n\u0010U\u001a\u00060\u0006j\u0002`92\n\u0010T\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0002\bqJ3\u0010r\u001a\u00020&2#\u0010s\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010Q¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\buJT\u0010v\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`928\u0010s\u001a4\u0012\u0015\u0012\u0013\u0018\u00010Q¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020&0wH\u0080\b¢\u0006\u0002\byJ\u0006\u0010z\u001a\u00020\u0000J\b\u0010{\u001a\u00020&H\u0016J\b\u0010|\u001a\u00020&H\u0016J\b\u0010}\u001a\u00020~H\u0016J\u000e\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\nJ\t\u0010\u0080\u0001\u001a\u00020&H\u0016J\u0011\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0086\u0001H\u0096\u0002J\u001b\u0010\u0087\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0088\u0001J\u001b\u0010\u0089\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u00020\n2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u008c\u0001J%\u0010\u008d\u0001\u001a\u0004\u0018\u00010Q2\n\u00108\u001a\u00060\u0006j\u0002`92\u0006\u0010x\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u008e\u0001J\u001d\u0010\u008f\u0001\u001a\u0004\u0018\u00010Q2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0090\u0001J\u001d\u0010\u0091\u0001\u001a\u0004\u0018\u00010Q2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0092\u0001J\u001d\u0010\u0093\u0001\u001a\u0004\u0018\u00010Q2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0094\u0001J\u001b\u0010\u0095\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0096\u0001J\u001b\u0010\u0097\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0098\u0001J\u001b\u0010\u0099\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u009a\u0001J\u0011\u0010¡\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0\u0003H\u0016J\u000f\u0010£\u0001\u001a\u00020QH\u0000¢\u0006\u0003\b¤\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u0011\u0010#\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b$\u0010\u0015R\u001d\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0084\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0015R\u0018\u0010\u009b\u0001\u001a\u00030\u009c\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R \u0010\u009f\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010Q0 \u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001¨\u0006¨\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "Landroidx/compose/runtime/SlotStorage;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "root", "", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "recordSourceInformation", "", "recordCallByInformation", "<init>", "(ILandroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;ZZ)V", "getRoot", "()I", "setRoot", "(I)V", "getAddressSpace", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "getRecordSourceInformation", "()Z", "setRecordSourceInformation", "(Z)V", "getRecordCallByInformation", "setRecordCallByInformation", "currentEditor", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "openReaders", "rootHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "value", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "getVersion", "hasEditor", "getHasEditor", "dispose", "", "buildSubTable", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "Lkotlin/ExtensionFunctionType;", "edit", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "read", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "openReader", "closeReader", "reader", "openEditor", "closeEditor", "editor", "contains", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "anchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "containsFlags", DownloaderServiceMarshaller.PARAMS_FLAGS, "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "hasRecomposeScopes", "inGroup", "groupAnchor", "childAnchor", "clear", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "deactivateAll", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "find", "identityToFind", "", "groupContainsAnchor", "Landroidx/compose/runtime/Anchor;", "parent", "child", "disposeUnusedMovableContent", RemoteConfigConstants.ResponseFieldKey.STATE, "invalidateAll", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", TypedValues.AttributesType.S_TARGET, "ownsRecomposeScope", "scope", "findEffectiveRecomposeScope", "getRecomposeScopeOrNull", "getRecomposeScopeOrNull$runtime", "traverseSiblings", "visit", "Lkotlin/ParameterName;", "name", "traverseSiblings$runtime", "traverseGroupAndParents", "traverseGroupAndParents$runtime", "traverseChildren", "traverseChildren$runtime", "traverseGroup", "includeSiblingsOfStartGroup", "traverseGroup$runtime", "traverseTable", "traverseTable$runtime", "isGroupAChildOf", "isGroupAChildOf$runtime", "forEachSlot", "action", "slot", "forEachSlot$runtime", "forEachGroupSlot", "Lkotlin/Function2;", FirebaseAnalytics.Param.INDEX, "forEachGroupSlot$runtime", "newTableInSameAddressSpace", "collectSourceInformation", "collectCalledByInformation", "toDebugString", "", "includeSlots", "verifyWellFormed", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "isEmpty", "iterator", "", "nextSiblingOf", "nextSiblingOf$runtime", "firstChildOf", "firstChildOf$runtime", "groupHasAux", "groupHasAux$runtime", "groupSlotAtIndex", "groupSlotAtIndex$runtime", "groupObjectKey", "groupObjectKey$runtime", "groupAux", "groupAux$runtime", "groupNode", "groupNode$runtime", "groupKeyOf", "groupKeyOf$runtime", "groupSlotRange", "groupSlotRange$runtime", "groupFlags", "groupFlags$runtime", "groups", "", "getGroups", "()[I", "slots", "", "getSlots", "()[Ljava/lang/Object;", "toDebugTree", "toDebugTree$runtime", "DebugGroup", "DebugSlotRange", "Companion", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTable extends SlotStorage implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    private final SlotTableAddressSpace addressSpace;
    private SlotTableEditor currentEditor;
    private int openReaders;
    private boolean recordCallByInformation;
    private boolean recordSourceInformation;
    private int root;
    private int version;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SlotTable() {
        this(0, null, false, false, 15, null);
    }

    public SlotTable(int i, SlotTableAddressSpace slotTableAddressSpace, boolean z, boolean z2) {
        this.root = i;
        this.addressSpace = slotTableAddressSpace;
        this.recordSourceInformation = z;
        this.recordCallByInformation = z2;
    }

    public final int getRoot() {
        return this.root;
    }

    public final void setRoot(int i) {
        this.root = i;
    }

    public /* synthetic */ SlotTable(int i, SlotTableAddressSpace slotTableAddressSpace, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? new SlotTableAddressSpace() : slotTableAddressSpace, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2);
    }

    public final SlotTableAddressSpace getAddressSpace() {
        return this.addressSpace;
    }

    public final boolean getRecordSourceInformation() {
        return this.recordSourceInformation;
    }

    public final void setRecordSourceInformation(boolean z) {
        this.recordSourceInformation = z;
    }

    public final boolean getRecordCallByInformation() {
        return this.recordCallByInformation;
    }

    public final void setRecordCallByInformation(boolean z) {
        this.recordCallByInformation = z;
    }

    public final long rootHandle() {
        return (UInt.m9943constructorimpl(this.root) & 4294967295L) | (-4294967296L);
    }

    public final int getVersion() {
        return this.version;
    }

    public final boolean getHasEditor() {
        return this.currentEditor != null;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void dispose() {
        int i = this.root;
        if (i != -1) {
            this.addressSpace.freeGroupTree(i);
            this.root = -1;
        }
    }

    public final SlotTable buildSubTable(Function1<? super SlotTableBuilder, Unit> function1) {
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(getAddressSpace(), false, false);
        slotTableBuilder.buildStart();
        function1.invoke(slotTableBuilder);
        return slotTableBuilder.build();
    }

    public final <T> T edit(Function1<? super SlotTableEditor, ? extends T> function1) {
        SlotTableEditor openEditor = openEditor();
        try {
            return function1.invoke(openEditor);
        } finally {
            openEditor.close();
        }
    }

    public final <T> T read(Function1<? super SlotTableReader, ? extends T> function1) {
        SlotTableReader openReader = openReader();
        try {
            return function1.invoke(openReader);
        } finally {
            openReader.close();
        }
    }

    public final SlotTableReader openReader() {
        if (getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while a writer is pending");
        }
        this.openReaders++;
        return new SlotTableReader(this);
    }

    public final void closeReader(SlotTableReader slotTableReader) {
        if (!(slotTableReader.getTable() == this && this.openReaders > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }
        this.openReaders--;
    }

    public final SlotTableEditor openEditor() {
        if (getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (!(this.openReaders <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.version++;
        SlotTableEditor slotTableEditor = new SlotTableEditor(this);
        this.currentEditor = slotTableEditor;
        return slotTableEditor;
    }

    public final void closeEditor(SlotTableEditor slotTableEditor) {
        if (!(this.currentEditor == slotTableEditor)) {
            ComposerKt.composeImmediateRuntimeError("Attempted to close an editor that was not the current editor");
        }
        this.currentEditor = null;
    }

    public final boolean contains(int i) {
        if (i >= 0 && this.addressSpace.contains(i)) {
            int[] groups = this.addressSpace.getGroups();
            int i2 = groups[i + 2];
            while (true) {
                if (i2 <= 0) {
                    if (!(i2 != 0)) {
                        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
                    }
                } else if (i2 == this.root) {
                    return true;
                } else {
                    i2 = groups[i2 + 2];
                }
            }
        }
        return false;
    }

    public final boolean contains(LinkAnchor linkAnchor) {
        return linkAnchor.getValid() && this.addressSpace.ownsAnchor(linkAnchor) && contains(linkAnchor.getAddress());
    }

    public final boolean containsFlags(int i) {
        return !isEmpty() && (this.addressSpace.getGroups()[this.root + 4] & i) == i;
    }

    public final boolean hasRecomposeScopes(int i) {
        int i2;
        int[] groups = this.addressSpace.getGroups();
        Object[] slots = this.addressSpace.getSlots();
        SlotTableAddressSpace addressSpace = getAddressSpace();
        if (i >= 0) {
            IntStack intStack = new IntStack();
            int[] groups2 = addressSpace.getGroups();
            int i3 = i;
            while (SlotTableKt.access$recomposeScopeOrNullInRegion(slots, groups[i3 + 5]) == null) {
                if (i3 != i && (i2 = groups2[i3 + 1]) >= 0) {
                    intStack.push(i2);
                }
                i3 = groups2[i3 + 3];
                if (i3 < 0) {
                    if (intStack.tos == 0) {
                        return false;
                    }
                    i3 = intStack.pop();
                }
            }
            return true;
        }
        return false;
    }

    public final boolean inGroup(LinkAnchor linkAnchor, LinkAnchor linkAnchor2) {
        if (linkAnchor.getValid() && linkAnchor2.getValid()) {
            if (Intrinsics.areEqual(linkAnchor, linkAnchor2)) {
                return true;
            }
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            if (slotTableAddressSpace.ownsAnchor(linkAnchor2) && slotTableAddressSpace.ownsAnchor(linkAnchor)) {
                int address = linkAnchor.getAddress();
                int address2 = linkAnchor2.getAddress();
                if (slotTableAddressSpace.contains(address) && slotTableAddressSpace.contains(address2)) {
                    int[] groups = slotTableAddressSpace.getGroups();
                    int i = groups[address2 + 2];
                    while (i > 0) {
                        if (i == address) {
                            return true;
                        }
                        if (address <= 0) {
                            return false;
                        }
                        i = groups[i + 2];
                    }
                    if (!(i != 0)) {
                        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + address2);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates(Applier<?> applier, ObjectList<MovableContentStateReference> objectList) {
        MutableScatterMap mutableScatterMapOf = ScatterMapKt.mutableScatterMapOf();
        SlotTableEditor openEditor = openEditor();
        try {
            Object[] objArr = objectList.content;
            int i = objectList._size;
            for (int i2 = 0; i2 < i; i2++) {
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr[i2];
                LinkAnchor asLinkAnchor = LinkAnchorKt.asLinkAnchor(movableContentStateReference.getAnchor$runtime());
                if (openEditor.getTable().contains(asLinkAnchor)) {
                    openEditor.seek(asLinkAnchor);
                    mutableScatterMapOf.set(movableContentStateReference, SlotTableKt.access$extractMovableContentAtCurrent(movableContentStateReference.getComposition$runtime(), movableContentStateReference, openEditor, applier));
                }
            }
            Unit unit = Unit.INSTANCE;
            openEditor.close();
            return mutableScatterMapOf;
        } catch (Throwable th) {
            openEditor.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object obj) {
        return new SlotTableGroup(this, this.root, this.version).find(obj);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean groupContainsAnchor(int i, Anchor anchor) {
        LinkAnchor asLinkAnchor = LinkAnchorKt.asLinkAnchor(anchor);
        return this.addressSpace.ownsAnchor(asLinkAnchor) && isGroupAChildOf$runtime(asLinkAnchor.getAddress(), i);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean inGroup(Anchor anchor, Anchor anchor2) {
        return inGroup(LinkAnchorKt.asLinkAnchor(anchor), LinkAnchorKt.asLinkAnchor(anchor2));
    }

    @Override // androidx.compose.runtime.SlotStorage
    public List<RecomposeScopeImpl> invalidateGroupsWithKey(int i) {
        boolean z;
        boolean z2;
        int i2;
        RecomposeScopeImpl findEffectiveRecomposeScope;
        LinkAnchor asLinkAnchor;
        MutableIntSet mutableIntSet;
        int i3 = 0;
        boolean z3 = true;
        MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
        ArrayList arrayList = new ArrayList();
        MutableIntSet mutableIntSet3 = new MutableIntSet(0, 1, null);
        mutableIntSet3.add(i);
        mutableIntSet3.add(-3);
        MutableIntObjectMap<MutableIntSet> calledByMap$runtime = this.addressSpace.getCalledByMap$runtime();
        if (calledByMap$runtime != null && (mutableIntSet = calledByMap$runtime.get(i)) != null) {
            mutableIntSet3.addAll(mutableIntSet);
        }
        int i4 = this.root;
        SlotTableAddressSpace addressSpace = getAddressSpace();
        if (i4 >= 0) {
            IntStack intStack = new IntStack();
            int[] groups = addressSpace.getGroups();
            int i5 = i4;
            while (true) {
                int i6 = this.addressSpace.getGroups()[i5];
                if (mutableIntSet3.contains(i6)) {
                    if (i6 != -3) {
                        mutableIntSet2.plusAssign(i5);
                    }
                    if (z3) {
                        RecomposeScopeImpl findEffectiveRecomposeScope2 = findEffectiveRecomposeScope(i5);
                        if (findEffectiveRecomposeScope2 != null) {
                            ArrayList arrayList2 = arrayList;
                            arrayList2.add(findEffectiveRecomposeScope2);
                            Anchor anchor = findEffectiveRecomposeScope2.getAnchor();
                            Integer valueOf = (anchor == null || (asLinkAnchor = LinkAnchorKt.asLinkAnchor(anchor)) == null) ? null : Integer.valueOf(asLinkAnchor.getAddress());
                            if (valueOf != null && valueOf.intValue() == i5 && (findEffectiveRecomposeScope = findEffectiveRecomposeScope(this.addressSpace.getGroups()[i5 + 2])) != null) {
                                arrayList2.add(findEffectiveRecomposeScope);
                            }
                        } else {
                            arrayList.clear();
                            z3 = false;
                        }
                    }
                }
                if (i5 != i4 && (i2 = groups[i5 + 1]) >= 0) {
                    intStack.push(i2);
                }
                i5 = groups[i5 + 3];
                if (i5 < 0) {
                    if (intStack.tos == 0) {
                        break;
                    }
                    i5 = intStack.pop();
                }
            }
        }
        SlotTableEditor openEditor = openEditor();
        try {
            MutableIntSet mutableIntSet4 = mutableIntSet2;
            int[] iArr = mutableIntSet4.elements;
            long[] jArr = mutableIntSet4.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i7 = 0;
                while (true) {
                    long j = jArr[i7];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i8 = 8 - ((~(i7 - length)) >>> 31);
                        int i9 = i3;
                        while (i9 < i8) {
                            if ((255 & j) < 128) {
                                z2 = z3;
                                openEditor.seek(UInt.m9943constructorimpl(iArr[(i7 << 3) + i9]) & 4294967295L);
                                openEditor.bashGroup$runtime(-3);
                            } else {
                                z2 = z3;
                            }
                            j >>= 8;
                            i9++;
                            z3 = z2;
                        }
                        z = z3;
                        if (i8 != 8) {
                            break;
                        }
                    } else {
                        z = z3;
                    }
                    if (i7 == length) {
                        break;
                    }
                    i7++;
                    z3 = z;
                    i3 = 0;
                }
            } else {
                z = z3;
            }
            Unit unit = Unit.INSTANCE;
            if (z) {
                return arrayList;
            }
            return null;
        } finally {
            openEditor.close();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean ownsRecomposeScope(RecomposeScopeImpl recomposeScopeImpl) {
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor != null) {
            LinkAnchor asLinkAnchor = LinkAnchorKt.asLinkAnchor(anchor);
            if (this.addressSpace.ownsAnchor(asLinkAnchor) && isGroupAChildOf$runtime(asLinkAnchor.getAddress(), this.root)) {
                return true;
            }
        }
        return false;
    }

    public final RecomposeScopeImpl getRecomposeScopeOrNull$runtime(int i) {
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int[] groups = slotTableAddressSpace.getGroups();
        Object[] slots = slotTableAddressSpace.getSlots();
        int i2 = groups[i + 5];
        if (i2 == -1) {
            return null;
        }
        int i3 = (i2 & 15) + 1;
        int i4 = i2 >> 4;
        if (i3 > 15) {
            i3 = slotTableAddressSpace.getLargeSizes().get(i4);
        }
        int i5 = i3 + i4;
        int utilitySlotsCountForFlags = i4 + GroupFlagsKt.utilitySlotsCountForFlags(groups[i + 4]);
        if (utilitySlotsCountForFlags <= i5) {
            Object obj = slots[utilitySlotsCountForFlags];
            if (obj instanceof RecomposeScopeImpl) {
                return (RecomposeScopeImpl) obj;
            }
        }
        return null;
    }

    public final void traverseSiblings$runtime(int i, Function1<? super Integer, Unit> function1) {
        int[] groups = getAddressSpace().getGroups();
        while (i >= 0) {
            function1.invoke(Integer.valueOf(i));
            i = groups[i + 1];
        }
    }

    public final void traverseGroupAndParents$runtime(int i, Function1<? super Integer, Unit> function1) {
        int[] groups = getAddressSpace().getGroups();
        int i2 = i;
        while (i2 > 0) {
            function1.invoke(Integer.valueOf(i2));
            i2 = groups[i2 + 2];
        }
        if (i2 != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
    }

    public final void traverseChildren$runtime(int i, Function1<? super Integer, Unit> function1) {
        int[] groups = getAddressSpace().getGroups();
        for (int i2 = groups[i + 3]; i2 > 0; i2 = groups[i2 + 1]) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    public static /* synthetic */ void traverseGroup$runtime$default(SlotTable slotTable, int i, boolean z, Function1 function1, int i2, Object obj) {
        int i3;
        if ((i2 & 2) != 0) {
            z = false;
        }
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        int i4 = i;
        while (true) {
            function1.invoke(Integer.valueOf(i4));
            if ((i4 != i || z) && (i3 = groups[i4 + 1]) >= 0) {
                intStack.push(i3);
            }
            i4 = groups[i4 + 3];
            if (i4 < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                i4 = intStack.pop();
            }
        }
    }

    public final void traverseGroup$runtime(int i, boolean z, Function1<? super Integer, Unit> function1) {
        int i2;
        SlotTableAddressSpace addressSpace = getAddressSpace();
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        int i3 = i;
        while (true) {
            function1.invoke(Integer.valueOf(i3));
            if ((i3 != i || z) && (i2 = groups[i3 + 1]) >= 0) {
                intStack.push(i2);
            }
            i3 = groups[i3 + 3];
            if (i3 < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                i3 = intStack.pop();
            }
        }
    }

    public final void traverseTable$runtime(Function1<? super Integer, Unit> function1) {
        SlotTableAddressSpace addressSpace = getAddressSpace();
        int root = getRoot();
        if (root < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        while (true) {
            function1.invoke(Integer.valueOf(root));
            int i = groups[root + 1];
            if (i >= 0) {
                intStack.push(i);
            }
            root = groups[root + 3];
            if (root < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                root = intStack.pop();
            }
        }
    }

    public final void forEachSlot$runtime(Function1<Object, Unit> function1) {
        if (getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while an editor is pending");
        }
        SlotTableAddressSpace addressSpace = getAddressSpace();
        int root = getRoot();
        if (root < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        while (true) {
            int i = getGroups()[root + 5];
            if (i != -1) {
                SlotTableAddressSpace addressSpace2 = getAddressSpace();
                int i2 = (i & 15) + 1;
                int i3 = i >> 4;
                if (i2 > 15) {
                    i2 = addressSpace2.getLargeSizes().get(i3);
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj = getSlots()[i3 + i4];
                    if (Intrinsics.areEqual(obj, Composer.Companion.getEmpty())) {
                        break;
                    }
                    function1.invoke(obj);
                }
            }
            int i5 = groups[root + 1];
            if (i5 >= 0) {
                intStack.push(i5);
            }
            root = groups[root + 3];
            if (root < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                root = intStack.pop();
            }
        }
    }

    public final void forEachGroupSlot$runtime(int i, Function2<Object, ? super Integer, Unit> function2) {
        int i2 = getGroups()[i + 5];
        if (i2 != -1) {
            SlotTableAddressSpace addressSpace = getAddressSpace();
            int i3 = (i2 & 15) + 1;
            int i4 = i2 >> 4;
            if (i3 > 15) {
                i3 = addressSpace.getLargeSizes().get(i4);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                Object obj = getSlots()[i4 + i5];
                if (Intrinsics.areEqual(obj, Composer.Companion.getEmpty())) {
                    return;
                }
                function2.invoke(obj, Integer.valueOf(i5));
            }
        }
    }

    public final SlotTable newTableInSameAddressSpace() {
        return new SlotTable(0, this.addressSpace, this.recordSourceInformation, this.recordCallByInformation, 1, null);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void collectSourceInformation() {
        this.recordSourceInformation = true;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void collectCalledByInformation() {
        this.recordCallByInformation = true;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public String toDebugString() {
        return toDebugString(true);
    }

    public final String toDebugString(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("SlotTable(\n");
        int[] groups = getAddressSpace().getGroups();
        for (int i = this.root; i >= 0; i = groups[i + 1]) {
            toDebugString$lambda$0$dumpGroup(sb, this, z, i, "  ");
        }
        sb.append(")");
        return sb.toString();
    }

    private static final void toDebugString$lambda$0$dumpGroup(StringBuilder sb, SlotTable slotTable, boolean z, int i, String str) {
        int i2;
        sb.append(str);
        int[] groups = slotTable.addressSpace.getGroups();
        sb.append("Group(" + i + ") key: " + groups[i]);
        Object[] slots = slotTable.addressSpace.getSlots();
        int i3 = groups[i + 5];
        int i4 = groups[i + 4];
        int i5 = 8388607 & i4;
        if (i5 > 0) {
            sb.append(" Nodes: ");
            sb.append(i5);
        }
        if (((-67108864) & i4) != 0) {
            sb.append(" Marks: ");
            if ((i4 & 268435456) == 268435456) {
                sb.append('C');
            }
            if ((i4 & 536870912) == 536870912) {
                sb.append('c');
            }
            if ((i4 & 1073741824) == 1073741824) {
                sb.append('S');
            }
            if ((i4 & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                sb.append('s');
            }
            if ((i4 & 67108864) == 67108864) {
                sb.append('R');
            }
            if ((i4 & 134217728) == 134217728) {
                sb.append('r');
            }
        }
        if (z) {
            int i6 = i3 >> 4;
            if (i3 != -1) {
                SlotTableAddressSpace slotTableAddressSpace = slotTable.addressSpace;
                if (i3 == -1) {
                    i2 = 0;
                } else {
                    i2 = (i3 & 15) + 1;
                    if (i2 > 15) {
                        i2 = slotTableAddressSpace.getLargeSizes().get(i6);
                    }
                }
                int i7 = i2 + i6;
                if ((i4 & 8388608) == 8388608) {
                    sb.append(" Node: ");
                    sb.append(SlotTableKt.access$summarize(slots[i6], 10));
                    i6++;
                }
                if ((i4 & 16777216) == 16777216) {
                    sb.append(" Key: ");
                    sb.append(SlotTableKt.access$summarize(slots[i6], 10));
                    i6++;
                }
                if ((i4 & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
                    sb.append(" Aux: ");
                    sb.append(SlotTableKt.access$summarize(slots[i6], 10));
                    i6++;
                }
                if (i6 < i7) {
                    sb.append(" (" + i6 + '-' + i7 + ")[");
                    while (i6 < i7) {
                        int i8 = i6 + 1;
                        sb.append(SlotTableKt.access$summarize(slots[i6], 10));
                        if (i8 < i7) {
                            sb.append(", ");
                        }
                        i6 = i8;
                    }
                    sb.append("]");
                }
            }
        }
        sb.append(AbstractJsonLexerKt.COLON).append('\n');
        String str2 = str + "  ";
        int[] groups2 = slotTable.getAddressSpace().getGroups();
        for (int i9 = groups2[i + 3]; i9 > 0; i9 = groups2[i9 + 1]) {
            toDebugString$lambda$0$dumpGroup(sb, slotTable, z, i9, str2);
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void verifyWellFormed() {
        this.addressSpace.validate();
        int[] groups = this.addressSpace.getGroups();
        Object[] slots = this.addressSpace.getSlots();
        MutableIntSet mutableIntSetOf = IntSetKt.mutableIntSetOf();
        int i = this.root;
        int[] groups2 = getAddressSpace().getGroups();
        for (int i2 = i; i2 >= 0; i2 = groups2[i2 + 1]) {
            verifyWellFormed$validateGroup(mutableIntSetOf, groups, this, slots, -1, i2);
        }
    }

    private static final void verifyWellFormed$validateSlotRange(SlotTable slotTable, Object[] objArr, int i, int i2) {
        if (i2 == -1) {
            return;
        }
        SlotTableAddressSpace slotTableAddressSpace = slotTable.addressSpace;
        int i3 = (i2 & 15) + 1;
        int i4 = i2 >> 4;
        if (i3 > 15) {
            slotTableAddressSpace.getLargeSizes().get(i4);
        }
        if (i4 < 0 || i4 >= objArr.length) {
            throw new IllegalStateException(("Slot index for group " + i + " out of bounds: " + i4).toString());
        }
    }

    private static final int verifyWellFormed$validateGroup(MutableIntSet mutableIntSet, int[] iArr, SlotTable slotTable, Object[] objArr, int i, int i2) {
        if (i2 == -1) {
            return 0;
        }
        if (mutableIntSet.contains(i2)) {
            throw new IllegalStateException(("Circular group encountered at " + i2).toString());
        }
        mutableIntSet.add(i2);
        if (i2 % 6 == 0) {
            if (iArr[i2 + 2] == i) {
                SlotTable slotTable2 = slotTable;
                Object[] objArr2 = objArr;
                verifyWellFormed$validateSlotRange(slotTable2, objArr2, i2, iArr[i2 + 5]);
                int i3 = i2 + 4;
                int i4 = iArr[i3] & GroupFlagsKt.HasMarkFlags;
                int[] groups = slotTable2.getAddressSpace().getGroups();
                int i5 = groups[i2 + 3];
                int i6 = 0;
                int i7 = 0;
                while (i5 > 0) {
                    i6 += verifyWellFormed$validateGroup(mutableIntSet, iArr, slotTable2, objArr2, i2, i5);
                    int propagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(iArr[i5 + 4]);
                    i7 |= propagatingFlagsOf;
                    if (propagatingFlagsOf != 0 && (i4 & propagatingFlagsOf) == 0) {
                        StringBuilder append = new StringBuilder("Group ").append(i5).append(" contains a flag that the parent, ").append(i2).append(", is not recorded as having, ");
                        String num = Integer.toString(propagatingFlagsOf, CharsKt.checkRadix(16));
                        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                        throw new IllegalStateException(append.append(num).append(' ').append(SlotTableKt.access$flagsNames(propagatingFlagsOf)).toString().toString());
                    }
                    i5 = groups[i5 + 1];
                    slotTable2 = slotTable;
                    objArr2 = objArr;
                }
                int i8 = iArr[i3];
                int i9 = i8 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
                if (i9 == i6) {
                    if (i4 == i7) {
                        if ((i8 & 8388608) == 8388608) {
                            return 1;
                        }
                        return i8 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
                    }
                    StringBuilder append2 = new StringBuilder("Unexpected has mark flags for group ").append(i2).append(", expected ");
                    String num2 = Integer.toString(i7, CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                    StringBuilder append3 = append2.append(num2).append(' ').append(SlotTableKt.access$flagsNames(i7)).append(", received ");
                    String num3 = Integer.toString(i4, CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(num3, "toString(...)");
                    throw new IllegalStateException(append3.append(num3).append(' ').append(SlotTableKt.access$flagsNames(i4)).toString().toString());
                }
                throw new IllegalStateException(("Unexpected node count for group " + i2 + ", expected " + i6 + ", received: " + i9).toString());
            }
            throw new IllegalStateException(("Invalid parent link in group " + i2).toString());
        }
        throw new IllegalStateException(("Invalid group address: " + i2).toString());
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @Override // androidx.compose.runtime.SlotStorage, androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.root == -1;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, this.root);
    }

    public final int nextSiblingOf$runtime(int i) {
        return getGroups()[i + 1];
    }

    public final int firstChildOf$runtime(int i) {
        return getGroups()[i + 3];
    }

    public final boolean groupHasAux$runtime(int i) {
        return (getGroups()[i + 4] & GroupFlagsKt.HasAuxSlotFlag) == 33554432;
    }

    public final Object groupSlotAtIndex$runtime(int i, int i2) {
        int i3 = i + 5;
        if (getGroups()[i3] != -1 && i2 >= 0) {
            int i4 = getGroups()[i3];
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i5 = (i4 & 15) + 1;
            int i6 = i4 >> 4;
            if (i5 > 15) {
                i5 = slotTableAddressSpace.getLargeSizes().get(i6);
            }
            if (i2 >= i5) {
                return null;
            }
            return getSlots()[i6 + i2];
        }
        return null;
    }

    public final Object groupObjectKey$runtime(int i) {
        int i2 = getGroups()[i + 4];
        if ((i2 & 16777216) == 16777216) {
            return groupSlotAtIndex$runtime(i, Integer.bitCount(i2 & 8388608));
        }
        return null;
    }

    public final Object groupAux$runtime(int i) {
        int i2 = getGroups()[i + 4];
        if ((i2 & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
            return groupSlotAtIndex$runtime(i, Integer.bitCount(i2 & 25165824));
        }
        return null;
    }

    public final Object groupNode$runtime(int i) {
        if ((getGroups()[i + 4] & 8388608) == 8388608) {
            return groupSlotAtIndex$runtime(i, 0);
        }
        return null;
    }

    public final int groupKeyOf$runtime(int i) {
        return getGroups()[i];
    }

    public final int groupSlotRange$runtime(int i) {
        return getGroups()[i + 5];
    }

    public final int groupFlags$runtime(int i) {
        return getGroups()[i + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] getGroups() {
        return this.addressSpace.getGroups();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] getSlots() {
        return this.addressSpace.getSlots();
    }

    @Override // androidx.compose.runtime.SlotStorage
    /* renamed from: getSlots  reason: collision with other method in class */
    public Iterable<Object> mo4618getSlots() {
        return new SlotTable$getSlots$1(this);
    }

    public final Object toDebugTree$runtime() {
        List list = SequencesKt.toList(SequencesKt.sequence(new SlotTable$toDebugTree$1(this, null)));
        return list.size() == 1 ? CollectionsKt.first((List<? extends Object>) list) : list;
    }

    /* compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010+\u001a\u00020,H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\bR\u0015\u0010\u0014\u001a\u00060\u0015R\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0011\u0010\"\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b$\u0010!R\u0011\u0010%\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b'\u0010!R\u0011\u0010(\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b(\u0010!R\u0011\u0010)\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b*\u0010!¨\u0006-"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugGroup;", "", "address", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getAddress", "()I", "children", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getChildren", "()Ljava/util/List;", "slots", "getSlots", "key", "getKey", DownloaderServiceMarshaller.PARAMS_FLAGS, "getFlags", "slotRange", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "getSlotRange", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "objectKey", "getObjectKey", "()Ljava/lang/Object;", "node", "getNode", "aux", "getAux", "isNode", "", "()Z", "isMovableContent", "hasMovableContent", "getHasMovableContent", "isSubComposition", "hasSubComposition", "getHasSubComposition", "isRecomposeRequired", "hasRecomposeRequired", "getHasRecomposeRequired", "toString", "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class DebugGroup {
        private final int address;

        public DebugGroup(int i) {
            this.address = i;
        }

        public final int getAddress() {
            return this.address;
        }

        public final List<DebugGroup> getChildren() {
            return SequencesKt.toList(SequencesKt.sequence(new SlotTable$DebugGroup$children$1(SlotTable.this, this, null)));
        }

        public final List<Object> getSlots() {
            return SequencesKt.toList(SequencesKt.sequence(new SlotTable$DebugGroup$slots$1(this, SlotTable.this, null)));
        }

        public final int getKey() {
            return SlotTable.this.getGroups()[this.address];
        }

        public final int getFlags() {
            return SlotTable.this.getGroups()[this.address + 4];
        }

        public final DebugSlotRange getSlotRange() {
            SlotTable slotTable = SlotTable.this;
            return new DebugSlotRange(slotTable.getGroups()[this.address + 5]);
        }

        public final Object getObjectKey() {
            if ((getFlags() & 16777216) == 16777216) {
                return SlotTable.this.getSlots()[getSlotRange().getAddress() + Integer.bitCount(getFlags() & 8388608)];
            }
            return Composer.Companion.getEmpty();
        }

        public final Object getNode() {
            if ((getFlags() & 8388608) == 8388608) {
                Object[] slots = SlotTable.this.getSlots();
                int address = getSlotRange().getAddress();
                getFlags();
                return slots[address];
            }
            return Composer.Companion.getEmpty();
        }

        public final Object getAux() {
            if ((getFlags() & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
                return SlotTable.this.getSlots()[getSlotRange().getAddress() + Integer.bitCount(getFlags() & 25165824)];
            }
            return Composer.Companion.getEmpty();
        }

        public final boolean isNode() {
            return (getFlags() & 8388608) == 8388608;
        }

        public final boolean isMovableContent() {
            return (getFlags() & 268435456) == 268435456;
        }

        public final boolean getHasMovableContent() {
            return (getFlags() & 536870912) == 536870912;
        }

        public final boolean isSubComposition() {
            return (getFlags() & 67108864) == 67108864;
        }

        public final boolean getHasSubComposition() {
            return (getFlags() & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        }

        public final boolean isRecomposeRequired() {
            return (getFlags() & 67108864) == 67108864;
        }

        public final boolean getHasRecomposeRequired() {
            return (getFlags() & 134217728) == 134217728;
        }

        public String toString() {
            SlotTable slotTable = SlotTable.this;
            StringBuilder sb = new StringBuilder("Group(");
            sb.append(getKey());
            if ((getFlags() & (-67108864)) != 0) {
                sb.append(", flags=");
                if (isMovableContent()) {
                    sb.append('C');
                }
                if (getHasMovableContent()) {
                    sb.append('c');
                }
                if (isSubComposition()) {
                    sb.append('S');
                }
                if (getHasSubComposition()) {
                    sb.append('s');
                }
                if (isRecomposeRequired()) {
                    sb.append('R');
                }
                if (getHasRecomposeRequired()) {
                    sb.append('r');
                }
            }
            if ((getFlags() & 16777216) == 16777216) {
                sb.append(", object key");
            }
            if ((getFlags() & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
                sb.append(", aux");
            }
            if (isNode()) {
                sb.append(", node");
            }
            int[] groups = slotTable.getGroups();
            int i = this.address;
            if (groups[i + 3] != -1) {
                int[] groups2 = slotTable.getAddressSpace().getGroups();
                int i2 = 0;
                for (int i3 = groups2[i + 3]; i3 > 0; i3 = groups2[i3 + 1]) {
                    i2++;
                }
                sb.append(", ");
                sb.append(i2);
                sb.append(i2 == 1 ? " child" : " children");
            }
            if (slotTable.getGroups()[this.address + 5] != -1) {
                sb.append(", ");
                sb.append(getSlotRange().getSize());
                sb.append(" slots");
            }
            sb.append(')');
            return sb.toString();
        }
    }

    /* compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "", "range", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getRange", "()I", "address", "getAddress", "size", "getSize", TtmlNode.END, "getEnd", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class DebugSlotRange {
        private final int range;

        public DebugSlotRange(int i) {
            this.range = i;
        }

        public final int getRange() {
            return this.range;
        }

        public final int getAddress() {
            return this.range >> 4;
        }

        public final int getSize() {
            SlotTableAddressSpace addressSpace = SlotTable.this.getAddressSpace();
            int i = this.range;
            if (i == -1) {
                return 0;
            }
            int i2 = (i & 15) + 1;
            return i2 > 15 ? addressSpace.getLargeSizes().get(i >> 4) : i2;
        }

        public final int getEnd() {
            return getAddress() + getSize();
        }
    }

    /* compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0086\b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$Companion;", "", "<init>", "()V", "build", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "", "Lkotlin/ExtensionFunctionType;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SlotTable build$default(Companion companion, SlotTableAddressSpace slotTableAddressSpace, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                slotTableAddressSpace = new SlotTableAddressSpace();
            }
            SlotTableBuilder slotTableBuilder = new SlotTableBuilder(slotTableAddressSpace, false, false);
            slotTableBuilder.buildStart();
            function1.invoke(slotTableBuilder);
            return slotTableBuilder.build();
        }

        public final SlotTable build(SlotTableAddressSpace slotTableAddressSpace, Function1<? super SlotTableBuilder, Unit> function1) {
            SlotTableBuilder slotTableBuilder = new SlotTableBuilder(slotTableAddressSpace, false, false);
            slotTableBuilder.buildStart();
            function1.invoke(slotTableBuilder);
            return slotTableBuilder.build();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void clear(RememberManager rememberManager) {
        SlotTableEditor openEditor = openEditor();
        try {
            SlotTableKt.removeCurrentGroup(openEditor, rememberManager);
            Unit unit = Unit.INSTANCE;
        } finally {
            openEditor.close();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void deactivateAll(RememberManager rememberManager) {
        SlotTableEditor openEditor = openEditor();
        try {
            SlotTableKt.deactivateCurrentGroup(openEditor, rememberManager);
            Unit unit = Unit.INSTANCE;
        } finally {
            openEditor.close();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void disposeUnusedMovableContent(RememberManager rememberManager, MovableContentState movableContentState) {
        SlotTableEditor openEditor = openEditor();
        try {
            SlotTableKt.removeCurrentGroup(openEditor, rememberManager);
            Unit unit = Unit.INSTANCE;
        } finally {
            openEditor.close();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void invalidateAll() {
        if (getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while an editor is pending");
        }
        SlotTableAddressSpace addressSpace = getAddressSpace();
        int root = getRoot();
        if (root < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        while (true) {
            int i = getGroups()[root + 5];
            if (i != -1) {
                SlotTableAddressSpace addressSpace2 = getAddressSpace();
                int i2 = (i & 15) + 1;
                int i3 = i >> 4;
                if (i2 > 15) {
                    i2 = addressSpace2.getLargeSizes().get(i3);
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj = getSlots()[i3 + i4];
                    if (Intrinsics.areEqual(obj, Composer.Companion.getEmpty())) {
                        break;
                    }
                    RecomposeScope recomposeScope = obj instanceof RecomposeScope ? (RecomposeScope) obj : null;
                    if (recomposeScope != null) {
                        recomposeScope.invalidate();
                    }
                }
            }
            int i5 = groups[root + 1];
            if (i5 >= 0) {
                intStack.push(i5);
            }
            root = groups[root + 3];
            if (root < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                root = intStack.pop();
            }
        }
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int i) {
        int[] groups = getAddressSpace().getGroups();
        int i2 = i;
        while (true) {
            if (i2 <= 0) {
                if (i2 != 0) {
                    return null;
                }
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
                return null;
            }
            RecomposeScopeImpl recomposeScopeOrNull$runtime = getRecomposeScopeOrNull$runtime(i2);
            if (recomposeScopeOrNull$runtime != null) {
                if (recomposeScopeOrNull$runtime.getUsed() && i2 != i) {
                    return recomposeScopeOrNull$runtime;
                }
                recomposeScopeOrNull$runtime.setForcedRecompose(true);
            }
            i2 = groups[i2 + 2];
        }
    }

    public final boolean isGroupAChildOf$runtime(int i, int i2) {
        int[] groups = getAddressSpace().getGroups();
        int i3 = i;
        while (true) {
            if (i3 <= 0) {
                if (!(i3 != 0)) {
                    ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
                }
                return false;
            } else if (i3 == i2) {
                return true;
            } else {
                i3 = groups[i3 + 2];
            }
        }
    }
}
