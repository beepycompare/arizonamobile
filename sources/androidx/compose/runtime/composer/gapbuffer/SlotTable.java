package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.GapComposerKt;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.collection.ExtensionsKt;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010(\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J7\u0010@\u001a\u0002HA\"\u0004\b\u0000\u0010A2!\u0010B\u001a\u001d\u0012\u0013\u0012\u00110D¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u0002HA0CH\u0086\b¢\u0006\u0002\u0010HJ7\u0010I\u001a\u0002HA\"\u0004\b\u0000\u0010A2!\u0010B\u001a\u001d\u0012\u0013\u0012\u00110J¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002HA0CH\u0086\b¢\u0006\u0002\u0010HJ\u0006\u0010K\u001a\u00020DJ\u0006\u0010L\u001a\u00020JJ\u000e\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020\fJ\u0012\u0010O\u001a\u0004\u0018\u00010&2\u0006\u0010N\u001a\u00020\fH\u0002J\u000e\u0010P\u001a\u00020\f2\u0006\u0010M\u001a\u00020&J\u000e\u0010Q\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020&J\u0018\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\f2\u0006\u0010M\u001a\u00020TH\u0016J\u0018\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020TH\u0016J=\u0010X\u001a\u00020=2\u0006\u0010G\u001a\u00020D2&\u0010,\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/H\u0000¢\u0006\u0002\bYJ\u008f\u0001\u0010X\u001a\u00020=2\u0006\u0010\u001d\u001a\u00020J2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0016\u001a\u00020\f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2&\u0010,\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0000¢\u0006\u0004\bY\u0010ZJ\u0087\u0001\u0010[\u001a\u00020=2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0016\u001a\u00020\f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2&\u0010,\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0000¢\u0006\u0004\b\\\u0010]J\u0018\u0010^\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010_2\u0006\u0010a\u001a\u00020\fH\u0016J\u0010\u0010b\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020`H\u0016J\u0006\u0010d\u001a\u00020\u001cJ\u0010\u0010e\u001a\u0004\u0018\u00010.2\u0006\u0010S\u001a\u00020\fJ\u0012\u0010f\u001a\u0004\u0018\u00010`2\u0006\u0010S\u001a\u00020\fH\u0002J\b\u0010g\u001a\u00020=H\u0016J\b\u0010h\u001a\u00020=H\u0002J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0003H\u0016J\b\u0010i\u001a\u00020=H\u0016J\b\u0010j\u001a\u00020=H\u0016J\u0010\u0010k\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010l\u001a\u00020=H\u0016J.\u0010m\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020p0n2\n\u0010q\u001a\u0006\u0012\u0002\b\u00030r2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020o0tH\u0016J\u0018\u0010u\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010v\u001a\u00020pH\u0016J\b\u0010w\u001a\u00020=H\u0016J\b\u0010x\u001a\u00020yH\u0016J \u0010z\u001a\u00020\f*\u00060{j\u0002`|2\u0006\u0010N\u001a\u00020\f2\u0006\u0010}\u001a\u00020\fH\u0002J\u000e\u0010~\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000e\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000f\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000f\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u001f\u0010\u0083\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110_2\u0006\u0010S\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0084\u0001J\"\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010S\u001a\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0087\u0001J\u0011\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u008c\u0001H\u0096\u0002J\u0014\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u008e\u0001\u001a\u00020\u0011H\u0016R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00060\u0011j\u0002`\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010#R*\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R:\u0010,\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u001fR\u001d\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008f\u0001"}, d2 = {"Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "Landroidx/compose/runtime/SlotStorage;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "<init>", "()V", "value", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "readers", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "", "writer", "getWriter$runtime", "()Z", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "getVersion$runtime", "setVersion$runtime", "(I)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime", "()Ljava/util/ArrayList;", "setAnchors$runtime", "(Ljava/util/ArrayList;)V", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "Lkotlin/collections/HashMap;", "getSourceInformationMap$runtime", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime", "(Ljava/util/HashMap;)V", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime", "(Landroidx/collection/MutableIntObjectMap;)V", "isEmpty", "clear", "", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "read", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "Lkotlin/ParameterName;", "name", "reader", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "write", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "openReader", "openWriter", "anchor", FirebaseAnalytics.Param.INDEX, "tryAnchor", "anchorIndex", "ownsAnchor", "groupContainsAnchor", "group", "Landroidx/compose/runtime/Anchor;", "inGroup", "parent", "child", "close", "close$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "setTo", "setTo$runtime", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", TypedValues.AttributesType.S_TARGET, "ownsRecomposeScope", "scope", "containsMark", "sourceInformationOf", "findEffectiveRecomposeScope", "verifyWellFormed", "validateRecomposeScopeAnchors", "collectCalledByInformation", "collectSourceInformation", "deactivateAll", "dispose", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "disposeUnusedMovableContent", RemoteConfigConstants.ResponseFieldKey.STATE, "invalidateAll", "toDebugString", "", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", FirebaseAnalytics.Param.LEVEL, UserMetadata.KEYDATA_FILENAME, "nodes", "parentIndexes", "dataIndexes", "groupSizes", "slotsOf", "slotsOf$runtime", "slot", "slotIndex", "slot$runtime", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "iterator", "", "find", "identityToFind", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTable extends SlotStorage implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    public static final int $stable = 8;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private HashMap<GapAnchor, GapGroupSourceInformation> sourceInformationMap;
    private int version;
    private boolean writer;
    private int[] groups = new int[0];
    private Object[] slots = new Object[0];
    private final Object lock = new Object();
    private ArrayList<GapAnchor> anchors = new ArrayList<>();

    @Override // androidx.compose.runtime.SlotStorage
    public void dispose() {
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    /* renamed from: getSlots  reason: collision with other method in class */
    public final Object[] m4553getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final boolean getWriter$runtime() {
        return this.writer;
    }

    public final int getVersion$runtime() {
        return this.version;
    }

    public final void setVersion$runtime(int i) {
        this.version = i;
    }

    public final ArrayList<GapAnchor> getAnchors$runtime() {
        return this.anchors;
    }

    public final void setAnchors$runtime(ArrayList<GapAnchor> arrayList) {
        this.anchors = arrayList;
    }

    public final HashMap<GapAnchor, GapGroupSourceInformation> getSourceInformationMap$runtime() {
        return this.sourceInformationMap;
    }

    public final void setSourceInformationMap$runtime(HashMap<GapAnchor, GapGroupSourceInformation> hashMap) {
        this.sourceInformationMap = hashMap;
    }

    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime() {
        return this.calledByMap;
    }

    public final void setCalledByMap$runtime(MutableIntObjectMap<MutableIntSet> mutableIntObjectMap) {
        this.calledByMap = mutableIntObjectMap;
    }

    @Override // androidx.compose.runtime.SlotStorage, androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    public final <T> T read(Function1<? super SlotReader, ? extends T> function1) {
        SlotReader openReader = openReader();
        try {
            return function1.invoke(openReader);
        } finally {
            openReader.close();
        }
    }

    public final <T> T write(Function1<? super SlotWriter, ? extends T> function1) {
        SlotWriter openWriter = openWriter();
        try {
            T invoke = function1.invoke(openWriter);
            openWriter.close(true);
            return invoke;
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending".toString());
        }
        this.readers++;
        return new SlotReader(this);
    }

    public final SlotWriter openWriter() {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (!(this.readers <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final GapAnchor anchor(int i) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to create an anchor location instead");
        }
        boolean z = false;
        if (i >= 0 && i < this.groupsSize) {
            z = true;
        }
        if (!z) {
            PreconditionsKt.throwIllegalArgumentException("Parameter index is out of range");
        }
        ArrayList<GapAnchor> arrayList = this.anchors;
        int search = SlotTableKt.search(arrayList, i, this.groupsSize);
        if (search < 0) {
            GapAnchor gapAnchor = new GapAnchor(i);
            arrayList.add(-(search + 1), gapAnchor);
            return gapAnchor;
        }
        return arrayList.get(search);
    }

    private final GapAnchor tryAnchor(int i) {
        int i2;
        GapAnchor find;
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
        }
        if (i < 0 || i >= (i2 = this.groupsSize)) {
            return null;
        }
        find = SlotTableKt.find(this.anchors, i, i2);
        return find;
    }

    public final int anchorIndex(GapAnchor gapAnchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }
        if (!gapAnchor.getValid()) {
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }
        return gapAnchor.getLocation$runtime();
    }

    public final boolean ownsAnchor(GapAnchor gapAnchor) {
        int search;
        return gapAnchor.getValid() && (search = SlotTableKt.search(this.anchors, gapAnchor.getLocation$runtime(), this.groupsSize)) >= 0 && Intrinsics.areEqual(this.anchors.get(search), gapAnchor);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean groupContainsAnchor(int i, Anchor anchor) {
        int groupSize;
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Writer is active");
        }
        if (!(i >= 0 && i < this.groupsSize)) {
            ComposerKt.composeImmediateRuntimeError("Invalid group index");
        }
        GapAnchor asGapAnchor = GapAnchorKt.asGapAnchor(anchor);
        if (ownsAnchor(asGapAnchor)) {
            groupSize = SlotTableKt.groupSize(this.groups, i);
            int i2 = groupSize + i;
            int location$runtime = asGapAnchor.getLocation$runtime();
            if (i <= location$runtime && location$runtime < i2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean inGroup(Anchor anchor, Anchor anchor2) {
        int groupSize;
        int location$runtime = GapAnchorKt.asGapAnchor(anchor).getLocation$runtime();
        groupSize = SlotTableKt.groupSize(this.groups, location$runtime);
        int i = groupSize + location$runtime;
        int location$runtime2 = GapAnchorKt.asGapAnchor(anchor2).getLocation$runtime();
        return location$runtime <= location$runtime2 && location$runtime2 < i;
    }

    public final void close$runtime(SlotReader slotReader, HashMap<GapAnchor, GapGroupSourceInformation> hashMap) {
        if (!(slotReader.getTable$runtime() == this && this.readers > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }
        this.readers--;
        if (hashMap != null) {
            synchronized (this.lock) {
                HashMap<GapAnchor, GapGroupSourceInformation> hashMap2 = this.sourceInformationMap;
                if (hashMap2 != null) {
                    hashMap2.putAll(hashMap);
                } else {
                    this.sourceInformationMap = hashMap;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void close$runtime(SlotWriter slotWriter, int[] iArr, int i, Object[] objArr, int i2, ArrayList<GapAnchor> arrayList, HashMap<GapAnchor, GapGroupSourceInformation> hashMap, MutableIntObjectMap<MutableIntSet> mutableIntObjectMap) {
        if (!(slotWriter.getTable$runtime() == this && this.writer)) {
            PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
        }
        this.writer = false;
        setTo$runtime(iArr, i, objArr, i2, arrayList, hashMap, mutableIntObjectMap);
    }

    public final void setTo$runtime(int[] iArr, int i, Object[] objArr, int i2, ArrayList<GapAnchor> arrayList, HashMap<GapAnchor, GapGroupSourceInformation> hashMap, MutableIntObjectMap<MutableIntSet> mutableIntObjectMap) {
        this.groups = iArr;
        this.groupsSize = i;
        this.slots = objArr;
        this.slotsSize = i2;
        this.anchors = arrayList;
        this.sourceInformationMap = hashMap;
        this.calledByMap = mutableIntObjectMap;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public List<RecomposeScopeImpl> invalidateGroupsWithKey(int i) {
        MutableIntSet mutableIntSet;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
        mutableIntSet2.add(i);
        mutableIntSet2.add(-3);
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        if (mutableIntObjectMap != null && (mutableIntSet = mutableIntObjectMap.get(i)) != null) {
            mutableIntSet2.addAll(mutableIntSet);
        }
        SlotReader openReader = openReader();
        try {
            invalidateGroupsWithKey$lambda$2$scanGroup(openReader, mutableIntSet2, arrayList, booleanRef, this, arrayList2);
            Unit unit = Unit.INSTANCE;
            openReader.close();
            SlotWriter openWriter = openWriter();
            try {
                openWriter.startGroup();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    GapAnchor gapAnchor = (GapAnchor) arrayList.get(i2);
                    if (gapAnchor.toIndexFor(openWriter) >= openWriter.getCurrentGroup()) {
                        openWriter.seek(gapAnchor);
                        openWriter.bashCurrentGroup();
                    }
                }
                openWriter.skipToGroupEnd();
                openWriter.endGroup();
                openWriter.close(true);
                if (booleanRef.element) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th) {
                openWriter.close(false);
                throw th;
            }
        } catch (Throwable th2) {
            openReader.close();
            throw th2;
        }
    }

    private static final void invalidateGroupsWithKey$lambda$2$scanGroup(SlotReader slotReader, MutableIntSet mutableIntSet, List<GapAnchor> list, Ref.BooleanRef booleanRef, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        GapAnchor asGapAnchor;
        RecomposeScopeImpl findEffectiveRecomposeScope;
        int groupKey = slotReader.getGroupKey();
        if (mutableIntSet.contains(groupKey)) {
            if (groupKey != -3) {
                list.add(SlotReader.anchor$default(slotReader, 0, 1, null));
            }
            if (booleanRef.element) {
                RecomposeScopeImpl findEffectiveRecomposeScope2 = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
                if (findEffectiveRecomposeScope2 != null) {
                    list2.add(findEffectiveRecomposeScope2);
                    Anchor anchor = findEffectiveRecomposeScope2.getAnchor();
                    if (anchor != null && (asGapAnchor = GapAnchorKt.asGapAnchor(anchor)) != null && asGapAnchor.getLocation$runtime() == slotReader.getCurrentGroup() && (findEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getParent())) != null) {
                        list2.add(findEffectiveRecomposeScope);
                    }
                } else {
                    booleanRef.element = false;
                    list2.clear();
                }
            }
            slotReader.skipGroup();
            return;
        }
        slotReader.startGroup();
        while (!slotReader.isGroupEnd()) {
            invalidateGroupsWithKey$lambda$2$scanGroup(slotReader, mutableIntSet, list, booleanRef, slotTable, list2);
        }
        slotReader.endGroup();
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean ownsRecomposeScope(RecomposeScopeImpl recomposeScopeImpl) {
        Anchor anchor = recomposeScopeImpl.getAnchor();
        return anchor != null && ownsAnchor(GapAnchorKt.asGapAnchor(anchor));
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && (this.groups[1] & 67108864) != 0;
    }

    public final GapGroupSourceInformation sourceInformationOf(int i) {
        GapAnchor tryAnchor;
        HashMap<GapAnchor, GapGroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null || (tryAnchor = tryAnchor(i)) == null) {
            return null;
        }
        return hashMap.get(tryAnchor);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int i) {
        int i2 = i;
        while (i2 > 0) {
            Iterator<Object> it = new DataIterator(this, i2).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) next;
                    if (recomposeScopeImpl.getUsed() && i2 != i) {
                        return recomposeScopeImpl;
                    }
                    recomposeScopeImpl.setForcedRecompose(true);
                }
            }
            i2 = this.groups[(i2 * 5) + 2];
        }
        return null;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void verifyWellFormed() {
        int groupSize;
        Ref.IntRef intRef = new Ref.IntRef();
        int i = -1;
        if (this.groupsSize > 0) {
            while (intRef.element < this.groupsSize) {
                int i2 = intRef.element;
                groupSize = SlotTableKt.groupSize(this.groups, intRef.element);
                verifyWellFormed$validateGroup(intRef, this, -1, i2 + groupSize);
            }
            if (!(intRef.element == this.groupsSize)) {
                PreconditionsKt.throwIllegalStateException("Incomplete group at root " + intRef.element + " expected to be " + this.groupsSize);
            }
        }
        int length = this.slots.length;
        for (int i3 = this.slotsSize; i3 < length; i3++) {
            if (!(this.slots[i3] == null)) {
                PreconditionsKt.throwIllegalStateException("Non null value in the slot gap at index " + i3);
            }
        }
        ArrayList<GapAnchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            int indexFor = arrayList.get(i4).toIndexFor(this);
            if (!(indexFor >= 0 && indexFor <= this.groupsSize)) {
                PreconditionsKt.throwIllegalArgumentException("Invalid anchor, location out of bound");
            }
            if (!(i < indexFor)) {
                PreconditionsKt.throwIllegalArgumentException("Anchor is out of order");
            }
            i4++;
            i = indexFor;
        }
        HashMap<GapAnchor, GapGroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap != null) {
            for (Map.Entry<GapAnchor, GapGroupSourceInformation> entry : hashMap.entrySet()) {
                GapAnchor key = entry.getKey();
                GapGroupSourceInformation value = entry.getValue();
                if (!key.getValid()) {
                    PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                }
                if (!ownsAnchor(key)) {
                    PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                }
                verifyWellFormed$verifySourceGroup(this, value);
            }
        }
        validateRecomposeScopeAnchors();
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef intRef, SlotTable slotTable, int i, int i2) {
        int groupSize;
        int slotAnchor;
        int groupSize2;
        int i3 = intRef.element;
        int i4 = i3 + 1;
        intRef.element = i4;
        int i5 = i3 * 5;
        int i6 = slotTable.groups[i5 + 2];
        boolean z = false;
        if (!(i6 == i)) {
            PreconditionsKt.throwIllegalStateException("Invalid parent index detected at " + i3 + ", expected parent index to be " + i + " found " + i6);
        }
        groupSize = SlotTableKt.groupSize(slotTable.groups, i3);
        int i7 = groupSize + i3;
        if (!(i7 <= slotTable.groupsSize)) {
            PreconditionsKt.throwIllegalStateException("A group extends past the end of the table at " + i3);
        }
        if (!(i7 <= i2)) {
            PreconditionsKt.throwIllegalStateException("A group extends past its parent group at " + i3);
        }
        int[] iArr = slotTable.groups;
        int i8 = i5 + 4;
        int i9 = iArr[i8];
        int i10 = i3 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : iArr[(i4 * 5) + 4];
        if (!(i10 <= slotTable.slots.length)) {
            PreconditionsKt.throwIllegalStateException("Slots for " + i3 + " extend past the end of the slot table");
        }
        if (!(i9 <= i10)) {
            PreconditionsKt.throwIllegalStateException("Invalid data anchor at " + i3);
        }
        slotAnchor = SlotTableKt.slotAnchor(slotTable.groups, i3);
        if (!(slotAnchor <= i10)) {
            PreconditionsKt.throwIllegalStateException("Slots start out of range at " + i3);
        }
        int i11 = i5 + 1;
        int i12 = slotTable.groups[i11];
        if (!(i10 - i9 >= (((i12 & 1073741824) != 0 ? 1 : 0) + ((536870912 & i12) != 0 ? 1 : 0)) + ((i12 & 268435456) != 0 ? 1 : 0))) {
            PreconditionsKt.throwIllegalStateException("Not enough slots added for group " + i3);
        }
        int[] iArr2 = slotTable.groups;
        boolean z2 = (iArr2[i11] & 1073741824) != 0;
        if (!((z2 && slotTable.slots[iArr2[i8]] == null) ? false : true)) {
            PreconditionsKt.throwIllegalStateException("No node recorded for a node group at " + i3);
        }
        int i13 = 0;
        while (intRef.element < i7) {
            i13 += verifyWellFormed$validateGroup(intRef, slotTable, i3, i7);
        }
        int[] iArr3 = slotTable.groups;
        int i14 = iArr3[i11] & 67108863;
        groupSize2 = SlotTableKt.groupSize(iArr3, i3);
        if (!(i14 == i13)) {
            PreconditionsKt.throwIllegalStateException("Incorrect node count detected at " + i3 + ", expected " + i14 + ", received " + i13);
        }
        int i15 = intRef.element - i3;
        if (!(groupSize2 == i15)) {
            PreconditionsKt.throwIllegalStateException("Incorrect slot count detected at " + i3 + ", expected " + groupSize2 + ", received " + i15);
        }
        int[] iArr4 = slotTable.groups;
        if ((iArr4[i11] & 201326592) != 0) {
            if (i3 <= 0 || (iArr4[(i * 5) + 1] & 67108864) != 0) {
                z = true;
            }
            if (!z) {
                PreconditionsKt.throwIllegalStateException("Expected group " + i + " to record it contains a mark because " + i3 + " does");
            }
        }
        if (z2) {
            return 1;
        }
        return i13;
    }

    private static final void verifyWellFormed$verifySourceGroup(SlotTable slotTable, GapGroupSourceInformation gapGroupSourceInformation) {
        ArrayList<Object> groups = gapGroupSourceInformation.getGroups();
        if (groups != null) {
            ArrayList<Object> arrayList = groups;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof GapAnchor) {
                    GapAnchor gapAnchor = (GapAnchor) obj;
                    if (!gapAnchor.getValid()) {
                        PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                    }
                    if (!slotTable.ownsAnchor(gapAnchor)) {
                        PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                    }
                } else if (obj instanceof GapGroupSourceInformation) {
                    verifyWellFormed$verifySourceGroup(slotTable, (GapGroupSourceInformation) obj);
                }
            }
        }
    }

    private final void validateRecomposeScopeAnchors() {
        GapAnchor asGapAnchor;
        Object[] objArr = this.slots;
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList2.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && (asGapAnchor = GapAnchorKt.asGapAnchor(anchor)) != null && !slotsOf$runtime(asGapAnchor.toIndexFor(this)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + asGapAnchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((RecomposeScopeImpl[]) this.slots, recomposeScopeImpl2));
            }
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    /* renamed from: getSlots */
    public Iterable<Object> mo4618getSlots() {
        return new SlotTable$getSlots$1(this);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void collectCalledByInformation() {
        this.calledByMap = new MutableIntObjectMap<>(0, 1, null);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void collectSourceInformation() {
        this.sourceInformationMap = new HashMap<>();
    }

    private static final void extractNestedStates$lambda$2$closeToGroupContaining(SlotWriter slotWriter, int i) {
        while (slotWriter.getParent() >= 0 && slotWriter.getCurrentGroupEnd() <= i) {
            slotWriter.skipToGroupEnd();
            slotWriter.endGroup();
        }
    }

    private static final void extractNestedStates$lambda$2$openParent(SlotWriter slotWriter, int i) {
        int nextGroup;
        extractNestedStates$lambda$2$closeToGroupContaining(slotWriter, i);
        while (slotWriter.getCurrentGroup() != i && !slotWriter.isGroupEnd()) {
            nextGroup = SlotTableKt.getNextGroup(slotWriter);
            if (i < nextGroup) {
                slotWriter.startGroup();
            } else {
                slotWriter.skipGroup();
            }
        }
        if (!(slotWriter.getCurrentGroup() == i)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot table structure");
        }
        slotWriter.startGroup();
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void invalidateAll() {
        Object[] objArr;
        for (Object obj : this.slots) {
            RecomposeScope recomposeScope = obj instanceof RecomposeScope ? (RecomposeScope) obj : null;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
            }
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public String toDebugString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('\n');
        int i = this.groupsSize;
        if (i > 0) {
            int i2 = 0;
            while (i2 < i) {
                i2 += emitGroup(sb, i2, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        return sb.toString();
    }

    private final int emitGroup(StringBuilder sb, int i, int i2) {
        int groupSize;
        int slotAnchor;
        String summarize;
        int auxIndex;
        String summarize2;
        String summarize3;
        int objectKeyIndex;
        String summarize4;
        String sourceInformation;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i);
        sb.append(")");
        GapGroupSourceInformation sourceInformationOf = sourceInformationOf(i);
        if (sourceInformationOf != null && (sourceInformation = sourceInformationOf.getSourceInformation()) != null && (StringsKt.startsWith$default(sourceInformation, "C(", false, 2, (Object) null) || StringsKt.startsWith$default(sourceInformation, "CC(", false, 2, (Object) null))) {
            String str = sourceInformation;
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null);
            sb.append(" ");
            String substring = sourceInformation.substring(StringsKt.indexOf$default((CharSequence) str, "(", 0, false, 6, (Object) null) + 1, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
            sb.append("()");
        }
        sb.append(" key=");
        int i4 = i * 5;
        sb.append(this.groups[i4]);
        groupSize = SlotTableKt.groupSize(this.groups, i);
        sb.append(", nodes=");
        int i5 = i4 + 1;
        sb.append(this.groups[i5] & 67108863);
        sb.append(", size=");
        sb.append(groupSize);
        if ((this.groups[i5] & 134217728) != 0) {
            sb.append(", mark");
        }
        if ((this.groups[i5] & 67108864) != 0) {
            sb.append(", contains mark");
        }
        int emitGroup$dataIndex = emitGroup$dataIndex(this, i);
        int i6 = i + 1;
        int emitGroup$dataIndex2 = emitGroup$dataIndex(this, i6);
        if (emitGroup$dataIndex < 0 || emitGroup$dataIndex > emitGroup$dataIndex2 || emitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + emitGroup$dataIndex + '-' + emitGroup$dataIndex2 + '*');
        } else {
            if ((this.groups[i5] & 536870912) != 0) {
                StringBuilder sb2 = new StringBuilder(" objectKey=");
                Object[] objArr = this.slots;
                objectKeyIndex = SlotTableKt.objectKeyIndex(this.groups, i);
                summarize4 = SlotTableKt.summarize(String.valueOf(objArr[objectKeyIndex]), 10);
                sb.append(sb2.append(summarize4).toString());
            }
            if ((this.groups[i5] & 1073741824) != 0) {
                StringBuilder sb3 = new StringBuilder(" node=");
                summarize3 = SlotTableKt.summarize(String.valueOf(this.slots[this.groups[i4 + 4]]), 10);
                sb.append(sb3.append(summarize3).toString());
            }
            if ((this.groups[i5] & 268435456) != 0) {
                StringBuilder sb4 = new StringBuilder(" aux=");
                Object[] objArr2 = this.slots;
                auxIndex = SlotTableKt.auxIndex(this.groups, i);
                summarize2 = SlotTableKt.summarize(String.valueOf(objArr2[auxIndex]), 10);
                sb.append(sb4.append(summarize2).toString());
            }
            slotAnchor = SlotTableKt.slotAnchor(this.groups, i);
            if (slotAnchor < emitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(slotAnchor);
                sb.append(": ");
                for (int i7 = slotAnchor; i7 < emitGroup$dataIndex2; i7++) {
                    if (i7 != slotAnchor) {
                        sb.append(", ");
                    }
                    summarize = SlotTableKt.summarize(String.valueOf(this.slots[i7]), 10);
                    sb.append(summarize);
                }
                sb.append("]");
            }
        }
        sb.append('\n');
        int i8 = i + groupSize;
        while (i6 < i8) {
            i6 += emitGroup(sb, i6, i2 + 1);
        }
        return groupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        return i >= slotTable.groupsSize ? slotTable.slotsSize : slotTable.groups[(i * 5) + 4];
    }

    private final List<Integer> keys() {
        List<Integer> keys;
        keys = SlotTableKt.keys(this.groups, this.groupsSize * 5);
        return keys;
    }

    private final List<Integer> nodes() {
        List<Integer> nodeCounts;
        nodeCounts = SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
        return nodeCounts;
    }

    private final List<Integer> parentIndexes() {
        List<Integer> parentAnchors;
        parentAnchors = SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
        return parentAnchors;
    }

    private final List<Integer> dataIndexes() {
        List<Integer> dataAnchors;
        dataAnchors = SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
        return dataAnchors;
    }

    private final List<Integer> groupSizes() {
        List<Integer> groupSizes;
        groupSizes = SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
        return groupSizes;
    }

    public final List<Object> slotsOf$runtime(int i) {
        int length;
        int[] iArr = this.groups;
        int i2 = iArr[(i * 5) + 4];
        int i3 = i + 1;
        if (i3 >= this.groupsSize) {
            length = this.slots.length;
        } else {
            length = iArr[(i3 * 5) + 4];
        }
        return ArraysKt.toList(this.slots).subList(i2, length);
    }

    public final Object slot$runtime(int i, int i2) {
        int slotAnchor;
        int length;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, i);
        int i3 = i + 1;
        if (i3 >= this.groupsSize) {
            length = this.slots.length;
        } else {
            length = this.groups[(i3 * 5) + 4];
        }
        return (i2 < 0 || i2 >= length - slotAnchor) ? Composer.Companion.getEmpty() : this.slots[slotAnchor + i2];
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object obj) {
        return new SlotTableGroup(this, 0, 0, 4, null).find(obj);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void clear(RememberManager rememberManager) {
        SlotWriter openWriter = openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberManager);
            Unit unit = Unit.INSTANCE;
            openWriter.close(true);
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void deactivateAll(RememberManager rememberManager) {
        SlotWriter openWriter = openWriter();
        try {
            GapComposerKt.deactivateCurrentGroup(openWriter, rememberManager);
            Unit unit = Unit.INSTANCE;
            openWriter.close(true);
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates(Applier<?> applier, ObjectList<MovableContentStateReference> objectList) {
        Object[] objArr = objectList.content;
        int i = objectList._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            } else if (ownsAnchor(GapAnchorKt.asGapAnchor(((MovableContentStateReference) objArr[i2]).getAnchor$runtime()))) {
                i2++;
            } else {
                MutableObjectList mutableObjectList = new MutableObjectList(0, 1, null);
                Object[] objArr2 = objectList.content;
                int i3 = objectList._size;
                for (int i4 = 0; i4 < i3; i4++) {
                    Object obj = objArr2[i4];
                    if (ownsAnchor(GapAnchorKt.asGapAnchor(((MovableContentStateReference) obj).getAnchor$runtime()))) {
                        mutableObjectList.add(obj);
                    }
                }
                objectList = mutableObjectList;
            }
        }
        ObjectList sortedBy = ExtensionsKt.sortedBy(objectList, new Function1() { // from class: androidx.compose.runtime.composer.gapbuffer.SlotTable$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Integer valueOf;
                valueOf = Integer.valueOf(SlotTable.this.anchorIndex(GapAnchorKt.asGapAnchor(((MovableContentStateReference) obj2).getAnchor$runtime())));
                return valueOf;
            }
        });
        if (sortedBy.isEmpty()) {
            return ScatterMapKt.emptyScatterMap();
        }
        MutableScatterMap mutableScatterMapOf = ScatterMapKt.mutableScatterMapOf();
        SlotWriter openWriter = openWriter();
        try {
            Object[] objArr3 = sortedBy.content;
            int i5 = sortedBy._size;
            for (int i6 = 0; i6 < i5; i6++) {
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr3[i6];
                int anchorIndex = openWriter.anchorIndex(GapAnchorKt.asGapAnchor(movableContentStateReference.getAnchor$runtime()));
                int parent = openWriter.parent(anchorIndex);
                extractNestedStates$lambda$2$closeToGroupContaining(openWriter, parent);
                extractNestedStates$lambda$2$openParent(openWriter, parent);
                openWriter.advanceBy(anchorIndex - openWriter.getCurrentGroup());
                mutableScatterMapOf.set(movableContentStateReference, ComposerKt.extractMovableContentAtCurrent(movableContentStateReference.getComposition$runtime(), movableContentStateReference, openWriter, applier));
            }
            extractNestedStates$lambda$2$closeToGroupContaining(openWriter, Integer.MAX_VALUE);
            Unit unit = Unit.INSTANCE;
            openWriter.close(true);
            return mutableScatterMapOf;
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void disposeUnusedMovableContent(RememberManager rememberManager, MovableContentState movableContentState) {
        SlotWriter openWriter = openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberManager);
            Unit unit = Unit.INSTANCE;
            openWriter.close(true);
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }
}
