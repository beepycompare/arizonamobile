package androidx.constraintlayout.core.parser;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes2.dex */
public class CLToken extends CLElement {
    int mIndex;
    char[] mTokenFalse;
    char[] mTokenNull;
    char[] mTokenTrue;
    Type mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public boolean getBoolean() throws CLParsingException {
        if (this.mType == Type.TRUE) {
            return true;
        }
        if (this.mType == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.mIndex = 0;
        this.mType = Type.UNKNOWN;
        this.mTokenTrue = "true".toCharArray();
        this.mTokenFalse = "false".toCharArray();
        this.mTokenNull = AbstractJsonLexerKt.NULL.toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (CLParser.sDebug) {
            return "<" + content() + ">";
        }
        return content();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    public Type getType() {
        return this.mType;
    }

    public boolean validate(char c, long j) {
        int ordinal = this.mType.ordinal();
        if (ordinal == 0) {
            char[] cArr = this.mTokenTrue;
            int i = this.mIndex;
            if (cArr[i] == c) {
                this.mType = Type.TRUE;
            } else if (this.mTokenFalse[i] == c) {
                this.mType = Type.FALSE;
            } else if (this.mTokenNull[i] == c) {
                this.mType = Type.NULL;
            }
            r2 = true;
        } else if (ordinal == 1) {
            char[] cArr2 = this.mTokenTrue;
            int i2 = this.mIndex;
            r2 = cArr2[i2] == c;
            if (r2 && i2 + 1 == cArr2.length) {
                setEnd(j);
            }
        } else if (ordinal == 2) {
            char[] cArr3 = this.mTokenFalse;
            int i3 = this.mIndex;
            r2 = cArr3[i3] == c;
            if (r2 && i3 + 1 == cArr3.length) {
                setEnd(j);
            }
        } else if (ordinal == 3) {
            char[] cArr4 = this.mTokenNull;
            int i4 = this.mIndex;
            r2 = cArr4[i4] == c;
            if (r2 && i4 + 1 == cArr4.length) {
                setEnd(j);
            }
        }
        this.mIndex++;
        return r2;
    }
}
