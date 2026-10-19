package kotlinx.metadata.jvm;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.Flag;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmFlags;
/* compiled from: JvmFlag.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding extensions on Km nodes, such as KmClass.hasMethodBodiesInInterface")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\n"}, d2 = {"Lkotlinx/metadata/jvm/JvmFlag;", "", "()V", "booleanFlag", "Lkotlinx/metadata/Flag;", "f", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "booleanFlag$kotlinx_metadata_jvm", "Class", "Property", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmFlag {
    public static final JvmFlag INSTANCE = new JvmFlag();

    private JvmFlag() {
    }

    /* compiled from: JvmFlag.kt */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding extension on KmProperty: KmProperty.isMovedFromInterfaceCompanion")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Lkotlinx/metadata/jvm/JvmFlag$Property;", "", "()V", "IS_MOVED_FROM_INTERFACE_COMPANION", "Lkotlinx/metadata/Flag;", "getIS_MOVED_FROM_INTERFACE_COMPANION$annotations", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Property {
        public static final Property INSTANCE = new Property();
        public static final Flag IS_MOVED_FROM_INTERFACE_COMPANION;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.isMovedFromInterfaceCompanion")
        public static /* synthetic */ void getIS_MOVED_FROM_INTERFACE_COMPANION$annotations() {
        }

        private Property() {
        }

        static {
            JvmFlag jvmFlag = JvmFlag.INSTANCE;
            Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
            Intrinsics.checkNotNullExpressionValue(is_moved_from_interface_companion, "<get-IS_MOVED_FROM_INTERFACE_COMPANION>(...)");
            IS_MOVED_FROM_INTERFACE_COMPANION = jvmFlag.booleanFlag$kotlinx_metadata_jvm(is_moved_from_interface_companion);
        }
    }

    /* compiled from: JvmFlag.kt */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding extensions on KmClass")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, d2 = {"Lkotlinx/metadata/jvm/JvmFlag$Class;", "", "()V", "HAS_METHOD_BODIES_IN_INTERFACE", "Lkotlinx/metadata/Flag;", "getHAS_METHOD_BODIES_IN_INTERFACE$annotations", "IS_COMPILED_IN_COMPATIBILITY_MODE", "getIS_COMPILED_IN_COMPATIBILITY_MODE$annotations", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Class {
        public static final Flag HAS_METHOD_BODIES_IN_INTERFACE;
        public static final Class INSTANCE = new Class();
        public static final Flag IS_COMPILED_IN_COMPATIBILITY_MODE;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.hasMethodBodiesInInterface")
        public static /* synthetic */ void getHAS_METHOD_BODIES_IN_INTERFACE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.isCompiledInCompatibilityMode")
        public static /* synthetic */ void getIS_COMPILED_IN_COMPATIBILITY_MODE$annotations() {
        }

        private Class() {
        }

        static {
            JvmFlag jvmFlag = JvmFlag.INSTANCE;
            Flags.BooleanFlagField is_compiled_in_jvm_default_mode = JvmFlags.INSTANCE.getIS_COMPILED_IN_JVM_DEFAULT_MODE();
            Intrinsics.checkNotNullExpressionValue(is_compiled_in_jvm_default_mode, "<get-IS_COMPILED_IN_JVM_DEFAULT_MODE>(...)");
            HAS_METHOD_BODIES_IN_INTERFACE = jvmFlag.booleanFlag$kotlinx_metadata_jvm(is_compiled_in_jvm_default_mode);
            JvmFlag jvmFlag2 = JvmFlag.INSTANCE;
            Flags.BooleanFlagField is_compiled_in_compatibility_mode = JvmFlags.INSTANCE.getIS_COMPILED_IN_COMPATIBILITY_MODE();
            Intrinsics.checkNotNullExpressionValue(is_compiled_in_compatibility_mode, "<get-IS_COMPILED_IN_COMPATIBILITY_MODE>(...)");
            IS_COMPILED_IN_COMPATIBILITY_MODE = jvmFlag2.booleanFlag$kotlinx_metadata_jvm(is_compiled_in_compatibility_mode);
        }
    }

    public final Flag booleanFlag$kotlinx_metadata_jvm(Flags.BooleanFlagField f) {
        Intrinsics.checkNotNullParameter(f, "f");
        return new Flag(f.offset, f.bitWidth, 1);
    }
}
