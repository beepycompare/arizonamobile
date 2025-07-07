package kotlinx.metadata.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.ClassNameKt;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmAnnotationArgument;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
import kotlinx.metadata.internal.metadata.serialization.StringTable;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: WriteUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\t\u001a\u00020\u0002¨\u0006\r"}, d2 = {"getClassNameIndex", "", "Lkotlinx/metadata/internal/metadata/serialization/StringTable;", "name", "", "Lkotlinx/metadata/ClassName;", "writeAnnotation", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Annotation$Builder;", "Lkotlinx/metadata/KmAnnotation;", "strings", "writeAnnotationArgument", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Annotation$Argument$Value$Builder;", "Lkotlinx/metadata/KmAnnotationArgument;", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WriteUtilsKt {
    public static final ProtoBuf.Annotation.Builder writeAnnotation(KmAnnotation kmAnnotation, StringTable strings) {
        Intrinsics.checkNotNullParameter(kmAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ProtoBuf.Annotation.Builder newBuilder = ProtoBuf.Annotation.newBuilder();
        newBuilder.setId(getClassNameIndex(strings, kmAnnotation.getClassName()));
        for (Map.Entry<String, KmAnnotationArgument> entry : kmAnnotation.getArguments().entrySet()) {
            ProtoBuf.Annotation.Argument.Builder newBuilder2 = ProtoBuf.Annotation.Argument.newBuilder();
            newBuilder2.setNameId(strings.getStringIndex(entry.getKey()));
            newBuilder2.setValue(writeAnnotationArgument(entry.getValue(), strings).build());
            newBuilder.addArgument(newBuilder2);
        }
        Intrinsics.checkNotNullExpressionValue(newBuilder, "apply(...)");
        return newBuilder;
    }

    public static final ProtoBuf.Annotation.Argument.Value.Builder writeAnnotationArgument(KmAnnotationArgument kmAnnotationArgument, StringTable strings) {
        Intrinsics.checkNotNullParameter(kmAnnotationArgument, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ProtoBuf.Annotation.Argument.Value.Builder newBuilder = ProtoBuf.Annotation.Argument.Value.newBuilder();
        if (kmAnnotationArgument instanceof KmAnnotationArgument.ByteValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            newBuilder.setIntValue(((KmAnnotationArgument.ByteValue) kmAnnotationArgument).getValue().byteValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.CharValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.CHAR);
            newBuilder.setIntValue(((KmAnnotationArgument.CharValue) kmAnnotationArgument).getValue().charValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.ShortValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            newBuilder.setIntValue(((KmAnnotationArgument.ShortValue) kmAnnotationArgument).getValue().shortValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.IntValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.INT);
            newBuilder.setIntValue(((KmAnnotationArgument.IntValue) kmAnnotationArgument).getValue().intValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.LongValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.LONG);
            newBuilder.setIntValue(((KmAnnotationArgument.LongValue) kmAnnotationArgument).getValue().longValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.FloatValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.FLOAT);
            newBuilder.setFloatValue(((KmAnnotationArgument.FloatValue) kmAnnotationArgument).getValue().floatValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.DoubleValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.DOUBLE);
            newBuilder.setDoubleValue(((KmAnnotationArgument.DoubleValue) kmAnnotationArgument).getValue().doubleValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.BooleanValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN);
            newBuilder.setIntValue(((KmAnnotationArgument.BooleanValue) kmAnnotationArgument).getValue().booleanValue() ? 1L : 0L);
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.UByteValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            newBuilder.setIntValue(((KmAnnotationArgument.UByteValue) kmAnnotationArgument).m10089getValuew2LRezQ() & 255);
            newBuilder.setFlags(Flags.IS_UNSIGNED.toFlags((Boolean) true));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.UShortValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            newBuilder.setIntValue(((KmAnnotationArgument.UShortValue) kmAnnotationArgument).m10101getValueMh2AYeg() & WebSocketProtocol.PAYLOAD_SHORT_MAX);
            newBuilder.setFlags(Flags.IS_UNSIGNED.toFlags((Boolean) true));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.UIntValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.INT);
            newBuilder.setIntValue(((KmAnnotationArgument.UIntValue) kmAnnotationArgument).m10093getValuepVg5ArA() & 4294967295L);
            newBuilder.setFlags(Flags.IS_UNSIGNED.toFlags((Boolean) true));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.ULongValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.LONG);
            newBuilder.setIntValue(((KmAnnotationArgument.ULongValue) kmAnnotationArgument).m10097getValuesVKNKU());
            newBuilder.setFlags(Flags.IS_UNSIGNED.toFlags((Boolean) true));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.StringValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.STRING);
            newBuilder.setStringValue(strings.getStringIndex(((KmAnnotationArgument.StringValue) kmAnnotationArgument).getValue()));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.KClassValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            newBuilder.setClassId(getClassNameIndex(strings, ((KmAnnotationArgument.KClassValue) kmAnnotationArgument).getClassName()));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.ArrayKClassValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            KmAnnotationArgument.ArrayKClassValue arrayKClassValue = (KmAnnotationArgument.ArrayKClassValue) kmAnnotationArgument;
            newBuilder.setClassId(getClassNameIndex(strings, arrayKClassValue.getClassName()));
            newBuilder.setArrayDimensionCount(arrayKClassValue.getArrayDimensionCount());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.EnumValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.ENUM);
            KmAnnotationArgument.EnumValue enumValue = (KmAnnotationArgument.EnumValue) kmAnnotationArgument;
            newBuilder.setClassId(getClassNameIndex(strings, enumValue.getEnumClassName()));
            newBuilder.setEnumValueId(strings.getStringIndex(enumValue.getEnumEntryName()));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.AnnotationValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION);
            newBuilder.setAnnotation(writeAnnotation(((KmAnnotationArgument.AnnotationValue) kmAnnotationArgument).getAnnotation(), strings).build());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.ArrayValue) {
            newBuilder.setType(ProtoBuf.Annotation.Argument.Value.Type.ARRAY);
            for (KmAnnotationArgument kmAnnotationArgument2 : ((KmAnnotationArgument.ArrayValue) kmAnnotationArgument).getElements()) {
                newBuilder.addArrayElement(writeAnnotationArgument(kmAnnotationArgument2, strings));
            }
        }
        Intrinsics.checkNotNullExpressionValue(newBuilder, "apply(...)");
        return newBuilder;
    }

    public static final int getClassNameIndex(StringTable stringTable, String name) {
        Intrinsics.checkNotNullParameter(stringTable, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (ClassNameKt.isLocalClassName(name)) {
            String substring = name.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return stringTable.getQualifiedClassNameIndex(substring, true);
        }
        return stringTable.getQualifiedClassNameIndex(name, false);
    }
}
