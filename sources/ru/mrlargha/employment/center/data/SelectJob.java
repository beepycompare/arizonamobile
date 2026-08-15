package ru.mrlargha.employment.center.data;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: ServerData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/employment/center/data/SelectJob;", "", "type", "", TtmlNode.ATTR_ID, "<init>", "(II)V", "getType", "()I", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "employment-center"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectJob {
    private final int id;
    private final int type;

    public static /* synthetic */ SelectJob copy$default(SelectJob selectJob, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = selectJob.type;
        }
        if ((i3 & 2) != 0) {
            i2 = selectJob.id;
        }
        return selectJob.copy(i, i2);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.id;
    }

    public final SelectJob copy(int i, int i2) {
        return new SelectJob(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectJob) {
            SelectJob selectJob = (SelectJob) obj;
            return this.type == selectJob.type && this.id == selectJob.id;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.type) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        int i = this.type;
        return "SelectJob(type=" + i + ", id=" + this.id + ")";
    }

    public SelectJob(int i, int i2) {
        this.type = i;
        this.id = i2;
    }

    public final int getType() {
        return this.type;
    }

    public final int getId() {
        return this.id;
    }
}
