package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.composer.GroupSourceInformation;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LinkGroupSourceInformation.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'J\u0018\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020'J\u000e\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003J\b\u0010,\u001a\u00020\u0000H\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010/\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nRF\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00132\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/LinkGroupSourceInformation;", "Landroidx/compose/runtime/composer/GroupSourceInformation;", "key", "", "sourceInformation", "", "dataStartOffset", "<init>", "(ILjava/lang/String;I)V", "getKey", "()I", "getSourceInformation", "()Ljava/lang/String;", "setSourceInformation", "(Ljava/lang/String;)V", "getDataStartOffset", "value", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "groups", "getGroups", "()Ljava/util/ArrayList;", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "dataEndOffset", "getDataEndOffset", "setDataEndOffset", "(I)V", "startGrouplessCall", "", "dataOffset", "endGrouplessCall", "reportGroup", "anchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "addGroupAfter", "predecessor", "group", "close", "openInformation", "add", "hasGroup", "removeGroup", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LinkGroupSourceInformation implements GroupSourceInformation {
    public static final int $stable = 8;
    private boolean closed;
    private int dataEndOffset;
    private final int dataStartOffset;
    private ArrayList<Object> groups;
    private final int key;
    private String sourceInformation;

    public LinkGroupSourceInformation(int i, String str, int i2) {
        this.key = i;
        this.sourceInformation = str;
        this.dataStartOffset = i2;
    }

    @Override // androidx.compose.runtime.composer.GroupSourceInformation
    public int getKey() {
        return this.key;
    }

    @Override // androidx.compose.runtime.composer.GroupSourceInformation
    public String getSourceInformation() {
        return this.sourceInformation;
    }

    public void setSourceInformation(String str) {
        this.sourceInformation = str;
    }

    @Override // androidx.compose.runtime.composer.GroupSourceInformation
    public int getDataStartOffset() {
        return this.dataStartOffset;
    }

    @Override // androidx.compose.runtime.composer.GroupSourceInformation
    public ArrayList<Object> getGroups() {
        return this.groups;
    }

    @Override // androidx.compose.runtime.composer.GroupSourceInformation
    public boolean getClosed() {
        return this.closed;
    }

    public void setClosed(boolean z) {
        this.closed = z;
    }

    @Override // androidx.compose.runtime.composer.GroupSourceInformation
    public int getDataEndOffset() {
        return this.dataEndOffset;
    }

    public void setDataEndOffset(int i) {
        this.dataEndOffset = i;
    }

    public final void startGrouplessCall(int i, String str, int i2) {
        openInformation().add(new LinkGroupSourceInformation(i, str, i2));
    }

    public final void endGrouplessCall(int i) {
        openInformation().close(i);
    }

    public final void reportGroup(LinkAnchor linkAnchor) {
        openInformation().add(linkAnchor);
    }

    public final void addGroupAfter(LinkAnchor linkAnchor, LinkAnchor linkAnchor2) {
        ArrayList<Object> groups = getGroups();
        if (groups == null) {
            groups = new ArrayList<>();
            this.groups = groups;
        }
        int i = 0;
        if (linkAnchor != null) {
            int size = groups.size();
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                }
                Object obj = groups.get(i);
                if (Intrinsics.areEqual(obj, linkAnchor) || ((obj instanceof LinkGroupSourceInformation) && ((LinkGroupSourceInformation) obj).hasGroup(linkAnchor))) {
                    break;
                }
                i++;
            }
        }
        groups.add(i, linkAnchor2);
    }

    public final void close(int i) {
        setClosed(true);
        setDataEndOffset(i);
    }

    private final LinkGroupSourceInformation openInformation() {
        LinkGroupSourceInformation openInformation;
        ArrayList<Object> groups = getGroups();
        LinkGroupSourceInformation linkGroupSourceInformation = null;
        if (groups != null) {
            int size = groups.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Object obj = groups.get(size);
                if ((obj instanceof LinkGroupSourceInformation) && !((LinkGroupSourceInformation) obj).getClosed()) {
                    linkGroupSourceInformation = obj;
                    break;
                }
                size--;
            }
        }
        LinkGroupSourceInformation linkGroupSourceInformation2 = linkGroupSourceInformation;
        return (linkGroupSourceInformation2 == null || (openInformation = linkGroupSourceInformation2.openInformation()) == null) ? this : openInformation;
    }

    private final void add(Object obj) {
        ArrayList<Object> groups = getGroups();
        if (groups == null) {
            groups = new ArrayList<>();
            this.groups = groups;
        }
        groups.add(obj);
    }

    private final boolean hasGroup(LinkAnchor linkAnchor) {
        ArrayList<Object> groups = getGroups();
        if (groups != null) {
            ArrayList<Object> arrayList = groups;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = arrayList.get(i);
                if (Intrinsics.areEqual(obj, linkAnchor)) {
                    return true;
                }
                if ((obj instanceof LinkGroupSourceInformation) && ((LinkGroupSourceInformation) obj).hasGroup(linkAnchor)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean removeGroup(LinkAnchor linkAnchor) {
        ArrayList<Object> groups = getGroups();
        if (groups != null) {
            for (int size = groups.size() - 1; size >= 0; size--) {
                Object obj = groups.get(size);
                if (obj instanceof LinkAnchor) {
                    if (Intrinsics.areEqual(obj, linkAnchor)) {
                        groups.remove(size);
                    }
                } else if ((obj instanceof LinkGroupSourceInformation) && !((LinkGroupSourceInformation) obj).removeGroup(linkAnchor)) {
                    groups.remove(size);
                }
            }
            if (groups.isEmpty()) {
                this.groups = null;
                return false;
            }
        }
        return true;
    }
}
