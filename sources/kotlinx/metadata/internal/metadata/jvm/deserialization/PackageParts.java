package kotlinx.metadata.internal.metadata.jvm.deserialization;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf;
/* compiled from: ModuleMapping.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ.\u0010\u001b\u001a\u00020\u0011*\u00020\u001c2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001fH\u0002J6\u0010!\u001a\u00020\u0011*\u00020\u001c2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\"\u001a\u00020\u001aH\u0002J$\u0010#\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001fH\u0002J \u0010$\u001a\u00020\u0011*\u00020\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0%H\u0002J\u0010\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003J\u0011\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0000H\u0086\u0002J\u0013\u0010.\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00100\u001a\u00020 H\u0016J\b\u00101\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010&\u001a\u00020\u0003*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010)\u001a\u00020\u0003*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(¨\u00062"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/PackageParts;", "", "packageFqName", "", "<init>", "(Ljava/lang/String;)V", "getPackageFqName", "()Ljava/lang/String;", "packageParts", "Ljava/util/LinkedHashMap;", "parts", "", "getParts", "()Ljava/util/Set;", "metadataParts", "getMetadataParts", "addPart", "", "partInternalName", "facadeInternalName", "removePart", "internalName", "addMetadataPart", "shortName", "addTo", "builder", "Lkotlinx/metadata/internal/metadata/jvm/JvmModuleProtoBuf$Module$Builder;", "writePartsWithinPackage", "Lkotlinx/metadata/internal/metadata/jvm/JvmModuleProtoBuf$PackageParts$Builder;", "", "facadeNameToId", "", "", "writePartsOutsidePackage", "packageTableBuilder", "getMultifileFacadeShortNameId", "writeMultifileFacadeNames", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "getPackageName", "(Ljava/lang/String;)Ljava/lang/String;", "className", "getClassName", "getMultifileFacadeName", "plusAssign", "other", "equals", "", "hashCode", "toString", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class PackageParts {
    private final Set<String> metadataParts;
    private final String packageFqName;
    private final LinkedHashMap<String, String> packageParts;

    public PackageParts(String packageFqName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        this.packageFqName = packageFqName;
        this.packageParts = new LinkedHashMap<>();
        this.metadataParts = new LinkedHashSet();
    }

    public final String getPackageFqName() {
        return this.packageFqName;
    }

    public final Set<String> getParts() {
        Set<String> keySet = this.packageParts.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        return keySet;
    }

    public final Set<String> getMetadataParts() {
        return this.metadataParts;
    }

    public final void addPart(String partInternalName, String str) {
        Intrinsics.checkNotNullParameter(partInternalName, "partInternalName");
        this.packageParts.put(partInternalName, str);
    }

    public final void removePart(String internalName) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        this.packageParts.remove(internalName);
    }

    public final void addMetadataPart(String shortName) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Set<String> set = this.metadataParts;
        Intrinsics.checkNotNull(set, "null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
        TypeIntrinsics.asMutableSet(set).add(shortName);
    }

    public final void addTo(JvmModuleProtoBuf.Module.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!getParts().isEmpty()) {
            JvmModuleProtoBuf.PackageParts.Builder newBuilder = JvmModuleProtoBuf.PackageParts.newBuilder();
            newBuilder.setPackageFqName(this.packageFqName);
            String packageFqName = newBuilder.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "getPackageFqName(...)");
            String replace$default = StringsKt.replace$default(packageFqName, '.', '/', false, 4, (Object) null);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : getParts()) {
                if (Intrinsics.areEqual(getPackageName((String) obj), replace$default)) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            }
            Pair pair = new Pair(arrayList, arrayList2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Intrinsics.checkNotNull(newBuilder);
            writePartsWithinPackage(newBuilder, (List) pair.component1(), linkedHashMap);
            writePartsOutsidePackage(newBuilder, (List) pair.component2(), linkedHashMap, builder);
            writeMultifileFacadeNames(newBuilder, linkedHashMap);
            builder.addPackageParts(newBuilder);
        }
        if (this.metadataParts.isEmpty()) {
            return;
        }
        JvmModuleProtoBuf.PackageParts.Builder newBuilder2 = JvmModuleProtoBuf.PackageParts.newBuilder();
        newBuilder2.setPackageFqName(this.packageFqName);
        newBuilder2.addAllShortClassName(CollectionsKt.sorted(this.metadataParts));
        builder.addMetadataParts(newBuilder2);
    }

    private final void writePartsWithinPackage(JvmModuleProtoBuf.PackageParts.Builder builder, List<String> list, Map<String, Integer> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String multifileFacadeName = getMultifileFacadeName((String) obj);
            Object obj2 = linkedHashMap.get(multifileFacadeName);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(multifileFacadeName, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (Map.Entry entry : MapsKt.toSortedMap(linkedHashMap, ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder())).entrySet()) {
            String str = (String) entry.getKey();
            List list2 = (List) entry.getValue();
            Intrinsics.checkNotNull(list2);
            for (String str2 : CollectionsKt.sorted(list2)) {
                builder.addShortClassName(getClassName(str2));
                if (str != null) {
                    builder.addMultifileFacadeShortNameId(getMultifileFacadeShortNameId(str, map));
                }
            }
        }
    }

    private final void writePartsOutsidePackage(JvmModuleProtoBuf.PackageParts.Builder builder, List<String> list, Map<String, Integer> map, JvmModuleProtoBuf.Module.Builder builder2) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String packageName = getPackageName((String) obj);
            Object obj2 = linkedHashMap.get(packageName);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(packageName, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (Map.Entry entry : MapsKt.toSortedMap(linkedHashMap).entrySet()) {
            String str = (String) entry.getKey();
            List list2 = (List) entry.getValue();
            Intrinsics.checkNotNull(str);
            String replace$default = StringsKt.replace$default(str, '/', '.', false, 4, (Object) null);
            if (!builder2.getJvmPackageNameList().contains(replace$default)) {
                builder2.addJvmPackageName(replace$default);
            }
            int indexOf = builder2.getJvmPackageNameList().indexOf(replace$default);
            Intrinsics.checkNotNull(list2);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                String multifileFacadeName = getMultifileFacadeName((String) obj3);
                Object obj4 = linkedHashMap2.get(multifileFacadeName);
                if (obj4 == null) {
                    obj4 = (List) new ArrayList();
                    linkedHashMap2.put(multifileFacadeName, obj4);
                }
                ((List) obj4).add(obj3);
            }
            for (Map.Entry entry2 : MapsKt.toSortedMap(linkedHashMap2, ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder())).entrySet()) {
                String str2 = (String) entry2.getKey();
                List list3 = (List) entry2.getValue();
                Intrinsics.checkNotNull(list3);
                for (String str3 : CollectionsKt.sorted(list3)) {
                    builder.addClassWithJvmPackageNameShortName(getClassName(str3));
                    if (str2 != null) {
                        builder.addClassWithJvmPackageNameMultifileFacadeShortNameId(getMultifileFacadeShortNameId(str2, map));
                    }
                    arrayList.add(Integer.valueOf(indexOf));
                }
            }
        }
        while (arrayList.size() > 1 && ((Number) arrayList.get(arrayList.size() - 1)).intValue() == ((Number) arrayList.get(arrayList.size() - 2)).intValue()) {
            arrayList.remove(arrayList.size() - 1);
        }
        builder.addAllClassWithJvmPackageNamePackageId(arrayList);
    }

    private final int getMultifileFacadeShortNameId(String str, Map<String, Integer> map) {
        String className = getClassName(str);
        Integer num = map.get(className);
        if (num == null) {
            num = Integer.valueOf(map.size());
            map.put(className, num);
        }
        return num.intValue() + 1;
    }

    private final void writeMultifileFacadeNames(JvmModuleProtoBuf.PackageParts.Builder builder, Map<String, Integer> map) {
        for (Pair pair : CollectionsKt.sortedWith(CollectionsKt.zip(map.values(), map.keySet()), new Comparator() { // from class: kotlinx.metadata.internal.metadata.jvm.deserialization.PackageParts$writeMultifileFacadeNames$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((Number) ((Pair) t).getFirst()).intValue()), Integer.valueOf(((Number) ((Pair) t2).getFirst()).intValue()));
            }
        })) {
            ((Number) pair.component1()).intValue();
            builder.getMultifileFacadeShortNameCount();
            builder.addMultifileFacadeShortName((String) pair.component2());
        }
    }

    private final String getPackageName(String str) {
        return StringsKt.substringBeforeLast(str, '/', "");
    }

    private final String getClassName(String str) {
        return StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null);
    }

    public final String getMultifileFacadeName(String partInternalName) {
        Intrinsics.checkNotNullParameter(partInternalName, "partInternalName");
        return this.packageParts.get(partInternalName);
    }

    public final void plusAssign(PackageParts other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (Map.Entry<String, String> entry : other.packageParts.entrySet()) {
            addPart(entry.getKey(), entry.getValue());
        }
        for (String str : other.metadataParts) {
            addMetadataPart(str);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof PackageParts) {
            PackageParts packageParts = (PackageParts) obj;
            return Intrinsics.areEqual(packageParts.packageFqName, this.packageFqName) && Intrinsics.areEqual(packageParts.packageParts, this.packageParts) && Intrinsics.areEqual(packageParts.metadataParts, this.metadataParts);
        }
        return false;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.packageParts.hashCode()) * 31) + this.metadataParts.hashCode();
    }

    public String toString() {
        return SetsKt.plus((Set) getParts(), (Iterable) this.metadataParts).toString();
    }
}
