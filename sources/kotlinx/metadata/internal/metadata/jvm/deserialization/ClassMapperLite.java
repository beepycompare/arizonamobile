package kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
/* compiled from: ClassMapperLite.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/ClassMapperLite;", "", "<init>", "()V", "kotlin", "", "map", "", "mapClass", "classId", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f1324kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
    private static final Map<String, String> map;

    private ClassMapperLite() {
    }

    static {
        char c;
        char c2;
        char c3;
        char c4;
        int i;
        int i2 = 0;
        char c5 = 3;
        char c6 = 4;
        char c7 = 5;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        char c8 = '\b';
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                StringBuilder sb = new StringBuilder();
                c = c5;
                String str = f1324kotlin;
                c2 = c6;
                c3 = c7;
                c4 = c8;
                linkedHashMap.put(sb.append(str).append('/').append((String) listOf.get(i2)).toString(), listOf.get(i2 + 1));
                linkedHashMap.put(str + '/' + ((String) listOf.get(i2)) + "Array", "[" + ((String) listOf.get(i)));
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 += 2;
                c5 = c;
                c6 = c2;
                c8 = c4;
                c7 = c3;
            }
        } else {
            c = 3;
            c2 = 4;
            c3 = 5;
            c4 = '\b';
        }
        linkedHashMap.put(f1324kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        map$lambda$0$add(linkedHashMap, "Any", "java/lang/Object");
        map$lambda$0$add(linkedHashMap, "Nothing", "java/lang/Void");
        map$lambda$0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        String[] strArr = new String[7];
        strArr[0] = "String";
        strArr[1] = "CharSequence";
        strArr[2] = "Throwable";
        strArr[c] = "Cloneable";
        strArr[c2] = "Number";
        strArr[c3] = "Comparable";
        strArr[6] = "Enum";
        for (String str2 : CollectionsKt.listOf((Object[]) strArr)) {
            map$lambda$0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        String[] strArr2 = new String[6];
        strArr2[0] = "Iterator";
        strArr2[1] = "Collection";
        strArr2[2] = "List";
        strArr2[c] = "Set";
        strArr2[c2] = "Map";
        strArr2[c3] = "ListIterator";
        for (String str3 : CollectionsKt.listOf((Object[]) strArr2)) {
            map$lambda$0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            map$lambda$0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        map$lambda$0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f1324kotlin;
            map$lambda$0$add(linkedHashMap, "Function" + i3, sb2.append(str4).append("/jvm/functions/Function").append(i3).toString());
            map$lambda$0$add(linkedHashMap, "reflect/KFunction" + i3, str4 + "/reflect/KFunction");
        }
        String[] strArr3 = new String[9];
        strArr3[0] = "Char";
        strArr3[1] = "Byte";
        strArr3[2] = "Short";
        strArr3[c] = "Int";
        strArr3[c2] = "Float";
        strArr3[c3] = "Long";
        strArr3[6] = "Double";
        strArr3[7] = "String";
        strArr3[c4] = "Enum";
        for (String str5 : CollectionsKt.listOf((Object[]) strArr3)) {
            map$lambda$0$add(linkedHashMap, str5 + ".Companion", f1324kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private static final void map$lambda$0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f1324kotlin + '/' + str, "L" + str2 + ';');
    }

    @JvmStatic
    public static final String mapClass(String classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        String str = map.get(classId);
        return str == null ? "L" + StringsKt.replace$default(classId, '.', (char) Typography.dollar, false, 4, (Object) null) + ';' : str;
    }
}
