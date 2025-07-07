package kotlinx.metadata.internal.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.deserialization.BinaryVersion;
/* compiled from: JvmMetadataVersion.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0015\b\u0016\u0012\n\u0010\b\u001a\u00020\u0003\"\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0000J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0000H\u0002J\u0006\u0010\u0012\u001a\u00020\u0000J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0000H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "Lkotlinx/metadata/internal/metadata/deserialization/BinaryVersion;", "versionArray", "", "isStrictSemantics", "", "<init>", "([IZ)V", "numbers", "", "([I)V", "()Z", "lastSupportedVersionWithThisLanguageVersion", "isCompatibleWithCurrentCompilerVersion", "isCompatible", "metadataVersionFromLanguageVersion", "isCompatibleInternal", "limitVersion", "next", "newerThan", "other", "Companion", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = new Companion(null);
    public static final JvmMetadataVersion INSTANCE;
    public static final JvmMetadataVersion INSTANCE_NEXT;
    public static final JvmMetadataVersion INVALID_VERSION;
    private final boolean isStrictSemantics;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int[] versionArray, boolean z) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        Intrinsics.checkNotNullParameter(versionArray, "versionArray");
        this.isStrictSemantics = z;
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int... numbers) {
        this(numbers, false);
        Intrinsics.checkNotNullParameter(numbers, "numbers");
    }

    public final JvmMetadataVersion lastSupportedVersionWithThisLanguageVersion(boolean z) {
        JvmMetadataVersion jvmMetadataVersion = z ? INSTANCE : INSTANCE_NEXT;
        return jvmMetadataVersion.newerThan(this) ? jvmMetadataVersion : this;
    }

    @Override // kotlinx.metadata.internal.metadata.deserialization.BinaryVersion
    public boolean isCompatibleWithCurrentCompilerVersion() {
        return isCompatibleInternal(this.isStrictSemantics ? INSTANCE : INSTANCE_NEXT);
    }

    public final boolean isCompatible(JvmMetadataVersion metadataVersionFromLanguageVersion) {
        Intrinsics.checkNotNullParameter(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        if (getMajor() == 2 && getMinor() == 0) {
            JvmMetadataVersion jvmMetadataVersion = INSTANCE;
            if (jvmMetadataVersion.getMajor() == 1 && jvmMetadataVersion.getMinor() == 8) {
                return true;
            }
        }
        return isCompatibleInternal(metadataVersionFromLanguageVersion.lastSupportedVersionWithThisLanguageVersion(this.isStrictSemantics));
    }

    private final boolean isCompatibleInternal(JvmMetadataVersion jvmMetadataVersion) {
        if ((getMajor() == 1 && getMinor() == 0) || getMajor() == 0) {
            return false;
        }
        return !newerThan(jvmMetadataVersion);
    }

    public final JvmMetadataVersion next() {
        return (getMajor() == 1 && getMinor() == 9) ? new JvmMetadataVersion(2, 0, 0) : new JvmMetadataVersion(getMajor(), getMinor() + 1, 0);
    }

    private final boolean newerThan(JvmMetadataVersion jvmMetadataVersion) {
        if (getMajor() > jvmMetadataVersion.getMajor()) {
            return true;
        }
        return getMajor() >= jvmMetadataVersion.getMajor() && getMinor() > jvmMetadataVersion.getMinor();
    }

    /* compiled from: JvmMetadataVersion.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion$Companion;", "", "<init>", "()V", "INSTANCE", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "INSTANCE_NEXT", "INVALID_VERSION", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(2, 0, 0);
        INSTANCE = jvmMetadataVersion;
        INSTANCE_NEXT = jvmMetadataVersion.next();
        INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    }
}
