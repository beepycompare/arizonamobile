package com.arkivanov.decompose.router.panels;

import com.arizona.launcher.UpdateActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: Panels.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 1*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u0002*\n\b\u0002\u0010\u0004 \u0001*\u00020\u00022\u00020\u0002:\u000201B1\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000e\u0010\u0018\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00018\u0002HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JL\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00022\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010!\u001a\u00020\rHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0085\u0001\u0010$\u001a\u00020%\"\n\b\u0003\u0010\u0001*\u0004\u0018\u00010\u0002\"\n\b\u0004\u0010\u0003*\u0004\u0018\u00010\u0002\"\n\b\u0005\u0010\u0004*\u0004\u0018\u00010\u00022\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H\u00030,2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00040,H\u0001¢\u0006\u0002\b/R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0002¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00062"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Panels;", "MC", "", "DC", "EC", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "details", "extra", UpdateActivity.UPDATE_MODE, "Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMain", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDetails", "getExtra", "getMode", "()Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;)Lcom/arkivanov/decompose/router/panels/Panels;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "typeSerial1", "typeSerial2", "write$Self$decompose_release", "$serializer", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class Panels<MC, DC, EC> {
    private static final SerialDescriptor $cachedDescriptor;
    private final DC details;
    private final EC extra;
    private final MC main;
    private final ChildPanelsMode mode;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, EnumsKt.createSimpleEnumSerializer("com.arkivanov.decompose.router.panels.ChildPanelsMode", ChildPanelsMode.values())};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Panels copy$default(Panels panels, Object obj, Object obj2, Object obj3, ChildPanelsMode childPanelsMode, int i, Object obj4) {
        if ((i & 1) != 0) {
            obj = panels.main;
        }
        if ((i & 2) != 0) {
            obj2 = panels.details;
        }
        if ((i & 4) != 0) {
            obj3 = panels.extra;
        }
        if ((i & 8) != 0) {
            childPanelsMode = panels.mode;
        }
        return panels.copy(obj, obj2, obj3, childPanelsMode);
    }

    public final MC component1() {
        return this.main;
    }

    public final DC component2() {
        return this.details;
    }

    public final EC component3() {
        return this.extra;
    }

    public final ChildPanelsMode component4() {
        return this.mode;
    }

    public final Panels<MC, DC, EC> copy(MC main, DC dc, EC ec, ChildPanelsMode mode) {
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new Panels<>(main, dc, ec, mode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Panels) {
            Panels panels = (Panels) obj;
            return Intrinsics.areEqual(this.main, panels.main) && Intrinsics.areEqual(this.details, panels.details) && Intrinsics.areEqual(this.extra, panels.extra) && this.mode == panels.mode;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.main.hashCode() * 31;
        DC dc = this.details;
        int hashCode2 = (hashCode + (dc == null ? 0 : dc.hashCode())) * 31;
        EC ec = this.extra;
        return ((hashCode2 + (ec != null ? ec.hashCode() : 0)) * 31) + this.mode.hashCode();
    }

    public String toString() {
        return "Panels(main=" + this.main + ", details=" + this.details + ", extra=" + this.extra + ", mode=" + this.mode + ')';
    }

    /* compiled from: Panels.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00060\u0005\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\b\"\u0004\b\u0005\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005¨\u0006\r"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Panels$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/decompose/router/panels/Panels;", "MC", "DC", "EC", "typeSerial0", "typeSerial1", "typeSerial2", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <MC, DC, EC> KSerializer<Panels<MC, DC, EC>> serializer(KSerializer<MC> typeSerial0, KSerializer<DC> typeSerial1, KSerializer<EC> typeSerial2) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            Intrinsics.checkNotNullParameter(typeSerial1, "typeSerial1");
            Intrinsics.checkNotNullParameter(typeSerial2, "typeSerial2");
            return new Panels$$serializer(typeSerial0, typeSerial1, typeSerial2);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.arkivanov.decompose.router.panels.Panels", null, 4);
        pluginGeneratedSerialDescriptor.addElement(JvmProtoBufUtil.DEFAULT_MODULE_NAME, false);
        pluginGeneratedSerialDescriptor.addElement("details", true);
        pluginGeneratedSerialDescriptor.addElement("extra", true);
        pluginGeneratedSerialDescriptor.addElement(UpdateActivity.UPDATE_MODE, true);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Panels(int i, Object obj, Object obj2, Object obj3, ChildPanelsMode childPanelsMode, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, $cachedDescriptor);
        }
        this.main = obj;
        if ((i & 2) == 0) {
            this.details = null;
        } else {
            this.details = obj2;
        }
        if ((i & 4) == 0) {
            this.extra = null;
        } else {
            this.extra = obj3;
        }
        if ((i & 8) == 0) {
            this.mode = ChildPanelsMode.SINGLE;
        } else {
            this.mode = childPanelsMode;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$decompose_release(Panels panels, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor, KSerializer kSerializer, KSerializer kSerializer2, KSerializer kSerializer3) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, kSerializer, panels.main);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || panels.details != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, kSerializer2, panels.details);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || panels.extra != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, kSerializer3, panels.extra);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && panels.mode == ChildPanelsMode.SINGLE) {
            return;
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], panels.mode);
    }

    public Panels(MC main, DC dc, EC ec, ChildPanelsMode mode) {
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.main = main;
        this.details = dc;
        this.extra = ec;
        this.mode = mode;
    }

    public final MC getMain() {
        return this.main;
    }

    public final DC getDetails() {
        return this.details;
    }

    public final EC getExtra() {
        return this.extra;
    }

    public /* synthetic */ Panels(Object obj, Object obj2, Object obj3, ChildPanelsMode childPanelsMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : obj2, (i & 4) != 0 ? null : obj3, (i & 8) != 0 ? ChildPanelsMode.SINGLE : childPanelsMode);
    }

    public final ChildPanelsMode getMode() {
        return this.mode;
    }
}
