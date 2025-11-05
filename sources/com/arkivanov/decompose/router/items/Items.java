package com.arkivanov.decompose.router.items;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: Items.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 (*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0003&'(B-\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J5\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001JE\u0010\u001c\u001a\u00020\u001d\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00010$H\u0001¢\u0006\u0002\b%R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/arkivanov/decompose/router/items/Items;", "C", "", "items", "", "activeItems", "", "Lcom/arkivanov/decompose/router/items/Items$ActiveLifecycleState;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItems", "()Ljava/util/List;", "getActiveItems", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$decompose_release", "ActiveLifecycleState", "$serializer", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class Items<C> {
    private static final SerialDescriptor $cachedDescriptor;
    public static final Companion Companion = new Companion(null);
    private final Map<C, ActiveLifecycleState> activeItems;
    private final List<C> items;

    public Items() {
        this((List) null, (Map) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Items copy$default(Items items, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = items.items;
        }
        if ((i & 2) != 0) {
            map = items.activeItems;
        }
        return items.copy(list, map);
    }

    public final List<C> component1() {
        return this.items;
    }

    public final Map<C, ActiveLifecycleState> component2() {
        return this.activeItems;
    }

    public final Items<C> copy(List<? extends C> items, Map<C, ? extends ActiveLifecycleState> activeItems) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(activeItems, "activeItems");
        return new Items<>(items, activeItems);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Items) {
            Items items = (Items) obj;
            return Intrinsics.areEqual(this.items, items.items) && Intrinsics.areEqual(this.activeItems, items.activeItems);
        }
        return false;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + this.activeItems.hashCode();
    }

    public String toString() {
        return "Items(items=" + this.items + ", activeItems=" + this.activeItems + ')';
    }

    /* compiled from: Items.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005¨\u0006\t"}, d2 = {"Lcom/arkivanov/decompose/router/items/Items$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/decompose/router/items/Items;", "C", "typeSerial0", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <C> KSerializer<Items<C>> serializer(KSerializer<C> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            return new Items$$serializer(typeSerial0);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.arkivanov.decompose.router.items.Items", null, 2);
        pluginGeneratedSerialDescriptor.addElement("items", true);
        pluginGeneratedSerialDescriptor.addElement("activeItems", true);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    public /* synthetic */ Items(int i, List list, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        this.items = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
        if ((i & 2) == 0) {
            this.activeItems = MapsKt.emptyMap();
        } else {
            this.activeItems = map;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$decompose_release(Items items, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor, KSerializer kSerializer) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(items.items, CollectionsKt.emptyList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, new ArrayListSerializer(kSerializer), items.items);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) && Intrinsics.areEqual(items.activeItems, MapsKt.emptyMap())) {
            return;
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, new LinkedHashMapSerializer(kSerializer, EnumsKt.createSimpleEnumSerializer("com.arkivanov.decompose.router.items.Items.ActiveLifecycleState", ActiveLifecycleState.values())), items.activeItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Items(List<? extends C> items, Map<C, ? extends ActiveLifecycleState> activeItems) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(activeItems, "activeItems");
        this.items = items;
        this.activeItems = activeItems;
    }

    public /* synthetic */ Items(List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final List<C> getItems() {
        return this.items;
    }

    public final Map<C, ActiveLifecycleState> getActiveItems() {
        return this.activeItems;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Items.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/items/Items$ActiveLifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", DebugCoroutineInfoImplKt.CREATED, "STARTED", "RESUMED", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ActiveLifecycleState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ActiveLifecycleState[] $VALUES;
        public static final ActiveLifecycleState CREATED = new ActiveLifecycleState(DebugCoroutineInfoImplKt.CREATED, 0);
        public static final ActiveLifecycleState STARTED = new ActiveLifecycleState("STARTED", 1);
        public static final ActiveLifecycleState RESUMED = new ActiveLifecycleState("RESUMED", 2);

        private static final /* synthetic */ ActiveLifecycleState[] $values() {
            return new ActiveLifecycleState[]{CREATED, STARTED, RESUMED};
        }

        public static EnumEntries<ActiveLifecycleState> getEntries() {
            return $ENTRIES;
        }

        private ActiveLifecycleState(String str, int i) {
        }

        static {
            ActiveLifecycleState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ActiveLifecycleState valueOf(String str) {
            return (ActiveLifecycleState) Enum.valueOf(ActiveLifecycleState.class, str);
        }

        public static ActiveLifecycleState[] values() {
            return (ActiveLifecycleState[]) $VALUES.clone();
        }
    }
}
