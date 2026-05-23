package com.arkivanov.decompose.router.children;

import com.arkivanov.decompose.router.children.ChildrenNavigator;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildrenFactory.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/arkivanov/decompose/router/children/SavedState;", "", "navState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "childState", "", "Lcom/arkivanov/decompose/router/children/ChildrenNavigator$SavedChildState;", "<init>", "(Lcom/arkivanov/essenty/statekeeper/SerializableContainer;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/arkivanov/essenty/statekeeper/SerializableContainer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNavState", "()Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "getChildState", "()Ljava/util/List;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$decompose_release", "$serializer", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class SavedState {
    private final List<ChildrenNavigator.SavedChildState> childState;
    private final SerializableContainer navState;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(ChildrenNavigator$SavedChildState$$serializer.INSTANCE)};

    /* compiled from: ChildrenFactory.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/children/SavedState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/decompose/router/children/SavedState;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SavedState> serializer() {
            return SavedState$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SavedState(int i, SerializableContainer serializableContainer, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, SavedState$$serializer.INSTANCE.getDescriptor());
        }
        this.navState = serializableContainer;
        this.childState = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$decompose_release(SavedState savedState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, SerializableContainer.Serializer.INSTANCE, savedState.navState);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], savedState.childState);
    }

    public SavedState(SerializableContainer navState, List<ChildrenNavigator.SavedChildState> childState) {
        Intrinsics.checkNotNullParameter(navState, "navState");
        Intrinsics.checkNotNullParameter(childState, "childState");
        this.navState = navState;
        this.childState = childState;
    }

    public final SerializableContainer getNavState() {
        return this.navState;
    }

    public final List<ChildrenNavigator.SavedChildState> getChildState() {
        return this.childState;
    }
}
