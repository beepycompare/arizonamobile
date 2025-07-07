package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: LazySaveableStateHolder.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB7\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0002\u0010\fJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0002\b\u0014H\u0017¢\u0006\u0002\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0096\u0001J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0001J\u001c\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0005H\u0016J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00062\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0013H\u0096\u0001J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "parentRegistry", "restoredValues", "", "", "", "", "wrappedHolder", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/util/Map;Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "wrappedRegistry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "previouslyComposedKeys", "Landroidx/collection/MutableScatterSet;", "SaveableStateProvider", "", "key", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "canBeSaved", "", "value", "consumeRestored", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "removeState", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class LazySaveableStateHolder implements SaveableStateRegistry, SaveableStateHolder {
    public static final Companion Companion = new Companion(null);
    private final MutableScatterSet<Object> previouslyComposedKeys;
    private final SaveableStateHolder wrappedHolder;
    private final SaveableStateRegistry wrappedRegistry;

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object obj) {
        return this.wrappedRegistry.canBeSaved(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String str) {
        return this.wrappedRegistry.consumeRestored(str);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry registerProvider(String str, Function0<? extends Object> function0) {
        return this.wrappedRegistry.registerProvider(str, function0);
    }

    public LazySaveableStateHolder(SaveableStateRegistry saveableStateRegistry, SaveableStateHolder saveableStateHolder) {
        this.wrappedRegistry = saveableStateRegistry;
        this.wrappedHolder = saveableStateHolder;
        this.previouslyComposedKeys = ScatterSetKt.mutableScatterSetOf();
    }

    public LazySaveableStateHolder(final SaveableStateRegistry saveableStateRegistry, Map<String, ? extends List<? extends Object>> map, SaveableStateHolder saveableStateHolder) {
        this(SaveableStateRegistryKt.SaveableStateRegistry(map, new Function1<Object, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.1
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                SaveableStateRegistry saveableStateRegistry2 = SaveableStateRegistry.this;
                return Boolean.valueOf(saveableStateRegistry2 != null ? saveableStateRegistry2.canBeSaved(obj) : true);
            }
        }), saveableStateHolder);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map<String, List<Object>> performSave() {
        MutableScatterSet<Object> mutableScatterSet = this.previouslyComposedKeys;
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
                            this.wrappedHolder.removeState(objArr[(i << 3) + i3]);
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
        return this.wrappedRegistry.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void SaveableStateProvider(final Object obj, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceGroup(-697180401);
        ComposerKt.sourceInformation(composer, "C(SaveableStateProvider)P(1)75@3301L35,76@3367L109,76@3345L131:LazySaveableStateHolder.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-697180401, i, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:74)");
        }
        int i2 = i & 14;
        this.wrappedHolder.SaveableStateProvider(obj, function2, composer, i & WebSocketProtocol.PAYLOAD_SHORT);
        ComposerKt.sourceInformationMarkerStart(composer, 622442072, "CC(remember):LazySaveableStateHolder.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this) | composer.changedInstance(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    MutableScatterSet mutableScatterSet;
                    mutableScatterSet = LazySaveableStateHolder.this.previouslyComposedKeys;
                    mutableScatterSet.minusAssign((MutableScatterSet) obj);
                    final LazySaveableStateHolder lazySaveableStateHolder = LazySaveableStateHolder.this;
                    final Object obj2 = obj;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            MutableScatterSet mutableScatterSet2;
                            mutableScatterSet2 = LazySaveableStateHolder.this.previouslyComposedKeys;
                            mutableScatterSet2.plusAssign((MutableScatterSet) obj2);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(obj, (Function1) rememberedValue, composer, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void removeState(Object obj) {
        this.wrappedHolder.removeState(obj);
    }

    /* compiled from: LazySaveableStateHolder.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u00060\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder$Companion;", "", "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "", "", "", "parentRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "wrappedHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazySaveableStateHolder, Map<String, List<Object>>> saver(final SaveableStateRegistry saveableStateRegistry, final SaveableStateHolder saveableStateHolder) {
            return SaverKt.Saver(new Function2<SaverScope, LazySaveableStateHolder, Map<String, ? extends List<? extends Object>>>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$1
                @Override // kotlin.jvm.functions.Function2
                public final Map<String, List<Object>> invoke(SaverScope saverScope, LazySaveableStateHolder lazySaveableStateHolder) {
                    Map<String, List<Object>> performSave = lazySaveableStateHolder.performSave();
                    if (performSave.isEmpty()) {
                        return null;
                    }
                    return performSave;
                }
            }, new Function1<Map<String, ? extends List<? extends Object>>, LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final LazySaveableStateHolder invoke(Map<String, ? extends List<? extends Object>> map) {
                    return new LazySaveableStateHolder(SaveableStateRegistry.this, map, saveableStateHolder);
                }
            });
        }
    }
}
