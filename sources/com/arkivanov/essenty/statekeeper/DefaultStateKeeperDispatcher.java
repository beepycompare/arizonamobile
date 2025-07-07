package com.arkivanov.essenty.statekeeper;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: DefaultStateKeeperDispatcher.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0002J/\u0010\u0010\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0013H\u0016¢\u0006\u0002\u0010\u0014J8\u0010\u0015\u001a\u00020\u0016\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00172\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tj\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/DefaultStateKeeperDispatcher;", "Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "savedState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "<init>", "(Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)V", "", "", "suppliers", "Ljava/util/HashMap;", "Lcom/arkivanov/essenty/statekeeper/DefaultStateKeeperDispatcher$Supplier;", "Lkotlin/collections/HashMap;", "save", "toSerializableContainer", ExifInterface.GPS_DIRECTION_TRUE, "", "consume", "key", "strategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Ljava/lang/String;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "register", "", "Lkotlinx/serialization/SerializationStrategy;", "supplier", "Lkotlin/Function0;", "unregister", "isRegistered", "", "Supplier", "SavedState", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultStateKeeperDispatcher implements StateKeeperDispatcher {
    private final Map<String, SerializableContainer> savedState;
    private final HashMap<String, Supplier<?>> suppliers;

    public DefaultStateKeeperDispatcher(SerializableContainer serializableContainer) {
        SavedState savedState;
        this.savedState = (serializableContainer == null || (savedState = (SavedState) serializableContainer.consume(SavedState.Companion.serializer())) == null) ? null : savedState.getMap();
        this.suppliers = new HashMap<>();
    }

    @Override // com.arkivanov.essenty.statekeeper.StateKeeperDispatcher
    public SerializableContainer save() {
        HashMap hashMap;
        Map<String, SerializableContainer> map = this.savedState;
        if (map == null || (hashMap = MapsKt.toMutableMap(map)) == null) {
            hashMap = new HashMap();
        }
        for (Map.Entry<String, Supplier<?>> entry : this.suppliers.entrySet()) {
            String key = entry.getKey();
            SerializableContainer serializableContainer = toSerializableContainer(entry.getValue());
            if (serializableContainer != null) {
                hashMap.put(key, serializableContainer);
            }
        }
        return SerializableContainerKt.SerializableContainer(new SavedState(hashMap), SavedState.Companion.serializer());
    }

    private final <T> SerializableContainer toSerializableContainer(Supplier<T> supplier) {
        T invoke = supplier.getSupplier().invoke();
        if (invoke != null) {
            return SerializableContainerKt.SerializableContainer(invoke, supplier.getStrategy());
        }
        return null;
    }

    @Override // com.arkivanov.essenty.statekeeper.StateKeeper
    public <T> T consume(String key, DeserializationStrategy<? extends T> strategy) {
        SerializableContainer remove;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Map<String, SerializableContainer> map = this.savedState;
        if (map == null || (remove = map.remove(key)) == null) {
            return null;
        }
        return (T) remove.consume(strategy);
    }

    @Override // com.arkivanov.essenty.statekeeper.StateKeeper
    public <T> void register(String key, SerializationStrategy<? super T> strategy, Function0<? extends T> supplier) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(supplier, "supplier");
        if (isRegistered(key)) {
            throw new IllegalStateException(("Another supplier is already registered with the key: " + key).toString());
        }
        this.suppliers.put(key, new Supplier<>(strategy, supplier));
    }

    @Override // com.arkivanov.essenty.statekeeper.StateKeeper
    public void unregister(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!isRegistered(key)) {
            throw new IllegalStateException(("No supplier is registered with the key: " + key).toString());
        }
        this.suppliers.remove(key);
    }

    @Override // com.arkivanov.essenty.statekeeper.StateKeeper
    public boolean isRegistered(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.suppliers.containsKey(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultStateKeeperDispatcher.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/DefaultStateKeeperDispatcher$Supplier;", ExifInterface.GPS_DIRECTION_TRUE, "", "strategy", "Lkotlinx/serialization/SerializationStrategy;", "supplier", "Lkotlin/Function0;", "<init>", "(Lkotlinx/serialization/SerializationStrategy;Lkotlin/jvm/functions/Function0;)V", "getStrategy", "()Lkotlinx/serialization/SerializationStrategy;", "getSupplier", "()Lkotlin/jvm/functions/Function0;", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Supplier<T> {
        private final SerializationStrategy<T> strategy;
        private final Function0<T> supplier;

        /* JADX WARN: Multi-variable type inference failed */
        public Supplier(SerializationStrategy<? super T> strategy, Function0<? extends T> supplier) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            Intrinsics.checkNotNullParameter(supplier, "supplier");
            this.strategy = strategy;
            this.supplier = supplier;
        }

        public final SerializationStrategy<T> getStrategy() {
            return this.strategy;
        }

        public final Function0<T> getSupplier() {
            return this.supplier;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultStateKeeperDispatcher.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007B1\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ%\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/DefaultStateKeeperDispatcher$SavedState;", "", "map", "", "", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "<init>", "(Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMap", "()Ljava/util/Map;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$state_keeper_release", "$serializer", "Companion", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes3.dex */
    public static final class SavedState {
        private final Map<String, SerializableContainer> map;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(StringSerializer.INSTANCE, SerializableContainer.Serializer.INSTANCE)};

        /* compiled from: DefaultStateKeeperDispatcher.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/DefaultStateKeeperDispatcher$SavedState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/essenty/statekeeper/DefaultStateKeeperDispatcher$SavedState;", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SavedState> serializer() {
                return DefaultStateKeeperDispatcher$SavedState$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SavedState(int i, Map map, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, DefaultStateKeeperDispatcher$SavedState$$serializer.INSTANCE.getDescriptor());
            }
            this.map = map;
        }

        public SavedState(Map<String, SerializableContainer> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
        }

        public final Map<String, SerializableContainer> getMap() {
            return this.map;
        }
    }
}
