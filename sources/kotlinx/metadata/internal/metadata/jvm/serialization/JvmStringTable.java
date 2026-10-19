package kotlinx.metadata.internal.metadata.jvm.serialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmNameResolver;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmNameResolverBase;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmNameResolverKt;
import kotlinx.metadata.internal.metadata.serialization.StringTable;
/* compiled from: JvmStringTable.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\f\u0010\u0014\u001a\u00020\u0015*\u00020\fH\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/serialization/JvmStringTable;", "Lkotlinx/metadata/internal/metadata/serialization/StringTable;", "nameResolver", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolver;)V", "strings", "Ljava/util/ArrayList;", "", "getStrings", "()Ljava/util/ArrayList;", "records", "Lkotlinx/metadata/internal/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Builder;", "map", "Ljava/util/HashMap;", "", "localNames", "Ljava/util/LinkedHashSet;", "getStringIndex", TypedValues.Custom.S_STRING, "isTrivial", "", "getQualifiedClassNameIndex", "className", "isLocal", "serializeTo", "", "output", "Ljava/io/OutputStream;", "toNameResolver", "Lkotlinx/metadata/internal/metadata/deserialization/NameResolver;", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public class JvmStringTable implements StringTable {
    private final LinkedHashSet<Integer> localNames;
    private final HashMap<String, Integer> map;
    private final ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> records;
    private final ArrayList<String> strings;

    public JvmStringTable() {
        this(null, 1, null);
    }

    public JvmStringTable(JvmNameResolver jvmNameResolver) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.strings = arrayList;
        ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> arrayList2 = new ArrayList<>();
        this.records = arrayList2;
        this.map = new HashMap<>();
        this.localNames = new LinkedHashSet<>();
        if (jvmNameResolver != null) {
            CollectionsKt.addAll(arrayList, jvmNameResolver.getStrings());
            List<JvmProtoBuf.StringTableTypes.Record> recordList = jvmNameResolver.getTypes().getRecordList();
            Intrinsics.checkNotNullExpressionValue(recordList, "getRecordList(...)");
            ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> arrayList3 = arrayList2;
            for (JvmProtoBuf.StringTableTypes.Record record : recordList) {
                arrayList3.add(record.toBuilder());
            }
            int size = this.strings.size();
            for (int i = 0; i < size; i++) {
                this.map.put(jvmNameResolver.getString(i), Integer.valueOf(i));
            }
            this.localNames.addAll(jvmNameResolver.getTypes().getLocalNameList());
        }
    }

    public /* synthetic */ JvmStringTable(JvmNameResolver jvmNameResolver, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jvmNameResolver);
    }

    public final ArrayList<String> getStrings() {
        return this.strings;
    }

    @Override // kotlinx.metadata.internal.metadata.serialization.StringTable
    public int getStringIndex(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        HashMap<String, Integer> hashMap = this.map;
        Integer num = hashMap.get(string);
        if (num == null) {
            int size = this.strings.size();
            this.strings.add(string);
            JvmProtoBuf.StringTableTypes.Record.Builder builder = (JvmProtoBuf.StringTableTypes.Record.Builder) CollectionsKt.lastOrNull((List<? extends Object>) this.records);
            if (builder != null && isTrivial(builder)) {
                builder.setRange(builder.getRange() + 1);
            } else {
                this.records.add(JvmProtoBuf.StringTableTypes.Record.newBuilder());
            }
            num = Integer.valueOf(size);
            hashMap.put(string, num);
        }
        return num.intValue();
    }

    private final boolean isTrivial(JvmProtoBuf.StringTableTypes.Record.Builder builder) {
        return !builder.hasPredefinedIndex() && !builder.hasOperation() && builder.getSubstringIndexCount() == 0 && builder.getReplaceCharCount() == 0;
    }

    @Override // kotlinx.metadata.internal.metadata.serialization.StringTable
    public int getQualifiedClassNameIndex(String className, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(className, "className");
        Integer num = this.map.get(className);
        if (num != null) {
            int intValue = num.intValue();
            if (z == this.localNames.contains(Integer.valueOf(intValue))) {
                return intValue;
            }
        }
        int size = this.strings.size();
        if (z) {
            this.localNames.add(Integer.valueOf(size));
        }
        JvmProtoBuf.StringTableTypes.Record.Builder newBuilder = JvmProtoBuf.StringTableTypes.Record.newBuilder();
        if (z || StringsKt.contains$default((CharSequence) className, (char) Typography.dollar, false, 2, (Object) null)) {
            str = className;
            this.strings.add(str);
        } else {
            Integer predefinedStringIndex = JvmNameResolverBase.Companion.getPredefinedStringIndex(className);
            if (predefinedStringIndex != null) {
                newBuilder.setPredefinedIndex(predefinedStringIndex.intValue());
                this.strings.add("");
                str = className;
            } else {
                newBuilder.setOperation(JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID);
                str = className;
                this.strings.add("L" + StringsKt.replace$default(str, '.', (char) Typography.dollar, false, 4, (Object) null) + ';');
            }
        }
        this.records.add(newBuilder);
        this.map.put(str, Integer.valueOf(size));
        return size;
    }

    public final void serializeTo(OutputStream output) {
        Intrinsics.checkNotNullParameter(output, "output");
        JvmProtoBuf.StringTableTypes.Builder newBuilder = JvmProtoBuf.StringTableTypes.newBuilder();
        ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> arrayList = this.records;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (JvmProtoBuf.StringTableTypes.Record.Builder builder : arrayList) {
            arrayList2.add(builder.build());
        }
        newBuilder.addAllRecord(arrayList2);
        newBuilder.addAllLocalName(this.localNames);
        newBuilder.build().writeDelimitedTo(output);
    }

    public final NameResolver toNameResolver() {
        String[] strArr = (String[]) this.strings.toArray(new String[0]);
        LinkedHashSet<Integer> linkedHashSet = this.localNames;
        ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> arrayList = this.records;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (JvmProtoBuf.StringTableTypes.Record.Builder builder : arrayList) {
            arrayList2.add(builder.build());
        }
        return new JvmNameResolverBase(strArr, linkedHashSet, JvmNameResolverKt.toExpandedRecordsList(arrayList2));
    }
}
