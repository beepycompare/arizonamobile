package androidx.media3.extractor.metadata.id3;

import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final String ID = "CTOC";
    public final String[] children;
    public final String elementId;
    public final boolean isOrdered;
    public final boolean isRoot;
    private final Id3Frame[] subFrames;

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super(ID);
        this.elementId = str;
        this.isRoot = z;
        this.isOrdered = z2;
        this.children = strArr;
        this.subFrames = id3FrameArr;
    }

    public int getSubFrameCount() {
        return this.subFrames.length;
    }

    public Id3Frame getSubFrame(int i) {
        return this.subFrames[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            if (this.isRoot == chapterTocFrame.isRoot && this.isOrdered == chapterTocFrame.isOrdered && Objects.equals(this.elementId, chapterTocFrame.elementId) && Arrays.equals(this.children, chapterTocFrame.children) && Arrays.equals(this.subFrames, chapterTocFrame.subFrames)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (((527 + (this.isRoot ? 1 : 0)) * 31) + (this.isOrdered ? 1 : 0)) * 31;
        String str = this.elementId;
        return i + (str != null ? str.hashCode() : 0);
    }
}
