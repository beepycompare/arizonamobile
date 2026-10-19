package kotlinx.metadata.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.serialization.MutableVersionRequirementTable;
import kotlinx.metadata.internal.metadata.serialization.StringTable;
/* compiled from: Writers.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086\u0002J\u0019\u0010\u0017\u001a\u00020\u00142\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0019H\u0000¢\u0006\u0002\b\u001aR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lkotlinx/metadata/internal/WriteContext;", "", "strings", "Lkotlinx/metadata/internal/metadata/serialization/StringTable;", "contextExtensions", "", "Lkotlinx/metadata/internal/WriteContextExtension;", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;Ljava/util/List;)V", "getContextExtensions", "()Ljava/util/List;", "extensions", "Lkotlinx/metadata/internal/extensions/MetadataExtensions;", "getExtensions$kotlinx_metadata", "getStrings", "()Lorg/jetbrains/kotlin/metadata/serialization/StringTable;", "versionRequirements", "Lkotlinx/metadata/internal/metadata/serialization/MutableVersionRequirementTable;", "getVersionRequirements$kotlinx_metadata", "()Lorg/jetbrains/kotlin/metadata/serialization/MutableVersionRequirementTable;", "get", "", TypedValues.Custom.S_STRING, "", "getClassName", "name", "Lkotlinx/metadata/ClassName;", "getClassName$kotlinx_metadata", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class WriteContext {
    private final List<WriteContextExtension> contextExtensions;
    private final List<MetadataExtensions> extensions;
    private final StringTable strings;
    private final MutableVersionRequirementTable versionRequirements;

    /* JADX WARN: Multi-variable type inference failed */
    public WriteContext(StringTable strings, List<? extends WriteContextExtension> contextExtensions) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        this.strings = strings;
        this.contextExtensions = contextExtensions;
        this.versionRequirements = new MutableVersionRequirementTable();
        this.extensions = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
    }

    public /* synthetic */ WriteContext(StringTable stringTable, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stringTable, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<WriteContextExtension> getContextExtensions() {
        return this.contextExtensions;
    }

    public final StringTable getStrings() {
        return this.strings;
    }

    public final MutableVersionRequirementTable getVersionRequirements$kotlinx_metadata() {
        return this.versionRequirements;
    }

    public final List<MetadataExtensions> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    public final int get(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return this.strings.getStringIndex(string);
    }

    public final int getClassName$kotlinx_metadata(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return WriteUtilsKt.getClassNameIndex(this.strings, name);
    }
}
