package com.arkivanov.decompose.router.children;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: TransientNavStateSaver.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004B\u001b\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0003\u0010\tJ%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0015R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/arkivanov/decompose/router/children/TransientSavedState;", "", "value", "<init>", "(Ljava/lang/Object;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$decompose_release", "$serializer", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
final class TransientSavedState {
    public static final Companion Companion = new Companion(null);
    private final Object value;

    public TransientSavedState() {
        this(null, 1, null);
    }

    @Transient
    public static /* synthetic */ void getValue$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$decompose_release(TransientSavedState transientSavedState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }

    /* compiled from: TransientNavStateSaver.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/children/TransientSavedState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/decompose/router/children/TransientSavedState;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TransientSavedState> serializer() {
            return TransientSavedState$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TransientSavedState(int i, SerializationConstructorMarker serializationConstructorMarker) {
        this.value = null;
    }

    public TransientSavedState(Object obj) {
        this.value = obj;
    }

    public /* synthetic */ TransientSavedState(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public final Object getValue() {
        return this.value;
    }
}
