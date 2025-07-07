package androidx.constraintlayout.core.parser;

import com.google.android.vending.expansion.downloader.Constants;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes2.dex */
public class CLElement implements Cloneable {
    protected static int sBaseIndent = 2;
    protected static int sMaxLine = 80;
    protected CLContainer mContainer;
    private final char[] mContent;
    private int mLine;
    protected long mStart = -1;
    protected long mEnd = Long.MAX_VALUE;

    public CLElement(char[] cArr) {
        this.mContent = cArr;
    }

    public boolean notStarted() {
        return this.mStart == -1;
    }

    public void setLine(int i) {
        this.mLine = i;
    }

    public int getLine() {
        return this.mLine;
    }

    public void setStart(long j) {
        this.mStart = j;
    }

    public long getStart() {
        return this.mStart;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public void setEnd(long j) {
        if (this.mEnd != Long.MAX_VALUE) {
            return;
        }
        this.mEnd = j;
        if (CLParser.sDebug) {
            System.out.println("closing " + hashCode() + " -> " + this);
        }
        CLContainer cLContainer = this.mContainer;
        if (cLContainer != null) {
            cLContainer.add(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addIndent(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
    }

    public String toString() {
        long j = this.mStart;
        long j2 = this.mEnd;
        if (j > j2 || j2 == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.mStart + Constants.FILENAME_SEQUENCE_SEPARATOR + this.mEnd + ")";
        }
        return getStrClass() + " (" + this.mStart + " : " + this.mEnd + ") <<" + new String(this.mContent).substring((int) this.mStart, ((int) this.mEnd) + 1) + ">>";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStrClass() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDebugName() {
        if (CLParser.sDebug) {
            return getStrClass() + " -> ";
        }
        return "";
    }

    public String content() {
        String str = new String(this.mContent);
        if (str.length() < 1) {
            return "";
        }
        long j = this.mEnd;
        if (j != Long.MAX_VALUE) {
            long j2 = this.mStart;
            if (j >= j2) {
                return str.substring((int) j2, ((int) j) + 1);
            }
        }
        long j3 = this.mStart;
        return str.substring((int) j3, ((int) j3) + 1);
    }

    public boolean hasContent() {
        char[] cArr = this.mContent;
        return cArr != null && cArr.length >= 1;
    }

    public boolean isDone() {
        return this.mEnd != Long.MAX_VALUE;
    }

    public void setContainer(CLContainer cLContainer) {
        this.mContainer = cLContainer;
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    public boolean isStarted() {
        return this.mStart > -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toJSON() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toFormattedJSON(int i, int i2) {
        return "";
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLElement) {
            CLElement cLElement = (CLElement) obj;
            if (this.mStart == cLElement.mStart && this.mEnd == cLElement.mEnd && this.mLine == cLElement.mLine && Arrays.equals(this.mContent, cLElement.mContent)) {
                return Objects.equals(this.mContainer, cLElement.mContainer);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j = this.mStart;
        long j2 = this.mEnd;
        int hashCode = ((((Arrays.hashCode(this.mContent) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        CLContainer cLContainer = this.mContainer;
        return ((hashCode + (cLContainer != null ? cLContainer.hashCode() : 0)) * 31) + this.mLine;
    }

    @Override // 
    /* renamed from: clone */
    public CLElement mo7166clone() {
        try {
            return (CLElement) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
