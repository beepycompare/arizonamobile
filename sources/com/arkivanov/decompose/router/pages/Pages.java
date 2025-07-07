package com.arkivanov.decompose.router.pages;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: Pages.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0002%&B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tB3\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001JE\u0010\u001b\u001a\u00020\u001c\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010#H\u0001¢\u0006\u0002\b$R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, d2 = {"Lcom/arkivanov/decompose/router/pages/Pages;", "C", "", FirebaseAnalytics.Param.ITEMS, "", "selectedIndex", "", "<init>", "(Ljava/util/List;I)V", "()V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItems", "()Ljava/util/List;", "getSelectedIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$decompose_release", "$serializer", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class Pages<C> {
    private static final SerialDescriptor $cachedDescriptor;
    public static final Companion Companion = new Companion(null);
    private final List<C> items;
    private final int selectedIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pages copy$default(Pages pages, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = pages.items;
        }
        if ((i2 & 2) != 0) {
            i = pages.selectedIndex;
        }
        return pages.copy(list, i);
    }

    public final List<C> component1() {
        return this.items;
    }

    public final int component2() {
        return this.selectedIndex;
    }

    public final Pages<C> copy(List<? extends C> items, int i) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new Pages<>(items, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pages) {
            Pages pages = (Pages) obj;
            return Intrinsics.areEqual(this.items, pages.items) && this.selectedIndex == pages.selectedIndex;
        }
        return false;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + Integer.hashCode(this.selectedIndex);
    }

    public String toString() {
        return "Pages(items=" + this.items + ", selectedIndex=" + this.selectedIndex + ')';
    }

    /* compiled from: Pages.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005¨\u0006\t"}, d2 = {"Lcom/arkivanov/decompose/router/pages/Pages$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/decompose/router/pages/Pages;", "C", "typeSerial0", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <C> KSerializer<Pages<C>> serializer(KSerializer<C> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            return new Pages$$serializer(typeSerial0);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.arkivanov.decompose.router.pages.Pages", null, 2);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, false);
        pluginGeneratedSerialDescriptor.addElement("selectedIndex", false);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    public /* synthetic */ Pages(int i, List list, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, $cachedDescriptor);
        }
        this.items = list;
        this.selectedIndex = i2;
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        if (i2 < 0 || i2 >= size) {
            throw new IllegalArgumentException(("The selectedIndex argument must be with the range: " + CollectionsKt.getIndices(list) + ". Actual: " + i2 + '.').toString());
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$decompose_release(Pages pages, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor, KSerializer kSerializer) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, new ArrayListSerializer(kSerializer), pages.items);
        compositeEncoder.encodeIntElement(serialDescriptor, 1, pages.selectedIndex);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Pages(List<? extends C> items, int i) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
        this.selectedIndex = i;
        if (items.isEmpty()) {
            return;
        }
        int size = items.size();
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException(("The selectedIndex argument must be with the range: " + CollectionsKt.getIndices(items) + ". Actual: " + i + '.').toString());
        }
    }

    public final List<C> getItems() {
        return this.items;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public Pages() {
        this(CollectionsKt.emptyList(), -1);
    }
}
