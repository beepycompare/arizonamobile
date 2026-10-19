package kotlinx.metadata.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: JvmMetadataVersion.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lkotlinx/metadata/jvm/JvmMetadataVersion;", "", "major", "", "minor", "(II)V", "intArray", "", "([I)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "compareTo", "other", "equals", "", "", "hashCode", "toIntArray", "toString", "", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmMetadataVersion implements Comparable<JvmMetadataVersion> {
    private final int major;
    private final int minor;
    private final int patch;
    public static final Companion Companion = new Companion(null);
    public static final JvmMetadataVersion LATEST_STABLE_SUPPORTED = new JvmMetadataVersion(1, 9, 0);
    public static final JvmMetadataVersion HIGHEST_ALLOWED_TO_WRITE = new JvmMetadataVersion(2, 0, 0);

    public JvmMetadataVersion(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        if (i < 0) {
            throw new IllegalArgumentException("Major version should be not less than 0".toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Minor version should be not less than 0".toString());
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Patch version should be not less than 0".toString());
        }
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public JvmMetadataVersion(int i, int i2) {
        this(i, i2, 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int[] intArray) {
        this(intArray[0], intArray[1], intArray[2]);
        Intrinsics.checkNotNullParameter(intArray, "intArray");
    }

    public final int[] toIntArray() {
        return new int[]{this.major, this.minor, this.patch};
    }

    @Override // java.lang.Comparable
    public int compareTo(JvmMetadataVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int compare = Intrinsics.compare(this.major, other.major);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Intrinsics.compare(this.minor, other.minor);
        return compare2 != 0 ? compare2 : Intrinsics.compare(this.patch, other.patch);
    }

    public String toString() {
        return new StringBuilder().append(this.major).append('.').append(this.minor).append('.').append(this.patch).toString();
    }

    public int hashCode() {
        return (((this.major * 31) + this.minor) * 31) + this.patch;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.metadata.jvm.JvmMetadataVersion");
            JvmMetadataVersion jvmMetadataVersion = (JvmMetadataVersion) obj;
            return this.major == jvmMetadataVersion.major && this.minor == jvmMetadataVersion.minor && this.patch == jvmMetadataVersion.patch;
        }
        return false;
    }

    /* compiled from: JvmMetadataVersion.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/metadata/jvm/JvmMetadataVersion$Companion;", "", "()V", "HIGHEST_ALLOWED_TO_WRITE", "Lkotlinx/metadata/jvm/JvmMetadataVersion;", "LATEST_STABLE_SUPPORTED", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
