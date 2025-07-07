package kotlinx.metadata.internal.metadata.jvm.deserialization;

import kotlin.Metadata;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
/* compiled from: JvmFlags.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011R\u001b\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u001b\u0010\f\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b¨\u0006\u0015"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmFlags;", "", "<init>", "()V", "IS_MOVED_FROM_INTERFACE_COMPANION", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "kotlin.jvm.PlatformType", "getIS_MOVED_FROM_INTERFACE_COMPANION", "()Lorg/jetbrains/kotlin/metadata/deserialization/Flags$BooleanFlagField;", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "IS_COMPILED_IN_JVM_DEFAULT_MODE", "getIS_COMPILED_IN_JVM_DEFAULT_MODE", "IS_COMPILED_IN_COMPATIBILITY_MODE", "getIS_COMPILED_IN_COMPATIBILITY_MODE", "getPropertyFlags", "", "isMovedFromInterfaceCompanion", "", "getClassFlags", "isAllInterfaceBodiesInside", "isCompatibilityMode", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class JvmFlags {
    private static final Flags.BooleanFlagField IS_COMPILED_IN_COMPATIBILITY_MODE;
    private static final Flags.BooleanFlagField IS_COMPILED_IN_JVM_DEFAULT_MODE;
    public static final JvmFlags INSTANCE = new JvmFlags();
    private static final Flags.BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = Flags.FlagField.booleanFirst();

    private JvmFlags() {
    }

    static {
        Flags.BooleanFlagField booleanFirst = Flags.FlagField.booleanFirst();
        IS_COMPILED_IN_JVM_DEFAULT_MODE = booleanFirst;
        IS_COMPILED_IN_COMPATIBILITY_MODE = Flags.FlagField.booleanAfter(booleanFirst);
    }

    public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return IS_MOVED_FROM_INTERFACE_COMPANION;
    }

    public final Flags.BooleanFlagField getIS_COMPILED_IN_JVM_DEFAULT_MODE() {
        return IS_COMPILED_IN_JVM_DEFAULT_MODE;
    }

    public final Flags.BooleanFlagField getIS_COMPILED_IN_COMPATIBILITY_MODE() {
        return IS_COMPILED_IN_COMPATIBILITY_MODE;
    }

    public final int getPropertyFlags(boolean z) {
        return IS_MOVED_FROM_INTERFACE_COMPANION.toFlags(Boolean.valueOf(z));
    }

    public final int getClassFlags(boolean z, boolean z2) {
        return IS_COMPILED_IN_JVM_DEFAULT_MODE.toFlags(Boolean.valueOf(z)) | IS_COMPILED_IN_COMPATIBILITY_MODE.toFlags(Boolean.valueOf(z2));
    }
}
