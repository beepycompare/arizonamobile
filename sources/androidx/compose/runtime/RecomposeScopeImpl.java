package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.RecomposeScopeObserver;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RecomposeScopeImpl.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010D\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u000eJ\u001c\u0010G\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0010\u0018\u00010H2\u0006\u0010J\u001a\u00020\u000fJ\b\u0010K\u001a\u00020\u0010H\u0016J\u0010\u0010L\u001a\u00020M2\b\u0010\u0016\u001a\u0004\u0018\u00010<J\u0010\u0010N\u001a\u00020\u00122\b\u0010O\u001a\u0004\u0018\u00010<J\u0015\u0010P\u001a\u00020Q2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\bRJ\u001c\u0010S\u001a\u00020\u00102\n\u0010T\u001a\u0006\u0012\u0002\b\u00030;2\b\u0010\u0016\u001a\u0004\u0018\u00010<J\u000e\u0010U\u001a\u00020\u00122\u0006\u0010T\u001a\u00020<J\u0006\u0010V\u001a\u00020\u0010J\u0006\u0010W\u001a\u00020\u0010J\u0006\u0010X\u001a\u00020\u0010J\u000e\u0010Y\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u000fJ\"\u0010Z\u001a\u00020\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016J*\u0010[\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030;2\u0018\u0010\\\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030;\u0012\u0006\u0012\u0004\u0018\u00010<0:H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u001aR\u0011\u0010\"\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b%\u0010&R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u001aR$\u0010*\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u001aR$\u0010-\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u001aR$\u00100\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u001aR$\u00103\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u001aR$\u00106\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128@@BX\u0080\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0014\"\u0004\b8\u0010\u001aR\"\u00109\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030;\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010?\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0014\"\u0004\bA\u0010\u001aR\u0011\u0010B\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bC\u0010\u0014¨\u0006^"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "owner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "canRecompose", "", "getCanRecompose", "()Z", "currentToken", "value", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", DownloaderServiceMarshaller.PARAMS_FLAGS, "forcedRecompose", "getForcedRecompose", "setForcedRecompose", "isConditional", "observer", "Landroidx/compose/runtime/tooling/RecomposeScopeObserver;", "getObserver$annotations", "()V", "paused", "getPaused", "setPaused", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "resuming", "getResuming", "setResuming", "reusing", "getReusing", "setReusing", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/collection/MutableObjectIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "adoptedBy", "compose", "composer", TtmlNode.END, "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observe$runtime_release", "recordDerivedStateValue", "instance", "recordRead", "release", "rereadTrackedInstances", "scopeSkipped", TtmlNode.START, "updateScope", "checkDerivedStateChanged", "dependencies", "Companion", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    private Anchor anchor;
    private Function2<? super Composer, ? super Integer, Unit> block;
    private int currentToken;
    private int flags;
    private RecomposeScopeObserver observer;
    private RecomposeScopeOwner owner;
    private MutableScatterMap<DerivedState<?>, Object> trackedDependencies;
    private MutableObjectIntMap<Object> trackedInstances;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private static /* synthetic */ void getObserver$annotations() {
    }

    public RecomposeScopeImpl(RecomposeScopeOwner recomposeScopeOwner) {
        this.owner = recomposeScopeOwner;
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public final boolean getValid() {
        if (this.owner != null) {
            Anchor anchor = this.anchor;
            if (anchor != null ? anchor.getValid() : false) {
                return true;
            }
        }
        return false;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final void setUsed(boolean z) {
        int i;
        if (z) {
            i = this.flags | 1;
        } else {
            i = this.flags & (-2);
        }
        this.flags = i;
    }

    public final boolean getReusing() {
        return (this.flags & 128) != 0;
    }

    public final void setReusing(boolean z) {
        int i;
        if (z) {
            i = this.flags | 128;
        } else {
            i = this.flags & (-129);
        }
        this.flags = i;
    }

    public final boolean getPaused() {
        return (this.flags & 256) != 0;
    }

    public final void setPaused(boolean z) {
        int i;
        if (z) {
            i = this.flags | 256;
        } else {
            i = this.flags & (-257);
        }
        this.flags = i;
    }

    public final boolean getResuming() {
        return (this.flags & 512) != 0;
    }

    public final void setResuming(boolean z) {
        int i;
        if (z) {
            i = this.flags | 512;
        } else {
            i = this.flags & (-513);
        }
        this.flags = i;
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final void setDefaultsInScope(boolean z) {
        if (z) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final void setDefaultsInvalid(boolean z) {
        if (z) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final void setRequiresRecompose(boolean z) {
        if (z) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void compose(Composer composer) {
        Unit unit;
        Function2<? super Composer, ? super Integer, Unit> function2 = this.block;
        RecomposeScopeObserver recomposeScopeObserver = this.observer;
        if (recomposeScopeObserver != null && function2 != null) {
            RecomposeScopeImpl recomposeScopeImpl = this;
            recomposeScopeObserver.onBeginScopeComposition(recomposeScopeImpl);
            try {
                function2.invoke(composer, 1);
                return;
            } finally {
                recomposeScopeObserver.onEndScopeComposition(recomposeScopeImpl);
            }
        }
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    public final CompositionObserverHandle observe$runtime_release(final RecomposeScopeObserver recomposeScopeObserver) {
        Object obj;
        obj = RecomposeScopeImplKt.callbackLock;
        synchronized (obj) {
            this.observer = recomposeScopeObserver;
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.RecomposeScopeImpl$observe$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj2;
                RecomposeScopeObserver recomposeScopeObserver2;
                obj2 = RecomposeScopeImplKt.callbackLock;
                RecomposeScopeImpl recomposeScopeImpl = RecomposeScopeImpl.this;
                RecomposeScopeObserver recomposeScopeObserver3 = recomposeScopeObserver;
                synchronized (obj2) {
                    recomposeScopeObserver2 = recomposeScopeImpl.observer;
                    if (Intrinsics.areEqual(recomposeScopeObserver2, recomposeScopeObserver3)) {
                        recomposeScopeImpl.observer = null;
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final InvalidationResult invalidateForResult(Object obj) {
        InvalidationResult invalidate;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        return (recomposeScopeOwner == null || (invalidate = recomposeScopeOwner.invalidate(this, obj)) == null) ? InvalidationResult.IGNORED : invalidate;
    }

    public final void release() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.recomposeScopeReleased(this);
        }
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
        RecomposeScopeObserver recomposeScopeObserver = this.observer;
        if (recomposeScopeObserver != null) {
            recomposeScopeObserver.onScopeDisposed(this);
        }
    }

    public final void adoptedBy(RecomposeScopeOwner recomposeScopeOwner) {
        this.owner = recomposeScopeOwner;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.invalidate(this, null);
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.block = function2;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean z) {
        if (z) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    public final boolean getForcedRecompose() {
        return (this.flags & 64) != 0;
    }

    public final void setForcedRecompose(boolean z) {
        if (z) {
            this.flags |= 64;
        } else {
            this.flags &= -65;
        }
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    private final void setSkipped(boolean z) {
        if (z) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void start(int i) {
        this.currentToken = i;
        setSkipped(false);
    }

    public final void scopeSkipped() {
        if (getReusing()) {
            return;
        }
        setSkipped(true);
    }

    public final boolean recordRead(Object obj) {
        if (getRereading()) {
            return false;
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = this.trackedInstances;
        if (mutableObjectIntMap == null) {
            mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
            this.trackedInstances = mutableObjectIntMap;
        }
        return mutableObjectIntMap.put(obj, this.currentToken, -1) == this.currentToken;
    }

    public final void recordDerivedStateValue(DerivedState<?> derivedState, Object obj) {
        MutableScatterMap<DerivedState<?>, Object> mutableScatterMap = this.trackedDependencies;
        if (mutableScatterMap == null) {
            mutableScatterMap = new MutableScatterMap<>(0, 1, null);
            this.trackedDependencies = mutableScatterMap;
        }
        mutableScatterMap.set(derivedState, obj);
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    public final boolean isInvalidFor(Object obj) {
        MutableScatterMap<DerivedState<?>, Object> mutableScatterMap;
        if (obj == null || (mutableScatterMap = this.trackedDependencies) == null) {
            return true;
        }
        if (obj instanceof DerivedState) {
            return checkDerivedStateChanged((DerivedState) obj, mutableScatterMap);
        }
        if (obj instanceof ScatterSet) {
            ScatterSet scatterSet = (ScatterSet) obj;
            if (scatterSet.isNotEmpty()) {
                Object[] objArr = scatterSet.elements;
                long[] jArr = scatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    loop0: while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    Object obj2 = objArr[(i << 3) + i3];
                                    if (!(obj2 instanceof DerivedState) || checkDerivedStateChanged((DerivedState) obj2, mutableScatterMap)) {
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
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private final boolean checkDerivedStateChanged(DerivedState<?> derivedState, MutableScatterMap<DerivedState<?>, Object> mutableScatterMap) {
        Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
        if (policy == null) {
            policy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return !policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), mutableScatterMap.get(derivedState));
    }

    public final void rereadTrackedInstances() {
        MutableObjectIntMap<Object> mutableObjectIntMap;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner == null || (mutableObjectIntMap = this.trackedInstances) == null) {
            return;
        }
        setRereading(true);
        try {
            MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableObjectIntMap;
            Object[] objArr = mutableObjectIntMap2.keys;
            int[] iArr = mutableObjectIntMap2.values;
            long[] jArr = mutableObjectIntMap2.metadata;
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
                                int i5 = iArr[i4];
                                recomposeScopeOwner.recordReadOf(obj);
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
        } finally {
            setRereading(false);
        }
    }

    public final Function1<Composition, Unit> end(final int i) {
        final MutableObjectIntMap<Object> mutableObjectIntMap = this.trackedInstances;
        if (mutableObjectIntMap != null && !getSkipped$runtime_release()) {
            MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableObjectIntMap;
            Object[] objArr = mutableObjectIntMap2.keys;
            int[] iArr = mutableObjectIntMap2.values;
            long[] jArr = mutableObjectIntMap2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8 - ((~(i2 - length)) >>> 31);
                        for (int i4 = 0; i4 < i3; i4++) {
                            if ((255 & j) < 128) {
                                int i5 = (i2 << 3) + i4;
                                Object obj = objArr[i5];
                                if (iArr[i5] != i) {
                                    return new Function1<Composition, Unit>() { // from class: androidx.compose.runtime.RecomposeScopeImpl$end$1$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Composition composition) {
                                            invoke2(composition);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(Composition composition) {
                                            int i6;
                                            MutableObjectIntMap mutableObjectIntMap3;
                                            int i7;
                                            MutableScatterMap mutableScatterMap;
                                            i6 = RecomposeScopeImpl.this.currentToken;
                                            if (i6 != i) {
                                                return;
                                            }
                                            MutableObjectIntMap<Object> mutableObjectIntMap4 = mutableObjectIntMap;
                                            mutableObjectIntMap3 = RecomposeScopeImpl.this.trackedInstances;
                                            if (!Intrinsics.areEqual(mutableObjectIntMap4, mutableObjectIntMap3) || !(composition instanceof CompositionImpl)) {
                                                return;
                                            }
                                            MutableObjectIntMap<Object> mutableObjectIntMap5 = mutableObjectIntMap;
                                            int i8 = i;
                                            RecomposeScopeImpl recomposeScopeImpl = RecomposeScopeImpl.this;
                                            long[] jArr2 = mutableObjectIntMap5.metadata;
                                            int length2 = jArr2.length - 2;
                                            if (length2 < 0) {
                                                return;
                                            }
                                            int i9 = 0;
                                            while (true) {
                                                long j2 = jArr2[i9];
                                                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i10 = 8;
                                                    int i11 = 8 - ((~(i9 - length2)) >>> 31);
                                                    int i12 = 0;
                                                    while (i12 < i11) {
                                                        if ((255 & j2) < 128) {
                                                            int i13 = (i9 << 3) + i12;
                                                            Object obj2 = mutableObjectIntMap5.keys[i13];
                                                            boolean z = mutableObjectIntMap5.values[i13] != i8;
                                                            i7 = i10;
                                                            if (z) {
                                                                CompositionImpl compositionImpl = (CompositionImpl) composition;
                                                                compositionImpl.removeObservation$runtime_release(obj2, recomposeScopeImpl);
                                                                if (obj2 instanceof DerivedState) {
                                                                    compositionImpl.removeDerivedStateObservation$runtime_release((DerivedState) obj2);
                                                                    mutableScatterMap = recomposeScopeImpl.trackedDependencies;
                                                                    if (mutableScatterMap != null) {
                                                                        mutableScatterMap.remove(obj2);
                                                                    }
                                                                }
                                                            }
                                                            if (z) {
                                                                mutableObjectIntMap5.removeValueAt(i13);
                                                            }
                                                        } else {
                                                            i7 = i10;
                                                        }
                                                        j2 >>= i7;
                                                        i12++;
                                                        i10 = i7;
                                                    }
                                                    if (i11 != i10) {
                                                        return;
                                                    }
                                                }
                                                if (i9 == length2) {
                                                    return;
                                                }
                                                i9++;
                                            }
                                        }
                                    };
                                }
                            }
                            j >>= 8;
                        }
                        if (i3 != 8) {
                            break;
                        }
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return null;
    }

    /* compiled from: RecomposeScopeImpl.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", "()V", "adoptAnchoredScopes", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "anchors", "", "Landroidx/compose/runtime/Anchor;", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "adoptAnchoredScopes$runtime_release", "hasAnchoredRecomposeScopes", "", "Landroidx/compose/runtime/SlotTable;", "hasAnchoredRecomposeScopes$runtime_release", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void adoptAnchoredScopes$runtime_release(SlotWriter slotWriter, List<Anchor> list, RecomposeScopeOwner recomposeScopeOwner) {
            List<Anchor> list2 = list;
            if (list2.isEmpty()) {
                return;
            }
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                Object slot = slotWriter.slot(list.get(i), 0);
                RecomposeScopeImpl recomposeScopeImpl = slot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) slot : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.adoptedBy(recomposeScopeOwner);
                }
            }
        }

        public final boolean hasAnchoredRecomposeScopes$runtime_release(SlotTable slotTable, List<Anchor> list) {
            List<Anchor> list2 = list;
            if (!list2.isEmpty()) {
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    Anchor anchor = list.get(i);
                    if (slotTable.ownsAnchor(anchor) && (slotTable.slot$runtime_release(slotTable.anchorIndex(anchor), 0) instanceof RecomposeScopeImpl)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
