package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PathParser.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ8\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0011\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082\bJ\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", "", "<init>", "()V", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "nodeData", "", "clear", "", "parsePathString", "pathData", "", "pathStringToNodes", "resizeNodeData", "dataCount", "", "addPathNodes", "", "toNodes", "toPath", "Landroidx/compose/ui/graphics/Path;", TypedValues.AttributesType.S_TARGET, "ui-graphics"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PathParser {
    public static final int $stable = 8;
    private float[] nodeData = new float[64];
    private ArrayList<PathNode> nodes;

    public final void clear() {
        ArrayList<PathNode> arrayList = this.nodes;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final PathParser parsePathString(String str) {
        ArrayList<PathNode> arrayList = this.nodes;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.nodes = arrayList;
        } else {
            arrayList.clear();
        }
        pathStringToNodes(str, arrayList);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList pathStringToNodes$default(PathParser pathParser, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            arrayList = new ArrayList();
        }
        return pathParser.pathStringToNodes(str, arrayList);
    }

    public final ArrayList<PathNode> pathStringToNodes(String str, ArrayList<PathNode> arrayList) {
        int i;
        char charAt;
        long nextFloat;
        float intBitsToFloat;
        int length = str.length();
        int i2 = 0;
        while (i2 < length && Intrinsics.compare((int) str.charAt(i2), 32) <= 0) {
            i2++;
        }
        while (length > i2 && Intrinsics.compare((int) str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i3 = 0;
        while (i2 < length) {
            while (true) {
                i = i2 + 1;
                charAt = str.charAt(i2);
                int i4 = charAt | ' ';
                if ((i4 - 97) * (i4 - 122) <= 0 && i4 != 101) {
                    break;
                } else if (i >= length) {
                    charAt = 0;
                    break;
                } else {
                    i2 = i;
                }
            }
            if (charAt != 0) {
                int i5 = charAt | ' ';
                if (i5 != 122) {
                    while (i < length && Intrinsics.compare((int) str.charAt(i), 32) <= 0) {
                        i++;
                    }
                    boolean z = i5 == 97;
                    int i6 = 0;
                    do {
                        if (z && 3 <= i6 && i6 < 5) {
                            nextFloat = FastFloatParserKt.nextFloat(str, i, Math.min(i + 1, length));
                        } else {
                            nextFloat = FastFloatParserKt.nextFloat(str, i, length);
                        }
                        i = (int) (nextFloat >>> 32);
                        intBitsToFloat = Float.intBitsToFloat((int) (nextFloat & 4294967295L));
                        if (!Float.isNaN(intBitsToFloat)) {
                            float[] fArr = this.nodeData;
                            int i7 = i6 + 1;
                            fArr[i6] = intBitsToFloat;
                            if (i7 >= fArr.length) {
                                float[] fArr2 = new float[i7 * 2];
                                this.nodeData = fArr2;
                                ArraysKt.copyInto(fArr, fArr2, 0, 0, fArr.length);
                            }
                            i6 = i7;
                        }
                        while (i < length && (Intrinsics.compare((int) str.charAt(i), 32) <= 0 || str.charAt(i) == ',')) {
                            i++;
                        }
                        if (i >= length) {
                            break;
                        }
                    } while (!Float.isNaN(intBitsToFloat));
                    i3 = i6;
                }
                PathNodeKt.addPathNodes(charAt, arrayList, this.nodeData, i3);
            }
            i2 = i;
        }
        return arrayList;
    }

    private final void resizeNodeData(int i) {
        float[] fArr = this.nodeData;
        if (i >= fArr.length) {
            float[] fArr2 = new float[i * 2];
            this.nodeData = fArr2;
            ArraysKt.copyInto(fArr, fArr2, 0, 0, fArr.length);
        }
    }

    public final PathParser addPathNodes(List<? extends PathNode> list) {
        ArrayList<PathNode> arrayList = this.nodes;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.nodes = arrayList;
        }
        arrayList.addAll(list);
        return this;
    }

    public final List<PathNode> toNodes() {
        ArrayList<PathNode> arrayList = this.nodes;
        return arrayList != null ? arrayList : CollectionsKt.emptyList();
    }

    public static /* synthetic */ Path toPath$default(PathParser pathParser, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(path);
    }

    public final Path toPath(Path path) {
        Path path2;
        ArrayList<PathNode> arrayList = this.nodes;
        return (arrayList == null || (path2 = PathParserKt.toPath(arrayList, path)) == null) ? AndroidPath_androidKt.Path() : path2;
    }
}
