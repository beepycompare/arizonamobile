package kotlinx.metadata.jvm;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmConstructor;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmType;
import kotlinx.metadata.KmTypeParameter;
import kotlinx.metadata.jvm.internal.JvmExtensionNodesKt;
/* compiled from: JvmExtensions.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\",\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\",\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\",\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\"(\u0010\u001e\u001a\u00020\u001d*\u00020\u00032\u0006\u0010\b\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\".\u0010#\u001a\u00020\"*\u00020\u000b2\u0006\u0010\b\u001a\u00020\"8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\".\u0010#\u001a\u00020\"*\u00020\u00122\u0006\u0010\b\u001a\u00020\"8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b$\u0010*\u001a\u0004\b&\u0010+\"\u0004\b(\u0010,\",\u0010-\u001a\u0004\u0018\u00010\t*\u00020.2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102\"\u001b\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b4\u00105\"\u001b\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u0002068F¢\u0006\u0006\u001a\u0004\b4\u00107\",\u00108\u001a\u0004\u0018\u00010\t*\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000f\",\u00108\u001a\u0004\u0018\u00010\t*\u0002062\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010;\"\u0004\b:\u0010<\",\u0010=\u001a\u0004\u0018\u00010\u0017*\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010\u001a\"\u0004\b?\u0010\u001c\",\u0010@\u001a\u0004\u0018\u00010\u0017*\u00020A2\b\u0010\b\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E\",\u0010@\u001a\u0004\u0018\u00010\u0017*\u00020.2\b\u0010\b\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010F\"\u0004\bD\u0010G\",\u0010H\u001a\u0004\u0018\u00010\u0017*\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u001a\"\u0004\bJ\u0010\u001c\",\u0010K\u001a\u0004\u0018\u00010\u0017*\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010\u001a\"\u0004\bM\u0010\u001c¨\u0006N"}, d2 = {"annotations", "", "Lkotlinx/metadata/KmAnnotation;", "Lkotlinx/metadata/KmType;", "getAnnotations", "(Lkotlinx/metadata/KmType;)Ljava/util/List;", "Lkotlinx/metadata/KmTypeParameter;", "(Lkotlinx/metadata/KmTypeParameter;)Ljava/util/List;", "value", "", "anonymousObjectOriginName", "Lkotlinx/metadata/KmClass;", "getAnonymousObjectOriginName", "(Lkotlinx/metadata/KmClass;)Ljava/lang/String;", "setAnonymousObjectOriginName", "(Lkotlinx/metadata/KmClass;Ljava/lang/String;)V", "Lkotlinx/metadata/jvm/JvmFieldSignature;", "fieldSignature", "Lkotlinx/metadata/KmProperty;", "getFieldSignature", "(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/jvm/JvmFieldSignature;", "setFieldSignature", "(Lkotlinx/metadata/KmProperty;Lkotlinx/metadata/jvm/JvmFieldSignature;)V", "Lkotlinx/metadata/jvm/JvmMethodSignature;", "getterSignature", "getGetterSignature", "(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/jvm/JvmMethodSignature;", "setGetterSignature", "(Lkotlinx/metadata/KmProperty;Lkotlinx/metadata/jvm/JvmMethodSignature;)V", "", "isRaw", "(Lkotlinx/metadata/KmType;)Z", "setRaw", "(Lkotlinx/metadata/KmType;Z)V", "", "jvmFlags", "getJvmFlags$annotations", "(Lkotlinx/metadata/KmClass;)V", "getJvmFlags", "(Lkotlinx/metadata/KmClass;)I", "setJvmFlags", "(Lkotlinx/metadata/KmClass;I)V", "(Lkotlinx/metadata/KmProperty;)V", "(Lkotlinx/metadata/KmProperty;)I", "(Lkotlinx/metadata/KmProperty;I)V", "lambdaClassOriginName", "Lkotlinx/metadata/KmFunction;", "getLambdaClassOriginName", "(Lkotlinx/metadata/KmFunction;)Ljava/lang/String;", "setLambdaClassOriginName", "(Lkotlinx/metadata/KmFunction;Ljava/lang/String;)V", "localDelegatedProperties", "getLocalDelegatedProperties", "(Lkotlinx/metadata/KmClass;)Ljava/util/List;", "Lkotlinx/metadata/KmPackage;", "(Lkotlinx/metadata/KmPackage;)Ljava/util/List;", "moduleName", "getModuleName", "setModuleName", "(Lkotlinx/metadata/KmPackage;)Ljava/lang/String;", "(Lkotlinx/metadata/KmPackage;Ljava/lang/String;)V", "setterSignature", "getSetterSignature", "setSetterSignature", "signature", "Lkotlinx/metadata/KmConstructor;", "getSignature", "(Lkotlinx/metadata/KmConstructor;)Lkotlinx/metadata/jvm/JvmMethodSignature;", "setSignature", "(Lkotlinx/metadata/KmConstructor;Lkotlinx/metadata/jvm/JvmMethodSignature;)V", "(Lkotlinx/metadata/KmFunction;)Lkotlinx/metadata/jvm/JvmMethodSignature;", "(Lkotlinx/metadata/KmFunction;Lkotlinx/metadata/jvm/JvmMethodSignature;)V", "syntheticMethodForAnnotations", "getSyntheticMethodForAnnotations", "setSyntheticMethodForAnnotations", "syntheticMethodForDelegate", "getSyntheticMethodForDelegate", "setSyntheticMethodForDelegate", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmExtensionsKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmClass, such as KmClass.hasMethodBodiesInInterface")
    public static /* synthetic */ void getJvmFlags$annotations(KmClass kmClass) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmProperty, such as KmProperty.isMovedFromInterfaceCompanion")
    public static /* synthetic */ void getJvmFlags$annotations(KmProperty kmProperty) {
    }

    public static final List<KmProperty> getLocalDelegatedProperties(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return JvmExtensionNodesKt.getJvm(kmClass).getLocalDelegatedProperties();
    }

    public static final String getModuleName(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return JvmExtensionNodesKt.getJvm(kmClass).getModuleName();
    }

    public static final void setModuleName(KmClass kmClass, String str) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        JvmExtensionNodesKt.getJvm(kmClass).setModuleName(str);
    }

    public static final String getAnonymousObjectOriginName(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return JvmExtensionNodesKt.getJvm(kmClass).getAnonymousObjectOriginName();
    }

    public static final void setAnonymousObjectOriginName(KmClass kmClass, String str) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        JvmExtensionNodesKt.getJvm(kmClass).setAnonymousObjectOriginName(str);
    }

    public static final int getJvmFlags(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return JvmExtensionNodesKt.getJvm(kmClass).getJvmFlags();
    }

    public static final void setJvmFlags(KmClass kmClass, int i) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        JvmExtensionNodesKt.getJvm(kmClass).setJvmFlags(i);
    }

    public static final List<KmProperty> getLocalDelegatedProperties(KmPackage kmPackage) {
        Intrinsics.checkNotNullParameter(kmPackage, "<this>");
        return JvmExtensionNodesKt.getJvm(kmPackage).getLocalDelegatedProperties();
    }

    public static final String getModuleName(KmPackage kmPackage) {
        Intrinsics.checkNotNullParameter(kmPackage, "<this>");
        return JvmExtensionNodesKt.getJvm(kmPackage).getModuleName();
    }

    public static final void setModuleName(KmPackage kmPackage, String str) {
        Intrinsics.checkNotNullParameter(kmPackage, "<this>");
        JvmExtensionNodesKt.getJvm(kmPackage).setModuleName(str);
    }

    public static final JvmMethodSignature getSignature(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return JvmExtensionNodesKt.getJvm(kmFunction).getSignature();
    }

    public static final void setSignature(KmFunction kmFunction, JvmMethodSignature jvmMethodSignature) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        JvmExtensionNodesKt.getJvm(kmFunction).setSignature(jvmMethodSignature);
    }

    public static final String getLambdaClassOriginName(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        return JvmExtensionNodesKt.getJvm(kmFunction).getLambdaClassOriginName();
    }

    public static final void setLambdaClassOriginName(KmFunction kmFunction, String str) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        JvmExtensionNodesKt.getJvm(kmFunction).setLambdaClassOriginName(str);
    }

    public static final int getJvmFlags(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return JvmExtensionNodesKt.getJvm(kmProperty).getJvmFlags();
    }

    public static final void setJvmFlags(KmProperty kmProperty, int i) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        JvmExtensionNodesKt.getJvm(kmProperty).setJvmFlags(i);
    }

    public static final JvmFieldSignature getFieldSignature(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return JvmExtensionNodesKt.getJvm(kmProperty).getFieldSignature();
    }

    public static final void setFieldSignature(KmProperty kmProperty, JvmFieldSignature jvmFieldSignature) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        JvmExtensionNodesKt.getJvm(kmProperty).setFieldSignature(jvmFieldSignature);
    }

    public static final JvmMethodSignature getGetterSignature(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return JvmExtensionNodesKt.getJvm(kmProperty).getGetterSignature();
    }

    public static final void setGetterSignature(KmProperty kmProperty, JvmMethodSignature jvmMethodSignature) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        JvmExtensionNodesKt.getJvm(kmProperty).setGetterSignature(jvmMethodSignature);
    }

    public static final JvmMethodSignature getSetterSignature(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return JvmExtensionNodesKt.getJvm(kmProperty).getSetterSignature();
    }

    public static final void setSetterSignature(KmProperty kmProperty, JvmMethodSignature jvmMethodSignature) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        JvmExtensionNodesKt.getJvm(kmProperty).setSetterSignature(jvmMethodSignature);
    }

    public static final JvmMethodSignature getSyntheticMethodForAnnotations(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return JvmExtensionNodesKt.getJvm(kmProperty).getSyntheticMethodForAnnotations();
    }

    public static final void setSyntheticMethodForAnnotations(KmProperty kmProperty, JvmMethodSignature jvmMethodSignature) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        JvmExtensionNodesKt.getJvm(kmProperty).setSyntheticMethodForAnnotations(jvmMethodSignature);
    }

    public static final JvmMethodSignature getSyntheticMethodForDelegate(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return JvmExtensionNodesKt.getJvm(kmProperty).getSyntheticMethodForDelegate();
    }

    public static final void setSyntheticMethodForDelegate(KmProperty kmProperty, JvmMethodSignature jvmMethodSignature) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        JvmExtensionNodesKt.getJvm(kmProperty).setSyntheticMethodForDelegate(jvmMethodSignature);
    }

    public static final JvmMethodSignature getSignature(KmConstructor kmConstructor) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        return JvmExtensionNodesKt.getJvm(kmConstructor).getSignature();
    }

    public static final void setSignature(KmConstructor kmConstructor, JvmMethodSignature jvmMethodSignature) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        JvmExtensionNodesKt.getJvm(kmConstructor).setSignature(jvmMethodSignature);
    }

    public static final List<KmAnnotation> getAnnotations(KmTypeParameter kmTypeParameter) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "<this>");
        return JvmExtensionNodesKt.getJvm(kmTypeParameter).getAnnotations();
    }

    public static final boolean isRaw(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        return JvmExtensionNodesKt.getJvm(kmType).isRaw();
    }

    public static final void setRaw(KmType kmType, boolean z) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        JvmExtensionNodesKt.getJvm(kmType).setRaw(z);
    }

    public static final List<KmAnnotation> getAnnotations(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        return JvmExtensionNodesKt.getJvm(kmType).getAnnotations();
    }
}
