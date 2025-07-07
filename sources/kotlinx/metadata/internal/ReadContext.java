package kotlinx.metadata.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import kotlinx.metadata.internal.metadata.deserialization.TypeTable;
import kotlinx.metadata.internal.metadata.deserialization.VersionRequirementTable;
/* compiled from: Readers.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u001f\u001a\u00060 j\u0002`!2\u0006\u0010\"\u001a\u00020\u001aH\u0000¢\u0006\u0002\b#J\u0011\u0010$\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001aH\u0086\u0002J\u0019\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010&\u001a\u00020\u001aH\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\fH\u0000¢\u0006\u0002\b,R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00078\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lkotlinx/metadata/internal/ReadContext;", "", "strings", "Lkotlinx/metadata/internal/metadata/deserialization/NameResolver;", "types", "Lkotlinx/metadata/internal/metadata/deserialization/TypeTable;", "versionRequirements", "Lkotlinx/metadata/internal/metadata/deserialization/VersionRequirementTable;", "ignoreUnknownVersionRequirements", "", "parent", "contextExtensions", "", "Lkotlinx/metadata/internal/ReadContextExtension;", "(Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/VersionRequirementTable;ZLkotlinx/metadata/internal/ReadContext;Ljava/util/List;)V", "getContextExtensions$kotlinx_metadata", "()Ljava/util/List;", "extensions", "Lkotlinx/metadata/internal/extensions/MetadataExtensions;", "getExtensions$kotlinx_metadata", "getIgnoreUnknownVersionRequirements$kotlinx_metadata", "()Z", "getStrings", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "typeParameterNameToId", "", "", "getTypes", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "getVersionRequirements$kotlinx_metadata", "()Lorg/jetbrains/kotlin/metadata/deserialization/VersionRequirementTable;", "className", "", "Lkotlinx/metadata/ClassName;", FirebaseAnalytics.Param.INDEX, "className$kotlinx_metadata", "get", "getTypeParameterId", "name", "getTypeParameterId$kotlinx_metadata", "(I)Ljava/lang/Integer;", "withTypeParameters", "typeParameters", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "withTypeParameters$kotlinx_metadata", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReadContext {
    private final List<ReadContextExtension> contextExtensions;
    private final List<MetadataExtensions> extensions;
    private final boolean ignoreUnknownVersionRequirements;
    private final ReadContext parent;
    private final NameResolver strings;
    private final Map<Integer, Integer> typeParameterNameToId;
    private final TypeTable types;
    private final VersionRequirementTable versionRequirements;

    /* JADX WARN: Multi-variable type inference failed */
    public ReadContext(NameResolver strings, TypeTable types, VersionRequirementTable versionRequirements, boolean z, ReadContext readContext, List<? extends ReadContextExtension> contextExtensions) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(versionRequirements, "versionRequirements");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        this.strings = strings;
        this.types = types;
        this.versionRequirements = versionRequirements;
        this.ignoreUnknownVersionRequirements = z;
        this.parent = readContext;
        this.contextExtensions = contextExtensions;
        this.typeParameterNameToId = new LinkedHashMap();
        this.extensions = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
    }

    public final NameResolver getStrings() {
        return this.strings;
    }

    public final TypeTable getTypes() {
        return this.types;
    }

    public final VersionRequirementTable getVersionRequirements$kotlinx_metadata() {
        return this.versionRequirements;
    }

    public final boolean getIgnoreUnknownVersionRequirements$kotlinx_metadata() {
        return this.ignoreUnknownVersionRequirements;
    }

    public /* synthetic */ ReadContext(NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, boolean z, ReadContext readContext, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nameResolver, typeTable, versionRequirementTable, z, (i & 16) != 0 ? null : readContext, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<ReadContextExtension> getContextExtensions$kotlinx_metadata() {
        return this.contextExtensions;
    }

    public final List<MetadataExtensions> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    public final String get(int i) {
        return this.strings.getString(i);
    }

    public final String className$kotlinx_metadata(int i) {
        return ReadUtilsKt.getClassName(this.strings, i);
    }

    public final Integer getTypeParameterId$kotlinx_metadata(int i) {
        Integer num = this.typeParameterNameToId.get(Integer.valueOf(i));
        if (num == null) {
            ReadContext readContext = this.parent;
            if (readContext != null) {
                return readContext.getTypeParameterId$kotlinx_metadata(i);
            }
            return null;
        }
        return num;
    }

    public final ReadContext withTypeParameters$kotlinx_metadata(List<ProtoBuf.TypeParameter> typeParameters) {
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        ReadContext readContext = new ReadContext(this.strings, this.types, this.versionRequirements, this.ignoreUnknownVersionRequirements, this, this.contextExtensions);
        for (ProtoBuf.TypeParameter typeParameter : typeParameters) {
            readContext.typeParameterNameToId.put(Integer.valueOf(typeParameter.getName()), Integer.valueOf(typeParameter.getId()));
        }
        return readContext;
    }
}
