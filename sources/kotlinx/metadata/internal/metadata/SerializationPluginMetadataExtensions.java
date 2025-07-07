package kotlinx.metadata.internal.metadata;

import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.WireFormat;
/* loaded from: classes5.dex */
public final class SerializationPluginMetadataExtensions {
    public static final int PROPERTIES_NAMES_IN_PROGRAM_ORDER_FIELD_NUMBER = 18000;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<Integer>> propertiesNamesInProgramOrder = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), null, null, PROPERTIES_NAMES_IN_PROGRAM_ORDER_FIELD_NUMBER, WireFormat.FieldType.INT32, false, Integer.class);

    private SerializationPluginMetadataExtensions() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(propertiesNamesInProgramOrder);
    }
}
