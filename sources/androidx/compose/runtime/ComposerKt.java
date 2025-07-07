package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composer.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0000\u001a\u0010\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020?H\u0000\u001a\u0011\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020\u0001H\u0080\b\u001a\u001f\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020?0EH\u0080\b\u001a.\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010(\u001a\u00020J2\u0006\u0010K\u001a\u0002032\f\u0010L\u001a\b\u0012\u0002\b\u0003\u0018\u00010MH\u0000\u001a(\u0010N\u001a\u0004\u0018\u00010\u00062\b\u0010C\u001a\u0004\u0018\u00010\u00062\b\u0010O\u001a\u0004\u0018\u00010\u00062\b\u0010P\u001a\u0004\u0018\u00010\u0006H\u0002\u001a\b\u0010Q\u001a\u00020\u0001H\u0007\u001a5\u0010R\u001a\u000e\u0012\u0004\u0012\u0002HT\u0012\u0004\u0012\u0002HU0S\"\b\b\u0000\u0010T*\u00020\u0006\"\b\b\u0001\u0010U*\u00020\u00062\u0006\u0010V\u001a\u00020\fH\u0002¢\u0006\u0002\u0010W\u001a\u0011\u0010X\u001a\u00020=2\u0006\u0010C\u001a\u00020\u0001H\u0080\b\u001a*\u0010X\u001a\u00020=2\u0006\u0010C\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020?0EH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a\u0018\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020[2\u0006\u0010Y\u001a\u00020?H\u0007\u001a\u0010\u0010\\\u001a\u00020=2\u0006\u0010Z\u001a\u00020[H\u0007\u001a \u0010]\u001a\u00020=2\u0006\u0010Z\u001a\u00020[2\u0006\u0010^\u001a\u00020\f2\u0006\u0010Y\u001a\u00020?H\u0007\u001a\b\u0010_\u001a\u00020=H\u0007\u001a(\u0010`\u001a\u00020=2\u0006\u0010^\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\f2\u0006\u0010c\u001a\u00020?H\u0007\u001a\u0018\u0010`\u001a\u00020=2\u0006\u0010^\u001a\u00020\f2\u0006\u0010c\u001a\u00020?H\u0007\u001a\f\u0010d\u001a\u00020\u0001*\u00020\fH\u0002\u001a\f\u0010e\u001a\u00020\f*\u00020\u0001H\u0002\u001a3\u0010f\u001a\u0002Hg\"\u0004\b\u0000\u0010g*\u00020[2\u0006\u0010h\u001a\u00020\u00012\u0011\u0010i\u001a\r\u0012\u0004\u0012\u0002Hg0E¢\u0006\u0002\bjH\u0087\b¢\u0006\u0002\u0010k\u001a\u001c\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060m*\u00020n2\u0006\u0010o\u001a\u00020pH\u0002\u001a\u0014\u0010q\u001a\u00020=*\u0002032\u0006\u0010r\u001a\u00020sH\u0000\u001a\u001c\u0010t\u001a\u00020\f*\u0002012\u0006\u0010u\u001a\u00020\f2\u0006\u0010v\u001a\u00020\fH\u0002\u001a(\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00040x*\b\u0012\u0004\u0012\u00020\u00040x2\u0006\u0010y\u001a\u00020\f2\u0006\u0010z\u001a\u00020\fH\u0002\u001a\u001a\u0010{\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00040x2\u0006\u0010|\u001a\u00020\fH\u0002\u001a\u001a\u0010}\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00040x2\u0006\u0010|\u001a\u00020\fH\u0002\u001a$\u0010~\u001a\u0004\u0018\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00040x2\u0006\u0010y\u001a\u00020\f2\u0006\u0010z\u001a\u00020\fH\u0002\u001a/\u0010\u007f\u001a\u00020=*\b\u0012\u0004\u0012\u00020\u00040x2\u0006\u0010|\u001a\u00020\f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0006H\u0002\u001a(\u0010\u0083\u0001\u001a\u00020\f*\u0002012\u0007\u0010\u0084\u0001\u001a\u00020\f2\u0007\u0010\u0085\u0001\u001a\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0002\u001a\u0015\u0010\u0087\u0001\u001a\u00020=*\u0002032\u0006\u0010r\u001a\u00020sH\u0000\u001a \u0010\u0088\u0001\u001a\u00020=*\u0002032\u0006\u0010u\u001a\u00020\f2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006H\u0002\u001a\u001d\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00040x2\u0006\u0010|\u001a\u00020\fH\u0002\u001a#\u0010\u008b\u0001\u001a\u00020=*\b\u0012\u0004\u0012\u00020\u00040x2\u0006\u0010y\u001a\u00020\f2\u0006\u0010z\u001a\u00020\fH\u0002\u001a<\u0010\u008c\u0001\u001a\u00020=\"\u0005\b\u0000\u0010\u008d\u0001*\u0002032\b\u0010o\u001a\u0004\u0018\u00010p2\u001b\u0010\u008e\u0001\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u0003H\u008d\u00010\u008f\u0001H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0016\u0010\u000b\u001a\u00020\f8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\b\"\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\b\"\u000e\u0010\u0011\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0013\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\n\"\u0016\u0010\u0016\u001a\u00020\f8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\b\"\u000e\u0010\u0018\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0019\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\n\"\u0016\u0010\u001c\u001a\u00020\f8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\b\"\u001c\u0010\u001e\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b \u0010\n\"\u0016\u0010!\u001a\u00020\f8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\b\"\u001c\u0010#\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\b\u001a\u0004\b%\u0010\n\"\u0016\u0010&\u001a\u00020\f8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\b\"\u001c\u0010(\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\b\u001a\u0004\b*\u0010\n\"\u0016\u0010+\u001a\u00020\f8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b,\u0010\b\"\u0016\u0010-\u001a\u00020\f8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b.\u0010\b\"\u000e\u0010/\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u0018\u00100\u001a\u00020\u0001*\u0002018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u00102\"\u0018\u00100\u001a\u00020\u0001*\u0002038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u00104\"\u0018\u00105\u001a\u00020\u0006*\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108\"\u0018\u00109\u001a\u00020\f*\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006\u0090\u0001"}, d2 = {"EnableDebugRuntimeChecks", "", "InvalidationLocationAscending", "Ljava/util/Comparator;", "Landroidx/compose/runtime/Invalidation;", "compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "defaultsKey", "invalidGroupLocation", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", TypedValues.Custom.S_REFERENCE, "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "reuseKey", "getReuseKey$annotations", "rootKey", "isAfterFirstChild", "Landroidx/compose/runtime/SlotReader;", "(Landroidx/compose/runtime/SlotReader;)Z", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;)Z", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "nextGroup", "getNextGroup", "(Landroidx/compose/runtime/SlotWriter;)I", "composeImmediateRuntimeError", "", "message", "", "composeRuntimeError", "", "debugRuntimeCheck", "value", "lazyMessage", "Lkotlin/Function0;", "extractMovableContentAtCurrent", "Landroidx/compose/runtime/MovableContentState;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/MovableContentStateReference;", "slots", "applier", "Landroidx/compose/runtime/Applier;", "getKey", TtmlNode.LEFT, TtmlNode.RIGHT, "isTraceInProgress", "multiMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "runtimeCheck", "sourceInformation", "composer", "Landroidx/compose/runtime/Composer;", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "traceEventEnd", "traceEventStart", "dirty1", "dirty2", "info", "asBool", "asInt", "cache", ExifInterface.GPS_DIRECTION_TRUE, "invalid", "block", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collectNodesFrom", "", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "deactivateCurrentGroup", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "distanceFrom", FirebaseAnalytics.Param.INDEX, "root", "filterToRange", "", TtmlNode.START, TtmlNode.END, "findInsertLocation", FirebaseAnalytics.Param.LOCATION, "findLocation", "firstInRange", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "nearestCommonRootOf", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "common", "removeCurrentGroup", "removeData", "data", "removeLocation", "removeRange", "withAfterAnchorInfo", "R", "cb", "Lkotlin/Function2;", "runtime_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerKt {
    public static final boolean EnableDebugRuntimeChecks = false;
    public static final int compositionLocalMapKey = 202;
    private static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    public static final int providerKey = 201;
    public static final int providerMapsKey = 204;
    public static final int providerValuesKey = 203;
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;
    private static final Object invocation = new OpaqueKey("provider");
    private static final Object provider = new OpaqueKey("provider");
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    private static final Object providerValues = new OpaqueKey("providerValues");
    private static final Object providerMaps = new OpaqueKey("providers");
    private static final Object reference = new OpaqueKey(TypedValues.Custom.S_REFERENCE);
    private static final Comparator<Invalidation> InvalidationLocationAscending = new Comparator() { // from class: androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int InvalidationLocationAscending$lambda$16;
            InvalidationLocationAscending$lambda$16 = ComposerKt.InvalidationLocationAscending$lambda$16((Invalidation) obj, (Invalidation) obj2);
            return InvalidationLocationAscending$lambda$16;
        }
    };

    public static final boolean asBool(int i) {
        return i != 0;
    }

    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }

    public static final void debugRuntimeCheck(boolean z) {
    }

    public static final void debugRuntimeCheck(boolean z, Function0<String> function0) {
    }

    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    public static /* synthetic */ void getInvocation$annotations() {
    }

    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static /* synthetic */ void getProviderValues$annotations() {
    }

    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static /* synthetic */ void getReference$annotations() {
    }

    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    public static /* synthetic */ void getReuseKey$annotations() {
    }

    public static final int getNextGroup(SlotWriter slotWriter) {
        return slotWriter.getCurrentGroup() + slotWriter.groupSize(slotWriter.getCurrentGroup());
    }

    @ComposeCompilerApi
    public static final <T> T cache(Composer composer, boolean z, Function0<? extends T> function0) {
        T t = (T) composer.rememberedValue();
        if (z || t == Composer.Companion.getEmpty()) {
            T invoke = function0.invoke();
            composer.updateRememberedValue(invoke);
            return invoke;
        }
        return t;
    }

    @ComposeCompilerApi
    public static final void sourceInformation(Composer composer, String str) {
        composer.sourceInformation(str);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(Composer composer, int i, String str) {
        composer.sourceInformationMarkerStart(i, str);
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer compositionTracer2 = compositionTracer;
        return compositionTracer2 != null && compositionTracer2.isTraceInProgress();
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int i, int i2, int i3, String str) {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventStart(i, i2, i3, str);
        }
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventEnd();
        }
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(Composer composer) {
        composer.sourceInformationMarkerEnd();
    }

    public static final void removeCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        int i;
        int dataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup() + slotWriter.groupSize(slotWriter.getCurrentGroup())));
        for (int dataIndex2 = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup())); dataIndex2 < dataIndex; dataIndex2++) {
            Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(dataIndex2)];
            int i2 = -1;
            if (obj instanceof ComposeNodeLifecycleCallback) {
                rememberManager.releasing((ComposeNodeLifecycleCallback) obj, slotWriter.getSlotsSize() - dataIndex2, -1, -1);
            }
            if (obj instanceof RememberObserverHolder) {
                int slotsSize = slotWriter.getSlotsSize() - dataIndex2;
                RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                Anchor after = rememberObserverHolder.getAfter();
                if (after == null || !after.getValid()) {
                    i = -1;
                } else {
                    i2 = slotWriter.anchorIndex(after);
                    i = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(i2);
                }
                rememberManager.forgetting(rememberObserverHolder, slotsSize, i2, i);
            }
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }
        slotWriter.removeGroup();
    }

    public static final <R> void withAfterAnchorInfo(SlotWriter slotWriter, Anchor anchor, Function2<? super Integer, ? super Integer, ? extends R> function2) {
        int i;
        int i2;
        if (anchor == null || !anchor.getValid()) {
            i = -1;
            i2 = -1;
        } else {
            i = slotWriter.anchorIndex(anchor);
            i2 = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(i);
        }
        function2.invoke(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static final boolean isAfterFirstChild(SlotWriter slotWriter) {
        return slotWriter.getCurrentGroup() > slotWriter.getParent() + 1;
    }

    public static final boolean isAfterFirstChild(SlotReader slotReader) {
        return slotReader.getCurrentGroup() > slotReader.getParent() + 1;
    }

    public static final void deactivateCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        int i;
        int dataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup() + slotWriter.groupSize(slotWriter.getCurrentGroup())));
        for (int dataIndex2 = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup())); dataIndex2 < dataIndex; dataIndex2++) {
            Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(dataIndex2)];
            int i2 = -1;
            if (obj instanceof ComposeNodeLifecycleCallback) {
                rememberManager.deactivating((ComposeNodeLifecycleCallback) obj, slotWriter.getSlotsSize() - dataIndex2, -1, -1);
            } else if (obj instanceof RememberObserverHolder) {
                RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                if (!(rememberObserverHolder.getWrapped() instanceof ReusableRememberObserver)) {
                    removeData(slotWriter, dataIndex2, obj);
                    int slotsSize = slotWriter.getSlotsSize() - dataIndex2;
                    Anchor after = rememberObserverHolder.getAfter();
                    if (after == null || !after.getValid()) {
                        i = -1;
                    } else {
                        i2 = slotWriter.anchorIndex(after);
                        i = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(i2);
                    }
                    rememberManager.forgetting(rememberObserverHolder, slotsSize, i2, i);
                }
            } else if (obj instanceof RecomposeScopeImpl) {
                removeData(slotWriter, dataIndex2, obj);
                ((RecomposeScopeImpl) obj).release();
            }
        }
    }

    private static final void removeData(SlotWriter slotWriter, int i, Object obj) {
        Object clear = slotWriter.clear(i);
        if (obj == clear) {
            return;
        }
        composeImmediateRuntimeError("Slot table is out of sync (expected " + obj + ", got " + clear + ')');
    }

    public static final <K, V> MutableScatterMap<Object, Object> multiMap(int i) {
        return MultiValueMap.m3598constructorimpl(new MutableScatterMap(i));
    }

    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey != null) {
            if (Intrinsics.areEqual(joinedKey.getLeft(), obj2) && Intrinsics.areEqual(joinedKey.getRight(), obj3)) {
                return obj;
            }
            Object key = getKey(joinedKey.getLeft(), obj2, obj3);
            return key == null ? getKey(joinedKey.getRight(), obj2, obj3) : key;
        }
        return null;
    }

    private static final int findLocation(List<Invalidation> list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int compare = Intrinsics.compare(list.get(i3).getLocation(), i);
            if (compare < 0) {
                i2 = i3 + 1;
            } else if (compare <= 0) {
                return i3;
            } else {
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    private static final int findInsertLocation(List<Invalidation> list, int i) {
        int findLocation = findLocation(list, i);
        return findLocation < 0 ? -(findLocation + 1) : findLocation;
    }

    public static final void insertIfMissing(List<Invalidation> list, int i, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int findLocation = findLocation(list, i);
        if (findLocation < 0) {
            int i2 = -(findLocation + 1);
            if (!(obj instanceof DerivedState)) {
                obj = null;
            }
            list.add(i2, new Invalidation(recomposeScopeImpl, i, obj));
            return;
        }
        Invalidation invalidation = list.get(findLocation);
        if (obj instanceof DerivedState) {
            Object instances = invalidation.getInstances();
            if (instances == null) {
                invalidation.setInstances(obj);
                return;
            } else if (instances instanceof MutableScatterSet) {
                ((MutableScatterSet) instances).add(obj);
                return;
            } else {
                invalidation.setInstances(ScatterSetKt.mutableScatterSetOf(instances, obj));
                return;
            }
        }
        invalidation.setInstances(null);
    }

    public static final Invalidation firstInRange(List<Invalidation> list, int i, int i2) {
        int findInsertLocation = findInsertLocation(list, i);
        if (findInsertLocation < list.size()) {
            Invalidation invalidation = list.get(findInsertLocation);
            if (invalidation.getLocation() < i2) {
                return invalidation;
            }
            return null;
        }
        return null;
    }

    public static final Invalidation removeLocation(List<Invalidation> list, int i) {
        int findLocation = findLocation(list, i);
        if (findLocation >= 0) {
            return list.remove(findLocation);
        }
        return null;
    }

    public static final void removeRange(List<Invalidation> list, int i, int i2) {
        int findInsertLocation = findInsertLocation(list, i);
        while (findInsertLocation < list.size() && list.get(findInsertLocation).getLocation() < i2) {
            list.remove(findInsertLocation);
        }
    }

    public static final List<Invalidation> filterToRange(List<Invalidation> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int findInsertLocation = findInsertLocation(list, i); findInsertLocation < list.size(); findInsertLocation++) {
            Invalidation invalidation = list.get(findInsertLocation);
            if (invalidation.getLocation() >= i2) {
                break;
            }
            arrayList.add(invalidation);
        }
        return arrayList;
    }

    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader openReader = slotTable.openReader();
        try {
            collectNodesFrom$lambda$10$collectFromGroup(openReader, arrayList, slotTable.anchorIndex(anchor));
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            openReader.close();
        }
    }

    private static final void collectNodesFrom$lambda$10$collectFromGroup(SlotReader slotReader, List<Object> list, int i) {
        if (slotReader.isNode(i)) {
            list.add(slotReader.node(i));
            return;
        }
        int i2 = i + 1;
        int groupSize = i + slotReader.groupSize(i);
        while (i2 < groupSize) {
            collectNodesFrom$lambda$10$collectFromGroup(slotReader, list, i2);
            i2 += slotReader.groupSize(i2);
        }
    }

    private static final int distanceFrom(SlotReader slotReader, int i, int i2) {
        int i3 = 0;
        while (i > 0 && i != i2) {
            i = slotReader.parent(i);
            i3++;
        }
        return i3;
    }

    public static final int nearestCommonRootOf(SlotReader slotReader, int i, int i2, int i3) {
        if (i != i2) {
            if (i == i3 || i2 == i3) {
                return i3;
            }
            if (slotReader.parent(i) == i2) {
                return i2;
            }
            if (slotReader.parent(i2) != i) {
                if (slotReader.parent(i) == slotReader.parent(i2)) {
                    return slotReader.parent(i);
                }
                int distanceFrom = distanceFrom(slotReader, i, i3);
                int distanceFrom2 = distanceFrom(slotReader, i2, i3);
                int i4 = distanceFrom - distanceFrom2;
                for (int i5 = 0; i5 < i4; i5++) {
                    i = slotReader.parent(i);
                }
                int i6 = distanceFrom2 - distanceFrom;
                for (int i7 = 0; i7 < i6; i7++) {
                    i2 = slotReader.parent(i2);
                }
                while (i != i2) {
                    i = slotReader.parent(i);
                    i2 = slotReader.parent(i2);
                }
                return i;
            }
        }
        return i;
    }

    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    public static final Object getInvocation() {
        return invocation;
    }

    public static final Object getProvider() {
        return provider;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static final Object getProviderValues() {
        return providerValues;
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static final Object getReference() {
        return reference;
    }

    public static final void runtimeCheck(boolean z, Function0<String> function0) {
        if (z) {
            return;
        }
        composeImmediateRuntimeError(function0.invoke());
    }

    public static final void runtimeCheck(boolean z) {
        if (z) {
            return;
        }
        composeImmediateRuntimeError("Check failed");
    }

    public static final Void composeRuntimeError(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void composeImmediateRuntimeError(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final int InvalidationLocationAscending$lambda$16(Invalidation invalidation, Invalidation invalidation2) {
        return Intrinsics.compare(invalidation.getLocation(), invalidation2.getLocation());
    }

    public static final MovableContentState extractMovableContentAtCurrent(final ControlledComposition controlledComposition, final MovableContentStateReference movableContentStateReference, SlotWriter slotWriter, Applier<?> applier) {
        SlotTable slotTable = new SlotTable();
        if (slotWriter.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        if (slotWriter.getCollectingCalledInformation()) {
            slotTable.collectCalledByInformation();
        }
        int currentGroup = slotWriter.getCurrentGroup();
        if (applier != null && slotWriter.nodeCount(currentGroup) > 0) {
            int parent = slotWriter.getParent();
            while (parent > 0 && !slotWriter.isNode(parent)) {
                parent = slotWriter.parent(parent);
            }
            if (parent >= 0 && slotWriter.isNode(parent)) {
                Object node = slotWriter.node(parent);
                int i = parent + 1;
                int groupSize = parent + slotWriter.groupSize(parent);
                int i2 = 0;
                while (i < groupSize) {
                    int groupSize2 = slotWriter.groupSize(i) + i;
                    if (groupSize2 > currentGroup) {
                        break;
                    }
                    i2 += slotWriter.isNode(i) ? 1 : slotWriter.nodeCount(i);
                    i = groupSize2;
                }
                int nodeCount = slotWriter.isNode(currentGroup) ? 1 : slotWriter.nodeCount(currentGroup);
                applier.down(node);
                applier.remove(i2, nodeCount);
                applier.up();
            }
        }
        SlotWriter openWriter = slotTable.openWriter();
        try {
            openWriter.beginInsert();
            openWriter.startGroup(MovableContentKt.movableContentKey, movableContentStateReference.getContent$runtime_release());
            SlotWriter.markGroup$default(openWriter, 0, 1, null);
            openWriter.update(movableContentStateReference.getParameter$runtime_release());
            List<Anchor> moveTo = slotWriter.moveTo(movableContentStateReference.getAnchor$runtime_release(), 1, openWriter);
            openWriter.skipGroup();
            openWriter.endGroup();
            openWriter.endInsert();
            openWriter.close(true);
            MovableContentState movableContentState = new MovableContentState(slotTable);
            if (RecomposeScopeImpl.Companion.hasAnchoredRecomposeScopes$runtime_release(slotTable, moveTo)) {
                RecomposeScopeOwner recomposeScopeOwner = new RecomposeScopeOwner() { // from class: androidx.compose.runtime.ComposerKt$extractMovableContentAtCurrent$movableContentRecomposeScopeOwner$1
                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl) {
                    }

                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public void recordReadOf(Object obj) {
                    }

                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
                        InvalidationResult invalidationResult;
                        ControlledComposition controlledComposition2 = ControlledComposition.this;
                        RecomposeScopeOwner recomposeScopeOwner2 = controlledComposition2 instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition2 : null;
                        if (recomposeScopeOwner2 == null || (invalidationResult = recomposeScopeOwner2.invalidate(recomposeScopeImpl, obj)) == null) {
                            invalidationResult = InvalidationResult.IGNORED;
                        }
                        if (invalidationResult == InvalidationResult.IGNORED) {
                            MovableContentStateReference movableContentStateReference2 = movableContentStateReference;
                            movableContentStateReference2.setInvalidations$runtime_release(CollectionsKt.plus((Collection<? extends Pair>) movableContentStateReference2.getInvalidations$runtime_release(), TuplesKt.to(recomposeScopeImpl, obj)));
                            return InvalidationResult.SCHEDULED;
                        }
                        return invalidationResult;
                    }
                };
                openWriter = slotTable.openWriter();
                try {
                    RecomposeScopeImpl.Companion.adoptAnchoredScopes$runtime_release(openWriter, moveTo, recomposeScopeOwner);
                    Unit unit = Unit.INSTANCE;
                    openWriter.close(true);
                    return movableContentState;
                } finally {
                }
            }
            return movableContentState;
        } finally {
        }
    }
}
