package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.tooling.ComposeStackTraceMode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
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
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b%\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u0002H\u00060\u000b¢\u0006\u0002\b\fH\u0087\b¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0011H\u0007\u001a \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0011H\u0007\u001a\b\u0010\u001f\u001a\u00020\tH\u0007\u001a\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0011H\u0007\u001a(\u0010 \u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0011H\u0007\u001a\b\u0010$\u001a\u00020\u000fH\u0007\u001a\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007\u001a\u0014\u0010&\u001a\u00020\u000f*\u00020\u00022\u0006\u0010'\u001a\u00020(H\u0000\u001a7\u0010)\u001a\u00020\u000f\"\u0004\b\u0000\u0010**\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010,2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H*0.H\u0080\b\u001a*\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\t2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a\u001f\u0010[\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\t2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0080\b\u001a\u0011\u0010[\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\tH\u0080\b\u001a\u0011\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\tH\u0080\b\u001a\u0010\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0011H\u0000\u001a\u0010\u0010_\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u0011H\u0000\u001a.\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010Q\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00022\f\u0010f\u001a\b\u0012\u0002\b\u0003\u0018\u00010gH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017\"\u001c\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\"\u0018\u0010/\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u0010/\u001a\u00020\t*\u0002018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u00102\"\u000e\u00103\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u00104\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b5\u0010\u0017\"\u001c\u00106\u001a\u0002078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u0017\u001a\u0004\b9\u0010:\"\u0016\u0010;\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b<\u0010\u0017\"\u001c\u0010=\u001a\u0002078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u0017\u001a\u0004\b?\u0010:\"\u0016\u0010@\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bA\u0010\u0017\"\u001c\u0010B\u001a\u0002078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010\u0017\u001a\u0004\bD\u0010:\"\u0016\u0010E\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bF\u0010\u0017\"\u001c\u0010G\u001a\u0002078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010\u0017\u001a\u0004\bI\u0010:\"\u0016\u0010J\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bK\u0010\u0017\"\u001c\u0010L\u001a\u0002078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010\u0017\u001a\u0004\bN\u0010:\"\u0016\u0010O\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bP\u0010\u0017\"\u001c\u0010Q\u001a\u0002078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\u0017\u001a\u0004\bS\u0010:\"\u0016\u0010T\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bU\u0010\u0017\"\u000e\u0010V\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"nextGroup", "", "Landroidx/compose/runtime/SlotWriter;", "getNextGroup", "(Landroidx/compose/runtime/SlotWriter;)I", "cache", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/Composer;", "invalid", "", "block", "Lkotlin/Function0;", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sourceInformation", "", "composer", "", "sourceInformationMarkerStart", "key", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "()V", "composeStackTraceMode", "Landroidx/compose/runtime/tooling/ComposeStackTraceMode;", "getComposeStackTraceMode", "()I", "setComposeStackTraceMode-76WK1J0", "(I)V", "I", "isTraceInProgress", "traceEventStart", "info", "dirty1", "dirty2", "traceEventEnd", "sourceInformationMarkerEnd", "removeCurrentGroup", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "withAfterAnchorInfo", "R", "anchor", "Landroidx/compose/runtime/Anchor;", "cb", "Lkotlin/Function2;", "isAfterFirstChild", "(Landroidx/compose/runtime/SlotWriter;)Z", "Landroidx/compose/runtime/SlotReader;", "(Landroidx/compose/runtime/SlotReader;)Z", "defaultsKey", "invocationKey", "getInvocationKey$annotations", "invocation", "", "getInvocation$annotations", "getInvocation", "()Ljava/lang/Object;", "providerKey", "getProviderKey$annotations", "provider", "getProvider$annotations", "getProvider", "compositionLocalMapKey", "getCompositionLocalMapKey$annotations", "compositionLocalMap", "getCompositionLocalMap$annotations", "getCompositionLocalMap", "providerValuesKey", "getProviderValuesKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerMapsKey", "getProviderMapsKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "referenceKey", "getReferenceKey$annotations", TypedValues.Custom.S_REFERENCE, "getReference$annotations", "getReference", "reuseKey", "getReuseKey$annotations", "invalidGroupLocation", "runtimeCheck", "value", "lazyMessage", "EnableDebugRuntimeChecks", "debugRuntimeCheck", "composeRuntimeError", "", "message", "composeImmediateRuntimeError", "extractMovableContentAtCurrent", "Landroidx/compose/runtime/MovableContentState;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/MovableContentStateReference;", "slots", "applier", "Landroidx/compose/runtime/Applier;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerKt {
    public static final boolean EnableDebugRuntimeChecks = false;
    public static final int compositionLocalMapKey = 202;
    private static CompositionTracer compositionTracer = null;
    public static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    public static final int invocationKey = 200;
    public static final int providerKey = 201;
    public static final int providerMapsKey = 204;
    public static final int providerValuesKey = 203;
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static int composeStackTraceMode = ComposeStackTraceMode.Companion.m4244getNoneMD5MrJc();
    private static final Object invocation = new OpaqueKey("provider");
    private static final Object provider = new OpaqueKey("provider");
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    private static final Object providerValues = new OpaqueKey("providerValues");
    private static final Object providerMaps = new OpaqueKey("providers");
    private static final Object reference = new OpaqueKey(TypedValues.Custom.S_REFERENCE);

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

    public static final int getComposeStackTraceMode() {
        return composeStackTraceMode;
    }

    /* renamed from: setComposeStackTraceMode-76WK1J0 */
    public static final void m3983setComposeStackTraceMode76WK1J0(int i) {
        composeStackTraceMode = i;
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

    public static final void removeCurrentGroup(SlotWriter slotWriter, final RememberManager rememberManager) {
        slotWriter.forAllDataInRememberOrder(slotWriter.getCurrentGroup(), new Function2() { // from class: androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ComposerKt.removeCurrentGroup$lambda$0(RememberManager.this, ((Integer) obj).intValue(), obj2);
            }
        });
        slotWriter.removeGroup();
    }

    public static final Unit removeCurrentGroup$lambda$0(RememberManager rememberManager, int i, Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            rememberManager.releasing((ComposeNodeLifecycleCallback) obj);
        }
        if (obj instanceof RememberObserverHolder) {
            rememberManager.forgetting((RememberObserverHolder) obj);
        }
        if (obj instanceof RecomposeScopeImpl) {
            ((RecomposeScopeImpl) obj).release();
        }
        return Unit.INSTANCE;
    }

    public static final <R> void withAfterAnchorInfo(SlotWriter slotWriter, Anchor anchor, Function2<? super Integer, ? super Integer, ? extends R> function2) {
        int i;
        int i2;
        if (anchor == null || !anchor.getValid()) {
            i = -1;
            i2 = -1;
        } else {
            i = slotWriter.anchorIndex(anchor);
            i2 = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime(i);
        }
        function2.invoke(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static final boolean isAfterFirstChild(SlotWriter slotWriter) {
        return slotWriter.getCurrentGroup() > slotWriter.getParent() + 1;
    }

    public static final boolean isAfterFirstChild(SlotReader slotReader) {
        return slotReader.getCurrentGroup() > slotReader.getParent() + 1;
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

    public static final MovableContentState extractMovableContentAtCurrent(final ControlledComposition controlledComposition, MovableContentStateReference movableContentStateReference, SlotWriter slotWriter, Applier<?> applier) {
        final MovableContentStateReference movableContentStateReference2;
        ArrayList emptyList;
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        long j;
        int i3;
        boolean z;
        Object obj;
        long j2;
        int i4;
        Object obj2;
        boolean z2;
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
                int i5 = parent + 1;
                int groupSize = parent + slotWriter.groupSize(parent);
                int i6 = 0;
                while (i5 < groupSize) {
                    int groupSize2 = slotWriter.groupSize(i5) + i5;
                    if (groupSize2 > currentGroup) {
                        break;
                    }
                    i6 += slotWriter.isNode(i5) ? 1 : slotWriter.nodeCount(i5);
                    i5 = groupSize2;
                }
                int nodeCount = slotWriter.isNode(currentGroup) ? 1 : slotWriter.nodeCount(currentGroup);
                applier.down(node);
                applier.remove(i6, nodeCount);
                applier.up();
            }
        }
        Anchor anchor$runtime = movableContentStateReference.getAnchor$runtime();
        if (anchor$runtime.getValid()) {
            Intrinsics.checkNotNull(controlledComposition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            CompositionImpl compositionImpl = (CompositionImpl) controlledComposition;
            if (ScopeMap.m4148getSizeimpl(compositionImpl.invalidations) > 0) {
                emptyList = new ArrayList();
                MutableScatterMap mutableScatterMap = compositionImpl.invalidations;
                long[] jArr3 = mutableScatterMap.metadata;
                int length = jArr3.length - 2;
                if (length >= 0) {
                    int i7 = 0;
                    while (true) {
                        long j3 = jArr3[i7];
                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i8 = 8;
                            int i9 = 8 - ((~(i7 - length)) >>> 31);
                            int i10 = 0;
                            while (i10 < i9) {
                                if ((j3 & 255) < 128) {
                                    int i11 = (i7 << 3) + i10;
                                    int i12 = i8;
                                    Object obj3 = mutableScatterMap.keys[i11];
                                    i = i10;
                                    Object obj4 = mutableScatterMap.values[i11];
                                    jArr2 = jArr3;
                                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                    if (obj4 instanceof MutableScatterSet) {
                                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj4;
                                        Object[] objArr = mutableScatterSet.elements;
                                        long[] jArr4 = mutableScatterSet.metadata;
                                        j = j3;
                                        int length2 = jArr4.length - 2;
                                        if (length2 >= 0) {
                                            int i13 = 0;
                                            while (true) {
                                                long j4 = jArr4[i13];
                                                long[] jArr5 = jArr4;
                                                i2 = length;
                                                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i14 = 8 - ((~(i13 - length2)) >>> 31);
                                                    int i15 = 0;
                                                    while (i15 < i14) {
                                                        if ((j4 & 255) < 128) {
                                                            j2 = j4;
                                                            int i16 = (i13 << 3) + i15;
                                                            Object obj5 = objArr[i16];
                                                            i4 = i15;
                                                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj3;
                                                            obj2 = obj3;
                                                            Anchor anchor = recomposeScopeImpl.getAnchor();
                                                            if (anchor == null || !slotWriter.inGroup(anchor$runtime, anchor)) {
                                                                z2 = false;
                                                            } else {
                                                                emptyList.add(TuplesKt.to(recomposeScopeImpl, obj5));
                                                                z2 = true;
                                                            }
                                                            if (z2) {
                                                                mutableScatterSet.removeElementAt(i16);
                                                            }
                                                        } else {
                                                            j2 = j4;
                                                            i4 = i15;
                                                            obj2 = obj3;
                                                        }
                                                        j4 = j2 >> i12;
                                                        i15 = i4 + 1;
                                                        obj3 = obj2;
                                                    }
                                                    obj = obj3;
                                                    if (i14 != i12) {
                                                        break;
                                                    }
                                                } else {
                                                    obj = obj3;
                                                }
                                                if (i13 == length2) {
                                                    break;
                                                }
                                                i13++;
                                                length = i2;
                                                jArr4 = jArr5;
                                                obj3 = obj;
                                                i12 = 8;
                                            }
                                        } else {
                                            i2 = length;
                                        }
                                        z = mutableScatterSet.isEmpty();
                                    } else {
                                        i2 = length;
                                        j = j3;
                                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj3;
                                        Anchor anchor2 = recomposeScopeImpl2.getAnchor();
                                        if (anchor2 == null || !slotWriter.inGroup(anchor$runtime, anchor2)) {
                                            z = false;
                                        } else {
                                            emptyList.add(TuplesKt.to(recomposeScopeImpl2, obj4));
                                            z = true;
                                        }
                                    }
                                    if (z) {
                                        mutableScatterMap.removeValueAt(i11);
                                    }
                                    i3 = 8;
                                } else {
                                    i = i10;
                                    jArr2 = jArr3;
                                    i2 = length;
                                    j = j3;
                                    i3 = i8;
                                }
                                j3 = j >> i3;
                                i10 = i + 1;
                                i8 = i3;
                                jArr3 = jArr2;
                                length = i2;
                            }
                            jArr = jArr3;
                            int i17 = length;
                            if (i9 != i8) {
                                break;
                            }
                            length = i17;
                        } else {
                            jArr = jArr3;
                        }
                        if (i7 == length) {
                            break;
                        }
                        i7++;
                        jArr3 = jArr;
                    }
                }
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            movableContentStateReference2 = movableContentStateReference;
            movableContentStateReference2.setInvalidations$runtime(CollectionsKt.plus((Collection) movableContentStateReference.getInvalidations$runtime(), (Iterable) emptyList));
        } else {
            movableContentStateReference2 = movableContentStateReference;
        }
        SlotWriter openWriter = slotTable.openWriter();
        try {
            openWriter.beginInsert();
            openWriter.startGroup(MovableContentKt.movableContentKey, movableContentStateReference2.getContent$runtime());
            SlotWriter.markGroup$default(openWriter, 0, 1, null);
            openWriter.update(movableContentStateReference2.getParameter$runtime());
            List<Anchor> moveTo = slotWriter.moveTo(movableContentStateReference2.getAnchor$runtime(), 1, openWriter);
            openWriter.skipGroup();
            openWriter.endGroup();
            openWriter.endInsert();
            openWriter.close(true);
            MovableContentState movableContentState = new MovableContentState(slotTable);
            if (RecomposeScopeImpl.Companion.hasAnchoredRecomposeScopes$runtime(slotTable, moveTo)) {
                RecomposeScopeOwner recomposeScopeOwner = new RecomposeScopeOwner() { // from class: androidx.compose.runtime.ComposerKt$extractMovableContentAtCurrent$movableContentRecomposeScopeOwner$1
                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl3) {
                    }

                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public void recordReadOf(Object obj6) {
                    }

                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl3, Object obj6) {
                        InvalidationResult invalidationResult;
                        ControlledComposition controlledComposition2 = ControlledComposition.this;
                        RecomposeScopeOwner recomposeScopeOwner2 = controlledComposition2 instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition2 : null;
                        if (recomposeScopeOwner2 == null || (invalidationResult = recomposeScopeOwner2.invalidate(recomposeScopeImpl3, obj6)) == null) {
                            invalidationResult = InvalidationResult.IGNORED;
                        }
                        if (invalidationResult == InvalidationResult.IGNORED) {
                            MovableContentStateReference movableContentStateReference3 = movableContentStateReference2;
                            movableContentStateReference3.setInvalidations$runtime(CollectionsKt.plus((Collection<? extends Pair>) movableContentStateReference3.getInvalidations$runtime(), TuplesKt.to(recomposeScopeImpl3, obj6)));
                            return InvalidationResult.SCHEDULED;
                        }
                        return invalidationResult;
                    }
                };
                openWriter = slotTable.openWriter();
                try {
                    RecomposeScopeImpl.Companion.adoptAnchoredScopes$runtime(openWriter, moveTo, recomposeScopeOwner);
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
