package kotlinx.metadata.internal.extensions;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmConstructor;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmType;
import kotlinx.metadata.KmTypeAlias;
import kotlinx.metadata.KmTypeParameter;
import kotlinx.metadata.KmValueParameter;
import kotlinx.metadata.internal.ReadContext;
import kotlinx.metadata.internal.WriteContext;
import kotlinx.metadata.internal.common.KmModuleFragment;
import kotlinx.metadata.internal.metadata.ProtoBuf;
/* compiled from: MetadataExtensions.kt */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 Z2\u00020\u0001:\u0001ZJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u0010\u001a\u001a\u0002012\u0006\u0010\u001c\u001a\u00020\u001dH&J \u00102\u001a\u00020\u00172\u0006\u00103\u001a\u0002042\u0006\u0010\u001a\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001dH&J \u00106\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u0010\u001a\u001a\u0002092\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020=2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020@2\u0006\u0010\u001a\u001a\u00020A2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010B\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020C2\u0006\u0010\u001c\u001a\u00020DH&J \u0010E\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020F2\u0006\u0010\u001c\u001a\u00020DH&J \u0010G\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020H2\u0006\u0010\u001c\u001a\u00020DH&J \u0010I\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020J2\u0006\u0010\u001c\u001a\u00020DH&J \u0010K\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020L2\u0006\u0010\u001c\u001a\u00020DH&J \u0010M\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u0010\u001a\u001a\u00020N2\u0006\u0010\u001c\u001a\u00020DH&J \u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u0002042\u0006\u0010\u001a\u001a\u00020Q2\u0006\u0010\u001c\u001a\u00020DH&J \u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u0002082\u0006\u0010\u001a\u001a\u00020T2\u0006\u0010\u001c\u001a\u00020DH&J \u0010U\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020V2\u0006\u0010\u001c\u001a\u00020DH&J \u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020@2\u0006\u0010\u001a\u001a\u00020Y2\u0006\u0010\u001c\u001a\u00020DH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006[À\u0006\u0001"}, d2 = {"Lkotlinx/metadata/internal/extensions/MetadataExtensions;", "", "createClassExtension", "Lkotlinx/metadata/internal/extensions/KmClassExtension;", "createConstructorExtension", "Lkotlinx/metadata/internal/extensions/KmConstructorExtension;", "createFunctionExtension", "Lkotlinx/metadata/internal/extensions/KmFunctionExtension;", "createModuleFragmentExtensions", "Lkotlinx/metadata/internal/extensions/KmModuleFragmentExtension;", "createPackageExtension", "Lkotlinx/metadata/internal/extensions/KmPackageExtension;", "createPropertyExtension", "Lkotlinx/metadata/internal/extensions/KmPropertyExtension;", "createTypeAliasExtension", "Lkotlinx/metadata/internal/extensions/KmTypeAliasExtension;", "createTypeExtension", "Lkotlinx/metadata/internal/extensions/KmTypeExtension;", "createTypeParameterExtension", "Lkotlinx/metadata/internal/extensions/KmTypeParameterExtension;", "createValueParameterExtension", "Lkotlinx/metadata/internal/extensions/KmValueParameterExtension;", "readClassExtensions", "", "kmClass", "Lkotlinx/metadata/KmClass;", "proto", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Class;", "c", "Lkotlinx/metadata/internal/ReadContext;", "readConstructorExtensions", "kmConstructor", "Lkotlinx/metadata/KmConstructor;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Constructor;", "readFunctionExtensions", "kmFunction", "Lkotlinx/metadata/KmFunction;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Function;", "readModuleFragmentExtensions", "kmModuleFragment", "Lkotlinx/metadata/internal/common/KmModuleFragment;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "readPackageExtensions", "kmPackage", "Lkotlinx/metadata/KmPackage;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Package;", "readPropertyExtensions", "kmProperty", "Lkotlinx/metadata/KmProperty;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Property;", "readTypeAliasExtensions", "kmTypeAlias", "Lkotlinx/metadata/KmTypeAlias;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias;", "readTypeExtensions", "kmType", "Lkotlinx/metadata/KmType;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Type;", "readTypeParameterExtensions", "kmTypeParameter", "Lkotlinx/metadata/KmTypeParameter;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "readValueParameterExtensions", "kmValueParameter", "Lkotlinx/metadata/KmValueParameter;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter;", "writeClassExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Class$Builder;", "Lkotlinx/metadata/internal/WriteContext;", "writeConstructorExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Constructor$Builder;", "writeFunctionExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "writeModuleFragmentExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment$Builder;", "writePackageExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Package$Builder;", "writePropertyExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Property$Builder;", "writeTypeAliasExtensions", "typeAlias", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias$Builder;", "writeTypeExtensions", "type", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "writeTypeParameterExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter$Builder;", "writeValueParameterExtensions", "valueParameter", "Lkotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter$Builder;", "Companion", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MetadataExtensions {
    public static final Companion Companion = Companion.$$INSTANCE;

    KmClassExtension createClassExtension();

    KmConstructorExtension createConstructorExtension();

    KmFunctionExtension createFunctionExtension();

    KmModuleFragmentExtension createModuleFragmentExtensions();

    KmPackageExtension createPackageExtension();

    KmPropertyExtension createPropertyExtension();

    KmTypeAliasExtension createTypeAliasExtension();

    KmTypeExtension createTypeExtension();

    KmTypeParameterExtension createTypeParameterExtension();

    KmValueParameterExtension createValueParameterExtension();

    void readClassExtensions(KmClass kmClass, ProtoBuf.Class r2, ReadContext readContext);

    void readConstructorExtensions(KmConstructor kmConstructor, ProtoBuf.Constructor constructor, ReadContext readContext);

    void readFunctionExtensions(KmFunction kmFunction, ProtoBuf.Function function, ReadContext readContext);

    void readModuleFragmentExtensions(KmModuleFragment kmModuleFragment, ProtoBuf.PackageFragment packageFragment, ReadContext readContext);

    void readPackageExtensions(KmPackage kmPackage, ProtoBuf.Package r2, ReadContext readContext);

    void readPropertyExtensions(KmProperty kmProperty, ProtoBuf.Property property, ReadContext readContext);

    void readTypeAliasExtensions(KmTypeAlias kmTypeAlias, ProtoBuf.TypeAlias typeAlias, ReadContext readContext);

    void readTypeExtensions(KmType kmType, ProtoBuf.Type type, ReadContext readContext);

    void readTypeParameterExtensions(KmTypeParameter kmTypeParameter, ProtoBuf.TypeParameter typeParameter, ReadContext readContext);

    void readValueParameterExtensions(KmValueParameter kmValueParameter, ProtoBuf.ValueParameter valueParameter, ReadContext readContext);

    void writeClassExtensions(KmClass kmClass, ProtoBuf.Class.Builder builder, WriteContext writeContext);

    void writeConstructorExtensions(KmConstructor kmConstructor, ProtoBuf.Constructor.Builder builder, WriteContext writeContext);

    void writeFunctionExtensions(KmFunction kmFunction, ProtoBuf.Function.Builder builder, WriteContext writeContext);

    void writeModuleFragmentExtensions(KmModuleFragment kmModuleFragment, ProtoBuf.PackageFragment.Builder builder, WriteContext writeContext);

    void writePackageExtensions(KmPackage kmPackage, ProtoBuf.Package.Builder builder, WriteContext writeContext);

    void writePropertyExtensions(KmProperty kmProperty, ProtoBuf.Property.Builder builder, WriteContext writeContext);

    void writeTypeAliasExtensions(KmTypeAlias kmTypeAlias, ProtoBuf.TypeAlias.Builder builder, WriteContext writeContext);

    void writeTypeExtensions(KmType kmType, ProtoBuf.Type.Builder builder, WriteContext writeContext);

    void writeTypeParameterExtensions(KmTypeParameter kmTypeParameter, ProtoBuf.TypeParameter.Builder builder, WriteContext writeContext);

    void writeValueParameterExtensions(KmValueParameter kmValueParameter, ProtoBuf.ValueParameter.Builder builder, WriteContext writeContext);

    /* compiled from: MetadataExtensions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/metadata/internal/extensions/MetadataExtensions$Companion;", "", "()V", "INSTANCES", "", "Lkotlinx/metadata/internal/extensions/MetadataExtensions;", "getINSTANCES$kotlinx_metadata", "()Ljava/util/List;", "INSTANCES$delegate", "Lkotlin/Lazy;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Lazy<List<MetadataExtensions>> INSTANCES$delegate = LazyKt.lazy(new Function0<List<? extends MetadataExtensions>>() { // from class: kotlinx.metadata.internal.extensions.MetadataExtensions$Companion$INSTANCES$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends MetadataExtensions> invoke() {
                ServiceLoader load = ServiceLoader.load(MetadataExtensions.class, MetadataExtensions.class.getClassLoader());
                Intrinsics.checkNotNullExpressionValue(load, "load(...)");
                List<? extends MetadataExtensions> list = CollectionsKt.toList(load);
                if (list.isEmpty()) {
                    throw new IllegalStateException("No MetadataExtensions instances found in the classpath. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager".toString());
                }
                return list;
            }
        });

        private Companion() {
        }

        public final List<MetadataExtensions> getINSTANCES$kotlinx_metadata() {
            return INSTANCES$delegate.getValue();
        }
    }
}
