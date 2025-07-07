package kotlinx.metadata;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
/* compiled from: Flag.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding extensions on Km nodes, such as KmClass.visibility")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00162\u00020\u0001:\n\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB\u001b\b\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0086\u0002J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0080\u0002¢\u0006\u0002\b\u0014R\u0014\u0010\n\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001f"}, d2 = {"Lkotlinx/metadata/Flag;", "", "field", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$FlagField;", "value", "", "(Lorg/jetbrains/kotlin/metadata/deserialization/Flags$FlagField;I)V", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "(Lorg/jetbrains/kotlin/metadata/deserialization/Flags$BooleanFlagField;)V", TypedValues.CycleType.S_WAVE_OFFSET, "bitWidth", "(III)V", "getBitWidth$kotlinx_metadata", "()I", "getOffset$kotlinx_metadata", "getValue$kotlinx_metadata", "invoke", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "plus", "plus$kotlinx_metadata", "Class", "Common", "Constructor", "EffectExpression", "Function", "Property", "PropertyAccessor", "Type", "TypeParameter", "ValueParameter", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Flag {
    public static final Common Common = new Common(null);
    public static final Flag HAS_ANNOTATIONS;
    public static final Flag IS_ABSTRACT;
    public static final Flag IS_FINAL;
    public static final Flag IS_INTERNAL;
    public static final Flag IS_LOCAL;
    public static final Flag IS_OPEN;
    public static final Flag IS_PRIVATE;
    public static final Flag IS_PRIVATE_TO_THIS;
    public static final Flag IS_PROTECTED;
    public static final Flag IS_PUBLIC;
    public static final Flag IS_SEALED;
    private final int bitWidth;
    private final int offset;
    private final int value;

    public Flag(int i, int i2, int i3) {
        this.offset = i;
        this.bitWidth = i2;
        this.value = i3;
    }

    public final int getBitWidth$kotlinx_metadata() {
        return this.bitWidth;
    }

    public final int getOffset$kotlinx_metadata() {
        return this.offset;
    }

    public final int getValue$kotlinx_metadata() {
        return this.value;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Flag(Flags.FlagField<?> field, int i) {
        this(field.offset, field.bitWidth, i);
        Intrinsics.checkNotNullParameter(field, "field");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Flag(Flags.BooleanFlagField field) {
        this(field, 1);
        Intrinsics.checkNotNullParameter(field, "field");
    }

    public final int plus$kotlinx_metadata(int i) {
        int i2 = this.offset;
        return (i & (~(((1 << this.bitWidth) - 1) << i2))) + (this.value << i2);
    }

    public final boolean invoke(int i) {
        return ((i >>> this.offset) & ((1 << this.bitWidth) - 1)) == this.value;
    }

    /* compiled from: Flag.kt */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding extensions on Km nodes, such as KmClass.visibility")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0002R\u0016\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0002R\u0016\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0002R\u0016\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0002¨\u0006\u001a"}, d2 = {"Lkotlinx/metadata/Flag$Common;", "", "()V", "HAS_ANNOTATIONS", "Lkotlinx/metadata/Flag;", "getHAS_ANNOTATIONS$annotations", "IS_ABSTRACT", "getIS_ABSTRACT$annotations", "IS_FINAL", "getIS_FINAL$annotations", "IS_INTERNAL", "getIS_INTERNAL$annotations", "IS_LOCAL", "getIS_LOCAL$annotations", "IS_OPEN", "getIS_OPEN$annotations", "IS_PRIVATE", "getIS_PRIVATE$annotations", "IS_PRIVATE_TO_THIS", "getIS_PRIVATE_TO_THIS$annotations", "IS_PROTECTED", "getIS_PROTECTED$annotations", "IS_PUBLIC", "getIS_PUBLIC$annotations", "IS_SEALED", "getIS_SEALED$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Common {
        public /* synthetic */ Common(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding extension on a node, e.g. KmClass.hasAnnotations")
        public static /* synthetic */ void getHAS_ANNOTATIONS$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use modality extension on a node, e.g. KmClass.modality or KmFunction.modality")
        public static /* synthetic */ void getIS_ABSTRACT$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use modality extension on a node, e.g. KmClass.modality or KmFunction.modality")
        public static /* synthetic */ void getIS_FINAL$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use visibility extension on a node, e.g. KmClass.visibility")
        public static /* synthetic */ void getIS_INTERNAL$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use visibility extension on a node, e.g. KmClass.visibility")
        public static /* synthetic */ void getIS_LOCAL$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use modality extension on a node, e.g. KmClass.modality or KmFunction.modality")
        public static /* synthetic */ void getIS_OPEN$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use visibility extension on a node, e.g. KmClass.visibility")
        public static /* synthetic */ void getIS_PRIVATE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use visibility extension on a node, e.g. KmClass.visibility")
        public static /* synthetic */ void getIS_PRIVATE_TO_THIS$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use visibility extension on a node, e.g. KmClass.visibility")
        public static /* synthetic */ void getIS_PROTECTED$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use visibility extension on a node, e.g. KmClass.visibility")
        public static /* synthetic */ void getIS_PUBLIC$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use modality extension on a node, e.g. KmClass.modality")
        public static /* synthetic */ void getIS_SEALED$annotations() {
        }

        private Common() {
        }
    }

    static {
        Flags.BooleanFlagField HAS_ANNOTATIONS2 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS2, "HAS_ANNOTATIONS");
        HAS_ANNOTATIONS = new Flag(HAS_ANNOTATIONS2);
        Flags.FlagField<ProtoBuf.Visibility> VISIBILITY = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(VISIBILITY, "VISIBILITY");
        IS_INTERNAL = new Flag(VISIBILITY, 0);
        Flags.FlagField<ProtoBuf.Visibility> VISIBILITY2 = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(VISIBILITY2, "VISIBILITY");
        IS_PRIVATE = new Flag(VISIBILITY2, 1);
        Flags.FlagField<ProtoBuf.Visibility> VISIBILITY3 = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(VISIBILITY3, "VISIBILITY");
        IS_PROTECTED = new Flag(VISIBILITY3, 2);
        Flags.FlagField<ProtoBuf.Visibility> VISIBILITY4 = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(VISIBILITY4, "VISIBILITY");
        IS_PUBLIC = new Flag(VISIBILITY4, 3);
        Flags.FlagField<ProtoBuf.Visibility> VISIBILITY5 = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(VISIBILITY5, "VISIBILITY");
        IS_PRIVATE_TO_THIS = new Flag(VISIBILITY5, 4);
        Flags.FlagField<ProtoBuf.Visibility> VISIBILITY6 = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(VISIBILITY6, "VISIBILITY");
        IS_LOCAL = new Flag(VISIBILITY6, 5);
        Flags.FlagField<ProtoBuf.Modality> MODALITY = Flags.MODALITY;
        Intrinsics.checkNotNullExpressionValue(MODALITY, "MODALITY");
        IS_FINAL = new Flag(MODALITY, 0);
        Flags.FlagField<ProtoBuf.Modality> MODALITY2 = Flags.MODALITY;
        Intrinsics.checkNotNullExpressionValue(MODALITY2, "MODALITY");
        IS_OPEN = new Flag(MODALITY2, 1);
        Flags.FlagField<ProtoBuf.Modality> MODALITY3 = Flags.MODALITY;
        Intrinsics.checkNotNullExpressionValue(MODALITY3, "MODALITY");
        IS_ABSTRACT = new Flag(MODALITY3, 2);
        Flags.FlagField<ProtoBuf.Modality> MODALITY4 = Flags.MODALITY;
        Intrinsics.checkNotNullExpressionValue(MODALITY4, "MODALITY");
        IS_SEALED = new Flag(MODALITY4, 3);
    }

    /* compiled from: Flag.kt */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding extension on a KmClass")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0002R\u0016\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0002R\u0016\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0002R\u0016\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0002R\u0016\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0002R\u0016\u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0002R\u0016\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0002R\u0016\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0002¨\u0006\""}, d2 = {"Lkotlinx/metadata/Flag$Class;", "", "()V", "HAS_ENUM_ENTRIES", "Lkotlinx/metadata/Flag;", "getHAS_ENUM_ENTRIES$annotations", "IS_ANNOTATION_CLASS", "getIS_ANNOTATION_CLASS$annotations", "IS_CLASS", "getIS_CLASS$annotations", "IS_COMPANION_OBJECT", "getIS_COMPANION_OBJECT$annotations", "IS_DATA", "getIS_DATA$annotations", "IS_ENUM_CLASS", "getIS_ENUM_CLASS$annotations", "IS_ENUM_ENTRY", "getIS_ENUM_ENTRY$annotations", "IS_EXPECT", "getIS_EXPECT$annotations", "IS_EXTERNAL", "getIS_EXTERNAL$annotations", "IS_FUN", "getIS_FUN$annotations", "IS_INLINE", "getIS_INLINE$annotations", "IS_INNER", "getIS_INNER$annotations", "IS_INTERFACE", "getIS_INTERFACE$annotations", "IS_OBJECT", "getIS_OBJECT$annotations", "IS_VALUE", "getIS_VALUE$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Class {
        public static final Flag HAS_ENUM_ENTRIES;
        public static final Class INSTANCE = new Class();
        public static final Flag IS_ANNOTATION_CLASS;
        public static final Flag IS_CLASS;
        public static final Flag IS_COMPANION_OBJECT;
        public static final Flag IS_DATA;
        public static final Flag IS_ENUM_CLASS;
        public static final Flag IS_ENUM_ENTRY;
        public static final Flag IS_EXPECT;
        public static final Flag IS_EXTERNAL;
        public static final Flag IS_FUN;
        public static final Flag IS_INLINE;
        public static final Flag IS_INNER;
        public static final Flag IS_INTERFACE;
        public static final Flag IS_OBJECT;
        public static final Flag IS_VALUE;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.hasEnumEntries")
        public static /* synthetic */ void getHAS_ENUM_ENTRIES$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.kind")
        public static /* synthetic */ void getIS_ANNOTATION_CLASS$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.kind")
        public static /* synthetic */ void getIS_CLASS$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.kind")
        public static /* synthetic */ void getIS_COMPANION_OBJECT$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.isData")
        public static /* synthetic */ void getIS_DATA$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.kind")
        public static /* synthetic */ void getIS_ENUM_CLASS$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.kind")
        public static /* synthetic */ void getIS_ENUM_ENTRY$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.isExpect")
        public static /* synthetic */ void getIS_EXPECT$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.isExternal")
        public static /* synthetic */ void getIS_EXTERNAL$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.isFun")
        public static /* synthetic */ void getIS_FUN$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use IS_VALUE instead, which returns true if the class is either a pre-1.5 inline class, or a 1.5+ value class.")
        public static /* synthetic */ void getIS_INLINE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.isInner")
        public static /* synthetic */ void getIS_INNER$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.kind")
        public static /* synthetic */ void getIS_INTERFACE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.kind")
        public static /* synthetic */ void getIS_OBJECT$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmClass.isValue")
        public static /* synthetic */ void getIS_VALUE$annotations() {
        }

        private Class() {
        }

        static {
            Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND = Flags.CLASS_KIND;
            Intrinsics.checkNotNullExpressionValue(CLASS_KIND, "CLASS_KIND");
            IS_CLASS = new Flag(CLASS_KIND, 0);
            Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND2 = Flags.CLASS_KIND;
            Intrinsics.checkNotNullExpressionValue(CLASS_KIND2, "CLASS_KIND");
            IS_INTERFACE = new Flag(CLASS_KIND2, 1);
            Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND3 = Flags.CLASS_KIND;
            Intrinsics.checkNotNullExpressionValue(CLASS_KIND3, "CLASS_KIND");
            IS_ENUM_CLASS = new Flag(CLASS_KIND3, 2);
            Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND4 = Flags.CLASS_KIND;
            Intrinsics.checkNotNullExpressionValue(CLASS_KIND4, "CLASS_KIND");
            IS_ENUM_ENTRY = new Flag(CLASS_KIND4, 3);
            Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND5 = Flags.CLASS_KIND;
            Intrinsics.checkNotNullExpressionValue(CLASS_KIND5, "CLASS_KIND");
            IS_ANNOTATION_CLASS = new Flag(CLASS_KIND5, 4);
            Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND6 = Flags.CLASS_KIND;
            Intrinsics.checkNotNullExpressionValue(CLASS_KIND6, "CLASS_KIND");
            IS_OBJECT = new Flag(CLASS_KIND6, 5);
            Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND7 = Flags.CLASS_KIND;
            Intrinsics.checkNotNullExpressionValue(CLASS_KIND7, "CLASS_KIND");
            IS_COMPANION_OBJECT = new Flag(CLASS_KIND7, 6);
            Flags.BooleanFlagField IS_INNER2 = Flags.IS_INNER;
            Intrinsics.checkNotNullExpressionValue(IS_INNER2, "IS_INNER");
            IS_INNER = new Flag(IS_INNER2);
            Flags.BooleanFlagField IS_DATA2 = Flags.IS_DATA;
            Intrinsics.checkNotNullExpressionValue(IS_DATA2, "IS_DATA");
            IS_DATA = new Flag(IS_DATA2);
            Flags.BooleanFlagField IS_EXTERNAL_CLASS = Flags.IS_EXTERNAL_CLASS;
            Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_CLASS, "IS_EXTERNAL_CLASS");
            IS_EXTERNAL = new Flag(IS_EXTERNAL_CLASS);
            Flags.BooleanFlagField IS_EXPECT_CLASS = Flags.IS_EXPECT_CLASS;
            Intrinsics.checkNotNullExpressionValue(IS_EXPECT_CLASS, "IS_EXPECT_CLASS");
            IS_EXPECT = new Flag(IS_EXPECT_CLASS);
            Flags.BooleanFlagField IS_VALUE_CLASS = Flags.IS_VALUE_CLASS;
            Intrinsics.checkNotNullExpressionValue(IS_VALUE_CLASS, "IS_VALUE_CLASS");
            IS_INLINE = new Flag(IS_VALUE_CLASS);
            Flags.BooleanFlagField IS_VALUE_CLASS2 = Flags.IS_VALUE_CLASS;
            Intrinsics.checkNotNullExpressionValue(IS_VALUE_CLASS2, "IS_VALUE_CLASS");
            IS_VALUE = new Flag(IS_VALUE_CLASS2);
            Flags.BooleanFlagField IS_FUN_INTERFACE = Flags.IS_FUN_INTERFACE;
            Intrinsics.checkNotNullExpressionValue(IS_FUN_INTERFACE, "IS_FUN_INTERFACE");
            IS_FUN = new Flag(IS_FUN_INTERFACE);
            Flags.BooleanFlagField HAS_ENUM_ENTRIES2 = Flags.HAS_ENUM_ENTRIES;
            Intrinsics.checkNotNullExpressionValue(HAS_ENUM_ENTRIES2, "HAS_ENUM_ENTRIES");
            HAS_ENUM_ENTRIES = new Flag(HAS_ENUM_ENTRIES2);
        }
    }

    /* compiled from: Flag.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\n"}, d2 = {"Lkotlinx/metadata/Flag$Constructor;", "", "()V", "HAS_NON_STABLE_PARAMETER_NAMES", "Lkotlinx/metadata/Flag;", "getHAS_NON_STABLE_PARAMETER_NAMES$annotations", "IS_PRIMARY", "getIS_PRIMARY$annotations", "IS_SECONDARY", "getIS_SECONDARY$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Constructor {
        public static final Flag HAS_NON_STABLE_PARAMETER_NAMES;
        public static final Constructor INSTANCE = new Constructor();
        public static final Flag IS_PRIMARY;
        public static final Flag IS_SECONDARY;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmConstructor.hasNonStableParameterNames")
        public static /* synthetic */ void getHAS_NON_STABLE_PARAMETER_NAMES$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use IS_SECONDARY which holds inverted value instead.")
        public static /* synthetic */ void getIS_PRIMARY$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmConstructor.isSecondary")
        public static /* synthetic */ void getIS_SECONDARY$annotations() {
        }

        private Constructor() {
        }

        static {
            Flags.BooleanFlagField IS_SECONDARY2 = Flags.IS_SECONDARY;
            Intrinsics.checkNotNullExpressionValue(IS_SECONDARY2, "IS_SECONDARY");
            IS_PRIMARY = new Flag(IS_SECONDARY2, 0);
            Flags.BooleanFlagField IS_SECONDARY3 = Flags.IS_SECONDARY;
            Intrinsics.checkNotNullExpressionValue(IS_SECONDARY3, "IS_SECONDARY");
            IS_SECONDARY = new Flag(IS_SECONDARY3);
            Flags.BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
            Intrinsics.checkNotNullExpressionValue(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES, "IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES");
            HAS_NON_STABLE_PARAMETER_NAMES = new Flag(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES);
        }
    }

    /* compiled from: Flag.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0002R\u0016\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0002R\u0016\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0002R\u0016\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0002R\u0016\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0002¨\u0006\u001c"}, d2 = {"Lkotlinx/metadata/Flag$Function;", "", "()V", "HAS_NON_STABLE_PARAMETER_NAMES", "Lkotlinx/metadata/Flag;", "getHAS_NON_STABLE_PARAMETER_NAMES$annotations", "IS_DECLARATION", "getIS_DECLARATION$annotations", "IS_DELEGATION", "getIS_DELEGATION$annotations", "IS_EXPECT", "getIS_EXPECT$annotations", "IS_EXTERNAL", "getIS_EXTERNAL$annotations", "IS_FAKE_OVERRIDE", "getIS_FAKE_OVERRIDE$annotations", "IS_INFIX", "getIS_INFIX$annotations", "IS_INLINE", "getIS_INLINE$annotations", "IS_OPERATOR", "getIS_OPERATOR$annotations", "IS_SUSPEND", "getIS_SUSPEND$annotations", "IS_SYNTHESIZED", "getIS_SYNTHESIZED$annotations", "IS_TAILREC", "getIS_TAILREC$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Function {
        public static final Flag HAS_NON_STABLE_PARAMETER_NAMES;
        public static final Function INSTANCE = new Function();
        public static final Flag IS_DECLARATION;
        public static final Flag IS_DELEGATION;
        public static final Flag IS_EXPECT;
        public static final Flag IS_EXTERNAL;
        public static final Flag IS_FAKE_OVERRIDE;
        public static final Flag IS_INFIX;
        public static final Flag IS_INLINE;
        public static final Flag IS_OPERATOR;
        public static final Flag IS_SUSPEND;
        public static final Flag IS_SYNTHESIZED;
        public static final Flag IS_TAILREC;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.isFunctionWithNonStableParameterNames")
        public static /* synthetic */ void getHAS_NON_STABLE_PARAMETER_NAMES$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.kind")
        public static /* synthetic */ void getIS_DECLARATION$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.kind")
        public static /* synthetic */ void getIS_DELEGATION$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.isExpectFunction")
        public static /* synthetic */ void getIS_EXPECT$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.isExternalFunction")
        public static /* synthetic */ void getIS_EXTERNAL$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.kind")
        public static /* synthetic */ void getIS_FAKE_OVERRIDE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.isInfix")
        public static /* synthetic */ void getIS_INFIX$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.isInline")
        public static /* synthetic */ void getIS_INLINE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.isOperator")
        public static /* synthetic */ void getIS_OPERATOR$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.isSuspend")
        public static /* synthetic */ void getIS_SUSPEND$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.kind")
        public static /* synthetic */ void getIS_SYNTHESIZED$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmFunction.isTailrec")
        public static /* synthetic */ void getIS_TAILREC$annotations() {
        }

        private Function() {
        }

        static {
            Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND = Flags.MEMBER_KIND;
            Intrinsics.checkNotNullExpressionValue(MEMBER_KIND, "MEMBER_KIND");
            IS_DECLARATION = new Flag(MEMBER_KIND, 0);
            Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND2 = Flags.MEMBER_KIND;
            Intrinsics.checkNotNullExpressionValue(MEMBER_KIND2, "MEMBER_KIND");
            IS_FAKE_OVERRIDE = new Flag(MEMBER_KIND2, 1);
            Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND3 = Flags.MEMBER_KIND;
            Intrinsics.checkNotNullExpressionValue(MEMBER_KIND3, "MEMBER_KIND");
            IS_DELEGATION = new Flag(MEMBER_KIND3, 2);
            Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND4 = Flags.MEMBER_KIND;
            Intrinsics.checkNotNullExpressionValue(MEMBER_KIND4, "MEMBER_KIND");
            IS_SYNTHESIZED = new Flag(MEMBER_KIND4, 3);
            Flags.BooleanFlagField IS_OPERATOR2 = Flags.IS_OPERATOR;
            Intrinsics.checkNotNullExpressionValue(IS_OPERATOR2, "IS_OPERATOR");
            IS_OPERATOR = new Flag(IS_OPERATOR2);
            Flags.BooleanFlagField IS_INFIX2 = Flags.IS_INFIX;
            Intrinsics.checkNotNullExpressionValue(IS_INFIX2, "IS_INFIX");
            IS_INFIX = new Flag(IS_INFIX2);
            Flags.BooleanFlagField IS_INLINE2 = Flags.IS_INLINE;
            Intrinsics.checkNotNullExpressionValue(IS_INLINE2, "IS_INLINE");
            IS_INLINE = new Flag(IS_INLINE2);
            Flags.BooleanFlagField IS_TAILREC2 = Flags.IS_TAILREC;
            Intrinsics.checkNotNullExpressionValue(IS_TAILREC2, "IS_TAILREC");
            IS_TAILREC = new Flag(IS_TAILREC2);
            Flags.BooleanFlagField IS_EXTERNAL_FUNCTION = Flags.IS_EXTERNAL_FUNCTION;
            Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_FUNCTION, "IS_EXTERNAL_FUNCTION");
            IS_EXTERNAL = new Flag(IS_EXTERNAL_FUNCTION);
            Flags.BooleanFlagField IS_SUSPEND2 = Flags.IS_SUSPEND;
            Intrinsics.checkNotNullExpressionValue(IS_SUSPEND2, "IS_SUSPEND");
            IS_SUSPEND = new Flag(IS_SUSPEND2);
            Flags.BooleanFlagField IS_EXPECT_FUNCTION = Flags.IS_EXPECT_FUNCTION;
            Intrinsics.checkNotNullExpressionValue(IS_EXPECT_FUNCTION, "IS_EXPECT_FUNCTION");
            IS_EXPECT = new Flag(IS_EXPECT_FUNCTION);
            Flags.BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
            Intrinsics.checkNotNullExpressionValue(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES, "IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES");
            HAS_NON_STABLE_PARAMETER_NAMES = new Flag(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES);
        }
    }

    /* compiled from: Flag.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0002R\u0016\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0002R\u0016\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0002R\u0016\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0002R\u0016\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0002R\u0016\u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0002¨\u0006\u001e"}, d2 = {"Lkotlinx/metadata/Flag$Property;", "", "()V", "HAS_CONSTANT", "Lkotlinx/metadata/Flag;", "getHAS_CONSTANT$annotations", "HAS_GETTER", "getHAS_GETTER$annotations", "HAS_SETTER", "getHAS_SETTER$annotations", "IS_CONST", "getIS_CONST$annotations", "IS_DECLARATION", "getIS_DECLARATION$annotations", "IS_DELEGATED", "getIS_DELEGATED$annotations", "IS_DELEGATION", "getIS_DELEGATION$annotations", "IS_EXPECT", "getIS_EXPECT$annotations", "IS_EXTERNAL", "getIS_EXTERNAL$annotations", "IS_FAKE_OVERRIDE", "getIS_FAKE_OVERRIDE$annotations", "IS_LATEINIT", "getIS_LATEINIT$annotations", "IS_SYNTHESIZED", "getIS_SYNTHESIZED$annotations", "IS_VAR", "getIS_VAR$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Property {
        public static final Flag HAS_CONSTANT;
        public static final Flag HAS_GETTER;
        public static final Flag HAS_SETTER;
        public static final Property INSTANCE = new Property();
        public static final Flag IS_CONST;
        public static final Flag IS_DECLARATION;
        public static final Flag IS_DELEGATED;
        public static final Flag IS_DELEGATION;
        public static final Flag IS_EXPECT;
        public static final Flag IS_EXTERNAL;
        public static final Flag IS_FAKE_OVERRIDE;
        public static final Flag IS_LATEINIT;
        public static final Flag IS_SYNTHESIZED;
        public static final Flag IS_VAR;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.hasConstant")
        public static /* synthetic */ void getHAS_CONSTANT$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.hasGetter")
        public static /* synthetic */ void getHAS_GETTER$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.hasSetter")
        public static /* synthetic */ void getHAS_SETTER$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.isConst")
        public static /* synthetic */ void getIS_CONST$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.kind")
        public static /* synthetic */ void getIS_DECLARATION$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.isDelegated")
        public static /* synthetic */ void getIS_DELEGATED$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.kind")
        public static /* synthetic */ void getIS_DELEGATION$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.isExpect")
        public static /* synthetic */ void getIS_EXPECT$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.isExternal")
        public static /* synthetic */ void getIS_EXTERNAL$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.kind")
        public static /* synthetic */ void getIS_FAKE_OVERRIDE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.isLateinit")
        public static /* synthetic */ void getIS_LATEINIT$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.kind")
        public static /* synthetic */ void getIS_SYNTHESIZED$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmProperty.isVar")
        public static /* synthetic */ void getIS_VAR$annotations() {
        }

        private Property() {
        }

        static {
            Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND = Flags.MEMBER_KIND;
            Intrinsics.checkNotNullExpressionValue(MEMBER_KIND, "MEMBER_KIND");
            IS_DECLARATION = new Flag(MEMBER_KIND, 0);
            Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND2 = Flags.MEMBER_KIND;
            Intrinsics.checkNotNullExpressionValue(MEMBER_KIND2, "MEMBER_KIND");
            IS_FAKE_OVERRIDE = new Flag(MEMBER_KIND2, 1);
            Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND3 = Flags.MEMBER_KIND;
            Intrinsics.checkNotNullExpressionValue(MEMBER_KIND3, "MEMBER_KIND");
            IS_DELEGATION = new Flag(MEMBER_KIND3, 2);
            Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND4 = Flags.MEMBER_KIND;
            Intrinsics.checkNotNullExpressionValue(MEMBER_KIND4, "MEMBER_KIND");
            IS_SYNTHESIZED = new Flag(MEMBER_KIND4, 3);
            Flags.BooleanFlagField IS_VAR2 = Flags.IS_VAR;
            Intrinsics.checkNotNullExpressionValue(IS_VAR2, "IS_VAR");
            IS_VAR = new Flag(IS_VAR2);
            Flags.BooleanFlagField HAS_GETTER2 = Flags.HAS_GETTER;
            Intrinsics.checkNotNullExpressionValue(HAS_GETTER2, "HAS_GETTER");
            HAS_GETTER = new Flag(HAS_GETTER2);
            Flags.BooleanFlagField HAS_SETTER2 = Flags.HAS_SETTER;
            Intrinsics.checkNotNullExpressionValue(HAS_SETTER2, "HAS_SETTER");
            HAS_SETTER = new Flag(HAS_SETTER2);
            Flags.BooleanFlagField IS_CONST2 = Flags.IS_CONST;
            Intrinsics.checkNotNullExpressionValue(IS_CONST2, "IS_CONST");
            IS_CONST = new Flag(IS_CONST2);
            Flags.BooleanFlagField IS_LATEINIT2 = Flags.IS_LATEINIT;
            Intrinsics.checkNotNullExpressionValue(IS_LATEINIT2, "IS_LATEINIT");
            IS_LATEINIT = new Flag(IS_LATEINIT2);
            Flags.BooleanFlagField HAS_CONSTANT2 = Flags.HAS_CONSTANT;
            Intrinsics.checkNotNullExpressionValue(HAS_CONSTANT2, "HAS_CONSTANT");
            HAS_CONSTANT = new Flag(HAS_CONSTANT2);
            Flags.BooleanFlagField IS_EXTERNAL_PROPERTY = Flags.IS_EXTERNAL_PROPERTY;
            Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_PROPERTY, "IS_EXTERNAL_PROPERTY");
            IS_EXTERNAL = new Flag(IS_EXTERNAL_PROPERTY);
            Flags.BooleanFlagField IS_DELEGATED2 = Flags.IS_DELEGATED;
            Intrinsics.checkNotNullExpressionValue(IS_DELEGATED2, "IS_DELEGATED");
            IS_DELEGATED = new Flag(IS_DELEGATED2);
            Flags.BooleanFlagField IS_EXPECT_PROPERTY = Flags.IS_EXPECT_PROPERTY;
            Intrinsics.checkNotNullExpressionValue(IS_EXPECT_PROPERTY, "IS_EXPECT_PROPERTY");
            IS_EXPECT = new Flag(IS_EXPECT_PROPERTY);
        }
    }

    /* compiled from: Flag.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\n"}, d2 = {"Lkotlinx/metadata/Flag$PropertyAccessor;", "", "()V", "IS_EXTERNAL", "Lkotlinx/metadata/Flag;", "getIS_EXTERNAL$annotations", "IS_INLINE", "getIS_INLINE$annotations", "IS_NOT_DEFAULT", "getIS_NOT_DEFAULT$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PropertyAccessor {
        public static final PropertyAccessor INSTANCE = new PropertyAccessor();
        public static final Flag IS_EXTERNAL;
        public static final Flag IS_INLINE;
        public static final Flag IS_NOT_DEFAULT;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmPropertyAccessorAttributes.isExternal")
        public static /* synthetic */ void getIS_EXTERNAL$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmPropertyAccessorAttributes.isInline")
        public static /* synthetic */ void getIS_INLINE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmPropertyAccessorAttributes.isNotDefault")
        public static /* synthetic */ void getIS_NOT_DEFAULT$annotations() {
        }

        private PropertyAccessor() {
        }

        static {
            Flags.BooleanFlagField IS_NOT_DEFAULT2 = Flags.IS_NOT_DEFAULT;
            Intrinsics.checkNotNullExpressionValue(IS_NOT_DEFAULT2, "IS_NOT_DEFAULT");
            IS_NOT_DEFAULT = new Flag(IS_NOT_DEFAULT2);
            Flags.BooleanFlagField IS_EXTERNAL_ACCESSOR = Flags.IS_EXTERNAL_ACCESSOR;
            Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_ACCESSOR, "IS_EXTERNAL_ACCESSOR");
            IS_EXTERNAL = new Flag(IS_EXTERNAL_ACCESSOR);
            Flags.BooleanFlagField IS_INLINE_ACCESSOR = Flags.IS_INLINE_ACCESSOR;
            Intrinsics.checkNotNullExpressionValue(IS_INLINE_ACCESSOR, "IS_INLINE_ACCESSOR");
            IS_INLINE = new Flag(IS_INLINE_ACCESSOR);
        }
    }

    /* compiled from: Flag.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\n"}, d2 = {"Lkotlinx/metadata/Flag$Type;", "", "()V", "IS_DEFINITELY_NON_NULL", "Lkotlinx/metadata/Flag;", "getIS_DEFINITELY_NON_NULL$annotations", "IS_NULLABLE", "getIS_NULLABLE$annotations", "IS_SUSPEND", "getIS_SUSPEND$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Type {
        public static final Type INSTANCE = new Type();
        public static final Flag IS_NULLABLE = new Flag(0, 1, 1);
        public static final Flag IS_SUSPEND = new Flag(Flags.SUSPEND_TYPE.offset + 1, Flags.SUSPEND_TYPE.bitWidth, 1);
        public static final Flag IS_DEFINITELY_NON_NULL = new Flag(Flags.DEFINITELY_NOT_NULL_TYPE.offset + 1, Flags.DEFINITELY_NOT_NULL_TYPE.bitWidth, 1);

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmType.isDefinitelyNonNull")
        public static /* synthetic */ void getIS_DEFINITELY_NON_NULL$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmType.isNullable")
        public static /* synthetic */ void getIS_NULLABLE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmType.isSuspend")
        public static /* synthetic */ void getIS_SUSPEND$annotations() {
        }

        private Type() {
        }
    }

    /* compiled from: Flag.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Lkotlinx/metadata/Flag$TypeParameter;", "", "()V", "IS_REIFIED", "Lkotlinx/metadata/Flag;", "getIS_REIFIED$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TypeParameter {
        public static final TypeParameter INSTANCE = new TypeParameter();
        public static final Flag IS_REIFIED = new Flag(0, 1, 1);

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmTypeParameter.isReified")
        public static /* synthetic */ void getIS_REIFIED$annotations() {
        }

        private TypeParameter() {
        }
    }

    /* compiled from: Flag.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\n"}, d2 = {"Lkotlinx/metadata/Flag$ValueParameter;", "", "()V", "DECLARES_DEFAULT_VALUE", "Lkotlinx/metadata/Flag;", "getDECLARES_DEFAULT_VALUE$annotations", "IS_CROSSINLINE", "getIS_CROSSINLINE$annotations", "IS_NOINLINE", "getIS_NOINLINE$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ValueParameter {
        public static final Flag DECLARES_DEFAULT_VALUE;
        public static final ValueParameter INSTANCE = new ValueParameter();
        public static final Flag IS_CROSSINLINE;
        public static final Flag IS_NOINLINE;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmValueParameter.declaresDefaultValue")
        public static /* synthetic */ void getDECLARES_DEFAULT_VALUE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmValueParameter.isCrossinline")
        public static /* synthetic */ void getIS_CROSSINLINE$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmValueParameter.isNoinline")
        public static /* synthetic */ void getIS_NOINLINE$annotations() {
        }

        private ValueParameter() {
        }

        static {
            Flags.BooleanFlagField DECLARES_DEFAULT_VALUE2 = Flags.DECLARES_DEFAULT_VALUE;
            Intrinsics.checkNotNullExpressionValue(DECLARES_DEFAULT_VALUE2, "DECLARES_DEFAULT_VALUE");
            DECLARES_DEFAULT_VALUE = new Flag(DECLARES_DEFAULT_VALUE2);
            Flags.BooleanFlagField IS_CROSSINLINE2 = Flags.IS_CROSSINLINE;
            Intrinsics.checkNotNullExpressionValue(IS_CROSSINLINE2, "IS_CROSSINLINE");
            IS_CROSSINLINE = new Flag(IS_CROSSINLINE2);
            Flags.BooleanFlagField IS_NOINLINE2 = Flags.IS_NOINLINE;
            Intrinsics.checkNotNullExpressionValue(IS_NOINLINE2, "IS_NOINLINE");
            IS_NOINLINE = new Flag(IS_NOINLINE2);
        }
    }

    /* compiled from: Flag.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, d2 = {"Lkotlinx/metadata/Flag$EffectExpression;", "", "()V", "IS_NEGATED", "Lkotlinx/metadata/Flag;", "getIS_NEGATED$annotations", "IS_NULL_CHECK_PREDICATE", "getIS_NULL_CHECK_PREDICATE$annotations", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class EffectExpression {
        public static final EffectExpression INSTANCE = new EffectExpression();
        public static final Flag IS_NEGATED;
        public static final Flag IS_NULL_CHECK_PREDICATE;

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmEffectExpression.isNegated")
        public static /* synthetic */ void getIS_NEGATED$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use KmEffectExpression.isNullCheckPredicate")
        public static /* synthetic */ void getIS_NULL_CHECK_PREDICATE$annotations() {
        }

        private EffectExpression() {
        }

        static {
            Flags.BooleanFlagField IS_NEGATED2 = Flags.IS_NEGATED;
            Intrinsics.checkNotNullExpressionValue(IS_NEGATED2, "IS_NEGATED");
            IS_NEGATED = new Flag(IS_NEGATED2);
            Flags.BooleanFlagField IS_NULL_CHECK_PREDICATE2 = Flags.IS_NULL_CHECK_PREDICATE;
            Intrinsics.checkNotNullExpressionValue(IS_NULL_CHECK_PREDICATE2, "IS_NULL_CHECK_PREDICATE");
            IS_NULL_CHECK_PREDICATE = new Flag(IS_NULL_CHECK_PREDICATE2);
        }
    }
}
