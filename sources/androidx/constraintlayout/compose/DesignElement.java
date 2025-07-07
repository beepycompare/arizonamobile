package androidx.constraintlayout.compose;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConstraintLayout.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J%\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/constraintlayout/compose/DesignElement;", "", "id", "", "type", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DesignElement {
    public static final int $stable = 8;
    private String id;
    private HashMap<String, String> params;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DesignElement copy$default(DesignElement designElement, String str, String str2, HashMap hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = designElement.id;
        }
        if ((i & 2) != 0) {
            str2 = designElement.type;
        }
        if ((i & 4) != 0) {
            hashMap = designElement.params;
        }
        return designElement.copy(str, str2, hashMap);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final HashMap<String, String> component3() {
        return this.params;
    }

    public final DesignElement copy(String str, String str2, HashMap<String, String> hashMap) {
        return new DesignElement(str, str2, hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DesignElement) {
            DesignElement designElement = (DesignElement) obj;
            return Intrinsics.areEqual(this.id, designElement.id) && Intrinsics.areEqual(this.type, designElement.type) && Intrinsics.areEqual(this.params, designElement.params);
        }
        return false;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "DesignElement(id=" + this.id + ", type=" + this.type + ", params=" + this.params + ')';
    }

    public DesignElement(String str, String str2, HashMap<String, String> hashMap) {
        this.id = str;
        this.type = str2;
        this.params = hashMap;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final HashMap<String, String> getParams() {
        return this.params;
    }

    public final void setParams(HashMap<String, String> hashMap) {
        this.params = hashMap;
    }
}
