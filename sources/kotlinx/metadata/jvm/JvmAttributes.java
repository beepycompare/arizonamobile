package kotlinx.metadata.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.internal.BooleanFlagDelegate;
import kotlinx.metadata.internal.FlagImpl;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmFlags;
/* compiled from: JvmAttributes.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\"/\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"/\u0010\n\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\t\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007\"/\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\t\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"<set-?>", "", "hasMethodBodiesInInterface", "Lkotlinx/metadata/KmClass;", "getHasMethodBodiesInInterface", "(Lkotlinx/metadata/KmClass;)Z", "setHasMethodBodiesInInterface", "(Lkotlinx/metadata/KmClass;Z)V", "hasMethodBodiesInInterface$delegate", "Lkotlinx/metadata/internal/BooleanFlagDelegate;", "isCompiledInCompatibilityMode", "setCompiledInCompatibilityMode", "isCompiledInCompatibilityMode$delegate", "isMovedFromInterfaceCompanion", "Lkotlinx/metadata/KmProperty;", "(Lkotlinx/metadata/KmProperty;)Z", "setMovedFromInterfaceCompanion", "(Lkotlinx/metadata/KmProperty;Z)V", "isMovedFromInterfaceCompanion$delegate", "booleanFlag", "Lkotlinx/metadata/internal/FlagImpl;", "f", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmAttributes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(JvmAttributes.class, "kotlinx-metadata-jvm"), "isMovedFromInterfaceCompanion", "isMovedFromInterfaceCompanion(Lkotlinx/metadata/KmProperty;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(JvmAttributes.class, "kotlinx-metadata-jvm"), "hasMethodBodiesInInterface", "getHasMethodBodiesInInterface(Lkotlinx/metadata/KmClass;)Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(JvmAttributes.class, "kotlinx-metadata-jvm"), "isCompiledInCompatibilityMode", "isCompiledInCompatibilityMode(Lkotlinx/metadata/KmClass;)Z"))};
    private static final BooleanFlagDelegate hasMethodBodiesInInterface$delegate;
    private static final BooleanFlagDelegate isCompiledInCompatibilityMode$delegate;
    private static final BooleanFlagDelegate isMovedFromInterfaceCompanion$delegate;

    static {
        Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Intrinsics.checkNotNullExpressionValue(is_moved_from_interface_companion, "<get-IS_MOVED_FROM_INTERFACE_COMPANION>(...)");
        isMovedFromInterfaceCompanion$delegate = new BooleanFlagDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.jvm.JvmAttributes$isMovedFromInterfaceCompanion$2
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(JvmExtensionsKt.getJvmFlags((KmProperty) obj));
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return "jvmFlags";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinPackage(JvmExtensionsKt.class, "kotlinx-metadata-jvm");
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getJvmFlags(Lkotlinx/metadata/KmProperty;)I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                JvmExtensionsKt.setJvmFlags((KmProperty) obj, ((Number) obj2).intValue());
            }
        }, booleanFlag(is_moved_from_interface_companion));
        Flags.BooleanFlagField is_compiled_in_jvm_default_mode = JvmFlags.INSTANCE.getIS_COMPILED_IN_JVM_DEFAULT_MODE();
        Intrinsics.checkNotNullExpressionValue(is_compiled_in_jvm_default_mode, "<get-IS_COMPILED_IN_JVM_DEFAULT_MODE>(...)");
        hasMethodBodiesInInterface$delegate = new BooleanFlagDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.jvm.JvmAttributes$hasMethodBodiesInInterface$2
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(JvmExtensionsKt.getJvmFlags((KmClass) obj));
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return "jvmFlags";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinPackage(JvmExtensionsKt.class, "kotlinx-metadata-jvm");
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getJvmFlags(Lkotlinx/metadata/KmClass;)I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                JvmExtensionsKt.setJvmFlags((KmClass) obj, ((Number) obj2).intValue());
            }
        }, booleanFlag(is_compiled_in_jvm_default_mode));
        Flags.BooleanFlagField is_compiled_in_compatibility_mode = JvmFlags.INSTANCE.getIS_COMPILED_IN_COMPATIBILITY_MODE();
        Intrinsics.checkNotNullExpressionValue(is_compiled_in_compatibility_mode, "<get-IS_COMPILED_IN_COMPATIBILITY_MODE>(...)");
        isCompiledInCompatibilityMode$delegate = new BooleanFlagDelegate(new MutablePropertyReference1() { // from class: kotlinx.metadata.jvm.JvmAttributes$isCompiledInCompatibilityMode$2
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(JvmExtensionsKt.getJvmFlags((KmClass) obj));
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return "jvmFlags";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinPackage(JvmExtensionsKt.class, "kotlinx-metadata-jvm");
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getJvmFlags(Lkotlinx/metadata/KmClass;)I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                JvmExtensionsKt.setJvmFlags((KmClass) obj, ((Number) obj2).intValue());
            }
        }, booleanFlag(is_compiled_in_compatibility_mode));
    }

    public static final boolean isMovedFromInterfaceCompanion(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        return isMovedFromInterfaceCompanion$delegate.getValue(kmProperty, $$delegatedProperties[0]);
    }

    public static final void setMovedFromInterfaceCompanion(KmProperty kmProperty, boolean z) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        isMovedFromInterfaceCompanion$delegate.setValue(kmProperty, $$delegatedProperties[0], z);
    }

    public static final boolean getHasMethodBodiesInInterface(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return hasMethodBodiesInInterface$delegate.getValue(kmClass, $$delegatedProperties[1]);
    }

    public static final void setHasMethodBodiesInInterface(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        hasMethodBodiesInInterface$delegate.setValue(kmClass, $$delegatedProperties[1], z);
    }

    public static final boolean isCompiledInCompatibilityMode(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isCompiledInCompatibilityMode$delegate.getValue(kmClass, $$delegatedProperties[2]);
    }

    public static final void setCompiledInCompatibilityMode(KmClass kmClass, boolean z) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        isCompiledInCompatibilityMode$delegate.setValue(kmClass, $$delegatedProperties[2], z);
    }

    private static final FlagImpl booleanFlag(Flags.BooleanFlagField booleanFlagField) {
        return new FlagImpl(booleanFlagField.offset, booleanFlagField.bitWidth, 1);
    }
}
