package kotlinx.metadata.internal.common;

import java.io.ByteArrayInputStream;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.internal.ReadersKt;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.builtins.ReadPackageFragmentKt;
import kotlinx.metadata.internal.metadata.deserialization.NameResolverImpl;
/* compiled from: KotlinCommonMetadata.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkotlinx/metadata/internal/common/KotlinCommonMetadata;", "", "proto", "Lkotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$PackageFragment;)V", "kmModuleFragment", "Lkotlinx/metadata/internal/common/KmModuleFragment;", "getKmModuleFragment", "()Lkotlinx/metadata/internal/common/KmModuleFragment;", "accept", "", "v", "Lkotlinx/metadata/internal/common/KmModuleFragmentVisitor;", "readImpl", "toKmModuleFragment", "Companion", "Writer", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinCommonMetadata {
    public static final Companion Companion = new Companion(null);
    private final KmModuleFragment kmModuleFragment;

    public /* synthetic */ KotlinCommonMetadata(ProtoBuf.PackageFragment packageFragment, DefaultConstructorMarker defaultConstructorMarker) {
        this(packageFragment);
    }

    @JvmStatic
    public static final KotlinCommonMetadata read(byte[] bArr) {
        return Companion.read(bArr);
    }

    private KotlinCommonMetadata(ProtoBuf.PackageFragment packageFragment) {
        this.kmModuleFragment = readImpl(packageFragment);
    }

    public final KmModuleFragment getKmModuleFragment() {
        return this.kmModuleFragment;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "To avoid excessive copying, use .kmModuleFragment property instead. Note that it returns a view and not a copy.", replaceWith = @ReplaceWith(expression = "kmModuleFragment", imports = {}))
    public final KmModuleFragment toKmModuleFragment() {
        KmModuleFragment kmModuleFragment = new KmModuleFragment();
        this.kmModuleFragment.accept(kmModuleFragment);
        return kmModuleFragment;
    }

    /* compiled from: KotlinCommonMetadata.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/metadata/internal/common/KotlinCommonMetadata$Writer;", "Lkotlinx/metadata/internal/common/KmModuleFragmentVisitor;", "()V", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Writer extends KmModuleFragmentVisitor {
        public Writer() {
            super(null, 1, null);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmModuleFragmentVisitor v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.kmModuleFragment.accept(v);
    }

    private final KmModuleFragment readImpl(ProtoBuf.PackageFragment packageFragment) {
        KmModuleFragment kmModuleFragment = new KmModuleFragment();
        ProtoBuf.StringTable strings = packageFragment.getStrings();
        Intrinsics.checkNotNullExpressionValue(strings, "getStrings(...)");
        ProtoBuf.QualifiedNameTable qualifiedNames = packageFragment.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(qualifiedNames, "getQualifiedNames(...)");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        if (packageFragment.hasPackage()) {
            ProtoBuf.Package r3 = packageFragment.getPackage();
            Intrinsics.checkNotNullExpressionValue(r3, "getPackage(...)");
            kmModuleFragment.setPkg(ReadersKt.toKmPackage$default(r3, nameResolverImpl, false, null, 6, null));
        }
        List<ProtoBuf.Class> class_List = packageFragment.getClass_List();
        Intrinsics.checkNotNullExpressionValue(class_List, "getClass_List(...)");
        List<KmClass> classes = kmModuleFragment.getClasses();
        for (ProtoBuf.Class r4 : class_List) {
            Intrinsics.checkNotNull(r4);
            classes.add(ReadersKt.toKmClass$default(r4, nameResolverImpl, false, null, 6, null));
        }
        return kmModuleFragment;
    }

    /* compiled from: KotlinCommonMetadata.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lkotlinx/metadata/internal/common/KotlinCommonMetadata$Companion;", "", "()V", "read", "Lkotlinx/metadata/internal/common/KotlinCommonMetadata;", "bytes", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final KotlinCommonMetadata read(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            ProtoBuf.PackageFragment component1 = ReadPackageFragmentKt.readBuiltinsPackageFragment(new ByteArrayInputStream(bytes)).component1();
            if (component1 == null) {
                return null;
            }
            return new KotlinCommonMetadata(component1, null);
        }
    }
}
